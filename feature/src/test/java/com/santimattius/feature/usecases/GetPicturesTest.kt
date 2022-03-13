package com.santimattius.feature.usecases

import com.santimattius.feature.domain.repositories.PicturesRepository
import com.santimattius.feature.domain.usecases.GetPictures
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Test

@ExperimentalCoroutinesApi
class GetPicturesTest {

    private val repository: PicturesRepository = mockk()
    private val useCase: GetPictures = GetPictures(repository)

    @Test
    fun `invoke get picture use case`() = runBlockingTest {
        //Given
        coEvery { repository.getPictures() } returns emptyList()
        //When
        val result = useCase.invoke()
        //Then
        assertThat(result, IsEqual(emptyList()))
        coVerify { repository.getPictures() }
    }
}