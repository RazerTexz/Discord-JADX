package com.discord.widgets.channels.memberlist;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel;
import com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import d0.LazyJVM;
import d0.d0._Ranges;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.Ranges2;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetChannelMembersList.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelMembersList extends AppFragment {
    private static final String SOURCE = "WidgetChannelMembersList";
    private ChannelMembersListAdapter adapter;
    private int memberCellHeightPx;

    /* renamed from: recycler$delegate, reason: from kotlin metadata */
    private final Lazy recycler;
    private final RxOnScrollListener scrollListener;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetChannelMembersList.kt */
    public static final class RxOnScrollListener extends RecyclerView.OnScrollListener {
        private final PublishSubject<Unit> scrollYSubject = PublishSubject.k0();

        public final Observable<Unit> observeScrollChanges() {
            PublishSubject<Unit> publishSubject = this.scrollYSubject;
            Intrinsics3.checkNotNullExpressionValue(publishSubject, "scrollYSubject");
            return publishSubject;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx, dy);
            PublishSubject<Unit> publishSubject = this.scrollYSubject;
            publishSubject.k.onNext(Unit.a);
        }
    }

    /* compiled from: WidgetChannelMembersList.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersList$configureLoadedUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ WidgetChannelMembersListViewModel.ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WidgetChannelMembersListViewModel.ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            Long lValueOf = Long.valueOf(this.$viewState.getChannel().getId());
            FragmentManager parentFragmentManager = WidgetChannelMembersList.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, j, lValueOf, parentFragmentManager, Long.valueOf(this.$viewState.getChannel().getGuildId()), null, null, null, 112, null);
        }
    }

    /* compiled from: WidgetChannelMembersList.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersList$configureLoadedUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ WidgetChannelMembersListViewModel.ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(WidgetChannelMembersListViewModel.ViewState.Loaded loaded) {
            super(0);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ChannelInviteLaunchUtils.inviteToChannel$default(ChannelInviteLaunchUtils.INSTANCE, WidgetChannelMembersList.this, this.$viewState.getChannel(), WidgetChannelMembersList.SOURCE, null, null, 24, null);
        }
    }

    /* compiled from: WidgetChannelMembersList.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersList$configureLoadedUI$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ WidgetChannelMembersListViewModel.ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(WidgetChannelMembersListViewModel.ViewState.Loaded loaded) {
            super(0);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChannelMembersList.access$getViewModel$p(WidgetChannelMembersList.this).onThreadJoinLeaveClicked(this.$viewState.getChannel().getId(), this.$viewState.isThreadJoined());
        }
    }

    /* compiled from: WidgetChannelMembersList.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersList$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetChannelMembersListViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelMembersListViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelMembersListViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetChannelMembersList.access$configureUI(WidgetChannelMembersList.this, viewState);
        }
    }

    /* compiled from: WidgetChannelMembersList.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersList$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetChannelMembersListViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelMembersListViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelMembersListViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            if (Intrinsics3.areEqual(event, WidgetChannelMembersListViewModel.Event.ScrollToTop.INSTANCE)) {
                WidgetChannelMembersList.access$scrollToTop(WidgetChannelMembersList.this);
            } else if (Intrinsics3.areEqual(event, WidgetChannelMembersListViewModel.Event.UpdateRanges.INSTANCE)) {
                WidgetChannelMembersList.access$updateRanges(WidgetChannelMembersList.this);
            } else if (event instanceof WidgetChannelMembersListViewModel.Event.Error) {
                WidgetChannelMembersList.access$showError(WidgetChannelMembersList.this, (WidgetChannelMembersListViewModel.Event.Error) event);
            }
        }
    }

    /* compiled from: WidgetChannelMembersList.kt */
    /* renamed from: com.discord.widgets.channels.memberlist.WidgetChannelMembersList$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Unit, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            WidgetChannelMembersList.access$updateRanges(WidgetChannelMembersList.this);
        }
    }

    public WidgetChannelMembersList() {
        super(R.layout.widget_channel_members_list);
        this.recycler = LazyJVM.lazy(new WidgetChannelMembersList2(this));
        this.scrollListener = new RxOnScrollListener();
        WidgetChannelMembersList3 widgetChannelMembersList3 = WidgetChannelMembersList3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetChannelMembersListViewModel.class), new WidgetChannelMembersList$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetChannelMembersList3));
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelMembersList widgetChannelMembersList, WidgetChannelMembersListViewModel.ViewState viewState) {
        widgetChannelMembersList.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetChannelMembersListViewModel access$getViewModel$p(WidgetChannelMembersList widgetChannelMembersList) {
        return widgetChannelMembersList.getViewModel();
    }

    public static final /* synthetic */ void access$scrollToTop(WidgetChannelMembersList widgetChannelMembersList) {
        widgetChannelMembersList.scrollToTop();
    }

    public static final /* synthetic */ void access$showError(WidgetChannelMembersList widgetChannelMembersList, WidgetChannelMembersListViewModel.Event.Error error) {
        widgetChannelMembersList.showError(error);
    }

    public static final /* synthetic */ void access$updateRanges(WidgetChannelMembersList widgetChannelMembersList) {
        widgetChannelMembersList.updateRanges();
    }

    private final void configureLoadedUI(WidgetChannelMembersListViewModel.ViewState.Loaded viewState) {
        if (viewState.getChannel() != null) {
            ChannelMembersListAdapter channelMembersListAdapter = this.adapter;
            if (channelMembersListAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("adapter");
            }
            channelMembersListAdapter.setOnUserClicked(new AnonymousClass1(viewState));
            ChannelMembersListAdapter channelMembersListAdapter2 = this.adapter;
            if (channelMembersListAdapter2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("adapter");
            }
            channelMembersListAdapter2.setOnAddMemberClicked(new AnonymousClass2(viewState));
            ChannelMembersListAdapter channelMembersListAdapter3 = this.adapter;
            if (channelMembersListAdapter3 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("adapter");
            }
            channelMembersListAdapter3.setOnJoinLeaveThreadClicked(new AnonymousClass3(viewState));
        }
        ChannelMembersListAdapter channelMembersListAdapter4 = this.adapter;
        if (channelMembersListAdapter4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        channelMembersListAdapter4.setData(viewState.getListItems().getListId(), viewState.getListItems(), true);
    }

    private final void configureUI(WidgetChannelMembersListViewModel.ViewState viewState) {
        if (!Intrinsics3.areEqual(viewState, WidgetChannelMembersListViewModel.ViewState.Empty.INSTANCE) && (viewState instanceof WidgetChannelMembersListViewModel.ViewState.Loaded)) {
            configureLoadedUI((WidgetChannelMembersListViewModel.ViewState.Loaded) viewState);
        }
    }

    private final RecyclerView getRecycler() {
        return (RecyclerView) this.recycler.getValue();
    }

    private final WidgetChannelMembersListViewModel getViewModel() {
        return (WidgetChannelMembersListViewModel) this.viewModel.getValue();
    }

    private final void scrollToTop() {
        getRecycler().scrollToPosition(0);
    }

    private final void setupRecyclerView() {
        this.memberCellHeightPx = getResources().getDimensionPixelSize(R.dimen.channel_list_row_height);
        getRecycler().setHasFixedSize(true);
        getRecycler().removeOnScrollListener(this.scrollListener);
        getRecycler().addOnScrollListener(this.scrollListener);
        ChannelMembersListAdapter channelMembersListAdapter = this.adapter;
        if (channelMembersListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        StickyHeaderItemDecoration stickyHeaderItemDecoration = new StickyHeaderItemDecoration(channelMembersListAdapter);
        getRecycler().addItemDecoration(stickyHeaderItemDecoration);
        stickyHeaderItemDecoration.blockClicks(getRecycler());
        RecyclerView recycler = getRecycler();
        ChannelMembersListAdapter channelMembersListAdapter2 = this.adapter;
        if (channelMembersListAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recycler.setAdapter(channelMembersListAdapter2);
    }

    private final void showError(WidgetChannelMembersListViewModel.Event.Error event) {
        Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(event.getCode());
        AppToast.i(this, abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : R.string.network_error_bad_request, 0, 4);
    }

    private final void updateRanges() {
        View view = getView();
        if (view != null) {
            int height = (view.getHeight() / this.memberCellHeightPx) + 1;
            RecyclerView.LayoutManager layoutManager = getRecycler().getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            getViewModel().updateSubscriptionsForChannel(new Ranges2(_Ranges.coerceAtLeast(linearLayoutManager.findFirstVisibleItemPosition() - height, 0), linearLayoutManager.findLastVisibleItemPosition() + height));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ChannelMembersListAdapter channelMembersListAdapter = new ChannelMembersListAdapter();
        this.adapter = channelMembersListAdapter;
        if (channelMembersListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        channelMembersListAdapter.setHasStableIds(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        ChannelMembersListAdapter channelMembersListAdapter = this.adapter;
        if (channelMembersListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        channelMembersListAdapter.dispose();
        super.onDestroy();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setupRecyclerView();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChannelMembersList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetChannelMembersList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        Observable<Unit> observableP = this.scrollListener.observeScrollChanges().p(100L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableP, "scrollListener\n        .…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableP, this, null, 2, null), WidgetChannelMembersList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
    }
}
