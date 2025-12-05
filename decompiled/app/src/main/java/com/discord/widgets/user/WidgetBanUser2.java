package com.discord.widgets.user;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetBanUserBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetBanUser.kt */
/* renamed from: com.discord.widgets.user.WidgetBanUser$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetBanUser2 extends FunctionReferenceImpl implements Function1<View, WidgetBanUserBinding> {
    public static final WidgetBanUser2 INSTANCE = new WidgetBanUser2();

    public WidgetBanUser2() {
        super(1, WidgetBanUserBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetBanUserBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetBanUserBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetBanUserBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.ban_user_body;
        TextView textView = (TextView) view.findViewById(C5419R.id.ban_user_body);
        if (textView != null) {
            i = C5419R.id.ban_user_button_container;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.ban_user_button_container);
            if (linearLayout != null) {
                i = C5419R.id.ban_user_cancel;
                MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.ban_user_cancel);
                if (materialButton != null) {
                    i = C5419R.id.ban_user_confirm;
                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.ban_user_confirm);
                    if (materialButton2 != null) {
                        i = C5419R.id.ban_user_delete_messages_1_day;
                        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.ban_user_delete_messages_1_day);
                        if (checkedSetting != null) {
                            i = C5419R.id.ban_user_delete_messages_7_days;
                            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(C5419R.id.ban_user_delete_messages_7_days);
                            if (checkedSetting2 != null) {
                                i = C5419R.id.ban_user_delete_messages_none;
                                CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(C5419R.id.ban_user_delete_messages_none);
                                if (checkedSetting3 != null) {
                                    i = C5419R.id.ban_user_reason;
                                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.ban_user_reason);
                                    if (textInputLayout != null) {
                                        i = C5419R.id.ban_user_title;
                                        TextView textView2 = (TextView) view.findViewById(C5419R.id.ban_user_title);
                                        if (textView2 != null) {
                                            LinearLayout linearLayout2 = (LinearLayout) view;
                                            return new WidgetBanUserBinding(linearLayout2, textView, linearLayout, materialButton, materialButton2, checkedSetting, checkedSetting2, checkedSetting3, textInputLayout, textView2, linearLayout2);
                                        }
                                    }
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
