package com.discord.widgets.search.suggestions;

import android.view.View;
import com.discord.utilities.search.suggestion.entries.ChannelSuggestion;
import com.discord.widgets.search.suggestions.WidgetSearchSuggestionsAdapter;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$InChannelViewHolder$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ ChannelSuggestion $channelSuggestion;
    public final /* synthetic */ WidgetSearchSuggestionsAdapter.InChannelViewHolder this$0;

    public WidgetSearchSuggestionsAdapter$InChannelViewHolder$onConfigure$1(WidgetSearchSuggestionsAdapter.InChannelViewHolder inChannelViewHolder, ChannelSuggestion channelSuggestion) {
        this.this$0 = inChannelViewHolder;
        this.$channelSuggestion = channelSuggestion;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSearchSuggestionsAdapter.InChannelViewHolder.access$getAdapter$p(this.this$0).getOnChannelClicked().invoke(this.$channelSuggestion);
    }
}
