package p600f0.p601e0.p608j;

import com.discord.api.permission.Permission;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Objects;
import kotlin.TypeCastException;
import okhttp3.Headers;
import okhttp3.internal.http2.StreamResetException;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p604f.TaskQueue2;
import p615g0.AsyncTimeout;
import p615g0.Buffer3;
import p615g0.Sink;
import p615g0.Source2;
import p615g0.Timeout2;

/* JADX INFO: renamed from: f0.e0.j.n, reason: use source file name */
/* JADX INFO: compiled from: Http2Stream.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Http2Stream {

    /* JADX INFO: renamed from: a */
    public long f25712a;

    /* JADX INFO: renamed from: b */
    public long f25713b;

    /* JADX INFO: renamed from: c */
    public long f25714c;

    /* JADX INFO: renamed from: d */
    public long f25715d;

    /* JADX INFO: renamed from: e */
    public final ArrayDeque<Headers> f25716e;

    /* JADX INFO: renamed from: f */
    public boolean f25717f;

    /* JADX INFO: renamed from: g */
    public final b f25718g;

    /* JADX INFO: renamed from: h */
    public final a f25719h;

    /* JADX INFO: renamed from: i */
    public final c f25720i;

    /* JADX INFO: renamed from: j */
    public final c f25721j;

    /* JADX INFO: renamed from: k */
    public ErrorCode2 f25722k;

    /* JADX INFO: renamed from: l */
    public IOException f25723l;

    /* JADX INFO: renamed from: m */
    public final int f25724m;

    /* JADX INFO: renamed from: n */
    public final Http2Connection f25725n;

    /* JADX INFO: renamed from: f0.e0.j.n$a */
    /* JADX INFO: compiled from: Http2Stream.kt */
    public final class a implements Sink {

        /* JADX INFO: renamed from: j */
        public final Buffer3 f25726j = new Buffer3();

        /* JADX INFO: renamed from: k */
        public boolean f25727k;

        /* JADX INFO: renamed from: l */
        public boolean f25728l;

        public a(boolean z2) {
            this.f25728l = z2;
        }

        /* JADX INFO: renamed from: a */
        public final void m10294a(boolean z2) throws IOException {
            long jMin;
            boolean z3;
            synchronized (Http2Stream.this) {
                Http2Stream.this.f25721j.m10424i();
                while (true) {
                    try {
                        Http2Stream http2Stream = Http2Stream.this;
                        if (http2Stream.f25714c < http2Stream.f25715d || this.f25728l || this.f25727k || http2Stream.m10287f() != null) {
                            break;
                        } else {
                            Http2Stream.this.m10293l();
                        }
                    } finally {
                    }
                }
                Http2Stream.this.f25721j.m10297m();
                Http2Stream.this.m10283b();
                Http2Stream http2Stream2 = Http2Stream.this;
                jMin = Math.min(http2Stream2.f25715d - http2Stream2.f25714c, this.f25726j.f26080k);
                Http2Stream http2Stream3 = Http2Stream.this;
                http2Stream3.f25714c += jMin;
                z3 = z2 && jMin == this.f25726j.f26080k && http2Stream3.m10287f() == null;
            }
            Http2Stream.this.f25721j.m10424i();
            try {
                Http2Stream http2Stream4 = Http2Stream.this;
                http2Stream4.f25725n.m10264n(http2Stream4.f25724m, z3, this.f25726j, jMin);
            } finally {
            }
        }

        @Override // p615g0.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            byte[] bArr = Util7.f25397a;
            synchronized (http2Stream) {
                if (this.f25727k) {
                    return;
                }
                boolean z2 = Http2Stream.this.m10287f() == null;
                Http2Stream http2Stream2 = Http2Stream.this;
                if (!http2Stream2.f25719h.f25728l) {
                    if (this.f25726j.f26080k > 0) {
                        while (this.f25726j.f26080k > 0) {
                            m10294a(true);
                        }
                    } else if (z2) {
                        http2Stream2.f25725n.m10264n(http2Stream2.f25724m, true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.f25727k = true;
                }
                Http2Stream.this.f25725n.f25627K.flush();
                Http2Stream.this.m10282a();
            }
        }

        @Override // p615g0.Sink, java.io.Flushable
        public void flush() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            byte[] bArr = Util7.f25397a;
            synchronized (http2Stream) {
                Http2Stream.this.m10283b();
            }
            while (this.f25726j.f26080k > 0) {
                m10294a(false);
                Http2Stream.this.f25725n.f25627K.flush();
            }
        }

        @Override // p615g0.Sink
        public Timeout2 timeout() {
            return Http2Stream.this.f25721j;
        }

        @Override // p615g0.Sink
        public void write(Buffer3 buffer3, long j) throws IOException {
            Intrinsics3.checkParameterIsNotNull(buffer3, "source");
            byte[] bArr = Util7.f25397a;
            this.f25726j.write(buffer3, j);
            while (this.f25726j.f26080k >= Permission.EMBED_LINKS) {
                m10294a(false);
            }
        }
    }

    /* JADX INFO: renamed from: f0.e0.j.n$b */
    /* JADX INFO: compiled from: Http2Stream.kt */
    public final class b implements Source2 {

        /* JADX INFO: renamed from: j */
        public final Buffer3 f25730j = new Buffer3();

        /* JADX INFO: renamed from: k */
        public final Buffer3 f25731k = new Buffer3();

        /* JADX INFO: renamed from: l */
        public boolean f25732l;

        /* JADX INFO: renamed from: m */
        public final long f25733m;

        /* JADX INFO: renamed from: n */
        public boolean f25734n;

        public b(long j, boolean z2) {
            this.f25733m = j;
            this.f25734n = z2;
        }

        /* JADX INFO: renamed from: a */
        public final void m10295a(long j) {
            Http2Stream http2Stream = Http2Stream.this;
            byte[] bArr = Util7.f25397a;
            http2Stream.f25725n.m10263f(j);
        }

        @Override // p615g0.Source2, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long j;
            synchronized (Http2Stream.this) {
                this.f25732l = true;
                Buffer3 buffer3 = this.f25731k;
                j = buffer3.f26080k;
                buffer3.skip(j);
                Http2Stream http2Stream = Http2Stream.this;
                if (http2Stream == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                }
                http2Stream.notifyAll();
            }
            if (j > 0) {
                m10295a(j);
            }
            Http2Stream.this.m10282a();
        }

        @Override // p615g0.Source2
        /* JADX INFO: renamed from: i0 */
        public long mo10176i0(Buffer3 buffer3, long j) throws Throwable {
            long jMo10176i0;
            boolean z2;
            long j2;
            Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
            long j3 = 0;
            if (!(j >= 0)) {
                throw new IllegalArgumentException(outline.m877t("byteCount < 0: ", j).toString());
            }
            while (true) {
                Throwable streamResetException = null;
                synchronized (Http2Stream.this) {
                    Http2Stream.this.f25720i.m10424i();
                    try {
                        if (Http2Stream.this.m10287f() != null && (streamResetException = Http2Stream.this.f25723l) == null) {
                            ErrorCode2 errorCode2M10287f = Http2Stream.this.m10287f();
                            if (errorCode2M10287f == null) {
                                Intrinsics3.throwNpe();
                            }
                            streamResetException = new StreamResetException(errorCode2M10287f);
                        }
                        if (this.f25732l) {
                            throw new IOException("stream closed");
                        }
                        Buffer3 buffer32 = this.f25731k;
                        long j4 = buffer32.f26080k;
                        if (j4 > j3) {
                            jMo10176i0 = buffer32.mo10176i0(buffer3, Math.min(j, j4));
                            Http2Stream http2Stream = Http2Stream.this;
                            long j5 = http2Stream.f25712a + jMo10176i0;
                            http2Stream.f25712a = j5;
                            long j6 = j5 - http2Stream.f25713b;
                            if (streamResetException == null && j6 >= http2Stream.f25725n.f25620D.m10312a() / 2) {
                                Http2Stream http2Stream2 = Http2Stream.this;
                                http2Stream2.f25725n.m10267t(http2Stream2.f25724m, j6);
                                Http2Stream http2Stream3 = Http2Stream.this;
                                http2Stream3.f25713b = http2Stream3.f25712a;
                            }
                        } else if (this.f25734n || streamResetException != null) {
                            jMo10176i0 = -1;
                        } else {
                            Http2Stream.this.m10293l();
                            z2 = true;
                            j2 = -1;
                        }
                        j2 = jMo10176i0;
                        z2 = false;
                    } finally {
                        Http2Stream.this.f25720i.m10297m();
                    }
                }
                if (!z2) {
                    if (j2 != -1) {
                        m10295a(j2);
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

        @Override // p615g0.Source2
        public Timeout2 timeout() {
            return Http2Stream.this.f25720i;
        }
    }

    /* JADX INFO: renamed from: f0.e0.j.n$c */
    /* JADX INFO: compiled from: Http2Stream.kt */
    public final class c extends AsyncTimeout {
        public c() {
        }

        @Override // p615g0.AsyncTimeout
        /* JADX INFO: renamed from: k */
        public IOException mo10296k(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // p615g0.AsyncTimeout
        /* JADX INFO: renamed from: l */
        public void mo10191l() {
            Http2Stream.this.m10286e(ErrorCode2.CANCEL);
            Http2Connection http2Connection = Http2Stream.this.f25725n;
            synchronized (http2Connection) {
                long j = http2Connection.f25617A;
                long j2 = http2Connection.f25644z;
                if (j < j2) {
                    return;
                }
                http2Connection.f25644z = j2 + 1;
                http2Connection.f25619C = System.nanoTime() + ((long) 1000000000);
                TaskQueue2 taskQueue2 = http2Connection.f25638t;
                String strM822J = outline.m822J(new StringBuilder(), http2Connection.f25633o, " ping");
                taskQueue2.m10154c(new TaskQueue8(strM822J, true, strM822J, true, http2Connection), 0L);
            }
        }

        /* JADX INFO: renamed from: m */
        public final void m10297m() throws IOException {
            if (m10425j()) {
                throw new SocketTimeoutException("timeout");
            }
        }
    }

    public Http2Stream(int i, Http2Connection http2Connection, boolean z2, boolean z3, Headers headers) {
        Intrinsics3.checkParameterIsNotNull(http2Connection, "connection");
        this.f25724m = i;
        this.f25725n = http2Connection;
        this.f25715d = http2Connection.f25621E.m10312a();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.f25716e = arrayDeque;
        this.f25718g = new b(http2Connection.f25620D.m10312a(), z3);
        this.f25719h = new a(z2);
        this.f25720i = new c();
        this.f25721j = new c();
        if (headers == null) {
            if (!m10289h()) {
                throw new IllegalStateException("remotely-initiated streams should have headers".toString());
            }
        } else {
            if (!(!m10289h())) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            arrayDeque.add(headers);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0019  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m10282a() throws IOException {
        boolean z2;
        boolean zM10290i;
        byte[] bArr = Util7.f25397a;
        synchronized (this) {
            b bVar = this.f25718g;
            if (bVar.f25734n || !bVar.f25732l) {
                z2 = false;
                zM10290i = m10290i();
            } else {
                a aVar = this.f25719h;
                if (aVar.f25728l || aVar.f25727k) {
                    z2 = true;
                }
                zM10290i = m10290i();
            }
        }
        if (z2) {
            m10284c(ErrorCode2.CANCEL, null);
        } else {
            if (zM10290i) {
                return;
            }
            this.f25725n.m10261d(this.f25724m);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m10283b() throws IOException {
        a aVar = this.f25719h;
        if (aVar.f25727k) {
            throw new IOException("stream closed");
        }
        if (aVar.f25728l) {
            throw new IOException("stream finished");
        }
        if (this.f25722k != null) {
            IOException iOException = this.f25723l;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode2 errorCode2 = this.f25722k;
            if (errorCode2 == null) {
                Intrinsics3.throwNpe();
            }
            throw new StreamResetException(errorCode2);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m10284c(ErrorCode2 errorCode2, IOException iOException) throws IOException {
        Intrinsics3.checkParameterIsNotNull(errorCode2, "rstStatusCode");
        if (m10285d(errorCode2, iOException)) {
            Http2Connection http2Connection = this.f25725n;
            int i = this.f25724m;
            Objects.requireNonNull(http2Connection);
            Intrinsics3.checkParameterIsNotNull(errorCode2, "statusCode");
            http2Connection.f25627K.m10304n(i, errorCode2);
        }
    }

    /* JADX INFO: renamed from: d */
    public final boolean m10285d(ErrorCode2 errorCode2, IOException iOException) {
        byte[] bArr = Util7.f25397a;
        synchronized (this) {
            if (this.f25722k != null) {
                return false;
            }
            if (this.f25718g.f25734n && this.f25719h.f25728l) {
                return false;
            }
            this.f25722k = errorCode2;
            this.f25723l = iOException;
            notifyAll();
            this.f25725n.m10261d(this.f25724m);
            return true;
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m10286e(ErrorCode2 errorCode2) {
        Intrinsics3.checkParameterIsNotNull(errorCode2, "errorCode");
        if (m10285d(errorCode2, null)) {
            this.f25725n.m10266s(this.f25724m, errorCode2);
        }
    }

    /* JADX INFO: renamed from: f */
    public final synchronized ErrorCode2 m10287f() {
        return this.f25722k;
    }

    /* JADX INFO: renamed from: g */
    public final Sink m10288g() {
        synchronized (this) {
            if (!(this.f25717f || m10289h())) {
                throw new IllegalStateException("reply before requesting the sink".toString());
            }
        }
        return this.f25719h;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m10289h() {
        return this.f25725n.f25630l == ((this.f25724m & 1) == 1);
    }

    /* JADX INFO: renamed from: i */
    public final synchronized boolean m10290i() {
        if (this.f25722k != null) {
            return false;
        }
        b bVar = this.f25718g;
        if (bVar.f25734n || bVar.f25732l) {
            a aVar = this.f25719h;
            if (aVar.f25728l || aVar.f25727k) {
                if (this.f25717f) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: j */
    public final void m10291j(Headers headers, boolean z2) {
        boolean zM10290i;
        Intrinsics3.checkParameterIsNotNull(headers, "headers");
        byte[] bArr = Util7.f25397a;
        synchronized (this) {
            if (this.f25717f && z2) {
                Objects.requireNonNull(this.f25718g);
            } else {
                this.f25717f = true;
                this.f25716e.add(headers);
            }
            if (z2) {
                this.f25718g.f25734n = true;
            }
            zM10290i = m10290i();
            notifyAll();
        }
        if (zM10290i) {
            return;
        }
        this.f25725n.m10261d(this.f25724m);
    }

    /* JADX INFO: renamed from: k */
    public final synchronized void m10292k(ErrorCode2 errorCode2) {
        Intrinsics3.checkParameterIsNotNull(errorCode2, "errorCode");
        if (this.f25722k == null) {
            this.f25722k = errorCode2;
            notifyAll();
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m10293l() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
}
