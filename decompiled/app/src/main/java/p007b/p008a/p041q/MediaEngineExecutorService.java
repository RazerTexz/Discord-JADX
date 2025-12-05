package p007b.p008a.p041q;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: MediaEngineExecutorService.kt */
/* renamed from: b.a.q.c, reason: use source file name */
/* loaded from: classes.dex */
public final class MediaEngineExecutorService implements ExecutorService {

    /* renamed from: j */
    public static final AtomicInteger f1607j = new AtomicInteger();

    /* renamed from: k */
    public volatile int f1608k;

    /* renamed from: l */
    public final ExecutorService f1609l;

    /* renamed from: m */
    public final boolean f1610m;

    /* compiled from: MediaEngineExecutorService.kt */
    /* renamed from: b.a.q.c$a */
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MediaEngineExecutorService.this.f1608k = Process.myTid();
            Thread threadCurrentThread = Thread.currentThread();
            Intrinsics3.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
            threadCurrentThread.setName("MediaEngineExecutor-" + MediaEngineExecutorService.f1607j.getAndIncrement());
        }
    }

    public MediaEngineExecutorService(ExecutorService executorService, boolean z2) {
        Intrinsics3.checkNotNullParameter(executorService, "es");
        this.f1609l = executorService;
        this.f1610m = z2;
        this.f1608k = -1;
        executorService.submit(new a());
    }

    /* renamed from: a */
    public final void m266a() {
        if (Process.myTid() != this.f1608k) {
            IllegalStateException illegalStateException = new IllegalStateException("oops! not called on the MediaEngineExecutor");
            AnimatableValueParser.m505c1("MediaEngineExecutor", "oops! not called on the MediaEngineExecutor", illegalStateException);
            if (this.f1610m) {
                new Handler(Looper.getMainLooper()).post(new MediaEngineExecutorService2(illegalStateException));
            }
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.f1609l.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f1609l.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.f1609l.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return this.f1609l.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return (T) this.f1609l.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) {
        return (T) this.f1609l.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f1609l.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f1609l.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f1609l.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.f1609l.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.f1609l.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.f1609l.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.f1609l.submit(callable);
    }
}
