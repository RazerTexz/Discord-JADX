package com.discord.widgets.forums;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.forums.WidgetForumBrowserViewModel;
import com.discord.widgets.forums.WidgetForumGuidelinesBottomSheet;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetForumBrowser.kt */
/* renamed from: com.discord.widgets.forums.WidgetForumBrowser$configureGuidelinesButton$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetForumBrowser4 implements View.OnClickListener {
    public final /* synthetic */ WidgetForumBrowserViewModel.ViewState.Loaded $viewState$inlined;
    public final /* synthetic */ WidgetForumBrowser this$0;

    public WidgetForumBrowser4(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel.ViewState.Loaded loaded) {
        this.this$0 = widgetForumBrowser;
        this.$viewState$inlined = loaded;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetForumGuidelinesBottomSheet.Companion companion = WidgetForumGuidelinesBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, this.$viewState$inlined.getGuildId(), this.$viewState$inlined.getChannelId(), "CLOSE_FORUM_GUIDELINES_NOOP_REQUEST_KEY");
    }
}
