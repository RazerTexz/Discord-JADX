package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsCommunitySetupFirstStepBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.ToastManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* compiled from: WidgetServerSettingsCommunityFirstStep.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityFirstStep extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerSettingsCommunityFirstStep.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCommunitySetupFirstStepBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ToastManager toastManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetServerSettingsCommunityFirstStep.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m156d(context, WidgetServerSettingsCommunityFirstStep.class, new Intent());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsCommunityFirstStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$configureUI$1 */
    public static final class ViewOnClickListenerC93531 implements View.OnClickListener {
        public final /* synthetic */ boolean $guildVerificationLevel;
        public final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded $viewState;

        /* compiled from: WidgetServerSettingsCommunityFirstStep.kt */
        /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$configureUI$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                return invoke2(communityGuildConfig);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke2(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                Intrinsics3.checkNotNullParameter(communityGuildConfig, "it");
                Intrinsics3.checkNotNullExpressionValue(WidgetServerSettingsCommunityFirstStep.access$getBinding$p(WidgetServerSettingsCommunityFirstStep.this).f17583c, "binding.communitySettingsVerifiedEmailedSwitch");
                return WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig.copy$default(communityGuildConfig, null, null, null, null, false, false, !r2.isChecked(), false, null, false, null, null, 4031, null);
            }
        }

        public ViewOnClickListenerC93531(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded, boolean z2) {
            this.$viewState = loaded;
            this.$guildVerificationLevel = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$viewState.getCommunityGuildConfig().getVerificationLevel() && this.$guildVerificationLevel) {
                AppToast.m166d(WidgetServerSettingsCommunityFirstStep.this.getContext(), C5419R.string.enable_community_modal_requirement_satisfied_tooltip, 0, WidgetServerSettingsCommunityFirstStep.access$getToastManager$p(WidgetServerSettingsCommunityFirstStep.this));
            } else {
                WidgetServerSettingsCommunityFirstStep.access$getViewModel$p(WidgetServerSettingsCommunityFirstStep.this).modifyGuildConfig(new AnonymousClass1());
            }
        }
    }

    /* compiled from: WidgetServerSettingsCommunityFirstStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$configureUI$2 */
    public static final class ViewOnClickListenerC93542 implements View.OnClickListener {
        public final /* synthetic */ boolean $guildExplicitContentFilter;
        public final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded $viewState;

        /* compiled from: WidgetServerSettingsCommunityFirstStep.kt */
        /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$configureUI$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                return invoke2(communityGuildConfig);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke2(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                Intrinsics3.checkNotNullParameter(communityGuildConfig, "it");
                Intrinsics3.checkNotNullExpressionValue(WidgetServerSettingsCommunityFirstStep.access$getBinding$p(WidgetServerSettingsCommunityFirstStep.this).f17582b, "binding.communitySettingsScanMessagesSwitch");
                return WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig.copy$default(communityGuildConfig, null, null, null, null, false, false, false, !r2.isChecked(), null, false, null, null, 3967, null);
            }
        }

        public ViewOnClickListenerC93542(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded, boolean z2) {
            this.$viewState = loaded;
            this.$guildExplicitContentFilter = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$viewState.getCommunityGuildConfig().getExplicitContentFilter() && this.$guildExplicitContentFilter) {
                AppToast.m166d(WidgetServerSettingsCommunityFirstStep.this.getContext(), C5419R.string.enable_community_modal_requirement_satisfied_tooltip, 0, WidgetServerSettingsCommunityFirstStep.access$getToastManager$p(WidgetServerSettingsCommunityFirstStep.this));
            } else {
                WidgetServerSettingsCommunityFirstStep.access$getViewModel$p(WidgetServerSettingsCommunityFirstStep.this).modifyGuildConfig(new AnonymousClass1());
            }
        }
    }

    /* compiled from: WidgetServerSettingsCommunityFirstStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityFirstStep$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C93571 extends FunctionReferenceImpl implements Function1<WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded, Unit> {
        public C93571(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep) {
            super(1, widgetServerSettingsCommunityFirstStep, WidgetServerSettingsCommunityFirstStep.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "p1");
            WidgetServerSettingsCommunityFirstStep.access$configureUI((WidgetServerSettingsCommunityFirstStep) this.receiver, loaded);
        }
    }

    public WidgetServerSettingsCommunityFirstStep() {
        super(C5419R.layout.widget_server_settings_community_setup_first_step);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsCommunityFirstStep2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new C9351x10f0ed5c(this), new AppViewModelDelegates2(WidgetServerSettingsCommunityFirstStep3.INSTANCE));
        this.toastManager = new ToastManager();
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep, WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
        widgetServerSettingsCommunityFirstStep.configureUI(loaded);
    }

    public static final /* synthetic */ WidgetServerSettingsCommunitySetupFirstStepBinding access$getBinding$p(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep) {
        return widgetServerSettingsCommunityFirstStep.getBinding();
    }

    public static final /* synthetic */ ToastManager access$getToastManager$p(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep) {
        return widgetServerSettingsCommunityFirstStep.toastManager;
    }

    public static final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel access$getViewModel$p(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep) {
        return widgetServerSettingsCommunityFirstStep.getViewModel();
    }

    public static final /* synthetic */ void access$setToastManager$p(WidgetServerSettingsCommunityFirstStep widgetServerSettingsCommunityFirstStep, ToastManager toastManager) {
        widgetServerSettingsCommunityFirstStep.toastManager = toastManager;
    }

    private final void configureUI(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded viewState) {
        CheckedSetting checkedSetting = getBinding().f17583c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.communitySettingsVerifiedEmailedSwitch");
        checkedSetting.setChecked(viewState.getCommunityGuildConfig().getVerificationLevel());
        CheckedSetting checkedSetting2 = getBinding().f17582b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.communitySettingsScanMessagesSwitch");
        checkedSetting2.setChecked(viewState.getCommunityGuildConfig().getExplicitContentFilter());
        Guild guild = viewState.getCommunityGuildConfig().getGuild();
        boolean z2 = guild != null && guild.getVerificationLevel().compareTo(GuildVerificationLevel.NONE) > 0;
        boolean z3 = guild != null && guild.getExplicitContentFilter().compareTo(GuildExplicitContentFilter.NONE) > 0;
        getBinding().f17583c.m8527e(new ViewOnClickListenerC93531(viewState, z2));
        getBinding().f17582b.m8527e(new ViewOnClickListenerC93542(viewState, z3));
    }

    public static final void create(Context context) {
        INSTANCE.create(context);
    }

    private final WidgetServerSettingsCommunitySetupFirstStepBinding getBinding() {
        return (WidgetServerSettingsCommunitySetupFirstStepBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsEnableCommunityViewModel getViewModel() {
        return (WidgetServerSettingsEnableCommunityViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.toastManager.close();
        super.onDestroyView();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableM11083G = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).m11118y(C9355xea26ebea.INSTANCE).m11083G(C9356xea26ebeb.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(observableM11083G, WidgetServerSettingsCommunityFirstStep.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C93571(this), 62, (Object) null);
    }
}
