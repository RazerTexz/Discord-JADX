package p617h0.p628c;

import org.webrtc.Camera1Session;

/* compiled from: lambda */
/* renamed from: h0.c.b */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12452b implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ Camera1Session.C129462 f26409j;

    /* renamed from: k */
    public final /* synthetic */ byte[] f26410k;

    public /* synthetic */ RunnableC12452b(Camera1Session.C129462 c129462, byte[] bArr) {
        this.f26409j = c129462;
        this.f26410k = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Camera1Session.C129462 c129462 = this.f26409j;
        Camera1Session.access$1000(Camera1Session.this).post(new RunnableC12450a(c129462, this.f26410k));
    }
}
