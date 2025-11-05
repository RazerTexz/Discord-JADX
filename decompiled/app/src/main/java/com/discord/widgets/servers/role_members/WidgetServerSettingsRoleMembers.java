package com.discord.widgets.servers.role_members;

import android.content.Context;
import android.view.View;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.SimpleConfirmationDialog;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsRoleMembersBinding;
import com.discord.dialogs.SimpleConfirmationDialog2;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel;
import d0.LazyJVM;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsRoleMembers.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsRoleMembers.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsRoleMembersBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_GUILD_ROLE_ID = "INTENT_EXTRA_GUILD_ROLE_ID";
    private static final int ROLE_MEMBERS_VIEW_FLIPPER_LOADING_STATE = 0;
    private static final int ROLE_MEMBERS_VIEW_FLIPPER_RESULT = 1;
    private WidgetServerSettingsRoleMembers2 adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: guildRoleId$delegate, reason: from kotlin metadata */
    private final Lazy guildRoleId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetServerSettingsRoleMembers.kt */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetServerSettingsRoleMembers newInstance(long guildRoleId, long guildId) {
            WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers = new WidgetServerSettingsRoleMembers();
            widgetServerSettingsRoleMembers.setArguments(Bundle2.bundleOf(Tuples.to(WidgetServerSettingsRoleMembers.INTENT_EXTRA_GUILD_ROLE_ID, Long.valueOf(guildRoleId)), Tuples.to("INTENT_EXTRA_GUILD_ID", Long.valueOf(guildId))));
            return widgetServerSettingsRoleMembers;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsRoleMembers.kt */
    /* renamed from: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<GuildMember, User, Unit> {
        public final /* synthetic */ ServerSettingsRoleMembersViewModel.ViewState $viewState;

        /* compiled from: WidgetServerSettingsRoleMembers.kt */
        /* renamed from: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class ViewOnClickListenerC03211 implements View.OnClickListener {
            public final /* synthetic */ GuildMember $guildMember;

            public ViewOnClickListenerC03211(GuildMember guildMember) {
                this.$guildMember = guildMember;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsRoleMembers.access$getViewModel$p(WidgetServerSettingsRoleMembers.this).removeRoleFromMember(this.$guildMember);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ServerSettingsRoleMembersViewModel.ViewState viewState) {
            super(2);
            this.$viewState = viewState;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(GuildMember guildMember, User user) {
            invoke2(guildMember, user);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildMember guildMember, User user) {
            Intrinsics3.checkNotNullParameter(guildMember, "guildMember");
            Intrinsics3.checkNotNullParameter(user, "user");
            SimpleConfirmationDialog.Companion companion = SimpleConfirmationDialog.INSTANCE;
            FragmentManager childFragmentManager = WidgetServerSettingsRoleMembers.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            String string = WidgetServerSettingsRoleMembers.this.getString(R.string.role_remove_member_confirm_title);
            Context contextRequireContext = WidgetServerSettingsRoleMembers.this.requireContext();
            Object[] objArr = new Object[2];
            Object nick = guildMember.getNick();
            if (nick == null) {
                nick = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null);
            }
            objArr[0] = nick;
            objArr[1] = ((ServerSettingsRoleMembersViewModel.ViewState.Loaded) this.$viewState).getRole().getName();
            companion.a(childFragmentManager, new SimpleConfirmationDialog2(string, FormatUtils.h(contextRequireContext, R.string.role_remove_member_confirm_body, objArr, null, 4).toString(), WidgetServerSettingsRoleMembers.this.getString(R.string.remove), WidgetServerSettingsRoleMembers.this.getString(R.string.cancel)), new ViewOnClickListenerC03211(guildMember));
        }
    }

    /* compiled from: WidgetServerSettingsRoleMembers.kt */
    /* renamed from: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "searchQuery");
            WidgetServerSettingsRoleMembers.access$getViewModel$p(WidgetServerSettingsRoleMembers.this).updateSearchQuery(str);
        }
    }

    /* compiled from: WidgetServerSettingsRoleMembers.kt */
    /* renamed from: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ServerSettingsRoleMembersViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsRoleMembersViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsRoleMembersViewModel.ViewState viewState) {
            WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers = WidgetServerSettingsRoleMembers.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            WidgetServerSettingsRoleMembers.access$configureUI(widgetServerSettingsRoleMembers, viewState);
        }
    }

    /* compiled from: WidgetServerSettingsRoleMembers.kt */
    /* renamed from: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<ServerSettingsRoleMembersViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsRoleMembersViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsRoleMembersViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetServerSettingsRoleMembers.access$handleEvents(WidgetServerSettingsRoleMembers.this, event);
        }
    }

    public WidgetServerSettingsRoleMembers() {
        super(R.layout.widget_server_settings_role_members);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsRoleMembers4.INSTANCE, null, 2, null);
        this.guildRoleId = LazyJVM.lazy(new WidgetServerSettingsRoleMembers6(this));
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsRoleMembers5(this));
        WidgetServerSettingsRoleMembers7 widgetServerSettingsRoleMembers7 = new WidgetServerSettingsRoleMembers7(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ServerSettingsRoleMembersViewModel.class), new WidgetServerSettingsRoleMembers$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetServerSettingsRoleMembers7));
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers, ServerSettingsRoleMembersViewModel.ViewState viewState) {
        widgetServerSettingsRoleMembers.configureUI(viewState);
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers) {
        return widgetServerSettingsRoleMembers.getGuildId();
    }

    public static final /* synthetic */ long access$getGuildRoleId$p(WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers) {
        return widgetServerSettingsRoleMembers.getGuildRoleId();
    }

    public static final /* synthetic */ ServerSettingsRoleMembersViewModel access$getViewModel$p(WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers) {
        return widgetServerSettingsRoleMembers.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvents(WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers, ServerSettingsRoleMembersViewModel.Event event) {
        widgetServerSettingsRoleMembers.handleEvents(event);
    }

    private final void configureUI(ServerSettingsRoleMembersViewModel.ViewState viewState) {
        if (viewState instanceof ServerSettingsRoleMembersViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().f2584b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.roleMembersAppViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (viewState instanceof ServerSettingsRoleMembersViewModel.ViewState.Loaded) {
            AppViewFlipper appViewFlipper2 = getBinding().f2584b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.roleMembersAppViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            WidgetServerSettingsRoleMembers2 widgetServerSettingsRoleMembers2 = this.adapter;
            if (widgetServerSettingsRoleMembers2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("adapter");
            }
            widgetServerSettingsRoleMembers2.setRemoveMemberClickListener(new AnonymousClass1(viewState));
            WidgetServerSettingsRoleMembers2 widgetServerSettingsRoleMembers22 = this.adapter;
            if (widgetServerSettingsRoleMembers22 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("adapter");
            }
            widgetServerSettingsRoleMembers22.setItems(((ServerSettingsRoleMembersViewModel.ViewState.Loaded) viewState).getMemberList());
        }
    }

    private final WidgetServerSettingsRoleMembersBinding getBinding() {
        return (WidgetServerSettingsRoleMembersBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final long getGuildRoleId() {
        return ((Number) this.guildRoleId.getValue()).longValue();
    }

    private final ServerSettingsRoleMembersViewModel getViewModel() {
        return (ServerSettingsRoleMembersViewModel) this.viewModel.getValue();
    }

    private final void handleEvents(ServerSettingsRoleMembersViewModel.Event event) {
        if (event instanceof ServerSettingsRoleMembersViewModel.Event.RemoveMemberFailure) {
            AppToast.i(this, R.string.default_failure_to_perform_action_message, 0, 4);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.adapter = new WidgetServerSettingsRoleMembers2(this, null, 2, null);
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsRoleMembersList");
        WidgetServerSettingsRoleMembers2 widgetServerSettingsRoleMembers2 = this.adapter;
        if (widgetServerSettingsRoleMembers2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(widgetServerSettingsRoleMembers2);
        getBinding().d.a(this, new AnonymousClass1());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<ServerSettingsRoleMembersViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetServerSettingsRoleMembers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetServerSettingsRoleMembers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
