package com.discord.widgets.guildscheduledevent;

import android.view.View;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities2;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel;

/* compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsExtrasBottomSheet3 implements View.OnClickListener {
    public final /* synthetic */ boolean $canManageEvent$inlined;
    public final /* synthetic */ GuildScheduledEventUtilities2 $eventTiming$inlined;
    public final /* synthetic */ GuildScheduledEventDetailsViewModel.ViewState $viewState$inlined;
    public final /* synthetic */ WidgetGuildScheduledEventDetailsExtrasBottomSheet this$0;

    public WidgetGuildScheduledEventDetailsExtrasBottomSheet3(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet, boolean z2, GuildScheduledEventUtilities2 guildScheduledEventUtilities2, GuildScheduledEventDetailsViewModel.ViewState viewState) {
        this.this$0 = widgetGuildScheduledEventDetailsExtrasBottomSheet;
        this.$canManageEvent$inlined = z2;
        this.$eventTiming$inlined = guildScheduledEventUtilities2;
        this.$viewState$inlined = viewState;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGuildScheduledEventDetailsExtrasBottomSheet.access$getViewModel$p(this.this$0).onRsvpButtonClicked();
    }
}
