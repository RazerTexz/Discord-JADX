package com.discord.widgets.channels.permissions;

import android.os.Bundle;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChannelSettingsAddMemberFragment.kt */
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$channelId$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragment4 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetChannelSettingsAddMemberFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsAddMemberFragment4(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        super(0);
        this.this$0 = widgetChannelSettingsAddMemberFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        Bundle arguments = this.this$0.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        return arguments.getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID");
    }
}
