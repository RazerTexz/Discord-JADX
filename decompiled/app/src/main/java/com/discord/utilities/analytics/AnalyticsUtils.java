package com.discord.utilities.analytics;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.MainThread;
import b.i.a.f.h.l.g;
import b.i.a.f.h.l.n;
import com.discord.analytics.generated.traits.TrackGuildReceiver;
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
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.user.UserUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import d0.g0.t;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: AnalyticsUtils.kt */
/* loaded from: classes2.dex */
public final class AnalyticsUtils {
    public static final AnalyticsUtils INSTANCE = new AnalyticsUtils();
    private static FirebaseAnalytics fireBaseInstance;

    /* compiled from: AnalyticsUtils.kt */
    /* renamed from: com.discord.utilities.analytics.AnalyticsUtils$initAppOpen$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<MeUser, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            m.checkNotNullParameter(meUser, "meUser");
            if (m.areEqual(meUser, UserUtils.INSTANCE.getEMPTY_USER())) {
                AppLog.g(0L, null, null);
                FirebaseAnalytics firebaseAnalyticsAccess$getFireBaseInstance$p = AnalyticsUtils.access$getFireBaseInstance$p(AnalyticsUtils.INSTANCE);
                if (firebaseAnalyticsAccess$getFireBaseInstance$p != null) {
                    g gVar = firebaseAnalyticsAccess$getFireBaseInstance$p.f3109b;
                    Objects.requireNonNull(gVar);
                    gVar.e.execute(new n(gVar, null));
                    return;
                }
                return;
            }
            FirebaseAnalytics firebaseAnalyticsAccess$getFireBaseInstance$p2 = AnalyticsUtils.access$getFireBaseInstance$p(AnalyticsUtils.INSTANCE);
            if (firebaseAnalyticsAccess$getFireBaseInstance$p2 != null) {
                String strValueOf = String.valueOf(meUser.getId());
                g gVar2 = firebaseAnalyticsAccess$getFireBaseInstance$p2.f3109b;
                Objects.requireNonNull(gVar2);
                gVar2.e.execute(new n(gVar2, strValueOf));
            }
            AppLog.g(Long.valueOf(meUser.getId()), meUser.getEmail(), meUser.getUsername());
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
        m.checkNotNullParameter(channel, "$this$properties");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = d0.o.to(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, Long.valueOf(channel.getId()));
        pairArr[1] = d0.o.to("channel_type", Integer.valueOf(channel.getType()));
        List<User> listZ = channel.z();
        pairArr[2] = d0.o.to("channel_size_total", Integer.valueOf(listZ != null ? listZ.size() : 0));
        return h0.mapOf(pairArr);
    }

    @MainThread
    public final void initAppOpen(Application context) {
        m.checkNotNullParameter(context, "context");
        if (fireBaseInstance != null) {
            return;
        }
        fireBaseInstance = FirebaseAnalytics.getInstance(context);
        ObservableExtensionsKt.appSubscribe$default(StoreStream.INSTANCE.getUsers().observeMe(true), AnalyticsUtils.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
        RtcCameraConfig.INSTANCE.init();
    }

    /* compiled from: AnalyticsUtils.kt */
    public static final class Tracker {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Lazy instance$delegate = d0.g.lazy(AnalyticsUtils$Tracker$Companion$instance$2.INSTANCE);
        private String analyticsToken;
        private final Clock clock;
        private final ConcurrentLinkedQueue<Science.Event> eventsQueue;
        private final ConcurrentHashMap<Pair<String, Long>, Long> eventsThrottledUntilMillis;
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
            m.checkNotNullParameter(clock, "clock");
            m.checkNotNullParameter(restAPI, "restAPI");
            m.checkNotNullParameter(concurrentLinkedQueue, "eventsQueue");
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
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.science(new Science(this.analyticsToken, arrayList)), false, 1, null), getClass(), (Context) null, (Function1) null, new AnalyticsUtils$Tracker$drainEventsQueue$2(this, arrayList), (Function0) null, (Function0) null, AnalyticsUtils$Tracker$drainEventsQueue$1.INSTANCE, 54, (Object) null);
            }
        }

        private final boolean getCanDrain() {
            return (this.eventsQueue.isEmpty() ^ true) && (this.fingerprinted || isAuthed$app_productionGoogleRelease());
        }

        private final boolean isEventThrottled(Pair<String, Long> throttleKey) {
            long jCurrentTimeMillis = this.clock.currentTimeMillis();
            Long l = this.eventsThrottledUntilMillis.get(throttleKey);
            if (l == null) {
                l = 0L;
            }
            m.checkNotNullExpressionValue(l, "eventsThrottledUntilMillis[throttleKey] ?: 0");
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
                Logger.e$default(AppLog.g, bundle.getClass().getSimpleName() + " putMap", th, null, 4, null);
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
            return !(str == null || t.isBlank(str));
        }

        public final synchronized void setTrackingData(String analyticsToken, boolean fingerprinted) {
            drainEventsQueue();
            this.analyticsToken = analyticsToken;
            this.fingerprinted = fingerprinted;
            drainEventsQueue();
        }

        public final void track(Pair<String, Long> throttleKey, long throttleTimeMs, Function0<? extends Map<String, ? extends Object>> lazyPropertyProvider) {
            m.checkNotNullParameter(throttleKey, "throttleKey");
            m.checkNotNullParameter(lazyPropertyProvider, "lazyPropertyProvider");
            if (isEventThrottled(throttleKey)) {
                return;
            }
            track(throttleKey.component1(), lazyPropertyProvider.invoke());
            this.eventsThrottledUntilMillis.put(throttleKey, Long.valueOf(this.clock.currentTimeMillis() + throttleTimeMs));
        }

        public final void trackFireBase(String event, Map<String, ? extends Object> properties) {
            m.checkNotNullParameter(event, "event");
            m.checkNotNullParameter(properties, "properties");
            Bundle bundlePutMap = putMap(new Bundle(), properties);
            FirebaseAnalytics firebaseAnalyticsAccess$getFireBaseInstance$p = AnalyticsUtils.access$getFireBaseInstance$p(AnalyticsUtils.INSTANCE);
            if (firebaseAnalyticsAccess$getFireBaseInstance$p != null) {
                firebaseAnalyticsAccess$getFireBaseInstance$p.f3109b.c(null, event, bundlePutMap, false, true, null);
            }
        }

        public final void track(String event, Map<String, ? extends Object> properties) {
            m.checkNotNullParameter(event, "event");
            if (properties == null) {
                properties = h0.emptyMap();
            }
            track(new Science.Event.MapObject(event, properties));
        }

        public final void track(AnalyticsSchema analyticsSchema) {
            m.checkNotNullParameter(analyticsSchema, "analyticsSchema");
            if (analyticsSchema instanceof TrackGuildReceiver) {
                TrackGuildReceiver trackGuildReceiver = (TrackGuildReceiver) analyticsSchema;
                trackGuildReceiver.c(AnalyticsUtilsKt.access$fill(trackGuildReceiver.getTrackGuild()));
            }
            track(new Science.Event.SchemaObject(analyticsSchema));
        }

        public final void track(Science.Event event) {
            m.checkNotNullParameter(event, "event");
            this.eventsQueue.add(event);
            Observable<Long> observableD0 = Observable.d0(1500L, TimeUnit.MILLISECONDS);
            m.checkNotNullExpressionValue(observableD0, "Observable\n          .ti…0, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(observableD0, Tracker.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnalyticsUtils$Tracker$track$1(this), 62, (Object) null);
        }
    }

    public final Map<String, String> getProperties$app_productionGoogleRelease(RtcConnection rtcConnection) {
        m.checkNotNullParameter(rtcConnection, "$this$properties");
        return g0.mapOf(d0.o.to("rtc_connection_id", rtcConnection.id));
    }
}
