package com.discord.utilities.guilds;

import com.discord.api.role.GuildRole;
import com.discord.utilities.time.TimeUtils;
import java.util.Comparator;

/* compiled from: RoleUtils.kt */
/* renamed from: com.discord.utilities.guilds.RoleUtils$ROLE_COMPARATOR$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class RoleUtils2 implements Comparator<GuildRole> {
    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(GuildRole guildRole, GuildRole guildRole2) {
        return compare2(guildRole, guildRole2);
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(GuildRole role1, GuildRole role2) {
        if (role1 != null && role2 != null) {
            int position = role1.getPosition();
            int position2 = role2.getPosition();
            return position2 != position ? position2 - position : (TimeUtils.parseSnowflake(Long.valueOf(role1.getId())) > TimeUtils.parseSnowflake(Long.valueOf(role2.getId())) ? 1 : (TimeUtils.parseSnowflake(Long.valueOf(role1.getId())) == TimeUtils.parseSnowflake(Long.valueOf(role2.getId())) ? 0 : -1));
        }
        if (role1 == null || role2 != null) {
            return (role1 != null || role2 == null) ? 0 : 1;
        }
        return -1;
    }
}
