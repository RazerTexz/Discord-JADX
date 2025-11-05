package com.discord.widgets.channels.memberlist;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreaming;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import d0.z.d.m;
import j0.k.b;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: PrivateChannelMemberListService.kt */
/* loaded from: classes2.dex */
public final class PrivateChannelMemberListService {
    private final StoreApplicationStreaming storeApplicationStreaming;
    private final StoreUserPresence storePresences;
    private final StoreUser storeUser;

    /* compiled from: PrivateChannelMemberListService.kt */
    public static final /* data */ class State {
        private final Map<Long, ModelApplicationStream> applicationStreams;
        private final Channel channel;
        private final Map<Long, Presence> presences;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public State(Channel channel, Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3) {
            m.checkNotNullParameter(channel, "channel");
            m.checkNotNullParameter(map, "users");
            m.checkNotNullParameter(map2, "presences");
            m.checkNotNullParameter(map3, "applicationStreams");
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

        /* renamed from: component1, reason: from getter */
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
            m.checkNotNullParameter(channel, "channel");
            m.checkNotNullParameter(users, "users");
            m.checkNotNullParameter(presences, "presences");
            m.checkNotNullParameter(applicationStreams, "applicationStreams");
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
            return m.areEqual(this.channel, state.channel) && m.areEqual(this.users, state.users) && m.areEqual(this.presences, state.presences) && m.areEqual(this.applicationStreams, state.applicationStreams);
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
            StringBuilder sbU = a.U("State(channel=");
            sbU.append(this.channel);
            sbU.append(", users=");
            sbU.append(this.users);
            sbU.append(", presences=");
            sbU.append(this.presences);
            sbU.append(", applicationStreams=");
            return a.M(sbU, this.applicationStreams, ")");
        }
    }

    /* compiled from: PrivateChannelMemberListService.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.PrivateChannelMemberListService$observeStateForGroupDm$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<com.discord.api.user.User, Long> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Long call(com.discord.api.user.User user) {
            return call2(user);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Long call2(com.discord.api.user.User user) {
            return Long.valueOf(user.getId());
        }
    }

    /* compiled from: PrivateChannelMemberListService.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.PrivateChannelMemberListService$observeStateForGroupDm$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<List<Long>, Observable<? extends State>> {
        public final /* synthetic */ Channel $channel;

        /* compiled from: PrivateChannelMemberListService.kt */
        /* renamed from: com.discord.widgets.channels.memberlist.PrivateChannelMemberListService$observeStateForGroupDm$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends ModelApplicationStream>, State> {
            public AnonymousClass1() {
            }

            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ State call(Map<Long, ? extends User> map, Map<Long, ? extends Presence> map2, Map<Long, ? extends ModelApplicationStream> map3) {
                return call2(map, (Map<Long, Presence>) map2, map3);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final State call2(Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, ? extends ModelApplicationStream> map3) {
                Channel channel = AnonymousClass2.this.$channel;
                m.checkNotNullExpressionValue(map, "users");
                m.checkNotNullExpressionValue(map2, "presences");
                m.checkNotNullExpressionValue(map3, "applicationStreams");
                return new State(channel, map, map2, map3);
            }
        }

        public AnonymousClass2(Channel channel) {
            this.$channel = channel;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends State> call(List<Long> list) {
            return call2(list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends State> call2(List<Long> list) {
            StoreUser storeUserAccess$getStoreUser$p = PrivateChannelMemberListService.access$getStoreUser$p(PrivateChannelMemberListService.this);
            m.checkNotNullExpressionValue(list, "ids");
            return Observable.i(storeUserAccess$getStoreUser$p.observeUsers(list), PrivateChannelMemberListService.access$getStorePresences$p(PrivateChannelMemberListService.this).observePresencesForUsers(list), PrivateChannelMemberListService.access$getStoreApplicationStreaming$p(PrivateChannelMemberListService.this).observeStreamsByUser(), new AnonymousClass1());
        }
    }

    public PrivateChannelMemberListService() {
        this(null, null, null, 7, null);
    }

    public PrivateChannelMemberListService(StoreUser storeUser, StoreUserPresence storeUserPresence, StoreApplicationStreaming storeApplicationStreaming) {
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeUserPresence, "storePresences");
        m.checkNotNullParameter(storeApplicationStreaming, "storeApplicationStreaming");
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
        m.checkNotNullParameter(channel, "channel");
        Observable<State> observableY = Observable.I(this.storeUser.observeMeId().Z(1).c0(5000L, TimeUnit.MILLISECONDS), Observable.B(channel.z()).G(AnonymousClass1.INSTANCE)).f0().Y(new AnonymousClass2(channel));
        m.checkNotNullExpressionValue(observableY, "Observable.merge(\n      …            }\n          }");
        return observableY;
    }

    public /* synthetic */ PrivateChannelMemberListService(StoreUser storeUser, StoreUserPresence storeUserPresence, StoreApplicationStreaming storeApplicationStreaming, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 2) != 0 ? StoreStream.INSTANCE.getPresences() : storeUserPresence, (i & 4) != 0 ? StoreStream.INSTANCE.getApplicationStreaming() : storeApplicationStreaming);
    }
}
