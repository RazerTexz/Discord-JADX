package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p512d0._Ranges;
import p507d0.p580t.Iterables2;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;

/* compiled from: StoreGuildIntegrations.kt */
/* loaded from: classes2.dex */
public final class StoreGuildIntegrations {
    private final HashMap<Long, Map<Long, ModelGuildIntegration>> allIntegrations;
    private Subscription closeIntegrationScreenSubscription;
    private final Dispatcher dispatcher;
    private final BehaviorSubject<Map<Long, Map<Long, ModelGuildIntegration>>> integrationsSubject;
    private boolean isOnIntegrationsScreen;

    /* compiled from: StoreGuildIntegrations.kt */
    /* renamed from: com.discord.stores.StoreGuildIntegrations$get$1 */
    public static final class C60221<T, R> implements Func1<Map<Long, ? extends Map<Long, ? extends ModelGuildIntegration>>, Map<Long, ? extends ModelGuildIntegration>> {
        public final /* synthetic */ long $guildId;

        public C60221(long j) {
            this.$guildId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends ModelGuildIntegration> call(Map<Long, ? extends Map<Long, ? extends ModelGuildIntegration>> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, ModelGuildIntegration> call2(Map<Long, ? extends Map<Long, ? extends ModelGuildIntegration>> map) {
            return (Map) map.get(Long.valueOf(this.$guildId));
        }
    }

    /* compiled from: StoreGuildIntegrations.kt */
    /* renamed from: com.discord.stores.StoreGuildIntegrations$get$2 */
    public static final class C60232<T, R> implements Func1<Map<Long, ? extends ModelGuildIntegration>, ModelGuildIntegration> {
        public final /* synthetic */ long $integrationId;

        public C60232(long j) {
            this.$integrationId = j;
        }

        @Override // p637j0.p641k.Func1
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
    /* renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenClosed$1 */
    public static final class C60241 extends Lambda implements Function1<Long, Unit> {

        /* compiled from: StoreGuildIntegrations.kt */
        /* renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenClosed$1$1, reason: invalid class name */
        public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
            public AnonymousClass1(StoreGuildIntegrations storeGuildIntegrations) {
                super(0, storeGuildIntegrations, StoreGuildIntegrations.class, "handleIntegrationScreenClosed", "handleIntegrationScreenClosed()V", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildIntegrations.access$handleIntegrationScreenClosed((StoreGuildIntegrations) this.receiver);
            }
        }

        public C60241() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreGuildIntegrations.access$getDispatcher$p(StoreGuildIntegrations.this).schedule(new AnonymousClass1(StoreGuildIntegrations.this));
        }
    }

    /* compiled from: StoreGuildIntegrations.kt */
    /* renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenClosed$2 */
    public static final class C60252 extends Lambda implements Function1<Subscription, Unit> {
        public C60252() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            StoreGuildIntegrations.access$setCloseIntegrationScreenSubscription$p(StoreGuildIntegrations.this, subscription);
        }
    }

    /* compiled from: StoreGuildIntegrations.kt */
    /* renamed from: com.discord.stores.StoreGuildIntegrations$onIntegrationScreenOpened$1 */
    public static final class C60261 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60261(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildIntegrations.access$handleIntegrationScreenOpened(StoreGuildIntegrations.this, this.$guildId);
        }
    }

    /* compiled from: StoreGuildIntegrations.kt */
    /* renamed from: com.discord.stores.StoreGuildIntegrations$requestGuildIntegrations$1 */
    public static final class C60271 extends Lambda implements Function1<List<? extends ModelGuildIntegration>, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildIntegrations.kt */
        /* renamed from: com.discord.stores.StoreGuildIntegrations$requestGuildIntegrations$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $integrations;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$integrations = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C60271 c60271 = C60271.this;
                StoreGuildIntegrations.access$handleIntegrationsLoaded(StoreGuildIntegrations.this, c60271.$guildId, this.$integrations);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60271(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGuildIntegration> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ModelGuildIntegration> list) {
            Intrinsics3.checkNotNullParameter(list, "integrations");
            StoreGuildIntegrations.access$getDispatcher$p(StoreGuildIntegrations.this).schedule(new AnonymousClass1(list));
        }
    }

    public StoreGuildIntegrations(Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.allIntegrations = new HashMap<>();
        this.integrationsSubject = BehaviorSubject.m11130l0(new HashMap());
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

    @Store3
    private final void handleIntegrationScreenClosed() {
        this.isOnIntegrationsScreen = false;
    }

    @Store3
    private final void handleIntegrationScreenOpened(long guildId) {
        if (this.isOnIntegrationsScreen) {
            return;
        }
        this.isOnIntegrationsScreen = true;
        requestGuildIntegrations(guildId);
    }

    @Store3
    private final void handleIntegrationsLoaded(long guildId, List<? extends ModelGuildIntegration> integrations) {
        HashMap<Long, Map<Long, ModelGuildIntegration>> map = this.allIntegrations;
        Long lValueOf = Long.valueOf(guildId);
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(integrations, 10)), 16));
        for (Object obj : integrations) {
            linkedHashMap.put(Long.valueOf(((ModelGuildIntegration) obj).getId()), obj);
        }
        map.put(lValueOf, linkedHashMap);
        this.integrationsSubject.onNext(new HashMap(this.allIntegrations));
    }

    private final void requestGuildIntegrations(long guildId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getGuildIntegrations(guildId), false, 1, null), StoreGuildIntegrations.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C60271(guildId), 62, (Object) null);
    }

    public final Observable<Map<Long, ModelGuildIntegration>> get(long guildId) {
        Observable<Map<Long, ModelGuildIntegration>> observableM11112r = this.integrationsSubject.m11083G(new C60221(guildId)).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "integrationsSubject\n    …  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Store3
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
        Observable<Long> observableM11068d0 = Observable.m11068d0(1000L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableM11068d0, "Observable\n        .time…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableM11068d0, getClass(), (Context) null, new C60252(), (Function1) null, (Function0) null, (Function0) null, new C60241(), 58, (Object) null);
    }

    public final synchronized void onIntegrationScreenOpened(long guildId) {
        Subscription subscription = this.closeIntegrationScreenSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.dispatcher.schedule(new C60261(guildId));
    }

    public final Observable<ModelGuildIntegration> get(long guildId, long integrationId) {
        Observable<ModelGuildIntegration> observableM11112r = get(guildId).m11083G(new C60232(integrationId)).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "get(guildId)\n          .…  .distinctUntilChanged()");
        return observableM11112r;
    }
}
