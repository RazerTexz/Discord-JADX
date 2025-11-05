package com.discord.widgets.user.phone;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserVerifyPhone;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetUserPhoneVerifyBinding;
import com.discord.models.domain.ModelPhoneVerificationToken;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.sms.SmsListener;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.WidgetUserPasswordVerify;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: WidgetUserPhoneVerify.kt */
/* loaded from: classes.dex */
public final class WidgetUserPhoneVerify extends WidgetUserAccountVerifyBase {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUserPhoneVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserPhoneVerifyBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_PHONE_NUMBER = "INTENT_EXTRA_PHONE_NUMBER";
    private static final String INTENT_EXTRA_SOURCE_TYPE = "INTENT_EXTRA_SOURCE_TYPE";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;
    private final ActivityResultLauncher<Intent> passwordVerifyLauncher;

    /* compiled from: WidgetUserPhoneVerify.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, WidgetUserAccountVerifyBase.Mode mode, String phoneNumber, String source) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(launcher, "launcher");
            m.checkNotNullParameter(mode, "mode");
            m.checkNotNullParameter(source, "source");
            Intent launchIntent = WidgetUserAccountVerifyBase.INSTANCE.getLaunchIntent(mode, true, false);
            if (mode == WidgetUserAccountVerifyBase.Mode.NO_HISTORY_FROM_USER_SETTINGS) {
                launchIntent.addFlags(BasicMeasure.EXACTLY);
            }
            launchIntent.putExtra(WidgetUserPhoneVerify.INTENT_EXTRA_PHONE_NUMBER, phoneNumber);
            launchIntent.putExtra(WidgetUserPhoneVerify.INTENT_EXTRA_SOURCE_TYPE, source);
            j.g.f(context, launcher, WidgetUserPhoneVerify.class, launchIntent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function0<Unit> callback) {
            m.checkNotNullParameter(fragment, "fragment");
            m.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetUserPhoneVerify$Companion$registerForResult$1(callback));
            m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserPhoneVerify.kt */
    /* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$autofillCode$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Long, Unit> {
        public final /* synthetic */ String $verificationCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(1);
            this.$verificationCode = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetUserPhoneVerify.access$handleCodeEntered(WidgetUserPhoneVerify.this, this.$verificationCode);
        }
    }

    /* compiled from: WidgetUserPhoneVerify.kt */
    /* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$handleCodeEntered$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ModelPhoneVerificationToken, TrackNetworkMetadataReceiver> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            return invoke2(modelPhoneVerificationToken);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadataReceiver invoke2(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            return new TrackNetworkActionUserVerifyPhone();
        }
    }

    /* compiled from: WidgetUserPhoneVerify.kt */
    /* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$handleCodeEntered$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<ModelPhoneVerificationToken> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            call2(modelPhoneVerificationToken);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(ModelPhoneVerificationToken modelPhoneVerificationToken) {
            WidgetUserPhoneVerify.access$handleCodeReceived(WidgetUserPhoneVerify.this, modelPhoneVerificationToken.getToken());
        }
    }

    /* compiled from: WidgetUserPhoneVerify.kt */
    /* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$handleCodeEntered$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Error> {
        public AnonymousClass3() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            WidgetUserPhoneVerify.access$getBinding$p(WidgetUserPhoneVerify.this).d.b();
        }
    }

    /* compiled from: WidgetUserPhoneVerify.kt */
    /* renamed from: com.discord.widgets.user.phone.WidgetUserPhoneVerify$onViewBound$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<String, Unit> {
        public AnonymousClass2(WidgetUserPhoneVerify widgetUserPhoneVerify) {
            super(1, widgetUserPhoneVerify, WidgetUserPhoneVerify.class, "autofillCode", "autofillCode(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, "p1");
            WidgetUserPhoneVerify.access$autofillCode((WidgetUserPhoneVerify) this.receiver, str);
        }
    }

    public WidgetUserPhoneVerify() {
        super(R.layout.widget_user_phone_verify);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserPhoneVerify$binding$2.INSTANCE, null, 2, null);
        this.passwordVerifyLauncher = WidgetUserPasswordVerify.INSTANCE.registerForResult(this, new WidgetUserPhoneVerify$passwordVerifyLauncher$1(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetUserPhoneVerify$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$autofillCode(WidgetUserPhoneVerify widgetUserPhoneVerify, String str) {
        widgetUserPhoneVerify.autofillCode(str);
    }

    public static final /* synthetic */ WidgetUserPhoneVerifyBinding access$getBinding$p(WidgetUserPhoneVerify widgetUserPhoneVerify) {
        return widgetUserPhoneVerify.getBinding();
    }

    public static final /* synthetic */ WidgetUserAccountVerifyBase.Mode access$getMode$p(WidgetUserPhoneVerify widgetUserPhoneVerify) {
        return widgetUserPhoneVerify.getMode();
    }

    public static final /* synthetic */ void access$handleCodeEntered(WidgetUserPhoneVerify widgetUserPhoneVerify, String str) {
        widgetUserPhoneVerify.handleCodeEntered(str);
    }

    public static final /* synthetic */ void access$handleCodeReceived(WidgetUserPhoneVerify widgetUserPhoneVerify, String str) {
        widgetUserPhoneVerify.handleCodeReceived(str);
    }

    public static final /* synthetic */ void access$setMode$p(WidgetUserPhoneVerify widgetUserPhoneVerify, WidgetUserAccountVerifyBase.Mode mode) {
        widgetUserPhoneVerify.setMode(mode);
    }

    private final void autofillCode(String verificationCode) {
        if (getView() != null) {
            WidgetUserPhoneVerifyBinding binding = getBinding();
            binding.d.setOnCodeEntered(WidgetUserPhoneVerify$autofillCode$1$1.INSTANCE);
            binding.d.setCode(verificationCode);
            binding.d.setOnCodeEntered(new WidgetUserPhoneVerify$autofillCode$1$2(this));
            Observable<Long> observableD0 = Observable.d0(500L, TimeUnit.MILLISECONDS);
            m.checkNotNullExpressionValue(observableD0, "Observable\n        .time…L, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), WidgetUserPhoneVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(verificationCode), 62, (Object) null);
        }
    }

    private final WidgetUserPhoneVerifyBinding getBinding() {
        return (WidgetUserPhoneVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void handleCodeEntered(String verificationCode) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_PHONE_NUMBER);
        if (stringExtra != null) {
            m.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…A_PHONE_NUMBER) ?: return");
            ObservableExtensionsKt.ui$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(RestAPI.INSTANCE.getApi().phoneVerificationsVerify(new RestAPIParams.VerificationCode(stringExtra, verificationCode)), AnonymousClass1.INSTANCE), false, 1, null), getBinding().c, 0L, 2, null), this, null, 2, null).k(b.a.d.o.h(new AnonymousClass2(), getContext(), new AnonymousClass3()));
        }
    }

    private final void handleCodeReceived(String phoneToken) {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_SOURCE_TYPE);
        if (stringExtra != null) {
            m.checkNotNullExpressionValue(stringExtra, "mostRecentIntent.getStri…RA_SOURCE_TYPE) ?: return");
            WidgetUserPasswordVerify.INSTANCE.launchUpdatePhoneNumber(requireContext(), this.passwordVerifyLauncher, phoneToken, stringExtra);
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.widgets.user.account.WidgetUserAccountVerifyBase, com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetUserPhoneVerifyBinding binding = getBinding();
        binding.d.setOnCodeEntered(new WidgetUserPhoneVerify$onViewBound$1$1(this));
        ImageView imageView = binding.f2688b;
        m.checkNotNullExpressionValue(imageView, "closeButton");
        imageView.setVisibility(isForced() ? 8 : 0);
        binding.f2688b.setOnClickListener(new WidgetUserPhoneVerify$onViewBound$$inlined$with$lambda$1(this));
        if (GrowthTeamFeatures.INSTANCE.isAndroidSmsAutofillEnabled()) {
            SmsListener.INSTANCE.startSmsListener(new AnonymousClass2(this));
        }
    }
}
