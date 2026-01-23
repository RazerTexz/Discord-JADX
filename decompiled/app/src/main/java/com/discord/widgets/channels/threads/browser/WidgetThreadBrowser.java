package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewpager.widget.ViewPager;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadBrowserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.simple_pager.SimplePager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserFilterSheet;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserViewModel;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppViewModelDelegates2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.functions.Action1;
import p658rx.functions.Action2;

/* JADX INFO: compiled from: WidgetThreadBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowser extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetThreadBrowser.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadBrowserBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int ACTIVE_PAGE;
    private final int ARCHIVED_PAGE;

    /* JADX INFO: renamed from: archivedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy archivedViewModel;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private final ChannelSelector channelSelector;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private WidgetThreadBrowserViewModel.ViewState previousViewState;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetThreadBrowser.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, long guildId, long channelId, String location) {
            Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            if (context != null) {
                Intent intent = new Intent();
                intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
                intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
                AppScreen2.m156d(context, WidgetThreadBrowser.class, intent);
                AnalyticsTracker.openModal("Thread Browser", location, Long.valueOf(guildId));
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser$initializeAdapter$1 */
    /* JADX INFO: compiled from: WidgetThreadBrowser.kt */
    public static final class C76361 extends Lambda implements Function0<Fragment> {
        public C76361() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Fragment invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Fragment invoke() {
            return WidgetThreadBrowserActive.INSTANCE.create(WidgetThreadBrowser.access$getViewModel$p(WidgetThreadBrowser.this).getGuildId(), WidgetThreadBrowser.access$getViewModel$p(WidgetThreadBrowser.this).getChannelId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser$initializeAdapter$2 */
    /* JADX INFO: compiled from: WidgetThreadBrowser.kt */
    public static final class C76372 extends Lambda implements Function0<Fragment> {
        public C76372() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Fragment invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Fragment invoke() {
            return WidgetThreadBrowserArchived.INSTANCE.create(WidgetThreadBrowser.access$getViewModel$p(WidgetThreadBrowser.this).getGuildId(), WidgetThreadBrowser.access$getViewModel$p(WidgetThreadBrowser.this).getChannelId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser$initializeAdapter$3 */
    /* JADX INFO: compiled from: WidgetThreadBrowser.kt */
    public static final class C76383 implements ViewPager.OnPageChangeListener {
        public C76383() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            WidgetThreadBrowser widgetThreadBrowser = WidgetThreadBrowser.this;
            WidgetThreadBrowserViewModel.ViewState viewStateAccess$getPreviousViewState$p = WidgetThreadBrowser.access$getPreviousViewState$p(widgetThreadBrowser);
            if (!(viewStateAccess$getPreviousViewState$p instanceof WidgetThreadBrowserViewModel.ViewState.Browser)) {
                viewStateAccess$getPreviousViewState$p = null;
            }
            WidgetThreadBrowserViewModel.ViewState.Browser browser = (WidgetThreadBrowserViewModel.ViewState.Browser) viewStateAccess$getPreviousViewState$p;
            WidgetThreadBrowser.access$updateMenu(widgetThreadBrowser, position, browser != null ? Boolean.valueOf(browser.getCanCreateThread()) : null);
            if (position == WidgetThreadBrowser.access$getACTIVE_PAGE$p(WidgetThreadBrowser.this)) {
                StoreStream.INSTANCE.getAnalytics().trackThreadBrowserTabChanged(WidgetThreadBrowser.access$getChannelId$p(WidgetThreadBrowser.this), "Active Threads");
            } else if (position == WidgetThreadBrowser.access$getARCHIVED_PAGE$p(WidgetThreadBrowser.this)) {
                WidgetThreadBrowser.access$getArchivedViewModel$p(WidgetThreadBrowser.this).trackTabChanged();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser$onResume$1 */
    /* JADX INFO: compiled from: WidgetThreadBrowser.kt */
    public static final class C76391 extends Lambda implements Function1<WidgetThreadBrowserViewModel.ViewState, Unit> {
        public C76391() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadBrowserViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadBrowserViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetThreadBrowser.access$updateView(WidgetThreadBrowser.this, viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser$updateMenu$1 */
    /* JADX INFO: compiled from: WidgetThreadBrowser.kt */
    public static final class C76401<T1, T2> implements Action2<MenuItem, Context> {
        public C76401() {
        }

        @Override // p658rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case C5419R.id.menu_thread_browser_create_thread /* 2131364416 */:
                    ChannelSelector.openCreateThread$default(ChannelSelector.INSTANCE.getInstance(), WidgetThreadBrowser.access$getGuildId$p(WidgetThreadBrowser.this), WidgetThreadBrowser.access$getChannelId$p(WidgetThreadBrowser.this), null, "Thread Browser Toolbar", 4, null);
                    WidgetThreadBrowser.this.requireAppActivity().finish();
                    break;
                case C5419R.id.menu_thread_browser_filters /* 2131364417 */:
                    WidgetThreadBrowserFilterSheet.Companion companion = WidgetThreadBrowserFilterSheet.INSTANCE;
                    FragmentManager parentFragmentManager = WidgetThreadBrowser.this.getParentFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion.show(parentFragmentManager, WidgetThreadBrowser.access$getGuildId$p(WidgetThreadBrowser.this), WidgetThreadBrowser.access$getChannelId$p(WidgetThreadBrowser.this));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser$updateMenu$2 */
    /* JADX INFO: compiled from: WidgetThreadBrowser.kt */
    public static final class C76412<T> implements Action1<Menu> {
        public final /* synthetic */ Boolean $canCreateThread;
        public final /* synthetic */ int $selectedPage;

        public C76412(int i, Boolean bool) {
            this.$selectedPage = i;
            this.$canCreateThread = bool;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            MenuItem menuItemFindItem = menu.findItem(C5419R.id.menu_thread_browser_filters);
            if (menuItemFindItem != null) {
                menuItemFindItem.setVisible(this.$selectedPage == WidgetThreadBrowser.access$getARCHIVED_PAGE$p(WidgetThreadBrowser.this));
            }
            MenuItem menuItemFindItem2 = menu.findItem(C5419R.id.menu_thread_browser_create_thread);
            if (menuItemFindItem2 != null) {
                menuItemFindItem2.setVisible(this.$selectedPage == WidgetThreadBrowser.access$getACTIVE_PAGE$p(WidgetThreadBrowser.this) && Intrinsics3.areEqual(this.$canCreateThread, Boolean.TRUE));
            }
        }
    }

    public WidgetThreadBrowser() {
        super(C5419R.layout.widget_thread_browser);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetThreadBrowser3.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetThreadBrowser5(this));
        this.channelId = LazyJVM.lazy(new WidgetThreadBrowser4(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetThreadBrowserViewModel.class), new C7632x66275139(this), new AppViewModelDelegates2(new WidgetThreadBrowser6(this)));
        this.archivedViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetThreadBrowserArchivedViewModel.class), new C7634x6627513b(this), new AppViewModelDelegates2(new WidgetThreadBrowser2(this)));
        this.channelSelector = ChannelSelector.INSTANCE.getInstance();
        this.ARCHIVED_PAGE = 1;
    }

    public static final /* synthetic */ int access$getACTIVE_PAGE$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.ACTIVE_PAGE;
    }

    public static final /* synthetic */ int access$getARCHIVED_PAGE$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.ARCHIVED_PAGE;
    }

    public static final /* synthetic */ WidgetThreadBrowserArchivedViewModel access$getArchivedViewModel$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.getArchivedViewModel();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.getChannelId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.getGuildId();
    }

    public static final /* synthetic */ WidgetThreadBrowserViewModel.ViewState access$getPreviousViewState$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.previousViewState;
    }

    public static final /* synthetic */ WidgetThreadBrowserViewModel access$getViewModel$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.getViewModel();
    }

    public static final /* synthetic */ void access$setPreviousViewState$p(WidgetThreadBrowser widgetThreadBrowser, WidgetThreadBrowserViewModel.ViewState viewState) {
        widgetThreadBrowser.previousViewState = viewState;
    }

    public static final /* synthetic */ void access$updateMenu(WidgetThreadBrowser widgetThreadBrowser, int i, Boolean bool) {
        widgetThreadBrowser.updateMenu(i, bool);
    }

    public static final /* synthetic */ void access$updateView(WidgetThreadBrowser widgetThreadBrowser, WidgetThreadBrowserViewModel.ViewState viewState) {
        widgetThreadBrowser.updateView(viewState);
    }

    private final WidgetThreadBrowserArchivedViewModel getArchivedViewModel() {
        return (WidgetThreadBrowserArchivedViewModel) this.archivedViewModel.getValue();
    }

    private final WidgetThreadBrowserBinding getBinding() {
        return (WidgetThreadBrowserBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final WidgetThreadBrowserViewModel getViewModel() {
        return (WidgetThreadBrowserViewModel) this.viewModel.getValue();
    }

    private final void initializeAdapter(WidgetThreadBrowserViewModel.ViewState.Browser viewState) {
        SimplePager simplePager = getBinding().f18274c;
        Intrinsics3.checkNotNullExpressionValue(simplePager, "binding.threadBrowserViewPager");
        if (simplePager.getAdapter() == null) {
            ArrayList arrayList = new ArrayList();
            String string = getString(C5419R.string.thread_browser_active);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.thread_browser_active)");
            arrayList.add(new SimplePager.Adapter.Item(string, new C76361()));
            if (viewState.getCanViewArchivedThreads()) {
                String string2 = getString(C5419R.string.thread_browser_archived);
                Intrinsics3.checkNotNullExpressionValue(string2, "getString(R.string.thread_browser_archived)");
                arrayList.add(new SimplePager.Adapter.Item(string2, new C76372()));
            }
            SimplePager simplePager2 = getBinding().f18274c;
            Intrinsics3.checkNotNullExpressionValue(simplePager2, "binding.threadBrowserViewPager");
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            Object[] array = arrayList.toArray(new SimplePager.Adapter.Item[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            SimplePager.Adapter.Item[] itemArr = (SimplePager.Adapter.Item[]) array;
            simplePager2.setAdapter(new SimplePager.Adapter(parentFragmentManager, (SimplePager.Adapter.Item[]) Arrays.copyOf(itemArr, itemArr.length)));
            getBinding().f18274c.addOnPageChangeListener(new C76383());
            TabLayout tabLayout = getBinding().f18273b;
            Intrinsics3.checkNotNullExpressionValue(tabLayout, "binding.actionBarTabs");
            tabLayout.setVisibility(viewState.getCanViewArchivedThreads() ? 0 : 8);
        }
    }

    public static final void show(Context context, long j, long j2, String str) {
        INSTANCE.show(context, j, j2, str);
    }

    private final void updateMenu(int selectedPage, Boolean canCreateThread) {
        setActionBarOptionsMenu(C5419R.menu.menu_thread_browser, new C76401(), new C76412(selectedPage, canCreateThread));
    }

    private final void updateView(WidgetThreadBrowserViewModel.ViewState viewState) {
        this.previousViewState = viewState;
        if (viewState instanceof WidgetThreadBrowserViewModel.ViewState.GoToChannel) {
            ChannelSelector.selectChannel$default(this.channelSelector, ((WidgetThreadBrowserViewModel.ViewState.GoToChannel) viewState).getChannel(), null, StoreChannelsSelected3.THREAD_BROWSER, 2, null);
            requireActivity().onBackPressed();
            return;
        }
        if (viewState instanceof WidgetThreadBrowserViewModel.ViewState.Browser) {
            WidgetThreadBrowserViewModel.ViewState.Browser browser = (WidgetThreadBrowserViewModel.ViewState.Browser) viewState;
            initializeAdapter(browser);
            if (browser.getChannelName() != null && !browser.isForumChannel()) {
                StringBuilder sbM833U = outline.m833U("#");
                sbM833U.append(browser.getChannelName());
                setActionBarSubtitle(sbM833U.toString());
            }
            if (browser.getChannelName() != null && browser.isForumChannel()) {
                StringBuilder sbM833U2 = outline.m833U("#");
                sbM833U2.append(browser.getChannelName());
                setActionBarTitle(sbM833U2.toString());
            }
            SimplePager simplePager = getBinding().f18274c;
            Intrinsics3.checkNotNullExpressionValue(simplePager, "binding.threadBrowserViewPager");
            updateMenu(simplePager.getCurrentItem(), Boolean.valueOf(browser.getCanCreateThread()));
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetThreadBrowser.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C76391(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.thread_browser_title);
    }
}
