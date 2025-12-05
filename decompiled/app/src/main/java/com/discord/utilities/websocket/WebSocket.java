package com.discord.utilities.websocket;

import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.websocket.ZLibWebSocketListener;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocketListener;
import p507d0.Tuples;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p600f0.OkHttpClient;
import p600f0.p601e0.p609k.Platform2;
import p637j0.p642l.p645c.TrampolineScheduler;
import p637j0.p653p.Schedulers2;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.functions.Action1;
import p658rx.subjects.PublishSubject;

/* compiled from: WebSocket.kt */
/* loaded from: classes2.dex */
public final class WebSocket {
    private static final int CLOSE_NORMAL = 1000;
    private okhttp3.WebSocket client;
    private final Function3<String, Exception, Map<String, String>, Unit> errorLogger;
    private Function1<? super Closed, Unit> onClosed;
    private Function1<? super Error, Unit> onError;
    private Function2<? super InputStreamReader, ? super Integer, Unit> onMessage;
    private Function1<? super Opened, Unit> onOpened;
    private RawMessageHandler rawMessageHandler;
    private final PublishSubject<Function0<Unit>> schedulerSubject;
    private final SSLSocketFactory socketFactory;
    private State state;

    /* compiled from: WebSocket.kt */
    /* renamed from: com.discord.utilities.websocket.WebSocket$1 */
    public static final class C70561<T> implements Action1<Function0<? extends Unit>> {
        public static final C70561 INSTANCE = new C70561();

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Function0<? extends Unit> function0) {
            call2((Function0<Unit>) function0);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Function0<Unit> function0) {
            function0.invoke();
        }
    }

    /* compiled from: WebSocket.kt */
    /* renamed from: com.discord.utilities.websocket.WebSocket$2 */
    public static final class C70572<T> implements Action1<Throwable> {
        public C70572() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
            WebSocket webSocket = WebSocket.this;
            Intrinsics3.checkNotNullExpressionValue(th, "it");
            WebSocket.access$handleOnFailure(webSocket, th, null, WebSocket.this.getState() == State.CLOSED);
        }
    }

    /* compiled from: WebSocket.kt */
    public static final class Closed {
        private final int code;
        private final String reason;

        public Closed(int i, String str) {
            this.code = i;
            this.reason = str;
        }

        public final int getCode() {
            return this.code;
        }

        public final String getReason() {
            return this.reason;
        }
    }

    /* compiled from: WebSocket.kt */
    public static final class Error {
        private final Response response;
        private final Throwable throwable;

        public Error(Throwable th, Response response) {
            Intrinsics3.checkNotNullParameter(th, "throwable");
            this.throwable = th;
            this.response = response;
        }

        public final Response getResponse() {
            return this.response;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }
    }

    /* compiled from: WebSocket.kt */
    public static final class Opened {
        private final Response response;

        public Opened(Response response) {
            this.response = response;
        }

        public final Response getResponse() {
            return this.response;
        }
    }

    /* compiled from: WebSocket.kt */
    public enum State {
        NOT_YET_CONNECTED,
        CONNECTING,
        CONNECTED,
        CLOSING,
        CLOSED
    }

    /* compiled from: WebSocket.kt */
    /* renamed from: com.discord.utilities.websocket.WebSocket$connect$1 */
    public static final class C70581 extends ZLibWebSocketListener.Listener {
        private final RawMessageHandler rawMessageHandler;

        public C70581() {
            this.rawMessageHandler = WebSocket.this.getRawMessageHandler();
        }

        private final void handleError(Exception exception, String errorMessage, String rawData) {
            Map mapEmptyMap;
            if (rawData == null || (mapEmptyMap = MapsJVM.mapOf(Tuples.m10073to("raw_data_string", rawData))) == null) {
                mapEmptyMap = Maps6.emptyMap();
            }
            WebSocket.access$getErrorLogger$p(WebSocket.this).invoke(errorMessage, exception, mapEmptyMap);
            WebSocket.access$handleOnFailure(WebSocket.this, exception, null, false);
        }

        public static /* synthetic */ void handleError$default(C70581 c70581, Exception exc, String str, String str2, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            c70581.handleError(exc, str, str2);
        }

        @Override // com.discord.utilities.websocket.ZLibWebSocketListener.Listener
        public RawMessageHandler getRawMessageHandler() {
            return this.rawMessageHandler;
        }

        @Override // okhttp3.WebSocketListener
        public void onClosed(okhttp3.WebSocket webSocket, int code, String reason) {
            Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics3.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
            WebSocket.access$schedule(WebSocket.this, new WebSocket2(this, code, reason));
        }

        @Override // okhttp3.WebSocketListener
        public void onClosing(okhttp3.WebSocket webSocket, int code, String reason) {
            Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics3.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
            WebSocket.access$setState$p(WebSocket.this, State.CLOSING);
            WebSocket.this.getOnClosed().invoke(new Closed(code, reason));
        }

        @Override // okhttp3.WebSocketListener
        public void onFailure(okhttp3.WebSocket webSocket, Throwable t, Response response) {
            Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics3.checkNotNullParameter(t, "t");
            WebSocket.access$schedule(WebSocket.this, new WebSocket3(this, t, response));
        }

        @Override // com.discord.utilities.websocket.ZLibWebSocketListener.Listener
        public void onInflateError(Exception e) {
            Intrinsics3.checkNotNullParameter(e, "e");
            handleError$default(this, e, "Unable to inflate message.", null, 4, null);
        }

        @Override // com.discord.utilities.websocket.ZLibWebSocketListener.Listener
        public void onInflatedMessage(okhttp3.WebSocket webSocket, InputStreamReader reader, int compressedByteLength) {
            Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics3.checkNotNullParameter(reader, "reader");
            try {
                WebSocket.this.getOnMessage().invoke(reader, Integer.valueOf(compressedByteLength));
            } catch (Exception e) {
                handleError$default(this, e, "Unable to parse model.", null, 4, null);
            }
        }

        @Override // okhttp3.WebSocketListener
        public void onOpen(okhttp3.WebSocket webSocket, Response response) {
            Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
            Intrinsics3.checkNotNullParameter(response, "response");
            WebSocket.access$schedule(WebSocket.this, new WebSocket4(this, webSocket, response));
        }
    }

    /* compiled from: WebSocket.kt */
    /* renamed from: com.discord.utilities.websocket.WebSocket$resetListeners$1 */
    public static final class C70591 extends Lambda implements Function1<Opened, Unit> {
        public static final C70591 INSTANCE = new C70591();

        public C70591() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Opened opened) {
            invoke2(opened);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Opened opened) {
            Intrinsics3.checkNotNullParameter(opened, "it");
        }
    }

    /* compiled from: WebSocket.kt */
    /* renamed from: com.discord.utilities.websocket.WebSocket$resetListeners$2 */
    public static final class C70602 extends Lambda implements Function1<Closed, Unit> {
        public static final C70602 INSTANCE = new C70602();

        public C70602() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Closed closed) {
            invoke2(closed);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Closed closed) {
            Intrinsics3.checkNotNullParameter(closed, "it");
        }
    }

    /* compiled from: WebSocket.kt */
    /* renamed from: com.discord.utilities.websocket.WebSocket$resetListeners$3 */
    public static final class C70613 extends Lambda implements Function2<InputStreamReader, Integer, Unit> {
        public static final C70613 INSTANCE = new C70613();

        public C70613() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(InputStreamReader inputStreamReader, Integer num) {
            invoke(inputStreamReader, num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(InputStreamReader inputStreamReader, int i) {
            Intrinsics3.checkNotNullParameter(inputStreamReader, "<anonymous parameter 0>");
        }
    }

    /* compiled from: WebSocket.kt */
    /* renamed from: com.discord.utilities.websocket.WebSocket$resetListeners$4 */
    public static final class C70624 extends Lambda implements Function1<Error, Unit> {
        public static final C70624 INSTANCE = new C70624();

        public C70624() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WebSocket(Scheduler scheduler, Function3<? super String, ? super Exception, ? super Map<String, String>, Unit> function3, SSLSocketFactory sSLSocketFactory) {
        Intrinsics3.checkNotNullParameter(function3, "errorLogger");
        this.errorLogger = function3;
        this.socketFactory = sSLSocketFactory;
        PublishSubject<Function0<Unit>> publishSubjectM11133k0 = PublishSubject.m11133k0();
        this.schedulerSubject = publishSubjectM11133k0;
        this.onOpened = WebSocket8.INSTANCE;
        this.onClosed = WebSocket5.INSTANCE;
        this.onMessage = WebSocket7.INSTANCE;
        this.onError = WebSocket6.INSTANCE;
        this.state = State.NOT_YET_CONNECTED;
        Observable<Function0<Unit>> observableM11085K = publishSubjectM11133k0.m11085K();
        if (scheduler == null) {
            AtomicReference<Schedulers2> atomicReference = Schedulers2.f27393a;
            scheduler = TrampolineScheduler.f27250a;
        }
        observableM11085K.m11084J(scheduler).m11097W(C70561.INSTANCE, new C70572());
    }

    public static final /* synthetic */ okhttp3.WebSocket access$getClient$p(WebSocket webSocket) {
        return webSocket.client;
    }

    public static final /* synthetic */ Function3 access$getErrorLogger$p(WebSocket webSocket) {
        return webSocket.errorLogger;
    }

    public static final /* synthetic */ State access$getState$p(WebSocket webSocket) {
        return webSocket.state;
    }

    public static final /* synthetic */ void access$handleOnFailure(WebSocket webSocket, Throwable th, Response response, boolean z2) {
        webSocket.handleOnFailure(th, response, z2);
    }

    public static final /* synthetic */ void access$schedule(WebSocket webSocket, Function0 function0) {
        webSocket.schedule(function0);
    }

    public static final /* synthetic */ void access$setClient$p(WebSocket webSocket, okhttp3.WebSocket webSocket2) {
        webSocket.client = webSocket2;
    }

    public static final /* synthetic */ void access$setState$p(WebSocket webSocket, State state) {
        webSocket.state = state;
    }

    private final okhttp3.WebSocket createWebSocket(String url, SSLSocketFactory socketFactory, WebSocketListener listener) {
        OkHttpClient.a aVar = new OkHttpClient.a();
        if (socketFactory != null) {
            Platform2.a aVar2 = Platform2.f25785c;
            aVar.m10421b(socketFactory, Platform2.f25783a.mo10325n());
        }
        aVar.m10420a(1L, TimeUnit.MINUTES);
        OkHttpClient okHttpClient = new OkHttpClient(aVar);
        Request.C12935a c12935a = new Request.C12935a();
        c12935a.m10983f(url);
        return okHttpClient.m10419g(c12935a.m10978a(), listener);
    }

    public static /* synthetic */ void disconnect$default(WebSocket webSocket, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1000;
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        webSocket.disconnect(i, str);
    }

    private final void handleOnFailure(Throwable throwable, Response response, boolean closed) {
        if (closed) {
            this.state = State.CLOSED;
        } else {
            disconnect(PointerIconCompat.TYPE_COPY, "Closing due to failure " + throwable + ", " + response);
        }
        this.onError.invoke(new Error(throwable, response));
    }

    private final void schedule(Function0<Unit> callback) {
        this.schedulerSubject.f27650k.onNext(callback);
    }

    public final void connect(String url) {
        Intrinsics3.checkNotNullParameter(url, "url");
        disconnect(1000, "Closing existing connection.");
        this.state = State.CONNECTING;
        this.client = createWebSocket(url, this.socketFactory, new ZLibWebSocketListener(new C70581()));
    }

    public final void disconnect() {
        disconnect$default(this, 0, null, 3, null);
    }

    public final void disconnect(int i) {
        disconnect$default(this, i, null, 2, null);
    }

    public final void disconnect(int code, String reason) {
        okhttp3.WebSocket webSocket = this.client;
        if (webSocket != null) {
            this.state = State.CLOSING;
            try {
                try {
                    webSocket.mo10349e(code, reason);
                } catch (Exception e) {
                    handleOnFailure(e, null, true);
                }
            } finally {
                this.client = null;
            }
        }
    }

    public final Function1<Closed, Unit> getOnClosed() {
        return this.onClosed;
    }

    public final Function1<Error, Unit> getOnError() {
        return this.onError;
    }

    public final Function2<InputStreamReader, Integer, Unit> getOnMessage() {
        return this.onMessage;
    }

    public final Function1<Opened, Unit> getOnOpened() {
        return this.onOpened;
    }

    public final RawMessageHandler getRawMessageHandler() {
        return this.rawMessageHandler;
    }

    public final State getState() {
        return this.state;
    }

    public final void message(String message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        okhttp3.WebSocket webSocket = this.client;
        if (webSocket == null || this.state != State.CONNECTED) {
            return;
        }
        try {
            webSocket.mo10345a(message);
        } catch (IllegalStateException e) {
            handleOnFailure(e, null, true);
        }
    }

    public final void resetListeners() {
        this.onOpened = C70591.INSTANCE;
        this.onClosed = C70602.INSTANCE;
        this.onMessage = C70613.INSTANCE;
        this.rawMessageHandler = null;
        this.onError = C70624.INSTANCE;
    }

    public final void setOnClosed(Function1<? super Closed, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onClosed = function1;
    }

    public final void setOnError(Function1<? super Error, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onError = function1;
    }

    public final void setOnMessage(Function2<? super InputStreamReader, ? super Integer, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "<set-?>");
        this.onMessage = function2;
    }

    public final void setOnOpened(Function1<? super Opened, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onOpened = function1;
    }

    public final void setRawMessageHandler(RawMessageHandler rawMessageHandler) {
        this.rawMessageHandler = rawMessageHandler;
    }
}
