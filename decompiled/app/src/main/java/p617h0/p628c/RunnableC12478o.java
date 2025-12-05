package p617h0.p628c;

import java.nio.ByteBuffer;
import org.webrtc.JniCommon;

/* compiled from: lambda */
/* renamed from: h0.c.o */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12478o implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ ByteBuffer f26454j;

    public /* synthetic */ RunnableC12478o(ByteBuffer byteBuffer) {
        this.f26454j = byteBuffer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JniCommon.nativeFreeByteBuffer(this.f26454j);
    }
}
