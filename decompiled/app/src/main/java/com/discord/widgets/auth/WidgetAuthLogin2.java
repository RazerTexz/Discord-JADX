package com.discord.widgets.auth;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetAuthLoginBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetAuthLogin.kt */
/* renamed from: com.discord.widgets.auth.WidgetAuthLogin$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthLogin2 extends FunctionReferenceImpl implements Function1<View, WidgetAuthLoginBinding> {
    public static final WidgetAuthLogin2 INSTANCE = new WidgetAuthLogin2();

    public WidgetAuthLogin2() {
        super(1, WidgetAuthLoginBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthLoginBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthLoginBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthLoginBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.auth_login;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.auth_login);
        if (materialButton != null) {
            i = C5419R.id.auth_login_container;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.auth_login_container);
            if (linearLayout != null) {
                i = C5419R.id.auth_login_forgot_password;
                TextView textView = (TextView) view.findViewById(C5419R.id.auth_login_forgot_password);
                if (textView != null) {
                    i = C5419R.id.auth_login_login_input;
                    PhoneOrEmailInputView phoneOrEmailInputView = (PhoneOrEmailInputView) view.findViewById(C5419R.id.auth_login_login_input);
                    if (phoneOrEmailInputView != null) {
                        i = C5419R.id.auth_login_password_manager_link;
                        TextView textView2 = (TextView) view.findViewById(C5419R.id.auth_login_password_manager_link);
                        if (textView2 != null) {
                            i = C5419R.id.auth_login_password_wrap;
                            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.auth_login_password_wrap);
                            if (textInputLayout != null) {
                                i = C5419R.id.dimmer_view;
                                DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
                                if (dimmerView != null) {
                                    return new WidgetAuthLoginBinding((CoordinatorLayout) view, materialButton, linearLayout, textView, phoneOrEmailInputView, textView2, textInputLayout, dimmerView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
