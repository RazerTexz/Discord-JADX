package com.discord.widgets.channels.permissions;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetStageChannelModeratorPermissions.kt */
/* renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$channelId$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissions2 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetStageChannelModeratorPermissions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageChannelModeratorPermissions2(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
        super(0);
        this.this$0 = widgetStageChannelModeratorPermissions;
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
