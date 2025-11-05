package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.sticker.dto.ModelStickerStoreDirectory;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.frecency.FrecencyTracker;
import com.discord.utilities.media.MediaFrecencyTracker;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.d0.f;
import d0.t.g0;
import d0.t.h0;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreStickers.kt */
/* loaded from: classes2.dex */
public final class StoreStickers extends StoreV2 {
    private static final long FETCH_ENABLED_STICKER_PACKS_DELAY = 300000;
    private static final int MAX_FREQUENTLY_USED_STICKERS = 20;
    private final RestAPI api;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private List<ModelStickerPack> enabledStickerPacks;
    private List<ModelStickerPack> enabledStickerPacksSnapshot;
    private List<Sticker> enabledStickerPacksStickersSnapshot;
    private final MediaFrecencyTracker frecency;
    private final Persister<MediaFrecencyTracker> frecencyCache;
    private long lastFetchedEnabledPacks;
    private final ObservationDeck observationDeck;
    private Map<Long, ? extends StickerPackState> stickerPacks;
    private Map<Long, ? extends StickerPackState> stickerPacksSnapshot;
    private Map<Long, Sticker> stickersSnapshot;

    /* compiled from: StoreStickers.kt */
    public static abstract class StickerPackState {

        /* compiled from: StoreStickers.kt */
        public static final /* data */ class Loaded extends StickerPackState {
            private final ModelStickerPack stickerPack;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(ModelStickerPack modelStickerPack) {
                super(null);
                m.checkNotNullParameter(modelStickerPack, "stickerPack");
                this.stickerPack = modelStickerPack;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, ModelStickerPack modelStickerPack, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelStickerPack = loaded.stickerPack;
                }
                return loaded.copy(modelStickerPack);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelStickerPack getStickerPack() {
                return this.stickerPack;
            }

            public final Loaded copy(ModelStickerPack stickerPack) {
                m.checkNotNullParameter(stickerPack, "stickerPack");
                return new Loaded(stickerPack);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && m.areEqual(this.stickerPack, ((Loaded) other).stickerPack);
                }
                return true;
            }

            public final ModelStickerPack getStickerPack() {
                return this.stickerPack;
            }

            public int hashCode() {
                ModelStickerPack modelStickerPack = this.stickerPack;
                if (modelStickerPack != null) {
                    return modelStickerPack.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = a.U("Loaded(stickerPack=");
                sbU.append(this.stickerPack);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: StoreStickers.kt */
        public static final class Loading extends StickerPackState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: StoreStickers.kt */
        public static final class Unknown extends StickerPackState {
            public static final Unknown INSTANCE = new Unknown();

            private Unknown() {
                super(null);
            }
        }

        private StickerPackState() {
        }

        public /* synthetic */ StickerPackState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreStickers.kt */
    /* renamed from: com.discord.stores.StoreStickers$fetchEnabledStickerDirectory$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ModelStickerStoreDirectory, Unit> {

        /* compiled from: StoreStickers.kt */
        /* renamed from: com.discord.stores.StoreStickers$fetchEnabledStickerDirectory$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02941 extends o implements Function0<Unit> {
            public final /* synthetic */ ModelStickerStoreDirectory $directory;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02941(ModelStickerStoreDirectory modelStickerStoreDirectory) {
                super(0);
                this.$directory = modelStickerStoreDirectory;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreStickers storeStickers = StoreStickers.this;
                StoreStickers.access$setLastFetchedEnabledPacks$p(storeStickers, StoreStickers.access$getClock$p(storeStickers).currentTimeMillis());
                StoreStickers.this.handleNewEnabledStickerDirectory(this.$directory.getStickerPacks());
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelStickerStoreDirectory modelStickerStoreDirectory) {
            invoke2(modelStickerStoreDirectory);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelStickerStoreDirectory modelStickerStoreDirectory) {
            m.checkNotNullParameter(modelStickerStoreDirectory, "directory");
            StoreStickers.access$getDispatcher$p(StoreStickers.this).schedule(new C02941(modelStickerStoreDirectory));
        }
    }

    /* compiled from: StoreStickers.kt */
    /* renamed from: com.discord.stores.StoreStickers$fetchStickerPack$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $stickerPackId;

        /* compiled from: StoreStickers.kt */
        /* renamed from: com.discord.stores.StoreStickers$fetchStickerPack$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02951 extends o implements Function1<ModelStickerPack, Unit> {

            /* compiled from: StoreStickers.kt */
            /* renamed from: com.discord.stores.StoreStickers$fetchStickerPack$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C02961 extends o implements Function0<Unit> {
                public final /* synthetic */ ModelStickerPack $newPack;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02961(ModelStickerPack modelStickerPack) {
                    super(0);
                    this.$newPack = modelStickerPack;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreStickers.this.handleNewLoadedStickerPacks(d0.t.m.listOf(this.$newPack));
                }
            }

