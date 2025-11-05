package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.hubs.WaitlistSignup;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHubWaitlistBinding;
import com.discord.stores.utilities.Loading;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.stores.utilities.Success;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputEditText;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* compiled from: WidgetHubWaitlist.kt */
/* loaded from: classes2.dex */
public final class WidgetHubWaitlist extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetHubWaitlist.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubWaitlistBinding;", 0)};

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetHubWaitlist.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubWaitlist$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Success<? extends WaitlistSignup>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Success<? extends WaitlistSignup> success) {
            invoke2((Success<WaitlistSignup>) success);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Success<WaitlistSignup> success) {
            m.checkNotNullParameter(success, "it");
            FragmentActivity activity = WidgetHubWaitlist.this.getActivity();
            if (activity != null) {
                activity.setResult(-1, d.g2(new HubWaitlistResult(success.invoke().getSchool())));
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetHubWaitlist.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubWaitlist$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<HubWaitlistState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HubWaitlistState hubWaitlistState) {
            invoke2(hubWaitlistState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(HubWaitlistState hubWaitlistState) {
            m.checkNotNullParameter(hubWaitlistState, "it");
            WidgetHubWaitlist.access$configureUI(WidgetHubWaitlist.this, hubWaitlistState);
        }
    }

    /* compiled from: WidgetHubWaitlist.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubWaitlist$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubWaitlist.access$maybeSubmitSchoolName(WidgetHubWaitlist.this);
        }
    }

    public WidgetHubWaitlist() {
        super(R.layout.widget_hub_waitlist);
        this.args = g.lazy(new WidgetHubWaitlist$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubWaitlist$binding$2.INSTANCE, null, 2, null);
        WidgetHubWaitlist$viewModel$2 widgetHubWaitlist$viewModel$2 = new WidgetHubWaitlist$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetHubWaitlistViewModel.class), new WidgetHubWaitlist$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetHubWaitlist$viewModel$2));
        this.validationManager = g.lazy(new WidgetHubWaitlist$validationManager$2(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetHubWaitlist widgetHubWaitlist, HubWaitlistState hubWaitlistState) {
        widgetHubWaitlist.configureUI(hubWaitlistState);
    }

    public static final /* synthetic */ void access$maybeSubmitSchoolName(WidgetHubWaitlist widgetHubWaitlist) {
        widgetHubWaitlist.maybeSubmitSchoolName();
    }

    private final void configureUI(HubWaitlistState state) {
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            getBinding().f2478b.setIsLoading(state.getWaitlistAsync() instanceof Loading);
            RestCallStateKt.handleResponse$default(state.getWaitlistAsync(), context, null, null, new AnonymousClass1(), 6, null);
        }
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void maybeSubmitSchoolName() {
        if (getValidationManager().validate(true)) {
            WidgetHubWaitlistViewModel viewModel = getViewModel();
            TextInputEditText textInputEditText = getBinding().c;
            m.checkNotNullExpressionValue(textInputEditText, "binding.hubWaitlistEditText");
            viewModel.joinWaitlist(String.valueOf(textInputEditText.getText()));
        }
        hideKeyboard(getView());
    }

    public final HubWaitlistArgs getArgs() {
        return (HubWaitlistArgs) this.args.getValue();
    }

    public final WidgetHubWaitlistBinding getBinding() {
        return (WidgetHubWaitlistBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final WidgetHubWaitlistViewModel getViewModel() {
        return (WidgetHubWaitlistViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null)), WidgetHubWaitlist.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        getBinding().f2478b.setOnClickListener(new AnonymousClass2());
        TextInputEditText textInputEditText = getBinding().c;
        m.checkNotNullExpressionValue(textInputEditText, "binding.hubWaitlistEditText");
        showKeyboard(textInputEditText);
    }
}
