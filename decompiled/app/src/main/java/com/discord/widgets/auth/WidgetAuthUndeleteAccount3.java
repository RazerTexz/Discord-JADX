package com.discord.widgets.auth;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetAuthUndeleteAccountBinding;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthUndeleteAccount$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetAuthUndeleteAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthUndeleteAccount3 extends FunctionReferenceImpl implements Function1<View, WidgetAuthUndeleteAccountBinding> {
    public static final WidgetAuthUndeleteAccount3 INSTANCE = new WidgetAuthUndeleteAccount3();

    public WidgetAuthUndeleteAccount3() {
        super(1, WidgetAuthUndeleteAccountBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAuthUndeleteAccountBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetAuthUndeleteAccountBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetAuthUndeleteAccountBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.auth_undelete_cancel;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.auth_undelete_cancel);
        if (materialButton != null) {
            i = C5419R.id.auth_undelete_delete;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.auth_undelete_delete);
            if (materialButton2 != null) {
                i = C5419R.id.auth_undelete_title;
                ScreenTitleView screenTitleView = (ScreenTitleView) view.findViewById(C5419R.id.auth_undelete_title);
                if (screenTitleView != null) {
                    return new WidgetAuthUndeleteAccountBinding((CoordinatorLayout) view, materialButton, materialButton2, screenTitleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
