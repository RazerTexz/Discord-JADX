package f0.e0.n;

import g0.m;
import g0.x;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;

/* compiled from: MessageInflater.kt */
/* loaded from: classes3.dex */
public final class c implements Closeable {
    public final g0.e j;
    public final Inflater k;
    public final m l;
    public final boolean m;

    public c(boolean z2) {
        this.m = z2;
        g0.e eVar = new g0.e();
        this.j = eVar;
        Inflater inflater = new Inflater(true);
        this.k = inflater;
        this.l = new m((x) eVar, inflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.l.close();
    }
}
