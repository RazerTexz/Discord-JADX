package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadBrowserArchivedBinding;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetThreadBrowserArchived.kt */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserArchived extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetThreadBrowserArchived.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadBrowserArchivedBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private WidgetThreadBrowserAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: browserViewModel$delegate, reason: from kotlin metadata */
    private final Lazy browserViewModel;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private WidgetThreadBrowserArchivedViewModel.ViewState currentViewState;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetThreadBrowserArchived.kt */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetThreadBrowserArchived create(long guildId, long channelId) {
            WidgetThreadBrowserArchived widgetThreadBrowserArchived = new WidgetThreadBrowserArchived();
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            bundleT.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            widgetThreadBrowserArchived.setArguments(bundleT);
            return widgetThreadBrowserArchived;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadBrowserArchived.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchived$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetThreadBrowserArchivedViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadBrowserArchivedViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadBrowserArchivedViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetThreadBrowserArchived.access$updateView(WidgetThreadBrowserArchived.this, viewState);
        }
    }

    /* compiled from: WidgetThreadBrowserArchived.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchived$onViewBound$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Channel, Unit> {
        public AnonymousClass1(WidgetThreadBrowserViewModel widgetThreadBrowserViewModel) {
            super(1, widgetThreadBrowserViewModel, WidgetThreadBrowserViewModel.class, "openThread", "openThread(Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "p1");
            ((WidgetThreadBrowserViewModel) this.receiver).openThread(channel);
        }
    }

    /* compiled from: WidgetThreadBrowserArchived.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchived$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            WidgetChannelsListItemThreadActions.Companion companion = WidgetChannelsListItemThreadActions.INSTANCE;
            FragmentManager parentFragmentManager = WidgetThreadBrowserArchived.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, channel.getId());
        }
    }

    /* compiled from: WidgetThreadBrowserArchived.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchived$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends RecyclerView.OnScrollListener {
        public AnonymousClass3() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx, dy);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager == null || linearLayoutManager.findLastVisibleItemPosition() < linearLayoutManager.getItemCount() - 8) {
                return;
            }
            WidgetThreadBrowserArchivedViewModel.maybeLoadMore$default(WidgetThreadBrowserArchived.access$getViewModel$p(WidgetThreadBrowserArchived.this), false, 1, null);
        }
    }

    /* compiled from: WidgetThreadBrowserArchived.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchived$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ChannelSelector.openCreateThread$default(ChannelSelector.INSTANCE.getInstance(), WidgetThreadBrowserArchived.access$getGuildId$p(WidgetThreadBrowserArchived.this), WidgetThreadBrowserArchived.access$getChannelId$p(WidgetThreadBrowserArchived.this), null, "Thread Browser Empty State", 4, null);
            WidgetThreadBrowserArchived.this.requireAppActivity().finish();
        }
    }

    /* compiled from: WidgetThreadBrowserArchived.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchived$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadBrowserArchived.access$getViewModel$p(WidgetThreadBrowserArchived.this).maybeLoadMore(true);
        }
    }

    public WidgetThreadBrowserArchived() {
        super(R.layout.widget_thread_browser_archived);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetThreadBrowserArchived2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetThreadBrowserArchived5(this));
        this.channelId = LazyJVM.lazy(new WidgetThreadBrowserArchived4(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetThreadBrowserArchivedViewModel.class), new WidgetThreadBrowserArchived$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetThreadBrowserArchived6(this)));
        this.browserViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetThreadBrowserViewModel.class), new WidgetThreadBrowserArchived$appActivityViewModels$$inlined$activityViewModels$3(this), new AppViewModelDelegates2(new WidgetThreadBrowserArchived3(this)));
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetThreadBrowserArchived widgetThreadBrowserArchived) {
        return widgetThreadBrowserArchived.getChannelId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetThreadBrowserArchived widgetThreadBrowserArchived) {
        return widgetThreadBrowserArchived.getGuildId();
    }

    public static final /* synthetic */ WidgetThreadBrowserArchivedViewModel access$getViewModel$p(WidgetThreadBrowserArchived widgetThreadBrowserArchived) {
        return widgetThreadBrowserArchived.getViewModel();
    }

    public static final /* synthetic */ void access$updateView(WidgetThreadBrowserArchived widgetThreadBrowserArchived, WidgetThreadBrowserArchivedViewModel.ViewState viewState) {
        widgetThreadBrowserArchived.updateView(viewState);
    }

    private final WidgetThreadBrowserArchivedBinding getBinding() {
        return (WidgetThreadBrowserArchivedBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetThreadBrowserViewModel getBrowserViewModel() {
        return (WidgetThreadBrowserViewModel) this.browserViewModel.getValue();
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final WidgetThreadBrowserArchivedViewModel getViewModel() {
        return (WidgetThreadBrowserArchivedViewModel) this.viewModel.getValue();
    }

    private final void updateView(WidgetThreadBrowserArchivedViewModel.ViewState viewState) {
        ConstraintLayout constraintLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.threadBrowserErrorOverlay");
        constraintLayout.setVisibility(viewState.isError() ? 0 : 8);
        this.currentViewState = viewState;
        WidgetThreadBrowserAdapter widgetThreadBrowserAdapter = this.adapter;
        if (widgetThreadBrowserAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetThreadBrowserAdapter.setData(viewState.getListItems());
        TextView textView = getBinding().f2669b.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.emptyView.threadBrowserEmptyHeading");
        textView.setText(requireContext().getString(R.string.thread_browser_empty_state_archived_header));
        ConstraintLayout constraintLayout2 = getBinding().f2669b.f196b;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.emptyView.threadBrowserEmpty");
        constraintLayout2.setVisibility(viewState.getListItems().isEmpty() ? 0 : 8);
        MaterialButton materialButton = getBinding().f2669b.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.emptyView.threadBrowserEmptyCreateButton");
        materialButton.setVisibility(viewState.getCanCreateThread() ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetThreadBrowserArchived.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        this.adapter = (WidgetThreadBrowserAdapter) companion.configure(new WidgetThreadBrowserAdapter(recyclerView, new AnonymousClass1(getBrowserViewModel()), new AnonymousClass2()));
        getBinding().c.addOnScrollListener(new AnonymousClass3());
        getBinding().f2669b.c.setOnClickListener(new AnonymousClass4());
        getBinding().e.setOnClickListener(new AnonymousClass5());
    }
}
