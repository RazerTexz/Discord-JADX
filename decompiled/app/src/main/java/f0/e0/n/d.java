package f0.e0.n;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.adjust.sdk.Constants;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.g0.t;
import d0.t.m;
import f0.e0.n.h;
import f0.y;
import g0.e;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.BufferedSink;
import okio.ByteString;

/* compiled from: RealWebSocket.kt */
/* loaded from: classes3.dex */
public final class d implements WebSocket, h.a {
    public static final List<y> a = m.listOf(y.HTTP_1_1);

    /* renamed from: b, reason: collision with root package name */
    public final String f3656b;
    public f0.e c;
    public f0.e0.f.a d;
    public h e;
    public i f;
    public f0.e0.f.c g;
    public String h;
    public c i;
    public final ArrayDeque<ByteString> j;
    public final ArrayDeque<Object> k;
    public long l;
    public boolean m;
    public int n;
    public String o;
    public boolean p;
    public int q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f3657s;
    public boolean t;
    public final Request u;
    public final WebSocketListener v;
    public final Random w;

    /* renamed from: x, reason: collision with root package name */
    public final long f3658x;

    /* renamed from: y, reason: collision with root package name */
    public f0.e0.n.f f3659y;

    /* renamed from: z, reason: collision with root package name */
    public long f3660z;

    /* compiled from: RealWebSocket.kt */
    public static final class a {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final ByteString f3661b;
        public final long c;

        public a(int i, ByteString byteString, long j) {
            this.a = i;
            this.f3661b = byteString;
            this.c = j;
        }
    }

    /* compiled from: RealWebSocket.kt */
    public static final class b {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final ByteString f3662b;

        public b(int i, ByteString byteString) {
            d0.z.d.m.checkParameterIsNotNull(byteString, "data");
            this.a = i;
            this.f3662b = byteString;
        }
    }

    /* compiled from: RealWebSocket.kt */
    public static abstract class c implements Closeable {
        public final boolean j;
        public final g0.g k;
        public final BufferedSink l;

        public c(boolean z2, g0.g gVar, BufferedSink bufferedSink) {
            d0.z.d.m.checkParameterIsNotNull(gVar, "source");
            d0.z.d.m.checkParameterIsNotNull(bufferedSink, "sink");
            this.j = z2;
            this.k = gVar;
            this.l = bufferedSink;
        }
    }

    /* compiled from: RealWebSocket.kt */
    /* renamed from: f0.e0.n.d$d, reason: collision with other inner class name */
    public final class C0610d extends f0.e0.f.a {
        public C0610d() {
            super(b.d.b.a.a.J(new StringBuilder(), d.this.h, " writer"), false, 2);
        }

        @Override // f0.e0.f.a
        public long a() {
            try {
                return d.this.m() ? 0L : -1L;
            } catch (IOException e) {
                d.this.i(e, null);
                return -1L;
            }
        }
    }

    /* compiled from: TaskQueue.kt */
    public static final class e extends f0.e0.f.a {
        public final /* synthetic */ long e;
        public final /* synthetic */ d f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, String str2, long j, d dVar, String str3, c cVar, f0.e0.n.f fVar) {
            super(str2, true);
            this.e = j;
            this.f = dVar;
        }

