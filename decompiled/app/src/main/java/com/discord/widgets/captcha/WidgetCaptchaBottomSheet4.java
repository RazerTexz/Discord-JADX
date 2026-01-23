package com.discord.widgets.captcha;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetCaptchaBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.captcha.WidgetCaptchaBottomSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetCaptchaBottomSheet4 extends FunctionReferenceImpl implements Function1<View, WidgetCaptchaBottomSheetBinding> {
    public static final WidgetCaptchaBottomSheet4 INSTANCE = new WidgetCaptchaBottomSheet4();

    public WidgetCaptchaBottomSheet4() {
        super(1, WidgetCaptchaBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetCaptchaBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetCaptchaBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetCaptchaBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.captcha_body;
        TextView textView = (TextView) view.findViewById(C5419R.id.captcha_body);
        if (textView != null) {
            i = C5419R.id.captcha_button;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.captcha_button);
            if (materialButton != null) {
                i = C5419R.id.captcha_title;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.captcha_title);
                if (textView2 != null) {
                    i = C5419R.id.guild_join_captcha_image;
                    ImageView imageView = (ImageView) view.findViewById(C5419R.id.guild_join_captcha_image);
                    if (imageView != null) {
                        return new WidgetCaptchaBottomSheetBinding((NestedScrollView) view, textView, materialButton, textView2, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
