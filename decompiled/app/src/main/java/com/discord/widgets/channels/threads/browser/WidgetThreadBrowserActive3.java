package com.discord.widgets.channels.threads.browser;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetThreadBrowserActive.kt */
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActive$browserViewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserActive3 extends Lambda implements Function0<WidgetThreadBrowserViewModel> {
    public final /* synthetic */ WidgetThreadBrowserActive this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserActive3(WidgetThreadBrowserActive widgetThreadBrowserActive) {
        super(0);
        this.this$0 = widgetThreadBrowserActive;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetThreadBrowserViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetThreadBrowserViewModel invoke() {
        return new WidgetThreadBrowserViewModel(WidgetThreadBrowserActive.access$getGuildId$p(this.this$0), WidgetThreadBrowserActive.access$getChannelId$p(this.this$0), null, null, null, null, 60, null);
    }
}
