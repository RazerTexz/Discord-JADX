package com.discord.utilities.analytics;

import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.adjust.sdk.Constants;
import com.discord.stores.StoreUserSettingsSystem;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.time.Clock;
import d0.g;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AppStartAnalyticsTracker.kt */
/* loaded from: classes2.dex */
public final class AppStartAnalyticsTracker {
    private static final String APP_FIRST_LAUNCHED = "app_first_launched";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy instance$delegate = g.lazy(AppStartAnalyticsTracker$Companion$instance$2.INSTANCE);
    private Long appOpenTimestamp;
    private final Clock clock;
    private final String openAppLoadId;
    private final StoreUserSettingsSystem storeUserSettingsSystem;
    private final AnalyticsUtils.Tracker tracker;

    /* compiled from: AppStartAnalyticsTracker.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Map access$insertUriProperties(Companion companion, Map map, Uri uri) {
            return companion.insertUriProperties(map, uri);
        }

        private final Map<String, Object> insertUriProperties(Map<String, Object> map, Uri uri) {
            String host = uri.getHost();
            if (host != null) {
                m.checkNotNullExpressionValue(host, "it");
                map.put("uri_host", host);
            }
            String scheme = uri.getScheme();
            if (scheme != null) {
                m.checkNotNullExpressionValue(scheme, "it");
                map.put("uri_scheme", scheme);
            }
            String path = uri.getPath();
            if (!(path == null || path.length() == 0)) {
                if (path.length() > 100) {
                    path = path.substring(0, 99);
                    m.checkNotNullExpressionValue(path, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                map.put("uri_path", path);
            }
            return map;
        }

        public final AppStartAnalyticsTracker getInstance() {
            Lazy lazyAccess$getInstance$cp = AppStartAnalyticsTracker.access$getInstance$cp();
            Companion companion = AppStartAnalyticsTracker.INSTANCE;
            return (AppStartAnalyticsTracker) lazyAccess$getInstance$cp.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AppStartAnalyticsTracker.kt */
    /* renamed from: com.discord.utilities.analytics.AppStartAnalyticsTracker$appOpen$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<String, ? extends Object>> {
        public final /* synthetic */ boolean $isNotificationRoute;
        public final /* synthetic */ Uri $uri;
        public final /* synthetic */ boolean $uriCanBeRouted;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2, boolean z3, Uri uri) {
            super(0);
            this.$isNotificationRoute = z2;
            this.$uriCanBeRouted = z3;
            this.$uri = uri;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<String, ? extends Object> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<String, ? extends Object> invoke2() {
            Pair[] pairArr = new Pair[2];
            pairArr[0] = d0.o.to("opened_from", this.$isNotificationRoute ? "notification" : this.$uriCanBeRouted ? Constants.DEEPLINK : "launcher");
            pairArr[1] = d0.o.to("theme", AppStartAnalyticsTracker.access$getStoreUserSettingsSystem$p(AppStartAnalyticsTracker.this).getTheme());
            Map<String, ? extends Object> mapMutableMapOf = h0.mutableMapOf(pairArr);
            Companion.access$insertUriProperties(AppStartAnalyticsTracker.INSTANCE, mapMutableMapOf, this.$uri);
            if (AppStartAnalyticsTracker.access$getAppOpenTimestamp$p(AppStartAnalyticsTracker.this) == null) {
                mapMutableMapOf.put("load_id", AppStartAnalyticsTracker.access$getOpenAppLoadId$p(AppStartAnalyticsTracker.this));
                AppStartAnalyticsTracker appStartAnalyticsTracker = AppStartAnalyticsTracker.this;
                AppStartAnalyticsTracker.access$setAppOpenTimestamp$p(appStartAnalyticsTracker, Long.valueOf(AppStartAnalyticsTracker.access$getClock$p(appStartAnalyticsTracker).currentTimeMillis()));
            }
            return mapMutableMapOf;
        }
    }

    public AppStartAnalyticsTracker(AnalyticsUtils.Tracker tracker, Clock clock, StoreUserSettingsSystem storeUserSettingsSystem) {
        m.checkNotNullParameter(tracker, "tracker");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(storeUserSettingsSystem, "storeUserSettingsSystem");
        this.tracker = tracker;
        this.clock = clock;
        this.storeUserSettingsSystem = storeUserSettingsSystem;
        String string = UUID.randomUUID().toString();
        m.checkNotNullExpressionValue(string, "UUID.randomUUID().toString()");
        this.openAppLoadId = string;
    }

    public static final /* synthetic */ Long access$getAppOpenTimestamp$p(AppStartAnalyticsTracker appStartAnalyticsTracker) {
        return appStartAnalyticsTracker.appOpenTimestamp;
    }

    public static final /* synthetic */ Clock access$getClock$p(AppStartAnalyticsTracker appStartAnalyticsTracker) {
        return appStartAnalyticsTracker.clock;
    }

    public static final /* synthetic */ Lazy access$getInstance$cp() {
        return instance$delegate;
    }

    public static final /* synthetic */ String access$getOpenAppLoadId$p(AppStartAnalyticsTracker appStartAnalyticsTracker) {
        return appStartAnalyticsTracker.openAppLoadId;
    }

    public static final /* synthetic */ StoreUserSettingsSystem access$getStoreUserSettingsSystem$p(AppStartAnalyticsTracker appStartAnalyticsTracker) {
        return appStartAnalyticsTracker.storeUserSettingsSystem;
    }

    public static final /* synthetic */ void access$setAppOpenTimestamp$p(AppStartAnalyticsTracker appStartAnalyticsTracker, Long l) {
        appStartAnalyticsTracker.appOpenTimestamp = l;
    }

    public final void appOpen(Uri uri, boolean uriCanBeRouted, boolean isNotificationRoute) {
        m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        this.tracker.track(d0.o.to("app_opened", null), 300000L, new AnonymousClass1(isNotificationRoute, uriCanBeRouted, uri));
        Persister persister = new Persister(APP_FIRST_LAUNCHED, Boolean.TRUE);
        if (((Boolean) persister.get()).booleanValue()) {
            this.tracker.track(APP_FIRST_LAUNCHED, g0.mapOf(d0.o.to("platform", "Android")));
            persister.set(Boolean.FALSE, true);
        }
    }

    public final void appUiViewed(String screenName, long time) {
        m.checkNotNullParameter(screenName, "screenName");
        Long l = this.appOpenTimestamp;
        this.tracker.track("app_ui_viewed", h0.mutableMapOf(d0.o.to("screen_name", screenName), d0.o.to("load_id", this.openAppLoadId), d0.o.to("duration_ms_since_app_opened", Long.valueOf(l != null ? time - l.longValue() : -1L)), d0.o.to("has_cached_data", Boolean.TRUE), d0.o.to("theme", this.storeUserSettingsSystem.getTheme())));
    }
}
