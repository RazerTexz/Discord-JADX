package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.EmailVerificationCode;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHubAuthenticationBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.stores.utilities.Success;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CodeVerificationView;
import d0.g;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* compiled from: WidgetHubAuthentication.kt */
/* loaded from: classes2.dex */
public final class WidgetHubAuthentication extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetHubAuthentication.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubAuthenticationBinding;", 0)};

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetHubAuthentication.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$configureUi$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Success<? extends EmailVerificationCode>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Success<? extends EmailVerificationCode> success) {
            invoke2((Success<EmailVerificationCode>) success);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Success<EmailVerificationCode> success) {
            m.checkNotNullParameter(success, "response");
            WidgetHubAuthentication widgetHubAuthentication = WidgetHubAuthentication.this;
            widgetHubAuthentication.hideKeyboard(widgetHubAuthentication.getView());
            EmailVerificationCode emailVerificationCodeInvoke = success.invoke();
            if (!emailVerificationCodeInvoke.getJoined()) {
                b.a.d.m.i(WidgetHubAuthentication.this, R.string.error_generic_title, 0, 4);
                return;
            }
            FragmentActivity activity = WidgetHubAuthentication.this.getActivity();
            if (activity != null) {
                activity.setResult(-1, d.g2(new AuthenticationResult(emailVerificationCodeInvoke.getGuild().getId())));
                activity.finish();
            }
            StoreStream.INSTANCE.getNux().updateNux(WidgetHubAuthentication$configureUi$1$1$2.INSTANCE);
        }
    }

    /* compiled from: WidgetHubAuthentication.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$configureUi$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Success<? extends EmailVerification>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Success<? extends EmailVerification> success) {
            invoke2((Success<EmailVerification>) success);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Success<EmailVerification> success) {
            m.checkNotNullParameter(success, "it");
            b.a.d.m.i(WidgetHubAuthentication.this, R.string.member_verification_email_verification_email_sent, 0, 4);
        }
    }

    /* compiled from: WidgetHubAuthentication.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            WidgetHubAuthentication.access$getViewModel$p(WidgetHubAuthentication.this).verifyCode(str);
        }
    }

    /* compiled from: WidgetHubAuthentication.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<RenderContext, Unit> {

        /* compiled from: WidgetHubAuthentication.kt */
        /* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBound$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                m.checkNotNullParameter(view, "it");
                WidgetHubAuthentication.access$getViewModel$p(WidgetHubAuthentication.this).resendEmail();
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("onClick", new AnonymousClass1());
        }
    }

    /* compiled from: WidgetHubAuthentication.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<HubAuthenticationState, Unit> {
        public AnonymousClass1(WidgetHubAuthentication widgetHubAuthentication) {
            super(1, widgetHubAuthentication, WidgetHubAuthentication.class, "configureUi", "configureUi(Lcom/discord/widgets/hubs/HubAuthenticationState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HubAuthenticationState hubAuthenticationState) {
            invoke2(hubAuthenticationState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(HubAuthenticationState hubAuthenticationState) {
            m.checkNotNullParameter(hubAuthenticationState, "p1");
            WidgetHubAuthentication.access$configureUi((WidgetHubAuthentication) this.receiver, hubAuthenticationState);
        }
    }

    public WidgetHubAuthentication() {
        super(R.layout.widget_hub_authentication);
        this.args = g.lazy(new WidgetHubAuthentication$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubAuthentication$binding$2.INSTANCE, null, 2, null);
        WidgetHubAuthentication$viewModel$2 widgetHubAuthentication$viewModel$2 = new WidgetHubAuthentication$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetHubAuthenticationViewModel.class), new WidgetHubAuthentication$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetHubAuthentication$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUi(WidgetHubAuthentication widgetHubAuthentication, HubAuthenticationState hubAuthenticationState) {
        widgetHubAuthentication.configureUi(hubAuthenticationState);
    }

    public static final /* synthetic */ WidgetHubAuthenticationViewModel access$getViewModel$p(WidgetHubAuthentication widgetHubAuthentication) {
        return widgetHubAuthentication.getViewModel();
    }

    private final void configureUi(HubAuthenticationState state) {
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            RestCallStateKt.handleResponse$default(state.getAuthenticationAsync(), context, null, null, new AnonymousClass1(), 6, null);
            RestCallStateKt.handleResponse$default(state.getResendEmailAsync(), context, null, null, new AnonymousClass2(), 6, null);
        }
    }

    private final WidgetHubAuthenticationBinding getBinding() {
        return (WidgetHubAuthenticationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetHubAuthenticationViewModel getViewModel() {
        return (WidgetHubAuthenticationViewModel) this.viewModel.getValue();
    }

    public final HubAuthenticationArgs getArgs() {
        return (HubAuthenticationArgs) this.args.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().c.setOnCodeEntered(new AnonymousClass1());
        LinkifiedTextView linkifiedTextView = getBinding().f2469b;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.description");
        linkifiedTextView.setText(b.e(this, R.string.hub_pin_description, new Object[]{getArgs().getEmail()}, new AnonymousClass2()));
        CodeVerificationView codeVerificationView = getBinding().c;
        m.checkNotNullExpressionValue(codeVerificationView, "binding.verification");
        showKeyboard(codeVerificationView);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetHubAuthentication.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
