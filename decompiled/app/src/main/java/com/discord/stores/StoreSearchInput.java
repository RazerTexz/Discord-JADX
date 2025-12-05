package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.ChannelNode;
import com.discord.utilities.search.query.node.answer.HasNode;
import com.discord.utilities.search.query.node.answer.HasNode2;
import com.discord.utilities.search.query.node.answer.UserNode;
import com.discord.utilities.search.query.node.content.ContentNode;
import com.discord.utilities.search.query.node.filter.FilterNode;
import com.discord.utilities.search.query.parsing.QueryParser;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.entries.ChannelSuggestion;
import com.discord.utilities.search.suggestion.entries.UserSuggestion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p653p.Schedulers2;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.PublishSubject;
import p658rx.subjects.SerializedSubject;

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
    /* renamed from: com.discord.stores.StoreSearchInput$1 */
    public static final class C63881<T, R> implements Func1<List<? extends QueryNode>, Boolean> {
        public static final C63881 INSTANCE = new C63881();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(List<? extends QueryNode> list) {
            return call2(list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(List<? extends QueryNode> list) {
            Intrinsics3.checkNotNullExpressionValue(list, "it");
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
    /* renamed from: com.discord.stores.StoreSearchInput$2 */
    public static final class C63892 extends Lambda implements Function1<Boolean, Unit> {
        public C63892() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            StoreSearchInput.access$isInputValidSubject$p(StoreSearchInput.this).f27653k.onNext(bool);
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
    /* renamed from: com.discord.stores.StoreSearchInput$init$1 */
    public static final class C63901<T, R> implements Func1<String, List<QueryNode>> {
        public final /* synthetic */ QueryParser $queryParser;

        public C63901(QueryParser queryParser) {
            this.$queryParser = queryParser;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ List<QueryNode> call(String str) {
            return call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<QueryNode> call2(String str) {
            QueryParser queryParser = this.$queryParser;
            Intrinsics3.checkNotNullExpressionValue(str, "it");
            return Parser.parse$default(queryParser, str, null, null, 4, null);
        }
    }

    /* compiled from: StoreSearchInput.kt */
    /* renamed from: com.discord.stores.StoreSearchInput$init$2 */
    public static final /* synthetic */ class C63912 extends FunctionReferenceImpl implements Function1<Subscription, Unit> {
        public C63912(StoreSearchInput storeSearchInput) {
            super(1, storeSearchInput, StoreSearchInput.class, "handleInputSubscription", "handleInputSubscription(Lrx/Subscription;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            StoreSearchInput.access$handleInputSubscription((StoreSearchInput) this.receiver, subscription);
        }
    }

    /* compiled from: StoreSearchInput.kt */
    /* renamed from: com.discord.stores.StoreSearchInput$init$3 */
    public static final /* synthetic */ class C63923 extends FunctionReferenceImpl implements Function1<List<? extends QueryNode>, Unit> {
        public C63923(SerializedSubject serializedSubject) {
            super(1, serializedSubject, SerializedSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends QueryNode> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends QueryNode> list) {
            ((SerializedSubject) this.receiver).f27653k.onNext(list);
        }
    }

    public StoreSearchInput() {
        SerializedSubject<List<QueryNode>, List<QueryNode>> serializedSubject = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.astSubject = serializedSubject;
        this.inputSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(""));
        SerializedSubject<Boolean, Boolean> serializedSubject2 = new SerializedSubject<>(BehaviorSubject.m11130l0(Boolean.FALSE));
        this.isInputValidSubject = serializedSubject2;
        PublishSubject<List<QueryNode>> publishSubjectM11133k0 = PublishSubject.m11133k0();
        this.forcedInputSubject = publishSubjectM11133k0;
        this.isInputValid = serializedSubject2;
        this.currentParsedInput = serializedSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubjectM11133k0, "forcedInputSubject");
        this.forcedInput = publishSubjectM11133k0;
        Observable observableM11098X = ObservableExtensionsKt.leadingEdgeThrottle(serializedSubject, 50L, TimeUnit.MILLISECONDS).m11083G(C63881.INSTANCE).m11098X(Schedulers2.m10873a());
        Intrinsics3.checkNotNullExpressionValue(observableM11098X, "astSubject\n        .lead…Schedulers.computation())");
        ObservableExtensionsKt.appSubscribe$default(observableM11098X, (Context) null, "validateSearchInput", (Function1) null, new C63892(), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
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
        int lastIndex = Collections2.getLastIndex(query);
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
        this.forcedInputSubject.f27650k.onNext(query);
    }

    public final void clear() {
        handleInputSubscription(null);
        this.inputSubject.f27653k.onNext("");
    }

    public final Observable<List<QueryNode>> getCurrentParsedInput() {
        return this.currentParsedInput;
    }

    public final Observable<List<QueryNode>> getForcedInput() {
        return this.forcedInput;
    }

    public final void init(SearchStringProvider searchStringProvider) {
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        Observable observableM11098X = ObservableExtensionsKt.leadingEdgeThrottle(this.inputSubject, 100L, TimeUnit.MILLISECONDS).m11112r().m11083G(new C63901(new QueryParser(searchStringProvider))).m11098X(Schedulers2.m10873a());
        Intrinsics3.checkNotNullExpressionValue(observableM11098X, "inputSubject\n        .le…Schedulers.computation())");
        ObservableExtensionsKt.appSubscribe$default(observableM11098X, StoreSearchInput.class, (Context) null, new C63912(this), (Function1) null, (Function0) null, (Function0) null, new C63923(this.astSubject), 58, (Object) null);
    }

    public final Observable<Boolean> isInputValid() {
        return this.isInputValid;
    }

    public final void onFilterClicked(FilterType filterType, SearchStringProvider searchStringProvider, List<QueryNode> query) {
        FilterNode filterNode;
        Intrinsics3.checkNotNullParameter(filterType, "filterType");
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        Intrinsics3.checkNotNullParameter(query, "query");
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
        replaceAndPublish(arrayList.isEmpty() ? 0 : ((QueryNode) _Collections.last((List) arrayList)) instanceof ContentNode ? Collections2.getLastIndex(query) : query.size(), CollectionsJVM.listOf(filterNode), query);
    }

    public final void onFromUserClicked(UserSuggestion userSuggestion, CharSequence fromFilterString, List<QueryNode> query) {
        Intrinsics3.checkNotNullParameter(userSuggestion, "userSuggestion");
        Intrinsics3.checkNotNullParameter(fromFilterString, "fromFilterString");
        Intrinsics3.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), Collections2.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.FROM, fromFilterString), new UserNode(userSuggestion.getUserName(), userSuggestion.getDiscriminator())}), query);
    }

    public final void onHasClicked(HasNode2 hasAnswerOption, CharSequence hasFilterString, CharSequence hasAnswerString, List<QueryNode> query) {
        Intrinsics3.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
        Intrinsics3.checkNotNullParameter(hasFilterString, "hasFilterString");
        Intrinsics3.checkNotNullParameter(hasAnswerString, "hasAnswerString");
        Intrinsics3.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), Collections2.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.HAS, hasFilterString), new HasNode(hasAnswerOption, hasAnswerString)}), query);
    }

    public final void onInChannelClicked(ChannelSuggestion channelSuggestion, CharSequence inFilterString, List<QueryNode> query) {
        Intrinsics3.checkNotNullParameter(channelSuggestion, "channelSuggestion");
        Intrinsics3.checkNotNullParameter(inFilterString, "inFilterString");
        Intrinsics3.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), Collections2.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.IN, inFilterString), new ChannelNode(channelSuggestion.getChannelName())}), query);
    }

    public final void onMentionsUserClicked(UserSuggestion userSuggestion, CharSequence mentionsFilterString, List<QueryNode> query) {
        Intrinsics3.checkNotNullParameter(userSuggestion, "userSuggestion");
        Intrinsics3.checkNotNullParameter(mentionsFilterString, "mentionsFilterString");
        Intrinsics3.checkNotNullParameter(query, "query");
        replaceAndPublish(getAnswerReplacementStart(query), Collections2.listOf((Object[]) new QueryNode[]{new FilterNode(FilterType.MENTIONS, mentionsFilterString), new UserNode(userSuggestion.getUserName(), userSuggestion.getDiscriminator())}), query);
    }

    public final void onQueryClicked(List<? extends QueryNode> query) {
        Intrinsics3.checkNotNullParameter(query, "query");
        this.forcedInputSubject.f27650k.onNext(query);
    }

    public final void updateInput(String input) {
        Intrinsics3.checkNotNullParameter(input, "input");
        this.inputSubject.f27653k.onNext(input);
    }
}
