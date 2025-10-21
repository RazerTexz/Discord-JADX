package com.discord.widgets.search.suggestions;

import android.view.View;
import com.discord.widgets.search.suggestions.WidgetSearchSuggestionsAdapter;
import java.util.List;

/* compiled from: WidgetSearchSuggestionsAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$RecentQueryViewHolder$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ List $query;
    public final /* synthetic */ WidgetSearchSuggestionsAdapter.RecentQueryViewHolder this$0;

    public WidgetSearchSuggestionsAdapter$RecentQueryViewHolder$onConfigure$1(WidgetSearchSuggestionsAdapter.RecentQueryViewHolder recentQueryViewHolder, List list) {
        this.this$0 = recentQueryViewHolder;
        this.$query = list;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSearchSuggestionsAdapter.RecentQueryViewHolder.access$getAdapter$p(this.this$0).getOnRecentQueryClicked().invoke(this.$query);
    }
}
