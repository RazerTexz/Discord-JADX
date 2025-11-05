package com.discord.widgets.forums;

import com.discord.widgets.forums.WidgetForumBrowserViewModel;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetForumBrowser.kt */
/* renamed from: com.discord.widgets.forums.WidgetForumBrowser$configureListState$$inlined$apply$lambda$4, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetForumBrowser8 extends Lambda implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetForumBrowserViewModel.ViewState.Loaded $viewState$inlined;
    public final /* synthetic */ WidgetForumBrowser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowser8(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel.ViewState.Loaded loaded) {
        super(1);
        this.this$0 = widgetForumBrowser;
        this.$viewState$inlined = loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        WidgetForumBrowser.access$enqueueForumPostFirstMessageFetches(this.this$0, this.$viewState$inlined.getChannelId(), this.$viewState$inlined.getGuildId());
        if (i == 0) {
            WidgetForumBrowserViewModel.maybeFetchForumPostFirstMessages$default(WidgetForumBrowser.access$getViewModel$p(this.this$0), this.$viewState$inlined.getChannelId(), this.$viewState$inlined.getGuildId(), false, 4, null);
        }
    }
}
