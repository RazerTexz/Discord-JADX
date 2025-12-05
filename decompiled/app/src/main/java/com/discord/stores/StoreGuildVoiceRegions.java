package com.discord.stores;

import android.content.Context;
import com.discord.models.domain.ModelVoiceRegion;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* compiled from: StoreGuildVoiceRegions.kt */
/* loaded from: classes2.dex */
public final class StoreGuildVoiceRegions extends StoreV2 {
    private final Dispatcher dispatcher;
    private Map<Long, ? extends List<? extends ModelVoiceRegion>> guildVoiceRegionsSnapshot;
    private final HashMap<Long, State> guildVoiceRegionsState;
    private final ObservationDeck observationDeck;

    /* compiled from: StoreGuildVoiceRegions.kt */
    public static abstract class State {

        /* compiled from: StoreGuildVoiceRegions.kt */
        public static final class Failure extends State {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: StoreGuildVoiceRegions.kt */
        public static final class Fetching extends State {
            public static final Fetching INSTANCE = new Fetching();

            private Fetching() {
                super(null);
            }
        }

        /* compiled from: StoreGuildVoiceRegions.kt */
        public static final /* data */ class Loaded extends State {
            private final List<ModelVoiceRegion> data;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends ModelVoiceRegion> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "data");
                this.data = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.data;
                }
                return loaded.copy(list);
            }

            public final List<ModelVoiceRegion> component1() {
                return this.data;
            }

