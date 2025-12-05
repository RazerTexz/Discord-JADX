package com.discord.widgets.servers.community;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetConfirmRemoveCommunityDialogBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetConfirmRemoveCommunityDialog.kt */
/* loaded from: classes2.dex */
public final class WidgetConfirmRemoveCommunityDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetConfirmRemoveCommunityDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetConfirmRemoveCommunityDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetConfirmRemoveCommunityDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager supportFragmentManager, long guildId) {
            Intrinsics3.checkNotNullParameter(supportFragmentManager, "supportFragmentManager");
            WidgetConfirmRemoveCommunityDialog widgetConfirmRemoveCommunityDialog = new WidgetConfirmRemoveCommunityDialog();
            Bundle bundle = new Bundle();
            bundle.putLong("INTENT_EXTRA_GUILD_ID", guildId);
            widgetConfirmRemoveCommunityDialog.setArguments(bundle);
            widgetConfirmRemoveCommunityDialog.show(supportFragmentManager, WidgetConfirmRemoveCommunityDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetConfirmRemoveCommunityDialog.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetConfirmRemoveCommunityDialog$onViewBound$1 */
    public static final class ViewOnClickListenerC93491 implements View.OnClickListener {
        public ViewOnClickListenerC93491() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetConfirmRemoveCommunityDialog.this.dismiss();
            WidgetConfirmRemoveCommunityDialog.access$getViewModel$p(WidgetConfirmRemoveCommunityDialog.this).disableCommunity();
        }
    }

    /* compiled from: WidgetConfirmRemoveCommunityDialog.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetConfirmRemoveCommunityDialog$onViewBound$2 */
    public static final class ViewOnClickListenerC93502 implements View.OnClickListener {
        public ViewOnClickListenerC93502() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetConfirmRemoveCommunityDialog.this.dismiss();
        }
    }

    public WidgetConfirmRemoveCommunityDialog() {
        super(C5419R.layout.widget_confirm_remove_community_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetConfirmRemoveCommunityDialog2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetServerSettingsCommunityOverviewViewModel.class), new C9347xb86cad10(this), new AppViewModelDelegates2(new WidgetConfirmRemoveCommunityDialog3(this)));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetConfirmRemoveCommunityDialog widgetConfirmRemoveCommunityDialog) {
        return widgetConfirmRemoveCommunityDialog.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel access$getViewModel$p(WidgetConfirmRemoveCommunityDialog widgetConfirmRemoveCommunityDialog) {
        return widgetConfirmRemoveCommunityDialog.getViewModel();
    }

    private final WidgetConfirmRemoveCommunityDialogBinding getBinding() {
        return (WidgetConfirmRemoveCommunityDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsCommunityOverviewViewModel getViewModel() {
        return (WidgetServerSettingsCommunityOverviewViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f16404c.setOnClickListener(new ViewOnClickListenerC93491());
        getBinding().f16403b.setOnClickListener(new ViewOnClickListenerC93502());
    }
}
