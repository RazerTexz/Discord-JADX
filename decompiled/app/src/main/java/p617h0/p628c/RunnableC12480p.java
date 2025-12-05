package p617h0.p628c;

import org.webrtc.JniCommon;

/* compiled from: lambda */
/* renamed from: h0.c.p */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12480p implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ long f26455j;

    public /* synthetic */ RunnableC12480p(long j) {
        this.f26455j = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JniCommon.nativeReleaseRef(this.f26455j);
    }
}
