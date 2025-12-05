package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionHubEmailVerifySend;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.hubs.EmailVerification;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetHubEmailViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetHubEmailViewModel extends AppViewModel<WidgetHubEmailViewModel4> {
    private final boolean multiDomainEnabled;
    private final RestAPI restAPI;

    /* compiled from: WidgetHubEmailViewModel.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailViewModel$submitEmail$1 */
    public static final class C90421 extends Lambda implements Function1<EmailVerification, TrackNetworkMetadata2> {
        public static final C90421 INSTANCE = new C90421();

        public C90421() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(EmailVerification emailVerification) {
            return invoke2(emailVerification);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(EmailVerification emailVerification) {
            return new TrackNetworkActionHubEmailVerifySend(emailVerification != null ? Boolean.valueOf(emailVerification.getHasMatchingGuild()) : null);
        }
    }

    /* compiled from: WidgetHubEmailViewModel.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailViewModel$submitEmail$2 */
    public static final class C90432 extends Lambda implements Function1<RestCallState<? extends EmailVerification>, Unit> {
        public C90432() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends EmailVerification> restCallState) {
            invoke2((RestCallState<EmailVerification>) restCallState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<EmailVerification> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "it");
            WidgetHubEmailViewModel widgetHubEmailViewModel = WidgetHubEmailViewModel.this;
            WidgetHubEmailViewModel.access$updateViewState(widgetHubEmailViewModel, WidgetHubEmailViewModel4.copy$default(WidgetHubEmailViewModel.access$requireViewState(widgetHubEmailViewModel), null, null, null, restCallState, 7, null));
        }
    }

    public WidgetHubEmailViewModel() {
        this(null, false, 3, null);
    }

    public /* synthetic */ WidgetHubEmailViewModel(RestAPI restAPI, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 2) != 0 ? GrowthTeamFeatures.INSTANCE.isMultiDomainEnabled() : z2);
    }

    public static final /* synthetic */ WidgetHubEmailViewModel4 access$requireViewState(WidgetHubEmailViewModel widgetHubEmailViewModel) {
        return widgetHubEmailViewModel.requireViewState();
    }

    public static final /* synthetic */ void access$updateViewState(WidgetHubEmailViewModel widgetHubEmailViewModel, WidgetHubEmailViewModel4 widgetHubEmailViewModel4) {
        widgetHubEmailViewModel.updateViewState(widgetHubEmailViewModel4);
    }

    public final boolean getMultiDomainEnabled() {
        return this.multiDomainEnabled;
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final void reset() {
        WidgetHubEmailViewModel4 viewState = getViewState();
        Intrinsics3.checkNotNull(viewState);
        updateViewState(WidgetHubEmailViewModel4.copy$default(viewState, null, null, null, RestCallState2.INSTANCE, 5, null));
    }

    public final void setHubWaitlistResult(WidgetHubWaitlist2 waitlistResult) {
        Intrinsics3.checkNotNullParameter(waitlistResult, "waitlistResult");
        WidgetHubEmailViewModel4 viewState = getViewState();
        Intrinsics3.checkNotNull(viewState);
        updateViewState(WidgetHubEmailViewModel4.copy$default(viewState, null, null, waitlistResult, null, 11, null));
    }

    public final void submitEmail(String email) {
        Intrinsics3.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        RestCallState5.executeRequest(RestCallState5.logNetworkAction(ObservableExtensionsKt.ui$default(this.restAPI.verifyEmail(new RestAPIParams.VerifyEmail(email, null, this.multiDomainEnabled, false, 10, null)), this, null, 2, null), C90421.INSTANCE), new C90432());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEmailViewModel(RestAPI restAPI, boolean z2) {
        super(new WidgetHubEmailViewModel4(null, null, null, null, 15, null));
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.restAPI = restAPI;
        this.multiDomainEnabled = z2;
    }
}
