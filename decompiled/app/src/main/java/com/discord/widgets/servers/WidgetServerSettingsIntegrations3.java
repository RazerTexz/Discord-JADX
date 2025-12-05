package com.discord.widgets.servers;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsIntegrationsBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetServerSettingsIntegrations.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsIntegrations$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsIntegrations3 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsIntegrationsBinding> {
    public static final WidgetServerSettingsIntegrations3 INSTANCE = new WidgetServerSettingsIntegrations3();

    public WidgetServerSettingsIntegrations3() {
        super(1, WidgetServerSettingsIntegrationsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsIntegrationsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsIntegrationsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsIntegrationsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.integrations_empty_body;
        TextView textView = (TextView) view.findViewById(C5419R.id.integrations_empty_body);
        if (textView != null) {
            i = C5419R.id.integrations_empty_header;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.integrations_empty_header);
            if (textView2 != null) {
                i = C5419R.id.integrations_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.integrations_recycler);
                if (recyclerView != null) {
                    i = C5419R.id.integrations_view_flipper;
                    AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.integrations_view_flipper);
                    if (appViewFlipper != null) {
                        return new WidgetServerSettingsIntegrationsBinding((CoordinatorLayout) view, textView, textView2, recyclerView, appViewFlipper);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
