package com.discord.widgets.hubs.events;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetHubEventsPage.kt */
/* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPage$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubEventsPage9 extends Lambda implements Function0<WidgetHubEventsViewModel> {
    public final /* synthetic */ WidgetHubEventsPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEventsPage9(WidgetHubEventsPage widgetHubEventsPage) {
        super(0);
        this.this$0 = widgetHubEventsPage;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetHubEventsViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubEventsViewModel invoke() {
        return new WidgetHubEventsViewModel(this.this$0.getArgs().getGuildId(), this.this$0.getArgs().getDirectoryChannelId(), null, null, null, null, null, null, null, 508, null);
    }
}
