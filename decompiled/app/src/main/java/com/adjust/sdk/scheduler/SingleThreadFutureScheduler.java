package com.adjust.sdk.scheduler;

import com.adjust.sdk.AdjustFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class SingleThreadFutureScheduler implements FutureScheduler {
    private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

    /* renamed from: com.adjust.sdk.scheduler.SingleThreadFutureScheduler$1 */
    public class RejectedExecutionHandlerC54011 implements RejectedExecutionHandler {
        public final /* synthetic */ String val$source;

        public RejectedExecutionHandlerC54011(String str) {
            this.val$source = str;
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            AdjustFactory.getLogger().warn("Runnable [%s] rejected from [%s] ", runnable.toString(), this.val$source);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V] */
    /* renamed from: com.adjust.sdk.scheduler.SingleThreadFutureScheduler$2 */
    public class CallableC54022<V> implements Callable<V> {
        public final /* synthetic */ Callable val$callable;

        public CallableC54022(Callable callable) {
            this.val$callable = callable;
        }

        @Override // java.util.concurrent.Callable
        public V call() {
            try {
                return (V) this.val$callable.call();
            } catch (Throwable th) {
                AdjustFactory.getLogger().error("Callable error [%s] of type [%s]", th.getMessage(), th.getClass().getCanonicalName());
                return null;
            }
        }
    }

    public SingleThreadFutureScheduler(String str, boolean z2) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactoryWrapper(str), new RejectedExecutionHandlerC54011(str));
        this.scheduledThreadPoolExecutor = scheduledThreadPoolExecutor;
        if (z2) {
            return;
        }
        scheduledThreadPoolExecutor.setKeepAliveTime(10L, TimeUnit.MILLISECONDS);
        this.scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    @Override // com.adjust.sdk.scheduler.FutureScheduler
    public ScheduledFuture<?> scheduleFuture(Runnable runnable, long j) {
        return this.scheduledThreadPoolExecutor.schedule(new RunnableWrapper(runnable), j, TimeUnit.MILLISECONDS);
    }

    @Override // com.adjust.sdk.scheduler.FutureScheduler
    public ScheduledFuture<?> scheduleFutureWithFixedDelay(Runnable runnable, long j, long j2) {
        return this.scheduledThreadPoolExecutor.scheduleWithFixedDelay(new RunnableWrapper(runnable), j, j2, TimeUnit.MILLISECONDS);
    }

    @Override // com.adjust.sdk.scheduler.FutureScheduler
    public <V> ScheduledFuture<V> scheduleFutureWithReturn(Callable<V> callable, long j) {
        return this.scheduledThreadPoolExecutor.schedule(new CallableC54022(callable), j, TimeUnit.MILLISECONDS);
    }

    @Override // com.adjust.sdk.scheduler.FutureScheduler
    public void teardown() {
        this.scheduledThreadPoolExecutor.shutdownNow();
    }
}
