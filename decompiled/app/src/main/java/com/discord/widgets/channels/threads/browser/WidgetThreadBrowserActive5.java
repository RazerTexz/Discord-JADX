package com.discord.widgets.channels.threads.browser;

import android.os.Bundle;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetThreadBrowserActive.kt */
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActive$guildId$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserActive5 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetThreadBrowserActive this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserActive5(WidgetThreadBrowserActive widgetThreadBrowserActive) {
        super(0);
        this.this$0 = widgetThreadBrowserActive;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        Bundle arguments = this.this$0.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        return arguments.getLong("com.discord.intent.extra.EXTRA_GUILD_ID");
    }
}
