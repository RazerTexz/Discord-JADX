package p617h0.p628c;

import org.webrtc.Camera1Session;

/* JADX INFO: renamed from: h0.c.a */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12450a implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Camera1Session.C129462 f26406j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ byte[] f26407k;

    public /* synthetic */ RunnableC12450a(Camera1Session.C129462 c129462, byte[] bArr) {
        this.f26406j = c129462;
        this.f26407k = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Camera1Session.C129462 c129462 = this.f26406j;
        byte[] bArr = this.f26407k;
        if (Camera1Session.access$400(Camera1Session.this) == Camera1Session.SessionState.RUNNING) {
            Camera1Session.access$300(Camera1Session.this).addCallbackBuffer(bArr);
        }
    }
}
