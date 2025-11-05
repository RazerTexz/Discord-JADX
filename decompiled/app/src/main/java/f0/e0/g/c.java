package f0.e0.g;

import androidx.core.app.NotificationCompat;
import f0.e0.n.d;
import f0.t;
import g0.v;
import g0.x;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Objects;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;
import okio.BufferedSink;

/* compiled from: Exchange.kt */
/* loaded from: classes3.dex */
public final class c {
    public boolean a;

    /* renamed from: b, reason: collision with root package name */
    public final j f3614b;
    public final e c;
    public final t d;
    public final d e;
    public final f0.e0.h.d f;

    /* compiled from: Exchange.kt */
    public final class a extends g0.i {
        public boolean j;
        public long k;
        public boolean l;
        public final long m;
        public final /* synthetic */ c n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, v vVar, long j) {
            super(vVar);
            d0.z.d.m.checkParameterIsNotNull(vVar, "delegate");
            this.n = cVar;
            this.m = j;
        }

        public final <E extends IOException> E a(E e) {
            if (this.j) {
                return e;
            }
            this.j = true;
            return (E) this.n.a(this.k, false, true, e);
        }

        @Override // g0.i, g0.v, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.l) {
                return;
            }
            this.l = true;
            long j = this.m;
            if (j != -1 && this.k != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                a(null);
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // g0.i, g0.v, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // g0.i, g0.v
        public void write(g0.e eVar, long j) throws IOException {
            d0.z.d.m.checkParameterIsNotNull(eVar, "source");
            if (!(!this.l)) {
                throw new IllegalStateException("closed".toString());
            }
            long j2 = this.m;
            if (j2 == -1 || this.k + j <= j2) {
                try {
                    super.write(eVar, j);
                    this.k += j;
                    return;
                } catch (IOException e) {
                    throw a(e);
                }
            }
            StringBuilder sbU = b.d.b.a.a.U("expected ");
            sbU.append(this.m);
            sbU.append(" bytes but received ");
            sbU.append(this.k + j);
            throw new ProtocolException(sbU.toString());
        }
    }

    /* compiled from: Exchange.kt */
    public final class b extends g0.j {
        public long k;
        public boolean l;
        public boolean m;
        public boolean n;
        public final long o;
        public final /* synthetic */ c p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, x xVar, long j) {
            super(xVar);
            d0.z.d.m.checkParameterIsNotNull(xVar, "delegate");
            this.p = cVar;
            this.o = j;
            this.l = true;
            if (j == 0) {
                a(null);
            }
        }

        public final <E extends IOException> E a(E e) {
            if (this.m) {
                return e;
            }
            this.m = true;
            if (e == null && this.l) {
                this.l = false;
                c cVar = this.p;
                t tVar = cVar.d;
                e eVar = cVar.c;
                Objects.requireNonNull(tVar);
                d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            }
            return (E) this.p.a(this.k, true, false, e);
        }

        @Override // g0.j, g0.x, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.n) {
                return;
            }
            this.n = true;
            try {
                this.j.close();
                a(null);
            } catch (IOException e) {
                throw a(e);
            }
        }

        @Override // g0.x
        public long i0(g0.e eVar, long j) throws IOException {
            d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
            if (!(!this.n)) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long jI0 = this.j.i0(eVar, j);
                if (this.l) {
                    this.l = false;
                    c cVar = this.p;
                    t tVar = cVar.d;
                    e eVar2 = cVar.c;
                    Objects.requireNonNull(tVar);
                    d0.z.d.m.checkParameterIsNotNull(eVar2, NotificationCompat.CATEGORY_CALL);
                }
                if (jI0 == -1) {
                    a(null);
                    return -1L;
                }
                long j2 = this.k + jI0;
                long j3 = this.o;
                if (j3 != -1 && j2 > j3) {
                    throw new ProtocolException("expected " + this.o + " bytes but received " + j2);
                }
                this.k = j2;
                if (j2 == j3) {
                    a(null);
                }
                return jI0;
            } catch (IOException e) {
                throw a(e);
            }
        }
    }

    public c(e eVar, t tVar, d dVar, f0.e0.h.d dVar2) {
        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        d0.z.d.m.checkParameterIsNotNull(tVar, "eventListener");
        d0.z.d.m.checkParameterIsNotNull(dVar, "finder");
        d0.z.d.m.checkParameterIsNotNull(dVar2, "codec");
        this.c = eVar;
        this.d = tVar;
        this.e = dVar;
        this.f = dVar2;
        this.f3614b = dVar2.e();
    }

    public final <E extends IOException> E a(long j, boolean z2, boolean z3, E e) {
        if (e != null) {
            g(e);
        }
        if (z3) {
            if (e != null) {
                t tVar = this.d;
                e eVar = this.c;
                Objects.requireNonNull(tVar);
                d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
                d0.z.d.m.checkParameterIsNotNull(e, "ioe");
            } else {
                t tVar2 = this.d;
                e eVar2 = this.c;
                Objects.requireNonNull(tVar2);
                d0.z.d.m.checkParameterIsNotNull(eVar2, NotificationCompat.CATEGORY_CALL);
            }
        }
        if (z2) {
            if (e != null) {
                t tVar3 = this.d;
                e eVar3 = this.c;
                Objects.requireNonNull(tVar3);
                d0.z.d.m.checkParameterIsNotNull(eVar3, NotificationCompat.CATEGORY_CALL);
                d0.z.d.m.checkParameterIsNotNull(e, "ioe");
            } else {
                t tVar4 = this.d;
                e eVar4 = this.c;
                Objects.requireNonNull(tVar4);
                d0.z.d.m.checkParameterIsNotNull(eVar4, NotificationCompat.CATEGORY_CALL);
            }
        }
        return (E) this.c.k(this, z3, z2, e);
    }

    public final v b(Request request, boolean z2) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(request, "request");
        this.a = z2;
        RequestBody requestBody = request.body;
        if (requestBody == null) {
            d0.z.d.m.throwNpe();
        }
        long jContentLength = requestBody.contentLength();
        t tVar = this.d;
        e eVar = this.c;
        Objects.requireNonNull(tVar);
        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
        return new a(this, this.f.h(request, jContentLength), jContentLength);
    }

    public final void c() throws IOException {
        try {
            this.f.f();
        } catch (IOException e) {
            t tVar = this.d;
            e eVar = this.c;
            Objects.requireNonNull(tVar);
            d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            d0.z.d.m.checkParameterIsNotNull(e, "ioe");
            g(e);
            throw e;
        }
    }

    public final d.c d() throws SocketException {
        this.c.n();
        j jVarE = this.f.e();
        Objects.requireNonNull(jVarE);
        d0.z.d.m.checkParameterIsNotNull(this, "exchange");
        Socket socket = jVarE.c;
        if (socket == null) {
            d0.z.d.m.throwNpe();
        }
        g0.g gVar = jVarE.g;
        if (gVar == null) {
            d0.z.d.m.throwNpe();
        }
        BufferedSink bufferedSink = jVarE.h;
        if (bufferedSink == null) {
            d0.z.d.m.throwNpe();
        }
        socket.setSoTimeout(0);
        jVarE.l();
        return new i(this, gVar, bufferedSink, true, gVar, bufferedSink);
    }

    public final Response.a e(boolean z2) throws IOException {
        try {
            Response.a aVarD = this.f.d(z2);
            if (aVarD != null) {
                d0.z.d.m.checkParameterIsNotNull(this, "deferredTrailers");
                aVarD.m = this;
            }
            return aVarD;
        } catch (IOException e) {
            t tVar = this.d;
            e eVar = this.c;
            Objects.requireNonNull(tVar);
            d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            d0.z.d.m.checkParameterIsNotNull(e, "ioe");
            g(e);
            throw e;
        }
    }

    public final void f() {
        t tVar = this.d;
        e eVar = this.c;
        Objects.requireNonNull(tVar);
        d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
    }

    public final void g(IOException iOException) {
        this.e.c(iOException);
        j jVarE = this.f.e();
        e eVar = this.c;
        synchronized (jVarE) {
            d0.z.d.m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            if (iOException instanceof StreamResetException) {
                if (((StreamResetException) iOException).errorCode == f0.e0.j.a.REFUSED_STREAM) {
                    int i = jVarE.m + 1;
                    jVarE.m = i;
                    if (i > 1) {
                        jVarE.i = true;
                        jVarE.k++;
                    }
                } else if (((StreamResetException) iOException).errorCode != f0.e0.j.a.CANCEL || !eVar.v) {
                    jVarE.i = true;
                    jVarE.k++;
                }
            } else if (!jVarE.j() || (iOException instanceof ConnectionShutdownException)) {
                jVarE.i = true;
                if (jVarE.l == 0) {
                    jVarE.d(eVar.f3618y, jVarE.q, iOException);
                    jVarE.k++;
                }
            }
        }
    }
}
