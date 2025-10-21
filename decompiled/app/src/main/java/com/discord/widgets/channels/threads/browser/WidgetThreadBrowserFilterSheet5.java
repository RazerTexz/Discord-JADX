package com.discord.widgets.channels.threads.browser;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetThreadBrowserFilterSheet.kt */
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserFilterSheet$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserFilterSheet5 extends Lambda implements Function0<WidgetThreadBrowserArchivedViewModel> {
    public final /* synthetic */ WidgetThreadBrowserFilterSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserFilterSheet5(WidgetThreadBrowserFilterSheet widgetThreadBrowserFilterSheet) {
        super(0);
        this.this$0 = widgetThreadBrowserFilterSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetThreadBrowserArchivedViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetThreadBrowserArchivedViewModel invoke() {
        return new WidgetThreadBrowserArchivedViewModel(WidgetThreadBrowserFilterSheet.access$getGuildId$p(this.this$0), WidgetThreadBrowserFilterSheet.access$getChannelId$p(this.this$0), null, null, null, null, null, null, 252, null);
    }
}
