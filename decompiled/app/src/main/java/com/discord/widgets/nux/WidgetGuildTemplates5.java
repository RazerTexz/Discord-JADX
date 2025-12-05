package com.discord.widgets.nux;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetNuxGuildTemplateBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetGuildTemplates.kt */
/* renamed from: com.discord.widgets.nux.WidgetGuildTemplates$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildTemplates5 extends FunctionReferenceImpl implements Function1<View, WidgetNuxGuildTemplateBinding> {
    public static final WidgetGuildTemplates5 INSTANCE = new WidgetGuildTemplates5();

    public WidgetGuildTemplates5() {
        super(1, WidgetNuxGuildTemplateBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetNuxGuildTemplateBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetNuxGuildTemplateBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetNuxGuildTemplateBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.nux_guild_template_action_join;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.nux_guild_template_action_join);
        if (materialButton != null) {
            i = C5419R.id.nux_guild_template_section_bottom;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.nux_guild_template_section_bottom);
            if (linearLayout != null) {
                i = C5419R.id.nux_guild_template_section_custom_label;
                TextView textView = (TextView) view.findViewById(C5419R.id.nux_guild_template_section_custom_label);
                if (textView != null) {
                    i = C5419R.id.nux_guild_template_section_title;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.nux_guild_template_section_title);
                    if (textView2 != null) {
                        i = C5419R.id.recycler_view;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.recycler_view);
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
