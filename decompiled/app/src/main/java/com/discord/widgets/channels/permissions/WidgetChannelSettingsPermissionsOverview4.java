package com.discord.widgets.channels.permissions;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverview4 extends Lambda implements Function0<WidgetChannelSettingsPermissionsOverviewViewModel> {
    public final /* synthetic */ WidgetChannelSettingsPermissionsOverview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsPermissionsOverview4(WidgetChannelSettingsPermissionsOverview widgetChannelSettingsPermissionsOverview) {
        super(0);
        this.this$0 = widgetChannelSettingsPermissionsOverview;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChannelSettingsPermissionsOverviewViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelSettingsPermissionsOverviewViewModel invoke() {
        long jAccess$getChannelIdFromIntent = WidgetChannelSettingsPermissionsOverview.access$getChannelIdFromIntent(this.this$0);
        Channel channel = StoreStream.INSTANCE.getChannels().getChannel(jAccess$getChannelIdFromIntent);
        return new WidgetChannelSettingsPermissionsOverviewViewModel(jAccess$getChannelIdFromIntent, channel != null && channel.getType() == 13);
    }
}
