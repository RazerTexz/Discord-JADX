package com.discord.widgets.guilds.profile;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheetViewModel;
import d0.z.d.Intrinsics3;
import rx.functions.Action1;

/* compiled from: WidgetGuildProfileSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$6<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetGuildProfileSheetViewModel.Actions $actions$inlined;
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    public WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$6(WidgetGuildProfileSheet widgetGuildProfileSheet, WidgetGuildProfileSheetViewModel.Actions actions, long j) {
        this.this$0 = widgetGuildProfileSheet;
        this.$actions$inlined = actions;
        this.$guildId$inlined = j;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        WidgetGuildProfileSheetViewModel widgetGuildProfileSheetViewModelAccess$getViewModel$p = WidgetGuildProfileSheet.access$getViewModel$p(this.this$0);
        long j = this.$guildId$inlined;
        Intrinsics3.checkNotNullExpressionValue(bool, "checked");
        widgetGuildProfileSheetViewModelAccess$getViewModel$p.setHideMutedChannels(j, bool.booleanValue());
    }
}
