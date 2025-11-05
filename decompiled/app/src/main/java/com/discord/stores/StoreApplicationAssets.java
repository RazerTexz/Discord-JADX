package com.discord.stores;

import android.content.Context;
import com.discord.api.application.ApplicationAsset;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreApplicationAssets.kt */
/* loaded from: classes2.dex */
public final class StoreApplicationAssets extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, ApplicationAsset> embeddedAppBackgrounds;
    private final HashSet<Long> embeddedAppBackgroundsLoading;
    private Map<Long, ApplicationAsset> embeddedAppBackgroundsSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restApi;

    /* compiled from: StoreApplicationAssets.kt */
    /* renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $appId;

        /* compiled from: StoreApplicationAssets.kt */
        /* renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01991 extends o implements Function1<List<? extends ApplicationAsset>, Unit> {

            /* compiled from: StoreApplicationAssets.kt */
            /* renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C02001 extends o implements Function0<Unit> {
                public final /* synthetic */ List $applicationAssets;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02001(List list) {
                    super(0);
                    this.$applicationAssets = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreApplicationAssets.access$getEmbeddedAppBackgroundsLoading$p(StoreApplicationAssets.this).remove(Long.valueOf(AnonymousClass1.this.$appId));
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreApplicationAssets.access$handleApplicationAssets(StoreApplicationAssets.this, anonymousClass1.$appId, this.$applicationAssets);
                }
            }

            public C01991() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ApplicationAsset> list) {
                invoke2((List<ApplicationAsset>) list);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ApplicationAsset> list) {
                m.checkNotNullParameter(list, "applicationAssets");
                StoreApplicationAssets.access$getDispatcher$p(StoreApplicationAssets.this).schedule(new C02001(list));
            }
        }

        /* compiled from: StoreApplicationAssets.kt */
        /* renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {

            /* compiled from: StoreApplicationAssets.kt */
            /* renamed from: com.discord.stores.StoreApplicationAssets$fetchIfNonExisting$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C02011 extends o implements Function0<Unit> {
                public C02011() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreApplicationAssets.access$getEmbeddedAppBackgroundsLoading$p(StoreApplicationAssets.this).remove(Long.valueOf(AnonymousClass1.this.$appId));
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                m.checkNotNullParameter(error, "it");
                StoreApplicationAssets.access$getDispatcher$p(StoreApplicationAssets.this).schedule(new C02011());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$appId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreApplicationAssets.access$getEmbeddedAppBackgrounds$p(StoreApplicationAssets.this).containsKey(Long.valueOf(this.$appId)) || StoreApplicationAssets.access$getEmbeddedAppBackgroundsLoading$p(StoreApplicationAssets.this).contains(Long.valueOf(this.$appId))) {
                return;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StoreApplicationAssets.access$getRestApi$p(StoreApplicationAssets.this).getApplicationAssets(this.$appId), false, 1, null), StoreApplicationAssets.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new C01991(), 54, (Object) null);
        }
    }

    /* compiled from: StoreApplicationAssets.kt */
    /* renamed from: com.discord.stores.StoreApplicationAssets$observeEmbeddedAppBackgrounds$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<Long, ? extends ApplicationAsset>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends ApplicationAsset> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends ApplicationAsset> invoke2() {
            return StoreApplicationAssets.this.getEmbeddedAppBackgrounds();
        }
    }

    public /* synthetic */ StoreApplicationAssets(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreApplicationAssets storeApplicationAssets) {
        return storeApplicationAssets.dispatcher;
    }

    public static final /* synthetic */ Map access$getEmbeddedAppBackgrounds$p(StoreApplicationAssets storeApplicationAssets) {
        return storeApplicationAssets.embeddedAppBackgrounds;
    }

    public static final /* synthetic */ HashSet access$getEmbeddedAppBackgroundsLoading$p(StoreApplicationAssets storeApplicationAssets) {
        return storeApplicationAssets.embeddedAppBackgroundsLoading;
    }

    public static final /* synthetic */ RestAPI access$getRestApi$p(StoreApplicationAssets storeApplicationAssets) {
        return storeApplicationAssets.restApi;
    }

    public static final /* synthetic */ void access$handleApplicationAssets(StoreApplicationAssets storeApplicationAssets, long j, List list) {
        storeApplicationAssets.handleApplicationAssets(j, list);
    }

    @StoreThread
    private final void handleApplicationAssets(long applicationId, List<ApplicationAsset> appAssets) {
        Object next;
        Iterator<T> it = appAssets.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (m.areEqual(((ApplicationAsset) next).getName(), "embedded_background")) {
                    break;
                }
            }
        }
        ApplicationAsset applicationAsset = (ApplicationAsset) next;
        if (applicationAsset != null) {
            this.embeddedAppBackgrounds.put(Long.valueOf(applicationId), applicationAsset);
            markChanged();
        }
    }

    public final void fetchIfNonExisting(long appId) {
        this.dispatcher.schedule(new AnonymousClass1(appId));
    }

    public final Map<Long, ApplicationAsset> getEmbeddedAppBackgrounds() {
        return this.embeddedAppBackgroundsSnapshot;
    }

    public final Observable<Map<Long, ApplicationAsset>> observeEmbeddedAppBackgrounds() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.embeddedAppBackgroundsSnapshot = new HashMap(this.embeddedAppBackgrounds);
    }

    public StoreApplicationAssets(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(restAPI, "restApi");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restApi = restAPI;
        this.embeddedAppBackgrounds = new LinkedHashMap();
        this.embeddedAppBackgroundsLoading = new HashSet<>();
        this.embeddedAppBackgroundsSnapshot = h0.emptyMap();
    }
}
