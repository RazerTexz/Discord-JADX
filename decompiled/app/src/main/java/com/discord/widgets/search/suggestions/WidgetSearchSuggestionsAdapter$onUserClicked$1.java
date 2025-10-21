package com.discord.widgets.search.suggestions;

import com.discord.utilities.search.suggestion.entries.UserSuggestion;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSearchSuggestionsAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$onUserClicked$1 extends Lambda implements Function1<UserSuggestion, Unit> {
    public static final WidgetSearchSuggestionsAdapter$onUserClicked$1 INSTANCE = new WidgetSearchSuggestionsAdapter$onUserClicked$1();

    public WidgetSearchSuggestionsAdapter$onUserClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UserSuggestion userSuggestion) {
        invoke2(userSuggestion);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(UserSuggestion userSuggestion) {
        Intrinsics3.checkNotNullParameter(userSuggestion, "it");
    }
}
