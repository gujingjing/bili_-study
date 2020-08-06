###协程入门使用

####协程挂起有三点需要注意的：	
- 启动其他协程并不会挂起当前协程，所以launch和async启动线程时，除非新协程运行在当前线程，则当前协程只能在新协程运行完成后继续执行，否则当前协程都会马上继续运行。
- 协程挂起并不会阻塞线程，因为协程挂起时相当于执行完协程的方法，线程继续执行其他之后的逻辑。
- 挂起函数并一定都会挂起协程，例如await()挂起函数如果返回值不等于IntrinsicsKt.getCOROUTINE_SUSPENDED()，则协程继续执行挂起点之后逻辑



###参考
- [深入理解协程的挂起、恢复与调度](https://johnnyshieh.me/posts/kotlin-coroutine-deep-diving/)
- [协程的挂起](https://kaixue.io/kotlin-coroutines-2/)
- [Kotlin中文网-协程](https://www.kotlincn.net/docs/reference/coroutines/coroutines-guide.html)



