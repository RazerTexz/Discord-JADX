package com.discord.widgets.settings.account;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetEnableSmsBackupDialogBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppToast;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* JADX INFO: compiled from: WidgetEnableSMSBackupDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEnableSMSBackupDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetEnableSMSBackupDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableSmsBackupDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_ENABLE = "extra_enable";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetEnableSMSBackupDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, boolean enable) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetEnableSMSBackupDialog widgetEnableSMSBackupDialog = new WidgetEnableSMSBackupDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean(WidgetEnableSMSBackupDialog.EXTRA_ENABLE, enable);
            widgetEnableSMSBackupDialog.setArguments(bundle);
            String tag = widgetEnableSMSBackupDialog.getTag();
            if (tag == null) {
                tag = "";
            }
            widgetEnableSMSBackupDialog.show(fragmentManager, tag);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog$enableSMSBackup$1 */
    /* JADX INFO: compiled from: WidgetEnableSMSBackupDialog.kt */
    public static final class C97131 extends Lambda implements Function1<Error, Unit> {
        public C97131() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetEnableSMSBackupDialog.access$getBinding$p(WidgetEnableSMSBackupDialog.this).f16595d.setIsLoading(false);
            View view = WidgetEnableSMSBackupDialog.this.getView();
            Context context = view != null ? view.getContext() : null;
            Error.Response response = error.getResponse();
            Intrinsics3.checkNotNullExpressionValue(response, "it.response");
            AppToast.m170h(context, response.getMessage(), 0, null, 12);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog$enableSMSBackup$2 */
    /* JADX INFO: compiled from: WidgetEnableSMSBackupDialog.kt */
    public static final class C97142 extends Lambda implements Function1<Void, Unit> {
        public C97142() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            StoreStream.INSTANCE.getMFA().togglingSMSBackup();
            WidgetEnableSMSBackupDialog.access$getBinding$p(WidgetEnableSMSBackupDialog.this).f16595d.setIsLoading(false);
            WidgetEnableSMSBackupDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog$onResume$1 */
    /* JADX INFO: compiled from: WidgetEnableSMSBackupDialog.kt */
    public static final class ViewOnClickListenerC97151 implements View.OnClickListener {
        public ViewOnClickListenerC97151() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEnableSMSBackupDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog$onResume$2 */
    /* JADX INFO: compiled from: WidgetEnableSMSBackupDialog.kt */
    public static final class ViewOnClickListenerC97162 implements View.OnClickListener {
        public final /* synthetic */ Boolean $enable;

        public ViewOnClickListenerC97162(Boolean bool) {
            this.$enable = bool;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEnableSMSBackupDialog.access$enableSMSBackup(WidgetEnableSMSBackupDialog.this, this.$enable.booleanValue());
        }
    }

    public WidgetEnableSMSBackupDialog() {
        super(C5419R.layout.widget_enable_sms_backup_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEnableSMSBackupDialog2.INSTANCE, null, 2, null);
        setCancelable(false);
    }

    public static final /* synthetic */ void access$enableSMSBackup(WidgetEnableSMSBackupDialog widgetEnableSMSBackupDialog, boolean z2) {
        widgetEnableSMSBackupDialog.enableSMSBackup(z2);
    }

    public static final /* synthetic */ WidgetEnableSmsBackupDialogBinding access$getBinding$p(WidgetEnableSMSBackupDialog widgetEnableSMSBackupDialog) {
        return widgetEnableSMSBackupDialog.getBinding();
    }

    private final void enableSMSBackup(boolean enable) {
        TextInputLayout textInputLayout = getBinding().f16597f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.enableSmsBackupPasswordWrap");
        RestAPIParams.ActivateMfaSMS activateMfaSMS = new RestAPIParams.ActivateMfaSMS(ViewExtensions.getTextOrEmpty(textInputLayout));
        Observable<Void> observableEnableMfaSMS = enable ? RestAPI.INSTANCE.getApi().enableMfaSMS(activateMfaSMS) : RestAPI.INSTANCE.getApi().disableMfaSMS(activateMfaSMS);
        getBinding().f16595d.setIsLoading(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableEnableMfaSMS, false, 1, null), this, null, 2, null), WidgetEnableSMSBackupDialog.class, (Context) null, (Function1) null, new C97131(), (Function0) null, (Function0) null, new C97142(), 54, (Object) null);
    }

    private final WidgetEnableSmsBackupDialogBinding getBinding() {
        return (WidgetEnableSmsBackupDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        AppDialog.hideKeyboard$default(this, null, 1, null);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Bundle arguments = getArguments();
        Boolean boolValueOf = arguments != null ? Boolean.valueOf(arguments.getBoolean(EXTRA_ENABLE)) : null;
        if (boolValueOf == null) {
            dismiss();
            return;
        }
        if (boolValueOf.booleanValue()) {
            TextView textView = getBinding().f16596e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.enableSmsBackupHeader");
            textView.setText(getString(C5419R.string.mfa_sms_enable));
            TextView textView2 = getBinding().f16593b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.enableSmsBackupBody");
            textView2.setText(getString(C5419R.string.mfa_sms_auth_sales_pitch));
            getBinding().f16595d.setText(getString(C5419R.string.enable));
        } else {
            TextView textView3 = getBinding().f16596e;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.enableSmsBackupHeader");
            textView3.setText(getString(C5419R.string.mfa_sms_remove));
            TextView textView4 = getBinding().f16593b;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.enableSmsBackupBody");
            textView4.setText(getString(C5419R.string.mfa_sms_confirm_remove_body));
            getBinding().f16595d.setText(getString(C5419R.string.disable));
        }
        getBinding().f16594c.setOnClickListener(new ViewOnClickListenerC97151());
        getBinding().f16595d.setIsLoading(false);
        getBinding().f16595d.setOnClickListener(new ViewOnClickListenerC97162(boolValueOf));
    }
}
