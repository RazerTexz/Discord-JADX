package com.discord.widgets.channels.threads.browser;

import android.view.View;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserAdapter;

/* compiled from: WidgetThreadBrowserAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserAdapter$ThreadItem$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ WidgetThreadBrowserAdapter.Item.Thread $item;
    public final /* synthetic */ WidgetThreadBrowserAdapter.ThreadItem this$0;

    public WidgetThreadBrowserAdapter$ThreadItem$onConfigure$1(WidgetThreadBrowserAdapter.ThreadItem threadItem, WidgetThreadBrowserAdapter.Item.Thread thread) {
        this.this$0 = threadItem;
        this.$item = thread;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetThreadBrowserAdapter.ThreadItem.access$getAdapter$p(this.this$0).onThreadClicked(this.$item.getThreadData().getChannel());
    }
}
