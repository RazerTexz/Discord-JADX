package p007b.p225i.p226a.p242c.p278y2;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p278y2.AsynchronousMediaCodecBufferEnqueuer2;

/* compiled from: AsynchronousMediaCodecBufferEnqueuer.java */
/* renamed from: b.i.a.c.y2.m, reason: use source file name */
/* loaded from: classes3.dex */
public class AsynchronousMediaCodecBufferEnqueuer extends Handler {

    /* renamed from: a */
    public final /* synthetic */ AsynchronousMediaCodecBufferEnqueuer2 f9068a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsynchronousMediaCodecBufferEnqueuer(AsynchronousMediaCodecBufferEnqueuer2 asynchronousMediaCodecBufferEnqueuer2, Looper looper) {
        super(looper);
        this.f9068a = asynchronousMediaCodecBufferEnqueuer2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        AsynchronousMediaCodecBufferEnqueuer2.a aVar;
        AsynchronousMediaCodecBufferEnqueuer2 asynchronousMediaCodecBufferEnqueuer2 = this.f9068a;
        Objects.requireNonNull(asynchronousMediaCodecBufferEnqueuer2);
        int i = message.what;
        if (i == 0) {
            aVar = (AsynchronousMediaCodecBufferEnqueuer2.a) message.obj;
            try {
                asynchronousMediaCodecBufferEnqueuer2.f9071c.queueInputBuffer(aVar.f9077a, aVar.f9078b, aVar.f9079c, aVar.f9081e, aVar.f9082f);
            } catch (RuntimeException e) {
                asynchronousMediaCodecBufferEnqueuer2.f9074f.set(e);
            }
        } else if (i != 1) {
            if (i != 2) {
                asynchronousMediaCodecBufferEnqueuer2.f9074f.set(new IllegalStateException(String.valueOf(message.what)));
            } else {
                asynchronousMediaCodecBufferEnqueuer2.f9075g.m3026b();
            }
            aVar = null;
        } else {
            aVar = (AsynchronousMediaCodecBufferEnqueuer2.a) message.obj;
            int i2 = aVar.f9077a;
            int i3 = aVar.f9078b;
            MediaCodec.CryptoInfo cryptoInfo = aVar.f9080d;
            long j = aVar.f9081e;
            int i4 = aVar.f9082f;
            try {
                synchronized (AsynchronousMediaCodecBufferEnqueuer2.f9070b) {
                    asynchronousMediaCodecBufferEnqueuer2.f9071c.queueSecureInputBuffer(i2, i3, cryptoInfo, j, i4);
                }
            } catch (RuntimeException e2) {
                asynchronousMediaCodecBufferEnqueuer2.f9074f.set(e2);
            }
        }
        if (aVar != null) {
            ArrayDeque<AsynchronousMediaCodecBufferEnqueuer2.a> arrayDeque = AsynchronousMediaCodecBufferEnqueuer2.f9069a;
            synchronized (arrayDeque) {
                arrayDeque.add(aVar);
            }
        }
    }
}
