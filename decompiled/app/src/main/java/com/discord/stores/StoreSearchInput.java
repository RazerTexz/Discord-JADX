package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.ChannelNode;
import com.discord.utilities.search.query.node.answer.HasAnswerOption;
import com.discord.utilities.search.query.node.answer.HasNode;
import com.discord.utilities.search.query.node.answer.UserNode;
import com.discord.utilities.search.query.node.content.ContentNode;
import com.discord.utilities.search.query.node.filter.FilterNode;
import com.discord.utilities.search.query.parsing.QueryParser;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.entries.ChannelSuggestion;
import com.discord.utilities.search.suggestion.entries.UserSuggestion;
import d0.t.n;
import d0.t.u;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import j0.p.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;

/* compiled from: StoreSearchInput.kt */
/* loaded from: classes2.dex */
public final class StoreSearchInput {
    private final SerializedSubject<List<QueryNode>, List<QueryNode>> astSubject;
    private final Observable<List<QueryNode>> currentParsedInput;
    private final Observable<List<QueryNode>> forcedInput;
    private final PublishSubject<List<QueryNode>> forcedInputSubject;
    private final SerializedSubject<String, String> inputSubject;
    private Subscription inputSubscription;
    private final Observable<Boolean> isInputValid;
    private final SerializedSubject<Boolean, Boolean> isInputValidSubject;

    /* compiled from: StoreSearchInput.kt */
    /* renamed from: com.discord.stores.StoreSearchInput$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<List<? extends QueryNode>, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Boolean call(List<? extends QueryNode> list) {
            return call2(list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(List<? extends QueryNode> list) {
            m.checkNotNullExpressionValue(list, "it");
            boolean z2 = true;
            if ((list instanceof Collection) && list.isEmpty()) {
                z2 = false;
            } else {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (!(((QueryNode) it.next()) instanceof FilterNode)) {
                        break;
                    }
                }
                z2 = false;
            }
            return Boolean.valueOf(z2);
        }
    }

    /* compiled from: StoreSearchInput.kt */
    /* renamed from: com.discord.stores.StoreSearchInput$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Boolean, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            StoreSearchInput.access$isInputValidSubject$p(StoreSearchInput.this).k.onNext(bool);
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FilterType.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[FilterType.FROM.ordinal()] = 1;
            iArr[FilterType.MENTIONS.ordinal()] = 2;
            iArr[FilterType.IN.ordinal()] = 3;
            iArr[FilterType.HAS.ordinal()] = 4;
        }
    }

    /* compiled from: StoreSearchInput.kt */
    /* renamed from: com.discord.stores.StoreSearchInput$init$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<String, List<QueryNode>> {
        public final /* synthetic */ QueryParser $queryParser;

