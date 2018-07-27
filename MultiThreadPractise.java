public static ThreadPoolExecutor catchThreadPool(int size){
    int poolSize = size;
    if(poolSize > 10){
        poolSize = 10;
    }
    //ThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue)
    return new ThreadPollExecutor(poolSize, poolSize, 5000, TimeUnit.MILLISECONDS,
        new LinkBlockingQueue<Runnable>());
}

