package f0.e0.j;

import com.discord.api.permission.Permission;
import g0.v;
import g0.x;
import g0.y;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Objects;
import kotlin.TypeCastException;
import okhttp3.Headers;
import okhttp3.internal.http2.StreamResetException;

/* compiled from: Http2Stream.kt */
/* loaded from: classes3.dex */
public final class n {
    public long a;

    /* renamed from: b, reason: collision with root package name */
    public long f3644b;
    public long c;
    public long d;
    public final ArrayDeque<Headers> e;
    public boolean f;
    public final b g;
    public final a h;
    public final c i;
    public final c j;
    public f0.e0.j.a k;
    public IOException l;
    public final int m;
    public final e n;

    /* compiled from: Http2Stream.kt */
    public final class a implements v {
        public final g0.e j = new g0.e();
        public boolean k;
        public boolean l;

        public a(boolean z2) {
            this.l = z2;
        }

        public final void a(boolean z2) throws IOException {
            long jMin;
            boolean z3;
            synchronized (n.this) {
                n.this.j.i();
                while (true) {
                    try {
                        n nVar = n.this;
                        if (nVar.c < nVar.d || this.l || this.k || nVar.f() != null) {
                            break;
                        } else {
                            n.this.l();
                        }
                    } finally {
                    }
                }
                n.this.j.m();
                n.this.b();
                n nVar2 = n.this;
                jMin = Math.min(nVar2.d - nVar2.c, this.j.k);
                n nVar3 = n.this;
                nVar3.c += jMin;
                z3 = z2 && jMin == this.j.k && nVar3.f() == null;
            }
            n.this.j.i();
            try {
                n nVar4 = n.this;
                nVar4.n.n(nVar4.m, z3, this.j, jMin);
            } finally {
            }
        }

        @Override // g0.v, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            n nVar = n.this;
            byte[] bArr = f0.e0.c.a;
            synchronized (nVar) {
                if (this.k) {
                    return;
                }
                boolean z2 = n.this.f() == null;
                n nVar2 = n.this;
                if (!nVar2.h.l) {
                    if (this.j.k > 0) {
                        while (this.j.k > 0) {
                            a(true);
                        }
                    } else if (z2) {
                        nVar2.n.n(nVar2.m, true, null, 0L);
                    }
                }
                synchronized (n.this) {
                    this.k = true;
                }
                n.this.n.K.flush();
                n.this.a();
            }
        }

        @Override // g0.v, java.io.Flushable
        public void flush() throws IOException {
            n nVar = n.this;
            byte[] bArr = f0.e0.c.a;
            synchronized (nVar) {
                n.this.b();
            }
            while (this.j.k > 0) {
                a(false);
                n.this.n.K.flush();
            }
        }

        @Override // g0.v
        public y timeout() {
            return n.this.j;
        }

