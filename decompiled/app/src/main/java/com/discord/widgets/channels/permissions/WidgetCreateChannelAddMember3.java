package com.discord.widgets.channels.permissions;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetCreateChannelAddMember.kt */
/* renamed from: com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember$channelId$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetCreateChannelAddMember3 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetCreateChannelAddMember this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreateChannelAddMember3(WidgetCreateChannelAddMember widgetCreateChannelAddMember) {
        super(0);
        this.this$0 = widgetCreateChannelAddMember;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.this$0.getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
    }
}
