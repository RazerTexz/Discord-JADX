package com.discord.widgets.channels.permissions;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChannelSettingsEditPermissions.kt */
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions$channelId$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsEditPermissions3 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetChannelSettingsEditPermissions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsEditPermissions3(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions) {
        super(0);
        this.this$0 = widgetChannelSettingsEditPermissions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.this$0.getMostRecentIntent().getLongExtra("INTENT_EXTRA_CHANNEL_ID", -1L);
    }
}