            public final Loaded copy(List<? extends ModelVoiceRegion> data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                return new Loaded(data);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.data, ((Loaded) other).data);
                }
                return true;
            }

            public final List<ModelVoiceRegion> getData() {
                return this.data;
            }

            public int hashCode() {
                List<ModelVoiceRegion> list = this.data;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.m824L(outline.m833U("Loaded(data="), this.data, ")");
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGuildVoiceRegions.kt */
    /* renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1 */
    public static final class C60891 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildVoiceRegions.kt */
        /* renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends ModelVoiceRegion>, Unit> {

            /* compiled from: StoreGuildVoiceRegions.kt */
            /* renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C132581 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ List $voiceRegions;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C132581(List list) {
                    super(0);
                    this.$voiceRegions = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C60891 c60891 = C60891.this;
                    StoreGuildVoiceRegions.access$handleGuildVoiceRegions(StoreGuildVoiceRegions.this, c60891.$guildId, this.$voiceRegions);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelVoiceRegion> list) {
                invoke2(list);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends ModelVoiceRegion> list) {
                Intrinsics3.checkNotNullParameter(list, "voiceRegions");
                StoreGuildVoiceRegions.access$getDispatcher$p(StoreGuildVoiceRegions.this).schedule(new C132581(list));
            }
        }

        /* compiled from: StoreGuildVoiceRegions.kt */
        /* renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* compiled from: StoreGuildVoiceRegions.kt */
            /* renamed from: com.discord.stores.StoreGuildVoiceRegions$fetchIfNonexisting$1$2$1, reason: invalid class name */
            public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C60891 c60891 = C60891.this;
                    StoreGuildVoiceRegions.access$handleGuildVoiceRegionsFetchFailed(StoreGuildVoiceRegions.this, c60891.$guildId);
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreGuildVoiceRegions.access$getDispatcher$p(StoreGuildVoiceRegions.this).schedule(new AnonymousClass1());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60891(long j) {
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
            State state = (State) StoreGuildVoiceRegions.access$getGuildVoiceRegionsState$p(StoreGuildVoiceRegions.this).get(Long.valueOf(this.$guildId));
            if ((state instanceof State.Loaded) || (state instanceof State.Fetching)) {
                return;
            }
            StoreGuildVoiceRegions.access$handleGuildVoiceRegionsFetchStart(StoreGuildVoiceRegions.this, this.$guildId);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn(RestAPI.INSTANCE.getApi().getGuildVoiceRegions(this.$guildId), false), StoreGuildVoiceRegions.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
        }
    }

    /* compiled from: StoreGuildVoiceRegions.kt */
    /* renamed from: com.discord.stores.StoreGuildVoiceRegions$observeGuildVoiceRegions$1 */
    public static final class C60901 extends Lambda implements Function0<List<? extends ModelVoiceRegion>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60901(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends ModelVoiceRegion> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends ModelVoiceRegion> invoke2() {
            return StoreGuildVoiceRegions.this.getGuildVoiceRegions(this.$guildId);
        }
    }

    public /* synthetic */ StoreGuildVoiceRegions(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildVoiceRegions storeGuildVoiceRegions) {
        return storeGuildVoiceRegions.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getGuildVoiceRegionsState$p(StoreGuildVoiceRegions storeGuildVoiceRegions) {
        return storeGuildVoiceRegions.guildVoiceRegionsState;
    }

    public static final /* synthetic */ void access$handleGuildVoiceRegions(StoreGuildVoiceRegions storeGuildVoiceRegions, long j, List list) {
        storeGuildVoiceRegions.handleGuildVoiceRegions(j, list);
    }

    public static final /* synthetic */ void access$handleGuildVoiceRegionsFetchFailed(StoreGuildVoiceRegions storeGuildVoiceRegions, long j) {
        storeGuildVoiceRegions.handleGuildVoiceRegionsFetchFailed(j);
    }

    public static final /* synthetic */ void access$handleGuildVoiceRegionsFetchStart(StoreGuildVoiceRegions storeGuildVoiceRegions, long j) {
        storeGuildVoiceRegions.handleGuildVoiceRegionsFetchStart(j);
    }

    @Store3
    private final void handleGuildVoiceRegions(long guildId, List<? extends ModelVoiceRegion> voiceRegions) {
        this.guildVoiceRegionsState.put(Long.valueOf(guildId), new State.Loaded(voiceRegions));
        markChanged();
    }

    @Store3
    private final void handleGuildVoiceRegionsFetchFailed(long guildId) {
        this.guildVoiceRegionsState.put(Long.valueOf(guildId), State.Failure.INSTANCE);
        markChanged();
    }

    @Store3
    private final void handleGuildVoiceRegionsFetchStart(long guildId) {
        this.guildVoiceRegionsState.put(Long.valueOf(guildId), State.Fetching.INSTANCE);
        markChanged();
    }

    public final void fetchIfNonexisting(long guildId) {
        this.dispatcher.schedule(new C60891(guildId));
    }

    public final List<ModelVoiceRegion> getGuildVoiceRegions(long guildId) {
        List<ModelVoiceRegion> list = (List) this.guildVoiceRegionsSnapshot.get(Long.valueOf(guildId));
        return list != null ? list : Collections2.emptyList();
    }

    public final Observable<List<ModelVoiceRegion>> observeGuildVoiceRegions(long guildId) {
        Observable<List<ModelVoiceRegion>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C60901(guildId), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        List<ModelVoiceRegion> listEmptyList;
        super.snapshotData();
        HashMap<Long, State> map = this.guildVoiceRegionsState;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, State> entry : map.entrySet()) {
            if (entry.getValue() instanceof State.Loaded) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsJVM.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key = entry2.getKey();
            Object value = entry2.getValue();
            if (!(value instanceof State.Loaded)) {
                value = null;
            }
            State.Loaded loaded = (State.Loaded) value;
            if (loaded == null || (listEmptyList = loaded.getData()) == null) {
                listEmptyList = Collections2.emptyList();
            }
            linkedHashMap2.put(key, listEmptyList);
        }
        this.guildVoiceRegionsSnapshot = linkedHashMap2;
    }

    public StoreGuildVoiceRegions(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildVoiceRegionsSnapshot = Maps6.emptyMap();
        this.guildVoiceRegionsState = new HashMap<>();
    }
}
