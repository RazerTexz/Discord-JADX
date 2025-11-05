package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetHubDomainsBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetHubDomains.kt */
/* renamed from: com.discord.widgets.hubs.WidgetHubDomains$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubDomains7 extends FunctionReferenceImpl implements Function1<View, WidgetHubDomainsBinding> {
    public static final WidgetHubDomains7 INSTANCE = new WidgetHubDomains7();

    public WidgetHubDomains7() {
        super(1, WidgetHubDomainsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubDomainsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetHubDomainsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetHubDomainsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.hub_domains_section_title;
        TextView textView = (TextView) view.findViewById(R.id.hub_domains_section_title);
        if (textView != null) {
            i = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
            if (recyclerView != null) {
                i = R.id.waitlist_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.waitlist_button);
                if (materialButton != null) {
                    return new WidgetHubDomainsBinding((LinearLayout) view, textView, recyclerView, materialButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
