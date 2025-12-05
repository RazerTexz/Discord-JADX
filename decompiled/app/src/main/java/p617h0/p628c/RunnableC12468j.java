package p617h0.p628c;

import org.webrtc.EglBase;
import org.webrtc.EglRenderer;

/* compiled from: lambda */
/* renamed from: h0.c.j */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12468j implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ EglRenderer f26439j;

    /* renamed from: k */
    public final /* synthetic */ EglBase.Context f26440k;

    /* renamed from: l */
    public final /* synthetic */ int[] f26441l;

    public /* synthetic */ RunnableC12468j(EglRenderer eglRenderer, EglBase.Context context, int[] iArr) {
        this.f26439j = eglRenderer;
        this.f26440k = context;
        this.f26441l = iArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26439j.m11020d(this.f26440k, this.f26441l);
    }
}
