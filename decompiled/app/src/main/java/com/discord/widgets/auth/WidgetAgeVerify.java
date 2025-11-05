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
import b.a.a.k;
import b.a.d.f;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetAgeVerifyBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.birthday.BirthdayHelper;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.discord.widgets.auth.WidgetAgeVerifyViewModel;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import java.text.DateFormat;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Func0;

/* compiled from: WidgetAgeVerify.kt */
/* loaded from: classes2.dex */
public final class WidgetAgeVerify extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetAgeVerify.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAgeVerifyBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_NSFW_CHANNEL = "INTENT_EXTRA_NSFW_CHANNEL";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetAgeVerify.kt */
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
            m.checkNotNullParameter(context, "context");
            AnalyticsTracker.openModal$default("Age Gate", "", null, 4, null);
            Bundle bundle = new Bundle();
            bundle.putBoolean(WidgetAgeVerify.INTENT_EXTRA_NSFW_CHANNEL, isNSFWChannel);
            j.d(context, WidgetAgeVerify.class, new Intent().putExtras(bundle));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetAgeVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAgeVerify$configureBirthdayInput$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<View, Unit> {
        public final /* synthetic */ Long $timeOfBirth;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l) {
            super(1);
            this.$timeOfBirth = l;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            m.checkNotNullParameter(view, "it");
            k.Companion companion = k.INSTANCE;
            FragmentManager parentFragmentManager = WidgetAgeVerify.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            CharSequence charSequenceK = b.k(WidgetAgeVerify.this, R.string.age_gate_date_of_birth, new Object[0], null, 4);
            Long l = this.$timeOfBirth;
            companion.a(parentFragmentManager, charSequenceK, l != null ? l.longValue() : BirthdayHelper.INSTANCE.defaultInputAge(), BirthdayHelper.INSTANCE.getMaxDateOfBirth()).onDatePicked = new WidgetAgeVerify$configureBirthdayInput$1$$special$$inlined$apply$lambda$1(this);
        }
    }

    /* compiled from: WidgetAgeVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAgeVerify$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1<R> implements Func0<Boolean> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            AppViewFlipper appViewFlipper = WidgetAgeVerify.access$getBinding$p(WidgetAgeVerify.this).f2224b;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.ageVerifyViewFlipper");
            int displayedChild = appViewFlipper.getDisplayedChild();
            if (displayedChild == 1) {
                WidgetAgeVerify.access$getViewModel$p(WidgetAgeVerify.this).onConfirmBackClicked();
            } else if (displayedChild == 2 || WidgetAgeVerify.access$getViewModel$p(WidgetAgeVerify.this).backToSafety()) {
                WidgetAgeVerify.this.requireAppActivity().j(WidgetAgeVerify.this.requireContext());
            } else {
                WidgetAgeVerify.this.requireActivity().finish();
            }
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetAgeVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAgeVerify$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<WidgetAgeVerifyViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetAgeVerifyViewModel.ViewState viewState) throws Resources.NotFoundException {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetAgeVerifyViewModel.ViewState viewState) throws Resources.NotFoundException {
            m.checkNotNullParameter(viewState, "it");
            WidgetAgeVerify.access$configureUI(WidgetAgeVerify.this, viewState);
        }
    }

    /* compiled from: WidgetAgeVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAgeVerify$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<WidgetAgeVerifyViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetAgeVerifyViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetAgeVerifyViewModel.Event event) {
            m.checkNotNullParameter(event, "it");
            WidgetAgeVerify.access$handleEvent(WidgetAgeVerify.this, event);
        }
    }

    /* compiled from: WidgetAgeVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAgeVerify$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAgeVerify.this.requireAppActivity().refreshEnabled = true;
            WidgetAgeVerify.this.requireActivity().finish();
        }
    }

    /* compiled from: WidgetAgeVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAgeVerify$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ boolean $isNSFWChannel;

        public AnonymousClass2(boolean z2) {
            this.$isNSFWChannel = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAgeVerify.access$getViewModel$p(WidgetAgeVerify.this).submit(this.$isNSFWChannel);
        }
    }

    /* compiled from: WidgetAgeVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAgeVerify$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ boolean $isNSFWChannel;

        public AnonymousClass3(boolean z2) {
            this.$isNSFWChannel = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAgeVerify.access$getViewModel$p(WidgetAgeVerify.this).submit(this.$isNSFWChannel);
        }
    }

    /* compiled from: WidgetAgeVerify.kt */
    /* renamed from: com.discord.widgets.auth.WidgetAgeVerify$onViewBoundOrOnResume$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetAgeVerify.access$getViewModel$p(WidgetAgeVerify.this).onConfirmBackClicked();
        }
    }

    public WidgetAgeVerify() {
        super(R.layout.widget_age_verify);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAgeVerify$binding$2.INSTANCE, null, 2, null);
        WidgetAgeVerify$viewModel$2 widgetAgeVerify$viewModel$2 = WidgetAgeVerify$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetAgeVerifyViewModel.class), new WidgetAgeVerify$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetAgeVerify$viewModel$2));
        this.loggingConfig = new LoggingConfig(false, null, new WidgetAgeVerify$loggingConfig$1(this), 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetAgeVerify widgetAgeVerify, WidgetAgeVerifyViewModel.ViewState viewState) throws Resources.NotFoundException {
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
        m.checkNotNullExpressionValue(calendar, "Calendar.getInstance()");
        calendar.setTimeInMillis(dateOfBirth != null ? dateOfBirth.longValue() : BirthdayHelper.INSTANCE.getMaxDateOfBirth());
        DateFormat dateInstance = DateFormat.getDateInstance(3);
        if (dateOfBirth != null) {
            m.checkNotNullExpressionValue(dateInstance, "formatter");
            dateInstance.setTimeZone(calendar.getTimeZone());
            String str = dateInstance.format(Long.valueOf(calendar.getTimeInMillis()));
            TextInputLayout textInputLayout = getBinding().e.c;
            m.checkNotNullExpressionValue(textInputLayout, "binding.verify.ageVerifyInputWrapper");
            ViewExtensions.setText(textInputLayout, new SpannableStringBuilder(str));
        }
        if (viewState.getErrorStringId() != null) {
            TextInputLayout textInputLayout2 = getBinding().e.c;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.verify.ageVerifyInputWrapper");
            textInputLayout2.setError(b.k(this, viewState.getErrorStringId().intValue(), new Object[0], null, 4));
        }
        TextInputLayout textInputLayout3 = getBinding().e.c;
        m.checkNotNullExpressionValue(textInputLayout3, "binding.verify.ageVerifyInputWrapper");
        ViewExtensions.setOnEditTextClickListener(textInputLayout3, new AnonymousClass1(dateOfBirth));
    }

    private final void configureUI(WidgetAgeVerifyViewModel.ViewState viewState) throws Resources.NotFoundException {
        Long dateOfBirth;
        if (viewState.getShouldClose() && viewState.getDisplayedChild() != 2) {
            requireActivity().finish();
        }
        getBinding().e.d.setIsLoading(viewState.isSubmitting());
        LoadingButton loadingButton = getBinding().e.d;
        m.checkNotNullExpressionValue(loadingButton, "binding.verify.ageVerifyNextButton");
        loadingButton.setEnabled(viewState.getDateOfBirth() != null);
        getBinding().c.c.setIsLoading(viewState.isSubmitting());
        LoadingButton loadingButton2 = getBinding().c.c;
        m.checkNotNullExpressionValue(loadingButton2, "binding.confirm.ageVerifyConfirmButton");
        loadingButton2.setEnabled(viewState.getDateOfBirth() != null);
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        CharSequence quantityString = StringResourceUtilsKt.getQuantityString(resources, requireContext(), R.plurals.age_gate_underage_existing_body_deletion_with_days_days, 30, 30);
        TextView textView = getBinding().d.d;
        m.checkNotNullExpressionValue(textView, "binding.underage.underageWarning");
        b.n(textView, R.string.age_gate_underage_existing_body_deletion_with_days, new Object[]{quantityString}, null, 4);
        LinkifiedTextView linkifiedTextView = getBinding().d.c;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.underage.ageVerifyUnderageDescription");
        Object[] objArr = new Object[2];
        String underageMessage = viewState.getUnderageMessage();
        if (underageMessage == null) {
            underageMessage = "";
        }
        objArr[0] = underageMessage;
        objArr[1] = f.a.a(360040724612L, null);
        b.n(linkifiedTextView, R.string.age_gate_underage_body, objArr, null, 4);
        if (viewState.getDisplayedChild() == 2) {
            requireAppActivity().refreshEnabled = false;
            AppFragment.hideKeyboard$default(this, null, 1, null);
        }
        if (viewState.getDisplayedChild() == 1 && (dateOfBirth = viewState.getDateOfBirth()) != null) {
            int age = BirthdayHelper.INSTANCE.getAge(dateOfBirth.longValue());
            TextView textView2 = getBinding().c.e;
            m.checkNotNullExpressionValue(textView2, "binding.confirm.ageVerifyConfirmTitle");
            b.n(textView2, R.string.age_gate_confirm_header, new Object[]{String.valueOf(age)}, null, 4);
        }
        configureBirthdayInput(viewState);
        configureViewFlipper(viewState.getDisplayedChild());
        AppFragment.setOnBackPressed$default(this, new AnonymousClass1(), 0, 2, null);
    }

    private final void configureViewFlipper(int displayedChild) {
        AppViewFlipper appViewFlipper = getBinding().f2224b;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.ageVerifyViewFlipper");
        if (displayedChild > appViewFlipper.getDisplayedChild()) {
            AppViewFlipper appViewFlipper2 = getBinding().f2224b;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.ageVerifyViewFlipper");
            appViewFlipper2.setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_horizontal_open_in));
            AppViewFlipper appViewFlipper3 = getBinding().f2224b;
            m.checkNotNullExpressionValue(appViewFlipper3, "binding.ageVerifyViewFlipper");
            appViewFlipper3.setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_horizontal_open_out));
        } else {
            AppViewFlipper appViewFlipper4 = getBinding().f2224b;
            m.checkNotNullExpressionValue(appViewFlipper4, "binding.ageVerifyViewFlipper");
            if (displayedChild < appViewFlipper4.getDisplayedChild()) {
                AppViewFlipper appViewFlipper5 = getBinding().f2224b;
                m.checkNotNullExpressionValue(appViewFlipper5, "binding.ageVerifyViewFlipper");
                appViewFlipper5.setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_horizontal_close_in));
                AppViewFlipper appViewFlipper6 = getBinding().f2224b;
                m.checkNotNullExpressionValue(appViewFlipper6, "binding.ageVerifyViewFlipper");
                appViewFlipper6.setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_horizontal_close_out));
            }
        }
        AppViewFlipper appViewFlipper7 = getBinding().f2224b;
        m.checkNotNullExpressionValue(appViewFlipper7, "binding.ageVerifyViewFlipper");
        appViewFlipper7.setDisplayedChild(displayedChild);
    }

    private final WidgetAgeVerifyBinding getBinding() {
        return (WidgetAgeVerifyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetAgeVerifyViewModel getViewModel() {
        return (WidgetAgeVerifyViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetAgeVerifyViewModel.Event event) {
        if (m.areEqual(event, WidgetAgeVerifyViewModel.Event.Verified.INSTANCE)) {
            Context context = getContext();
            b.a.d.m.f(this, context != null ? context.getString(R.string.age_gate_age_verified) : null, 1);
            requireActivity().finish();
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetAgeVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetAgeVerify.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getBinding().d.f131b.setOnClickListener(new AnonymousClass1());
        boolean booleanExtra = getMostRecentIntent().getBooleanExtra(INTENT_EXTRA_NSFW_CHANNEL, false);
        LinkifiedTextView linkifiedTextView = getBinding().e.f117b;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.verify.ageVerifyDescription");
        b.n(linkifiedTextView, booleanExtra ? R.string.age_gate_nsfw_body : R.string.age_gate_body, new Object[]{f.a.a(360040724612L, null)}, null, 4);
        LinkifiedTextView linkifiedTextView2 = getBinding().c.d;
        m.checkNotNullExpressionValue(linkifiedTextView2, "binding.confirm.ageVerifyConfirmDescription");
        LinkifiedTextView linkifiedTextView3 = getBinding().e.f117b;
        m.checkNotNullExpressionValue(linkifiedTextView3, "binding.verify.ageVerifyDescription");
        linkifiedTextView2.setText(linkifiedTextView3.getText());
        getBinding().e.d.setOnClickListener(new AnonymousClass2(booleanExtra));
        getBinding().c.c.setOnClickListener(new AnonymousClass3(booleanExtra));
        getBinding().c.f124b.setOnClickListener(new AnonymousClass4());
    }
}
