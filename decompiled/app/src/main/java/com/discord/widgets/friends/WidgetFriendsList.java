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
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
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
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.functions.Action1;
import p658rx.functions.Action2;

/* JADX INFO: compiled from: WidgetFriendsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsList extends AppFragment implements OnTabSelectedListener {
    private static final String ANALYTICS_SOURCE = "Friends";
    private static final int VIEW_INDEX_EMPTY = 1;
    private static final int VIEW_INDEX_LOADING = 2;
    private static final int VIEW_INDEX_RECYCLER = 0;
    private WidgetFriendsListAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetFriendsList5 loadingAdapter;
    private PrivateCallLauncher privateCallLauncher;
    private boolean showContactSyncIcon;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetFriendsList.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFriendsListBinding;", 0)};

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsList$configureToolbar$1 */
    /* JADX INFO: compiled from: WidgetFriendsList.kt */
    public static final class C83981<T1, T2> implements Action2<MenuItem, Context> {
        public C83981() {
        }

        @Override // p658rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case C5419R.id.menu_friends_add_friend /* 2131364389 */:
                    WidgetFriendsAdd.Companion companion = WidgetFriendsAdd.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    WidgetFriendsAdd.Companion.show$default(companion, context, null, WidgetFriendsList.ANALYTICS_SOURCE, 2, null);
                    break;
                case C5419R.id.menu_friends_contact_sync /* 2131364390 */:
                    ContactSyncFlowAnalytics.Companion.trackStart$default(ContactSyncFlowAnalytics.INSTANCE, false, MapsJVM.mapOf(Tuples.m10073to("location_page", "Friends List Icon")), 1, null);
                    AnalyticsTracker.INSTANCE.openModal("Contact Sync", new Traits.Location("Friends List Icon", null, null, null, null, 30, null));
                    WidgetContactSync.Companion companion2 = WidgetContactSync.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    WidgetContactSync.Companion.launch$default(companion2, context, null, false, false, false, 30, null);
                    break;
                case C5419R.id.menu_friends_start_group /* 2131364391 */:
                    if (!GroupInviteFriendsSheetFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
                        WidgetGroupInviteFriends.INSTANCE.launch(WidgetFriendsList.this.requireContext(), WidgetFriendsList.ANALYTICS_SOURCE);
                    } else {
                        GroupInviteFriendsSheet.Companion companion3 = GroupInviteFriendsSheet.INSTANCE;
                        FragmentManager parentFragmentManager = WidgetFriendsList.this.getParentFragmentManager();
                        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                        GroupInviteFriendsSheet.Companion.show$default(companion3, parentFragmentManager, 0L, WidgetFriendsList.ANALYTICS_SOURCE, 2, null);
                    }
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsList$configureToolbar$2 */
    /* JADX INFO: compiled from: WidgetFriendsList.kt */
    public static final class C83992<T> implements Action1<Menu> {
        public C83992() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            MenuItem menuItemFindItem = menu.findItem(C5419R.id.menu_friends_contact_sync);
            if (menuItemFindItem != null) {
                menuItemFindItem.setVisible(WidgetFriendsList.access$getShowContactSyncIcon$p(WidgetFriendsList.this));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsList$handleCaptchaError$1 */
    /* JADX INFO: compiled from: WidgetFriendsList.kt */
    public static final class C84001 extends Lambda implements Function2<AppFragment, CaptchaHelper.CaptchaPayload, Unit> {
        public final /* synthetic */ FriendsListViewModel.Event.CaptchaError $event;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C84001(FriendsListViewModel.Event.CaptchaError captchaError) {
            super(2);
            this.$event = captchaError;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            invoke2(appFragment, captchaPayload);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AppFragment appFragment, CaptchaHelper.CaptchaPayload captchaPayload) {
            Intrinsics3.checkNotNullParameter(appFragment, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(captchaPayload, "captchaPayload");
            WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).acceptFriendSuggestion(this.$event.getUsername(), this.$event.getDiscriminator(), captchaPayload);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetFriendsList.kt */
    public static final class C84011 extends Lambda implements Function2<View, User, Unit> {
        public C84011() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(View view, User user) {
            invoke2(view, user);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view, User user) {
            Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(user, "user");
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = user.getId();
            FragmentManager parentFragmentManager = WidgetFriendsList.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$10 */
    /* JADX INFO: compiled from: WidgetFriendsList.kt */
    public static final class C840210 extends Lambda implements Function1<User, Unit> {
        public C840210() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            FriendsListViewModel.acceptFriendSuggestion$default(WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this), user.getUsername(), user.getDiscriminator(), null, 4, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$11 */
    /* JADX INFO: compiled from: WidgetFriendsList.kt */
    public static final /* synthetic */ class C840311 extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public C840311(FriendsListViewModel friendsListViewModel) {
            super(1, friendsListViewModel, FriendsListViewModel.class, "ignoreSuggestion", "ignoreSuggestion(J)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            ((FriendsListViewModel) this.receiver).ignoreSuggestion(j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetFriendsList.kt */
    public static final class C84042 extends Lambda implements Function0<Unit> {
        public C84042() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).handleClickPendingHeader();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetFriendsList.kt */
    public static final class C84053 extends Lambda implements Function1<User, Unit> {
        public C84053() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).launchVoiceCall(user.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetFriendsList.kt */
    public static final class C84064 extends Lambda implements Function1<User, Unit> {
        public C84064() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            ChannelSelector.INSTANCE.getInstance().findAndSetDirectMessage(WidgetFriendsList.this.requireContext(), user.getId());
            StoreTabsNavigation.selectHomeTab$default(StoreStream.INSTANCE.getTabsNavigation(), StoreNavigation.PanelAction.CLOSE, false, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$5 */
    /* JADX INFO: compiled from: WidgetFriendsList.kt */
    public static final class C84075 extends Lambda implements Function1<User, Unit> {
        public C84075() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            Intrinsics3.checkNotNullParameter(user, "it");
            WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).acceptFriendRequest(user.getId(), user.getUsername());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$6 */
    /* JADX INFO: compiled from: WidgetFriendsList.kt */
    public static final class C84086 extends Lambda implements Function2<User, Integer, Unit> {
        public C84086() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(User user, Integer num) {
            invoke(user, num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(User user, int i) {
            Intrinsics3.checkNotNullParameter(user, "user");
            WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).removeFriendRequest(user.getId(), i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$7 */
    /* JADX INFO: compiled from: WidgetFriendsList.kt */
    public static final class C84097 extends Lambda implements Function0<Unit> {
        public C84097() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ContactSyncFlowAnalytics.Companion.trackStart$default(ContactSyncFlowAnalytics.INSTANCE, false, MapsJVM.mapOf(Tuples.m10073to("location_page", "Friends List Upsell")), 1, null);
            AnalyticsTracker.INSTANCE.openModal("Contact Sync", new Traits.Location("Friends List Upsell", null, null, null, null, 30, null));
            WidgetContactSync.Companion.launch$default(WidgetContactSync.INSTANCE, WidgetFriendsList.this.requireContext(), null, false, false, false, 30, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$8 */
    /* JADX INFO: compiled from: WidgetFriendsList.kt */
    public static final class C84108 extends Lambda implements Function1<View, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$8$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetFriendsList.kt */
        public static final class AnonymousClass1 implements MenuItem.OnMenuItemClickListener {
            public AnonymousClass1() {
            }

            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).dismissContactSyncUpsell();
                return true;
            }
        }

        public C84108() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "upsellView");
            PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(view.getContext(), 2131951663), view);
            popupMenu.getMenuInflater().inflate(C5419R.menu.menu_contact_sync_upsell, popupMenu.getMenu());
            popupMenu.getMenu().findItem(C5419R.id.menu_contact_sync_upsell_dismiss).setOnMenuItemClickListener(new AnonymousClass1());
            popupMenu.show();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBound$9 */
    /* JADX INFO: compiled from: WidgetFriendsList.kt */
    public static final class C84119 extends Lambda implements Function0<Unit> {
        public C84119() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetFriendsList.access$getViewModel$p(WidgetFriendsList.this).handleClickSuggestedHeader();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetFriendsList.kt */
    public static final /* synthetic */ class C84121 extends FunctionReferenceImpl implements Function1<FriendsListViewModel.ViewState, Unit> {
        public C84121(WidgetFriendsList widgetFriendsList) {
            super(1, widgetFriendsList, WidgetFriendsList.class, "configureUI", "configureUI(Lcom/discord/widgets/friends/FriendsListViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FriendsListViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FriendsListViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetFriendsList.access$configureUI((WidgetFriendsList) this.receiver, viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsList$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetFriendsList.kt */
    public static final /* synthetic */ class C84132 extends FunctionReferenceImpl implements Function1<FriendsListViewModel.Event, Unit> {
        public C84132(WidgetFriendsList widgetFriendsList) {
            super(1, widgetFriendsList, WidgetFriendsList.class, "handleEvent", "handleEvent(Lcom/discord/widgets/friends/FriendsListViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FriendsListViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(FriendsListViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetFriendsList.access$handleEvent((WidgetFriendsList) this.receiver, event);
        }
    }

    public WidgetFriendsList() {
        super(C5419R.layout.widget_friends_list);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetFriendsList3.INSTANCE, null, 2, null);
        WidgetFriendsList4 widgetFriendsList4 = WidgetFriendsList4.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(FriendsListViewModel.class), new WidgetFriendsList$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetFriendsList4));
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
        setActionBarTitle(C5419R.string.friends);
        setActionBarTitleLayoutMinimumTappableArea();
        setActionBarOptionsMenu(C5419R.menu.menu_friends, new C83981(), new C83992());
    }

    private final void configureUI(FriendsListViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, FriendsListViewModel.ViewState.Uninitialized.INSTANCE)) {
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
        AppViewFlipper appViewFlipper = getBinding().f16678c;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.friendsListFlipper");
        appViewFlipper.setVisibility(0);
        AppViewFlipper appViewFlipper2 = getBinding().f16678c;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.friendsListFlipper");
        appViewFlipper2.setDisplayedChild(index);
    }

    private final WidgetFriendsListBinding getBinding() {
        return (WidgetFriendsListBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final FriendsListViewModel getViewModel() {
        return (FriendsListViewModel) this.viewModel.getValue();
    }

    private final void handleCaptchaError(FriendsListViewModel.Event.CaptchaError event) {
        WidgetCaptchaBottomSheet.Companion.enqueue$default(WidgetCaptchaBottomSheet.INSTANCE, "Add Friend Captcha", new C84001(event), null, CaptchaErrorBody.INSTANCE.createFromError(event.getError()), 4, null);
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
            Intrinsics3.throwUninitializedPropertyAccessException("privateCallLauncher");
        }
        privateCallLauncher.launchVoiceCall(event.getChannelId());
    }

    private final void handleShowFriendRequestErrorToast(FriendsListViewModel.Event.ShowFriendRequestErrorToast event) {
        AppToast.m172j(this, RestAPIAbortMessages.ResponseResolver.INSTANCE.getRelationshipResponse(getContext(), event.getAbortCode(), event.getUsername()), 0, 4);
    }

    private final void handleShowToast(FriendsListViewModel.Event.ShowToast event) {
        AppToast.m171i(this, event.getStringRes(), 0, 4);
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
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
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
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof WidgetTabsHost)) {
            parentFragment = null;
        }
        WidgetTabsHost widgetTabsHost = (WidgetTabsHost) parentFragment;
        if (widgetTabsHost != null) {
            widgetTabsHost.registerTabSelectionListener(NavigationTab.FRIENDS, this);
        }
        getBinding().f16677b.updateView(ANALYTICS_SOURCE);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16680e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.friendsListRecycler");
        WidgetFriendsListAdapter widgetFriendsListAdapter = (WidgetFriendsListAdapter) companion.configure(new WidgetFriendsListAdapter(recyclerView));
        this.adapter = widgetFriendsListAdapter;
        if (widgetFriendsListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter.setOnClickUserProfile(new C84011());
        WidgetFriendsListAdapter widgetFriendsListAdapter2 = this.adapter;
        if (widgetFriendsListAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter2.setOnClickPendingHeaderExpand(new C84042());
        WidgetFriendsListAdapter widgetFriendsListAdapter3 = this.adapter;
        if (widgetFriendsListAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter3.setOnClickCall(new C84053());
        WidgetFriendsListAdapter widgetFriendsListAdapter4 = this.adapter;
        if (widgetFriendsListAdapter4 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter4.setOnClickChat(new C84064());
        WidgetFriendsListAdapter widgetFriendsListAdapter5 = this.adapter;
        if (widgetFriendsListAdapter5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter5.setOnClickAcceptFriend(new C84075());
        WidgetFriendsListAdapter widgetFriendsListAdapter6 = this.adapter;
        if (widgetFriendsListAdapter6 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter6.setOnClickDeclineFriend(new C84086());
        WidgetFriendsListAdapter widgetFriendsListAdapter7 = this.adapter;
        if (widgetFriendsListAdapter7 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter7.setOnClickContactSyncUpsell(new C84097());
        WidgetFriendsListAdapter widgetFriendsListAdapter8 = this.adapter;
        if (widgetFriendsListAdapter8 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter8.setOnClickContactSyncUpsellLongClick(new C84108());
        WidgetFriendsListAdapter widgetFriendsListAdapter9 = this.adapter;
        if (widgetFriendsListAdapter9 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter9.setOnClickSuggestedHeaderExpandCollapse(new C84119());
        WidgetFriendsListAdapter widgetFriendsListAdapter10 = this.adapter;
        if (widgetFriendsListAdapter10 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter10.setOnClickApproveSuggestion(new C840210());
        WidgetFriendsListAdapter widgetFriendsListAdapter11 = this.adapter;
        if (widgetFriendsListAdapter11 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetFriendsListAdapter11.setOnClickRemoveSuggestion(new C840311(getViewModel()));
        this.loadingAdapter = new WidgetFriendsList5();
        RecyclerView recyclerView2 = getBinding().f16679d;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.friendsListLoading");
        WidgetFriendsList5 widgetFriendsList5 = this.loadingAdapter;
        if (widgetFriendsList5 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("loadingAdapter");
        }
        recyclerView2.setAdapter(widgetFriendsList5);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetFriendsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C84121(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetFriendsList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C84132(this), 62, (Object) null);
    }
}
