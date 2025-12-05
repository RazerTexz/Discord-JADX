package com.discord.widgets.settings.billing;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.models.domain.ModelSubscription;
import com.discord.stores.StorePaymentSources;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.settings.billing.PaymentSourceAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.functions.Func2;

/* compiled from: SettingsBillingViewModel.kt */
/* loaded from: classes2.dex */
public final class SettingsBillingViewModel extends AppViewModel<ViewState> {
    private final StorePaymentSources storePaymentSources;
    private final StoreSubscriptions storeSubscriptions;

    /* compiled from: SettingsBillingViewModel.kt */
    /* renamed from: com.discord.widgets.settings.billing.SettingsBillingViewModel$1 */
    public static final class C98041<T1, T2, R> implements Func2<StorePaymentSources.PaymentSourcesState, StoreSubscriptions.SubscriptionsState, StoreState> {
        public static final C98041 INSTANCE = new C98041();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ StoreState call(StorePaymentSources.PaymentSourcesState paymentSourcesState, StoreSubscriptions.SubscriptionsState subscriptionsState) {
            return call2(paymentSourcesState, subscriptionsState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final StoreState call2(StorePaymentSources.PaymentSourcesState paymentSourcesState, StoreSubscriptions.SubscriptionsState subscriptionsState) {
            Intrinsics3.checkNotNullExpressionValue(paymentSourcesState, "paymentSourcesState");
            Intrinsics3.checkNotNullExpressionValue(subscriptionsState, "subscriptionsState");
            return new StoreState(paymentSourcesState, subscriptionsState);
        }
    }

    /* compiled from: SettingsBillingViewModel.kt */
    /* renamed from: com.discord.widgets.settings.billing.SettingsBillingViewModel$2 */
    public static final class C98052 extends Lambda implements Function1<StoreState, Unit> {
        public C98052() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            SettingsBillingViewModel.access$handleStoreState(SettingsBillingViewModel.this, storeState);
        }
    }

    /* compiled from: SettingsBillingViewModel.kt */
    public static final /* data */ class StoreState {
        private final StorePaymentSources.PaymentSourcesState paymentSourceState;
        private final StoreSubscriptions.SubscriptionsState subscriptionsState;

        public StoreState(StorePaymentSources.PaymentSourcesState paymentSourcesState, StoreSubscriptions.SubscriptionsState subscriptionsState) {
            Intrinsics3.checkNotNullParameter(paymentSourcesState, "paymentSourceState");
            Intrinsics3.checkNotNullParameter(subscriptionsState, "subscriptionsState");
            this.paymentSourceState = paymentSourcesState;
            this.subscriptionsState = subscriptionsState;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StorePaymentSources.PaymentSourcesState paymentSourcesState, StoreSubscriptions.SubscriptionsState subscriptionsState, int i, Object obj) {
            if ((i & 1) != 0) {
                paymentSourcesState = storeState.paymentSourceState;
            }
            if ((i & 2) != 0) {
                subscriptionsState = storeState.subscriptionsState;
            }
            return storeState.copy(paymentSourcesState, subscriptionsState);
        }

        /* renamed from: component1, reason: from getter */
        public final StorePaymentSources.PaymentSourcesState getPaymentSourceState() {
            return this.paymentSourceState;
        }

        /* renamed from: component2, reason: from getter */
        public final StoreSubscriptions.SubscriptionsState getSubscriptionsState() {
            return this.subscriptionsState;
        }

        public final StoreState copy(StorePaymentSources.PaymentSourcesState paymentSourceState, StoreSubscriptions.SubscriptionsState subscriptionsState) {
            Intrinsics3.checkNotNullParameter(paymentSourceState, "paymentSourceState");
            Intrinsics3.checkNotNullParameter(subscriptionsState, "subscriptionsState");
            return new StoreState(paymentSourceState, subscriptionsState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.paymentSourceState, storeState.paymentSourceState) && Intrinsics3.areEqual(this.subscriptionsState, storeState.subscriptionsState);
        }

        public final StorePaymentSources.PaymentSourcesState getPaymentSourceState() {
            return this.paymentSourceState;
        }

        public final StoreSubscriptions.SubscriptionsState getSubscriptionsState() {
            return this.subscriptionsState;
        }

        public int hashCode() {
            StorePaymentSources.PaymentSourcesState paymentSourcesState = this.paymentSourceState;
            int iHashCode = (paymentSourcesState != null ? paymentSourcesState.hashCode() : 0) * 31;
            StoreSubscriptions.SubscriptionsState subscriptionsState = this.subscriptionsState;
            return iHashCode + (subscriptionsState != null ? subscriptionsState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("StoreState(paymentSourceState=");
            sbM833U.append(this.paymentSourceState);
            sbM833U.append(", subscriptionsState=");
            sbM833U.append(this.subscriptionsState);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: SettingsBillingViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: SettingsBillingViewModel.kt */
        public static final class Failure extends ViewState {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: SettingsBillingViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final List<PaymentSourceAdapter.Item> paymentSourceItems;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends PaymentSourceAdapter.Item> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "paymentSourceItems");
                this.paymentSourceItems = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.paymentSourceItems;
                }
                return loaded.copy(list);
            }

            public final List<PaymentSourceAdapter.Item> component1() {
                return this.paymentSourceItems;
            }

            public final Loaded copy(List<? extends PaymentSourceAdapter.Item> paymentSourceItems) {
                Intrinsics3.checkNotNullParameter(paymentSourceItems, "paymentSourceItems");
                return new Loaded(paymentSourceItems);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.paymentSourceItems, ((Loaded) other).paymentSourceItems);
                }
                return true;
            }

