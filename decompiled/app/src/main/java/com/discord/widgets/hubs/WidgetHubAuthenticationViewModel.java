package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import b.a.d.d0;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionHubEmailVerify;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionHubEmailVerifySend;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.EmailVerificationCode;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubAuthenticationlViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetHubAuthenticationViewModel extends d0<HubAuthenticationState> {
    private final String email;
    private final Long guildId;
    private final boolean multiDomainEnabled;
    private final RestAPI restAPI;

    /* compiled from: WidgetHubAuthenticationlViewModel.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthenticationViewModel$resendEmail$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<EmailVerification, TrackNetworkMetadataReceiver> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(EmailVerification emailVerification) {
            return invoke2(emailVerification);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadataReceiver invoke2(EmailVerification emailVerification) {
            return new TrackNetworkActionHubEmailVerifySend(emailVerification != null ? Boolean.valueOf(emailVerification.getHasMatchingGuild()) : null);
        }
    }

    /* compiled from: WidgetHubAuthenticationlViewModel.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthenticationViewModel$resendEmail$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<RestCallState<? extends EmailVerification>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends EmailVerification> restCallState) {
            invoke2((RestCallState<EmailVerification>) restCallState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<EmailVerification> restCallState) {
            m.checkNotNullParameter(restCallState, "it");
            WidgetHubAuthenticationViewModel widgetHubAuthenticationViewModel = WidgetHubAuthenticationViewModel.this;
            WidgetHubAuthenticationViewModel.access$updateViewState(widgetHubAuthenticationViewModel, HubAuthenticationState.copy$default(WidgetHubAuthenticationViewModel.access$requireViewState(widgetHubAuthenticationViewModel), null, restCallState, null, 5, null));
        }
    }

    /* compiled from: WidgetHubAuthenticationlViewModel.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthenticationViewModel$verifyCode$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<EmailVerificationCode, TrackNetworkMetadataReceiver> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(EmailVerificationCode emailVerificationCode) {
            return invoke2(emailVerificationCode);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadataReceiver invoke2(EmailVerificationCode emailVerificationCode) {
            return new TrackNetworkActionHubEmailVerify();
        }
    }

    /* compiled from: WidgetHubAuthenticationlViewModel.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthenticationViewModel$verifyCode$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<RestCallState<? extends EmailVerificationCode>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends EmailVerificationCode> restCallState) {
            invoke2((RestCallState<EmailVerificationCode>) restCallState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<EmailVerificationCode> restCallState) {
            m.checkNotNullParameter(restCallState, "response");
            WidgetHubAuthenticationViewModel widgetHubAuthenticationViewModel = WidgetHubAuthenticationViewModel.this;
            WidgetHubAuthenticationViewModel.access$updateViewState(widgetHubAuthenticationViewModel, HubAuthenticationState.copy$default(WidgetHubAuthenticationViewModel.access$requireViewState(widgetHubAuthenticationViewModel), null, null, restCallState, 3, null));
        }
    }

    public /* synthetic */ WidgetHubAuthenticationViewModel(String str, Long l, RestAPI restAPI, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, l, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 8) != 0 ? GrowthTeamFeatures.INSTANCE.isMultiDomainEnabled() : z2);
    }

    public static final /* synthetic */ HubAuthenticationState access$requireViewState(WidgetHubAuthenticationViewModel widgetHubAuthenticationViewModel) {
        return widgetHubAuthenticationViewModel.requireViewState();
    }

    public static final /* synthetic */ void access$updateViewState(WidgetHubAuthenticationViewModel widgetHubAuthenticationViewModel, HubAuthenticationState hubAuthenticationState) {
        widgetHubAuthenticationViewModel.updateViewState(hubAuthenticationState);
    }

    public final void resendEmail() {
        RestCallStateKt.executeRequest(RestCallStateKt.logNetworkAction(this.restAPI.verifyEmail(new RestAPIParams.VerifyEmail(this.email, this.guildId, this.multiDomainEnabled, false, 8, null)), AnonymousClass1.INSTANCE), new AnonymousClass2());
    }

    public final void verifyCode(String code) {
        m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        RestCallStateKt.executeRequest(RestCallStateKt.logNetworkAction(this.restAPI.verifyEmailCode(new RestAPIParams.VerifyEmailCode(this.email, code, this.guildId)), AnonymousClass1.INSTANCE), new AnonymousClass2());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAuthenticationViewModel(String str, Long l, RestAPI restAPI, boolean z2) {
        super(new HubAuthenticationState(null, null, null, 7, null));
        m.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        m.checkNotNullParameter(restAPI, "restAPI");
        this.email = str;
        this.guildId = l;
        this.restAPI = restAPI;
        this.multiDomainEnabled = z2;
    }
}
