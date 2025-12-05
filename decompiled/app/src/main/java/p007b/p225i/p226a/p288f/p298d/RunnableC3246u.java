package p007b.p225i.p226a.p288f.p298d;

import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* renamed from: b.i.a.f.d.u */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC3246u implements Runnable {

    /* renamed from: j */
    public final TaskCompletionSource f9287j;

    public RunnableC3246u(TaskCompletionSource taskCompletionSource) {
        this.f9287j = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f9287j.m9125a(new IOException("TIMEOUT"))) {
            Log.w("Rpc", "No response");
        }
    }
}
