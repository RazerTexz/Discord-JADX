package com.discord.widgets.guilds.leave;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func2;

/* compiled from: LeaveGuildDialogViewModel.kt */
/* renamed from: com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class LeaveGuildDialogViewModel2<T1, T2, R> implements Func2<Guild, Boolean, LeaveGuildDialogViewModel.StoreState> {
    public static final LeaveGuildDialogViewModel2 INSTANCE = new LeaveGuildDialogViewModel2();

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ LeaveGuildDialogViewModel.StoreState call(Guild guild, Boolean bool) {
        return call2(guild, bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final LeaveGuildDialogViewModel.StoreState call2(Guild guild, Boolean bool) {
        if (guild == null) {
            return LeaveGuildDialogViewModel.StoreState.Invalid.INSTANCE;
        }
        Intrinsics3.checkNotNullExpressionValue(bool, "isLurking");
        return new LeaveGuildDialogViewModel.StoreState.Valid(guild, bool.booleanValue());
    }
}
