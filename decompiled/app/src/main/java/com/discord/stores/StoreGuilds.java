package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.guildmember.GuildMembersChunk;
import com.discord.api.guildscheduledevent.ApiGuildScheduledEventUser;
import com.discord.api.role.GuildRole;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadListMember;
import com.discord.api.thread.ThreadMemberListUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelPayload;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.collections.CollectionExtensionsKt;
import com.discord.utilities.collections.SnowflakePartitionMap;
import com.discord.utilities.guildmember.GuildMemberUtilsKt;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.g0;
import d0.t.h0;
import d0.t.n0;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: StoreGuilds.kt */
/* loaded from: classes2.dex */
public final class StoreGuilds extends StoreV2 {
    private static final int HUGE_GUILD_SIZE = 2000;
    private final Dispatcher dispatcher;
    private final Map<Long, Map<Long, GuildMember>> guildMembers;
    private final Map<Long, Map<Long, com.discord.models.member.GuildMember>> guildMembersComputed;
    private Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>> guildMembersComputedSnapshot;
    private final Map<Long, Map<Long, GuildRole>> guildRoles;
    private final Persister<Map<Long, Map<Long, GuildRole>>> guildRolesCache;
    private Map<Long, ? extends Map<Long, GuildRole>> guildRolesSnapshot;
    private final Map<Long, Guild> guilds;
    private final Persister<Map<Long, Guild>> guildsCache;
    private final Map<Long, Long> guildsJoinedAt;
    private final Persister<Map<Long, Long>> guildsJoinedAtCache;
    private Map<Long, Long> guildsJoinedAtSnapshot;
    private Map<Long, Guild> guildsSnapshot;
    private final Set<Long> guildsUnavailable;
    private Set<Long> guildsUnavailableSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreUser userStore;
    private static final Map<Long, com.discord.models.member.GuildMember> emptyComputedMap = new HashMap();
    private static final Map<Long, GuildRole> emptyRoles = new HashMap();
    private static final StoreGuilds$Companion$GuildsUpdate$1 GuildsUpdate = new StoreGuilds$Companion$GuildsUpdate$1();
    private static final StoreGuilds$Companion$ComputedMembersUpdate$1 ComputedMembersUpdate = new StoreGuilds$Companion$ComputedMembersUpdate$1();

    /* compiled from: StoreGuilds.kt */
    public static final class Actions {
        public static final Actions INSTANCE = new Actions();

        private Actions() {
        }

