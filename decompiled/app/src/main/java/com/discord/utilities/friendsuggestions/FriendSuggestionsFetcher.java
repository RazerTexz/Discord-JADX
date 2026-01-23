package com.discord.utilities.friendsuggestions;

import android.content.Context;
import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.restapi.RestAPIInterface;
import com.discord.stores.Dispatcher;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Subscription;

/* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendSuggestionsFetcher {
    private final Dispatcher dispatcher;
    private Subscription fetchSubscription;
    private final Function0<Unit> onFetchFailure;
    private final Function1<List<FriendSuggestion>, Unit> onFetchSuccess;
    private final RestAPIInterface restApi;

    /* JADX INFO: renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$1 */
    /* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
    public static final class C67581 extends Lambda implements Function1<Subscription, Unit> {
        public C67581() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            FriendSuggestionsFetcher.access$setFetchSubscription$p(FriendSuggestionsFetcher.this, subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$2 */
    /* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
    public static final class C67592 extends Lambda implements Function1<List<? extends FriendSuggestion>, Unit> {

        /* JADX INFO: renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $response;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$response = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FriendSuggestionsFetcher.access$getOnFetchSuccess$p(FriendSuggestionsFetcher.this).invoke(this.$response);
            }
        }

        public C67592() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends FriendSuggestion> list) {
            invoke2((List<FriendSuggestion>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<FriendSuggestion> list) {
            Intrinsics3.checkNotNullParameter(list, "response");
            FriendSuggestionsFetcher.access$getDispatcher$p(FriendSuggestionsFetcher.this).schedule(new AnonymousClass1(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$3 */
    /* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
    public static final class C67603 extends Lambda implements Function1<Error, Unit> {

        /* JADX INFO: renamed from: com.discord.utilities.friendsuggestions.FriendSuggestionsFetcher$maybeFetch$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FriendSuggestionsFetcher.access$getOnFetchFailure$p(FriendSuggestionsFetcher.this).invoke();
            }
        }

        public C67603() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            FriendSuggestionsFetcher.access$getDispatcher$p(FriendSuggestionsFetcher.this).schedule(new AnonymousClass1());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FriendSuggestionsFetcher(Dispatcher dispatcher, RestAPIInterface restAPIInterface, Function1<? super List<FriendSuggestion>, Unit> function1, Function0<Unit> function0) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPIInterface, "restApi");
        Intrinsics3.checkNotNullParameter(function1, "onFetchSuccess");
        Intrinsics3.checkNotNullParameter(function0, "onFetchFailure");
        this.dispatcher = dispatcher;
        this.restApi = restAPIInterface;
        this.onFetchSuccess = function1;
        this.onFetchFailure = function0;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(FriendSuggestionsFetcher friendSuggestionsFetcher) {
        return friendSuggestionsFetcher.dispatcher;
    }

    public static final /* synthetic */ Subscription access$getFetchSubscription$p(FriendSuggestionsFetcher friendSuggestionsFetcher) {
        return friendSuggestionsFetcher.fetchSubscription;
    }

    public static final /* synthetic */ Function0 access$getOnFetchFailure$p(FriendSuggestionsFetcher friendSuggestionsFetcher) {
        return friendSuggestionsFetcher.onFetchFailure;
    }

    public static final /* synthetic */ Function1 access$getOnFetchSuccess$p(FriendSuggestionsFetcher friendSuggestionsFetcher) {
        return friendSuggestionsFetcher.onFetchSuccess;
    }

    public static final /* synthetic */ void access$setFetchSubscription$p(FriendSuggestionsFetcher friendSuggestionsFetcher, Subscription subscription) {
        friendSuggestionsFetcher.fetchSubscription = subscription;
    }

    public final void maybeFetch() {
        Subscription subscription = this.fetchSubscription;
        if (subscription == null || subscription.isUnsubscribed()) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.getFriendSuggestions(), false, 1, null), FriendSuggestionsFetcher.class, (Context) null, new C67581(), new C67603(), (Function0) null, (Function0) null, new C67592(), 50, (Object) null);
        }
    }
}
