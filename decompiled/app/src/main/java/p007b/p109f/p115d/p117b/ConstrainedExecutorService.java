package p007b.p109f.p115d.p117b;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p007b.p109f.p115d.p120e.FLog;

/* compiled from: ConstrainedExecutorService.java */
/* renamed from: b.f.d.b.b, reason: use source file name */
/* loaded from: classes.dex */
public class ConstrainedExecutorService extends AbstractExecutorService {

    /* renamed from: j */
    public static final Class<?> f3079j = ConstrainedExecutorService.class;

    /* renamed from: k */
    public final String f3080k;

    /* renamed from: l */
    public final Executor f3081l;

    /* renamed from: m */
    public volatile int f3082m;

    /* renamed from: n */
    public final BlockingQueue<Runnable> f3083n;

    /* renamed from: o */
    public final b f3084o;

    /* renamed from: p */
    public final AtomicInteger f3085p;

    /* renamed from: q */
    public final AtomicInteger f3086q;

    /* compiled from: ConstrainedExecutorService.java */
    /* renamed from: b.f.d.b.b$b */
    public class b implements Runnable {
        public b(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnablePoll = ConstrainedExecutorService.this.f3083n.poll();
                if (runnablePoll != null) {
                    runnablePoll.run();
                } else {
                    Class<?> cls = ConstrainedExecutorService.f3079j;
                    Class<?> cls2 = ConstrainedExecutorService.f3079j;
                    String str = ConstrainedExecutorService.this.f3080k;
                    int i = FLog.f3102a;
                }
                ConstrainedExecutorService.this.f3085p.decrementAndGet();
                if (!ConstrainedExecutorService.this.f3083n.isEmpty()) {
                    ConstrainedExecutorService.this.m964a();
                    return;
                }
                Class<?> cls3 = ConstrainedExecutorService.f3079j;
                Class<?> cls4 = ConstrainedExecutorService.f3079j;
                String str2 = ConstrainedExecutorService.this.f3080k;
                int i2 = FLog.f3102a;
            } catch (Throwable th) {
                ConstrainedExecutorService.this.f3085p.decrementAndGet();
                if (ConstrainedExecutorService.this.f3083n.isEmpty()) {
                    Class<?> cls5 = ConstrainedExecutorService.f3079j;
                    Class<?> cls6 = ConstrainedExecutorService.f3079j;
                    String str3 = ConstrainedExecutorService.this.f3080k;
                    int i3 = FLog.f3102a;
                } else {
                    ConstrainedExecutorService.this.m964a();
                }
                throw th;
            }
        }
    }

    public ConstrainedExecutorService(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.f3080k = str;
        this.f3081l = executor;
        this.f3082m = i;
        this.f3083n = blockingQueue;
        this.f3084o = new b(null);
        this.f3085p = new AtomicInteger(0);
        this.f3086q = new AtomicInteger(0);
    }

    /* renamed from: a */
    public final void m964a() {
        int i = this.f3085p.get();
        while (i < this.f3082m) {
            int i2 = i + 1;
            if (this.f3085p.compareAndSet(i, i2)) {
                FLog.m982j(f3079j, "%s: starting worker %d of %d", this.f3080k, Integer.valueOf(i2), Integer.valueOf(this.f3082m));
                this.f3081l.execute(this.f3084o);
                return;
            } else {
                int i3 = FLog.f3102a;
                i = this.f3085p.get();
            }
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Objects.requireNonNull(runnable, "runnable parameter is null");
        if (!this.f3083n.offer(runnable)) {
            throw new RejectedExecutionException(this.f3080k + " queue is full, size=" + this.f3083n.size());
        }
        int size = this.f3083n.size();
        int i = this.f3086q.get();
        if (size > i && this.f3086q.compareAndSet(i, size)) {
            int i2 = FLog.f3102a;
        }
        m964a();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }
}
