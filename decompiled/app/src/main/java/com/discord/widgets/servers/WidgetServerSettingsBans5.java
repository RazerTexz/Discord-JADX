package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import rx.functions.Func3;

/* compiled from: WidgetServerSettingsBans.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Model$Companion$getCanManageBans$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsBans5<T1, T2, T3, R> implements Func3<Long, Guild, MeUser, Boolean> {
    public static final WidgetServerSettingsBans5 INSTANCE = new WidgetServerSettingsBans5();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ Boolean call(Long l, Guild guild, MeUser meUser) {
        return call2(l, guild, meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Long l, Guild guild, MeUser meUser) {
        return Boolean.valueOf((guild == null || l == null) ? false : PermissionUtils.canAndIsElevated(4L, l, meUser.getMfaEnabled(), guild.getMfaLevel()));
    }
}
