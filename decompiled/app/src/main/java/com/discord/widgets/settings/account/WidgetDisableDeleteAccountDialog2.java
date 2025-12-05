package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetDisableDeleteAccountDialogBinding;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetDisableDeleteAccountDialog.kt */
/* renamed from: com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetDisableDeleteAccountDialog2 extends FunctionReferenceImpl implements Function1<View, WidgetDisableDeleteAccountDialogBinding> {
    public static final WidgetDisableDeleteAccountDialog2 INSTANCE = new WidgetDisableDeleteAccountDialog2();

    public WidgetDisableDeleteAccountDialog2() {
        super(1, WidgetDisableDeleteAccountDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetDisableDeleteAccountDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetDisableDeleteAccountDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetDisableDeleteAccountDialogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.disable_delete_body;
        TextView textView = (TextView) view.findViewById(C5419R.id.disable_delete_body);
        if (textView != null) {
            i = C5419R.id.disable_delete_cancel;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.disable_delete_cancel);
            if (materialButton != null) {
                i = C5419R.id.disable_delete_code_wrap;
                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.disable_delete_code_wrap);
                if (textInputLayout != null) {
                    i = C5419R.id.disable_delete_confirm;
                    LoadingButton loadingButton = (LoadingButton) view.findViewById(C5419R.id.disable_delete_confirm);
                    if (loadingButton != null) {
                        i = C5419R.id.disable_delete_header;
                        TextView textView2 = (TextView) view.findViewById(C5419R.id.disable_delete_header);
                        if (textView2 != null) {
                            i = C5419R.id.disable_delete_password_wrap;
                            TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(C5419R.id.disable_delete_password_wrap);
                            if (textInputLayout2 != null) {
                                i = C5419R.id.notice_header_container;
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.notice_header_container);
                                if (linearLayout != null) {
                                    return new WidgetDisableDeleteAccountDialogBinding((LinearLayout) view, textView, materialButton, textInputLayout, loadingButton, textView2, textInputLayout2, linearLayout);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
