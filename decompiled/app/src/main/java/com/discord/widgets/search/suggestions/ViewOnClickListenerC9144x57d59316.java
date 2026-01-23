package com.discord.widgets.search.suggestions;

import android.view.View;
import com.discord.widgets.search.suggestions.WidgetSearchSuggestionsAdapter;
import java.util.List;

/* JADX INFO: renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestionsAdapter$RecentQueryViewHolder$onConfigure$1 */
/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewOnClickListenerC9144x57d59316 implements View.OnClickListener {
    public final /* synthetic */ List $query;
    public final /* synthetic */ WidgetSearchSuggestionsAdapter.RecentQueryViewHolder this$0;

    public ViewOnClickListenerC9144x57d59316(WidgetSearchSuggestionsAdapter.RecentQueryViewHolder recentQueryViewHolder, List list) {
        this.this$0 = recentQueryViewHolder;
        this.$query = list;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSearchSuggestionsAdapter.RecentQueryViewHolder.access$getAdapter$p(this.this$0).getOnRecentQueryClicked().invoke(this.$query);
    }
}
