package com.discord.widgets.forums;

import com.discord.widgets.forums.WidgetForumBrowserViewModel;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetForumBrowser.kt */
/* loaded from: classes2.dex */
public final class WidgetForumBrowser$configureListState$$inlined$apply$lambda$2 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetForumBrowserViewModel.ViewState.Loaded $viewState$inlined;
    public final /* synthetic */ WidgetForumBrowser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowser$configureListState$$inlined$apply$lambda$2(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel.ViewState.Loaded loaded) {
        super(0);
        this.this$0 = widgetForumBrowser;
        this.$viewState$inlined = loaded;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetForumBrowser.access$enqueueForumPostFirstMessageFetches(this.this$0, this.$viewState$inlined.getChannelId(), this.$viewState$inlined.getGuildId());
    }
}
