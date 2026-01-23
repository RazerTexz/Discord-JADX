package p617h0.p628c;

import android.os.Looper;
import org.webrtc.EglRenderer;

/* JADX INFO: renamed from: h0.c.k */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12470k implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ EglRenderer f26443j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Looper f26444k;

    public /* synthetic */ RunnableC12470k(EglRenderer eglRenderer, Looper looper) {
        this.f26443j = eglRenderer;
        this.f26444k = looper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26443j.m11022f(this.f26444k);
    }
}
