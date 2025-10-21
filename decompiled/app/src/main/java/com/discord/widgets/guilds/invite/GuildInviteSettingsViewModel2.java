package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite;
import com.discord.widgets.guilds.invite.GuildInviteSettingsViewModel;
import d0.z.d.Intrinsics3;
import java.util.Map;
import rx.functions.Func2;

/* compiled from: GuildInviteSettingsViewModel.kt */
/* renamed from: com.discord.widgets.guilds.invite.GuildInviteSettingsViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildInviteSettingsViewModel2<T1, T2, R> implements Func2<ModelInvite.Settings, Map<Long, ? extends Channel>, GuildInviteSettingsViewModel.StoreState> {
    public static final GuildInviteSettingsViewModel2 INSTANCE = new GuildInviteSettingsViewModel2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ GuildInviteSettingsViewModel.StoreState call(ModelInvite.Settings settings, Map<Long, ? extends Channel> map) {
        return call2(settings, (Map<Long, Channel>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildInviteSettingsViewModel.StoreState call2(ModelInvite.Settings settings, Map<Long, Channel> map) {
        Intrinsics3.checkNotNullExpressionValue(settings, "inviteSettings");
        Intrinsics3.checkNotNullExpressionValue(map, "invitableChannels");
        return new GuildInviteSettingsViewModel.StoreState(settings, map);
    }
}
