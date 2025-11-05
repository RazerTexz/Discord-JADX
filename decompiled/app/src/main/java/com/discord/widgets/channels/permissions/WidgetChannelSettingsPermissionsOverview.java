package com.discord.widgets.channels.permissions;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetChannelSettingsPermissionsOverviewBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverviewViewModel;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverview extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelSettingsPermissionsOverview.class, "viewBinding", "getViewBinding()Lcom/discord/databinding/WidgetChannelSettingsPermissionsOverviewBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int TAB_INDEX_ADVANCED = 1;
    private static final int TAB_INDEX_MODERATOR = 0;
    private static final int VIEW_INDEX_ADVANCED = 1;
    private static final int VIEW_INDEX_STAGE_MODERATOR = 0;

    /* renamed from: viewBinding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate viewBinding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long channelId) {
            m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            j.d(context, WidgetChannelSettingsPermissionsOverview.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canManage;
        private final Channel channel;
        private final Guild guild;
        private final Map<Long, GuildRole> guildRoles;
        private final MeUser me;
        private final long myPermissions;

        /* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId) {
                Observable observableY = StoreStream.INSTANCE.getChannels().observeChannel(channelId).Y(new WidgetChannelSettingsPermissionsOverview$Model$Companion$get$1(channelId));
                m.checkNotNullExpressionValue(observableY, "StoreStream.getChannels(…          }\n            }");
                return observableY;
            }

            public final boolean isValid(MeUser me2, Guild guild, Channel channel, Long myPermissionsForChannel) {
                return (me2 == null || guild == null || channel == null || myPermissionsForChannel == null) ? false : true;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, Guild guild, Channel channel, long j, Map<Long, GuildRole> map) {
            m.checkNotNullParameter(meUser, "me");
            m.checkNotNullParameter(guild, "guild");
            m.checkNotNullParameter(channel, "channel");
            m.checkNotNullParameter(map, "guildRoles");
            this.me = meUser;
            this.guild = guild;
            this.channel = channel;
            this.myPermissions = j;
            this.guildRoles = map;
            this.canManage = guild.getOwnerId() == meUser.getId() || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, Long.valueOf(j), meUser.getMfaEnabled(), guild.getMfaLevel()) || PermissionUtils.canAndIsElevated(8L, Long.valueOf(j), meUser.getMfaEnabled(), guild.getMfaLevel());
        }

        public static /* synthetic */ Model copy$default(Model model, MeUser meUser, Guild guild, Channel channel, long j, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                meUser = model.me;
            }
            if ((i & 2) != 0) {
                guild = model.guild;
            }
            Guild guild2 = guild;
            if ((i & 4) != 0) {
                channel = model.channel;
            }
            Channel channel2 = channel;
            if ((i & 8) != 0) {
                j = model.myPermissions;
            }
            long j2 = j;
            if ((i & 16) != 0) {
                map = model.guildRoles;
            }
            return model.copy(meUser, guild2, channel2, j2, map);
        }

        /* renamed from: component1, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component3, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component4, reason: from getter */
        public final long getMyPermissions() {
            return this.myPermissions;
        }

        public final Map<Long, GuildRole> component5() {
            return this.guildRoles;
        }

        public final Model copy(MeUser me2, Guild guild, Channel channel, long myPermissions, Map<Long, GuildRole> guildRoles) {
            m.checkNotNullParameter(me2, "me");
            m.checkNotNullParameter(guild, "guild");
            m.checkNotNullParameter(channel, "channel");
            m.checkNotNullParameter(guildRoles, "guildRoles");
            return new Model(me2, guild, channel, myPermissions, guildRoles);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return m.areEqual(this.me, model.me) && m.areEqual(this.guild, model.guild) && m.areEqual(this.channel, model.channel) && this.myPermissions == model.myPermissions && m.areEqual(this.guildRoles, model.guildRoles);
        }

        public final boolean getCanManage() {
            return this.canManage;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Map<Long, GuildRole> getGuildRoles() {
            return this.guildRoles;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final long getMyPermissions() {
            return this.myPermissions;
        }

        public int hashCode() {
            MeUser meUser = this.me;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iA = (b.a(this.myPermissions) + ((iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31)) * 31;
            Map<Long, GuildRole> map = this.guildRoles;
            return iA + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(me=");
            sbU.append(this.me);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", myPermissions=");
            sbU.append(this.myPermissions);
            sbU.append(", guildRoles=");
            return a.M(sbU, this.guildRoles, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            WidgetChannelSettingsPermissionsOverviewViewModel.Tab.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            WidgetChannelSettingsPermissionsOverviewViewModel.Tab tab = WidgetChannelSettingsPermissionsOverviewViewModel.Tab.MODERATOR;
            iArr[tab.ordinal()] = 1;
            WidgetChannelSettingsPermissionsOverviewViewModel.Tab tab2 = WidgetChannelSettingsPermissionsOverviewViewModel.Tab.ADVANCED;
            iArr[tab2.ordinal()] = 2;
            WidgetChannelSettingsPermissionsOverviewViewModel.Tab.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[tab.ordinal()] = 1;
            iArr2[tab2.ordinal()] = 2;
        }
    }

    /* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview$configureTabs$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetChannelSettingsPermissionsOverviewViewModel.Tab tab;
            if (i == 0) {
                tab = WidgetChannelSettingsPermissionsOverviewViewModel.Tab.MODERATOR;
            } else {
                if (i != 1) {
                    throw new IllegalArgumentException(a.q("illegal index: ", i));
                }
                tab = WidgetChannelSettingsPermissionsOverviewViewModel.Tab.ADVANCED;
            }
            WidgetChannelSettingsPermissionsOverview.access$getViewModel$p(WidgetChannelSettingsPermissionsOverview.this).selectTab(tab);
        }
    }

    /* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetChannelSettingsPermissionsOverview.access$configureUI(WidgetChannelSettingsPermissionsOverview.this, model);
        }
    }

    /* compiled from: WidgetChannelSettingsPermissionsOverview.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<WidgetChannelSettingsPermissionsOverviewViewModel.ViewState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSettingsPermissionsOverviewViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelSettingsPermissionsOverviewViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "viewState");
            WidgetChannelSettingsPermissionsOverview.access$configureTabs(WidgetChannelSettingsPermissionsOverview.this, viewState);
        }
    }

    public WidgetChannelSettingsPermissionsOverview() {
        super(R.layout.widget_channel_settings_permissions_overview);
        this.viewBinding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelSettingsPermissionsOverview$viewBinding$2.INSTANCE, null, 2, null);
        WidgetChannelSettingsPermissionsOverview$viewModel$2 widgetChannelSettingsPermissionsOverview$viewModel$2 = new WidgetChannelSettingsPermissionsOverview$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetChannelSettingsPermissionsOverviewViewModel.class), new WidgetChannelSettingsPermissionsOverview$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetChannelSettingsPermissionsOverview$viewModel$2));
    }

    public static final /* synthetic */ void access$configureTabs(WidgetChannelSettingsPermissionsOverview widgetChannelSettingsPermissionsOverview, WidgetChannelSettingsPermissionsOverviewViewModel.ViewState viewState) {
        widgetChannelSettingsPermissionsOverview.configureTabs(viewState);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelSettingsPermissionsOverview widgetChannelSettingsPermissionsOverview, Model model) {
        widgetChannelSettingsPermissionsOverview.configureUI(model);
    }

    public static final /* synthetic */ long access$getChannelIdFromIntent(WidgetChannelSettingsPermissionsOverview widgetChannelSettingsPermissionsOverview) {
        return widgetChannelSettingsPermissionsOverview.getChannelIdFromIntent();
    }

    public static final /* synthetic */ WidgetChannelSettingsPermissionsOverviewViewModel access$getViewModel$p(WidgetChannelSettingsPermissionsOverview widgetChannelSettingsPermissionsOverview) {
        return widgetChannelSettingsPermissionsOverview.getViewModel();
    }

    private final void configureTabs(WidgetChannelSettingsPermissionsOverviewViewModel.ViewState viewState) {
        int i;
        int iOrdinal = viewState.getSelectedTab().ordinal();
        if (iOrdinal == 0) {
            AppViewFlipper appViewFlipper = getViewBinding().f2279b;
            m.checkNotNullExpressionValue(appViewFlipper, "viewBinding.flipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (iOrdinal == 1) {
            AppViewFlipper appViewFlipper2 = getViewBinding().f2279b;
            m.checkNotNullExpressionValue(appViewFlipper2, "viewBinding.flipper");
            appViewFlipper2.setDisplayedChild(1);
        }
        SegmentedControlContainer segmentedControlContainer = getViewBinding().c;
        int iOrdinal2 = viewState.getSelectedTab().ordinal();
        if (iOrdinal2 == 0) {
            i = 0;
        } else {
            if (iOrdinal2 != 1) {
                throw new NoWhenBranchMatchedException();
            }
            i = 1;
        }
        segmentedControlContainer.a(i);
        getViewBinding().c.setOnSegmentSelectedChangeListener(new AnonymousClass1());
        SegmentedControlContainer segmentedControlContainer2 = getViewBinding().c;
        m.checkNotNullExpressionValue(segmentedControlContainer2, "viewBinding.segmentedControl");
        segmentedControlContainer2.setVisibility(viewState.getAvailableTabs().size() > 1 ? 0 : 8);
    }

    private final void configureToolbar(Channel channel) {
        setActionBarTitle(ChannelUtils.k(channel) ? R.string.category_settings : R.string.channel_settings);
        setActionBarSubtitle(ChannelUtils.d(channel, requireContext(), true));
    }

    private final void configureUI(Model model) {
        if (model == null || !model.getCanManage()) {
            requireActivity().finish();
        } else {
            configureToolbar(model.getChannel());
        }
    }

    private final long getChannelIdFromIntent() {
        return getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
    }

    private final WidgetChannelSettingsPermissionsOverviewBinding getViewBinding() {
        return (WidgetChannelSettingsPermissionsOverviewBinding) this.viewBinding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetChannelSettingsPermissionsOverviewViewModel getViewModel() {
        return (WidgetChannelSettingsPermissionsOverviewViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<Model> observableR = Model.INSTANCE.get(getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L)).r();
        m.checkNotNullExpressionValue(observableR, "Model\n        .get(chann…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetChannelSettingsPermissionsOverview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChannelSettingsPermissionsOverview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
