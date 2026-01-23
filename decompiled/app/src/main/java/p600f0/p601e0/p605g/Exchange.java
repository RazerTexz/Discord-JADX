package p600f0.p601e0.p605g;

import androidx.core.app.NotificationCompat;
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
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.EventListener;
import p600f0.p601e0.p606h.ExchangeCodec;
import p600f0.p601e0.p608j.ErrorCode2;
import p600f0.p601e0.p613n.RealWebSocket;
import p615g0.Buffer3;
import p615g0.BufferedSource;
import p615g0.ForwardingSink;
import p615g0.ForwardingSource;
import p615g0.Sink;
import p615g0.Source2;

/* JADX INFO: renamed from: f0.e0.g.c, reason: use source file name */
/* JADX INFO: compiled from: Exchange.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Exchange {

    /* JADX INFO: renamed from: a */
    public boolean f25437a;

    /* JADX INFO: renamed from: b */
    public final RealConnection4 f25438b;

    /* JADX INFO: renamed from: c */
    public final RealCall f25439c;

    /* JADX INFO: renamed from: d */
    public final EventListener f25440d;

    /* JADX INFO: renamed from: e */
    public final ExchangeFinder f25441e;

    /* JADX INFO: renamed from: f */
    public final ExchangeCodec f25442f;

    /* JADX INFO: renamed from: f0.e0.g.c$a */
    /* JADX INFO: compiled from: Exchange.kt */
    public final class a extends ForwardingSink {

        /* JADX INFO: renamed from: j */
        public boolean f25443j;

        /* JADX INFO: renamed from: k */
        public long f25444k;

        /* JADX INFO: renamed from: l */
        public boolean f25445l;

        /* JADX INFO: renamed from: m */
        public final long f25446m;

        /* JADX INFO: renamed from: n */
        public final /* synthetic */ Exchange f25447n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Exchange exchange, Sink sink, long j) {
            super(sink);
            Intrinsics3.checkParameterIsNotNull(sink, "delegate");
            this.f25447n = exchange;
            this.f25446m = j;
        }

        /* JADX INFO: renamed from: a */
        public final <E extends IOException> E m10174a(E e) {
            if (this.f25443j) {
                return e;
            }
            this.f25443j = true;
            return (E) this.f25447n.m10167a(this.f25444k, false, true, e);
        }

        @Override // p615g0.ForwardingSink, p615g0.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f25445l) {
                return;
            }
            this.f25445l = true;
            long j = this.f25446m;
            if (j != -1 && this.f25444k != j) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                m10174a(null);
            } catch (IOException e) {
                throw m10174a(e);
            }
        }

        @Override // p615g0.ForwardingSink, p615g0.Sink, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e) {
                throw m10174a(e);
            }
        }

        @Override // p615g0.ForwardingSink, p615g0.Sink
        public void write(Buffer3 buffer3, long j) throws IOException {
            Intrinsics3.checkParameterIsNotNull(buffer3, "source");
            if (!(!this.f25445l)) {
                throw new IllegalStateException("closed".toString());
            }
            long j2 = this.f25446m;
            if (j2 == -1 || this.f25444k + j <= j2) {
                try {
                    super.write(buffer3, j);
                    this.f25444k += j;
                    return;
                } catch (IOException e) {
                    throw m10174a(e);
                }
            }
            StringBuilder sbM833U = outline.m833U("expected ");
            sbM833U.append(this.f25446m);
            sbM833U.append(" bytes but received ");
            sbM833U.append(this.f25444k + j);
            throw new ProtocolException(sbM833U.toString());
        }
    }

    /* JADX INFO: renamed from: f0.e0.g.c$b */
    /* JADX INFO: compiled from: Exchange.kt */
    public final class b extends ForwardingSource {

        /* JADX INFO: renamed from: k */
        public long f25448k;

        /* JADX INFO: renamed from: l */
        public boolean f25449l;

        /* JADX INFO: renamed from: m */
        public boolean f25450m;

        /* JADX INFO: renamed from: n */
        public boolean f25451n;

        /* JADX INFO: renamed from: o */
        public final long f25452o;

        /* JADX INFO: renamed from: p */
        public final /* synthetic */ Exchange f25453p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Exchange exchange, Source2 source2, long j) {
            super(source2);
            Intrinsics3.checkParameterIsNotNull(source2, "delegate");
            this.f25453p = exchange;
            this.f25452o = j;
            this.f25449l = true;
            if (j == 0) {
                m10175a(null);
            }
        }

        /* JADX INFO: renamed from: a */
        public final <E extends IOException> E m10175a(E e) {
            if (this.f25450m) {
                return e;
            }
            this.f25450m = true;
            if (e == null && this.f25449l) {
                this.f25449l = false;
                Exchange exchange = this.f25453p;
                EventListener eventListener = exchange.f25440d;
                RealCall realCall = exchange.f25439c;
                Objects.requireNonNull(eventListener);
                Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
            }
            return (E) this.f25453p.m10167a(this.f25448k, true, false, e);
        }

        @Override // p615g0.ForwardingSource, p615g0.Source2, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f25451n) {
                return;
            }
            this.f25451n = true;
            try {
                this.f26093j.close();
                m10175a(null);
            } catch (IOException e) {
                throw m10175a(e);
            }
        }

        @Override // p615g0.Source2
        /* JADX INFO: renamed from: i0 */
        public long mo10176i0(Buffer3 buffer3, long j) throws IOException {
            Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
            if (!(!this.f25451n)) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long jMo10176i0 = this.f26093j.mo10176i0(buffer3, j);
                if (this.f25449l) {
                    this.f25449l = false;
                    Exchange exchange = this.f25453p;
                    EventListener eventListener = exchange.f25440d;
                    RealCall realCall = exchange.f25439c;
                    Objects.requireNonNull(eventListener);
                    Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
                }
                if (jMo10176i0 == -1) {
                    m10175a(null);
                    return -1L;
                }
                long j2 = this.f25448k + jMo10176i0;
                long j3 = this.f25452o;
                if (j3 != -1 && j2 > j3) {
                    throw new ProtocolException("expected " + this.f25452o + " bytes but received " + j2);
                }
                this.f25448k = j2;
                if (j2 == j3) {
                    m10175a(null);
                }
                return jMo10176i0;
            } catch (IOException e) {
                throw m10175a(e);
            }
        }
    }

    public Exchange(RealCall realCall, EventListener eventListener, ExchangeFinder exchangeFinder, ExchangeCodec exchangeCodec) {
        Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(eventListener, "eventListener");
        Intrinsics3.checkParameterIsNotNull(exchangeFinder, "finder");
        Intrinsics3.checkParameterIsNotNull(exchangeCodec, "codec");
        this.f25439c = realCall;
        this.f25440d = eventListener;
        this.f25441e = exchangeFinder;
        this.f25442f = exchangeCodec;
        this.f25438b = exchangeCodec.mo10217e();
    }

    /* JADX INFO: renamed from: a */
    public final <E extends IOException> E m10167a(long j, boolean z2, boolean z3, E e) {
        if (e != null) {
            m10173g(e);
        }
        if (z3) {
            if (e != null) {
                EventListener eventListener = this.f25440d;
                RealCall realCall = this.f25439c;
                Objects.requireNonNull(eventListener);
                Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
                Intrinsics3.checkParameterIsNotNull(e, "ioe");
            } else {
                EventListener eventListener2 = this.f25440d;
                RealCall realCall2 = this.f25439c;
                Objects.requireNonNull(eventListener2);
                Intrinsics3.checkParameterIsNotNull(realCall2, NotificationCompat.CATEGORY_CALL);
            }
        }
        if (z2) {
            if (e != null) {
                EventListener eventListener3 = this.f25440d;
                RealCall realCall3 = this.f25439c;
                Objects.requireNonNull(eventListener3);
                Intrinsics3.checkParameterIsNotNull(realCall3, NotificationCompat.CATEGORY_CALL);
                Intrinsics3.checkParameterIsNotNull(e, "ioe");
            } else {
                EventListener eventListener4 = this.f25440d;
                RealCall realCall4 = this.f25439c;
                Objects.requireNonNull(eventListener4);
                Intrinsics3.checkParameterIsNotNull(realCall4, NotificationCompat.CATEGORY_CALL);
            }
        }
        return (E) this.f25439c.m10186k(this, z3, z2, e);
    }

    /* JADX INFO: renamed from: b */
    public final Sink m10168b(Request request, boolean z2) throws IOException {
        Intrinsics3.checkParameterIsNotNull(request, "request");
        this.f25437a = z2;
        RequestBody requestBody = request.body;
        if (requestBody == null) {
            Intrinsics3.throwNpe();
        }
        long jContentLength = requestBody.contentLength();
        EventListener eventListener = this.f25440d;
        RealCall realCall = this.f25439c;
        Objects.requireNonNull(eventListener);
        Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
        return new a(this, this.f25442f.mo10220h(request, jContentLength), jContentLength);
    }

    /* JADX INFO: renamed from: c */
    public final void m10169c() throws IOException {
        try {
            this.f25442f.mo10218f();
        } catch (IOException e) {
            EventListener eventListener = this.f25440d;
            RealCall realCall = this.f25439c;
            Objects.requireNonNull(eventListener);
            Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(e, "ioe");
            m10173g(e);
            throw e;
        }
    }

    /* JADX INFO: renamed from: d */
    public final RealWebSocket.c m10170d() throws SocketException {
        this.f25439c.m10189n();
        RealConnection4 realConnection4Mo10217e = this.f25442f.mo10217e();
        Objects.requireNonNull(realConnection4Mo10217e);
        Intrinsics3.checkParameterIsNotNull(this, "exchange");
        Socket socket = realConnection4Mo10217e.f25492c;
        if (socket == null) {
            Intrinsics3.throwNpe();
        }
        BufferedSource bufferedSource = realConnection4Mo10217e.f25496g;
        if (bufferedSource == null) {
            Intrinsics3.throwNpe();
        }
        BufferedSink bufferedSink = realConnection4Mo10217e.f25497h;
        if (bufferedSink == null) {
            Intrinsics3.throwNpe();
        }
        socket.setSoTimeout(0);
        realConnection4Mo10217e.m10203l();
        return new RealConnection3(this, bufferedSource, bufferedSink, true, bufferedSource, bufferedSink);
    }

    /* JADX INFO: renamed from: e */
    public final Response.C12937a m10171e(boolean z2) throws IOException {
        try {
            Response.C12937a c12937aMo10216d = this.f25442f.mo10216d(z2);
            if (c12937aMo10216d != null) {
                Intrinsics3.checkParameterIsNotNull(this, "deferredTrailers");
                c12937aMo10216d.f27577m = this;
            }
            return c12937aMo10216d;
        } catch (IOException e) {
            EventListener eventListener = this.f25440d;
            RealCall realCall = this.f25439c;
            Objects.requireNonNull(eventListener);
            Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(e, "ioe");
            m10173g(e);
            throw e;
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m10172f() {
        EventListener eventListener = this.f25440d;
        RealCall realCall = this.f25439c;
        Objects.requireNonNull(eventListener);
        Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
    }

    /* JADX INFO: renamed from: g */
    public final void m10173g(IOException iOException) {
        this.f25441e.m10179c(iOException);
        RealConnection4 realConnection4Mo10217e = this.f25442f.mo10217e();
        RealCall realCall = this.f25439c;
        synchronized (realConnection4Mo10217e) {
            Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
            if (iOException instanceof StreamResetException) {
                if (((StreamResetException) iOException).errorCode == ErrorCode2.REFUSED_STREAM) {
                    int i = realConnection4Mo10217e.f25502m + 1;
                    realConnection4Mo10217e.f25502m = i;
                    if (i > 1) {
                        realConnection4Mo10217e.f25498i = true;
                        realConnection4Mo10217e.f25500k++;
                    }
                } else if (((StreamResetException) iOException).errorCode != ErrorCode2.CANCEL || !realCall.f25477v) {
                    realConnection4Mo10217e.f25498i = true;
                    realConnection4Mo10217e.f25500k++;
                }
            } else if (!realConnection4Mo10217e.m10201j() || (iOException instanceof ConnectionShutdownException)) {
                realConnection4Mo10217e.f25498i = true;
                if (realConnection4Mo10217e.f25501l == 0) {
                    realConnection4Mo10217e.m10195d(realCall.f25480y, realConnection4Mo10217e.f25506q, iOException);
                    realConnection4Mo10217e.f25500k++;
                }
            }
        }
    }
}
