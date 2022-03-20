package com.santimattius.microbenchmark

import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.annotation.UiThreadTest
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.santimattius.feature.presentation.activities.MainActivity
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Benchmark, which will execute on an Android device.
 *
 * The body of [BenchmarkRule.measureRepeated] is measured in a loop, and Studio will
 * output the result. Modify your code to see how it affects performance.
 * run: ./gradlew :microbenchmark:connectedReleaseAndroidTest
 */
@LargeTest
@RunWith(AndroidJUnit4::class)
class PictureListBenchmark {

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setup() {
        activityRule.scenario.onActivity { activity ->
            activity.fragment.recyclerView.layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, 1)
            activity.fragment.adapter.submitList(null)
            activity.fragment.adapter.submitList(LazyComputedList {
                stubUiPicture("Author $it")
            })
        }
    }

    @Test
    fun stubUiPicture() {
        benchmarkRule.measureRepeated {
            // measure cost of generating paragraph - this is overhead in the primary scroll()
            // benchmark, but is a very small fraction of the amount of work there.
            stubUiPicture("Author Test")
        }
    }

    @UiThreadTest
    @Test
    fun scroll() {
        activityRule.scenario.onActivity { activity ->
            val recyclerView = activity.fragment.recyclerView

            assertTrue("RecyclerView expected to have children", recyclerView.childCount > 0)
            assertEquals("RecyclerView must have height = 1", 1, recyclerView.height)

            // RecyclerView has children, its items are attached, bound, and have gone through layout.
            // Ready to benchmark!
            benchmarkRule.measureRepeated {
                recyclerView.scrollBy(0, recyclerView.getLastChild().height)
            }
        }
    }

    class LazyComputedList<T>(
        override val size: Int = Int.MAX_VALUE,
        private inline val compute: (Int) -> T,
    ) : AbstractList<T>() {
        override fun get(index: Int): T = compute(index)
    }
}

private fun ViewGroup.getLastChild(): View = getChildAt(childCount - 1)
