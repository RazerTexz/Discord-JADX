package p007b.p109f.p115d.p117b;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: b.f.d.b.g, reason: use source file name */
/* JADX INFO: compiled from: UiThreadImmediateExecutorService.java */
/* JADX INFO: loaded from: classes.dex */
public class UiThreadImmediateExecutorService extends HandlerExecutorServiceImpl {

    /* JADX INFO: renamed from: k */
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
