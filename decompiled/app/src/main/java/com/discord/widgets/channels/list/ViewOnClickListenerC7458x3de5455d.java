package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$6 */
/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewOnClickListenerC7458x3de5455d implements View.OnClickListener {
    public final /* synthetic */ WidgetChannelsListItemChannelActions.Model $this_configureUI$inlined;

    public ViewOnClickListenerC7458x3de5455d(WidgetChannelsListItemChannelActions.Model model) {
        this.$this_configureUI$inlined = model;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChannelNotificationSettings.Companion.launch$default(WidgetChannelNotificationSettings.INSTANCE, outline.m885x(view, "it", "it.context"), this.$this_configureUI$inlined.getChannel().getId(), false, 4, null);
    }
}
