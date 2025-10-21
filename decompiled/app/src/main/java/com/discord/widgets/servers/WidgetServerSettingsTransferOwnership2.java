package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.widgets.servers.WidgetServerSettingsTransferOwnership;
import rx.functions.Func3;

/* compiled from: WidgetServerSettingsTransferOwnership.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsTransferOwnership$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsTransferOwnership2<T1, T2, T3, R> implements Func3<Guild, User, MeUser, WidgetServerSettingsTransferOwnership.Model> {
    public static final WidgetServerSettingsTransferOwnership2 INSTANCE = new WidgetServerSettingsTransferOwnership2();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetServerSettingsTransferOwnership.Model call(Guild guild, User user, MeUser meUser) {
        return call2(guild, user, meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsTransferOwnership.Model call2(Guild guild, User user, MeUser meUser) {
        if (guild == null || meUser == null || user == null) {
            return null;
        }
        return new WidgetServerSettingsTransferOwnership.Model(user, guild, meUser.getMfaEnabled(), guild.getOwnerId() == meUser.getId());
    }
}
