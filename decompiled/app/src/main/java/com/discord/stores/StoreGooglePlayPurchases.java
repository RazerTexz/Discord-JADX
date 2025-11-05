package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import b.d.b.a.a;
import com.android.billingclient.api.Purchase;
import com.discord.restapi.RestAPIParams;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.BillingUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import d0.t.n;
import d0.t.u;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import retrofit2.HttpException;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: StoreGooglePlayPurchases.kt */
/* loaded from: classes2.dex */
public final class StoreGooglePlayPurchases extends StoreV2 {
    private static final long CACHED_ANALYTICS_TTL = 259200000;
    private static final String CACHE_KEY_PAYMENT_FLOW_ANALYTICS = "CACHE_KEY_PAYMENT_FLOW_ANALYTICS";
    private static final String VIEWED_GIFTING_WARNING_DIALOG = "VIEWED_GIFTING_WARNING_DIALOG";
    private final AnalyticsTracker analyticsTracker;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final PublishSubject<Event> eventSubject;
    private final Gson gson;
    private final ObservationDeck observationDeck;
    private QueryState queryState;
    private QueryState queryStateSnapshot;
    private final RestAPI restAPI;
    private State storeState;
    private State storeStateSnapshot;

    /* compiled from: StoreGooglePlayPurchases.kt */
    public static final /* data */ class AnalyticsTrait {
        private final Traits.Location locationTrait;
        private final Traits.Payment paymentTrait;
        private final long skuId;
        private final Traits.StoreSku storeSkuTrait;
        private final long timestamp;

        public AnalyticsTrait(long j, long j2, Traits.Location location, Traits.StoreSku storeSku, Traits.Payment payment) {
            m.checkNotNullParameter(location, "locationTrait");
            m.checkNotNullParameter(storeSku, "storeSkuTrait");
            m.checkNotNullParameter(payment, "paymentTrait");
            this.skuId = j;
            this.timestamp = j2;
            this.locationTrait = location;
            this.storeSkuTrait = storeSku;
            this.paymentTrait = payment;
        }

        public static /* synthetic */ AnalyticsTrait copy$default(AnalyticsTrait analyticsTrait, long j, long j2, Traits.Location location, Traits.StoreSku storeSku, Traits.Payment payment, int i, Object obj) {
            return analyticsTrait.copy((i & 1) != 0 ? analyticsTrait.skuId : j, (i & 2) != 0 ? analyticsTrait.timestamp : j2, (i & 4) != 0 ? analyticsTrait.locationTrait : location, (i & 8) != 0 ? analyticsTrait.storeSkuTrait : storeSku, (i & 16) != 0 ? analyticsTrait.paymentTrait : payment);
        }

        /* renamed from: component1, reason: from getter */
        public final long getSkuId() {
            return this.skuId;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* renamed from: component3, reason: from getter */
        public final Traits.Location getLocationTrait() {
            return this.locationTrait;
        }

        /* renamed from: component4, reason: from getter */
        public final Traits.StoreSku getStoreSkuTrait() {
            return this.storeSkuTrait;
        }

        /* renamed from: component5, reason: from getter */
        public final Traits.Payment getPaymentTrait() {
            return this.paymentTrait;
        }

        public final AnalyticsTrait copy(long skuId, long timestamp, Traits.Location locationTrait, Traits.StoreSku storeSkuTrait, Traits.Payment paymentTrait) {
            m.checkNotNullParameter(locationTrait, "locationTrait");
            m.checkNotNullParameter(storeSkuTrait, "storeSkuTrait");
            m.checkNotNullParameter(paymentTrait, "paymentTrait");
            return new AnalyticsTrait(skuId, timestamp, locationTrait, storeSkuTrait, paymentTrait);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnalyticsTrait)) {
                return false;
            }
            AnalyticsTrait analyticsTrait = (AnalyticsTrait) other;
            return this.skuId == analyticsTrait.skuId && this.timestamp == analyticsTrait.timestamp && m.areEqual(this.locationTrait, analyticsTrait.locationTrait) && m.areEqual(this.storeSkuTrait, analyticsTrait.storeSkuTrait) && m.areEqual(this.paymentTrait, analyticsTrait.paymentTrait);
        }

        public final Traits.Location getLocationTrait() {
            return this.locationTrait;
        }

        public final Traits.Payment getPaymentTrait() {
            return this.paymentTrait;
        }

        public final long getSkuId() {
            return this.skuId;
        }

