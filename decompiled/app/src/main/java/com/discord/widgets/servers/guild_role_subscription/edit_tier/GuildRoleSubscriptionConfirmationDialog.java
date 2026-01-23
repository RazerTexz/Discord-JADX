package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.app.Dialog;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.DialogGuiildRoleSubscriptionConfirmationBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: GuildRoleSubscriptionConfirmationDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionConfirmationDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(GuildRoleSubscriptionConfirmationDialog.class, "binding", "getBinding()Lcom/discord/databinding/DialogGuiildRoleSubscriptionConfirmationBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CONFIRMATION_BUTTON_TEXT = "INTENT_EXTRA_CONFIRMATION_BUTTON_TEXT";
    private static final String INTENT_EXTRA_IS_DESTRUCTIVE_OPERATION = "INTENT_EXTRA_IS_DESTRUCTIVE_OPERATION";
    private static final String INTENT_EXTRA_SUBTITLE = "INTENT_EXTRA_SUBTITLE";
    private static final String INTENT_EXTRA_TITLE = "INTENT_EXTRA_TITLE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function0<Unit> confirmCallback;

    /* JADX INFO: compiled from: GuildRoleSubscriptionConfirmationDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, String str, String str2, String str3, boolean z2, Function0 function0, int i, Object obj) {
            companion.show(fragmentManager, str, str2, str3, (i & 16) != 0 ? false : z2, function0);
        }

        public final void show(FragmentManager fragmentManager, String title, String subtitle, String confirmationButtonText, boolean isDestructiveOperation, Function0<Unit> confirmCallback) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(title, "title");
            Intrinsics3.checkNotNullParameter(subtitle, "subtitle");
            Intrinsics3.checkNotNullParameter(confirmationButtonText, "confirmationButtonText");
            Intrinsics3.checkNotNullParameter(confirmCallback, "confirmCallback");
            GuildRoleSubscriptionConfirmationDialog guildRoleSubscriptionConfirmationDialog = new GuildRoleSubscriptionConfirmationDialog();
            guildRoleSubscriptionConfirmationDialog.setConfirmCallback(confirmCallback);
            guildRoleSubscriptionConfirmationDialog.setArguments(Bundle2.bundleOf(Tuples.m10073to(GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_TITLE, title), Tuples.m10073to(GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_SUBTITLE, subtitle), Tuples.m10073to(GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_CONFIRMATION_BUTTON_TEXT, confirmationButtonText), Tuples.m10073to(GuildRoleSubscriptionConfirmationDialog.INTENT_EXTRA_IS_DESTRUCTIVE_OPERATION, Boolean.valueOf(isDestructiveOperation))));
            guildRoleSubscriptionConfirmationDialog.show(fragmentManager, GuildRoleSubscriptionConfirmationDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.GuildRoleSubscriptionConfirmationDialog$onViewBound$1 */
    /* JADX INFO: compiled from: GuildRoleSubscriptionConfirmationDialog.kt */
    public static final class ViewOnClickListenerC94651 implements View.OnClickListener {
        public ViewOnClickListenerC94651() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0Access$getConfirmCallback$p = GuildRoleSubscriptionConfirmationDialog.access$getConfirmCallback$p(GuildRoleSubscriptionConfirmationDialog.this);
            if (function0Access$getConfirmCallback$p != null) {
            }
            GuildRoleSubscriptionConfirmationDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.GuildRoleSubscriptionConfirmationDialog$onViewBound$2 */
    /* JADX INFO: compiled from: GuildRoleSubscriptionConfirmationDialog.kt */
    public static final class ViewOnClickListenerC94662 implements View.OnClickListener {
        public ViewOnClickListenerC94662() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildRoleSubscriptionConfirmationDialog.this.dismiss();
        }
    }

    public GuildRoleSubscriptionConfirmationDialog() {
        super(C5419R.layout.dialog_guiild_role_subscription_confirmation);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, GuildRoleSubscriptionConfirmationDialog2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ Function0 access$getConfirmCallback$p(GuildRoleSubscriptionConfirmationDialog guildRoleSubscriptionConfirmationDialog) {
        return guildRoleSubscriptionConfirmationDialog.confirmCallback;
    }

    public static final /* synthetic */ void access$setConfirmCallback$p(GuildRoleSubscriptionConfirmationDialog guildRoleSubscriptionConfirmationDialog, Function0 function0) {
        guildRoleSubscriptionConfirmationDialog.confirmCallback = function0;
    }

    private final DialogGuiildRoleSubscriptionConfirmationBinding getBinding() {
        return (DialogGuiildRoleSubscriptionConfirmationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getConfirmationButtonText() {
        String string = requireArguments().getString(INTENT_EXTRA_CONFIRMATION_BUTTON_TEXT, "");
        Intrinsics3.checkNotNullExpressionValue(string, "requireArguments().getSt…IRMATION_BUTTON_TEXT, \"\")");
        return string;
    }

    private final String getSubtitle() {
        String string = requireArguments().getString(INTENT_EXTRA_SUBTITLE, "");
        Intrinsics3.checkNotNullExpressionValue(string, "requireArguments().getSt…NTENT_EXTRA_SUBTITLE, \"\")");
        return string;
    }

    private final String getTitle() {
        String string = requireArguments().getString(INTENT_EXTRA_TITLE, "");
        Intrinsics3.checkNotNullExpressionValue(string, "requireArguments().getSt…g(INTENT_EXTRA_TITLE, \"\")");
        return string;
    }

    private final boolean isDestructiveOperation() {
        return requireArguments().getBoolean(INTENT_EXTRA_IS_DESTRUCTIVE_OPERATION);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Dialog dialogRequireDialog = requireDialog();
        Intrinsics3.checkNotNullExpressionValue(dialogRequireDialog, "requireDialog()");
        Window window = dialogRequireDialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
        }
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (this.confirmCallback == null) {
            dismiss();
            return;
        }
        requireDialog().setCanceledOnTouchOutside(true);
        getBinding().f15036c.setOnClickListener(new ViewOnClickListenerC94651());
        getBinding().f15035b.setOnClickListener(new ViewOnClickListenerC94662());
        TextView textView = getBinding().f15038e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionConfirmationTitle");
        textView.setText(getTitle());
        TextView textView2 = getBinding().f15037d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionConfirmationSubtitle");
        textView2.setText(getSubtitle());
        if (isDestructiveOperation()) {
            MaterialButton materialButton = getBinding().f15036c;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "this");
            materialButton.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(materialButton, C5419R.color.uikit_btn_bg_color_selector_red)));
            materialButton.setTextColor(ColorCompat.getColor(materialButton, C5419R.color.primary_100));
        }
        MaterialButton materialButton2 = getBinding().f15036c;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.confirm");
        materialButton2.setText(getConfirmationButtonText());
    }

    public final void setConfirmCallback(Function0<Unit> callback) {
        Intrinsics3.checkNotNullParameter(callback, "callback");
        this.confirmCallback = callback;
    }
}
