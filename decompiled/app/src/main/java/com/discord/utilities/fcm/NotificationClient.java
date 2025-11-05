package com.discord.utilities.fcm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import androidx.core.app.FrameMetricsAggregator;
import b.d.b.a.a;
import b.i.a.f.n.c;
import b.i.c.w.i;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.collections.CollectionExtensionsKt;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import d0.o;
import d0.t.h0;
import d0.z.d.m;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NotificationClient.kt */
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes2.dex */
public final class NotificationClient {
    public static final String IGNORED_NOTIFICATION_TYPE = "top_messages_push";
    public static final String NOTIF_CHANNEL_CALLS = "Calls";
    public static final String NOTIF_CHANNEL_FORUM_POST_CREATE = "Forum Post Create";
    public static final String NOTIF_CHANNEL_GAME_DETECTION = "Game Detection";
    public static final String NOTIF_CHANNEL_MEDIA_CONNECTIONS = "Media Connections";
    public static final String NOTIF_CHANNEL_MESSAGES = "Messages";
    public static final String NOTIF_CHANNEL_MESSAGES_DIRECT = "DirectMessages";
    public static final String NOTIF_CHANNEL_SOCIAL = "Social";
    public static final String NOTIF_CHANNEL_STAGE_START = "Stage Live";
    public static final String NOTIF_GENERAL = "General";
    public static final String NOTIF_GENERAL_HIGH_PRIO = "GeneralHigh";
    public static final String NOTIF_GUILD_SCHEDULED_EVENT_START = "Guild Event Live";
    private static Context context;
    private static String token;
    public static final NotificationClient INSTANCE = new NotificationClient();
    private static final Persister<SettingsV2> settings = new Persister<>("NOTIFICATION_CLIENT_SETTINGS_V3", new SettingsV2(false, false, false, false, false, false, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null));
    private static Function1<? super String, Unit> tokenCallback = NotificationClient$tokenCallback$1.INSTANCE;
    private static boolean isBackgrounded = true;

