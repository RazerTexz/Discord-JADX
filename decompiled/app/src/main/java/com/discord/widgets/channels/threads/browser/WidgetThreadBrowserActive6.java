package com.discord.widgets.channels.threads.browser;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetThreadBrowserActive.kt */
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActive$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserActive6 extends Lambda implements Function0<WidgetThreadBrowserActiveViewModel> {
    public final /* synthetic */ WidgetThreadBrowserActive this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserActive6(WidgetThreadBrowserActive widgetThreadBrowserActive) {
        super(0);
        this.this$0 = widgetThreadBrowserActive;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetThreadBrowserActiveViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetThreadBrowserActiveViewModel invoke() {
        return new WidgetThreadBrowserActiveViewModel(WidgetThreadBrowserActive.access$getGuildId$p(this.this$0), WidgetThreadBrowserActive.access$getChannelId$p(this.this$0), null, null, null, null, null, null, null, null, null, 2044, null);
    }
}
