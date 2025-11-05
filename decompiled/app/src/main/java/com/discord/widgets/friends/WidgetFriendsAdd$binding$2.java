package com.discord.widgets.friends;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetFriendsAddBinding;
import com.discord.utilities.simple_pager.SimplePager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetFriendsAdd.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetFriendsAdd$binding$2 extends k implements Function1<View, WidgetFriendsAddBinding> {
    public static final WidgetFriendsAdd$binding$2 INSTANCE = new WidgetFriendsAdd$binding$2();

    public WidgetFriendsAdd$binding$2() {
        super(1, WidgetFriendsAddBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetFriendsAddBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetFriendsAddBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetFriendsAddBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R.id.action_bar_tabs;
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.action_bar_tabs);
        if (tabLayout != null) {
            i = R.id.action_bar_toolbar_layout;
            AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.action_bar_toolbar_layout);
            if (appBarLayout != null) {
                i = R.id.add_friend_view_pager;
                SimplePager simplePager = (SimplePager) view.findViewById(R.id.add_friend_view_pager);
                if (simplePager != null) {
                    return new WidgetFriendsAddBinding((CoordinatorLayout) view, tabLayout, appBarLayout, simplePager);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
