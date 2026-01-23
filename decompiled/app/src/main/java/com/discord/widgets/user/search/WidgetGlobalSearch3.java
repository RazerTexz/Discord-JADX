package com.discord.widgets.user.search;

import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$configureUI$$inlined$apply$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGlobalSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearch3 extends Lambda implements Function2<List<? extends WidgetGlobalSearchModel.ItemDataPayload>, List<? extends WidgetGlobalSearchModel.ItemDataPayload>, Unit> {
    public final /* synthetic */ WidgetGlobalSearchModel $model$inlined;
    public final /* synthetic */ WidgetGlobalSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearch3(WidgetGlobalSearch widgetGlobalSearch, WidgetGlobalSearchModel widgetGlobalSearchModel) {
        super(2);
        this.this$0 = widgetGlobalSearch;
        this.$model$inlined = widgetGlobalSearchModel;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends WidgetGlobalSearchModel.ItemDataPayload> list, List<? extends WidgetGlobalSearchModel.ItemDataPayload> list2) {
        invoke2(list, list2);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends WidgetGlobalSearchModel.ItemDataPayload> list, List<? extends WidgetGlobalSearchModel.ItemDataPayload> list2) {
        Intrinsics3.checkNotNullParameter(list, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(list2, "<anonymous parameter 1>");
        if (!Intrinsics3.areEqual(WidgetGlobalSearch.access$getFilterString$p(this.this$0), this.$model$inlined.getFilter())) {
            WidgetGlobalSearch.access$getBinding$p(this.this$0).f16713g.scrollToPosition(0);
            WidgetGlobalSearch.access$setFilterString$p(this.this$0, this.$model$inlined.getFilter());
        }
    }
}
