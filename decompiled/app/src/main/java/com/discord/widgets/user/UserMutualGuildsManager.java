package com.discord.widgets.user;

import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p512d0._Ranges;
import p507d0.p580t.Iterables2;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* JADX INFO: compiled from: UserMutualGuildsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserMutualGuildsManager {
    private final ObservationDeck observationDeck;
    private final StoreGuilds storeGuilds;
    private final StoreGuildsSorted storeGuildsSorted;

    /* JADX INFO: renamed from: com.discord.widgets.user.UserMutualGuildsManager$observeMutualGuilds$1 */
    /* JADX INFO: compiled from: UserMutualGuildsManager.kt */
    public static final class C101841 extends Lambda implements Function0<Map<Long, ? extends List<? extends Guild>>> {
        public final /* synthetic */ Collection $userIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C101841(Collection collection) {
            super(0);
            this.$userIds = collection;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends List<? extends Guild>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends List<? extends Guild>> invoke2() {
            LinkedHashMap<Long, Guild> orderedGuilds = UserMutualGuildsManager.access$getStoreGuildsSorted$p(UserMutualGuildsManager.this).getOrderedGuilds();
            Map<Long, Map<Long, GuildMember>> members = UserMutualGuildsManager.access$getStoreGuilds$p(UserMutualGuildsManager.this).getMembers();
            Collection<Guild> collectionValues = orderedGuilds.values();
            Collection<Number> collection = this.$userIds;
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(collection, 10)), 16));
            for (Number number : collection) {
                Long lValueOf = Long.valueOf(number.longValue());
                long jLongValue = number.longValue();
                Intrinsics3.checkNotNullExpressionValue(collectionValues, "guildsList");
                ArrayList arrayList = new ArrayList();
                for (Object obj : collectionValues) {
                    Map map = (Map) outline.m847e((Guild) obj, members);
                    if (map != null && map.containsKey(Long.valueOf(jLongValue))) {
                        arrayList.add(obj);
                    }
                }
                linkedHashMap.put(lValueOf, arrayList);
            }
            return linkedHashMap;
        }
    }

    public UserMutualGuildsManager() {
        this(null, null, null, 7, null);
    }

    public UserMutualGuildsManager(StoreGuildsSorted storeGuildsSorted, StoreGuilds storeGuilds, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeGuildsSorted, "storeGuildsSorted");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeGuildsSorted = storeGuildsSorted;
        this.storeGuilds = storeGuilds;
        this.observationDeck = observationDeck;
    }

    public static final /* synthetic */ StoreGuilds access$getStoreGuilds$p(UserMutualGuildsManager userMutualGuildsManager) {
        return userMutualGuildsManager.storeGuilds;
    }

    public static final /* synthetic */ StoreGuildsSorted access$getStoreGuildsSorted$p(UserMutualGuildsManager userMutualGuildsManager) {
        return userMutualGuildsManager.storeGuildsSorted;
    }

    public final Observable<Map<Long, List<Guild>>> observeMutualGuilds(Collection<Long> userIds) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Observable<Map<Long, List<Guild>>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeGuildsSorted, this.storeGuilds}, false, null, null, new C101841(userIds), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public /* synthetic */ UserMutualGuildsManager(StoreGuildsSorted storeGuildsSorted, StoreGuilds storeGuilds, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getGuildsSorted() : storeGuildsSorted, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
    }
}
