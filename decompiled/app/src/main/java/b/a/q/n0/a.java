package b.a.q.n0;

import androidx.annotation.AnyThread;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.socket.io.Opcodes;
import com.discord.rtcconnection.socket.io.Payloads;
import com.discord.utilities.debug.DebugPrintBuilder;
import com.discord.utilities.debug.DebugPrintable;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.Backoff;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.time.Clock;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import d0.z.d.m;
import d0.z.d.o;
import f0.e0.k.h;
import f0.x;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/* compiled from: RtcControlSocket.kt */
/* loaded from: classes.dex */
public final class a extends WebSocketListener implements DebugPrintable {
    public static int j;
    public Long A;
    public c B;
    public boolean C;
    public final String D;
    public final String E;
    public final SSLSocketFactory F;
    public final Logger G;
    public final b.a.q.c H;
    public final Clock I;
    public final String J;
    public final String m;
    public final Gson n;
    public final Timer o;
    public final Backoff p;
    public final CopyOnWriteArraySet<d> q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public WebSocket f275s;
    public String t;
    public String u;
    public Long v;
    public boolean w;

    /* renamed from: x, reason: collision with root package name */
    public b.a.q.n0.b f276x;

    /* renamed from: y, reason: collision with root package name */
    public Long f277y;

    /* renamed from: z, reason: collision with root package name */
    public TimerTask f278z;
    public static final b l = new b(null);
    public static final Type k = new C0046a().getType();

    /* compiled from: RtcControlSocket.kt */
    /* renamed from: b.a.q.n0.a$a, reason: collision with other inner class name */
    public static final class C0046a extends TypeToken<Map<String, ? extends Integer>> {
    }

    /* compiled from: RtcControlSocket.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: RtcControlSocket.kt */
    public enum c {
        DISCONNECTED,
        CONNECTING,
        IDENTIFYING,
        RESUMING,
        CONNECTED,
        RECONNECTING
    }

    /* compiled from: RtcControlSocket.kt */
    public interface d {
        void a(String str, String str2);

        void b(boolean z2, Integer num, String str);

        void c(String str, List<Integer> list);

        void d(String str);

        void e(long j, int i, int i2, List<Payloads.Stream> list);

        void f(Map<String, Integer> map);

        void g(long j);

        void h();

        void i();

        void j(long j);

        void k(int i, int i2, String str, List<Payloads.Stream> list);

        void onConnecting();

        void onSpeaking(long j, int i, boolean z2);
    }

