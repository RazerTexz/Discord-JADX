package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.role.GuildRole;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsCommunitySetupThirdStepBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.guild.Guild;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.ToastManager;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppHelpDesk;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates2;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityThirdStep extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerSettingsCommunityThirdStep.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCommunitySetupThirdStepBinding;", 0)};

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
            AppScreen2.m156d(context, WidgetServerSettingsCommunityThirdStep.class, new Intent());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityThirdStep$configureUI$1 */
    public static final class ViewOnClickListenerC93841 implements View.OnClickListener {
        public final /* synthetic */ boolean $guildDefaultMessageNotifications;
        public final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded $viewState;

        /* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
        /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityThirdStep$configureUI$1$1, reason: invalid class name */
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
                Intrinsics3.checkNotNullExpressionValue(WidgetServerSettingsCommunityThirdStep.access$getBinding$p(WidgetServerSettingsCommunityThirdStep.this).f17591e, "binding.communitySetting…ficationsToMentionsSwitch");
                return WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig.copy$default(communityGuildConfig, null, null, null, null, false, !r2.isChecked(), false, false, null, false, null, null, 4063, null);
            }
        }

        public ViewOnClickListenerC93841(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded, boolean z2) {
            this.$viewState = loaded;
            this.$guildDefaultMessageNotifications = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$viewState.getCommunityGuildConfig().getDefaultMessageNotifications() && this.$guildDefaultMessageNotifications) {
                AppToast.m166d(WidgetServerSettingsCommunityThirdStep.this.getContext(), C5419R.string.enable_community_modal_requirement_satisfied_tooltip, 0, WidgetServerSettingsCommunityThirdStep.access$getToastManager$p(WidgetServerSettingsCommunityThirdStep.this));
            } else {
                WidgetServerSettingsCommunityThirdStep.access$getViewModel$p(WidgetServerSettingsCommunityThirdStep.this).modifyGuildConfig(new AnonymousClass1());
            }
        }
    }

    /* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityThirdStep$configureUI$2 */
    public static final class ViewOnClickListenerC93852 implements View.OnClickListener {
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
                Intrinsics3.checkNotNullExpressionValue(WidgetServerSettingsCommunityThirdStep.access$getBinding$p(WidgetServerSettingsCommunityThirdStep.this).f17590d, "binding.communitySettingManagePermissionsSwitch");
                return WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig.copy$default(communityGuildConfig, null, null, null, null, false, false, false, false, null, !r2.isChecked(), null, null, 3583, null);
            }
        }

        public ViewOnClickListenerC93852(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded, boolean z2) {
            this.$viewState = loaded;
            this.$guildEveryonePermissions = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$viewState.getCommunityGuildConfig().getEveryonePermissions() && this.$guildEveryonePermissions) {
                AppToast.m166d(WidgetServerSettingsCommunityThirdStep.this.getContext(), C5419R.string.enable_community_modal_requirement_satisfied_tooltip, 0, WidgetServerSettingsCommunityThirdStep.access$getToastManager$p(WidgetServerSettingsCommunityThirdStep.this));
            } else {
                WidgetServerSettingsCommunityThirdStep.access$getViewModel$p(WidgetServerSettingsCommunityThirdStep.this).modifyGuildConfig(new AnonymousClass1());
            }
        }
    }

    /* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityThirdStep$configureUI$3 */
    public static final class ViewOnClickListenerC93863 implements View.OnClickListener {

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
                Intrinsics3.checkNotNullExpressionValue(WidgetServerSettingsCommunityThirdStep.access$getBinding$p(WidgetServerSettingsCommunityThirdStep.this).f17588b, "binding.communitySettingCommunityGuidelinesSwitch");
                return WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig.copy$default(communityGuildConfig, null, null, null, null, !r2.isChecked(), false, false, false, null, false, null, null, 4079, null);
            }
        }

        public ViewOnClickListenerC93863() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsCommunityThirdStep.access$getViewModel$p(WidgetServerSettingsCommunityThirdStep.this).modifyGuildConfig(new AnonymousClass1());
        }
    }

    /* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityThirdStep$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C93891 extends FunctionReferenceImpl implements Function1<WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded, Unit> {
        public C93891(WidgetServerSettingsCommunityThirdStep widgetServerSettingsCommunityThirdStep) {
            super(1, widgetServerSettingsCommunityThirdStep, WidgetServerSettingsCommunityThirdStep.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "p1");
            WidgetServerSettingsCommunityThirdStep.access$configureUI((WidgetServerSettingsCommunityThirdStep) this.receiver, loaded);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityThirdStep$onViewBoundOrOnResume$2 */
    public static final class C93902 extends Lambda implements Function1<RenderContext, Unit> {
        public C93902() {
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
            renderContext.boldColor = Integer.valueOf(ColorCompat.getThemedColor(WidgetServerSettingsCommunityThirdStep.this.getContext(), C5419R.attr.color_brand));
        }
    }

    /* compiled from: WidgetServerSettingsCommunityThirdStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityThirdStep$onViewBoundOrOnResume$3 */
    public static final class C93913 extends Lambda implements Function1<RenderContext, Unit> {
        public C93913() {
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
            renderContext.boldColor = Integer.valueOf(ColorCompat.getThemedColor(WidgetServerSettingsCommunityThirdStep.this.getContext(), C5419R.attr.color_brand));
        }
    }

    public WidgetServerSettingsCommunityThirdStep() {
        super(C5419R.layout.widget_server_settings_community_setup_third_step);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsCommunityThirdStep2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new C9382xc0ca0f13(this), new AppViewModelDelegates2(WidgetServerSettingsCommunityThirdStep3.INSTANCE));
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
        CheckedSetting checkedSetting = getBinding().f17591e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.communitySetting…ficationsToMentionsSwitch");
        checkedSetting.setChecked(viewState.getCommunityGuildConfig().getDefaultMessageNotifications());
        CheckedSetting checkedSetting2 = getBinding().f17590d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.communitySettingManagePermissionsSwitch");
        checkedSetting2.setChecked(viewState.getCommunityGuildConfig().getEveryonePermissions());
        CheckedSetting checkedSetting3 = getBinding().f17588b;
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
        getBinding().f17591e.m8527e(new ViewOnClickListenerC93841(viewState, z3));
        getBinding().f17590d.m8527e(new ViewOnClickListenerC93852(viewState, z2));
        getBinding().f17588b.m8527e(new ViewOnClickListenerC93863());
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
        Observable observableM11083G = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).m11118y(C9387x1cd57661.INSTANCE).m11083G(C9388x1cd57662.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(observableM11083G, WidgetServerSettingsCommunityThirdStep.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C93891(this), 62, (Object) null);
        CheckedSetting checkedSetting = getBinding().f17591e;
        Context context = getContext();
        checkedSetting.setText(context != null ? FormatUtils.m210b(context, C5419R.string.enable_community_modal_default_notifications_label_mobile, new Object[0], new C93902()) : null);
        CheckedSetting checkedSetting2 = getBinding().f17590d;
        Context context2 = getContext();
        checkedSetting2.setText(context2 != null ? FormatUtils.m210b(context2, C5419R.string.enable_community_modal_everyone_role_permission_label_mobile, new Object[0], new C93913()) : null);
        LinkifiedTextView linkifiedTextView = getBinding().f17589c;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.communitySettingGuidelines");
        FormatUtils.m222n(linkifiedTextView, C5419R.string.community_policy_help, new Object[]{AppHelpDesk.f507a.m149a(360035969312L, null)}, null, 4);
    }
}
