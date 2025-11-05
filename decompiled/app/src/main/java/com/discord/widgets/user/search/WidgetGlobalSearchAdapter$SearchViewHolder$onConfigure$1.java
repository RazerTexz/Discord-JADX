package com.discord.widgets.user.search;

import android.view.View;
import com.discord.widgets.user.search.WidgetGlobalSearchAdapter;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* compiled from: WidgetGlobalSearchAdapter.kt */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchAdapter$SearchViewHolder$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ WidgetGlobalSearchModel.ItemDataPayload $data;
    public final /* synthetic */ int $position;
    public final /* synthetic */ WidgetGlobalSearchAdapter.SearchViewHolder this$0;

    public WidgetGlobalSearchAdapter$SearchViewHolder$onConfigure$1(WidgetGlobalSearchAdapter.SearchViewHolder searchViewHolder, int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
        this.this$0 = searchViewHolder;
        this.$position = i;
        this.$data = itemDataPayload;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function4<View, Integer, WidgetGlobalSearchModel.ItemDataPayload, Boolean, Unit> onSelectedListener = WidgetGlobalSearchAdapter.SearchViewHolder.access$getAdapter$p(this.this$0).getOnSelectedListener();
        m.checkNotNullExpressionValue(view, "view");
        onSelectedListener.invoke(view, Integer.valueOf(this.$position), this.$data, Boolean.FALSE);
    }
}
