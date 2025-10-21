package com.discord.widgets.search.suggestions;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.SearchSuggestionEngine;
import com.discord.utilities.search.validation.SearchData;
import com.discord.widgets.search.suggestions.WidgetSearchSuggestions;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;
import rx.functions.Func3;

/* compiled from: WidgetSearchSuggestions.kt */
/* renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSearchSuggestions2<T1, T2, T3, R> implements Func3<SearchData, List<? extends QueryNode>, Collection<? extends List<? extends QueryNode>>, WidgetSearchSuggestions.Model> {
    public final /* synthetic */ SearchStringProvider $searchStringProvider;

    public WidgetSearchSuggestions2(SearchStringProvider searchStringProvider) {
        this.$searchStringProvider = searchStringProvider;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetSearchSuggestions.Model call(SearchData searchData, List<? extends QueryNode> list, Collection<? extends List<? extends QueryNode>> collection) {
        return call2(searchData, list, collection);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetSearchSuggestions.Model call2(SearchData searchData, List<? extends QueryNode> list, Collection<? extends List<? extends QueryNode>> collection) {
        Intrinsics3.checkNotNullParameter(searchData, "searchData");
        Intrinsics3.checkNotNullParameter(list, "queryNodes");
        Intrinsics3.checkNotNullParameter(collection, "history");
        List<QueryNode> mutableList = _Collections.toMutableList((Collection) list);
        QueryNode.INSTANCE.preprocess(mutableList, searchData);
        return new WidgetSearchSuggestions.Model(mutableList, SearchSuggestionEngine.getSuggestions(mutableList, searchData, this.$searchStringProvider, collection));
    }
}
