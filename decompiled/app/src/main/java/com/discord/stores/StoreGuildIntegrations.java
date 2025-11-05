package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.d0.f;
import d0.t.g0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* compiled from: StoreGuildIntegrations.kt */
/* loaded from: classes2.dex */
public final class StoreGuildIntegrations {
    private final HashMap<Long, Map<Long, ModelGuildIntegration>> allIntegrations;
    private Subscription closeIntegrationScreenSubscription;
    private final Dispatcher dispatcher;
    private final BehaviorSubject<Map<Long, Map<Long, ModelGuildIntegration>>> integrationsSubject;
    private boolean isOnIntegrationsScreen;

    /* compiled from: StoreGuildIntegrations.kt */
    /* renamed from: com.discord.stores.StoreGuildIntegrations$get$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Map<Long, ? extends Map<Long, ? extends ModelGuildIntegration>>, Map<Long, ? extends ModelGuildIntegration>> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass1(long j) {
            this.$guildId = j;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Map<Long, ? extends ModelGuildIntegration> call(Map<Long, ? extends Map<Long, ? extends ModelGuildIntegration>> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, ModelGuildIntegration> call2(Map<Long, ? extends Map<Long, ? extends ModelGuildIntegration>> map) {
            return (Map) map.get(Long.valueOf(this.$guildId));
        }
    }

    /* compiled from: StoreGuildIntegrations.kt */
    /* renamed from: com.discord.stores.StoreGuildIntegrations$get$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Map<Long, ? extends ModelGuildIntegration>, ModelGuildIntegration> {
        public final /* synthetic */ long $integrationId;

