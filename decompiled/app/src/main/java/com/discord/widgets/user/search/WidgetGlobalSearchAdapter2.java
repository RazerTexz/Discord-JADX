package com.discord.widgets.user.search;

import android.view.View;
import com.discord.widgets.user.search.WidgetGlobalSearchAdapter;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* compiled from: WidgetGlobalSearchAdapter.kt */
/* renamed from: com.discord.widgets.user.search.WidgetGlobalSearchAdapter$HeaderViewHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchAdapter2 implements View.OnClickListener {
    public final /* synthetic */ WidgetGlobalSearchModel.ItemDataPayload $data;
    public final /* synthetic */ int $position;
    public final /* synthetic */ WidgetGlobalSearchAdapter.HeaderViewHolder this$0;

    public WidgetGlobalSearchAdapter2(WidgetGlobalSearchAdapter.HeaderViewHolder headerViewHolder, int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
        this.this$0 = headerViewHolder;
        this.$position = i;
        this.$data = itemDataPayload;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function4<View, Integer, WidgetGlobalSearchModel.ItemDataPayload, Boolean, Unit> onSelectedListener = WidgetGlobalSearchAdapter.HeaderViewHolder.access$getAdapter$p(this.this$0).getOnSelectedListener();
        Intrinsics3.checkNotNullExpressionValue(view, "view");
        onSelectedListener.invoke(view, Integer.valueOf(this.$position), this.$data, Boolean.FALSE);
    }
}
