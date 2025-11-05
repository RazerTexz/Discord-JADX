package b.i.a.c.y2;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import b.i.a.c.y2.n;
import java.util.ArrayDeque;
import java.util.Objects;

/* compiled from: AsynchronousMediaCodecBufferEnqueuer.java */
/* loaded from: classes3.dex */
public class m extends Handler {
    public final /* synthetic */ n a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(n nVar, Looper looper) {
        super(looper);
        this.a = nVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        n.a aVar;
        n nVar = this.a;
        Objects.requireNonNull(nVar);
        int i = message.what;
        if (i == 0) {
            aVar = (n.a) message.obj;
            try {
                nVar.c.queueInputBuffer(aVar.a, aVar.f1309b, aVar.c, aVar.e, aVar.f);
            } catch (RuntimeException e) {
                nVar.f.set(e);
            }
        } else if (i != 1) {
            if (i != 2) {
                nVar.f.set(new IllegalStateException(String.valueOf(message.what)));
            } else {
                nVar.g.b();
            }
            aVar = null;
        } else {
            aVar = (n.a) message.obj;
            int i2 = aVar.a;
            int i3 = aVar.f1309b;
            MediaCodec.CryptoInfo cryptoInfo = aVar.d;
            long j = aVar.e;
            int i4 = aVar.f;
            try {
                synchronized (n.f1308b) {
                    nVar.c.queueSecureInputBuffer(i2, i3, cryptoInfo, j, i4);
                }
            } catch (RuntimeException e2) {
                nVar.f.set(e2);
            }
        }
        if (aVar != null) {
            ArrayDeque<n.a> arrayDeque = n.a;
            synchronized (arrayDeque) {
                arrayDeque.add(aVar);
            }
        }
    }
}