        public AnonymousClass1(QueryParser queryParser) {
            this.$queryParser = queryParser;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ List<QueryNode> call(String str) {
            return call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<QueryNode> call2(String str) {
            QueryParser queryParser = this.$queryParser;
            m.checkNotNullExpressionValue(str, "it");
            return Parser.parse$default(queryParser, str, null, null, 4, null);
        }
    }

    /* compiled from: StoreSearchInput.kt */
    /* renamed from: com.discord.stores.StoreSearchInput$init$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<Subscription, Unit> {
        public AnonymousClass2(StoreSearchInput storeSearchInput) {
            super(1, storeSearchInput, StoreSearchInput.class, "handleInputSubscription", "handleInputSubscription(Lrx/Subscription;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            StoreSearchInput.access$handleInputSubscription((StoreSearchInput) this.receiver, subscription);
        }
    }

    /* compiled from: StoreSearchInput.kt */
    /* renamed from: com.discord.stores.StoreSearchInput$init$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends k implements Function1<List<? extends QueryNode>, Unit> {
        public AnonymousClass3(SerializedSubject serializedSubject) {
            super(1, serializedSubject, SerializedSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends QueryNode> list) {
            invoke2(list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends QueryNode> list) {
            ((SerializedSubject) this.receiver).k.onNext(list);
        }
    }

    public StoreSearchInput() {
        SerializedSubject<List<QueryNode>, List<QueryNode>> serializedSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.astSubject = serializedSubject;
        this.inputSubject = new SerializedSubject<>(BehaviorSubject.l0(""));
        SerializedSubject<Boolean, Boolean> serializedSubject2 = new SerializedSubject<>(BehaviorSubject.l0(Boolean.FALSE));
        this.isInputValidSubject = serializedSubject2;
        PublishSubject<List<QueryNode>> publishSubjectK0 = PublishSubject.k0();
        this.forcedInputSubject = publishSubjectK0;
        this.isInputValid = serializedSubject2;
        this.currentParsedInput = serializedSubject;
        m.checkNotNullExpressionValue(publishSubjectK0, "forcedInputSubject");
        this.forcedInput = publishSubjectK0;
        Observable observableX = ObservableExtensionsKt.leadingEdgeThrottle(serializedSubject, 50L, TimeUnit.MILLISECONDS).G(AnonymousClass1.INSTANCE).X(a.a());
        m.checkNotNullExpressionValue(observableX, "astSubject\n        .lead…Schedulers.computation())");
        ObservableExtensionsKt.appSubscribe$default(observableX, (Context) null, "validateSearchInput", (Function1) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    public static final /* synthetic */ void access$handleInputSubscription(StoreSearchInput storeSearchInput, Subscription subscription) {
        storeSearchInput.handleInputSubscription(subscription);
    }

    public static final /* synthetic */ SerializedSubject access$isInputValidSubject$p(StoreSearchInput storeSearchInput) {
        return storeSearchInput.isInputValidSubject;
    }

    private final int getAnswerReplacementStart(List<? extends QueryNode> query) {
        if (query.size() <= 1) {
            return 0;
        }
        int lastIndex = n.getLastIndex(query);
        QueryNode queryNode = query.get(lastIndex);
        int i = lastIndex - 1;
        QueryNode queryNode2 = query.get(i);
        if (queryNode instanceof FilterNode) {
            return lastIndex;
        }
        if ((queryNode instanceof ContentNode) && (queryNode2 instanceof FilterNode)) {
            return i;
        }
        return -1;
    }

    private final synchronized void handleInputSubscription(Subscription subscription) {
        Subscription subscription2 = this.inputSubscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        this.inputSubscription = subscription;
    }

    private final void replaceAndPublish(int replacementIndex, List<? extends QueryNode> replacement, List<QueryNode> query) {
        if (replacementIndex < 0 || replacementIndex > query.size()) {
            return;
        }
        query.subList(replacementIndex, query.size()).clear();
        query.addAll(replacementIndex, replacement);
        this.forcedInputSubject.k.onNext(query);
    }

    public final void clear() {
        handleInputSubscription(null);
        this.inputSubject.k.onNext("");
    }

    public final Observable<List<QueryNode>> getCurrentParsedInput() {
        return this.currentParsedInput;
    }

    public final Observable<List<QueryNode>> getForcedInput() {
        return this.forcedInput;
    }

    public final void init(SearchStringProvider searchStringProvider) {
        m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        Observable observableX = ObservableExtensionsKt.leadingEdgeThrottle(this.inputSubject, 100L, TimeUnit.MILLISECONDS).r().G(new AnonymousClass1(new QueryParser(searchStringProvider))).X(a.a());
        m.checkNotNullExpressionValue(observableX, "inputSubject\n        .le…Schedulers.computation())");
        ObservableExtensionsKt.appSubscribe$default(observableX, StoreSearchInput.class, (Context) null, new AnonymousClass2(this), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(this.astSubject), 58, (Object) null);
    }

    public final Observable<Boolean> isInputValid() {
        return this.isInputValid;
    }

    public final void onFilterClicked(FilterType filterType, SearchStringProvider searchStringProvider, List<QueryNode> query) {
        FilterNode filterNode;
        m.checkNotNullParameter(filterType, "filterType");
        m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        m.checkNotNullParameter(query, "query");
        ArrayList arrayList = new ArrayList(query);
        int iOrdinal = filterType.ordinal();
        if (iOrdinal == 0) {
            filterNode = new FilterNode(FilterType.FROM, searchStringProvider.getFromFilterString());
        } else if (iOrdinal == 1) {
            filterNode = new FilterNode(FilterType.MENTIONS, searchStringProvider.getMentionsFilterString());
        } else if (iOrdinal == 2) {
            filterNode = new FilterNode(FilterType.HAS, searchStringProvider.getHasFilterString());
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            filterNode = new FilterNode(FilterType.IN, searchStringProvider.getInFilterString());
        }
        replaceAndPublish(arrayList.isEmpty() ? 0 : ((QueryNode) u.last((List) arrayList)) instanceof ContentNode ? n.getLastIndex(query) : query.size(), d0.t.m.listOf(filterNode), query);
    }

    public final void onFromUserClicked(UserSuggestion userSuggestion, CharSequence fromFilterString, List<QueryNode> query) {
        m.checkNotNullParameter(userSuggestion, "userSuggestion");
        m.checkNotNullParameter(fromFilterString, "fromFilterString");
        m.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), n.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.FROM, fromFilterString), new UserNode(userSuggestion.getUserName(), userSuggestion.getDiscriminator())}), query);
    }

    public final void onHasClicked(HasAnswerOption hasAnswerOption, CharSequence hasFilterString, CharSequence hasAnswerString, List<QueryNode> query) {
        m.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
        m.checkNotNullParameter(hasFilterString, "hasFilterString");
        m.checkNotNullParameter(hasAnswerString, "hasAnswerString");
        m.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), n.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.HAS, hasFilterString), new HasNode(hasAnswerOption, hasAnswerString)}), query);
    }

    public final void onInChannelClicked(ChannelSuggestion channelSuggestion, CharSequence inFilterString, List<QueryNode> query) {
        m.checkNotNullParameter(channelSuggestion, "channelSuggestion");
        m.checkNotNullParameter(inFilterString, "inFilterString");
        m.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), n.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.IN, inFilterString), new ChannelNode(channelSuggestion.getChannelName())}), query);
    }

    public final void onMentionsUserClicked(UserSuggestion userSuggestion, CharSequence mentionsFilterString, List<QueryNode> query) {
        m.checkNotNullParameter(userSuggestion, "userSuggestion");
        m.checkNotNullParameter(mentionsFilterString, "mentionsFilterString");
        m.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), n.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.MENTIONS, mentionsFilterString), new UserNode(userSuggestion.getUserName(), userSuggestion.getDiscriminator())}), query);
    }

    public final void onQueryClicked(List<? extends QueryNode> query) {
        m.checkNotNullParameter(query, "query");
        this.forcedInputSubject.k.onNext(query);
    }

    public final void updateInput(String input) {
        m.checkNotNullParameter(input, "input");
        this.inputSubject.k.onNext(input);
    }
}
