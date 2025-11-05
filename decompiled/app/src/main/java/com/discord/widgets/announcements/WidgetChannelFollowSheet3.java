package com.discord.widgets.announcements;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChannelFollowSheet.kt */
/* renamed from: com.discord.widgets.announcements.WidgetChannelFollowSheet$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelFollowSheet3 extends Lambda implements Function0<WidgetChannelFollowSheetViewModel> {
    public final /* synthetic */ WidgetChannelFollowSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelFollowSheet3(WidgetChannelFollowSheet widgetChannelFollowSheet) {
        super(0);
        this.this$0 = widgetChannelFollowSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChannelFollowSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelFollowSheetViewModel invoke() {
        return new WidgetChannelFollowSheetViewModel(WidgetChannelFollowSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_GUILD_ID"), WidgetChannelFollowSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID"), null, null, null, 28, null);
    }
}
