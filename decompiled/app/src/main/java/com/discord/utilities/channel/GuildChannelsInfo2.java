package com.discord.utilities.channel;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildFeature;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.permissions.PermissionsContexts;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func8;

/* JADX INFO: renamed from: com.discord.utilities.channel.GuildChannelsInfo$Companion$get$1, reason: use source file name */
/* JADX INFO: compiled from: GuildChannelsInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildChannelsInfo2<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Func8<MeUser, Guild, ModelNotificationSettings, Boolean, Map<Long, ? extends GuildRole>, Long, Map<Long, ? extends Long>, List<? extends Channel>, GuildChannelsInfo> {
    public static final GuildChannelsInfo2 INSTANCE = new GuildChannelsInfo2();

    @Override // p658rx.functions.Func8
    public /* bridge */ /* synthetic */ GuildChannelsInfo call(MeUser meUser, Guild guild, ModelNotificationSettings modelNotificationSettings, Boolean bool, Map<Long, ? extends GuildRole> map, Long l, Map<Long, ? extends Long> map2, List<? extends Channel> list) {
        return call2(meUser, guild, modelNotificationSettings, bool, (Map<Long, GuildRole>) map, l, (Map<Long, Long>) map2, (List<Channel>) list);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0042  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final GuildChannelsInfo call2(MeUser meUser, Guild guild, ModelNotificationSettings modelNotificationSettings, Boolean bool, Map<Long, GuildRole> map, Long l, Map<Long, Long> map2, List<Channel> list) {
        boolean z2;
        Set<GuildFeature> features;
        boolean z3 = meUser != null && meUser.getMfaEnabled();
        int mfaLevel = guild != null ? guild.getMfaLevel() : 0;
        boolean zIsElevated = PermissionUtils.isElevated(16L, z3, mfaLevel);
        boolean z4 = zIsElevated && PermissionUtils.can(16L, l);
        if (PermissionUtils.can(1L, l)) {
            z2 = true;
        } else {
            if ((guild != null ? guild.getVanityUrlCode() : null) == null) {
                z2 = false;
            }
        }
        GuildRole guildRole = guild != null ? (GuildRole) outline.m847e(guild, map) : null;
        boolean z5 = !zIsElevated && z4;
        boolean zContains = (guild == null || (features = guild.getFeatures()) == null) ? false : features.contains(GuildFeature.VERIFIED);
        PermissionsContexts.Companion companion = PermissionsContexts.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(list, "categories");
        boolean z6 = ((guild != null ? Long.valueOf(guild.getOwnerId()) : null) == null || meUser == null || meUser.getId() != guild.getOwnerId()) ? false : true;
        Intrinsics3.checkNotNullExpressionValue(map2, "channelPermissions");
        PermissionsContexts permissionsContextsFrom = companion.from(list, z6, l, map2, mfaLevel, meUser != null ? meUser.getMfaEnabled() : false);
        boolean zCan = PermissionUtils.can(Permission.CHANGE_NICKNAME, l);
        Intrinsics3.checkNotNullExpressionValue(modelNotificationSettings, "guildSettings");
        Intrinsics3.checkNotNullExpressionValue(bool, "hideMuted");
        return new GuildChannelsInfo(guild, guildRole, modelNotificationSettings, bool.booleanValue(), map2, z2, z5, zContains, permissionsContextsFrom, zCan, map);
    }
}
