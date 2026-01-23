package p617h0.p628c;

import org.webrtc.EglRenderer;

/* JADX INFO: renamed from: h0.c.f */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12460f implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ EglRenderer f26420j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ float f26421k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ float f26422l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ float f26423m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ float f26424n;

    public /* synthetic */ RunnableC12460f(EglRenderer eglRenderer, float f, float f2, float f3, float f4) {
        this.f26420j = eglRenderer;
        this.f26421k = f;
        this.f26422l = f2;
        this.f26423m = f3;
        this.f26424n = f4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26420j.m11019b(this.f26421k, this.f26422l, this.f26423m, this.f26424n);
    }
}
