package com.discord.widgets.channels.threads.browser;

import android.view.View;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserAdapter;

/* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserAdapter$ThreadItem$onConfigure$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserAdapter3 implements View.OnLongClickListener {
    public final /* synthetic */ WidgetThreadBrowserAdapter.Item.Thread $item;
    public final /* synthetic */ WidgetThreadBrowserAdapter.ThreadItem this$0;

    public WidgetThreadBrowserAdapter3(WidgetThreadBrowserAdapter.ThreadItem threadItem, WidgetThreadBrowserAdapter.Item.Thread thread) {
        this.this$0 = threadItem;
        this.$item = thread;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        WidgetThreadBrowserAdapter.ThreadItem.access$getAdapter$p(this.this$0).onThreadLongClicked(this.$item.getThreadData().getChannel());
        return true;
    }
}
