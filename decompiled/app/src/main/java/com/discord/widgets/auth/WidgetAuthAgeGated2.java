package com.discord.widgets.auth;

import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetAuthAgeGatedBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetAuthAgeGated.kt */
/* renamed from: com.discord.widgets.auth.WidgetAuthAgeGated$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthAgeGated2 extends FunctionReferenceImpl implements Function1<View, WidgetAuthAgeGatedBinding> {
    public static final WidgetAuthAgeGated2 INSTANCE = new WidgetAuthAgeGated2();

    public WidgetAuthAgeGated2() {
        super(1, WidgetAuthAgeGatedBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthAgeGatedBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthAgeGatedBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthAgeGatedBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.auth_register_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.auth_register_container);
        if (linearLayout != null) {
            i = C5419R.id.auth_register_underage_button;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.auth_register_underage_button);
            if (materialButton != null) {
                i = C5419R.id.auth_register_underage_description;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.auth_register_underage_description);
                if (linkifiedTextView != null) {
                    return new WidgetAuthAgeGatedBinding((CoordinatorLayout) view, linearLayout, materialButton, linkifiedTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
