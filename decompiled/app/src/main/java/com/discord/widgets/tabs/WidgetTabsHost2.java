package com.discord.widgets.tabs;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import com.discord.R;
import com.discord.databinding.WidgetTabsHostBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetTabsHost.kt */
/* renamed from: com.discord.widgets.tabs.WidgetTabsHost$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetTabsHost2 extends FunctionReferenceImpl implements Function1<View, WidgetTabsHostBinding> {
    public static final WidgetTabsHost2 INSTANCE = new WidgetTabsHost2();

    public WidgetTabsHost2() {
        super(1, WidgetTabsHostBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetTabsHostBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetTabsHostBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetTabsHostBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.widget_tabs_host_bottom_navigation_view;
        TabsHostBottomNavigationView tabsHostBottomNavigationView = (TabsHostBottomNavigationView) view.findViewById(R.id.widget_tabs_host_bottom_navigation_view);
        if (tabsHostBottomNavigationView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.widget_tabs_host_friends;
            FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.widget_tabs_host_friends);
            if (fragmentContainerView != null) {
                i = R.id.widget_tabs_host_global_status_indicator;
                FragmentContainerView fragmentContainerView2 = (FragmentContainerView) view.findViewById(R.id.widget_tabs_host_global_status_indicator);
                if (fragmentContainerView2 != null) {
                    i = R.id.widget_tabs_host_home;
                    FragmentContainerView fragmentContainerView3 = (FragmentContainerView) view.findViewById(R.id.widget_tabs_host_home);
                    if (fragmentContainerView3 != null) {
                        i = R.id.widget_tabs_host_mentions;
                        FragmentContainerView fragmentContainerView4 = (FragmentContainerView) view.findViewById(R.id.widget_tabs_host_mentions);
                        if (fragmentContainerView4 != null) {
                            i = R.id.widget_tabs_host_nav_host;
                            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.widget_tabs_host_nav_host);
                            if (frameLayout != null) {
                                i = R.id.widget_tabs_host_non_fullscreen_nav_host;
                                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.widget_tabs_host_non_fullscreen_nav_host);
                                if (frameLayout2 != null) {
                                    i = R.id.widget_tabs_host_user_settings;
                                    FragmentContainerView fragmentContainerView5 = (FragmentContainerView) view.findViewById(R.id.widget_tabs_host_user_settings);
                                    if (fragmentContainerView5 != null) {
                                        return new WidgetTabsHostBinding(constraintLayout, tabsHostBottomNavigationView, constraintLayout, fragmentContainerView, fragmentContainerView2, fragmentContainerView3, fragmentContainerView4, frameLayout, frameLayout2, fragmentContainerView5);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
