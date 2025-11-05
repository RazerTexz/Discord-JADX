package com.discord.widgets.search.suggestions;

import android.view.View;
import com.discord.utilities.search.suggestion.entries.UserSuggestion;
import com.discord.widgets.search.suggestions.WidgetSearchSuggestionsAdapter;

/* compiled from: WidgetSearchSuggestionsAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$UserViewHolder$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ UserSuggestion $userSuggestion;
    public final /* synthetic */ WidgetSearchSuggestionsAdapter.UserViewHolder this$0;

    public WidgetSearchSuggestionsAdapter$UserViewHolder$onConfigure$1(WidgetSearchSuggestionsAdapter.UserViewHolder userViewHolder, UserSuggestion userSuggestion) {
        this.this$0 = userViewHolder;
        this.$userSuggestion = userSuggestion;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSearchSuggestionsAdapter.UserViewHolder.access$getAdapter$p(this.this$0).getOnUserClicked().invoke(this.$userSuggestion);
    }
}
