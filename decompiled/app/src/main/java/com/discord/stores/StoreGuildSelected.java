package com.discord.stores;

import android.content.Context;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.collections.LeastRecentlyAddedSet;
import com.discord.utilities.persister.Persister;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.MutableCollections;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreGuildSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildSelected extends StoreV2 {
    private static final int MAX_SAVED_GUILD_IDS = 5;
    public static final long UNSELECTED = 0;
    private final StoreAnalytics analyticsStore;
    private final Dispatcher dispatcher;
    private final StoreGuilds guildStore;
    private final ObservationDeck observationDeck;
    private final LeastRecentlyAddedSet<Long> selectedGuildIds;
    private final Persister<LeastRecentlyAddedSet<Long>> selectedGuildIdsCache;
    private List<Long> selectedGuildIdsSnapshot;
    private final StoreStream stream;

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildSelected$dispatchSampleGuildIdSelected$1 */
    /* JADX INFO: compiled from: StoreGuildSelected.kt */
    public static final class C60711 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60711(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildSelected.access$getStream$p(StoreGuildSelected.this).handleSamplePremiumGuildSelected(this.$guildId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildSelected$handleConnectionOpen$1 */
    /* JADX INFO: compiled from: StoreGuildSelected.kt */
    public static final class C60721 extends Lambda implements Function1<Long, Boolean> {
        public final /* synthetic */ ModelPayload $payload;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60721(ModelPayload modelPayload) {
            super(1);
            this.$payload = modelPayload;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
            return Boolean.valueOf(invoke(l.longValue()));
        }

        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean invoke(long j) {
            boolean z2;
            if (j != 0) {
                List<Guild> guilds = this.$payload.getGuilds();
                Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
                if ((guilds instanceof Collection) && guilds.isEmpty()) {
                    z2 = false;
                    if (z2) {
                    }
                } else {
                    Iterator<T> it = guilds.iterator();
                    while (it.hasNext()) {
                        if (j == ((Guild) it.next()).getId()) {
                            z2 = true;
                            break;
                        }
                    }
                    z2 = false;
                    if (z2) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildSelected$observeRecentSelectedGuildIds$1 */
    /* JADX INFO: compiled from: StoreGuildSelected.kt */
    public static final class C60731 extends Lambda implements Function0<List<? extends Long>> {
        public C60731() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends Long> invoke2() {
            return StoreGuildSelected.this.getRecentlySelectedGuildIds();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildSelected$observeSelectedGuild$1 */
    /* JADX INFO: compiled from: StoreGuildSelected.kt */
    public static final class C60741 extends Lambda implements Function0<com.discord.models.guild.Guild> {
        public C60741() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ com.discord.models.guild.Guild invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.discord.models.guild.Guild invoke() {
            return StoreGuildSelected.access$getGuildStore$p(StoreGuildSelected.this).getGuilds().get(Long.valueOf(StoreGuildSelected.this.getSelectedGuildId()));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildSelected$observeSelectedGuildId$1 */
    /* JADX INFO: compiled from: StoreGuildSelected.kt */
    public static final class C60751 extends Lambda implements Function0<Long> {
        public C60751() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return Long.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2() {
            return StoreGuildSelected.this.getSelectedGuildId();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildSelected$set$1 */
    /* JADX INFO: compiled from: StoreGuildSelected.kt */
    public static final class C60761 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60761(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildSelected.access$getStream$p(StoreGuildSelected.this).handleGuildSelected(this.$guildId);
        }
    }

    public /* synthetic */ StoreGuildSelected(StoreStream storeStream, Dispatcher dispatcher, StoreGuilds storeGuilds, StoreAnalytics storeAnalytics, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, storeGuilds, storeAnalytics, (i & 16) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ StoreGuilds access$getGuildStore$p(StoreGuildSelected storeGuildSelected) {
        return storeGuildSelected.guildStore;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreGuildSelected storeGuildSelected) {
        return storeGuildSelected.stream;
    }

    public final void dispatchSampleGuildIdSelected(long guildId) {
        this.dispatcher.schedule(new C60711(guildId));
    }

    public final List<Long> getRecentlySelectedGuildIds() {
        return this.selectedGuildIdsSnapshot;
    }

    public final long getSelectedGuildId() {
        Long l = (Long) _Collections.firstOrNull((List) this.selectedGuildIdsSnapshot);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    @Store3
    public final long getSelectedGuildIdInternal$app_productionGoogleRelease() {
        Long l = (Long) _Collections.lastOrNull(this.selectedGuildIds);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        MutableCollections.removeAll(this.selectedGuildIds, new C60721(payload));
        markChanged();
    }

    @Store3
    public final void handleGuildRemove(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        if (this.selectedGuildIds.remove(Long.valueOf(guild.getId()))) {
            markChanged();
        }
    }

    @Store3
    public final void handleGuildSelected(long guildId) {
        this.selectedGuildIds.add(Long.valueOf(guildId));
        markChanged();
    }

    @Store3
    public final void handlePreLogout() {
        this.selectedGuildIds.clear();
        markChanged();
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        this.selectedGuildIds.clear();
        this.selectedGuildIds.addAll(this.selectedGuildIdsCache.get());
        markChanged();
    }

    public final Observable<List<Long>> observeRecentSelectedGuildIds() {
        Observable<List<Long>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C60731(), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<com.discord.models.guild.Guild> observeSelectedGuild() {
        Observable<com.discord.models.guild.Guild> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this, this.guildStore}, false, null, null, new C60741(), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Long> observeSelectedGuildId() {
        Observable<Long> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C60751(), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final void set(long guildId) {
        this.dispatcher.schedule(new C60761(guildId));
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        if (this.selectedGuildIds.isEmpty()) {
            this.selectedGuildIds.add(0L);
        }
        this.analyticsStore.trackGuildViewed(((Number) _Collections.last(this.selectedGuildIds)).longValue());
        Set<Long> lurkingGuildIdsSync = this.stream.getLurking().getLurkingGuildIdsSync();
        LeastRecentlyAddedSet<Long> leastRecentlyAddedSet = new LeastRecentlyAddedSet<>(0, null, 3, null);
        LeastRecentlyAddedSet<Long> leastRecentlyAddedSet2 = this.selectedGuildIds;
        ArrayList arrayList = new ArrayList();
        for (Long l : leastRecentlyAddedSet2) {
            if (true ^ lurkingGuildIdsSync.contains(Long.valueOf(l.longValue()))) {
                arrayList.add(l);
            }
        }
        leastRecentlyAddedSet.addAll(arrayList);
        this.selectedGuildIdsCache.set(leastRecentlyAddedSet, true);
        this.selectedGuildIdsSnapshot = _Collections.reversed(this.selectedGuildIds);
    }

    public StoreGuildSelected(StoreStream storeStream, Dispatcher dispatcher, StoreGuilds storeGuilds, StoreAnalytics storeAnalytics, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildStore");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "analyticsStore");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.guildStore = storeGuilds;
        this.analyticsStore = storeAnalytics;
        this.observationDeck = observationDeck;
        LeastRecentlyAddedSet<Long> leastRecentlyAddedSet = new LeastRecentlyAddedSet<>(5, null, 2, null);
        this.selectedGuildIds = leastRecentlyAddedSet;
        this.selectedGuildIdsSnapshot = new ArrayList();
        this.selectedGuildIdsCache = new Persister<>("STORE_GUILD_SELECTED_V5", leastRecentlyAddedSet);
    }
}
