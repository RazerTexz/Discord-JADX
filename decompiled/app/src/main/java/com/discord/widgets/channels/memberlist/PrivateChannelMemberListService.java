package com.discord.widgets.channels.memberlist;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: PrivateChannelMemberListService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PrivateChannelMemberListService {
    private final StoreApplicationStreaming storeApplicationStreaming;
    private final StoreUserPresence storePresences;
    private final StoreUser storeUser;

    /* JADX INFO: compiled from: PrivateChannelMemberListService.kt */
    public static final /* data */ class State {
        private final Map<Long, ModelApplicationStream> applicationStreams;
        private final Channel channel;
        private final Map<Long, Presence> presences;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public State(Channel channel, Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(map, "users");
            Intrinsics3.checkNotNullParameter(map2, "presences");
            Intrinsics3.checkNotNullParameter(map3, "applicationStreams");
            this.channel = channel;
            this.users = map;
            this.presences = map2;
            this.applicationStreams = map3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, Channel channel, Map map, Map map2, Map map3, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = state.channel;
            }
            if ((i & 2) != 0) {
                map = state.users;
            }
            if ((i & 4) != 0) {
                map2 = state.presences;
            }
            if ((i & 8) != 0) {
                map3 = state.applicationStreams;
            }
            return state.copy(channel, map, map2, map3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, User> component2() {
            return this.users;
        }

        public final Map<Long, Presence> component3() {
            return this.presences;
        }

        public final Map<Long, ModelApplicationStream> component4() {
            return this.applicationStreams;
        }

        public final State copy(Channel channel, Map<Long, ? extends User> users, Map<Long, Presence> presences, Map<Long, ? extends ModelApplicationStream> applicationStreams) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(users, "users");
            Intrinsics3.checkNotNullParameter(presences, "presences");
            Intrinsics3.checkNotNullParameter(applicationStreams, "applicationStreams");
            return new State(channel, users, presences, applicationStreams);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics3.areEqual(this.channel, state.channel) && Intrinsics3.areEqual(this.users, state.users) && Intrinsics3.areEqual(this.presences, state.presences) && Intrinsics3.areEqual(this.applicationStreams, state.applicationStreams);
        }

        public final Map<Long, ModelApplicationStream> getApplicationStreams() {
            return this.applicationStreams;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, Presence> getPresences() {
            return this.presences;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Map<Long, User> map = this.users;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Presence> map2 = this.presences;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, ModelApplicationStream> map3 = this.applicationStreams;
            return iHashCode3 + (map3 != null ? map3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("State(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", users=");
            sbM833U.append(this.users);
            sbM833U.append(", presences=");
            sbM833U.append(this.presences);
            sbM833U.append(", applicationStreams=");
            return outline.m825M(sbM833U, this.applicationStreams, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.PrivateChannelMemberListService$observeStateForGroupDm$1 */
    /* JADX INFO: compiled from: PrivateChannelMemberListService.kt */
    public static final class C74861<T, R> implements Func1<com.discord.api.user.User, Long> {
        public static final C74861 INSTANCE = new C74861();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Long call(com.discord.api.user.User user) {
            return call2(user);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Long call2(com.discord.api.user.User user) {
            return Long.valueOf(user.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.PrivateChannelMemberListService$observeStateForGroupDm$2 */
    /* JADX INFO: compiled from: PrivateChannelMemberListService.kt */
    public static final class C74872<T, R> implements Func1<List<Long>, Observable<? extends State>> {
        public final /* synthetic */ Channel $channel;

        /* JADX INFO: renamed from: com.discord.widgets.channels.memberlist.PrivateChannelMemberListService$observeStateForGroupDm$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: PrivateChannelMemberListService.kt */
        public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends ModelApplicationStream>, State> {
            public AnonymousClass1() {
            }

            @Override // p658rx.functions.Func3
            public /* bridge */ /* synthetic */ State call(Map<Long, ? extends User> map, Map<Long, ? extends Presence> map2, Map<Long, ? extends ModelApplicationStream> map3) {
                return call2(map, (Map<Long, Presence>) map2, map3);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final State call2(Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3) {
                Channel channel = C74872.this.$channel;
                Intrinsics3.checkNotNullExpressionValue(map, "users");
                Intrinsics3.checkNotNullExpressionValue(map2, "presences");
                Intrinsics3.checkNotNullExpressionValue(map3, "applicationStreams");
                return new State(channel, map, map2, map3);
            }
        }

        public C74872(Channel channel) {
            this.$channel = channel;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends State> call(List<Long> list) {
            return call2(list);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends State> call2(List<Long> list) {
            StoreUser storeUserAccess$getStoreUser$p = PrivateChannelMemberListService.access$getStoreUser$p(PrivateChannelMemberListService.this);
            Intrinsics3.checkNotNullExpressionValue(list, "ids");
            return Observable.m11075i(storeUserAccess$getStoreUser$p.observeUsers(list), PrivateChannelMemberListService.access$getStorePresences$p(PrivateChannelMemberListService.this).observePresencesForUsers(list), PrivateChannelMemberListService.access$getStoreApplicationStreaming$p(PrivateChannelMemberListService.this).observeStreamsByUser(), new AnonymousClass1());
        }
    }

    public PrivateChannelMemberListService() {
        this(null, null, null, 7, null);
    }

    public PrivateChannelMemberListService(StoreUser storeUser, StoreUserPresence storeUserPresence, StoreApplicationStreaming storeApplicationStreaming) {
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeUserPresence, "storePresences");
        Intrinsics3.checkNotNullParameter(storeApplicationStreaming, "storeApplicationStreaming");
        this.storeUser = storeUser;
        this.storePresences = storeUserPresence;
        this.storeApplicationStreaming = storeApplicationStreaming;
    }

    public static final /* synthetic */ StoreApplicationStreaming access$getStoreApplicationStreaming$p(PrivateChannelMemberListService privateChannelMemberListService) {
        return privateChannelMemberListService.storeApplicationStreaming;
    }

    public static final /* synthetic */ StoreUserPresence access$getStorePresences$p(PrivateChannelMemberListService privateChannelMemberListService) {
        return privateChannelMemberListService.storePresences;
    }

    public static final /* synthetic */ StoreUser access$getStoreUser$p(PrivateChannelMemberListService privateChannelMemberListService) {
        return privateChannelMemberListService.storeUser;
    }

    public final Observable<State> observeStateForGroupDm(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Observable<State> observableM11099Y = Observable.m11064I(this.storeUser.observeMeId().m11100Z(1).m11104c0(5000L, TimeUnit.MILLISECONDS), Observable.m11058B(channel.m7659z()).m11083G(C74861.INSTANCE)).m11105f0().m11099Y(new C74872(channel));
        Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "Observable.merge(\n      …            }\n          }");
        return observableM11099Y;
    }

    public /* synthetic */ PrivateChannelMemberListService(StoreUser storeUser, StoreUserPresence storeUserPresence, StoreApplicationStreaming storeApplicationStreaming, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 2) != 0 ? StoreStream.INSTANCE.getPresences() : storeUserPresence, (i & 4) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming);
    }
}
