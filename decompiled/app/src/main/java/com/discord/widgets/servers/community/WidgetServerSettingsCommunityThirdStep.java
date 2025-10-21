package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsCommunitySetupThirdStepBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.guild.Guild;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.ToastManager;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityThirdStep extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsCommunityThirdStep.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCommunitySetupThirdStepBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ToastManager toastManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetServerSettingsCommunityThirdStep.class, new Intent());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityThirdStep$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ boolean $guildDefaultMessageNotifications;
        public final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded $viewState;

        /* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
        /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityThirdStep$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03201 extends Lambda implements Function1<WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig> {
            public C03201() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                return invoke2(communityGuildConfig);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke2(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                Intrinsics3.checkNotNullParameter(communityGuildConfig, "it");
                Intrinsics3.checkNotNullExpressionValue(WidgetServerSettingsCommunityThirdStep.access$getBinding$p(WidgetServerSettingsCommunityThirdStep.this).e, "binding.communitySetting…ficationsToMentionsSwitch");
                return WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig.copy$default(communityGuildConfig, null, null, null, null, false, !r2.isChecked(), false, false, null, false, null, null, 4063, null);
            }
        }

        public AnonymousClass1(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded, boolean z2) {
            this.$viewState = loaded;
            this.$guildDefaultMessageNotifications = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$viewState.getCommunityGuildConfig().getDefaultMessageNotifications() && this.$guildDefaultMessageNotifications) {
                AppToast.d(WidgetServerSettingsCommunityThirdStep.this.getContext(), R.string.enable_community_modal_requirement_satisfied_tooltip, 0, WidgetServerSettingsCommunityThirdStep.access$getToastManager$p(WidgetServerSettingsCommunityThirdStep.this));
            } else {
                WidgetServerSettingsCommunityThirdStep.access$getViewModel$p(WidgetServerSettingsCommunityThirdStep.this).modifyGuildConfig(new C03201());
            }
        }
    }

    /* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityThirdStep$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ boolean $guildEveryonePermissions;
        public final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded $viewState;

        /* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
        /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityThirdStep$configureUI$2$1, reason: invalid class name */
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
                Intrinsics3.checkNotNullExpressionValue(WidgetServerSettingsCommunityThirdStep.access$getBinding$p(WidgetServerSettingsCommunityThirdStep.this).d, "binding.communitySettingManagePermissionsSwitch");
                return WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig.copy$default(communityGuildConfig, null, null, null, null, false, false, false, false, null, !r2.isChecked(), null, null, 3583, null);
            }
        }

        public AnonymousClass2(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded, boolean z2) {
            this.$viewState = loaded;
            this.$guildEveryonePermissions = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$viewState.getCommunityGuildConfig().getEveryonePermissions() && this.$guildEveryonePermissions) {
                AppToast.d(WidgetServerSettingsCommunityThirdStep.this.getContext(), R.string.enable_community_modal_requirement_satisfied_tooltip, 0, WidgetServerSettingsCommunityThirdStep.access$getToastManager$p(WidgetServerSettingsCommunityThirdStep.this));
            } else {
                WidgetServerSettingsCommunityThirdStep.access$getViewModel$p(WidgetServerSettingsCommunityThirdStep.this).modifyGuildConfig(new AnonymousClass1());
            }
        }
    }

    /* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityThirdStep$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {

        /* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
        /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityThirdStep$configureUI$3$1, reason: invalid class name */
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
                Intrinsics3.checkNotNullExpressionValue(WidgetServerSettingsCommunityThirdStep.access$getBinding$p(WidgetServerSettingsCommunityThirdStep.this).f2556b, "binding.communitySettingCommunityGuidelinesSwitch");
                return WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig.copy$default(communityGuildConfig, null, null, null, null, !r2.isChecked(), false, false, false, null, false, null, null, 4079, null);
            }
        }

        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsCommunityThirdStep.access$getViewModel$p(WidgetServerSettingsCommunityThirdStep.this).modifyGuildConfig(new AnonymousClass1());
        }
    }

    /* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityThirdStep$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded, Unit> {
        public AnonymousClass1(WidgetServerSettingsCommunityThirdStep widgetServerSettingsCommunityThirdStep) {
            super(1, widgetServerSettingsCommunityThirdStep, WidgetServerSettingsCommunityThirdStep.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "p1");
            WidgetServerSettingsCommunityThirdStep.access$configureUI((WidgetServerSettingsCommunityThirdStep) this.receiver, loaded);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityThirdStep$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<RenderContext, Unit> {
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
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(ColorCompat.getThemedColor(WidgetServerSettingsCommunityThirdStep.this.getContext(), R.attr.color_brand));
        }
    }

    /* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityThirdStep$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<RenderContext, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(ColorCompat.getThemedColor(WidgetServerSettingsCommunityThirdStep.this.getContext(), R.attr.color_brand));
        }
    }

    public WidgetServerSettingsCommunityThirdStep() {
        super(R.layout.widget_server_settings_community_setup_third_step);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsCommunityThirdStep2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new WidgetServerSettingsCommunityThirdStep$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetServerSettingsCommunityThirdStep3.INSTANCE));
        this.toastManager = new ToastManager();
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsCommunityThirdStep widgetServerSettingsCommunityThirdStep, WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
        widgetServerSettingsCommunityThirdStep.configureUI(loaded);
    }

    public static final /* synthetic */ WidgetServerSettingsCommunitySetupThirdStepBinding access$getBinding$p(WidgetServerSettingsCommunityThirdStep widgetServerSettingsCommunityThirdStep) {
        return widgetServerSettingsCommunityThirdStep.getBinding();
    }

    public static final /* synthetic */ ToastManager access$getToastManager$p(WidgetServerSettingsCommunityThirdStep widgetServerSettingsCommunityThirdStep) {
        return widgetServerSettingsCommunityThirdStep.toastManager;
    }

    public static final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel access$getViewModel$p(WidgetServerSettingsCommunityThirdStep widgetServerSettingsCommunityThirdStep) {
        return widgetServerSettingsCommunityThirdStep.getViewModel();
    }

    public static final /* synthetic */ void access$setToastManager$p(WidgetServerSettingsCommunityThirdStep widgetServerSettingsCommunityThirdStep, ToastManager toastManager) {
        widgetServerSettingsCommunityThirdStep.toastManager = toastManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void configureUI(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded viewState) {
        long permissions;
        CheckedSetting checkedSetting = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.communitySetting…ficationsToMentionsSwitch");
        checkedSetting.setChecked(viewState.getCommunityGuildConfig().getDefaultMessageNotifications());
        CheckedSetting checkedSetting2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.communitySettingManagePermissionsSwitch");
        checkedSetting2.setChecked(viewState.getCommunityGuildConfig().getEveryonePermissions());
        CheckedSetting checkedSetting3 = getBinding().f2556b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.communitySettingCommunityGuidelinesSwitch");
        checkedSetting3.setChecked(viewState.getCommunityGuildConfig().isPrivacyPolicyAccepted());
        Guild guild = viewState.getCommunityGuildConfig().getGuild();
        boolean z2 = false;
        boolean z3 = guild != null && guild.getDefaultMessageNotifications() == 1;
        Map<Long, GuildRole> roles = viewState.getCommunityGuildConfig().getRoles();
        if (roles == null) {
            permissions = 0;
        } else {
            Guild guild2 = viewState.getCommunityGuildConfig().getGuild();
            GuildRole guildRole = roles.get(guild2 != null ? Long.valueOf(guild2.getId()) : null);
            if (guildRole != null) {
                permissions = guildRole.getPermissions();
            }
        }
        long j = (-1116960071743L) & permissions;
        Map<Long, GuildRole> roles2 = viewState.getCommunityGuildConfig().getRoles();
        if (roles2 != null) {
            Guild guild3 = viewState.getCommunityGuildConfig().getGuild();
            GuildRole guildRole2 = roles2.get(guild3 != null ? Long.valueOf(guild3.getId()) : null);
            if (guildRole2 != null && j == guildRole2.getPermissions()) {
                z2 = true;
            }
        }
        getBinding().e.e(new AnonymousClass1(viewState, z3));
        getBinding().d.e(new AnonymousClass2(viewState, z2));
        getBinding().f2556b.e(new AnonymousClass3());
    }

    public static final void create(Context context) {
        INSTANCE.create(context);
    }

    private final WidgetServerSettingsCommunitySetupThirdStepBinding getBinding() {
        return (WidgetServerSettingsCommunitySetupThirdStepBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
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
        Observable observableG = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).y(WidgetServerSettingsCommunityThirdStep$onViewBoundOrOnResume$$inlined$filterIs$1.INSTANCE).G(WidgetServerSettingsCommunityThirdStep$onViewBoundOrOnResume$$inlined$filterIs$2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(observableG, WidgetServerSettingsCommunityThirdStep.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        CheckedSetting checkedSetting = getBinding().e;
        Context context = getContext();
        checkedSetting.setText(context != null ? FormatUtils.b(context, R.string.enable_community_modal_default_notifications_label_mobile, new Object[0], new AnonymousClass2()) : null);
        CheckedSetting checkedSetting2 = getBinding().d;
        Context context2 = getContext();
        checkedSetting2.setText(context2 != null ? FormatUtils.b(context2, R.string.enable_community_modal_everyone_role_permission_label_mobile, new Object[0], new AnonymousClass3()) : null);
        LinkifiedTextView linkifiedTextView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.communitySettingGuidelines");
        FormatUtils.n(linkifiedTextView, R.string.community_policy_help, new Object[]{AppHelpDesk.a.a(360035969312L, null)}, null, 4);
    }
}
