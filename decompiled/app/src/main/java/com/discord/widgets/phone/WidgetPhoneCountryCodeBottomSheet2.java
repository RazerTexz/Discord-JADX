package com.discord.widgets.phone;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetPhoneCountryCodeBottomSheetBinding;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetPhoneCountryCodeBottomSheet.kt */
/* renamed from: com.discord.widgets.phone.WidgetPhoneCountryCodeBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetPhoneCountryCodeBottomSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetPhoneCountryCodeBottomSheetBinding> {
    public static final WidgetPhoneCountryCodeBottomSheet2 INSTANCE = new WidgetPhoneCountryCodeBottomSheet2();

    public WidgetPhoneCountryCodeBottomSheet2() {
        super(1, WidgetPhoneCountryCodeBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPhoneCountryCodeBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetPhoneCountryCodeBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetPhoneCountryCodeBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.phone_country_code_recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.phone_country_code_recycler);
        if (recyclerView != null) {
            i = C5419R.id.phone_country_code_search;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.phone_country_code_search);
            if (textInputLayout != null) {
                return new WidgetPhoneCountryCodeBottomSheetBinding((LinearLayout) view, recyclerView, textInputLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
