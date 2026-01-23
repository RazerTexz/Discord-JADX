package p617h0.p628c;

import java.nio.ByteBuffer;
import org.webrtc.JniCommon;

/* JADX INFO: renamed from: h0.c.o */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC12478o implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ ByteBuffer f26454j;

    public /* synthetic */ RunnableC12478o(ByteBuffer byteBuffer) {
        this.f26454j = byteBuffer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JniCommon.nativeFreeByteBuffer(this.f26454j);
    }
}
