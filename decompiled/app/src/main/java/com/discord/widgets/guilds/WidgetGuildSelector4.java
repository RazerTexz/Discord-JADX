package com.discord.widgets.guilds;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildSelectorBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetGuildSelector.kt */
/* renamed from: com.discord.widgets.guilds.WidgetGuildSelector$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildSelector4 extends FunctionReferenceImpl implements Function1<View, WidgetGuildSelectorBinding> {
    public static final WidgetGuildSelector4 INSTANCE = new WidgetGuildSelector4();

    public WidgetGuildSelector4() {
        super(1, WidgetGuildSelectorBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildSelectorBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildSelectorBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildSelectorBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_actions_overview_header_tv;
        TextView textView = (TextView) view.findViewById(C5419R.id.guild_actions_overview_header_tv);
        if (textView != null) {
            i = C5419R.id.guild_selector_list;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.guild_selector_list);
            if (recyclerView != null) {
                return new WidgetGuildSelectorBinding((NestedScrollView) view, textView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
