package com.discord.widgets.guilds;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetGuildSelectorBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildSelector.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildSelector$binding$2 extends k implements Function1<View, WidgetGuildSelectorBinding> {
    public static final WidgetGuildSelector$binding$2 INSTANCE = new WidgetGuildSelector$binding$2();

    public WidgetGuildSelector$binding$2() {
        super(1, WidgetGuildSelectorBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildSelectorBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildSelectorBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildSelectorBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R.id.guild_actions_overview_header_tv;
        TextView textView = (TextView) view.findViewById(R.id.guild_actions_overview_header_tv);
        if (textView != null) {
            i = R.id.guild_selector_list;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.guild_selector_list);
            if (recyclerView != null) {
                return new WidgetGuildSelectorBinding((NestedScrollView) view, textView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
