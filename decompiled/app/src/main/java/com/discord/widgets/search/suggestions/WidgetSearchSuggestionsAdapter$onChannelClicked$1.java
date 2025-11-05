package com.discord.widgets.search.suggestions;

import com.discord.utilities.search.suggestion.entries.ChannelSuggestion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSearchSuggestionsAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$onChannelClicked$1 extends o implements Function1<ChannelSuggestion, Unit> {
    public static final WidgetSearchSuggestionsAdapter$onChannelClicked$1 INSTANCE = new WidgetSearchSuggestionsAdapter$onChannelClicked$1();

    public WidgetSearchSuggestionsAdapter$onChannelClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChannelSuggestion channelSuggestion) {
        invoke2(channelSuggestion);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ChannelSuggestion channelSuggestion) {
        m.checkNotNullParameter(channelSuggestion, "it");
    }
}