        public final Traits.StoreSku getStoreSkuTrait() {
            return this.storeSkuTrait;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            int iA = (b.a(this.timestamp) + (b.a(this.skuId) * 31)) * 31;
            Traits.Location location = this.locationTrait;
            int iHashCode = (iA + (location != null ? location.hashCode() : 0)) * 31;
            Traits.StoreSku storeSku = this.storeSkuTrait;
            int iHashCode2 = (iHashCode + (storeSku != null ? storeSku.hashCode() : 0)) * 31;
            Traits.Payment payment = this.paymentTrait;
            return iHashCode2 + (payment != null ? payment.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("AnalyticsTrait(skuId=");
            sbU.append(this.skuId);
            sbU.append(", timestamp=");
            sbU.append(this.timestamp);
            sbU.append(", locationTrait=");
            sbU.append(this.locationTrait);
            sbU.append(", storeSkuTrait=");
            sbU.append(this.storeSkuTrait);
            sbU.append(", paymentTrait=");
            sbU.append(this.paymentTrait);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    public static abstract class Event {

        /* compiled from: StoreGooglePlayPurchases.kt */
        public static final /* data */ class PurchaseQueryFailure extends Event {
            private final String newSkuName;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PurchaseQueryFailure(String str) {
                super(null);
                m.checkNotNullParameter(str, "newSkuName");
                this.newSkuName = str;
            }

            public static /* synthetic */ PurchaseQueryFailure copy$default(PurchaseQueryFailure purchaseQueryFailure, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = purchaseQueryFailure.newSkuName;
                }
                return purchaseQueryFailure.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getNewSkuName() {
                return this.newSkuName;
            }

            public final PurchaseQueryFailure copy(String newSkuName) {
                m.checkNotNullParameter(newSkuName, "newSkuName");
                return new PurchaseQueryFailure(newSkuName);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof PurchaseQueryFailure) && m.areEqual(this.newSkuName, ((PurchaseQueryFailure) other).newSkuName);
                }
                return true;
            }

            public final String getNewSkuName() {
                return this.newSkuName;
            }

            public int hashCode() {
                String str = this.newSkuName;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return a.J(a.U("PurchaseQueryFailure(newSkuName="), this.newSkuName, ")");
            }
        }

        /* compiled from: StoreGooglePlayPurchases.kt */
        public static final /* data */ class PurchaseQuerySuccess extends Event {
            private final String giftCode;
            private final String newSkuName;
            private final Long skuId;
            private final Long subscriptionPlanId;

            public /* synthetic */ PurchaseQuerySuccess(String str, Long l, Long l2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : str2);
            }

            public static /* synthetic */ PurchaseQuerySuccess copy$default(PurchaseQuerySuccess purchaseQuerySuccess, String str, Long l, Long l2, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = purchaseQuerySuccess.newSkuName;
                }
                if ((i & 2) != 0) {
                    l = purchaseQuerySuccess.skuId;
                }
                if ((i & 4) != 0) {
                    l2 = purchaseQuerySuccess.subscriptionPlanId;
                }
                if ((i & 8) != 0) {
                    str2 = purchaseQuerySuccess.giftCode;
                }
                return purchaseQuerySuccess.copy(str, l, l2, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getNewSkuName() {
                return this.newSkuName;
            }

            /* renamed from: component2, reason: from getter */
            public final Long getSkuId() {
                return this.skuId;
            }

            /* renamed from: component3, reason: from getter */
            public final Long getSubscriptionPlanId() {
                return this.subscriptionPlanId;
            }

            /* renamed from: component4, reason: from getter */
            public final String getGiftCode() {
                return this.giftCode;
            }

            public final PurchaseQuerySuccess copy(String newSkuName, Long skuId, Long subscriptionPlanId, String giftCode) {
                m.checkNotNullParameter(newSkuName, "newSkuName");
                return new PurchaseQuerySuccess(newSkuName, skuId, subscriptionPlanId, giftCode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PurchaseQuerySuccess)) {
                    return false;
                }
                PurchaseQuerySuccess purchaseQuerySuccess = (PurchaseQuerySuccess) other;
                return m.areEqual(this.newSkuName, purchaseQuerySuccess.newSkuName) && m.areEqual(this.skuId, purchaseQuerySuccess.skuId) && m.areEqual(this.subscriptionPlanId, purchaseQuerySuccess.subscriptionPlanId) && m.areEqual(this.giftCode, purchaseQuerySuccess.giftCode);
            }

            public final String getGiftCode() {
                return this.giftCode;
            }

            public final String getNewSkuName() {
                return this.newSkuName;
            }

            public final Long getSkuId() {
                return this.skuId;
            }

            public final Long getSubscriptionPlanId() {
                return this.subscriptionPlanId;
            }

            public int hashCode() {
                String str = this.newSkuName;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                Long l = this.skuId;
                int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
                Long l2 = this.subscriptionPlanId;
                int iHashCode3 = (iHashCode2 + (l2 != null ? l2.hashCode() : 0)) * 31;
                String str2 = this.giftCode;
                return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("PurchaseQuerySuccess(newSkuName=");
                sbU.append(this.newSkuName);
                sbU.append(", skuId=");
                sbU.append(this.skuId);
                sbU.append(", subscriptionPlanId=");
                sbU.append(this.subscriptionPlanId);
                sbU.append(", giftCode=");
                return a.J(sbU, this.giftCode, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PurchaseQuerySuccess(String str, Long l, Long l2, String str2) {
                super(null);
                m.checkNotNullParameter(str, "newSkuName");
                this.newSkuName = str;
                this.skuId = l;
                this.subscriptionPlanId = l2;
                this.giftCode = str2;
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    public static abstract class QueryState {

        /* compiled from: StoreGooglePlayPurchases.kt */
        public static final class InProgress extends QueryState {
            public static final InProgress INSTANCE = new InProgress();

            private InProgress() {
                super(null);
            }
        }

        /* compiled from: StoreGooglePlayPurchases.kt */
        public static final class NotInProgress extends QueryState {
            public static final NotInProgress INSTANCE = new NotInProgress();

            private NotInProgress() {
                super(null);
            }
        }

        private QueryState() {
        }

        public /* synthetic */ QueryState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    public static abstract class State {

        /* compiled from: StoreGooglePlayPurchases.kt */
        public static final class Uninitialized extends State {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private State() {
        }

        /* compiled from: StoreGooglePlayPurchases.kt */
        public static final /* data */ class Loaded extends State {
            private final List<Purchase> iapPurchases;
            private final PendingDowngrade pendingDowngrade;
            private final List<Purchase> subscriptionPurchases;

            public /* synthetic */ Loaded(List list, List list2, PendingDowngrade pendingDowngrade, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? n.emptyList() : list, (i & 2) != 0 ? n.emptyList() : list2, pendingDowngrade);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, List list2, PendingDowngrade pendingDowngrade, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.subscriptionPurchases;
                }
                if ((i & 2) != 0) {
                    list2 = loaded.iapPurchases;
                }
                if ((i & 4) != 0) {
                    pendingDowngrade = loaded.pendingDowngrade;
                }
                return loaded.copy(list, list2, pendingDowngrade);
            }

            public final List<Purchase> component1() {
                return this.subscriptionPurchases;
            }

            public final List<Purchase> component2() {
                return this.iapPurchases;
            }

            /* renamed from: component3, reason: from getter */
            public final PendingDowngrade getPendingDowngrade() {
                return this.pendingDowngrade;
            }

            public final Loaded copy(List<? extends Purchase> subscriptionPurchases, List<? extends Purchase> iapPurchases, PendingDowngrade pendingDowngrade) {
                m.checkNotNullParameter(subscriptionPurchases, "subscriptionPurchases");
                m.checkNotNullParameter(iapPurchases, "iapPurchases");
                return new Loaded(subscriptionPurchases, iapPurchases, pendingDowngrade);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return m.areEqual(this.subscriptionPurchases, loaded.subscriptionPurchases) && m.areEqual(this.iapPurchases, loaded.iapPurchases) && m.areEqual(this.pendingDowngrade, loaded.pendingDowngrade);
            }

            public final List<Purchase> getIapPurchases() {
                return this.iapPurchases;
            }

            public final PendingDowngrade getPendingDowngrade() {
                return this.pendingDowngrade;
            }

            public final List<Purchase> getPurchases() {
                return u.plus((Collection) this.subscriptionPurchases, (Iterable) this.iapPurchases);
            }

            public final List<Purchase> getSubscriptionPurchases() {
                return this.subscriptionPurchases;
            }

            public int hashCode() {
                List<Purchase> list = this.subscriptionPurchases;
                int iHashCode = (list != null ? list.hashCode() : 0) * 31;
                List<Purchase> list2 = this.iapPurchases;
                int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
                PendingDowngrade pendingDowngrade = this.pendingDowngrade;
                return iHashCode2 + (pendingDowngrade != null ? pendingDowngrade.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("Loaded(subscriptionPurchases=");
                sbU.append(this.subscriptionPurchases);
                sbU.append(", iapPurchases=");
                sbU.append(this.iapPurchases);
                sbU.append(", pendingDowngrade=");
                sbU.append(this.pendingDowngrade);
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends Purchase> list, List<? extends Purchase> list2, PendingDowngrade pendingDowngrade) {
                super(null);
                m.checkNotNullParameter(list, "subscriptionPurchases");
                m.checkNotNullParameter(list2, "iapPurchases");
                this.subscriptionPurchases = list;
                this.iapPurchases = list2;
                this.pendingDowngrade = pendingDowngrade;
            }
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    public static final /* data */ class VerificationResult {
        private final RestAPIParams.VerifyPurchaseResponse apiResponse;
        private final Purchase purchase;

        public VerificationResult(Purchase purchase, RestAPIParams.VerifyPurchaseResponse verifyPurchaseResponse) {
            m.checkNotNullParameter(purchase, "purchase");
            this.purchase = purchase;
            this.apiResponse = verifyPurchaseResponse;
        }

        public static /* synthetic */ VerificationResult copy$default(VerificationResult verificationResult, Purchase purchase, RestAPIParams.VerifyPurchaseResponse verifyPurchaseResponse, int i, Object obj) {
            if ((i & 1) != 0) {
                purchase = verificationResult.purchase;
            }
            if ((i & 2) != 0) {
                verifyPurchaseResponse = verificationResult.apiResponse;
            }
            return verificationResult.copy(purchase, verifyPurchaseResponse);
        }

        /* renamed from: component1, reason: from getter */
        public final Purchase getPurchase() {
            return this.purchase;
        }

        /* renamed from: component2, reason: from getter */
        public final RestAPIParams.VerifyPurchaseResponse getApiResponse() {
            return this.apiResponse;
        }

        public final VerificationResult copy(Purchase purchase, RestAPIParams.VerifyPurchaseResponse apiResponse) {
            m.checkNotNullParameter(purchase, "purchase");
            return new VerificationResult(purchase, apiResponse);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VerificationResult)) {
                return false;
            }
            VerificationResult verificationResult = (VerificationResult) other;
            return m.areEqual(this.purchase, verificationResult.purchase) && m.areEqual(this.apiResponse, verificationResult.apiResponse);
        }

        public final RestAPIParams.VerifyPurchaseResponse getApiResponse() {
            return this.apiResponse;
        }

        public final Purchase getPurchase() {
            return this.purchase;
        }

        public int hashCode() {
            Purchase purchase = this.purchase;
            int iHashCode = (purchase != null ? purchase.hashCode() : 0) * 31;
            RestAPIParams.VerifyPurchaseResponse verifyPurchaseResponse = this.apiResponse;
            return iHashCode + (verifyPurchaseResponse != null ? verifyPurchaseResponse.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("VerificationResult(purchase=");
            sbU.append(this.purchase);
            sbU.append(", apiResponse=");
            sbU.append(this.apiResponse);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$doDowngrade$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<Throwable, Boolean> {
        public AnonymousClass1(StoreGooglePlayPurchases storeGooglePlayPurchases) {
            super(1, storeGooglePlayPurchases, StoreGooglePlayPurchases.class, "shouldRetryDowngrade", "shouldRetryDowngrade(Ljava/lang/Throwable;)Z", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
            return Boolean.valueOf(invoke2(th));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Throwable th) {
            m.checkNotNullParameter(th, "p1");
            return StoreGooglePlayPurchases.access$shouldRetryDowngrade((StoreGooglePlayPurchases) this.receiver, th);
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$doDowngrade$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Object, Unit> {
        public final /* synthetic */ String $newSkuName;

        /* compiled from: StoreGooglePlayPurchases.kt */
        /* renamed from: com.discord.stores.StoreGooglePlayPurchases$doDowngrade$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                StoreGooglePlayPurchases.access$handleDowngradeSuccess(StoreGooglePlayPurchases.this, anonymousClass2.$newSkuName);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$newSkuName = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj) {
            StoreGooglePlayPurchases.access$getDispatcher$p(StoreGooglePlayPurchases.this).schedule(new AnonymousClass1());
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$doDowngrade$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Error, Unit> {
        public final /* synthetic */ String $newSkuName;

        /* compiled from: StoreGooglePlayPurchases.kt */
        /* renamed from: com.discord.stores.StoreGooglePlayPurchases$doDowngrade$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                StoreGooglePlayPurchases.access$handleDowngradeFailure(StoreGooglePlayPurchases.this, anonymousClass3.$newSkuName);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str) {
            super(1);
            this.$newSkuName = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            StoreGooglePlayPurchases.access$getDispatcher$p(StoreGooglePlayPurchases.this).schedule(new AnonymousClass1());
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$downgradePurchase$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            State stateAccess$getStoreState$p = StoreGooglePlayPurchases.access$getStoreState$p(StoreGooglePlayPurchases.this);
            if (stateAccess$getStoreState$p instanceof State.Loaded) {
                State.Loaded loaded = (State.Loaded) stateAccess$getStoreState$p;
                if (loaded.getPendingDowngrade() != null) {
                    StoreGooglePlayPurchases.access$setQueryState$p(StoreGooglePlayPurchases.this, QueryState.InProgress.INSTANCE);
                    StoreGooglePlayPurchases.this.markChanged();
                    StoreGooglePlayPurchases.access$doDowngrade(StoreGooglePlayPurchases.this, loaded.getPendingDowngrade());
                }
            }
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$observeQueryState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<QueryState> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ QueryState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final QueryState invoke() {
            return StoreGooglePlayPurchases.this.getQueryStateSnapshot();
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$observeState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<State> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ State invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreGooglePlayPurchases.this.getStoreStateSnapshot();
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$onVerificationFailure$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ VerificationResult $verificationResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(VerificationResult verificationResult) {
            super(0);
            this.$verificationResult = verificationResult;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ArrayList<String> arrayListB = this.$verificationResult.getPurchase().b();
            m.checkNotNullExpressionValue(arrayListB, "verificationResult.purchase.skus");
            for (String str : arrayListB) {
                PublishSubject publishSubjectAccess$getEventSubject$p = StoreGooglePlayPurchases.access$getEventSubject$p(StoreGooglePlayPurchases.this);
                m.checkNotNullExpressionValue(str, "sku");
                publishSubjectAccess$getEventSubject$p.k.onNext(new Event.PurchaseQueryFailure(str));
            }
            StoreGooglePlayPurchases.access$setQueryState$p(StoreGooglePlayPurchases.this, QueryState.NotInProgress.INSTANCE);
            StoreGooglePlayPurchases.this.markChanged();
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$onVerificationStart$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGooglePlayPurchases.access$setQueryState$p(StoreGooglePlayPurchases.this, QueryState.InProgress.INSTANCE);
            StoreGooglePlayPurchases.this.markChanged();
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$processPurchases$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ List $purchases;
        public final /* synthetic */ String $skuType;

        /* compiled from: StoreGooglePlayPurchases.kt */
        /* renamed from: com.discord.stores.StoreGooglePlayPurchases$processPurchases$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02361 extends o implements Function1<QueryState, Unit> {
            public C02361() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QueryState queryState) {
                invoke2(queryState);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QueryState queryState) {
                if (queryState instanceof QueryState.NotInProgress) {
                    BillingUtils.INSTANCE.verifyPurchases(AnonymousClass1.this.$purchases);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list, String str) {
            super(0);
            this.$purchases = list;
            this.$skuType = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGooglePlayPurchases.access$handlePurchases(StoreGooglePlayPurchases.this, this.$purchases, this.$skuType);
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(StoreGooglePlayPurchases.this.observeQueryState(), 0L, false, 3, null), StoreGooglePlayPurchases.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C02361(), 62, (Object) null);
        }
    }

    /* compiled from: StoreGooglePlayPurchases.kt */
    /* renamed from: com.discord.stores.StoreGooglePlayPurchases$updatePendingDowngrade$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ PendingDowngrade $newPendingDowngrade;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PendingDowngrade pendingDowngrade) {
            super(0);
            this.$newPendingDowngrade = pendingDowngrade;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGooglePlayPurchases storeGooglePlayPurchases = StoreGooglePlayPurchases.this;
            StoreGooglePlayPurchases.access$setStoreState$p(storeGooglePlayPurchases, new State.Loaded(StoreGooglePlayPurchases.access$getSubscriptionPurchases$p(storeGooglePlayPurchases), StoreGooglePlayPurchases.access$getIapPurchases$p(StoreGooglePlayPurchases.this), this.$newPendingDowngrade));
            StoreGooglePlayPurchases.this.markChanged();
        }
    }

    public StoreGooglePlayPurchases(ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI, Clock clock, Gson gson, AnalyticsTracker analyticsTracker) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(restAPI, "restAPI");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(gson, "gson");
        m.checkNotNullParameter(analyticsTracker, "analyticsTracker");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.clock = clock;
        this.gson = gson;
        this.analyticsTracker = analyticsTracker;
        State.Uninitialized uninitialized = State.Uninitialized.INSTANCE;
        this.storeState = uninitialized;
        this.storeStateSnapshot = uninitialized;
        QueryState.NotInProgress notInProgress = QueryState.NotInProgress.INSTANCE;
        this.queryState = notInProgress;
        this.queryStateSnapshot = notInProgress;
        this.eventSubject = PublishSubject.k0();
    }

    public static final /* synthetic */ void access$doDowngrade(StoreGooglePlayPurchases storeGooglePlayPurchases, PendingDowngrade pendingDowngrade) {
        storeGooglePlayPurchases.doDowngrade(pendingDowngrade);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        return storeGooglePlayPurchases.dispatcher;
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        return storeGooglePlayPurchases.eventSubject;
    }

    public static final /* synthetic */ List access$getIapPurchases$p(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        return storeGooglePlayPurchases.getIapPurchases();
    }

    public static final /* synthetic */ QueryState access$getQueryState$p(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        return storeGooglePlayPurchases.queryState;
    }

    public static final /* synthetic */ State access$getStoreState$p(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        return storeGooglePlayPurchases.storeState;
    }

    public static final /* synthetic */ List access$getSubscriptionPurchases$p(StoreGooglePlayPurchases storeGooglePlayPurchases) {
        return storeGooglePlayPurchases.getSubscriptionPurchases();
    }

    public static final /* synthetic */ void access$handleDowngradeFailure(StoreGooglePlayPurchases storeGooglePlayPurchases, String str) {
        storeGooglePlayPurchases.handleDowngradeFailure(str);
    }

    public static final /* synthetic */ void access$handleDowngradeSuccess(StoreGooglePlayPurchases storeGooglePlayPurchases, String str) {
        storeGooglePlayPurchases.handleDowngradeSuccess(str);
    }

    public static final /* synthetic */ void access$handlePurchases(StoreGooglePlayPurchases storeGooglePlayPurchases, List list, String str) {
        storeGooglePlayPurchases.handlePurchases(list, str);
    }

    public static final /* synthetic */ void access$setQueryState$p(StoreGooglePlayPurchases storeGooglePlayPurchases, QueryState queryState) {
        storeGooglePlayPurchases.queryState = queryState;
    }

    public static final /* synthetic */ void access$setStoreState$p(StoreGooglePlayPurchases storeGooglePlayPurchases, State state) {
        storeGooglePlayPurchases.storeState = state;
    }

    public static final /* synthetic */ boolean access$shouldRetryDowngrade(StoreGooglePlayPurchases storeGooglePlayPurchases, Throwable th) {
        return storeGooglePlayPurchases.shouldRetryDowngrade(th);
    }

    private final void cacheAnalyticsTraits(Map<String, AnalyticsTrait> analyticsTraitsMap) throws JsonIOException {
        getPrefs().edit().putString(CACHE_KEY_PAYMENT_FLOW_ANALYTICS, this.gson.m(analyticsTraitsMap)).apply();
    }

    private final void clearAnalyticsTraits(String paymentGatewaySkuId) throws JsonIOException {
        Map<String, AnalyticsTrait> cachedAnalyticsTraitsMap = getCachedAnalyticsTraitsMap();
        cachedAnalyticsTraitsMap.remove(paymentGatewaySkuId);
        cacheAnalyticsTraits(cachedAnalyticsTraitsMap);
    }

    @StoreThread
    private final void doDowngrade(PendingDowngrade downgrade) {
        String purchaseToken = downgrade.getPurchaseToken();
        String subscriptionId = downgrade.getSubscriptionId();
        String newSkuName = downgrade.getNewSkuName();
        RestAPIParams.DowngradeSubscriptionBody downgradeSubscriptionBody = new RestAPIParams.DowngradeSubscriptionBody(subscriptionId, purchaseToken, newSkuName);
        RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
        Observable<Object> observableX = this.restAPI.downgradeSubscription(downgradeSubscriptionBody).X(j0.p.a.c());
        m.checkNotNullExpressionValue(observableX, "restAPI\n        .downgra…scribeOn(Schedulers.io())");
        ObservableExtensionsKt.appSubscribe$default(RetryWithDelay.restRetry$default(retryWithDelay, observableX, 0L, null, null, new AnonymousClass1(this), 1, null), StoreGooglePlayPurchases.class, (Context) null, (Function1) null, new AnonymousClass3(newSkuName), (Function0) null, (Function0) null, new AnonymousClass2(newSkuName), 54, (Object) null);
    }

    private final Map<String, AnalyticsTrait> getCachedAnalyticsTraitsMap() {
        String string = getPrefs().getString(CACHE_KEY_PAYMENT_FLOW_ANALYTICS, null);
        if (string != null) {
            Map<String, AnalyticsTrait> map = (Map) this.gson.g(string, new StoreGooglePlayPurchases$getCachedAnalyticsTraitsMap$1$typeToken$1().getType());
            if (map != null) {
                return map;
            }
        }
        return new LinkedHashMap();
    }

    private final List<Purchase> getIapPurchases() {
        State storeStateSnapshot = getStoreStateSnapshot();
        if (!(storeStateSnapshot instanceof State.Loaded)) {
            storeStateSnapshot = null;
        }
        State.Loaded loaded = (State.Loaded) storeStateSnapshot;
        List<Purchase> iapPurchases = loaded != null ? loaded.getIapPurchases() : null;
        return iapPurchases != null ? iapPurchases : n.emptyList();
    }

    private final AnalyticsTrait getOrClearAnalyticsTraits(String paymentGatewaySkuId) throws JsonIOException {
        AnalyticsTrait analyticsTrait = getCachedAnalyticsTraitsMap().get(paymentGatewaySkuId);
        if (analyticsTrait == null) {
            return null;
        }
        if (!(this.clock.currentTimeMillis() - analyticsTrait.getTimestamp() > CACHED_ANALYTICS_TTL)) {
            return analyticsTrait;
        }
        clearAnalyticsTraits(paymentGatewaySkuId);
        return null;
    }

    private final PendingDowngrade getPendingDowngrade() {
        State storeStateSnapshot = getStoreStateSnapshot();
        if (!(storeStateSnapshot instanceof State.Loaded)) {
            storeStateSnapshot = null;
        }
        State.Loaded loaded = (State.Loaded) storeStateSnapshot;
        if (loaded != null) {
            return loaded.getPendingDowngrade();
        }
        return null;
    }

    private final List<Purchase> getSubscriptionPurchases() {
        State storeStateSnapshot = getStoreStateSnapshot();
        if (!(storeStateSnapshot instanceof State.Loaded)) {
            storeStateSnapshot = null;
        }
        State.Loaded loaded = (State.Loaded) storeStateSnapshot;
        List<Purchase> subscriptionPurchases = loaded != null ? loaded.getSubscriptionPurchases() : null;
        return subscriptionPurchases != null ? subscriptionPurchases : n.emptyList();
    }

    @StoreThread
    private final void handleDowngradeFailure(String newSkuName) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.PurchaseQueryFailure(newSkuName));
        updatePendingDowngrade(null);
        this.queryState = QueryState.NotInProgress.INSTANCE;
        markChanged();
    }

    @StoreThread
    private final void handleDowngradeSuccess(String newSkuName) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.PurchaseQuerySuccess(newSkuName, null, null, null, 14, null));
        updatePendingDowngrade(null);
        this.queryState = QueryState.NotInProgress.INSTANCE;
        markChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00b7  */
    @StoreThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handlePurchases(List<? extends Purchase> newPurchases, String skuType) {
        State loaded;
        int iHashCode = skuType.hashCode();
        boolean z2 = false;
        if (iHashCode == 3541555 ? !(!skuType.equals("subs") || newPurchases == null || newPurchases.size() != getSubscriptionPurchases().size() || !newPurchases.containsAll(getSubscriptionPurchases()) || !getSubscriptionPurchases().containsAll(newPurchases)) : !(iHashCode != 100343516 || !skuType.equals("inapp") || newPurchases == null || newPurchases.size() != getIapPurchases().size() || !newPurchases.containsAll(getIapPurchases()) || !getIapPurchases().containsAll(newPurchases))) {
            z2 = true;
        }
        if (newPurchases != null && (!newPurchases.isEmpty()) && z2) {
            return;
        }
        int iHashCode2 = skuType.hashCode();
        if (iHashCode2 != 3541555) {
            if (iHashCode2 == 100343516 && skuType.equals("inapp")) {
                if (newPurchases == null) {
                    newPurchases = n.emptyList();
                }
                loaded = new State.Loaded(getSubscriptionPurchases(), newPurchases, getPendingDowngrade());
            } else {
                loaded = State.Uninitialized.INSTANCE;
            }
        } else if (skuType.equals("subs")) {
            if (newPurchases == null) {
                newPurchases = n.emptyList();
            }
            loaded = new State.Loaded(newPurchases, getIapPurchases(), getPendingDowngrade());
        }
        this.storeState = loaded;
        markChanged();
    }

    private final boolean shouldRetryDowngrade(Throwable throwable) {
        if (throwable instanceof TimeoutException) {
            return false;
        }
        if (!(throwable instanceof HttpException)) {
            return throwable instanceof IOException;
        }
        int iA = ((HttpException) throwable).a();
        return 500 <= iA && 599 >= iA;
    }

    public final void downgradePurchase() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    /* renamed from: getQueryState, reason: from getter */
    public final QueryState getQueryStateSnapshot() {
        return this.queryStateSnapshot;
    }

    /* renamed from: getState, reason: from getter */
    public final State getStoreStateSnapshot() {
        return this.storeStateSnapshot;
    }

    public final boolean hasSeenGiftingWarning() {
        return getPrefs().getBoolean(VIEWED_GIFTING_WARNING_DIALOG, false);
    }

    public final void markViewedGiftingWarning() {
        getPrefs().edit().putBoolean(VIEWED_GIFTING_WARNING_DIALOG, true).apply();
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final Observable<QueryState> observeQueryState() {
        Observable<QueryState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<State> observeState() {
        Observable<State> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void onVerificationFailure(VerificationResult verificationResult) {
        m.checkNotNullParameter(verificationResult, "verificationResult");
        this.dispatcher.schedule(new AnonymousClass1(verificationResult));
    }

    public final void onVerificationStart() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void onVerificationSuccess(VerificationResult verificationResult) {
        m.checkNotNullParameter(verificationResult, "verificationResult");
        ArrayList<String> arrayListB = verificationResult.getPurchase().b();
        m.checkNotNullExpressionValue(arrayListB, "verificationResult.purchase.skus");
        Iterator<T> it = arrayListB.iterator();
        while (it.hasNext()) {
            this.dispatcher.schedule(new StoreGooglePlayPurchases$onVerificationSuccess$$inlined$forEach$lambda$1((String) it.next(), this, verificationResult));
        }
    }

    public final void processPurchases(List<? extends Purchase> purchases, String skuType) {
        m.checkNotNullParameter(skuType, "skuType");
        this.dispatcher.schedule(new AnonymousClass1(purchases, skuType));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        State stateCopy$default = this.storeState;
        if (stateCopy$default instanceof State.Loaded) {
            State.Loaded loaded = (State.Loaded) stateCopy$default;
            stateCopy$default = State.Loaded.copy$default(loaded, new ArrayList(loaded.getSubscriptionPurchases()), new ArrayList(loaded.getIapPurchases()), null, 4, null);
        } else if (!m.areEqual(stateCopy$default, State.Uninitialized.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        this.storeStateSnapshot = stateCopy$default;
        this.queryStateSnapshot = this.queryState;
    }

    public final void trackPaymentFlowCompleted(String paymentGatewaySkuId) throws JsonIOException {
        m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        AnalyticsTrait orClearAnalyticsTraits = getOrClearAnalyticsTraits(paymentGatewaySkuId);
        if (orClearAnalyticsTraits != null) {
            AnalyticsTracker.paymentFlowCompleted$default(this.analyticsTracker, orClearAnalyticsTraits.getLocationTrait(), null, orClearAnalyticsTraits.getPaymentTrait(), orClearAnalyticsTraits.getStoreSkuTrait(), null, 18, null);
            clearAnalyticsTraits(paymentGatewaySkuId);
        }
    }

    public final void trackPaymentFlowFailed(String paymentGatewaySkuId) {
        m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        AnalyticsTrait orClearAnalyticsTraits = getOrClearAnalyticsTraits(paymentGatewaySkuId);
        if (orClearAnalyticsTraits != null) {
            AnalyticsTracker.paymentFlowFailed$default(this.analyticsTracker, orClearAnalyticsTraits.getLocationTrait(), null, orClearAnalyticsTraits.getStoreSkuTrait(), orClearAnalyticsTraits.getPaymentTrait(), 2, null);
            clearAnalyticsTraits(paymentGatewaySkuId);
        }
    }

    public final void trackPaymentFlowStarted(String paymentGatewaySkuId, long skuId, Traits.Location locationTrait, Traits.StoreSku storeSkuTrait, Traits.Payment paymentTrait) throws JsonIOException {
        m.checkNotNullParameter(paymentGatewaySkuId, "paymentGatewaySkuId");
        m.checkNotNullParameter(locationTrait, "locationTrait");
        m.checkNotNullParameter(storeSkuTrait, "storeSkuTrait");
        m.checkNotNullParameter(paymentTrait, "paymentTrait");
        AnalyticsTrait analyticsTrait = new AnalyticsTrait(skuId, this.clock.currentTimeMillis(), locationTrait, storeSkuTrait, paymentTrait);
        Map<String, AnalyticsTrait> cachedAnalyticsTraitsMap = getCachedAnalyticsTraitsMap();
        cachedAnalyticsTraitsMap.put(paymentGatewaySkuId, analyticsTrait);
        cacheAnalyticsTraits(cachedAnalyticsTraitsMap);
        AnalyticsTracker.paymentFlowStarted$default(this.analyticsTracker, analyticsTrait.getLocationTrait(), null, analyticsTrait.getStoreSkuTrait(), analyticsTrait.getPaymentTrait(), 2, null);
    }

    public final void trackPaymentFlowStep(String paymentGatewaySkuId, String fromStep, String toStep) throws JsonIOException {
        a.q0(paymentGatewaySkuId, "paymentGatewaySkuId", fromStep, "fromStep", toStep, "toStep");
        AnalyticsTrait orClearAnalyticsTraits = getOrClearAnalyticsTraits(paymentGatewaySkuId);
        if (orClearAnalyticsTraits != null) {
            AnalyticsTracker.paymentFlowStep$default(this.analyticsTracker, orClearAnalyticsTraits.getLocationTrait(), null, toStep, fromStep, orClearAnalyticsTraits.getStoreSkuTrait(), orClearAnalyticsTraits.getPaymentTrait(), 2, null);
        }
    }

    public final void updatePendingDowngrade(PendingDowngrade newPendingDowngrade) {
        this.dispatcher.schedule(new AnonymousClass1(newPendingDowngrade));
    }
}
