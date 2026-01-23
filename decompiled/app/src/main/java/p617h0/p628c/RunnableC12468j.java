package p617h0.p628c;

import org.webrtc.EglBase;
import org.webrtc.EglRenderer;

/* JADX INFO: renamed from: h0.c.j */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12468j implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ EglRenderer f26439j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ EglBase.Context f26440k;

    /* JADX INFO: renamed from: l */
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
