package com.discord.widgets.hubs;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetHubAddName.kt */
/* renamed from: com.discord.widgets.hubs.WidgetHubAddName$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubAddName4 extends Lambda implements Function0<WidgetHubAddNameViewModel> {
    public final /* synthetic */ WidgetHubAddName this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddName4(WidgetHubAddName widgetHubAddName) {
        super(0);
        this.this$0 = widgetHubAddName;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetHubAddNameViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubAddNameViewModel invoke() {
        return new WidgetHubAddNameViewModel(this.this$0.getArgs().getGuildId(), null, null, null, 14, null);
    }
}
