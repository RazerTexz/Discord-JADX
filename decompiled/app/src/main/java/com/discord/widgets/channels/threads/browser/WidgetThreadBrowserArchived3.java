package com.discord.widgets.channels.threads.browser;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetThreadBrowserArchived.kt */
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchived$browserViewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserArchived3 extends Lambda implements Function0<WidgetThreadBrowserViewModel> {
    public final /* synthetic */ WidgetThreadBrowserArchived this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserArchived3(WidgetThreadBrowserArchived widgetThreadBrowserArchived) {
        super(0);
        this.this$0 = widgetThreadBrowserArchived;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetThreadBrowserViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetThreadBrowserViewModel invoke() {
        return new WidgetThreadBrowserViewModel(WidgetThreadBrowserArchived.access$getGuildId$p(this.this$0), WidgetThreadBrowserArchived.access$getChannelId$p(this.this$0), null, null, null, null, 60, null);
    }
}
