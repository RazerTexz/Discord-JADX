package p007b.p109f.p115d.p117b;

import android.os.Handler;
import android.os.Looper;

/* compiled from: UiThreadImmediateExecutorService.java */
/* renamed from: b.f.d.b.g, reason: use source file name */
/* loaded from: classes.dex */
public class UiThreadImmediateExecutorService extends HandlerExecutorServiceImpl {

    /* renamed from: k */
    public static UiThreadImmediateExecutorService f3090k;

    public UiThreadImmediateExecutorService() {
        super(new Handler(Looper.getMainLooper()));
    }

    @Override // p007b.p109f.p115d.p117b.HandlerExecutorServiceImpl, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (Thread.currentThread() == this.f3088j.getLooper().getThread()) {
            runnable.run();
        } else {
            this.f3088j.post(runnable);
        }
    }
}
