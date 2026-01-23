package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsAccountEmailEditConfirmBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEditConfirm$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsAccountEmailEditConfirm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountEmailEditConfirm3 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsAccountEmailEditConfirmBinding> {
    public static final WidgetSettingsAccountEmailEditConfirm3 INSTANCE = new WidgetSettingsAccountEmailEditConfirm3();

    public WidgetSettingsAccountEmailEditConfirm3() {
        super(1, WidgetSettingsAccountEmailEditConfirmBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountEmailEditConfirmBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsAccountEmailEditConfirmBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccountEmailEditConfirmBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
        if (dimmerView != null) {
            i = C5419R.id.edit_account_code_wrap;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.edit_account_code_wrap);
            if (textInputLayout != null) {
                i = C5419R.id.edit_account_email_confirm_description;
                TextView textView = (TextView) view.findViewById(C5419R.id.edit_account_email_confirm_description);
                if (textView != null) {
                    i = C5419R.id.settings_account_confirm_resend;
                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.settings_account_confirm_resend);
                    if (linkifiedTextView != null) {
                        i = C5419R.id.settings_account_next;
                        Button button = (Button) view.findViewById(C5419R.id.settings_account_next);
                        if (button != null) {
                            return new WidgetSettingsAccountEmailEditConfirmBinding((CoordinatorLayout) view, dimmerView, textInputLayout, textView, linkifiedTextView, button);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