        @Override // g0.v
        public void write(g0.e eVar, long j) throws IOException {
            d0.z.d.m.checkParameterIsNotNull(eVar, "source");
            byte[] bArr = f0.e0.c.a;
            this.j.write(eVar, j);
            while (this.j.k >= Permission.EMBED_LINKS) {
                a(false);
            }
        }
    }

    /* compiled from: Http2Stream.kt */
    public final class b implements x {
        public final g0.e j = new g0.e();
        public final g0.e k = new g0.e();
        public boolean l;
        public final long m;
        public boolean n;

        public b(long j, boolean z2) {
            this.m = j;
            this.n = z2;
        }

        public final void a(long j) {
            n nVar = n.this;
            byte[] bArr = f0.e0.c.a;
            nVar.n.f(j);
        }

        @Override // g0.x, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long j;
            synchronized (n.this) {
                this.l = true;
                g0.e eVar = this.k;
                j = eVar.k;
                eVar.skip(j);
                n nVar = n.this;
                if (nVar == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                }
                nVar.notifyAll();
            }
            if (j > 0) {
                a(j);
            }
            n.this.a();
        }

        @Override // g0.x
        public long i0(g0.e eVar, long j) throws Throwable {
            long jI0;
            boolean z2;
            long j2;
            d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
            long j3 = 0;
            if (!(j >= 0)) {
                throw new IllegalArgumentException(b.d.b.a.a.t("byteCount < 0: ", j).toString());
            }
            while (true) {
                Throwable streamResetException = null;
                synchronized (n.this) {
                    n.this.i.i();
                    try {
                        if (n.this.f() != null && (streamResetException = n.this.l) == null) {
                            f0.e0.j.a aVarF = n.this.f();
                            if (aVarF == null) {
                                d0.z.d.m.throwNpe();
                            }
                            streamResetException = new StreamResetException(aVarF);
                        }
                        if (this.l) {
                            throw new IOException("stream closed");
                        }
                        g0.e eVar2 = this.k;
                        long j4 = eVar2.k;
                        if (j4 > j3) {
                            jI0 = eVar2.i0(eVar, Math.min(j, j4));
                            n nVar = n.this;
                            long j5 = nVar.a + jI0;
                            nVar.a = j5;
                            long j6 = j5 - nVar.f3644b;
                            if (streamResetException == null && j6 >= nVar.n.D.a() / 2) {
                                n nVar2 = n.this;
                                nVar2.n.t(nVar2.m, j6);
                                n nVar3 = n.this;
                                nVar3.f3644b = nVar3.a;
                            }
                        } else if (this.n || streamResetException != null) {
                            jI0 = -1;
                        } else {
                            n.this.l();
                            z2 = true;
                            j2 = -1;
                        }
                        j2 = jI0;
                        z2 = false;
                    } finally {
                        n.this.i.m();
                    }
                }
                if (!z2) {
                    if (j2 != -1) {
                        a(j2);
                        return j2;
                    }
                    if (streamResetException == null) {
                        return -1L;
                    }
                    throw streamResetException;
                }
                j3 = 0;
            }
        }

        @Override // g0.x
        public y timeout() {
            return n.this.i;
        }
    }

    /* compiled from: Http2Stream.kt */
    public final class c extends g0.b {
        public c() {
        }

        @Override // g0.b
        public IOException k(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // g0.b
        public void l() {
            n.this.e(f0.e0.j.a.CANCEL);
            e eVar = n.this.n;
            synchronized (eVar) {
                long j = eVar.A;
                long j2 = eVar.f3641z;
                if (j < j2) {
                    return;
                }
                eVar.f3641z = j2 + 1;
                eVar.C = System.nanoTime() + 1000000000;
                f0.e0.f.c cVar = eVar.t;
                String strJ = b.d.b.a.a.J(new StringBuilder(), eVar.o, " ping");
                cVar.c(new k(strJ, true, strJ, true, eVar), 0L);
            }
        }

        public final void m() throws IOException {
            if (j()) {
                throw new SocketTimeoutException("timeout");
            }
        }
    }

    public n(int i, e eVar, boolean z2, boolean z3, Headers headers) {
        d0.z.d.m.checkParameterIsNotNull(eVar, "connection");
        this.m = i;
        this.n = eVar;
        this.d = eVar.E.a();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.e = arrayDeque;
        this.g = new b(eVar.D.a(), z3);
        this.h = new a(z2);
        this.i = new c();
        this.j = new c();
        if (headers == null) {
            if (!h()) {
                throw new IllegalStateException("remotely-initiated streams should have headers".toString());
            }
        } else {
            if (!(!h())) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            arrayDeque.add(headers);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() throws IOException {
        boolean z2;
        boolean zI;
        byte[] bArr = f0.e0.c.a;
        synchronized (this) {
            b bVar = this.g;
            if (bVar.n || !bVar.l) {
                z2 = false;
                zI = i();
            } else {
                a aVar = this.h;
                if (aVar.l || aVar.k) {
                    z2 = true;
                }
                zI = i();
            }
        }
        if (z2) {
            c(f0.e0.j.a.CANCEL, null);
        } else {
            if (zI) {
                return;
            }
            this.n.d(this.m);
        }
    }

    public final void b() throws IOException {
        a aVar = this.h;
        if (aVar.k) {
            throw new IOException("stream closed");
        }
        if (aVar.l) {
            throw new IOException("stream finished");
        }
        if (this.k != null) {
            IOException iOException = this.l;
            if (iOException != null) {
                throw iOException;
            }
            f0.e0.j.a aVar2 = this.k;
            if (aVar2 == null) {
                d0.z.d.m.throwNpe();
            }
            throw new StreamResetException(aVar2);
        }
    }

    public final void c(f0.e0.j.a aVar, IOException iOException) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(aVar, "rstStatusCode");
        if (d(aVar, iOException)) {
            e eVar = this.n;
            int i = this.m;
            Objects.requireNonNull(eVar);
            d0.z.d.m.checkParameterIsNotNull(aVar, "statusCode");
            eVar.K.n(i, aVar);
        }
    }

    public final boolean d(f0.e0.j.a aVar, IOException iOException) {
        byte[] bArr = f0.e0.c.a;
        synchronized (this) {
            if (this.k != null) {
                return false;
            }
            if (this.g.n && this.h.l) {
                return false;
            }
            this.k = aVar;
            this.l = iOException;
            notifyAll();
            this.n.d(this.m);
            return true;
        }
    }

    public final void e(f0.e0.j.a aVar) {
        d0.z.d.m.checkParameterIsNotNull(aVar, "errorCode");
        if (d(aVar, null)) {
            this.n.s(this.m, aVar);
        }
    }

    public final synchronized f0.e0.j.a f() {
        return this.k;
    }

    public final v g() {
        synchronized (this) {
            if (!(this.f || h())) {
                throw new IllegalStateException("reply before requesting the sink".toString());
            }
        }
        return this.h;
    }

    public final boolean h() {
        return this.n.l == ((this.m & 1) == 1);
    }

    public final synchronized boolean i() {
        if (this.k != null) {
            return false;
        }
        b bVar = this.g;
        if (bVar.n || bVar.l) {
            a aVar = this.h;
            if (aVar.l || aVar.k) {
                if (this.f) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void j(Headers headers, boolean z2) {
        boolean zI;
        d0.z.d.m.checkParameterIsNotNull(headers, "headers");
        byte[] bArr = f0.e0.c.a;
        synchronized (this) {
            if (this.f && z2) {
                Objects.requireNonNull(this.g);
            } else {
                this.f = true;
                this.e.add(headers);
            }
            if (z2) {
                this.g.n = true;
            }
            zI = i();
            notifyAll();
        }
        if (zI) {
            return;
        }
        this.n.d(this.m);
    }

    public final synchronized void k(f0.e0.j.a aVar) {
        d0.z.d.m.checkParameterIsNotNull(aVar, "errorCode");
        if (this.k == null) {
            this.k = aVar;
            notifyAll();
        }
    }

    public final void l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
}
