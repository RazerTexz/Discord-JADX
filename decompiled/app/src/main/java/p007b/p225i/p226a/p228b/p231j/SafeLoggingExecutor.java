package p007b.p225i.p226a.p228b.p231j;

import java.util.concurrent.Executor;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: SafeLoggingExecutor.java */
/* renamed from: b.i.a.b.j.h, reason: use source file name */
/* loaded from: classes3.dex */
public class SafeLoggingExecutor implements Executor {

    /* renamed from: j */
    public final Executor f5279j;

    /* compiled from: SafeLoggingExecutor.java */
    /* renamed from: b.i.a.b.j.h$a */
    public static class a implements Runnable {

        /* renamed from: j */
        public final Runnable f5280j;

        public a(Runnable runnable) {
            this.f5280j = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f5280j.run();
            } catch (Exception e) {
                AnimatableValueParser.m504c0("Executor", "Background execution failure.", e);
            }
        }
    }

    public SafeLoggingExecutor(Executor executor) {
        this.f5279j = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f5279j.execute(new a(runnable));
    }
}