        public AnonymousClass2(long j) {
            this.$integrationId = j;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ ModelGuildIntegration call(Map<Long, ? extends ModelGuildIntegration> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ModelGuildIntegration call2(Map<Long, ? extends ModelGuildIntegration> map) {
            if (map != null) {
                return map.get(Long.valueOf(this.$integrationId));
            }
            return null;
        }
    }

    /* compiled from: StoreGuildIntegrations.kt */
    /* renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenClosed$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Long, Unit> {

        /* compiled from: StoreGuildIntegrations.kt */
        /* renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenClosed$1$1, reason: invalid class name and collision with other inner class name */
        public static final /* synthetic */ class C02371 extends k implements Function0<Unit> {
            public C02371(StoreGuildIntegrations storeGuildIntegrations) {
                super(0, storeGuildIntegrations, StoreGuildIntegrations.class, "handleIntegrationScreenClosed", "handleIntegrationScreenClosed()V", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildIntegrations.access$handleIntegrationScreenClosed((StoreGuildIntegrations) this.receiver);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreGuildIntegrations.access$getDispatcher$p(StoreGuildIntegrations.this).schedule(new C02371(StoreGuildIntegrations.this));
        }
    }

    /* compiled from: StoreGuildIntegrations.kt */
    /* renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenClosed$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            m.checkNotNullParameter(subscription, "it");
            StoreGuildIntegrations.access$setCloseIntegrationScreenSubscription$p(StoreGuildIntegrations.this, subscription);
        }
    }

    /* compiled from: StoreGuildIntegrations.kt */
    /* renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenOpened$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildIntegrations.access$handleIntegrationScreenOpened(StoreGuildIntegrations.this, this.$guildId);
        }
    }

    /* compiled from: StoreGuildIntegrations.kt */
    /* renamed from: com.discord.stores.StoreGuildIntegrations$requestGuildIntegrations$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<List<? extends ModelGuildIntegration>, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildIntegrations.kt */
        /* renamed from: com.discord.stores.StoreGuildIntegrations$requestGuildIntegrations$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02381 extends o implements Function0<Unit> {
            public final /* synthetic */ List $integrations;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02381(List list) {
                super(0);
                this.$integrations = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                StoreGuildIntegrations.access$handleIntegrationsLoaded(StoreGuildIntegrations.this, anonymousClass1.$guildId, this.$integrations);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGuildIntegration> list) {
            invoke2(list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ModelGuildIntegration> list) {
            m.checkNotNullParameter(list, "integrations");
            StoreGuildIntegrations.access$getDispatcher$p(StoreGuildIntegrations.this).schedule(new C02381(list));
        }
    }

    public StoreGuildIntegrations(Dispatcher dispatcher) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.allIntegrations = new HashMap<>();
        this.integrationsSubject = BehaviorSubject.l0(new HashMap());
    }

    public static final /* synthetic */ Subscription access$getCloseIntegrationScreenSubscription$p(StoreGuildIntegrations storeGuildIntegrations) {
        return storeGuildIntegrations.closeIntegrationScreenSubscription;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildIntegrations storeGuildIntegrations) {
        return storeGuildIntegrations.dispatcher;
    }

    public static final /* synthetic */ void access$handleIntegrationScreenClosed(StoreGuildIntegrations storeGuildIntegrations) {
        storeGuildIntegrations.handleIntegrationScreenClosed();
    }

    public static final /* synthetic */ void access$handleIntegrationScreenOpened(StoreGuildIntegrations storeGuildIntegrations, long j) {
        storeGuildIntegrations.handleIntegrationScreenOpened(j);
    }

    public static final /* synthetic */ void access$handleIntegrationsLoaded(StoreGuildIntegrations storeGuildIntegrations, long j, List list) {
        storeGuildIntegrations.handleIntegrationsLoaded(j, list);
    }

    public static final /* synthetic */ void access$setCloseIntegrationScreenSubscription$p(StoreGuildIntegrations storeGuildIntegrations, Subscription subscription) {
        storeGuildIntegrations.closeIntegrationScreenSubscription = subscription;
    }

    @StoreThread
    private final void handleIntegrationScreenClosed() {
        this.isOnIntegrationsScreen = false;
    }

    @StoreThread
    private final void handleIntegrationScreenOpened(long guildId) {
        if (this.isOnIntegrationsScreen) {
            return;
        }
        this.isOnIntegrationsScreen = true;
        requestGuildIntegrations(guildId);
    }

    @StoreThread
    private final void handleIntegrationsLoaded(long guildId, List<? extends ModelGuildIntegration> integrations) {
        HashMap<Long, Map<Long, ModelGuildIntegration>> map = this.allIntegrations;
        Long lValueOf = Long.valueOf(guildId);
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(integrations, 10)), 16));
        for (Object obj : integrations) {
            linkedHashMap.put(Long.valueOf(((ModelGuildIntegration) obj).getId()), obj);
        }
        map.put(lValueOf, linkedHashMap);
        this.integrationsSubject.onNext(new HashMap(this.allIntegrations));
    }

    private final void requestGuildIntegrations(long guildId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getGuildIntegrations(guildId), false, 1, null), StoreGuildIntegrations.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(guildId), 62, (Object) null);
    }

    public final Observable<Map<Long, ModelGuildIntegration>> get(long guildId) {
        Observable<Map<Long, ModelGuildIntegration>> observableR = this.integrationsSubject.G(new AnonymousClass1(guildId)).r();
        m.checkNotNullExpressionValue(observableR, "integrationsSubject\n    …  .distinctUntilChanged()");
        return observableR;
    }

    @StoreThread
    public final void handleUpdate(ModelGuildIntegration.Update update) {
        if (!this.isOnIntegrationsScreen || update == null) {
            return;
        }
        requestGuildIntegrations(update.getGuildId());
    }

    public final synchronized void onIntegrationScreenClosed() {
        Subscription subscription = this.closeIntegrationScreenSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<Long> observableD0 = Observable.d0(1000L, TimeUnit.MILLISECONDS);
        m.checkNotNullExpressionValue(observableD0, "Observable\n        .time…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableD0, getClass(), (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 58, (Object) null);
    }

    public final synchronized void onIntegrationScreenOpened(long guildId) {
        Subscription subscription = this.closeIntegrationScreenSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final Observable<ModelGuildIntegration> get(long guildId, long integrationId) {
        Observable<ModelGuildIntegration> observableR = get(guildId).G(new AnonymousClass2(integrationId)).r();
        m.checkNotNullExpressionValue(observableR, "get(guildId)\n          .…  .distinctUntilChanged()");
        return observableR;
    }
}
