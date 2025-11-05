package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
/* loaded from: classes2.dex */
public final class CreateGuildRoleSubscriptionTierViewModel extends AppViewModel<ViewState> {
    private static final int CHANNEL_BENEFITS_STEP = 1;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int DESIGN_STEP = 3;
    private static final int DETAILS_STEP = 0;
    private static final int INTANGIBLE_BENEFITS_STEP = 2;
    private final PublishSubject<Event> eventSubject;
    private final long groupListingId;
    private final long guildId;
    private Boolean isFullServerGating;
    private final RestAPI restApi;
    private final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions;

    /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.CreateGuildRoleSubscriptionTierViewModel$1, reason: invalid class name */
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
            CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel = CreateGuildRoleSubscriptionTierViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            CreateGuildRoleSubscriptionTierViewModel.access$handleStoreState(createGuildRoleSubscriptionTierViewModel, storeState);
        }
    }

    /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, long j, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds) {
            return companion.observeStoreState(j, observationDeck, storeGuildRoleSubscriptions, storeGuilds);
        }

        private final Observable<StoreState> observeStoreState(long guildId, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeGuildRoleSubscriptions}, false, null, null, new CreateGuildRoleSubscriptionTierViewModel2(storeGuildRoleSubscriptions, guildId, storeGuilds), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
    public static abstract class Event {

        /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
        public static final /* data */ class ServerGatingUpdate extends Event {
            private final boolean isFullServerGating;

            public ServerGatingUpdate(boolean z2) {
                super(null);
                this.isFullServerGating = z2;
            }

            public static /* synthetic */ ServerGatingUpdate copy$default(ServerGatingUpdate serverGatingUpdate, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = serverGatingUpdate.isFullServerGating;
                }
                return serverGatingUpdate.copy(z2);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsFullServerGating() {
                return this.isFullServerGating;
            }

            public final ServerGatingUpdate copy(boolean isFullServerGating) {
                return new ServerGatingUpdate(isFullServerGating);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ServerGatingUpdate) && this.isFullServerGating == ((ServerGatingUpdate) other).isFullServerGating;
                }
                return true;
            }

            public int hashCode() {
                boolean z2 = this.isFullServerGating;
                if (z2) {
                    return 1;
                }
                return z2 ? 1 : 0;
            }

            public final boolean isFullServerGating() {
                return this.isFullServerGating;
            }

            public String toString() {
                return outline.O(outline.U("ServerGatingUpdate(isFullServerGating="), this.isFullServerGating, ")");
            }
        }

        /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
        public static final /* data */ class SubmitFailure extends Event {
            private final Error error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SubmitFailure(Error error) {
                super(null);
                Intrinsics3.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ SubmitFailure copy$default(SubmitFailure submitFailure, Error error, int i, Object obj) {
                if ((i & 1) != 0) {
                    error = submitFailure.error;
                }
                return submitFailure.copy(error);
            }

            /* renamed from: component1, reason: from getter */
            public final Error getError() {
                return this.error;
            }

            public final SubmitFailure copy(Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                return new SubmitFailure(error);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SubmitFailure) && Intrinsics3.areEqual(this.error, ((SubmitFailure) other).error);
                }
                return true;
            }

            public final Error getError() {
                return this.error;
            }

            public int hashCode() {
                Error error = this.error;
                if (error != null) {
                    return error.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("SubmitFailure(error=");
                sbU.append(this.error);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
        public static final class SubmitSuccess extends Event {
            public static final SubmitSuccess INSTANCE = new SubmitSuccess();

            private SubmitSuccess() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
    public static final /* data */ class StoreState {
        private final Boolean fullServerGatingOverwrite;
        private final GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing;

        public StoreState() {
            this(null, null, 3, null);
        }

        public StoreState(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean bool) {
            this.guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
            this.fullServerGatingOverwrite = bool;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRoleSubscriptionGroupListing = storeState.guildRoleSubscriptionGroupListing;
            }
            if ((i & 2) != 0) {
                bool = storeState.fullServerGatingOverwrite;
            }
            return storeState.copy(guildRoleSubscriptionGroupListing, bool);
        }

        /* renamed from: component1, reason: from getter */
        public final GuildRoleSubscriptionGroupListing getGuildRoleSubscriptionGroupListing() {
            return this.guildRoleSubscriptionGroupListing;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getFullServerGatingOverwrite() {
            return this.fullServerGatingOverwrite;
        }

        public final StoreState copy(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean fullServerGatingOverwrite) {
            return new StoreState(guildRoleSubscriptionGroupListing, fullServerGatingOverwrite);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guildRoleSubscriptionGroupListing, storeState.guildRoleSubscriptionGroupListing) && Intrinsics3.areEqual(this.fullServerGatingOverwrite, storeState.fullServerGatingOverwrite);
        }

        public final Boolean getFullServerGatingOverwrite() {
            return this.fullServerGatingOverwrite;
        }

        public final GuildRoleSubscriptionGroupListing getGuildRoleSubscriptionGroupListing() {
            return this.guildRoleSubscriptionGroupListing;
        }

        public int hashCode() {
            GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = this.guildRoleSubscriptionGroupListing;
            int iHashCode = (guildRoleSubscriptionGroupListing != null ? guildRoleSubscriptionGroupListing.hashCode() : 0) * 31;
            Boolean bool = this.fullServerGatingOverwrite;
            return iHashCode + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guildRoleSubscriptionGroupListing=");
            sbU.append(this.guildRoleSubscriptionGroupListing);
            sbU.append(", fullServerGatingOverwrite=");
            return outline.D(sbU, this.fullServerGatingOverwrite, ")");
        }

        public /* synthetic */ StoreState(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : guildRoleSubscriptionGroupListing, (i & 2) != 0 ? null : bool);
        }
    }

    /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
    public static final /* data */ class ViewState {
        private final boolean canProceed;
        private final int currentStep;
        private final GuildRoleSubscriptionTier guildRoleSubscriptionTier;
        private final boolean isSubmitting;

        public ViewState() {
            this(0, false, false, null, 15, null);
        }

        public ViewState(int i, boolean z2, boolean z3, GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
            this.currentStep = i;
            this.canProceed = z2;
            this.isSubmitting = z3;
            this.guildRoleSubscriptionTier = guildRoleSubscriptionTier;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, int i, boolean z2, boolean z3, GuildRoleSubscriptionTier guildRoleSubscriptionTier, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = viewState.currentStep;
            }
            if ((i2 & 2) != 0) {
                z2 = viewState.canProceed;
            }
            if ((i2 & 4) != 0) {
                z3 = viewState.isSubmitting;
            }
            if ((i2 & 8) != 0) {
                guildRoleSubscriptionTier = viewState.guildRoleSubscriptionTier;
            }
            return viewState.copy(i, z2, z3, guildRoleSubscriptionTier);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCurrentStep() {
            return this.currentStep;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getCanProceed() {
            return this.canProceed;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsSubmitting() {
            return this.isSubmitting;
        }

        /* renamed from: component4, reason: from getter */
        public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
            return this.guildRoleSubscriptionTier;
        }

        public final ViewState copy(int currentStep, boolean canProceed, boolean isSubmitting, GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
            return new ViewState(currentStep, canProceed, isSubmitting, guildRoleSubscriptionTier);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.currentStep == viewState.currentStep && this.canProceed == viewState.canProceed && this.isSubmitting == viewState.isSubmitting && Intrinsics3.areEqual(this.guildRoleSubscriptionTier, viewState.guildRoleSubscriptionTier);
        }

        public final boolean getCanProceed() {
            return this.canProceed;
        }

        public final int getCurrentStep() {
            return this.currentStep;
        }

        public final GuildRoleSubscriptionTier getGuildRoleSubscriptionTier() {
            return this.guildRoleSubscriptionTier;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i = this.currentStep * 31;
            boolean z2 = this.canProceed;
            int i2 = z2;
            if (z2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            boolean z3 = this.isSubmitting;
            int i4 = (i3 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            GuildRoleSubscriptionTier guildRoleSubscriptionTier = this.guildRoleSubscriptionTier;
            return i4 + (guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.hashCode() : 0);
        }

        public final boolean isSubmitting() {
            return this.isSubmitting;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(currentStep=");
            sbU.append(this.currentStep);
            sbU.append(", canProceed=");
            sbU.append(this.canProceed);
            sbU.append(", isSubmitting=");
            sbU.append(this.isSubmitting);
            sbU.append(", guildRoleSubscriptionTier=");
            sbU.append(this.guildRoleSubscriptionTier);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ ViewState(int i, boolean z2, boolean z3, GuildRoleSubscriptionTier guildRoleSubscriptionTier, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? false : z2, (i2 & 4) != 0 ? false : z3, (i2 & 8) != 0 ? null : guildRoleSubscriptionTier);
        }
    }

    /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.CreateGuildRoleSubscriptionTierViewModel$submit$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRoleSubscriptionTierListing, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            invoke2(guildRoleSubscriptionTierListing);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierListing, "it");
            CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel = CreateGuildRoleSubscriptionTierViewModel.this;
            createGuildRoleSubscriptionTierViewModel.updateViewState2(ViewState.copy$default(CreateGuildRoleSubscriptionTierViewModel.access$requireViewState(createGuildRoleSubscriptionTierViewModel), 0, false, false, null, 11, null));
            CreateGuildRoleSubscriptionTierViewModel.access$emitEvent(CreateGuildRoleSubscriptionTierViewModel.this, Event.SubmitSuccess.INSTANCE);
        }
    }

    /* compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.CreateGuildRoleSubscriptionTierViewModel$submit$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel = CreateGuildRoleSubscriptionTierViewModel.this;
            createGuildRoleSubscriptionTierViewModel.updateViewState2(ViewState.copy$default(CreateGuildRoleSubscriptionTierViewModel.access$requireViewState(createGuildRoleSubscriptionTierViewModel), 0, false, false, null, 11, null));
            CreateGuildRoleSubscriptionTierViewModel.access$emitEvent(CreateGuildRoleSubscriptionTierViewModel.this, new Event.SubmitFailure(error));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CreateGuildRoleSubscriptionTierViewModel(long j, long j2, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds, ObservationDeck observationDeck, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreGuildRoleSubscriptions guildRoleSubscriptions = (i & 8) != 0 ? StoreStream.INSTANCE.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions;
        StoreGuilds guilds = (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        ObservationDeck observationDeck2 = (i & 32) != 0 ? ObservationDeck4.get() : observationDeck;
        this(j, j2, api, guildRoleSubscriptions, guilds, observationDeck2, (i & 64) != 0 ? Companion.access$observeStoreState(INSTANCE, j, observationDeck2, guildRoleSubscriptions, guilds) : observable);
    }

    public static final /* synthetic */ void access$emitEvent(CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel, Event event) {
        createGuildRoleSubscriptionTierViewModel.emitEvent(event);
    }

    public static final /* synthetic */ void access$handleStoreState(CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel, StoreState storeState) {
        createGuildRoleSubscriptionTierViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ ViewState access$requireViewState(CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel) {
        return createGuildRoleSubscriptionTierViewModel.requireViewState();
    }

    private final boolean computeCanProceedToNextStep(ViewState viewState) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = viewState.getGuildRoleSubscriptionTier();
        int currentStep = viewState.getCurrentStep();
        if (currentStep == 0) {
            String name = guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.getName() : null;
            if (name == null || StringsJVM.isBlank(name)) {
                return false;
            }
            if ((guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.getPriceTier() : null) == null) {
                return false;
            }
            String description = guildRoleSubscriptionTier.getDescription();
            if (description == null || StringsJVM.isBlank(description)) {
                return false;
            }
            String image = guildRoleSubscriptionTier.getImage();
            if (image == null || StringsJVM.isBlank(image)) {
                return false;
            }
        } else if (currentStep != 1 && currentStep != 2) {
            if (currentStep != 3) {
                return false;
            }
            if ((guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.getMemberColor() : null) == null) {
                return false;
            }
        }
        return true;
    }

    @MainThread
    private final void emitEvent(Event event) {
        this.eventSubject.k.onNext(event);
    }

    private final void handleStoreState(StoreState storeState) {
        if (storeState.getGuildRoleSubscriptionGroupListing() != null) {
            Boolean fullServerGatingOverwrite = storeState.getFullServerGatingOverwrite();
            boolean zBooleanValue = fullServerGatingOverwrite != null ? fullServerGatingOverwrite.booleanValue() : storeState.getGuildRoleSubscriptionGroupListing().getFullServerGate();
            this.isFullServerGating = Boolean.valueOf(zBooleanValue);
            emitEvent(new Event.ServerGatingUpdate(zBooleanValue));
        }
    }

    public final void goToNextStep() {
        ViewState viewStateRequireViewState = requireViewState();
        updateViewState2(ViewState.copy$default(viewStateRequireViewState, viewStateRequireViewState.getCurrentStep() + 1, false, false, null, 14, null));
    }

    public final void goToPreviousStep() {
        updateViewState2(ViewState.copy$default(requireViewState(), r1.getCurrentStep() - 1, false, false, null, 14, null));
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onTierUpdated(GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        updateViewState2(ViewState.copy$default(requireViewState(), 0, false, false, guildRoleSubscriptionTier, 7, null));
    }

    public final void submit() {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        if (guildRoleSubscriptionTier != null) {
            String name = guildRoleSubscriptionTier.getName();
            if ((name == null || StringsJVM.isBlank(name)) || guildRoleSubscriptionTier.getPriceTier() == null || guildRoleSubscriptionTier.getMemberColor() == null) {
                return;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(GuildRoleSubscriptionUtils.INSTANCE.createGuildRoleSubscriptionTierListing(this.restApi, this.storeGuildRoleSubscriptions, this.guildId, this.groupListingId, guildRoleSubscriptionTier.getName(), guildRoleSubscriptionTier.getDescription(), guildRoleSubscriptionTier.getPriceTier().intValue(), guildRoleSubscriptionTier.getImage(), ColorCompat.INSTANCE.removeAlphaComponent(guildRoleSubscriptionTier.getMemberColor().intValue()), guildRoleSubscriptionTier.getMemberIcon(), guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(this.isFullServerGating), guildRoleSubscriptionTier.getChannelBenefits(), guildRoleSubscriptionTier.getIntangibleBenefits()), this, null, 2, null), CreateGuildRoleSubscriptionTierViewModel.class, (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
        }
    }

    @Override // b.a.d.AppViewModel
    public /* bridge */ /* synthetic */ void updateViewState(ViewState viewState) {
        updateViewState2(viewState);
    }

    /* renamed from: updateViewState, reason: avoid collision after fix types in other method */
    public void updateViewState2(ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        super.updateViewState((CreateGuildRoleSubscriptionTierViewModel) ViewState.copy$default(viewState, 0, computeCanProceedToNextStep(viewState), false, null, 13, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateGuildRoleSubscriptionTierViewModel(long j, long j2, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds, ObservationDeck observationDeck, Observable<StoreState> observable) {
        super(new ViewState(0, false, false, null, 15, null));
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.groupListingId = j2;
        this.restApi = restAPI;
        this.storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.eventSubject = PublishSubject.k0();
        Observable<StoreState> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), CreateGuildRoleSubscriptionTierViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
