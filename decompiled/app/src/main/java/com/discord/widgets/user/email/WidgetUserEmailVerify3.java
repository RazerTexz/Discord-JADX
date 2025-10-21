package com.discord.widgets.user.email;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.discord.R;
import com.discord.databinding.WidgetUserEmailVerifyBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetUserEmailVerify.kt */
/* renamed from: com.discord.widgets.user.email.WidgetUserEmailVerify$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetUserEmailVerify3 extends FunctionReferenceImpl implements Function1<View, WidgetUserEmailVerifyBinding> {
    public static final WidgetUserEmailVerify3 INSTANCE = new WidgetUserEmailVerify3();

    public WidgetUserEmailVerify3() {
        super(1, WidgetUserEmailVerifyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserEmailVerifyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserEmailVerifyBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserEmailVerifyBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.alert_verify_email_anchor;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.alert_verify_email_anchor);
        if (linearLayout != null) {
            i = R.id.alert_verify_email_change;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.alert_verify_email_change);
            if (materialButton != null) {
                i = R.id.alert_verify_email_resend;
                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.alert_verify_email_resend);
                if (materialButton2 != null) {
                    return new WidgetUserEmailVerifyBinding((RelativeLayout) view, linearLayout, materialButton, materialButton2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
