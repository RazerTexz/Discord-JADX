package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetStageChannelModeratorPermissionsBinding;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialog;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberSheet;
import com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* compiled from: WidgetStageChannelModeratorPermissions.kt */
/* loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetStageChannelModeratorPermissions.class, "viewBinding", "getViewBinding()Lcom/discord/databinding/WidgetStageChannelModeratorPermissionsBinding;", 0)};

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: viewBinding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate viewBinding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetStageChannelModeratorPermissions.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$configureUI$1 */
    public static final class ViewOnClickListenerC75611 implements View.OnClickListener {
        public final /* synthetic */ WidgetStageChannelModeratorPermissionsViewModel.ViewState $viewState;

        public ViewOnClickListenerC75611(WidgetStageChannelModeratorPermissionsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            boolean canEditModerators = ((WidgetStageChannelModeratorPermissionsViewModel.ViewState.Valid) this.$viewState).getCanEditModerators();
            if (!canEditModerators) {
                if (canEditModerators) {
                    return;
                }
                Toast.makeText(WidgetStageChannelModeratorPermissions.this.getContext(), C5419R.string.channel_permissions_cannot_edit_moderators, 0).show();
            } else {
                WidgetChannelSettingsAddMemberSheet.Companion companion = WidgetChannelSettingsAddMemberSheet.INSTANCE;
                FragmentManager parentFragmentManager = WidgetStageChannelModeratorPermissions.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, WidgetStageChannelModeratorPermissions.access$getChannelId$p(WidgetStageChannelModeratorPermissions.this));
            }
        }
    }

    /* compiled from: WidgetStageChannelModeratorPermissions.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$configureUI$2 */
    public static final /* synthetic */ class C75622 extends FunctionReferenceImpl implements Function1<PermissionOwner, Unit> {
        public C75622(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
            super(1, widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissions.class, "confirmRemoveModerator", "confirmRemoveModerator(Lcom/discord/widgets/channels/permissions/PermissionOwner;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PermissionOwner permissionOwner) {
            invoke2(permissionOwner);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PermissionOwner permissionOwner) {
            Intrinsics3.checkNotNullParameter(permissionOwner, "p1");
            WidgetStageChannelModeratorPermissions.access$confirmRemoveModerator((WidgetStageChannelModeratorPermissions) this.receiver, permissionOwner);
        }
    }

    /* compiled from: WidgetStageChannelModeratorPermissions.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$configureUI$3 */
    public static final /* synthetic */ class C75633 extends FunctionReferenceImpl implements Function1<PermissionOwner, Unit> {
        public C75633(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
            super(1, widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissions.class, "confirmRemoveModerator", "confirmRemoveModerator(Lcom/discord/widgets/channels/permissions/PermissionOwner;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PermissionOwner permissionOwner) {
            invoke2(permissionOwner);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PermissionOwner permissionOwner) {
            Intrinsics3.checkNotNullParameter(permissionOwner, "p1");
            WidgetStageChannelModeratorPermissions.access$confirmRemoveModerator((WidgetStageChannelModeratorPermissions) this.receiver, permissionOwner);
        }
    }

    /* compiled from: WidgetStageChannelModeratorPermissions.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissions$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C75641 extends FunctionReferenceImpl implements Function1<WidgetStageChannelModeratorPermissionsViewModel.ViewState, Unit> {
        public C75641(WidgetStageChannelModeratorPermissions widgetStageChannelModeratorPermissions) {
            super(1, widgetStageChannelModeratorPermissions, WidgetStageChannelModeratorPermissions.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/permissions/WidgetStageChannelModeratorPermissionsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetStageChannelModeratorPermissionsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetStageChannelModeratorPermissionsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetStageChannelModeratorPermissions.access$configureUI((WidgetStageChannelModeratorPermissions) this.receiver, viewState);
        }
    }

    public WidgetStageChannelModeratorPermissions() {
        super(C5419R.layout.widget_stage_channel_moderator_permissions);
        WidgetStageChannelModeratorPermissions4 widgetStageChannelModeratorPermissions4 = new WidgetStageChannelModeratorPermissions4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetStageChannelModeratorPermissionsViewModel.class), new C7560xfc95c629(appViewModelDelegates3), new AppViewModelDelegates5(widgetStageChannelModeratorPermissions4));
        this.channelId = LazyJVM.lazy(new WidgetStageChannelModeratorPermissions2(this));
        this.viewBinding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStageChannelModeratorPermissions3.INSTANCE, null, 2, null);
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
            AddPermissionOwnerView addPermissionOwnerView = getViewBinding().f18152b;
            Intrinsics3.checkNotNullExpressionValue(addPermissionOwnerView, "viewBinding.addPermissionOwnerButton");
            WidgetStageChannelModeratorPermissionsViewModel.ViewState.Valid valid = (WidgetStageChannelModeratorPermissionsViewModel.ViewState.Valid) viewState;
            ViewExtensions.setEnabledAlpha$default(addPermissionOwnerView, valid.getCanEditModerators(), 0.0f, 2, null);
            getViewBinding().f18152b.setOnClickListener(new ViewOnClickListenerC75611(viewState));
            getViewBinding().f18154d.setData(valid.getRoleItems(), new C75622(this));
            getViewBinding().f18153c.setData(valid.getMemberItems(), new C75633(this));
        }
    }

    private final void confirmRemoveModerator(PermissionOwner permissionOwner) {
        ConfirmRemovePermissionDialog.Companion companion = ConfirmRemovePermissionDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
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
        Observable<WidgetStageChannelModeratorPermissionsViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), WidgetStageChannelModeratorPermissions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C75641(this), 62, (Object) null);
    }
}
