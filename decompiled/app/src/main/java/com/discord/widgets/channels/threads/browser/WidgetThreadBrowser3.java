package com.discord.widgets.channels.threads.browser;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetThreadBrowserBinding;
import com.discord.utilities.simple_pager.SimplePager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetThreadBrowser.kt */
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadBrowser3 extends FunctionReferenceImpl implements Function1<View, WidgetThreadBrowserBinding> {
    public static final WidgetThreadBrowser3 INSTANCE = new WidgetThreadBrowser3();

    public WidgetThreadBrowser3() {
        super(1, WidgetThreadBrowserBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadBrowserBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetThreadBrowserBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetThreadBrowserBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.action_bar_tabs;
        TabLayout tabLayout = (TabLayout) view.findViewById(C5419R.id.action_bar_tabs);
        if (tabLayout != null) {
            i = C5419R.id.thread_browser_toolbar;
            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(C5419R.id.thread_browser_toolbar);
            if (appBarLayout != null) {
                i = C5419R.id.thread_browser_view_pager;
                SimplePager simplePager = (SimplePager) view.findViewById(C5419R.id.thread_browser_view_pager);
                if (simplePager != null) {
                    return new WidgetThreadBrowserBinding((ConstraintLayout) view, tabLayout, appBarLayout, simplePager);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
