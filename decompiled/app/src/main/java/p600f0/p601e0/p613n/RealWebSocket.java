package p600f0.p601e0.p613n;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.adjust.sdk.Constants;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
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
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Call2;
import p600f0.Protocol2;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p604f.Task2;
import p600f0.p601e0.p604f.TaskQueue2;
import p600f0.p601e0.p604f.TaskRunner;
import p600f0.p601e0.p605g.Exchange;
import p600f0.p601e0.p613n.WebSocketReader;
import p615g0.Buffer3;
import p615g0.BufferedSource;

/* JADX INFO: renamed from: f0.e0.n.d, reason: use source file name */
/* JADX INFO: compiled from: RealWebSocket.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.a {

    /* JADX INFO: renamed from: a */
    public static final List<Protocol2> f25821a = CollectionsJVM.listOf(Protocol2.HTTP_1_1);

    /* JADX INFO: renamed from: b */
    public final String f25822b;

    /* JADX INFO: renamed from: c */
    public Call2 f25823c;

    /* JADX INFO: renamed from: d */
    public Task2 f25824d;

    /* JADX INFO: renamed from: e */
    public WebSocketReader f25825e;

    /* JADX INFO: renamed from: f */
    public WebSocketWriter f25826f;

    /* JADX INFO: renamed from: g */
    public TaskQueue2 f25827g;

    /* JADX INFO: renamed from: h */
    public String f25828h;

    /* JADX INFO: renamed from: i */
    public c f25829i;

    /* JADX INFO: renamed from: j */
    public final ArrayDeque<ByteString> f25830j;

    /* JADX INFO: renamed from: k */
    public final ArrayDeque<Object> f25831k;

    /* JADX INFO: renamed from: l */
    public long f25832l;

    /* JADX INFO: renamed from: m */
    public boolean f25833m;

    /* JADX INFO: renamed from: n */
    public int f25834n;

    /* JADX INFO: renamed from: o */
    public String f25835o;

    /* JADX INFO: renamed from: p */
    public boolean f25836p;

    /* JADX INFO: renamed from: q */
    public int f25837q;

    /* JADX INFO: renamed from: r */
    public int f25838r;

    /* JADX INFO: renamed from: s */
    public int f25839s;

    /* JADX INFO: renamed from: t */
    public boolean f25840t;

    /* JADX INFO: renamed from: u */
    public final Request f25841u;

    /* JADX INFO: renamed from: v */
    public final WebSocketListener f25842v;

    /* JADX INFO: renamed from: w */
    public final Random f25843w;

    /* JADX INFO: renamed from: x */
    public final long f25844x;

    /* JADX INFO: renamed from: y */
    public WebSocketExtensions f25845y;

    /* JADX INFO: renamed from: z */
    public long f25846z;

    /* JADX INFO: renamed from: f0.e0.n.d$a */
    /* JADX INFO: compiled from: RealWebSocket.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final int f25847a;

        /* JADX INFO: renamed from: b */
        public final ByteString f25848b;

        /* JADX INFO: renamed from: c */
        public final long f25849c;

        public a(int i, ByteString byteString, long j) {
            this.f25847a = i;
            this.f25848b = byteString;
            this.f25849c = j;
        }
    }

    /* JADX INFO: renamed from: f0.e0.n.d$b */
    /* JADX INFO: compiled from: RealWebSocket.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final int f25850a;

        /* JADX INFO: renamed from: b */
        public final ByteString f25851b;

        public b(int i, ByteString byteString) {
            Intrinsics3.checkParameterIsNotNull(byteString, "data");
            this.f25850a = i;
            this.f25851b = byteString;
        }
    }

    /* JADX INFO: renamed from: f0.e0.n.d$c */
    /* JADX INFO: compiled from: RealWebSocket.kt */
    public static abstract class c implements Closeable {

        /* JADX INFO: renamed from: j */
        public final boolean f25852j;

        /* JADX INFO: renamed from: k */
        public final BufferedSource f25853k;

        /* JADX INFO: renamed from: l */
        public final BufferedSink f25854l;

        public c(boolean z2, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
            Intrinsics3.checkParameterIsNotNull(bufferedSink, "sink");
            this.f25852j = z2;
            this.f25853k = bufferedSource;
            this.f25854l = bufferedSink;
        }
    }

    /* JADX INFO: renamed from: f0.e0.n.d$d */
    /* JADX INFO: compiled from: RealWebSocket.kt */
    public final class d extends Task2 {
        public d() {
            super(outline.m822J(new StringBuilder(), RealWebSocket.this.f25828h, " writer"), false, 2);
        }

        @Override // p600f0.p601e0.p604f.Task2
        /* JADX INFO: renamed from: a */
        public long mo10150a() {
            try {
                return RealWebSocket.this.m10357m() ? 0L : -1L;
            } catch (IOException e) {
                RealWebSocket.this.m10353i(e, null);
                return -1L;
            }
        }
    }

    /* JADX INFO: renamed from: f0.e0.n.d$e */
    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class e extends Task2 {

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ long f25856e;

        /* JADX INFO: renamed from: f */
        public final /* synthetic */ RealWebSocket f25857f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, String str2, long j, RealWebSocket realWebSocket, String str3, c cVar, WebSocketExtensions webSocketExtensions) {
            super(str2, true);
            this.f25856e = j;
            this.f25857f = realWebSocket;
        }

        @Override // p600f0.p601e0.p604f.Task2
        /* JADX INFO: renamed from: a */
        public long mo10150a() {
            WebSocketWriter webSocketWriter;
            RealWebSocket realWebSocket = this.f25857f;
            synchronized (realWebSocket) {
                if (!realWebSocket.f25836p && (webSocketWriter = realWebSocket.f25826f) != null) {
                    int i = realWebSocket.f25840t ? realWebSocket.f25837q : -1;
                    realWebSocket.f25837q++;
                    realWebSocket.f25840t = true;
                    if (i != -1) {
                        StringBuilder sbM833U = outline.m833U("sent ping but didn't receive pong within ");
                        sbM833U.append(realWebSocket.f25844x);
                        sbM833U.append("ms (after ");
                        sbM833U.append(i - 1);
                        sbM833U.append(" successful ping/pongs)");
                        realWebSocket.m10353i(new SocketTimeoutException(sbM833U.toString()), null);
                    } else {
                        try {
                            ByteString byteString = ByteString.f27592j;
                            Intrinsics3.checkParameterIsNotNull(byteString, "payload");
                            webSocketWriter.m10364b(9, byteString);
                        } catch (IOException e) {
                            realWebSocket.m10353i(e, null);
                        }
                    }
                }
            }
            return this.f25856e;
        }
    }

    /* JADX INFO: renamed from: f0.e0.n.d$f */
    /* JADX INFO: compiled from: TaskQueue.kt */
    public static final class f extends Task2 {

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ RealWebSocket f25858e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, boolean z2, String str2, boolean z3, RealWebSocket realWebSocket, WebSocketWriter webSocketWriter, ByteString byteString, Ref$ObjectRef ref$ObjectRef, Ref$IntRef ref$IntRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$ObjectRef ref$ObjectRef4, Ref$ObjectRef ref$ObjectRef5) {
            super(str2, z3);
            this.f25858e = realWebSocket;
        }

        @Override // p600f0.p601e0.p604f.Task2
        /* JADX INFO: renamed from: a */
        public long mo10150a() {
            Call2 call2 = this.f25858e.f25823c;
            if (call2 == null) {
                Intrinsics3.throwNpe();
            }
            call2.cancel();
            return -1L;
        }
    }

    public RealWebSocket(TaskRunner taskRunner, Request request, WebSocketListener webSocketListener, Random random, long j, WebSocketExtensions webSocketExtensions, long j2) {
        Intrinsics3.checkParameterIsNotNull(taskRunner, "taskRunner");
        Intrinsics3.checkParameterIsNotNull(request, "originalRequest");
        Intrinsics3.checkParameterIsNotNull(webSocketListener, "listener");
        Intrinsics3.checkParameterIsNotNull(random, "random");
        this.f25841u = request;
        this.f25842v = webSocketListener;
        this.f25843w = random;
        this.f25844x = j;
        this.f25845y = null;
        this.f25846z = j2;
        this.f25827g = taskRunner.m10162f();
        this.f25830j = new ArrayDeque<>();
        this.f25831k = new ArrayDeque<>();
        this.f25834n = -1;
        if (!Intrinsics3.areEqual(ShareTarget.METHOD_GET, request.method)) {
            StringBuilder sbM833U = outline.m833U("Request must be GET: ");
            sbM833U.append(request.method);
            throw new IllegalArgumentException(sbM833U.toString().toString());
        }
        ByteString.Companion companion = ByteString.INSTANCE;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.f25822b = ByteString.Companion.m11009d(companion, bArr, 0, 0, 3).mo10500f();
    }

    @Override // okhttp3.WebSocket
    /* JADX INFO: renamed from: a */
    public boolean mo10345a(String str) {
        Intrinsics3.checkParameterIsNotNull(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        ByteString byteStringM11012c = ByteString.INSTANCE.m11012c(str);
        synchronized (this) {
            if (!this.f25836p && !this.f25833m) {
                if (this.f25832l + ((long) byteStringM11012c.mo10502j()) > Permission.MOVE_MEMBERS) {
                    mo10349e(PointerIconCompat.TYPE_CONTEXT_MENU, null);
                    return false;
                }
                this.f25832l += (long) byteStringM11012c.mo10502j();
                this.f25831k.add(new b(1, byteStringM11012c));
                m10356l();
                return true;
            }
            return false;
        }
    }

    @Override // p600f0.p601e0.p613n.WebSocketReader.a
    /* JADX INFO: renamed from: b */
    public void mo10346b(ByteString byteString) throws IOException {
        Intrinsics3.checkParameterIsNotNull(byteString, "bytes");
        this.f25842v.onMessage(this, byteString);
    }

    @Override // p600f0.p601e0.p613n.WebSocketReader.a
    /* JADX INFO: renamed from: c */
    public void mo10347c(String str) throws IOException {
        Intrinsics3.checkParameterIsNotNull(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.f25842v.onMessage(this, str);
    }

    @Override // p600f0.p601e0.p613n.WebSocketReader.a
    /* JADX INFO: renamed from: d */
    public synchronized void mo10348d(ByteString byteString) {
        Intrinsics3.checkParameterIsNotNull(byteString, "payload");
        if (!this.f25836p && (!this.f25833m || !this.f25831k.isEmpty())) {
            this.f25830j.add(byteString);
            m10356l();
            this.f25838r++;
        }
    }

    @Override // okhttp3.WebSocket
    /* JADX INFO: renamed from: e */
    public boolean mo10349e(int i, String str) {
        String str2;
        synchronized (this) {
            ByteString byteStringM11012c = null;
            if (i < 1000 || i >= 5000) {
                str2 = "Code must be in range [1000,5000): " + i;
            } else if ((1004 > i || 1006 < i) && (1015 > i || 2999 < i)) {
                str2 = null;
            } else {
                str2 = "Code " + i + " is reserved and may not be used.";
            }
            if (!(str2 == null)) {
                if (str2 == null) {
                    Intrinsics3.throwNpe();
                }
                throw new IllegalArgumentException(str2.toString());
            }
            if (str != null) {
                byteStringM11012c = ByteString.INSTANCE.m11012c(str);
                if (!(((long) byteStringM11012c.mo10502j()) <= 123)) {
                    throw new IllegalArgumentException(("reason.size() > 123: " + str).toString());
                }
            }
            if (!this.f25836p && !this.f25833m) {
                this.f25833m = true;
                this.f25831k.add(new a(i, byteStringM11012c, 60000L));
                m10356l();
                return true;
            }
            return false;
        }
    }

    @Override // p600f0.p601e0.p613n.WebSocketReader.a
    /* JADX INFO: renamed from: f */
    public synchronized void mo10350f(ByteString byteString) {
        Intrinsics3.checkParameterIsNotNull(byteString, "payload");
        this.f25839s++;
        this.f25840t = false;
    }

    @Override // p600f0.p601e0.p613n.WebSocketReader.a
    /* JADX INFO: renamed from: g */
    public void mo10351g(int i, String str) {
        c cVar;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        if (!(i != -1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            if (!(this.f25834n == -1)) {
                throw new IllegalStateException("already closed".toString());
            }
            this.f25834n = i;
            this.f25835o = str;
            cVar = null;
            if (this.f25833m && this.f25831k.isEmpty()) {
                c cVar2 = this.f25829i;
                this.f25829i = null;
                webSocketReader = this.f25825e;
                this.f25825e = null;
                webSocketWriter = this.f25826f;
                this.f25826f = null;
                this.f25827g.m10156f();
                cVar = cVar2;
            } else {
                webSocketReader = null;
                webSocketWriter = null;
            }
        }
        try {
            this.f25842v.onClosing(this, i, str);
            if (cVar != null) {
                this.f25842v.onClosed(this, i, str);
            }
            if (cVar != null) {
                byte[] bArr = Util7.f25397a;
                Intrinsics3.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                try {
                    cVar.close();
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception unused) {
                }
            }
            if (webSocketReader != null) {
                byte[] bArr2 = Util7.f25397a;
                Intrinsics3.checkParameterIsNotNull(webSocketReader, "$this$closeQuietly");
                try {
                    webSocketReader.close();
                } catch (RuntimeException e3) {
                    throw e3;
                } catch (Exception unused2) {
                }
            }
            if (webSocketWriter != null) {
                byte[] bArr3 = Util7.f25397a;
                Intrinsics3.checkParameterIsNotNull(webSocketWriter, "$this$closeQuietly");
                try {
                    webSocketWriter.close();
                } catch (RuntimeException e4) {
                    throw e4;
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            if (cVar != null) {
                byte[] bArr4 = Util7.f25397a;
                Intrinsics3.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                try {
                    cVar.close();
                } catch (RuntimeException e5) {
                    throw e5;
                } catch (Exception unused4) {
                }
            }
            if (webSocketReader != null) {
                byte[] bArr5 = Util7.f25397a;
                Intrinsics3.checkParameterIsNotNull(webSocketReader, "$this$closeQuietly");
                try {
                    webSocketReader.close();
                } catch (RuntimeException e6) {
                    throw e6;
                } catch (Exception unused5) {
                }
            }
            if (webSocketWriter == null) {
                throw th;
            }
            byte[] bArr6 = Util7.f25397a;
            Intrinsics3.checkParameterIsNotNull(webSocketWriter, "$this$closeQuietly");
            try {
                webSocketWriter.close();
                throw th;
            } catch (RuntimeException e7) {
                throw e7;
            } catch (Exception unused6) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m10352h(Response response, Exchange exchange) throws IOException {
        Intrinsics3.checkParameterIsNotNull(response, "response");
        if (response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String != 101) {
            StringBuilder sbM833U = outline.m833U("Expected HTTP 101 response but was '");
            sbM833U.append(response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String);
            sbM833U.append(' ');
            throw new ProtocolException(outline.m820H(sbM833U, response.message, '\''));
        }
        String strM10989a = Response.m10989a(response, "Connection", null, 2);
        if (!StringsJVM.equals("Upgrade", strM10989a, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strM10989a + '\'');
        }
        String strM10989a2 = Response.m10989a(response, "Upgrade", null, 2);
        if (!StringsJVM.equals("websocket", strM10989a2, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strM10989a2 + '\'');
        }
        String strM10989a3 = Response.m10989a(response, "Sec-WebSocket-Accept", null, 2);
        String strMo10500f = ByteString.INSTANCE.m11012c(this.f25822b + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").mo10501g(Constants.SHA1).mo10500f();
        if (!(!Intrinsics3.areEqual(strMo10500f, strM10989a3))) {
            if (exchange == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strMo10500f + "' but was '" + strM10989a3 + '\'');
    }

    /* JADX INFO: renamed from: i */
    public final void m10353i(Exception exc, Response response) {
        Intrinsics3.checkParameterIsNotNull(exc, "e");
        synchronized (this) {
            if (this.f25836p) {
                return;
            }
            this.f25836p = true;
            c cVar = this.f25829i;
            this.f25829i = null;
            WebSocketReader webSocketReader = this.f25825e;
            this.f25825e = null;
            WebSocketWriter webSocketWriter = this.f25826f;
            this.f25826f = null;
            this.f25827g.m10156f();
            try {
                this.f25842v.onFailure(this, exc, response);
                if (cVar != null) {
                    byte[] bArr = Util7.f25397a;
                    Intrinsics3.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                    try {
                        cVar.close();
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused) {
                    }
                }
                if (webSocketReader != null) {
                    byte[] bArr2 = Util7.f25397a;
                    Intrinsics3.checkParameterIsNotNull(webSocketReader, "$this$closeQuietly");
                    try {
                        webSocketReader.close();
                    } catch (RuntimeException e3) {
                        throw e3;
                    } catch (Exception unused2) {
                    }
                }
                if (webSocketWriter != null) {
                    byte[] bArr3 = Util7.f25397a;
                    Intrinsics3.checkParameterIsNotNull(webSocketWriter, "$this$closeQuietly");
                    try {
                        webSocketWriter.close();
                    } catch (RuntimeException e4) {
                        throw e4;
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                if (cVar != null) {
                    byte[] bArr4 = Util7.f25397a;
                    Intrinsics3.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                    try {
                        cVar.close();
                    } catch (RuntimeException e5) {
                        throw e5;
                    } catch (Exception unused4) {
                    }
                }
                if (webSocketReader != null) {
                    byte[] bArr5 = Util7.f25397a;
                    Intrinsics3.checkParameterIsNotNull(webSocketReader, "$this$closeQuietly");
                    try {
                        webSocketReader.close();
                    } catch (RuntimeException e6) {
                        throw e6;
                    } catch (Exception unused5) {
                    }
                }
                if (webSocketWriter == null) {
                    throw th;
                }
                byte[] bArr6 = Util7.f25397a;
                Intrinsics3.checkParameterIsNotNull(webSocketWriter, "$this$closeQuietly");
                try {
                    webSocketWriter.close();
                    throw th;
                } catch (RuntimeException e7) {
                    throw e7;
                } catch (Exception unused6) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: renamed from: j */
    public final void m10354j(String str, c cVar) throws IOException {
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull(cVar, "streams");
        WebSocketExtensions webSocketExtensions = this.f25845y;
        if (webSocketExtensions == null) {
            Intrinsics3.throwNpe();
        }
        synchronized (this) {
            this.f25828h = str;
            this.f25829i = cVar;
            boolean z2 = cVar.f25852j;
            this.f25826f = new WebSocketWriter(z2, cVar.f25854l, this.f25843w, webSocketExtensions.f25861a, z2 ? webSocketExtensions.f25863c : webSocketExtensions.f25865e, this.f25846z);
            this.f25824d = new d();
            long j = this.f25844x;
            if (j != 0) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(j);
                String str2 = str + " ping";
                this.f25827g.m10154c(new e(str2, str2, nanos, this, str, cVar, webSocketExtensions), nanos);
            }
            if (!this.f25831k.isEmpty()) {
                m10356l();
            }
        }
        boolean z3 = cVar.f25852j;
        this.f25825e = new WebSocketReader(z3, cVar.f25853k, this, webSocketExtensions.f25861a, z3 ^ true ? webSocketExtensions.f25863c : webSocketExtensions.f25865e);
    }

    /* JADX INFO: renamed from: k */
    public final void m10355k() throws IOException {
        while (this.f25834n == -1) {
            WebSocketReader webSocketReader = this.f25825e;
            if (webSocketReader == null) {
                Intrinsics3.throwNpe();
            }
            webSocketReader.m10362b();
            if (!webSocketReader.f25871n) {
                int i = webSocketReader.f25868k;
                if (i != 1 && i != 2) {
                    StringBuilder sbM833U = outline.m833U("Unknown opcode: ");
                    sbM833U.append(Util7.m10143x(i));
                    throw new ProtocolException(sbM833U.toString());
                }
                while (!webSocketReader.f25867j) {
                    long j = webSocketReader.f25869l;
                    if (j > 0) {
                        webSocketReader.f25879v.mo10428B(webSocketReader.f25874q, j);
                        if (!webSocketReader.f25878u) {
                            Buffer3 buffer3 = webSocketReader.f25874q;
                            Buffer3.a aVar = webSocketReader.f25877t;
                            if (aVar == null) {
                                Intrinsics3.throwNpe();
                            }
                            buffer3.m10469u(aVar);
                            webSocketReader.f25877t.m10476b(webSocketReader.f25874q.f26080k - webSocketReader.f25869l);
                            Buffer3.a aVar2 = webSocketReader.f25877t;
                            byte[] bArr = webSocketReader.f25876s;
                            if (bArr == null) {
                                Intrinsics3.throwNpe();
                            }
                            WebSocketProtocol.m10360a(aVar2, bArr);
                            webSocketReader.f25877t.close();
                        }
                    }
                    if (webSocketReader.f25870m) {
                        if (webSocketReader.f25872o) {
                            MessageInflater messageInflater = webSocketReader.f25875r;
                            if (messageInflater == null) {
                                messageInflater = new MessageInflater(webSocketReader.f25882y);
                                webSocketReader.f25875r = messageInflater;
                            }
                            Buffer3 buffer32 = webSocketReader.f25874q;
                            Intrinsics3.checkParameterIsNotNull(buffer32, "buffer");
                            if (!(messageInflater.f25817j.f26080k == 0)) {
                                throw new IllegalArgumentException("Failed requirement.".toString());
                            }
                            if (messageInflater.f25820m) {
                                messageInflater.f25818k.reset();
                            }
                            messageInflater.f25817j.mo10440P(buffer32);
                            messageInflater.f25817j.m10447W(65535);
                            long bytesRead = messageInflater.f25818k.getBytesRead() + messageInflater.f25817j.f26080k;
                            do {
                                messageInflater.f25819l.m10488a(buffer32, RecyclerView.FOREVER_NS);
                            } while (messageInflater.f25818k.getBytesRead() < bytesRead);
                        }
                        if (i == 1) {
                            webSocketReader.f25880w.mo10347c(webSocketReader.f25874q.m10429D());
                        } else {
                            webSocketReader.f25880w.mo10346b(webSocketReader.f25874q.m10473x());
                        }
                    } else {
                        while (!webSocketReader.f25867j) {
                            webSocketReader.m10362b();
                            if (!webSocketReader.f25871n) {
                                break;
                            } else {
                                webSocketReader.m10361a();
                            }
                        }
                        if (webSocketReader.f25868k != 0) {
                            StringBuilder sbM833U2 = outline.m833U("Expected continuation opcode. Got: ");
                            sbM833U2.append(Util7.m10143x(webSocketReader.f25868k));
                            throw new ProtocolException(sbM833U2.toString());
                        }
                    }
                }
                throw new IOException("closed");
            }
            webSocketReader.m10361a();
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m10356l() {
        byte[] bArr = Util7.f25397a;
        Task2 task2 = this.f25824d;
        if (task2 != null) {
            this.f25827g.m10154c(task2, 0L);
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
    /* JADX INFO: renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m10357m() throws Throwable {
        ByteString byteString;
        WebSocketWriter webSocketWriter;
        Ref$ObjectRef ref$ObjectRef;
        Ref$ObjectRef ref$ObjectRef2;
        Ref$ObjectRef ref$ObjectRef3;
        Ref$ObjectRef ref$ObjectRef4;
        Ref$IntRef ref$IntRef;
        Ref$ObjectRef ref$ObjectRef5;
        Ref$ObjectRef ref$ObjectRef6;
        Ref$ObjectRef ref$ObjectRef7;
        c cVar;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter2;
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
            if (this.f25836p) {
                return false;
            }
            WebSocketWriter webSocketWriter3 = this.f25826f;
            ByteString byteStringPoll = this.f25830j.poll();
            if (byteStringPoll == null) {
                ?? Poll = this.f25831k.poll();
                ref$ObjectRef8.element = Poll;
                if (Poll instanceof a) {
                    int i = this.f25834n;
                    ref$IntRef2.element = i;
                    ref$ObjectRef9.element = this.f25835o;
                    if (i != -1) {
                        ref$ObjectRef10.element = this.f25829i;
                        this.f25829i = null;
                        ref$ObjectRef11.element = this.f25825e;
                        this.f25825e = null;
                        ref$ObjectRef12.element = this.f25826f;
                        this.f25826f = null;
                        this.f25827g.m10156f();
                        byteString = byteStringPoll;
                        webSocketWriter = webSocketWriter3;
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
                        long j = ((a) t).f25849c;
                        TaskQueue2 taskQueue2 = this.f25827g;
                        String str = this.f25828h + " cancel";
                        byteString = byteStringPoll;
                        webSocketWriter = webSocketWriter3;
                        ref$ObjectRef = ref$ObjectRef12;
                        ref$ObjectRef2 = ref$ObjectRef11;
                        ref$ObjectRef3 = ref$ObjectRef10;
                        ref$ObjectRef4 = ref$ObjectRef9;
                        ref$IntRef = ref$IntRef2;
                        taskQueue2.m10154c(new f(str, true, str, true, this, webSocketWriter3, byteStringPoll, ref$ObjectRef8, ref$IntRef2, ref$ObjectRef9, ref$ObjectRef10, ref$ObjectRef2, ref$ObjectRef), TimeUnit.MILLISECONDS.toNanos(j));
                    }
                } else {
                    byteString = byteStringPoll;
                    webSocketWriter = webSocketWriter3;
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
                webSocketWriter = webSocketWriter3;
                ref$ObjectRef = ref$ObjectRef12;
                ref$ObjectRef2 = ref$ObjectRef11;
                ref$ObjectRef3 = ref$ObjectRef10;
                ref$ObjectRef4 = ref$ObjectRef9;
                ref$IntRef = ref$IntRef2;
            }
            Ref$ObjectRef ref$ObjectRef13 = byteString;
            try {
            } catch (Throwable th) {
                th = th;
                ref$ObjectRef13 = ref$ObjectRef;
                ref$ObjectRef5 = ref$ObjectRef2;
                ref$ObjectRef6 = ref$ObjectRef3;
            }
            if (ref$ObjectRef13 == 0) {
                ref$ObjectRef6 = webSocketWriter;
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
                            Intrinsics3.throwNpe();
                        }
                        ref$ObjectRef6.m10363a(aVar.f25847a, aVar.f25848b);
                        ref$ObjectRef6 = ref$ObjectRef3;
                        try {
                            c cVar2 = (c) ref$ObjectRef6.element;
                            ref$ObjectRef7 = ref$ObjectRef6;
                            if (cVar2 != null) {
                                WebSocketListener webSocketListener = this.f25842v;
                                int i2 = ref$IntRef.element;
                                String str2 = (String) ref$ObjectRef4.element;
                                if (str2 == null) {
                                    Intrinsics3.throwNpe();
                                }
                                webSocketListener.onClosed(this, i2, str2);
                                ref$ObjectRef7 = ref$ObjectRef6;
                            }
                            cVar = (c) ref$ObjectRef7.element;
                            if (cVar != null) {
                                byte[] bArr = Util7.f25397a;
                                Intrinsics3.checkParameterIsNotNull(cVar, "$this$closeQuietly");
                                try {
                                    cVar.close();
                                } catch (RuntimeException e2) {
                                    throw e2;
                                } catch (Exception unused) {
                                }
                            }
                            webSocketReader = (WebSocketReader) ref$ObjectRef2.element;
                            if (webSocketReader != null) {
                                byte[] bArr2 = Util7.f25397a;
                                Intrinsics3.checkParameterIsNotNull(webSocketReader, "$this$closeQuietly");
                                try {
                                    webSocketReader.close();
                                } catch (RuntimeException e3) {
                                    throw e3;
                                } catch (Exception unused2) {
                                }
                            }
                            webSocketWriter2 = (WebSocketWriter) ref$ObjectRef.element;
                            if (webSocketWriter2 != null) {
                                byte[] bArr3 = Util7.f25397a;
                                Intrinsics3.checkParameterIsNotNull(webSocketWriter2, "$this$closeQuietly");
                                try {
                                    webSocketWriter2.close();
                                } catch (RuntimeException e4) {
                                    throw e4;
                                } catch (Exception unused3) {
                                }
                            }
                            return true;
                        } catch (Throwable th2) {
                            th = th2;
                            ref$ObjectRef13 = ref$ObjectRef;
                            ref$ObjectRef5 = ref$ObjectRef2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    if (t2 == 0) {
                        throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");
                    }
                    b bVar = (b) t2;
                    if (ref$ObjectRef6 == 0) {
                        Intrinsics3.throwNpe();
                    }
                    ref$ObjectRef6.m10365c(bVar.f25850a, bVar.f25851b);
                    synchronized (this) {
                        this.f25832l -= (long) bVar.f25851b.mo10502j();
                    }
                }
                c cVar3 = (c) ref$ObjectRef6.element;
                if (cVar3 != null) {
                    byte[] bArr4 = Util7.f25397a;
                    Intrinsics3.checkParameterIsNotNull(cVar3, "$this$closeQuietly");
                    try {
                        cVar3.close();
                    } catch (RuntimeException e5) {
                        throw e5;
                    } catch (Exception unused4) {
                    }
                }
                WebSocketReader webSocketReader2 = (WebSocketReader) ref$ObjectRef5.element;
                if (webSocketReader2 != null) {
                    byte[] bArr5 = Util7.f25397a;
                    Intrinsics3.checkParameterIsNotNull(webSocketReader2, "$this$closeQuietly");
                    try {
                        webSocketReader2.close();
                    } catch (RuntimeException e6) {
                        throw e6;
                    } catch (Exception unused5) {
                    }
                }
                WebSocketWriter webSocketWriter4 = (WebSocketWriter) ref$ObjectRef13.element;
                if (webSocketWriter4 == null) {
                    throw th;
                }
                byte[] bArr6 = Util7.f25397a;
                Intrinsics3.checkParameterIsNotNull(webSocketWriter4, "$this$closeQuietly");
                try {
                    webSocketWriter4.close();
                    throw th;
                } catch (RuntimeException e7) {
                    throw e7;
                } catch (Exception unused6) {
                    throw th;
                }
            }
            WebSocketWriter webSocketWriter5 = webSocketWriter;
            if (webSocketWriter5 == 0) {
                Intrinsics3.throwNpe();
            }
            Objects.requireNonNull(webSocketWriter5);
            Intrinsics3.checkParameterIsNotNull(ref$ObjectRef13, "payload");
            webSocketWriter5.m10364b(10, ref$ObjectRef13);
            ref$ObjectRef7 = ref$ObjectRef3;
            cVar = (c) ref$ObjectRef7.element;
            if (cVar != null) {
            }
            webSocketReader = (WebSocketReader) ref$ObjectRef2.element;
            if (webSocketReader != null) {
            }
            webSocketWriter2 = (WebSocketWriter) ref$ObjectRef.element;
            if (webSocketWriter2 != null) {
            }
            return true;
        }
    }
}
