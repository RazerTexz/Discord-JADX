package com.discord.widgets.captcha;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetCaptchaBinding;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetCaptcha.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetCaptcha$binding$2 extends k implements Function1<View, WidgetCaptchaBinding> {
    public static final WidgetCaptcha$binding$2 INSTANCE = new WidgetCaptcha$binding$2();

    public WidgetCaptcha$binding$2() {
        super(1, WidgetCaptchaBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCaptchaBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetCaptchaBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetCaptchaBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R.id.captcha_help;
        TextView textView = (TextView) view.findViewById(R.id.captcha_help);
        if (textView != null) {
            i = R.id.captcha_verify;
            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.captcha_verify);
            if (materialButton != null) {
                i = R.id.screen_title;
                ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(R.id.screen_title);
                if (screenTitleView != null) {
                    return new WidgetCaptchaBinding((CoordinatorLayout) view, textView, materialButton, screenTitleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