            public C02951() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelStickerPack modelStickerPack) {
                invoke2(modelStickerPack);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelStickerPack modelStickerPack) {
                m.checkNotNullParameter(modelStickerPack, "newPack");
                StoreStickers.access$getDispatcher$p(StoreStickers.this).schedule(new C02961(modelStickerPack));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$stickerPackId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStickers.this.handleNewLoadingStickerPacks(d0.t.m.listOf(Long.valueOf(this.$stickerPackId)));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StoreStickers.access$getApi$p(StoreStickers.this).getStickerPack(this.$stickerPackId), false, 1, null), StoreStickers.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C02951(), 62, (Object) null);
        }
    }

    /* compiled from: StoreStickers.kt */
    /* renamed from: com.discord.stores.StoreStickers$handleDeletedStickers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ List $stickerIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list) {
            super(0);
            this.$stickerIds = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Iterator it = this.$stickerIds.iterator();
            while (it.hasNext()) {
                StoreStickers.access$getFrecency$p(StoreStickers.this).removeEntry(String.valueOf(((Number) it.next()).longValue()));
            }
            StoreStickers.access$getFrecencyCache$p(StoreStickers.this).set(StoreStickers.access$getFrecency$p(StoreStickers.this), true);
        }
    }

    /* compiled from: StoreStickers.kt */
    /* renamed from: com.discord.stores.StoreStickers$observeEnabledStickerPacks$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<List<? extends ModelStickerPack>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends ModelStickerPack> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends ModelStickerPack> invoke2() {
            return StoreStickers.access$getEnabledStickerPacksSnapshot$p(StoreStickers.this);
        }
    }

    /* compiled from: StoreStickers.kt */
    /* renamed from: com.discord.stores.StoreStickers$observeFrequentlyUsedStickerIds$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<MediaFrecencyTracker, List<? extends Long>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ List<? extends Long> call(MediaFrecencyTracker mediaFrecencyTracker) {
            return call2(mediaFrecencyTracker);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Long> call2(MediaFrecencyTracker mediaFrecencyTracker) {
            Collection sortedKeys$default = FrecencyTracker.getSortedKeys$default(mediaFrecencyTracker, 0L, 1, null);
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(sortedKeys$default, 10));
            Iterator<T> it = sortedKeys$default.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(Long.parseLong((String) it.next())));
            }
            return arrayList;
        }
    }

    /* compiled from: StoreStickers.kt */
    /* renamed from: com.discord.stores.StoreStickers$observeStickerPack$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $stickerPackId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$stickerPackId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreStickers.access$getStickerPacks$p(StoreStickers.this).containsKey(Long.valueOf(this.$stickerPackId))) {
                return;
            }
            StoreStickers.this.fetchStickerPack(this.$stickerPackId);
        }
    }

    /* compiled from: StoreStickers.kt */
    /* renamed from: com.discord.stores.StoreStickers$observeStickerPack$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<StickerPackState> {
        public final /* synthetic */ long $stickerPackId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(0);
            this.$stickerPackId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ StickerPackState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final StickerPackState invoke() {
            StickerPackState stickerPackState = (StickerPackState) StoreStickers.access$getStickerPacks$p(StoreStickers.this).get(Long.valueOf(this.$stickerPackId));
            return stickerPackState != null ? stickerPackState : StickerPackState.Unknown.INSTANCE;
        }
    }

    /* compiled from: StoreStickers.kt */
    /* renamed from: com.discord.stores.StoreStickers$observeStickerPacks$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<List<? extends StickerPackState>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends StickerPackState> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends StickerPackState> invoke2() {
            return u.toList(StoreStickers.access$getStickerPacks$p(StoreStickers.this).values());
        }
    }

    /* compiled from: StoreStickers.kt */
    /* renamed from: com.discord.stores.StoreStickers$onStickerUsed$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ Sticker $sticker;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Sticker sticker) {
            super(0);
            this.$sticker = sticker;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FrecencyTracker.track$default(StoreStickers.access$getFrecency$p(StoreStickers.this), String.valueOf(this.$sticker.getId()), 0L, 2, null);
            StoreStickers.access$getFrecencyCache$p(StoreStickers.this).set(StoreStickers.access$getFrecency$p(StoreStickers.this), true);
        }
    }

    public /* synthetic */ StoreStickers(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 8) != 0 ? ClockFactory.get() : clock);
    }

    public static final /* synthetic */ RestAPI access$getApi$p(StoreStickers storeStickers) {
        return storeStickers.api;
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreStickers storeStickers) {
        return storeStickers.clock;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreStickers storeStickers) {
        return storeStickers.dispatcher;
    }

    public static final /* synthetic */ List access$getEnabledStickerPacksSnapshot$p(StoreStickers storeStickers) {
        return storeStickers.enabledStickerPacksSnapshot;
    }

    public static final /* synthetic */ MediaFrecencyTracker access$getFrecency$p(StoreStickers storeStickers) {
        return storeStickers.frecency;
    }

    public static final /* synthetic */ Persister access$getFrecencyCache$p(StoreStickers storeStickers) {
        return storeStickers.frecencyCache;
    }

    public static final /* synthetic */ long access$getLastFetchedEnabledPacks$p(StoreStickers storeStickers) {
        return storeStickers.lastFetchedEnabledPacks;
    }

    public static final /* synthetic */ Map access$getStickerPacks$p(StoreStickers storeStickers) {
        return storeStickers.stickerPacks;
    }

    public static final /* synthetic */ void access$setEnabledStickerPacksSnapshot$p(StoreStickers storeStickers, List list) {
        storeStickers.enabledStickerPacksSnapshot = list;
    }

    public static final /* synthetic */ void access$setLastFetchedEnabledPacks$p(StoreStickers storeStickers, long j) {
        storeStickers.lastFetchedEnabledPacks = j;
    }

    public static final /* synthetic */ void access$setStickerPacks$p(StoreStickers storeStickers, Map map) {
        storeStickers.stickerPacks = map;
    }

    public final void fetchEnabledStickerDirectory() {
        if (this.lastFetchedEnabledPacks + 300000 >= this.clock.currentTimeMillis()) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.api.getStickerPacks(), false, 1, null), StoreStickers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public final void fetchStickerPack(long stickerPackId) {
        this.dispatcher.schedule(new AnonymousClass1(stickerPackId));
    }

    public final List<ModelStickerPack> getEnabledStickerPacks() {
        return this.enabledStickerPacksSnapshot;
    }

    public final List<Sticker> getEnabledStickers() {
        return this.enabledStickerPacksStickersSnapshot;
    }

    public final StickerPackState getStickerPack(long stickerPackId) {
        return this.stickerPacksSnapshot.get(Long.valueOf(stickerPackId));
    }

    public final Map<Long, StickerPackState> getStickerPacks() {
        return this.stickerPacksSnapshot;
    }

    public final Map<Long, Sticker> getStickers() {
        return this.stickersSnapshot;
    }

    public final void handleDeletedStickers(List<Long> stickerIds) {
        m.checkNotNullParameter(stickerIds, "stickerIds");
        this.dispatcher.schedule(new AnonymousClass1(stickerIds));
    }

    public final void handleFetchedSticker(Sticker sticker) {
        if (sticker == null || sticker.getType() != StickerType.STANDARD) {
            return;
        }
        Long packId = sticker.getPackId();
        m.checkNotNull(packId);
        fetchStickerPack(packId.longValue());
    }

    @StoreThread
    public final void handleNewEnabledStickerDirectory(List<ModelStickerPack> enabledPacks) {
        m.checkNotNullParameter(enabledPacks, "enabledPacks");
        handleNewLoadedStickerPacks(enabledPacks);
        this.enabledStickerPacks = enabledPacks;
        markChanged();
    }

    @StoreThread
    public final void handleNewLoadedStickerPacks(List<ModelStickerPack> newStickerPacks) {
        m.checkNotNullParameter(newStickerPacks, "newStickerPacks");
        Map<Long, ? extends StickerPackState> mutableMap = h0.toMutableMap(this.stickerPacks);
        for (ModelStickerPack modelStickerPack : newStickerPacks) {
            StickerPackState stickerPackState = this.stickerPacks.get(Long.valueOf(modelStickerPack.getId()));
            if (stickerPackState == null || !(stickerPackState instanceof StickerPackState.Loaded) || ((StickerPackState.Loaded) stickerPackState).getStickerPack().getStoreListing() == null) {
                mutableMap.put(Long.valueOf(modelStickerPack.getId()), new StickerPackState.Loaded(modelStickerPack));
            }
        }
        this.stickerPacks = mutableMap;
        markChanged();
    }

    @StoreThread
    public final void handleNewLoadingStickerPacks(List<Long> stickerPackIds) {
        m.checkNotNullParameter(stickerPackIds, "stickerPackIds");
        Map<Long, ? extends StickerPackState> mutableMap = h0.toMutableMap(this.stickerPacks);
        Iterator<T> it = stickerPackIds.iterator();
        while (it.hasNext()) {
            mutableMap.put(Long.valueOf(((Number) it.next()).longValue()), StickerPackState.Loading.INSTANCE);
        }
        this.stickerPacks = mutableMap;
        markChanged();
    }

    @StoreThread
    public final void handlePreLogout() {
        Persister.clear$default(this.frecencyCache, false, 1, null);
    }

    public final void init() {
        fetchEnabledStickerDirectory();
    }

    public final Observable<List<ModelStickerPack>> observeEnabledStickerPacks() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<List<Long>> observeFrequentlyUsedStickerIds() {
        Observable observableG = this.frecencyCache.getObservable().G(AnonymousClass1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "frecencyCache.getObserva…ckerId.toLong() }\n      }");
        return observableG;
    }

    public final Observable<StickerPackState> observeStickerPack(long stickerPackId) {
        this.dispatcher.schedule(new AnonymousClass1(stickerPackId));
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass2(stickerPackId), 14, null);
    }

    public final Observable<List<StickerPackState>> observeStickerPacks() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final void onStickerUsed(Sticker sticker) {
        m.checkNotNullParameter(sticker, "sticker");
        this.dispatcher.schedule(new AnonymousClass1(sticker));
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        HashMap map = new HashMap(this.stickerPacks);
        this.stickerPacksSnapshot = map;
        Collection collectionValues = map.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (obj instanceof StickerPackState.Loaded) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((StickerPackState.Loaded) it.next()).getStickerPack().getStickers());
        }
        List listFlatten = d0.t.o.flatten(arrayList2);
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(listFlatten, 10)), 16));
        for (Object obj2 : listFlatten) {
            linkedHashMap.put(Long.valueOf(((Sticker) obj2).getId()), obj2);
        }
        this.stickersSnapshot = linkedHashMap;
        this.enabledStickerPacksSnapshot = new ArrayList(this.enabledStickerPacks);
        List<ModelStickerPack> list = this.enabledStickerPacks;
        ArrayList arrayList3 = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((ModelStickerPack) it2.next()).getStickers());
        }
        this.enabledStickerPacksStickersSnapshot = new ArrayList(d0.t.o.flatten(arrayList3));
    }

    public StoreStickers(Dispatcher dispatcher, RestAPI restAPI, ObservationDeck observationDeck, Clock clock) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(restAPI, "api");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(clock, "clock");
        this.dispatcher = dispatcher;
        this.api = restAPI;
        this.observationDeck = observationDeck;
        this.clock = clock;
        this.stickerPacks = h0.emptyMap();
        this.stickerPacksSnapshot = h0.emptyMap();
        this.stickersSnapshot = h0.emptyMap();
        Persister<MediaFrecencyTracker> persister = new Persister<>("STICKER_HISTORY_V1", new MediaFrecencyTracker(20, 1));
        this.frecencyCache = persister;
        this.frecency = persister.get();
        this.enabledStickerPacks = n.emptyList();
        this.enabledStickerPacksSnapshot = n.emptyList();
        this.enabledStickerPacksStickersSnapshot = n.emptyList();
    }
}
