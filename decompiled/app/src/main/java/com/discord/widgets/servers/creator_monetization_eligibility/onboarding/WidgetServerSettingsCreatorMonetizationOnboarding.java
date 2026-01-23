package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.C5473x4f85106c;
import com.discord.databinding.C5474x305cfbd8;
import com.discord.databinding.WidgetServerSettingsCreatorMonetizationOnboardingBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.DurationUtils2;
import com.discord.utilities.resources.DurationUtils3;
import com.discord.utilities.resources.DurationUtils4;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.textprocessing.FontColorSpan;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.viewstub.LazyViewStubDelegate;
import com.discord.views.LoadingButton;
import com.discord.widgets.servers.creator_monetization_eligibility.EligibilityChecklistView;
import com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel;
import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerSettingsCreatorMonetizationOnboarding.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCreatorMonetizationOnboardingBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int VIEW_FLIPPER_ACCEPT_TERMS_STATE = 3;
    private static final int VIEW_FLIPPER_CREATE_REQUEST_STATE = 2;
    private static final int VIEW_FLIPPER_ERROR_STATE = 1;
    private static final int VIEW_FLIPPER_LOADING_STATE = 0;

    /* JADX INFO: renamed from: acceptTermsBinding$delegate, reason: from kotlin metadata */
    private final Lazy acceptTermsBinding;

    /* JADX INFO: renamed from: acceptTermsOnlyGuildOwnerNotice$delegate, reason: from kotlin metadata */
    private final Lazy acceptTermsOnlyGuildOwnerNotice;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: createRequestBinding$delegate, reason: from kotlin metadata */
    private final Lazy createRequestBinding;

    /* JADX INFO: renamed from: createRequestOnlyGuildOwnerNotice$delegate, reason: from kotlin metadata */
    private final Lazy createRequestOnlyGuildOwnerNotice;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class Companion {
        private Companion() {
        }

        private final CharSequence formatRejectionCooldown(Context context, CreatorMonetizationEligibilityRequirements.Rejection rejection, Clock clock) {
            long time = rejection.getCanReapplyAt().getTime() - clock.currentTimeMillis();
            if (time <= 0) {
                return null;
            }
            return DurationUtils4.INSTANCE.formatDurationInMillis(context, time);
        }

        public static /* synthetic */ CharSequence formatRejectionCooldown$default(Companion companion, Context context, CreatorMonetizationEligibilityRequirements.Rejection rejection, Clock clock, int i, Object obj) {
            if ((i & 2) != 0) {
                clock = ClockFactory.get();
            }
            return companion.formatRejectionCooldown(context, rejection, clock);
        }

        public final void launch(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            AppScreen2.m156d(context, WidgetServerSettingsCreatorMonetizationOnboarding.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$4 */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class C94304 extends Lambda implements Function1<RenderContext, Unit> {
        public C94304() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new FontColorSpan(ColorCompat2.getColor(WidgetServerSettingsCreatorMonetizationOnboarding.this, C5419R.color.status_red_500)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.f27425a;
            }
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8422a("doesNotHook", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class C94341 extends Lambda implements Function1<ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState, Unit> {
        public C94341() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
            WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding = WidgetServerSettingsCreatorMonetizationOnboarding.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            WidgetServerSettingsCreatorMonetizationOnboarding.access$configureUI(widgetServerSettingsCreatorMonetizationOnboarding, viewState);
            WidgetServerSettingsCreatorMonetizationOnboarding.this.getAppLogger().m8372b();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class C94352 extends Lambda implements Function1<ServerSettingsCreatorMonetizationOnboardingViewModel.Event, Unit> {
        public C94352() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsCreatorMonetizationOnboardingViewModel.Event event) throws Throwable {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsCreatorMonetizationOnboardingViewModel.Event event) throws Throwable {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetServerSettingsCreatorMonetizationOnboarding.access$handleEvent(WidgetServerSettingsCreatorMonetizationOnboarding.this, event);
        }
    }

    public WidgetServerSettingsCreatorMonetizationOnboarding() {
        super(C5419R.layout.widget_server_settings_creator_monetization_onboarding);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsCreatorMonetizationOnboarding$binding$2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsCreatorMonetizationOnboarding$guildId$2(this));
        WidgetServerSettingsCreatorMonetizationOnboarding$viewModel$2 widgetServerSettingsCreatorMonetizationOnboarding$viewModel$2 = new WidgetServerSettingsCreatorMonetizationOnboarding$viewModel$2(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ServerSettingsCreatorMonetizationOnboardingViewModel.class), new C9424x8b88e847(appViewModelDelegates3), new AppViewModelDelegates5(widgetServerSettingsCreatorMonetizationOnboarding$viewModel$2));
        this.createRequestBinding = LazyJVM.lazy(new C9431x4350d5de(this));
        this.acceptTermsBinding = LazyJVM.lazy(new C9422xff1a9372(this));
        LazyViewStubDelegate.Companion companion = LazyViewStubDelegate.INSTANCE;
        this.createRequestOnlyGuildOwnerNotice = companion.lazyViewStub(new C9432x5ac632a7(this));
        this.acceptTermsOnlyGuildOwnerNotice = companion.lazyViewStub(new C9423x1fb02593(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding, ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
        widgetServerSettingsCreatorMonetizationOnboarding.configureUI(viewState);
    }

    public static final /* synthetic */ CharSequence access$formatDurationFromDays(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding, int i) {
        return widgetServerSettingsCreatorMonetizationOnboarding.formatDurationFromDays(i);
    }

    public static final /* synthetic */ C5473x4f85106c access$getAcceptTermsBinding$p(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        return widgetServerSettingsCreatorMonetizationOnboarding.getAcceptTermsBinding();
    }

    public static final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboardingBinding access$getBinding$p(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        return widgetServerSettingsCreatorMonetizationOnboarding.getBinding();
    }

    public static final /* synthetic */ C5474x305cfbd8 access$getCreateRequestBinding$p(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        return widgetServerSettingsCreatorMonetizationOnboarding.getCreateRequestBinding();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        return widgetServerSettingsCreatorMonetizationOnboarding.getGuildId();
    }

    public static final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel access$getViewModel$p(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        return widgetServerSettingsCreatorMonetizationOnboarding.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding, ServerSettingsCreatorMonetizationOnboardingViewModel.Event event) throws Throwable {
        widgetServerSettingsCreatorMonetizationOnboarding.handleEvent(event);
    }

    private final void configureAcceptTermsState(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms viewState) {
        getAcceptTermsOnlyGuildOwnerNotice().setVisible(!viewState.isGuildOwner());
        CheckBox checkBox = getAcceptTermsBinding().f17594c;
        checkBox.setChecked(viewState.getHasAcceptedTerms());
        checkBox.setEnabled(!viewState.isSubmitting() && viewState.isGuildOwner());
        checkBox.setOnCheckedChangeListener(new C9425xd1ebfe5d(this, viewState));
        LoadingButton loadingButton = getAcceptTermsBinding().f17593b;
        loadingButton.setEnabled(viewState.getHasAcceptedTerms() && viewState.isGuildOwner());
        loadingButton.setIsLoading(viewState.isSubmitting());
        loadingButton.setOnClickListener(new ViewOnClickListenerC9426xd1ebfe5e(this, viewState));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureCreateRequestState(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest viewState) {
        CharSequence rejectionCooldown$default;
        LoadingButton loadingButton = getCreateRequestBinding().f17604c;
        boolean z2 = true;
        loadingButton.setEnabled(viewState.getRequirements().getCanApply() && viewState.isGuildOwner());
        loadingButton.setVisibility(viewState.isApplicationPending() ^ true ? 0 : 8);
        loadingButton.setIsLoading(viewState.isSubmitting());
        loadingButton.setOnClickListener(new ViewOnClickListenerC9427x9fa2e849(this, viewState));
        getCreateRequestOnlyGuildOwnerNotice().setVisible(!viewState.isGuildOwner());
        MaterialButton materialButton = getCreateRequestBinding().f17603b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "createRequestBinding.applicationPendingButton");
        materialButton.setVisibility(viewState.isApplicationPending() ? 0 : 8);
        TextView textView = getCreateRequestBinding().f17609h;
        CreatorMonetizationEligibilityRequirements.Rejection rejectionM7775j = viewState.getRequirements().getRejection();
        if (rejectionM7775j != null) {
            Companion companion = INSTANCE;
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            rejectionCooldown$default = Companion.formatRejectionCooldown$default(companion, context, rejectionM7775j, null, 2, null);
        } else {
            rejectionCooldown$default = null;
        }
        if (rejectionCooldown$default == null) {
            z2 = false;
        } else {
            CreatorMonetizationEnableRequest creatorMonetizationEnableRequestM7771f = viewState.getRequirements().getLatestRequest();
            if ((creatorMonetizationEnableRequestM7771f != null ? creatorMonetizationEnableRequestM7771f.getState() : null) != CreatorMonetizationEnableRequest.State.REJECTED) {
            }
        }
        textView.setVisibility(z2 ? 0 : 8);
        if (rejectionCooldown$default != null) {
            FormatUtils.m221m(textView, C5419R.string.guild_role_subscription_settings_enable_request_rejected, new Object[0], new C9428x2d7e4c81(rejectionCooldown$default));
        }
        LinkifiedTextView linkifiedTextView = getCreateRequestBinding().f17610i;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "createRequestBinding.requirementsDescription");
        FormatUtils.m221m(linkifiedTextView, C5419R.string.guild_role_subscription_settings_enable_requirements_description, new Object[0], C94293.INSTANCE);
        ImageView imageView = getCreateRequestBinding().f17606e;
        Intrinsics3.checkNotNullExpressionValue(imageView, "createRequestBinding.eli…yChecklistHeaderIndicator");
        imageView.setActivated(viewState.getRequirements().getSufficient());
        if (viewState.getRequirements().getSufficient()) {
            TextView textView2 = getCreateRequestBinding().f17607f;
            Intrinsics3.checkNotNullExpressionValue(textView2, "createRequestBinding.eligibilityChecklistTitle");
            FormatUtils.m222n(textView2, C5419R.string.guild_role_subscription_settings_eligible_message, new Object[0], null, 4);
        } else {
            TextView textView3 = getCreateRequestBinding().f17607f;
            Intrinsics3.checkNotNullExpressionValue(textView3, "createRequestBinding.eligibilityChecklistTitle");
            FormatUtils.m221m(textView3, C5419R.string.guild_role_subscription_settings_not_eligible_message, new Object[0], new C94304());
        }
        getCreateRequestBinding().f17605d.bind(toChecklistRequirements(viewState.getRequirements()));
    }

    private final void configureUI(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
        Unit unit;
        if (viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().f17601e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.viewFlipper");
            appViewFlipper.setDisplayedChild(0);
            unit = Unit.f27425a;
        } else if (viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.Error) {
            AppViewFlipper appViewFlipper2 = getBinding().f17601e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.viewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            TextView textView = getBinding().f17598b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.errorNoticeText");
            textView.setText(((ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.Error) viewState).getError().getDisplayString(requireContext()));
            unit = Unit.f27425a;
        } else if (viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) {
            AppViewFlipper appViewFlipper3 = getBinding().f17601e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.viewFlipper");
            appViewFlipper3.setDisplayedChild(2);
            configureCreateRequestState((ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) viewState);
            unit = Unit.f27425a;
        } else {
            if (!(viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms)) {
                throw new NoWhenBranchMatchedException();
            }
            ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms acceptTerms = (ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms) viewState;
            if (acceptTerms.getGuild().hasFeature(GuildFeature.CREATOR_MONETIZABLE)) {
                WidgetServerSettingsEmptyGuildRoleSubscriptions.INSTANCE.launch(requireContext(), getGuildId());
                requireActivity().finish();
                unit = Unit.f27425a;
            } else {
                AppViewFlipper appViewFlipper4 = getBinding().f17601e;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper4, "binding.viewFlipper");
                appViewFlipper4.setDisplayedChild(3);
                configureAcceptTermsState(acceptTerms);
                unit = Unit.f27425a;
            }
        }
        KotlinExtensions.getExhaustive(unit);
    }

    private final CharSequence formatDurationFromDays(int minimumAgeInDays) {
        return (minimumAgeInDays <= 0 || minimumAgeInDays % 7 != 0) ? DurationUtils3.formatDuration(requireContext(), DurationUtils2.DAYS, minimumAgeInDays) : DurationUtils3.formatDuration(requireContext(), DurationUtils2.WEEKS, minimumAgeInDays / 7);
    }

    private final C5473x4f85106c getAcceptTermsBinding() {
        return (C5473x4f85106c) this.acceptTermsBinding.getValue();
    }

    private final LazyViewStubDelegate getAcceptTermsOnlyGuildOwnerNotice() {
        return (LazyViewStubDelegate) this.acceptTermsOnlyGuildOwnerNotice.getValue();
    }

    private final WidgetServerSettingsCreatorMonetizationOnboardingBinding getBinding() {
        return (WidgetServerSettingsCreatorMonetizationOnboardingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final C5474x305cfbd8 getCreateRequestBinding() {
        return (C5474x305cfbd8) this.createRequestBinding.getValue();
    }

    private final LazyViewStubDelegate getCreateRequestOnlyGuildOwnerNotice() {
        return (LazyViewStubDelegate) this.createRequestOnlyGuildOwnerNotice.getValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final ServerSettingsCreatorMonetizationOnboardingViewModel getViewModel() {
        return (ServerSettingsCreatorMonetizationOnboardingViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(ServerSettingsCreatorMonetizationOnboardingViewModel.Event event) throws Throwable {
        if (event instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.Event.ShowErrorToast) {
            Error.handle(((ServerSettingsCreatorMonetizationOnboardingViewModel.Event.ShowErrorToast) event).getError(), WidgetServerSettingsCreatorMonetizationOnboarding.class.getSimpleName(), null, getActivity());
        }
    }

    public static final void launch(Context context, long j) {
        INSTANCE.launch(context, j);
    }

    private final List<EligibilityChecklistView.Requirement> toChecklistRequirements(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
        EligibilityChecklistView.Requirement[] requirementArr = new EligibilityChecklistView.Requirement[6];
        String string = creatorMonetizationEligibilityRequirements.getSize() ? getString(C5419R.string.f14692x95c3e2c2) : getString(C5419R.string.f14693xc54a792e);
        Intrinsics3.checkNotNullExpressionValue(string, "when {\n                s…eligible)\n              }");
        requirementArr[0] = new EligibilityChecklistView.Requirement(string, FormatUtils.m213e(this, C5419R.string.f14691x26fcaf31, new Object[0], new C94361(creatorMonetizationEligibilityRequirements)), creatorMonetizationEligibilityRequirements.getSize());
        String string2 = creatorMonetizationEligibilityRequirements.getAge() ? getString(C5419R.string.f14686xe742c01c) : getString(C5419R.string.f14687x57071988);
        Intrinsics3.checkNotNullExpressionValue(string2, "when {\n                a…eligible)\n              }");
        requirementArr[1] = new EligibilityChecklistView.Requirement(string2, FormatUtils.m213e(this, C5419R.string.f14685xe15d9b97, new Object[0], new C94372(creatorMonetizationEligibilityRequirements)), creatorMonetizationEligibilityRequirements.getAge());
        String string3 = creatorMonetizationEligibilityRequirements.getSafeEnvironment() ? getString(C5419R.string.f14701x95059463) : getString(C5419R.string.f14702x328724f);
        Intrinsics3.checkNotNullExpressionValue(string3, "when {\n                s…        )\n              }");
        requirementArr[2] = new EligibilityChecklistView.Requirement(string3, FormatUtils.m213e(this, C5419R.string.f14700xa4da8df0, new Object[0], C94383.INSTANCE), creatorMonetizationEligibilityRequirements.getSafeEnvironment());
        String string4 = creatorMonetizationEligibilityRequirements.getEngagementHealthy() ? getString(C5419R.string.f14689xa26c16fd) : getString(C5419R.string.f14690x1df817e9);
        Intrinsics3.checkNotNullExpressionValue(string4, "when {\n                e…        )\n              }");
        String string5 = getString(C5419R.string.f14688x1112cd16);
        Intrinsics3.checkNotNullExpressionValue(string5, "getString(R.string.guild…ommunicators_description)");
        requirementArr[3] = new EligibilityChecklistView.Requirement(string4, string5, creatorMonetizationEligibilityRequirements.getEngagementHealthy());
        String string6 = creatorMonetizationEligibilityRequirements.getRetentionHealthy() ? getString(C5419R.string.f14698x8b46b51d) : getString(C5419R.string.f14699xbe16a609);
        Intrinsics3.checkNotNullExpressionValue(string6, "when {\n                r…eligible)\n              }");
        String string7 = getString(C5419R.string.f14697x89d9faf6);
        Intrinsics3.checkNotNullExpressionValue(string7, "getString(R.string.guild…nt_retention_description)");
        requirementArr[4] = new EligibilityChecklistView.Requirement(string6, string7, creatorMonetizationEligibilityRequirements.getRetentionHealthy());
        String string8 = creatorMonetizationEligibilityRequirements.m7774i().isEmpty() ? getString(C5419R.string.f14695xfcdc6141) : getString(C5419R.string.f14696xd6f1a02d);
        Intrinsics3.checkNotNullExpressionValue(string8, "when {\n                n…        )\n              }");
        String string9 = getString(C5419R.string.f14694x82652c52);
        Intrinsics3.checkNotNullExpressionValue(string9, "getString(R.string.guild…nsfw_content_description)");
        requirementArr[5] = new EligibilityChecklistView.Requirement(string8, string9, creatorMonetizationEligibilityRequirements.m7774i().isEmpty());
        return Collections2.listOf((Object[]) requirementArr);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return (AppLogger2) getViewModel().withViewState(new C9433x9aac34d0(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(C5419R.string.guild_settings_role_subscriptions_title);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), WidgetServerSettingsCreatorMonetizationOnboarding.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C94341(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().listenForEvents(), this, null, 2, null), WidgetServerSettingsCreatorMonetizationOnboarding.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C94352(), 62, (Object) null);
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$3 */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class C94293 extends Lambda implements Function1<RenderContext, Unit> {
        public static final C94293 INSTANCE = new C94293();

        public C94293() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("faqUrl", "https://support.discord.com/hc/en-us/articles/5371495812631");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class C94372 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ CreatorMonetizationEligibilityRequirements $this_toChecklistRequirements;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C94372(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
            super(1);
            this.$this_toChecklistRequirements = creatorMonetizationEligibilityRequirements;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("minimumAge", WidgetServerSettingsCreatorMonetizationOnboarding.access$formatDurationFromDays(WidgetServerSettingsCreatorMonetizationOnboarding.this, this.$this_toChecklistRequirements.getMinimumAgeInDays()).toString());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$3 */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class C94383 extends Lambda implements Function1<RenderContext, Unit> {
        public static final C94383 INSTANCE = new C94383();

        public C94383() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("communityGuidelinesUrl", "https://support.discord.com/hc/en-us/articles/360035969312");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class C94361 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ CreatorMonetizationEligibilityRequirements $this_toChecklistRequirements;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C94361(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
            super(1);
            this.$this_toChecklistRequirements = creatorMonetizationEligibilityRequirements;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("minimumSize", StringResourceUtils.getI18nPluralString(WidgetServerSettingsCreatorMonetizationOnboarding.this.requireContext(), C5419R.plurals.guild_role_subscription_settings_eligibility_requirement_members_description_minimumSize, this.$this_toChecklistRequirements.getMinimumSize(), Integer.valueOf(this.$this_toChecklistRequirements.getMinimumSize())).toString());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }
}
