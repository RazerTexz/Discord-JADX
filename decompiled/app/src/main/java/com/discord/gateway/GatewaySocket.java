package com.discord.gateway;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityType;
import com.discord.api.activity.ActivityType2;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.presence.ClientStatus;
import com.discord.gateway.GatewaySocketLogger;
import com.discord.gateway.opcodes.Opcode;
import com.discord.gateway.p498io.Incoming;
import com.discord.gateway.p498io.Incoming2;
import com.discord.gateway.p498io.Outgoing;
import com.discord.gateway.p498io.Outgoing2;
import com.discord.gateway.rest.RestClient;
import com.discord.gateway.rest.RestConfig;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.collections.ListenerCollection;
import com.discord.utilities.collections.ListenerCollection2;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.Backoff;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.websocket.WebSocket;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonReader;
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
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p408d.FieldNamingPolicy;
import p007b.p225i.p408d.GsonBuilder;
import p507d0.Tuples;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Collections2;
import p507d0.p580t.Maps6;
import p507d0.p580t.Sets5;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.TypeIntrinsics;
import p637j0.p641k.Func1;
import p637j0.p642l.p643a.OnSubscribeLift;
import p637j0.p642l.p643a.OperatorSkipWhile2;
import p637j0.p642l.p643a.OperatorSkipWhile3;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p637j0.p653p.Schedulers2;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscription;
import p658rx.functions.Action1;

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
    private final ListenerCollection2<Listener> listenerSubject;
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
    /* renamed from: com.discord.gateway.GatewaySocket$1 */
    public static final class C54861 extends Lambda implements Function1<String, Unit> {
        public C54861() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "message");
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), str, false, 2, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$2 */
    public static final class C54872<T, R> implements Func1<Boolean, Boolean> {
        public static final C54872 INSTANCE = new C54872();

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Boolean bool) {
            return bool;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Boolean bool) {
            return call2(bool);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$3 */
    public static final class C54883<T> implements Action1<Boolean> {
        public C54883() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            GatewaySocket gatewaySocket = GatewaySocket.this;
            Intrinsics3.checkNotNullExpressionValue(bool, "isConnected");
            GatewaySocket.access$handleDeviceConnectivityChange(gatewaySocket, bool.booleanValue());
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$4 */
    public static final class C54894<T> implements Action1<Throwable> {
        public C54894() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbM833U = outline.m833U("failed to handle connectivity change in ");
            sbM833U.append(GatewaySocket.this.getClass().getSimpleName());
            Logger.e$default(loggerAccess$getLogger$p, sbM833U.toString(), th, null, 4, null);
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
            Logger.v$default(logger, outline.m883w("[GatewaySocket] ", str), null, 2, null);
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
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        }

        @Override // com.discord.gateway.GatewaySocket.Listener
        public void onConnecting(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        }

        @Override // com.discord.gateway.GatewaySocket.Listener
        public void onDisconnected(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        }

        @Override // com.discord.gateway.GatewaySocket.Listener
        public void onHello(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        }
    }

    /* compiled from: GatewaySocket.kt */
    public static final class IdentifyData {
        private final Outgoing2.IdentifyClientState clientState;
        private final String token;

        public IdentifyData(String str, Outgoing2.IdentifyClientState identifyClientState) {
            Intrinsics3.checkNotNullParameter(str, "token");
            this.token = str;
            this.clientState = identifyClientState;
        }

        public final Outgoing2.IdentifyClientState getClientState() {
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
            Intrinsics3.checkNotNullParameter(inputStreamReader, "source");
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
            Intrinsics3.checkNotNullParameter(buffer, "buffer");
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
            Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
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
            Intrinsics3.checkNotNullParameter(callback, "callback");
            cancel();
            this.subscription = Observable.m11062F(delayMillis, delayMillis, TimeUnit.MILLISECONDS, Schedulers2.m10873a()).m11084J(this.scheduler).m11097W(new GatewaySocket$Timer$postInterval$1(callback), GatewaySocket$Timer$postInterval$2.INSTANCE);
        }

        @Override // com.discord.utilities.networking.Backoff.Scheduler
        public void schedule(Function0<Unit> action, long delayMs) {
            Intrinsics3.checkNotNullParameter(action, "action");
            cancel();
            this.subscription = Observable.m11068d0(delayMs, TimeUnit.MILLISECONDS).m11084J(this.scheduler).m11097W(new GatewaySocket$Timer$schedule$1(this, action), GatewaySocket$Timer$schedule$2.INSTANCE);
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
    /* renamed from: com.discord.gateway.GatewaySocket$callConnect$1 */
    public static final class C54901 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C54901(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Companion companion = GatewaySocket.INSTANCE;
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbM833U = outline.m833U("Sending call connect sync on channel id: ");
            sbM833U.append(this.$channelId);
            sbM833U.append('.');
            Companion.log$default(companion, loggerAccess$getLogger$p, sbM833U.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.CALL_CONNECT, new Outgoing2.CallConnect(this.$channelId)), false, null, 6, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$close$1 */
    public static final class C54911 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $clean;

        /* compiled from: GatewaySocket.kt */
        /* renamed from: com.discord.gateway.GatewaySocket$close$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<WebSocket, Unit> {
            public final /* synthetic */ int $code;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(int i) {
                super(1);
                this.$code = i;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
                invoke2(webSocket);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WebSocket webSocket) {
                if (webSocket != null) {
                    WebSocket.disconnect$default(webSocket, this.$code, null, 2, null);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C54911(boolean z2) {
            super(0);
            this.$clean = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (GatewaySocket.access$getConnectionState$p(GatewaySocket.this) == 0) {
                return;
            }
            int i = this.$clean ? 1000 : 4000;
            GatewaySocket.access$cleanup(GatewaySocket.this, new AnonymousClass1(i));
            GatewaySocket.access$setConnectionState$p(GatewaySocket.this, 0);
            GatewaySocket.access$reset(GatewaySocket.this, this.$clean, i, "Disconnect requested by client");
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$connect$1 */
    public static final class C54921 extends Lambda implements Function0<Unit> {
        public C54921() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
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
    /* renamed from: com.discord.gateway.GatewaySocket$connect$2 */
    public static final class C54932 extends Lambda implements Function1<WebSocket, Unit> {
        public static final C54932 INSTANCE = new C54932();

        public C54932() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
            invoke2(webSocket);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WebSocket webSocket) {
            if (webSocket != null) {
                webSocket.disconnect(4000, "Connect called with an existing web socket.");
            }
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$connect$3 */
    public static final class C54943 extends Lambda implements Function0<Unit> {
        public C54943() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            GatewaySocket gatewaySocket = GatewaySocket.this;
            StringBuilder sbM833U = outline.m833U("Connection timed out after ");
            sbM833U.append(Companion.getDelay$default(GatewaySocket.INSTANCE, GatewaySocket.access$getConnectionStartTime$p(GatewaySocket.this), null, 2, null));
            sbM833U.append("ms, did not receive hello in time.");
            GatewaySocket.access$handleClose(gatewaySocket, false, 0, sbM833U.toString());
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$connect$4 */
    public static final /* synthetic */ class C54954 extends FunctionReferenceImpl implements Function3<String, Exception, Map<String, ? extends String>, Unit> {
        public C54954(GatewaySocket gatewaySocket) {
            super(3, gatewaySocket, GatewaySocket.class, "logError", "logError(Ljava/lang/String;Ljava/lang/Exception;Ljava/util/Map;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(String str, Exception exc, Map<String, ? extends String> map) {
            invoke2(str, exc, (Map<String, String>) map);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str, Exception exc, Map<String, String> map) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            Intrinsics3.checkNotNullParameter(exc, "p2");
            GatewaySocket.access$logError((GatewaySocket) this.receiver, str, exc, map);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$discover$1 */
    public static final class C54961 extends Lambda implements Function1<Listener, Unit> {
        public C54961() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onConnecting(GatewaySocket.this);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$discover$2 */
    public static final class C54972 extends Lambda implements Function1<String, Unit> {
        public C54972() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            String str2;
            Intrinsics3.checkNotNullParameter(str, "gatewayUrl");
            GatewaySocket gatewaySocket = GatewaySocket.this;
            Function1 function1Access$getGatewayUrlTransform$p = GatewaySocket.access$getGatewayUrlTransform$p(gatewaySocket);
            if (function1Access$getGatewayUrlTransform$p != null && (str2 = (String) function1Access$getGatewayUrlTransform$p.invoke(str)) != null) {
                str = str2;
            }
            GatewaySocket.access$connect(gatewaySocket, str);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$discover$3 */
    public static final class C54983 extends Lambda implements Function1<Throwable, Unit> {
        public C54983() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            Intrinsics3.checkNotNullParameter(th, "it");
            GatewaySocket.access$discoveryFailed(GatewaySocket.this);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$expeditedHeartbeat$1 */
    public static final class C54991 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $reason;
        public final /* synthetic */ boolean $shouldResetBackoff;
        public final /* synthetic */ long $timeout;

        /* compiled from: GatewaySocket.kt */
        /* renamed from: com.discord.gateway.GatewaySocket$expeditedHeartbeat$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
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
        public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
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
        public C54991(String str, long j, boolean z2) {
            super(0);
            this.$reason = str;
            this.$timeout = j;
            this.$shouldResetBackoff = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            String strM820H = this.$reason != null ? outline.m820H(outline.m833U("with reason '"), this.$reason, '\'') : "";
            AnonymousClass1 anonymousClass1 = new AnonymousClass1();
            if (GatewaySocket.access$getWebSocket$p(GatewaySocket.this) == null) {
                if (this.$shouldResetBackoff) {
                    anonymousClass1.invoke2(strM820H);
                    return;
                } else {
                    Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), outline.m886y("Expedited heartbeat requested ", strM820H, ", but disconnected and no reset backoff."), false, 2, null);
                    return;
                }
            }
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), "Performing an expedited heartbeat " + strM820H + '.', false, 2, null);
            GatewaySocket gatewaySocket = GatewaySocket.this;
            GatewaySocket.access$heartbeat(gatewaySocket, GatewaySocket.access$getSeq$p(gatewaySocket));
            GatewaySocket.access$setHeartbeatAck$p(GatewaySocket.this, false);
            GatewaySocket.access$getHeartbeatExpeditedTimeout$p(GatewaySocket.this).schedule(new AnonymousClass2(), this.$timeout);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$handleClose$1 */
    public static final class C55001 extends Lambda implements Function1<WebSocket, Unit> {
        public static final C55001 INSTANCE = new C55001();

        public C55001() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
            invoke2(webSocket);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WebSocket webSocket) {
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$handleHeartbeatAck$1 */
    public static final class C55011 extends Lambda implements Function0<Unit> {
        public C55011() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), "Expedited heartbeat succeeded.", false, 2, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$handleHeartbeatTimeout$1 */
    public static final class C55021 extends Lambda implements Function1<WebSocket, Unit> {
        public static final C55021 INSTANCE = new C55021();

        public C55021() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
            invoke2(webSocket);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WebSocket webSocket) {
            if (webSocket != null) {
                WebSocket.disconnect$default(webSocket, 4000, null, 2, null);
            }
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$handleHello$1 */
    public static final class C55031 extends Lambda implements Function1<Listener, Unit> {
        public C55031() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onHello(GatewaySocket.this);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$handleReconnect$1 */
    public static final class C55041 extends Lambda implements Function1<WebSocket, Unit> {
        public final /* synthetic */ String $reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C55041(String str) {
            super(1);
            this.$reason = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
            invoke2(webSocket);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WebSocket webSocket) {
            if (webSocket != null) {
                webSocket.disconnect(4000, this.$reason);
            }
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$handleWebSocketClose$1 */
    public static final class C55051 extends Lambda implements Function1<Listener, Unit> {
        public C55051() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onDisconnected(GatewaySocket.this);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$handleWebSocketOpened$1 */
    public static final class C55061 extends Lambda implements Function1<Listener, Unit> {
        public C55061() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onConnected(GatewaySocket.this);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$presenceUpdate$1 */
    public static final class C55071 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $activities;
        public final /* synthetic */ Boolean $afk;
        public final /* synthetic */ Long $since;
        public final /* synthetic */ ClientStatus $status;

        /* compiled from: GatewaySocket.kt */
        /* renamed from: com.discord.gateway.GatewaySocket$presenceUpdate$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Activity, CharSequence> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Activity activity) {
                return invoke2(activity);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Activity activity) {
                Intrinsics3.checkNotNullParameter(activity, "it");
                return activity.getName();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C55071(ClientStatus clientStatus, List list, Long l, Boolean bool) {
            super(0);
            this.$status = clientStatus;
            this.$activities = list;
            this.$since = l;
            this.$afk = bool;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            String strName;
            Companion companion = GatewaySocket.INSTANCE;
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbM833U = outline.m833U("Sending self presence update: ");
            sbM833U.append(this.$status);
            sbM833U.append(' ');
            List list = this.$activities;
            String lowerCase = null;
            sbM833U.append(list != null ? _Collections.joinToString$default(list, null, null, null, 0, null, AnonymousClass1.INSTANCE, 31, null) : null);
            Companion.log$default(companion, loggerAccess$getLogger$p, sbM833U.toString(), false, 2, null);
            GatewaySocket gatewaySocket = GatewaySocket.this;
            Opcode opcode = Opcode.PRESENCE_UPDATE;
            ClientStatus clientStatus = this.$status;
            if (clientStatus != null && (strName = clientStatus.name()) != null) {
                Locale locale = Locale.ROOT;
                Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
                lowerCase = strName.toLowerCase(locale);
                Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            }
            Long l = this.$since;
            List listEmptyList = this.$activities;
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            GatewaySocket.send$default(gatewaySocket, new Outgoing(opcode, new Outgoing2.PresenceUpdate(lowerCase, l, listEmptyList, this.$afk)), false, null, 6, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$requestGuildMembers$1 */
    public static final class C55081 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $guildIds;
        public final /* synthetic */ Integer $limit;
        public final /* synthetic */ String $query;
        public final /* synthetic */ List $userIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C55081(List list, String str, List list2, Integer num) {
            super(0);
            this.$guildIds = list;
            this.$query = str;
            this.$userIds = list2;
            this.$limit = num;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Outgoing2.GuildMembersRequest guildMembersRequest = new Outgoing2.GuildMembersRequest(this.$guildIds, this.$query, this.$userIds, this.$limit, false, 16, null);
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), "Sending guild member request: " + guildMembersRequest, false, 2, null);
            GatewaySocket gatewaySocket = GatewaySocket.this;
            Outgoing outgoing = new Outgoing(Opcode.REQUEST_GUILD_MEMBERS, guildMembersRequest);
            Gson gsonAccess$getGsonOmitNulls$cp = GatewaySocket.access$getGsonOmitNulls$cp();
            Intrinsics3.checkNotNullExpressionValue(gsonAccess$getGsonOmitNulls$cp, "gsonOmitNulls");
            GatewaySocket.send$default(gatewaySocket, outgoing, false, gsonAccess$getGsonOmitNulls$cp, 2, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$resetOnError$1 */
    public static final class C55091 extends Lambda implements Function0<Unit> {
        public C55091() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            GatewaySocket.access$setNextReconnectIsImmediate$p(GatewaySocket.this, false);
            GatewaySocket.handleReconnect$default(GatewaySocket.this, "encountered an error", false, 2, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$schedule$1 */
    public static final class C55101<T> implements Action1<Function0<? extends Unit>> {
        public static final C55101 INSTANCE = new C55101();

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Function0<? extends Unit> function0) {
            call2((Function0<Unit>) function0);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Function0<Unit> function0) {
            function0.invoke();
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$schedule$2 */
    public static final class C55112<T> implements Action1<Throwable> {
        public static final C55112 INSTANCE = new C55112();

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$simulateReconnectForTesting$1 */
    public static final class C55121 extends Lambda implements Function0<Unit> {
        public C55121() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            GatewaySocket.handleReconnect$default(GatewaySocket.this, null, false, 1, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$startHeartbeater$1 */
    public static final class C55131 extends Lambda implements Function0<Unit> {
        public C55131() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.f27425a;
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
    /* renamed from: com.discord.gateway.GatewaySocket$streamDelete$1 */
    public static final class C55141 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C55141(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Companion companion = GatewaySocket.INSTANCE;
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbM833U = outline.m833U("Sending STREAM_DELETE: ");
            sbM833U.append(this.$streamKey);
            Companion.log$default(companion, loggerAccess$getLogger$p, sbM833U.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.STREAM_DELETE, new Outgoing2.DeleteStream(this.$streamKey)), false, null, 6, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$streamPing$1 */
    public static final class C55151 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C55151(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Companion companion = GatewaySocket.INSTANCE;
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbM833U = outline.m833U("Sending OPCODE_STREAM_PING: ");
            sbM833U.append(this.$streamKey);
            Companion.log$default(companion, loggerAccess$getLogger$p, sbM833U.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.OPCODE_STREAM_PING, new Outgoing2.StreamPing(this.$streamKey)), false, null, 6, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$streamWatch$1 */
    public static final class C55161 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C55161(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Companion companion = GatewaySocket.INSTANCE;
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbM833U = outline.m833U("Sending STREAM_WATCH: ");
            sbM833U.append(this.$streamKey);
            Companion.log$default(companion, loggerAccess$getLogger$p, sbM833U.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.STREAM_WATCH, new Outgoing2.WatchStream(this.$streamKey)), false, null, 6, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$voiceServerPing$1 */
    public static final class C55171 extends Lambda implements Function0<Unit> {
        public C55171() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() throws JsonIOException {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.access$getLogger$p(GatewaySocket.this), "Sending ping to voice server.", false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.VOICE_SERVER_PING, (Object) null), false, null, 6, null);
        }
    }

    /* compiled from: GatewaySocket.kt */
    /* renamed from: com.discord.gateway.GatewaySocket$voiceStateUpdate$1 */
    public static final class C55181 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $channelId;
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ String $preferredRegion;
        public final /* synthetic */ boolean $selfDeaf;
        public final /* synthetic */ boolean $selfMute;
        public final /* synthetic */ boolean $selfVideo;
        public final /* synthetic */ boolean $shouldIncludePreferredRegion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C55181(Long l, Long l2, boolean z2, boolean z3, String str, boolean z4, boolean z5) {
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
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() throws JsonIOException {
            Companion companion = GatewaySocket.INSTANCE;
            Logger loggerAccess$getLogger$p = GatewaySocket.access$getLogger$p(GatewaySocket.this);
            StringBuilder sbM833U = outline.m833U("Sending voice state update for guild [");
            sbM833U.append(this.$guildId);
            sbM833U.append("] and channel [");
            sbM833U.append(this.$channelId);
            sbM833U.append("]. ");
            sbM833U.append("Muted: ");
            sbM833U.append(this.$selfMute);
            sbM833U.append(", deafened: ");
            sbM833U.append(this.$selfDeaf);
            sbM833U.append(", preferredRegion: ");
            sbM833U.append(this.$preferredRegion);
            Companion.log$default(companion, loggerAccess$getLogger$p, sbM833U.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.VOICE_STATE_UPDATE, this.$shouldIncludePreferredRegion ? new Outgoing2.VoiceStateUpdate(this.$guildId, this.$channelId, this.$selfMute, this.$selfDeaf, this.$selfVideo, this.$preferredRegion) : new Outgoing2.VoiceStateUpdateNoPreferredRegion(this.$guildId, this.$channelId, this.$selfMute, this.$selfDeaf, this.$selfVideo)), false, null, 6, null);
        }
    }

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.f13101g = true;
        FieldNamingPolicy fieldNamingPolicy = FieldNamingPolicy.f13091m;
        gsonBuilder.f13097c = fieldNamingPolicy;
        gsonBuilder.m6852b(ActivityType.class, new ActivityType2());
        gsonIncludeNulls = gsonBuilder.m6851a();
        GsonBuilder gsonBuilder2 = new GsonBuilder();
        gsonBuilder2.f13097c = fieldNamingPolicy;
        gsonOmitNulls = gsonBuilder2.m6851a();
        EXPECTED_NULL_DATA_EVENTS = Sets5.setOf((Object[]) new String[]{"USER_SUBSCRIPTIONS_UPDATE", "USER_PAYMENT_SOURCES_UPDATE"});
        clock = ClockFactory.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GatewaySocket(Function0<IdentifyData> function0, Function1<? super Map<String, ? extends Object>, Unit> function1, GatewayEventHandler gatewayEventHandler, Scheduler scheduler, Logger logger, NetworkMonitor networkMonitor, RestConfig restConfig, Context context, Function1<? super String, String> function12, SSLSocketFactory sSLSocketFactory, Map<String, ? extends Object> map, GatewaySocketLogger gatewaySocketLogger) {
        Intrinsics3.checkNotNullParameter(function0, "identifyDataProvider");
        Intrinsics3.checkNotNullParameter(function1, "trackReadyPayload");
        Intrinsics3.checkNotNullParameter(gatewayEventHandler, "eventHandler");
        Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(networkMonitor, "networkMonitor");
        Intrinsics3.checkNotNullParameter(restConfig, "restConfig");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(map, "identifyProperties");
        Intrinsics3.checkNotNullParameter(gatewaySocketLogger, "gatewaySocketLogger");
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
        ListenerCollection2<Listener> listenerCollection2 = new ListenerCollection2<>();
        this.listenerSubject = listenerCollection2;
        this.listeners = listenerCollection2;
        RestClient restClient = RestClient.INSTANCE;
        restClient.init(restConfig, context);
        this.gatewayDiscovery = new GatewayDiscovery(context, scheduler, backoff, new C54861(), restClient.getGateway());
        Observable<Boolean> observableM11084J = networkMonitor.observeIsConnected().m11084J(scheduler);
        Observable.m11074h0(new OnSubscribeLift(observableM11084J.f27640j, new OperatorSkipWhile3(new OperatorSkipWhile2(C54872.INSTANCE)))).m11097W(new C54883(), new C54894());
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
        this.listenerSubject.notify(new C54961());
        this.gatewayDiscovery.discoverGatewayUrl(new C54972(), new C54983());
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
        send$default(this, new Outgoing(Opcode.IDENTIFY, new Outgoing2.Identify(identifyDataInvoke.getToken(), 100, true, CLIENT_CAPABILITIES, this.identifyProperties, identifyDataInvoke.getClientState())), false, null, 4, null);
    }

    private final void doResume() throws JsonIOException {
        this.connectionState = 4;
        this.replayedEvents = 0;
        Companion companion = INSTANCE;
        Logger logger = this.logger;
        StringBuilder sbM833U = outline.m833U("Resuming session ");
        String str = this.sessionId;
        if (str == null) {
            str = "";
        }
        sbM833U.append(str);
        sbM833U.append(" at sequence: ");
        Companion.log$default(companion, logger, outline.m813A(sbM833U, this.seq, '.'), false, 2, null);
        send$default(this, new Outgoing(Opcode.RESUME, new Outgoing2.Resume(this.token, this.sessionId, this.seq)), false, null, 4, null);
    }

    private final void doResumeOrIdentify() throws JsonIOException {
        Companion companion = INSTANCE;
        long delay$default = Companion.getDelay$default(companion, this.heartbeatAckTimeMostRecent, null, 2, null);
        float f = this.heartbeatAckTimeMostRecent == 0 ? 0.0f : (delay$default / 1000.0f) / 60.0f;
        if (this.sessionId != null && delay$default <= ((long) HEARTBEAT_MAX_RESUME_THRESHOLD)) {
            Logger logger = this.logger;
            StringBuilder sbM833U = outline.m833U("Attempting to resume after elapsed duration of ");
            String str = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
            Intrinsics3.checkNotNullExpressionValue(str, "java.lang.String.format(this, *args)");
            sbM833U.append(str);
            sbM833U.append(" minutes.");
            Companion.log$default(companion, logger, sbM833U.toString(), false, 2, null);
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
    private final void flattenTraces(Object trace, ArrayList<Tuples2<String, Integer>> result) {
        if (trace == null) {
            return;
        }
        try {
            if (!TypeIntrinsics.isMutableList(trace)) {
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
                if (!TypeIntrinsics.isMutableMap(obj2)) {
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
                        result.add(new Tuples2<>(str, Integer.valueOf(number.intValue() / 1000)));
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
        return (trace == null || (strJoinToString$default = _Collections.joinToString$default(trace, " -> ", null, null, 0, null, null, 62, null)) == null) ? "???" : strJoinToString$default;
    }

    private final void handleClose(boolean wasClean, int code, String reason) {
        cleanup(C55001.INSTANCE);
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
        String strM822J = outline.m822J(sb, reason, "'.");
        if (this.nextReconnectIsImmediate) {
            Companion.log$default(INSTANCE, this.logger, outline.m883w(strM822J, " Retrying immediately."), false, 2, null);
            discover();
            return;
        }
        long jFail = this.gatewayBackoff.fail(new GatewaySocket$handleClose$delay$1(this));
        Companion.log$default(INSTANCE, this.logger, strM822J + " Retrying in: " + jFail + "ms.", false, 2, null);
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
        if (Intrinsics3.areEqual(type, "READY") || Intrinsics3.areEqual(type, "RESUMED")) {
            if (type != null) {
                int iHashCode = type.hashCode();
                if (iHashCode != 77848963) {
                    if (iHashCode == 1815529911 && type.equals("RESUMED")) {
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sbM833U = outline.m833U("Resumed session, took ");
                        Companion companion = INSTANCE;
                        sbM833U.append(Companion.getDelay$default(companion, this.connectionStartTime, null, 2, null));
                        sbM833U.append("ms, ");
                        sb.append(sbM833U.toString());
                        sb.append("replayed " + this.replayedEvents + " events, new seq: " + this.seq + '.');
                        String string = sb.toString();
                        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder()\n        …              .toString()");
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
                    StringBuilder sbM833U2 = outline.m833U("Ready with session id: ");
                    sbM833U2.append(this.sessionId);
                    sbM833U2.append(", took ");
                    Companion.log$default(companion2, logger, outline.m815C(sbM833U2, Companion.getDelay$default(companion2, this.connectionStartTime, null, 2, null), "ms"), false, 2, null);
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
        if (_Collections.contains(EXPECTED_NULL_DATA_EVENTS, type)) {
            this.eventHandler.handleDispatch(type, Unit.f27425a);
        } else if ((!Intrinsics3.areEqual(type, "READY")) && (!Intrinsics3.areEqual(type, "RESUMED"))) {
            Logger.w$default(this.logger, outline.m886y("handleDispatch() ", type, " is unhandled!"), null, 2, null);
        }
    }

    private final void handleHeartbeat() throws JsonIOException {
        heartbeat(this.seq);
    }

    private final void handleHeartbeatAck() {
        Companion.access$log(INSTANCE, this.logger, "Received heartbeat ACK.", false);
        this.heartbeatAckTimeMostRecent = clock.currentTimeMillis();
        this.heartbeatAck = true;
        this.heartbeatExpeditedTimeout.cancel(new C55011());
    }

    private final void handleHeartbeatTimeout() {
        cleanup(C55021.INSTANCE);
        this.connectionState = 1;
        long jFail = this.gatewayBackoff.fail(new GatewaySocket$handleHeartbeatTimeout$delay$1(this));
        Companion.log$default(INSTANCE, this.logger, "Ack timeout, reconnecting om " + jFail + "ms.", false, 2, null);
    }

    private final void handleHello(ModelPayload.Hello data) {
        this.listenerSubject.notify(new C55031());
        clearHelloTimeout();
        this.heartbeatInterval = data.getHeartbeatInterval();
        Companion companion = INSTANCE;
        Logger logger = this.logger;
        StringBuilder sbM833U = outline.m833U("Hello via ");
        sbM833U.append(getConnectionPath(data));
        sbM833U.append(", at interval ");
        sbM833U.append(this.heartbeatInterval);
        sbM833U.append(" took ");
        Companion.log$default(companion, logger, outline.m815C(sbM833U, Companion.getDelay$default(companion, this.connectionStartTime, null, 2, null), "ms."), false, 2, null);
        startHeartbeater();
    }

    private final void handleInvalidSession(boolean canResume) throws JsonIOException {
        Companion.log$default(INSTANCE, this.logger, outline.m822J(outline.m833U("Invalid session, is "), canResume ? "" : "not", " resumable."), false, 2, null);
        if (canResume) {
            doResumeOrIdentify();
            return;
        }
        Boolean bool = Boolean.FALSE;
        handleConnected(bool, bool);
        doIdentify();
    }

    private final void handleReconnect(String reason, boolean resetSession) {
        cleanup(new C55041(reason));
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
        this.listenerSubject.notify(new C55051());
        handleClose(true, closed.getCode(), reason);
    }

    private final void handleWebSocketError() {
        handleClose(false, 0, "An error with the web socket occurred.");
    }

    private final void handleWebSocketMessage(InputStreamReader reader, int compressedByteSize) throws JsonIOException {
        long jCurrentTimeMillis = clock.currentTimeMillis();
        SizeRecordingInputStreamReader sizeRecordingInputStreamReader = new SizeRecordingInputStreamReader(reader, 0, 2, null);
        Incoming incomingBuild = ((Incoming2) new Model.JsonReader(new JsonReader(sizeRecordingInputStreamReader)).parse(new Incoming2(new GatewaySocket$handleWebSocketMessage$incomingParser$1(this)))).build();
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
                StringBuilder sbM833U = outline.m833U("Unhandled op code ");
                sbM833U.append(incomingBuild.getOpcode());
                sbM833U.append('.');
                Companion.log$default(companion, logger, sbM833U.toString(), false, 2, null);
                break;
        }
    }

    private final void handleWebSocketOpened(String gatewayUrl) throws JsonIOException {
        Companion companion = INSTANCE;
        Companion.log$default(companion, this.logger, outline.m815C(outline.m837Y("Connected to ", gatewayUrl, " in "), Companion.getDelay$default(companion, this.connectionStartTime, null, 2, null), "ms."), false, 2, null);
        this.listenerSubject.notify(new C55061());
        doResumeOrIdentify();
    }

    private final void heartbeat(int seq) throws JsonIOException {
        Companion.access$log(INSTANCE, this.logger, "Sending heartbeat at sequence: " + seq + '.', false);
        send$default(this, new Outgoing(Opcode.HEARTBEAT, Integer.valueOf(seq)), false, null, 4, null);
    }

    private final void logError(String message, Exception exception, Map<String, String> metadata) {
        Logger logger = this.logger;
        if (metadata == null) {
            metadata = Maps6.emptyMap();
        }
        logger.mo8364e(message, exception, metadata);
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
        new ScalarSynchronousObservable(callback).m11098X(this.scheduler).m11097W(C55101.INSTANCE, C55112.INSTANCE);
    }

    private final void send(Outgoing data, boolean checkSessionEstablished, Gson gson) throws JsonIOException {
        if (checkSessionEstablished && !isSessionEstablished()) {
            Companion companion = INSTANCE;
            Logger logger = this.logger;
            StringBuilder sbM833U = outline.m833U("Attempted to send while not being in a connected state, opcode: ");
            sbM833U.append(data.getOp());
            sbM833U.append('.');
            Companion.log$default(companion, logger, sbM833U.toString(), false, 2, null);
            return;
        }
        WebSocket webSocket = this.webSocket;
        if (webSocket != null) {
            String strM9209m = gson.m9209m(data);
            GatewaySocketLogger gatewaySocketLogger = this.gatewaySocketLogger;
            Intrinsics3.checkNotNullExpressionValue(strM9209m, GATEWAY_ENCODING);
            gatewaySocketLogger.logOutboundMessage(strM9209m);
            webSocket.message(strM9209m);
            return;
        }
        Companion companion2 = INSTANCE;
        Logger logger2 = this.logger;
        StringBuilder sbM833U2 = outline.m833U("Attempted to send without a web socket that exists, opcode: ");
        sbM833U2.append(data.getOp());
        sbM833U2.append('.');
        Companion.log$default(companion2, logger2, sbM833U2.toString(), false, 2, null);
    }

    public static /* synthetic */ void send$default(GatewaySocket gatewaySocket, Outgoing outgoing, boolean z2, Gson gson, int i, Object obj) throws JsonIOException {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            gson = gsonIncludeNulls;
            Intrinsics3.checkNotNullExpressionValue(gson, "gsonIncludeNulls");
        }
        gatewaySocket.send(outgoing, z2, gson);
    }

    private final void startHeartbeater() {
        this.heartbeater.cancel();
        this.heartbeatAck = true;
        this.heartbeater.postInterval(new C55131(), this.heartbeatInterval);
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
            List<Channel> listM7860g = it.next().m7860g();
            if (listM7860g != null) {
                Iterator<T> it2 = listM7860g.iterator();
                while (it2.hasNext()) {
                    i++;
                    if (((Channel) it2.next()).getType() == 4) {
                        i2++;
                    }
                }
            }
        }
        ArrayList<Tuples2<String, Integer>> arrayList = new ArrayList<>();
        flattenTraces(payload.getTrace(), arrayList);
        if (arrayList.size() > 0) {
            Tuples2<String, Integer> tuples2 = arrayList.get(0);
            String strComponent1 = tuples2.component1();
            iIntValue = tuples2.component2().intValue();
            if (!StringsJVM.startsWith$default(strComponent1, "gateway-", false, 2, null)) {
                iIntValue = 0;
            }
        }
        int i3 = 0;
        int i4 = 0;
        for (Tuples2<String, Integer> tuples22 : arrayList) {
            String strComponent12 = tuples22.component1();
            int iIntValue2 = tuples22.component2().intValue();
            if (Intrinsics3.areEqual(strComponent12, "start_session")) {
                i3 = iIntValue2;
            } else if (Intrinsics3.areEqual(strComponent12, "guilds_connect")) {
                i4 = iIntValue2;
            }
        }
        Function1<Map<String, ? extends Object>, Unit> function1 = this.trackReadyPayload;
        Companion companion = INSTANCE;
        function1.invoke(Maps6.mapOf(Tuples.m10073to("duration_ms_since_connection_start", Long.valueOf(Companion.getDelay$default(companion, this.connectionStartTime, null, 2, null))), Tuples.m10073to("duration_ms_since_identify_start", Long.valueOf(Companion.getDelay$default(companion, this.identifyStartTime, null, 2, null))), Tuples.m10073to("identify_total_server_duration_ms", Integer.valueOf(iIntValue)), Tuples.m10073to("identify_api_duration_ms", Integer.valueOf(i3)), Tuples.m10073to("identify_guilds_duration_ms", Integer.valueOf(i4)), Tuples.m10073to("compressed_byte_size", Integer.valueOf(compressedByteSize)), Tuples.m10073to("uncompressed_byte_size", Integer.valueOf(uncompressedByteSize)), Tuples.m10073to("compression_algorithm", "zlib"), Tuples.m10073to("packing_algorithm", GATEWAY_ENCODING), Tuples.m10073to("unpack_duration_ms", Long.valueOf(unpackDurationMs)), Tuples.m10073to("is_reconnect", Boolean.valueOf(this.hasConnectedOnce)), Tuples.m10073to("is_fast_connect", Boolean.FALSE), Tuples.m10073to("num_guilds", Integer.valueOf(size)), Tuples.m10073to("num_guild_channels", Integer.valueOf(i)), Tuples.m10073to("num_guild_category_channels", Integer.valueOf(i2))));
    }

    public final void callConnect(long channelId) {
        schedule(new C54901(channelId));
    }

    public final void close(boolean clean) {
        schedule(new C54911(clean));
    }

    public final void connect() {
        schedule(new C54921());
    }

    public final void expeditedHeartbeat(long timeout, String reason, boolean shouldResetBackoff) {
        schedule(new C54991(reason, timeout, shouldResetBackoff));
    }

    public final ListenerCollection<Listener> getListeners() {
        return this.listeners;
    }

    public final boolean isSessionEstablished() {
        return this.connectionState == 5;
    }

    public final void presenceUpdate(ClientStatus status, Long since, List<Activity> activities, Boolean afk) {
        schedule(new C55071(status, activities, since, afk));
    }

    public final void requestApplicationCommands(Outgoing2.ApplicationCommandRequest request) {
        Intrinsics3.checkNotNullParameter(request, "request");
        Outgoing outgoing = new Outgoing(Opcode.REQUEST_GUILD_APPLICATION_COMMANDS, request);
        Gson gson = gsonOmitNulls;
        Intrinsics3.checkNotNullExpressionValue(gson, "gsonOmitNulls");
        send$default(this, outgoing, false, gson, 2, null);
    }

    public final void requestForumUnreads(Outgoing2.ForumUnreadsRequest request) {
        Intrinsics3.checkNotNullParameter(request, "request");
        Outgoing outgoing = new Outgoing(Opcode.REQUEST_FORUM_UNREADS, request);
        Gson gson = gsonOmitNulls;
        Intrinsics3.checkNotNullExpressionValue(gson, "gsonOmitNulls");
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
        Intrinsics3.checkNotNullParameter(guildIds, "guildIds");
        schedule(new C55081(guildIds, query, userIds, limit));
    }

    public final void resetOnError() {
        schedule(new C55091());
    }

    public final void simulateReconnectForTesting() {
        schedule(new C55121());
    }

    public final void streamCreate(String streamType, long channelId, Long guildId, String preferredRegion) {
        Intrinsics3.checkNotNullParameter(streamType, "streamType");
        Companion.log$default(INSTANCE, this.logger, "Sending STREAM_CREATE: " + channelId + ' ' + guildId, false, 2, null);
        send$default(this, new Outgoing(Opcode.STREAM_CREATE, new Outgoing2.CreateStream(streamType, channelId, guildId, preferredRegion)), false, null, 6, null);
    }

    public final void streamDelete(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        schedule(new C55141(streamKey));
    }

    public final void streamPing(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        schedule(new C55151(streamKey));
    }

    public final void streamWatch(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        schedule(new C55161(streamKey));
    }

    public final void updateGuildSubscriptions(long guildId, Outgoing2.GuildSubscriptions guildSubscriptions) {
        Intrinsics3.checkNotNullParameter(guildSubscriptions, "guildSubscriptions");
        Companion.log$default(INSTANCE, this.logger, "sending guild subscriptions: " + guildId + " -- " + guildSubscriptions, false, 2, null);
        Opcode opcode = Opcode.GUILD_SUBSCRIPTIONS;
        Boolean typing = guildSubscriptions.getTyping();
        Boolean activities = guildSubscriptions.getActivities();
        List<Long> members = guildSubscriptions.getMembers();
        Outgoing outgoing = new Outgoing(opcode, new Outgoing2.GuildSubscriptionsUpdate(guildId, typing, activities, members != null ? _Collections.toList(members) : null, guildSubscriptions.getChannels(), guildSubscriptions.getThreads(), guildSubscriptions.getThreadMemberLists()));
        Gson gson = gsonOmitNulls;
        Intrinsics3.checkNotNullExpressionValue(gson, "gsonOmitNulls");
        send$default(this, outgoing, false, gson, 2, null);
    }

    public final void voiceServerPing() {
        schedule(new C55171());
    }

    public final void voiceStateUpdate(Long guildId, Long channelId, boolean selfMute, boolean selfDeaf, boolean selfVideo, String preferredRegion, boolean shouldIncludePreferredRegion) {
        schedule(new C55181(guildId, channelId, selfMute, selfDeaf, preferredRegion, shouldIncludePreferredRegion, selfVideo));
    }

    private final void connect(String gatewayUrl) {
        GatewaySocket$connect$$inlined$apply$lambda$4 gatewaySocket$connect$$inlined$apply$lambda$4;
        if (this.connectionState != 1) {
            return;
        }
        this.connectionState = 2;
        Companion.log$default(INSTANCE, this.logger, outline.m886y("Connect to: ", gatewayUrl, ", encoding: json, version 9."), false, 2, null);
        cleanup(C54932.INSTANCE);
        this.connectionStartTime = clock.currentTimeMillis();
        this.helloTimeout.schedule(new C54943(), HELLO_TIMEOUT);
        WebSocket webSocket = new WebSocket(this.scheduler, new C54954(this), this.sslSocketFactory);
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
        this(function0, function1, gatewayEventHandler, scheduler, logger, networkMonitor, restConfig, context, (i & 256) != 0 ? null : function12, (i & 512) != 0 ? null : sSLSocketFactory, (i & 1024) != 0 ? Maps6.emptyMap() : map, gatewaySocketLogger);
    }
}
