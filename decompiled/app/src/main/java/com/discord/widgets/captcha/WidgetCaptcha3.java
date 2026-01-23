package com.discord.widgets.captcha;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetCaptchaBinding;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.captcha.WidgetCaptcha$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetCaptcha.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetCaptcha3 extends FunctionReferenceImpl implements Function1<View, WidgetCaptchaBinding> {
    public static final WidgetCaptcha3 INSTANCE = new WidgetCaptcha3();

    public WidgetCaptcha3() {
        super(1, WidgetCaptchaBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCaptchaBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetCaptchaBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetCaptchaBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.captcha_help;
        TextView textView = (TextView) view.findViewById(C5419R.id.captcha_help);
        if (textView != null) {
            i = C5419R.id.captcha_verify;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.captcha_verify);
            if (materialButton != null) {
                i = C5419R.id.screen_title;
                ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(C5419R.id.screen_title);
                if (screenTitleView != null) {
                    return new WidgetCaptchaBinding((CoordinatorLayout) view, textView, materialButton, screenTitleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
