package com.discord.widgets.forums;

import android.view.View;
import com.discord.widgets.forums.ForumBrowserItem;
import com.discord.widgets.forums.WidgetForumBrowserAdapter;

/* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowserAdapter$PostItem$onConfigure$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetForumBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserAdapter2 implements View.OnClickListener {
    public final /* synthetic */ ForumBrowserItem.PostItem $item;
    public final /* synthetic */ WidgetForumBrowserAdapter.PostItem this$0;

    public WidgetForumBrowserAdapter2(WidgetForumBrowserAdapter.PostItem postItem, ForumBrowserItem.PostItem postItem2) {
        this.this$0 = postItem;
        this.$item = postItem2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetForumBrowserAdapter.access$getOnPostClick$p(WidgetForumBrowserAdapter.PostItem.access$getAdapter$p(this.this$0)).invoke(this.$item.getPost().getChannel());
    }
}