            public final List<PaymentSourceAdapter.Item> getPaymentSourceItems() {
                return this.paymentSourceItems;
            }

            public int hashCode() {
                List<PaymentSourceAdapter.Item> list = this.paymentSourceItems;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.m824L(outline.m833U("Loaded(paymentSourceItems="), this.paymentSourceItems, ")");
            }
        }

        /* compiled from: SettingsBillingViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SettingsBillingViewModel() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SettingsBillingViewModel(StorePaymentSources storePaymentSources, StoreSubscriptions storeSubscriptions, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        storePaymentSources = (i & 1) != 0 ? StoreStream.INSTANCE.getPaymentSources() : storePaymentSources;
        storeSubscriptions = (i & 2) != 0 ? StoreStream.INSTANCE.getSubscriptions() : storeSubscriptions;
        if ((i & 4) != 0) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            observable = Observable.m11076j(companion.getPaymentSources().observePaymentSourcesState(), companion.getSubscriptions().observeSubscriptions(), C98041.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observable, "Observable\n      .combin…nsState\n        )\n      }");
        }
        this(storePaymentSources, storeSubscriptions, observable);
    }

    public static final /* synthetic */ void access$handleStoreState(SettingsBillingViewModel settingsBillingViewModel, StoreState storeState) {
        settingsBillingViewModel.handleStoreState(storeState);
    }

    private final void fetchData() {
        this.storePaymentSources.fetchPaymentSources();
        this.storeSubscriptions.fetchSubscriptions();
    }

    private final List<PaymentSourceAdapter.Item> generateListItems(List<? extends ModelPaymentSource> paymentSources, ModelSubscription premiumSubscription) {
        ArrayList arrayList = new ArrayList();
        if (!paymentSources.isEmpty()) {
            int i = 0;
            for (Object obj : paymentSources) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                ModelPaymentSource modelPaymentSource = (ModelPaymentSource) obj;
                PaymentSourceAdapter.PaymentSourceHeader.Type type = i != 0 ? i != 1 ? null : PaymentSourceAdapter.PaymentSourceHeader.Type.OTHER : PaymentSourceAdapter.PaymentSourceHeader.Type.DEFAULT;
                PaymentSourceAdapter.PaymentSourceHeader paymentSourceHeader = type != null ? new PaymentSourceAdapter.PaymentSourceHeader(type) : null;
                if (paymentSourceHeader != null) {
                    arrayList.add(paymentSourceHeader);
                }
                arrayList.add(new PaymentSourceAdapter.PaymentSourceItem(modelPaymentSource, Intrinsics3.areEqual(modelPaymentSource.getId(), premiumSubscription != null ? premiumSubscription.getPaymentSourceId() : null) && !premiumSubscription.getStatus().isCanceled()));
                i = i2;
            }
            arrayList.add(new PaymentSourceAdapter.PaymentSourceAddItem());
        }
        return arrayList;
    }

    private final void handleStoreState(StoreState storeState) {
        StorePaymentSources.PaymentSourcesState paymentSourceState = storeState.getPaymentSourceState();
        StoreSubscriptions.SubscriptionsState subscriptionsState = storeState.getSubscriptionsState();
        if ((paymentSourceState instanceof StorePaymentSources.PaymentSourcesState.Loaded) && (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Loaded)) {
            updateViewState(new ViewState.Loaded(generateListItems(((StorePaymentSources.PaymentSourcesState.Loaded) paymentSourceState).getPaymentSources(), ((StoreSubscriptions.SubscriptionsState.Loaded) subscriptionsState).getPremiumSubscription())));
        } else if ((paymentSourceState instanceof StorePaymentSources.PaymentSourcesState.Failure) || (subscriptionsState instanceof StoreSubscriptions.SubscriptionsState.Failure)) {
            updateViewState(ViewState.Failure.INSTANCE);
        } else {
            updateViewState(ViewState.Loading.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsBillingViewModel(StorePaymentSources storePaymentSources, StoreSubscriptions storeSubscriptions, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(storePaymentSources, "storePaymentSources");
        Intrinsics3.checkNotNullParameter(storeSubscriptions, "storeSubscriptions");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.storePaymentSources = storePaymentSources;
        this.storeSubscriptions = storeSubscriptions;
        fetchData();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), SettingsBillingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C98052(), 62, (Object) null);
    }
}
