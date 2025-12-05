package com.discord.utilities.analytics;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.MainThread;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.channel.Channel;
import com.discord.api.science.AnalyticsSchema;
import com.discord.api.science.Science;
import com.discord.api.user.User;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.MeUser;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreStream;
import com.discord.utilities.device.RtcCameraConfig;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;
import p007b.p225i.p226a.p288f.p313h.p325l.C3755n;
import p507d0.LazyJVM;
import p507d0.Tuples;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* compiled from: AnalyticsUtils.kt */
/* loaded from: classes2.dex */
public final class AnalyticsUtils {
    public static final AnalyticsUtils INSTANCE = new AnalyticsUtils();
    private static FirebaseAnalytics fireBaseInstance;

    /* compiled from: AnalyticsUtils.kt */
    /* renamed from: com.discord.utilities.analytics.AnalyticsUtils$initAppOpen$1 */
    public static final class C66821 extends Lambda implements Function1<MeUser, Unit> {
        public static final C66821 INSTANCE = new C66821();

        public C66821() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            if (Intrinsics3.areEqual(meUser, UserUtils.INSTANCE.getEMPTY_USER())) {
                AppLog.m8357g(0L, null, null);
                FirebaseAnalytics firebaseAnalyticsAccess$getFireBaseInstance$p = AnalyticsUtils.access$getFireBaseInstance$p(AnalyticsUtils.INSTANCE);
                if (firebaseAnalyticsAccess$getFireBaseInstance$p != null) {
                    C3661g c3661g = firebaseAnalyticsAccess$getFireBaseInstance$p.f21404b;
                    Objects.requireNonNull(c3661g);
                    c3661g.f9950e.execute(new C3755n(c3661g, null));
                    return;
                }
                return;
            }
            FirebaseAnalytics firebaseAnalyticsAccess$getFireBaseInstance$p2 = AnalyticsUtils.access$getFireBaseInstance$p(AnalyticsUtils.INSTANCE);
            if (firebaseAnalyticsAccess$getFireBaseInstance$p2 != null) {
                String strValueOf = String.valueOf(meUser.getId());
                C3661g c3661g2 = firebaseAnalyticsAccess$getFireBaseInstance$p2.f21404b;
                Objects.requireNonNull(c3661g2);
                c3661g2.f9950e.execute(new C3755n(c3661g2, strValueOf));
            }
            AppLog.m8357g(Long.valueOf(meUser.getId()), meUser.getEmail(), meUser.getUsername());
        }
    }

    private AnalyticsUtils() {
    }

    public static final /* synthetic */ FirebaseAnalytics access$getFireBaseInstance$p(AnalyticsUtils analyticsUtils) {
        return fireBaseInstance;
    }

    public static final /* synthetic */ void access$setFireBaseInstance$p(AnalyticsUtils analyticsUtils, FirebaseAnalytics firebaseAnalytics) {
        fireBaseInstance = firebaseAnalytics;
    }

    public final Map<String, Object> getProperties$app_productionGoogleRelease(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "$this$properties");
        Tuples2[] tuples2Arr = new Tuples2[3];
        tuples2Arr[0] = Tuples.m10073to(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channel.getId()));
        tuples2Arr[1] = Tuples.m10073to("channel_type", Integer.valueOf(channel.getType()));
        List<User> listM7659z = channel.m7659z();
        tuples2Arr[2] = Tuples.m10073to("channel_size_total", Integer.valueOf(listM7659z != null ? listM7659z.size() : 0));
        return Maps6.mapOf(tuples2Arr);
    }

    @MainThread
    public final void initAppOpen(Application context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (fireBaseInstance != null) {
            return;
        }
        fireBaseInstance = FirebaseAnalytics.getInstance(context);
        ObservableExtensionsKt.appSubscribe$default(StoreStream.INSTANCE.getUsers().observeMe(true), AnalyticsUtils.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, C66821.INSTANCE, 62, (Object) null);
        RtcCameraConfig.INSTANCE.init();
    }

    /* compiled from: AnalyticsUtils.kt */
    public static final class Tracker {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy instance$delegate = LazyJVM.lazy(AnalyticsUtils2.INSTANCE);
        private String analyticsToken;
        private final Clock clock;
        private final ConcurrentLinkedQueue<Science.Event> eventsQueue;
        private final ConcurrentHashMap<Tuples2<String, Long>, Long> eventsThrottledUntilMillis;
        private boolean fingerprinted;
        private final RestAPI restAPI;

        /* compiled from: AnalyticsUtils.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Tracker getInstance() {
                Lazy lazyAccess$getInstance$cp = Tracker.access$getInstance$cp();
                Companion companion = Tracker.INSTANCE;
                return (Tracker) lazyAccess$getInstance$cp.getValue();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Tracker(Clock clock, RestAPI restAPI, ConcurrentLinkedQueue<Science.Event> concurrentLinkedQueue) {
            Intrinsics3.checkNotNullParameter(clock, "clock");
            Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
            Intrinsics3.checkNotNullParameter(concurrentLinkedQueue, "eventsQueue");
            this.clock = clock;
            this.restAPI = restAPI;
            this.eventsQueue = concurrentLinkedQueue;
            this.eventsThrottledUntilMillis = new ConcurrentHashMap<>();
        }

        public static final /* synthetic */ void access$drainEventsQueue(Tracker tracker) {
            tracker.drainEventsQueue();
        }

        public static final /* synthetic */ ConcurrentLinkedQueue access$getEventsQueue$p(Tracker tracker) {
            return tracker.eventsQueue;
        }

        public static final /* synthetic */ Lazy access$getInstance$cp() {
            return instance$delegate;
        }

        private final synchronized void drainEventsQueue() {
            if (getCanDrain()) {
                ArrayList arrayList = new ArrayList(this.eventsQueue);
                this.eventsQueue.clear();
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.science(new Science(this.analyticsToken, arrayList)), false, 1, null), getClass(), (Context) null, (Function1) null, new AnalyticsUtils4(this, arrayList), (Function0) null, (Function0) null, AnalyticsUtils3.INSTANCE, 54, (Object) null);
            }
        }

        private final boolean getCanDrain() {
            return (this.eventsQueue.isEmpty() ^ true) && (this.fingerprinted || isAuthed$app_productionGoogleRelease());
        }

        private final boolean isEventThrottled(Tuples2<String, Long> throttleKey) {
            long jCurrentTimeMillis = this.clock.currentTimeMillis();
            Long l = this.eventsThrottledUntilMillis.get(throttleKey);
            if (l == null) {
                l = 0L;
            }
            Intrinsics3.checkNotNullExpressionValue(l, "eventsThrottledUntilMillis[throttleKey] ?: 0");
            return jCurrentTimeMillis < l.longValue();
        }

        private final Bundle putMap(Bundle bundle, Map<String, ? extends Object> map) {
            try {
                for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value instanceof String) {
                        bundle.putString(key, (String) value);
                    } else if (value instanceof Integer) {
                        bundle.putInt(key, ((Number) value).intValue());
                    } else if (value instanceof Long) {
                        bundle.putLong(key, ((Number) value).longValue());
                    } else if (value instanceof Double) {
                        bundle.putDouble(key, ((Number) value).doubleValue());
                    } else if (value instanceof Float) {
                        bundle.putFloat(key, ((Number) value).floatValue());
                    }
                }
            } catch (Throwable th) {
                Logger.e$default(AppLog.f14950g, bundle.getClass().getSimpleName() + " putMap", th, null, 4, null);
            }
            return bundle;
        }

        public static /* synthetic */ void setTrackingData$default(Tracker tracker, String str, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            tracker.setTrackingData(str, z2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void track$default(Tracker tracker, String str, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                map = null;
            }
            tracker.track(str, map);
        }

        public final boolean isAuthed$app_productionGoogleRelease() {
            String str = this.analyticsToken;
            return !(str == null || StringsJVM.isBlank(str));
        }

        public final synchronized void setTrackingData(String analyticsToken, boolean fingerprinted) {
            drainEventsQueue();
            this.analyticsToken = analyticsToken;
            this.fingerprinted = fingerprinted;
            drainEventsQueue();
        }

        public final void track(Tuples2<String, Long> throttleKey, long throttleTimeMs, Function0<? extends Map<String, ? extends Object>> lazyPropertyProvider) {
            Intrinsics3.checkNotNullParameter(throttleKey, "throttleKey");
            Intrinsics3.checkNotNullParameter(lazyPropertyProvider, "lazyPropertyProvider");
            if (isEventThrottled(throttleKey)) {
                return;
            }
            track(throttleKey.component1(), lazyPropertyProvider.invoke());
            this.eventsThrottledUntilMillis.put(throttleKey, Long.valueOf(this.clock.currentTimeMillis() + throttleTimeMs));
        }

        public final void trackFireBase(String event, Map<String, ? extends Object> properties) {
            Intrinsics3.checkNotNullParameter(event, "event");
            Intrinsics3.checkNotNullParameter(properties, "properties");
            Bundle bundlePutMap = putMap(new Bundle(), properties);
            FirebaseAnalytics firebaseAnalyticsAccess$getFireBaseInstance$p = AnalyticsUtils.access$getFireBaseInstance$p(AnalyticsUtils.INSTANCE);
            if (firebaseAnalyticsAccess$getFireBaseInstance$p != null) {
                firebaseAnalyticsAccess$getFireBaseInstance$p.f21404b.m4886c(null, event, bundlePutMap, false, true, null);
            }
        }

        public final void track(String event, Map<String, ? extends Object> properties) {
            Intrinsics3.checkNotNullParameter(event, "event");
            if (properties == null) {
                properties = Maps6.emptyMap();
            }
            track(new Science.Event.MapObject(event, properties));
        }

        public final void track(AnalyticsSchema analyticsSchema) {
            Intrinsics3.checkNotNullParameter(analyticsSchema, "analyticsSchema");
            if (analyticsSchema instanceof TrackGuild2) {
                TrackGuild2 trackGuild2 = (TrackGuild2) analyticsSchema;
                trackGuild2.mo7508c(AnalyticsUtils6.access$fill(trackGuild2.getTrackGuild()));
            }
            track(new Science.Event.SchemaObject(analyticsSchema));
        }

        public final void track(Science.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            this.eventsQueue.add(event);
            Observable<Long> observableM11068d0 = Observable.m11068d0(1500L, TimeUnit.MILLISECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableM11068d0, "Observable\n          .ti…0, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(observableM11068d0, Tracker.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnalyticsUtils5(this), 62, (Object) null);
        }
    }

    public final Map<String, String> getProperties$app_productionGoogleRelease(RtcConnection rtcConnection) {
        Intrinsics3.checkNotNullParameter(rtcConnection, "$this$properties");
        return MapsJVM.mapOf(Tuples.m10073to("rtc_connection_id", rtcConnection.id));
    }
}
