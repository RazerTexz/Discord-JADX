package p617h0.p628c;

import android.os.Looper;
import org.webrtc.EglRenderer;

/* compiled from: lambda */
/* renamed from: h0.c.k */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12470k implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ EglRenderer f26443j;

    /* renamed from: k */
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
