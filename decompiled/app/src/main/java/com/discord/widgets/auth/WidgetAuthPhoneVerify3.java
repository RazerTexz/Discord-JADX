package com.discord.widgets.auth;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetAuthPhoneVerifyBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthPhoneVerify$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthPhoneVerify3 extends FunctionReferenceImpl implements Function1<View, WidgetAuthPhoneVerifyBinding> {
    public static final WidgetAuthPhoneVerify3 INSTANCE = new WidgetAuthPhoneVerify3();

    public WidgetAuthPhoneVerify3() {
        super(1, WidgetAuthPhoneVerifyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthPhoneVerifyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthPhoneVerifyBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthPhoneVerifyBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.auth_phone_bailout;
        TextView textView = (TextView) view.findViewById(C5419R.id.auth_phone_bailout);
        if (textView != null) {
            i = C5419R.id.auth_phone_verify_code;
            CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(C5419R.id.auth_phone_verify_code);
            if (codeVerificationView != null) {
                i = C5419R.id.auth_phone_verify_resend;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.auth_phone_verify_resend);
                if (textView2 != null) {
                    i = C5419R.id.auth_phone_verify_subtitle;
                    TextView textView3 = (TextView) view.findViewById(C5419R.id.auth_phone_verify_subtitle);
                    if (textView3 != null) {
                        i = C5419R.id.auth_phone_verify_title;
                        TextView textView4 = (TextView) view.findViewById(C5419R.id.auth_phone_verify_title);
                        if (textView4 != null) {
                            i = C5419R.id.dimmer_view;
                            DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
                            if (dimmerView != null) {
                                return new WidgetAuthPhoneVerifyBinding((CoordinatorLayout) view, textView, codeVerificationView, textView2, textView3, textView4, dimmerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
