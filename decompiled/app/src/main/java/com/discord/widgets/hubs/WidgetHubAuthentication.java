package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.EmailVerification2;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHubAuthenticationBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState5;
import com.discord.stores.utilities.RestCallState6;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CodeVerificationView;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetHubAuthentication.kt */
/* loaded from: classes2.dex */
public final class WidgetHubAuthentication extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetHubAuthentication.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubAuthenticationBinding;", 0)};

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetHubAuthentication.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$configureUi$1 */
    public static final class C90001 extends Lambda implements Function1<RestCallState6<? extends EmailVerification2>, Unit> {
        public C90001() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends EmailVerification2> restCallState6) {
            invoke2((RestCallState6<EmailVerification2>) restCallState6);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<EmailVerification2> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "response");
            WidgetHubAuthentication widgetHubAuthentication = WidgetHubAuthentication.this;
            widgetHubAuthentication.hideKeyboard(widgetHubAuthentication.getView());
            EmailVerification2 emailVerification2Invoke = restCallState6.invoke();
            if (!emailVerification2Invoke.getJoined()) {
                AppToast.m171i(WidgetHubAuthentication.this, C5419R.string.error_generic_title, 0, 4);
                return;
            }
            FragmentActivity activity = WidgetHubAuthentication.this.getActivity();
            if (activity != null) {
                activity.setResult(-1, AnimatableValueParser.m522g2(new WidgetHubAuthenticationlViewModel(emailVerification2Invoke.getGuild().getId())));
                activity.finish();
            }
            StoreStream.INSTANCE.getNux().updateNux(WidgetHubAuthentication3.INSTANCE);
        }
    }

    /* compiled from: WidgetHubAuthentication.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$configureUi$2 */
    public static final class C90012 extends Lambda implements Function1<RestCallState6<? extends EmailVerification>, Unit> {
        public C90012() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends EmailVerification> restCallState6) {
            invoke2((RestCallState6<EmailVerification>) restCallState6);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<EmailVerification> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
            AppToast.m171i(WidgetHubAuthentication.this, C5419R.string.member_verification_email_verification_email_sent, 0, 4);
        }
    }

    /* compiled from: WidgetHubAuthentication.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBound$1 */
    public static final class C90021 extends Lambda implements Function1<String, Unit> {
        public C90021() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            WidgetHubAuthentication.access$getViewModel$p(WidgetHubAuthentication.this).verifyCode(str);
        }
    }

    /* compiled from: WidgetHubAuthentication.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBound$2 */
    public static final class C90032 extends Lambda implements Function1<RenderContext, Unit> {

        /* compiled from: WidgetHubAuthentication.kt */
        /* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBound$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "it");
                WidgetHubAuthentication.access$getViewModel$p(WidgetHubAuthentication.this).resendEmail();
            }
        }

        public C90032() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8423b("onClick", new AnonymousClass1());
        }
    }

    /* compiled from: WidgetHubAuthentication.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C90041 extends FunctionReferenceImpl implements Function1<WidgetHubAuthenticationlViewModel3, Unit> {
        public C90041(WidgetHubAuthentication widgetHubAuthentication) {
            super(1, widgetHubAuthentication, WidgetHubAuthentication.class, "configureUi", "configureUi(Lcom/discord/widgets/hubs/HubAuthenticationState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubAuthenticationlViewModel3 widgetHubAuthenticationlViewModel3) {
            invoke2(widgetHubAuthenticationlViewModel3);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubAuthenticationlViewModel3 widgetHubAuthenticationlViewModel3) {
            Intrinsics3.checkNotNullParameter(widgetHubAuthenticationlViewModel3, "p1");
            WidgetHubAuthentication.access$configureUi((WidgetHubAuthentication) this.receiver, widgetHubAuthenticationlViewModel3);
        }
    }

    public WidgetHubAuthentication() {
        super(C5419R.layout.widget_hub_authentication);
        this.args = LazyJVM.lazy(new WidgetHubAuthentication$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubAuthentication2.INSTANCE, null, 2, null);
        WidgetHubAuthentication4 widgetHubAuthentication4 = new WidgetHubAuthentication4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHubAuthenticationlViewModel4.class), new WidgetHubAuthentication$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetHubAuthentication4));
    }

    public static final /* synthetic */ void access$configureUi(WidgetHubAuthentication widgetHubAuthentication, WidgetHubAuthenticationlViewModel3 widgetHubAuthenticationlViewModel3) {
        widgetHubAuthentication.configureUi(widgetHubAuthenticationlViewModel3);
    }

    public static final /* synthetic */ WidgetHubAuthenticationlViewModel4 access$getViewModel$p(WidgetHubAuthentication widgetHubAuthentication) {
        return widgetHubAuthentication.getViewModel();
    }

    private final void configureUi(WidgetHubAuthenticationlViewModel3 state) {
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            RestCallState5.handleResponse$default(state.getAuthenticationAsync(), context, null, null, new C90001(), 6, null);
            RestCallState5.handleResponse$default(state.getResendEmailAsync(), context, null, null, new C90012(), 6, null);
        }
    }

    private final WidgetHubAuthenticationBinding getBinding() {
        return (WidgetHubAuthenticationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetHubAuthenticationlViewModel4 getViewModel() {
        return (WidgetHubAuthenticationlViewModel4) this.viewModel.getValue();
    }

    public final WidgetHubAuthenticationlViewModel2 getArgs() {
        return (WidgetHubAuthenticationlViewModel2) this.args.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f17153c.setOnCodeEntered(new C90021());
        LinkifiedTextView linkifiedTextView = getBinding().f17152b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.description");
        linkifiedTextView.setText(FormatUtils.m213e(this, C5419R.string.hub_pin_description, new Object[]{getArgs().getEmail()}, new C90032()));
        CodeVerificationView codeVerificationView = getBinding().f17153c;
        Intrinsics3.checkNotNullExpressionValue(codeVerificationView, "binding.verification");
        showKeyboard(codeVerificationView);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetHubAuthentication.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C90041(this), 62, (Object) null);
    }
}
