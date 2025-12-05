package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
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
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.collections.CollectionExtensions;
import com.discord.utilities.collections.SnowflakePartitionMap;
import com.discord.utilities.guildmember.GuildMemberUtils;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
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
import p007b.p008a.p018d.C0879o;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p580t.Sets5;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func2;

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
    private static final StoreGuilds8 GuildsUpdate = new StoreGuilds8();
    private static final StoreGuilds7 ComputedMembersUpdate = new StoreGuilds7();

    /* compiled from: StoreGuilds.kt */
    public static final class Actions {
        public static final Actions INSTANCE = new Actions();

        private Actions() {
        }

        public static final void requestMembers(AppComponent fragment, Observable<String> partialUserNameTokenEmitted, boolean autocomplete) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(partialUserNameTokenEmitted, "partialUserNameTokenEmitted");
            Observable observableM11099Y = partialUserNameTokenEmitted.m11110p(1000L, TimeUnit.MILLISECONDS).m11083G(new StoreGuilds2(autocomplete)).m11118y(StoreGuilds3.INSTANCE).m11112r().m11099Y(StoreGuilds4.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "partialUserNameTokenEmit…            }\n          }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11099Y), fragment, null, 2, null), (Context) null, "requestGuildMembers", (Function1) null, StoreGuilds5.INSTANCE, (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
        }

        public static final void requestRoleMembers(long guildId, long roleId, AppComponent appComponent, RestAPI restApi, StoreGatewayConnection storeGatewayConnection) {
            Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
            Intrinsics3.checkNotNullParameter(restApi, "restApi");
            Intrinsics3.checkNotNullParameter(storeGatewayConnection, "storeGatewayConnection");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(restApi.getGuildRoleMemberIds(guildId, roleId)), appComponent, null, 2, null), INSTANCE.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreGuilds6(storeGatewayConnection, guildId), 62, (Object) null);
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$handleGuildMemberCommunicationEnabled$1 */
    public static final class C60951 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60951(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuilds.access$handleGuildMemberCommunicationEnabledInternal(StoreGuilds.this, this.$guildId, this.$userId);
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$initClearCommunicationDisabledObserver$1 */
    public static final class C60961<T1, T2, R> implements Func2<List<? extends com.discord.models.member.GuildMember>, Long, List<? extends com.discord.models.member.GuildMember>> {
        public static final C60961 INSTANCE = new C60961();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ List<? extends com.discord.models.member.GuildMember> call(List<? extends com.discord.models.member.GuildMember> list, Long l) {
            return call2((List<com.discord.models.member.GuildMember>) list, l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<com.discord.models.member.GuildMember> call2(List<com.discord.models.member.GuildMember> list, Long l) {
            ArrayList arrayListM840a0 = outline.m840a0(list, "members");
            for (Object obj : list) {
                if (!((com.discord.models.member.GuildMember) obj).isCommunicationDisabled()) {
                    arrayListM840a0.add(obj);
                }
            }
            return arrayListM840a0;
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$initClearCommunicationDisabledObserver$2 */
    public static final class C60972 extends Lambda implements Function1<List<? extends com.discord.models.member.GuildMember>, Unit> {

        /* compiled from: StoreGuilds.kt */
        /* renamed from: com.discord.stores.StoreGuilds$initClearCommunicationDisabledObserver$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $members;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$members = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List<com.discord.models.member.GuildMember> list = this.$members;
                Intrinsics3.checkNotNullExpressionValue(list, "members");
                for (com.discord.models.member.GuildMember guildMember : list) {
                    StoreGuilds.access$handleGuildMemberCommunicationEnabledInternal(StoreGuilds.this, guildMember.getGuildId(), guildMember.getUserId());
                }
            }
        }

        public C60972() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.discord.models.member.GuildMember> list) {
            invoke2((List<com.discord.models.member.GuildMember>) list);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<com.discord.models.member.GuildMember> list) {
            StoreGuilds.access$getDispatcher$p(StoreGuilds.this).schedule(new AnonymousClass1(list));
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeCommunicationDisabledGuildMembers$1 */
    public static final class C60981<T1, T2, R> implements Func2<Set<? extends Long>, Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>, List<? extends com.discord.models.member.GuildMember>> {
        public static final C60981 INSTANCE = new C60981();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ List<? extends com.discord.models.member.GuildMember> call(Set<? extends Long> set, Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>> map) {
            return call2((Set<Long>) set, (Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<com.discord.models.member.GuildMember> call2(Set<Long> set, Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>> map) {
            ArrayList arrayList;
            Collection<com.discord.models.member.GuildMember> collectionValues;
            Intrinsics3.checkNotNullExpressionValue(set, "guildIds");
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
            return Iterables2.flatten(arrayList2);
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeComputed$1 */
    public static final class C60991 extends Lambda implements Function0<Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>> {
        public C60991() {
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
    /* renamed from: com.discord.stores.StoreGuilds$observeComputed$2 */
    public static final class C61002<T, R> implements Func1<Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>, Map<Long, ? extends com.discord.models.member.GuildMember>> {
        public final /* synthetic */ long $guildId;

        public C61002(long j) {
            this.$guildId = j;
        }

        @Override // p637j0.p641k.Func1
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
    /* renamed from: com.discord.stores.StoreGuilds$observeComputedMember$1 */
    public static final class C61011 extends Lambda implements Function0<com.discord.models.member.GuildMember> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61011(long j, long j2) {
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
    /* renamed from: com.discord.stores.StoreGuilds$observeFromChannelId$1 */
    public static final class C61021<T, R> implements Func1<Channel, Observable<? extends Guild>> {
        public C61021() {
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Guild> call(Channel channel) {
            return call2(channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Guild> call2(Channel channel) {
            return channel != null ? StoreGuilds.this.observeGuild(channel.getGuildId()) : new ScalarSynchronousObservable(null);
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeGuild$1 */
    public static final class C61031<T, R> implements Func1<Map<Long, ? extends Guild>, Guild> {
        public final /* synthetic */ long $guildId;

        public C61031(long j) {
            this.$guildId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Guild call(Map<Long, ? extends Guild> map) {
            return call2((Map<Long, Guild>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Guild call2(Map<Long, Guild> map) {
            return map.get(Long.valueOf(this.$guildId));
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeGuildIds$1 */
    public static final class C61041<T, R> implements Func1<Map<Long, ? extends Guild>, Observable<? extends Set<? extends Long>>> {
        public static final C61041 INSTANCE = new C61041();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Set<? extends Long>> call(Map<Long, ? extends Guild> map) {
            return call2((Map<Long, Guild>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Set<Long>> call2(Map<Long, Guild> map) {
            return new ScalarSynchronousObservable(map.keySet());
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeGuildMember$1 */
    public static final class C61051<T, R> implements Func1<Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>, com.discord.models.member.GuildMember> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        public C61051(long j, long j2) {
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // p637j0.p641k.Func1
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
    /* renamed from: com.discord.stores.StoreGuilds$observeGuildMembers$1 */
    public static final class C61061<T, R> implements Func1<Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>, Map<Long, ? extends com.discord.models.member.GuildMember>> {
        public final /* synthetic */ long $guildId;

        public C61061(long j) {
            this.$guildId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends com.discord.models.member.GuildMember> call(Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>> map) {
            return call2((Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, com.discord.models.member.GuildMember> call2(Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>> map) {
            Map<Long, com.discord.models.member.GuildMember> map2 = map.get(Long.valueOf(this.$guildId));
            return map2 != null ? map2 : Maps6.emptyMap();
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeGuilds$1 */
    public static final class C61071 extends Lambda implements Function0<Map<Long, ? extends Guild>> {
        public C61071() {
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
    /* renamed from: com.discord.stores.StoreGuilds$observeJoinedAt$1 */
    public static final class C61081 extends Lambda implements Function0<Map<Long, ? extends Long>> {
        public C61081() {
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
    /* renamed from: com.discord.stores.StoreGuilds$observeJoinedAt$2 */
    public static final class C61092<T, R> implements Func1<Map<Long, ? extends Long>, Long> {
        public final /* synthetic */ long $guildId;

        public C61092(long j) {
            this.$guildId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Long call(Map<Long, ? extends Long> map) {
            return call2((Map<Long, Long>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Long call2(Map<Long, Long> map) {
            return Long.valueOf(GuildMemberUtils.getJoinedAtOrNow(map.get(Long.valueOf(this.$guildId))));
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeRoles$1 */
    public static final class C61101 extends Lambda implements Function0<Map<Long, ? extends Map<Long, ? extends GuildRole>>> {
        public C61101() {
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
    /* renamed from: com.discord.stores.StoreGuilds$observeRoles$2 */
    public static final class C61112<T, R> implements Func1<Map<Long, ? extends Map<Long, ? extends GuildRole>>, Map<Long, ? extends GuildRole>> {
        public final /* synthetic */ long $guildId;

        public C61112(long j) {
            this.$guildId = j;
        }

        @Override // p637j0.p641k.Func1
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
    /* renamed from: com.discord.stores.StoreGuilds$observeSortedRoles$1 */
    public static final class C61121<T, R> implements Func1<Map<Long, ? extends GuildRole>, Observable<? extends List<? extends GuildRole>>> {
        public static final C61121 INSTANCE = new C61121();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends List<? extends GuildRole>> call(Map<Long, ? extends GuildRole> map) {
            return call2((Map<Long, GuildRole>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends List<GuildRole>> call2(Map<Long, GuildRole> map) {
            return new ScalarSynchronousObservable(_Collections.sortedWith(map.values(), RoleUtils.getROLE_COMPARATOR()));
        }
    }

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$observeUnavailableGuilds$1 */
    public static final class C61131 extends Lambda implements Function0<Set<? extends Long>> {
        public C61131() {
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
    /* renamed from: com.discord.stores.StoreGuilds$observeVerificationLevel$1 */
    public static final class C61141<T, R> implements Func1<Guild, GuildVerificationLevel> {
        public static final C61141 INSTANCE = new C61141();

        @Override // p637j0.p641k.Func1
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
        this(storeUser, dispatcher, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck);
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

    @Store3
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
        if (!Intrinsics3.areEqual(guildMerge, this.guilds.get(Long.valueOf(id2)))) {
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

    @Store3
    private final void handleGuildMemberCommunicationEnabledInternal(long guildId, long userId) {
        Map<Long, GuildMember> map = this.guildMembers.get(Long.valueOf(guildId));
        GuildMember guildMember = map != null ? map.get(Long.valueOf(userId)) : null;
        if ((guildMember != null ? guildMember.getCommunicationDisabledUntil() : null) == null) {
            return;
        }
        GuildMember guildMemberM7915a = GuildMember.m7915a(guildMember, 0L, null, null, null, null, null, false, null, null, null, null, null, null, 4095);
        handleGuildMember$default(this, guildMemberM7915a, guildId, false, 4, null);
        if (userId == getMeId()) {
            StoreStream.INSTANCE.getPermissions().handleGuildMemberAdd(guildMemberM7915a);
        }
    }

    @Store3
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

    @Store3
    private final void handleGuildMembersMap(long guildId, Map<Long, GuildMember> members) {
        handleGuildMembers(guildId, 0L, members != null ? members.values() : null, false);
    }

    @Store3
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
                if (!Intrinsics3.areEqual(map4.get(Long.valueOf(guildRole.getId())), guildRole)) {
                    map4.put(Long.valueOf(guildRole.getId()), guildRole);
                    markChanged(GuildsUpdate);
                }
            }
        }
    }

    @Store3
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

    @Store3
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
        Observable observableM11112r = Observable.m11076j(observeCommunicationDisabledGuildMembers(), Observable.m11061E(0L, 10L, TimeUnit.SECONDS), C60961.INSTANCE).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(observableM11112r), StoreGuilds.class, ctx, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C60972(), 60, (Object) null);
    }

    public final Guild getGuild(long guildId) {
        return this.guildsSnapshot.get(Long.valueOf(guildId));
    }

    @Store3
    public final Map<Long, Map<Long, com.discord.models.member.GuildMember>> getGuildMembersComputedInternal$app_productionGoogleRelease() {
        return this.guildMembersComputed;
    }

    @Store3
    public final Map<Long, Map<Long, GuildRole>> getGuildRolesInternal$app_productionGoogleRelease() {
        return this.guildRoles;
    }

    public final Map<Long, Guild> getGuilds() {
        return this.guildsSnapshot;
    }

    @Store3
    public final Map<Long, Guild> getGuildsInternal$app_productionGoogleRelease() {
        return this.guilds;
    }

    public final Map<Long, Long> getGuildsJoinedAt() {
        return this.guildsJoinedAtSnapshot;
    }

    @Store3
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

    @Store3
    public final Set<Long> getUnavailableGuildsInternal$app_productionGoogleRelease() {
        return this.guildsUnavailable;
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Map<Long, GuildMember> mapEmptyMap;
        Intrinsics3.checkNotNullParameter(payload, "payload");
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
                handleGuildRoles(id2, 0L, guild.m7842G(), false);
                Intrinsics3.checkNotNullExpressionValue(guild, "guild");
                handleGuild(guild, false);
                List<GuildMember> listM7875v = guild.m7875v();
                if (listM7875v == null || (mapEmptyMap = GuildUtils.asMap(listM7875v)) == null) {
                    mapEmptyMap = Maps6.emptyMap();
                }
                handleGuildMembersMap(id2, mapEmptyMap);
                handleHasRoleAndJoinedAt(id2, mapEmptyMap);
            }
        }
        markChanged(GuildsUpdate, ComputedMembersUpdate);
    }

    @Store3
    public final void handleGuildAdd(com.discord.api.guild.Guild guild) {
        Map<Long, GuildMember> mapEmptyMap;
        Intrinsics3.checkNotNullParameter(guild, "guild");
        handleGuildUnavailable(guild.getId(), guild.getUnavailable(), false);
        if (guild.getUnavailable()) {
            return;
        }
        handleGuildRoles(guild.getId(), 0L, guild.m7842G(), false);
        handleGuild(guild, false);
        List<GuildMember> listM7875v = guild.m7875v();
        if (listM7875v == null || (mapEmptyMap = GuildUtils.asMap(listM7875v)) == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        handleGuildMembersMap(guild.getId(), mapEmptyMap);
        handleHasRoleAndJoinedAt(guild.getId(), mapEmptyMap);
    }

    @Store3
    public final void handleGuildMember(GuildMember member, long guildId, boolean isFullGuildMember) {
        GuildMember guildMemberM7915a = member;
        Intrinsics3.checkNotNullParameter(guildMemberM7915a, "member");
        long id2 = member.getUser().getId();
        if (!this.guildMembers.containsKey(Long.valueOf(guildId))) {
            this.guildMembers.put(Long.valueOf(guildId), new HashMap());
        }
        if (!this.guildMembersComputed.containsKey(Long.valueOf(guildId))) {
            this.guildMembersComputed.put(Long.valueOf(guildId), new HashMap());
        }
        Map<Long, GuildMember> map = this.guildMembers.get(Long.valueOf(guildId));
        Intrinsics3.checkNotNull(map);
        GuildMember guildMember = map.get(Long.valueOf(id2));
        if (!isFullGuildMember && guildMember != null) {
            guildMemberM7915a = GuildMember.m7915a(member, 0L, null, null, null, null, null, false, null, null, null, guildMember.getBio(), guildMember.getBanner(), null, 5119);
        }
        GuildMember guildMember2 = guildMemberM7915a;
        if (!Intrinsics3.areEqual(guildMember2, guildMember)) {
            Map<Long, GuildMember> map2 = this.guildMembers.get(Long.valueOf(guildId));
            Intrinsics3.checkNotNull(map2);
            map2.put(Long.valueOf(id2), guildMember2);
        }
        com.discord.models.member.GuildMember guildMemberFrom$default = GuildMember.Companion.from$default(com.discord.models.member.GuildMember.INSTANCE, guildMember2, guildId, this.guildRoles.get(Long.valueOf(guildId)), null, 8, null);
        Intrinsics3.checkNotNull(this.guildMembersComputed.get(Long.valueOf(guildId)));
        if (!Intrinsics3.areEqual(guildMemberFrom$default, r3.get(Long.valueOf(id2)))) {
            Map<Long, com.discord.models.member.GuildMember> map3 = this.guildMembersComputed.get(Long.valueOf(guildId));
            Intrinsics3.checkNotNull(map3);
            map3.put(Long.valueOf(id2), guildMemberFrom$default);
            markChanged(ComputedMembersUpdate);
        }
    }

    @Store3
    public final void handleGuildMemberAdd(com.discord.api.guildmember.GuildMember member) {
        Intrinsics3.checkNotNullParameter(member, "member");
        handleGuildMember$default(this, member, member.getGuildId(), false, 4, null);
    }

    public final void handleGuildMemberCommunicationEnabled(long guildId, long userId) {
        this.dispatcher.schedule(new C60951(guildId, userId));
    }

    @Store3
    public final void handleGuildMemberRemove(long guildId, long userId) {
        handleGuildMembers(guildId, userId, null, true);
    }

    @Store3
    public final void handleGuildMembersChunk(GuildMembersChunk chunk) {
        Intrinsics3.checkNotNullParameter(chunk, "chunk");
        handleGuildMembers(chunk.getGuildId(), 0L, chunk.m7932b(), false);
    }

    @Store3
    public final void handleGuildRemove(com.discord.api.guild.Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        handleGuildUnavailable(guild.getId(), guild.getUnavailable(), true);
        handleGuild(guild, true);
        handleGuildRoles(guild.getId(), 0L, null, true);
        handleGuildMembers(guild.getId(), 0L, null, true);
    }

    @Store3
    public final void handleGuildRoleCreateOrUpdate(long guildId, GuildRole role) {
        Intrinsics3.checkNotNullParameter(role, "role");
        handleGuildRoles(guildId, 0L, CollectionsJVM.listOf(role), false);
        handleGuildMembersMap(guildId, this.guildMembers.get(Long.valueOf(guildId)));
        handleHasRoleAndJoinedAt(guildId, this.guildMembers.get(Long.valueOf(guildId)));
    }

    @Store3
    public final void handleGuildRoleRemove(long roleId, long guildId) {
        handleGuildRoles(guildId, roleId, null, true);
        handleGuildMembersMap(guildId, this.guildMembers.get(Long.valueOf(guildId)));
        handleHasRoleAndJoinedAt(guildId, this.guildMembers.get(Long.valueOf(guildId)));
    }

    @Store3
    public final void handleGuildScheduledEventUsersFetch(List<ApiGuildScheduledEventUser> apiGuildScheduledEventUsers, long guildId) {
        Intrinsics3.checkNotNullParameter(apiGuildScheduledEventUsers, "apiGuildScheduledEventUsers");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = apiGuildScheduledEventUsers.iterator();
        while (it.hasNext()) {
            com.discord.api.guildmember.GuildMember guildMemberM7967a = ((ApiGuildScheduledEventUser) it.next()).m7967a(guildId);
            if (guildMemberM7967a != null) {
                arrayList.add(guildMemberM7967a);
            }
        }
        handleGuildMembers(guildId, 0L, arrayList, false);
    }

    @Store3
    public final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        ArrayList arrayList;
        Intrinsics3.checkNotNullParameter(threadMemberListUpdate, "threadMemberListUpdate");
        long jM8265a = threadMemberListUpdate.getGuildId();
        List<ThreadListMember> listM8266b = threadMemberListUpdate.m8266b();
        if (listM8266b != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = listM8266b.iterator();
            while (it.hasNext()) {
                com.discord.api.guildmember.GuildMember guildMemberM8253a = ((ThreadListMember) it.next()).getMember();
                if (guildMemberM8253a != null) {
                    arrayList2.add(guildMemberM8253a);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        handleGuildMembers(jM8265a, 0L, arrayList, false);
    }

    @Store3
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        ArrayList arrayList;
        Intrinsics3.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        long jM8276b = threadMembersUpdate.getGuildId();
        List<AugmentedThreadMember> listM8275a = threadMembersUpdate.m8275a();
        if (listM8275a != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = listM8275a.iterator();
            while (it.hasNext()) {
                com.discord.api.guildmember.GuildMember guildMemberM8247c = ((AugmentedThreadMember) it.next()).getMember();
                if (guildMemberM8247c != null) {
                    arrayList2.add(guildMemberM8247c);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        handleGuildMembers(jM8276b, 0L, arrayList, false);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        this.guilds.putAll(CollectionExtensions.filterNonNullValues(this.guildsCache.get()));
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
            this.guildRoles.put(Long.valueOf(((Number) entry.getKey()).longValue()), Maps6.toMutableMap((Map) entry.getValue()));
        }
        this.guildsJoinedAt.putAll(this.guildsJoinedAtCache.get());
        markChanged(GuildsUpdate, ComputedMembersUpdate);
        initClearCommunicationDisabledObserver(context);
    }

    public final Observable<List<com.discord.models.member.GuildMember>> observeCommunicationDisabledGuildMembers() {
        Observable<List<com.discord.models.member.GuildMember>> observableM11112r = Observable.m11076j(observeGuildIds(), observeComputed(), C60981.INSTANCE).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, Map<Long, com.discord.models.member.GuildMember>>> observeComputed() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{ComputedMembersUpdate}, false, null, null, new C60991(), 14, null);
    }

    public final Observable<com.discord.models.member.GuildMember> observeComputedMember(long guildId, long userId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{ComputedMembersUpdate}, false, null, null, new C61011(guildId, userId), 14, null);
    }

    public final Observable<Guild> observeFromChannelId(long channelId) {
        Observable observableM11099Y = StoreStream.INSTANCE.getChannels().observeChannel(channelId).m11099Y(new C61021());
        Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n        .get…ll)\n          }\n        }");
        return observableM11099Y;
    }

    public final Observable<Guild> observeGuild(long guildId) {
        Observable<Guild> observableM11112r = observeGuilds().m11083G(new C61031(guildId)).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observeGuilds()\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Set<Long>> observeGuildIds() {
        Observable<Set<Long>> observableM11112r = observeGuilds().m11099Y(C61041.INSTANCE).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observeGuilds()\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<com.discord.models.member.GuildMember> observeGuildMember(long guildId, long userId) {
        return observeComputed().m11083G(new C61051(guildId, userId)).m11112r();
    }

    public final Observable<Map<Long, com.discord.models.member.GuildMember>> observeGuildMembers(long guildId) {
        return observeComputed().m11083G(new C61061(guildId)).m11112r();
    }

    public final Observable<Map<Long, Guild>> observeGuilds() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{GuildsUpdate}, false, null, null, new C61071(), 14, null);
    }

    public final Observable<Map<Long, Long>> observeJoinedAt() {
        Observable<Map<Long, Long>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{GuildsUpdate}, false, null, null, new C61081(), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, Map<Long, GuildRole>>> observeRoles() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{GuildsUpdate}, false, null, null, new C61101(), 14, null);
    }

    public final Observable<List<GuildRole>> observeSortedRoles(long guildId) {
        Observable<List<GuildRole>> observableM11112r = observeRoles(guildId).m11099Y(C61121.INSTANCE).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observeRoles(guildId)\n  …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Set<Long>> observeUnavailableGuilds() {
        Observable<Set<Long>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{GuildsUpdate}, false, null, null, new C61131(), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<GuildVerificationLevel> observeVerificationLevel(long guildId) {
        Observable<GuildVerificationLevel> observableM11112r = observeGuild(guildId).m11083G(C61141.INSTANCE).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observeGuild(guildId)\n  …  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        SnowflakePartitionMap.CopiablePartitionMap copiablePartitionMap;
        super.snapshotData();
        if (getUpdateSources().contains(GuildsUpdate)) {
            HashMap map = new HashMap(this.guildsJoinedAt);
            this.guildsJoinedAtSnapshot = map;
            Persister.set$default(this.guildsJoinedAtCache, map, false, 2, null);
            this.guildsSnapshot = new HashMap(this.guilds);
            Persister.set$default(this.guildsCache, Maps6.minus((Map) this.guilds, (Iterable) StoreStream.INSTANCE.getLurking().getLurkingGuildIdsSync()), false, 2, null);
            this.guildsUnavailableSnapshot = new HashSet(this.guildsUnavailable);
            Map<Long, Map<Long, GuildRole>> map2 = this.guildRoles;
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(map2.size()));
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
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.userStore = storeUser;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildsSnapshot = Maps6.emptyMap();
        this.guildMembersComputedSnapshot = Maps6.emptyMap();
        this.guildRolesSnapshot = Maps6.emptyMap();
        this.guildsUnavailableSnapshot = Sets5.emptySet();
        this.guildsJoinedAtSnapshot = Maps6.emptyMap();
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
        Observable<Map<Long, com.discord.models.member.GuildMember>> observableM11112r = observeComputed().m11083G(new C61002(guildId)).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observeComputed()\n      …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, GuildRole>> observeRoles(long guildId) {
        Observable<Map<Long, GuildRole>> observableM11112r = observeRoles().m11083G(new C61112(guildId)).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observeRoles()\n        .…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Long> observeJoinedAt(long guildId) {
        Observable<Long> observableM11112r = observeJoinedAt().m11083G(new C61092(guildId)).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observeJoinedAt()\n      …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, com.discord.models.member.GuildMember>> observeComputed(long guildId, Collection<Long> userIds) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Observable observableM11108k = observeComputed(guildId).m11108k(C0879o.m175a(userIds));
        Intrinsics3.checkNotNullExpressionValue(observableM11108k, "observeComputed(guildId)…mpose(filterMap(userIds))");
        return observableM11108k;
    }

    public final Observable<Map<Long, GuildRole>> observeRoles(long guildId, Collection<Long> roleIds) {
        Intrinsics3.checkNotNullParameter(roleIds, "roleIds");
        Observable observableM11108k = observeRoles(guildId).m11108k(C0879o.m175a(roleIds));
        Intrinsics3.checkNotNullExpressionValue(observableM11108k, "observeRoles(guildId)\n  …mpose(filterMap(roleIds))");
        return observableM11108k;
    }
}
