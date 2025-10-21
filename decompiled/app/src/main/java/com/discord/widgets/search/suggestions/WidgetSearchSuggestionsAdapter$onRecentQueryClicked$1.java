package com.discord.widgets.search.suggestions;

import com.discord.utilities.search.query.node.QueryNode;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSearchSuggestionsAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$onRecentQueryClicked$1 extends Lambda implements Function1<List<? extends QueryNode>, Unit> {
    public static final WidgetSearchSuggestionsAdapter$onRecentQueryClicked$1 INSTANCE = new WidgetSearchSuggestionsAdapter$onRecentQueryClicked$1();

    public WidgetSearchSuggestionsAdapter$onRecentQueryClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends QueryNode> list) {
        invoke2(list);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends QueryNode> list) {
        Intrinsics3.checkNotNullParameter(list, "it");
    }
}
