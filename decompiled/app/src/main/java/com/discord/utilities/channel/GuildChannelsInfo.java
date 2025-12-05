package com.discord.utilities.channel;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableWithLeadingEdgeThrottle;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.permissions.PermissionsContexts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p580t.MutableCollections;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;

/* compiled from: GuildChannelsInfo.kt */
/* loaded from: classes2.dex */
public final /* data */ class GuildChannelsInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean ableToInstantInvite;
    private final boolean canChangeNickname;
    private final Map<Long, Long> channelPermissions;
    private final GuildRole everyoneRole;
    private final Guild guild;
    private final Map<Long, GuildRole> guildRoles;
    private final boolean hideMutedChannels;
    private final boolean isVerifiedServer;
    private final PermissionsContexts manageGuildContext;
    private final ModelNotificationSettings notificationSettings;
    private final boolean unelevated;

    /* compiled from: GuildChannelsInfo.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<GuildChannelsInfo> get(long guildId) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<GuildChannelsInfo> observableM11112r = ObservableWithLeadingEdgeThrottle.combineLatest(companion.getUsers().observeMe(true), companion.getGuilds().observeGuild(guildId), companion.getUserGuildSettings().observeGuildSettings(guildId), companion.getUserGuildSettings().observeHideMutedChannels(guildId), companion.getGuilds().observeRoles(guildId), companion.getPermissions().observePermissionsForGuild(guildId), companion.getPermissions().observeChannelPermissionsForGuild(guildId), companion.getChannels().observeChannelCategories(guildId), GuildChannelsInfo2.INSTANCE, 500L, TimeUnit.MILLISECONDS).m11112r();
            Intrinsics3.checkNotNullExpressionValue(observableM11112r, "ObservableWithLeadingEdg…  .distinctUntilChanged()");
            return observableM11112r;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GuildChannelsInfo(Guild guild, GuildRole guildRole, ModelNotificationSettings modelNotificationSettings, boolean z2, Map<Long, Long> map, boolean z3, boolean z4, boolean z5, PermissionsContexts permissionsContexts, boolean z6, Map<Long, GuildRole> map2) {
        Intrinsics3.checkNotNullParameter(modelNotificationSettings, "notificationSettings");
        Intrinsics3.checkNotNullParameter(map, "channelPermissions");
        Intrinsics3.checkNotNullParameter(permissionsContexts, "manageGuildContext");
        this.guild = guild;
        this.everyoneRole = guildRole;
        this.notificationSettings = modelNotificationSettings;
        this.hideMutedChannels = z2;
        this.channelPermissions = map;
        this.ableToInstantInvite = z3;
        this.unelevated = z4;
        this.isVerifiedServer = z5;
        this.manageGuildContext = permissionsContexts;
        this.canChangeNickname = z6;
        this.guildRoles = map2;
    }

    public static /* synthetic */ GuildChannelsInfo copy$default(GuildChannelsInfo guildChannelsInfo, Guild guild, GuildRole guildRole, ModelNotificationSettings modelNotificationSettings, boolean z2, Map map, boolean z3, boolean z4, boolean z5, PermissionsContexts permissionsContexts, boolean z6, Map map2, int i, Object obj) {
        return guildChannelsInfo.copy((i & 1) != 0 ? guildChannelsInfo.guild : guild, (i & 2) != 0 ? guildChannelsInfo.everyoneRole : guildRole, (i & 4) != 0 ? guildChannelsInfo.notificationSettings : modelNotificationSettings, (i & 8) != 0 ? guildChannelsInfo.hideMutedChannels : z2, (i & 16) != 0 ? guildChannelsInfo.channelPermissions : map, (i & 32) != 0 ? guildChannelsInfo.ableToInstantInvite : z3, (i & 64) != 0 ? guildChannelsInfo.unelevated : z4, (i & 128) != 0 ? guildChannelsInfo.isVerifiedServer : z5, (i & 256) != 0 ? guildChannelsInfo.manageGuildContext : permissionsContexts, (i & 512) != 0 ? guildChannelsInfo.canChangeNickname : z6, (i & 1024) != 0 ? guildChannelsInfo.guildRoles : map2);
    }

    /* renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getCanChangeNickname() {
        return this.canChangeNickname;
    }

    public final Map<Long, GuildRole> component11() {
        return this.guildRoles;
    }

    /* renamed from: component2, reason: from getter */
    public final GuildRole getEveryoneRole() {
        return this.everyoneRole;
    }

    /* renamed from: component3, reason: from getter */
    public final ModelNotificationSettings getNotificationSettings() {
        return this.notificationSettings;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getHideMutedChannels() {
        return this.hideMutedChannels;
    }

    public final Map<Long, Long> component5() {
        return this.channelPermissions;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getAbleToInstantInvite() {
        return this.ableToInstantInvite;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getUnelevated() {
        return this.unelevated;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsVerifiedServer() {
        return this.isVerifiedServer;
    }

    /* renamed from: component9, reason: from getter */
    public final PermissionsContexts getManageGuildContext() {
        return this.manageGuildContext;
    }

    public final GuildChannelsInfo copy(Guild guild, GuildRole everyoneRole, ModelNotificationSettings notificationSettings, boolean hideMutedChannels, Map<Long, Long> channelPermissions, boolean ableToInstantInvite, boolean unelevated, boolean isVerifiedServer, PermissionsContexts manageGuildContext, boolean canChangeNickname, Map<Long, GuildRole> guildRoles) {
        Intrinsics3.checkNotNullParameter(notificationSettings, "notificationSettings");
        Intrinsics3.checkNotNullParameter(channelPermissions, "channelPermissions");
        Intrinsics3.checkNotNullParameter(manageGuildContext, "manageGuildContext");
        return new GuildChannelsInfo(guild, everyoneRole, notificationSettings, hideMutedChannels, channelPermissions, ableToInstantInvite, unelevated, isVerifiedServer, manageGuildContext, canChangeNickname, guildRoles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildChannelsInfo)) {
            return false;
        }
        GuildChannelsInfo guildChannelsInfo = (GuildChannelsInfo) other;
        return Intrinsics3.areEqual(this.guild, guildChannelsInfo.guild) && Intrinsics3.areEqual(this.everyoneRole, guildChannelsInfo.everyoneRole) && Intrinsics3.areEqual(this.notificationSettings, guildChannelsInfo.notificationSettings) && this.hideMutedChannels == guildChannelsInfo.hideMutedChannels && Intrinsics3.areEqual(this.channelPermissions, guildChannelsInfo.channelPermissions) && this.ableToInstantInvite == guildChannelsInfo.ableToInstantInvite && this.unelevated == guildChannelsInfo.unelevated && this.isVerifiedServer == guildChannelsInfo.isVerifiedServer && Intrinsics3.areEqual(this.manageGuildContext, guildChannelsInfo.manageGuildContext) && this.canChangeNickname == guildChannelsInfo.canChangeNickname && Intrinsics3.areEqual(this.guildRoles, guildChannelsInfo.guildRoles);
    }

    public final boolean getAbleToInstantInvite() {
        return this.ableToInstantInvite;
    }

    public final boolean getCanChangeNickname() {
        return this.canChangeNickname;
    }

    public final Map<Long, Long> getChannelPermissions() {
        return this.channelPermissions;
    }

    public final GuildRole getEveryoneRole() {
        return this.everyoneRole;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, GuildRole> getGuildRoles() {
        return this.guildRoles;
    }

    public final boolean getHideMutedChannels() {
        return this.hideMutedChannels;
    }

    public final PermissionsContexts getManageGuildContext() {
        return this.manageGuildContext;
    }

    public final ModelNotificationSettings getNotificationSettings() {
        return this.notificationSettings;
    }

    public final Map<Long, Collection<Channel>> getSortedCategories(Map<Long, Channel> guildChannels) {
        Intrinsics3.checkNotNullParameter(guildChannels, "guildChannels");
        TreeMap treeMap = new TreeMap(new GuildChannelsInfo3(guildChannels));
        for (Channel channel : _Collections.filterNotNull(guildChannels.values())) {
            Long lValueOf = Long.valueOf(ChannelUtils.m7687k(channel) ? channel.getId() : channel.getParentId());
            Object treeSet = treeMap.get(lValueOf);
            if (treeSet == null) {
                treeSet = new TreeSet(ChannelUtils.m7684h(Channel.INSTANCE));
                treeMap.put(lValueOf, treeSet);
            }
            ((Set) treeSet).add(channel);
        }
        return treeMap;
    }

    public final List<Channel> getSortedVisibleChannels(Map<Long, Channel> guildChannels) {
        Intrinsics3.checkNotNullParameter(guildChannels, "guildChannels");
        Map<Long, Collection<Channel>> sortedCategories = getSortedCategories(guildChannels);
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Long, Collection<Channel>>> it = sortedCategories.entrySet().iterator();
        while (it.hasNext()) {
            Collection<Channel> value = it.next().getValue();
            List arrayList2 = new ArrayList();
            for (Object obj : value) {
                Channel channel = (Channel) obj;
                if (PermissionUtils.INSTANCE.hasAccess(channel, (Long) outline.m845d(channel, this.channelPermissions))) {
                    arrayList2.add(obj);
                }
            }
            if (arrayList2.size() == 1) {
                arrayList2 = Collections2.emptyList();
            }
            MutableCollections.addAll(arrayList, arrayList2);
        }
        return arrayList;
    }

    public final boolean getUnelevated() {
        return this.unelevated;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        GuildRole guildRole = this.everyoneRole;
        int iHashCode2 = (iHashCode + (guildRole != null ? guildRole.hashCode() : 0)) * 31;
        ModelNotificationSettings modelNotificationSettings = this.notificationSettings;
        int iHashCode3 = (iHashCode2 + (modelNotificationSettings != null ? modelNotificationSettings.hashCode() : 0)) * 31;
        boolean z2 = this.hideMutedChannels;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode3 + i) * 31;
        Map<Long, Long> map = this.channelPermissions;
        int iHashCode4 = (i2 + (map != null ? map.hashCode() : 0)) * 31;
        boolean z3 = this.ableToInstantInvite;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (iHashCode4 + i3) * 31;
        boolean z4 = this.unelevated;
        int i5 = z4;
        if (z4 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        boolean z5 = this.isVerifiedServer;
        int i7 = z5;
        if (z5 != 0) {
            i7 = 1;
        }
        int i8 = (i6 + i7) * 31;
        PermissionsContexts permissionsContexts = this.manageGuildContext;
        int iHashCode5 = (i8 + (permissionsContexts != null ? permissionsContexts.hashCode() : 0)) * 31;
        boolean z6 = this.canChangeNickname;
        int i9 = (iHashCode5 + (z6 ? 1 : z6 ? 1 : 0)) * 31;
        Map<Long, GuildRole> map2 = this.guildRoles;
        return i9 + (map2 != null ? map2.hashCode() : 0);
    }

    public final boolean isVerifiedServer() {
        return this.isVerifiedServer;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("GuildChannelsInfo(guild=");
        sbM833U.append(this.guild);
        sbM833U.append(", everyoneRole=");
        sbM833U.append(this.everyoneRole);
        sbM833U.append(", notificationSettings=");
        sbM833U.append(this.notificationSettings);
        sbM833U.append(", hideMutedChannels=");
        sbM833U.append(this.hideMutedChannels);
        sbM833U.append(", channelPermissions=");
        sbM833U.append(this.channelPermissions);
        sbM833U.append(", ableToInstantInvite=");
        sbM833U.append(this.ableToInstantInvite);
        sbM833U.append(", unelevated=");
        sbM833U.append(this.unelevated);
        sbM833U.append(", isVerifiedServer=");
        sbM833U.append(this.isVerifiedServer);
        sbM833U.append(", manageGuildContext=");
        sbM833U.append(this.manageGuildContext);
        sbM833U.append(", canChangeNickname=");
        sbM833U.append(this.canChangeNickname);
        sbM833U.append(", guildRoles=");
        return outline.m825M(sbM833U, this.guildRoles, ")");
    }
}
