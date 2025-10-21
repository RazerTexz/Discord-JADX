package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.servers.WidgetServerSettingsModeration;
import d0.z.d.Intrinsics3;
import rx.functions.Func3;

/* compiled from: WidgetServerSettingsModeration.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsModeration2<T1, T2, T3, R> implements Func3<Guild, MeUser, Long, WidgetServerSettingsModeration.Model> {
    public static final WidgetServerSettingsModeration2 INSTANCE = new WidgetServerSettingsModeration2();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetServerSettingsModeration.Model call(Guild guild, MeUser meUser, Long l) {
        return call2(guild, meUser, l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsModeration.Model call2(Guild guild, MeUser meUser, Long l) {
        Intrinsics3.checkNotNullParameter(meUser, "me");
        if (guild == null) {
            return null;
        }
        if (guild.isOwner(meUser.getId()) || PermissionUtils.canAndIsElevated(32L, l, meUser.getMfaEnabled(), guild.getMfaLevel())) {
            return new WidgetServerSettingsModeration.Model(guild);
        }
        return null;
    }
}
