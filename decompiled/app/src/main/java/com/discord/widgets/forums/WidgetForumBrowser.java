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
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetForumBrowserBinding;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions;
import com.discord.widgets.forums.ForumBrowserItem;
import com.discord.widgets.forums.WidgetForumBrowserViewModel;
import com.discord.widgets.forums.WidgetForumGuidelinesBottomSheet;
import com.discord.widgets.home.WidgetHomePanelNsfw;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p025i.ForumBrowserEmptyBinding;
import p007b.p008a.p025i.ForumBrowserLoadingBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p512d0._Ranges;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetForumBrowser.class, "binding", "getBinding()Lcom/discord/databinding/WidgetForumBrowserBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetForumBrowser.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context) {
            if (context != null) {
                AppScreen2.m157e(context, WidgetForumBrowser.class, null, 4);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetForumBrowser.kt */
    /* renamed from: com.discord.widgets.forums.WidgetForumBrowser$configureCreatePostButton$2 */
    public static final class C83392 extends Lambda implements Function2<Long, Long, Unit> {
        public C83392() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
            invoke(l.longValue(), l2.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j, long j2) {
            WidgetForumBrowser.access$openCreatePostScreen(WidgetForumBrowser.this, j, j2);
        }
    }

    /* compiled from: WidgetForumBrowser.kt */
    /* renamed from: com.discord.widgets.forums.WidgetForumBrowser$handleViewState$1 */
    public static final class C83411 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ WidgetForumBrowserViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83411(WidgetForumBrowserViewModel.ViewState viewState) {
            super(1);
            this.$viewState = viewState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
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
    /* renamed from: com.discord.widgets.forums.WidgetForumBrowser$onResume$1 */
    public static final class C83421 extends Lambda implements Function1<WidgetForumBrowserViewModel.Event, Unit> {
        public C83421() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetForumBrowserViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetForumBrowserViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetForumBrowser.access$handleEvent(WidgetForumBrowser.this, event);
        }
    }

    /* compiled from: WidgetForumBrowser.kt */
    /* renamed from: com.discord.widgets.forums.WidgetForumBrowser$onResume$2 */
    public static final class C83432 extends Lambda implements Function1<WidgetForumBrowserViewModel.ViewState, Unit> {
        public C83432() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetForumBrowserViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetForumBrowserViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetForumBrowser.access$handleViewState(WidgetForumBrowser.this, viewState);
        }
    }

    /* compiled from: WidgetForumBrowser.kt */
    /* renamed from: com.discord.widgets.forums.WidgetForumBrowser$onViewBound$1 */
    public static final /* synthetic */ class C83441 extends FunctionReferenceImpl implements Function1<Channel, Unit> {
        public C83441(WidgetForumBrowser widgetForumBrowser) {
            super(1, widgetForumBrowser, WidgetForumBrowser.class, "openForumPost", "openForumPost(Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "p1");
            WidgetForumBrowser.access$openForumPost((WidgetForumBrowser) this.receiver, channel);
        }
    }

    /* compiled from: WidgetForumBrowser.kt */
    /* renamed from: com.discord.widgets.forums.WidgetForumBrowser$onViewBound$2 */
    public static final /* synthetic */ class C83452 extends FunctionReferenceImpl implements Function1<Channel, Unit> {
        public C83452(WidgetForumBrowser widgetForumBrowser) {
            super(1, widgetForumBrowser, WidgetForumBrowser.class, "openForumPostOptions", "openForumPostOptions(Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "p1");
            WidgetForumBrowser.access$openForumPostOptions((WidgetForumBrowser) this.receiver, channel);
        }
    }

    /* compiled from: WidgetForumBrowser.kt */
    /* renamed from: com.discord.widgets.forums.WidgetForumBrowser$setWindowInsetListener$1 */
    public static final class C83461 implements OnApplyWindowInsetsListener {
        public static final C83461 INSTANCE = new C83461();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            Intrinsics3.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = insets.bottom;
            view.setLayoutParams(layoutParams2);
            return windowInsetsCompat;
        }
    }

    public WidgetForumBrowser() {
        super(C5419R.layout.widget_forum_browser);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetForumBrowser2.INSTANCE, null, 2, null);
        WidgetForumBrowser9 widgetForumBrowser9 = WidgetForumBrowser9.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetForumBrowserViewModel.class), new WidgetForumBrowser$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetForumBrowser9));
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
        ExtendedFloatingActionButton extendedFloatingActionButton = getBinding().f16634b;
        extendedFloatingActionButton.setVisibility(viewState.getCanCreateForumChannelPosts() && this.panelNsfwHidden ? 0 : 8);
        if (extendedFloatingActionButton.getVisibility() == 0) {
            String channelTopic = viewState.getChannelTopic();
            extendedFloatingActionButton.setOnClickListener(new WidgetForumBrowser3(!(channelTopic == null || channelTopic.length() == 0), this, viewState));
        }
        WidgetForumGuidelinesBottomSheet.INSTANCE.registerForResult(this, CLOSE_FORUM_GUIDELINES_REQUEST_KEY, new C83392());
    }

    private final void configureEmptyState(WidgetForumBrowserViewModel.ViewState.Loaded viewState) {
        ForumBrowserEmptyBinding forumBrowserEmptyBinding = getBinding().f16635c;
        Intrinsics3.checkNotNullExpressionValue(forumBrowserEmptyBinding, "binding.emptyView");
        ConstraintLayout constraintLayout = forumBrowserEmptyBinding.f1092a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.emptyView.root");
        constraintLayout.setVisibility(0);
        RecyclerView recyclerView = getBinding().f16638f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(8);
        this.adapterDataReference.clear();
        TextView textView = getBinding().f16635c.f1093b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.emptyView.forumBrowserEmptySubheading");
        FormatUtils.m222n(textView, C5419R.string.forum_empty_state_description, new Object[]{viewState.getChannelName()}, null, 4);
    }

    private final void configureGuidelinesButton(WidgetForumBrowserViewModel.ViewState.Loaded viewState) {
        FloatingActionButton floatingActionButton = getBinding().f16639g;
        String channelTopic = viewState.getChannelTopic();
        floatingActionButton.setVisibility(!(channelTopic == null || channelTopic.length() == 0) && this.panelNsfwHidden ? 0 : 8);
        if (floatingActionButton.getVisibility() == 0) {
            floatingActionButton.setOnClickListener(new WidgetForumBrowser4(this, viewState));
        }
    }

    private final void configureListState(WidgetForumBrowserViewModel.ViewState.Loaded viewState) {
        ForumBrowserEmptyBinding forumBrowserEmptyBinding = getBinding().f16635c;
        Intrinsics3.checkNotNullExpressionValue(forumBrowserEmptyBinding, "binding.emptyView");
        ConstraintLayout constraintLayout = forumBrowserEmptyBinding.f1092a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.emptyView.root");
        constraintLayout.setVisibility(8);
        RecyclerView recyclerView = getBinding().f16638f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(0);
        this.adapterDataReference.clear();
        this.adapterDataReference.addAll(viewState.getListItems());
        WidgetForumBrowserAdapter widgetForumBrowserAdapter = this.forumBrowserAdapter;
        if (widgetForumBrowserAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserAdapter");
        }
        widgetForumBrowserAdapter.setData(viewState.getListItems());
        ForumBrowserLayoutManager forumBrowserLayoutManager = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        forumBrowserLayoutManager.setOnLayoutCompletedCallback(new WidgetForumBrowser5(this, viewState));
        ForumBrowserScrollListener forumBrowserScrollListener = this.forumBrowserScrollListener;
        if (forumBrowserScrollListener == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserScrollListener");
        }
        forumBrowserScrollListener.setOnScrollCallback(new WidgetForumBrowser6(this, viewState));
        forumBrowserScrollListener.setOnScrollEndCallback(new WidgetForumBrowser7(this, viewState));
        forumBrowserScrollListener.setOnScrollStateChangedCallback(new WidgetForumBrowser8(this, viewState));
    }

    private final void enqueueForumPostFirstMessageFetches(long parentChannelId, long guildId) {
        ForumBrowserLayoutManager forumBrowserLayoutManager = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        int iFindFirstVisibleItemPosition = forumBrowserLayoutManager.findFirstVisibleItemPosition();
        if (iFindFirstVisibleItemPosition == -1) {
            return;
        }
        ForumBrowserLayoutManager forumBrowserLayoutManager2 = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        if (forumBrowserLayoutManager2.findLastVisibleItemPosition() == -1) {
            return;
        }
        int size = this.adapterDataReference.size();
        if (this.forumBrowserLayoutManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        int i = (iFindFirstVisibleItemPosition / 10) * 10;
        int iCoerceAtMost = _Ranges.coerceAtMost(_Ranges.coerceAtMost(size, r4.getItemCount()) - 1, (((r3 / 10) + 1) * 10) - 1);
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
            getBinding().f16638f.scrollToPosition(0);
        }
    }

    private final void handleViewState(WidgetForumBrowserViewModel.ViewState viewState) {
        WidgetForumBrowserViewModel.NsfwPanelState nsfwPanelState = viewState.getNsfwPanelState();
        WidgetHomePanelNsfw widgetHomePanelNsfw = this.panelNsfw;
        if (widgetHomePanelNsfw != null) {
            WidgetHomePanelNsfw.configureUI$default(widgetHomePanelNsfw, nsfwPanelState.getGuildId(), nsfwPanelState.isChannelNsfw(), nsfwPanelState.isNsfwUnconsented(), nsfwPanelState.getNsfwAllowed(), getBinding().f16637e, new C83411(viewState), null, 64, null);
        }
        if (!(viewState instanceof WidgetForumBrowserViewModel.ViewState.Loading)) {
            if (viewState instanceof WidgetForumBrowserViewModel.ViewState.Loaded) {
                ForumBrowserLoadingBinding forumBrowserLoadingBinding = getBinding().f16636d;
                Intrinsics3.checkNotNullExpressionValue(forumBrowserLoadingBinding, "binding.loadingView");
                ConstraintLayout constraintLayout = forumBrowserLoadingBinding.f1121a;
                Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.loadingView.root");
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
        ForumBrowserLoadingBinding forumBrowserLoadingBinding2 = getBinding().f16636d;
        Intrinsics3.checkNotNullExpressionValue(forumBrowserLoadingBinding2, "binding.loadingView");
        ConstraintLayout constraintLayout2 = forumBrowserLoadingBinding2.f1121a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.loadingView.root");
        constraintLayout2.setVisibility(0);
        ForumBrowserEmptyBinding forumBrowserEmptyBinding = getBinding().f16635c;
        Intrinsics3.checkNotNullExpressionValue(forumBrowserEmptyBinding, "binding.emptyView");
        ConstraintLayout constraintLayout3 = forumBrowserEmptyBinding.f1092a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout3, "binding.emptyView.root");
        constraintLayout3.setVisibility(8);
        RecyclerView recyclerView = getBinding().f16638f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(8);
        ExtendedFloatingActionButton extendedFloatingActionButton = getBinding().f16634b;
        Intrinsics3.checkNotNullExpressionValue(extendedFloatingActionButton, "binding.createPost");
        extendedFloatingActionButton.setVisibility(8);
        FloatingActionButton floatingActionButton = getBinding().f16639g;
        Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.viewGuidelines");
        floatingActionButton.setVisibility(8);
        ForumBrowserEmptyBinding forumBrowserEmptyBinding2 = getBinding().f16635c;
        Intrinsics3.checkNotNullExpressionValue(forumBrowserEmptyBinding2, "binding.emptyView");
        ConstraintLayout constraintLayout4 = forumBrowserEmptyBinding2.f1092a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout4, "binding.emptyView.root");
        constraintLayout4.setVisibility(8);
        this.adapterDataReference.clear();
        WidgetForumBrowserAdapter widgetForumBrowserAdapter = this.forumBrowserAdapter;
        if (widgetForumBrowserAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserAdapter");
        }
        widgetForumBrowserAdapter.setData(Collections2.emptyList());
    }

    private final void onCreatePostClick(long guildId, long parentChannelId, boolean hasForumGuidelines) {
        if (!hasForumGuidelines || ForumGuidelinesManager.INSTANCE.hasSeenGuidelines(parentChannelId)) {
            openCreatePostScreen(guildId, parentChannelId);
            return;
        }
        WidgetForumGuidelinesBottomSheet.Companion companion = WidgetForumGuidelinesBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
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
        ChannelSelector.INSTANCE.getInstance().selectChannel(channel, Long.valueOf(channel.getParentId()), StoreChannelsSelected3.THREAD_BROWSER);
        requireActivity().onBackPressed();
    }

    private final void openForumPostOptions(Channel channel) {
        WidgetChannelsListItemThreadActions.Companion companion = WidgetChannelsListItemThreadActions.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, channel.getId());
    }

    private final void setWindowInsetListener(View viewBinding) {
        ViewCompat.setOnApplyWindowInsetsListener(viewBinding, C83461.INSTANCE);
    }

    private final void setWindowInsetsListeners() {
        WidgetForumBrowserBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        ConstraintLayout constraintLayout = binding.f16633a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        ViewExtensions.setForwardingWindowInsetsListener(constraintLayout);
        RecyclerView recyclerView = getBinding().f16638f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        setWindowInsetListener(recyclerView);
        FloatingActionButton floatingActionButton = getBinding().f16639g;
        Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.viewGuidelines");
        setWindowInsetListener(floatingActionButton);
        ExtendedFloatingActionButton extendedFloatingActionButton = getBinding().f16634b;
        Intrinsics3.checkNotNullExpressionValue(extendedFloatingActionButton, "binding.createPost");
        setWindowInsetListener(extendedFloatingActionButton);
    }

    public static final void show(Context context) {
        INSTANCE.show(context);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetForumBrowser.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C83421(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetForumBrowser.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C83432(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16638f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        this.forumBrowserAdapter = (WidgetForumBrowserAdapter) companion.configure(new WidgetForumBrowserAdapter(recyclerView, new C83441(this), new C83452(this)));
        RecyclerView recyclerView2 = getBinding().f16638f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        this.forumBrowserLayoutManager = new ForumBrowserLayoutManager(recyclerView2);
        this.forumBrowserScrollListener = new ForumBrowserScrollListener();
        RecyclerView recyclerView3 = getBinding().f16638f;
        ForumBrowserLayoutManager forumBrowserLayoutManager = this.forumBrowserLayoutManager;
        if (forumBrowserLayoutManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserLayoutManager");
        }
        recyclerView3.setLayoutManager(forumBrowserLayoutManager);
        ForumBrowserScrollListener forumBrowserScrollListener = this.forumBrowserScrollListener;
        if (forumBrowserScrollListener == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserScrollListener");
        }
        recyclerView3.addOnScrollListener(forumBrowserScrollListener);
        WidgetForumBrowserAdapter widgetForumBrowserAdapter = this.forumBrowserAdapter;
        if (widgetForumBrowserAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("forumBrowserAdapter");
        }
        recyclerView3.addItemDecoration(widgetForumBrowserAdapter.getItemDecoration());
        setWindowInsetsListeners();
        this.panelNsfw = new WidgetHomePanelNsfw(this);
    }
}
