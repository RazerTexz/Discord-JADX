package com.discord.widgets.directories;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.C5419R;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetDirectoryChannelBinding;
import com.discord.models.guild.Guild;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreStream;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.hubs.HubUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.recycler.ViewPager2Extensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.directories.ServerDiscoveryHeader;
import com.discord.widgets.directories.WidgetDirectoriesViewModel;
import com.discord.widgets.hubs.WidgetHubAddName;
import com.discord.widgets.hubs.WidgetHubAddNameViewModel3;
import com.discord.widgets.hubs.WidgetHubAddServer;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppViewModelDelegates2;
import p007b.p008a.p025i.WidgetDirectoryChannelEmptyBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p008a.p039o.PanelsChildGestureRegionObserver;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* compiled from: WidgetDirectoryChannel.kt */
/* loaded from: classes2.dex */
public final class WidgetDirectoryChannel extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetDirectoryChannel.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDirectoryChannelBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int TAB_LAYOUT_MARGINS = DimenUtils.dpToPixels(48);
    private final ActivityResultLauncher<Intent> activityResult;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean hasBound;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetDirectoryChannel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final int getTAB_LAYOUT_MARGINS() {
            return WidgetDirectoryChannel.access$getTAB_LAYOUT_MARGINS$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetDirectoryChannel.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$initializeUI$1 */
    public static final class ViewOnClickListenerC82941 implements View.OnClickListener {
        public ViewOnClickListenerC82941() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppScreen2.f524g.m160f(WidgetDirectoryChannel.this.requireContext(), WidgetDirectoryChannel.access$getActivityResult$p(WidgetDirectoryChannel.this), WidgetHubAddServer.class, null);
        }
    }

    /* compiled from: WidgetDirectoryChannel.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$initializeUI$5 */
    public static final class C82955 extends Lambda implements Function1<Long, Unit> {
        public C82955() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            Guild guild;
            Context context;
            StoreStream.Companion companion = StoreStream.INSTANCE;
            long selectedGuildId = companion.getGuildSelected().getSelectedGuildId();
            GuildMember member = companion.getGuilds().getMember(selectedGuildId, companion.getUsers().getMeSnapshot().getId());
            if (member == null || (guild = companion.getGuilds().getGuild(selectedGuildId)) == null || (context = WidgetDirectoryChannel.this.getContext()) == null) {
                return;
            }
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return@appSubscribe");
            if (WidgetDirectoryChannel.this.isVisible() && selectedGuildId == j && guild.isHub()) {
                String nick = member.getNick();
                if (!(nick == null || StringsJVM.isBlank(nick)) || companion.getDirectories().getAndSetSeenNamePrompt(selectedGuildId) || GrowthTeamFeatures.INSTANCE.isHubNameKillSwitchEnabled()) {
                    return;
                }
                AppScreen2.m156d(context, WidgetHubAddName.class, new WidgetHubAddNameViewModel3(guild.getId()));
            }
        }
    }

    /* compiled from: WidgetDirectoryChannel.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$onViewBoundOrOnResume$1 */
    public static final class C82961<T, R> implements Func1<WidgetDirectoriesViewModel.ViewState, Boolean> {
        public static final C82961 INSTANCE = new C82961();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(WidgetDirectoriesViewModel.ViewState viewState) {
            return call2(viewState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(WidgetDirectoriesViewModel.ViewState viewState) {
            return Boolean.valueOf(viewState != null);
        }
    }

    /* compiled from: WidgetDirectoryChannel.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$onViewBoundOrOnResume$2 */
    public static final class C82972 extends Lambda implements Function1<WidgetDirectoriesViewModel.ViewState, Unit> {
        public C82972() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetDirectoriesViewModel.ViewState viewState) {
            WidgetDirectoryChannel.this.initializeUI();
        }
    }

    /* compiled from: WidgetDirectoryChannel.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$onViewBoundOrOnResume$3 */
    public static final class C82983<T, R> implements Func1<WidgetDirectoriesViewModel.ViewState, Boolean> {
        public static final C82983 INSTANCE = new C82983();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(WidgetDirectoriesViewModel.ViewState viewState) {
            return call2(viewState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(WidgetDirectoriesViewModel.ViewState viewState) {
            return Boolean.valueOf(viewState != null);
        }
    }

    /* compiled from: WidgetDirectoryChannel.kt */
    /* renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$onViewBoundOrOnResume$4 */
    public static final class C82994 extends Lambda implements Function1<WidgetDirectoriesViewModel.ViewState, Unit> {
        public C82994() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetDirectoriesViewModel.ViewState viewState) {
            WidgetDirectoryChannel widgetDirectoryChannel = WidgetDirectoryChannel.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            WidgetDirectoryChannel.access$configureUi(widgetDirectoryChannel, viewState);
        }
    }

    public WidgetDirectoryChannel() {
        super(C5419R.layout.widget_directory_channel);
        this.binding = FragmentViewBindingDelegate3.viewBinding(this, WidgetDirectoryChannel3.INSTANCE, new WidgetDirectoryChannel4(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetDirectoriesViewModel.class), new C8291x2378b3d9(this), new AppViewModelDelegates2(WidgetDirectoryChannel8.INSTANCE));
        this.adapter = LazyJVM.lazy(new WidgetDirectoryChannel2(this));
        this.activityResult = HubUtils.getAddServerActivityResultHandler(this);
    }

    public static final /* synthetic */ void access$configureUi(WidgetDirectoryChannel widgetDirectoryChannel, WidgetDirectoriesViewModel.ViewState viewState) {
        widgetDirectoryChannel.configureUi(viewState);
    }

    public static final /* synthetic */ ActivityResultLauncher access$getActivityResult$p(WidgetDirectoryChannel widgetDirectoryChannel) {
        return widgetDirectoryChannel.activityResult;
    }

    public static final /* synthetic */ int access$getTAB_LAYOUT_MARGINS$cp() {
        return TAB_LAYOUT_MARGINS;
    }

    public static final /* synthetic */ void access$onViewBindingDestroy(WidgetDirectoryChannel widgetDirectoryChannel, WidgetDirectoryChannelBinding widgetDirectoryChannelBinding) {
        widgetDirectoryChannel.onViewBindingDestroy(widgetDirectoryChannelBinding);
    }

    public static /* synthetic */ void bindGestureObservers$default(WidgetDirectoryChannel widgetDirectoryChannel, boolean z2, WidgetDirectoryChannelBinding widgetDirectoryChannelBinding, int i, Object obj) {
        if ((i & 2) != 0) {
            widgetDirectoryChannelBinding = null;
        }
        widgetDirectoryChannel.bindGestureObservers(z2, widgetDirectoryChannelBinding);
    }

    private final void configureUi(WidgetDirectoriesViewModel.ViewState state) {
        Guild guild = state.getGuild();
        if (guild != null) {
            getBinding().f16466f.f791d.setOnClickListener(new WidgetDirectoryChannel6(guild, this));
            TextView textView = getBinding().f16466f.f789b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.widgetDirectoryC….itemDirectoryEmptyHeader");
            textView.setText(FormatUtils.m219k(this, C5419R.string.hub_directory_channel_empty_title, new Object[]{guild.getName()}, null, 4));
        }
        ServerDiscoveryHeader serverDiscoveryHeader = getBinding().f16463c;
        serverDiscoveryHeader.setButtonOnClickListener(new WidgetDirectoryChannel5(serverDiscoveryHeader, state));
        List<DirectoryEntryGuild> listInvoke = state.getDirectories().invoke();
        boolean z2 = listInvoke != null && (listInvoke.isEmpty() ^ true);
        ServerDiscoveryHeader serverDiscoveryHeader2 = getBinding().f16463c;
        Intrinsics3.checkNotNullExpressionValue(serverDiscoveryHeader2, "binding.header");
        serverDiscoveryHeader2.setVisibility(z2 ? 0 : 8);
        ViewPager2 viewPager2 = getBinding().f16465e;
        Intrinsics3.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        viewPager2.setVisibility(z2 ? 0 : 8);
        WidgetDirectoryChannelEmptyBinding widgetDirectoryChannelEmptyBinding = getBinding().f16466f;
        Intrinsics3.checkNotNullExpressionValue(widgetDirectoryChannelEmptyBinding, "binding.widgetDirectoryChannelEmpty");
        LinearLayout linearLayout = widgetDirectoryChannelEmptyBinding.f788a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.widgetDirectoryChannelEmpty.root");
        linearLayout.setVisibility(z2 ^ true ? 0 : 8);
        Map<Integer, Integer> mapInvoke = state.getTabs().invoke();
        boolean z3 = !(mapInvoke == null || mapInvoke.isEmpty());
        toggleHeaderMargins(z3);
        TabLayout tabLayout = getBinding().f16464d;
        Intrinsics3.checkNotNullExpressionValue(tabLayout, "binding.tabs");
        tabLayout.setVisibility(z3 ? 0 : 8);
        WidgetDirectoryChannelViewPagerAdapter adapter = getAdapter();
        List<Tuples2<DirectoryEntryCategory, Integer>> mappedTabs = state.getMappedTabs();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(mappedTabs, 10));
        Iterator<T> it = mappedTabs.iterator();
        while (it.hasNext()) {
            arrayList.add((DirectoryEntryCategory) ((Tuples2) it.next()).getFirst());
        }
        adapter.setTabs(_Collections.toList(arrayList));
    }

    private final void onViewBindingDestroy(WidgetDirectoryChannelBinding binding) {
        bindGestureObservers(false, binding);
    }

    private final void toggleHeaderMargins(boolean showTabLayout) {
        int i = showTabLayout ? TAB_LAYOUT_MARGINS : 0;
        ServerDiscoveryHeader serverDiscoveryHeader = getBinding().f16463c;
        Intrinsics3.checkNotNullExpressionValue(serverDiscoveryHeader, "binding.header");
        ViewGroup.LayoutParams layoutParams = serverDiscoveryHeader.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = i;
        serverDiscoveryHeader.setLayoutParams(marginLayoutParams);
        Toolbar toolbar = getBinding().f16462b;
        Intrinsics3.checkNotNullExpressionValue(toolbar, "binding.actionBarToolbar");
        ViewGroup.LayoutParams layoutParams2 = toolbar.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams2.bottomMargin = i;
        toolbar.setLayoutParams(marginLayoutParams2);
    }

    public final void bindGestureObservers(boolean bind, WidgetDirectoryChannelBinding binding) {
        if (binding == null) {
            binding = getBinding();
        }
        if (!this.hasBound && bind) {
            PanelsChildGestureRegionObserver panelsChildGestureRegionObserverM232a = PanelsChildGestureRegionObserver.b.m232a();
            TabLayout tabLayout = binding.f16464d;
            Intrinsics3.checkNotNullExpressionValue(tabLayout, "nonNullBinding.tabs");
            panelsChildGestureRegionObserverM232a.m230b(tabLayout);
            PanelsChildGestureRegionObserver panelsChildGestureRegionObserverM232a2 = PanelsChildGestureRegionObserver.b.m232a();
            ViewPager2 viewPager2 = binding.f16465e;
            Intrinsics3.checkNotNullExpressionValue(viewPager2, "nonNullBinding.viewPager");
            panelsChildGestureRegionObserverM232a2.m230b(viewPager2);
            this.hasBound = true;
            return;
        }
        if (bind) {
            return;
        }
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverM232a3 = PanelsChildGestureRegionObserver.b.m232a();
        TabLayout tabLayout2 = binding.f16464d;
        Intrinsics3.checkNotNullExpressionValue(tabLayout2, "nonNullBinding.tabs");
        panelsChildGestureRegionObserverM232a3.m231c(tabLayout2);
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverM232a4 = PanelsChildGestureRegionObserver.b.m232a();
        ViewPager2 viewPager22 = binding.f16465e;
        Intrinsics3.checkNotNullExpressionValue(viewPager22, "nonNullBinding.viewPager");
        panelsChildGestureRegionObserverM232a4.m231c(viewPager22);
        this.hasBound = false;
    }

    public final WidgetDirectoryChannelViewPagerAdapter getAdapter() {
        return (WidgetDirectoryChannelViewPagerAdapter) this.adapter.getValue();
    }

    public final WidgetDirectoryChannelBinding getBinding() {
        return (WidgetDirectoryChannelBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final WidgetDirectoriesViewModel getViewModel() {
        return (WidgetDirectoriesViewModel) this.viewModel.getValue();
    }

    @SuppressLint({"SetTextI18n"})
    public final void initializeUI() {
        getBinding().f16466f.f790c.setOnClickListener(new ViewOnClickListenerC82941());
        ServerDiscoveryHeader serverDiscoveryHeader = getBinding().f16463c;
        serverDiscoveryHeader.setTitle(getString(C5419R.string.hub_directory_search_title));
        serverDiscoveryHeader.setDescription(getString(C5419R.string.hub_directory_search_subtitle));
        getBinding().f16465e.setAdapter(getAdapter());
        TabLayout tabLayout = getBinding().f16464d;
        ViewPager2 viewPager2 = getBinding().f16465e;
        Intrinsics3.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        ViewPager2Extensions.setUpWithViewPager2(tabLayout, viewPager2, new WidgetDirectoryChannel7(tabLayout, this));
        bindGestureObservers$default(this, true, null, 2, null);
        Observable<Long> observableM11112r = StoreStream.INSTANCE.getGuildSelected().observeSelectedGuildId().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "StoreStream\n        .get…  .distinctUntilChanged()");
        Observable<R> observableM11083G = observableM11112r.m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(observableM11083G), WidgetDirectoryChannel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C82955(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetDirectoriesViewModel.ViewState> observableM11119z = getViewModel().observeViewState().m11118y(C82961.INSTANCE).m11119z();
        Intrinsics3.checkNotNullExpressionValue(observableM11119z, "viewModel\n        .obser…= null }\n        .first()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11119z, this, null, 2, null), WidgetDirectoryChannel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C82972(), 62, (Object) null);
        Observable<WidgetDirectoriesViewModel.ViewState> observableM11118y = getViewModel().observeViewState().m11118y(C82983.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11118y, "viewModel\n        .obser…   .filter { it != null }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11118y, this, null, 2, null), WidgetDirectoryChannel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C82994(), 62, (Object) null);
    }
}
