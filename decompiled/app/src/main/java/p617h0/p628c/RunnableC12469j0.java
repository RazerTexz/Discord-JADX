package p617h0.p628c;

import java.nio.ByteBuffer;
import org.webrtc.JniCommon;

/* compiled from: lambda */
/* renamed from: h0.c.j0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12469j0 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ ByteBuffer f26442j;

    public /* synthetic */ RunnableC12469j0(ByteBuffer byteBuffer) {
        this.f26442j = byteBuffer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JniCommon.nativeFreeByteBuffer(this.f26442j);
    }
}
