package com.discord.widgets.forums;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.a.i.p;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetForumBrowserBinding;
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions;
import com.discord.widgets.forums.ForumBrowserItem;
import com.discord.widgets.forums.WidgetForumBrowserViewModel;
import com.discord.widgets.forums.WidgetForumGuidelinesBottomSheet;
import com.discord.widgets.home.WidgetHomePanelNsfw;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.d0.f;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetForumBrowser.kt */
/* loaded from: classes2.dex */
public final class WidgetForumBrowser extends AppFragment {
    private static final String CLOSE_FORUM_GUIDELINES_NOOP_REQUEST_KEY = "CLOSE_FORUM_GUIDELINES_NOOP_REQUEST_KEY";
    private static final String CLOSE_FORUM_GUIDELINES_REQUEST_KEY = "CLOSE_FORUM_GUIDELINES_REQUEST_KEY";
    private final List<ForumBrowserItem> adapterDataReference;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetForumBrowserAdapter forumBrowserAdapter;
    private ForumBrowserLayoutManager forumBrowserLayoutManager;
    private ForumBrowserScrollListener forumBrowserScrollListener;
    private WidgetHomePanelNsfw panelNsfw;
    private boolean panelNsfwHidden;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetForumBrowser.class, "binding", "getBinding()Lcom/discord/databinding/WidgetForumBrowserBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetForumBrowser.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context) {
            if (context != null) {
                j.e(context, WidgetForumBrowser.class, null, 4);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetForumBrowser.kt */
    /* renamed from: com.discord.widgets.forums.WidgetForumBrowser$configureCreatePostButton$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function2<Long, Long, Unit> {
        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
            invoke(l.longValue(), l2.longValue());
            return Unit.a;
        }

        public final void invoke(long j, long j2) {
            WidgetForumBrowser.access$openCreatePostScreen(WidgetForumBrowser.this, j, j2);
        }
    }

    /* compiled from: WidgetForumBrowser.kt */
    /* renamed from: com.discord.widgets.forums.WidgetForumBrowser$handleViewState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Boolean, Unit> {
        public final /* synthetic */ WidgetForumBrowserViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WidgetForumBrowserViewModel.ViewState viewState) {
            super(1);
            this.$viewState = viewState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            WidgetForumBrowser.access$setPanelNsfwHidden$p(WidgetForumBrowser.this, !z2);
            WidgetForumBrowserViewModel.ViewState viewState = this.$viewState;
            if (viewState instanceof WidgetForumBrowserViewModel.ViewState.Loaded) {
                WidgetForumBrowser.access$configureCreatePostButton(WidgetForumBrowser.this, (WidgetForumBrowserViewModel.ViewState.Loaded) viewState);
                WidgetForumBrowser.access$configureGuidelinesButton(WidgetForumBrowser.this, (WidgetForumBrowserViewModel.ViewState.Loaded) this.$viewState);
            }
        }
    }

    /* compiled from: WidgetForumBrowser.kt */
    /* renamed from: com.discord.widgets.forums.WidgetForumBrowser$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<WidgetForumBrowserViewModel.Event, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetForumBrowserViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetForumBrowserViewModel.Event event) {
            m.checkNotNullParameter(event, "event");
            WidgetForumBrowser.access$handleEvent(WidgetForumBrowser.this, event);
        }
    }

    /* compiled from: WidgetForumBrowser.kt */
    /* renamed from: com.discord.widgets.forums.WidgetForumBrowser$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<WidgetForumBrowserViewModel.ViewState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetForumBrowserViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetForumBrowserViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "viewState");
            WidgetForumBrowser.access$handleViewState(WidgetForumBrowser.this, viewState);
        }
    }

    /* compiled from: WidgetForumBrowser.kt */
    /* renamed from: com.discord.widgets.forums.WidgetForumBrowser$onViewBound$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<Channel, Unit> {
        public AnonymousClass1(WidgetForumBrowser widgetForumBrowser) {
            super(1, widgetForumBrowser, WidgetForumBrowser.class, "openForumPost", "openForumPost(Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            m.checkNotNullParameter(channel, "p1");
            WidgetForumBrowser.access$openForumPost((WidgetForumBrowser) this.receiver, channel);
        }
    }

    /* compiled from: WidgetForumBrowser.kt */
    /* renamed from: com.discord.widgets.forums.WidgetForumBrowser$onViewBound$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<Channel, Unit> {
        public AnonymousClass2(WidgetForumBrowser widgetForumBrowser) {
            super(1, widgetForumBrowser, WidgetForumBrowser.class, "openForumPostOptions", "openForumPostOptions(Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            m.checkNotNullParameter(channel, "p1");
            WidgetForumBrowser.access$openForumPostOptions((WidgetForumBrowser) this.receiver, channel);
        }
    }

    /* compiled from: WidgetForumBrowser.kt */
    /* renamed from: com.discord.widgets.forums.WidgetForumBrowser$setWindowInsetListener$1, reason: invalid class name */
    public static final class AnonymousClass1 implements OnApplyWindowInsetsListener {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            m.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
            m.checkNotNullExpressionValue(view, "view");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = insets.bottom;
            view.setLayoutParams(layoutParams2);
            return windowInsetsCompat;
        }
    }

    public WidgetForumBrowser() {
        super(R.layout.widget_forum_browser);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetForumBrowser$binding$2.INSTANCE, null, 2, null);
        WidgetForumBrowser$viewModel$2 widgetForumBrowser$viewModel$2 = WidgetForumBrowser$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetForumBrowserViewModel.class), new WidgetForumBrowser$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetForumBrowser$viewModel$2));
        this.adapterDataReference = new ArrayList();
        this.panelNsfwHidden = true;
    }

    public static final /* synthetic */ void access$configureCreatePostButton(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel.ViewState.Loaded loaded) {
        widgetForumBrowser.configureCreatePostButton(loaded);
    }

    public static final /* synthetic */ void access$configureGuidelinesButton(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel.ViewState.Loaded loaded) {
        widgetForumBrowser.configureGuidelinesButton(loaded);
    }

    public static final /* synthetic */ void access$enqueueForumPostFirstMessageFetches(WidgetForumBrowser widgetForumBrowser, long j, long j2) {
        widgetForumBrowser.enqueueForumPostFirstMessageFetches(j, j2);
    }

    public static final /* synthetic */ boolean access$getPanelNsfwHidden$p(WidgetForumBrowser widgetForumBrowser) {
        return widgetForumBrowser.panelNsfwHidden;
    }

    public static final /* synthetic */ WidgetForumBrowserViewModel access$getViewModel$p(WidgetForumBrowser widgetForumBrowser) {
        return widgetForumBrowser.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel.Event event) {
        widgetForumBrowser.handleEvent(event);
    }

    public static final /* synthetic */ void access$handleViewState(WidgetForumBrowser widgetForumBrowser, WidgetForumBrowserViewModel.ViewState viewState) {
        widgetForumBrowser.handleViewState(viewState);
    }

    public static final /* synthetic */ void access$onCreatePostClick(WidgetForumBrowser widgetForumBrowser, long j, long j2, boolean z2) {
        widgetForumBrowser.onCreatePostClick(j, j2, z2);
    }

    public static final /* synthetic */ void access$onLayoutCompleted(WidgetForumBrowser widgetForumBrowser, long j, long j2) {
        widgetForumBrowser.onLayoutCompleted(j, j2);
    }

    public static final /* synthetic */ void access$openCreatePostScreen(WidgetForumBrowser widgetForumBrowser, long j, long j2) {
        widgetForumBrowser.openCreatePostScreen(j, j2);
    }

    public static final /* synthetic */ void access$openForumPost(WidgetForumBrowser widgetForumBrowser, Channel channel) {
        widgetForumBrowser.openForumPost(channel);
    }

    public static final /* synthetic */ void access$openForumPostOptions(WidgetForumBrowser widgetForumBrowser, Channel channel) {
        widgetForumBrowser.openForumPostOptions(channel);
    }

    public static final /* synthetic */ void access$setPanelNsfwHidden$p(WidgetForumBrowser widgetForumBrowser, boolean z2) {
        widgetForumBrowser.panelNsfwHidden = z2;
    }

    private final void configureCreatePostButton(WidgetForumBrowserViewModel.ViewState.Loaded viewState) {
        ExtendedFloatingActionButton extendedFloatingActionButton = getBinding().f2387b;
        extendedFloatingActionButton.setVisibility(viewState.getCanCreateForumChannelPosts() && this.panelNsfwHidden ? 0 : 8);
        if (extendedFloatingActionButton.getVisibility() == 0) {
            String channelTopic = viewState.getChannelTopic();
            extendedFloatingActionButton.setOnClickListener(new WidgetForumBrowser$configureCreatePostButton$$inlined$apply$lambda$1(!(channelTopic == null || channelTopic.length() == 0), this, viewState));
        }
        WidgetForumGuidelinesBottomSheet.INSTANCE.registerForResult(this, CLOSE_FORUM_GUIDELINES_REQUEST_KEY, new AnonymousClass2());
    }

    private final void configureEmptyState(WidgetForumBrowserViewModel.ViewState.Loaded viewState) {
        b.a.i.o oVar = getBinding().c;
        m.checkNotNullExpressionValue(oVar, "binding.emptyView");
        ConstraintLayout constraintLayout = oVar.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.emptyView.root");
        constraintLayout.setVisibility(0);
        RecyclerView recyclerView = getBinding().f;
        m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(8);
        this.adapterDataReference.clear();
        TextView textView = getBinding().c.f170b;
        m.checkNotNullExpressionValue(textView, "binding.emptyView.forumBrowserEmptySubheading");
        b.n(textView, R.string.forum_empty_state_description, new Object[]{viewState.getChannelName()}, null, 4);
    }

    private final void configureGuidelinesButton(WidgetForumBrowserViewModel.ViewState.Loaded viewState) {
        FloatingActionButton floatingActionButton = getBinding().g;
        String channelTopic = viewState.getChannelTopic();
        floatingActionButton.setVisibility(!(channelTopic == null || channelTopic.length() == 0) && this.panelNsfwHidden ? 0 : 8);
        if (floatingActionButton.getVisibility() == 0) {
            floatingActionButton.setOnClickListener(new WidgetForumBrowser$configureGuidelinesButton$$inlined$apply$lambda$1(this, viewState));
        }
    }

    private final void configureListState(WidgetForumBrowserViewModel.ViewState.Loaded viewState) {
        b.a.i.o oVar = getBinding().c;
        m.checkNotNullExpressionValue(oVar, "binding.emptyView");
        ConstraintLayout constraintLayout = oVar.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.emptyView.root");
        constraintLayout.setVisibility(8);
        RecyclerView recyclerView = getBinding().f;
        m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(0);
        this.adapterDataReference.clear();
        this.adapterDataReference.addAll(viewState.getListItems());
        WidgetForumBrowserAdapter widgetForumBrowserAdapter = this.forumBrowserAdapter;
        if (widgetForumBrowserAdapter == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserAdapter");
        }
        widgetForumBrowserAdapter.setData(viewState.getListItems());
        ForumBrowserLayoutManager forumBrowserLayoutManager = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        forumBrowserLayoutManager.setOnLayoutCompletedCallback(new WidgetForumBrowser$configureListState$$inlined$apply$lambda$1(this, viewState));
        ForumBrowserScrollListener forumBrowserScrollListener = this.forumBrowserScrollListener;
        if (forumBrowserScrollListener == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserScrollListener");
        }
        forumBrowserScrollListener.setOnScrollCallback(new WidgetForumBrowser$configureListState$$inlined$apply$lambda$2(this, viewState));
        forumBrowserScrollListener.setOnScrollEndCallback(new WidgetForumBrowser$configureListState$$inlined$apply$lambda$3(this, viewState));
        forumBrowserScrollListener.setOnScrollStateChangedCallback(new WidgetForumBrowser$configureListState$$inlined$apply$lambda$4(this, viewState));
    }

    private final void enqueueForumPostFirstMessageFetches(long parentChannelId, long guildId) {
        ForumBrowserLayoutManager forumBrowserLayoutManager = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        int iFindFirstVisibleItemPosition = forumBrowserLayoutManager.findFirstVisibleItemPosition();
        if (iFindFirstVisibleItemPosition == -1) {
            return;
        }
        ForumBrowserLayoutManager forumBrowserLayoutManager2 = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager2 == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        if (forumBrowserLayoutManager2.findLastVisibleItemPosition() == -1) {
            return;
        }
        int size = this.adapterDataReference.size();
        if (this.forumBrowserLayoutManager == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        int i = (iFindFirstVisibleItemPosition / 10) * 10;
        int iCoerceAtMost = f.coerceAtMost(f.coerceAtMost(size, r4.getItemCount()) - 1, (((r3 / 10) + 1) * 10) - 1);
        if (i > iCoerceAtMost) {
            return;
        }
        while (true) {
            ForumBrowserItem forumBrowserItem = this.adapterDataReference.get(i);
            if (forumBrowserItem instanceof ForumBrowserItem.PostItem) {
                ForumBrowserItem.PostItem postItem = (ForumBrowserItem.PostItem) forumBrowserItem;
                if (postItem.getPost().getIsActivePost()) {
                    getViewModel().enqueueForumPostFirstMessageFetch(parentChannelId, guildId, postItem.getPost().getChannel().getId());
                }
            }
            if (i == iCoerceAtMost) {
                return;
            } else {
                i++;
            }
        }
    }

    private final WidgetForumBrowserBinding getBinding() {
        return (WidgetForumBrowserBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetForumBrowserViewModel getViewModel() {
        return (WidgetForumBrowserViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetForumBrowserViewModel.Event event) {
        if (event instanceof WidgetForumBrowserViewModel.Event.ScrollToTop) {
            getBinding().f.scrollToPosition(0);
        }
    }

    private final void handleViewState(WidgetForumBrowserViewModel.ViewState viewState) {
        WidgetForumBrowserViewModel.NsfwPanelState nsfwPanelState = viewState.getNsfwPanelState();
        WidgetHomePanelNsfw widgetHomePanelNsfw = this.panelNsfw;
        if (widgetHomePanelNsfw != null) {
            WidgetHomePanelNsfw.configureUI$default(widgetHomePanelNsfw, nsfwPanelState.getGuildId(), nsfwPanelState.isChannelNsfw(), nsfwPanelState.isNsfwUnconsented(), nsfwPanelState.getNsfwAllowed(), getBinding().e, new AnonymousClass1(viewState), null, 64, null);
        }
        if (!(viewState instanceof WidgetForumBrowserViewModel.ViewState.Loading)) {
            if (viewState instanceof WidgetForumBrowserViewModel.ViewState.Loaded) {
                p pVar = getBinding().d;
                m.checkNotNullExpressionValue(pVar, "binding.loadingView");
                ConstraintLayout constraintLayout = pVar.a;
                m.checkNotNullExpressionValue(constraintLayout, "binding.loadingView.root");
                constraintLayout.setVisibility(8);
                WidgetForumBrowserViewModel.ViewState.Loaded loaded = (WidgetForumBrowserViewModel.ViewState.Loaded) viewState;
                configureCreatePostButton(loaded);
                configureGuidelinesButton(loaded);
                if (loaded.getListItems().isEmpty()) {
                    configureEmptyState(loaded);
                    return;
                } else {
                    configureListState(loaded);
                    return;
                }
            }
            return;
        }
        p pVar2 = getBinding().d;
        m.checkNotNullExpressionValue(pVar2, "binding.loadingView");
        ConstraintLayout constraintLayout2 = pVar2.a;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.loadingView.root");
        constraintLayout2.setVisibility(0);
        b.a.i.o oVar = getBinding().c;
        m.checkNotNullExpressionValue(oVar, "binding.emptyView");
        ConstraintLayout constraintLayout3 = oVar.a;
        m.checkNotNullExpressionValue(constraintLayout3, "binding.emptyView.root");
        constraintLayout3.setVisibility(8);
        RecyclerView recyclerView = getBinding().f;
        m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(8);
        ExtendedFloatingActionButton extendedFloatingActionButton = getBinding().f2387b;
        m.checkNotNullExpressionValue(extendedFloatingActionButton, "binding.createPost");
        extendedFloatingActionButton.setVisibility(8);
        FloatingActionButton floatingActionButton = getBinding().g;
        m.checkNotNullExpressionValue(floatingActionButton, "binding.viewGuidelines");
        floatingActionButton.setVisibility(8);
        b.a.i.o oVar2 = getBinding().c;
        m.checkNotNullExpressionValue(oVar2, "binding.emptyView");
        ConstraintLayout constraintLayout4 = oVar2.a;
        m.checkNotNullExpressionValue(constraintLayout4, "binding.emptyView.root");
        constraintLayout4.setVisibility(8);
        this.adapterDataReference.clear();
        WidgetForumBrowserAdapter widgetForumBrowserAdapter = this.forumBrowserAdapter;
        if (widgetForumBrowserAdapter == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserAdapter");
        }
        widgetForumBrowserAdapter.setData(n.emptyList());
    }

    private final void onCreatePostClick(long guildId, long parentChannelId, boolean hasForumGuidelines) {
        if (!hasForumGuidelines || ForumGuidelinesManager.INSTANCE.hasSeenGuidelines(parentChannelId)) {
            openCreatePostScreen(guildId, parentChannelId);
            return;
        }
        WidgetForumGuidelinesBottomSheet.Companion companion = WidgetForumGuidelinesBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, guildId, parentChannelId, CLOSE_FORUM_GUIDELINES_REQUEST_KEY);
    }

    private final void onLayoutCompleted(long parentChannelId, long guildId) {
        List<ForumBrowserItem> list = this.adapterDataReference;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof ForumBrowserItem.PostItem) {
                arrayList.add(obj);
            }
        }
        boolean z2 = false;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((ForumBrowserItem.PostItem) it.next()).getPost().getIsActivePost()) {
                        z2 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z2) {
            enqueueForumPostFirstMessageFetches(parentChannelId, guildId);
            getViewModel().maybeFetchForumPostFirstMessages(parentChannelId, guildId, true);
            getViewModel().requestForumUnreads(parentChannelId, guildId);
        }
    }

    private final void openCreatePostScreen(long guildId, long channelId) {
        ChannelSelector.openCreateThread$default(ChannelSelector.INSTANCE.getInstance(), guildId, channelId, null, "Thread Browser Toolbar", 4, null);
    }

    private final void openForumPost(Channel channel) {
        ChannelSelector.INSTANCE.getInstance().selectChannel(channel, Long.valueOf(channel.getParentId()), SelectedChannelAnalyticsLocation.THREAD_BROWSER);
        requireActivity().onBackPressed();
    }

    private final void openForumPostOptions(Channel channel) {
        WidgetChannelsListItemThreadActions.Companion companion = WidgetChannelsListItemThreadActions.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, channel.getId());
    }

    private final void setWindowInsetListener(View viewBinding) {
        ViewCompat.setOnApplyWindowInsetsListener(viewBinding, AnonymousClass1.INSTANCE);
    }

    private final void setWindowInsetsListeners() {
        WidgetForumBrowserBinding binding = getBinding();
        m.checkNotNullExpressionValue(binding, "binding");
        ConstraintLayout constraintLayout = binding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        ViewExtensions.setForwardingWindowInsetsListener(constraintLayout);
        RecyclerView recyclerView = getBinding().f;
        m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        setWindowInsetListener(recyclerView);
        FloatingActionButton floatingActionButton = getBinding().g;
        m.checkNotNullExpressionValue(floatingActionButton, "binding.viewGuidelines");
        setWindowInsetListener(floatingActionButton);
        ExtendedFloatingActionButton extendedFloatingActionButton = getBinding().f2387b;
        m.checkNotNullExpressionValue(extendedFloatingActionButton, "binding.createPost");
        setWindowInsetListener(extendedFloatingActionButton);
    }

    public static final void show(Context context) {
        INSTANCE.show(context);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetForumBrowser.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetForumBrowser.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f;
        m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        this.forumBrowserAdapter = (WidgetForumBrowserAdapter) companion.configure(new WidgetForumBrowserAdapter(recyclerView, new AnonymousClass1(this), new AnonymousClass2(this)));
        RecyclerView recyclerView2 = getBinding().f;
        m.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        this.forumBrowserLayoutManager = new ForumBrowserLayoutManager(recyclerView2);
        this.forumBrowserScrollListener = new ForumBrowserScrollListener();
        RecyclerView recyclerView3 = getBinding().f;
        ForumBrowserLayoutManager forumBrowserLayoutManager = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        recyclerView3.setLayoutManager(forumBrowserLayoutManager);
        ForumBrowserScrollListener forumBrowserScrollListener = this.forumBrowserScrollListener;
        if (forumBrowserScrollListener == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserScrollListener");
        }
        recyclerView3.addOnScrollListener(forumBrowserScrollListener);
        WidgetForumBrowserAdapter widgetForumBrowserAdapter = this.forumBrowserAdapter;
        if (widgetForumBrowserAdapter == null) {
            m.throwUninitializedPropertyAccessException("forumBrowserAdapter");
        }
        recyclerView3.addItemDecoration(widgetForumBrowserAdapter.getItemDecoration());
        setWindowInsetsListeners();
        this.panelNsfw = new WidgetHomePanelNsfw(this);
    }
}
