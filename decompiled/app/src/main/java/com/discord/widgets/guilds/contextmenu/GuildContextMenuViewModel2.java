package com.discord.widgets.guilds.contextmenu;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.widgets.guilds.contextmenu.GuildContextMenuViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func4;

/* compiled from: GuildContextMenuViewModel.kt */
/* renamed from: com.discord.widgets.guilds.contextmenu.GuildContextMenuViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildContextMenuViewModel2<T1, T2, T3, T4, R> implements Func4<Guild, MeUser, Boolean, Long, GuildContextMenuViewModel.StoreState> {
    public static final GuildContextMenuViewModel2 INSTANCE = new GuildContextMenuViewModel2();

    @Override // p658rx.functions.Func4
    public /* bridge */ /* synthetic */ GuildContextMenuViewModel.StoreState call(Guild guild, MeUser meUser, Boolean bool, Long l) {
        return call2(guild, meUser, bool, l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildContextMenuViewModel.StoreState call2(Guild guild, MeUser meUser, Boolean bool, Long l) {
        if (guild == null) {
            return GuildContextMenuViewModel.StoreState.Invalid.INSTANCE;
        }
        long id2 = meUser.getId();
        Intrinsics3.checkNotNullExpressionValue(bool, "isUnread");
        boolean zBooleanValue = bool.booleanValue();
        Intrinsics3.checkNotNullExpressionValue(l, "selectedGuildId");
        return new GuildContextMenuViewModel.StoreState.Valid(guild, id2, zBooleanValue, l.longValue());
    }
}
