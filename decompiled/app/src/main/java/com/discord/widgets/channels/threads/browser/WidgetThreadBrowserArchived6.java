package com.discord.widgets.channels.threads.browser;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetThreadBrowserArchived.kt */
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchived$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserArchived6 extends Lambda implements Function0<WidgetThreadBrowserArchivedViewModel> {
    public final /* synthetic */ WidgetThreadBrowserArchived this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserArchived6(WidgetThreadBrowserArchived widgetThreadBrowserArchived) {
        super(0);
        this.this$0 = widgetThreadBrowserArchived;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetThreadBrowserArchivedViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetThreadBrowserArchivedViewModel invoke() {
        return new WidgetThreadBrowserArchivedViewModel(WidgetThreadBrowserArchived.access$getGuildId$p(this.this$0), WidgetThreadBrowserArchived.access$getChannelId$p(this.this$0), null, null, null, null, null, null, 252, null);
    }
}
