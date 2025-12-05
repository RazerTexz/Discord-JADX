package p007b.p008a.p041q.p046n0;

import androidx.annotation.AnyThread;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.socket.p499io.Opcodes;
import com.discord.rtcconnection.socket.p499io.Payloads;
import com.discord.utilities.debug.DebugPrintable;
import com.discord.utilities.debug.DebugPrintable2;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.Backoff;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.time.Clock;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
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
import p007b.p008a.p041q.MediaEngineExecutorService;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p408d.GsonBuilder;
import p007b.p225i.p408d.p410q.p411x.JsonTreeReader;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p600f0.OkHttpClient;
import p600f0.p601e0.p609k.Platform2;
import p600f0.p601e0.p613n.RealWebSocket;

/* compiled from: RtcControlSocket.kt */
/* renamed from: b.a.q.n0.a, reason: use source file name */
/* loaded from: classes.dex */
public final class RtcControlSocket extends WebSocketListener implements DebugPrintable {

    /* renamed from: j */
    public static int f1763j;

    /* renamed from: A */
    public Long f1766A;

    /* renamed from: B */
    public c f1767B;

    /* renamed from: C */
    public boolean f1768C;

    /* renamed from: D */
    public final String f1769D;

    /* renamed from: E */
    public final String f1770E;

    /* renamed from: F */
    public final SSLSocketFactory f1771F;

    /* renamed from: G */
    public final Logger f1772G;

    /* renamed from: H */
    public final MediaEngineExecutorService f1773H;

    /* renamed from: I */
    public final Clock f1774I;

    /* renamed from: J */
    public final String f1775J;

    /* renamed from: m */
    public final String f1776m;

    /* renamed from: n */
    public final Gson f1777n;

    /* renamed from: o */
    public final Timer f1778o;

    /* renamed from: p */
    public final Backoff f1779p;

    /* renamed from: q */
    public final CopyOnWriteArraySet<d> f1780q;

    /* renamed from: r */
    public int f1781r;

    /* renamed from: s */
    public WebSocket f1782s;

    /* renamed from: t */
    public String f1783t;

    /* renamed from: u */
    public String f1784u;

    /* renamed from: v */
    public Long f1785v;

    /* renamed from: w */
    public boolean f1786w;

    /* renamed from: x */
    public RtcControlSocket2 f1787x;

    /* renamed from: y */
    public Long f1788y;

    /* renamed from: z */
    public TimerTask f1789z;

    /* renamed from: l */
    public static final b f1765l = new b(null);

    /* renamed from: k */
    public static final Type f1764k = new a().getType();

    /* compiled from: RtcControlSocket.kt */
    /* renamed from: b.a.q.n0.a$a */
    public static final class a extends TypeToken<Map<String, ? extends Integer>> {
    }

    /* compiled from: RtcControlSocket.kt */
    /* renamed from: b.a.q.n0.a$b */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: RtcControlSocket.kt */
    /* renamed from: b.a.q.n0.a$c */
    public enum c {
        DISCONNECTED,
        CONNECTING,
        IDENTIFYING,
        RESUMING,
        CONNECTED,
        RECONNECTING
    }

    /* compiled from: RtcControlSocket.kt */
    /* renamed from: b.a.q.n0.a$d */
    public interface d {
        /* renamed from: a */
        void mo267a(String str, String str2);

        /* renamed from: b */
        void mo268b(boolean z2, Integer num, String str);

        /* renamed from: c */
        void mo269c(String str, List<Integer> list);

        /* renamed from: d */
        void mo270d(String str);

        /* renamed from: e */
        void mo271e(long j, int i, int i2, List<Payloads.Stream> list);

        /* renamed from: f */
        void mo272f(Map<String, Integer> map);

        /* renamed from: g */
        void mo273g(long j);

        /* renamed from: h */
        void mo274h();

        /* renamed from: i */
        void mo275i();

        /* renamed from: j */
        void mo276j(long j);

        /* renamed from: k */
        void mo277k(int i, int i2, String str, List<Payloads.Stream> list);

        void onConnecting();

