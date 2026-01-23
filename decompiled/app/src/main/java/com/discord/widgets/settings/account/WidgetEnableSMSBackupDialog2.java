package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetEnableSmsBackupDialogBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetEnableSMSBackupDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableSMSBackupDialog2 extends FunctionReferenceImpl implements Function1<View, WidgetEnableSmsBackupDialogBinding> {
    public static final WidgetEnableSMSBackupDialog2 INSTANCE = new WidgetEnableSMSBackupDialog2();

    public WidgetEnableSMSBackupDialog2() {
        super(1, WidgetEnableSmsBackupDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableSmsBackupDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetEnableSmsBackupDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetEnableSmsBackupDialogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.enable_sms_backup_body;
        TextView textView = (TextView) view.findViewById(C5419R.id.enable_sms_backup_body);
        if (textView != null) {
            i = C5419R.id.enable_sms_backup_cancel;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.enable_sms_backup_cancel);
            if (materialButton != null) {
                i = C5419R.id.enable_sms_backup_confirm;
                LoadingButton loadingButton = (LoadingButton) view.findViewById(C5419R.id.enable_sms_backup_confirm);
                if (loadingButton != null) {
                    i = C5419R.id.enable_sms_backup_header;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.enable_sms_backup_header);
                    if (textView2 != null) {
                        i = C5419R.id.enable_sms_backup_password_wrap;
                        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.enable_sms_backup_password_wrap);
                        if (textInputLayout != null) {
                            i = C5419R.id.notice_header_container;
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.notice_header_container);
                            if (linearLayout != null) {
                                return new WidgetEnableSmsBackupDialogBinding((LinearLayout) view, textView, materialButton, loadingButton, textView2, textInputLayout, linearLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
