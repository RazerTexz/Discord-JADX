package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.VanityUrlResponse;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.servers.WidgetServerSettingsVanityUrl;
import d0.z.d.Intrinsics3;
import rx.functions.Func4;

/* compiled from: WidgetServerSettingsVanityUrl.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsVanityUrl$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsVanityUrl2<T1, T2, T3, T4, R> implements Func4<MeUser, Long, Guild, VanityUrlResponse, WidgetServerSettingsVanityUrl.Model> {
    public final /* synthetic */ long $guildId;

    public WidgetServerSettingsVanityUrl2(long j) {
        this.$guildId = j;
    }

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ WidgetServerSettingsVanityUrl.Model call(MeUser meUser, Long l, Guild guild, VanityUrlResponse vanityUrlResponse) {
        return call2(meUser, l, guild, vanityUrlResponse);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsVanityUrl.Model call2(MeUser meUser, Long l, Guild guild, VanityUrlResponse vanityUrlResponse) {
        Intrinsics3.checkNotNullParameter(meUser, "meUser");
        int uses = vanityUrlResponse.getUses();
        if (l == null || guild == null || !guild.canHaveVanityURL()) {
            return null;
        }
        if (guild.isOwner(meUser.getId()) || PermissionUtils.can(32L, l)) {
            return new WidgetServerSettingsVanityUrl.Model(this.$guildId, guild.getName(), guild.getVanityUrlCode(), uses);
        }
        return null;
    }
}