    /* compiled from: RtcControlSocket.kt */
    public static final class e extends o implements Function1<WebSocket, Unit> {
        public static final e j = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WebSocket webSocket) {
            WebSocket webSocket2 = webSocket;
            m.checkNotNullParameter(webSocket2, "it");
            webSocket2.e(1000, "Force Close");
            return Unit.a;
        }
    }

    /* compiled from: RtcControlSocket.kt */
    public static final class f extends o implements Function1<WebSocket, Unit> {
        public static final f j = new f();

        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WebSocket webSocket) {
            WebSocket webSocket2 = webSocket;
            m.checkNotNullParameter(webSocket2, "it");
            webSocket2.e(SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM, "close reason");
            return Unit.a;
        }
    }

    /* compiled from: RtcControlSocket.kt */
    public static final class g extends TimerTask {

        /* compiled from: RtcControlSocket.kt */
        /* renamed from: b.a.q.n0.a$g$a, reason: collision with other inner class name */
        public static final class C0047a extends o implements Function0<Unit> {
            public C0047a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                a.a(a.this, true, null, "The connection timed out. Did not receive OP_HELLO in time.");
                return Unit.a;
            }
        }

        public g() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            a.this.m(new C0047a());
        }
    }

    /* compiled from: RtcControlSocket.kt */
    public static final class h extends o implements Function0<Unit> {
        public final /* synthetic */ int $code;
        public final /* synthetic */ String $reason;
        public final /* synthetic */ WebSocket $webSocket;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(WebSocket webSocket, int i, String str) {
            super(0);
            this.$webSocket = webSocket;
            this.$code = i;
            this.$reason = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (!(!m.areEqual(this.$webSocket, a.this.f275s))) {
                a.a(a.this, true, Integer.valueOf(this.$code), this.$reason);
            }
            return Unit.a;
        }
    }

    /* compiled from: RtcControlSocket.kt */
    public static final class i extends o implements Function0<Unit> {
        public final /* synthetic */ Throwable $t;
        public final /* synthetic */ WebSocket $webSocket;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(WebSocket webSocket, Throwable th) {
            super(0);
            this.$webSocket = webSocket;
            this.$t = th;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (!(!m.areEqual(this.$webSocket, a.this.f275s))) {
                a aVar = a.this;
                StringBuilder sbU = b.d.b.a.a.U("An error with the websocket occurred: ");
                sbU.append(this.$t.getMessage());
                a.a(aVar, true, null, sbU.toString());
            }
            return Unit.a;
        }
    }

    /* compiled from: RtcControlSocket.kt */
    public static final class j extends o implements Function0<Unit> {
        public final /* synthetic */ Payloads.Incoming $message;
        public final /* synthetic */ WebSocket $webSocket;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(WebSocket webSocket, Payloads.Incoming incoming) {
            super(0);
            this.$webSocket = webSocket;
            this.$message = incoming;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() throws JsonSyntaxException {
            if (!(!m.areEqual(this.$webSocket, a.this.f275s))) {
                switch (this.$message.getOpcode()) {
                    case 2:
                        a aVar = a.this;
                        Object objC = aVar.n.c(this.$message.getData(), Payloads.Ready.class);
                        m.checkNotNullExpressionValue(objC, "gson.fromJson(message.da…yloads.Ready::class.java)");
                        Payloads.Ready ready = (Payloads.Ready) objC;
                        aVar.p.succeed();
                        long jCurrentTimeMillis = aVar.I.currentTimeMillis();
                        Long l = aVar.A;
                        aVar.i("[READY] took " + (jCurrentTimeMillis - (l != null ? l.longValue() : 0L)) + " ms");
                        aVar.H.a();
                        for (d dVar : aVar.q) {
                            m.checkNotNullExpressionValue(dVar, "it");
                            dVar.k(ready.getPort(), ready.getSsrc(), ready.getIp(), ready.getStreams());
                        }
                        break;
                    case 3:
                        a aVar2 = a.this;
                        aVar2.n(3, String.valueOf(aVar2.I.currentTimeMillis()));
                        break;
                    case 4:
                        a aVar3 = a.this;
                        Object objC2 = aVar3.n.c(this.$message.getData(), Payloads.Description.class);
                        m.checkNotNullExpressionValue(objC2, "gson.fromJson(message.da….Description::class.java)");
                        Payloads.Description description = (Payloads.Description) objC2;
                        aVar3.H.a();
                        for (d dVar2 : aVar3.q) {
                            m.checkNotNullExpressionValue(dVar2, "it");
                            dVar2.c(description.getMode(), description.getSecretKey());
                            dVar2.a(description.getAudioCodec(), description.getVideoCodec());
                            String mediaSessionId = description.getMediaSessionId();
                            if (mediaSessionId != null) {
                                dVar2.d(mediaSessionId);
                            }
                        }
                        aVar3.C = true;
                        break;
                    case 5:
                        a aVar4 = a.this;
                        Object objC3 = aVar4.n.c(this.$message.getData(), Payloads.Speaking.class);
                        m.checkNotNullExpressionValue(objC3, "gson.fromJson(message.da…ads.Speaking::class.java)");
                        Payloads.Speaking speaking = (Payloads.Speaking) objC3;
                        if (speaking.getUserId() != null && speaking.getSpeaking() != null) {
                            Integer speaking2 = speaking.getSpeaking();
                            boolean z2 = speaking2 != null && speaking2.intValue() == 1;
                            aVar4.H.a();
                            for (d dVar3 : aVar4.q) {
                                m.checkNotNullExpressionValue(dVar3, "it");
                                dVar3.onSpeaking(speaking.getUserId().longValue(), speaking.getSsrc(), z2);
                            }
                            break;
                        }
                        break;
                    case 6:
                        a aVar5 = a.this;
                        Object objC4 = aVar5.n.c(this.$message.getData(), Long.TYPE);
                        m.checkNotNullExpressionValue(objC4, "gson.fromJson(message.data, Long::class.java)");
                        long jLongValue = ((Number) objC4).longValue();
                        long jCurrentTimeMillis2 = aVar5.I.currentTimeMillis();
                        long j = jCurrentTimeMillis2 - jLongValue;
                        aVar5.h("got heartbeat ack after " + j + " ms");
                        aVar5.f277y = Long.valueOf(jCurrentTimeMillis2);
                        aVar5.w = true;
                        aVar5.H.a();
                        for (d dVar4 : aVar5.q) {
                            m.checkNotNullExpressionValue(dVar4, "it");
                            dVar4.g(j);
                        }
                        break;
                    case 7:
                    case 10:
                    case 11:
                    default:
                        a aVar6 = a.this;
                        StringBuilder sbU = b.d.b.a.a.U("unknown opcode: ");
                        sbU.append(this.$message.getOpcode());
                        aVar6.i(sbU.toString());
                        break;
                    case 8:
                        a aVar7 = a.this;
                        Object objC5 = aVar7.n.c(this.$message.getData(), Payloads.Hello.class);
                        m.checkNotNullExpressionValue(objC5, "gson.fromJson(message.da…yloads.Hello::class.java)");
                        Payloads.Hello hello = (Payloads.Hello) objC5;
                        TimerTask timerTask = aVar7.f278z;
                        if (timerTask != null) {
                            timerTask.cancel();
                        }
                        aVar7.i("[HELLO] raw: " + hello);
                        aVar7.v = Long.valueOf(hello.getHeartbeatIntervalMs());
                        aVar7.r = hello.getServerVersion();
                        aVar7.f276x.cancel();
                        aVar7.w = true;
                        aVar7.k();
                        break;
                    case 9:
                        a.this.p.succeed();
                        break;
                    case 12:
                        a aVar8 = a.this;
                        Object objC6 = aVar8.n.c(this.$message.getData(), Payloads.Video.class);
                        m.checkNotNullExpressionValue(objC6, "gson.fromJson(message.da…yloads.Video::class.java)");
                        Payloads.Video video = (Payloads.Video) objC6;
                        if (video.getUserId() != null) {
                            aVar8.H.a();
                            for (d dVar5 : aVar8.q) {
                                m.checkNotNullExpressionValue(dVar5, "it");
                                dVar5.e(video.getUserId().longValue(), video.getAudioSsrc(), video.getVideoSsrc(), video.getStreams());
                            }
                            break;
                        }
                        break;
                    case 13:
                        a aVar9 = a.this;
                        Object objC7 = aVar9.n.c(this.$message.getData(), Payloads.ClientDisconnect.class);
                        m.checkNotNullExpressionValue(objC7, "gson.fromJson(message.da…ntDisconnect::class.java)");
                        Payloads.ClientDisconnect clientDisconnect = (Payloads.ClientDisconnect) objC7;
                        aVar9.H.a();
                        for (d dVar6 : aVar9.q) {
                            m.checkNotNullExpressionValue(dVar6, "it");
                            dVar6.j(clientDisconnect.getUserId());
                        }
                        break;
                    case 14:
                        a aVar10 = a.this;
                        Object objC8 = aVar10.n.c(this.$message.getData(), Payloads.SessionUpdate.class);
                        m.checkNotNullExpressionValue(objC8, "gson.fromJson(message.da…essionUpdate::class.java)");
                        Payloads.SessionUpdate sessionUpdate = (Payloads.SessionUpdate) objC8;
                        aVar10.H.a();
                        for (d dVar7 : aVar10.q) {
                            m.checkNotNullExpressionValue(dVar7, "it");
                            String mediaSessionId2 = sessionUpdate.getMediaSessionId();
                            if (mediaSessionId2 != null) {
                                dVar7.d(mediaSessionId2);
                            }
                        }
                        break;
                    case 15:
                        a aVar11 = a.this;
                        Gson gson = aVar11.n;
                        JsonElement data = this.$message.getData();
                        Type type = a.k;
                        Objects.requireNonNull(gson);
                        Object objD = data == null ? null : gson.d(new b.i.d.q.x.a(data), type);
                        m.checkNotNullExpressionValue(objD, "gson.fromJson(message.data, MEDIA_SINK_WANTS_TYPE)");
                        Map<String, Integer> map = (Map) objD;
                        aVar11.H.a();
                        for (d dVar8 : aVar11.q) {
                            m.checkNotNullExpressionValue(dVar8, "it");
                            dVar8.f(map);
                        }
                        break;
                }
            }
            return Unit.a;
        }
    }

    /* compiled from: RtcControlSocket.kt */
    public static final class k extends o implements Function0<Unit> {
        public final /* synthetic */ WebSocket $webSocket;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(WebSocket webSocket) {
            super(0);
            this.$webSocket = webSocket;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            boolean z2 = true;
            if (!(!m.areEqual(this.$webSocket, a.this.f275s))) {
                a aVar = a.this;
                c cVar = aVar.B;
                if (cVar == c.CONNECTING) {
                    aVar.H.a();
                    for (d dVar : aVar.q) {
                        m.checkNotNullExpressionValue(dVar, "it");
                        dVar.i();
                    }
                } else if (cVar == c.RECONNECTING) {
                    String str = aVar.u;
                    String str2 = aVar.t;
                    String str3 = aVar.E;
                    Long l = aVar.f277y;
                    if (l != null && aVar.I.currentTimeMillis() - l.longValue() > 60000) {
                        z2 = false;
                    }
                    if (str == null || str2 == null || !aVar.C || !z2) {
                        StringBuilder sbU = b.d.b.a.a.U("Cannot resume connection. resumable: ");
                        sbU.append(aVar.C);
                        sbU.append(" -- isHeartbeatRecentEnough: ");
                        sbU.append(z2);
                        aVar.f(false, 4801, sbU.toString());
                    } else {
                        aVar.i("[RESUME] resuming session. serverId=" + str2 + " sessionId=" + str);
                        aVar.H.a();
                        for (d dVar2 : aVar.q) {
                            m.checkNotNullExpressionValue(dVar2, "it");
                            dVar2.h();
                        }
                        aVar.B = c.RESUMING;
                        aVar.n(7, new Payloads.Resume(str3, str, str2));
                    }
                }
                a aVar2 = a.this;
                aVar2.B = c.CONNECTED;
                long jCurrentTimeMillis = aVar2.I.currentTimeMillis();
                Long l2 = a.this.A;
                long jLongValue = jCurrentTimeMillis - (l2 != null ? l2.longValue() : 0L);
                a aVar3 = a.this;
                StringBuilder sbU2 = b.d.b.a.a.U("[CONNECTED] to ");
                sbU2.append(a.this.D);
                aVar3.i(sbU2.toString());
                a aVar4 = a.this;
                aVar4.H.a();
                for (d dVar3 : aVar4.q) {
                    m.checkNotNullExpressionValue(dVar3, "it");
                    dVar3.g(jLongValue / 2);
                }
            }
            return Unit.a;
        }
    }

    /* compiled from: RtcControlSocket.kt */
    public static final class l extends o implements Function1<WebSocket, Unit> {
        public static final l j = new l();

        public l() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WebSocket webSocket) {
            WebSocket webSocket2 = webSocket;
            m.checkNotNullParameter(webSocket2, "it");
            webSocket2.e(SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM, "reconnecting");
            return Unit.a;
        }
    }

    public a(String str, String str2, SSLSocketFactory sSLSocketFactory, Logger logger, b.a.q.c cVar, Clock clock, String str3) {
        m.checkNotNullParameter(str, "endpoint");
        m.checkNotNullParameter(str2, "token");
        m.checkNotNullParameter(logger, "logger");
        m.checkNotNullParameter(cVar, "mediaEngineThreadExecutor");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(str3, "loggingTagPrefix");
        this.D = str;
        this.E = str2;
        this.F = sSLSocketFactory;
        this.G = logger;
        this.H = cVar;
        this.I = clock;
        this.J = str3;
        StringBuilder sbX = b.d.b.a.a.X(str3, "->RtcControlSocket ");
        int i2 = j + 1;
        j = i2;
        sbX.append(i2);
        String string = sbX.toString();
        this.m = string;
        this.n = new b.i.d.e().a();
        this.o = new Timer();
        this.p = new Backoff(1000L, 5000L, 3, false, new Backoff.TimerScheduler(string, cVar), 8, null);
        this.q = new CopyOnWriteArraySet<>();
        this.r = 3;
        this.f276x = new b.a.q.n0.b(this);
        this.B = c.DISCONNECTED;
    }

    public static final void a(a aVar, boolean z2, Integer num, String str) {
        aVar.B = c.DISCONNECTED;
        if ((num != null && num.intValue() == 4004) || ((num != null && num.intValue() == 4015) || ((num != null && num.intValue() == 4011) || (num != null && num.intValue() == 4006)))) {
            aVar.f(true, num, str);
            return;
        }
        if (aVar.p.hasReachedFailureThreshold()) {
            aVar.j("[WS CLOSED] Backoff exceeded. Resetting.");
            aVar.f(z2, num, str);
            return;
        }
        aVar.b(null);
        aVar.j("`[WS CLOSED] (" + z2 + ", " + num + ", " + str + ") retrying in " + b.d.b.a.a.P(new Object[]{Double.valueOf(aVar.p.fail(new b.a.q.n0.c(aVar, z2, num, str)) / 1000.0d)}, 1, "%.2f", "java.lang.String.format(this, *args)") + " seconds.");
    }

    public final void b(Function1<? super WebSocket, Unit> function1) {
        this.p.cancel();
        this.f276x.cancel();
        TimerTask timerTask = this.f278z;
        if (timerTask != null) {
            timerTask.cancel();
        }
        WebSocket webSocket = this.f275s;
        if (webSocket != null && function1 != null) {
            function1.invoke(webSocket);
        }
        this.f275s = (WebSocket) null;
    }

    public final void c() {
        this.H.a();
        i("[CLOSE]");
        b(e.j);
        this.t = null;
        this.u = null;
        this.C = false;
        this.B = c.DISCONNECTED;
        this.H.a();
        for (d dVar : this.q) {
            m.checkNotNullExpressionValue(dVar, "it");
            dVar.b(false, 1000, "Force Close");
        }
    }

    public final boolean d() {
        this.H.a();
        if (this.B != c.DISCONNECTED) {
            j("Cannot start a new connection, connection state is not disconnected");
            return false;
        }
        this.B = c.CONNECTING;
        e();
        this.H.a();
        for (d dVar : this.q) {
            m.checkNotNullExpressionValue(dVar, "it");
            dVar.onConnecting();
        }
        return true;
    }

    @Override // com.discord.utilities.debug.DebugPrintable
    public void debugPrint(DebugPrintBuilder debugPrintBuilder) {
        m.checkNotNullParameter(debugPrintBuilder, "dp");
        debugPrintBuilder.appendKeyValue("serverId", this.t);
        debugPrintBuilder.appendKeyValue("sessionId", this.u);
        debugPrintBuilder.appendKeyValue("heartbeatInterval", this.v);
        debugPrintBuilder.appendKeyValue("lastHeartbeatAckTime", this.f277y);
        debugPrintBuilder.appendKeyValue("connectionStartTime", this.A);
        debugPrintBuilder.appendKeyValue("connectionState", this.B);
        debugPrintBuilder.appendKeyValue("resumable", Boolean.valueOf(this.C));
    }

    public final void e() {
        StringBuilder sbU = b.d.b.a.a.U("[CONNECT] ");
        sbU.append(this.D);
        i(sbU.toString());
        if (this.f275s != null) {
            this.G.e(this.m, "Connect called with already existing websocket", null, null);
            b(f.j);
            return;
        }
        this.A = Long.valueOf(this.I.currentTimeMillis());
        TimerTask timerTask = this.f278z;
        if (timerTask != null) {
            timerTask.cancel();
        }
        g gVar = new g();
        this.f278z = gVar;
        this.o.schedule(gVar, 20000L);
        x.a aVar = new x.a();
        aVar.a(1L, TimeUnit.MINUTES);
        SSLSocketFactory sSLSocketFactory = this.F;
        if (sSLSocketFactory != null) {
            h.a aVar2 = f0.e0.k.h.c;
            aVar.b(sSLSocketFactory, f0.e0.k.h.a.n());
        }
        String strJ = b.d.b.a.a.J(new StringBuilder(), this.D, "?v=5");
        i("attempting WSS connection with " + strJ);
        x xVar = new x(aVar);
        Request.a aVar3 = new Request.a();
        aVar3.f(strJ);
        this.f275s = xVar.g(aVar3.a(), this);
    }

    public final void f(boolean z2, Integer num, String str) {
        j("[DISCONNECT] (" + z2 + ", " + num + ", " + str + ')');
        b(null);
        this.t = null;
        this.u = null;
        this.C = false;
        this.B = c.DISCONNECTED;
        this.H.a();
        for (d dVar : this.q) {
            m.checkNotNullExpressionValue(dVar, "it");
            dVar.b(z2, num, str);
        }
    }

    public final void g(long j2, String str, boolean z2) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        this.H.a();
        if (this.f275s != null) {
            i("Performing an immediate heartbeat on existing socket: " + str);
            this.f276x.cancel();
            b.a.q.n0.b bVar = new b.a.q.n0.b(this);
            this.f276x = bVar;
            this.o.schedule(bVar, j2);
            return;
        }
        if (!z2) {
            i("Immediate heartbeat requested, but is disconnected and a reset was not requested: " + str);
            return;
        }
        if (this.p.getIsPending() && this.f275s == null) {
            i("Connection backoff reset Immediate heartbeat when socket was disconnected.");
            this.p.succeed();
            l(false, 4802, "Reset backoff.");
        }
    }

    public final void h(String str) {
        Logger.d$default(this.G, this.m, str, null, 4, null);
    }

    public final void i(String str) {
        Logger.i$default(this.G, this.m, str, null, 4, null);
    }

    public final void j(String str) {
        Logger.w$default(this.G, this.m, str, null, 4, null);
    }

    public final void k() {
        if (!this.w) {
            b(b.a.q.n0.d.j);
            j("[ACK TIMEOUT] reconnecting in " + b.d.b.a.a.P(new Object[]{Double.valueOf(this.p.fail(new b.a.q.n0.e(this)) / 1000.0d)}, 1, "%.2f", "java.lang.String.format(this, *args)") + " seconds.");
            return;
        }
        this.w = false;
        n(3, String.valueOf(this.I.currentTimeMillis()));
        Long l2 = this.v;
        if (l2 == null) {
            j("onHeartbeatInterval called when heartbeatInterval was null");
            return;
        }
        b.a.q.n0.b bVar = new b.a.q.n0.b(this);
        this.f276x = bVar;
        this.o.schedule(bVar, l2.longValue());
    }

    public final void l(boolean z2, Integer num, String str) {
        i("[RECONNECT] wasFatal=" + z2 + " code=" + num + " reason=" + str);
        b(l.j);
        this.B = c.RECONNECTING;
        e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [b.a.q.n0.f] */
    @AnyThread
    public final void m(Function0<Unit> function0) {
        b.a.q.c cVar = this.H;
        if (function0 != null) {
            function0 = new b.a.q.n0.f(function0);
        }
        cVar.l.execute((Runnable) function0);
    }

    public final void n(int i2, Object obj) {
        WebSocket webSocket = this.f275s;
        if (webSocket == null) {
            StringBuilder sbU = b.d.b.a.a.U("opcode() websocket null. opcode: ");
            sbU.append(Opcodes.INSTANCE.getNameOf(i2));
            this.G.e(this.m, sbU.toString(), null, null);
            return;
        }
        try {
            String strM = this.n.m(new Payloads.Outgoing(i2, obj));
            h("sending (" + Opcodes.INSTANCE.getNameOf(i2) + "): " + strM);
            m.checkNotNullExpressionValue(strM, "json");
            webSocket.a(strM);
        } catch (Exception unused) {
            j("exception sending opcode: " + i2 + " and payload: " + obj);
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(WebSocket webSocket, int i2, String str) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        super.onClosed(webSocket, i2, str);
        m(new h(webSocket, i2, str));
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(WebSocket webSocket, int i2, String str) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        ((f0.e0.n.d) webSocket).e(i2, str);
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(th, "t");
        super.onFailure(webSocket, th, response);
        m(new i(webSocket, th));
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, String str) throws JsonSyntaxException {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        Payloads.Incoming incoming = (Payloads.Incoming) b.i.a.f.e.o.f.E1(Payloads.Incoming.class).cast(this.n.g(str, Payloads.Incoming.class));
        super.onMessage(webSocket, str);
        StringBuilder sbU = b.d.b.a.a.U("received (");
        sbU.append(Opcodes.INSTANCE.getNameOf(incoming.getOpcode()));
        sbU.append("): ");
        sbU.append(incoming);
        h(sbU.toString());
        m(new j(webSocket, incoming));
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(WebSocket webSocket, Response response) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(response, "response");
        super.onOpen(webSocket, response);
        m(new k(webSocket));
    }
}
