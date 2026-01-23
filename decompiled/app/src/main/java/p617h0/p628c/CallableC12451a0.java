package p617h0.p628c;

import java.util.concurrent.Callable;
import org.webrtc.TextureBufferImpl;

/* JADX INFO: renamed from: h0.c.a0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CallableC12451a0 implements Callable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ TextureBufferImpl f26408j;

    public /* synthetic */ CallableC12451a0(TextureBufferImpl textureBufferImpl) {
        this.f26408j = textureBufferImpl;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f26408j.m11048a();
    }
}
