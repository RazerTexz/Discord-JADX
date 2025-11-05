package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildFeature;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.ManageGuildContext;
import com.discord.widgets.servers.WidgetServerSettings;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import rx.functions.Func6;

/* compiled from: WidgetServerSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettings$Model$Companion$get$1<T1, T2, T3, T4, T5, T6, R> implements Func6<MeUser, Guild, Long, List<? extends Channel>, Map<Long, ? extends Long>, Boolean, WidgetServerSettings.Model> {
    public static final WidgetServerSettings$Model$Companion$get$1 INSTANCE = new WidgetServerSettings$Model$Companion$get$1();

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ WidgetServerSettings.Model call(MeUser meUser, Guild guild, Long l, List<? extends Channel> list, Map<Long, ? extends Long> map, Boolean bool) {
        return call2(meUser, guild, l, (List<Channel>) list, (Map<Long, Long>) map, bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettings.Model call2(MeUser meUser, Guild guild, Long l, List<Channel> list, Map<Long, Long> map, Boolean bool) {
        if (guild == null) {
            return null;
        }
        ManageGuildContext.Companion companion = ManageGuildContext.INSTANCE;
        m.checkNotNullExpressionValue(list, "categories");
        boolean z2 = guild.getOwnerId() == meUser.getId();
        m.checkNotNullExpressionValue(map, "channelPermissions");
        ManageGuildContext manageGuildContextFrom = companion.from(list, z2, l, map, guild.getMfaLevel(), meUser.getMfaEnabled());
        boolean zHasFeature = guild.hasFeature(GuildFeature.ROLE_SUBSCRIPTIONS_ENABLED);
        m.checkNotNullExpressionValue(bool, "canGuildSeeRoleSubscriptionsSettings");
        return new WidgetServerSettings.Model(guild, manageGuildContextFrom, bool.booleanValue() && manageGuildContextFrom.getCanManageServer(), zHasFeature);
    }
}
