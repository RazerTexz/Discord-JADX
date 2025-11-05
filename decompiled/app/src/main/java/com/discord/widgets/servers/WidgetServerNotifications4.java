package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildProfiles;
import com.discord.widgets.servers.WidgetServerNotifications;
import rx.functions.Func3;

/* compiled from: WidgetServerNotifications.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerNotifications$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerNotifications4<T1, T2, T3, R> implements Func3<Guild, ModelNotificationSettings, StoreGuildProfiles.GuildProfileData, WidgetServerNotifications.Model> {
    public static final WidgetServerNotifications4 INSTANCE = new WidgetServerNotifications4();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetServerNotifications.Model call(Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles.GuildProfileData guildProfileData) {
        return call2(guild, modelNotificationSettings, guildProfileData);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerNotifications.Model call2(Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles.GuildProfileData guildProfileData) {
        if (guild == null || modelNotificationSettings == null) {
            return null;
        }
        return new WidgetServerNotifications.Model(guild, modelNotificationSettings, guildProfileData);
    }
}
