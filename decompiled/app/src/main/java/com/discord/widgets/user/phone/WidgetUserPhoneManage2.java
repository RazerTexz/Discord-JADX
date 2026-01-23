package com.discord.widgets.user.phone;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetUserPhoneManageBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.user.phone.WidgetUserPhoneManage$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetUserPhoneManage.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserPhoneManage2 extends FunctionReferenceImpl implements Function1<View, WidgetUserPhoneManageBinding> {
    public static final WidgetUserPhoneManage2 INSTANCE = new WidgetUserPhoneManage2();

    public WidgetUserPhoneManage2() {
        super(1, WidgetUserPhoneManageBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserPhoneManageBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserPhoneManageBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserPhoneManageBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
        if (dimmerView != null) {
            i = C5419R.id.remove_phone;
            TextView textView = (TextView) view.findViewById(C5419R.id.remove_phone);
            if (textView != null) {
                i = C5419R.id.user_phone_add_description_note;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.user_phone_add_description_note);
                if (textView2 != null) {
                    i = C5419R.id.user_phone_add_next;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.user_phone_add_next);
                    if (materialButton != null) {
                        i = C5419R.id.user_phone_add_number;
                        PhoneOrEmailInputView phoneOrEmailInputView = (PhoneOrEmailInputView) view.findViewById(C5419R.id.user_phone_add_number);
                        if (phoneOrEmailInputView != null) {
                            i = C5419R.id.user_phone_title;
                            TextView textView3 = (TextView) view.findViewById(C5419R.id.user_phone_title);
                            if (textView3 != null) {
                                return new WidgetUserPhoneManageBinding((FrameLayout) view, dimmerView, textView, textView2, materialButton, phoneOrEmailInputView, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
