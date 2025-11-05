package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetStageChannelModeratorPermissionsBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialog;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberSheet;
import com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel;
import d0.g;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetStageChannelModeratorPermissions.kt */
/* loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetStageChannelModeratorPermissions.class, "viewBinding", "getViewBinding()Lcom/discord/databinding/WidgetStageChannelModeratorPermissionsBinding;", 0)};

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: viewBinding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate viewBinding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetStageChannelModeratorPermissions.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetStageChannelModeratorPermissionsViewModel.ViewState $viewState;

        public AnonymousClass1(WidgetStageChannelModeratorPermissionsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            boolean canEditModerators = ((WidgetStageChannelModeratorPermissionsViewModel.ViewState.Valid) this.$viewState).getCanEditModerators();
            if (!canEditModerators) {
                if (canEditModerators) {
                    return;
                }
                Toast.makeText(WidgetStageChannelModeratorPermissions.this.getContext(), R.string.channel_permissions_cannot_edit_moderators, 0).show();
            } else {
                WidgetChannelSettingsAddMemberSheet.Companion companion = WidgetChannelSettingsAddMemberSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetStageChannelModeratorPermissions.this.getParentFragmentManager();
                m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, WidgetStageChannelModeratorPermissions.access$getChannelId$p(WidgetStageChannelModeratorPermissions.this));
            }
        }
    }

    /* compiled from: WidgetStageChannelModeratorPermissions.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$configureUI$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<PermissionOwner, Unit> {
        public AnonymousClass2(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
            super(1, widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissions.class, "confirmRemoveModerator", "confirmRemoveModerator(Lcom/discord/widgets/channels/permissions/PermissionOwner;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PermissionOwner permissionOwner) {
            invoke2(permissionOwner);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PermissionOwner permissionOwner) {
            m.checkNotNullParameter(permissionOwner, "p1");
            WidgetStageChannelModeratorPermissions.access$confirmRemoveModerator((WidgetStageChannelModeratorPermissions) this.receiver, permissionOwner);
        }
    }

    /* compiled from: WidgetStageChannelModeratorPermissions.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$configureUI$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends k implements Function1<PermissionOwner, Unit> {
        public AnonymousClass3(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
            super(1, widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissions.class, "confirmRemoveModerator", "confirmRemoveModerator(Lcom/discord/widgets/channels/permissions/PermissionOwner;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PermissionOwner permissionOwner) {
            invoke2(permissionOwner);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PermissionOwner permissionOwner) {
            m.checkNotNullParameter(permissionOwner, "p1");
            WidgetStageChannelModeratorPermissions.access$confirmRemoveModerator((WidgetStageChannelModeratorPermissions) this.receiver, permissionOwner);
        }
    }

    /* compiled from: WidgetStageChannelModeratorPermissions.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<WidgetStageChannelModeratorPermissionsViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
            super(1, widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissions.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetStageChannelModeratorPermissionsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetStageChannelModeratorPermissionsViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetStageChannelModeratorPermissions.access$configureUI((WidgetStageChannelModeratorPermissions) this.receiver, viewState);
        }
    }

    public WidgetStageChannelModeratorPermissions() {
        super(R.layout.widget_stage_channel_moderator_permissions);
        WidgetStageChannelModeratorPermissions$viewModel$2 widgetStageChannelModeratorPermissions$viewModel$2 = new WidgetStageChannelModeratorPermissions$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetStageChannelModeratorPermissionsViewModel.class), new WidgetStageChannelModeratorPermissions$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetStageChannelModeratorPermissions$viewModel$2));
        this.channelId = g.lazy(new WidgetStageChannelModeratorPermissions$channelId$2(this));
        this.viewBinding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetStageChannelModeratorPermissions$viewBinding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissionsViewModel.ViewState viewState) {
        widgetStageChannelModeratorPermissions.configureUI(viewState);
    }

    public static final /* synthetic */ void access$confirmRemoveModerator(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions, PermissionOwner permissionOwner) {
        widgetStageChannelModeratorPermissions.confirmRemoveModerator(permissionOwner);
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
        return widgetStageChannelModeratorPermissions.getChannelId();
    }

    private final void configureUI(WidgetStageChannelModeratorPermissionsViewModel.ViewState viewState) {
        if (viewState instanceof WidgetStageChannelModeratorPermissionsViewModel.ViewState.Valid) {
            AddPermissionOwnerView addPermissionOwnerView = getViewBinding().f2652b;
            m.checkNotNullExpressionValue(addPermissionOwnerView, "viewBinding.addPermissionOwnerButton");
            WidgetStageChannelModeratorPermissionsViewModel.ViewState.Valid valid = (WidgetStageChannelModeratorPermissionsViewModel.ViewState.Valid) viewState;
            ViewExtensions.setEnabledAlpha$default(addPermissionOwnerView, valid.getCanEditModerators(), 0.0f, 2, null);
            getViewBinding().f2652b.setOnClickListener(new AnonymousClass1(viewState));
            getViewBinding().d.setData(valid.getRoleItems(), new AnonymousClass2(this));
            getViewBinding().c.setData(valid.getMemberItems(), new AnonymousClass3(this));
        }
    }

    private final void confirmRemoveModerator(PermissionOwner permissionOwner) {
        ConfirmRemovePermissionDialog.Companion companion = ConfirmRemovePermissionDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(permissionOwner, getChannelId(), parentFragmentManager);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final WidgetStageChannelModeratorPermissionsBinding getViewBinding() {
        return (WidgetStageChannelModeratorPermissionsBinding) this.viewBinding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetStageChannelModeratorPermissionsViewModel getViewModel() {
        return (WidgetStageChannelModeratorPermissionsViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetStageChannelModeratorPermissionsViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetStageChannelModeratorPermissions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
