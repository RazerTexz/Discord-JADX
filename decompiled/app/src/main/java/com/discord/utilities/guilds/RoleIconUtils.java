package com.discord.utilities.guilds;

import com.discord.api.guild.GuildFeature;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import d0.z.d.Intrinsics3;

/* compiled from: RoleIconUtils.kt */
/* loaded from: classes2.dex */
public final class RoleIconUtils {
    public static final RoleIconUtils INSTANCE = new RoleIconUtils();

    private RoleIconUtils() {
    }

    public final boolean canUseRoleIcons(Guild guild, GuildRole guildRole) {
        Intrinsics3.checkNotNullParameter(guild, "$this$canUseRoleIcons");
        if (guild.hasFeature(GuildFeature.ROLE_ICONS)) {
            return true;
        }
        return guildRole != null && RoleUtils.hasSubscriptionListingId(guildRole);
    }
}