        void onSpeaking(long j, int i, boolean z2);
    }

    /* compiled from: RtcControlSocket.kt */
    /* renamed from: b.a.q.n0.a$e */
    public static final class e extends Lambda implements Function1<WebSocket, Unit> {

        /* renamed from: j */
        public static final e f1797j = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WebSocket webSocket) {
            WebSocket webSocket2 = webSocket;
            Intrinsics3.checkNotNullParameter(webSocket2, "it");
            webSocket2.mo10349e(1000, "Force Close");
            return Unit.f27425a;
        }
    }

    /* compiled from: RtcControlSocket.kt */
    /* renamed from: b.a.q.n0.a$f */
    public static final class f extends Lambda implements Function1<WebSocket, Unit> {

        /* renamed from: j */
        public static final f f1798j = new f();

        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WebSocket webSocket) {
            WebSocket webSocket2 = webSocket;
            Intrinsics3.checkNotNullParameter(webSocket2, "it");
            webSocket2.mo10349e(SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM, "close reason");
            return Unit.f27425a;
        }
    }

    /* compiled from: RtcControlSocket.kt */
    /* renamed from: b.a.q.n0.a$g */
    public static final class g extends TimerTask {

        /* compiled from: RtcControlSocket.kt */
        /* renamed from: b.a.q.n0.a$g$a */
        public static final class a extends Lambda implements Function0<Unit> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                RtcControlSocket.m337a(RtcControlSocket.this, true, null, "The connection timed out. Did not receive OP_HELLO in time.");
                return Unit.f27425a;
            }
        }

        public g() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            RtcControlSocket.this.m349m(new a());
        }
    }

    /* compiled from: RtcControlSocket.kt */
    /* renamed from: b.a.q.n0.a$h */
    public static final class h extends Lambda implements Function0<Unit> {
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
            if (!(!Intrinsics3.areEqual(this.$webSocket, RtcControlSocket.this.f1782s))) {
                RtcControlSocket.m337a(RtcControlSocket.this, true, Integer.valueOf(this.$code), this.$reason);
            }
            return Unit.f27425a;
        }
    }

    /* compiled from: RtcControlSocket.kt */
    /* renamed from: b.a.q.n0.a$i */
    public static final class i extends Lambda implements Function0<Unit> {

        /* renamed from: $t */
        public final /* synthetic */ Throwable f1800$t;
        public final /* synthetic */ WebSocket $webSocket;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(WebSocket webSocket, Throwable th) {
            super(0);
            this.$webSocket = webSocket;
            this.f1800$t = th;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (!(!Intrinsics3.areEqual(this.$webSocket, RtcControlSocket.this.f1782s))) {
                RtcControlSocket rtcControlSocket = RtcControlSocket.this;
                StringBuilder sbM833U = outline.m833U("An error with the websocket occurred: ");
                sbM833U.append(this.f1800$t.getMessage());
                RtcControlSocket.m337a(rtcControlSocket, true, null, sbM833U.toString());
            }
            return Unit.f27425a;
        }
    }

    /* compiled from: RtcControlSocket.kt */
    /* renamed from: b.a.q.n0.a$j */
    public static final class j extends Lambda implements Function0<Unit> {
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
            if (!(!Intrinsics3.areEqual(this.$webSocket, RtcControlSocket.this.f1782s))) {
                switch (this.$message.getOpcode()) {
                    case 2:
                        RtcControlSocket rtcControlSocket = RtcControlSocket.this;
                        Object objM9199c = rtcControlSocket.f1777n.m9199c(this.$message.getData(), Payloads.Ready.class);
                        Intrinsics3.checkNotNullExpressionValue(objM9199c, "gson.fromJson(message.da…yloads.Ready::class.java)");
                        Payloads.Ready ready = (Payloads.Ready) objM9199c;
                        rtcControlSocket.f1779p.succeed();
                        long jCurrentTimeMillis = rtcControlSocket.f1774I.currentTimeMillis();
                        Long l = rtcControlSocket.f1766A;
                        rtcControlSocket.m345i("[READY] took " + (jCurrentTimeMillis - (l != null ? l.longValue() : 0L)) + " ms");
                        rtcControlSocket.f1773H.m266a();
                        for (d dVar : rtcControlSocket.f1780q) {
                            Intrinsics3.checkNotNullExpressionValue(dVar, "it");
                            dVar.mo277k(ready.getPort(), ready.getSsrc(), ready.getIp(), ready.getStreams());
                        }
                        break;
                    case 3:
                        RtcControlSocket rtcControlSocket2 = RtcControlSocket.this;
                        rtcControlSocket2.m350n(3, String.valueOf(rtcControlSocket2.f1774I.currentTimeMillis()));
                        break;
                    case 4:
                        RtcControlSocket rtcControlSocket3 = RtcControlSocket.this;
                        Object objM9199c2 = rtcControlSocket3.f1777n.m9199c(this.$message.getData(), Payloads.Description.class);
                        Intrinsics3.checkNotNullExpressionValue(objM9199c2, "gson.fromJson(message.da….Description::class.java)");
                        Payloads.Description description = (Payloads.Description) objM9199c2;
                        rtcControlSocket3.f1773H.m266a();
                        for (d dVar2 : rtcControlSocket3.f1780q) {
                            Intrinsics3.checkNotNullExpressionValue(dVar2, "it");
                            dVar2.mo269c(description.getMode(), description.getSecretKey());
                            dVar2.mo267a(description.getAudioCodec(), description.getVideoCodec());
                            String mediaSessionId = description.getMediaSessionId();
                            if (mediaSessionId != null) {
                                dVar2.mo270d(mediaSessionId);
                            }
                        }
                        rtcControlSocket3.f1768C = true;
                        break;
                    case 5:
                        RtcControlSocket rtcControlSocket4 = RtcControlSocket.this;
                        Object objM9199c3 = rtcControlSocket4.f1777n.m9199c(this.$message.getData(), Payloads.Speaking.class);
                        Intrinsics3.checkNotNullExpressionValue(objM9199c3, "gson.fromJson(message.da…ads.Speaking::class.java)");
                        Payloads.Speaking speaking = (Payloads.Speaking) objM9199c3;
                        if (speaking.getUserId() != null && speaking.getSpeaking() != null) {
                            Integer speaking2 = speaking.getSpeaking();
                            boolean z2 = speaking2 != null && speaking2.intValue() == 1;
                            rtcControlSocket4.f1773H.m266a();
                            for (d dVar3 : rtcControlSocket4.f1780q) {
                                Intrinsics3.checkNotNullExpressionValue(dVar3, "it");
                                dVar3.onSpeaking(speaking.getUserId().longValue(), speaking.getSsrc(), z2);
                            }
                        }
                        break;
                    case 6:
                        RtcControlSocket rtcControlSocket5 = RtcControlSocket.this;
                        Object objM9199c4 = rtcControlSocket5.f1777n.m9199c(this.$message.getData(), Long.TYPE);
                        Intrinsics3.checkNotNullExpressionValue(objM9199c4, "gson.fromJson(message.data, Long::class.java)");
                        long jLongValue = ((Number) objM9199c4).longValue();
                        long jCurrentTimeMillis2 = rtcControlSocket5.f1774I.currentTimeMillis();
                        long j = jCurrentTimeMillis2 - jLongValue;
                        rtcControlSocket5.m344h("got heartbeat ack after " + j + " ms");
                        rtcControlSocket5.f1788y = Long.valueOf(jCurrentTimeMillis2);
                        rtcControlSocket5.f1786w = true;
                        rtcControlSocket5.f1773H.m266a();
                        for (d dVar4 : rtcControlSocket5.f1780q) {
                            Intrinsics3.checkNotNullExpressionValue(dVar4, "it");
                            dVar4.mo273g(j);
                        }
                        break;
                    case 7:
                    case 10:
                    case 11:
                    default:
                        RtcControlSocket rtcControlSocket6 = RtcControlSocket.this;
                        StringBuilder sbM833U = outline.m833U("unknown opcode: ");
                        sbM833U.append(this.$message.getOpcode());
                        rtcControlSocket6.m345i(sbM833U.toString());
                        break;
                    case 8:
                        RtcControlSocket rtcControlSocket7 = RtcControlSocket.this;
                        Object objM9199c5 = rtcControlSocket7.f1777n.m9199c(this.$message.getData(), Payloads.Hello.class);
                        Intrinsics3.checkNotNullExpressionValue(objM9199c5, "gson.fromJson(message.da…yloads.Hello::class.java)");
                        Payloads.Hello hello = (Payloads.Hello) objM9199c5;
                        TimerTask timerTask = rtcControlSocket7.f1789z;
                        if (timerTask != null) {
                            timerTask.cancel();
                        }
                        rtcControlSocket7.m345i("[HELLO] raw: " + hello);
                        rtcControlSocket7.f1785v = Long.valueOf(hello.getHeartbeatIntervalMs());
                        rtcControlSocket7.f1781r = hello.getServerVersion();
                        rtcControlSocket7.f1787x.cancel();
                        rtcControlSocket7.f1786w = true;
                        rtcControlSocket7.m347k();
                        break;
                    case 9:
                        RtcControlSocket.this.f1779p.succeed();
                        break;
                    case 12:
                        RtcControlSocket rtcControlSocket8 = RtcControlSocket.this;
                        Object objM9199c6 = rtcControlSocket8.f1777n.m9199c(this.$message.getData(), Payloads.Video.class);
                        Intrinsics3.checkNotNullExpressionValue(objM9199c6, "gson.fromJson(message.da…yloads.Video::class.java)");
                        Payloads.Video video = (Payloads.Video) objM9199c6;
                        if (video.getUserId() != null) {
                            rtcControlSocket8.f1773H.m266a();
                            for (d dVar5 : rtcControlSocket8.f1780q) {
                                Intrinsics3.checkNotNullExpressionValue(dVar5, "it");
                                dVar5.mo271e(video.getUserId().longValue(), video.getAudioSsrc(), video.getVideoSsrc(), video.getStreams());
                            }
                        }
                        break;
                    case 13:
                        RtcControlSocket rtcControlSocket9 = RtcControlSocket.this;
                        Object objM9199c7 = rtcControlSocket9.f1777n.m9199c(this.$message.getData(), Payloads.ClientDisconnect.class);
                        Intrinsics3.checkNotNullExpressionValue(objM9199c7, "gson.fromJson(message.da…ntDisconnect::class.java)");
                        Payloads.ClientDisconnect clientDisconnect = (Payloads.ClientDisconnect) objM9199c7;
                        rtcControlSocket9.f1773H.m266a();
                        for (d dVar6 : rtcControlSocket9.f1780q) {
                            Intrinsics3.checkNotNullExpressionValue(dVar6, "it");
                            dVar6.mo276j(clientDisconnect.getUserId());
                        }
                        break;
                    case 14:
                        RtcControlSocket rtcControlSocket10 = RtcControlSocket.this;
                        Object objM9199c8 = rtcControlSocket10.f1777n.m9199c(this.$message.getData(), Payloads.SessionUpdate.class);
                        Intrinsics3.checkNotNullExpressionValue(objM9199c8, "gson.fromJson(message.da…essionUpdate::class.java)");
                        Payloads.SessionUpdate sessionUpdate = (Payloads.SessionUpdate) objM9199c8;
                        rtcControlSocket10.f1773H.m266a();
                        for (d dVar7 : rtcControlSocket10.f1780q) {
                            Intrinsics3.checkNotNullExpressionValue(dVar7, "it");
                            String mediaSessionId2 = sessionUpdate.getMediaSessionId();
                            if (mediaSessionId2 != null) {
                                dVar7.mo270d(mediaSessionId2);
                            }
                        }
                        break;
                    case 15:
                        RtcControlSocket rtcControlSocket11 = RtcControlSocket.this;
                        Gson gson = rtcControlSocket11.f1777n;
                        JsonElement data = this.$message.getData();
                        Type type = RtcControlSocket.f1764k;
                        Objects.requireNonNull(gson);
                        Object objM9200d = data == null ? null : gson.m9200d(new JsonTreeReader(data), type);
                        Intrinsics3.checkNotNullExpressionValue(objM9200d, "gson.fromJson(message.data, MEDIA_SINK_WANTS_TYPE)");
                        Map<String, Integer> map = (Map) objM9200d;
                        rtcControlSocket11.f1773H.m266a();
                        for (d dVar8 : rtcControlSocket11.f1780q) {
                            Intrinsics3.checkNotNullExpressionValue(dVar8, "it");
                            dVar8.mo272f(map);
                        }
                        break;
                }
            }
            return Unit.f27425a;
        }
    }

    /* compiled from: RtcControlSocket.kt */
    /* renamed from: b.a.q.n0.a$k */
    public static final class k extends Lambda implements Function0<Unit> {
        public final /* synthetic */ WebSocket $webSocket;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(WebSocket webSocket) {
            super(0);
            this.$webSocket = webSocket;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            boolean z2 = true;
            if (!(!Intrinsics3.areEqual(this.$webSocket, RtcControlSocket.this.f1782s))) {
                RtcControlSocket rtcControlSocket = RtcControlSocket.this;
                c cVar = rtcControlSocket.f1767B;
                if (cVar == c.CONNECTING) {
                    rtcControlSocket.f1773H.m266a();
                    for (d dVar : rtcControlSocket.f1780q) {
                        Intrinsics3.checkNotNullExpressionValue(dVar, "it");
                        dVar.mo275i();
                    }
                } else if (cVar == c.RECONNECTING) {
                    String str = rtcControlSocket.f1784u;
                    String str2 = rtcControlSocket.f1783t;
                    String str3 = rtcControlSocket.f1770E;
                    Long l = rtcControlSocket.f1788y;
                    if (l != null && rtcControlSocket.f1774I.currentTimeMillis() - l.longValue() > 60000) {
                        z2 = false;
                    }
                    if (str == null || str2 == null || !rtcControlSocket.f1768C || !z2) {
                        StringBuilder sbM833U = outline.m833U("Cannot resume connection. resumable: ");
                        sbM833U.append(rtcControlSocket.f1768C);
                        sbM833U.append(" -- isHeartbeatRecentEnough: ");
                        sbM833U.append(z2);
                        rtcControlSocket.m342f(false, 4801, sbM833U.toString());
                    } else {
                        rtcControlSocket.m345i("[RESUME] resuming session. serverId=" + str2 + " sessionId=" + str);
                        rtcControlSocket.f1773H.m266a();
                        for (d dVar2 : rtcControlSocket.f1780q) {
                            Intrinsics3.checkNotNullExpressionValue(dVar2, "it");
                            dVar2.mo274h();
                        }
                        rtcControlSocket.f1767B = c.RESUMING;
                        rtcControlSocket.m350n(7, new Payloads.Resume(str3, str, str2));
                    }
                }
                RtcControlSocket rtcControlSocket2 = RtcControlSocket.this;
                rtcControlSocket2.f1767B = c.CONNECTED;
                long jCurrentTimeMillis = rtcControlSocket2.f1774I.currentTimeMillis();
                Long l2 = RtcControlSocket.this.f1766A;
                long jLongValue = jCurrentTimeMillis - (l2 != null ? l2.longValue() : 0L);
                RtcControlSocket rtcControlSocket3 = RtcControlSocket.this;
                StringBuilder sbM833U2 = outline.m833U("[CONNECTED] to ");
                sbM833U2.append(RtcControlSocket.this.f1769D);
                rtcControlSocket3.m345i(sbM833U2.toString());
                RtcControlSocket rtcControlSocket4 = RtcControlSocket.this;
                rtcControlSocket4.f1773H.m266a();
                for (d dVar3 : rtcControlSocket4.f1780q) {
                    Intrinsics3.checkNotNullExpressionValue(dVar3, "it");
                    dVar3.mo273g(jLongValue / 2);
                }
            }
            return Unit.f27425a;
        }
    }

    /* compiled from: RtcControlSocket.kt */
    /* renamed from: b.a.q.n0.a$l */
    public static final class l extends Lambda implements Function1<WebSocket, Unit> {

        /* renamed from: j */
        public static final l f1801j = new l();

        public l() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WebSocket webSocket) {
            WebSocket webSocket2 = webSocket;
            Intrinsics3.checkNotNullParameter(webSocket2, "it");
            webSocket2.mo10349e(SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM, "reconnecting");
            return Unit.f27425a;
        }
    }

    public RtcControlSocket(String str, String str2, SSLSocketFactory sSLSocketFactory, Logger logger, MediaEngineExecutorService mediaEngineExecutorService, Clock clock, String str3) {
        Intrinsics3.checkNotNullParameter(str, "endpoint");
        Intrinsics3.checkNotNullParameter(str2, "token");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(mediaEngineExecutorService, "mediaEngineThreadExecutor");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(str3, "loggingTagPrefix");
        this.f1769D = str;
        this.f1770E = str2;
        this.f1771F = sSLSocketFactory;
        this.f1772G = logger;
        this.f1773H = mediaEngineExecutorService;
        this.f1774I = clock;
        this.f1775J = str3;
        StringBuilder sbM836X = outline.m836X(str3, "->RtcControlSocket ");
        int i2 = f1763j + 1;
        f1763j = i2;
        sbM836X.append(i2);
        String string = sbM836X.toString();
        this.f1776m = string;
        this.f1777n = new GsonBuilder().m6851a();
        this.f1778o = new Timer();
        this.f1779p = new Backoff(1000L, 5000L, 3, false, new Backoff.TimerScheduler(string, mediaEngineExecutorService), 8, null);
        this.f1780q = new CopyOnWriteArraySet<>();
        this.f1781r = 3;
        this.f1787x = new RtcControlSocket2(this);
        this.f1767B = c.DISCONNECTED;
    }

    /* renamed from: a */
    public static final void m337a(RtcControlSocket rtcControlSocket, boolean z2, Integer num, String str) {
        rtcControlSocket.f1767B = c.DISCONNECTED;
        if ((num != null && num.intValue() == 4004) || ((num != null && num.intValue() == 4015) || ((num != null && num.intValue() == 4011) || (num != null && num.intValue() == 4006)))) {
            rtcControlSocket.m342f(true, num, str);
            return;
        }
        if (rtcControlSocket.f1779p.hasReachedFailureThreshold()) {
            rtcControlSocket.m346j("[WS CLOSED] Backoff exceeded. Resetting.");
            rtcControlSocket.m342f(z2, num, str);
            return;
        }
        rtcControlSocket.m338b(null);
        rtcControlSocket.m346j("`[WS CLOSED] (" + z2 + ", " + num + ", " + str + ") retrying in " + outline.m828P(new Object[]{Double.valueOf(rtcControlSocket.f1779p.fail(new RtcControlSocket3(rtcControlSocket, z2, num, str)) / 1000.0d)}, 1, "%.2f", "java.lang.String.format(this, *args)") + " seconds.");
    }

    /* renamed from: b */
    public final void m338b(Function1<? super WebSocket, Unit> function1) {
        this.f1779p.cancel();
        this.f1787x.cancel();
        TimerTask timerTask = this.f1789z;
        if (timerTask != null) {
            timerTask.cancel();
        }
        WebSocket webSocket = this.f1782s;
        if (webSocket != null && function1 != null) {
            function1.invoke(webSocket);
        }
        this.f1782s = (WebSocket) null;
    }

    /* renamed from: c */
    public final void m339c() {
        this.f1773H.m266a();
        m345i("[CLOSE]");
        m338b(e.f1797j);
        this.f1783t = null;
        this.f1784u = null;
        this.f1768C = false;
        this.f1767B = c.DISCONNECTED;
        this.f1773H.m266a();
        for (d dVar : this.f1780q) {
            Intrinsics3.checkNotNullExpressionValue(dVar, "it");
            dVar.mo268b(false, 1000, "Force Close");
        }
    }

    /* renamed from: d */
    public final boolean m340d() {
        this.f1773H.m266a();
        if (this.f1767B != c.DISCONNECTED) {
            m346j("Cannot start a new connection, connection state is not disconnected");
            return false;
        }
        this.f1767B = c.CONNECTING;
        m341e();
        this.f1773H.m266a();
        for (d dVar : this.f1780q) {
            Intrinsics3.checkNotNullExpressionValue(dVar, "it");
            dVar.onConnecting();
        }
        return true;
    }

    @Override // com.discord.utilities.debug.DebugPrintable
    public void debugPrint(DebugPrintable2 debugPrintable2) {
        Intrinsics3.checkNotNullParameter(debugPrintable2, "dp");
        debugPrintable2.appendKeyValue("serverId", this.f1783t);
        debugPrintable2.appendKeyValue("sessionId", this.f1784u);
        debugPrintable2.appendKeyValue("heartbeatInterval", this.f1785v);
        debugPrintable2.appendKeyValue("lastHeartbeatAckTime", this.f1788y);
        debugPrintable2.appendKeyValue("connectionStartTime", this.f1766A);
        debugPrintable2.appendKeyValue("connectionState", this.f1767B);
        debugPrintable2.appendKeyValue("resumable", Boolean.valueOf(this.f1768C));
    }

    /* renamed from: e */
    public final void m341e() {
        StringBuilder sbM833U = outline.m833U("[CONNECT] ");
        sbM833U.append(this.f1769D);
        m345i(sbM833U.toString());
        if (this.f1782s != null) {
            this.f1772G.mo8363e(this.f1776m, "Connect called with already existing websocket", null, null);
            m338b(f.f1798j);
            return;
        }
        this.f1766A = Long.valueOf(this.f1774I.currentTimeMillis());
        TimerTask timerTask = this.f1789z;
        if (timerTask != null) {
            timerTask.cancel();
        }
        g gVar = new g();
        this.f1789z = gVar;
        this.f1778o.schedule(gVar, 20000L);
        OkHttpClient.a aVar = new OkHttpClient.a();
        aVar.m10420a(1L, TimeUnit.MINUTES);
        SSLSocketFactory sSLSocketFactory = this.f1771F;
        if (sSLSocketFactory != null) {
            Platform2.a aVar2 = Platform2.f25785c;
            aVar.m10421b(sSLSocketFactory, Platform2.f25783a.mo10325n());
        }
        String strM822J = outline.m822J(new StringBuilder(), this.f1769D, "?v=5");
        m345i("attempting WSS connection with " + strM822J);
        OkHttpClient okHttpClient = new OkHttpClient(aVar);
        Request.C12935a c12935a = new Request.C12935a();
        c12935a.m10983f(strM822J);
        this.f1782s = okHttpClient.m10419g(c12935a.m10978a(), this);
    }

    /* renamed from: f */
    public final void m342f(boolean z2, Integer num, String str) {
        m346j("[DISCONNECT] (" + z2 + ", " + num + ", " + str + ')');
        m338b(null);
        this.f1783t = null;
        this.f1784u = null;
        this.f1768C = false;
        this.f1767B = c.DISCONNECTED;
        this.f1773H.m266a();
        for (d dVar : this.f1780q) {
            Intrinsics3.checkNotNullExpressionValue(dVar, "it");
            dVar.mo268b(z2, num, str);
        }
    }

    /* renamed from: g */
    public final void m343g(long j2, String str, boolean z2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        this.f1773H.m266a();
        if (this.f1782s != null) {
            m345i("Performing an immediate heartbeat on existing socket: " + str);
            this.f1787x.cancel();
            RtcControlSocket2 rtcControlSocket2 = new RtcControlSocket2(this);
            this.f1787x = rtcControlSocket2;
            this.f1778o.schedule(rtcControlSocket2, j2);
            return;
        }
        if (!z2) {
            m345i("Immediate heartbeat requested, but is disconnected and a reset was not requested: " + str);
            return;
        }
        if (this.f1779p.getIsPending() && this.f1782s == null) {
            m345i("Connection backoff reset Immediate heartbeat when socket was disconnected.");
            this.f1779p.succeed();
            m348l(false, 4802, "Reset backoff.");
        }
    }

    /* renamed from: h */
    public final void m344h(String str) {
        Logger.d$default(this.f1772G, this.f1776m, str, null, 4, null);
    }

    /* renamed from: i */
    public final void m345i(String str) {
        Logger.i$default(this.f1772G, this.f1776m, str, null, 4, null);
    }

    /* renamed from: j */
    public final void m346j(String str) {
        Logger.w$default(this.f1772G, this.f1776m, str, null, 4, null);
    }

    /* renamed from: k */
    public final void m347k() {
        if (!this.f1786w) {
            m338b(RtcControlSocket4.f1803j);
            m346j("[ACK TIMEOUT] reconnecting in " + outline.m828P(new Object[]{Double.valueOf(this.f1779p.fail(new RtcControlSocket5(this)) / 1000.0d)}, 1, "%.2f", "java.lang.String.format(this, *args)") + " seconds.");
            return;
        }
        this.f1786w = false;
        m350n(3, String.valueOf(this.f1774I.currentTimeMillis()));
        Long l2 = this.f1785v;
        if (l2 == null) {
            m346j("onHeartbeatInterval called when heartbeatInterval was null");
            return;
        }
        RtcControlSocket2 rtcControlSocket2 = new RtcControlSocket2(this);
        this.f1787x = rtcControlSocket2;
        this.f1778o.schedule(rtcControlSocket2, l2.longValue());
    }

    /* renamed from: l */
    public final void m348l(boolean z2, Integer num, String str) {
        m345i("[RECONNECT] wasFatal=" + z2 + " code=" + num + " reason=" + str);
        m338b(l.f1801j);
        this.f1767B = c.RECONNECTING;
        m341e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [b.a.q.n0.f] */
    @AnyThread
    /* renamed from: m */
    public final void m349m(Function0<Unit> function0) {
        MediaEngineExecutorService mediaEngineExecutorService = this.f1773H;
        if (function0 != null) {
            function0 = new RtcControlSocket6(function0);
        }
        mediaEngineExecutorService.f1609l.execute((Runnable) function0);
    }

    /* renamed from: n */
    public final void m350n(int i2, Object obj) {
        WebSocket webSocket = this.f1782s;
        if (webSocket == null) {
            StringBuilder sbM833U = outline.m833U("opcode() websocket null. opcode: ");
            sbM833U.append(Opcodes.INSTANCE.getNameOf(i2));
            this.f1772G.mo8363e(this.f1776m, sbM833U.toString(), null, null);
            return;
        }
        try {
            String strM9209m = this.f1777n.m9209m(new Payloads.Outgoing(i2, obj));
            m344h("sending (" + Opcodes.INSTANCE.getNameOf(i2) + "): " + strM9209m);
            Intrinsics3.checkNotNullExpressionValue(strM9209m, "json");
            webSocket.mo10345a(strM9209m);
        } catch (Exception unused) {
            m346j("exception sending opcode: " + i2 + " and payload: " + obj);
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(WebSocket webSocket, int i2, String str) {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        super.onClosed(webSocket, i2, str);
        m349m(new h(webSocket, i2, str));
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(WebSocket webSocket, int i2, String str) {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        ((RealWebSocket) webSocket).mo10349e(i2, str);
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(th, "t");
        super.onFailure(webSocket, th, response);
        m349m(new i(webSocket, th));
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, String str) throws JsonSyntaxException {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        Payloads.Incoming incoming = (Payloads.Incoming) C3404f.m4203E1(Payloads.Incoming.class).cast(this.f1777n.m9203g(str, Payloads.Incoming.class));
        super.onMessage(webSocket, str);
        StringBuilder sbM833U = outline.m833U("received (");
        sbM833U.append(Opcodes.INSTANCE.getNameOf(incoming.getOpcode()));
        sbM833U.append("): ");
        sbM833U.append(incoming);
        m344h(sbM833U.toString());
        m349m(new j(webSocket, incoming));
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(WebSocket webSocket, Response response) {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(response, "response");
        super.onOpen(webSocket, response);
        m349m(new k(webSocket));
    }
}
