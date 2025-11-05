package com.discord.widgets.debugging;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetDebuggingBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetDebugging.kt */
/* renamed from: com.discord.widgets.debugging.WidgetDebugging$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetDebugging4 extends FunctionReferenceImpl implements Function1<View, WidgetDebuggingBinding> {
    public static final WidgetDebugging4 INSTANCE = new WidgetDebugging4();

    public WidgetDebugging4() {
        super(1, WidgetDebuggingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetDebuggingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetDebuggingBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetDebuggingBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.debugging_logs);
        if (recyclerView != null) {
            return new WidgetDebuggingBinding((CoordinatorLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.debugging_logs)));
    }
}
