package com.discord.utilities.search.history;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.stores.StoreSearch;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.query.node.QueryNode;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

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
            m.checkNotNullParameter(searchTarget, "searchTarget");
            m.checkNotNullParameter(linkedList, "recentQueries");
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
            m.checkNotNullParameter(searchTarget, "searchTarget");
            m.checkNotNullParameter(recentQueries, "recentQueries");
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
            return m.areEqual(this.searchTarget, targetHistory.searchTarget) && m.areEqual(this.recentQueries, targetHistory.recentQueries);
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
            StringBuilder sbU = a.U("TargetHistory(searchTarget=");
            sbU.append(this.searchTarget);
            sbU.append(", recentQueries=");
            sbU.append(this.recentQueries);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: MGPreferenceSearchHistoryCache.kt */
    /* renamed from: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache$clear$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<LinkedList<TargetHistory>, LinkedList<TargetHistory>> {
        public final /* synthetic */ StoreSearch.SearchTarget $searchTarget;

        public AnonymousClass1(StoreSearch.SearchTarget searchTarget) {
            this.$searchTarget = searchTarget;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ LinkedList<TargetHistory> call(LinkedList<TargetHistory> linkedList) {
            return call2(linkedList);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final LinkedList<TargetHistory> call2(LinkedList<TargetHistory> linkedList) {
            MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache = MGPreferenceSearchHistoryCache.this;
            m.checkNotNullExpressionValue(linkedList, "it");
            return MGPreferenceSearchHistoryCache.access$removeAndCopy(mGPreferenceSearchHistoryCache, linkedList, this.$searchTarget);
        }
    }

    /* compiled from: MGPreferenceSearchHistoryCache.kt */
    /* renamed from: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache$clear$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<LinkedList<TargetHistory>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LinkedList<TargetHistory> linkedList) {
            invoke2(linkedList);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LinkedList<TargetHistory> linkedList) {
            Persister persisterAccess$getBackingCache$p = MGPreferenceSearchHistoryCache.access$getBackingCache$p(MGPreferenceSearchHistoryCache.this);
            m.checkNotNullExpressionValue(linkedList, "it");
            Persister.set$default(persisterAccess$getBackingCache$p, linkedList, false, 2, null);
        }
    }

    /* compiled from: MGPreferenceSearchHistoryCache.kt */
    /* renamed from: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache$getHistory$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<LinkedList<TargetHistory>, Collection<? extends List<? extends QueryNode>>> {
        public final /* synthetic */ StoreSearch.SearchTarget $searchTarget;

        public AnonymousClass1(StoreSearch.SearchTarget searchTarget) {
            this.$searchTarget = searchTarget;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Collection<? extends List<? extends QueryNode>> call(LinkedList<TargetHistory> linkedList) {
            return call2(linkedList);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Collection<List<QueryNode>> call2(LinkedList<TargetHistory> linkedList) {
            MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache = MGPreferenceSearchHistoryCache.this;
            m.checkNotNullExpressionValue(linkedList, "it");
            return MGPreferenceSearchHistoryCache.access$find(mGPreferenceSearchHistoryCache, linkedList, this.$searchTarget);
        }
    }

    /* compiled from: MGPreferenceSearchHistoryCache.kt */
    /* renamed from: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache$persistQuery$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<LinkedList<TargetHistory>, LinkedList<TargetHistory>> {
        public final /* synthetic */ List $query;
        public final /* synthetic */ StoreSearch.SearchTarget $searchTarget;

        public AnonymousClass1(StoreSearch.SearchTarget searchTarget, List list) {
            this.$searchTarget = searchTarget;
            this.$query = list;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ LinkedList<TargetHistory> call(LinkedList<TargetHistory> linkedList) {
            return call2(linkedList);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final LinkedList<TargetHistory> call2(LinkedList<TargetHistory> linkedList) {
            MGPreferenceSearchHistoryCache mGPreferenceSearchHistoryCache = MGPreferenceSearchHistoryCache.this;
            m.checkNotNullExpressionValue(linkedList, "it");
            return MGPreferenceSearchHistoryCache.access$putAndCopy(mGPreferenceSearchHistoryCache, linkedList, this.$searchTarget, this.$query);
        }
    }

    /* compiled from: MGPreferenceSearchHistoryCache.kt */
    /* renamed from: com.discord.utilities.search.history.MGPreferenceSearchHistoryCache$persistQuery$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<LinkedList<TargetHistory>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LinkedList<TargetHistory> linkedList) {
            invoke2(linkedList);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LinkedList<TargetHistory> linkedList) {
            Persister persisterAccess$getBackingCache$p = MGPreferenceSearchHistoryCache.access$getBackingCache$p(MGPreferenceSearchHistoryCache.this);
            m.checkNotNullExpressionValue(linkedList, "it");
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
        m.checkNotNullExpressionValue(it, "iterator()");
        while (it.hasNext()) {
            TargetHistory next = it.next();
            m.checkNotNullExpressionValue(next, "iter.next()");
            TargetHistory targetHistory = next;
            if (m.areEqual(targetHistory.getSearchTarget(), searchTarget)) {
                return targetHistory.getRecentQueries();
            }
        }
        return new LinkedList<>();
    }

    private final LinkedList<TargetHistory> putAndCopy(LinkedList<TargetHistory> linkedList, StoreSearch.SearchTarget searchTarget, List<? extends QueryNode> list) {
        TargetHistory targetHistory;
        Iterator<TargetHistory> it = linkedList.iterator();
        m.checkNotNullExpressionValue(it, "iterator()");
        while (true) {
            if (!it.hasNext()) {
                targetHistory = null;
                break;
            }
            TargetHistory next = it.next();
            m.checkNotNullExpressionValue(next, "targetsIter.next()");
            targetHistory = next;
            if (m.areEqual(targetHistory.getSearchTarget(), searchTarget)) {
                it.remove();
                break;
            }
        }
        if (targetHistory == null) {
            targetHistory = new TargetHistory(searchTarget, new LinkedList());
        }
        Iterator<List<QueryNode>> it2 = targetHistory.getRecentQueries().iterator();
        m.checkNotNullExpressionValue(it2, "targetHistory.recentQueries.iterator()");
        while (it2.hasNext()) {
            List<QueryNode> next2 = it2.next();
            m.checkNotNullExpressionValue(next2, "queriesIter.next()");
            if (m.areEqual(next2, list)) {
                it2.remove();
            }
        }
        targetHistory.getRecentQueries().push(list);
        linkedList.push(new TargetHistory(searchTarget, new LinkedList(u.take(targetHistory.getRecentQueries(), this.MAX_QUERIES_PER_TARGET))));
        return new LinkedList<>(u.take(linkedList, this.MAX_SEARCH_TARGETS));
    }

    private final LinkedList<TargetHistory> removeAndCopy(LinkedList<TargetHistory> linkedList, StoreSearch.SearchTarget searchTarget) {
        Iterator<TargetHistory> it = linkedList.iterator();
        m.checkNotNullExpressionValue(it, "iterator()");
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TargetHistory next = it.next();
            m.checkNotNullExpressionValue(next, "iter.next()");
            if (m.areEqual(next.getSearchTarget(), searchTarget)) {
                it.remove();
                break;
            }
        }
        return new LinkedList<>(linkedList);
    }

    @Override // com.discord.utilities.search.history.SearchHistoryCache
    public void clear(StoreSearch.SearchTarget searchTarget) {
        m.checkNotNullParameter(searchTarget, "searchTarget");
        Observable<R> observableG = this.backingCache.getObservable().Z(1).G(new AnonymousClass1(searchTarget));
        m.checkNotNullExpressionValue(observableG, "backingCache\n        .ge…veAndCopy(searchTarget) }");
        ObservableExtensionsKt.appSubscribe$default(observableG, (Context) null, "clear history", (Function1) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    @Override // com.discord.utilities.search.history.SearchHistoryCache
    public Observable<Collection<List<QueryNode>>> getHistory(StoreSearch.SearchTarget searchTarget) {
        m.checkNotNullParameter(searchTarget, "searchTarget");
        Observable observableG = this.backingCache.getObservable().G(new AnonymousClass1(searchTarget));
        m.checkNotNullExpressionValue(observableG, "backingCache\n        .ge…{ it.find(searchTarget) }");
        return observableG;
    }

    @Override // com.discord.utilities.search.history.SearchHistoryCache
    public void persistQuery(StoreSearch.SearchTarget searchTarget, List<? extends QueryNode> query) {
        m.checkNotNullParameter(searchTarget, "searchTarget");
        m.checkNotNullParameter(query, "query");
        Observable<R> observableG = this.backingCache.getObservable().Z(1).G(new AnonymousClass1(searchTarget, query));
        m.checkNotNullExpressionValue(observableG, "backingCache\n        .ge…py(searchTarget, query) }");
        ObservableExtensionsKt.appSubscribe$default(observableG, (Context) null, "persist query", (Function1) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }
}
