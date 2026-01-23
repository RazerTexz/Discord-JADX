package com.discord.widgets.guilds.join;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildWelcomeScreens;
import com.discord.widgets.guilds.join.WidgetGuildWelcomeSheetViewModel;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: com.discord.widgets.guilds.join.WidgetGuildWelcomeSheetViewModel$Companion$observeStores$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildWelcomeSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheetViewModel2<T1, T2, R> implements Func2<Guild, StoreGuildWelcomeScreens.State, WidgetGuildWelcomeSheetViewModel.StoreState> {
    public static final WidgetGuildWelcomeSheetViewModel2 INSTANCE = new WidgetGuildWelcomeSheetViewModel2();

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetGuildWelcomeSheetViewModel.StoreState call(Guild guild, StoreGuildWelcomeScreens.State state) {
        return call2(guild, state);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGuildWelcomeSheetViewModel.StoreState call2(Guild guild, StoreGuildWelcomeScreens.State state) {
        return new WidgetGuildWelcomeSheetViewModel.StoreState(guild, state);
    }
}
