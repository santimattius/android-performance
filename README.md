# Android Performance

[![codecov](https://codecov.io/gh/santimattius/android-arch-template/branch/master/graph/badge.svg?token=7ITWBL56NJ)](https://codecov.io/gh/santimattius/android-arch-template) [![codecov](https://www.travis-ci.com/santimattius/android-arch-template.svg?token=P7xvicFZMo2reEHHNuJS&branch=master)](https://www.travis-ci.com/santimattius/android-arch-template)

Profile your app performance

An app is considered to have poor performance if it responds slowly, shows choppy animations, freezes, or consumes too much power. Fixing performance problems involves identifying areas in which your app makes inefficient use of resources such as the CPU, memory, graphics, network, or the device battery.

To find and fix these problems, use the profiling and benchmarking tools and techniques described in this topic. To learn techniques for measuring performance and examples of how to use these techniques to resolve specific problems, see Measuring performance.

## Microbenchmark

The Microbenchmark library lets you benchmark app code directly in a loop. This is designed for measuring CPU work that assesses best-case performance (warmed up Just in Time (JIT), disk accesses cached), that you might see with an inner-loop or a specific hot function. ​​The library can only measure the code you can call directly in isolation.

If your app needs to process a complex data structure, or have some specific computation-heavy algorithm that is called multiple times during the application run, these may be good examples for benchmarking. You can also measure parts of your UI. For example, you can measure the cost of the RecyclerView item binding, how long it takes to inflate a layout, or how demanding the layout-and-measure pass of your View class is from a performance perspective.

However, you won’t be able to measure how the benchmarked cases contribute to the overall user experience. In some scenarios, benchmarking won’t tell you if you’re improving a bottleneck like jank or application startup time. For that reason, it’s crucial to identify those bottlenecks first with the Android Profiler. After you have found the code you want to investigate and optimize, the benchmarked loop can run repeatedly, in a quick and easy fashion to create less noisy results, which lets you focus on one area of improvement.

The Microbenchmark library only reports information about your application, not about the system overall. Therefore, it’s best at analyzing performance of situations specific to the app, not ones that might relate to overall system issues.

- See more -> [Here](https://developer.android.com/studio/profile/microbenchmark-overview)
- **Example** -> [Here](https://github.com/santimattius/android-performance/blob/master/microbenchmark/src/androidTest/java/com/santimattius/microbenchmark/PictureListBenchmark.kt)

## Macrobenchmark

The Macrobenchmark library measures larger end-user interactions, such as startup, interacting with the UI, and animations. Unlike the Microbenchmark library, Macrobenchmark provides direct control over the performance environment you're testing. It allows you to control compiling, starting and stopping your application to directly measure actual app startup or scrolling, instead of only the specific jitted, hot functions, with all disk accesses cached.

The library injects events and monitors results externally from a test application that is built with your tests. Therefore, when writing the benchmarks, you don’t call your application code directly and instead navigate within your application as a user would.

- See more -> [Here](https://developer.android.com/studio/profile/macrobenchmark-overview)
- **Example** -> [Here](https://github.com/santimattius/android-performance/blob/master/macrobenchmark/src/main/java/com/santimattius/macrobenchmark/StartupBenchmark.kt)
