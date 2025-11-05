package com.discord.widgets.stickers;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.premium.PremiumTier;
import com.discord.api.sticker.Sticker;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.premium.PremiumUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StickerSheetViewModel.kt */
/* loaded from: classes.dex */
public final class StickerSheetViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean hasFiredAnalytics;
    private final String location;
    private final Sticker sticker;
    private final StoreStickers storeStickers;
    private final StoreUser storeUser;

    /* compiled from: StickerSheetViewModel.kt */
    /* renamed from: com.discord.widgets.stickers.StickerSheetViewModel$1, reason: invalid class name */
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
            StickerSheetViewModel.access$handleStoreState(StickerSheetViewModel.this, storeState);
        }
    }

    /* compiled from: StickerSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, StoreStickers storeStickers, StoreUser storeUser, Sticker sticker) {
            return companion.observeStoreState(storeStickers, storeUser, sticker);
        }

        private final Observable<StoreState> observeStoreState(StoreStickers storeStickers, StoreUser storeUser, Sticker sticker) {
            Long packId = sticker.getPackId();
            m.checkNotNull(packId);
            Observable<StoreState> observableJ = Observable.j(storeStickers.observeStickerPack(packId.longValue()), StoreUser.observeMe$default(storeUser, false, 1, null), StickerSheetViewModel$Companion$observeStoreState$1.INSTANCE);
            m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…ser\n          )\n        }");
            return observableJ;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StickerSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final MeUser meUser;
        private final StoreStickers.StickerPackState stickerPack;

        public StoreState(StoreStickers.StickerPackState stickerPackState, MeUser meUser) {
            m.checkNotNullParameter(stickerPackState, "stickerPack");
            m.checkNotNullParameter(meUser, "meUser");
            this.stickerPack = stickerPackState;
            this.meUser = meUser;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreStickers.StickerPackState stickerPackState, MeUser meUser, int i, Object obj) {
            if ((i & 1) != 0) {
                stickerPackState = storeState.stickerPack;
            }
            if ((i & 2) != 0) {
                meUser = storeState.meUser;
            }
            return storeState.copy(stickerPackState, meUser);
        }

        /* renamed from: component1, reason: from getter */
        public final StoreStickers.StickerPackState getStickerPack() {
            return this.stickerPack;
        }

        /* renamed from: component2, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final StoreState copy(StoreStickers.StickerPackState stickerPack, MeUser meUser) {
            m.checkNotNullParameter(stickerPack, "stickerPack");
            m.checkNotNullParameter(meUser, "meUser");
            return new StoreState(stickerPack, meUser);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return m.areEqual(this.stickerPack, storeState.stickerPack) && m.areEqual(this.meUser, storeState.meUser);
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final StoreStickers.StickerPackState getStickerPack() {
            return this.stickerPack;
        }

        public int hashCode() {
            StoreStickers.StickerPackState stickerPackState = this.stickerPack;
            int iHashCode = (stickerPackState != null ? stickerPackState.hashCode() : 0) * 31;
            MeUser meUser = this.meUser;
            return iHashCode + (meUser != null ? meUser.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("StoreState(stickerPack=");
            sbU.append(this.stickerPack);
            sbU.append(", meUser=");
            sbU.append(this.meUser);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: StickerSheetViewModel.kt */
    public static final /* data */ class ViewState {
        private final boolean canUsePremiumStickers;
        private final boolean isStickerPackEnabled;
        private final PremiumTier meUserPremiumTier;
        private final Sticker sticker;
        private final ModelStickerPack stickerPack;

        public ViewState(ModelStickerPack modelStickerPack, Sticker sticker, PremiumTier premiumTier, boolean z2) {
            m.checkNotNullParameter(modelStickerPack, "stickerPack");
            m.checkNotNullParameter(sticker, "sticker");
            m.checkNotNullParameter(premiumTier, "meUserPremiumTier");
            this.stickerPack = modelStickerPack;
            this.sticker = sticker;
            this.meUserPremiumTier = premiumTier;
            this.isStickerPackEnabled = z2;
            this.canUsePremiumStickers = PremiumUtilsKt.grantsAccessToPremiumStickers(premiumTier);
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, ModelStickerPack modelStickerPack, Sticker sticker, PremiumTier premiumTier, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                modelStickerPack = viewState.stickerPack;
            }
            if ((i & 2) != 0) {
                sticker = viewState.sticker;
            }
            if ((i & 4) != 0) {
                premiumTier = viewState.meUserPremiumTier;
            }
            if ((i & 8) != 0) {
                z2 = viewState.isStickerPackEnabled;
            }
            return viewState.copy(modelStickerPack, sticker, premiumTier, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelStickerPack getStickerPack() {
            return this.stickerPack;
        }

        /* renamed from: component2, reason: from getter */
        public final Sticker getSticker() {
            return this.sticker;
        }

        /* renamed from: component3, reason: from getter */
        public final PremiumTier getMeUserPremiumTier() {
            return this.meUserPremiumTier;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsStickerPackEnabled() {
            return this.isStickerPackEnabled;
        }

        public final ViewState copy(ModelStickerPack stickerPack, Sticker sticker, PremiumTier meUserPremiumTier, boolean isStickerPackEnabled) {
            m.checkNotNullParameter(stickerPack, "stickerPack");
            m.checkNotNullParameter(sticker, "sticker");
            m.checkNotNullParameter(meUserPremiumTier, "meUserPremiumTier");
            return new ViewState(stickerPack, sticker, meUserPremiumTier, isStickerPackEnabled);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return m.areEqual(this.stickerPack, viewState.stickerPack) && m.areEqual(this.sticker, viewState.sticker) && m.areEqual(this.meUserPremiumTier, viewState.meUserPremiumTier) && this.isStickerPackEnabled == viewState.isStickerPackEnabled;
        }

        public final boolean getCanUsePremiumStickers() {
            return this.canUsePremiumStickers;
        }

        public final PremiumTier getMeUserPremiumTier() {
            return this.meUserPremiumTier;
        }

        public final Sticker getSticker() {
            return this.sticker;
        }

        public final ModelStickerPack getStickerPack() {
            return this.stickerPack;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ModelStickerPack modelStickerPack = this.stickerPack;
            int iHashCode = (modelStickerPack != null ? modelStickerPack.hashCode() : 0) * 31;
            Sticker sticker = this.sticker;
            int iHashCode2 = (iHashCode + (sticker != null ? sticker.hashCode() : 0)) * 31;
            PremiumTier premiumTier = this.meUserPremiumTier;
            int iHashCode3 = (iHashCode2 + (premiumTier != null ? premiumTier.hashCode() : 0)) * 31;
            boolean z2 = this.isStickerPackEnabled;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode3 + i;
        }

        public final boolean isStickerPackEnabled() {
            return this.isStickerPackEnabled;
        }

        public String toString() {
            StringBuilder sbU = a.U("ViewState(stickerPack=");
            sbU.append(this.stickerPack);
            sbU.append(", sticker=");
            sbU.append(this.sticker);
            sbU.append(", meUserPremiumTier=");
            sbU.append(this.meUserPremiumTier);
            sbU.append(", isStickerPackEnabled=");
            return a.O(sbU, this.isStickerPackEnabled, ")");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ StickerSheetViewModel(Sticker sticker, StoreStickers storeStickers, StoreUser storeUser, String str, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreStickers stickers = (i & 2) != 0 ? StoreStream.INSTANCE.getStickers() : storeStickers;
        StoreUser users = (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        this(sticker, stickers, users, str, (i & 16) != 0 ? Companion.access$observeStoreState(INSTANCE, stickers, users, sticker) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(StickerSheetViewModel stickerSheetViewModel, StoreState storeState) {
        stickerSheetViewModel.handleStoreState(storeState);
    }

    private final void fetchStickersData() {
        StoreStickers storeStickers = this.storeStickers;
        Long packId = this.sticker.getPackId();
        m.checkNotNull(packId);
        storeStickers.fetchStickerPack(packId.longValue());
        this.storeStickers.fetchEnabledStickerDirectory();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[LOOP:0: B:14:0x0071->B:38:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleLoadedStoreState(StoreState storeState) {
        boolean z2;
        MeUser meUser = storeState.getMeUser();
        StoreStickers.StickerPackState stickerPack = storeState.getStickerPack();
        Objects.requireNonNull(stickerPack, "null cannot be cast to non-null type com.discord.stores.StoreStickers.StickerPackState.Loaded");
        ModelStickerPack stickerPack2 = ((StoreStickers.StickerPackState.Loaded) stickerPack).getStickerPack();
        if (!this.hasFiredAnalytics && this.location != null) {
            StickerPurchaseLocation popoutPurchaseLocation = StickerPurchaseLocation.INSTANCE.getPopoutPurchaseLocation(stickerPack2.canBePurchased());
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            Long packId = this.sticker.getPackId();
            m.checkNotNull(packId);
            analyticsTracker.stickerPopoutOpened(packId.longValue(), this.location, new Traits.Location(null, popoutPurchaseLocation.getAnalyticsValue(), null, null, null, 29, null));
            this.hasFiredAnalytics = true;
        }
        Sticker sticker = this.sticker;
        PremiumTier premiumTier = meUser.getPremiumTier();
        List<ModelStickerPack> enabledStickerPacks = this.storeStickers.getEnabledStickerPacks();
        boolean z3 = false;
        if (!(enabledStickerPacks instanceof Collection) || !enabledStickerPacks.isEmpty()) {
            Iterator<T> it = enabledStickerPacks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                List<Sticker> stickers = ((ModelStickerPack) it.next()).getStickers();
                if ((stickers instanceof Collection) && stickers.isEmpty()) {
                    z2 = false;
                    if (!z2) {
                    }
                } else {
                    Iterator<T> it2 = stickers.iterator();
                    while (it2.hasNext()) {
                        if (((Sticker) it2.next()).getId() == this.sticker.getId()) {
                            z2 = true;
                            break;
                        }
                    }
                    z2 = false;
                    if (!z2) {
                        z3 = true;
                        break;
                    }
                }
            }
        }
        updateViewState(new ViewState(stickerPack2, sticker, premiumTier, z3));
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (storeState.getStickerPack() instanceof StoreStickers.StickerPackState.Loaded) {
            handleLoadedStoreState(storeState);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerSheetViewModel(Sticker sticker, StoreStickers storeStickers, StoreUser storeUser, String str, Observable<StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(sticker, "sticker");
        m.checkNotNullParameter(storeStickers, "storeStickers");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.sticker = sticker;
        this.storeStickers = storeStickers;
        this.storeUser = storeUser;
        this.location = str;
        fetchStickersData();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), StickerSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
