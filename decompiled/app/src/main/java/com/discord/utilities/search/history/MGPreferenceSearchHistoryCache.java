package com.discord.utilities.search.history;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreSearch;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.search.query.node.QueryNode;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* compiled from: MGPreferenceSearchHistoryCache.kt */
/* loaded from: classes2.dex */
public final class MGPreferenceSearchHistoryCache implements SearchHistoryCache {
    private final int MAX_SEARCH_TARGETS = 10;
    private final int MAX_QUERIES_PER_TARGET = 5;
    private final Persister<LinkedList<TargetHistory>> backingCache = new Persister<>("SEARCH_HISTORY_V2", new LinkedList());

    /* compiled from: MGPreferenceSearchHistoryCache.kt */
    public static final /* data */ class TargetHistory {
        private final LinkedList<List<QueryNode>> recentQueries;
        private final StoreSearch.SearchTarget searchTarget;

        public TargetHistory(StoreSearch.SearchTarget searchTarget, LinkedList<List<QueryNode>> linkedList) {
            Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
            Intrinsics3.checkNotNullParameter(linkedList, "recentQueries");
            this.searchTarget = searchTarget;
            this.recentQueries = linkedList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TargetHistory copy$default(TargetHistory targetHistory, StoreSearch.SearchTarget searchTarget, LinkedList linkedList, int i, Object obj) {
            if ((i & 1) != 0) {
                searchTarget = targetHistory.searchTarget;
            }
            if ((i & 2) != 0) {
                linkedList = targetHistory.recentQueries;
            }
            return targetHistory.copy(searchTarget, linkedList);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreSearch.SearchTarget getSearchTarget() {
            return this.searchTarget;
        }

        public final LinkedList<List<QueryNode>> component2() {
            return this.recentQueries;
        }

        public final TargetHistory copy(StoreSearch.SearchTarget searchTarget, LinkedList<List<QueryNode>> recentQueries) {
            Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
            Intrinsics3.checkNotNullParameter(recentQueries, "recentQueries");
            return new TargetHistory(searchTarget, recentQueries);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TargetHistory)) {
                return false;
            }
            TargetHistory targetHistory = (TargetHistory) other;
            return Intrinsics3.areEqual(this.searchTarget, targetHistory.searchTarget) && Intrinsics3.areEqual(this.recentQueries, targetHistory.recentQueries);
        }

        public final LinkedList<List<QueryNode>> getRecentQueries() {
            return this.recentQueries;
        }

        public final StoreSearch.SearchTarget getSearchTarget() {
            return this.searchTarget;
        }

        public int hashCode() {
            StoreSearch.SearchTarget searchTarget = this.searchTarget;
            int iHashCode = (searchTarget != null ? searchTarget.hashCode() : 0) * 31;
            LinkedList<List<QueryNode>> linkedList = this.recentQueries;
            return iHashCode + (linkedList != null ? linkedList.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("TargetHistory(searchTarget=");
            sbM833U.append(this.searchTarget);
            sbM833U.append(", recentQueries=");
            sbM833U.append(this.recentQueries);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: MGPreferenceSearchHistoryCache.kt */
    /* renamed from: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache$clear$1 */
    public static final class C68991<T, R> implements Func1<LinkedList<TargetHistory>, LinkedList<TargetHistory>> {
        public final /* synthetic */ StoreSearch.SearchTarget $searchTarget;

        public C68991(StoreSearch.SearchTarget searchTarget) {
            this.$searchTarget = searchTarget;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ LinkedList<TargetHistory> call(LinkedList<TargetHistory> linkedList) {
            return call2(linkedList);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final LinkedList<TargetHistory> call2(LinkedList<TargetHistory> linkedList) {
            MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache = MGPreferenceSearchHistoryCache.this;
            Intrinsics3.checkNotNullExpressionValue(linkedList, "it");
            return MGPreferenceSearchHistoryCache.access$removeAndCopy(mGPreferenceSearchHistoryCache, linkedList, this.$searchTarget);
        }
    }

    /* compiled from: MGPreferenceSearchHistoryCache.kt */
    /* renamed from: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache$clear$2 */
    public static final class C69002 extends Lambda implements Function1<LinkedList<TargetHistory>, Unit> {
        public C69002() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LinkedList<TargetHistory> linkedList) {
            invoke2(linkedList);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LinkedList<TargetHistory> linkedList) {
            Persister persisterAccess$getBackingCache$p = MGPreferenceSearchHistoryCache.access$getBackingCache$p(MGPreferenceSearchHistoryCache.this);
            Intrinsics3.checkNotNullExpressionValue(linkedList, "it");
            Persister.set$default(persisterAccess$getBackingCache$p, linkedList, false, 2, null);
        }
    }

    /* compiled from: MGPreferenceSearchHistoryCache.kt */
    /* renamed from: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache$getHistory$1 */
    public static final class C69011<T, R> implements Func1<LinkedList<TargetHistory>, Collection<? extends List<? extends QueryNode>>> {
        public final /* synthetic */ StoreSearch.SearchTarget $searchTarget;

        public C69011(StoreSearch.SearchTarget searchTarget) {
            this.$searchTarget = searchTarget;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Collection<? extends List<? extends QueryNode>> call(LinkedList<TargetHistory> linkedList) {
            return call2(linkedList);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Collection<List<QueryNode>> call2(LinkedList<TargetHistory> linkedList) {
            MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache = MGPreferenceSearchHistoryCache.this;
            Intrinsics3.checkNotNullExpressionValue(linkedList, "it");
            return MGPreferenceSearchHistoryCache.access$find(mGPreferenceSearchHistoryCache, linkedList, this.$searchTarget);
        }
    }

    /* compiled from: MGPreferenceSearchHistoryCache.kt */
    /* renamed from: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache$persistQuery$1 */
    public static final class C69021<T, R> implements Func1<LinkedList<TargetHistory>, LinkedList<TargetHistory>> {
        public final /* synthetic */ List $query;
        public final /* synthetic */ StoreSearch.SearchTarget $searchTarget;

        public C69021(StoreSearch.SearchTarget searchTarget, List list) {
            this.$searchTarget = searchTarget;
            this.$query = list;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ LinkedList<TargetHistory> call(LinkedList<TargetHistory> linkedList) {
            return call2(linkedList);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final LinkedList<TargetHistory> call2(LinkedList<TargetHistory> linkedList) {
            MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache = MGPreferenceSearchHistoryCache.this;
            Intrinsics3.checkNotNullExpressionValue(linkedList, "it");
            return MGPreferenceSearchHistoryCache.access$putAndCopy(mGPreferenceSearchHistoryCache, linkedList, this.$searchTarget, this.$query);
        }
    }

    /* compiled from: MGPreferenceSearchHistoryCache.kt */
    /* renamed from: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache$persistQuery$2 */
    public static final class C69032 extends Lambda implements Function1<LinkedList<TargetHistory>, Unit> {
        public C69032() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LinkedList<TargetHistory> linkedList) {
            invoke2(linkedList);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LinkedList<TargetHistory> linkedList) {
            Persister persisterAccess$getBackingCache$p = MGPreferenceSearchHistoryCache.access$getBackingCache$p(MGPreferenceSearchHistoryCache.this);
            Intrinsics3.checkNotNullExpressionValue(linkedList, "it");
            Persister.set$default(persisterAccess$getBackingCache$p, linkedList, false, 2, null);
        }
    }

    public static final /* synthetic */ LinkedList access$find(MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache, LinkedList linkedList, StoreSearch.SearchTarget searchTarget) {
        return mGPreferenceSearchHistoryCache.find(linkedList, searchTarget);
    }

    public static final /* synthetic */ Persister access$getBackingCache$p(MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache) {
        return mGPreferenceSearchHistoryCache.backingCache;
    }

    public static final /* synthetic */ LinkedList access$putAndCopy(MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache, LinkedList linkedList, StoreSearch.SearchTarget searchTarget, List list) {
        return mGPreferenceSearchHistoryCache.putAndCopy(linkedList, searchTarget, list);
    }

    public static final /* synthetic */ LinkedList access$removeAndCopy(MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache, LinkedList linkedList, StoreSearch.SearchTarget searchTarget) {
        return mGPreferenceSearchHistoryCache.removeAndCopy(linkedList, searchTarget);
    }

    private final LinkedList<List<QueryNode>> find(LinkedList<TargetHistory> linkedList, StoreSearch.SearchTarget searchTarget) {
        Iterator<TargetHistory> it = linkedList.iterator();
        Intrinsics3.checkNotNullExpressionValue(it, "iterator()");
        while (it.hasNext()) {
            TargetHistory next = it.next();
            Intrinsics3.checkNotNullExpressionValue(next, "iter.next()");
            TargetHistory targetHistory = next;
            if (Intrinsics3.areEqual(targetHistory.getSearchTarget(), searchTarget)) {
                return targetHistory.getRecentQueries();
            }
        }
        return new LinkedList<>();
    }

    private final LinkedList<TargetHistory> putAndCopy(LinkedList<TargetHistory> linkedList, StoreSearch.SearchTarget searchTarget, List<? extends QueryNode> list) {
        TargetHistory targetHistory;
        Iterator<TargetHistory> it = linkedList.iterator();
        Intrinsics3.checkNotNullExpressionValue(it, "iterator()");
        while (true) {
            if (!it.hasNext()) {
                targetHistory = null;
                break;
            }
            TargetHistory next = it.next();
            Intrinsics3.checkNotNullExpressionValue(next, "targetsIter.next()");
            targetHistory = next;
            if (Intrinsics3.areEqual(targetHistory.getSearchTarget(), searchTarget)) {
                it.remove();
                break;
            }
        }
        if (targetHistory == null) {
            targetHistory = new TargetHistory(searchTarget, new LinkedList());
        }
        Iterator<List<QueryNode>> it2 = targetHistory.getRecentQueries().iterator();
        Intrinsics3.checkNotNullExpressionValue(it2, "targetHistory.recentQueries.iterator()");
        while (it2.hasNext()) {
            List<QueryNode> next2 = it2.next();
            Intrinsics3.checkNotNullExpressionValue(next2, "queriesIter.next()");
            if (Intrinsics3.areEqual(next2, list)) {
                it2.remove();
            }
        }
        targetHistory.getRecentQueries().push(list);
        linkedList.push(new TargetHistory(searchTarget, new LinkedList(_Collections.take(targetHistory.getRecentQueries(), this.MAX_QUERIES_PER_TARGET))));
        return new LinkedList<>(_Collections.take(linkedList, this.MAX_SEARCH_TARGETS));
    }

    private final LinkedList<TargetHistory> removeAndCopy(LinkedList<TargetHistory> linkedList, StoreSearch.SearchTarget searchTarget) {
        Iterator<TargetHistory> it = linkedList.iterator();
        Intrinsics3.checkNotNullExpressionValue(it, "iterator()");
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TargetHistory next = it.next();
            Intrinsics3.checkNotNullExpressionValue(next, "iter.next()");
            if (Intrinsics3.areEqual(next.getSearchTarget(), searchTarget)) {
                it.remove();
                break;
            }
        }
        return new LinkedList<>(linkedList);
    }

    @Override // com.discord.utilities.search.history.SearchHistoryCache
    public void clear(StoreSearch.SearchTarget searchTarget) {
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        Observable<R> observableM11083G = this.backingCache.getObservable().m11100Z(1).m11083G(new C68991(searchTarget));
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "backingCache\n        .ge…veAndCopy(searchTarget) }");
        ObservableExtensionsKt.appSubscribe$default(observableM11083G, (Context) null, "clear history", (Function1) null, new C69002(), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    @Override // com.discord.utilities.search.history.SearchHistoryCache
    public Observable<Collection<List<QueryNode>>> getHistory(StoreSearch.SearchTarget searchTarget) {
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        Observable observableM11083G = this.backingCache.getObservable().m11083G(new C69011(searchTarget));
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "backingCache\n        .ge…{ it.find(searchTarget) }");
        return observableM11083G;
    }

    @Override // com.discord.utilities.search.history.SearchHistoryCache
    public void persistQuery(StoreSearch.SearchTarget searchTarget, List<? extends QueryNode> query) {
        Intrinsics3.checkNotNullParameter(searchTarget, "searchTarget");
        Intrinsics3.checkNotNullParameter(query, "query");
        Observable<R> observableM11083G = this.backingCache.getObservable().m11100Z(1).m11083G(new C69021(searchTarget, query));
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "backingCache\n        .ge…py(searchTarget, query) }");
        ObservableExtensionsKt.appSubscribe$default(observableM11083G, (Context) null, "persist query", (Function1) null, new C69032(), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }
}
