package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetAgeVerifyBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.birthday.BirthdayHelper;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.discord.widgets.auth.WidgetAgeVerifyViewModel;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.DatePickerDialog;
import p007b.p008a.p018d.AppHelpDesk;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetAgeVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAgeVerify extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetAgeVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAgeVerifyBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_NSFW_CHANNEL = "INTENT_EXTRA_NSFW_CHANNEL";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetAgeVerify.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            companion.start(context, z2);
        }

        public final void start(Context context, boolean isNSFWChannel) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AnalyticsTracker.openModal$default("Age Gate", "", null, 4, null);
            Bundle bundle = new Bundle();
            bundle.putBoolean(WidgetAgeVerify.INTENT_EXTRA_NSFW_CHANNEL, isNSFWChannel);
            AppScreen2.m156d(context, WidgetAgeVerify.class, new Intent().putExtras(bundle));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAgeVerify$configureBirthdayInput$1 */
    /* JADX INFO: compiled from: WidgetAgeVerify.kt */
    public static final class C71531 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Long $timeOfBirth;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C71531(Long l) {
            super(1);
            this.$timeOfBirth = l;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            DatePickerDialog.Companion companion = DatePickerDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetAgeVerify.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            CharSequence charSequenceM219k = FormatUtils.m219k(WidgetAgeVerify.this, C5419R.string.age_gate_date_of_birth, new Object[0], null, 4);
            Long l = this.$timeOfBirth;
            companion.m139a(parentFragmentManager, charSequenceM219k, l != null ? l.longValue() : BirthdayHelper.INSTANCE.defaultInputAge(), BirthdayHelper.INSTANCE.getMaxDateOfBirth()).onDatePicked = new WidgetAgeVerify3(this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAgeVerify$configureUI$1 */
    /* JADX INFO: compiled from: WidgetAgeVerify.kt */
    public static final class C71551<R> implements Func0<Boolean> {
        public C71551() {
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            AppViewFlipper appViewFlipper = WidgetAgeVerify.access$getBinding$p(WidgetAgeVerify.this).f15644b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.ageVerifyViewFlipper");
            int displayedChild = appViewFlipper.getDisplayedChild();
            if (displayedChild == 1) {
                WidgetAgeVerify.access$getViewModel$p(WidgetAgeVerify.this).onConfirmBackClicked();
            } else if (displayedChild == 2 || WidgetAgeVerify.access$getViewModel$p(WidgetAgeVerify.this).backToSafety()) {
                WidgetAgeVerify.this.requireAppActivity().m8349j(WidgetAgeVerify.this.requireContext());
            } else {
                WidgetAgeVerify.this.requireActivity().finish();
            }
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAgeVerify$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetAgeVerify.kt */
    public static final class C71561 extends Lambda implements Function1<WidgetAgeVerifyViewModel.ViewState, Unit> {
        public C71561() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetAgeVerifyViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetAgeVerifyViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetAgeVerify.access$configureUI(WidgetAgeVerify.this, viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAgeVerify$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetAgeVerify.kt */
    public static final class C71572 extends Lambda implements Function1<WidgetAgeVerifyViewModel.Event, Unit> {
        public C71572() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetAgeVerifyViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetAgeVerifyViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetAgeVerify.access$handleEvent(WidgetAgeVerify.this, event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAgeVerify$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetAgeVerify.kt */
    public static final class ViewOnClickListenerC71581 implements View.OnClickListener {
        public ViewOnClickListenerC71581() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAgeVerify.this.requireAppActivity().refreshEnabled = true;
            WidgetAgeVerify.this.requireActivity().finish();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAgeVerify$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetAgeVerify.kt */
    public static final class ViewOnClickListenerC71592 implements View.OnClickListener {
        public final /* synthetic */ boolean $isNSFWChannel;

        public ViewOnClickListenerC71592(boolean z2) {
            this.$isNSFWChannel = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAgeVerify.access$getViewModel$p(WidgetAgeVerify.this).submit(this.$isNSFWChannel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAgeVerify$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetAgeVerify.kt */
    public static final class ViewOnClickListenerC71603 implements View.OnClickListener {
        public final /* synthetic */ boolean $isNSFWChannel;

        public ViewOnClickListenerC71603(boolean z2) {
            this.$isNSFWChannel = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAgeVerify.access$getViewModel$p(WidgetAgeVerify.this).submit(this.$isNSFWChannel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAgeVerify$onViewBoundOrOnResume$4 */
    /* JADX INFO: compiled from: WidgetAgeVerify.kt */
    public static final class ViewOnClickListenerC71614 implements View.OnClickListener {
        public ViewOnClickListenerC71614() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAgeVerify.access$getViewModel$p(WidgetAgeVerify.this).onConfirmBackClicked();
        }
    }

    public WidgetAgeVerify() {
        super(C5419R.layout.widget_age_verify);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetAgeVerify2.INSTANCE, null, 2, null);
        WidgetAgeVerify5 widgetAgeVerify5 = WidgetAgeVerify5.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetAgeVerifyViewModel.class), new WidgetAgeVerify$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetAgeVerify5));
        this.loggingConfig = new AppLogger2(false, null, new WidgetAgeVerify4(this), 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetAgeVerify widgetAgeVerify, WidgetAgeVerifyViewModel.ViewState viewState) {
        widgetAgeVerify.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetAgeVerifyBinding access$getBinding$p(WidgetAgeVerify widgetAgeVerify) {
        return widgetAgeVerify.getBinding();
    }

    public static final /* synthetic */ WidgetAgeVerifyViewModel access$getViewModel$p(WidgetAgeVerify widgetAgeVerify) {
        return widgetAgeVerify.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetAgeVerify widgetAgeVerify, WidgetAgeVerifyViewModel.Event event) {
        widgetAgeVerify.handleEvent(event);
    }

    private final void configureBirthdayInput(WidgetAgeVerifyViewModel.ViewState viewState) {
        Long dateOfBirth = viewState.getDateOfBirth();
        Calendar calendar = Calendar.getInstance();
        Intrinsics3.checkNotNullExpressionValue(calendar, "Calendar.getInstance()");
        calendar.setTimeInMillis(dateOfBirth != null ? dateOfBirth.longValue() : BirthdayHelper.INSTANCE.getMaxDateOfBirth());
        DateFormat dateInstance = DateFormat.getDateInstance(3);
        if (dateOfBirth != null) {
            Intrinsics3.checkNotNullExpressionValue(dateInstance, "formatter");
            dateInstance.setTimeZone(calendar.getTimeZone());
            String str = dateInstance.format(Long.valueOf(calendar.getTimeInMillis()));
            TextInputLayout textInputLayout = getBinding().f15647e.f859c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.verify.ageVerifyInputWrapper");
            ViewExtensions.setText(textInputLayout, new SpannableStringBuilder(str));
        }
        if (viewState.getErrorStringId() != null) {
            TextInputLayout textInputLayout2 = getBinding().f15647e.f859c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.verify.ageVerifyInputWrapper");
            textInputLayout2.setError(FormatUtils.m219k(this, viewState.getErrorStringId().intValue(), new Object[0], null, 4));
        }
        TextInputLayout textInputLayout3 = getBinding().f15647e.f859c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.verify.ageVerifyInputWrapper");
        ViewExtensions.setOnEditTextClickListener(textInputLayout3, new C71531(dateOfBirth));
    }

    private final void configureUI(WidgetAgeVerifyViewModel.ViewState viewState) {
        Long dateOfBirth;
        if (viewState.getShouldClose() && viewState.getDisplayedChild() != 2) {
            requireActivity().finish();
        }
        getBinding().f15647e.f860d.setIsLoading(viewState.isSubmitting());
        LoadingButton loadingButton = getBinding().f15647e.f860d;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.verify.ageVerifyNextButton");
        loadingButton.setEnabled(viewState.getDateOfBirth() != null);
        getBinding().f15645c.f897c.setIsLoading(viewState.isSubmitting());
        LoadingButton loadingButton2 = getBinding().f15645c.f897c;
        Intrinsics3.checkNotNullExpressionValue(loadingButton2, "binding.confirm.ageVerifyConfirmButton");
        loadingButton2.setEnabled(viewState.getDateOfBirth() != null);
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        CharSequence quantityString = StringResourceUtils.getQuantityString(resources, requireContext(), C5419R.plurals.age_gate_underage_existing_body_deletion_with_days_days, 30, 30);
        TextView textView = getBinding().f15646d.f940d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.underage.underageWarning");
        FormatUtils.m222n(textView, C5419R.string.age_gate_underage_existing_body_deletion_with_days, new Object[]{quantityString}, null, 4);
        LinkifiedTextView linkifiedTextView = getBinding().f15646d.f939c;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.underage.ageVerifyUnderageDescription");
        Object[] objArr = new Object[2];
        String underageMessage = viewState.getUnderageMessage();
        if (underageMessage == null) {
            underageMessage = "";
        }
        objArr[0] = underageMessage;
        objArr[1] = AppHelpDesk.f507a.m149a(360040724612L, null);
        FormatUtils.m222n(linkifiedTextView, C5419R.string.age_gate_underage_body, objArr, null, 4);
        if (viewState.getDisplayedChild() == 2) {
            requireAppActivity().refreshEnabled = false;
            AppFragment.hideKeyboard$default(this, null, 1, null);
        }
        if (viewState.getDisplayedChild() == 1 && (dateOfBirth = viewState.getDateOfBirth()) != null) {
            int age = BirthdayHelper.INSTANCE.getAge(dateOfBirth.longValue());
            TextView textView2 = getBinding().f15645c.f899e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.confirm.ageVerifyConfirmTitle");
            FormatUtils.m222n(textView2, C5419R.string.age_gate_confirm_header, new Object[]{String.valueOf(age)}, null, 4);
        }
        configureBirthdayInput(viewState);
        configureViewFlipper(viewState.getDisplayedChild());
        AppFragment.setOnBackPressed$default(this, new C71551(), 0, 2, null);
    }

    private final void configureViewFlipper(int displayedChild) {
        AppViewFlipper appViewFlipper = getBinding().f15644b;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.ageVerifyViewFlipper");
        if (displayedChild > appViewFlipper.getDisplayedChild()) {
            AppViewFlipper appViewFlipper2 = getBinding().f15644b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.ageVerifyViewFlipper");
            appViewFlipper2.setInAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.activity_slide_horizontal_open_in));
            AppViewFlipper appViewFlipper3 = getBinding().f15644b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.ageVerifyViewFlipper");
            appViewFlipper3.setOutAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.activity_slide_horizontal_open_out));
        } else {
            AppViewFlipper appViewFlipper4 = getBinding().f15644b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper4, "binding.ageVerifyViewFlipper");
            if (displayedChild < appViewFlipper4.getDisplayedChild()) {
                AppViewFlipper appViewFlipper5 = getBinding().f15644b;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper5, "binding.ageVerifyViewFlipper");
                appViewFlipper5.setInAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.activity_slide_horizontal_close_in));
                AppViewFlipper appViewFlipper6 = getBinding().f15644b;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper6, "binding.ageVerifyViewFlipper");
                appViewFlipper6.setOutAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.activity_slide_horizontal_close_out));
            }
        }
        AppViewFlipper appViewFlipper7 = getBinding().f15644b;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper7, "binding.ageVerifyViewFlipper");
        appViewFlipper7.setDisplayedChild(displayedChild);
    }

    private final WidgetAgeVerifyBinding getBinding() {
        return (WidgetAgeVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetAgeVerifyViewModel getViewModel() {
        return (WidgetAgeVerifyViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetAgeVerifyViewModel.Event event) {
        if (Intrinsics3.areEqual(event, WidgetAgeVerifyViewModel.Event.Verified.INSTANCE)) {
            Context context = getContext();
            AppToast.m168f(this, context != null ? context.getString(C5419R.string.age_gate_age_verified) : null, 1);
            requireActivity().finish();
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetAgeVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C71561(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetAgeVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C71572(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getBinding().f15646d.f938b.setOnClickListener(new ViewOnClickListenerC71581());
        boolean booleanExtra = getMostRecentIntent().getBooleanExtra(INTENT_EXTRA_NSFW_CHANNEL, false);
        LinkifiedTextView linkifiedTextView = getBinding().f15647e.f858b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.verify.ageVerifyDescription");
        FormatUtils.m222n(linkifiedTextView, booleanExtra ? C5419R.string.age_gate_nsfw_body : C5419R.string.age_gate_body, new Object[]{AppHelpDesk.f507a.m149a(360040724612L, null)}, null, 4);
        LinkifiedTextView linkifiedTextView2 = getBinding().f15645c.f898d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.confirm.ageVerifyConfirmDescription");
        LinkifiedTextView linkifiedTextView3 = getBinding().f15647e.f858b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView3, "binding.verify.ageVerifyDescription");
        linkifiedTextView2.setText(linkifiedTextView3.getText());
        getBinding().f15647e.f860d.setOnClickListener(new ViewOnClickListenerC71592(booleanExtra));
        getBinding().f15645c.f897c.setOnClickListener(new ViewOnClickListenerC71603(booleanExtra));
        getBinding().f15645c.f896b.setOnClickListener(new ViewOnClickListenerC71614());
    }
}
