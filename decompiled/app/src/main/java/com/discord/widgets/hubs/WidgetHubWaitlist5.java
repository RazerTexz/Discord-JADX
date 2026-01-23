package com.discord.widgets.hubs;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubWaitlist$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubWaitlist.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubWaitlist5 extends Lambda implements Function0<WidgetHubWaitlistViewModel> {
    public final /* synthetic */ WidgetHubWaitlist this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubWaitlist5(WidgetHubWaitlist widgetHubWaitlist) {
        super(0);
        this.this$0 = widgetHubWaitlist;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetHubWaitlistViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubWaitlistViewModel invoke() {
        return new WidgetHubWaitlistViewModel(this.this$0.getArgs().getEmail(), null, 2, null);
    }
}
