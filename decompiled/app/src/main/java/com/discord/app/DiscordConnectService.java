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
import com.discord.C5419R;
import com.discord.stores.StoreConnectionOpen;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.intent.RouteHandlers;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.voice.DiscordOverlayService;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import p007b.p008a.p018d.AppState2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.DiscordConnectService2;
import p007b.p008a.p018d.DiscordConnectService4;
import p007b.p008a.p018d.p019m0.RoutingPatterns;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.StringNumberConversions;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

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

        /* renamed from: a */
        public static final void m8374a(Companion companion, String str) {
            AppLog appLog = AppLog.f14950g;
            String simpleName = DiscordConnectService.class.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName, "DiscordConnectService::class.java.simpleName");
            Logger.i$default(appLog, simpleName, str, null, 4, null);
        }

        /* renamed from: b */
        public final void m8375b(Context context, long j) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = IntentUtils.RouteBuilders.INSTANCE.connectVoice(j).setPackage(context.getPackageName());
            Intrinsics3.checkNotNullExpressionValue(intent, "IntentUtils.RouteBuilder…kage(context.packageName)");
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        }
    }

    /* compiled from: DiscordConnectService.kt */
    /* renamed from: com.discord.app.DiscordConnectService$b */
    public static final class C5459b extends Lambda implements Function1<Object, Unit> {

        /* renamed from: j */
        public static final C5459b f14971j = new C5459b();

        public C5459b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Object obj) {
            return Unit.f27425a;
        }
    }

    /* compiled from: DiscordConnectService.kt */
    /* renamed from: com.discord.app.DiscordConnectService$c */
    public static final class C5460c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int $startId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C5460c(int i) {
            super(0);
            this.$startId = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Companion companion = DiscordConnectService.INSTANCE;
            StringBuilder sbM833U = outline.m833U("Success[");
            sbM833U.append(this.$startId);
            sbM833U.append(']');
            Companion.m8374a(companion, sbM833U.toString());
            DiscordConnectService discordConnectService = DiscordConnectService.this;
            int i = this.$startId;
            discordConnectService.stopForeground(true);
            discordConnectService.stopSelf(i);
            return Unit.f27425a;
        }
    }

    /* compiled from: DiscordConnectService.kt */
    /* renamed from: com.discord.app.DiscordConnectService$d */
    public static final class C5461d extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ int $startId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C5461d(int i) {
            super(1);
            this.$startId = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Error error) {
            Error error2 = error;
            Intrinsics3.checkNotNullParameter(error2, "it");
            error2.setShouldLog(false);
            Companion companion = DiscordConnectService.INSTANCE;
            StringBuilder sbM833U = outline.m833U("Request timeout[");
            sbM833U.append(this.$startId);
            sbM833U.append("]: ");
            sbM833U.append(error2);
            Companion.m8374a(companion, sbM833U.toString());
            DiscordConnectService discordConnectService = DiscordConnectService.this;
            int i = this.$startId;
            discordConnectService.stopForeground(true);
            discordConnectService.stopSelf(i);
            return Unit.f27425a;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        throw new IllegalStateException("All my bases are belong to me!");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        AppLog appLog = AppLog.f14950g;
        String simpleName = DiscordConnectService.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "DiscordConnectService::class.java.simpleName");
        Logger.i$default(appLog, simpleName, "onCreate", null, 4, null);
        AppState2.f530c.m161a(this);
        Notification notificationBuild = new NotificationCompat.Builder(this, NotificationClient.NOTIF_CHANNEL_SOCIAL).setAutoCancel(true).setOnlyAlertOnce(true).setLocalOnly(true).setSmallIcon(C5419R.drawable.ic_notification_24dp).setColor(ColorCompat.getThemedColor(this, C5419R.attr.color_brand_500)).setContentTitle(getString(C5419R.string.connecting)).setContentText(getString(C5419R.string.connection_status_awaiting_endpoint)).build();
        Intrinsics3.checkNotNullExpressionValue(notificationBuild, "NotificationCompat.Build…dpoint))\n        .build()");
        startForeground(100, notificationBuild);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Application application = getApplication();
        Intrinsics3.checkNotNullExpressionValue(application, "application");
        companion.initialize(application);
        AnalyticsUtils analyticsUtils = AnalyticsUtils.INSTANCE;
        Application application2 = getApplication();
        Intrinsics3.checkNotNullExpressionValue(application2, "application");
        analyticsUtils.initAppOpen(application2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        AppLog appLog = AppLog.f14950g;
        String simpleName = DiscordConnectService.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "DiscordConnectService::class.java.simpleName");
        Logger.i$default(appLog, simpleName, "onDestroy", null, 4, null);
        AppState2.f530c.m162b(this);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Observable observableM11081x;
        Observable scalarSynchronousObservable;
        List<String> groupValues;
        String str;
        String strM871q = outline.m871q("onStartCommand: ", startId);
        AppLog appLog = AppLog.f14950g;
        String simpleName = DiscordConnectService.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "DiscordConnectService::class.java.simpleName");
        Logger.i$default(appLog, simpleName, strM871q, null, 4, null);
        Uri data = intent != null ? intent.getData() : null;
        if (data == null || !IntentUtils.INSTANCE.isDiscordAppUri(data)) {
            String simpleName2 = DiscordConnectService.class.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName2, "DiscordConnectService::class.java.simpleName");
            Logger.i$default(appLog, simpleName2, "Invalid request " + data, null, 4, null);
            stopForeground(true);
            stopSelf(startId);
            return 2;
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        if (companion.getAuthentication().getAuthState() == null) {
            AppToast.m169g(this, C5419R.string.overlay_mobile_unauthed, 0, null, 12);
            observableM11081x = Observable.m11081x(new IllegalStateException("UNAUTHED"));
            Intrinsics3.checkNotNullExpressionValue(observableM11081x, "Observable.error(Illegal…ateException(\"UNAUTHED\"))");
        } else {
            RoutingPatterns routingPatterns = RoutingPatterns.f538G;
            Regex regex = RoutingPatterns.f557s;
            String path = data.getPath();
            if (path == null) {
                path = "";
            }
            MatchResult matchResultMatchEntire = regex.matchEntire(path);
            Long longOrNull = (matchResultMatchEntire == null || (groupValues = matchResultMatchEntire.getGroupValues()) == null || (str = (String) _Collections.getOrNull(groupValues, 1)) == null) ? null : StringNumberConversions.toLongOrNull(str);
            if (matchResultMatchEntire != null) {
                companion.getAnalytics().deepLinkReceived(intent != null ? intent : new Intent(), new RouteHandlers.AnalyticsMetadata("connect", null, longOrNull, 2, null));
            }
            if (longOrNull != null) {
                if (ContextCompat.checkSelfPermission(this, "android.permission.RECORD_AUDIO") != 0) {
                    AppToast.m169g(this, C5419R.string.permission_microphone_denied, 0, null, 12);
                    observableM11081x = Observable.m11081x(new IllegalStateException("Do not have microphone permissions, go to main app"));
                    Intrinsics3.checkNotNullExpressionValue(observableM11081x, "Observable.error(\n      …to main app\")\n          )");
                } else {
                    long jLongValue = longOrNull.longValue();
                    String simpleName3 = DiscordConnectService.class.getSimpleName();
                    Intrinsics3.checkNotNullExpressionValue(simpleName3, "DiscordConnectService::class.java.simpleName");
                    Logger.i$default(appLog, simpleName3, "Try joining voice channel", null, 4, null);
                    companion.getVoiceChannelSelected().selectVoiceChannel(jLongValue);
                    Observable observableM11118y = StoreConnectionOpen.observeConnectionOpen$default(companion.getConnectionOpen(), false, 1, null).m11118y(DiscordConnectService2.f525j);
                    Intrinsics3.checkNotNullExpressionValue(observableM11118y, "StoreStream\n        .get…()\n        .filter { it }");
                    observableM11081x = ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11118y, 10000L, false, 2, null).m11099Y(DiscordConnectService4.f531j);
                    Intrinsics3.checkNotNullExpressionValue(observableM11081x, "isConnectedObs.switchMap…nnected\n          }\n    }");
                }
            } else {
                if (matchResultMatchEntire != null) {
                    DiscordOverlayService.INSTANCE.launchForConnect(this);
                    scalarSynchronousObservable = new ScalarSynchronousObservable(Unit.f27425a);
                    Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(Unit)");
                    ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(scalarSynchronousObservable, 10000L, false, 2, null), DiscordConnectService.class, (Context) null, (Function1) null, new C5461d(startId), new C5460c(startId), (Function0) null, C5459b.f14971j, 38, (Object) null);
                    return 2;
                }
                observableM11081x = Observable.m11081x(new IllegalArgumentException("Invalid Request: " + data));
                Intrinsics3.checkNotNullExpressionValue(observableM11081x, "Observable.error(Illegal…\"Invalid Request: $uri\"))");
            }
        }
        scalarSynchronousObservable = observableM11081x;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(scalarSynchronousObservable, 10000L, false, 2, null), DiscordConnectService.class, (Context) null, (Function1) null, new C5461d(startId), new C5460c(startId), (Function0) null, C5459b.f14971j, 38, (Object) null);
        return 2;
    }
}
