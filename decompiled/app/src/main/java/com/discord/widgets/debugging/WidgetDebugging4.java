package com.discord.widgets.debugging;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetDebuggingBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.debugging.WidgetDebugging$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetDebugging.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetDebugging4 extends FunctionReferenceImpl implements Function1<View, WidgetDebuggingBinding> {
    public static final WidgetDebugging4 INSTANCE = new WidgetDebugging4();

    public WidgetDebugging4() {
        super(1, WidgetDebuggingBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetDebuggingBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetDebuggingBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetDebuggingBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.debugging_logs);
        if (recyclerView != null) {
            return new WidgetDebuggingBinding((CoordinatorLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.debugging_logs)));
    }
}
