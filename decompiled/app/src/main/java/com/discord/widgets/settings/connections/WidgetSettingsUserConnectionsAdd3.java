package com.discord.widgets.settings.connections;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsConnectionsAddBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAdd$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsUserConnectionsAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsUserConnectionsAdd3 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsConnectionsAddBinding> {
    public static final WidgetSettingsUserConnectionsAdd3 INSTANCE = new WidgetSettingsUserConnectionsAdd3();

    public WidgetSettingsUserConnectionsAdd3() {
        super(1, WidgetSettingsConnectionsAddBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsConnectionsAddBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsConnectionsAddBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsConnectionsAddBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.connections_recycler);
        if (recyclerView != null) {
            return new WidgetSettingsConnectionsAddBinding((NestedScrollView) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.connections_recycler)));
    }
}
