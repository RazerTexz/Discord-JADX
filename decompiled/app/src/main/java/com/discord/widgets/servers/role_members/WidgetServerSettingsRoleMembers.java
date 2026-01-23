package com.discord.widgets.servers.role_members;

import android.content.Context;
import android.view.View;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsRoleMembersBinding;
import com.discord.dialogs.SimpleConfirmationDialog2;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.SimpleConfirmationDialog;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.Tuples;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerSettingsRoleMembers.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsRoleMembersBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_GUILD_ROLE_ID = "INTENT_EXTRA_GUILD_ROLE_ID";
    private static final int ROLE_MEMBERS_VIEW_FLIPPER_LOADING_STATE = 0;
    private static final int ROLE_MEMBERS_VIEW_FLIPPER_RESULT = 1;
    private WidgetServerSettingsRoleMembers2 adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: guildRoleId$delegate, reason: from kotlin metadata */
    private final Lazy guildRoleId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetServerSettingsRoleMembers newInstance(long guildRoleId, long guildId) {
            WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers = new WidgetServerSettingsRoleMembers();
            widgetServerSettingsRoleMembers.setArguments(Bundle2.bundleOf(Tuples.m10073to(WidgetServerSettingsRoleMembers.INTENT_EXTRA_GUILD_ROLE_ID, Long.valueOf(guildRoleId)), Tuples.m10073to("INTENT_EXTRA_GUILD_ID", Long.valueOf(guildId))));
            return widgetServerSettingsRoleMembers;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers$configureUI$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
    public static final class C95771 extends Lambda implements Function2<GuildMember, User, Unit> {
        public final /* synthetic */ ServerSettingsRoleMembersViewModel.ViewState $viewState;

        /* JADX INFO: renamed from: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers$configureUI$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
        public static final class AnonymousClass1 implements View.OnClickListener {
            public final /* synthetic */ GuildMember $guildMember;

            public AnonymousClass1(GuildMember guildMember) {
                this.$guildMember = guildMember;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetServerSettingsRoleMembers.access$getViewModel$p(WidgetServerSettingsRoleMembers.this).removeRoleFromMember(this.$guildMember);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C95771(ServerSettingsRoleMembersViewModel.ViewState viewState) {
            super(2);
            this.$viewState = viewState;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(GuildMember guildMember, User user) {
            invoke2(guildMember, user);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildMember guildMember, User user) {
            Intrinsics3.checkNotNullParameter(guildMember, "guildMember");
            Intrinsics3.checkNotNullParameter(user, "user");
            SimpleConfirmationDialog.Companion companion = SimpleConfirmationDialog.INSTANCE;
            FragmentManager childFragmentManager = WidgetServerSettingsRoleMembers.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            String string = WidgetServerSettingsRoleMembers.this.getString(C5419R.string.role_remove_member_confirm_title);
            Context contextRequireContext = WidgetServerSettingsRoleMembers.this.requireContext();
            Object[] objArr = new Object[2];
            Object nick = guildMember.getNick();
            if (nick == null) {
                nick = UserUtils.getUserNameWithDiscriminator$default(UserUtils.INSTANCE, user, null, null, 3, null);
            }
            objArr[0] = nick;
            objArr[1] = ((ServerSettingsRoleMembersViewModel.ViewState.Loaded) this.$viewState).getRole().getName();
            companion.m128a(childFragmentManager, new SimpleConfirmationDialog2(string, FormatUtils.m216h(contextRequireContext, C5419R.string.role_remove_member_confirm_body, objArr, null, 4).toString(), WidgetServerSettingsRoleMembers.this.getString(C5419R.string.remove), WidgetServerSettingsRoleMembers.this.getString(C5419R.string.cancel)), new AnonymousClass1(guildMember));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
    public static final class C95781 extends Lambda implements Function1<String, Unit> {
        public C95781() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "searchQuery");
            WidgetServerSettingsRoleMembers.access$getViewModel$p(WidgetServerSettingsRoleMembers.this).updateSearchQuery(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
    public static final class C95791 extends Lambda implements Function1<ServerSettingsRoleMembersViewModel.ViewState, Unit> {
        public C95791() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsRoleMembersViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsRoleMembersViewModel.ViewState viewState) {
            WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers = WidgetServerSettingsRoleMembers.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            WidgetServerSettingsRoleMembers.access$configureUI(widgetServerSettingsRoleMembers, viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.role_members.WidgetServerSettingsRoleMembers$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
    public static final class C95802 extends Lambda implements Function1<ServerSettingsRoleMembersViewModel.Event, Unit> {
        public C95802() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsRoleMembersViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsRoleMembersViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetServerSettingsRoleMembers.access$handleEvents(WidgetServerSettingsRoleMembers.this, event);
        }
    }

    public WidgetServerSettingsRoleMembers() {
        super(C5419R.layout.widget_server_settings_role_members);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsRoleMembers4.INSTANCE, null, 2, null);
        this.guildRoleId = LazyJVM.lazy(new WidgetServerSettingsRoleMembers6(this));
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsRoleMembers5(this));
        WidgetServerSettingsRoleMembers7 widgetServerSettingsRoleMembers7 = new WidgetServerSettingsRoleMembers7(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ServerSettingsRoleMembersViewModel.class), new C9576x93a19a7a(appViewModelDelegates3), new AppViewModelDelegates5(widgetServerSettingsRoleMembers7));
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
            AppViewFlipper appViewFlipper = getBinding().f17745b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.roleMembersAppViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (viewState instanceof ServerSettingsRoleMembersViewModel.ViewState.Loaded) {
            AppViewFlipper appViewFlipper2 = getBinding().f17745b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.roleMembersAppViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            WidgetServerSettingsRoleMembers2 widgetServerSettingsRoleMembers2 = this.adapter;
            if (widgetServerSettingsRoleMembers2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("adapter");
            }
            widgetServerSettingsRoleMembers2.setRemoveMemberClickListener(new C95771(viewState));
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
            AppToast.m171i(this, C5419R.string.default_failure_to_perform_action_message, 0, 4);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.adapter = new WidgetServerSettingsRoleMembers2(this, null, 2, null);
        RecyclerView recyclerView = getBinding().f17746c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsRoleMembersList");
        WidgetServerSettingsRoleMembers2 widgetServerSettingsRoleMembers2 = this.adapter;
        if (widgetServerSettingsRoleMembers2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(widgetServerSettingsRoleMembers2);
        getBinding().f17747d.m8553a(this, new C95781());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<ServerSettingsRoleMembersViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), WidgetServerSettingsRoleMembers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C95791(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetServerSettingsRoleMembers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C95802(), 62, (Object) null);
    }
}
