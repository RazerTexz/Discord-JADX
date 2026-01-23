package p617h0.p628c;

import java.util.Objects;
import org.webrtc.TextureBufferImpl;

/* JADX INFO: renamed from: h0.c.z */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12496z implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ TextureBufferImpl f26472j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ TextureBufferImpl.RefCountMonitor f26473k;

    public /* synthetic */ RunnableC12496z(TextureBufferImpl textureBufferImpl, TextureBufferImpl.RefCountMonitor refCountMonitor) {
        this.f26472j = textureBufferImpl;
        this.f26473k = refCountMonitor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextureBufferImpl textureBufferImpl = this.f26472j;
        TextureBufferImpl.RefCountMonitor refCountMonitor = this.f26473k;
        Objects.requireNonNull(textureBufferImpl);
        refCountMonitor.onDestroy(textureBufferImpl);
    }
}
