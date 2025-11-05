package com.discord.widgets.channels.list;

import android.view.View;
import b.d.b.a.a;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;

/* compiled from: WidgetChannelsListItemChannelActions.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$6 implements View.OnClickListener {
    public final /* synthetic */ WidgetChannelsListItemChannelActions.Model $this_configureUI$inlined;

    public WidgetChannelsListItemChannelActions$configureUI$$inlined$apply$lambda$6(WidgetChannelsListItemChannelActions.Model model) {
        this.$this_configureUI$inlined = model;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChannelNotificationSettings.Companion.launch$default(WidgetChannelNotificationSettings.INSTANCE, a.x(view, "it", "it.context"), this.$this_configureUI$inlined.getChannel().getId(), false, 4, null);
    }
}
