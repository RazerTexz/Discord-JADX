package com.discord.widgets.forums;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.forums.WidgetForumBrowserViewModel;
import com.discord.widgets.forums.WidgetForumGuidelinesBottomSheet;
import d0.z.d.m;

/* compiled from: WidgetForumBrowser.kt */
/* loaded from: classes2.dex */
public final class WidgetForumBrowser$configureGuidelinesButton$$inlined$apply$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ WidgetForumBrowserViewModel.ViewState.Loaded $viewState$inlined;
    public final /* synthetic */ WidgetForumBrowser this$0;

    public WidgetForumBrowser$configureGuidelinesButton$$inlined$apply$lambda$1(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel.ViewState.Loaded loaded) {
        this.this$0 = widgetForumBrowser;
        this.$viewState$inlined = loaded;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetForumGuidelinesBottomSheet.Companion companion = WidgetForumGuidelinesBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, this.$viewState$inlined.getGuildId(), this.$viewState$inlined.getChannelId(), "CLOSE_FORUM_GUIDELINES_NOOP_REQUEST_KEY");
    }
}
