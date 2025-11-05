package com.discord.stores;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.app.NotificationCompat;
import b.a.e.d;
import b.d.b.a.a;
import b.i.a.f.e.o.f;
import com.discord.api.channel.Channel;
import com.discord.api.presence.ClientStatus;
import com.discord.app.AppActivity;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ActivityLifecycleCallbacks;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.widgets.notice.NoticePopupChannel;
import d0.l;
import d0.o;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.z.d.k;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;
import rx.functions.Func2;
import s.a.k0;

/* compiled from: StoreNotifications.kt */
/* loaded from: classes2.dex */
public final class StoreNotifications extends Store {
    private static final long INAPP_MESSAGE_WINDOW_MS = 10000;
    private String authToken;
    private final Clock clock;
    private Context context;
    private final Persister<NotificationClient.SettingsV2> notificationSettings;
    private String pushToken;
    private String pushTokenPersisted;
    private final StoreStream stream;

    /* compiled from: StoreNotifications.kt */
    /* renamed from: com.discord.stores.StoreNotifications$configureContextSetter$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ActivityLifecycleCallbacks {
        public AnonymousClass1() {
        }

        @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
        public void onActivityCreatedOrResumed(AppActivity activity) {
            m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            super.onActivityCreatedOrResumed(activity);
            StoreNotifications.access$setContext$p(StoreNotifications.this, activity);
        }

        @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
        public void onActivityDestroyed(AppActivity activity) {
            m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            super.onActivityDestroyed(activity);
            StoreNotifications.access$setContext$p(StoreNotifications.this, null);
        }
    }

    /* compiled from: StoreNotifications.kt */
    /* renamed from: com.discord.stores.StoreNotifications$configureNotificationClient$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<String, Unit> {
        public AnonymousClass1(StoreNotifications storeNotifications) {
            super(1, storeNotifications, StoreNotifications.class, "handleRegistrationToken", "handleRegistrationToken(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            StoreNotifications.access$handleRegistrationToken((StoreNotifications) this.receiver, str);
        }
    }

    /* compiled from: StoreNotifications.kt */
    /* renamed from: com.discord.stores.StoreNotifications$configureNotificationClient$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<NotificationClient.SettingsV2, Boolean, Pair<? extends NotificationClient.SettingsV2, ? extends Boolean>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Pair<? extends NotificationClient.SettingsV2, ? extends Boolean> call(NotificationClient.SettingsV2 settingsV2, Boolean bool) {
            return call2(settingsV2, bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Pair<NotificationClient.SettingsV2, Boolean> call2(NotificationClient.SettingsV2 settingsV2, Boolean bool) {
            return o.to(settingsV2, bool);
        }
    }

    /* compiled from: StoreNotifications.kt */
    /* renamed from: com.discord.stores.StoreNotifications$configureNotificationClient$3, reason: invalid class name */
    public static final class AnonymousClass3 extends d0.z.d.o implements Function1<Pair<? extends NotificationClient.SettingsV2, ? extends Boolean>, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends NotificationClient.SettingsV2, ? extends Boolean> pair) {
            invoke2((Pair<NotificationClient.SettingsV2, Boolean>) pair);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Pair<NotificationClient.SettingsV2, Boolean> pair) {
            NotificationClient.SettingsV2 settingsV2Component1 = pair.component1();
            Boolean boolComponent2 = pair.component2();
            NotificationClient notificationClient = NotificationClient.INSTANCE;
            m.checkNotNullExpressionValue(settingsV2Component1, "settings");
            m.checkNotNullExpressionValue(boolComponent2, "isBackgrounded");
            notificationClient.updateSettings$app_productionGoogleRelease(settingsV2Component1, boolComponent2.booleanValue());
        }
    }

    /* compiled from: StoreNotifications.kt */
    /* renamed from: com.discord.stores.StoreNotifications$displayPopup$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.z.d.o implements Function1<View, Unit> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Channel channel, Message message) {
            super(1);
            this.$channel = channel;
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            m.checkNotNullParameter(view, "view");
            Intent intentSelectChannel = IntentUtils.RouteBuilders.selectChannel(this.$channel.getId(), this.$channel.getGuildId(), Long.valueOf(this.$message.getId()));
            intentSelectChannel.putExtra("com.discord.intent.ORIGIN_SOURCE", "com.discord.intent.ORIGIN_NOTIF_INAPP");
            IntentUtils intentUtils = IntentUtils.INSTANCE;
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "view.context");
            intentUtils.consumeExternalRoutingIntent(intentSelectChannel, context);
        }
    }

    /* compiled from: StoreNotifications.kt */
    @e(c = "com.discord.stores.StoreNotifications$handleChannelSelected$1", f = "StoreNotifications.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.discord.stores.StoreNotifications$handleChannelSelected$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.w.i.a.k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ long $channelId;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, Continuation continuation) {
            super(2, continuation);
            this.$channelId = j;
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(this.$channelId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            c.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
            NotificationClient.clear$default(NotificationClient.INSTANCE, this.$channelId, null, false, 6, null);
            return Unit.a;
        }
    }

    /* compiled from: StoreNotifications.kt */
    /* renamed from: com.discord.stores.StoreNotifications$setEnabled$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.z.d.o implements Function1<NotificationClient.SettingsV2, NotificationClient.SettingsV2> {
        public final /* synthetic */ boolean $enabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$enabled = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NotificationClient.SettingsV2 invoke(NotificationClient.SettingsV2 settingsV2) {
            return invoke2(settingsV2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NotificationClient.SettingsV2 invoke2(NotificationClient.SettingsV2 settingsV2) {
            m.checkNotNullParameter(settingsV2, "it");
            return NotificationClient.SettingsV2.copy$default(settingsV2, this.$enabled, false, false, false, false, false, null, null, null, 510, null);
        }
    }

    /* compiled from: StoreNotifications.kt */
    /* renamed from: com.discord.stores.StoreNotifications$setNotificationLightDisabled$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.z.d.o implements Function1<NotificationClient.SettingsV2, NotificationClient.SettingsV2> {
        public final /* synthetic */ boolean $notificationLightDisabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$notificationLightDisabled = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NotificationClient.SettingsV2 invoke(NotificationClient.SettingsV2 settingsV2) {
            return invoke2(settingsV2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NotificationClient.SettingsV2 invoke2(NotificationClient.SettingsV2 settingsV2) {
            m.checkNotNullParameter(settingsV2, "it");
            return NotificationClient.SettingsV2.copy$default(settingsV2, false, false, false, this.$notificationLightDisabled, false, false, null, null, null, 503, null);
        }
    }

    /* compiled from: StoreNotifications.kt */
    /* renamed from: com.discord.stores.StoreNotifications$setNotificationSoundDisabled$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.z.d.o implements Function1<NotificationClient.SettingsV2, NotificationClient.SettingsV2> {
        public final /* synthetic */ boolean $notificationSoundDisabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$notificationSoundDisabled = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NotificationClient.SettingsV2 invoke(NotificationClient.SettingsV2 settingsV2) {
            return invoke2(settingsV2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NotificationClient.SettingsV2 invoke2(NotificationClient.SettingsV2 settingsV2) {
            m.checkNotNullParameter(settingsV2, "it");
            return NotificationClient.SettingsV2.copy$default(settingsV2, false, false, false, false, this.$notificationSoundDisabled, false, null, null, null, 495, null);
        }
    }

    /* compiled from: StoreNotifications.kt */
    /* renamed from: com.discord.stores.StoreNotifications$setNotificationsVibrateDisabled$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.z.d.o implements Function1<NotificationClient.SettingsV2, NotificationClient.SettingsV2> {
        public final /* synthetic */ boolean $notificationsVibrateDisabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$notificationsVibrateDisabled = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ NotificationClient.SettingsV2 invoke(NotificationClient.SettingsV2 settingsV2) {
            return invoke2(settingsV2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final NotificationClient.SettingsV2 invoke2(NotificationClient.SettingsV2 settingsV2) {
            m.checkNotNullParameter(settingsV2, "it");
            return NotificationClient.SettingsV2.copy$default(settingsV2, false, false, false, false, false, this.$notificationsVibrateDisabled, null, null, null, 479, null);
        }
    }

    /* compiled from: StoreNotifications.kt */
    /* renamed from: com.discord.stores.StoreNotifications$tryTokenPersist$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.z.d.o implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            StoreNotifications storeNotifications = StoreNotifications.this;
            StoreNotifications.access$handleRegistrationTokenPersisted(storeNotifications, StoreNotifications.access$getPushToken$p(storeNotifications));
        }
    }

    public StoreNotifications(Clock clock, StoreStream storeStream) {
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(storeStream, "stream");
        this.clock = clock;
        this.stream = storeStream;
        this.notificationSettings = new Persister<>("STORE_NOTIFICATIONS_SETTINGS_V2", new NotificationClient.SettingsV2(false, false, false, false, false, false, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null));
    }

    public static final /* synthetic */ Context access$getContext$p(StoreNotifications storeNotifications) {
        return storeNotifications.context;
    }

    public static final /* synthetic */ String access$getPushToken$p(StoreNotifications storeNotifications) {
        return storeNotifications.pushToken;
    }

    public static final /* synthetic */ void access$handleRegistrationToken(StoreNotifications storeNotifications, String str) {
        storeNotifications.handleRegistrationToken(str);
    }

    public static final /* synthetic */ void access$handleRegistrationTokenPersisted(StoreNotifications storeNotifications, String str) {
        storeNotifications.handleRegistrationTokenPersisted(str);
    }

    public static final /* synthetic */ void access$setContext$p(StoreNotifications storeNotifications, Context context) {
        storeNotifications.context = context;
    }

    public static final /* synthetic */ void access$setPushToken$p(StoreNotifications storeNotifications, String str) {
        storeNotifications.pushToken = str;
    }

    private final void configureContextSetter(Application application) {
        application.registerActivityLifecycleCallbacks(new AnonymousClass1());
    }

    private final void configureNotificationClient() {
        NotificationClient.INSTANCE.setRegistrationIdReceived(new AnonymousClass1(this));
        Observable<NotificationClient.SettingsV2> settings = getSettings();
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableJ = Observable.j(Observable.h(settings, companion.getAuthentication().getAuthedToken$app_productionGoogleRelease(), companion.getUserSettingsSystem().observeSettings(false), ObservableExtensionsKt.leadingEdgeThrottle(companion.getPermissions().observePermissionsForAllChannels(), 1L, TimeUnit.SECONDS).G(StoreNotifications$configureNotificationClient$completedSettings$1.INSTANCE), StoreNotifications$configureNotificationClient$completedSettings$2.INSTANCE).r(), d.d.a(), AnonymousClass2.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable\n        .comb… isBackgrounded\n        }");
        Observable observableR = ObservableExtensionsKt.computationBuffered(observableJ).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n        .comb…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, (Context) null, "nsClient", (Function1) null, AnonymousClass3.INSTANCE, (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    private final void displayPopup(Message message, Channel channel) {
        Context context;
        if ((message.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH + 10000 <= this.clock.currentTimeMillis() || (context = this.context) == null) {
            return;
        }
        NoticePopupChannel noticePopupChannel = NoticePopupChannel.INSTANCE;
        StringBuilder sbU = a.U("{InAppNotif}#");
        sbU.append(message.getChannelId());
        noticePopupChannel.enqueue(context, sbU.toString(), message, new AnonymousClass1(channel, message));
    }

    private final synchronized void handleRegistrationToken(String pushToken) {
        this.pushToken = pushToken;
        tryTokenPersist();
    }

    private final synchronized void handleRegistrationTokenPersisted(String pushToken) {
        this.pushTokenPersisted = pushToken;
    }

    public static /* synthetic */ void setEnabledInApp$default(StoreNotifications storeNotifications, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 2) != 0) {
            z3 = true;
        }
        storeNotifications.setEnabledInApp(z2, z3);
    }

    private final void tryTokenPersist() {
        String str = this.authToken;
        if (str == null) {
            this.pushTokenPersisted = null;
        }
        if (str == null || m.areEqual(this.pushToken, this.pushTokenPersisted)) {
            return;
        }
        ObservableExtensionsKt.computationBuffered(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userCreateDevice(new RestAPIParams.UserDevices(this.pushToken)), false, 1, null)).k(b.a.d.o.a.g(null, new AnonymousClass1(), null));
    }

    public final synchronized String getPushToken() {
        return this.pushToken;
    }

    public final Observable<NotificationClient.SettingsV2> getSettings() {
        return ObservableExtensionsKt.computationBuffered(this.notificationSettings.getObservable());
    }

    public final synchronized void handleAuthToken(String authToken) {
        this.authToken = authToken;
        tryTokenPersist();
    }

    @StoreThread
    public final void handleChannelSelected(long channelId) {
        f.H0(f.c(k0.a), null, null, new AnonymousClass1(channelId, null), 3, null);
    }

    @StoreThread
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        Channel channel;
        m.checkNotNullParameter(message, "message");
        if (this.notificationSettings.get().isEnabledInApp() && this.stream.getPresences().getLocalPresence().getStatus() != ClientStatus.DND) {
            Map<Long, Integer> relationships = this.stream.getUserRelationships().getRelationships();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, Integer> entry : relationships.entrySet()) {
                if (entry.getValue().intValue() == 2) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            if (message.getChannelId() == this.stream.getChannelsSelected().getId()) {
                return;
            }
            Map<Long, Map<Long, Channel>> channelsByGuildInternal$app_productionGoogleRelease = this.stream.getChannels().getChannelsByGuildInternal$app_productionGoogleRelease();
            Long guildId = message.getGuildId();
            Map<Long, Channel> map = channelsByGuildInternal$app_productionGoogleRelease.get(Long.valueOf(guildId != null ? guildId.longValue() : 0L));
            Channel channel2 = this.stream.getChannels().getThreadsByIdInternal$app_productionGoogleRelease().get(Long.valueOf(message.getChannelId()));
            if (channel2 != null) {
                channel = channel2;
            } else if (map != null) {
                channel2 = map.get(Long.valueOf(message.getChannelId()));
                channel = channel2;
            } else {
                channel = null;
            }
            if (channel != null) {
                if (NotificationTextUtils.INSTANCE.shouldNotifyInAppPopup(this.stream.getUsers().getMe(), message, channel, linkedHashMap, map != null ? map.get(Long.valueOf(channel.getParentId())) : null, (Guild) a.c(channel, this.stream.getGuilds().getGuildsInternal$app_productionGoogleRelease()), this.stream.getGuilds().getGuildMembersComputedInternal$app_productionGoogleRelease(), this.stream.getGuildSettings().getGuildSettingsInternal$app_productionGoogleRelease(), this.stream.getThreadsJoined().getAllJoinedThreadsInternal$app_productionGoogleRelease(), this.stream.getVoiceChannelSelected().getSelectedVoiceChannelId(), (Long) a.d(channel, this.stream.getPermissions().getPermissionsByChannel()))) {
                    displayPopup(new Message(message), channel);
                }
            }
        }
    }

    public final void handlePreLogout() {
        Persister.set$default(this.notificationSettings, new NotificationClient.SettingsV2(false, false, false, false, false, false, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null), false, 2, null);
    }

    public final void init(Application application) {
        m.checkNotNullParameter(application, "application");
        super.init((Context) application);
        configureContextSetter(application);
        configureNotificationClient();
    }

    public final void setEnabled(boolean enabled) {
        this.notificationSettings.getAndSet(true, new AnonymousClass1(enabled));
        AnalyticsTracker.INSTANCE.updateNotifications(enabled);
    }

    public final void setEnabledInApp(boolean isEnabledInApp, boolean logToggle) {
        NotificationClient.SettingsV2 andSet = this.notificationSettings.getAndSet(true, new StoreNotifications$setEnabledInApp$oldValue$1(isEnabledInApp));
        if (!logToggle || andSet.isEnabledInApp() == isEnabledInApp) {
            return;
        }
        AnalyticsTracker.INSTANCE.updateNotificationsInApp(isEnabledInApp);
    }

    public final void setNotificationLightDisabled(boolean notificationLightDisabled) {
        this.notificationSettings.getAndSet(true, new AnonymousClass1(notificationLightDisabled));
    }

    public final void setNotificationSoundDisabled(boolean notificationSoundDisabled) {
        this.notificationSettings.getAndSet(true, new AnonymousClass1(notificationSoundDisabled));
    }

    public final void setNotificationsVibrateDisabled(boolean notificationsVibrateDisabled) {
        this.notificationSettings.getAndSet(true, new AnonymousClass1(notificationsVibrateDisabled));
    }
}
