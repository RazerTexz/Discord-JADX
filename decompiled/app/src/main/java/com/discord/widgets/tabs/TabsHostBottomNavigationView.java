package com.discord.widgets.tabs;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.TabsHostBottomNavigationViewBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.user.UserAvatarPresenceView;
import com.discord.views.user.UserAvatarPresenceViewController;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.FormatUtils;
import p507d0.Tuples;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: TabsHostBottomNavigationView.kt */
/* loaded from: classes.dex */
public final class TabsHostBottomNavigationView extends LinearLayout {
    private final TabsHostBottomNavigationViewBinding binding;
    private final Set<HeightChangedListener> heightChangedListeners;
    private Map<View, ? extends NavigationTab> iconToNavigationTabMap;
    private Map<NavigationTab, ? extends View> navigationTabToViewMap;
    private Map<ImageView, ? extends NavigationTab> tintableIconToNavigationTabMap;
    private UserAvatarPresenceViewController userAvatarPresenceViewController;

    /* compiled from: TabsHostBottomNavigationView.kt */
    public interface HeightChangedListener {
        void onHeightChanged(int height);
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$10 */
    public static final class ViewOnClickListenerC1014110 implements View.OnClickListener {
        public static final ViewOnClickListenerC1014110 INSTANCE = new ViewOnClickListenerC1014110();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$11 */
    public static final class ViewOnClickListenerC1014211 implements View.OnClickListener {
        public static final ViewOnClickListenerC1014211 INSTANCE = new ViewOnClickListenerC1014211();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$12 */
    public static final class ViewOnClickListenerC1014312 implements View.OnClickListener {
        public static final ViewOnClickListenerC1014312 INSTANCE = new ViewOnClickListenerC1014312();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$13 */
    public static final class ViewOnClickListenerC1014413 implements View.OnClickListener {
        public static final ViewOnClickListenerC1014413 INSTANCE = new ViewOnClickListenerC1014413();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$14 */
    public static final class ViewOnClickListenerC1014514 implements View.OnClickListener {
        public static final ViewOnClickListenerC1014514 INSTANCE = new ViewOnClickListenerC1014514();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$15 */
    public static final class ViewOnLongClickListenerC1014615 implements View.OnLongClickListener {
        public static final ViewOnLongClickListenerC1014615 INSTANCE = new ViewOnLongClickListenerC1014615();

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            return false;
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$16 */
    public static final class ViewOnLongClickListenerC1014716 implements View.OnLongClickListener {
        public static final ViewOnLongClickListenerC1014716 INSTANCE = new ViewOnLongClickListenerC1014716();

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View view) {
            return false;
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$4 */
    public static final class ViewOnClickListenerC101484 implements View.OnClickListener {
        public final /* synthetic */ Function1 $onTabSelected;

        public ViewOnClickListenerC101484(Function1 function1) {
            this.$onTabSelected = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onTabSelected.invoke(NavigationTab.HOME);
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$5 */
    public static final class ViewOnClickListenerC101495 implements View.OnClickListener {
        public final /* synthetic */ Function1 $onTabSelected;

        public ViewOnClickListenerC101495(Function1 function1) {
            this.$onTabSelected = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onTabSelected.invoke(NavigationTab.FRIENDS);
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$6 */
    public static final class ViewOnClickListenerC101506 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onSearchClick;

        public ViewOnClickListenerC101506(Function0 function0) {
            this.$onSearchClick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onSearchClick.invoke();
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$7 */
    public static final class ViewOnClickListenerC101517 implements View.OnClickListener {
        public final /* synthetic */ Function1 $onTabSelected;

        public ViewOnClickListenerC101517(Function1 function1) {
            this.$onTabSelected = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onTabSelected.invoke(NavigationTab.MENTIONS);
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$8 */
    public static final class ViewOnClickListenerC101528 implements View.OnClickListener {
        public final /* synthetic */ Function1 $onTabSelected;

        public ViewOnClickListenerC101528(Function1 function1) {
            this.$onTabSelected = function1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onTabSelected.invoke(NavigationTab.SETTINGS);
        }
    }

    /* compiled from: TabsHostBottomNavigationView.kt */
    /* renamed from: com.discord.widgets.tabs.TabsHostBottomNavigationView$updateView$9 */
    public static final class C101539 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Function0 $onSettingsLongPress;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C101539(Function0 function0) {
            super(1);
            this.$onSettingsLongPress = function0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            this.$onSettingsLongPress.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostBottomNavigationView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        TabsHostBottomNavigationViewBinding tabsHostBottomNavigationViewBindingM8390a = TabsHostBottomNavigationViewBinding.m8390a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationViewBindingM8390a, "TabsHostBottomNavigation…rom(context), this, true)");
        this.binding = tabsHostBottomNavigationViewBindingM8390a;
        this.heightChangedListeners = new LinkedHashSet();
    }

    private final void initialize() {
        int i;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        if (resources.getConfiguration().orientation == 1) {
            Resources resources2 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
            i = resources2.getDisplayMetrics().widthPixels;
        } else {
            Resources resources3 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources3, "resources");
            i = resources3.getDisplayMetrics().heightPixels;
        }
        LinearLayout linearLayout = this.binding.f15305l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.tabsHostBottomNavTabsContainer");
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = i;
        LinearLayout linearLayout2 = this.binding.f15305l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.tabsHostBottomNavTabsContainer");
        linearLayout2.setLayoutParams(layoutParams);
        ImageView imageView = this.binding.f15298e;
        NavigationTab navigationTab = NavigationTab.HOME;
        ImageView imageView2 = this.binding.f15295b;
        NavigationTab navigationTab2 = NavigationTab.FRIENDS;
        ImageView imageView3 = this.binding.f15303j;
        NavigationTab navigationTab3 = NavigationTab.SEARCH;
        ImageView imageView4 = this.binding.f15301h;
        NavigationTab navigationTab4 = NavigationTab.MENTIONS;
        this.tintableIconToNavigationTabMap = Maps6.mapOf(Tuples.m10073to(imageView, navigationTab), Tuples.m10073to(imageView2, navigationTab2), Tuples.m10073to(imageView3, navigationTab3), Tuples.m10073to(imageView4, navigationTab4));
        UserAvatarPresenceView userAvatarPresenceView = this.binding.f15306m;
        NavigationTab navigationTab5 = NavigationTab.SETTINGS;
        this.iconToNavigationTabMap = Maps6.mapOf(Tuples.m10073to(this.binding.f15298e, navigationTab), Tuples.m10073to(this.binding.f15295b, navigationTab2), Tuples.m10073to(this.binding.f15303j, navigationTab3), Tuples.m10073to(this.binding.f15301h, navigationTab4), Tuples.m10073to(userAvatarPresenceView, navigationTab5));
        this.navigationTabToViewMap = Maps6.mapOf(Tuples.m10073to(navigationTab, this.binding.f15299f), Tuples.m10073to(navigationTab2, this.binding.f15296c), Tuples.m10073to(navigationTab3, this.binding.f15304k), Tuples.m10073to(navigationTab4, this.binding.f15302i), Tuples.m10073to(navigationTab5, this.binding.f15307n));
        UserAvatarPresenceView userAvatarPresenceView2 = this.binding.f15306m;
        Intrinsics3.checkNotNullExpressionValue(userAvatarPresenceView2, "binding.tabsHostBottomNavUserAvatarPresenceView");
        this.userAvatarPresenceViewController = new UserAvatarPresenceViewController(userAvatarPresenceView2, null, null, null, 14);
    }

    private final void updateNotificationBadges(int homeNotificationsCount, int friendsNotificationsCount) {
        TextView textView = this.binding.f15300g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.tabsHostBottomNavHomeNotificationsBadge");
        textView.setText(String.valueOf(homeNotificationsCount));
        TextView textView2 = this.binding.f15300g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.tabsHostBottomNavHomeNotificationsBadge");
        textView2.setVisibility(homeNotificationsCount > 0 ? 0 : 8);
        TextView textView3 = this.binding.f15300g;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.tabsHostBottomNavHomeNotificationsBadge");
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        textView3.setContentDescription(FormatUtils.m217i(resources, C5419R.string.mentions_count, new Object[]{String.valueOf(homeNotificationsCount)}, null, 4));
        TextView textView4 = this.binding.f15297d;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.tabsHostBottomNavFriendsNotificationsBadge");
        textView4.setText(String.valueOf(friendsNotificationsCount));
        TextView textView5 = this.binding.f15297d;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.tabsHostBottomNavFriendsNotificationsBadge");
        textView5.setVisibility(friendsNotificationsCount > 0 ? 0 : 8);
        TextView textView6 = this.binding.f15297d;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.tabsHostBottomNavFriendsNotificationsBadge");
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        textView6.setContentDescription(FormatUtils.m217i(resources2, C5419R.string.incoming_friend_requests_count, new Object[]{String.valueOf(friendsNotificationsCount)}, null, 4));
    }

    public final void addHeightChangedListener(HeightChangedListener heightChangedListener) {
        Intrinsics3.checkNotNullParameter(heightChangedListener, "heightChangedListener");
        this.heightChangedListeners.add(heightChangedListener);
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Iterator<T> it = this.heightChangedListeners.iterator();
        while (it.hasNext()) {
            ((HeightChangedListener) it.next()).onHeightChanged(h);
        }
    }

    public final void updateView(NavigationTab selectedTab, Function1<? super NavigationTab, Unit> onTabSelected, boolean buttonsEnabled, long myUserId, Set<? extends NavigationTab> visibleTabs, int homeNotificationsCount, int friendsNotificationsCount, Function0<Unit> onSearchClick, Function0<Unit> onSettingsLongPress, Function0<Unit> onMentionsLongPress) {
        Intrinsics3.checkNotNullParameter(selectedTab, "selectedTab");
        Intrinsics3.checkNotNullParameter(onTabSelected, "onTabSelected");
        Intrinsics3.checkNotNullParameter(visibleTabs, "visibleTabs");
        Intrinsics3.checkNotNullParameter(onSearchClick, "onSearchClick");
        Intrinsics3.checkNotNullParameter(onSettingsLongPress, "onSettingsLongPress");
        Intrinsics3.checkNotNullParameter(onMentionsLongPress, "onMentionsLongPress");
        LinearLayout linearLayout = this.binding.f15305l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.tabsHostBottomNavTabsContainer");
        linearLayout.setWeightSum(visibleTabs.size());
        ConstraintLayout constraintLayout = this.binding.f15299f;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.tabsHostBottomNavHomeItem");
        constraintLayout.setVisibility(visibleTabs.contains(NavigationTab.HOME) ? 0 : 8);
        ConstraintLayout constraintLayout2 = this.binding.f15296c;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.tabsHostBottomNavFriendsItem");
        constraintLayout2.setVisibility(visibleTabs.contains(NavigationTab.FRIENDS) ? 0 : 8);
        FrameLayout frameLayout = this.binding.f15304k;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.tabsHostBottomNavSearchItem");
        frameLayout.setVisibility(visibleTabs.contains(NavigationTab.SEARCH) ? 0 : 8);
        FrameLayout frameLayout2 = this.binding.f15302i;
        Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.tabsHostBottomNavMentionsItem");
        frameLayout2.setVisibility(visibleTabs.contains(NavigationTab.MENTIONS) ? 0 : 8);
        FrameLayout frameLayout3 = this.binding.f15307n;
        Intrinsics3.checkNotNullExpressionValue(frameLayout3, "binding.tabsHostBottomNavUserSettingsItem");
        frameLayout3.setVisibility(visibleTabs.contains(NavigationTab.SETTINGS) ? 0 : 8);
        Map<ImageView, ? extends NavigationTab> map = this.tintableIconToNavigationTabMap;
        if (map == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("tintableIconToNavigationTabMap");
        }
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ColorCompat2.tintWithColor((ImageView) entry.getKey(), ColorCompat.getThemedColor(getContext(), ((NavigationTab) entry.getValue()) == selectedTab ? C5419R.attr.colorTabsIconActive : C5419R.attr.colorInteractiveNormal));
        }
        Map<View, ? extends NavigationTab> map2 = this.iconToNavigationTabMap;
        if (map2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("iconToNavigationTabMap");
        }
        Iterator<T> it2 = map2.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            ((View) entry2.getKey()).setAlpha(selectedTab == ((NavigationTab) entry2.getValue()) ? 1.0f : 0.5f);
        }
        Map<NavigationTab, ? extends View> map3 = this.navigationTabToViewMap;
        if (map3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("navigationTabToViewMap");
        }
        Iterator<T> it3 = map3.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it3.next();
            ((View) entry3.getValue()).setSelected(selectedTab == ((NavigationTab) entry3.getKey()));
        }
        UserAvatarPresenceViewController userAvatarPresenceViewController = this.userAvatarPresenceViewController;
        if (userAvatarPresenceViewController == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("userAvatarPresenceViewController");
        }
        long j = userAvatarPresenceViewController.userId;
        userAvatarPresenceViewController.userId = myUserId;
        if (j != myUserId) {
            userAvatarPresenceViewController.bind();
        }
        updateNotificationBadges(homeNotificationsCount, friendsNotificationsCount);
        if (!buttonsEnabled) {
            this.binding.f15299f.setOnClickListener(ViewOnClickListenerC1014110.INSTANCE);
            this.binding.f15296c.setOnClickListener(ViewOnClickListenerC1014211.INSTANCE);
            this.binding.f15304k.setOnClickListener(ViewOnClickListenerC1014312.INSTANCE);
            this.binding.f15302i.setOnClickListener(ViewOnClickListenerC1014413.INSTANCE);
            this.binding.f15307n.setOnClickListener(ViewOnClickListenerC1014514.INSTANCE);
            this.binding.f15307n.setOnLongClickListener(ViewOnLongClickListenerC1014615.INSTANCE);
            this.binding.f15302i.setOnLongClickListener(ViewOnLongClickListenerC1014716.INSTANCE);
            return;
        }
        this.binding.f15299f.setOnClickListener(new ViewOnClickListenerC101484(onTabSelected));
        this.binding.f15296c.setOnClickListener(new ViewOnClickListenerC101495(onTabSelected));
        this.binding.f15304k.setOnClickListener(new ViewOnClickListenerC101506(onSearchClick));
        this.binding.f15302i.setOnClickListener(new ViewOnClickListenerC101517(onTabSelected));
        this.binding.f15307n.setOnClickListener(new ViewOnClickListenerC101528(onTabSelected));
        FrameLayout frameLayout4 = this.binding.f15307n;
        Intrinsics3.checkNotNullExpressionValue(frameLayout4, "binding.tabsHostBottomNavUserSettingsItem");
        ViewExtensions.setOnLongClickListenerConsumeClick(frameLayout4, new C101539(onSettingsLongPress));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostBottomNavigationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        TabsHostBottomNavigationViewBinding tabsHostBottomNavigationViewBindingM8390a = TabsHostBottomNavigationViewBinding.m8390a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationViewBindingM8390a, "TabsHostBottomNavigation…rom(context), this, true)");
        this.binding = tabsHostBottomNavigationViewBindingM8390a;
        this.heightChangedListeners = new LinkedHashSet();
        initialize();
    }

    public /* synthetic */ TabsHostBottomNavigationView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabsHostBottomNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        TabsHostBottomNavigationViewBinding tabsHostBottomNavigationViewBindingM8390a = TabsHostBottomNavigationViewBinding.m8390a(LayoutInflater.from(getContext()), this, true);
        Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationViewBindingM8390a, "TabsHostBottomNavigation…rom(context), this, true)");
        this.binding = tabsHostBottomNavigationViewBindingM8390a;
        this.heightChangedListeners = new LinkedHashSet();
        initialize();
    }

    public /* synthetic */ TabsHostBottomNavigationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
