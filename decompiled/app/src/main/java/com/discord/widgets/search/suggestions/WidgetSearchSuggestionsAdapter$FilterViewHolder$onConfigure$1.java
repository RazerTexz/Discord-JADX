package com.discord.widgets.search.suggestions;

import android.view.View;
import com.discord.utilities.search.query.FilterType;
import com.discord.widgets.search.suggestions.WidgetSearchSuggestionsAdapter;

/* compiled from: WidgetSearchSuggestionsAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$FilterViewHolder$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ FilterType $filterType;
    public final /* synthetic */ WidgetSearchSuggestionsAdapter.FilterViewHolder this$0;

    public WidgetSearchSuggestionsAdapter$FilterViewHolder$onConfigure$1(WidgetSearchSuggestionsAdapter.FilterViewHolder filterViewHolder, FilterType filterType) {
        this.this$0 = filterViewHolder;
        this.$filterType = filterType;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSearchSuggestionsAdapter.FilterViewHolder.access$getAdapter$p(this.this$0).getOnFilterClicked().invoke(this.$filterType);
    }
}
