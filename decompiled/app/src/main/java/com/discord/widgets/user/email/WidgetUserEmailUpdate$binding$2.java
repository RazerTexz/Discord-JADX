package com.discord.widgets.user.email;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.discord.R;
import com.discord.databinding.WidgetUserEmailUpdateBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetUserEmailUpdate.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetUserEmailUpdate$binding$2 extends k implements Function1<View, WidgetUserEmailUpdateBinding> {
    public static final WidgetUserEmailUpdate$binding$2 INSTANCE = new WidgetUserEmailUpdate$binding$2();

    public WidgetUserEmailUpdate$binding$2() {
        super(1, WidgetUserEmailUpdateBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserEmailUpdateBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserEmailUpdateBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserEmailUpdateBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R.id.alert_verify_email_anchor;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.alert_verify_email_anchor);
        if (linearLayout != null) {
            i = R.id.alert_verify_email_change;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.alert_verify_email_change);
            if (materialButton != null) {
                i = R.id.alert_verify_email_change_email;
                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.alert_verify_email_change_email);
                if (textInputLayout != null) {
                    i = R.id.alert_verify_email_change_password;
                    TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.alert_verify_email_change_password);
                    if (textInputLayout2 != null) {
                        i = R.id.dimmer_view;
                        DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
                        if (dimmerView != null) {
                            return new WidgetUserEmailUpdateBinding((RelativeLayout) view, linearLayout, materialButton, textInputLayout, textInputLayout2, dimmerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
