package com.discord.widgets.servers.settings.members;

import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;

/* compiled from: WidgetServerSettingsMembersModel.kt */
/* loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsMembersModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int MEMBER_LIST_ITEM_TYPE = 1;
    private final boolean canKick;
    private final boolean canManageMembers;
    private final Guild guild;
    private final MeUser meUser;
    private final List<MemberItem> memberItems;
    private final GuildRole myHighestRole;
    private final Map<Long, GuildRole> roles;

    /* compiled from: WidgetServerSettingsMembersModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Comparator access$sortMembersComparator(Companion companion) {
            return companion.sortMembersComparator();
        }

        public static final /* synthetic */ Map access$sortRoles(Companion companion, Map map) {
            return companion.sortRoles(map);
        }

        private final Comparator<MemberItem> sortMembersComparator() {
            return WidgetServerSettingsMembersModel3.INSTANCE;
        }

        private final Map<Long, GuildRole> sortRoles(Map<Long, GuildRole> guildRoles) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(guildRoles.size());
            ArrayList arrayList = new ArrayList(guildRoles.values());
            Collections.sort(arrayList, RoleUtils.getROLE_COMPARATOR());
            for (Object obj : arrayList) {
                linkedHashMap.put(Long.valueOf(((GuildRole) obj).getId()), obj);
            }
            return linkedHashMap;
        }

        public final Observable<WidgetServerSettingsMembersModel> get(long guildId, Observable<String> filterPublisher, Observable<Long> roleFilterPublisher) {
            Intrinsics3.checkNotNullParameter(filterPublisher, "filterPublisher");
            Intrinsics3.checkNotNullParameter(roleFilterPublisher, "roleFilterPublisher");
            Observable<R> observableM11099Y = StoreStream.INSTANCE.getGuilds().observeComputed(guildId).m11099Y(new WidgetServerSettingsMembersModel2(guildId, filterPublisher, roleFilterPublisher));
            Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …          }\n            }");
            Observable<WidgetServerSettingsMembersModel> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11099Y).m11112r();
            Intrinsics3.checkNotNullExpressionValue(observableM11112r, "StoreStream\n            …  .distinctUntilChanged()");
            return observableM11112r;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsMembersModel.kt */
    public static final /* data */ class MemberItem implements MGRecyclerDataPayload {
        private final GuildMember guildMember;
        private final boolean isManagable;
        private final String key;
        private final List<GuildRole> roles;
        private final int type;
        private final User user;
        private final String userDisplayName;

        public MemberItem(User user, String str, List<GuildRole> list, boolean z2, GuildMember guildMember) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(str, "userDisplayName");
            Intrinsics3.checkNotNullParameter(list, "roles");
            Intrinsics3.checkNotNullParameter(guildMember, "guildMember");
            this.user = user;
            this.userDisplayName = str;
            this.roles = list;
            this.isManagable = z2;
            this.guildMember = guildMember;
            this.key = String.valueOf(user.getId());
            this.type = 1;
        }

        public static /* synthetic */ MemberItem copy$default(MemberItem memberItem, User user, String str, List list, boolean z2, GuildMember guildMember, int i, Object obj) {
            if ((i & 1) != 0) {
                user = memberItem.user;
            }
            if ((i & 2) != 0) {
                str = memberItem.userDisplayName;
            }
            String str2 = str;
            if ((i & 4) != 0) {
                list = memberItem.roles;
            }
            List list2 = list;
            if ((i & 8) != 0) {
                z2 = memberItem.isManagable;
            }
            boolean z3 = z2;
            if ((i & 16) != 0) {
                guildMember = memberItem.guildMember;
            }
            return memberItem.copy(user, str2, list2, z3, guildMember);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* renamed from: component2, reason: from getter */
        public final String getUserDisplayName() {
            return this.userDisplayName;
        }

        public final List<GuildRole> component3() {
            return this.roles;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsManagable() {
            return this.isManagable;
        }

        /* renamed from: component5, reason: from getter */
        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public final MemberItem copy(User user, String userDisplayName, List<GuildRole> roles, boolean isManagable, GuildMember guildMember) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(userDisplayName, "userDisplayName");
            Intrinsics3.checkNotNullParameter(roles, "roles");
            Intrinsics3.checkNotNullParameter(guildMember, "guildMember");
            return new MemberItem(user, userDisplayName, roles, isManagable, guildMember);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MemberItem)) {
                return false;
            }
            MemberItem memberItem = (MemberItem) other;
            return Intrinsics3.areEqual(this.user, memberItem.user) && Intrinsics3.areEqual(this.userDisplayName, memberItem.userDisplayName) && Intrinsics3.areEqual(this.roles, memberItem.roles) && this.isManagable == memberItem.isManagable && Intrinsics3.areEqual(this.guildMember, memberItem.guildMember);
        }

        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final List<GuildRole> getRoles() {
            return this.roles;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        public final String getUserDisplayName() {
            return this.userDisplayName;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            String str = this.userDisplayName;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            List<GuildRole> list = this.roles;
            int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.isManagable;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode3 + i) * 31;
            GuildMember guildMember = this.guildMember;
            return i2 + (guildMember != null ? guildMember.hashCode() : 0);
        }

        public final boolean isManagable() {
            return this.isManagable;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("MemberItem(user=");
            sbM833U.append(this.user);
            sbM833U.append(", userDisplayName=");
            sbM833U.append(this.userDisplayName);
            sbM833U.append(", roles=");
            sbM833U.append(this.roles);
            sbM833U.append(", isManagable=");
            sbM833U.append(this.isManagable);
            sbM833U.append(", guildMember=");
            sbM833U.append(this.guildMember);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    public WidgetServerSettingsMembersModel(Guild guild, Map<Long, GuildRole> map, List<MemberItem> list, GuildRole guildRole, MeUser meUser, boolean z2, boolean z3) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        Intrinsics3.checkNotNullParameter(map, "roles");
        Intrinsics3.checkNotNullParameter(list, "memberItems");
        Intrinsics3.checkNotNullParameter(meUser, "meUser");
        this.guild = guild;
        this.roles = map;
        this.memberItems = list;
        this.myHighestRole = guildRole;
        this.meUser = meUser;
        this.canKick = z2;
        this.canManageMembers = z3;
    }

    public static /* synthetic */ WidgetServerSettingsMembersModel copy$default(WidgetServerSettingsMembersModel widgetServerSettingsMembersModel, Guild guild, Map map, List list, GuildRole guildRole, MeUser meUser, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetServerSettingsMembersModel.guild;
        }
        if ((i & 2) != 0) {
            map = widgetServerSettingsMembersModel.roles;
        }
        Map map2 = map;
        if ((i & 4) != 0) {
            list = widgetServerSettingsMembersModel.memberItems;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            guildRole = widgetServerSettingsMembersModel.myHighestRole;
        }
        GuildRole guildRole2 = guildRole;
        if ((i & 16) != 0) {
            meUser = widgetServerSettingsMembersModel.meUser;
        }
        MeUser meUser2 = meUser;
        if ((i & 32) != 0) {
            z2 = widgetServerSettingsMembersModel.canKick;
        }
        boolean z4 = z2;
        if ((i & 64) != 0) {
            z3 = widgetServerSettingsMembersModel.canManageMembers;
        }
        return widgetServerSettingsMembersModel.copy(guild, map2, list2, guildRole2, meUser2, z4, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, GuildRole> component2() {
        return this.roles;
    }

    public final List<MemberItem> component3() {
        return this.memberItems;
    }

    /* renamed from: component4, reason: from getter */
    public final GuildRole getMyHighestRole() {
        return this.myHighestRole;
    }

    /* renamed from: component5, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getCanKick() {
        return this.canKick;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getCanManageMembers() {
        return this.canManageMembers;
    }

    public final WidgetServerSettingsMembersModel copy(Guild guild, Map<Long, GuildRole> roles, List<MemberItem> memberItems, GuildRole myHighestRole, MeUser meUser, boolean canKick, boolean canManageMembers) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        Intrinsics3.checkNotNullParameter(roles, "roles");
        Intrinsics3.checkNotNullParameter(memberItems, "memberItems");
        Intrinsics3.checkNotNullParameter(meUser, "meUser");
        return new WidgetServerSettingsMembersModel(guild, roles, memberItems, myHighestRole, meUser, canKick, canManageMembers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsMembersModel)) {
            return false;
        }
        WidgetServerSettingsMembersModel widgetServerSettingsMembersModel = (WidgetServerSettingsMembersModel) other;
        return Intrinsics3.areEqual(this.guild, widgetServerSettingsMembersModel.guild) && Intrinsics3.areEqual(this.roles, widgetServerSettingsMembersModel.roles) && Intrinsics3.areEqual(this.memberItems, widgetServerSettingsMembersModel.memberItems) && Intrinsics3.areEqual(this.myHighestRole, widgetServerSettingsMembersModel.myHighestRole) && Intrinsics3.areEqual(this.meUser, widgetServerSettingsMembersModel.meUser) && this.canKick == widgetServerSettingsMembersModel.canKick && this.canManageMembers == widgetServerSettingsMembersModel.canManageMembers;
    }

    public final boolean getCanKick() {
        return this.canKick;
    }

    public final boolean getCanManageMembers() {
        return this.canManageMembers;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final List<MemberItem> getMemberItems() {
        return this.memberItems;
    }

    public final GuildRole getMyHighestRole() {
        return this.myHighestRole;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        Map<Long, GuildRole> map = this.roles;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        List<MemberItem> list = this.memberItems;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        GuildRole guildRole = this.myHighestRole;
        int iHashCode4 = (iHashCode3 + (guildRole != null ? guildRole.hashCode() : 0)) * 31;
        MeUser meUser = this.meUser;
        int iHashCode5 = (iHashCode4 + (meUser != null ? meUser.hashCode() : 0)) * 31;
        boolean z2 = this.canKick;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode5 + i) * 31;
        boolean z3 = this.canManageMembers;
        return i2 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("WidgetServerSettingsMembersModel(guild=");
        sbM833U.append(this.guild);
        sbM833U.append(", roles=");
        sbM833U.append(this.roles);
        sbM833U.append(", memberItems=");
        sbM833U.append(this.memberItems);
        sbM833U.append(", myHighestRole=");
        sbM833U.append(this.myHighestRole);
        sbM833U.append(", meUser=");
        sbM833U.append(this.meUser);
        sbM833U.append(", canKick=");
        sbM833U.append(this.canKick);
        sbM833U.append(", canManageMembers=");
        return outline.m827O(sbM833U, this.canManageMembers, ")");
    }
}
