package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: PriceTierPickerBottomSheetViewModel.kt */
/* loaded from: classes2.dex */
public final class PriceTierPickerBottomSheetViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: PriceTierPickerBottomSheetViewModel.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.PriceTierPickerBottomSheetViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            m.checkNotNullParameter(storeState, "storeState");
            PriceTierPickerBottomSheetViewModel.access$handleStoreState(PriceTierPickerBottomSheetViewModel.this, storeState);
        }
    }

    /* compiled from: PriceTierPickerBottomSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeGuildRoleSubscriptions}, false, null, null, new PriceTierPickerBottomSheetViewModel$Companion$observeStoreState$1(storeGuildRoleSubscriptions), 14, null);
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, int i, Object obj) {
            if ((i & 1) != 0) {
                observationDeck = ObservationDeckProvider.get();
            }
            if ((i & 2) != 0) {
                storeGuildRoleSubscriptions = StoreStream.INSTANCE.getGuildRoleSubscriptions();
            }
            return companion.observeStoreState(observationDeck, storeGuildRoleSubscriptions);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PriceTierPickerBottomSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final StoreGuildRoleSubscriptions.PriceTierState priceTierState;

        public StoreState(StoreGuildRoleSubscriptions.PriceTierState priceTierState) {
            m.checkNotNullParameter(priceTierState, "priceTierState");
            this.priceTierState = priceTierState;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreGuildRoleSubscriptions.PriceTierState priceTierState, int i, Object obj) {
            if ((i & 1) != 0) {
                priceTierState = storeState.priceTierState;
            }
            return storeState.copy(priceTierState);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreGuildRoleSubscriptions.PriceTierState getPriceTierState() {
            return this.priceTierState;
        }

        public final StoreState copy(StoreGuildRoleSubscriptions.PriceTierState priceTierState) {
            m.checkNotNullParameter(priceTierState, "priceTierState");
            return new StoreState(priceTierState);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StoreState) && m.areEqual(this.priceTierState, ((StoreState) other).priceTierState);
            }
            return true;
        }

        public final StoreGuildRoleSubscriptions.PriceTierState getPriceTierState() {
            return this.priceTierState;
        }

        public int hashCode() {
            StoreGuildRoleSubscriptions.PriceTierState priceTierState = this.priceTierState;
            if (priceTierState != null) {
                return priceTierState.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = a.U("StoreState(priceTierState=");
            sbU.append(this.priceTierState);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: PriceTierPickerBottomSheetViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: PriceTierPickerBottomSheetViewModel.kt */
        public static final class Failed extends ViewState {
            public static final Failed INSTANCE = new Failed();

            private Failed() {
                super(null);
            }
        }

        /* compiled from: PriceTierPickerBottomSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final List<Integer> priceTiers;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<Integer> list) {
                super(null);
                m.checkNotNullParameter(list, "priceTiers");
                this.priceTiers = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.priceTiers;
                }
                return loaded.copy(list);
            }

            public final List<Integer> component1() {
                return this.priceTiers;
            }

            public final Loaded copy(List<Integer> priceTiers) {
                m.checkNotNullParameter(priceTiers, "priceTiers");
                return new Loaded(priceTiers);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && m.areEqual(this.priceTiers, ((Loaded) other).priceTiers);
                }
                return true;
            }

            public final List<Integer> getPriceTiers() {
                return this.priceTiers;
            }

            public int hashCode() {
                List<Integer> list = this.priceTiers;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return a.L(a.U("Loaded(priceTiers="), this.priceTiers, ")");
            }
        }

        /* compiled from: PriceTierPickerBottomSheetViewModel.kt */
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

    public PriceTierPickerBottomSheetViewModel() {
        this(null, null, 3, null);
    }

    public /* synthetic */ PriceTierPickerBottomSheetViewModel(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions, (i & 2) != 0 ? Companion.observeStoreState$default(INSTANCE, null, null, 3, null) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(PriceTierPickerBottomSheetViewModel priceTierPickerBottomSheetViewModel, StoreState storeState) {
        priceTierPickerBottomSheetViewModel.handleStoreState(storeState);
    }

    private final void handleStoreState(StoreState storeState) {
        StoreGuildRoleSubscriptions.PriceTierState priceTierState = storeState.getPriceTierState();
        if (priceTierState instanceof StoreGuildRoleSubscriptions.PriceTierState.Loading) {
            updateViewState(ViewState.Loading.INSTANCE);
        } else if (priceTierState instanceof StoreGuildRoleSubscriptions.PriceTierState.Failed) {
            updateViewState(ViewState.Failed.INSTANCE);
        } else if (priceTierState instanceof StoreGuildRoleSubscriptions.PriceTierState.Loaded) {
            updateViewState(new ViewState.Loaded(((StoreGuildRoleSubscriptions.PriceTierState.Loaded) storeState.getPriceTierState()).getPriceTiers()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriceTierPickerBottomSheetViewModel(StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, Observable<StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        m.checkNotNullParameter(observable, "storeObservable");
        storeGuildRoleSubscriptions.fetchPriceTiersIfNonExisting();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), PriceTierPickerBottomSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
