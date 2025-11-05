package b.i.c.m.d.k;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ExecutorUtils.java */
/* loaded from: classes3.dex */
public class s0 implements ThreadFactory {
    public final /* synthetic */ String j;
    public final /* synthetic */ AtomicLong k;

    /* compiled from: ExecutorUtils.java */
    public class a extends d {
        public final /* synthetic */ Runnable j;

        public a(s0 s0Var, Runnable runnable) {
            this.j = runnable;
        }

        @Override // b.i.c.m.d.k.d
        public void a() {
            this.j.run();
        }
    }

    public s0(String str, AtomicLong atomicLong) {
        this.j = str;
        this.k = atomicLong;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = Executors.defaultThreadFactory().newThread(new a(this, runnable));
        threadNewThread.setName(this.j + this.k.getAndIncrement());
        return threadNewThread;
    }
}
