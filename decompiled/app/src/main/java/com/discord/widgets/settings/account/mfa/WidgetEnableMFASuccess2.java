package com.discord.widgets.settings.account.mfa;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsEnableMfaSuccessBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFASuccess$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetEnableMFASuccess.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableMFASuccess2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsEnableMfaSuccessBinding> {
    public static final WidgetEnableMFASuccess2 INSTANCE = new WidgetEnableMFASuccess2();

    public WidgetEnableMFASuccess2() {
        super(1, WidgetSettingsEnableMfaSuccessBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsEnableMfaSuccessBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsEnableMfaSuccessBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsEnableMfaSuccessBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.mfa_success_enable_sms);
        if (materialButton != null) {
            return new WidgetSettingsEnableMfaSuccessBinding((LinearLayout) view, materialButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.mfa_success_enable_sms)));
    }
}
