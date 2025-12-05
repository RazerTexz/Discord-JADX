package com.discord.widgets.share;

import com.discord.widgets.share.WidgetIncomingShare;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetIncomingShare.kt */
/* renamed from: com.discord.widgets.share.WidgetIncomingShare$configureUi$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetIncomingShare4 extends Lambda implements Function2<List<? extends WidgetGlobalSearchModel.ItemDataPayload>, List<? extends WidgetGlobalSearchModel.ItemDataPayload>, Unit> {
    public final /* synthetic */ WidgetIncomingShare.Model $this_configureUi$inlined;
    public final /* synthetic */ WidgetIncomingShare this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIncomingShare4(WidgetIncomingShare widgetIncomingShare, WidgetIncomingShare.Model model) {
        super(2);
        this.this$0 = widgetIncomingShare;
        this.$this_configureUi$inlined = model;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends WidgetGlobalSearchModel.ItemDataPayload> list, List<? extends WidgetGlobalSearchModel.ItemDataPayload> list2) {
        invoke2(list, list2);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends WidgetGlobalSearchModel.ItemDataPayload> list, List<? extends WidgetGlobalSearchModel.ItemDataPayload> list2) {
        Intrinsics3.checkNotNullParameter(list, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(list2, "<anonymous parameter 1>");
        if (!Intrinsics3.areEqual(WidgetIncomingShare.access$getQueryString$p(this.this$0), this.$this_configureUi$inlined.getSearchModel().getFilter())) {
            WidgetIncomingShare.access$getBinding$p(this.this$0).f17199h.scrollToPosition(0);
            WidgetIncomingShare.access$setQueryString$p(this.this$0, this.$this_configureUi$inlined.getSearchModel().getFilter());
        }
    }
}
