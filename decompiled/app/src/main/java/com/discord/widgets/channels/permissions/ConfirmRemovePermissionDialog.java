package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.ConfirmRemovePermissionDialogBinding;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialogViewModel;
import com.discord.widgets.channels.permissions.PermissionOwner;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: ConfirmRemovePermissionDialog.kt */
/* loaded from: classes2.dex */
public final class ConfirmRemovePermissionDialog extends AppDialog {
    private static final String ARG_PERMISSION_OWNER = "ARG_PERMISSION_OWNER";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(ConfirmRemovePermissionDialog.class, "binding", "getBinding()Lcom/discord/databinding/ConfirmRemovePermissionDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: ConfirmRemovePermissionDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(PermissionOwner permissionOwner, long channelId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(permissionOwner, "permissionOwner");
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            ConfirmRemovePermissionDialog confirmRemovePermissionDialog = new ConfirmRemovePermissionDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable(ConfirmRemovePermissionDialog.ARG_PERMISSION_OWNER, permissionOwner);
            bundle.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            confirmRemovePermissionDialog.setArguments(bundle);
            confirmRemovePermissionDialog.show(fragmentManager, ConfirmRemovePermissionDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ConfirmRemovePermissionDialog.kt */
    /* renamed from: com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialog$onResume$1 */
    public static final class C75191 extends Lambda implements Function1<ConfirmRemovePermissionDialogViewModel.ViewState, Unit> {
        public C75191() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ConfirmRemovePermissionDialogViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ConfirmRemovePermissionDialogViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            ConfirmRemovePermissionDialog.access$configureUI(ConfirmRemovePermissionDialog.this, viewState);
        }
    }

    /* compiled from: ConfirmRemovePermissionDialog.kt */
    /* renamed from: com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialog$onResume$2 */
    public static final class ViewOnClickListenerC75202 implements View.OnClickListener {
        public ViewOnClickListenerC75202() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ConfirmRemovePermissionDialog.access$getViewModel$p(ConfirmRemovePermissionDialog.this).submit();
        }
    }

    /* compiled from: ConfirmRemovePermissionDialog.kt */
    /* renamed from: com.discord.widgets.channels.permissions.ConfirmRemovePermissionDialog$onResume$3 */
    public static final class ViewOnClickListenerC75213 implements View.OnClickListener {
        public ViewOnClickListenerC75213() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ConfirmRemovePermissionDialog.this.dismiss();
        }
    }

    public ConfirmRemovePermissionDialog() {
        super(C5419R.layout.confirm_remove_permission_dialog);
        ConfirmRemovePermissionDialog3 confirmRemovePermissionDialog3 = new ConfirmRemovePermissionDialog3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ConfirmRemovePermissionDialogViewModel.class), new C7518x3593037c(appViewModelDelegates3), new AppViewModelDelegates5(confirmRemovePermissionDialog3));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, ConfirmRemovePermissionDialog2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(ConfirmRemovePermissionDialog confirmRemovePermissionDialog, ConfirmRemovePermissionDialogViewModel.ViewState viewState) {
        confirmRemovePermissionDialog.configureUI(viewState);
    }

    public static final /* synthetic */ long access$getChannelIdFromArgs(ConfirmRemovePermissionDialog confirmRemovePermissionDialog) {
        return confirmRemovePermissionDialog.getChannelIdFromArgs();
    }

    public static final /* synthetic */ PermissionOwner access$getPermissionOwnerFromArgs(ConfirmRemovePermissionDialog confirmRemovePermissionDialog) {
        return confirmRemovePermissionDialog.getPermissionOwnerFromArgs();
    }

    public static final /* synthetic */ ConfirmRemovePermissionDialogViewModel access$getViewModel$p(ConfirmRemovePermissionDialog confirmRemovePermissionDialog) {
        return confirmRemovePermissionDialog.getViewModel();
    }

    private final void configureUI(ConfirmRemovePermissionDialogViewModel.ViewState viewState) {
        Unit unit;
        if (viewState instanceof ConfirmRemovePermissionDialogViewModel.ViewState.Default) {
            getBinding().f15024d.setIsLoading(((ConfirmRemovePermissionDialogViewModel.ViewState.Default) viewState).isSubmitting());
            unit = Unit.f27425a;
        } else {
            if (!Intrinsics3.areEqual(viewState, ConfirmRemovePermissionDialogViewModel.ViewState.Complete.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            dismiss();
            unit = Unit.f27425a;
        }
        KotlinExtensions.getExhaustive(unit);
    }

    private final ConfirmRemovePermissionDialogBinding getBinding() {
        return (ConfirmRemovePermissionDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelIdFromArgs() {
        return requireArguments().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID");
    }

    private final PermissionOwner getPermissionOwnerFromArgs() {
        Serializable serializable = requireArguments().getSerializable(ARG_PERMISSION_OWNER);
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.widgets.channels.permissions.PermissionOwner");
        return (PermissionOwner) serializable;
    }

    private final ConfirmRemovePermissionDialogViewModel getViewModel() {
        return (ConfirmRemovePermissionDialogViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        String username;
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), ConfirmRemovePermissionDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C75191(), 62, (Object) null);
        PermissionOwner permissionOwnerFromArgs = getPermissionOwnerFromArgs();
        if (permissionOwnerFromArgs instanceof PermissionOwner.Role) {
            username = ((PermissionOwner.Role) permissionOwnerFromArgs).getRole().getName();
        } else {
            if (!(permissionOwnerFromArgs instanceof PermissionOwner.Member)) {
                throw new NoWhenBranchMatchedException();
            }
            PermissionOwner.Member member = (PermissionOwner.Member) permissionOwnerFromArgs;
            String nickname = member.getNickname();
            username = nickname != null ? nickname : member.getUser().getUsername();
        }
        TextView textView = getBinding().f15022b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.body");
        FormatUtils.m222n(textView, C5419R.string.settings_permissions_delete_body, new Object[]{username}, null, 4);
        getBinding().f15024d.setOnClickListener(new ViewOnClickListenerC75202());
        getBinding().f15023c.setOnClickListener(new ViewOnClickListenerC75213());
    }
}