        @Override // f0.e0.f.a
        public long a() {
            i iVar;
            d dVar = this.f;
            synchronized (dVar) {
                if (!dVar.p && (iVar = dVar.f) != null) {
                    int i = dVar.t ? dVar.q : -1;
                    dVar.q++;
                    dVar.t = true;
                    if (i != -1) {
                        StringBuilder sbU = b.d.b.a.a.U("sent ping but didn't receive pong within ");
                        sbU.append(dVar.f3658x);
                        sbU.append("ms (after ");
                        sbU.append(i - 1);
                        sbU.append(" successful ping/pongs)");
                        dVar.i(new SocketTimeoutException(sbU.toString()), null);
                    } else {
                        try {
                            ByteString byteString = ByteString.j;
                            d0.z.d.m.checkParameterIsNotNull(byteString, "payload");
                            iVar.b(9, byteString);
                        } catch (IOException e) {
                            dVar.i(e, null);
                        }
                    }
                }
            }
            return this.e;
        }
    }

    /* compiled from: TaskQueue.kt */
    public static final class f extends f0.e0.f.a {
        public final /* synthetic */ d e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, boolean z2, String str2, boolean z3, d dVar, i iVar, ByteString byteString, Ref$ObjectRef ref$ObjectRef, Ref$IntRef ref$IntRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$ObjectRef ref$ObjectRef4, Ref$ObjectRef ref$ObjectRef5) {
            super(str2, z3);
            this.e = dVar;
        }

        @Override // f0.e0.f.a
        public long a() {
            f0.e eVar = this.e.c;
            if (eVar == null) {
                d0.z.d.m.throwNpe();
            }
            eVar.cancel();
            return -1L;
        }
    }

    public d(f0.e0.f.d dVar, Request request, WebSocketListener webSocketListener, Random random, long j, f0.e0.n.f fVar, long j2) {
        d0.z.d.m.checkParameterIsNotNull(dVar, "taskRunner");
        d0.z.d.m.checkParameterIsNotNull(request, "originalRequest");
        d0.z.d.m.checkParameterIsNotNull(webSocketListener, "listener");
        d0.z.d.m.checkParameterIsNotNull(random, "random");
        this.u = request;
        this.v = webSocketListener;
        this.w = random;
        this.f3658x = j;
        this.f3659y = null;
        this.f3660z = j2;
        this.g = dVar.f();
        this.j = new ArrayDeque<>();
        this.k = new ArrayDeque<>();
        this.n = -1;
        if (!d0.z.d.m.areEqual(ShareTarget.METHOD_GET, request.method)) {
            StringBuilder sbU = b.d.b.a.a.U("Request must be GET: ");
            sbU.append(request.method);
            throw new IllegalArgumentException(sbU.toString().toString());
        }
        ByteString.Companion companion = ByteString.INSTANCE;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.f3656b = ByteString.Companion.d(companion, bArr, 0, 0, 3).f();
    }

    @Override // okhttp3.WebSocket
    public boolean a(String str) {
        d0.z.d.m.checkParameterIsNotNull(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        ByteString byteStringC = ByteString.INSTANCE.c(str);
        synchronized (this) {
            if (!this.p && !this.m) {
                if (this.l + byteStringC.j() > Permission.MOVE_MEMBERS) {
                    e(PointerIconCompat.TYPE_CONTEXT_MENU, null);
                    return false;
                }
                this.l += byteStringC.j();
                this.k.add(new b(1, byteStringC));
                l();
                return true;
            }
            return false;
        }
    }

    @Override // f0.e0.n.h.a
    public void b(ByteString byteString) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(byteString, "bytes");
        this.v.onMessage(this, byteString);
    }

    @Override // f0.e0.n.h.a
    public void c(String str) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.v.onMessage(this, str);
    }

    @Override // f0.e0.n.h.a
    public synchronized void d(ByteString byteString) {
        d0.z.d.m.checkParameterIsNotNull(byteString, "payload");
        if (!this.p && (!this.m || !this.k.isEmpty())) {
            this.j.add(byteString);
            l();
            this.r++;
        }
    }

    @Override // okhttp3.WebSocket
    public boolean e(int i, String str) {
        String str2;
        synchronized (this) {
            ByteString byteStringC = null;
            if (i < 1000 || i >= 5000) {
                str2 = "Code must be in range [1000,5000): " + i;
            } else if ((1004 > i || 1006 < i) && (1015 > i || 2999 < i)) {
                str2 = null;
            } else {
                str2 = "Code " + i + " is reserved and may not be used.";
            }
            if (!(str2 == null)) {
                if (str2 == null) {
                    d0.z.d.m.throwNpe();
                }
                throw new IllegalArgumentException(str2.toString());
            }
            if (str != null) {
                byteStringC = ByteString.INSTANCE.c(str);
                if (!(((long) byteStringC.j()) <= 123)) {
                    throw new IllegalArgumentException(("reason.size() > 123: " + str).toString());
                }
            }
            if (!this.p && !this.m) {
                this.m = true;
                this.k.add(new a(i, byteStringC, 60000L));
                l();
                return true;
            }
            return false;
        }
    }

    @Override // f0.e0.n.h.a
    public synchronized void f(ByteString byteString) {
        d0.z.d.m.checkParameterIsNotNull(byteString, "payload");
        this.f3657s++;
        this.t = false;
    }

    @Override // f0.e0.n.h.a
    public void g(int i, String str) {
        c cVar;
        h hVar;
        i iVar;
        d0.z.d.m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        if (!(i != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            if (!(this.n == -1)) {
                throw new IllegalStateException("already closed".toString());
            }
            this.n = i;
            this.o = str;
            cVar = null;
            if (this.m && this.k.isEmpty()) {
                c cVar2 = this.i;
                this.i = null;
                hVar = this.e;
                this.e = null;
                iVar = this.f;
                this.f = null;
                this.g.f();
                cVar = cVar2;
            } else {
                hVar = null;
                iVar = null;
            }
        }
        try {
            this.v.onClosing(this, i, str);
            if (cVar != null) {
                this.v.onClosed(this, i, str);
            }
            if (cVar != null) {
                byte[] bArr = f0.e0.c.a;
                d0.z.d.m.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                try {
                    cVar.close();
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception unused) {
                }
            }
            if (hVar != null) {
                byte[] bArr2 = f0.e0.c.a;
                d0.z.d.m.checkParameterIsNotNull(hVar, "$this$closeQuietly");
                try {
                    hVar.close();
                } catch (RuntimeException e3) {
                    throw e3;
                } catch (Exception unused2) {
                }
            }
            if (iVar != null) {
                byte[] bArr3 = f0.e0.c.a;
                d0.z.d.m.checkParameterIsNotNull(iVar, "$this$closeQuietly");
                try {
                    iVar.close();
                } catch (RuntimeException e4) {
                    throw e4;
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            if (cVar != null) {
                byte[] bArr4 = f0.e0.c.a;
                d0.z.d.m.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                try {
                    cVar.close();
                } catch (RuntimeException e5) {
                    throw e5;
                } catch (Exception unused4) {
                }
            }
            if (hVar != null) {
                byte[] bArr5 = f0.e0.c.a;
                d0.z.d.m.checkParameterIsNotNull(hVar, "$this$closeQuietly");
                try {
                    hVar.close();
                } catch (RuntimeException e6) {
                    throw e6;
                } catch (Exception unused5) {
                }
            }
            if (iVar == null) {
                throw th;
            }
            byte[] bArr6 = f0.e0.c.a;
            d0.z.d.m.checkParameterIsNotNull(iVar, "$this$closeQuietly");
            try {
                iVar.close();
                throw th;
            } catch (RuntimeException e7) {
                throw e7;
            } catch (Exception unused6) {
                throw th;
            }
        }
    }

    public final void h(Response response, f0.e0.g.c cVar) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(response, "response");
        if (response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String != 101) {
            StringBuilder sbU = b.d.b.a.a.U("Expected HTTP 101 response but was '");
            sbU.append(response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String);
            sbU.append(' ');
            throw new ProtocolException(b.d.b.a.a.H(sbU, response.message, '\''));
        }
        String strA = Response.a(response, "Connection", null, 2);
        if (!t.equals("Upgrade", strA, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strA + '\'');
        }
        String strA2 = Response.a(response, "Upgrade", null, 2);
        if (!t.equals("websocket", strA2, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strA2 + '\'');
        }
        String strA3 = Response.a(response, "Sec-WebSocket-Accept", null, 2);
        String strF = ByteString.INSTANCE.c(this.f3656b + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").g(Constants.SHA1).f();
        if (!(!d0.z.d.m.areEqual(strF, strA3))) {
            if (cVar == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strF + "' but was '" + strA3 + '\'');
    }

    public final void i(Exception exc, Response response) {
        d0.z.d.m.checkParameterIsNotNull(exc, "e");
        synchronized (this) {
            if (this.p) {
                return;
            }
            this.p = true;
            c cVar = this.i;
            this.i = null;
            h hVar = this.e;
            this.e = null;
            i iVar = this.f;
            this.f = null;
            this.g.f();
            try {
                this.v.onFailure(this, exc, response);
                if (cVar != null) {
                    byte[] bArr = f0.e0.c.a;
                    d0.z.d.m.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                    try {
                        cVar.close();
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused) {
                    }
                }
                if (hVar != null) {
                    byte[] bArr2 = f0.e0.c.a;
                    d0.z.d.m.checkParameterIsNotNull(hVar, "$this$closeQuietly");
                    try {
                        hVar.close();
                    } catch (RuntimeException e3) {
                        throw e3;
                    } catch (Exception unused2) {
                    }
                }
                if (iVar != null) {
                    byte[] bArr3 = f0.e0.c.a;
                    d0.z.d.m.checkParameterIsNotNull(iVar, "$this$closeQuietly");
                    try {
                        iVar.close();
                    } catch (RuntimeException e4) {
                        throw e4;
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                if (cVar != null) {
                    byte[] bArr4 = f0.e0.c.a;
                    d0.z.d.m.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                    try {
                        cVar.close();
                    } catch (RuntimeException e5) {
                        throw e5;
                    } catch (Exception unused4) {
                    }
                }
                if (hVar != null) {
                    byte[] bArr5 = f0.e0.c.a;
                    d0.z.d.m.checkParameterIsNotNull(hVar, "$this$closeQuietly");
                    try {
                        hVar.close();
                    } catch (RuntimeException e6) {
                        throw e6;
                    } catch (Exception unused5) {
                    }
                }
                if (iVar == null) {
                    throw th;
                }
                byte[] bArr6 = f0.e0.c.a;
                d0.z.d.m.checkParameterIsNotNull(iVar, "$this$closeQuietly");
                try {
                    iVar.close();
                    throw th;
                } catch (RuntimeException e7) {
                    throw e7;
                } catch (Exception unused6) {
                    throw th;
                }
            }
        }
    }

    public final void j(String str, c cVar) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkParameterIsNotNull(cVar, "streams");
        f0.e0.n.f fVar = this.f3659y;
        if (fVar == null) {
            d0.z.d.m.throwNpe();
        }
        synchronized (this) {
            this.h = str;
            this.i = cVar;
            boolean z2 = cVar.j;
            this.f = new i(z2, cVar.l, this.w, fVar.a, z2 ? fVar.c : fVar.e, this.f3660z);
            this.d = new C0610d();
            long j = this.f3658x;
            if (j != 0) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(j);
                String str2 = str + " ping";
                this.g.c(new e(str2, str2, nanos, this, str, cVar, fVar), nanos);
            }
            if (!this.k.isEmpty()) {
                l();
            }
        }
        boolean z3 = cVar.j;
        this.e = new h(z3, cVar.k, this, fVar.a, z3 ^ true ? fVar.c : fVar.e);
    }

    public final void k() throws IOException {
        while (this.n == -1) {
            h hVar = this.e;
            if (hVar == null) {
                d0.z.d.m.throwNpe();
            }
            hVar.b();
            if (!hVar.n) {
                int i = hVar.k;
                if (i != 1 && i != 2) {
                    StringBuilder sbU = b.d.b.a.a.U("Unknown opcode: ");
                    sbU.append(f0.e0.c.x(i));
                    throw new ProtocolException(sbU.toString());
                }
                while (!hVar.j) {
                    long j = hVar.l;
                    if (j > 0) {
                        hVar.v.B(hVar.q, j);
                        if (!hVar.u) {
                            g0.e eVar = hVar.q;
                            e.a aVar = hVar.t;
                            if (aVar == null) {
                                d0.z.d.m.throwNpe();
                            }
                            eVar.u(aVar);
                            hVar.t.b(hVar.q.k - hVar.l);
                            e.a aVar2 = hVar.t;
                            byte[] bArr = hVar.f3665s;
                            if (bArr == null) {
                                d0.z.d.m.throwNpe();
                            }
                            g.a(aVar2, bArr);
                            hVar.t.close();
                        }
                    }
                    if (hVar.m) {
                        if (hVar.o) {
                            f0.e0.n.c cVar = hVar.r;
                            if (cVar == null) {
                                cVar = new f0.e0.n.c(hVar.f3667y);
                                hVar.r = cVar;
                            }
                            g0.e eVar2 = hVar.q;
                            d0.z.d.m.checkParameterIsNotNull(eVar2, "buffer");
                            if (!(cVar.j.k == 0)) {
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            if (cVar.m) {
                                cVar.k.reset();
                            }
                            cVar.j.P(eVar2);
                            cVar.j.W(65535);
                            long bytesRead = cVar.k.getBytesRead() + cVar.j.k;
                            do {
                                cVar.l.a(eVar2, RecyclerView.FOREVER_NS);
                            } while (cVar.k.getBytesRead() < bytesRead);
                        }
                        if (i == 1) {
                            hVar.w.c(hVar.q.D());
                        } else {
                            hVar.w.b(hVar.q.x());
                        }
                    } else {
                        while (!hVar.j) {
                            hVar.b();
                            if (!hVar.n) {
                                break;
                            } else {
                                hVar.a();
                            }
                        }
                        if (hVar.k != 0) {
                            StringBuilder sbU2 = b.d.b.a.a.U("Expected continuation opcode. Got: ");
                            sbU2.append(f0.e0.c.x(hVar.k));
                            throw new ProtocolException(sbU2.toString());
                        }
                    }
                }
                throw new IOException("closed");
            }
            hVar.a();
        }
    }

    public final void l() {
        byte[] bArr = f0.e0.c.a;
        f0.e0.f.a aVar = this.d;
        if (aVar != null) {
            this.g.c(aVar, 0L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a3  */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12, types: [f0.e0.n.i] */
    /* JADX WARN: Type inference failed for: r1v15, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v25, types: [T, f0.e0.n.d$c] */
    /* JADX WARN: Type inference failed for: r2v26, types: [T, f0.e0.n.h] */
    /* JADX WARN: Type inference failed for: r2v27, types: [T, f0.e0.n.i] */
    /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v16, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, okio.ByteString] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m() throws Throwable {
        ByteString byteString;
        i iVar;
        Ref$ObjectRef ref$ObjectRef;
        Ref$ObjectRef ref$ObjectRef2;
        Ref$ObjectRef ref$ObjectRef3;
        Ref$ObjectRef ref$ObjectRef4;
        Ref$IntRef ref$IntRef;
        Ref$ObjectRef ref$ObjectRef5;
        Ref$ObjectRef ref$ObjectRef6;
        Ref$ObjectRef ref$ObjectRef7;
        c cVar;
        h hVar;
        i iVar2;
        Ref$ObjectRef ref$ObjectRef8 = new Ref$ObjectRef();
        ref$ObjectRef8.element = null;
        Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        ref$IntRef2.element = -1;
        Ref$ObjectRef ref$ObjectRef9 = new Ref$ObjectRef();
        ref$ObjectRef9.element = null;
        Ref$ObjectRef ref$ObjectRef10 = new Ref$ObjectRef();
        ref$ObjectRef10.element = null;
        Ref$ObjectRef ref$ObjectRef11 = new Ref$ObjectRef();
        ref$ObjectRef11.element = null;
        Ref$ObjectRef ref$ObjectRef12 = new Ref$ObjectRef();
        ref$ObjectRef12.element = null;
        synchronized (this) {
            if (this.p) {
                return false;
            }
            i iVar3 = this.f;
            ByteString byteStringPoll = this.j.poll();
            if (byteStringPoll == null) {
                ?? Poll = this.k.poll();
                ref$ObjectRef8.element = Poll;
                if (Poll instanceof a) {
                    int i = this.n;
                    ref$IntRef2.element = i;
                    ref$ObjectRef9.element = this.o;
                    if (i != -1) {
                        ref$ObjectRef10.element = this.i;
                        this.i = null;
                        ref$ObjectRef11.element = this.e;
                        this.e = null;
                        ref$ObjectRef12.element = this.f;
                        this.f = null;
                        this.g.f();
                        byteString = byteStringPoll;
                        iVar = iVar3;
                        ref$ObjectRef = ref$ObjectRef12;
                        ref$ObjectRef2 = ref$ObjectRef11;
                        ref$ObjectRef3 = ref$ObjectRef10;
                        ref$ObjectRef4 = ref$ObjectRef9;
                        ref$IntRef = ref$IntRef2;
                    } else {
                        T t = ref$ObjectRef8.element;
                        if (t == 0) {
                            throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
                        }
                        long j = ((a) t).c;
                        f0.e0.f.c cVar2 = this.g;
                        String str = this.h + " cancel";
                        byteString = byteStringPoll;
                        iVar = iVar3;
                        ref$ObjectRef = ref$ObjectRef12;
                        ref$ObjectRef2 = ref$ObjectRef11;
                        ref$ObjectRef3 = ref$ObjectRef10;
                        ref$ObjectRef4 = ref$ObjectRef9;
                        ref$IntRef = ref$IntRef2;
                        cVar2.c(new f(str, true, str, true, this, iVar3, byteStringPoll, ref$ObjectRef8, ref$IntRef2, ref$ObjectRef9, ref$ObjectRef10, ref$ObjectRef2, ref$ObjectRef), TimeUnit.MILLISECONDS.toNanos(j));
                    }
                } else {
                    byteString = byteStringPoll;
                    iVar = iVar3;
                    ref$ObjectRef = ref$ObjectRef12;
                    ref$ObjectRef2 = ref$ObjectRef11;
                    ref$ObjectRef3 = ref$ObjectRef10;
                    ref$ObjectRef4 = ref$ObjectRef9;
                    ref$IntRef = ref$IntRef2;
                    if (Poll == 0) {
                        return false;
                    }
                }
            } else {
                byteString = byteStringPoll;
                iVar = iVar3;
                ref$ObjectRef = ref$ObjectRef12;
                ref$ObjectRef2 = ref$ObjectRef11;
                ref$ObjectRef3 = ref$ObjectRef10;
                ref$ObjectRef4 = ref$ObjectRef9;
                ref$IntRef = ref$IntRef2;
            }
            Ref$ObjectRef ref$ObjectRef13 = byteString;
            try {
                if (ref$ObjectRef13 != 0) {
                    i iVar4 = iVar;
                    if (iVar4 == 0) {
                        d0.z.d.m.throwNpe();
                    }
                    Objects.requireNonNull(iVar4);
                    d0.z.d.m.checkParameterIsNotNull(ref$ObjectRef13, "payload");
                    iVar4.b(10, ref$ObjectRef13);
                } else {
                    ref$ObjectRef6 = iVar;
                    T t2 = ref$ObjectRef8.element;
                    if (!(t2 instanceof b)) {
                        ref$ObjectRef5 = t2 instanceof a;
                        try {
                            if (ref$ObjectRef5 == 0) {
                                throw new AssertionError();
                            }
                            if (t2 == 0) {
                                throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
                            }
                            a aVar = (a) t2;
                            if (ref$ObjectRef6 == 0) {
                                d0.z.d.m.throwNpe();
                            }
                            ref$ObjectRef6.a(aVar.a, aVar.f3661b);
                            ref$ObjectRef6 = ref$ObjectRef3;
                            try {
                                c cVar3 = (c) ref$ObjectRef6.element;
                                ref$ObjectRef7 = ref$ObjectRef6;
                                if (cVar3 != null) {
                                    WebSocketListener webSocketListener = this.v;
                                    int i2 = ref$IntRef.element;
                                    String str2 = (String) ref$ObjectRef4.element;
                                    if (str2 == null) {
                                        d0.z.d.m.throwNpe();
                                    }
                                    webSocketListener.onClosed(this, i2, str2);
                                    ref$ObjectRef7 = ref$ObjectRef6;
                                }
                                cVar = (c) ref$ObjectRef7.element;
                                if (cVar != null) {
                                    byte[] bArr = f0.e0.c.a;
                                    d0.z.d.m.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                                    try {
                                        cVar.close();
                                    } catch (RuntimeException e2) {
                                        throw e2;
                                    } catch (Exception unused) {
                                    }
                                }
                                hVar = (h) ref$ObjectRef2.element;
                                if (hVar != null) {
                                    byte[] bArr2 = f0.e0.c.a;
                                    d0.z.d.m.checkParameterIsNotNull(hVar, "$this$closeQuietly");
                                    try {
                                        hVar.close();
                                    } catch (RuntimeException e3) {
                                        throw e3;
                                    } catch (Exception unused2) {
                                    }
                                }
                                iVar2 = (i) ref$ObjectRef.element;
                                if (iVar2 != null) {
                                    byte[] bArr3 = f0.e0.c.a;
                                    d0.z.d.m.checkParameterIsNotNull(iVar2, "$this$closeQuietly");
                                    try {
                                        iVar2.close();
                                    } catch (RuntimeException e4) {
                                        throw e4;
                                    } catch (Exception unused3) {
                                    }
                                }
                                return true;
                            } catch (Throwable th) {
                                th = th;
                                ref$ObjectRef13 = ref$ObjectRef;
                                ref$ObjectRef5 = ref$ObjectRef2;
                                c cVar4 = (c) ref$ObjectRef6.element;
                                if (cVar4 != null) {
                                    byte[] bArr4 = f0.e0.c.a;
                                    d0.z.d.m.checkParameterIsNotNull(cVar4, "$this$closeQuietly");
                                    try {
                                        cVar4.close();
                                    } catch (RuntimeException e5) {
                                        throw e5;
                                    } catch (Exception unused4) {
                                    }
                                }
                                h hVar2 = (h) ref$ObjectRef5.element;
                                if (hVar2 != null) {
                                    byte[] bArr5 = f0.e0.c.a;
                                    d0.z.d.m.checkParameterIsNotNull(hVar2, "$this$closeQuietly");
                                    try {
                                        hVar2.close();
                                    } catch (RuntimeException e6) {
                                        throw e6;
                                    } catch (Exception unused5) {
                                    }
                                }
                                i iVar5 = (i) ref$ObjectRef13.element;
                                if (iVar5 == null) {
                                    throw th;
                                }
                                byte[] bArr6 = f0.e0.c.a;
                                d0.z.d.m.checkParameterIsNotNull(iVar5, "$this$closeQuietly");
                                try {
                                    iVar5.close();
                                    throw th;
                                } catch (RuntimeException e7) {
                                    throw e7;
                                } catch (Exception unused6) {
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } else {
                        if (t2 == 0) {
                            throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");
                        }
                        b bVar = (b) t2;
                        if (ref$ObjectRef6 == 0) {
                            d0.z.d.m.throwNpe();
                        }
                        ref$ObjectRef6.c(bVar.a, bVar.f3662b);
                        synchronized (this) {
                            this.l -= bVar.f3662b.j();
                        }
                    }
                }
                ref$ObjectRef7 = ref$ObjectRef3;
                cVar = (c) ref$ObjectRef7.element;
                if (cVar != null) {
                }
                hVar = (h) ref$ObjectRef2.element;
                if (hVar != null) {
                }
                iVar2 = (i) ref$ObjectRef.element;
                if (iVar2 != null) {
                }
                return true;
            } catch (Throwable th3) {
                th = th3;
                ref$ObjectRef13 = ref$ObjectRef;
                ref$ObjectRef5 = ref$ObjectRef2;
                ref$ObjectRef6 = ref$ObjectRef3;
            }
        }
    }
}
