package com.discord.widgets.settings.profile;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.user.UserProfile;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserProfile;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: EditProfileBannerSheetViewModel.kt */
/* loaded from: classes2.dex */
public final class EditProfileBannerSheetViewModel extends d0<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String defaultBannerColorHex;
    private final String initialColorPreviewHex;
    private boolean upsellViewedTracked;

    /* compiled from: EditProfileBannerSheetViewModel.kt */
    /* renamed from: com.discord.widgets.settings.profile.EditProfileBannerSheetViewModel$1, reason: invalid class name */
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
            EditProfileBannerSheetViewModel editProfileBannerSheetViewModel = EditProfileBannerSheetViewModel.this;
            m.checkNotNullExpressionValue(storeState, "storeState");
            EditProfileBannerSheetViewModel.access$handleStoreState(editProfileBannerSheetViewModel, storeState);
        }
    }

    /* compiled from: EditProfileBannerSheetViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StoreUser storeUser, StoreUserProfile storeUserProfile) {
            return ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck.UpdateSource[]{StoreUser.INSTANCE.getMeUpdate(), storeUserProfile}, false, null, null, new EditProfileBannerSheetViewModel$Companion$observeStoreState$1(storeUser, storeUserProfile), 14, null);
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, StoreUser storeUser, StoreUserProfile storeUserProfile, int i, Object obj) {
            if ((i & 1) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            if ((i & 2) != 0) {
                storeUserProfile = StoreStream.INSTANCE.getUserProfile();
            }
            return companion.observeStoreState(storeUser, storeUserProfile);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EditProfileBannerSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final User user;
        private final UserProfile userProfile;

        public StoreState(User user, UserProfile userProfile) {
            m.checkNotNullParameter(user, "user");
            m.checkNotNullParameter(userProfile, "userProfile");
            this.user = user;
            this.userProfile = userProfile;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, User user, UserProfile userProfile, int i, Object obj) {
            if ((i & 1) != 0) {
                user = storeState.user;
            }
            if ((i & 2) != 0) {
                userProfile = storeState.userProfile;
            }
            return storeState.copy(user, userProfile);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* renamed from: component2, reason: from getter */
        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        public final StoreState copy(User user, UserProfile userProfile) {
            m.checkNotNullParameter(user, "user");
            m.checkNotNullParameter(userProfile, "userProfile");
            return new StoreState(user, userProfile);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return m.areEqual(this.user, storeState.user) && m.areEqual(this.userProfile, storeState.userProfile);
        }

        public final User getUser() {
            return this.user;
        }

        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            UserProfile userProfile = this.userProfile;
            return iHashCode + (userProfile != null ? userProfile.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("StoreState(user=");
            sbU.append(this.user);
            sbU.append(", userProfile=");
            sbU.append(this.userProfile);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: EditProfileBannerSheetViewModel.kt */
    public static final /* data */ class ViewState {
        private final String bannerColorHex;
        private final boolean showPremiumUpsell;

        public ViewState(String str, boolean z2) {
            m.checkNotNullParameter(str, "bannerColorHex");
            this.bannerColorHex = str;
            this.showPremiumUpsell = z2;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, String str, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = viewState.bannerColorHex;
            }
            if ((i & 2) != 0) {
                z2 = viewState.showPremiumUpsell;
            }
            return viewState.copy(str, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getBannerColorHex() {
            return this.bannerColorHex;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getShowPremiumUpsell() {
            return this.showPremiumUpsell;
        }

        public final ViewState copy(String bannerColorHex, boolean showPremiumUpsell) {
            m.checkNotNullParameter(bannerColorHex, "bannerColorHex");
            return new ViewState(bannerColorHex, showPremiumUpsell);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return m.areEqual(this.bannerColorHex, viewState.bannerColorHex) && this.showPremiumUpsell == viewState.showPremiumUpsell;
        }

        public final String getBannerColorHex() {
            return this.bannerColorHex;
        }

        public final boolean getShowPremiumUpsell() {
            return this.showPremiumUpsell;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.bannerColorHex;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z2 = this.showPremiumUpsell;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public String toString() {
            StringBuilder sbU = a.U("ViewState(bannerColorHex=");
            sbU.append(this.bannerColorHex);
            sbU.append(", showPremiumUpsell=");
            return a.O(sbU, this.showPremiumUpsell, ")");
        }
    }

    public /* synthetic */ EditProfileBannerSheetViewModel(String str, String str2, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? Companion.observeStoreState$default(INSTANCE, null, null, 3, null) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(EditProfileBannerSheetViewModel editProfileBannerSheetViewModel, StoreState storeState) {
        editProfileBannerSheetViewModel.handleStoreState(storeState);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        ViewState viewState = getViewState();
        String bannerColorHex = viewState != null ? viewState.getBannerColorHex() : null;
        User user = storeState.getUser();
        if (bannerColorHex == null) {
            bannerColorHex = this.initialColorPreviewHex;
        }
        if (bannerColorHex == null) {
            bannerColorHex = this.defaultBannerColorHex;
        }
        updateViewState(new ViewState(bannerColorHex, !UserUtils.INSTANCE.isPremiumTier2(user)));
    }

    public final boolean getUpsellViewedTracked() {
        return this.upsellViewedTracked;
    }

    public final void setUpsellViewedTracked(boolean z2) {
        this.upsellViewedTracked = z2;
    }

    @MainThread
    public final void updateColorPreview(String colorHex) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            if (colorHex == null) {
                colorHex = this.defaultBannerColorHex;
            }
            updateViewState(ViewState.copy$default(viewState, colorHex, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditProfileBannerSheetViewModel(String str, String str2, Observable<StoreState> observable) {
        super(null);
        m.checkNotNullParameter(str, "defaultBannerColorHex");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.defaultBannerColorHex = str;
        this.initialColorPreviewHex = str2;
        Observable<StoreState> observableR = observable.r();
        m.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), EditProfileBannerSheetViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
