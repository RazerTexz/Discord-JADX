package com.discord.widgets.settings;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.core.app.FrameMetricsAggregator;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreNotificationUpsells;
import com.discord.stores.StoreOutboundPromotions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreSubscriptions;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.handoff.MobileWebHandoff;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: SettingsViewModel.kt */
/* loaded from: classes2.dex */
public final class SettingsViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String MANAGE_SUBSCRIPTIONS_URL = "/settings/subscriptions/role-subscriptions";
    private final StoreSubscriptions subscriptionsStore;

    /* compiled from: SettingsViewModel.kt */
    /* renamed from: com.discord.widgets.settings.SettingsViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
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
            SettingsViewModel settingsViewModel = SettingsViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            SettingsViewModel.access$handleStoreState(settingsViewModel, storeState);
        }
    }

    /* compiled from: SettingsViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ boolean access$isActiveGuildSubscription$p(Companion companion, ModelSubscription modelSubscription) {
            return companion.isActiveGuildSubscription(modelSubscription);
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, StoreUser storeUser, StoreGuilds storeGuilds, StoreUserPresence storeUserPresence, StoreOutboundPromotions storeOutboundPromotions, StoreNotificationUpsells storeNotificationUpsells, StoreExperiments storeExperiments, StoreSubscriptions storeSubscriptions, ObservationDeck observationDeck) {
            return companion.observeStoreState(storeUser, storeGuilds, storeUserPresence, storeOutboundPromotions, storeNotificationUpsells, storeExperiments, storeSubscriptions, observationDeck);
        }

        private final boolean isActiveGuildSubscription(ModelSubscription modelSubscription) {
            return modelSubscription.getType() == ModelSubscription.Type.GUILD && modelSubscription.getStatus() != ModelSubscription.Status.ENDED;
        }

        private final Observable<StoreState> observeStoreState(StoreUser userStore, StoreGuilds guildsStore, StoreUserPresence userPresenceStore, StoreOutboundPromotions outboundPromotionsStore, StoreNotificationUpsells notificationUpsellsStore, StoreExperiments experimentsStore, StoreSubscriptions subscriptionsStore, ObservationDeck observationDeck) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{userStore, guildsStore, userPresenceStore, outboundPromotionsStore, notificationUpsellsStore, subscriptionsStore}, false, null, null, new SettingsViewModel2(subscriptionsStore, userStore, guildsStore, userPresenceStore, outboundPromotionsStore, notificationUpsellsStore, experimentsStore), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SettingsViewModel.kt */
    public static final /* data */ class StoreState {
        private final boolean isEligibleForMobileWebSubscriptions;
        private final boolean isStaffOrAlpha;
        private final MeUser meUser;
        private final Presence presence;
        private final int promoCount;
        private final boolean pushNotificationUpsellDismissed;
        private final List<ModelSubscription> subscriptions;

        public StoreState(MeUser meUser, boolean z2, Presence presence, int i, boolean z3, boolean z4, List<ModelSubscription> list) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(presence, "presence");
            this.meUser = meUser;
            this.isStaffOrAlpha = z2;
            this.presence = presence;
            this.promoCount = i;
            this.pushNotificationUpsellDismissed = z3;
            this.isEligibleForMobileWebSubscriptions = z4;
            this.subscriptions = list;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, MeUser meUser, boolean z2, Presence presence, int i, boolean z3, boolean z4, List list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                meUser = storeState.meUser;
            }
            if ((i2 & 2) != 0) {
                z2 = storeState.isStaffOrAlpha;
            }
            boolean z5 = z2;
            if ((i2 & 4) != 0) {
                presence = storeState.presence;
            }
            Presence presence2 = presence;
            if ((i2 & 8) != 0) {
                i = storeState.promoCount;
            }
            int i3 = i;
            if ((i2 & 16) != 0) {
                z3 = storeState.pushNotificationUpsellDismissed;
            }
            boolean z6 = z3;
            if ((i2 & 32) != 0) {
                z4 = storeState.isEligibleForMobileWebSubscriptions;
            }
            boolean z7 = z4;
            if ((i2 & 64) != 0) {
                list = storeState.subscriptions;
            }
            return storeState.copy(meUser, z5, presence2, i3, z6, z7, list);
        }

        /* renamed from: component1, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsStaffOrAlpha() {
            return this.isStaffOrAlpha;
        }

        /* renamed from: component3, reason: from getter */
        public final Presence getPresence() {
            return this.presence;
        }

        /* renamed from: component4, reason: from getter */
        public final int getPromoCount() {
            return this.promoCount;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getPushNotificationUpsellDismissed() {
            return this.pushNotificationUpsellDismissed;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsEligibleForMobileWebSubscriptions() {
            return this.isEligibleForMobileWebSubscriptions;
        }

        public final List<ModelSubscription> component7() {
            return this.subscriptions;
        }

        public final StoreState copy(MeUser meUser, boolean isStaffOrAlpha, Presence presence, int promoCount, boolean pushNotificationUpsellDismissed, boolean isEligibleForMobileWebSubscriptions, List<ModelSubscription> subscriptions) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(presence, "presence");
            return new StoreState(meUser, isStaffOrAlpha, presence, promoCount, pushNotificationUpsellDismissed, isEligibleForMobileWebSubscriptions, subscriptions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.meUser, storeState.meUser) && this.isStaffOrAlpha == storeState.isStaffOrAlpha && Intrinsics3.areEqual(this.presence, storeState.presence) && this.promoCount == storeState.promoCount && this.pushNotificationUpsellDismissed == storeState.pushNotificationUpsellDismissed && this.isEligibleForMobileWebSubscriptions == storeState.isEligibleForMobileWebSubscriptions && Intrinsics3.areEqual(this.subscriptions, storeState.subscriptions);
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final Presence getPresence() {
            return this.presence;
        }

        public final int getPromoCount() {
            return this.promoCount;
        }

        public final boolean getPushNotificationUpsellDismissed() {
            return this.pushNotificationUpsellDismissed;
        }

        public final List<ModelSubscription> getSubscriptions() {
            return this.subscriptions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            MeUser meUser = this.meUser;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            boolean z2 = this.isStaffOrAlpha;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            Presence presence = this.presence;
            int iHashCode2 = (((i2 + (presence != null ? presence.hashCode() : 0)) * 31) + this.promoCount) * 31;
            boolean z3 = this.pushNotificationUpsellDismissed;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (iHashCode2 + i3) * 31;
            boolean z4 = this.isEligibleForMobileWebSubscriptions;
            int i5 = (i4 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
            List<ModelSubscription> list = this.subscriptions;
            return i5 + (list != null ? list.hashCode() : 0);
        }

        public final boolean isEligibleForMobileWebSubscriptions() {
            return this.isEligibleForMobileWebSubscriptions;
        }

        public final boolean isStaffOrAlpha() {
            return this.isStaffOrAlpha;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(meUser=");
            sbU.append(this.meUser);
            sbU.append(", isStaffOrAlpha=");
            sbU.append(this.isStaffOrAlpha);
            sbU.append(", presence=");
            sbU.append(this.presence);
            sbU.append(", promoCount=");
            sbU.append(this.promoCount);
            sbU.append(", pushNotificationUpsellDismissed=");
            sbU.append(this.pushNotificationUpsellDismissed);
            sbU.append(", isEligibleForMobileWebSubscriptions=");
            sbU.append(this.isEligibleForMobileWebSubscriptions);
            sbU.append(", subscriptions=");
            return outline.L(sbU, this.subscriptions, ")");
        }
    }

    /* compiled from: SettingsViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: SettingsViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final boolean isStaffOrAlpha;
            private final MeUser meUser;
            private final Presence presence;
            private final int promoCount;
            private final boolean pushNotificationUpsellDismissed;
            private final boolean showRoleSubscriptionsButton;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(MeUser meUser, boolean z2, Presence presence, int i, boolean z3, boolean z4) {
                super(null);
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                Intrinsics3.checkNotNullParameter(presence, "presence");
                this.meUser = meUser;
                this.isStaffOrAlpha = z2;
                this.presence = presence;
                this.promoCount = i;
                this.pushNotificationUpsellDismissed = z3;
                this.showRoleSubscriptionsButton = z4;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, MeUser meUser, boolean z2, Presence presence, int i, boolean z3, boolean z4, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    meUser = loaded.meUser;
                }
                if ((i2 & 2) != 0) {
                    z2 = loaded.isStaffOrAlpha;
                }
                boolean z5 = z2;
                if ((i2 & 4) != 0) {
                    presence = loaded.presence;
                }
                Presence presence2 = presence;
                if ((i2 & 8) != 0) {
                    i = loaded.promoCount;
                }
                int i3 = i;
                if ((i2 & 16) != 0) {
                    z3 = loaded.pushNotificationUpsellDismissed;
                }
                boolean z6 = z3;
                if ((i2 & 32) != 0) {
                    z4 = loaded.showRoleSubscriptionsButton;
                }
                return loaded.copy(meUser, z5, presence2, i3, z6, z4);
            }

            /* renamed from: component1, reason: from getter */
            public final MeUser getMeUser() {
                return this.meUser;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsStaffOrAlpha() {
                return this.isStaffOrAlpha;
            }

            /* renamed from: component3, reason: from getter */
            public final Presence getPresence() {
                return this.presence;
            }

            /* renamed from: component4, reason: from getter */
            public final int getPromoCount() {
                return this.promoCount;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getPushNotificationUpsellDismissed() {
                return this.pushNotificationUpsellDismissed;
            }

            /* renamed from: component6, reason: from getter */
            public final boolean getShowRoleSubscriptionsButton() {
                return this.showRoleSubscriptionsButton;
            }

            public final Loaded copy(MeUser meUser, boolean isStaffOrAlpha, Presence presence, int promoCount, boolean pushNotificationUpsellDismissed, boolean showRoleSubscriptionsButton) {
                Intrinsics3.checkNotNullParameter(meUser, "meUser");
                Intrinsics3.checkNotNullParameter(presence, "presence");
                return new Loaded(meUser, isStaffOrAlpha, presence, promoCount, pushNotificationUpsellDismissed, showRoleSubscriptionsButton);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.meUser, loaded.meUser) && this.isStaffOrAlpha == loaded.isStaffOrAlpha && Intrinsics3.areEqual(this.presence, loaded.presence) && this.promoCount == loaded.promoCount && this.pushNotificationUpsellDismissed == loaded.pushNotificationUpsellDismissed && this.showRoleSubscriptionsButton == loaded.showRoleSubscriptionsButton;
            }

            public final MeUser getMeUser() {
                return this.meUser;
            }

            public final Presence getPresence() {
                return this.presence;
            }

            public final int getPromoCount() {
                return this.promoCount;
            }

            public final boolean getPushNotificationUpsellDismissed() {
                return this.pushNotificationUpsellDismissed;
            }

            public final boolean getShowRoleSubscriptionsButton() {
                return this.showRoleSubscriptionsButton;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                MeUser meUser = this.meUser;
                int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
                boolean z2 = this.isStaffOrAlpha;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                Presence presence = this.presence;
                int iHashCode2 = (((i2 + (presence != null ? presence.hashCode() : 0)) * 31) + this.promoCount) * 31;
                boolean z3 = this.pushNotificationUpsellDismissed;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (iHashCode2 + i3) * 31;
                boolean z4 = this.showRoleSubscriptionsButton;
                return i4 + (z4 ? 1 : z4 ? 1 : 0);
            }

            public final boolean isStaffOrAlpha() {
                return this.isStaffOrAlpha;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(meUser=");
                sbU.append(this.meUser);
                sbU.append(", isStaffOrAlpha=");
                sbU.append(this.isStaffOrAlpha);
                sbU.append(", presence=");
                sbU.append(this.presence);
                sbU.append(", promoCount=");
                sbU.append(this.promoCount);
                sbU.append(", pushNotificationUpsellDismissed=");
                sbU.append(this.pushNotificationUpsellDismissed);
                sbU.append(", showRoleSubscriptionsButton=");
                return outline.O(sbU, this.showRoleSubscriptionsButton, ")");
            }
        }

        /* compiled from: SettingsViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SettingsViewModel() {
        this(null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SettingsViewModel(StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreNotificationUpsells storeNotificationUpsells, StoreOutboundPromotions storeOutboundPromotions, StoreSubscriptions storeSubscriptions, StoreUser storeUser, StoreUserPresence storeUserPresence, ObservationDeck observationDeck, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreExperiments experiments = (i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments;
        StoreGuilds guilds = (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreNotificationUpsells notificationUpsells = (i & 4) != 0 ? StoreStream.INSTANCE.getNotificationUpsells() : storeNotificationUpsells;
        StoreOutboundPromotions outboundPromotions = (i & 8) != 0 ? StoreStream.INSTANCE.getOutboundPromotions() : storeOutboundPromotions;
        StoreSubscriptions subscriptions = (i & 16) != 0 ? StoreStream.INSTANCE.getSubscriptions() : storeSubscriptions;
        StoreUser users = (i & 32) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreUserPresence presences = (i & 64) != 0 ? StoreStream.INSTANCE.getPresences() : storeUserPresence;
        ObservationDeck observationDeck2 = (i & 128) != 0 ? ObservationDeck4.get() : observationDeck;
        this(experiments, guilds, notificationUpsells, outboundPromotions, subscriptions, users, presences, observationDeck2, (i & 256) != 0 ? Companion.access$observeStoreState(INSTANCE, users, guilds, presences, outboundPromotions, notificationUpsells, experiments, subscriptions, observationDeck2) : observable);
    }

    public static final /* synthetic */ void access$handleStoreState(SettingsViewModel settingsViewModel, StoreState storeState) {
        settingsViewModel.handleStoreState(storeState);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleStoreState(StoreState storeState) {
        boolean z2;
        boolean z3;
        if (storeState.isEligibleForMobileWebSubscriptions()) {
            List<ModelSubscription> subscriptions = storeState.getSubscriptions();
            if (subscriptions == null) {
                subscriptions = Collections2.emptyList();
            }
            if ((subscriptions instanceof Collection) && subscriptions.isEmpty()) {
                z3 = false;
                if (!z3) {
                }
            } else {
                Iterator<T> it = subscriptions.iterator();
                while (it.hasNext()) {
                    if (Companion.access$isActiveGuildSubscription$p(INSTANCE, (ModelSubscription) it.next())) {
                        z3 = true;
                        break;
                    }
                }
                z3 = false;
                if (!z3) {
                    z2 = true;
                }
            }
        } else {
            z2 = false;
        }
        updateViewState(new ViewState.Loaded(storeState.getMeUser(), storeState.isStaffOrAlpha(), storeState.getPresence(), storeState.getPromoCount(), storeState.getPushNotificationUpsellDismissed(), z2));
    }

    public final void openRoleSubscriptionsManagement(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        MobileWebHandoff.tryLaunchRedirectTo$default(new MobileWebHandoff(context, null, null, null, 14, null), MANAGE_SUBSCRIPTIONS_URL, false, false, 6, null);
    }

    public final void refreshSubscriptions() {
        if (this.subscriptionsStore.isFetchingSubscriptions()) {
            return;
        }
        this.subscriptionsStore.fetchSubscriptions();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsViewModel(StoreExperiments storeExperiments, StoreGuilds storeGuilds, StoreNotificationUpsells storeNotificationUpsells, StoreOutboundPromotions storeOutboundPromotions, StoreSubscriptions storeSubscriptions, StoreUser storeUser, StoreUserPresence storeUserPresence, ObservationDeck observationDeck, Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeExperiments, "experimentsStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeNotificationUpsells, "notificationUpsellsStore");
        Intrinsics3.checkNotNullParameter(storeOutboundPromotions, "outboundPromotionsStore");
        Intrinsics3.checkNotNullParameter(storeSubscriptions, "subscriptionsStore");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeUserPresence, "userPresenceStore");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.subscriptionsStore = storeSubscriptions;
        Observable<StoreState> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), SettingsViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
