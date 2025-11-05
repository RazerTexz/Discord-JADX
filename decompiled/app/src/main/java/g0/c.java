package g0;

import java.io.IOException;

/* compiled from: AsyncTimeout.kt */
/* loaded from: classes3.dex */
public final class c implements v {
    public final /* synthetic */ b j;
    public final /* synthetic */ v k;

    public c(b bVar, v vVar) {
        this.j = bVar;
        this.k = vVar;
    }

    @Override // g0.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        b bVar = this.j;
        bVar.i();
        try {
            this.k.close();
            if (bVar.j()) {
                throw bVar.k(null);
            }
        } catch (IOException e) {
            if (!bVar.j()) {
                throw e;
            }
            throw bVar.k(e);
        } finally {
            bVar.j();
        }
    }

    @Override // g0.v, java.io.Flushable
    public void flush() throws IOException {
        b bVar = this.j;
        bVar.i();
        try {
            this.k.flush();
            if (bVar.j()) {
                throw bVar.k(null);
            }
        } catch (IOException e) {
            if (!bVar.j()) {
                throw e;
            }
            throw bVar.k(e);
        } finally {
            bVar.j();
        }
    }

    @Override // g0.v
    public y timeout() {
        return this.j;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("AsyncTimeout.sink(");
        sbU.append(this.k);
        sbU.append(')');
        return sbU.toString();
    }

    @Override // g0.v
    public void write(e eVar, long j) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(eVar, "source");
        b.i.a.f.e.o.f.B(eVar.k, 0L, j);
        while (true) {
            long j2 = 0;
            if (j <= 0) {
                return;
            }
            s sVar = eVar.j;
            if (sVar == null) {
                d0.z.d.m.throwNpe();
            }
            while (true) {
                if (j2 >= 65536) {
                    break;
                }
                j2 += sVar.c - sVar.f3693b;
                if (j2 >= j) {
                    j2 = j;
                    break;
                } else {
                    sVar = sVar.f;
                    if (sVar == null) {
                        d0.z.d.m.throwNpe();
                    }
                }
            }
            b bVar = this.j;
            bVar.i();
            try {
                this.k.write(eVar, j2);
                if (bVar.j()) {
                    throw bVar.k(null);
                }
                j -= j2;
            } catch (IOException e) {
                if (!bVar.j()) {
                    throw e;
                }
                throw bVar.k(e);
            } finally {
                bVar.j();
            }
        }
    }
}
