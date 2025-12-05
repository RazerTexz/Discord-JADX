package com.discord.widgets.guilds.list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildsListBinding;
import com.discord.stores.StoreConnectionOpen;
import com.discord.stores.StoreNux;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.list.WidgetChannelListUnreads;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions;
import com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu;
import com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import com.discord.widgets.guilds.list.GuildListItem;
import com.discord.widgets.guilds.list.WidgetGuildListAdapter;
import com.discord.widgets.guilds.list.WidgetGuildsListViewModel;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.hubs.WidgetHubEmailFlow;
import com.discord.widgets.hubs.WidgetHubEmailViewModel2;
import com.discord.widgets.nux.WidgetGuildTemplates;
import com.discord.widgets.nux.WidgetNavigationHelp;
import com.discord.widgets.tabs.BottomNavViewObserver;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* compiled from: WidgetGuildsList.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildsList extends AppFragment implements WidgetGuildListAdapter.InteractionListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildsList.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildsListBinding;", 0)};
    private WidgetGuildListAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BottomNavViewObserver bottomNavViewObserver;
    private View guildListAddHint;
    private WidgetChannelListUnreads guildListUnreads;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildsList.kt */
    public static final /* data */ class AddGuildHint {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean isAddGuildHint;
        private final boolean isEligible;

        /* compiled from: WidgetGuildsList.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<AddGuildHint> get() {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM11118y = Observable.m11075i(companion.getNux().getNuxState(), StoreConnectionOpen.observeConnectionOpen$default(companion.getConnectionOpen(), false, 1, null), companion.getChannels().observeGuildAndPrivateChannels(), WidgetGuildsList2.INSTANCE).m11118y(WidgetGuildsList3.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11118y, "Observable\n             ….filter { it.isEligible }");
                Observable<AddGuildHint> observableM11087M = ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11118y, 0L, false, 3, null).m11087M(WidgetGuildsList4.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11087M, "Observable\n             … = false)\n              }");
                return observableM11087M;
            }

            public final Observable<Boolean> getDismissAction() {
                Observable observableM11083G = StoreStream.INSTANCE.getNavigation().observeLeftPanelState().m11083G(WidgetGuildsList5.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11083G, "StoreStream\n            …te == PanelState.Closed }");
                return observableM11083G;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public AddGuildHint(boolean z2, boolean z3) {
            this.isEligible = z2;
            this.isAddGuildHint = z3;
        }

        public static /* synthetic */ AddGuildHint copy$default(AddGuildHint addGuildHint, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = addGuildHint.isEligible;
            }
            if ((i & 2) != 0) {
                z3 = addGuildHint.isAddGuildHint;
            }
            return addGuildHint.copy(z2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsEligible() {
            return this.isEligible;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsAddGuildHint() {
            return this.isAddGuildHint;
        }

        public final AddGuildHint copy(boolean isEligible, boolean isAddGuildHint) {
            return new AddGuildHint(isEligible, isAddGuildHint);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddGuildHint)) {
                return false;
            }
            AddGuildHint addGuildHint = (AddGuildHint) other;
            return this.isEligible == addGuildHint.isEligible && this.isAddGuildHint == addGuildHint.isAddGuildHint;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z2 = this.isEligible;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.isAddGuildHint;
            return i + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isAddGuildHint() {
            return this.isAddGuildHint;
        }

        public final boolean isEligible() {
            return this.isEligible;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("AddGuildHint(isEligible=");
            sbM833U.append(this.isEligible);
            sbM833U.append(", isAddGuildHint=");
            return outline.m827O(sbM833U, this.isAddGuildHint, ")");
        }

        public /* synthetic */ AddGuildHint(boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, (i & 2) != 0 ? false : z3);
        }
    }

    /* compiled from: WidgetGuildsList.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$configureAddGuildHint$1 */
    public static final class C87451 extends Lambda implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
        public static final C87451 INSTANCE = new C87451();

        public C87451() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
            return invoke2(nuxState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final StoreNux.NuxState invoke2(StoreNux.NuxState nuxState) {
            Intrinsics3.checkNotNullParameter(nuxState, "nux");
            return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, false, null, 47, null);
        }
    }

    /* compiled from: WidgetGuildsList.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$configureBottomNavSpace$1 */
    public static final class C87461 extends Lambda implements Function1<Integer, Unit> {
        public C87461() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            WidgetGuildsList.access$getAdapter$p(WidgetGuildsList.this).handleBottomNavHeight(i);
            ViewStub viewStub = WidgetGuildsList.access$getBinding$p(WidgetGuildsList.this).f17094c;
            Intrinsics3.checkNotNullExpressionValue(viewStub, "binding.guildListUnreadsStub");
            ViewGroup.LayoutParams layoutParams = viewStub.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, i);
            ViewStub viewStub2 = WidgetGuildsList.access$getBinding$p(WidgetGuildsList.this).f17094c;
            Intrinsics3.checkNotNullExpressionValue(viewStub2, "binding.guildListUnreadsStub");
            viewStub2.setLayoutParams(marginLayoutParams);
        }
    }

    /* compiled from: WidgetGuildsList.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onResume$1 */
    public static final class C87471 extends Lambda implements Function1<WidgetGuildsListViewModel.ViewState, Unit> {
        public C87471() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildsListViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildsListViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildsList.access$configureUI(WidgetGuildsList.this, viewState);
        }
    }

    /* compiled from: WidgetGuildsList.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onResume$2 */
    public static final class C87482 extends Lambda implements Function1<WidgetGuildsListViewModel.Event, Unit> {
        public C87482() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildsListViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildsListViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetGuildsList.access$handleEvent(WidgetGuildsList.this, event);
        }
    }

    /* compiled from: WidgetGuildsList.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onResume$3 */
    public static final class C87493 extends Lambda implements Function1<AddGuildHint, Unit> {
        public C87493() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AddGuildHint addGuildHint) {
            invoke2(addGuildHint);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AddGuildHint addGuildHint) {
            Intrinsics3.checkNotNullParameter(addGuildHint, "it");
            WidgetGuildsList.access$configureAddGuildHint(WidgetGuildsList.this, addGuildHint);
        }
    }

    /* compiled from: WidgetGuildsList.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onResume$4 */
    public static final class C87504 extends Lambda implements Function1<Boolean, Unit> {
        public C87504() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            if (z2) {
                WidgetGuildsList.access$dismissAddGuildHint(WidgetGuildsList.this, false);
            }
        }
    }

    /* compiled from: WidgetGuildsList.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onViewBound$1 */
    public static final class C87511 extends Lambda implements Function0<Integer> {
        public C87511() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return WidgetGuildsList.access$getAdapter$p(WidgetGuildsList.this).getItemCount();
        }
    }

    /* compiled from: WidgetGuildsList.kt */
    /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onViewBound$2 */
    public static final class C87522 extends Lambda implements Function1<View, Unit> {

        /* compiled from: WidgetGuildsList.kt */
        /* renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onViewBound$2$1, reason: invalid class name */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildsList.access$dismissAddGuildHint(WidgetGuildsList.this, true);
            }
        }

        public C87522() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetGuildsList.access$setGuildListAddHint$p(WidgetGuildsList.this, view);
            View viewAccess$getGuildListAddHint$p = WidgetGuildsList.access$getGuildListAddHint$p(WidgetGuildsList.this);
            if (viewAccess$getGuildListAddHint$p != null) {
                viewAccess$getGuildListAddHint$p.setOnClickListener(new AnonymousClass1());
            }
        }
    }

    public WidgetGuildsList() {
        super(C5419R.layout.widget_guilds_list);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildsList6.INSTANCE, null, 2, null);
        this.bottomNavViewObserver = BottomNavViewObserver.INSTANCE.getINSTANCE();
        WidgetGuildsList7 widgetGuildsList7 = WidgetGuildsList7.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildsListViewModel.class), new WidgetGuildsList$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildsList7));
    }

    public static final /* synthetic */ void access$configureAddGuildHint(WidgetGuildsList widgetGuildsList, AddGuildHint addGuildHint) {
        widgetGuildsList.configureAddGuildHint(addGuildHint);
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildsList widgetGuildsList, WidgetGuildsListViewModel.ViewState viewState) {
        widgetGuildsList.configureUI(viewState);
    }

    public static final /* synthetic */ void access$dismissAddGuildHint(WidgetGuildsList widgetGuildsList, boolean z2) {
        widgetGuildsList.dismissAddGuildHint(z2);
    }

    public static final /* synthetic */ WidgetGuildListAdapter access$getAdapter$p(WidgetGuildsList widgetGuildsList) {
        WidgetGuildListAdapter widgetGuildListAdapter = widgetGuildsList.adapter;
        if (widgetGuildListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        return widgetGuildListAdapter;
    }

    public static final /* synthetic */ WidgetGuildsListBinding access$getBinding$p(WidgetGuildsList widgetGuildsList) {
        return widgetGuildsList.getBinding();
    }

    public static final /* synthetic */ View access$getGuildListAddHint$p(WidgetGuildsList widgetGuildsList) {
        return widgetGuildsList.guildListAddHint;
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildsList widgetGuildsList, WidgetGuildsListViewModel.Event event) {
        widgetGuildsList.handleEvent(event);
    }

    public static final /* synthetic */ void access$setAdapter$p(WidgetGuildsList widgetGuildsList, WidgetGuildListAdapter widgetGuildListAdapter) {
        widgetGuildsList.adapter = widgetGuildListAdapter;
    }

    public static final /* synthetic */ void access$setGuildListAddHint$p(WidgetGuildsList widgetGuildsList, View view) {
        widgetGuildsList.guildListAddHint = view;
    }

    private final void announceFolderToggle(GuildListItem.FolderItem item) {
        Object[] objArr = new Object[2];
        objArr[0] = FormatUtils.m219k(this, item.isOpen() ? C5419R.string.collapsed : C5419R.string.expanded, new Object[0], null, 4);
        String name = item.getName();
        if (name == null) {
            name = "";
        }
        objArr[1] = name;
        AccessibilityUtils.INSTANCE.sendAnnouncement(requireContext(), outline.m828P(objArr, 2, "%s, %s", "java.lang.String.format(this, *args)"));
    }

    private final void configureAddGuildHint(AddGuildHint addGuildHint) {
        if (addGuildHint.isAddGuildHint()) {
            StoreStream.INSTANCE.getNux().updateNux(C87451.INSTANCE);
        }
        if (addGuildHint.isEligible()) {
            AnalyticsTracker.INSTANCE.showFirstServerTipTutorial();
            View view = this.guildListAddHint;
            if (view != null) {
                ViewExtensions.fadeIn$default(view, 0L, null, null, null, 15, null);
            }
        }
    }

    private final void configureBottomNavSpace() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(this.bottomNavViewObserver.observeHeight(), this, null, 2, null), WidgetGuildsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C87461(), 62, (Object) null);
    }

    private final void configureUI(WidgetGuildsListViewModel.ViewState viewState) {
        View view;
        if (viewState instanceof WidgetGuildsListViewModel.ViewState.Loaded) {
            WidgetGuildListAdapter widgetGuildListAdapter = this.adapter;
            if (widgetGuildListAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("adapter");
            }
            WidgetGuildsListViewModel.ViewState.Loaded loaded = (WidgetGuildsListViewModel.ViewState.Loaded) viewState;
            widgetGuildListAdapter.setItems(loaded.getItems(), !loaded.getWasDragResult());
            WidgetChannelListUnreads widgetChannelListUnreads = this.guildListUnreads;
            if (widgetChannelListUnreads != null) {
                widgetChannelListUnreads.onDatasetChanged(loaded.getItems());
            }
            if (loaded.getHasChannels() && (view = this.guildListAddHint) != null && view.getVisibility() == 0) {
                dismissAddGuildHint(false);
            }
        }
    }

    private final void dismissAddGuildHint(boolean wasAcknowledged) {
        if (wasAcknowledged) {
            View view = this.guildListAddHint;
            if (view != null) {
                ViewExtensions.fadeOut$default(view, 0L, null, null, 7, null);
            }
            AnalyticsTracker.INSTANCE.closeFirstServerTipTutorial(true);
            return;
        }
        View view2 = this.guildListAddHint;
        if (view2 == null || view2.getVisibility() != 0) {
            return;
        }
        View view3 = this.guildListAddHint;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        AnalyticsTracker.INSTANCE.closeFirstServerTipTutorial(false);
    }

    private final void focusFirstElement() {
        View childAt = getBinding().f17093b.getChildAt(0);
        if (childAt != null) {
            childAt.sendAccessibilityEvent(8);
        }
    }

    private final WidgetGuildsListBinding getBinding() {
        return (WidgetGuildsListBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGuildsListViewModel getViewModel() {
        return (WidgetGuildsListViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetGuildsListViewModel.Event event) {
        if (event instanceof WidgetGuildsListViewModel.Event.ShowChannelActions) {
            showChannelActions(((WidgetGuildsListViewModel.Event.ShowChannelActions) event).getChannelId());
            return;
        }
        if (event instanceof WidgetGuildsListViewModel.Event.ShowUnavailableGuilds) {
            showUnavailableGuildsToast(((WidgetGuildsListViewModel.Event.ShowUnavailableGuilds) event).getUnavailableGuildCount());
            return;
        }
        if (event instanceof WidgetGuildsListViewModel.Event.AnnounceFolderToggleForAccessibility) {
            announceFolderToggle(((WidgetGuildsListViewModel.Event.AnnounceFolderToggleForAccessibility) event).getItem());
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetGuildsListViewModel.Event.ShowCreateGuild.INSTANCE)) {
            showCreateGuild();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetGuildsListViewModel.Event.ShowHubVerification.INSTANCE)) {
            showHubVerification();
        } else if (Intrinsics3.areEqual(event, WidgetGuildsListViewModel.Event.ShowHelp.INSTANCE)) {
            showHelp();
        } else {
            if (!Intrinsics3.areEqual(event, WidgetGuildsListViewModel.Event.FocusFirstElement.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            focusFirstElement();
        }
    }

    private final void setupRecycler() {
        RecyclerView recyclerView = getBinding().f17093b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildList");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 1, false);
        WidgetGuildListAdapter widgetGuildListAdapter = new WidgetGuildListAdapter(linearLayoutManager, this);
        this.adapter = widgetGuildListAdapter;
        if (widgetGuildListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetGuildListAdapter.setHasStableIds(true);
        RecyclerView recyclerView2 = getBinding().f17093b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.guildList");
        recyclerView2.setItemAnimator(null);
        RecyclerView recyclerView3 = getBinding().f17093b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.guildList");
        recyclerView3.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView4 = getBinding().f17093b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView4, "binding.guildList");
        WidgetGuildListAdapter widgetGuildListAdapter2 = this.adapter;
        if (widgetGuildListAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView4.setAdapter(widgetGuildListAdapter2);
        WidgetGuildListAdapter widgetGuildListAdapter3 = this.adapter;
        if (widgetGuildListAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        new ItemTouchHelper(new GuildsDragAndDropCallback(widgetGuildListAdapter3)).attachToRecyclerView(getBinding().f17093b);
        RecyclerView recyclerView5 = getBinding().f17093b;
        Drawable drawable = ContextCompat.getDrawable(requireContext(), DrawableCompat.getThemedDrawableRes$default(requireContext(), C5419R.attr.bg_folder_no_children, 0, 2, (Object) null));
        Intrinsics3.checkNotNull(drawable);
        Intrinsics3.checkNotNullExpressionValue(drawable, "ContextCompat.getDrawabl…children)\n            )!!");
        Drawable drawable2 = ContextCompat.getDrawable(requireContext(), DrawableCompat.getThemedDrawableRes$default(requireContext(), C5419R.attr.bg_folder_tintable_no_children, 0, 2, (Object) null));
        Intrinsics3.checkNotNull(drawable2);
        Intrinsics3.checkNotNullExpressionValue(drawable2, "ContextCompat.getDrawabl…children)\n            )!!");
        Drawable drawable3 = ContextCompat.getDrawable(requireContext(), DrawableCompat.getThemedDrawableRes$default(requireContext(), C5419R.attr.bg_folder_with_children, 0, 2, (Object) null));
        Intrinsics3.checkNotNull(drawable3);
        Intrinsics3.checkNotNullExpressionValue(drawable3, "ContextCompat.getDrawabl…children)\n            )!!");
        recyclerView5.addItemDecoration(new FolderItemDecoration(drawable, drawable2, drawable3, requireContext().getResources().getDimensionPixelSize(C5419R.dimen.avatar_size_large)));
    }

    private final void showChannelActions(long channelId) {
        WidgetChannelsListItemChannelActions.Companion companion = WidgetChannelsListItemChannelActions.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, channelId);
    }

    private final void showCreateGuild() {
        dismissAddGuildHint(true);
        WidgetGuildTemplates.INSTANCE.launch(requireContext(), CreateGuildTrigger.IN_APP, false);
    }

    private final void showHelp() {
        dismissAddGuildHint(true);
        WidgetNavigationHelp.Companion companion = WidgetNavigationHelp.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager);
    }

    private final void showHubVerification() {
        AppScreen2.m156d(requireContext(), WidgetHubEmailFlow.class, new WidgetHubEmailViewModel2(null, 0, null, 7, null));
    }

    private final void showUnavailableGuildsToast(int unavailableGuildCount) {
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        AppToast.m170h(getContext(), FormatUtils.m220l(StringResourceUtils.getQuantityString(resources, requireContext(), C5419R.plurals.partial_outage_count, unavailableGuildCount, Integer.valueOf(unavailableGuildCount)), new Object[0], null, 2), 0, null, 12);
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter.InteractionListener
    public boolean onDrop() {
        return getViewModel().onDrop();
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter.InteractionListener
    public void onItemClicked(View view, GuildListItem item) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(item, "item");
        WidgetGuildsListViewModel viewModel = getViewModel();
        Context contextRequireContext = requireContext();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        viewModel.onItemClicked(item, contextRequireContext, parentFragmentManager);
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter.InteractionListener
    public void onItemLongPressed(View view, GuildListItem item) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(item, "item");
        boolean z2 = item instanceof GuildListItem.GuildItem;
        if (!z2 && !(item instanceof GuildListItem.FolderItem)) {
            getViewModel().onItemLongPressed(item);
            return;
        }
        view.getLocationInWindow(new int[2]);
        PointF pointF = new PointF(r1[0] + DimenUtils.dpToPixels(64), r1[1]);
        if (z2) {
            WidgetGuildContextMenu.Companion companion = WidgetGuildContextMenu.INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            companion.show(fragmentActivityRequireActivity, pointF, ((GuildListItem.GuildItem) item).getGuild().getId());
            return;
        }
        if (item instanceof GuildListItem.FolderItem) {
            WidgetFolderContextMenu.Companion companion2 = WidgetFolderContextMenu.INSTANCE;
            FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
            companion2.show(fragmentActivityRequireActivity2, pointF, ((GuildListItem.FolderItem) item).getFolderId());
        }
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter.InteractionListener
    public void onItemMoved() {
        WidgetGuildContextMenu.Companion companion = WidgetGuildContextMenu.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        companion.hide(fragmentActivityRequireActivity, true);
        WidgetFolderContextMenu.Companion companion2 = WidgetFolderContextMenu.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
        companion2.hide(fragmentActivityRequireActivity2, true);
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter.InteractionListener
    public void onOperation(WidgetGuildListAdapter.Operation operation) {
        Intrinsics3.checkNotNullParameter(operation, "operation");
        if (operation instanceof WidgetGuildListAdapter.Operation.MoveAbove) {
            WidgetGuildListAdapter.Operation.MoveAbove moveAbove = (WidgetGuildListAdapter.Operation.MoveAbove) operation;
            getViewModel().moveAbove(moveAbove.getFromPosition(), moveAbove.getTargetPosition());
        } else if (operation instanceof WidgetGuildListAdapter.Operation.MoveBelow) {
            WidgetGuildListAdapter.Operation.MoveBelow moveBelow = (WidgetGuildListAdapter.Operation.MoveBelow) operation;
            getViewModel().moveBelow(moveBelow.getFromPosition(), moveBelow.getTargetPosition());
        } else if (operation instanceof WidgetGuildListAdapter.Operation.TargetOperation) {
            WidgetGuildListAdapter.Operation.TargetOperation targetOperation = (WidgetGuildListAdapter.Operation.TargetOperation) operation;
            getViewModel().target(targetOperation.getFromPosition(), targetOperation.getTargetPosition());
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C87471(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().listenForEvents(), this, null, 2, null), WidgetGuildsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C87482(), 62, (Object) null);
        AddGuildHint.Companion companion = AddGuildHint.INSTANCE;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(companion.get(), this, null, 2, null), WidgetGuildsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C87493(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(companion.getDismissAction(), this, null, 2, null), WidgetGuildsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C87504(), 62, (Object) null);
        configureBottomNavSpace();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setupRecycler();
        ViewStub viewStub = getBinding().f17094c;
        Intrinsics3.checkNotNullExpressionValue(viewStub, "binding.guildListUnreadsStub");
        RecyclerView recyclerView = getBinding().f17093b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildList");
        WidgetChannelListUnreads widgetChannelListUnreads = new WidgetChannelListUnreads(viewStub, recyclerView, null, new C87511(), 0, 0, false, 116, null);
        this.guildListUnreads = widgetChannelListUnreads;
        if (widgetChannelListUnreads != null) {
            widgetChannelListUnreads.setMentionResId(C5419R.string._new);
        }
        WidgetChannelListUnreads widgetChannelListUnreads2 = this.guildListUnreads;
        if (widgetChannelListUnreads2 != null) {
            widgetChannelListUnreads2.setUnreadsEnabled(false);
        }
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof WidgetHome)) {
            parentFragment = null;
        }
        WidgetHome widgetHome = (WidgetHome) parentFragment;
        if (widgetHome != null) {
            widgetHome.setOnGuildListAddHintCreate(new C87522());
        }
    }
}
