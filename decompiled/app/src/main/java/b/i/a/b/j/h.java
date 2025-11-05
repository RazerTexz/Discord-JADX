package b.i.a.b.j;

import java.util.concurrent.Executor;

/* compiled from: SafeLoggingExecutor.java */
/* loaded from: classes3.dex */
public class h implements Executor {
    public final Executor j;

    /* compiled from: SafeLoggingExecutor.java */
    public static class a implements Runnable {
        public final Runnable j;

        public a(Runnable runnable) {
            this.j = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.j.run();
            } catch (Exception e) {
                b.c.a.a0.d.c0("Executor", "Background execution failure.", e);
            }
        }
    }

    public h(Executor executor) {
        this.j = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.j.execute(new a(runnable));
    }
}
