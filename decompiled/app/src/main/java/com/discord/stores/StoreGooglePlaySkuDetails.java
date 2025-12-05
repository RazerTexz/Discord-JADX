package com.discord.stores;

import com.android.billingclient.api.SkuDetails;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.billing.GooglePlayInAppSku3;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p512d0._Ranges;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* compiled from: StoreGooglePlaySkuDetails.kt */
/* loaded from: classes2.dex */
public final class StoreGooglePlaySkuDetails extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private State skuState;
    private State skuStateSnapshot;

    /* compiled from: StoreGooglePlaySkuDetails.kt */
    public static abstract class State {

        /* compiled from: StoreGooglePlaySkuDetails.kt */
        public static final class Failure extends State {
            public static final Failure INSTANCE = new Failure();

            private Failure() {
                super(null);
            }
        }

        /* compiled from: StoreGooglePlaySkuDetails.kt */
        public static final /* data */ class Loaded extends State {
            private final Map<String, SkuDetails> skuDetails;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(Map<String, ? extends SkuDetails> map) {
                super(null);
                Intrinsics3.checkNotNullParameter(map, "skuDetails");
                this.skuDetails = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = loaded.skuDetails;
                }
                return loaded.copy(map);
            }

            public final Map<String, SkuDetails> component1() {
                return this.skuDetails;
            }

            public final Loaded copy(Map<String, ? extends SkuDetails> skuDetails) {
                Intrinsics3.checkNotNullParameter(skuDetails, "skuDetails");
                return new Loaded(skuDetails);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.skuDetails, ((Loaded) other).skuDetails);
                }
                return true;
            }

            public final Map<String, SkuDetails> getSkuDetails() {
                return this.skuDetails;
            }

            public int hashCode() {
                Map<String, SkuDetails> map = this.skuDetails;
                if (map != null) {
                    return map.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.m825M(outline.m833U("Loaded(skuDetails="), this.skuDetails, ")");
            }
        }

        /* compiled from: StoreGooglePlaySkuDetails.kt */
        public static final class Uninitialized extends State {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private State() {
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreGooglePlaySkuDetails.kt */
    /* renamed from: com.discord.stores.StoreGooglePlaySkuDetails$handleError$1 */
    public static final class C60141 extends Lambda implements Function0<Unit> {
        public C60141() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGooglePlaySkuDetails.this.handleFetchError();
        }
    }

    /* compiled from: StoreGooglePlaySkuDetails.kt */
    /* renamed from: com.discord.stores.StoreGooglePlaySkuDetails$observeState$1 */
    public static final class C60151 extends Lambda implements Function0<State> {
        public C60151() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ State invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreGooglePlaySkuDetails.this.getSkuStateSnapshot();
        }
    }

    /* compiled from: StoreGooglePlaySkuDetails.kt */
    /* renamed from: com.discord.stores.StoreGooglePlaySkuDetails$updateSkuDetails$1 */
    public static final class C60161 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $skuDetails;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60161(List list) {
            super(0);
            this.$skuDetails = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGooglePlaySkuDetails.this.handleFetchSuccess(this.$skuDetails);
        }
    }

    public StoreGooglePlaySkuDetails(ObservationDeck observationDeck, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        State.Uninitialized uninitialized = State.Uninitialized.INSTANCE;
        this.skuState = uninitialized;
        this.skuStateSnapshot = uninitialized;
    }

    /* renamed from: getState, reason: from getter */
    public final State getSkuStateSnapshot() {
        return this.skuStateSnapshot;
    }

    public final void handleError() {
        this.dispatcher.schedule(new C60141());
    }

    @Store3
    public final void handleFetchError() {
        this.skuState = State.Failure.INSTANCE;
        markChanged();
    }

    @Store3
    public final void handleFetchSuccess(List<? extends SkuDetails> newSkuDetails) {
        Intrinsics3.checkNotNullParameter(newSkuDetails, "newSkuDetails");
        State state = this.skuState;
        if (!(state instanceof State.Loaded)) {
            state = null;
        }
        State.Loaded loaded = (State.Loaded) state;
        Map<String, SkuDetails> skuDetails = loaded != null ? loaded.getSkuDetails() : null;
        if (skuDetails == null) {
            skuDetails = Maps6.emptyMap();
        }
        Map<String, ? extends SkuDetails> mutableMap = Maps6.toMutableMap(skuDetails);
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(newSkuDetails, 10)), 16));
        for (Object obj : newSkuDetails) {
            linkedHashMap.put(((SkuDetails) obj).m7503d(), obj);
        }
        mutableMap.putAll(linkedHashMap);
        GooglePlayInAppSku3.INSTANCE.populateSkuDetails(mutableMap);
        this.skuState = new State.Loaded(mutableMap);
        markChanged();
    }

    public final Observable<State> observeState() {
        Observable<State> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C60151(), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        State stateCopy = this.skuState;
        if (stateCopy instanceof State.Loaded) {
            State.Loaded loaded = (State.Loaded) stateCopy;
            stateCopy = loaded.copy(new HashMap(loaded.getSkuDetails()));
        } else if (!Intrinsics3.areEqual(stateCopy, State.Uninitialized.INSTANCE) && !Intrinsics3.areEqual(stateCopy, State.Failure.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        this.skuStateSnapshot = stateCopy;
    }

    public final void updateSkuDetails(List<? extends SkuDetails> skuDetails) {
        Intrinsics3.checkNotNullParameter(skuDetails, "skuDetails");
        this.dispatcher.schedule(new C60161(skuDetails));
    }
}
