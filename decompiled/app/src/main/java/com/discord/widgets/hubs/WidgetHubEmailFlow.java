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
import com.discord.C5419R;
import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.EmailVerification3;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetHubEmailFlowBinding;
import com.discord.stores.StoreNux;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.RestCallState4;
import com.discord.stores.utilities.RestCallState5;
import com.discord.stores.utilities.RestCallState6;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import com.discord.widgets.nux.WidgetGuildTemplates;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p025i.WidgetDiscordHubEmailInputBinding;
import p007b.p008a.p025i.WidgetHubEmailFlowConfirmationBinding;
import p007b.p008a.p025i.WidgetHubEmailFlowWaitlistBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEmailFlow extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetHubEmailFlow.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubEmailFlowBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NAME = WidgetHubEmailFlow.class.getName();
    private final ActivityResultLauncher<Intent> activityResultHandler;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
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
            WidgetHubEmailViewModel3.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            WidgetHubEmailViewModel3 widgetHubEmailViewModel3 = WidgetHubEmailViewModel3.Invite;
            iArr[widgetHubEmailViewModel3.ordinal()] = 1;
            WidgetHubEmailViewModel3 widgetHubEmailViewModel32 = WidgetHubEmailViewModel3.Onboarding;
            iArr[widgetHubEmailViewModel32.ordinal()] = 2;
            WidgetHubEmailViewModel3.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[widgetHubEmailViewModel3.ordinal()] = 1;
            iArr2[widgetHubEmailViewModel32.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
    public static final class C90341 extends Lambda implements Function1<WidgetHubEmailViewModel4, Unit> {
        public C90341() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHubEmailViewModel4 widgetHubEmailViewModel4) {
            invoke2(widgetHubEmailViewModel4);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHubEmailViewModel4 widgetHubEmailViewModel4) {
            WidgetHubEmailFlow widgetHubEmailFlow = WidgetHubEmailFlow.this;
            Intrinsics3.checkNotNullExpressionValue(widgetHubEmailViewModel4, "viewState");
            WidgetHubEmailFlow.access$updateView(widgetHubEmailFlow, widgetHubEmailViewModel4);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
    public static final class ViewOnClickListenerC90351 implements View.OnClickListener {
        public ViewOnClickListenerC90351() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEmailFlow.access$verifyEmail(WidgetHubEmailFlow.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewCreated$2 */
    /* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
    public static final class ViewOnClickListenerC90362 implements View.OnClickListener {

        /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewCreated$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
                return invoke2(nuxState);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final StoreNux.NuxState invoke2(StoreNux.NuxState nuxState) {
                Intrinsics3.checkNotNullParameter(nuxState, "it");
                return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, false, null, 62, null);
            }
        }

        public ViewOnClickListenerC90362() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetHubEmailFlow.this.getActivity();
            if (activity != null) {
                Intrinsics3.checkNotNullExpressionValue(activity, "activity ?: return@setOnClickListener");
                if (WidgetHubEmailFlow.access$getArgs$p(WidgetHubEmailFlow.this).getEntryPoint() == WidgetHubEmailViewModel3.Onboarding) {
                    StoreStream.INSTANCE.getNux().updateNux(AnonymousClass1.INSTANCE);
                    WidgetGuildTemplates.INSTANCE.launch(activity, CreateGuildTrigger.NUF, true);
                }
                activity.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewCreated$3 */
    /* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
    public static final class ViewOnClickListenerC90373 implements View.OnClickListener {
        public ViewOnClickListenerC90373() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEmailFlow.access$getViewModel$p(WidgetHubEmailFlow.this).reset();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$updateView$2 */
    /* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
    public static final class ViewOnClickListenerC90392 implements View.OnClickListener {
        public ViewOnClickListenerC90392() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = WidgetHubEmailFlow.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$updateView$3 */
    /* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
    public static final class ViewOnClickListenerC90403 implements View.OnClickListener {
        public ViewOnClickListenerC90403() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetHubEmailFlow.access$verifyEmail(WidgetHubEmailFlow.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$updateView$4 */
    /* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
    public static final class C90414 extends Lambda implements Function1<RestCallState6<? extends EmailVerification>, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ String $email;
        public final /* synthetic */ WidgetHubEmailViewModel4 $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C90414(WidgetHubEmailViewModel4 widgetHubEmailViewModel4, Context context, String str) {
            super(1);
            this.$state = widgetHubEmailViewModel4;
            this.$context = context;
            this.$email = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState6<? extends EmailVerification> restCallState6) {
            invoke2((RestCallState6<EmailVerification>) restCallState6);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState6<EmailVerification> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
            StoreStream.INSTANCE.getDirectories().markDiscordHubClicked();
            if (!this.$state.getHasMultipleDomains()) {
                EmailVerification emailVerificationInvoke = this.$state.getVerifyEmailAsync().invoke();
                if (emailVerificationInvoke == null || emailVerificationInvoke.getHasMatchingGuild() || !GrowthTeamFeatures.INSTANCE.isMultiDomainEnabled()) {
                    return;
                }
                AppScreen2.f524g.m160f(this.$context, WidgetHubEmailFlow.access$getActivityResultHandler$p(WidgetHubEmailFlow.this), WidgetHubWaitlist.class, new WidgetHubWaitlistViewModel2(this.$email));
                WidgetHubEmailFlow.access$getViewModel$p(WidgetHubEmailFlow.this).reset();
                return;
            }
            AppScreen2 appScreen2 = AppScreen2.f524g;
            Context context = this.$context;
            ActivityResultLauncher<Intent> activityResultLauncherAccess$getActivityResultHandler$p = WidgetHubEmailFlow.access$getActivityResultHandler$p(WidgetHubEmailFlow.this);
            String str = this.$email;
            List<EmailVerification3> listM7998a = restCallState6.invoke().m7998a();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listM7998a, 10));
            Iterator<T> it = listM7998a.iterator();
            while (it.hasNext()) {
                arrayList.add(WidgetHubDomains2.INSTANCE.from((EmailVerification3) it.next()));
            }
            appScreen2.m160f(context, activityResultLauncherAccess$getActivityResultHandler$p, WidgetHubDomains.class, new WidgetHubDomains3(str, arrayList));
            WidgetHubEmailFlow.access$getViewModel$p(WidgetHubEmailFlow.this).reset();
        }
    }

    public WidgetHubEmailFlow() {
        super(C5419R.layout.widget_hub_email_flow);
        this.args = LazyJVM.lazy(new WidgetHubEmailFlow$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHubEmailFlow3.INSTANCE, null, 2, null);
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetHubEmailFlow2(this));
        Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…  }\n            }\n      }");
        this.activityResultHandler = activityResultLauncherRegisterForActivityResult;
        WidgetHubEmailFlow7 widgetHubEmailFlow7 = WidgetHubEmailFlow7.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHubEmailViewModel.class), new WidgetHubEmailFlow$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetHubEmailFlow7));
        this.validationManager = LazyJVM.lazy(new WidgetHubEmailFlow6(this));
        this.loggingConfig = new AppLogger2(false, null, new WidgetHubEmailFlow4(this), 3);
    }

    public static final /* synthetic */ ActivityResultLauncher access$getActivityResultHandler$p(WidgetHubEmailFlow widgetHubEmailFlow) {
        return widgetHubEmailFlow.activityResultHandler;
    }

    public static final /* synthetic */ WidgetHubEmailViewModel2 access$getArgs$p(WidgetHubEmailFlow widgetHubEmailFlow) {
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

    public static final /* synthetic */ void access$updateView(WidgetHubEmailFlow widgetHubEmailFlow, WidgetHubEmailViewModel4 widgetHubEmailViewModel4) {
        widgetHubEmailFlow.updateView(widgetHubEmailViewModel4);
    }

    public static final /* synthetic */ void access$verifyEmail(WidgetHubEmailFlow widgetHubEmailFlow) {
        widgetHubEmailFlow.verifyEmail();
    }

    private final WidgetHubEmailViewModel2 getArgs() {
        return (WidgetHubEmailViewModel2) this.args.getValue();
    }

    private final WidgetHubEmailFlowBinding getBinding() {
        return (WidgetHubEmailFlowBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getEmail() {
        TextInputEditText textInputEditText = getBinding().f17175c.f819c;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.discordHubEmailI…aderDescriptionEmailInput");
        return String.valueOf(textInputEditText.getText());
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final WidgetHubEmailViewModel getViewModel() {
        return (WidgetHubEmailViewModel) this.viewModel.getValue();
    }

    private final void updateView(WidgetHubEmailViewModel4 state) {
        String school;
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            EmailVerification emailVerificationInvoke = state.getVerifyEmailAsync().invoke();
            boolean z2 = emailVerificationInvoke != null && emailVerificationInvoke.getHasMatchingGuild();
            boolean z3 = !(state.getVerifyEmailAsync() instanceof RestCallState6) && state.getWaitlistResult() == null;
            EmailVerification emailVerificationInvoke2 = state.getVerifyEmailAsync().invoke();
            boolean z4 = ((emailVerificationInvoke2 == null || emailVerificationInvoke2.getHasMatchingGuild()) && state.getWaitlistResult() == null) ? false : true;
            TextInputEditText textInputEditText = getBinding().f17175c.f819c;
            Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.discordHubEmailI…aderDescriptionEmailInput");
            String strValueOf = String.valueOf(textInputEditText.getText());
            WidgetDiscordHubEmailInputBinding widgetDiscordHubEmailInputBinding = getBinding().f17175c;
            Intrinsics3.checkNotNullExpressionValue(widgetDiscordHubEmailInputBinding, "binding.discordHubEmailInput");
            NestedScrollView nestedScrollView = widgetDiscordHubEmailInputBinding.f817a;
            Intrinsics3.checkNotNullExpressionValue(nestedScrollView, "binding.discordHubEmailInput.root");
            nestedScrollView.setVisibility(z3 ? 0 : 8);
            MaterialButton materialButton = getBinding().f17176d;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.discordHubEmailNo");
            materialButton.setVisibility(z3 ? 0 : 8);
            WidgetHubEmailFlowConfirmationBinding widgetHubEmailFlowConfirmationBinding = getBinding().f17174b;
            Intrinsics3.checkNotNullExpressionValue(widgetHubEmailFlowConfirmationBinding, "binding.discordHubEmailConfirmation");
            NestedScrollView nestedScrollView2 = widgetHubEmailFlowConfirmationBinding.f1117a;
            Intrinsics3.checkNotNullExpressionValue(nestedScrollView2, "binding.discordHubEmailConfirmation.root");
            nestedScrollView2.setVisibility(z2 ? 0 : 8);
            TextView textView = getBinding().f17174b.f1119c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.discordHubEmailC…ilConfirmationHeaderTitle");
            textView.setText(FormatUtils.m219k(this, C5419R.string.member_verification_email_confirmation_title, new Object[]{strValueOf}, null, 4));
            WidgetHubEmailFlowWaitlistBinding widgetHubEmailFlowWaitlistBinding = getBinding().f17178f;
            Intrinsics3.checkNotNullExpressionValue(widgetHubEmailFlowWaitlistBinding, "binding.discordHubWaitlist");
            NestedScrollView nestedScrollView3 = widgetHubEmailFlowWaitlistBinding.f1139a;
            Intrinsics3.checkNotNullExpressionValue(nestedScrollView3, "binding.discordHubWaitlist.root");
            nestedScrollView3.setVisibility(z4 ? 0 : 8);
            WidgetHubWaitlist2 waitlistResult = state.getWaitlistResult();
            if (waitlistResult != null && (school = waitlistResult.getSchool()) != null) {
                TextView textView2 = getBinding().f17178f.f1140b;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.discordHubWaitlist.hubWaitlistDescription");
                textView2.setText(FormatUtils.m219k(this, C5419R.string.hub_waitlist_modal_joined_description, new Object[]{school}, null, 4));
            }
            getBinding().f17177e.setOnClickListener(z4 ? new ViewOnClickListenerC90392() : new ViewOnClickListenerC90403());
            LoadingButton loadingButton = getBinding().f17177e;
            Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.discordHubEmailYes");
            loadingButton.setVisibility(z2 ^ true ? 0 : 8);
            getBinding().f17177e.setText(z4 ? getString(C5419R.string.hub_add_server_confirmation_button) : getString(C5419R.string.hub_email_connection_content_button));
            getBinding().f17177e.setIsLoading(state.getVerifyEmailAsync() instanceof RestCallState4);
            RestCallState5.handleResponse$default(state.getVerifyEmailAsync(), context, null, null, new C90414(state, context, strValueOf), 6, null);
        }
    }

    private final void verifyEmail() {
        boolean zValidate$default = ValidationManager.validate$default(getValidationManager(), false, 1, null);
        TextView textView = getBinding().f17175c.f822f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.discordHubEmailInput.discordHubEmailLabel");
        textView.setVisibility(zValidate$default ? 0 : 8);
        if (zValidate$default) {
            getViewModel().submitEmail(getEmail());
            hideKeyboard(getView());
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetHubEmailViewModel4> observableM11112r = getViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), WidgetHubEmailFlow.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C90341(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        CharSequence string;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f17174b.f1120d.setOnClickListener(new ViewOnClickListenerC90351());
        getBinding().f17176d.setOnClickListener(new ViewOnClickListenerC90362());
        getBinding().f17174b.f1118b.setOnClickListener(new ViewOnClickListenerC90373());
        TextView textView = getBinding().f17175c.f821e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.discordHubEmailI…iscordHubEmailHeaderTitle");
        int iOrdinal = getArgs().getEntryPoint().ordinal();
        if (iOrdinal == 0) {
            string = getString(C5419R.string.hub_email_connection_nux_header);
        } else if (iOrdinal != 1) {
            string = getString(C5419R.string.hub_waitlist_modal_join_header);
        } else {
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "view.context");
            string = FormatUtils.m219k(this, C5419R.string.hub_email_connection_invite_header, new Object[]{StringResourceUtils.getI18nPluralString(context, C5419R.plurals.hub_email_connection_invite_header_count, getArgs().getGuildMemberCount(), Integer.valueOf(getArgs().getGuildMemberCount())), getArgs().getGuildName()}, null, 4);
        }
        textView.setText(string);
        int iOrdinal2 = getArgs().getEntryPoint().ordinal();
        String string2 = getString(iOrdinal2 != 0 ? iOrdinal2 != 1 ? C5419R.string.hub_waitlist_modal_join_subheader : C5419R.string.hub_email_connection_content_description : C5419R.string.hub_email_connection_nux_content_description);
        Intrinsics3.checkNotNullExpressionValue(string2, "getString(\n        when …subheader\n        }\n    )");
        CharSequence charSequenceM213e = FormatUtils.m213e(this, C5419R.string.learn_more_link, new Object[0], new WidgetHubEmailFlow5(this));
        LinkifiedTextView linkifiedTextView = getBinding().f17175c.f818b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.discordHubEmailI…HubEmailHeaderDescription");
        linkifiedTextView.setText(new SpannableStringBuilder(string2).append((CharSequence) " ").append(charSequenceM213e));
    }
}
