package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverviewViewModel;
import java.util.Map;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverview extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetChannelSettingsPermissionsOverview.class, "viewBinding", "getViewBinding()Lcom/discord/databinding/WidgetChannelSettingsPermissionsOverviewBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int TAB_INDEX_ADVANCED = 1;
    private static final int TAB_INDEX_MODERATOR = 0;
    private static final int VIEW_INDEX_ADVANCED = 1;
    private static final int VIEW_INDEX_STAGE_MODERATOR = 0;

    /* JADX INFO: renamed from: viewBinding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate viewBinding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long channelId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            AppScreen2.m156d(context, WidgetChannelSettingsPermissionsOverview.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canManage;
        private final Channel channel;
        private final Guild guild;
        private final Map<Long, GuildRole> guildRoles;
        private final MeUser me;
        private final long myPermissions;

        /* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId) {
                Observable observableM11099Y = StoreStream.INSTANCE.getChannels().observeChannel(channelId).m11099Y(new WidgetChannelSettingsPermissionsOverview2(channelId));
                Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream.getChannels(…          }\n            }");
                return observableM11099Y;
            }

            public final boolean isValid(MeUser me2, Guild guild, Channel channel, Long myPermissionsForChannel) {
                return (me2 == null || guild == null || channel == null || myPermissionsForChannel == null) ? false : true;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, Guild guild, Channel channel, long j, Map<Long, GuildRole> map) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(map, "guildRoles");
            this.me = meUser;
            this.guild = guild;
            this.channel = channel;
            this.myPermissions = j;
            this.guildRoles = map;
            this.canManage = guild.getOwnerId() == meUser.getId() || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, Long.valueOf(j), meUser.getMfaEnabled(), guild.getMfaLevel()) || PermissionUtils.canAndIsElevated(8L, Long.valueOf(j), meUser.getMfaEnabled(), guild.getMfaLevel());
        }

        /* JADX WARN: Multi-variable type inference failed */
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

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getMyPermissions() {
            return this.myPermissions;
        }

        public final Map<Long, GuildRole> component5() {
            return this.guildRoles;
        }

        public final Model copy(MeUser me2, Guild guild, Channel channel, long myPermissions, Map<Long, GuildRole> guildRoles) {
            Intrinsics3.checkNotNullParameter(me2, "me");
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
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
            return Intrinsics3.areEqual(this.me, model.me) && Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.channel, model.channel) && this.myPermissions == model.myPermissions && Intrinsics3.areEqual(this.guildRoles, model.guildRoles);
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
            int iM3a = (C0002b.m3a(this.myPermissions) + ((iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31)) * 31;
            Map<Long, GuildRole> map = this.guildRoles;
            return iM3a + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(me=");
            sbM833U.append(this.me);
            sbM833U.append(", guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", myPermissions=");
            sbM833U.append(this.myPermissions);
            sbM833U.append(", guildRoles=");
            return outline.m825M(sbM833U, this.guildRoles, ")");
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

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview$configureTabs$1 */
    /* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
    public static final class C75541 extends Lambda implements Function1<Integer, Unit> {
        public C75541() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            WidgetChannelSettingsPermissionsOverviewViewModel.Tab tab;
            if (i == 0) {
                tab = WidgetChannelSettingsPermissionsOverviewViewModel.Tab.MODERATOR;
            } else {
                if (i != 1) {
                    throw new IllegalArgumentException(outline.m871q("illegal index: ", i));
                }
                tab = WidgetChannelSettingsPermissionsOverviewViewModel.Tab.ADVANCED;
            }
            WidgetChannelSettingsPermissionsOverview.access$getViewModel$p(WidgetChannelSettingsPermissionsOverview.this).selectTab(tab);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
    public static final class C75551 extends Lambda implements Function1<Model, Unit> {
        public C75551() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetChannelSettingsPermissionsOverview.access$configureUI(WidgetChannelSettingsPermissionsOverview.this, model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsOverview$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
    public static final class C75562 extends Lambda implements Function1<WidgetChannelSettingsPermissionsOverviewViewModel.ViewState, Unit> {
        public C75562() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSettingsPermissionsOverviewViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelSettingsPermissionsOverviewViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetChannelSettingsPermissionsOverview.access$configureTabs(WidgetChannelSettingsPermissionsOverview.this, viewState);
        }
    }

    public WidgetChannelSettingsPermissionsOverview() {
        super(C5419R.layout.widget_channel_settings_permissions_overview);
        this.viewBinding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelSettingsPermissionsOverview3.INSTANCE, null, 2, null);
        WidgetChannelSettingsPermissionsOverview4 widgetChannelSettingsPermissionsOverview4 = new WidgetChannelSettingsPermissionsOverview4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetChannelSettingsPermissionsOverviewViewModel.class), new C7553x17255b9c(appViewModelDelegates3), new AppViewModelDelegates5(widgetChannelSettingsPermissionsOverview4));
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
            AppViewFlipper appViewFlipper = getViewBinding().f15956b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "viewBinding.flipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (iOrdinal == 1) {
            AppViewFlipper appViewFlipper2 = getViewBinding().f15956b;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "viewBinding.flipper");
            appViewFlipper2.setDisplayedChild(1);
        }
        SegmentedControlContainer segmentedControlContainer = getViewBinding().f15957c;
        int iOrdinal2 = viewState.getSelectedTab().ordinal();
        if (iOrdinal2 == 0) {
            i = 0;
        } else {
            if (iOrdinal2 != 1) {
                throw new NoWhenBranchMatchedException();
            }
            i = 1;
        }
        segmentedControlContainer.m8607a(i);
        getViewBinding().f15957c.setOnSegmentSelectedChangeListener(new C75541());
        SegmentedControlContainer segmentedControlContainer2 = getViewBinding().f15957c;
        Intrinsics3.checkNotNullExpressionValue(segmentedControlContainer2, "viewBinding.segmentedControl");
        segmentedControlContainer2.setVisibility(viewState.getAvailableTabs().size() > 1 ? 0 : 8);
    }

    private final void configureToolbar(Channel channel) {
        setActionBarTitle(ChannelUtils.m7687k(channel) ? C5419R.string.category_settings : C5419R.string.channel_settings);
        setActionBarSubtitle(ChannelUtils.m7680d(channel, requireContext(), true));
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<Model> observableM11112r = Model.INSTANCE.get(getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L)).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Model\n        .get(chann…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11112r), this, null, 2, null), WidgetChannelSettingsPermissionsOverview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C75551(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChannelSettingsPermissionsOverview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C75562(), 62, (Object) null);
    }
}
