package p600f0.p601e0.p613n;

import java.io.Closeable;
import java.util.zip.Deflater;
import p615g0.Buffer3;
import p615g0.DeflaterSink;

/* JADX INFO: renamed from: f0.e0.n.a, reason: use source file name */
/* JADX INFO: compiled from: MessageDeflater.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MessageDeflater implements Closeable {

    /* JADX INFO: renamed from: j */
    public final Buffer3 f25812j;

    /* JADX INFO: renamed from: k */
    public final Deflater f25813k;

    /* JADX INFO: renamed from: l */
    public final DeflaterSink f25814l;

    /* JADX INFO: renamed from: m */
    public final boolean f25815m;

    public MessageDeflater(boolean z2) {
        this.f25815m = z2;
        Buffer3 buffer3 = new Buffer3();
        this.f25812j = buffer3;
        Deflater deflater = new Deflater(-1, true);
        this.f25813k = deflater;
        this.f25814l = new DeflaterSink(buffer3, deflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.f25814l.close();
    }
}
