package com.discord.widgets.friends;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetFriendsListBinding;
import com.discord.models.user.User;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheet;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetFeatureFlag;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics;
import com.discord.widgets.contact_sync.WidgetContactSync;
import com.discord.widgets.friends.FriendsListViewModel;
import com.discord.widgets.friends.WidgetFriendsAdd;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.OnTabSelectedListener;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import d0.o;
import d0.t.g0;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;
import rx.functions.Action1;
import rx.functions.Action2;

/* compiled from: WidgetFriendsList.kt */
/* loaded from: classes2.dex */
public final class WidgetFriendsList extends AppFragment implements OnTabSelectedListener {
    private static final String ANALYTICS_SOURCE = "Friends";
    private static final int VIEW_INDEX_EMPTY = 1;
    private static final int VIEW_INDEX_LOADING = 2;
    private static final int VIEW_INDEX_RECYCLER = 0;
    private WidgetFriendsListAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetFriendsListLoadingAdapter loadingAdapter;
    private PrivateCallLauncher privateCallLauncher;
    private boolean showContactSyncIcon;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetFriendsList.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFriendsListBinding;", 0)};

    /* compiled from: WidgetFriendsList.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$configureToolbar$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            m.checkNotNullExpressionValue(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case R.id.menu_friends_add_friend /* 2131364389 */:
                    WidgetFriendsAdd.Companion companion = WidgetFriendsAdd.INSTANCE;
                    m.checkNotNullExpressionValue(context, "context");
                    WidgetFriendsAdd.Companion.show$default(companion, context, null, WidgetFriendsList.ANALYTICS_SOURCE, 2, null);
                    break;
                case R.id.menu_friends_contact_sync /* 2131364390 */:
                    ContactSyncFlowAnalytics.Companion.trackStart$default(ContactSyncFlowAnalytics.INSTANCE, false, g0.mapOf(o.to("location_page", "Friends List Icon")), 1, null);
                    AnalyticsTracker.INSTANCE.openModal("Contact Sync", new Traits.Location("Friends List Icon", null, null, null, null, 30, null));
                    WidgetContactSync.Companion companion2 = WidgetContactSync.INSTANCE;
                    m.checkNotNullExpressionValue(context, "context");
                    WidgetContactSync.Companion.launch$default(companion2, context, null, false, false, false, 30, null);
                    break;
                case R.id.menu_friends_start_group /* 2131364391 */:
                    if (!GroupInviteFriendsSheetFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
                        WidgetGroupInviteFriends.INSTANCE.launch(WidgetFriendsList.this.requireContext(), WidgetFriendsList.ANALYTICS_SOURCE);
                        break;
                    } else {
                        GroupInviteFriendsSheet.Companion companion3 = GroupInviteFriendsSheet.INSTANCE;
                        FragmentManager parentFragmentManager = WidgetFriendsList.this.getParentFragmentManager();
                        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                        GroupInviteFriendsSheet.Companion.show$default(companion3, parentFragmentManager, 0L, WidgetFriendsList.ANALYTICS_SOURCE, 2, null);
                        break;
                    }
            }
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$configureToolbar$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Menu> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            MenuItem menuItemFindItem = menu.findItem(R.id.menu_friends_contact_sync);
            if (menuItemFindItem != null) {
                menuItemFindItem.setVisible(WidgetFriendsList.access$getShowContactSyncIcon$p(WidgetFriendsList.this));
            }
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$handleCaptchaError$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.z.d.o implements Function2<AppFragment, CaptchaHelper.CaptchaPayload, Unit> {
        public final /* synthetic */ FriendsListViewModel.Event.CaptchaError $event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FriendsListViewModel.Event.CaptchaError captchaError) {
            super(2);
            this.$event = captchaError;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            invoke2(appFragment, captchaPayload);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            m.checkNotNullParameter(appFragment, "<anonymous parameter 0>");
            m.checkNotNullParameter(captchaPayload, "captchaPayload");
            WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).acceptFriendSuggestion(this.$event.getUsername(), this.$event.getDiscriminator(), captchaPayload);
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.z.d.o implements Function2<View, User, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, User user) {
            invoke2(view, user);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view, User user) {
            m.checkNotNullParameter(view, "<anonymous parameter 0>");
            m.checkNotNullParameter(user, "user");
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = user.getId();
            FragmentManager parentFragmentManager = WidgetFriendsList.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$10, reason: invalid class name */
    public static final class AnonymousClass10 extends d0.z.d.o implements Function1<User, Unit> {
        public AnonymousClass10() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            m.checkNotNullParameter(user, "user");
            FriendsListViewModel.acceptFriendSuggestion$default(WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this), user.getUsername(), user.getDiscriminator(), null, 4, null);
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$11, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass11 extends k implements Function1<Long, Unit> {
        public AnonymousClass11(FriendsListViewModel friendsListViewModel) {
            super(1, friendsListViewModel, FriendsListViewModel.class, "ignoreSuggestion", "ignoreSuggestion(J)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            ((FriendsListViewModel) this.receiver).ignoreSuggestion(j);
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends d0.z.d.o implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).handleClickPendingHeader();
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends d0.z.d.o implements Function1<User, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            m.checkNotNullParameter(user, "user");
            WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).launchVoiceCall(user.getId());
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 extends d0.z.d.o implements Function1<User, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            m.checkNotNullParameter(user, "user");
            ChannelSelector.INSTANCE.getInstance().findAndSetDirectMessage(WidgetFriendsList.this.requireContext(), user.getId());
            StoreTabsNavigation.selectHomeTab$default(StoreStream.INSTANCE.getTabsNavigation(), StoreNavigation.PanelAction.CLOSE, false, 2, null);
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$5, reason: invalid class name */
    public static final class AnonymousClass5 extends d0.z.d.o implements Function1<User, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            m.checkNotNullParameter(user, "it");
            WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).acceptFriendRequest(user.getId(), user.getUsername());
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$6, reason: invalid class name */
    public static final class AnonymousClass6 extends d0.z.d.o implements Function2<User, Integer, Unit> {
        public AnonymousClass6() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(User user, Integer num) {
            invoke(user, num.intValue());
            return Unit.a;
        }

        public final void invoke(User user, int i) {
            m.checkNotNullParameter(user, "user");
            WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).removeFriendRequest(user.getId(), i);
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$7, reason: invalid class name */
    public static final class AnonymousClass7 extends d0.z.d.o implements Function0<Unit> {
        public AnonymousClass7() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ContactSyncFlowAnalytics.Companion.trackStart$default(ContactSyncFlowAnalytics.INSTANCE, false, g0.mapOf(o.to("location_page", "Friends List Upsell")), 1, null);
            AnalyticsTracker.INSTANCE.openModal("Contact Sync", new Traits.Location("Friends List Upsell", null, null, null, null, 30, null));
            WidgetContactSync.Companion.launch$default(WidgetContactSync.INSTANCE, WidgetFriendsList.this.requireContext(), null, false, false, false, 30, null);
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$8, reason: invalid class name */
    public static final class AnonymousClass8 extends d0.z.d.o implements Function1<View, Unit> {

        /* compiled from: WidgetFriendsList.kt */
        /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$8$1, reason: invalid class name */
        public static final class AnonymousClass1 implements MenuItem.OnMenuItemClickListener {
            public AnonymousClass1() {
            }

            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).dismissContactSyncUpsell();
                return true;
            }
        }

        public AnonymousClass8() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            m.checkNotNullParameter(view, "upsellView");
            PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(view.getContext(), 2131951663), view);
            popupMenu.getMenuInflater().inflate(R.menu.menu_contact_sync_upsell, popupMenu.getMenu());
            popupMenu.getMenu().findItem(R.id.menu_contact_sync_upsell_dismiss).setOnMenuItemClickListener(new AnonymousClass1());
            popupMenu.show();
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$9, reason: invalid class name */
    public static final class AnonymousClass9 extends d0.z.d.o implements Function0<Unit> {
        public AnonymousClass9() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).handleClickSuggestedHeader();
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<FriendsListViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetFriendsList widgetFriendsList) {
            super(1, widgetFriendsList, WidgetFriendsList.class, "configureUI", "configureUI(Lcom/discord/widgets/friends/FriendsListViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FriendsListViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FriendsListViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetFriendsList.access$configureUI((WidgetFriendsList) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetFriendsList.kt */
    /* renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<FriendsListViewModel.Event, Unit> {
        public AnonymousClass2(WidgetFriendsList widgetFriendsList) {
            super(1, widgetFriendsList, WidgetFriendsList.class, "handleEvent", "handleEvent(Lcom/discord/widgets/friends/FriendsListViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FriendsListViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FriendsListViewModel.Event event) {
            m.checkNotNullParameter(event, "p1");
            WidgetFriendsList.access$handleEvent((WidgetFriendsList) this.receiver, event);
        }
    }

    public WidgetFriendsList() {
        super(R.layout.widget_friends_list);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetFriendsList$binding$2.INSTANCE, null, 2, null);
        WidgetFriendsList$viewModel$2 widgetFriendsList$viewModel$2 = WidgetFriendsList$viewModel$2.INSTANCE;
        b.a.d.g0 g0Var = new b.a.d.g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(FriendsListViewModel.class), new WidgetFriendsList$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetFriendsList$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetFriendsList widgetFriendsList, FriendsListViewModel.ViewState viewState) {
        widgetFriendsList.configureUI(viewState);
    }

    public static final /* synthetic */ boolean access$getShowContactSyncIcon$p(WidgetFriendsList widgetFriendsList) {
        return widgetFriendsList.showContactSyncIcon;
    }

    public static final /* synthetic */ FriendsListViewModel access$getViewModel$p(WidgetFriendsList widgetFriendsList) {
        return widgetFriendsList.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetFriendsList widgetFriendsList, FriendsListViewModel.Event event) {
        widgetFriendsList.handleEvent(event);
    }

    public static final /* synthetic */ void access$setShowContactSyncIcon$p(WidgetFriendsList widgetFriendsList, boolean z2) {
        widgetFriendsList.showContactSyncIcon = z2;
    }

    private final void configureToolbar() {
        AppFragment.bindToolbar$default(this, null, 1, null);
        setActionBarTitle(R.string.friends);
        setActionBarTitleLayoutMinimumTappableArea();
        setActionBarOptionsMenu(R.menu.menu_friends, new AnonymousClass1(), new AnonymousClass2());
    }

    private final void configureUI(FriendsListViewModel.ViewState viewState) {
        if (m.areEqual(viewState, FriendsListViewModel.ViewState.Uninitialized.INSTANCE)) {
            showLoadingView();
        } else if (viewState instanceof FriendsListViewModel.ViewState.Empty) {
            showEmptyView((FriendsListViewModel.ViewState.Empty) viewState);
        } else {
            if (!(viewState instanceof FriendsListViewModel.ViewState.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            updateView((FriendsListViewModel.ViewState.Loaded) viewState);
        }
    }

    private final void displayFlipperChild(int index) {
        AppViewFlipper appViewFlipper = getBinding().c;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.friendsListFlipper");
        appViewFlipper.setVisibility(0);
        AppViewFlipper appViewFlipper2 = getBinding().c;
        m.checkNotNullExpressionValue(appViewFlipper2, "binding.friendsListFlipper");
        appViewFlipper2.setDisplayedChild(index);
    }

    private final WidgetFriendsListBinding getBinding() {
        return (WidgetFriendsListBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final FriendsListViewModel getViewModel() {
        return (FriendsListViewModel) this.viewModel.getValue();
    }

    private final void handleCaptchaError(FriendsListViewModel.Event.CaptchaError event) {
        WidgetCaptchaBottomSheet.Companion.enqueue$default(WidgetCaptchaBottomSheet.INSTANCE, "Add Friend Captcha", new AnonymousClass1(event), null, CaptchaErrorBody.INSTANCE.createFromError(event.getError()), 4, null);
    }

    private final void handleEvent(FriendsListViewModel.Event event) {
        if (event instanceof FriendsListViewModel.Event.ShowToast) {
            handleShowToast((FriendsListViewModel.Event.ShowToast) event);
            return;
        }
        if (event instanceof FriendsListViewModel.Event.ShowFriendRequestErrorToast) {
            handleShowFriendRequestErrorToast((FriendsListViewModel.Event.ShowFriendRequestErrorToast) event);
        } else if (event instanceof FriendsListViewModel.Event.LaunchVoiceCall) {
            handleLaunchVoiceCall((FriendsListViewModel.Event.LaunchVoiceCall) event);
        } else {
            if (!(event instanceof FriendsListViewModel.Event.CaptchaError)) {
                throw new NoWhenBranchMatchedException();
            }
            handleCaptchaError((FriendsListViewModel.Event.CaptchaError) event);
        }
    }

    private final void handleLaunchVoiceCall(FriendsListViewModel.Event.LaunchVoiceCall event) {
        PrivateCallLauncher privateCallLauncher = this.privateCallLauncher;
        if (privateCallLauncher == null) {
            m.throwUninitializedPropertyAccessException("privateCallLauncher");
        }
        privateCallLauncher.launchVoiceCall(event.getChannelId());
    }

    private final void handleShowFriendRequestErrorToast(FriendsListViewModel.Event.ShowFriendRequestErrorToast event) {
        b.a.d.m.j(this, RestAPIAbortMessages.ResponseResolver.INSTANCE.getRelationshipResponse(getContext(), event.getAbortCode(), event.getUsername()), 0, 4);
    }

    private final void handleShowToast(FriendsListViewModel.Event.ShowToast event) {
        b.a.d.m.i(this, event.getStringRes(), 0, 4);
    }

    private final void showEmptyView(FriendsListViewModel.ViewState.Empty viewState) {
        displayFlipperChild(1);
        this.showContactSyncIcon = viewState.getShowContactSyncIcon();
        configureToolbar();
    }

    private final void showLoadingView() {
        displayFlipperChild(2);
    }

    private final void updateView(FriendsListViewModel.ViewState.Loaded viewState) {
        displayFlipperChild(0);
        WidgetFriendsListAdapter widgetFriendsListAdapter = this.adapter;
        if (widgetFriendsListAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter.setData(viewState.getItems());
        this.showContactSyncIcon = viewState.getShowContactSyncIcon();
        configureToolbar();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context contextRequireContext = requireContext();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        this.privateCallLauncher = new PrivateCallLauncher(this, this, contextRequireContext, parentFragmentManager);
    }

    @Override // com.discord.widgets.tabs.OnTabSelectedListener
    public void onTabSelected() {
        configureToolbar();
        AnalyticsTracker.INSTANCE.friendsListViewed();
        setActionBarTitleAccessibilityViewFocused();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof WidgetTabsHost)) {
            parentFragment = null;
        }
        WidgetTabsHost widgetTabsHost = (WidgetTabsHost) parentFragment;
        if (widgetTabsHost != null) {
            widgetTabsHost.registerTabSelectionListener(NavigationTab.FRIENDS, this);
        }
        getBinding().f2396b.updateView(ANALYTICS_SOURCE);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().e;
        m.checkNotNullExpressionValue(recyclerView, "binding.friendsListRecycler");
        WidgetFriendsListAdapter widgetFriendsListAdapter = (WidgetFriendsListAdapter) companion.configure(new WidgetFriendsListAdapter(recyclerView));
        this.adapter = widgetFriendsListAdapter;
        if (widgetFriendsListAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter.setOnClickUserProfile(new AnonymousClass1());
        WidgetFriendsListAdapter widgetFriendsListAdapter2 = this.adapter;
        if (widgetFriendsListAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter2.setOnClickPendingHeaderExpand(new AnonymousClass2());
        WidgetFriendsListAdapter widgetFriendsListAdapter3 = this.adapter;
        if (widgetFriendsListAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter3.setOnClickCall(new AnonymousClass3());
        WidgetFriendsListAdapter widgetFriendsListAdapter4 = this.adapter;
        if (widgetFriendsListAdapter4 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter4.setOnClickChat(new AnonymousClass4());
        WidgetFriendsListAdapter widgetFriendsListAdapter5 = this.adapter;
        if (widgetFriendsListAdapter5 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter5.setOnClickAcceptFriend(new AnonymousClass5());
        WidgetFriendsListAdapter widgetFriendsListAdapter6 = this.adapter;
        if (widgetFriendsListAdapter6 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter6.setOnClickDeclineFriend(new AnonymousClass6());
        WidgetFriendsListAdapter widgetFriendsListAdapter7 = this.adapter;
        if (widgetFriendsListAdapter7 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter7.setOnClickContactSyncUpsell(new AnonymousClass7());
        WidgetFriendsListAdapter widgetFriendsListAdapter8 = this.adapter;
        if (widgetFriendsListAdapter8 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter8.setOnClickContactSyncUpsellLongClick(new AnonymousClass8());
        WidgetFriendsListAdapter widgetFriendsListAdapter9 = this.adapter;
        if (widgetFriendsListAdapter9 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter9.setOnClickSuggestedHeaderExpandCollapse(new AnonymousClass9());
        WidgetFriendsListAdapter widgetFriendsListAdapter10 = this.adapter;
        if (widgetFriendsListAdapter10 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter10.setOnClickApproveSuggestion(new AnonymousClass10());
        WidgetFriendsListAdapter widgetFriendsListAdapter11 = this.adapter;
        if (widgetFriendsListAdapter11 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter11.setOnClickRemoveSuggestion(new AnonymousClass11(getViewModel()));
        this.loadingAdapter = new WidgetFriendsListLoadingAdapter();
        RecyclerView recyclerView2 = getBinding().d;
        m.checkNotNullExpressionValue(recyclerView2, "binding.friendsListLoading");
        WidgetFriendsListLoadingAdapter widgetFriendsListLoadingAdapter = this.loadingAdapter;
        if (widgetFriendsListLoadingAdapter == null) {
            m.throwUninitializedPropertyAccessException("loadingAdapter");
        }
        recyclerView2.setAdapter(widgetFriendsListLoadingAdapter);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetFriendsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetFriendsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}
