package com.discord.widgets.voice.fullscreen;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreenViewModel;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetCallFullscreen.kt */
/* loaded from: classes.dex */
public final class WidgetCallFullscreen$configureActionBar$$inlined$let$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ GuildScheduledEvent $activeEvent$inlined;
    public final /* synthetic */ WidgetCallFullscreenViewModel.ViewState.Valid $viewState$inlined;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$configureActionBar$$inlined$let$lambda$1(GuildScheduledEvent guildScheduledEvent, WidgetCallFullscreen widgetCallFullscreen, WidgetCallFullscreenViewModel.ViewState.Valid valid) {
        this.$activeEvent$inlined = guildScheduledEvent;
        this.this$0 = widgetCallFullscreen;
        this.$viewState$inlined = valid;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.showForGuild(parentFragmentManager, this.$activeEvent$inlined.getId());
    }
}
