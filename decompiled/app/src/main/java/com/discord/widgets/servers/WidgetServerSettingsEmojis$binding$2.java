package com.discord.widgets.servers;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsEmojisBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetServerSettingsEmojis.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEmojis$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsEmojisBinding> {
    public static final WidgetServerSettingsEmojis$binding$2 INSTANCE = new WidgetServerSettingsEmojis$binding$2();

    public WidgetServerSettingsEmojis$binding$2() {
        super(1, WidgetServerSettingsEmojisBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsEmojisBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsEmojisBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEmojisBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.widget_server_settings_emojis_recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.widget_server_settings_emojis_recycler);
        if (recyclerView != null) {
            i = C5419R.id.widget_server_settings_emojis_view_flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.widget_server_settings_emojis_view_flipper);
            if (appViewFlipper != null) {
                return new WidgetServerSettingsEmojisBinding((CoordinatorLayout) view, recyclerView, appViewFlipper);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
