package com.discord.widgets.settings.account;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsAccountContactsNameEditBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetSettingsAccountContactsNameEdit.kt */
/* renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsAccountContactsNameEdit2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsAccountContactsNameEditBinding> {
    public static final WidgetSettingsAccountContactsNameEdit2 INSTANCE = new WidgetSettingsAccountContactsNameEdit2();

    public WidgetSettingsAccountContactsNameEdit2() {
        super(1, WidgetSettingsAccountContactsNameEditBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsAccountContactsNameEditBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsAccountContactsNameEditBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsAccountContactsNameEditBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.edit_account_name_wrap;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.edit_account_name_wrap);
        if (textInputLayout != null) {
            i = C5419R.id.settings_account_name_clear;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.settings_account_name_clear);
            if (materialButton != null) {
                i = C5419R.id.settings_account_save;
                FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C5419R.id.settings_account_save);
                if (floatingActionButton != null) {
                    return new WidgetSettingsAccountContactsNameEditBinding((CoordinatorLayout) view, textInputLayout, materialButton, floatingActionButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
