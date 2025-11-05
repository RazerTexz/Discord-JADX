package com.discord.widgets.forums;

import android.view.View;
import com.discord.widgets.forums.WidgetForumBrowserViewModel;

/* compiled from: WidgetForumBrowser.kt */
/* renamed from: com.discord.widgets.forums.WidgetForumBrowser$configureCreatePostButton$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetForumBrowser3 implements View.OnClickListener {
    public final /* synthetic */ boolean $hasForumGuidelines;
    public final /* synthetic */ WidgetForumBrowserViewModel.ViewState.Loaded $viewState$inlined;
    public final /* synthetic */ WidgetForumBrowser this$0;

    public WidgetForumBrowser3(boolean z2, WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel.ViewState.Loaded loaded) {
        this.$hasForumGuidelines = z2;
        this.this$0 = widgetForumBrowser;
        this.$viewState$inlined = loaded;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetForumBrowser.access$onCreatePostClick(this.this$0, this.$viewState$inlined.getGuildId(), this.$viewState$inlined.getChannelId(), this.$hasForumGuidelines);
    }
}
