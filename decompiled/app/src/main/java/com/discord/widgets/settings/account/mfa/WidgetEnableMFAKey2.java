package com.discord.widgets.settings.account.mfa;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsEnableMfaKeyBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFAKey$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetEnableMFAKey.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableMFAKey2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsEnableMfaKeyBinding> {
    public static final WidgetEnableMFAKey2 INSTANCE = new WidgetEnableMFAKey2();

    public WidgetEnableMFAKey2() {
        super(1, WidgetSettingsEnableMfaKeyBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsEnableMfaKeyBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsEnableMfaKeyBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsEnableMfaKeyBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.enable_mfa_key_code;
        TextView textView = (TextView) view.findViewById(C5419R.id.enable_mfa_key_code);
        if (textView != null) {
            i = C5419R.id.enable_mfa_key_launch_authy;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.enable_mfa_key_launch_authy);
            if (textView2 != null) {
                i = C5419R.id.enable_mfa_key_launch_google_auth;
                TextView textView3 = (TextView) view.findViewById(C5419R.id.enable_mfa_key_launch_google_auth);
                if (textView3 != null) {
                    return new WidgetSettingsEnableMfaKeyBinding((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
