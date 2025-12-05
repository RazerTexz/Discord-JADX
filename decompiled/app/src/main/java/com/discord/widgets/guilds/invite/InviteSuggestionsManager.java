package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.channel.ChannelUtils3;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreMessagesMostRecent;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserAffinities;
import com.discord.stores.StoreUserRelationships;
import com.discord.widgets.guilds.invite.InviteSuggestion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func2;
import p658rx.functions.Func3;

/* compiled from: InviteSuggestionsManager.kt */
/* loaded from: classes2.dex */
public final class InviteSuggestionsManager {
    private final StoreChannels storeChannels;
    private final StoreMessagesMostRecent storeMessagesMostRecent;
    private final StoreUserAffinities storeUserAffinities;
    private final StoreUserRelationships storeUserRelationships;
    private final StoreUser storeUsers;

    /* compiled from: InviteSuggestionsManager.kt */
    public static final /* data */ class UserAffinityData {
        private final Map<Long, Integer> relationships;
        private final List<Long> userIds;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public UserAffinityData(List<Long> list, Map<Long, ? extends User> map, Map<Long, Integer> map2) {
            Intrinsics3.checkNotNullParameter(list, "userIds");
            Intrinsics3.checkNotNullParameter(map, "users");
            Intrinsics3.checkNotNullParameter(map2, "relationships");
            this.userIds = list;
            this.users = map;
            this.relationships = map2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UserAffinityData copy$default(UserAffinityData userAffinityData, List list, Map map, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = userAffinityData.userIds;
            }
            if ((i & 2) != 0) {
                map = userAffinityData.users;
            }
            if ((i & 4) != 0) {
                map2 = userAffinityData.relationships;
            }
            return userAffinityData.copy(list, map, map2);
        }

        public final List<Long> component1() {
            return this.userIds;
        }

        public final Map<Long, User> component2() {
            return this.users;
        }

        public final Map<Long, Integer> component3() {
            return this.relationships;
        }

        public final UserAffinityData copy(List<Long> userIds, Map<Long, ? extends User> users, Map<Long, Integer> relationships) {
            Intrinsics3.checkNotNullParameter(userIds, "userIds");
            Intrinsics3.checkNotNullParameter(users, "users");
            Intrinsics3.checkNotNullParameter(relationships, "relationships");
            return new UserAffinityData(userIds, users, relationships);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UserAffinityData)) {
                return false;
            }
            UserAffinityData userAffinityData = (UserAffinityData) other;
            return Intrinsics3.areEqual(this.userIds, userAffinityData.userIds) && Intrinsics3.areEqual(this.users, userAffinityData.users) && Intrinsics3.areEqual(this.relationships, userAffinityData.relationships);
        }

        public final Map<Long, Integer> getRelationships() {
            return this.relationships;
        }

        public final List<Long> getUserIds() {
            return this.userIds;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            List<Long> list = this.userIds;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            Map<Long, User> map = this.users;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Integer> map2 = this.relationships;
            return iHashCode2 + (map2 != null ? map2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("UserAffinityData(userIds=");
            sbM833U.append(this.userIds);
            sbM833U.append(", users=");
            sbM833U.append(this.users);
            sbM833U.append(", relationships=");
            return outline.m825M(sbM833U, this.relationships, ")");
        }
    }

    /* compiled from: InviteSuggestionsManager.kt */
    /* renamed from: com.discord.widgets.guilds.invite.InviteSuggestionsManager$observeInviteSuggestions$1 */
    public static final class C86371<T, R> implements Func1<List<? extends Long>, Observable<? extends UserAffinityData>> {

        /* compiled from: InviteSuggestionsManager.kt */
        /* renamed from: com.discord.widgets.guilds.invite.InviteSuggestionsManager$observeInviteSuggestions$1$1, reason: invalid class name */
        public static final class AnonymousClass1<T1, T2, R> implements Func2<Map<Long, ? extends User>, Map<Long, ? extends Integer>, UserAffinityData> {
            public final /* synthetic */ List $affinityUserIds;

            public AnonymousClass1(List list) {
                this.$affinityUserIds = list;
            }

            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ UserAffinityData call(Map<Long, ? extends User> map, Map<Long, ? extends Integer> map2) {
                return call2(map, (Map<Long, Integer>) map2);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final UserAffinityData call2(Map<Long, ? extends User> map, Map<Long, Integer> map2) {
                List list = this.$affinityUserIds;
                Intrinsics3.checkNotNullExpressionValue(list, "affinityUserIds");
                Intrinsics3.checkNotNullExpressionValue(map, "users");
                Intrinsics3.checkNotNullExpressionValue(map2, "relationships");
                return new UserAffinityData(list, map, map2);
            }
        }

        public C86371() {
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends UserAffinityData> call(List<? extends Long> list) {
            return call2((List<Long>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends UserAffinityData> call2(List<Long> list) {
            StoreUser storeUserAccess$getStoreUsers$p = InviteSuggestionsManager.access$getStoreUsers$p(InviteSuggestionsManager.this);
            Intrinsics3.checkNotNullExpressionValue(list, "affinityUserIds");
            return Observable.m11076j(storeUserAccess$getStoreUsers$p.observeUsers(list).m11112r(), InviteSuggestionsManager.access$getStoreUserRelationships$p(InviteSuggestionsManager.this).observe(list), new AnonymousClass1(list));
        }
    }

    /* compiled from: InviteSuggestionsManager.kt */
    /* renamed from: com.discord.widgets.guilds.invite.InviteSuggestionsManager$observeInviteSuggestions$2 */
    public static final class C86382<T1, T2, T3, R> implements Func3<Map<Long, ? extends Channel>, Map<Long, ? extends Long>, UserAffinityData, List<? extends InviteSuggestion>> {
        public static final C86382 INSTANCE = new C86382();

        @Override // p658rx.functions.Func3
        public /* bridge */ /* synthetic */ List<? extends InviteSuggestion> call(Map<Long, ? extends Channel> map, Map<Long, ? extends Long> map2, UserAffinityData userAffinityData) {
            return call2((Map<Long, Channel>) map, (Map<Long, Long>) map2, userAffinityData);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<InviteSuggestion> call2(Map<Long, Channel> map, Map<Long, Long> map2, UserAffinityData userAffinityData) {
            User userM7677a;
            ArrayList arrayList = new ArrayList();
            Collection<Channel> collectionValues = map.values();
            Channel.Companion companion = Channel.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(map2, "mostRecentMessages");
            Intrinsics3.checkNotNullParameter(companion, "$this$getSortByMostRecent");
            Intrinsics3.checkNotNullParameter(map2, "mostRecentMessageIds");
            List listSortedWith = _Collections.sortedWith(collectionValues, new ChannelUtils3(map2));
            Channel channel = listSortedWith.isEmpty() ^ true ? (Channel) listSortedWith.get(0) : null;
            if (channel != null) {
                arrayList.add(new InviteSuggestion.ChannelItem(channel));
            }
            List<Long> userIds = userAffinityData.getUserIds();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = userIds.iterator();
            while (it.hasNext()) {
                User user = userAffinityData.getUsers().get(Long.valueOf(((Number) it.next()).longValue()));
                if (user != null) {
                    arrayList2.add(user);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : arrayList2) {
                User user2 = (User) obj;
                Integer num = (Integer) outline.m849f(user2, userAffinityData.getRelationships());
                if (!(!(channel == null || (userM7677a = ChannelUtils.m7677a(channel)) == null || userM7677a.getId() != user2.getId()) || (num != null && num.intValue() == 2))) {
                    arrayList3.add(obj);
                }
            }
            List listDistinct = _Collections.distinct(arrayList3);
            Iterator it2 = listDistinct.iterator();
            while (it2.hasNext()) {
                arrayList.add(new InviteSuggestion.UserSuggestion((User) it2.next()));
            }
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : listSortedWith) {
                Channel channel2 = (Channel) obj2;
                if ((Intrinsics3.areEqual(channel, channel2) ^ true) && (ChannelUtils.m7677a(channel2) == null || !_Collections.contains(listDistinct, ChannelUtils.m7677a(channel2)))) {
                    arrayList4.add(obj2);
                }
            }
            ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList4, 10));
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                arrayList5.add(Boolean.valueOf(arrayList.add(new InviteSuggestion.ChannelItem((Channel) it3.next()))));
            }
            return arrayList;
        }
    }

    public InviteSuggestionsManager() {
        this(null, null, null, null, null, 31, null);
    }

    public InviteSuggestionsManager(StoreChannels storeChannels, StoreMessagesMostRecent storeMessagesMostRecent, StoreUserAffinities storeUserAffinities, StoreUser storeUser, StoreUserRelationships storeUserRelationships) {
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeMessagesMostRecent, "storeMessagesMostRecent");
        Intrinsics3.checkNotNullParameter(storeUserAffinities, "storeUserAffinities");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUsers");
        Intrinsics3.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        this.storeChannels = storeChannels;
        this.storeMessagesMostRecent = storeMessagesMostRecent;
        this.storeUserAffinities = storeUserAffinities;
        this.storeUsers = storeUser;
        this.storeUserRelationships = storeUserRelationships;
    }

    public static final /* synthetic */ StoreUserRelationships access$getStoreUserRelationships$p(InviteSuggestionsManager inviteSuggestionsManager) {
        return inviteSuggestionsManager.storeUserRelationships;
    }

    public static final /* synthetic */ StoreUser access$getStoreUsers$p(InviteSuggestionsManager inviteSuggestionsManager) {
        return inviteSuggestionsManager.storeUsers;
    }

    public final Observable<List<InviteSuggestion>> observeInviteSuggestions() {
        Observable<List<InviteSuggestion>> observableM11075i = Observable.m11075i(this.storeChannels.observePrivateChannels(), this.storeMessagesMostRecent.observeRecentMessageIds().m11100Z(1), this.storeUserAffinities.observeAffinityUserIds().m11099Y(new C86371()), C86382.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest… inviteSuggestionList\n  }");
        return observableM11075i;
    }

    public /* synthetic */ InviteSuggestionsManager(StoreChannels storeChannels, StoreMessagesMostRecent storeMessagesMostRecent, StoreUserAffinities storeUserAffinities, StoreUser storeUser, StoreUserRelationships storeUserRelationships, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 2) != 0 ? StoreStream.INSTANCE.getMessagesMostRecent() : storeMessagesMostRecent, (i & 4) != 0 ? StoreStream.INSTANCE.getUserAffinities() : storeUserAffinities, (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.INSTANCE.getUserRelationships() : storeUserRelationships);
    }
}
