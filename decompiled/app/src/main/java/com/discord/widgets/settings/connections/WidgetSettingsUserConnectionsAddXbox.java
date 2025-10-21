package com.discord.widgets.settings.connections;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetConnectionsAddXboxBinding;
import com.discord.models.domain.ModelConnectionState;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.error.Error;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsAddXbox extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsUserConnectionsAddXbox.class, "binding", "getBinding()Lcom/discord/databinding/WidgetConnectionsAddXboxBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsUserConnectionsAddXbox.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
    /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreUserConnections userConnections = StoreStream.INSTANCE.getUserConnections();
            String platformId = Platform.XBOX.getPlatformId();
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "v.context");
            userConnections.authorizeConnection(platformId, context, Traits.Location.Page.USER_SETTINGS);
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
    /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {

        /* compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
        /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox$onViewBound$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements Action1<Error> {
            public AnonymousClass1() {
            }

            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Error error) {
                call2(error);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(Error error) {
                WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox = WidgetSettingsUserConnectionsAddXbox.this;
                Intrinsics3.checkNotNullExpressionValue(error, "error");
                WidgetSettingsUserConnectionsAddXbox.access$trackXboxLinkFailed(widgetSettingsUserConnectionsAddXbox, error);
                if (error.getType() == Error.Type.DISCORD_REQUEST_ERROR) {
                    error.setShowErrorToasts(false);
                    WidgetSettingsUserConnectionsAddXbox.access$showPinError(WidgetSettingsUserConnectionsAddXbox.this);
                }
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "verificationCode");
            if (str.length() == 6) {
                WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox = WidgetSettingsUserConnectionsAddXbox.this;
                Platform platform = Platform.XBOX;
                DimmerView dimmerView = WidgetSettingsUserConnectionsAddXbox.access$getBinding$p(widgetSettingsUserConnectionsAddXbox).d;
                WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox2 = WidgetSettingsUserConnectionsAddXbox.this;
                widgetSettingsUserConnectionsAddXbox.submitPinCode(str, platform, dimmerView, widgetSettingsUserConnectionsAddXbox2, widgetSettingsUserConnectionsAddXbox2.getActivity(), new AnonymousClass1());
            }
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
    /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox$submitPinCode$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<ModelConnectionState, Observable<? extends Void>> {
        public final /* synthetic */ Platform $platform;

        public AnonymousClass1(Platform platform) {
            this.$platform = platform;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Void> call(ModelConnectionState modelConnectionState) {
            return call2(modelConnectionState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Void> call2(ModelConnectionState modelConnectionState) {
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(modelConnectionState, "state");
            analyticsTracker.accountLinkStep("PIN code entry", "PIN success", modelConnectionState.getState(), this.$platform.getPlatformId());
            RestAPI api = RestAPI.INSTANCE.getApi();
            String platformId = this.$platform.getPlatformId();
            String code = modelConnectionState.getCode();
            String state = modelConnectionState.getState();
            Boolean bool = Boolean.TRUE;
            return api.submitConnectionState(platformId, new RestAPIParams.ConnectionState(code, state, bool, bool));
        }
    }

    /* compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
    /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox$submitPinCode$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ Activity $activity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Activity activity) {
            super(1);
            this.$activity = activity;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            Activity activity = this.$activity;
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public WidgetSettingsUserConnectionsAddXbox() {
        super(R.layout.widget_connections_add_xbox);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsUserConnectionsAddXbox2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ WidgetConnectionsAddXboxBinding access$getBinding$p(WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox) {
        return widgetSettingsUserConnectionsAddXbox.getBinding();
    }

    public static final /* synthetic */ void access$showPinError(WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox) {
        widgetSettingsUserConnectionsAddXbox.showPinError();
    }

    public static final /* synthetic */ void access$trackXboxLinkFailed(WidgetSettingsUserConnectionsAddXbox widgetSettingsUserConnectionsAddXbox, Error error) {
        widgetSettingsUserConnectionsAddXbox.trackXboxLinkFailed(error);
    }

    private final WidgetConnectionsAddXboxBinding getBinding() {
        return (WidgetConnectionsAddXboxBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    private final void showPinError() {
        AppToast.g(getContext(), R.string.connection_invalid_pin, 0, null, 12);
        getBinding().f2354b.b();
    }

    private final void trackXboxLinkFailed(Error error) {
        AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
        String bodyText = error.getBodyText();
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        analyticsTracker.accountLinkFailed(bodyText, Integer.valueOf(response.getCode()), "pin", "PIN code entry", Platform.XBOX.getPlatformId());
    }

    private final void trackXboxLinkStep() {
        AnalyticsTracker.accountLinkStep$default(AnalyticsTracker.INSTANCE, "mobile connections", "PIN code entry", null, Platform.XBOX.getPlatformId(), 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.connections);
        trackXboxLinkStep();
        getBinding().c.setOnClickListener(AnonymousClass1.INSTANCE);
        getBinding().f2354b.setOnCodeEntered(new AnonymousClass2());
    }

    public final void submitPinCode(String verificationCode, Platform platform, DimmerView dimmer, AppComponent appComponent, Activity activity, Action1<Error> errorHandler) {
        Intrinsics3.checkNotNullParameter(verificationCode, "verificationCode");
        Intrinsics3.checkNotNullParameter(platform, "platform");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(errorHandler, "errorHandler");
        Observable observableA = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getConnectionState(platform.getPlatformId(), verificationCode), false, 1, null).A(new AnonymousClass1(platform));
        Intrinsics3.checkNotNullExpressionValue(observableA, "RestAPI\n        .api\n   …              )\n        }");
        ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(observableA, appComponent, null, 2, null), dimmer, 0L, 2, null).k(o.a.g(activity, new AnonymousClass2(activity), errorHandler));
    }
}
