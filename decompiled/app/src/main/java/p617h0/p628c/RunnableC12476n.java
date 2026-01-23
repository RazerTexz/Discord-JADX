package p617h0.p628c;

import org.webrtc.HardwareVideoEncoder;

/* JADX INFO: renamed from: h0.c.n */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12476n implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ HardwareVideoEncoder f26452j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ int f26453k;

    public /* synthetic */ RunnableC12476n(HardwareVideoEncoder hardwareVideoEncoder, int i) {
        this.f26452j = hardwareVideoEncoder;
        this.f26453k = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26452j.m11026a(this.f26453k);
    }
}
