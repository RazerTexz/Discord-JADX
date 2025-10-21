package com.discord.widgets.guilds.join;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildWelcomeScreens;
import com.discord.widgets.guilds.join.WidgetGuildWelcomeSheetViewModel;
import rx.functions.Func2;

/* compiled from: WidgetGuildWelcomeSheetViewModel.kt */
/* renamed from: com.discord.widgets.guilds.join.WidgetGuildWelcomeSheetViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheetViewModel2<T1, T2, R> implements Func2<Guild, StoreGuildWelcomeScreens.State, WidgetGuildWelcomeSheetViewModel.StoreState> {
    public static final WidgetGuildWelcomeSheetViewModel2 INSTANCE = new WidgetGuildWelcomeSheetViewModel2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetGuildWelcomeSheetViewModel.StoreState call(Guild guild, StoreGuildWelcomeScreens.State state) {
        return call2(guild, state);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGuildWelcomeSheetViewModel.StoreState call2(Guild guild, StoreGuildWelcomeScreens.State state) {
        return new WidgetGuildWelcomeSheetViewModel.StoreState(guild, state);
    }
}