    /* compiled from: NotificationClient.kt */
    public static final class FCMMessagingService extends FirebaseMessagingService {
        @Override // com.google.firebase.messaging.FirebaseMessagingService
        public void onMessageReceived(RemoteMessage remoteMessage) {
            m.checkNotNullParameter(remoteMessage, "remoteMessage");
            super.onMessageReceived(remoteMessage);
            if (remoteMessage.k == null) {
                Bundle bundle = remoteMessage.j;
                ArrayMap arrayMap = new ArrayMap();
                for (String str : bundle.keySet()) {
                    Object obj = bundle.get(str);
                    if (obj instanceof String) {
                        String str2 = (String) obj;
                        if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                            arrayMap.put(str, str2);
                        }
                    }
                }
                remoteMessage.k = arrayMap;
            }
            Map<String, String> map = remoteMessage.k;
            m.checkNotNullExpressionValue(map, "remoteMessage.data");
            AppLog.i("Got notification: " + map);
            NotificationData notificationData = new NotificationData(map);
            SettingsV2 settings$app_productionGoogleRelease = NotificationClient.INSTANCE.getSettings$app_productionGoogleRelease();
            Iterator<Long> it = notificationData.getAckChannelIds().iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                NotificationClient notificationClient = NotificationClient.INSTANCE;
                notificationClient.clear(jLongValue, NotificationClient.access$getContext$p(notificationClient), true);
            }
            NotificationClient notificationClient2 = NotificationClient.INSTANCE;
            Context contextAccess$getContext$p = NotificationClient.access$getContext$p(notificationClient2);
            if (contextAccess$getContext$p == null) {
                Logger.e$default(AppLog.g, "Not showing notification because context was null.", null, null, 6, null);
                return;
            }
            if (!notificationData.isValid() || !settings$app_productionGoogleRelease.getIsAuthed()) {
                if (m.areEqual(notificationData.getType(), NotificationData.TYPE_MESSAGE_CREATE)) {
                    Logger.e$default(AppLog.g, "Not showing invalid notification", null, h0.mapOf(o.to("messageId", String.valueOf(notificationData.getMessageId())), o.to("channelId", String.valueOf(notificationData.getChannelId())), o.to("isAuthed", String.valueOf(settings$app_productionGoogleRelease.getIsAuthed())), o.to("type", notificationData.getType())), 2, null);
                    return;
                }
                return;
            }
            if (m.areEqual(notificationData.getTrackingType(), NotificationClient.IGNORED_NOTIFICATION_TYPE)) {
                Pair[] pairArr = new Pair[5];
                String trackingType = notificationData.getTrackingType();
                if (trackingType == null) {
                    trackingType = notificationData.getType();
                }
                pairArr[0] = o.to("notif_type", trackingType);
                pairArr[1] = o.to("notif_user_id", Long.valueOf(notificationData.getUserId()));
                pairArr[2] = o.to("message_id", Long.valueOf(notificationData.getMessageId()));
                pairArr[3] = o.to(ModelAuditLogEntry.CHANGE_KEY_GUILD_ID, Long.valueOf(notificationData.getGuildId()));
                pairArr[4] = o.to("notification_id", notificationData.getNotificationId());
                AnalyticsTracker.INSTANCE.appNotificationDropped(CollectionExtensionsKt.filterNonNullValues(h0.mapOf(pairArr)));
                return;
            }
            if (notificationData.getChannelId() != -1) {
                NotificationCache.INSTANCE.setIgnoreNextClearForAck(notificationData.getChannelId(), false);
            }
            if (NotificationClient.access$isBackgrounded$p(notificationClient2) && settings$app_productionGoogleRelease.isEnabled()) {
                NotificationRenderer.INSTANCE.display(contextAccess$getContext$p, notificationData, settings$app_productionGoogleRelease);
            } else {
                if (NotificationClient.access$isBackgrounded$p(notificationClient2) || !settings$app_productionGoogleRelease.isEnabledInApp()) {
                    return;
                }
                NotificationRenderer.INSTANCE.displayInApp(contextAccess$getContext$p, notificationData);
            }
        }

        @Override // com.google.firebase.messaging.FirebaseMessagingService
        public void onNewToken(String token) {
            m.checkNotNullParameter(token, "token");
            NotificationClient.INSTANCE.onNewToken(token);
        }
    }

    /* compiled from: NotificationClient.kt */
    /* renamed from: com.discord.utilities.fcm.NotificationClient$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.z.d.o implements Function0<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2() {
            return NotificationClient.INSTANCE.getSettings$app_productionGoogleRelease().getToken();
        }
    }

    /* compiled from: NotificationClient.kt */
    /* renamed from: com.discord.utilities.fcm.NotificationClient$init$2, reason: invalid class name */
    public static final class AnonymousClass2 extends d0.z.d.o implements Function0<String> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ String invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2() {
            return NotificationClient.INSTANCE.getSettings$app_productionGoogleRelease().getLocale();
        }
    }

    /* compiled from: NotificationClient.kt */
    /* renamed from: com.discord.utilities.fcm.NotificationClient$init$3, reason: invalid class name */
    public static final class AnonymousClass3<TResult> implements c<String> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // b.i.a.f.n.c
        public final void onComplete(Task<String> task) {
            m.checkNotNullExpressionValue(task, "task");
            if (task.p()) {
                NotificationClient.INSTANCE.onNewToken(task.l());
            } else {
                AppLog.g.w("Fetching FCM registration token failed", task.k());
            }
        }
    }

    private NotificationClient() {
    }

    public static final /* synthetic */ Context access$getContext$p(NotificationClient notificationClient) {
        return context;
    }

    public static final /* synthetic */ boolean access$isBackgrounded$p(NotificationClient notificationClient) {
        return isBackgrounded;
    }

    public static final /* synthetic */ void access$setBackgrounded$p(NotificationClient notificationClient, boolean z2) {
        isBackgrounded = z2;
    }

    public static final /* synthetic */ void access$setContext$p(NotificationClient notificationClient, Context context2) {
        context = context2;
    }

    public static /* synthetic */ void clear$default(NotificationClient notificationClient, long j, Context context2, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            context2 = null;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        notificationClient.clear(j, context2, z2);
    }

    public final Map<String, Object> buildTrackingData(Intent intent) {
        return NotificationData.INSTANCE.buildTrackingData(intent);
    }

    public final void clear(long channelId, Context context2, boolean isAckRequest) {
        NotificationRenderer notificationRenderer = NotificationRenderer.INSTANCE;
        if (context2 == null) {
            context2 = context;
        }
        notificationRenderer.clear(context2, channelId, isAckRequest);
    }

    public final synchronized SettingsV2 getSettings$app_productionGoogleRelease() {
        return settings.get();
    }

    @TargetApi(26)
    public final void init(Application application) {
        FirebaseMessaging firebaseMessaging;
        m.checkNotNullParameter(application, "application");
        context = application;
        if (isOsLevelNotificationEnabled()) {
            NotificationRenderer.INSTANCE.initNotificationChannels(application);
        }
        RestAPI.AppHeadersProvider.authTokenProvider = AnonymousClass1.INSTANCE;
        RestAPI.AppHeadersProvider.localeProvider = AnonymousClass2.INSTANCE;
        try {
            synchronized (FirebaseMessaging.class) {
                firebaseMessaging = FirebaseMessaging.getInstance(b.i.c.c.b());
            }
            m.checkNotNullExpressionValue(firebaseMessaging, "FirebaseMessaging.getInstance()");
            m.checkNotNullExpressionValue(firebaseMessaging.d.f().h(i.a).b(AnonymousClass3.INSTANCE), "FirebaseMessaging.getIns…eption)\n        }\n      }");
        } catch (IllegalStateException e) {
            AppLog.g.w("FCM service start error", e);
        }
    }

    public final synchronized boolean isAuthed() {
        return settings.get().getIsAuthed();
    }

    public final boolean isOsLevelNotificationEnabled() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public final synchronized void onNewToken(String token2) {
        AppLog appLog = AppLog.g;
        StringBuilder sb = new StringBuilder();
        sb.append("FCM token received. hash=");
        sb.append(token2 != null ? Integer.valueOf(token2.hashCode()) : null);
        Logger.d$default(appLog, sb.toString(), null, 2, null);
        token = token2;
        tokenCallback.invoke(token2);
    }

    public final synchronized void setRegistrationIdReceived(Function1<? super String, Unit> onDeviceRegistrationIdReceived) {
        m.checkNotNullParameter(onDeviceRegistrationIdReceived, "onDeviceRegistrationIdReceived");
        tokenCallback = onDeviceRegistrationIdReceived;
        onDeviceRegistrationIdReceived.invoke(token);
    }

    public final synchronized void updateSettings$app_productionGoogleRelease(SettingsV2 settings2, boolean isBackgrounded2) {
        m.checkNotNullParameter(settings2, "settings");
        settings.set(settings2, isBackgrounded2);
        isBackgrounded = isBackgrounded2;
    }

    /* compiled from: NotificationClient.kt */
    public static final /* data */ class SettingsV2 {
        private final boolean isAuthed;
        private final boolean isDisableBlink;
        private final boolean isDisableSound;
        private final boolean isDisableVibrate;
        private final boolean isEnabled;
        private final boolean isEnabledInApp;
        private final boolean isWake;
        private final String locale;
        private final Set<Long> sendBlockedChannels;
        private final String token;

        public SettingsV2() {
            this(false, false, false, false, false, false, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
        }

        public SettingsV2(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, String str2, Set<Long> set) {
            m.checkNotNullParameter(str2, "locale");
            m.checkNotNullParameter(set, "sendBlockedChannels");
            this.isEnabled = z2;
            this.isEnabledInApp = z3;
            this.isWake = z4;
            this.isDisableBlink = z5;
            this.isDisableSound = z6;
            this.isDisableVibrate = z7;
            this.token = str;
            this.locale = str2;
            this.sendBlockedChannels = set;
            this.isAuthed = str != null;
        }

        public static /* synthetic */ SettingsV2 copy$default(SettingsV2 settingsV2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, String str2, Set set, int i, Object obj) {
            return settingsV2.copy((i & 1) != 0 ? settingsV2.isEnabled : z2, (i & 2) != 0 ? settingsV2.isEnabledInApp : z3, (i & 4) != 0 ? settingsV2.isWake : z4, (i & 8) != 0 ? settingsV2.isDisableBlink : z5, (i & 16) != 0 ? settingsV2.isDisableSound : z6, (i & 32) != 0 ? settingsV2.isDisableVibrate : z7, (i & 64) != 0 ? settingsV2.token : str, (i & 128) != 0 ? settingsV2.locale : str2, (i & 256) != 0 ? settingsV2.sendBlockedChannels : set);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsEnabled() {
            return this.isEnabled;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsEnabledInApp() {
            return this.isEnabledInApp;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsWake() {
            return this.isWake;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsDisableBlink() {
            return this.isDisableBlink;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsDisableSound() {
            return this.isDisableSound;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsDisableVibrate() {
            return this.isDisableVibrate;
        }

        /* renamed from: component7, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        /* renamed from: component8, reason: from getter */
        public final String getLocale() {
            return this.locale;
        }

        public final Set<Long> component9() {
            return this.sendBlockedChannels;
        }

        public final SettingsV2 copy(boolean isEnabled, boolean isEnabledInApp, boolean isWake, boolean isDisableBlink, boolean isDisableSound, boolean isDisableVibrate, String token, String locale, Set<Long> sendBlockedChannels) {
            m.checkNotNullParameter(locale, "locale");
            m.checkNotNullParameter(sendBlockedChannels, "sendBlockedChannels");
            return new SettingsV2(isEnabled, isEnabledInApp, isWake, isDisableBlink, isDisableSound, isDisableVibrate, token, locale, sendBlockedChannels);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SettingsV2)) {
                return false;
            }
            SettingsV2 settingsV2 = (SettingsV2) other;
            return this.isEnabled == settingsV2.isEnabled && this.isEnabledInApp == settingsV2.isEnabledInApp && this.isWake == settingsV2.isWake && this.isDisableBlink == settingsV2.isDisableBlink && this.isDisableSound == settingsV2.isDisableSound && this.isDisableVibrate == settingsV2.isDisableVibrate && m.areEqual(this.token, settingsV2.token) && m.areEqual(this.locale, settingsV2.locale) && m.areEqual(this.sendBlockedChannels, settingsV2.sendBlockedChannels);
        }

        public final String getLocale() {
            return this.locale;
        }

        public final Set<Long> getSendBlockedChannels() {
            return this.sendBlockedChannels;
        }

        public final String getToken() {
            return this.token;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.isEnabled;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.isEnabledInApp;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            ?? r22 = this.isWake;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            ?? r23 = this.isDisableBlink;
            int i6 = r23;
            if (r23 != 0) {
                i6 = 1;
            }
            int i7 = (i5 + i6) * 31;
            ?? r24 = this.isDisableSound;
            int i8 = r24;
            if (r24 != 0) {
                i8 = 1;
            }
            int i9 = (i7 + i8) * 31;
            boolean z3 = this.isDisableVibrate;
            int i10 = (i9 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            String str = this.token;
            int iHashCode = (i10 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.locale;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Set<Long> set = this.sendBlockedChannels;
            return iHashCode2 + (set != null ? set.hashCode() : 0);
        }

        /* renamed from: isAuthed, reason: from getter */
        public final boolean getIsAuthed() {
            return this.isAuthed;
        }

        public final boolean isDisableBlink() {
            return this.isDisableBlink;
        }

        public final boolean isDisableSound() {
            return this.isDisableSound;
        }

        public final boolean isDisableVibrate() {
            return this.isDisableVibrate;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        public final boolean isEnabledInApp() {
            return this.isEnabledInApp;
        }

        public final boolean isWake() {
            return this.isWake;
        }

        public String toString() {
            StringBuilder sbU = a.U("SettingsV2(isEnabled=");
            sbU.append(this.isEnabled);
            sbU.append(", isEnabledInApp=");
            sbU.append(this.isEnabledInApp);
            sbU.append(", isWake=");
            sbU.append(this.isWake);
            sbU.append(", isDisableBlink=");
            sbU.append(this.isDisableBlink);
            sbU.append(", isDisableSound=");
            sbU.append(this.isDisableSound);
            sbU.append(", isDisableVibrate=");
            sbU.append(this.isDisableVibrate);
            sbU.append(", token=");
            sbU.append(this.token);
            sbU.append(", locale=");
            sbU.append(this.locale);
            sbU.append(", sendBlockedChannels=");
            return a.N(sbU, this.sendBlockedChannels, ")");
        }

        public /* synthetic */ SettingsV2(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, String str2, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z2, (i & 2) == 0 ? z3 : true, (i & 4) != 0 ? false : z4, (i & 8) != 0 ? false : z5, (i & 16) != 0 ? false : z6, (i & 32) != 0 ? false : z7, (i & 64) != 0 ? null : str, (i & 128) != 0 ? "" : str2, (i & 256) != 0 ? new HashSet(0) : set);
        }
    }
}
