package p007b.p225i.p361c.p369m.p370d.p373k;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ExecutorUtils.java */
/* renamed from: b.i.c.m.d.k.s0, reason: use source file name */
/* loaded from: classes3.dex */
public class ExecutorUtils implements ThreadFactory {

    /* renamed from: j */
    public final /* synthetic */ String f12387j;

    /* renamed from: k */
    public final /* synthetic */ AtomicLong f12388k;

    /* compiled from: ExecutorUtils.java */
    /* renamed from: b.i.c.m.d.k.s0$a */
    public class a extends BackgroundPriorityRunnable {

        /* renamed from: j */
        public final /* synthetic */ Runnable f12389j;

        public a(ExecutorUtils executorUtils, Runnable runnable) {
            this.f12389j = runnable;
        }

        @Override // p007b.p225i.p361c.p369m.p370d.p373k.BackgroundPriorityRunnable
        /* renamed from: a */
        public void mo6398a() {
            this.f12389j.run();
        }
    }

    public ExecutorUtils(String str, AtomicLong atomicLong) {
        this.f12387j = str;
        this.f12388k = atomicLong;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadNewThread = Executors.defaultThreadFactory().newThread(new a(this, runnable));
        threadNewThread.setName(this.f12387j + this.f12388k.getAndIncrement());
        return threadNewThread;
    }
}
