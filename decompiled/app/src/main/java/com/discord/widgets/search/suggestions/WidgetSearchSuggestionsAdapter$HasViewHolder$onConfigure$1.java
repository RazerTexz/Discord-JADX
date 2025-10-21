package com.discord.widgets.search.suggestions;

import android.view.View;
import com.discord.utilities.search.suggestion.entries.HasSuggestion;
import com.discord.widgets.search.suggestions.WidgetSearchSuggestionsAdapter;

/* compiled from: WidgetSearchSuggestionsAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$HasViewHolder$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ HasSuggestion $hasSuggestion;
    public final /* synthetic */ WidgetSearchSuggestionsAdapter.HasViewHolder this$0;

    public WidgetSearchSuggestionsAdapter$HasViewHolder$onConfigure$1(WidgetSearchSuggestionsAdapter.HasViewHolder hasViewHolder, HasSuggestion hasSuggestion) {
        this.this$0 = hasViewHolder;
        this.$hasSuggestion = hasSuggestion;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSearchSuggestionsAdapter.HasViewHolder.access$getAdapter$p(this.this$0).getOnHasClicked().invoke(this.$hasSuggestion.getHasAnswerOption());
    }
}
