package com.discord.widgets.chat.managereactions;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetManageReactionsBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetManageReactions.kt */
/* renamed from: com.discord.widgets.chat.managereactions.WidgetManageReactions$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetManageReactions2 extends FunctionReferenceImpl implements Function1<View, WidgetManageReactionsBinding> {
    public static final WidgetManageReactions2 INSTANCE = new WidgetManageReactions2();

    public WidgetManageReactions2() {
        super(1, WidgetManageReactionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetManageReactionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetManageReactionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetManageReactionsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.manage_reactions_emojis_recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.manage_reactions_emojis_recycler);
        if (recyclerView != null) {
            i = R.id.manage_reactions_results_recycler;
            RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.manage_reactions_results_recycler);
            if (recyclerView2 != null) {
                return new WidgetManageReactionsBinding((CoordinatorLayout) view, recyclerView, recyclerView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
