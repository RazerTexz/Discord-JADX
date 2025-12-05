package com.discord.widgets.guildscheduledevent;

import android.content.res.Resources;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventCreateSuccess$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventCreateSuccess6 extends Lambda implements Function0<WidgetGuildScheduledEventCreateSuccessViewModel> {
    public final /* synthetic */ WidgetGuildScheduledEventCreateSuccess this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventCreateSuccess6(WidgetGuildScheduledEventCreateSuccess widgetGuildScheduledEventCreateSuccess) {
        super(0);
        this.this$0 = widgetGuildScheduledEventCreateSuccess;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetGuildScheduledEventCreateSuccessViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildScheduledEventCreateSuccessViewModel invoke() {
        Long lAccess$getChannelId$p = WidgetGuildScheduledEventCreateSuccess.access$getChannelId$p(this.this$0);
        long jAccess$getGuildId$p = WidgetGuildScheduledEventCreateSuccess.access$getGuildId$p(this.this$0);
        long jAccess$getGuildScheduledEventId$p = WidgetGuildScheduledEventCreateSuccess.access$getGuildScheduledEventId$p(this.this$0);
        Resources resources = this.this$0.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        return new WidgetGuildScheduledEventCreateSuccessViewModel(lAccess$getChannelId$p, jAccess$getGuildId$p, jAccess$getGuildScheduledEventId$p, null, null, null, null, null, null, null, null, resources, 2040, null);
    }
}
