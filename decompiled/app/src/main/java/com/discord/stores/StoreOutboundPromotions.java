package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import com.discord.api.premium.ClaimedOutboundPromotion;
import com.discord.api.premium.OutboundPromotion;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelPayload;
import com.discord.models.user.MeUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.settings.premium.OutboundPromosPreviewFeatureFlag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* compiled from: StoreOutboundPromotions.kt */
/* loaded from: classes2.dex */
public final class StoreOutboundPromotions extends StoreV2 {
    private static final String CONSUMED_ENTITLEMENT_PROMO_ID = "CONSUMED_ENTITLEMENT_CODE";
    private static final String LATEST_SEEN_PROMO_DATE = "LATEST_SEEN_PROMO_DATE";
    private static final long NO_PROMO_ID = -1;
    private static final long NO_SEEN_PROMO_DATE = -1;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final OutboundPromosPreviewFeatureFlag previewFeatureFlag;
    private final RestAPI restAPI;
    private State state;
    private State stateSnapshot;

    /* compiled from: StoreOutboundPromotions.kt */
    public static abstract class State {

        /* compiled from: StoreOutboundPromotions.kt */
        public static final class Failed extends State {
            public static final Failed INSTANCE = new Failed();

            private Failed() {
                super(null);
            }
        }

        /* compiled from: StoreOutboundPromotions.kt */
        public static final /* data */ class Loaded extends State {
            private final int unseenCount;
            private final List<OutboundPromotion> validActivePromotions;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<OutboundPromotion> list, int i) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "validActivePromotions");
                this.validActivePromotions = list;
                this.unseenCount = i;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    list = loaded.validActivePromotions;
                }
                if ((i2 & 2) != 0) {
                    i = loaded.unseenCount;
                }
                return loaded.copy(list, i);
            }

            public final List<OutboundPromotion> component1() {
                return this.validActivePromotions;
            }

            /* renamed from: component2, reason: from getter */
            public final int getUnseenCount() {
                return this.unseenCount;
            }

            public final Loaded copy(List<OutboundPromotion> validActivePromotions, int unseenCount) {
                Intrinsics3.checkNotNullParameter(validActivePromotions, "validActivePromotions");
                return new Loaded(validActivePromotions, unseenCount);
            }

            @Override // com.discord.stores.StoreOutboundPromotions.State
            public /* bridge */ /* synthetic */ State deepCopy() {
                return deepCopy();
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.validActivePromotions, loaded.validActivePromotions) && this.unseenCount == loaded.unseenCount;
            }

            public final int getUnseenCount() {
                return this.unseenCount;
            }

            public final List<OutboundPromotion> getValidActivePromotions() {
                return this.validActivePromotions;
            }

            public int hashCode() {
                List<OutboundPromotion> list = this.validActivePromotions;
                return ((list != null ? list.hashCode() : 0) * 31) + this.unseenCount;
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(validActivePromotions=");
                sbM833U.append(this.validActivePromotions);
                sbM833U.append(", unseenCount=");
                return outline.m814B(sbM833U, this.unseenCount, ")");
            }

            @Override // com.discord.stores.StoreOutboundPromotions.State
            public Loaded deepCopy() {
                return copy$default(this, new ArrayList(this.validActivePromotions), 0, 2, null);
            }
        }

        /* compiled from: StoreOutboundPromotions.kt */
        public static final class Loading extends State {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private State() {
        }

        public State deepCopy() {
            return this;
        }

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreOutboundPromotions.kt */
    /* renamed from: com.discord.stores.StoreOutboundPromotions$markSeen$1 */
    public static final class C63191 extends Lambda implements Function0<Unit> {
        public C63191() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            List<OutboundPromotion> validActivePromotions;
            State stateAccess$getState$p = StoreOutboundPromotions.access$getState$p(StoreOutboundPromotions.this);
            Object next = null;
            if (!(stateAccess$getState$p instanceof State.Loaded)) {
                stateAccess$getState$p = null;
            }
            State.Loaded loaded = (State.Loaded) stateAccess$getState$p;
            if (loaded == null || (validActivePromotions = loaded.getValidActivePromotions()) == null) {
                return;
            }
            Iterator<T> it = validActivePromotions.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    UtcDateTime startDate = ((OutboundPromotion) next).getStartDate();
                    do {
                        Object next2 = it.next();
                        UtcDateTime startDate2 = ((OutboundPromotion) next2).getStartDate();
                        if (startDate.compareTo(startDate2) < 0) {
                            next = next2;
                            startDate = startDate2;
                        }
                    } while (it.hasNext());
                }
            }
            OutboundPromotion outboundPromotion = (OutboundPromotion) next;
            if (outboundPromotion != null) {
                SharedPreferences.Editor editorEdit = StoreOutboundPromotions.this.getPrefs().edit();
                Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
                editorEdit.putLong(StoreOutboundPromotions.LATEST_SEEN_PROMO_DATE, outboundPromotion.getStartDate().getDateTimeMillis());
                editorEdit.apply();
                StoreOutboundPromotions storeOutboundPromotions = StoreOutboundPromotions.this;
                StoreOutboundPromotions.access$setState$p(storeOutboundPromotions, new State.Loaded(validActivePromotions, StoreOutboundPromotions.access$getUnseenCount(storeOutboundPromotions, validActivePromotions)));
                StoreOutboundPromotions.this.markChanged();
            }
        }
    }

    /* compiled from: StoreOutboundPromotions.kt */
    /* renamed from: com.discord.stores.StoreOutboundPromotions$observeState$1 */
    public static final class C63201 extends Lambda implements Function0<State> {
        public C63201() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ State invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreOutboundPromotions.this.getStateSnapshot();
        }
    }

    /* compiled from: StoreOutboundPromotions.kt */
    /* renamed from: com.discord.stores.StoreOutboundPromotions$observeUnseenCount$1 */
    public static final class C63211 extends Lambda implements Function0<Integer> {
        public C63211() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return StoreOutboundPromotions.this.getUnseenCount();
        }
    }

    public /* synthetic */ StoreOutboundPromotions(OutboundPromosPreviewFeatureFlag outboundPromosPreviewFeatureFlag, Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(outboundPromosPreviewFeatureFlag, dispatcher, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck, (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreOutboundPromotions storeOutboundPromotions) {
        return storeOutboundPromotions.dispatcher;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreOutboundPromotions storeOutboundPromotions) {
        return storeOutboundPromotions.restAPI;
    }

    public static final /* synthetic */ State access$getState$p(StoreOutboundPromotions storeOutboundPromotions) {
        return storeOutboundPromotions.state;
    }

    public static final /* synthetic */ int access$getUnseenCount(StoreOutboundPromotions storeOutboundPromotions, List list) {
        return storeOutboundPromotions.getUnseenCount(list);
    }

    public static final /* synthetic */ void access$setState$p(StoreOutboundPromotions storeOutboundPromotions, State state) {
        storeOutboundPromotions.state = state;
    }

    public final Observable<ClaimedOutboundPromotion> claimOutboundPromotion(long promotionId) {
        return this.restAPI.claimOutboundPromotion(promotionId);
    }

    public final Observable<List<ClaimedOutboundPromotion>> fetchClaimedOutboundPromotions() {
        return this.restAPI.getClaimedOutboundPromotions();
    }

    /* renamed from: getState, reason: from getter */
    public final State getStateSnapshot() {
        return this.stateSnapshot;
    }

    public final int getUnseenCount() {
        State stateSnapshot = getStateSnapshot();
        if (!(stateSnapshot instanceof State.Loaded)) {
            stateSnapshot = null;
        }
        State.Loaded loaded = (State.Loaded) stateSnapshot;
        if (loaded != null) {
            return loaded.getUnseenCount();
        }
        return 0;
    }

    @Store3
    public final void handleConnectionOpen$app_productionGoogleRelease(ModelPayload readyPayload) {
        Intrinsics3.checkNotNullParameter(readyPayload, "readyPayload");
        UserUtils userUtils = UserUtils.INSTANCE;
        User me2 = readyPayload.getMe();
        Intrinsics3.checkNotNullExpressionValue(me2, "readyPayload.me");
        if (!userUtils.isPremiumTier2(new MeUser(me2))) {
            this.state = new State.Loaded(Collections2.emptyList(), 0);
            markChanged();
            return;
        }
        this.state = State.Loading.INSTANCE;
        markChanged();
        RestAPI restAPI = this.restAPI;
        Observable observableM11082A = ObservableExtensionsKt.restSubscribeOn$default(this.previewFeatureFlag.isEnabled() ? restAPI.getAllPreviewPromotions() : restAPI.getAllActiveOutboundPromotions(), false, 1, null).m11082A(new StoreOutboundPromotions2(this));
        Intrinsics3.checkNotNullExpressionValue(observableM11082A, "restAPI.run {\n        if…            }\n          }");
        ObservableExtensionsKt.appSubscribe$default(observableM11082A, StoreOutboundPromotions.class, (Context) null, (Function1) null, new StoreOutboundPromotions3(this), (Function0) null, (Function0) null, new StoreOutboundPromotions4(this), 54, (Object) null);
    }

    public final void markSeen() {
        this.dispatcher.schedule(new C63191());
    }

    public final Observable<State> observeState() {
        Observable<State> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C63201(), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Integer> observeUnseenCount() {
        Observable<Integer> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C63211(), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.stateSnapshot = this.state.deepCopy();
    }

    private final int getUnseenCount(List<OutboundPromotion> promos) {
        long j = getPrefs().getLong(LATEST_SEEN_PROMO_DATE, -1L);
        if ((promos instanceof Collection) && promos.isEmpty()) {
            return 0;
        }
        Iterator<T> it = promos.iterator();
        int i = 0;
        while (it.hasNext()) {
            if ((((OutboundPromotion) it.next()).getStartDate().getDateTimeMillis() > j) && (i = i + 1) < 0) {
                Collections2.throwCountOverflow();
            }
        }
        return i;
    }

    public StoreOutboundPromotions(OutboundPromosPreviewFeatureFlag outboundPromosPreviewFeatureFlag, Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(outboundPromosPreviewFeatureFlag, "previewFeatureFlag");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.previewFeatureFlag = outboundPromosPreviewFeatureFlag;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        State.Loading loading = State.Loading.INSTANCE;
        this.state = loading;
        this.stateSnapshot = loading;
    }
}
