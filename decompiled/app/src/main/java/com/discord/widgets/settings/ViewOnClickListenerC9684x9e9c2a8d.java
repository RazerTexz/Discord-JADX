package com.discord.widgets.settings;

import android.view.View;

/* compiled from: WidgetSettingsPrivacy.kt */
/* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$showDefaultGuildsRestrictedExistingServers$$inlined$apply$lambda$2 */
/* loaded from: classes2.dex */
public final class ViewOnClickListenerC9684x9e9c2a8d implements View.OnClickListener {
    public final /* synthetic */ boolean $defaultGuildsRestricted$inlined;
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    public ViewOnClickListenerC9684x9e9c2a8d(WidgetSettingsPrivacy widgetSettingsPrivacy, boolean z2) {
        this.this$0 = widgetSettingsPrivacy;
        this.$defaultGuildsRestricted$inlined = z2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSettingsPrivacy.access$updateDefaultGuildsRestricted(this.this$0, this.$defaultGuildsRestricted$inlined, true);
    }
}
