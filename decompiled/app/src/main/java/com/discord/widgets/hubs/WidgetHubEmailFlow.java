package com.discord.widgets.hubs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.a.i.e5;
import b.a.i.o5;
import b.a.i.p5;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.GuildInfo;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetHubEmailFlowBinding;
import com.discord.stores.StoreNux;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.Loading;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.stores.utilities.Success;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import com.discord.widgets.nux.WidgetGuildTemplates;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetHubEmailFlow.kt */
/* loaded from: classes2.dex */
public final class WidgetHubEmailFlow extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetHubEmailFlow.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubEmailFlowBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NAME = WidgetHubEmailFlow.class.getName();
    private final ActivityResultLauncher<Intent> activityResultHandler;

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    /* renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetHubEmailFlow.kt */
    public static final class Companion {
        private Companion() {
        }

        public final String getNAME() {
            return WidgetHubEmailFlow.access$getNAME$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            HubEmailEntryPoint.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            HubEmailEntryPoint hubEmailEntryPoint = HubEmailEntryPoint.Invite;
            iArr[hubEmailEntryPoint.ordinal()] = 1;
            HubEmailEntryPoint hubEmailEntryPoint2 = HubEmailEntryPoint.Onboarding;
            iArr[hubEmailEntryPoint2.ordinal()] = 2;
            HubEmailEntryPoint.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[hubEmailEntryPoint.ordinal()] = 1;
            iArr2[hubEmailEntryPoint2.ordinal()] = 2;
        }
    }

    /* compiled from: WidgetHubEmailFlow.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<HubEmailState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HubEmailState hubEmailState) {
            invoke2(hubEmailState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(HubEmailState hubEmailState) {
            WidgetHubEmailFlow widgetHubEmailFlow = WidgetHubEmailFlow.this;
            m.checkNotNullExpressionValue(hubEmailState, "viewState");
            WidgetHubEmailFlow.access$updateView(widgetHubEmailFlow, hubEmailState);
        }
    }

    /* compiled from: WidgetHubEmailFlow.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEmailFlow.access$verifyEmail(WidgetHubEmailFlow.this);
        }
    }

    /* compiled from: WidgetHubEmailFlow.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {

        /* compiled from: WidgetHubEmailFlow.kt */
        /* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewCreated$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
                return invoke2(nuxState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final StoreNux.NuxState invoke2(StoreNux.NuxState nuxState) {
                m.checkNotNullParameter(nuxState, "it");
                return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, false, null, 62, null);
            }
        }

        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetHubEmailFlow.this.getActivity();
            if (activity != null) {
                m.checkNotNullExpressionValue(activity, "activity ?: return@setOnClickListener");
                if (WidgetHubEmailFlow.access$getArgs$p(WidgetHubEmailFlow.this).getEntryPoint() == HubEmailEntryPoint.Onboarding) {
                    StoreStream.INSTANCE.getNux().updateNux(AnonymousClass1.INSTANCE);
                    WidgetGuildTemplates.INSTANCE.launch(activity, CreateGuildTrigger.NUF, true);
                }
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetHubEmailFlow.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewCreated$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEmailFlow.access$getViewModel$p(WidgetHubEmailFlow.this).reset();
        }
    }

    /* compiled from: WidgetHubEmailFlow.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$updateView$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetHubEmailFlow.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetHubEmailFlow.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$updateView$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEmailFlow.access$verifyEmail(WidgetHubEmailFlow.this);
        }
    }

    /* compiled from: WidgetHubEmailFlow.kt */
    /* renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$updateView$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<Success<? extends EmailVerification>, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ String $email;
        public final /* synthetic */ HubEmailState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(HubEmailState hubEmailState, Context context, String str) {
            super(1);
            this.$state = hubEmailState;
            this.$context = context;
            this.$email = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Success<? extends EmailVerification> success) {
            invoke2((Success<EmailVerification>) success);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Success<EmailVerification> success) {
            m.checkNotNullParameter(success, "it");
            StoreStream.INSTANCE.getDirectories().markDiscordHubClicked();
            if (!this.$state.getHasMultipleDomains()) {
                EmailVerification emailVerificationInvoke = this.$state.getVerifyEmailAsync().invoke();
                if (emailVerificationInvoke == null || emailVerificationInvoke.getHasMatchingGuild() || !GrowthTeamFeatures.INSTANCE.isMultiDomainEnabled()) {
                    return;
                }
                j.g.f(this.$context, WidgetHubEmailFlow.access$getActivityResultHandler$p(WidgetHubEmailFlow.this), WidgetHubWaitlist.class, new HubWaitlistArgs(this.$email));
                WidgetHubEmailFlow.access$getViewModel$p(WidgetHubEmailFlow.this).reset();
                return;
            }
            j jVar = j.g;
            Context context = this.$context;
            ActivityResultLauncher<Intent> activityResultLauncherAccess$getActivityResultHandler$p = WidgetHubEmailFlow.access$getActivityResultHandler$p(WidgetHubEmailFlow.this);
            String str = this.$email;
            List<GuildInfo> listA = success.invoke().a();
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listA, 10));
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add(DomainGuildInfo.INSTANCE.from((GuildInfo) it.next()));
            }
            jVar.f(context, activityResultLauncherAccess$getActivityResultHandler$p, WidgetHubDomains.class, new HubDomainArgs(str, arrayList));
            WidgetHubEmailFlow.access$getViewModel$p(WidgetHubEmailFlow.this).reset();
        }
    }

    public WidgetHubEmailFlow() {
        super(R.layout.widget_hub_email_flow);
        this.args = g.lazy(new WidgetHubEmailFlow$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubEmailFlow$binding$2.INSTANCE, null, 2, null);
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetHubEmailFlow$activityResultHandler$1(this));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…  }\n            }\n      }");
        this.activityResultHandler = activityResultLauncherRegisterForActivityResult;
        WidgetHubEmailFlow$viewModel$2 widgetHubEmailFlow$viewModel$2 = WidgetHubEmailFlow$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetHubEmailViewModel.class), new WidgetHubEmailFlow$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetHubEmailFlow$viewModel$2));
        this.validationManager = g.lazy(new WidgetHubEmailFlow$validationManager$2(this));
        this.loggingConfig = new LoggingConfig(false, null, new WidgetHubEmailFlow$loggingConfig$1(this), 3);
    }

    public static final /* synthetic */ ActivityResultLauncher access$getActivityResultHandler$p(WidgetHubEmailFlow widgetHubEmailFlow) {
        return widgetHubEmailFlow.activityResultHandler;
    }

    public static final /* synthetic */ HubEmailArgs access$getArgs$p(WidgetHubEmailFlow widgetHubEmailFlow) {
        return widgetHubEmailFlow.getArgs();
    }

    public static final /* synthetic */ WidgetHubEmailFlowBinding access$getBinding$p(WidgetHubEmailFlow widgetHubEmailFlow) {
        return widgetHubEmailFlow.getBinding();
    }

    public static final /* synthetic */ String access$getNAME$cp() {
        return NAME;
    }

    public static final /* synthetic */ WidgetHubEmailViewModel access$getViewModel$p(WidgetHubEmailFlow widgetHubEmailFlow) {
        return widgetHubEmailFlow.getViewModel();
    }

    public static final /* synthetic */ void access$updateView(WidgetHubEmailFlow widgetHubEmailFlow, HubEmailState hubEmailState) {
        widgetHubEmailFlow.updateView(hubEmailState);
    }

    public static final /* synthetic */ void access$verifyEmail(WidgetHubEmailFlow widgetHubEmailFlow) {
        widgetHubEmailFlow.verifyEmail();
    }

    private final HubEmailArgs getArgs() {
        return (HubEmailArgs) this.args.getValue();
    }

    private final WidgetHubEmailFlowBinding getBinding() {
        return (WidgetHubEmailFlowBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getEmail() {
        TextInputEditText textInputEditText = getBinding().c.c;
        m.checkNotNullExpressionValue(textInputEditText, "binding.discordHubEmailI…aderDescriptionEmailInput");
        return String.valueOf(textInputEditText.getText());
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final WidgetHubEmailViewModel getViewModel() {
        return (WidgetHubEmailViewModel) this.viewModel.getValue();
    }

    private final void updateView(HubEmailState state) {
        String school;
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            EmailVerification emailVerificationInvoke = state.getVerifyEmailAsync().invoke();
            boolean z2 = emailVerificationInvoke != null && emailVerificationInvoke.getHasMatchingGuild();
            boolean z3 = !(state.getVerifyEmailAsync() instanceof Success) && state.getWaitlistResult() == null;
            EmailVerification emailVerificationInvoke2 = state.getVerifyEmailAsync().invoke();
            boolean z4 = ((emailVerificationInvoke2 == null || emailVerificationInvoke2.getHasMatchingGuild()) && state.getWaitlistResult() == null) ? false : true;
            TextInputEditText textInputEditText = getBinding().c.c;
            m.checkNotNullExpressionValue(textInputEditText, "binding.discordHubEmailI…aderDescriptionEmailInput");
            String strValueOf = String.valueOf(textInputEditText.getText());
            e5 e5Var = getBinding().c;
            m.checkNotNullExpressionValue(e5Var, "binding.discordHubEmailInput");
            NestedScrollView nestedScrollView = e5Var.a;
            m.checkNotNullExpressionValue(nestedScrollView, "binding.discordHubEmailInput.root");
            nestedScrollView.setVisibility(z3 ? 0 : 8);
            MaterialButton materialButton = getBinding().d;
            m.checkNotNullExpressionValue(materialButton, "binding.discordHubEmailNo");
            materialButton.setVisibility(z3 ? 0 : 8);
            o5 o5Var = getBinding().f2473b;
            m.checkNotNullExpressionValue(o5Var, "binding.discordHubEmailConfirmation");
            NestedScrollView nestedScrollView2 = o5Var.a;
            m.checkNotNullExpressionValue(nestedScrollView2, "binding.discordHubEmailConfirmation.root");
            nestedScrollView2.setVisibility(z2 ? 0 : 8);
            TextView textView = getBinding().f2473b.c;
            m.checkNotNullExpressionValue(textView, "binding.discordHubEmailC…ilConfirmationHeaderTitle");
            textView.setText(b.k(this, R.string.member_verification_email_confirmation_title, new Object[]{strValueOf}, null, 4));
            p5 p5Var = getBinding().f;
            m.checkNotNullExpressionValue(p5Var, "binding.discordHubWaitlist");
            NestedScrollView nestedScrollView3 = p5Var.a;
            m.checkNotNullExpressionValue(nestedScrollView3, "binding.discordHubWaitlist.root");
            nestedScrollView3.setVisibility(z4 ? 0 : 8);
            HubWaitlistResult waitlistResult = state.getWaitlistResult();
            if (waitlistResult != null && (school = waitlistResult.getSchool()) != null) {
                TextView textView2 = getBinding().f.f182b;
                m.checkNotNullExpressionValue(textView2, "binding.discordHubWaitlist.hubWaitlistDescription");
                textView2.setText(b.k(this, R.string.hub_waitlist_modal_joined_description, new Object[]{school}, null, 4));
            }
            getBinding().e.setOnClickListener(z4 ? new AnonymousClass2() : new AnonymousClass3());
            LoadingButton loadingButton = getBinding().e;
            m.checkNotNullExpressionValue(loadingButton, "binding.discordHubEmailYes");
            loadingButton.setVisibility(z2 ^ true ? 0 : 8);
            getBinding().e.setText(z4 ? getString(R.string.hub_add_server_confirmation_button) : getString(R.string.hub_email_connection_content_button));
            getBinding().e.setIsLoading(state.getVerifyEmailAsync() instanceof Loading);
            RestCallStateKt.handleResponse$default(state.getVerifyEmailAsync(), context, null, null, new AnonymousClass4(state, context, strValueOf), 6, null);
        }
    }

    private final void verifyEmail() {
        boolean zValidate$default = ValidationManager.validate$default(getValidationManager(), false, 1, null);
        TextView textView = getBinding().c.f;
        m.checkNotNullExpressionValue(textView, "binding.discordHubEmailInput.discordHubEmailLabel");
        textView.setVisibility(zValidate$default ? 0 : 8);
        if (zValidate$default) {
            getViewModel().submitEmail(getEmail());
            hideKeyboard(getView());
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<HubEmailState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetHubEmailFlow.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        CharSequence string;
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f2473b.d.setOnClickListener(new AnonymousClass1());
        getBinding().d.setOnClickListener(new AnonymousClass2());
        getBinding().f2473b.f176b.setOnClickListener(new AnonymousClass3());
        TextView textView = getBinding().c.e;
        m.checkNotNullExpressionValue(textView, "binding.discordHubEmailI…iscordHubEmailHeaderTitle");
        int iOrdinal = getArgs().getEntryPoint().ordinal();
        if (iOrdinal == 0) {
            string = getString(R.string.hub_email_connection_nux_header);
        } else if (iOrdinal != 1) {
            string = getString(R.string.hub_waitlist_modal_join_header);
        } else {
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "view.context");
            string = b.k(this, R.string.hub_email_connection_invite_header, new Object[]{StringResourceUtilsKt.getI18nPluralString(context, R.plurals.hub_email_connection_invite_header_count, getArgs().getGuildMemberCount(), Integer.valueOf(getArgs().getGuildMemberCount())), getArgs().getGuildName()}, null, 4);
        }
        textView.setText(string);
        int iOrdinal2 = getArgs().getEntryPoint().ordinal();
        String string2 = getString(iOrdinal2 != 0 ? iOrdinal2 != 1 ? R.string.hub_waitlist_modal_join_subheader : R.string.hub_email_connection_content_description : R.string.hub_email_connection_nux_content_description);
        m.checkNotNullExpressionValue(string2, "getString(\n        when …subheader\n        }\n    )");
        CharSequence charSequenceE = b.e(this, R.string.learn_more_link, new Object[0], new WidgetHubEmailFlow$onViewCreated$learnMore$1(this));
        LinkifiedTextView linkifiedTextView = getBinding().c.f107b;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.discordHubEmailI…HubEmailHeaderDescription");
        linkifiedTextView.setText(new SpannableStringBuilder(string2).append((CharSequence) " ").append(charSequenceE));
    }
}