        public static final void requestMembers(AppComponent fragment, Observable<String> partialUserNameTokenEmitted, boolean autocomplete) {
            m.checkNotNullParameter(fragment, "fragment");
            m.checkNotNullParameter(partialUserNameTokenEmitted, "partialUserNameTokenEmitted");
            Observable observableY = partialUserNameTokenEmitted.p(1000L, TimeUnit.MILLISECONDS).G(new StoreGuilds$Actions$requestMembers$1(autocomplete)).y(StoreGuilds$Actions$requestMembers$2.INSTANCE).r().Y(StoreGuilds$Actions$requestMembers$3.INSTANCE);
            m.checkNotNullExpressionValue(observableY, "partialUserNameTokenEmit…            }\n          }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableY), fragment, null, 2, null), (Context) null, "requestGuildMembers", (Function1) null, StoreGuilds$Actions$requestMembers$4.INSTANCE, (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
        }

        public static final void requestRoleMembers(long guildId, long roleId, AppComponent appComponent, RestAPI restApi, StoreGatewayConnection storeGatewayConnection) {
            m.checkNotNullParameter(appComponent, "appComponent");
            m.checkNotNullParameter(restApi, "restApi");
            m.checkNotNullParameter(storeGatewayConnection, "storeGatewayConnection");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(restApi.getGuildRoleMemberIds(guildId, roleId)), appComponent, null, 2, null), INSTANCE.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreGuilds$Actions$requestRoleMembers$1(storeGatewayConnection, guildId), 62, (Object) null);
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$handleGuildMemberCommunicationEnabled$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuilds.access$handleGuildMemberCommunicationEnabledInternal(StoreGuilds.this, this.$guildId, this.$userId);
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$initClearCommunicationDisabledObserver$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<List<? extends com.discord.models.member.GuildMember>, Long, List<? extends com.discord.models.member.GuildMember>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ List<? extends com.discord.models.member.GuildMember> call(List<? extends com.discord.models.member.GuildMember> list, Long l) {
            return call2((List<com.discord.models.member.GuildMember>) list, l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<com.discord.models.member.GuildMember> call2(List<com.discord.models.member.GuildMember> list, Long l) {
            ArrayList arrayListA0 = a.a0(list, "members");
            for (Object obj : list) {
                if (!((com.discord.models.member.GuildMember) obj).isCommunicationDisabled()) {
                    arrayListA0.add(obj);
                }
            }
            return arrayListA0;
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$initClearCommunicationDisabledObserver$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<List<? extends com.discord.models.member.GuildMember>, Unit> {

        /* compiled from: StoreGuilds.kt */
        /* renamed from: com.discord.stores.StoreGuilds$initClearCommunicationDisabledObserver$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public final /* synthetic */ List $members;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$members = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List<com.discord.models.member.GuildMember> list = this.$members;
                m.checkNotNullExpressionValue(list, "members");
                for (com.discord.models.member.GuildMember guildMember : list) {
                    StoreGuilds.access$handleGuildMemberCommunicationEnabledInternal(StoreGuilds.this, guildMember.getGuildId(), guildMember.getUserId());
                }
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.discord.models.member.GuildMember> list) {
            invoke2((List<com.discord.models.member.GuildMember>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<com.discord.models.member.GuildMember> list) {
            StoreGuilds.access$getDispatcher$p(StoreGuilds.this).schedule(new AnonymousClass1(list));
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeCommunicationDisabledGuildMembers$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<Set<? extends Long>, Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>, List<? extends com.discord.models.member.GuildMember>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ List<? extends com.discord.models.member.GuildMember> call(Set<? extends Long> set, Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>> map) {
            return call2((Set<Long>) set, (Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<com.discord.models.member.GuildMember> call2(Set<Long> set, Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>> map) {
            ArrayList arrayList;
            Collection<com.discord.models.member.GuildMember> collectionValues;
            m.checkNotNullExpressionValue(set, "guildIds");
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                Map<Long, com.discord.models.member.GuildMember> map2 = map.get(Long.valueOf(((Number) it.next()).longValue()));
                if (map2 == null || (collectionValues = map2.values()) == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList();
                    for (Object obj : collectionValues) {
                        if (((com.discord.models.member.GuildMember) obj).isCommunicationDisabled()) {
                            arrayList.add(obj);
                        }
                    }
                }
                if (arrayList != null) {
                    arrayList2.add(arrayList);
                }
            }
            return d0.t.o.flatten(arrayList2);
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeComputed$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>> invoke2() {
            return StoreGuilds.this.getMembers();
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeComputed$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>, Map<Long, ? extends com.discord.models.member.GuildMember>> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass2(long j) {
            this.$guildId = j;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Map<Long, ? extends com.discord.models.member.GuildMember> call(Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>> map) {
            return call2((Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, com.discord.models.member.GuildMember> call2(Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>> map) {
            Map<Long, com.discord.models.member.GuildMember> map2 = map.get(Long.valueOf(this.$guildId));
            return map2 != null ? map2 : StoreGuilds.access$getEmptyComputedMap$cp();
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeComputedMember$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<com.discord.models.member.GuildMember> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ com.discord.models.member.GuildMember invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.discord.models.member.GuildMember invoke() {
            return StoreGuilds.this.getMember(this.$guildId, this.$userId);
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeFromChannelId$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Channel, Observable<? extends Guild>> {
        public AnonymousClass1() {
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends Guild> call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Guild> call2(Channel channel) {
            return channel != null ? StoreGuilds.this.observeGuild(channel.getGuildId()) : new k(null);
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeGuild$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Map<Long, ? extends Guild>, Guild> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass1(long j) {
            this.$guildId = j;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Guild call(Map<Long, ? extends Guild> map) {
            return call2((Map<Long, Guild>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Guild call2(Map<Long, Guild> map) {
            return map.get(Long.valueOf(this.$guildId));
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeGuildIds$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Map<Long, ? extends Guild>, Observable<? extends Set<? extends Long>>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends Set<? extends Long>> call(Map<Long, ? extends Guild> map) {
            return call2((Map<Long, Guild>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Set<Long>> call2(Map<Long, Guild> map) {
            return new k(map.keySet());
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeGuildMember$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>, com.discord.models.member.GuildMember> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        public AnonymousClass1(long j, long j2) {
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ com.discord.models.member.GuildMember call(Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>> map) {
            return call2((Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final com.discord.models.member.GuildMember call2(Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>> map) {
            Map<Long, com.discord.models.member.GuildMember> map2 = map.get(Long.valueOf(this.$guildId));
            if (map2 != null) {
                return map2.get(Long.valueOf(this.$userId));
            }
            return null;
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeGuildMembers$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>, Map<Long, ? extends com.discord.models.member.GuildMember>> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass1(long j) {
            this.$guildId = j;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Map<Long, ? extends com.discord.models.member.GuildMember> call(Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>> map) {
            return call2((Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, com.discord.models.member.GuildMember> call2(Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>> map) {
            Map<Long, com.discord.models.member.GuildMember> map2 = map.get(Long.valueOf(this.$guildId));
            return map2 != null ? map2 : h0.emptyMap();
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeGuilds$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<Long, ? extends Guild>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Guild> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Guild> invoke2() {
            return StoreGuilds.this.getGuilds();
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeJoinedAt$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<Long, ? extends Long>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Long> invoke2() {
            return StoreGuilds.this.getGuildsJoinedAt();
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeJoinedAt$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Map<Long, ? extends Long>, Long> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass2(long j) {
            this.$guildId = j;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Long call(Map<Long, ? extends Long> map) {
            return call2((Map<Long, Long>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Long call2(Map<Long, Long> map) {
            return Long.valueOf(GuildMemberUtilsKt.getJoinedAtOrNow(map.get(Long.valueOf(this.$guildId))));
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeRoles$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<Long, ? extends Map<Long, ? extends GuildRole>>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Map<Long, ? extends GuildRole>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Map<Long, ? extends GuildRole>> invoke2() {
            return StoreGuilds.this.getRoles();
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeRoles$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Map<Long, ? extends Map<Long, ? extends GuildRole>>, Map<Long, ? extends GuildRole>> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass2(long j) {
            this.$guildId = j;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Map<Long, ? extends GuildRole> call(Map<Long, ? extends Map<Long, ? extends GuildRole>> map) {
            return call2((Map<Long, ? extends Map<Long, GuildRole>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, GuildRole> call2(Map<Long, ? extends Map<Long, GuildRole>> map) {
            Map<Long, GuildRole> map2 = map.get(Long.valueOf(this.$guildId));
            return map2 != null ? map2 : StoreGuilds.access$getEmptyRoles$cp();
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeSortedRoles$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Map<Long, ? extends GuildRole>, Observable<? extends List<? extends GuildRole>>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends List<? extends GuildRole>> call(Map<Long, ? extends GuildRole> map) {
            return call2((Map<Long, GuildRole>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends List<GuildRole>> call2(Map<Long, GuildRole> map) {
            return new k(u.sortedWith(map.values(), RoleUtils.getROLE_COMPARATOR()));
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeUnavailableGuilds$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Set<? extends Long>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Set<? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Set<? extends Long> invoke2() {
            return StoreGuilds.this.getUnavailableGuilds();
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeVerificationLevel$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Guild, GuildVerificationLevel> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ GuildVerificationLevel call(Guild guild) {
            return call2(guild);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final GuildVerificationLevel call2(Guild guild) {
            GuildVerificationLevel verificationLevel;
            return (guild == null || (verificationLevel = guild.getVerificationLevel()) == null) ? GuildVerificationLevel.NONE : verificationLevel;
        }
    }

    public /* synthetic */ StoreGuilds(StoreUser storeUser, Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeUser, dispatcher, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuilds storeGuilds) {
        return storeGuilds.dispatcher;
    }

    public static final /* synthetic */ Map access$getEmptyComputedMap$cp() {
        return emptyComputedMap;
    }

    public static final /* synthetic */ Map access$getEmptyRoles$cp() {
        return emptyRoles;
    }

    public static final /* synthetic */ void access$handleGuildMemberCommunicationEnabledInternal(StoreGuilds storeGuilds, long j, long j2) {
        storeGuilds.handleGuildMemberCommunicationEnabledInternal(j, j2);
    }

    private final long getMeId() {
        return this.userStore.getMe().getId();
    }

    @StoreThread
    private final void handleGuild(com.discord.api.guild.Guild guild, boolean remove) {
        long id2 = guild.getId();
        if (remove) {
            if (this.guilds.containsKey(Long.valueOf(id2))) {
                this.guilds.remove(Long.valueOf(id2));
                markChanged(GuildsUpdate);
                return;
            }
            return;
        }
        Guild guild2 = this.guilds.get(Long.valueOf(id2));
        if (guild2 == null) {
            guild2 = new Guild(null, null, null, null, null, 0, 0L, null, 0L, null, null, null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, false, null, -1, 3, null);
        }
        Guild guildMerge = guild2.merge(guild);
        if (!m.areEqual(guildMerge, this.guilds.get(Long.valueOf(id2)))) {
            this.guilds.put(Long.valueOf(id2), guildMerge);
            markChanged(GuildsUpdate);
        }
    }

    public static /* synthetic */ void handleGuildMember$default(StoreGuilds storeGuilds, GuildMember guildMember, long j, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        storeGuilds.handleGuildMember(guildMember, j, z2);
    }

    @StoreThread
    private final void handleGuildMemberCommunicationEnabledInternal(long guildId, long userId) {
        Map<Long, GuildMember> map = this.guildMembers.get(Long.valueOf(guildId));
        GuildMember guildMember = map != null ? map.get(Long.valueOf(userId)) : null;
        if ((guildMember != null ? guildMember.getCommunicationDisabledUntil() : null) == null) {
            return;
        }
        GuildMember guildMemberA = GuildMember.a(guildMember, 0L, null, null, null, null, null, false, null, null, null, null, null, null, 4095);
        handleGuildMember$default(this, guildMemberA, guildId, false, 4, null);
        if (userId == getMeId()) {
            StoreStream.INSTANCE.getPermissions().handleGuildMemberAdd(guildMemberA);
        }
    }

    @StoreThread
    private final void handleGuildMembers(long guildId, long removedGuildMemberUserId, Collection<GuildMember> members, boolean remove) {
        if (!remove) {
            if (members != null) {
                Iterator<T> it = members.iterator();
                while (it.hasNext()) {
                    handleGuildMember$default(this, (GuildMember) it.next(), guildId, false, 4, null);
                }
                return;
            }
            return;
        }
        if (removedGuildMemberUserId <= 0) {
            if (this.guildMembers.remove(Long.valueOf(guildId)) != null) {
                markChanged(GuildsUpdate);
            }
            if (this.guildMembersComputed.remove(Long.valueOf(guildId)) != null) {
                markChanged(ComputedMembersUpdate);
                return;
            }
            return;
        }
        Map<Long, GuildMember> map = this.guildMembers.get(Long.valueOf(guildId));
        if ((map != null ? map.remove(Long.valueOf(removedGuildMemberUserId)) : null) != null) {
            markChanged(GuildsUpdate);
        }
        Map<Long, com.discord.models.member.GuildMember> map2 = this.guildMembersComputed.get(Long.valueOf(guildId));
        if ((map2 != null ? map2.remove(Long.valueOf(removedGuildMemberUserId)) : null) != null) {
            markChanged(ComputedMembersUpdate);
        }
    }

    @StoreThread
    private final void handleGuildMembersMap(long guildId, Map<Long, GuildMember> members) {
        handleGuildMembers(guildId, 0L, members != null ? members.values() : null, false);
    }

    @StoreThread
    private final void handleGuildRoles(long guildId, long deletedRoleId, List<GuildRole> roles, boolean remove) {
        if (remove) {
            if (deletedRoleId > 0) {
                Map<Long, GuildRole> map = this.guildRoles.get(Long.valueOf(guildId));
                if ((map != null ? map.remove(Long.valueOf(deletedRoleId)) : null) != null) {
                    markChanged(GuildsUpdate);
                    return;
                }
                return;
            }
            if (this.guildRoles.containsKey(Long.valueOf(guildId))) {
                this.guildRoles.remove(Long.valueOf(guildId));
                markChanged(GuildsUpdate);
                return;
            }
            return;
        }
        Map<Long, Map<Long, GuildRole>> map2 = this.guildRoles;
        Long lValueOf = Long.valueOf(guildId);
        Map<Long, GuildRole> map3 = map2.get(lValueOf);
        if (map3 == null) {
            map3 = new HashMap<>();
            map2.put(lValueOf, map3);
        }
        Map<Long, GuildRole> map4 = map3;
        if (roles != null) {
            for (GuildRole guildRole : roles) {
                if (!m.areEqual(map4.get(Long.valueOf(guildRole.getId())), guildRole)) {
                    map4.put(Long.valueOf(guildRole.getId()), guildRole);
                    markChanged(GuildsUpdate);
                }
            }
        }
    }

    @StoreThread
    private final void handleGuildUnavailable(long guildId, boolean unavailable, boolean remove) {
        if (remove) {
            if (!unavailable || this.guildsUnavailable.contains(Long.valueOf(guildId))) {
                return;
            }
            this.guildsUnavailable.add(Long.valueOf(guildId));
            markChanged(GuildsUpdate);
            return;
        }
        if (unavailable || !this.guildsUnavailable.contains(Long.valueOf(guildId))) {
            return;
        }
        this.guildsUnavailable.remove(Long.valueOf(guildId));
        markChanged(GuildsUpdate);
    }

    @StoreThread
    private final void handleHasRoleAndJoinedAt(long guildId, Map<Long, GuildMember> members) {
        GuildMember guildMember;
        Long l;
        MeUser meInternal$app_productionGoogleRelease = this.userStore.getMe();
        if (members == null || (guildMember = members.get(Long.valueOf(meInternal$app_productionGoogleRelease.getId()))) == null) {
            return;
        }
        UtcDateTime joinedAt = guildMember.getJoinedAt();
        long dateTimeMillis = joinedAt != null ? joinedAt.getDateTimeMillis() : 0L;
        if (this.guildsJoinedAt.containsKey(Long.valueOf(guildId)) && (l = this.guildsJoinedAt.get(Long.valueOf(guildId))) != null && l.longValue() == dateTimeMillis) {
            return;
        }
        this.guildsJoinedAt.put(Long.valueOf(guildId), Long.valueOf(dateTimeMillis));
        markChanged(GuildsUpdate);
    }

    private final void initClearCommunicationDisabledObserver(Context ctx) {
        Observable observableR = Observable.j(observeCommunicationDisabledGuildMembers(), Observable.E(0L, 10L, TimeUnit.SECONDS), AnonymousClass1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(observableR), StoreGuilds.class, ctx, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 60, (Object) null);
    }

    public final Guild getGuild(long guildId) {
        return this.guildsSnapshot.get(Long.valueOf(guildId));
    }

    @StoreThread
    public final Map<Long, Map<Long, com.discord.models.member.GuildMember>> getGuildMembersComputedInternal$app_productionGoogleRelease() {
        return this.guildMembersComputed;
    }

    @StoreThread
    public final Map<Long, Map<Long, GuildRole>> getGuildRolesInternal$app_productionGoogleRelease() {
        return this.guildRoles;
    }

    public final Map<Long, Guild> getGuilds() {
        return this.guildsSnapshot;
    }

    @StoreThread
    public final Map<Long, Guild> getGuildsInternal$app_productionGoogleRelease() {
        return this.guilds;
    }

    public final Map<Long, Long> getGuildsJoinedAt() {
        return this.guildsJoinedAtSnapshot;
    }

    @StoreThread
    public final Map<Long, Long> getGuildsJoinedAtInternal$app_productionGoogleRelease() {
        return this.guildsJoinedAt;
    }

    public final com.discord.models.member.GuildMember getMember(long guildId, long userId) {
        Map<Long, com.discord.models.member.GuildMember> map = this.guildMembersComputedSnapshot.get(Long.valueOf(guildId));
        if (map != null) {
            return map.get(Long.valueOf(userId));
        }
        return null;
    }

    public final Map<Long, Map<Long, com.discord.models.member.GuildMember>> getMembers() {
        return this.guildMembersComputedSnapshot;
    }

    public final Map<Long, Map<Long, GuildRole>> getRoles() {
        return this.guildRolesSnapshot;
    }

    public final Set<Long> getUnavailableGuilds() {
        return this.guildsUnavailableSnapshot;
    }

    @StoreThread
    public final Set<Long> getUnavailableGuildsInternal$app_productionGoogleRelease() {
        return this.guildsUnavailable;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        Map<Long, GuildMember> mapEmptyMap;
        m.checkNotNullParameter(payload, "payload");
        this.guilds.clear();
        this.guildMembers.clear();
        this.guildMembersComputed.clear();
        this.guildRoles.clear();
        this.guildsUnavailable.clear();
        for (com.discord.api.guild.Guild guild : payload.getGuilds()) {
            long id2 = guild.getId();
            if (guild.getUnavailable()) {
                this.guildsUnavailable.add(Long.valueOf(id2));
            } else {
                handleGuildRoles(id2, 0L, guild.G(), false);
                m.checkNotNullExpressionValue(guild, "guild");
                handleGuild(guild, false);
                List<GuildMember> listV = guild.v();
                if (listV == null || (mapEmptyMap = GuildUtilsKt.asMap(listV)) == null) {
                    mapEmptyMap = h0.emptyMap();
                }
                handleGuildMembersMap(id2, mapEmptyMap);
                handleHasRoleAndJoinedAt(id2, mapEmptyMap);
            }
        }
        markChanged(GuildsUpdate, ComputedMembersUpdate);
    }

    @StoreThread
    public final void handleGuildAdd(com.discord.api.guild.Guild guild) {
        Map<Long, GuildMember> mapEmptyMap;
        m.checkNotNullParameter(guild, "guild");
        handleGuildUnavailable(guild.getId(), guild.getUnavailable(), false);
        if (guild.getUnavailable()) {
            return;
        }
        handleGuildRoles(guild.getId(), 0L, guild.G(), false);
        handleGuild(guild, false);
        List<GuildMember> listV = guild.v();
        if (listV == null || (mapEmptyMap = GuildUtilsKt.asMap(listV)) == null) {
            mapEmptyMap = h0.emptyMap();
        }
        handleGuildMembersMap(guild.getId(), mapEmptyMap);
        handleHasRoleAndJoinedAt(guild.getId(), mapEmptyMap);
    }

    @StoreThread
    public final void handleGuildMember(GuildMember member, long guildId, boolean isFullGuildMember) {
        GuildMember guildMemberA = member;
        m.checkNotNullParameter(guildMemberA, "member");
        long id2 = member.getUser().getId();
        if (!this.guildMembers.containsKey(Long.valueOf(guildId))) {
            this.guildMembers.put(Long.valueOf(guildId), new HashMap());
        }
        if (!this.guildMembersComputed.containsKey(Long.valueOf(guildId))) {
            this.guildMembersComputed.put(Long.valueOf(guildId), new HashMap());
        }
        Map<Long, GuildMember> map = this.guildMembers.get(Long.valueOf(guildId));
        m.checkNotNull(map);
        GuildMember guildMember = map.get(Long.valueOf(id2));
        if (!isFullGuildMember && guildMember != null) {
            guildMemberA = GuildMember.a(member, 0L, null, null, null, null, null, false, null, null, null, guildMember.getBio(), guildMember.getBanner(), null, 5119);
        }
        GuildMember guildMember2 = guildMemberA;
        if (!m.areEqual(guildMember2, guildMember)) {
            Map<Long, GuildMember> map2 = this.guildMembers.get(Long.valueOf(guildId));
            m.checkNotNull(map2);
            map2.put(Long.valueOf(id2), guildMember2);
        }
        com.discord.models.member.GuildMember guildMemberFrom$default = GuildMember.Companion.from$default(com.discord.models.member.GuildMember.INSTANCE, guildMember2, guildId, this.guildRoles.get(Long.valueOf(guildId)), null, 8, null);
        m.checkNotNull(this.guildMembersComputed.get(Long.valueOf(guildId)));
        if (!m.areEqual(guildMemberFrom$default, r3.get(Long.valueOf(id2)))) {
            Map<Long, com.discord.models.member.GuildMember> map3 = this.guildMembersComputed.get(Long.valueOf(guildId));
            m.checkNotNull(map3);
            map3.put(Long.valueOf(id2), guildMemberFrom$default);
            markChanged(ComputedMembersUpdate);
        }
    }

    @StoreThread
    public final void handleGuildMemberAdd(com.discord.api.guildmember.GuildMember member) {
        m.checkNotNullParameter(member, "member");
        handleGuildMember$default(this, member, member.getGuildId(), false, 4, null);
    }

    public final void handleGuildMemberCommunicationEnabled(long guildId, long userId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, userId));
    }

    @StoreThread
    public final void handleGuildMemberRemove(long guildId, long userId) {
        handleGuildMembers(guildId, userId, null, true);
    }

    @StoreThread
    public final void handleGuildMembersChunk(GuildMembersChunk chunk) {
        m.checkNotNullParameter(chunk, "chunk");
        handleGuildMembers(chunk.getGuildId(), 0L, chunk.b(), false);
    }

    @StoreThread
    public final void handleGuildRemove(com.discord.api.guild.Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        handleGuildUnavailable(guild.getId(), guild.getUnavailable(), true);
        handleGuild(guild, true);
        handleGuildRoles(guild.getId(), 0L, null, true);
        handleGuildMembers(guild.getId(), 0L, null, true);
    }

    @StoreThread
    public final void handleGuildRoleCreateOrUpdate(long guildId, GuildRole role) {
        m.checkNotNullParameter(role, "role");
        handleGuildRoles(guildId, 0L, d0.t.m.listOf(role), false);
        handleGuildMembersMap(guildId, this.guildMembers.get(Long.valueOf(guildId)));
        handleHasRoleAndJoinedAt(guildId, this.guildMembers.get(Long.valueOf(guildId)));
    }

    @StoreThread
    public final void handleGuildRoleRemove(long roleId, long guildId) {
        handleGuildRoles(guildId, roleId, null, true);
        handleGuildMembersMap(guildId, this.guildMembers.get(Long.valueOf(guildId)));
        handleHasRoleAndJoinedAt(guildId, this.guildMembers.get(Long.valueOf(guildId)));
    }

    @StoreThread
    public final void handleGuildScheduledEventUsersFetch(List<ApiGuildScheduledEventUser> apiGuildScheduledEventUsers, long guildId) {
        m.checkNotNullParameter(apiGuildScheduledEventUsers, "apiGuildScheduledEventUsers");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = apiGuildScheduledEventUsers.iterator();
        while (it.hasNext()) {
            com.discord.api.guildmember.GuildMember guildMemberA = ((ApiGuildScheduledEventUser) it.next()).a(guildId);
            if (guildMemberA != null) {
                arrayList.add(guildMemberA);
            }
        }
        handleGuildMembers(guildId, 0L, arrayList, false);
    }

    @StoreThread
    public final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        ArrayList arrayList;
        m.checkNotNullParameter(threadMemberListUpdate, "threadMemberListUpdate");
        long jA = threadMemberListUpdate.getGuildId();
        List<ThreadListMember> listB = threadMemberListUpdate.b();
        if (listB != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                com.discord.api.guildmember.GuildMember guildMemberA = ((ThreadListMember) it.next()).getMember();
                if (guildMemberA != null) {
                    arrayList2.add(guildMemberA);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        handleGuildMembers(jA, 0L, arrayList, false);
    }

    @StoreThread
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        ArrayList arrayList;
        m.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        long jB = threadMembersUpdate.getGuildId();
        List<AugmentedThreadMember> listA = threadMembersUpdate.a();
        if (listA != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                com.discord.api.guildmember.GuildMember guildMemberC = ((AugmentedThreadMember) it.next()).getMember();
                if (guildMemberC != null) {
                    arrayList2.add(guildMemberC);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        handleGuildMembers(jB, 0L, arrayList, false);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        this.guilds.putAll(CollectionExtensionsKt.filterNonNullValues(this.guildsCache.get()));
        Map<Long, Map<Long, GuildRole>> map = this.guildRolesCache.get();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<Long, Map<Long, GuildRole>>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Long, Map<Long, GuildRole>> next = it.next();
            if (next.getKey() != null) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            this.guildRoles.put(Long.valueOf(((Number) entry.getKey()).longValue()), h0.toMutableMap((Map) entry.getValue()));
        }
        this.guildsJoinedAt.putAll(this.guildsJoinedAtCache.get());
        markChanged(GuildsUpdate, ComputedMembersUpdate);
        initClearCommunicationDisabledObserver(context);
    }

    public final Observable<List<com.discord.models.member.GuildMember>> observeCommunicationDisabledGuildMembers() {
        Observable<List<com.discord.models.member.GuildMember>> observableR = Observable.j(observeGuildIds(), observeComputed(), AnonymousClass1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Map<Long, com.discord.models.member.GuildMember>>> observeComputed() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{ComputedMembersUpdate}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<com.discord.models.member.GuildMember> observeComputedMember(long guildId, long userId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{ComputedMembersUpdate}, false, null, null, new AnonymousClass1(guildId, userId), 14, null);
    }

    public final Observable<Guild> observeFromChannelId(long channelId) {
        Observable observableY = StoreStream.INSTANCE.getChannels().observeChannel(channelId).Y(new AnonymousClass1());
        m.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…ll)\n          }\n        }");
        return observableY;
    }

    public final Observable<Guild> observeGuild(long guildId) {
        Observable<Guild> observableR = observeGuilds().G(new AnonymousClass1(guildId)).r();
        m.checkNotNullExpressionValue(observableR, "observeGuilds()\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Set<Long>> observeGuildIds() {
        Observable<Set<Long>> observableR = observeGuilds().Y(AnonymousClass1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "observeGuilds()\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<com.discord.models.member.GuildMember> observeGuildMember(long guildId, long userId) {
        return observeComputed().G(new AnonymousClass1(guildId, userId)).r();
    }

    public final Observable<Map<Long, com.discord.models.member.GuildMember>> observeGuildMembers(long guildId) {
        return observeComputed().G(new AnonymousClass1(guildId)).r();
    }

    public final Observable<Map<Long, Guild>> observeGuilds() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{GuildsUpdate}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Map<Long, Long>> observeJoinedAt() {
        Observable<Map<Long, Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{GuildsUpdate}, false, null, null, new AnonymousClass1(), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Map<Long, GuildRole>>> observeRoles() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{GuildsUpdate}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<List<GuildRole>> observeSortedRoles(long guildId) {
        Observable<List<GuildRole>> observableR = observeRoles(guildId).Y(AnonymousClass1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "observeRoles(guildId)\n  …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Set<Long>> observeUnavailableGuilds() {
        Observable<Set<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{GuildsUpdate}, false, null, null, new AnonymousClass1(), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<GuildVerificationLevel> observeVerificationLevel(long guildId) {
        Observable<GuildVerificationLevel> observableR = observeGuild(guildId).G(AnonymousClass1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "observeGuild(guildId)\n  …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        SnowflakePartitionMap.CopiablePartitionMap copiablePartitionMap;
        super.snapshotData();
        if (getUpdateSources().contains(GuildsUpdate)) {
            HashMap map = new HashMap(this.guildsJoinedAt);
            this.guildsJoinedAtSnapshot = map;
            Persister.set$default(this.guildsJoinedAtCache, map, false, 2, null);
            this.guildsSnapshot = new HashMap(this.guilds);
            Persister.set$default(this.guildsCache, h0.minus((Map) this.guilds, (Iterable) StoreStream.INSTANCE.getLurking().getLurkingGuildIdsSync()), false, 2, null);
            this.guildsUnavailableSnapshot = new HashSet(this.guildsUnavailable);
            Map<Long, Map<Long, GuildRole>> map2 = this.guildRoles;
            LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(map2.size()));
            Iterator<T> it = map2.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), new HashMap((Map) entry.getValue()));
            }
            this.guildRolesSnapshot = linkedHashMap;
            Persister.set$default(this.guildRolesCache, linkedHashMap, false, 2, null);
        }
        if (getUpdateSources().contains(ComputedMembersUpdate)) {
            HashMap map3 = new HashMap();
            for (Map.Entry<Long, Map<Long, com.discord.models.member.GuildMember>> entry2 : this.guildMembersComputed.entrySet()) {
                Map<Long, com.discord.models.member.GuildMember> value = entry2.getValue();
                if (value.size() < 2000) {
                    map3.put(entry2.getKey(), new HashMap(value));
                } else {
                    if (value instanceof SnowflakePartitionMap.CopiablePartitionMap) {
                        copiablePartitionMap = (SnowflakePartitionMap.CopiablePartitionMap) value;
                    } else {
                        SnowflakePartitionMap.CopiablePartitionMap copiablePartitionMap2 = new SnowflakePartitionMap.CopiablePartitionMap(0, 1, null);
                        copiablePartitionMap2.putAll(value);
                        entry2.setValue(copiablePartitionMap2);
                        copiablePartitionMap = copiablePartitionMap2;
                    }
                    map3.put(entry2.getKey(), copiablePartitionMap.fastCopy());
                }
            }
            this.guildMembersComputedSnapshot = map3;
        }
    }

    public StoreGuilds(StoreUser storeUser, Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.userStore = storeUser;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildsSnapshot = h0.emptyMap();
        this.guildMembersComputedSnapshot = h0.emptyMap();
        this.guildRolesSnapshot = h0.emptyMap();
        this.guildsUnavailableSnapshot = n0.emptySet();
        this.guildsJoinedAtSnapshot = h0.emptyMap();
        this.guilds = new HashMap();
        this.guildMembersComputed = new HashMap();
        this.guildMembers = new HashMap();
        this.guildRoles = new HashMap();
        this.guildsUnavailable = new HashSet();
        this.guildsJoinedAt = new HashMap();
        this.guildsCache = new Persister<>("STORE_GUILDS_V34", new HashMap());
        this.guildRolesCache = new Persister<>("STORE_GUILD_ROLES_V7", new HashMap());
        this.guildsJoinedAtCache = new Persister<>("STORE_GUILD_JOINED_AT_V6", new HashMap());
    }

    public final Observable<Map<Long, com.discord.models.member.GuildMember>> observeComputed(long guildId) {
        Observable<Map<Long, com.discord.models.member.GuildMember>> observableR = observeComputed().G(new AnonymousClass2(guildId)).r();
        m.checkNotNullExpressionValue(observableR, "observeComputed()\n      …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, GuildRole>> observeRoles(long guildId) {
        Observable<Map<Long, GuildRole>> observableR = observeRoles().G(new AnonymousClass2(guildId)).r();
        m.checkNotNullExpressionValue(observableR, "observeRoles()\n        .…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Long> observeJoinedAt(long guildId) {
        Observable<Long> observableR = observeJoinedAt().G(new AnonymousClass2(guildId)).r();
        m.checkNotNullExpressionValue(observableR, "observeJoinedAt()\n      …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, com.discord.models.member.GuildMember>> observeComputed(long guildId, Collection<Long> userIds) {
        m.checkNotNullParameter(userIds, "userIds");
        Observable observableK = observeComputed(guildId).k(b.a.d.o.a(userIds));
        m.checkNotNullExpressionValue(observableK, "observeComputed(guildId)…mpose(filterMap(userIds))");
        return observableK;
    }

    public final Observable<Map<Long, GuildRole>> observeRoles(long guildId, Collection<Long> roleIds) {
        m.checkNotNullParameter(roleIds, "roleIds");
        Observable observableK = observeRoles(guildId).k(b.a.d.o.a(roleIds));
        m.checkNotNullExpressionValue(observableK, "observeRoles(guildId)\n  …mpose(filterMap(roleIds))");
        return observableK;
    }
}
