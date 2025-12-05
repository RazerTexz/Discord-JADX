package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.hubs.WaitlistSignup;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHubWaitlistBinding;
import com.discord.stores.utilities.RestCallState4;
import com.discord.stores.utilities.RestCallState5;
import com.discord.stores.utilities.RestCallState6;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.textfield.TextInputEditText;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetHubWaitlist.kt */
/* loaded from: classes2.dex */
public final class WidgetHubWaitlist extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetHubWaitlist.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubWaitlistBinding;", 0)};

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetHubWaitlist.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubWaitlist$configureUI$1 */
    public static final class C90441 extends Lambda implements Function1<RestCallState6<? extends WaitlistSignup>, Unit> {
        public C90441() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends WaitlistSignup> restCallState6) {
            invoke2((RestCallState6<WaitlistSignup>) restCallState6);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<WaitlistSignup> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
            FragmentActivity activity = WidgetHubWaitlist.this.getActivity();
            if (activity != null) {
                activity.setResult(-1, AnimatableValueParser.m522g2(new WidgetHubWaitlist2(restCallState6.invoke().getSchool())));
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetHubWaitlist.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubWaitlist$onViewBoundOrOnResume$1 */
    public static final class C90451 extends Lambda implements Function1<WidgetHubWaitlistViewModel3, Unit> {
        public C90451() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubWaitlistViewModel3 widgetHubWaitlistViewModel3) {
            invoke2(widgetHubWaitlistViewModel3);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubWaitlistViewModel3 widgetHubWaitlistViewModel3) {
            Intrinsics3.checkNotNullParameter(widgetHubWaitlistViewModel3, "it");
            WidgetHubWaitlist.access$configureUI(WidgetHubWaitlist.this, widgetHubWaitlistViewModel3);
        }
    }

    /* compiled from: WidgetHubWaitlist.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubWaitlist$onViewBoundOrOnResume$2 */
    public static final class ViewOnClickListenerC90462 implements View.OnClickListener {
        public ViewOnClickListenerC90462() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubWaitlist.access$maybeSubmitSchoolName(WidgetHubWaitlist.this);
        }
    }

    public WidgetHubWaitlist() {
        super(C5419R.layout.widget_hub_waitlist);
        this.args = LazyJVM.lazy(new WidgetHubWaitlist$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubWaitlist3.INSTANCE, null, 2, null);
        WidgetHubWaitlist5 widgetHubWaitlist5 = new WidgetHubWaitlist5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHubWaitlistViewModel.class), new WidgetHubWaitlist$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetHubWaitlist5));
        this.validationManager = LazyJVM.lazy(new WidgetHubWaitlist4(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetHubWaitlist widgetHubWaitlist, WidgetHubWaitlistViewModel3 widgetHubWaitlistViewModel3) {
        widgetHubWaitlist.configureUI(widgetHubWaitlistViewModel3);
    }

    public static final /* synthetic */ void access$maybeSubmitSchoolName(WidgetHubWaitlist widgetHubWaitlist) {
        widgetHubWaitlist.maybeSubmitSchoolName();
    }

    private final void configureUI(WidgetHubWaitlistViewModel3 state) {
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            getBinding().f17189b.setIsLoading(state.getWaitlistAsync() instanceof RestCallState4);
            RestCallState5.handleResponse$default(state.getWaitlistAsync(), context, null, null, new C90441(), 6, null);
        }
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void maybeSubmitSchoolName() {
        if (getValidationManager().validate(true)) {
            WidgetHubWaitlistViewModel viewModel = getViewModel();
            TextInputEditText textInputEditText = getBinding().f17190c;
            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.hubWaitlistEditText");
            viewModel.joinWaitlist(String.valueOf(textInputEditText.getText()));
        }
        hideKeyboard(getView());
    }

    public final WidgetHubWaitlistViewModel2 getArgs() {
        return (WidgetHubWaitlistViewModel2) this.args.getValue();
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
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null)), WidgetHubWaitlist.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C90451(), 62, (Object) null);
        getBinding().f17189b.setOnClickListener(new ViewOnClickListenerC90462());
        TextInputEditText textInputEditText = getBinding().f17190c;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.hubWaitlistEditText");
        showKeyboard(textInputEditText);
    }
}
