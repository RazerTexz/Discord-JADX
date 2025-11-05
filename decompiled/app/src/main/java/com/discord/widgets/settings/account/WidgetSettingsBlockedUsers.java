package com.discord.widgets.settings.account;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsBlockedUsersBinding;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.settings.account.WidgetSettingsBlockedUsersViewModel;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetSettingsBlockedUsers.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsers extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsBlockedUsers.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsBlockedUsersBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int VIEW_INDEX_EMPTY = 1;
    private static final int VIEW_INDEX_RECYCLER = 0;
    private WidgetSettingsBlockedUsersAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetSettingsBlockedUsers.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            m.checkNotNullParameter(context, "context");
            j.e(context, WidgetSettingsBlockedUsers.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsBlockedUsers.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsers$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<WidgetSettingsBlockedUsersViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetSettingsBlockedUsers widgetSettingsBlockedUsers) {
            super(1, widgetSettingsBlockedUsers, WidgetSettingsBlockedUsers.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetSettingsBlockedUsersViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetSettingsBlockedUsersViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetSettingsBlockedUsers.access$configureUI((WidgetSettingsBlockedUsers) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetSettingsBlockedUsers.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsers$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function1<WidgetSettingsBlockedUsersViewModel.Event, Unit> {
        public AnonymousClass2(WidgetSettingsBlockedUsers widgetSettingsBlockedUsers) {
            super(1, widgetSettingsBlockedUsers, WidgetSettingsBlockedUsers.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetSettingsBlockedUsersViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetSettingsBlockedUsersViewModel.Event event) {
            m.checkNotNullParameter(event, "p1");
            WidgetSettingsBlockedUsers.access$handleEvent((WidgetSettingsBlockedUsers) this.receiver, event);
        }
    }

    /* compiled from: WidgetSettingsBlockedUsers.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsers$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<User, Unit> {
        public AnonymousClass2() {
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
            WidgetSettingsBlockedUsers.access$getViewModel$p(WidgetSettingsBlockedUsers.this).onClickUnblock(user.getId());
        }
    }

    /* compiled from: WidgetSettingsBlockedUsers.kt */
    /* renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsers$onViewCreated$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<User, Unit> {
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
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = user.getId();
            FragmentManager parentFragmentManager = WidgetSettingsBlockedUsers.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
        }
    }

    public WidgetSettingsBlockedUsers() {
        super(R.layout.widget_settings_blocked_users);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsBlockedUsers$binding$2.INSTANCE, null, 2, null);
        WidgetSettingsBlockedUsers$viewModel$2 widgetSettingsBlockedUsers$viewModel$2 = WidgetSettingsBlockedUsers$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetSettingsBlockedUsersViewModel.class), new WidgetSettingsBlockedUsers$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetSettingsBlockedUsers$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsBlockedUsers widgetSettingsBlockedUsers, WidgetSettingsBlockedUsersViewModel.ViewState viewState) {
        widgetSettingsBlockedUsers.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetSettingsBlockedUsersViewModel access$getViewModel$p(WidgetSettingsBlockedUsers widgetSettingsBlockedUsers) {
        return widgetSettingsBlockedUsers.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetSettingsBlockedUsers widgetSettingsBlockedUsers, WidgetSettingsBlockedUsersViewModel.Event event) {
        widgetSettingsBlockedUsers.handleEvent(event);
    }

    private final void configureUI(WidgetSettingsBlockedUsersViewModel.ViewState viewState) {
        if (m.areEqual(viewState, WidgetSettingsBlockedUsersViewModel.ViewState.Uninitialized.INSTANCE)) {
            return;
        }
        if (m.areEqual(viewState, WidgetSettingsBlockedUsersViewModel.ViewState.Empty.INSTANCE)) {
            showEmptyView();
        } else {
            if (!(viewState instanceof WidgetSettingsBlockedUsersViewModel.ViewState.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            showBlockedUsers((WidgetSettingsBlockedUsersViewModel.ViewState.Loaded) viewState);
        }
    }

    private final WidgetSettingsBlockedUsersBinding getBinding() {
        return (WidgetSettingsBlockedUsersBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetSettingsBlockedUsersViewModel getViewModel() {
        return (WidgetSettingsBlockedUsersViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetSettingsBlockedUsersViewModel.Event event) {
        if (!(event instanceof WidgetSettingsBlockedUsersViewModel.Event.ShowToast)) {
            throw new NoWhenBranchMatchedException();
        }
        handleShowToast((WidgetSettingsBlockedUsersViewModel.Event.ShowToast) event);
    }

    private final void handleShowToast(WidgetSettingsBlockedUsersViewModel.Event.ShowToast event) {
        b.a.d.m.i(this, event.getStringRes(), 0, 4);
    }

    private final void showBlockedUsers(WidgetSettingsBlockedUsersViewModel.ViewState.Loaded viewState) {
        AppViewFlipper appViewFlipper = getBinding().f2611b;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.blockedUsersFlipper");
        appViewFlipper.setDisplayedChild(0);
        WidgetSettingsBlockedUsersAdapter widgetSettingsBlockedUsersAdapter = this.adapter;
        if (widgetSettingsBlockedUsersAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSettingsBlockedUsersAdapter.setData(viewState.getItems());
    }

    private final void showEmptyView() {
        AppViewFlipper appViewFlipper = getBinding().f2611b;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.blockedUsersFlipper");
        appViewFlipper.setDisplayedChild(1);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetSettingsBlockedUsers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetSettingsBlockedUsers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setActionBarTitle(R.string.user_settings_blocked_users);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        RecyclerView recyclerView = getBinding().c;
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        m.checkNotNullExpressionValue(recyclerView, "it");
        WidgetSettingsBlockedUsersAdapter widgetSettingsBlockedUsersAdapter = (WidgetSettingsBlockedUsersAdapter) companion.configure(new WidgetSettingsBlockedUsersAdapter(recyclerView));
        this.adapter = widgetSettingsBlockedUsersAdapter;
        if (widgetSettingsBlockedUsersAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSettingsBlockedUsersAdapter.setOnClickUnblock(new AnonymousClass2());
        WidgetSettingsBlockedUsersAdapter widgetSettingsBlockedUsersAdapter2 = this.adapter;
        if (widgetSettingsBlockedUsersAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSettingsBlockedUsersAdapter2.setOnClickUserProfile(new AnonymousClass3());
    }
}
