package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
/* loaded from: classes2.dex */
public final class ServerSettingsCreatorMonetizationOnboardingViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final long guildId;
    private final BehaviorSubject<RequirementsState> requirementsSubject;
    private final RestAPI restApi;

    /* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
    /* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R> implements Func2<StoreState, RequirementsState, Tuples2<? extends StoreState, ? extends RequirementsState>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Tuples2<? extends StoreState, ? extends RequirementsState> call(StoreState storeState, RequirementsState requirementsState) {
            return call2(storeState, requirementsState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Tuples2<StoreState, RequirementsState> call2(StoreState storeState, RequirementsState requirementsState) {
            return Tuples.to(storeState, requirementsState);
        }
    }

    /* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
    /* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Tuples2<? extends StoreState, ? extends RequirementsState>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends StoreState, ? extends RequirementsState> tuples2) {
            invoke2((Tuples2<StoreState, ? extends RequirementsState>) tuples2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<StoreState, ? extends RequirementsState> tuples2) {
            StoreState storeStateComponent1 = tuples2.component1();
            RequirementsState requirementsStateComponent2 = tuples2.component2();
            ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel = ServerSettingsCreatorMonetizationOnboardingViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeStateComponent1, "storeState");
            Intrinsics3.checkNotNullExpressionValue(requirementsStateComponent2, "requirements");
            ServerSettingsCreatorMonetizationOnboardingViewModel.access$handleStoreState(serverSettingsCreatorMonetizationOnboardingViewModel, storeStateComponent1, requirementsStateComponent2);
        }
    }

    /* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStores(Companion companion, ObservationDeck observationDeck, StoreGuilds storeGuilds, StoreUser storeUser, long j) {
            return companion.observeStores(observationDeck, storeGuilds, storeUser, j);
        }

        private final Observable<StoreState> observeStores(ObservationDeck observationDeck, StoreGuilds guilds, StoreUser users, long guildId) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{guilds, users}, false, null, null, new ServerSettingsCreatorMonetizationOnboardingViewModel2(guilds, guildId, users), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
    public static abstract class Event {

        /* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
        public static final /* data */ class ShowErrorToast extends Event {
            private final Throwable error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowErrorToast(Throwable th) {
                super(null);
                Intrinsics3.checkNotNullParameter(th, "error");
                this.error = th;
            }

            public static /* synthetic */ ShowErrorToast copy$default(ShowErrorToast showErrorToast, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    th = showErrorToast.error;
                }
                return showErrorToast.copy(th);
            }

            /* renamed from: component1, reason: from getter */
            public final Throwable getError() {
                return this.error;
            }

            public final ShowErrorToast copy(Throwable error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                return new ShowErrorToast(error);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowErrorToast) && Intrinsics3.areEqual(this.error, ((ShowErrorToast) other).error);
                }
                return true;
            }

            public final Throwable getError() {
                return this.error;
            }

            public int hashCode() {
                Throwable th = this.error;
                if (th != null) {
                    return th.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("ShowErrorToast(error=");
                sbU.append(this.error);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
    public static abstract class RequirementsState {

        /* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
        public static final /* data */ class Error extends RequirementsState {
            private final com.discord.utilities.error.Error error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(com.discord.utilities.error.Error error) {
                super(null);
                Intrinsics3.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ Error copy$default(Error error, com.discord.utilities.error.Error error2, int i, Object obj) {
                if ((i & 1) != 0) {
                    error2 = error.error;
                }
                return error.copy(error2);
            }

            /* renamed from: component1, reason: from getter */
            public final com.discord.utilities.error.Error getError() {
                return this.error;
            }

            public final Error copy(com.discord.utilities.error.Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                return new Error(error);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Error) && Intrinsics3.areEqual(this.error, ((Error) other).error);
                }
                return true;
            }

            public final com.discord.utilities.error.Error getError() {
                return this.error;
            }

            public int hashCode() {
                com.discord.utilities.error.Error error = this.error;
                if (error != null) {
                    return error.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Error(error=");
                sbU.append(this.error);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
        public static final /* data */ class Loaded extends RequirementsState {
            private final CreatorMonetizationEligibilityRequirements requirements;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
                super(null);
                Intrinsics3.checkNotNullParameter(creatorMonetizationEligibilityRequirements, "requirements");
                this.requirements = creatorMonetizationEligibilityRequirements;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements, int i, Object obj) {
                if ((i & 1) != 0) {
                    creatorMonetizationEligibilityRequirements = loaded.requirements;
                }
                return loaded.copy(creatorMonetizationEligibilityRequirements);
            }

            /* renamed from: component1, reason: from getter */
            public final CreatorMonetizationEligibilityRequirements getRequirements() {
                return this.requirements;
            }

            public final Loaded copy(CreatorMonetizationEligibilityRequirements requirements) {
                Intrinsics3.checkNotNullParameter(requirements, "requirements");
                return new Loaded(requirements);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.requirements, ((Loaded) other).requirements);
                }
                return true;
            }

            public final CreatorMonetizationEligibilityRequirements getRequirements() {
                return this.requirements;
            }

            public int hashCode() {
                CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements = this.requirements;
                if (creatorMonetizationEligibilityRequirements != null) {
                    return creatorMonetizationEligibilityRequirements.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(requirements=");
                sbU.append(this.requirements);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
        public static final class Loading extends RequirementsState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private RequirementsState() {
        }

        public /* synthetic */ RequirementsState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
    public static final /* data */ class StoreState {
        private final Guild guild;
        private final boolean isGuildOwner;

        public StoreState(Guild guild, boolean z2) {
            this.guild = guild;
            this.isGuildOwner = z2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = storeState.guild;
            }
            if ((i & 2) != 0) {
                z2 = storeState.isGuildOwner;
            }
            return storeState.copy(guild, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsGuildOwner() {
            return this.isGuildOwner;
        }

        public final StoreState copy(Guild guild, boolean isGuildOwner) {
            return new StoreState(guild, isGuildOwner);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guild, storeState.guild) && this.isGuildOwner == storeState.isGuildOwner;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            boolean z2 = this.isGuildOwner;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public final boolean isGuildOwner() {
            return this.isGuildOwner;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guild=");
            sbU.append(this.guild);
            sbU.append(", isGuildOwner=");
            return outline.O(sbU, this.isGuildOwner, ")");
        }
    }

    /* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
    public static abstract class ViewState {

        /* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
        public static final /* data */ class AcceptTerms extends ViewState {
            private final Guild guild;
            private final boolean hasAcceptedTerms;
            private final boolean isGuildOwner;
            private final boolean isSubmitting;
            private final CreatorMonetizationEnableRequest latestRequest;

            public /* synthetic */ AcceptTerms(Guild guild, boolean z2, CreatorMonetizationEnableRequest creatorMonetizationEnableRequest, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(guild, z2, creatorMonetizationEnableRequest, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4);
            }

            public static /* synthetic */ AcceptTerms copy$default(AcceptTerms acceptTerms, Guild guild, boolean z2, CreatorMonetizationEnableRequest creatorMonetizationEnableRequest, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = acceptTerms.guild;
                }
                if ((i & 2) != 0) {
                    z2 = acceptTerms.isGuildOwner;
                }
                boolean z5 = z2;
                if ((i & 4) != 0) {
                    creatorMonetizationEnableRequest = acceptTerms.latestRequest;
                }
                CreatorMonetizationEnableRequest creatorMonetizationEnableRequest2 = creatorMonetizationEnableRequest;
                if ((i & 8) != 0) {
                    z3 = acceptTerms.hasAcceptedTerms;
                }
                boolean z6 = z3;
                if ((i & 16) != 0) {
                    z4 = acceptTerms.isSubmitting;
                }
                return acceptTerms.copy(guild, z5, creatorMonetizationEnableRequest2, z6, z4);
            }

            /* renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsGuildOwner() {
                return this.isGuildOwner;
            }

            /* renamed from: component3, reason: from getter */
            public final CreatorMonetizationEnableRequest getLatestRequest() {
                return this.latestRequest;
            }

            /* renamed from: component4, reason: from getter */
            public final boolean getHasAcceptedTerms() {
                return this.hasAcceptedTerms;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getIsSubmitting() {
                return this.isSubmitting;
            }

            public final AcceptTerms copy(Guild guild, boolean isGuildOwner, CreatorMonetizationEnableRequest latestRequest, boolean hasAcceptedTerms, boolean isSubmitting) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(latestRequest, "latestRequest");
                return new AcceptTerms(guild, isGuildOwner, latestRequest, hasAcceptedTerms, isSubmitting);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AcceptTerms)) {
                    return false;
                }
                AcceptTerms acceptTerms = (AcceptTerms) other;
                return Intrinsics3.areEqual(this.guild, acceptTerms.guild) && this.isGuildOwner == acceptTerms.isGuildOwner && Intrinsics3.areEqual(this.latestRequest, acceptTerms.latestRequest) && this.hasAcceptedTerms == acceptTerms.hasAcceptedTerms && this.isSubmitting == acceptTerms.isSubmitting;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final boolean getHasAcceptedTerms() {
                return this.hasAcceptedTerms;
            }

            public final CreatorMonetizationEnableRequest getLatestRequest() {
                return this.latestRequest;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                boolean z2 = this.isGuildOwner;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                CreatorMonetizationEnableRequest creatorMonetizationEnableRequest = this.latestRequest;
                int iHashCode2 = (i2 + (creatorMonetizationEnableRequest != null ? creatorMonetizationEnableRequest.hashCode() : 0)) * 31;
                boolean z3 = this.hasAcceptedTerms;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (iHashCode2 + i3) * 31;
                boolean z4 = this.isSubmitting;
                return i4 + (z4 ? 1 : z4 ? 1 : 0);
            }

            public final boolean isGuildOwner() {
                return this.isGuildOwner;
            }

            public final boolean isSubmitting() {
                return this.isSubmitting;
            }

            public String toString() {
                StringBuilder sbU = outline.U("AcceptTerms(guild=");
                sbU.append(this.guild);
                sbU.append(", isGuildOwner=");
                sbU.append(this.isGuildOwner);
                sbU.append(", latestRequest=");
                sbU.append(this.latestRequest);
                sbU.append(", hasAcceptedTerms=");
                sbU.append(this.hasAcceptedTerms);
                sbU.append(", isSubmitting=");
                return outline.O(sbU, this.isSubmitting, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AcceptTerms(Guild guild, boolean z2, CreatorMonetizationEnableRequest creatorMonetizationEnableRequest, boolean z3, boolean z4) {
                super(null);
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(creatorMonetizationEnableRequest, "latestRequest");
                this.guild = guild;
                this.isGuildOwner = z2;
                this.latestRequest = creatorMonetizationEnableRequest;
                this.hasAcceptedTerms = z3;
                this.isSubmitting = z4;
            }
        }

        /* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
        public static final /* data */ class CreateRequest extends ViewState {
            private final boolean isGuildOwner;
            private final boolean isSubmitting;
            private final CreatorMonetizationEligibilityRequirements requirements;

            public /* synthetic */ CreateRequest(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(creatorMonetizationEligibilityRequirements, z2, (i & 4) != 0 ? false : z3);
            }

            public static /* synthetic */ CreateRequest copy$default(CreateRequest createRequest, CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    creatorMonetizationEligibilityRequirements = createRequest.requirements;
                }
                if ((i & 2) != 0) {
                    z2 = createRequest.isGuildOwner;
                }
                if ((i & 4) != 0) {
                    z3 = createRequest.isSubmitting;
                }
                return createRequest.copy(creatorMonetizationEligibilityRequirements, z2, z3);
            }

            /* renamed from: component1, reason: from getter */
            public final CreatorMonetizationEligibilityRequirements getRequirements() {
                return this.requirements;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsGuildOwner() {
                return this.isGuildOwner;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getIsSubmitting() {
                return this.isSubmitting;
            }

            public final CreateRequest copy(CreatorMonetizationEligibilityRequirements requirements, boolean isGuildOwner, boolean isSubmitting) {
                Intrinsics3.checkNotNullParameter(requirements, "requirements");
                return new CreateRequest(requirements, isGuildOwner, isSubmitting);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CreateRequest)) {
                    return false;
                }
                CreateRequest createRequest = (CreateRequest) other;
                return Intrinsics3.areEqual(this.requirements, createRequest.requirements) && this.isGuildOwner == createRequest.isGuildOwner && this.isSubmitting == createRequest.isSubmitting;
            }

            public final CreatorMonetizationEligibilityRequirements getRequirements() {
                return this.requirements;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements = this.requirements;
                int iHashCode = (creatorMonetizationEligibilityRequirements != null ? creatorMonetizationEligibilityRequirements.hashCode() : 0) * 31;
                boolean z2 = this.isGuildOwner;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                boolean z3 = this.isSubmitting;
                return i2 + (z3 ? 1 : z3 ? 1 : 0);
            }

            public final boolean isApplicationPending() {
                CreatorMonetizationEnableRequest latestRequest = this.requirements.getLatestRequest();
                return (latestRequest != null ? latestRequest.getState() : null) == CreatorMonetizationEnableRequest.State.OPEN;
            }

            public final boolean isGuildOwner() {
                return this.isGuildOwner;
            }

            public final boolean isSubmitting() {
                return this.isSubmitting;
            }

            public String toString() {
                StringBuilder sbU = outline.U("CreateRequest(requirements=");
                sbU.append(this.requirements);
                sbU.append(", isGuildOwner=");
                sbU.append(this.isGuildOwner);
                sbU.append(", isSubmitting=");
                return outline.O(sbU, this.isSubmitting, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CreateRequest(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements, boolean z2, boolean z3) {
                super(null);
                Intrinsics3.checkNotNullParameter(creatorMonetizationEligibilityRequirements, "requirements");
                this.requirements = creatorMonetizationEligibilityRequirements;
                this.isGuildOwner = z2;
                this.isSubmitting = z3;
            }
        }

        /* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
        public static final /* data */ class Error extends ViewState {
            private final com.discord.utilities.error.Error error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(com.discord.utilities.error.Error error) {
                super(null);
                Intrinsics3.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ Error copy$default(Error error, com.discord.utilities.error.Error error2, int i, Object obj) {
                if ((i & 1) != 0) {
                    error2 = error.error;
                }
                return error.copy(error2);
            }

            /* renamed from: component1, reason: from getter */
            public final com.discord.utilities.error.Error getError() {
                return this.error;
            }

            public final Error copy(com.discord.utilities.error.Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                return new Error(error);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Error) && Intrinsics3.areEqual(this.error, ((Error) other).error);
                }
                return true;
            }

            public final com.discord.utilities.error.Error getError() {
                return this.error;
            }

            public int hashCode() {
                com.discord.utilities.error.Error error = this.error;
                if (error != null) {
                    return error.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Error(error=");
                sbU.append(this.error);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
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

    /* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
    /* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel$dispatchErrorsToUI$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Throwable> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Throwable th) {
            PublishSubject publishSubjectAccess$getEventSubject$p = ServerSettingsCreatorMonetizationOnboardingViewModel.access$getEventSubject$p(ServerSettingsCreatorMonetizationOnboardingViewModel.this);
            Intrinsics3.checkNotNullExpressionValue(th, "e");
            publishSubjectAccess$getEventSubject$p.k.onNext(new Event.ShowErrorToast(th));
        }
    }

    /* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
    /* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel$refreshRequirements$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass1() {
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
            error.setShowErrorToasts(false);
            ServerSettingsCreatorMonetizationOnboardingViewModel.access$getRequirementsSubject$p(ServerSettingsCreatorMonetizationOnboardingViewModel.this).onNext(new RequirementsState.Error(error));
        }
    }

    /* compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
    /* renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel$refreshRequirements$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<CreatorMonetizationEligibilityRequirements, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
            invoke2(creatorMonetizationEligibilityRequirements);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
            Intrinsics3.checkNotNullParameter(creatorMonetizationEligibilityRequirements, "requirements");
            ServerSettingsCreatorMonetizationOnboardingViewModel.access$getRequirementsSubject$p(ServerSettingsCreatorMonetizationOnboardingViewModel.this).onNext(new RequirementsState.Loaded(creatorMonetizationEligibilityRequirements));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel(long j, RestAPI restAPI, BehaviorSubject behaviorSubject, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        BehaviorSubject behaviorSubject2;
        Observable observableAccess$observeStores;
        RestAPI api = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        if ((i & 4) != 0) {
            BehaviorSubject behaviorSubjectK0 = BehaviorSubject.k0();
            Intrinsics3.checkNotNullExpressionValue(behaviorSubjectK0, "BehaviorSubject.create()");
            behaviorSubject2 = behaviorSubjectK0;
        } else {
            behaviorSubject2 = behaviorSubject;
        }
        if ((i & 8) != 0) {
            Companion companion = INSTANCE;
            ObservationDeck observationDeck = ObservationDeck4.get();
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observableAccess$observeStores = Companion.access$observeStores(companion, observationDeck, companion2.getGuilds(), companion2.getUsers(), j);
        } else {
            observableAccess$observeStores = observable;
        }
        this(j, api, behaviorSubject2, observableAccess$observeStores);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel) {
        return serverSettingsCreatorMonetizationOnboardingViewModel.eventSubject;
    }

    public static final /* synthetic */ BehaviorSubject access$getRequirementsSubject$p(ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel) {
        return serverSettingsCreatorMonetizationOnboardingViewModel.requirementsSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel, StoreState storeState, RequirementsState requirementsState) {
        serverSettingsCreatorMonetizationOnboardingViewModel.handleStoreState(storeState, requirementsState);
    }

    public static final /* synthetic */ ViewState access$requireViewState(ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel) {
        return serverSettingsCreatorMonetizationOnboardingViewModel.requireViewState();
    }

    public static final /* synthetic */ void access$updateViewState(ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel, ViewState viewState) {
        serverSettingsCreatorMonetizationOnboardingViewModel.updateViewState(viewState);
    }

    public static final /* synthetic */ void access$updateWithViewState(ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel, Function1 function1) {
        serverSettingsCreatorMonetizationOnboardingViewModel.updateWithViewState(function1);
    }

    private final <T> Observable<T> dispatchErrorsToUI(Observable<T> observable) {
        return observable.t(new AnonymousClass1());
    }

    private final void handleStoreState(StoreState storeState, RequirementsState requirementsState) {
        ViewState.AcceptTerms acceptTerms;
        if (storeState.getGuild() == null || (requirementsState instanceof RequirementsState.Loading)) {
            updateViewState(ViewState.Loading.INSTANCE);
            return;
        }
        if (requirementsState instanceof RequirementsState.Error) {
            updateViewState(new ViewState.Error(((RequirementsState.Error) requirementsState).getError()));
            return;
        }
        boolean z2 = requirementsState instanceof RequirementsState.Loaded;
        if (z2) {
            RequirementsState.Loaded loaded = (RequirementsState.Loaded) requirementsState;
            CreatorMonetizationEnableRequest latestRequest = loaded.getRequirements().getLatestRequest();
            if ((latestRequest != null ? latestRequest.getState() : null) == CreatorMonetizationEnableRequest.State.APPROVED) {
                ViewState viewStateRequireViewState = requireViewState();
                if (viewStateRequireViewState instanceof ViewState.AcceptTerms) {
                    acceptTerms = ViewState.AcceptTerms.copy$default((ViewState.AcceptTerms) viewStateRequireViewState, storeState.getGuild(), false, null, false, false, 30, null);
                } else {
                    Guild guild = storeState.getGuild();
                    boolean zIsGuildOwner = storeState.isGuildOwner();
                    CreatorMonetizationEnableRequest latestRequest2 = loaded.getRequirements().getLatestRequest();
                    if (latestRequest2 == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    acceptTerms = new ViewState.AcceptTerms(guild, zIsGuildOwner, latestRequest2, false, false, 24, null);
                }
                updateViewState(acceptTerms);
                return;
            }
        }
        if (z2) {
            updateViewState(new ViewState.CreateRequest(((RequirementsState.Loaded) requirementsState).getRequirements(), storeState.isGuildOwner(), false, 4, null));
        }
    }

    private final void refreshRequirements() {
        if (this.requirementsSubject.n0() instanceof RequirementsState.Loading) {
            return;
        }
        this.requirementsSubject.onNext(RequirementsState.Loading.INSTANCE);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.getCreatorMonetizationEligibilityRequirements(this.guildId), false, 1, null), this, null, 2, null), ServerSettingsCreatorMonetizationOnboardingViewModel.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
    }

    private final /* synthetic */ <T extends ViewState> void updateWithViewState(Function1<? super T, ? extends T> transform) {
        ViewState viewStateAccess$requireViewState = access$requireViewState(this);
        Intrinsics3.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (viewStateAccess$requireViewState instanceof ViewState) {
            access$updateViewState(this, transform.invoke(viewStateAccess$requireViewState));
        }
    }

    public final void createRequestToEnableMonetization() {
        ViewState viewStateAccess$requireViewState = access$requireViewState(this);
        if (viewStateAccess$requireViewState instanceof ViewState.CreateRequest) {
            Observable observableDispatchErrorsToUI = dispatchErrorsToUI(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.createCreatorMonetizationEnableRequest(this.guildId), false, 1, null), this, null, 2, null));
            Intrinsics3.checkNotNullExpressionValue(observableDispatchErrorsToUI, "restApi.createCreatorMon…    .dispatchErrorsToUI()");
            ObservableExtensionsKt.appSubscribe$default(observableDispatchErrorsToUI, ServerSettingsCreatorMonetizationOnboardingViewModel.class, (Context) null, (Function1) null, new ServerSettingsCreatorMonetizationOnboardingViewModel3(this), (Function0) null, (Function0) null, new ServerSettingsCreatorMonetizationOnboardingViewModel4(this), 54, (Object) null);
            access$updateViewState(this, ViewState.CreateRequest.copy$default((ViewState.CreateRequest) viewStateAccess$requireViewState, null, false, true, 3, null));
        }
    }

    public final Observable<Event> listenForEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void setHasAcceptedTerms(boolean hasAccepted) {
        ViewState viewStateAccess$requireViewState = access$requireViewState(this);
        if (viewStateAccess$requireViewState instanceof ViewState.AcceptTerms) {
            access$updateViewState(this, ViewState.AcceptTerms.copy$default((ViewState.AcceptTerms) viewStateAccess$requireViewState, null, false, null, hasAccepted, false, 23, null));
        }
    }

    public final void submitTermsAcceptance() {
        ViewState viewStateAccess$requireViewState = access$requireViewState(this);
        if (viewStateAccess$requireViewState instanceof ViewState.AcceptTerms) {
            ViewState.AcceptTerms acceptTerms = (ViewState.AcceptTerms) viewStateAccess$requireViewState;
            Observable observableDispatchErrorsToUI = dispatchErrorsToUI(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.acceptCreatorMonetizationTerms(this.guildId, acceptTerms.getLatestRequest().getId()), false, 1, null), this, null, 2, null));
            Intrinsics3.checkNotNullExpressionValue(observableDispatchErrorsToUI, "restApi.acceptCreatorMon…    .dispatchErrorsToUI()");
            ObservableExtensionsKt.appSubscribe$default(observableDispatchErrorsToUI, ServerSettingsCreatorMonetizationOnboardingViewModel.class, (Context) null, (Function1) null, new ServerSettingsCreatorMonetizationOnboardingViewModel5(acceptTerms, this), (Function0) null, (Function0) null, ServerSettingsCreatorMonetizationOnboardingViewModel6.INSTANCE, 54, (Object) null);
            access$updateViewState(this, ViewState.AcceptTerms.copy$default(acceptTerms, null, false, null, false, true, 15, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsCreatorMonetizationOnboardingViewModel(long j, RestAPI restAPI, BehaviorSubject<RequirementsState> behaviorSubject, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(restAPI, "restApi");
        Intrinsics3.checkNotNullParameter(behaviorSubject, "requirementsSubject");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.restApi = restAPI;
        this.requirementsSubject = behaviorSubject;
        this.eventSubject = PublishSubject.k0();
        Observable observableJ = Observable.j(ObservableExtensionsKt.computationLatest(observable).r(), behaviorSubject, AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…reState to requirements }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableJ, this, null, 2, null), ServerSettingsCreatorMonetizationOnboardingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        refreshRequirements();
    }
}
