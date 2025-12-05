package com.discord.widgets.channels.permissions;

import android.content.Context;
import androidx.annotation.MainThread;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGatewayConnection;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.channels.permissions.AddMemberAdapter;
import com.discord.widgets.channels.permissions.PermissionOwner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.Strings4;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragmentViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final StoreChannels channelsStore;
    private final StoreGatewayConnection gatewaySocket;
    private final StoreGuilds guildsStore;
    private String query;
    private final HashMap<Long, PermissionOverwrite.Type> selected;
    private final boolean showRolesWithGuildPermission;
    private StoreState storeState;
    private final StoreUser userStore;

    /* compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragmentViewModel$1 */
    public static final class C75291 extends Lambda implements Function1<StoreState, Unit> {
        public C75291() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            WidgetChannelSettingsAddMemberFragmentViewModel.access$handleStoreState(WidgetChannelSettingsAddMemberFragmentViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUser storeUser) {
            return companion.observeStoreState(j, storeChannels, storeGuilds, storeUser);
        }

        private final Observable<StoreState> observeStoreState(long channelId, StoreChannels channelsStore, StoreGuilds guildsStore, StoreUser userStore) {
            Observable<R> observableM11083G = channelsStore.observeChannel(channelId).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
            Observable<StoreState> observableM11099Y = observableM11083G.m11112r().m11099Y(new WidgetChannelSettingsAddMemberFragmentViewModel2(guildsStore, userStore));
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "channelsStore.observeCha…          }\n            }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
    public static final /* data */ class StoreState {
        private final Channel channel;
        private final Map<Long, PermissionOverwrite> channelPermissionOverwritesMap;
        private final Guild guild;
        private final Map<Long, GuildMember> members;
        private final Map<Long, GuildRole> roles;
        private final Map<Long, User> users;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(Guild guild, Channel channel, Map<Long, PermissionOverwrite> map, Map<Long, GuildRole> map2, Map<Long, GuildMember> map3, Map<Long, ? extends User> map4) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(map, "channelPermissionOverwritesMap");
            Intrinsics3.checkNotNullParameter(map2, "roles");
            Intrinsics3.checkNotNullParameter(map3, "members");
            Intrinsics3.checkNotNullParameter(map4, "users");
            this.guild = guild;
            this.channel = channel;
            this.channelPermissionOverwritesMap = map;
            this.roles = map2;
            this.members = map3;
            this.users = map4;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, Channel channel, Map map, Map map2, Map map3, Map map4, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = storeState.guild;
            }
            if ((i & 2) != 0) {
                channel = storeState.channel;
            }
            Channel channel2 = channel;
            if ((i & 4) != 0) {
                map = storeState.channelPermissionOverwritesMap;
            }
            Map map5 = map;
            if ((i & 8) != 0) {
                map2 = storeState.roles;
            }
            Map map6 = map2;
            if ((i & 16) != 0) {
                map3 = storeState.members;
            }
            Map map7 = map3;
            if ((i & 32) != 0) {
                map4 = storeState.users;
            }
            return storeState.copy(guild, channel2, map5, map6, map7, map4);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, PermissionOverwrite> component3() {
            return this.channelPermissionOverwritesMap;
        }

        public final Map<Long, GuildRole> component4() {
            return this.roles;
        }

        public final Map<Long, GuildMember> component5() {
            return this.members;
        }

        public final Map<Long, User> component6() {
            return this.users;
        }

        public final StoreState copy(Guild guild, Channel channel, Map<Long, PermissionOverwrite> channelPermissionOverwritesMap, Map<Long, GuildRole> roles, Map<Long, GuildMember> members, Map<Long, ? extends User> users) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(channelPermissionOverwritesMap, "channelPermissionOverwritesMap");
            Intrinsics3.checkNotNullParameter(roles, "roles");
            Intrinsics3.checkNotNullParameter(members, "members");
            Intrinsics3.checkNotNullParameter(users, "users");
            return new StoreState(guild, channel, channelPermissionOverwritesMap, roles, members, users);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.channel, storeState.channel) && Intrinsics3.areEqual(this.channelPermissionOverwritesMap, storeState.channelPermissionOverwritesMap) && Intrinsics3.areEqual(this.roles, storeState.roles) && Intrinsics3.areEqual(this.members, storeState.members) && Intrinsics3.areEqual(this.users, storeState.users);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Map<Long, PermissionOverwrite> getChannelPermissionOverwritesMap() {
            return this.channelPermissionOverwritesMap;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Map<Long, GuildMember> getMembers() {
            return this.members;
        }

        public final Map<Long, GuildRole> getRoles() {
            return this.roles;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            Map<Long, PermissionOverwrite> map = this.channelPermissionOverwritesMap;
            int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, GuildRole> map2 = this.roles;
            int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Map<Long, GuildMember> map3 = this.members;
            int iHashCode5 = (iHashCode4 + (map3 != null ? map3.hashCode() : 0)) * 31;
            Map<Long, User> map4 = this.users;
            return iHashCode5 + (map4 != null ? map4.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("StoreState(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", channelPermissionOverwritesMap=");
            sbM833U.append(this.channelPermissionOverwritesMap);
            sbM833U.append(", roles=");
            sbM833U.append(this.roles);
            sbM833U.append(", members=");
            sbM833U.append(this.members);
            sbM833U.append(", users=");
            return outline.m825M(sbM833U, this.users, ")");
        }
    }

    /* compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
    public static final /* data */ class ViewState {
        private final Channel channel;
        private final Guild guild;
        private final List<AddMemberAdapter.Item> items;
        private final String query;
        private final Map<Long, PermissionOverwrite.Type> selected;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(Guild guild, Channel channel, String str, List<? extends AddMemberAdapter.Item> list, Map<Long, ? extends PermissionOverwrite.Type> map) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(str, "query");
            Intrinsics3.checkNotNullParameter(list, "items");
            Intrinsics3.checkNotNullParameter(map, "selected");
            this.guild = guild;
            this.channel = channel;
            this.query = str;
            this.items = list;
            this.selected = map;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, Guild guild, Channel channel, String str, List list, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = viewState.guild;
            }
            if ((i & 2) != 0) {
                channel = viewState.channel;
            }
            Channel channel2 = channel;
            if ((i & 4) != 0) {
                str = viewState.query;
            }
            String str2 = str;
            if ((i & 8) != 0) {
                list = viewState.items;
            }
            List list2 = list;
            if ((i & 16) != 0) {
                map = viewState.selected;
            }
            return viewState.copy(guild, channel2, str2, list2, map);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component3, reason: from getter */
        public final String getQuery() {
            return this.query;
        }

        public final List<AddMemberAdapter.Item> component4() {
            return this.items;
        }

        public final Map<Long, PermissionOverwrite.Type> component5() {
            return this.selected;
        }

        public final ViewState copy(Guild guild, Channel channel, String query, List<? extends AddMemberAdapter.Item> items, Map<Long, ? extends PermissionOverwrite.Type> selected) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(query, "query");
            Intrinsics3.checkNotNullParameter(items, "items");
            Intrinsics3.checkNotNullParameter(selected, "selected");
            return new ViewState(guild, channel, query, items, selected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.guild, viewState.guild) && Intrinsics3.areEqual(this.channel, viewState.channel) && Intrinsics3.areEqual(this.query, viewState.query) && Intrinsics3.areEqual(this.items, viewState.items) && Intrinsics3.areEqual(this.selected, viewState.selected);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final List<AddMemberAdapter.Item> getItems() {
            return this.items;
        }

        public final String getQuery() {
            return this.query;
        }

        public final Map<Long, PermissionOverwrite.Type> getSelected() {
            return this.selected;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            String str = this.query;
            int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            List<AddMemberAdapter.Item> list = this.items;
            int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
            Map<Long, PermissionOverwrite.Type> map = this.selected;
            return iHashCode4 + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("ViewState(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", query=");
            sbM833U.append(this.query);
            sbM833U.append(", items=");
            sbM833U.append(this.items);
            sbM833U.append(", selected=");
            return outline.m825M(sbM833U, this.selected, ")");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetChannelSettingsAddMemberFragmentViewModel(long j, boolean z2, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUser storeUser, StoreGatewayConnection storeGatewayConnection, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreGuilds guilds = (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreUser users = (i & 16) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        this(j, z2, channels, guilds, users, (i & 32) != 0 ? StoreStream.INSTANCE.getGatewaySocket() : storeGatewayConnection, (i & 64) != 0 ? Companion.access$observeStoreState(INSTANCE, j, channels, guilds, users) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetChannelSettingsAddMemberFragmentViewModel widgetChannelSettingsAddMemberFragmentViewModel, StoreState storeState) {
        widgetChannelSettingsAddMemberFragmentViewModel.handleStoreState(storeState);
    }

    private final ViewState generateViewState(StoreState storeState) {
        return new ViewState(storeState.getGuild(), storeState.getChannel(), this.query, makeAdapterItems(storeState), this.selected);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        this.storeState = storeState;
        updateViewState(generateViewState(storeState));
    }

    private final boolean isPermissionOverrideAlreadyPresent(PermissionOverwrite overwrite, long permission) {
        return overwrite != null && (overwrite.getAllow() & permission) == permission;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<AddMemberAdapter.Item> makeAdapterItems(StoreState storeState) {
        AddMemberAdapter.Item.PermissionOwnerItem.Companion.AddStatus cannotAdd;
        boolean z2;
        Guild guild = storeState.getGuild();
        Map<Long, PermissionOverwrite> channelPermissionOverwritesMap = storeState.getChannelPermissionOverwritesMap();
        String str = this.query;
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        String string = Strings4.trim(str).toString();
        Collection<GuildRole> collectionValues = storeState.getRoles().values();
        ArrayList<GuildRole> arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            GuildRole guildRole = (GuildRole) obj;
            if ((guildRole.getPermissions() & 8) == 0) {
                z2 = (guild == null || guildRole.getId() != guild.getId()) && (this.showRolesWithGuildPermission || !PermissionUtils.INSTANCE.canRole(20971536L, guildRole, channelPermissionOverwritesMap.get(Long.valueOf(guildRole.getId())))) && !isPermissionOverrideAlreadyPresent(channelPermissionOverwritesMap.get(Long.valueOf(guildRole.getId())), 20971536L) && Strings4.contains((CharSequence) guildRole.getName(), (CharSequence) string, true);
            }
            if (z2) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        for (GuildRole guildRole2 : arrayList) {
            boolean zCanRole = PermissionUtils.INSTANCE.canRole(20971536L, guildRole2, channelPermissionOverwritesMap.get(Long.valueOf(guildRole2.getId())));
            PermissionOwner.Role role = new PermissionOwner.Role(guildRole2);
            boolean z3 = zCanRole || this.selected.containsKey(Long.valueOf(guildRole2.getId()));
            if (zCanRole) {
                cannotAdd = new AddMemberAdapter.Item.PermissionOwnerItem.Companion.AddStatus.CannotAdd(AddMemberAdapter.Item.PermissionOwnerItem.Companion.AddStatus.CannotAdd.Reason.HAS_GUILD_PERMISSIONS);
            } else {
                if (zCanRole) {
                    throw new NoWhenBranchMatchedException();
                }
                cannotAdd = AddMemberAdapter.Item.PermissionOwnerItem.Companion.AddStatus.CanAdd.INSTANCE;
            }
            arrayList2.add(new AddMemberAdapter.Item.PermissionOwnerItem(role, z3, cannotAdd));
        }
        Set<Map.Entry<Long, GuildMember>> setEntrySet = storeState.getMembers().entrySet();
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            User user = storeState.getUsers().get(entry.getKey());
            Tuples2 tuples2 = user == null ? null : new Tuples2((GuildMember) entry.getValue(), user);
            if (tuples2 != null) {
                arrayList3.add(tuples2);
            }
        }
        ArrayList<Tuples2> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            Tuples2 tuples22 = (Tuples2) obj2;
            GuildMember guildMember = (GuildMember) tuples22.component1();
            User user2 = (User) tuples22.component2();
            if (((guild != null ? guild.isOwner(user2.getId()) : false) || isPermissionOverrideAlreadyPresent((PermissionOverwrite) outline.m849f(user2, channelPermissionOverwritesMap), 20971536L) || (!Strings4.contains((CharSequence) user2.getUsername(), (CharSequence) string, true) && (guildMember.getNick() == null || !Strings4.contains((CharSequence) guildMember.getNick(), (CharSequence) string, true)))) ? false : true) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList4, 10));
        for (Tuples2 tuples23 : arrayList4) {
            GuildMember guildMember2 = (GuildMember) tuples23.component1();
            User user3 = (User) tuples23.component2();
            arrayList5.add(new AddMemberAdapter.Item.PermissionOwnerItem(new PermissionOwner.Member(user3, guildMember2.getNick(), guild != null && guild.isOwner(user3.getId())), this.selected.containsKey(Long.valueOf(user3.getId())), AddMemberAdapter.Item.PermissionOwnerItem.Companion.AddStatus.CanAdd.INSTANCE));
        }
        return _Collections.plus((Collection) _Collections.plus((Collection) _Collections.plus((Collection) CollectionsJVM.listOf(new AddMemberAdapter.Item.CategoryItem(AddMemberAdapter.Item.CategoryItem.Companion.CategoryType.ROLE)), (Iterable) arrayList2), (Iterable) CollectionsJVM.listOf(new AddMemberAdapter.Item.CategoryItem(AddMemberAdapter.Item.CategoryItem.Companion.CategoryType.MEMBER))), (Iterable) arrayList5);
    }

    private final void requestMembers(String query) {
        Guild guild;
        StoreState storeState = this.storeState;
        if (storeState == null || (guild = storeState.getGuild()) == null) {
            return;
        }
        long id2 = guild.getId();
        StoreGatewayConnection storeGatewayConnection = this.gatewaySocket;
        Objects.requireNonNull(query, "null cannot be cast to non-null type kotlin.CharSequence");
        storeGatewayConnection.requestGuildMembers(id2, Strings4.trim(query).toString(), null, 20);
    }

    public final String getQuery() {
        return this.query;
    }

    public final void setQuery(String str) {
        Intrinsics3.checkNotNullParameter(str, "<set-?>");
        this.query = str;
    }

    public final void toggleItem(long id2, PermissionOverwrite.Type type) {
        Intrinsics3.checkNotNullParameter(type, "type");
        if (this.selected.containsKey(Long.valueOf(id2))) {
            this.selected.remove(Long.valueOf(id2));
        } else {
            this.selected.put(Long.valueOf(id2), type);
        }
        StoreState storeState = this.storeState;
        if (storeState != null) {
            updateViewState(generateViewState(storeState));
        }
    }

    public final void updateQuery(String query) {
        Intrinsics3.checkNotNullParameter(query, "query");
        this.query = query;
        StoreState storeState = this.storeState;
        if (storeState != null) {
            updateViewState(generateViewState(storeState));
        }
        requestMembers(query);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsAddMemberFragmentViewModel(long j, boolean z2, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUser storeUser, StoreGatewayConnection storeGatewayConnection, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeGatewayConnection, "gatewaySocket");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.channelId = j;
        this.showRolesWithGuildPermission = z2;
        this.channelsStore = storeChannels;
        this.guildsStore = storeGuilds;
        this.userStore = storeUser;
        this.gatewaySocket = storeGatewayConnection;
        this.query = "";
        this.selected = new HashMap<>();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetChannelSettingsAddMemberFragmentViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C75291(), 62, (Object) null);
    }
}
