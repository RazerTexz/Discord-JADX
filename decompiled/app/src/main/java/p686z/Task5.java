package p686z;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

/* compiled from: Task.java */
/* renamed from: z.f, reason: use source file name */
/* loaded from: classes.dex */
public final class Task5 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ TaskCompletionSource2 f27975j;

    /* renamed from: k */
    public final /* synthetic */ Callable f27976k;

    public Task5(TaskCompletionSource2 taskCompletionSource2, Callable callable) {
        this.f27975j = taskCompletionSource2;
        this.f27976k = callable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f27975j.m11376c(this.f27976k.call());
        } catch (CancellationException unused) {
            this.f27975j.m11374a();
        } catch (Exception e) {
            this.f27975j.m11375b(e);
        }
    }
}
