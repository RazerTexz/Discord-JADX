package b.f.d.b;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ConstrainedExecutorService.java */
/* loaded from: classes.dex */
public class b extends AbstractExecutorService {
    public static final Class<?> j = b.class;
    public final String k;
    public final Executor l;
    public volatile int m;
    public final BlockingQueue<Runnable> n;
    public final RunnableC0066b o;
    public final AtomicInteger p;
    public final AtomicInteger q;

    /* compiled from: ConstrainedExecutorService.java */
    /* renamed from: b.f.d.b.b$b, reason: collision with other inner class name */
    public class RunnableC0066b implements Runnable {
        public RunnableC0066b(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnablePoll = b.this.n.poll();
                if (runnablePoll != null) {
                    runnablePoll.run();
                } else {
                    Class<?> cls = b.j;
                    Class<?> cls2 = b.j;
                    String str = b.this.k;
                    int i = b.f.d.e.a.a;
                }
                b.this.p.decrementAndGet();
                if (!b.this.n.isEmpty()) {
                    b.this.a();
                    return;
                }
                Class<?> cls3 = b.j;
                Class<?> cls4 = b.j;
                String str2 = b.this.k;
                int i2 = b.f.d.e.a.a;
            } catch (Throwable th) {
                b.this.p.decrementAndGet();
                if (b.this.n.isEmpty()) {
                    Class<?> cls5 = b.j;
                    Class<?> cls6 = b.j;
                    String str3 = b.this.k;
                    int i3 = b.f.d.e.a.a;
                } else {
                    b.this.a();
                }
                throw th;
            }
        }
    }

    public b(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.k = str;
        this.l = executor;
        this.m = i;
        this.n = blockingQueue;
        this.o = new RunnableC0066b(null);
        this.p = new AtomicInteger(0);
        this.q = new AtomicInteger(0);
    }

    public final void a() {
        int i = this.p.get();
        while (i < this.m) {
            int i2 = i + 1;
            if (this.p.compareAndSet(i, i2)) {
                b.f.d.e.a.j(j, "%s: starting worker %d of %d", this.k, Integer.valueOf(i2), Integer.valueOf(this.m));
                this.l.execute(this.o);
                return;
            } else {
                int i3 = b.f.d.e.a.a;
                i = this.p.get();
            }
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j2, TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Objects.requireNonNull(runnable, "runnable parameter is null");
        if (!this.n.offer(runnable)) {
            throw new RejectedExecutionException(this.k + " queue is full, size=" + this.n.size());
        }
        int size = this.n.size();
        int i = this.q.get();
        if (size > i && this.q.compareAndSet(i, size)) {
            int i2 = b.f.d.e.a.a;
        }
        a();
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
