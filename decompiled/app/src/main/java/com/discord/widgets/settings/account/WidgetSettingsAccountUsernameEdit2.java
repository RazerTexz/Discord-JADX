package com.discord.widgets.settings.account;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsAccountEditBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetSettingsAccountUsernameEdit.kt */
/* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountUsernameEdit2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsAccountEditBinding> {
    public static final WidgetSettingsAccountUsernameEdit2 INSTANCE = new WidgetSettingsAccountUsernameEdit2();

    public WidgetSettingsAccountUsernameEdit2() {
        super(1, WidgetSettingsAccountEditBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountEditBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsAccountEditBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccountEditBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.dtddd;
        TextView textView = (TextView) view.findViewById(C5419R.id.dtddd);
        if (textView != null) {
            i = C5419R.id.edit_account_discriminator_wrap;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.edit_account_discriminator_wrap);
            if (textInputLayout != null) {
                i = C5419R.id.edit_account_tag_layout_container;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C5419R.id.edit_account_tag_layout_container);
                if (relativeLayout != null) {
                    i = C5419R.id.edit_account_username_wrap;
                    TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(C5419R.id.edit_account_username_wrap);
                    if (textInputLayout2 != null) {
                        i = C5419R.id.settings_account_save;
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C5419R.id.settings_account_save);
                        if (floatingActionButton != null) {
                            return new WidgetSettingsAccountEditBinding((CoordinatorLayout) view, textView, textInputLayout, relativeLayout, textInputLayout2, floatingActionButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
