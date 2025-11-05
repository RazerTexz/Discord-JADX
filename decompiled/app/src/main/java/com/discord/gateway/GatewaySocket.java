package com.discord.gateway;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import b.i.d.c;
import b.i.d.e;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityType;
import com.discord.api.activity.ActivityTypeTypeAdapter;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.presence.ClientStatus;
import com.discord.gateway.GatewaySocketLogger;
import com.discord.gateway.io.Incoming;
import com.discord.gateway.io.IncomingParser;
import com.discord.gateway.io.Outgoing;
import com.discord.gateway.io.OutgoingPayload;
import com.discord.gateway.opcodes.Opcode;
import com.discord.gateway.rest.RestClient;
import com.discord.gateway.rest.RestConfig;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.collections.ListenerCollection;
import com.discord.utilities.collections.ListenerCollectionSubject;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.Backoff;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.websocket.WebSocket;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonReader;
import d0.g0.t;
import d0.t.h0;
import d0.t.n;
import d0.t.n0;
import d0.t.u;
import d0.z.d.e0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import j0.l.a.r;
import j0.l.a.v1;
import j0.l.a.w1;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action1;

/* compiled from: GatewaySocket.kt */
/* loaded from: classes.dex */
public final class GatewaySocket {
    private static final long AUTH_TOKEN_REFRESH = 256;
    private static final long CLIENT_CAPABILITIES = 351;
    private static final int CLOSE_CODE_CLEAN = 1000;
    private static final int CLOSE_CODE_DIRTY = 4000;
    private static final int CLOSE_CODE_UNAUTHORIZED = 4004;
    private static final boolean COMPRESS_DATA = true;
    private static final int CONNECTED = 5;
    private static final int CONNECTING = 2;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long DEDUPE_USER_OBJECTS = 16;
    private static final int DISCONNECTED = 0;
    private static final int DISCOVERING = 1;
    private static final Set<String> EXPECTED_NULL_DATA_EVENTS;
    private static final String GATEWAY_COMPRESSION = "zlib-stream";
    private static final String GATEWAY_ENCODING = "json";
    private static final int GATEWAY_URL_RESET_THRESHOLD = 4;
    private static final int GATEWAY_VERSION = 9;
    private static final int HEARTBEAT_MAX_RESUME_THRESHOLD = 180000;
    private static final long HELLO_TIMEOUT = 20000;
    private static final int IDENTIFYING = 3;
    private static final int LARGE_GUILD_THRESHOLD = 100;
    private static final long LAZY_USER_NOTES = 1;
    private static final long MULTIPLE_GUILD_EXPERIMENT_POPULATIONS = 64;
    private static final long NO_AFFINE_USER_IDS = 2;
    private static final int RESUMING = 4;
    private static final long VERSIONED_READ_STATES = 4;
    private static final long VERSIONED_USER_GUILD_SETTINGS = 8;
    private static final Clock clock;
    private static final Gson gsonIncludeNulls;
    private static final Gson gsonOmitNulls;
    private boolean connected;
    private boolean connectionReady;
    private long connectionStartTime;
    private int connectionState;
    private final GatewayEventHandler eventHandler;
    private final Backoff gatewayBackoff;
    private final GatewayDiscovery gatewayDiscovery;
    private final GatewaySocketLogger gatewaySocketLogger;
    private final Function1<String, String> gatewayUrlTransform;
    private boolean hasConnectedOnce;
    private boolean heartbeatAck;
    private long heartbeatAckTimeMostRecent;
    private Timer heartbeatExpeditedTimeout;
    private long heartbeatInterval;
    private Timer heartbeater;
    private Timer helloTimeout;
    private final Function0<IdentifyData> identifyDataProvider;
    private final Map<String, Object> identifyProperties;
    private long identifyStartTime;
    private final ListenerCollectionSubject<Listener> listenerSubject;
    private final ListenerCollection<Listener> listeners;
    private final Logger logger;
    private boolean nextReconnectIsImmediate;
    private int replayedEvents;
    private final Scheduler scheduler;
    private int seq;
    private String sessionId;
    private final SSLSocketFactory sslSocketFactory;
    private String token;
    private final Function1<Map<String, ? extends Object>, Unit> trackReadyPayload;
    private WebSocket webSocket;

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, "message");
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), str, false, 2, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Boolean, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Boolean bool) {
            return bool;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Boolean call(Boolean bool) {
            return call2(bool);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Boolean> {
        public AnonymousClass3() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            GatewaySocket gatewaySocket = GatewaySocket.this;
            m.checkNotNullExpressionValue(bool, "isConnected");
            GatewaySocket.access$handleDeviceConnectivityChange(gatewaySocket, bool.booleanValue());
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$4, reason: invalid class name */
    public static final class AnonymousClass4<T> implements Action1<Throwable> {
        public AnonymousClass4() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbU = a.U("failed to handle connectivity change in ");
            sbU.append(GatewaySocket.this.getClass().getSimpleName());
            Logger.e$default(loggerAccess$getLogger$p, sbU.toString(), th, null, 4, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ void access$log(Companion companion, Logger logger, String str, boolean z2) {
            companion.log(logger, str, z2);
        }

        private final long getDelay(long startTime, Long currentTime) {
            return (currentTime != null ? currentTime.longValue() : ClockFactory.get().currentTimeMillis()) - startTime;
        }

        public static /* synthetic */ long getDelay$default(Companion companion, long j, Long l, int i, Object obj) {
            if ((i & 2) != 0) {
                l = null;
            }
            return companion.getDelay(j, l);
        }

        private final void log(Logger logger, String str, boolean z2) {
            Logger.v$default(logger, a.w("[GatewaySocket] ", str), null, 2, null);
            if (z2) {
                logger.recordBreadcrumb("Gateway [" + str + ']', "log");
            }
        }

        public static /* synthetic */ void log$default(Companion companion, Logger logger, String str, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = true;
            }
            companion.log(logger, str, z2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: GatewaySocket.kt */
    public static abstract class DefaultListener implements Listener {
        @Override // com.discord.gateway.GatewaySocket.Listener
        public void onConnected(GatewaySocket gatewaySocket) {
            m.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        }

        @Override // com.discord.gateway.GatewaySocket.Listener
        public void onConnecting(GatewaySocket gatewaySocket) {
            m.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        }

        @Override // com.discord.gateway.GatewaySocket.Listener
        public void onDisconnected(GatewaySocket gatewaySocket) {
            m.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        }

        @Override // com.discord.gateway.GatewaySocket.Listener
        public void onHello(GatewaySocket gatewaySocket) {
            m.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        }
    }

    /* compiled from: GatewaySocket.kt */
    public static final class IdentifyData {
        private final OutgoingPayload.IdentifyClientState clientState;
        private final String token;

        public IdentifyData(String str, OutgoingPayload.IdentifyClientState identifyClientState) {
            m.checkNotNullParameter(str, "token");
            this.token = str;
            this.clientState = identifyClientState;
        }

        public final OutgoingPayload.IdentifyClientState getClientState() {
            return this.clientState;
        }

        public final String getToken() {
            return this.token;
        }
    }

    /* compiled from: GatewaySocket.kt */
    public interface Listener {
        void onConnected(GatewaySocket gatewaySocket);

        void onConnecting(GatewaySocket gatewaySocket);

        void onDisconnected(GatewaySocket gatewaySocket);

        void onHello(GatewaySocket gatewaySocket);
    }

    /* compiled from: GatewaySocket.kt */
    public static final class SizeRecordingInputStreamReader extends Reader {
        private int size;
        private final InputStreamReader source;

        public SizeRecordingInputStreamReader(InputStreamReader inputStreamReader, int i) {
            m.checkNotNullParameter(inputStreamReader, "source");
            this.source = inputStreamReader;
            this.size = i;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.source.close();
        }

        public final int getSize() {
            return this.size;
        }

        public final InputStreamReader getSource() {
            return this.source;
        }

        @Override // java.io.Reader
        public int read(char[] buffer, int offset, int len) throws IOException {
            m.checkNotNullParameter(buffer, "buffer");
            int i = this.source.read(buffer, offset, len);
            if (i != -1) {
                this.size += i;
            }
            return i;
        }

        public final void setSize(int i) {
            this.size = i;
        }

        public /* synthetic */ SizeRecordingInputStreamReader(InputStreamReader inputStreamReader, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(inputStreamReader, (i2 & 2) != 0 ? 0 : i);
        }
    }

    /* compiled from: GatewaySocket.kt */
    public static final class Timer implements Backoff.Scheduler {
        private final Scheduler scheduler;
        private Subscription subscription;

        public Timer(Scheduler scheduler) {
            m.checkNotNullParameter(scheduler, "scheduler");
            this.scheduler = scheduler;
        }

        public static final /* synthetic */ Subscription access$getSubscription$p(Timer timer) {
            return timer.subscription;
        }

        public static final /* synthetic */ void access$setSubscription$p(Timer timer, Subscription subscription) {
            timer.subscription = subscription;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void cancel$default(Timer timer, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                function0 = null;
            }
            timer.cancel(function0);
        }

        @Override // com.discord.utilities.networking.Backoff.Scheduler
        public void cancel() {
            cancel(null);
        }

        public final boolean getPending() {
            return this.subscription != null;
        }

        public final void postInterval(Function0<Unit> callback, long delayMillis) {
            m.checkNotNullParameter(callback, "callback");
            cancel();
            this.subscription = Observable.F(delayMillis, delayMillis, TimeUnit.MILLISECONDS, j0.p.a.a()).J(this.scheduler).W(new GatewaySocket$Timer$postInterval$1(callback), GatewaySocket$Timer$postInterval$2.INSTANCE);
        }

        @Override // com.discord.utilities.networking.Backoff.Scheduler
        public void schedule(Function0<Unit> action, long delayMs) {
            m.checkNotNullParameter(action, "action");
            cancel();
            this.subscription = Observable.d0(delayMs, TimeUnit.MILLISECONDS).J(this.scheduler).W(new GatewaySocket$Timer$schedule$1(this, action), GatewaySocket$Timer$schedule$2.INSTANCE);
        }

        public final void cancel(Function0<Unit> callback) {
            Subscription subscription = this.subscription;
            if (subscription != null) {
                if (subscription != null) {
                    subscription.unsubscribe();
                }
                this.subscription = null;
                if (callback != null) {
                    callback.invoke();
                }
            }
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            GatewaySocketLogger.LogLevel.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[GatewaySocketLogger.LogLevel.NONE.ordinal()] = 1;
            iArr[GatewaySocketLogger.LogLevel.VERBOSE.ordinal()] = 2;
            Opcode.values();
            int[] iArr2 = new int[21];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Opcode.HELLO.ordinal()] = 1;
            iArr2[Opcode.RECONNECT.ordinal()] = 2;
            iArr2[Opcode.INVALID_SESSION.ordinal()] = 3;
            iArr2[Opcode.HEARTBEAT.ordinal()] = 4;
            iArr2[Opcode.HEARTBEAT_ACK.ordinal()] = 5;
            iArr2[Opcode.DISPATCH.ordinal()] = 6;
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$callConnect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Companion companion = GatewaySocket.INSTANCE;
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbU = a.U("Sending call connect sync on channel id: ");
            sbU.append(this.$channelId);
            sbU.append('.');
            Companion.log$default(companion, loggerAccess$getLogger$p, sbU.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.CALL_CONNECT, new OutgoingPayload.CallConnect(this.$channelId)), false, null, 6, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$close$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ boolean $clean;

        /* compiled from: GatewaySocket.kt */
        /* renamed from: com.discord.gateway.GatewaySocket$close$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01851 extends o implements Function1<WebSocket, Unit> {
            public final /* synthetic */ int $code;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01851(int i) {
                super(1);
                this.$code = i;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
                invoke2(webSocket);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WebSocket webSocket) {
                if (webSocket != null) {
                    WebSocket.disconnect$default(webSocket, this.$code, null, 2, null);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(0);
            this.$clean = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (GatewaySocket.access$getConnectionState$p(GatewaySocket.this) == 0) {
                return;
            }
            int i = this.$clean ? 1000 : 4000;
            GatewaySocket.access$cleanup(GatewaySocket.this, new C01851(i));
            GatewaySocket.access$setConnectionState$p(GatewaySocket.this, 0);
            GatewaySocket.access$reset(GatewaySocket.this, this.$clean, i, "Disconnect requested by client");
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$connect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (GatewaySocket.access$getConnectionState$p(GatewaySocket.this) == 0) {
                GatewaySocket.access$setConnectionState$p(GatewaySocket.this, 1);
                GatewaySocket.access$discover(GatewaySocket.this);
            }
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$connect$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<WebSocket, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
            invoke2(webSocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WebSocket webSocket) {
            if (webSocket != null) {
                webSocket.disconnect(4000, "Connect called with an existing web socket.");
            }
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$connect$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            GatewaySocket gatewaySocket = GatewaySocket.this;
            StringBuilder sbU = a.U("Connection timed out after ");
            sbU.append(Companion.getDelay$default(GatewaySocket.INSTANCE, GatewaySocket.access$getConnectionStartTime$p(GatewaySocket.this), null, 2, null));
            sbU.append("ms, did not receive hello in time.");
            GatewaySocket.access$handleClose(gatewaySocket, false, 0, sbU.toString());
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$connect$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends k implements Function3<String, Exception, Map<String, ? extends String>, Unit> {
        public AnonymousClass4(GatewaySocket gatewaySocket) {
            super(3, gatewaySocket, GatewaySocket.class, "logError", "logError(Ljava/lang/String;Ljava/lang/Exception;Ljava/util/Map;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(String str, Exception exc, Map<String, ? extends String> map) {
            invoke2(str, exc, (Map<String, String>) map);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str, Exception exc, Map<String, String> map) {
            m.checkNotNullParameter(str, "p1");
            m.checkNotNullParameter(exc, "p2");
            GatewaySocket.access$logError((GatewaySocket) this.receiver, str, exc, map);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$discover$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Listener, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            m.checkNotNullParameter(listener, "it");
            listener.onConnecting(GatewaySocket.this);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$discover$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<String, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            String str2;
            m.checkNotNullParameter(str, "gatewayUrl");
            GatewaySocket gatewaySocket = GatewaySocket.this;
            Function1 function1Access$getGatewayUrlTransform$p = GatewaySocket.access$getGatewayUrlTransform$p(gatewaySocket);
            if (function1Access$getGatewayUrlTransform$p != null && (str2 = (String) function1Access$getGatewayUrlTransform$p.invoke(str)) != null) {
                str = str2;
            }
            GatewaySocket.access$connect(gatewaySocket, str);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$discover$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Throwable, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            m.checkNotNullParameter(th, "it");
            GatewaySocket.access$discoveryFailed(GatewaySocket.this);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$expeditedHeartbeat$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ String $reason;
        public final /* synthetic */ boolean $shouldResetBackoff;
        public final /* synthetic */ long $timeout;

        /* compiled from: GatewaySocket.kt */
        /* renamed from: com.discord.gateway.GatewaySocket$expeditedHeartbeat$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01861 extends o implements Function1<String, Unit> {
            public C01861() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
                Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), "Connection backoff reset " + str + '.', false, 2, null);
                GatewaySocket.access$getGatewayBackoff$p(GatewaySocket.this).succeed();
                GatewaySocket.access$setNextReconnectIsImmediate$p(GatewaySocket.this, true);
                if (GatewaySocket.access$getConnectionState$p(GatewaySocket.this) == 1) {
                    GatewaySocket.access$discover(GatewaySocket.this);
                }
            }
        }

        /* compiled from: GatewaySocket.kt */
        /* renamed from: com.discord.gateway.GatewaySocket$expeditedHeartbeat$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends o implements Function0<Unit> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (GatewaySocket.access$getHeartbeatAck$p(GatewaySocket.this)) {
                    return;
                }
                GatewaySocket.access$handleHeartbeatTimeout(GatewaySocket.this);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, long j, boolean z2) {
            super(0);
            this.$reason = str;
            this.$timeout = j;
            this.$shouldResetBackoff = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            String strH = this.$reason != null ? a.H(a.U("with reason '"), this.$reason, '\'') : "";
            C01861 c01861 = new C01861();
            if (GatewaySocket.access$getWebSocket$p(GatewaySocket.this) == null) {
                if (this.$shouldResetBackoff) {
                    c01861.invoke2(strH);
                    return;
                } else {
                    Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), a.y("Expedited heartbeat requested ", strH, ", but disconnected and no reset backoff."), false, 2, null);
                    return;
                }
            }
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), "Performing an expedited heartbeat " + strH + '.', false, 2, null);
            GatewaySocket gatewaySocket = GatewaySocket.this;
            GatewaySocket.access$heartbeat(gatewaySocket, GatewaySocket.access$getSeq$p(gatewaySocket));
            GatewaySocket.access$setHeartbeatAck$p(GatewaySocket.this, false);
            GatewaySocket.access$getHeartbeatExpeditedTimeout$p(GatewaySocket.this).schedule(new AnonymousClass2(), this.$timeout);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$handleClose$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<WebSocket, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
            invoke2(webSocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WebSocket webSocket) {
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$handleHeartbeatAck$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), "Expedited heartbeat succeeded.", false, 2, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$handleHeartbeatTimeout$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<WebSocket, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
            invoke2(webSocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WebSocket webSocket) {
            if (webSocket != null) {
                WebSocket.disconnect$default(webSocket, 4000, null, 2, null);
            }
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$handleHello$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Listener, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            m.checkNotNullParameter(listener, "it");
            listener.onHello(GatewaySocket.this);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$handleReconnect$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<WebSocket, Unit> {
        public final /* synthetic */ String $reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$reason = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
            invoke2(webSocket);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WebSocket webSocket) {
            if (webSocket != null) {
                webSocket.disconnect(4000, this.$reason);
            }
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$handleWebSocketClose$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Listener, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            m.checkNotNullParameter(listener, "it");
            listener.onDisconnected(GatewaySocket.this);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$handleWebSocketOpened$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Listener, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            m.checkNotNullParameter(listener, "it");
            listener.onConnected(GatewaySocket.this);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$presenceUpdate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ List $activities;
        public final /* synthetic */ Boolean $afk;
        public final /* synthetic */ Long $since;
        public final /* synthetic */ ClientStatus $status;

        /* compiled from: GatewaySocket.kt */
        /* renamed from: com.discord.gateway.GatewaySocket$presenceUpdate$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01871 extends o implements Function1<Activity, CharSequence> {
            public static final C01871 INSTANCE = new C01871();

            public C01871() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Activity activity) {
                return invoke2(activity);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Activity activity) {
                m.checkNotNullParameter(activity, "it");
                return activity.getName();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ClientStatus clientStatus, List list, Long l, Boolean bool) {
            super(0);
            this.$status = clientStatus;
            this.$activities = list;
            this.$since = l;
            this.$afk = bool;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            String strName;
            Companion companion = GatewaySocket.INSTANCE;
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbU = a.U("Sending self presence update: ");
            sbU.append(this.$status);
            sbU.append(' ');
            List list = this.$activities;
            String lowerCase = null;
            sbU.append(list != null ? u.joinToString$default(list, null, null, null, 0, null, C01871.INSTANCE, 31, null) : null);
            Companion.log$default(companion, loggerAccess$getLogger$p, sbU.toString(), false, 2, null);
            GatewaySocket gatewaySocket = GatewaySocket.this;
            Opcode opcode = Opcode.PRESENCE_UPDATE;
            ClientStatus clientStatus = this.$status;
            if (clientStatus != null && (strName = clientStatus.name()) != null) {
                Locale locale = Locale.ROOT;
                m.checkNotNullExpressionValue(locale, "Locale.ROOT");
                lowerCase = strName.toLowerCase(locale);
                m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            }
            Long l = this.$since;
            List listEmptyList = this.$activities;
            if (listEmptyList == null) {
                listEmptyList = n.emptyList();
            }
            GatewaySocket.send$default(gatewaySocket, new Outgoing(opcode, new OutgoingPayload.PresenceUpdate(lowerCase, l, listEmptyList, this.$afk)), false, null, 6, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$requestGuildMembers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ List $guildIds;
        public final /* synthetic */ Integer $limit;
        public final /* synthetic */ String $query;
        public final /* synthetic */ List $userIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list, String str, List list2, Integer num) {
            super(0);
            this.$guildIds = list;
            this.$query = str;
            this.$userIds = list2;
            this.$limit = num;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            OutgoingPayload.GuildMembersRequest guildMembersRequest = new OutgoingPayload.GuildMembersRequest(this.$guildIds, this.$query, this.$userIds, this.$limit, false, 16, null);
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), "Sending guild member request: " + guildMembersRequest, false, 2, null);
            GatewaySocket gatewaySocket = GatewaySocket.this;
            Outgoing outgoing = new Outgoing(Opcode.REQUEST_GUILD_MEMBERS, guildMembersRequest);
            Gson gsonAccess$getGsonOmitNulls$cp = GatewaySocket.access$getGsonOmitNulls$cp();
            m.checkNotNullExpressionValue(gsonAccess$getGsonOmitNulls$cp, "gsonOmitNulls");
            GatewaySocket.send$default(gatewaySocket, outgoing, false, gsonAccess$getGsonOmitNulls$cp, 2, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$resetOnError$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            GatewaySocket.access$setNextReconnectIsImmediate$p(GatewaySocket.this, false);
            GatewaySocket.handleReconnect$default(GatewaySocket.this, "encountered an error", false, 2, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$schedule$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Function0<? extends Unit>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Function0<? extends Unit> function0) {
            call2((Function0<Unit>) function0);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Function0<Unit> function0) {
            function0.invoke();
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$schedule$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Throwable> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$simulateReconnectForTesting$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            GatewaySocket.handleReconnect$default(GatewaySocket.this, null, false, 1, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$startHeartbeater$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            if (GatewaySocket.access$getHeartbeatAck$p(GatewaySocket.this)) {
                GatewaySocket.access$setHeartbeatAck$p(GatewaySocket.this, false);
                GatewaySocket gatewaySocket = GatewaySocket.this;
                GatewaySocket.access$heartbeat(gatewaySocket, GatewaySocket.access$getSeq$p(gatewaySocket));
            } else {
                if (GatewaySocket.access$getHeartbeatExpeditedTimeout$p(GatewaySocket.this).getPending()) {
                    return;
                }
                GatewaySocket.access$handleHeartbeatTimeout(GatewaySocket.this);
            }
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$streamDelete$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Companion companion = GatewaySocket.INSTANCE;
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbU = a.U("Sending STREAM_DELETE: ");
            sbU.append(this.$streamKey);
            Companion.log$default(companion, loggerAccess$getLogger$p, sbU.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.STREAM_DELETE, new OutgoingPayload.DeleteStream(this.$streamKey)), false, null, 6, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$streamPing$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Companion companion = GatewaySocket.INSTANCE;
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbU = a.U("Sending OPCODE_STREAM_PING: ");
            sbU.append(this.$streamKey);
            Companion.log$default(companion, loggerAccess$getLogger$p, sbU.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.OPCODE_STREAM_PING, new OutgoingPayload.StreamPing(this.$streamKey)), false, null, 6, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$streamWatch$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Companion companion = GatewaySocket.INSTANCE;
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbU = a.U("Sending STREAM_WATCH: ");
            sbU.append(this.$streamKey);
            Companion.log$default(companion, loggerAccess$getLogger$p, sbU.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.STREAM_WATCH, new OutgoingPayload.WatchStream(this.$streamKey)), false, null, 6, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$voiceServerPing$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), "Sending ping to voice server.", false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.VOICE_SERVER_PING, (Object) null), false, null, 6, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$voiceStateUpdate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ Long $channelId;
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ String $preferredRegion;
        public final /* synthetic */ boolean $selfDeaf;
        public final /* synthetic */ boolean $selfMute;
        public final /* synthetic */ boolean $selfVideo;
        public final /* synthetic */ boolean $shouldIncludePreferredRegion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l, Long l2, boolean z2, boolean z3, String str, boolean z4, boolean z5) {
            super(0);
            this.$guildId = l;
            this.$channelId = l2;
            this.$selfMute = z2;
            this.$selfDeaf = z3;
            this.$preferredRegion = str;
            this.$shouldIncludePreferredRegion = z4;
            this.$selfVideo = z5;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Companion companion = GatewaySocket.INSTANCE;
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbU = a.U("Sending voice state update for guild [");
            sbU.append(this.$guildId);
            sbU.append("] and channel [");
            sbU.append(this.$channelId);
            sbU.append("]. ");
            sbU.append("Muted: ");
            sbU.append(this.$selfMute);
            sbU.append(", deafened: ");
            sbU.append(this.$selfDeaf);
            sbU.append(", preferredRegion: ");
            sbU.append(this.$preferredRegion);
            Companion.log$default(companion, loggerAccess$getLogger$p, sbU.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.VOICE_STATE_UPDATE, this.$shouldIncludePreferredRegion ? new OutgoingPayload.VoiceStateUpdate(this.$guildId, this.$channelId, this.$selfMute, this.$selfDeaf, this.$selfVideo, this.$preferredRegion) : new OutgoingPayload.VoiceStateUpdateNoPreferredRegion(this.$guildId, this.$channelId, this.$selfMute, this.$selfDeaf, this.$selfVideo)), false, null, 6, null);
        }
    }

    static {
        e eVar = new e();
        eVar.g = true;
        c cVar = c.m;
        eVar.c = cVar;
        eVar.b(ActivityType.class, new ActivityTypeTypeAdapter());
        gsonIncludeNulls = eVar.a();
        e eVar2 = new e();
        eVar2.c = cVar;
        gsonOmitNulls = eVar2.a();
        EXPECTED_NULL_DATA_EVENTS = n0.setOf((Object[]) new String[]{"USER_SUBSCRIPTIONS_UPDATE", "USER_PAYMENT_SOURCES_UPDATE"});
        clock = ClockFactory.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GatewaySocket(Function0<IdentifyData> function0, Function1<? super Map<String, ? extends Object>, Unit> function1, GatewayEventHandler gatewayEventHandler, Scheduler scheduler, Logger logger, NetworkMonitor networkMonitor, RestConfig restConfig, Context context, Function1<? super String, String> function12, SSLSocketFactory sSLSocketFactory, Map<String, ? extends Object> map, GatewaySocketLogger gatewaySocketLogger) {
        m.checkNotNullParameter(function0, "identifyDataProvider");
        m.checkNotNullParameter(function1, "trackReadyPayload");
        m.checkNotNullParameter(gatewayEventHandler, "eventHandler");
        m.checkNotNullParameter(scheduler, "scheduler");
        m.checkNotNullParameter(logger, "logger");
        m.checkNotNullParameter(networkMonitor, "networkMonitor");
        m.checkNotNullParameter(restConfig, "restConfig");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(map, "identifyProperties");
        m.checkNotNullParameter(gatewaySocketLogger, "gatewaySocketLogger");
        this.identifyDataProvider = function0;
        this.trackReadyPayload = function1;
        this.eventHandler = gatewayEventHandler;
        this.scheduler = scheduler;
        this.logger = logger;
        this.gatewayUrlTransform = function12;
        this.sslSocketFactory = sSLSocketFactory;
        this.identifyProperties = map;
        this.gatewaySocketLogger = gatewaySocketLogger;
        Backoff backoff = new Backoff(1000L, 10000L, 4, true, new Timer(scheduler));
        this.gatewayBackoff = backoff;
        this.heartbeatExpeditedTimeout = new Timer(scheduler);
        this.heartbeatInterval = RecyclerView.FOREVER_NS;
        this.heartbeater = new Timer(scheduler);
        this.heartbeatAck = true;
        this.helloTimeout = new Timer(scheduler);
        ListenerCollectionSubject<Listener> listenerCollectionSubject = new ListenerCollectionSubject<>();
        this.listenerSubject = listenerCollectionSubject;
        this.listeners = listenerCollectionSubject;
        RestClient restClient = RestClient.INSTANCE;
        restClient.init(restConfig, context);
        this.gatewayDiscovery = new GatewayDiscovery(context, scheduler, backoff, new AnonymousClass1(), restClient.getGateway());
        Observable<Boolean> observableJ = networkMonitor.observeIsConnected().J(scheduler);
        Observable.h0(new r(observableJ.j, new w1(new v1(AnonymousClass2.INSTANCE)))).W(new AnonymousClass3(), new AnonymousClass4());
    }

    public static final /* synthetic */ void access$cleanup(GatewaySocket gatewaySocket, Function1 function1) {
        gatewaySocket.cleanup(function1);
    }

    public static final /* synthetic */ void access$connect(GatewaySocket gatewaySocket, String str) {
        gatewaySocket.connect(str);
    }

    public static final /* synthetic */ void access$discover(GatewaySocket gatewaySocket) {
        gatewaySocket.discover();
    }

    public static final /* synthetic */ void access$discoveryFailed(GatewaySocket gatewaySocket) {
        gatewaySocket.discoveryFailed();
    }

    public static final /* synthetic */ long access$getConnectionStartTime$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.connectionStartTime;
    }

    public static final /* synthetic */ int access$getConnectionState$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.connectionState;
    }

    public static final /* synthetic */ Backoff access$getGatewayBackoff$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.gatewayBackoff;
    }

    public static final /* synthetic */ GatewaySocketLogger access$getGatewaySocketLogger$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.gatewaySocketLogger;
    }

    public static final /* synthetic */ Function1 access$getGatewayUrlTransform$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.gatewayUrlTransform;
    }

    public static final /* synthetic */ Gson access$getGsonOmitNulls$cp() {
        return gsonOmitNulls;
    }

    public static final /* synthetic */ boolean access$getHeartbeatAck$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.heartbeatAck;
    }

    public static final /* synthetic */ Timer access$getHeartbeatExpeditedTimeout$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.heartbeatExpeditedTimeout;
    }

    public static final /* synthetic */ Logger access$getLogger$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.logger;
    }

    public static final /* synthetic */ boolean access$getNextReconnectIsImmediate$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.nextReconnectIsImmediate;
    }

    public static final /* synthetic */ int access$getSeq$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.seq;
    }

    public static final /* synthetic */ WebSocket access$getWebSocket$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.webSocket;
    }

    public static final /* synthetic */ void access$handleClose(GatewaySocket gatewaySocket, boolean z2, int i, String str) {
        gatewaySocket.handleClose(z2, i, str);
    }

    public static final /* synthetic */ void access$handleDeviceConnectivityChange(GatewaySocket gatewaySocket, boolean z2) {
        gatewaySocket.handleDeviceConnectivityChange(z2);
    }

    public static final /* synthetic */ void access$handleHeartbeatTimeout(GatewaySocket gatewaySocket) {
        gatewaySocket.handleHeartbeatTimeout();
    }

    public static final /* synthetic */ void access$handleWebSocketClose(GatewaySocket gatewaySocket, WebSocket.Closed closed) {
        gatewaySocket.handleWebSocketClose(closed);
    }

    public static final /* synthetic */ void access$handleWebSocketError(GatewaySocket gatewaySocket) {
        gatewaySocket.handleWebSocketError();
    }

    public static final /* synthetic */ void access$handleWebSocketMessage(GatewaySocket gatewaySocket, InputStreamReader inputStreamReader, int i) {
        gatewaySocket.handleWebSocketMessage(inputStreamReader, i);
    }

    public static final /* synthetic */ void access$handleWebSocketOpened(GatewaySocket gatewaySocket, String str) {
        gatewaySocket.handleWebSocketOpened(str);
    }

    public static final /* synthetic */ void access$heartbeat(GatewaySocket gatewaySocket, int i) throws JsonIOException {
        gatewaySocket.heartbeat(i);
    }

    public static final /* synthetic */ void access$logError(GatewaySocket gatewaySocket, String str, Exception exc, Map map) {
        gatewaySocket.logError(str, exc, map);
    }

    public static final /* synthetic */ void access$reset(GatewaySocket gatewaySocket, boolean z2, int i, String str) {
        gatewaySocket.reset(z2, i, str);
    }

    public static final /* synthetic */ void access$setConnectionStartTime$p(GatewaySocket gatewaySocket, long j) {
        gatewaySocket.connectionStartTime = j;
    }

    public static final /* synthetic */ void access$setConnectionState$p(GatewaySocket gatewaySocket, int i) {
        gatewaySocket.connectionState = i;
    }

    public static final /* synthetic */ void access$setHeartbeatAck$p(GatewaySocket gatewaySocket, boolean z2) {
        gatewaySocket.heartbeatAck = z2;
    }

    public static final /* synthetic */ void access$setHeartbeatExpeditedTimeout$p(GatewaySocket gatewaySocket, Timer timer) {
        gatewaySocket.heartbeatExpeditedTimeout = timer;
    }

    public static final /* synthetic */ void access$setNextReconnectIsImmediate$p(GatewaySocket gatewaySocket, boolean z2) {
        gatewaySocket.nextReconnectIsImmediate = z2;
    }

    public static final /* synthetic */ void access$setSeq$p(GatewaySocket gatewaySocket, int i) {
        gatewaySocket.seq = i;
    }

    public static final /* synthetic */ void access$setWebSocket$p(GatewaySocket gatewaySocket, WebSocket webSocket) {
        gatewaySocket.webSocket = webSocket;
    }

    private final void cleanup(Function1<? super WebSocket, Unit> callback) {
        stopHeartbeater();
        clearHelloTimeout();
        if (callback != null) {
            callback.invoke(this.webSocket);
        }
        WebSocket webSocket = this.webSocket;
        if (webSocket != null) {
            webSocket.resetListeners();
        }
        this.webSocket = null;
        this.gatewayBackoff.cancel();
    }

    private final void clearHelloTimeout() {
        this.helloTimeout.cancel();
    }

    public static /* synthetic */ void close$default(GatewaySocket gatewaySocket, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        gatewaySocket.close(z2);
    }

    private final void discover() {
        this.nextReconnectIsImmediate = false;
        if (this.connectionState != 1) {
            return;
        }
        this.listenerSubject.notify(new AnonymousClass1());
        this.gatewayDiscovery.discoverGatewayUrl(new AnonymousClass2(), new AnonymousClass3());
    }

    private final void discoveryFailed() {
        long jFail = this.gatewayBackoff.fail(new GatewaySocket$discoveryFailed$delay$1(this));
        Companion.log$default(INSTANCE, this.logger, "Discovery failed, retrying in " + jFail + "ms.", false, 2, null);
        if (this.gatewayBackoff.hasReachedFailureThreshold()) {
            reset(false, 0, "Gateway discovery failed.");
        }
    }

    private final void doIdentify() throws JsonIOException {
        this.seq = 0;
        this.sessionId = null;
        IdentifyData identifyDataInvoke = this.identifyDataProvider.invoke();
        if (identifyDataInvoke == null) {
            handleClose(true, CLOSE_CODE_UNAUTHORIZED, "No connection info provided.");
            return;
        }
        this.connectionState = 3;
        this.identifyStartTime = clock.currentTimeMillis();
        this.token = identifyDataInvoke.getToken();
        Companion.log$default(INSTANCE, this.logger, "Sending identify.", false, 2, null);
        send$default(this, new Outgoing(Opcode.IDENTIFY, new OutgoingPayload.Identify(identifyDataInvoke.getToken(), 100, true, CLIENT_CAPABILITIES, this.identifyProperties, identifyDataInvoke.getClientState())), false, null, 4, null);
    }

    private final void doResume() throws JsonIOException {
        this.connectionState = 4;
        this.replayedEvents = 0;
        Companion companion = INSTANCE;
        Logger logger = this.logger;
        StringBuilder sbU = a.U("Resuming session ");
        String str = this.sessionId;
        if (str == null) {
            str = "";
        }
        sbU.append(str);
        sbU.append(" at sequence: ");
        Companion.log$default(companion, logger, a.A(sbU, this.seq, '.'), false, 2, null);
        send$default(this, new Outgoing(Opcode.RESUME, new OutgoingPayload.Resume(this.token, this.sessionId, this.seq)), false, null, 4, null);
    }

    private final void doResumeOrIdentify() throws JsonIOException {
        Companion companion = INSTANCE;
        long delay$default = Companion.getDelay$default(companion, this.heartbeatAckTimeMostRecent, null, 2, null);
        float f = this.heartbeatAckTimeMostRecent == 0 ? 0.0f : (delay$default / 1000.0f) / 60.0f;
        if (this.sessionId != null && delay$default <= ((long) HEARTBEAT_MAX_RESUME_THRESHOLD)) {
            Logger logger = this.logger;
            StringBuilder sbU = a.U("Attempting to resume after elapsed duration of ");
            String str = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
            m.checkNotNullExpressionValue(str, "java.lang.String.format(this, *args)");
            sbU.append(str);
            sbU.append(" minutes.");
            Companion.log$default(companion, logger, sbU.toString(), false, 2, null);
            doResume();
        } else {
            handleInvalidSession(false);
        }
        this.heartbeatAckTimeMostRecent = clock.currentTimeMillis();
    }

    public static /* synthetic */ void expeditedHeartbeat$default(GatewaySocket gatewaySocket, long j, String str, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        gatewaySocket.expeditedHeartbeat(j, str, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void flattenTraces(Object trace, ArrayList<Pair<String, Integer>> result) {
        if (trace == null) {
            return;
        }
        try {
            if (!e0.isMutableList(trace)) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i2 >= ((List) trace).size()) {
                    return;
                }
                Object obj = ((List) trace).get(i);
                Number number = null;
                if (!(obj instanceof String)) {
                    obj = null;
                }
                String str = (String) obj;
                Object obj2 = ((List) trace).get(i2);
                if (!e0.isMutableMap(obj2)) {
                    obj2 = null;
                }
                Map map = (Map) obj2;
                i += 2;
                if (str != null && map != null) {
                    if (map.containsKey("micros")) {
                        Object obj3 = map.get("micros");
                        if (obj3 instanceof Number) {
                            number = obj3;
                        }
                        number = number;
                    }
                    if (number != null) {
                        result.add(new Pair<>(str, Integer.valueOf(number.intValue() / 1000)));
                    }
                    flattenTraces(map.get("calls"), result);
                }
            }
        } catch (Exception e) {
            Logger.e$default(this.logger, "Unable to parse ready payload traces", e, null, 4, null);
        }
    }

    private final String getConnectionPath(ModelPayload.Hello hello) {
        String strJoinToString$default;
        List<String> trace = hello.getTrace();
        return (trace == null || (strJoinToString$default = u.joinToString$default(trace, " -> ", null, null, 0, null, null, 62, null)) == null) ? "???" : strJoinToString$default;
    }

    private final void handleClose(boolean wasClean, int code, String reason) {
        cleanup(AnonymousClass1.INSTANCE);
        handleConnected$default(this, null, Boolean.FALSE, 1, null);
        if (code == CLOSE_CODE_UNAUTHORIZED) {
            this.connectionState = 0;
            reset(wasClean, code, reason);
            return;
        }
        this.connectionState = 1;
        StringBuilder sb = new StringBuilder();
        sb.append("Closed cleanly: ");
        sb.append(wasClean);
        sb.append(", with code: ");
        sb.append(code);
        sb.append(", for reason: '");
        String strJ = a.J(sb, reason, "'.");
        if (this.nextReconnectIsImmediate) {
            Companion.log$default(INSTANCE, this.logger, a.w(strJ, " Retrying immediately."), false, 2, null);
            discover();
            return;
        }
        long jFail = this.gatewayBackoff.fail(new GatewaySocket$handleClose$delay$1(this));
        Companion.log$default(INSTANCE, this.logger, strJ + " Retrying in: " + jFail + "ms.", false, 2, null);
        if (this.gatewayBackoff.hasReachedFailureThreshold()) {
            reset(wasClean, code, reason);
        }
    }

    private final void handleConnected(Boolean connected, Boolean connectionReady) {
        if (connected != null) {
            boolean zBooleanValue = connected.booleanValue();
            this.connected = zBooleanValue;
            this.hasConnectedOnce = this.hasConnectedOnce || zBooleanValue;
            this.eventHandler.handleConnected(zBooleanValue);
        }
        if (connectionReady != null) {
            boolean zBooleanValue2 = connectionReady.booleanValue();
            this.connectionReady = zBooleanValue2;
            this.eventHandler.handleConnectionReady(zBooleanValue2);
        }
    }

    public static /* synthetic */ void handleConnected$default(GatewaySocket gatewaySocket, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        if ((i & 2) != 0) {
            bool2 = null;
        }
        gatewaySocket.handleConnected(bool, bool2);
    }

    private final void handleDeviceConnectivityChange(boolean isConnected) {
        if (isConnected) {
            expeditedHeartbeat$default(this, 4500L, "network detected online", false, 4, null);
        } else {
            expeditedHeartbeat$default(this, 9000L, "network detected offline", false, 4, null);
        }
    }

    private final void handleDispatch(Object data, String type, int compressedByteSize, int uncompressedByteSize, long unpackDurationMs) {
        if (this.connectionState == 4) {
            this.replayedEvents++;
        }
        if (m.areEqual(type, "READY") || m.areEqual(type, "RESUMED")) {
            if (type != null) {
                int iHashCode = type.hashCode();
                if (iHashCode != 77848963) {
                    if (iHashCode == 1815529911 && type.equals("RESUMED")) {
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sbU = a.U("Resumed session, took ");
                        Companion companion = INSTANCE;
                        sbU.append(Companion.getDelay$default(companion, this.connectionStartTime, null, 2, null));
                        sbU.append("ms, ");
                        sb.append(sbU.toString());
                        sb.append("replayed " + this.replayedEvents + " events, new seq: " + this.seq + '.');
                        String string = sb.toString();
                        m.checkNotNullExpressionValue(string, "StringBuilder()\n        …              .toString()");
                        Companion.log$default(companion, this.logger, string, false, 2, null);
                        this.replayedEvents = 0;
                    }
                } else if (type.equals("READY")) {
                    ModelPayload modelPayload = (ModelPayload) data;
                    if (modelPayload == null) {
                        handleReconnect$default(this, "Reconnect due to invalid ready payload received.", false, 2, null);
                        return;
                    }
                    this.sessionId = modelPayload.getSessionId();
                    trackReadyPayload(modelPayload, compressedByteSize, uncompressedByteSize, unpackDurationMs);
                    Companion companion2 = INSTANCE;
                    Logger logger = this.logger;
                    StringBuilder sbU2 = a.U("Ready with session id: ");
                    sbU2.append(this.sessionId);
                    sbU2.append(", took ");
                    Companion.log$default(companion2, logger, a.C(sbU2, Companion.getDelay$default(companion2, this.connectionStartTime, null, 2, null), "ms"), false, 2, null);
                }
            }
            this.gatewayBackoff.succeed();
            this.connectionState = 5;
            Boolean bool = Boolean.TRUE;
            handleConnected(bool, bool);
        }
        if (data != null) {
            this.eventHandler.handleDispatch(type, data);
            return;
        }
        if (u.contains(EXPECTED_NULL_DATA_EVENTS, type)) {
            this.eventHandler.handleDispatch(type, Unit.a);
        } else if ((!m.areEqual(type, "READY")) && (!m.areEqual(type, "RESUMED"))) {
            Logger.w$default(this.logger, a.y("handleDispatch() ", type, " is unhandled!"), null, 2, null);
        }
    }

    private final void handleHeartbeat() throws JsonIOException {
        heartbeat(this.seq);
    }

    private final void handleHeartbeatAck() {
        Companion.access$log(INSTANCE, this.logger, "Received heartbeat ACK.", false);
        this.heartbeatAckTimeMostRecent = clock.currentTimeMillis();
        this.heartbeatAck = true;
        this.heartbeatExpeditedTimeout.cancel(new AnonymousClass1());
    }

    private final void handleHeartbeatTimeout() {
        cleanup(AnonymousClass1.INSTANCE);
        this.connectionState = 1;
        long jFail = this.gatewayBackoff.fail(new GatewaySocket$handleHeartbeatTimeout$delay$1(this));
        Companion.log$default(INSTANCE, this.logger, "Ack timeout, reconnecting om " + jFail + "ms.", false, 2, null);
    }

    private final void handleHello(ModelPayload.Hello data) {
        this.listenerSubject.notify(new AnonymousClass1());
        clearHelloTimeout();
        this.heartbeatInterval = data.getHeartbeatInterval();
        Companion companion = INSTANCE;
        Logger logger = this.logger;
        StringBuilder sbU = a.U("Hello via ");
        sbU.append(getConnectionPath(data));
        sbU.append(", at interval ");
        sbU.append(this.heartbeatInterval);
        sbU.append(" took ");
        Companion.log$default(companion, logger, a.C(sbU, Companion.getDelay$default(companion, this.connectionStartTime, null, 2, null), "ms."), false, 2, null);
        startHeartbeater();
    }

    private final void handleInvalidSession(boolean canResume) throws JsonIOException {
        Companion.log$default(INSTANCE, this.logger, a.J(a.U("Invalid session, is "), canResume ? "" : "not", " resumable."), false, 2, null);
        if (canResume) {
            doResumeOrIdentify();
            return;
        }
        Boolean bool = Boolean.FALSE;
        handleConnected(bool, bool);
        doIdentify();
    }

    private final void handleReconnect(String reason, boolean resetSession) {
        cleanup(new AnonymousClass1(reason));
        reset(!resetSession, resetSession ? 1000 : 4000, reason);
        handleClose(!resetSession, 0, reason);
    }

    public static /* synthetic */ void handleReconnect$default(GatewaySocket gatewaySocket, String str, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "Reconnect to gateway requested.";
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        gatewaySocket.handleReconnect(str, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleWebSocketClose(WebSocket.Closed closed) {
        String reason = closed.getReason();
        if (reason == null) {
            reason = "unspecified reason";
        } else {
            if (!(reason.length() > 0)) {
            }
        }
        this.listenerSubject.notify(new AnonymousClass1());
        handleClose(true, closed.getCode(), reason);
    }

    private final void handleWebSocketError() {
        handleClose(false, 0, "An error with the web socket occurred.");
    }

    private final void handleWebSocketMessage(InputStreamReader reader, int compressedByteSize) throws JsonIOException {
        long jCurrentTimeMillis = clock.currentTimeMillis();
        SizeRecordingInputStreamReader sizeRecordingInputStreamReader = new SizeRecordingInputStreamReader(reader, 0, 2, null);
        Incoming incomingBuild = ((IncomingParser) new Model.JsonReader(new JsonReader(sizeRecordingInputStreamReader)).parse(new IncomingParser(new GatewaySocket$handleWebSocketMessage$incomingParser$1(this)))).build();
        Integer seq = incomingBuild.getSeq();
        Companion companion = INSTANCE;
        long delay$default = Companion.getDelay$default(companion, jCurrentTimeMillis, null, 2, null);
        if (seq != null) {
            this.seq = seq.intValue();
        }
        int iOrdinal = incomingBuild.getOpcode().ordinal();
        if (iOrdinal == 1) {
            handleDispatch(incomingBuild.getData(), incomingBuild.getType(), compressedByteSize, sizeRecordingInputStreamReader.getSize(), delay$default);
        }
        if (iOrdinal == 2) {
            handleHeartbeat();
            return;
        }
        if (iOrdinal == 8) {
            handleReconnect$default(this, null, false, 1, null);
            return;
        }
        switch (iOrdinal) {
            case 10:
                Object data = incomingBuild.getData();
                Objects.requireNonNull(data, "null cannot be cast to non-null type kotlin.Boolean");
                handleInvalidSession(((Boolean) data).booleanValue());
                break;
            case 11:
                Object data2 = incomingBuild.getData();
                Objects.requireNonNull(data2, "null cannot be cast to non-null type com.discord.models.domain.ModelPayload.Hello");
                handleHello((ModelPayload.Hello) data2);
                break;
            case 12:
                handleHeartbeatAck();
                break;
            default:
                Logger logger = this.logger;
                StringBuilder sbU = a.U("Unhandled op code ");
                sbU.append(incomingBuild.getOpcode());
                sbU.append('.');
                Companion.log$default(companion, logger, sbU.toString(), false, 2, null);
                break;
        }
    }

    private final void handleWebSocketOpened(String gatewayUrl) throws JsonIOException {
        Companion companion = INSTANCE;
        Companion.log$default(companion, this.logger, a.C(a.Y("Connected to ", gatewayUrl, " in "), Companion.getDelay$default(companion, this.connectionStartTime, null, 2, null), "ms."), false, 2, null);
        this.listenerSubject.notify(new AnonymousClass1());
        doResumeOrIdentify();
    }

    private final void heartbeat(int seq) throws JsonIOException {
        Companion.access$log(INSTANCE, this.logger, "Sending heartbeat at sequence: " + seq + '.', false);
        send$default(this, new Outgoing(Opcode.HEARTBEAT, Integer.valueOf(seq)), false, null, 4, null);
    }

    private final void logError(String message, Exception exception, Map<String, String> metadata) {
        Logger logger = this.logger;
        if (metadata == null) {
            metadata = h0.emptyMap();
        }
        logger.e(message, exception, metadata);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void presenceUpdate$default(GatewaySocket gatewaySocket, ClientStatus clientStatus, Long l, List list, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            l = Long.valueOf(clock.currentTimeMillis());
        }
        if ((i & 4) != 0) {
            list = null;
        }
        if ((i & 8) != 0) {
            bool = Boolean.FALSE;
        }
        gatewaySocket.presenceUpdate(clientStatus, l, list, bool);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void requestGuildMembers$default(GatewaySocket gatewaySocket, List list, String str, List list2, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            list2 = null;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        gatewaySocket.requestGuildMembers(list, str, list2, num);
    }

    private final void reset(boolean wasClean, int code, String reason) {
        if (code != 4000) {
            this.sessionId = null;
            this.seq = 0;
        }
        String str = wasClean ? "cleanly" : "dirty";
        Companion.log$default(INSTANCE, this.logger, "Reset " + str + ", with code " + code + ", at sequence " + this.seq + ". Reason: '" + reason + "'.", false, 2, null);
        handleConnected(Boolean.valueOf(code == 4000 && this.connected), Boolean.FALSE);
        this.eventHandler.handleDisconnect(code == CLOSE_CODE_UNAUTHORIZED);
    }

    private final void schedule(Function0<Unit> callback) {
        new j0.l.e.k(callback).X(this.scheduler).W(AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE);
    }

    private final void send(Outgoing data, boolean checkSessionEstablished, Gson gson) throws JsonIOException {
        if (checkSessionEstablished && !isSessionEstablished()) {
            Companion companion = INSTANCE;
            Logger logger = this.logger;
            StringBuilder sbU = a.U("Attempted to send while not being in a connected state, opcode: ");
            sbU.append(data.getOp());
            sbU.append('.');
            Companion.log$default(companion, logger, sbU.toString(), false, 2, null);
            return;
        }
        WebSocket webSocket = this.webSocket;
        if (webSocket != null) {
            String strM = gson.m(data);
            GatewaySocketLogger gatewaySocketLogger = this.gatewaySocketLogger;
            m.checkNotNullExpressionValue(strM, GATEWAY_ENCODING);
            gatewaySocketLogger.logOutboundMessage(strM);
            webSocket.message(strM);
            return;
        }
        Companion companion2 = INSTANCE;
        Logger logger2 = this.logger;
        StringBuilder sbU2 = a.U("Attempted to send without a web socket that exists, opcode: ");
        sbU2.append(data.getOp());
        sbU2.append('.');
        Companion.log$default(companion2, logger2, sbU2.toString(), false, 2, null);
    }

    public static /* synthetic */ void send$default(GatewaySocket gatewaySocket, Outgoing outgoing, boolean z2, Gson gson, int i, Object obj) throws JsonIOException {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            gson = gsonIncludeNulls;
            m.checkNotNullExpressionValue(gson, "gsonIncludeNulls");
        }
        gatewaySocket.send(outgoing, z2, gson);
    }

    private final void startHeartbeater() {
        this.heartbeater.cancel();
        this.heartbeatAck = true;
        this.heartbeater.postInterval(new AnonymousClass1(), this.heartbeatInterval);
    }

    private final void stopHeartbeater() {
        this.heartbeater.cancel();
        this.heartbeatExpeditedTimeout.cancel();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void trackReadyPayload(ModelPayload payload, int compressedByteSize, int uncompressedByteSize, long unpackDurationMs) {
        int iIntValue;
        int size = payload.getGuilds().size();
        Iterator<Guild> it = payload.getGuilds().iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            List<Channel> listG = it.next().g();
            if (listG != null) {
                Iterator<T> it2 = listG.iterator();
                while (it2.hasNext()) {
                    i++;
                    if (((Channel) it2.next()).getType() == 4) {
                        i2++;
                    }
                }
            }
        }
        ArrayList<Pair<String, Integer>> arrayList = new ArrayList<>();
        flattenTraces(payload.getTrace(), arrayList);
        if (arrayList.size() > 0) {
            Pair<String, Integer> pair = arrayList.get(0);
            String strComponent1 = pair.component1();
            iIntValue = pair.component2().intValue();
            if (!t.startsWith$default(strComponent1, "gateway-", false, 2, null)) {
                iIntValue = 0;
            }
        }
        Iterator<Pair<String, Integer>> it3 = arrayList.iterator();
        int i3 = 0;
        int i4 = 0;
        while (it3.hasNext()) {
            Pair<String, Integer> next = it3.next();
            String strComponent12 = next.component1();
            int iIntValue2 = next.component2().intValue();
            if (m.areEqual(strComponent12, "start_session")) {
                i3 = iIntValue2;
            } else if (m.areEqual(strComponent12, "guilds_connect")) {
                i4 = iIntValue2;
            }
        }
        Function1<Map<String, ? extends Object>, Unit> function1 = this.trackReadyPayload;
        Companion companion = INSTANCE;
        function1.invoke(h0.mapOf(d0.o.to("duration_ms_since_connection_start", Long.valueOf(Companion.getDelay$default(companion, this.connectionStartTime, null, 2, null))), d0.o.to("duration_ms_since_identify_start", Long.valueOf(Companion.getDelay$default(companion, this.identifyStartTime, null, 2, null))), d0.o.to("identify_total_server_duration_ms", Integer.valueOf(iIntValue)), d0.o.to("identify_api_duration_ms", Integer.valueOf(i3)), d0.o.to("identify_guilds_duration_ms", Integer.valueOf(i4)), d0.o.to("compressed_byte_size", Integer.valueOf(compressedByteSize)), d0.o.to("uncompressed_byte_size", Integer.valueOf(uncompressedByteSize)), d0.o.to("compression_algorithm", "zlib"), d0.o.to("packing_algorithm", GATEWAY_ENCODING), d0.o.to("unpack_duration_ms", Long.valueOf(unpackDurationMs)), d0.o.to("is_reconnect", Boolean.valueOf(this.hasConnectedOnce)), d0.o.to("is_fast_connect", Boolean.FALSE), d0.o.to("num_guilds", Integer.valueOf(size)), d0.o.to("num_guild_channels", Integer.valueOf(i)), d0.o.to("num_guild_category_channels", Integer.valueOf(i2))));
    }

    public final void callConnect(long channelId) {
        schedule(new AnonymousClass1(channelId));
    }

    public final void close(boolean clean) {
        schedule(new AnonymousClass1(clean));
    }

    public final void connect() {
        schedule(new AnonymousClass1());
    }

    public final void expeditedHeartbeat(long timeout, String reason, boolean shouldResetBackoff) {
        schedule(new AnonymousClass1(reason, timeout, shouldResetBackoff));
    }

    public final ListenerCollection<Listener> getListeners() {
        return this.listeners;
    }

    public final boolean isSessionEstablished() {
        return this.connectionState == 5;
    }

    public final void presenceUpdate(ClientStatus status, Long since, List<Activity> activities, Boolean afk) {
        schedule(new AnonymousClass1(status, activities, since, afk));
    }

    public final void requestApplicationCommands(OutgoingPayload.ApplicationCommandRequest request) {
        m.checkNotNullParameter(request, "request");
        Outgoing outgoing = new Outgoing(Opcode.REQUEST_GUILD_APPLICATION_COMMANDS, request);
        Gson gson = gsonOmitNulls;
        m.checkNotNullExpressionValue(gson, "gsonOmitNulls");
        send$default(this, outgoing, false, gson, 2, null);
    }

    public final void requestForumUnreads(OutgoingPayload.ForumUnreadsRequest request) {
        m.checkNotNullParameter(request, "request");
        Outgoing outgoing = new Outgoing(Opcode.REQUEST_FORUM_UNREADS, request);
        Gson gson = gsonOmitNulls;
        m.checkNotNullExpressionValue(gson, "gsonOmitNulls");
        send$default(this, outgoing, false, gson, 2, null);
    }

    public final void requestGuildMembers(List<Long> list) {
        requestGuildMembers$default(this, list, null, null, null, 14, null);
    }

    public final void requestGuildMembers(List<Long> list, String str) {
        requestGuildMembers$default(this, list, str, null, null, 12, null);
    }

    public final void requestGuildMembers(List<Long> list, String str, List<Long> list2) {
        requestGuildMembers$default(this, list, str, list2, null, 8, null);
    }

    public final void requestGuildMembers(List<Long> guildIds, String query, List<Long> userIds, Integer limit) {
        m.checkNotNullParameter(guildIds, "guildIds");
        schedule(new AnonymousClass1(guildIds, query, userIds, limit));
    }

    public final void resetOnError() {
        schedule(new AnonymousClass1());
    }

    public final void simulateReconnectForTesting() {
        schedule(new AnonymousClass1());
    }

    public final void streamCreate(String streamType, long channelId, Long guildId, String preferredRegion) {
        m.checkNotNullParameter(streamType, "streamType");
        Companion.log$default(INSTANCE, this.logger, "Sending STREAM_CREATE: " + channelId + ' ' + guildId, false, 2, null);
        send$default(this, new Outgoing(Opcode.STREAM_CREATE, new OutgoingPayload.CreateStream(streamType, channelId, guildId, preferredRegion)), false, null, 6, null);
    }

    public final void streamDelete(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        schedule(new AnonymousClass1(streamKey));
    }

    public final void streamPing(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        schedule(new AnonymousClass1(streamKey));
    }

    public final void streamWatch(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        schedule(new AnonymousClass1(streamKey));
    }

    public final void updateGuildSubscriptions(long guildId, OutgoingPayload.GuildSubscriptions guildSubscriptions) {
        m.checkNotNullParameter(guildSubscriptions, "guildSubscriptions");
        Companion.log$default(INSTANCE, this.logger, "sending guild subscriptions: " + guildId + " -- " + guildSubscriptions, false, 2, null);
        Opcode opcode = Opcode.GUILD_SUBSCRIPTIONS;
        Boolean typing = guildSubscriptions.getTyping();
        Boolean activities = guildSubscriptions.getActivities();
        List<Long> members = guildSubscriptions.getMembers();
        Outgoing outgoing = new Outgoing(opcode, new OutgoingPayload.GuildSubscriptionsUpdate(guildId, typing, activities, members != null ? u.toList(members) : null, guildSubscriptions.getChannels(), guildSubscriptions.getThreads(), guildSubscriptions.getThreadMemberLists()));
        Gson gson = gsonOmitNulls;
        m.checkNotNullExpressionValue(gson, "gsonOmitNulls");
        send$default(this, outgoing, false, gson, 2, null);
    }

    public final void voiceServerPing() {
        schedule(new AnonymousClass1());
    }

    public final void voiceStateUpdate(Long guildId, Long channelId, boolean selfMute, boolean selfDeaf, boolean selfVideo, String preferredRegion, boolean shouldIncludePreferredRegion) {
        schedule(new AnonymousClass1(guildId, channelId, selfMute, selfDeaf, preferredRegion, shouldIncludePreferredRegion, selfVideo));
    }

    private final void connect(String gatewayUrl) {
        GatewaySocket$connect$$inlined$apply$lambda$4 gatewaySocket$connect$$inlined$apply$lambda$4;
        if (this.connectionState != 1) {
            return;
        }
        this.connectionState = 2;
        Companion.log$default(INSTANCE, this.logger, a.y("Connect to: ", gatewayUrl, ", encoding: json, version 9."), false, 2, null);
        cleanup(AnonymousClass2.INSTANCE);
        this.connectionStartTime = clock.currentTimeMillis();
        this.helloTimeout.schedule(new AnonymousClass3(), HELLO_TIMEOUT);
        WebSocket webSocket = new WebSocket(this.scheduler, new AnonymousClass4(this), this.sslSocketFactory);
        webSocket.setOnOpened(new GatewaySocket$connect$$inlined$apply$lambda$1(this, gatewayUrl));
        webSocket.setOnClosed(new GatewaySocket$connect$$inlined$apply$lambda$2(this, gatewayUrl));
        webSocket.setOnMessage(new GatewaySocket$connect$$inlined$apply$lambda$3(this, gatewayUrl));
        int iOrdinal = this.gatewaySocketLogger.getLogLevel().ordinal();
        if (iOrdinal == 0) {
            gatewaySocket$connect$$inlined$apply$lambda$4 = null;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            gatewaySocket$connect$$inlined$apply$lambda$4 = new GatewaySocket$connect$$inlined$apply$lambda$4(this, gatewayUrl);
        }
        webSocket.setRawMessageHandler(gatewaySocket$connect$$inlined$apply$lambda$4);
        webSocket.setOnError(new GatewaySocket$connect$$inlined$apply$lambda$5(this, gatewayUrl));
        webSocket.connect(gatewayUrl + "/?encoding=json&v=9&compress=zlib-stream");
        this.webSocket = webSocket;
    }

    public /* synthetic */ GatewaySocket(Function0 function0, Function1 function1, GatewayEventHandler gatewayEventHandler, Scheduler scheduler, Logger logger, NetworkMonitor networkMonitor, RestConfig restConfig, Context context, Function1 function12, SSLSocketFactory sSLSocketFactory, Map map, GatewaySocketLogger gatewaySocketLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, function1, gatewayEventHandler, scheduler, logger, networkMonitor, restConfig, context, (i & 256) != 0 ? null : function12, (i & 512) != 0 ? null : sSLSocketFactory, (i & 1024) != 0 ? h0.emptyMap() : map, gatewaySocketLogger);
    }
}
