package com.discord.utilities.search.history;

import com.discord.stores.StoreSearch;
import com.discord.utilities.search.query.node.QueryNode;
import java.util.Collection;
import java.util.List;
import rx.Observable;

/* compiled from: SearchHistoryCache.kt */
/* loaded from: classes2.dex */
public interface SearchHistoryCache {
    void clear(StoreSearch.SearchTarget searchTarget);

    Observable<Collection<List<QueryNode>>> getHistory(StoreSearch.SearchTarget searchTarget);

    void persistQuery(StoreSearch.SearchTarget searchTarget, List<? extends QueryNode> query);
}
