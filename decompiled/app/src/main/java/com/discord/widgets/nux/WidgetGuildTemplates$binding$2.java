package com.discord.widgets.nux;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetNuxGuildTemplateBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildTemplates.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildTemplates$binding$2 extends k implements Function1<View, WidgetNuxGuildTemplateBinding> {
    public static final WidgetGuildTemplates$binding$2 INSTANCE = new WidgetGuildTemplates$binding$2();

    public WidgetGuildTemplates$binding$2() {
        super(1, WidgetNuxGuildTemplateBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetNuxGuildTemplateBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetNuxGuildTemplateBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetNuxGuildTemplateBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R.id.nux_guild_template_action_join;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.nux_guild_template_action_join);
        if (materialButton != null) {
            i = R.id.nux_guild_template_section_bottom;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.nux_guild_template_section_bottom);
            if (linearLayout != null) {
                i = R.id.nux_guild_template_section_custom_label;
                TextView textView = (TextView) view.findViewById(R.id.nux_guild_template_section_custom_label);
                if (textView != null) {
                    i = R.id.nux_guild_template_section_title;
                    TextView textView2 = (TextView) view.findViewById(R.id.nux_guild_template_section_title);
                    if (textView2 != null) {
                        i = R.id.recycler_view;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                        if (recyclerView != null) {
                            return new WidgetNuxGuildTemplateBinding((LinearLayout) view, materialButton, linearLayout, textView, textView2, recyclerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
