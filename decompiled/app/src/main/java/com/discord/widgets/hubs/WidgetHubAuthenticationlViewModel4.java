package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionHubEmailVerify;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionHubEmailVerifySend;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.EmailVerification2;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rest.RestAPI;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetHubAuthenticationlViewModel.kt */
/* renamed from: com.discord.widgets.hubs.WidgetHubAuthenticationViewModel, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubAuthenticationlViewModel4 extends AppViewModel<WidgetHubAuthenticationlViewModel3> {
    private final String email;
    private final Long guildId;
    private final boolean multiDomainEnabled;
    private final RestAPI restAPI;

    /* compiled from: WidgetHubAuthenticationlViewModel.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthenticationViewModel$resendEmail$1 */
    public static final class C90051 extends Lambda implements Function1<EmailVerification, TrackNetworkMetadata2> {
        public static final C90051 INSTANCE = new C90051();

        public C90051() {
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

    /* compiled from: WidgetHubAuthenticationlViewModel.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthenticationViewModel$resendEmail$2 */
    public static final class C90062 extends Lambda implements Function1<RestCallState<? extends EmailVerification>, Unit> {
        public C90062() {
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
            WidgetHubAuthenticationlViewModel4 widgetHubAuthenticationlViewModel4 = WidgetHubAuthenticationlViewModel4.this;
            WidgetHubAuthenticationlViewModel4.access$updateViewState(widgetHubAuthenticationlViewModel4, WidgetHubAuthenticationlViewModel3.copy$default(WidgetHubAuthenticationlViewModel4.access$requireViewState(widgetHubAuthenticationlViewModel4), null, restCallState, null, 5, null));
        }
    }

    /* compiled from: WidgetHubAuthenticationlViewModel.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthenticationViewModel$verifyCode$1 */
    public static final class C90071 extends Lambda implements Function1<EmailVerification2, TrackNetworkMetadata2> {
        public static final C90071 INSTANCE = new C90071();

        public C90071() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(EmailVerification2 emailVerification2) {
            return invoke2(emailVerification2);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadata2 invoke2(EmailVerification2 emailVerification2) {
            return new TrackNetworkActionHubEmailVerify();
        }
    }

    /* compiled from: WidgetHubAuthenticationlViewModel.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthenticationViewModel$verifyCode$2 */
    public static final class C90082 extends Lambda implements Function1<RestCallState<? extends EmailVerification2>, Unit> {
        public C90082() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends EmailVerification2> restCallState) {
            invoke2((RestCallState<EmailVerification2>) restCallState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<EmailVerification2> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "response");
            WidgetHubAuthenticationlViewModel4 widgetHubAuthenticationlViewModel4 = WidgetHubAuthenticationlViewModel4.this;
            WidgetHubAuthenticationlViewModel4.access$updateViewState(widgetHubAuthenticationlViewModel4, WidgetHubAuthenticationlViewModel3.copy$default(WidgetHubAuthenticationlViewModel4.access$requireViewState(widgetHubAuthenticationlViewModel4), null, null, restCallState, 3, null));
        }
    }

    public /* synthetic */ WidgetHubAuthenticationlViewModel4(String str, Long l, RestAPI restAPI, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, l, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 8) != 0 ? GrowthTeamFeatures.INSTANCE.isMultiDomainEnabled() : z2);
    }

    public static final /* synthetic */ WidgetHubAuthenticationlViewModel3 access$requireViewState(WidgetHubAuthenticationlViewModel4 widgetHubAuthenticationlViewModel4) {
        return widgetHubAuthenticationlViewModel4.requireViewState();
    }

    public static final /* synthetic */ void access$updateViewState(WidgetHubAuthenticationlViewModel4 widgetHubAuthenticationlViewModel4, WidgetHubAuthenticationlViewModel3 widgetHubAuthenticationlViewModel3) {
        widgetHubAuthenticationlViewModel4.updateViewState(widgetHubAuthenticationlViewModel3);
    }

    public final void resendEmail() {
        RestCallState5.executeRequest(RestCallState5.logNetworkAction(this.restAPI.verifyEmail(new RestAPIParams.VerifyEmail(this.email, this.guildId, this.multiDomainEnabled, false, 8, null)), C90051.INSTANCE), new C90062());
    }

    public final void verifyCode(String code) {
        Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        RestCallState5.executeRequest(RestCallState5.logNetworkAction(this.restAPI.verifyEmailCode(new RestAPIParams.VerifyEmailCode(this.email, code, this.guildId)), C90071.INSTANCE), new C90082());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAuthenticationlViewModel4(String str, Long l, RestAPI restAPI, boolean z2) {
        super(new WidgetHubAuthenticationlViewModel3(null, null, null, 7, null));
        Intrinsics3.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.email = str;
        this.guildId = l;
        this.restAPI = restAPI;
        this.multiDomainEnabled = z2;
    }
}
