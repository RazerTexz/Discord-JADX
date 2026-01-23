package com.discord.widgets.auth;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetAuthMfaBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthMfa$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetAuthMfa.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthMfa2 extends FunctionReferenceImpl implements Function1<View, WidgetAuthMfaBinding> {
    public static final WidgetAuthMfa2 INSTANCE = new WidgetAuthMfa2();

    public WidgetAuthMfa2() {
        super(1, WidgetAuthMfaBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthMfaBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthMfaBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthMfaBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.auth_login_forgot_password;
        TextView textView = (TextView) view.findViewById(C5419R.id.auth_login_forgot_password);
        if (textView != null) {
            i = C5419R.id.auth_mfa_verification;
            CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(C5419R.id.auth_mfa_verification);
            if (codeVerificationView != null) {
                i = C5419R.id.dimmer_view;
                DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
                if (dimmerView != null) {
                    return new WidgetAuthMfaBinding((CoordinatorLayout) view, textView, codeVerificationView, dimmerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
