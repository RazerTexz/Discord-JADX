package com.discord.widgets.settings.account;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetEnableSmsBackupDialogBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetEnableSMSBackupDialog.kt */
/* loaded from: classes2.dex */
public final class WidgetEnableSMSBackupDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetEnableSMSBackupDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEnableSmsBackupDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_ENABLE = "extra_enable";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetEnableSMSBackupDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, boolean enable) {
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
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

    /* compiled from: WidgetEnableSMSBackupDialog.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog$enableSMSBackup$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "it");
            WidgetEnableSMSBackupDialog.access$getBinding$p(WidgetEnableSMSBackupDialog.this).d.setIsLoading(false);
            View view = WidgetEnableSMSBackupDialog.this.getView();
            Context context = view != null ? view.getContext() : null;
            Error.Response response = error.getResponse();
            m.checkNotNullExpressionValue(response, "it.response");
            b.a.d.m.h(context, response.getMessage(), 0, null, 12);
        }
    }

    /* compiled from: WidgetEnableSMSBackupDialog.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog$enableSMSBackup$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Void, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            StoreStream.INSTANCE.getMFA().togglingSMSBackup();
            WidgetEnableSMSBackupDialog.access$getBinding$p(WidgetEnableSMSBackupDialog.this).d.setIsLoading(false);
            WidgetEnableSMSBackupDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetEnableSMSBackupDialog.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEnableSMSBackupDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetEnableSMSBackupDialog.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Boolean $enable;

        public AnonymousClass2(Boolean bool) {
            this.$enable = bool;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEnableSMSBackupDialog.access$enableSMSBackup(WidgetEnableSMSBackupDialog.this, this.$enable.booleanValue());
        }
    }

    public WidgetEnableSMSBackupDialog() {
        super(R.layout.widget_enable_sms_backup_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEnableSMSBackupDialog$binding$2.INSTANCE, null, 2, null);
        setCancelable(false);
    }

    public static final /* synthetic */ void access$enableSMSBackup(WidgetEnableSMSBackupDialog widgetEnableSMSBackupDialog, boolean z2) {
        widgetEnableSMSBackupDialog.enableSMSBackup(z2);
    }

    public static final /* synthetic */ WidgetEnableSmsBackupDialogBinding access$getBinding$p(WidgetEnableSMSBackupDialog widgetEnableSMSBackupDialog) {
        return widgetEnableSMSBackupDialog.getBinding();
    }

    private final void enableSMSBackup(boolean enable) {
        TextInputLayout textInputLayout = getBinding().f;
        m.checkNotNullExpressionValue(textInputLayout, "binding.enableSmsBackupPasswordWrap");
        RestAPIParams.ActivateMfaSMS activateMfaSMS = new RestAPIParams.ActivateMfaSMS(ViewExtensions.getTextOrEmpty(textInputLayout));
        Observable<Void> observableEnableMfaSMS = enable ? RestAPI.INSTANCE.getApi().enableMfaSMS(activateMfaSMS) : RestAPI.INSTANCE.getApi().disableMfaSMS(activateMfaSMS);
        getBinding().d.setIsLoading(true);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(observableEnableMfaSMS, false, 1, null), this, null, 2, null), WidgetEnableSMSBackupDialog.class, (Context) null, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
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
            TextView textView = getBinding().e;
            m.checkNotNullExpressionValue(textView, "binding.enableSmsBackupHeader");
            textView.setText(getString(R.string.mfa_sms_enable));
            TextView textView2 = getBinding().f2381b;
            m.checkNotNullExpressionValue(textView2, "binding.enableSmsBackupBody");
            textView2.setText(getString(R.string.mfa_sms_auth_sales_pitch));
            getBinding().d.setText(getString(R.string.enable));
        } else {
            TextView textView3 = getBinding().e;
            m.checkNotNullExpressionValue(textView3, "binding.enableSmsBackupHeader");
            textView3.setText(getString(R.string.mfa_sms_remove));
            TextView textView4 = getBinding().f2381b;
            m.checkNotNullExpressionValue(textView4, "binding.enableSmsBackupBody");
            textView4.setText(getString(R.string.mfa_sms_confirm_remove_body));
            getBinding().d.setText(getString(R.string.disable));
        }
        getBinding().c.setOnClickListener(new AnonymousClass1());
        getBinding().d.setIsLoading(false);
        getBinding().d.setOnClickListener(new AnonymousClass2(boolValueOf));
    }
}
