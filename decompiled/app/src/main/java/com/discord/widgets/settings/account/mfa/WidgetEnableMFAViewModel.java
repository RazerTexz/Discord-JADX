package com.discord.widgets.settings.account.mfa;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.auth.mfa.EnableMfaResponse;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreMFA;
import com.discord.stores.StoreStream;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetEnableMFAViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetEnableMFAViewModel extends AppViewModel<ViewState> {
    private String encodedTotpSecret;
    private String password;
    private CompositeSubscription subs;
    private String totpSecret;

    /* compiled from: WidgetEnableMFAViewModel.kt */
    public static final /* data */ class ViewState {
        private final boolean isLoading;
        private final Integer screenIndex;

        public ViewState() {
            this(false, null, 3, null);
        }

        public ViewState(boolean z2, Integer num) {
            this.isLoading = z2;
            this.screenIndex = num;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z2, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = viewState.isLoading;
            }
            if ((i & 2) != 0) {
                num = viewState.screenIndex;
            }
            return viewState.copy(z2, num);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getScreenIndex() {
            return this.screenIndex;
        }

        public final ViewState copy(boolean isLoading, Integer screenIndex) {
            return new ViewState(isLoading, screenIndex);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && Intrinsics3.areEqual(this.screenIndex, viewState.screenIndex);
        }

        public final Integer getScreenIndex() {
            return this.screenIndex;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z2 = this.isLoading;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            Integer num = this.screenIndex;
            return i + (num != null ? num.hashCode() : 0);
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(isLoading=");
            sbU.append(this.isLoading);
            sbU.append(", screenIndex=");
            return outline.F(sbU, this.screenIndex, ")");
        }

        public /* synthetic */ ViewState(boolean z2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? null : num);
        }
    }

    /* compiled from: WidgetEnableMFAViewModel.kt */
    /* renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFAViewModel$enableMFA$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<EnableMfaResponse, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EnableMfaResponse enableMfaResponse) {
            invoke2(enableMfaResponse);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EnableMfaResponse enableMfaResponse) {
            WidgetEnableMFAViewModel.access$handleMFASuccess(WidgetEnableMFAViewModel.this, enableMfaResponse.getToken());
        }
    }

    /* compiled from: WidgetEnableMFAViewModel.kt */
    /* renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFAViewModel$enableMFA$2, reason: invalid class name */
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
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetEnableMFAViewModel.access$handleMFAFailure(WidgetEnableMFAViewModel.this);
        }
    }

    /* compiled from: WidgetEnableMFAViewModel.kt */
    /* renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFAViewModel$enableMFA$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetEnableMFAViewModel.access$getSubs$p(WidgetEnableMFAViewModel.this).a(subscription);
        }
    }

    public WidgetEnableMFAViewModel() {
        super(new ViewState(false, 0));
        this.subs = new CompositeSubscription();
    }

    public static final /* synthetic */ CompositeSubscription access$getSubs$p(WidgetEnableMFAViewModel widgetEnableMFAViewModel) {
        return widgetEnableMFAViewModel.subs;
    }

    public static final /* synthetic */ void access$handleMFAFailure(WidgetEnableMFAViewModel widgetEnableMFAViewModel) {
        widgetEnableMFAViewModel.handleMFAFailure();
    }

    public static final /* synthetic */ void access$handleMFASuccess(WidgetEnableMFAViewModel widgetEnableMFAViewModel, String str) {
        widgetEnableMFAViewModel.handleMFASuccess(str);
    }

    public static final /* synthetic */ void access$setSubs$p(WidgetEnableMFAViewModel widgetEnableMFAViewModel, CompositeSubscription compositeSubscription) {
        widgetEnableMFAViewModel.subs = compositeSubscription;
    }

    @MainThread
    private final void handleMFAFailure() {
        updateViewState(new ViewState(false, 2));
    }

    @MainThread
    private final void handleMFASuccess(String token) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getAuthentication().setAuthed(token);
        updateViewState(new ViewState(false, 3));
        companion.getMFA().updatePendingMFAState(StoreMFA.MFAActivationState.PENDING_ENABLED);
    }

    @MainThread
    public final void enableMFA(Context context, String mfaCode) {
        String str;
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(mfaCode, "mfaCode");
        updateViewState(new ViewState(true, null));
        RestAPI api = RestAPI.INSTANCE.getApi();
        String str2 = this.encodedTotpSecret;
        if (str2 == null || (str = this.password) == null) {
            return;
        }
        Observable<EnableMfaResponse> observableQ = api.enableMFA(new RestAPIParams.EnableMFA(mfaCode, str2, str)).q(2000L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableQ, "RestAPI\n        .api\n   …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableQ, false, 1, null), this, null, 2, null), WidgetEnableMFAViewModel.class, context, new AnonymousClass3(), new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 48, (Object) null);
    }

    @MainThread
    public final String getPassword() {
        return this.password;
    }

    @MainThread
    public final String getTotpSecret() {
        return this.totpSecret;
    }

    @Override // b.a.d.AppViewModel, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        this.subs.b();
    }

    @MainThread
    public final void setPassword(String password) {
        Intrinsics3.checkNotNullParameter(password, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        this.password = password;
    }

    @MainThread
    public final void setTotpSecret(String secret) {
        Intrinsics3.checkNotNullParameter(secret, "secret");
        this.totpSecret = secret;
        AuthUtils authUtils = AuthUtils.INSTANCE;
        if (secret != null) {
            this.encodedTotpSecret = authUtils.encodeTotpSecret(secret);
        }
    }

    @MainThread
    public final void updateScreenIndex(int currentPage) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, false, Integer.valueOf(currentPage), 1, null));
        }
    }
}
