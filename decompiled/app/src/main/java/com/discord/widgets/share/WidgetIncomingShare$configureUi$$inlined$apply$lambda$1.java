package com.discord.widgets.share;

import com.discord.widgets.share.WidgetIncomingShare;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetIncomingShare.kt */
/* loaded from: classes2.dex */
public final class WidgetIncomingShare$configureUi$$inlined$apply$lambda$1 extends o implements Function2<List<? extends WidgetGlobalSearchModel.ItemDataPayload>, List<? extends WidgetGlobalSearchModel.ItemDataPayload>, Unit> {
    public final /* synthetic */ WidgetIncomingShare.Model $this_configureUi$inlined;
    public final /* synthetic */ WidgetIncomingShare this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIncomingShare$configureUi$$inlined$apply$lambda$1(WidgetIncomingShare widgetIncomingShare, WidgetIncomingShare.Model model) {
        super(2);
        this.this$0 = widgetIncomingShare;
        this.$this_configureUi$inlined = model;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends WidgetGlobalSearchModel.ItemDataPayload> list, List<? extends WidgetGlobalSearchModel.ItemDataPayload> list2) {
        invoke2(list, list2);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends WidgetGlobalSearchModel.ItemDataPayload> list, List<? extends WidgetGlobalSearchModel.ItemDataPayload> list2) {
        m.checkNotNullParameter(list, "<anonymous parameter 0>");
        m.checkNotNullParameter(list2, "<anonymous parameter 1>");
        if (!m.areEqual(WidgetIncomingShare.access$getQueryString$p(this.this$0), this.$this_configureUi$inlined.getSearchModel().getFilter())) {
            WidgetIncomingShare.access$getBinding$p(this.this$0).h.scrollToPosition(0);
            WidgetIncomingShare.access$setQueryString$p(this.this$0, this.$this_configureUi$inlined.getSearchModel().getFilter());
        }
    }
}
