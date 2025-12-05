package p600f0.p601e0.p613n;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import p615g0.Buffer3;
import p615g0.InflaterSource;
import p615g0.Source2;

/* compiled from: MessageInflater.kt */
/* renamed from: f0.e0.n.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class MessageInflater implements Closeable {

    /* renamed from: j */
    public final Buffer3 f25817j;

    /* renamed from: k */
    public final Inflater f25818k;

    /* renamed from: l */
    public final InflaterSource f25819l;

    /* renamed from: m */
    public final boolean f25820m;

    public MessageInflater(boolean z2) {
        this.f25820m = z2;
        Buffer3 buffer3 = new Buffer3();
        this.f25817j = buffer3;
        Inflater inflater = new Inflater(true);
        this.f25818k = inflater;
        this.f25819l = new InflaterSource((Source2) buffer3, inflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f25819l.close();
    }
}
