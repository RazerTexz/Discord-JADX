package p617h0.p628c;

import java.nio.ByteBuffer;
import org.webrtc.JniCommon;

/* JADX INFO: renamed from: h0.c.j0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12469j0 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ ByteBuffer f26442j;

    public /* synthetic */ RunnableC12469j0(ByteBuffer byteBuffer) {
        this.f26442j = byteBuffer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JniCommon.nativeFreeByteBuffer(this.f26442j);
    }
}
