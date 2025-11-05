package com.discord.app;

import android.app.Application;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import b.a.d.j0;
import b.a.d.l;
import b.a.d.l0;
import b.d.b.a.a;
import com.discord.R;
import com.discord.stores.StoreConnectionOpen;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.intent.RouteHandlers;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.voice.DiscordOverlayService;
import d0.g0.s;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import j0.l.e.k;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import rx.Observable;

/* compiled from: DiscordConnectService.kt */
/* loaded from: classes.dex */
public final class DiscordConnectService extends Service {

    /* renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: DiscordConnectService.kt */
    /* renamed from: com.discord.app.DiscordConnectService$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final void a(Companion companion, String str) {
            AppLog appLog = AppLog.g;
            String simpleName = DiscordConnectService.class.getSimpleName();
            m.checkNotNullExpressionValue(simpleName, "DiscordConnectService::class.java.simpleName");
            Logger.i$default(appLog, simpleName, str, null, 4, null);
        }

        public final void b(Context context, long j) {
            m.checkNotNullParameter(context, "context");
            Intent intent = IntentUtils.RouteBuilders.INSTANCE.connectVoice(j).setPackage(context.getPackageName());
            m.checkNotNullExpressionValue(intent, "IntentUtils.RouteBuilder…kage(context.packageName)");
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        }
    }

    /* compiled from: DiscordConnectService.kt */
    public static final class b extends o implements Function1<Object, Unit> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Object obj) {
            return Unit.a;
        }
    }

    /* compiled from: DiscordConnectService.kt */
    public static final class c extends o implements Function0<Unit> {
        public final /* synthetic */ int $startId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i) {
            super(0);
            this.$startId = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Companion companion = DiscordConnectService.INSTANCE;
            StringBuilder sbU = a.U("Success[");
            sbU.append(this.$startId);
            sbU.append(']');
            Companion.a(companion, sbU.toString());
            DiscordConnectService discordConnectService = DiscordConnectService.this;
            int i = this.$startId;
            discordConnectService.stopForeground(true);
            discordConnectService.stopSelf(i);
            return Unit.a;
        }
    }

    /* compiled from: DiscordConnectService.kt */
    public static final class d extends o implements Function1<Error, Unit> {
        public final /* synthetic */ int $startId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i) {
            super(1);
            this.$startId = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Error error) {
            Error error2 = error;
            m.checkNotNullParameter(error2, "it");
            error2.setShouldLog(false);
            Companion companion = DiscordConnectService.INSTANCE;
            StringBuilder sbU = a.U("Request timeout[");
            sbU.append(this.$startId);
            sbU.append("]: ");
            sbU.append(error2);
            Companion.a(companion, sbU.toString());
            DiscordConnectService discordConnectService = DiscordConnectService.this;
            int i = this.$startId;
            discordConnectService.stopForeground(true);
            discordConnectService.stopSelf(i);
            return Unit.a;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        throw new IllegalStateException("All my bases are belong to me!");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        AppLog appLog = AppLog.g;
        String simpleName = DiscordConnectService.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "DiscordConnectService::class.java.simpleName");
        Logger.i$default(appLog, simpleName, "onCreate", null, 4, null);
        l.c.a(this);
        Notification notificationBuild = new NotificationCompat.Builder(this, NotificationClient.NOTIF_CHANNEL_SOCIAL).setAutoCancel(true).setOnlyAlertOnce(true).setLocalOnly(true).setSmallIcon(R.drawable.ic_notification_24dp).setColor(ColorCompat.getThemedColor(this, R.attr.color_brand_500)).setContentTitle(getString(R.string.connecting)).setContentText(getString(R.string.connection_status_awaiting_endpoint)).build();
        m.checkNotNullExpressionValue(notificationBuild, "NotificationCompat.Build…dpoint))\n        .build()");
        startForeground(100, notificationBuild);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Application application = getApplication();
        m.checkNotNullExpressionValue(application, "application");
        companion.initialize(application);
        AnalyticsUtils analyticsUtils = AnalyticsUtils.INSTANCE;
        Application application2 = getApplication();
        m.checkNotNullExpressionValue(application2, "application");
        analyticsUtils.initAppOpen(application2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        AppLog appLog = AppLog.g;
        String simpleName = DiscordConnectService.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "DiscordConnectService::class.java.simpleName");
        Logger.i$default(appLog, simpleName, "onDestroy", null, 4, null);
        l.c.b(this);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Observable observableX;
        Observable kVar;
        List<String> groupValues;
        String str;
        String strQ = a.q("onStartCommand: ", startId);
        AppLog appLog = AppLog.g;
        String simpleName = DiscordConnectService.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "DiscordConnectService::class.java.simpleName");
        Logger.i$default(appLog, simpleName, strQ, null, 4, null);
        Uri data = intent != null ? intent.getData() : null;
        if (data == null || !IntentUtils.INSTANCE.isDiscordAppUri(data)) {
            String simpleName2 = DiscordConnectService.class.getSimpleName();
            m.checkNotNullExpressionValue(simpleName2, "DiscordConnectService::class.java.simpleName");
            Logger.i$default(appLog, simpleName2, "Invalid request " + data, null, 4, null);
            stopForeground(true);
            stopSelf(startId);
            return 2;
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        if (companion.getAuthentication().getAuthState() == null) {
            b.a.d.m.g(this, R.string.overlay_mobile_unauthed, 0, null, 12);
            observableX = Observable.x(new IllegalStateException("UNAUTHED"));
            m.checkNotNullExpressionValue(observableX, "Observable.error(Illegal…ateException(\"UNAUTHED\"))");
        } else {
            b.a.d.m0.a aVar = b.a.d.m0.a.G;
            Regex regex = b.a.d.m0.a.f61s;
            String path = data.getPath();
            if (path == null) {
                path = "";
            }
            MatchResult matchResultMatchEntire = regex.matchEntire(path);
            Long longOrNull = (matchResultMatchEntire == null || (groupValues = matchResultMatchEntire.getGroupValues()) == null || (str = (String) u.getOrNull(groupValues, 1)) == null) ? null : s.toLongOrNull(str);
            if (matchResultMatchEntire != null) {
                companion.getAnalytics().deepLinkReceived(intent != null ? intent : new Intent(), new RouteHandlers.AnalyticsMetadata("connect", null, longOrNull, 2, null));
            }
            if (longOrNull != null) {
                if (ContextCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") != 0) {
                    b.a.d.m.g(this, R.string.permission_microphone_denied, 0, null, 12);
                    observableX = Observable.x(new IllegalStateException("Do not have microphone permissions, go to main app"));
                    m.checkNotNullExpressionValue(observableX, "Observable.error(\n      …to main app\")\n          )");
                } else {
                    long jLongValue = longOrNull.longValue();
                    String simpleName3 = DiscordConnectService.class.getSimpleName();
                    m.checkNotNullExpressionValue(simpleName3, "DiscordConnectService::class.java.simpleName");
                    Logger.i$default(appLog, simpleName3, "Try joining voice channel", null, 4, null);
                    companion.getVoiceChannelSelected().selectVoiceChannel(jLongValue);
                    Observable observableY = StoreConnectionOpen.observeConnectionOpen$default(companion.getConnectionOpen(), false, 1, null).y(j0.j);
                    m.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…()\n        .filter { it }");
                    observableX = ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 10000L, false, 2, null).Y(l0.j);
                    m.checkNotNullExpressionValue(observableX, "isConnectedObs.switchMap…nnected\n          }\n    }");
                }
            } else {
                if (matchResultMatchEntire != null) {
                    DiscordOverlayService.INSTANCE.launchForConnect(this);
                    kVar = new k(Unit.a);
                    m.checkNotNullExpressionValue(kVar, "Observable.just(Unit)");
                    ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(kVar, 10000L, false, 2, null), DiscordConnectService.class, (Context) null, (Function1) null, new d(startId), new c(startId), (Function0) null, b.j, 38, (Object) null);
                    return 2;
                }
                observableX = Observable.x(new IllegalArgumentException("Invalid Request: " + data));
                m.checkNotNullExpressionValue(observableX, "Observable.error(Illegal…\"Invalid Request: $uri\"))");
            }
        }
        kVar = observableX;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(kVar, 10000L, false, 2, null), DiscordConnectService.class, (Context) null, (Function1) null, new d(startId), new c(startId), (Function0) null, b.j, 38, (Object) null);
        return 2;
    }
}
