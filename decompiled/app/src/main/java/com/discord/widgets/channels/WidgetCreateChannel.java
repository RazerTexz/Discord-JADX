package com.discord.widgets.channels;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionChannelCreate;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.ViewCheckableRoleListItemThemedBinding;
import com.discord.databinding.WidgetCreateChannelBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.channel.GuildChannelIconUtils2;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.mg_recycler.SingleTypePayload;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.stage.StageChannelUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember;
import com.discord.widgets.forums.ForumUtils;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.functions.Action2;

/* compiled from: WidgetCreateChannel.kt */
/* loaded from: classes2.dex */
public final class WidgetCreateChannel extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetCreateChannel.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCreateChannelBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_CATEGORY_ID = "INTENT_CATEGORY_ID";
    private static final String INTENT_DISABLE_ANNOUNCEMENT_CHANNEL_TYPE = "INTENT_DISABLE_ANNOUNCEMENT_CHANNEL_TYPE";
    private static final String INTENT_DISABLE_PRIVATE_SWITCH = "INTENT_DISABLE_PRIVATE_SWITCH";
    private static final String INTENT_GUILD_ID = "INTENT_GUILD_ID";
    private static final String INTENT_PROVIDE_RESULT_ONLY = "INTENT_PROVIDE_RESULT_ONLY";
    private static final String INTENT_SHOULD_CHANNEL_DEFAULT_PRIVATE = "INTENT_SHOULD_CHANNEL_DEFAULT_PRIVATE";
    private static final String INTENT_TYPE = "INTENT_TYPE";
    private static final String RESULT_EXTRA_CHANNEL_ICON_RES_ID = "RESULT_EXTRA_CHANNEL_ICON_RES_ID";
    private static final String RESULT_EXTRA_CHANNEL_ID = "RESULT_EXTRA_CHANNEL_ID";
    private static final String RESULT_EXTRA_CHANNEL_NAME = "RESULT_EXTRA_CHANNEL_NAME";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: categoryId$delegate, reason: from kotlin metadata */
    private final Lazy categoryId;

    /* renamed from: disableAnnouncementChannelType$delegate, reason: from kotlin metadata */
    private final Lazy disableAnnouncementChannelType;

    /* renamed from: disablePrivateSwitch$delegate, reason: from kotlin metadata */
    private final Lazy disablePrivateSwitch;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final AppLogger2 loggingConfig;

    /* renamed from: provideResultOnly$delegate, reason: from kotlin metadata */
    private final Lazy provideResultOnly;
    private RolesAdapter rolesAdapter;

    /* renamed from: shouldChannelDefaultPrivate$delegate, reason: from kotlin metadata */
    private final Lazy shouldChannelDefaultPrivate;

    /* renamed from: type$delegate, reason: from kotlin metadata */
    private final Lazy type;

    /* compiled from: WidgetCreateChannel.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, ActivityResultLauncher activityResultLauncher, long j, int i, Long l, boolean z2, boolean z3, boolean z4, boolean z5, int i2, Object obj) {
            companion.launch(context, activityResultLauncher, j, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? null : l, (i2 & 32) != 0 ? false : z2, (i2 & 64) != 0 ? false : z3, (i2 & 128) != 0 ? false : z4, (i2 & 256) != 0 ? false : z5);
        }

        public static /* synthetic */ void show$default(Companion companion, Context context, long j, int i, Long l, int i2, Object obj) {
            int i3 = (i2 & 4) != 0 ? 0 : i;
            if ((i2 & 8) != 0) {
                l = null;
            }
            companion.show(context, j, i3, l);
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, long guildId, int type, Long categoryId, boolean shouldChannelDefaultPrivate, boolean provideResultOnly, boolean disablePrivateSwitch, boolean disableAnnouncementChannelType) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            AppScreen2 appScreen2 = AppScreen2.f524g;
            Intent intent = new Intent();
            intent.putExtra(WidgetCreateChannel.INTENT_GUILD_ID, guildId);
            intent.putExtra(WidgetCreateChannel.INTENT_TYPE, type);
            intent.putExtra(WidgetCreateChannel.INTENT_CATEGORY_ID, categoryId);
            intent.putExtra(WidgetCreateChannel.INTENT_PROVIDE_RESULT_ONLY, provideResultOnly);
            intent.putExtra(WidgetCreateChannel.INTENT_SHOULD_CHANNEL_DEFAULT_PRIVATE, shouldChannelDefaultPrivate);
            intent.putExtra(WidgetCreateChannel.INTENT_DISABLE_PRIVATE_SWITCH, disablePrivateSwitch);
            intent.putExtra(WidgetCreateChannel.INTENT_DISABLE_ANNOUNCEMENT_CHANNEL_TYPE, disableAnnouncementChannelType);
            appScreen2.m160f(context, launcher, WidgetCreateChannel.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function3<? super Long, ? super String, ? super Integer, Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetCreateChannel$Companion$registerForResult$1(callback));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public final void show(Context context, long guildId, int type, Long categoryId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra(WidgetCreateChannel.INTENT_GUILD_ID, guildId);
            intent.putExtra(WidgetCreateChannel.INTENT_TYPE, type);
            intent.putExtra(WidgetCreateChannel.INTENT_CATEGORY_ID, categoryId);
            AppScreen2.m156d(context, WidgetCreateChannel.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    public static final class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canCreate;
        private final boolean canCreateCommunityChannels;
        private final boolean canCreateForumChannels;
        private final boolean canManageRoles;
        private final List<SingleTypePayload<GuildRole>> roleItems;

        /* compiled from: WidgetCreateChannel.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId, Long categoryId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM11071f = Observable.m11071f(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeGuild(guildId), companion.getPermissions().observePermissionsForGuild(guildId), companion.getPermissions().observePermissionsForChannel(categoryId != null ? categoryId.longValue() : 0L), companion.getGuilds().observeSortedRoles(guildId), ForumUtils.observeCanCreateForumChannels$default(ForumUtils.INSTANCE, guildId, null, null, 6, null), WidgetCreateChannel$Model$Companion$get$1.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11071f, "Observable\n            .…          }\n            }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11071f).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Observable\n            .…  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Model(boolean z2, boolean z3, boolean z4, boolean z5, List<SingleTypePayload<GuildRole>> list) {
            this.canCreateForumChannels = z2;
            this.canCreate = z3;
            this.canManageRoles = z4;
            this.canCreateCommunityChannels = z5;
            this.roleItems = list;
        }

        public final boolean getCanCreate() {
            return this.canCreate;
        }

        public final boolean getCanCreateCommunityChannels() {
            return this.canCreateCommunityChannels;
        }

        public final boolean getCanCreateForumChannels() {
            return this.canCreateForumChannels;
        }

        public final boolean getCanManageRoles() {
            return this.canManageRoles;
        }

        public final List<SingleTypePayload<GuildRole>> getRoleItems() {
            return this.roleItems;
        }

        public /* synthetic */ Model(boolean z2, boolean z3, boolean z4, boolean z5, List list, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, z3, z4, z5, list);
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    public static final class RolesAdapter extends MGRecyclerAdapterSimple<SingleTypePayload<GuildRole>> {
        private final Map<Long, Integer> checkedRoles;

        /* compiled from: WidgetCreateChannel.kt */
        public static final class RoleListItem extends MGRecyclerViewHolder<RolesAdapter, SingleTypePayload<GuildRole>> {
            private final ViewCheckableRoleListItemThemedBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RoleListItem(RolesAdapter rolesAdapter) {
                super(C5419R.layout.view_checkable_role_list_item_themed, rolesAdapter);
                Intrinsics3.checkNotNullParameter(rolesAdapter, "adapter");
                View view = this.itemView;
                Objects.requireNonNull(view, "rootView");
                CheckedSetting checkedSetting = (CheckedSetting) view;
                ViewCheckableRoleListItemThemedBinding viewCheckableRoleListItemThemedBinding = new ViewCheckableRoleListItemThemedBinding(checkedSetting, checkedSetting);
                Intrinsics3.checkNotNullExpressionValue(viewCheckableRoleListItemThemedBinding, "ViewCheckableRoleListIte…medBinding.bind(itemView)");
                this.binding = viewCheckableRoleListItemThemedBinding;
            }

            public static final /* synthetic */ RolesAdapter access$getAdapter$p(RoleListItem roleListItem) {
                return (RolesAdapter) roleListItem.adapter;
            }

            public static final /* synthetic */ ViewCheckableRoleListItemThemedBinding access$getBinding$p(RoleListItem roleListItem) {
                return roleListItem.binding;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, SingleTypePayload<GuildRole> singleTypePayload) {
                onConfigure2(i, singleTypePayload);
            }

            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, SingleTypePayload<GuildRole> data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                GuildRole data2 = data.getData();
                boolean zContainsKey = ((RolesAdapter) this.adapter).getCheckedRoles().containsKey(Long.valueOf(data2.getId()));
                CheckedSetting checkedSetting = this.binding.f15400b;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.roleItemCheckedSetting");
                checkedSetting.setChecked(zContainsKey);
                this.binding.f15400b.m8527e(new WidgetCreateChannel$RolesAdapter$RoleListItem$onConfigure$1(this, data2));
                this.binding.f15400b.setText(data2.getName());
                CheckedSetting checkedSetting2 = this.binding.f15400b;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.roleItemCheckedSetting");
                Context context = checkedSetting2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "binding.roleItemCheckedSetting.context");
                checkedSetting2.setTextColor(RoleUtils.getRoleColor$default(data2, context, null, 2, null));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RolesAdapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
            this.checkedRoles = new HashMap();
        }

        public static final /* synthetic */ void access$onRoleClicked(RolesAdapter rolesAdapter, boolean z2, int i, long j) {
            rolesAdapter.onRoleClicked(z2, i, j);
        }

        private final void onRoleClicked(boolean checked, int position, long roleId) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(position));
            if (checked) {
                this.checkedRoles.put(Long.valueOf(roleId), Integer.valueOf(position));
            } else {
                this.checkedRoles.remove(Long.valueOf(roleId));
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                if (iIntValue < getPageSize()) {
                    notifyItemChanged(iIntValue);
                }
            }
        }

        public final Map<Long, Integer> getCheckedRoles() {
            return this.checkedRoles;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple
        public void setData(List<SingleTypePayload<GuildRole>> data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.setData(data);
            this.checkedRoles.clear();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<?, SingleTypePayload<GuildRole>> onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return new RoleListItem(this);
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$configureUI$1 */
    public static final class C73701<T1, T2> implements Action2<MenuItem, Context> {

        /* compiled from: WidgetCreateChannel.kt */
        /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$configureUI$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Channel, TrackNetworkMetadata2> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(Channel channel) {
                return invoke2(channel);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final TrackNetworkMetadata2 invoke2(Channel channel) {
                List<PermissionOverwrite> listM7655v;
                return new TrackNetworkActionChannelCreate((channel == null || (listM7655v = channel.m7655v()) == null) ? null : Boolean.valueOf(!listM7655v.isEmpty()), channel != null ? Long.valueOf(channel.getType()) : null, channel != null ? Long.valueOf(channel.getId()) : null, channel != null ? Long.valueOf(channel.getParentId()) : null, Long.valueOf(WidgetCreateChannel.access$getGuildId$p(WidgetCreateChannel.this)));
            }
        }

        /* compiled from: WidgetCreateChannel.kt */
        /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$configureUI$1$2, reason: invalid class name */
        public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Channel, Unit> {
            public AnonymousClass2(WidgetCreateChannel widgetCreateChannel) {
                super(1, widgetCreateChannel, WidgetCreateChannel.class, "onChannelCreated", "onChannelCreated(Lcom/discord/api/channel/Channel;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
                invoke2(channel);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Channel channel) {
                Intrinsics3.checkNotNullParameter(channel, "p1");
                WidgetCreateChannel.access$onChannelCreated((WidgetCreateChannel) this.receiver, channel);
            }
        }

        public C73701() {
        }

        @Override // p658rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullParameter(menuItem, "menuItem");
            if (menuItem.getItemId() == C5419R.id.menu_sort_channel) {
                RestAPI api = RestAPI.INSTANCE.getApi();
                long jAccess$getGuildId$p = WidgetCreateChannel.access$getGuildId$p(WidgetCreateChannel.this);
                int iAccess$getChannelType$p = WidgetCreateChannel.access$getChannelType$p(WidgetCreateChannel.this);
                TextInputLayout textInputLayout = WidgetCreateChannel.access$getBinding$p(WidgetCreateChannel.this).f16424f;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.createChannelNameLayout");
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(api.createGuildChannel(jAccess$getGuildId$p, new RestAPIParams.CreateGuildChannel(iAccess$getChannelType$p, null, ViewExtensions.getTextOrEmpty(textInputLayout), WidgetCreateChannel.access$getCategoryId$p(WidgetCreateChannel.this), WidgetCreateChannel.access$getPermissionOverwrites(WidgetCreateChannel.this), null)), new AnonymousClass1()), false, 1, null), WidgetCreateChannel.this, null, 2, null), WidgetCreateChannel.this.getClass(), WidgetCreateChannel.this.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(WidgetCreateChannel.this), 60, (Object) null);
            }
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C73711 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public C73711(WidgetCreateChannel widgetCreateChannel) {
            super(1, widgetCreateChannel, WidgetCreateChannel.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/WidgetCreateChannel$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetCreateChannel.access$configureUI((WidgetCreateChannel) this.receiver, model);
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$onViewBoundOrOnResume$2 */
    public static final class ViewOnClickListenerC73722 implements View.OnClickListener {
        public final /* synthetic */ RadioManager $radioManager;

        public ViewOnClickListenerC73722(RadioManager radioManager) {
            this.$radioManager = radioManager;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RadioManager radioManager = this.$radioManager;
            RadioButton radioButton = WidgetCreateChannel.access$getBinding$p(WidgetCreateChannel.this).f16435q;
            Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.createChannelTextRadio");
            radioManager.m8550a(radioButton);
            WidgetCreateChannel.access$configurePrivateRoles(WidgetCreateChannel.this);
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$onViewBoundOrOnResume$3 */
    public static final class ViewOnClickListenerC73733 implements View.OnClickListener {
        public final /* synthetic */ RadioManager $radioManager;

        public ViewOnClickListenerC73733(RadioManager radioManager) {
            this.$radioManager = radioManager;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RadioManager radioManager = this.$radioManager;
            RadioButton radioButton = WidgetCreateChannel.access$getBinding$p(WidgetCreateChannel.this).f16438t;
            Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.createChannelVoiceRadio");
            radioManager.m8550a(radioButton);
            WidgetCreateChannel.access$configurePrivateRoles(WidgetCreateChannel.this);
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$onViewBoundOrOnResume$4 */
    public static final class ViewOnClickListenerC73744 implements View.OnClickListener {
        public final /* synthetic */ RadioManager $radioManager;

        public ViewOnClickListenerC73744(RadioManager radioManager) {
            this.$radioManager = radioManager;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RadioManager radioManager = this.$radioManager;
            RadioButton radioButton = WidgetCreateChannel.access$getBinding$p(WidgetCreateChannel.this).f16421c;
            Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.createChannelAnnouncementsRadio");
            radioManager.m8550a(radioButton);
            WidgetCreateChannel.access$configurePrivateRoles(WidgetCreateChannel.this);
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$onViewBoundOrOnResume$5 */
    public static final class ViewOnClickListenerC73755 implements View.OnClickListener {
        public final /* synthetic */ RadioManager $radioManager;

        public ViewOnClickListenerC73755(RadioManager radioManager) {
            this.$radioManager = radioManager;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RadioManager radioManager = this.$radioManager;
            RadioButton radioButton = WidgetCreateChannel.access$getBinding$p(WidgetCreateChannel.this).f16433o;
            Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.createChannelStageRadio");
            radioManager.m8550a(radioButton);
            WidgetCreateChannel.access$configurePrivateRoles(WidgetCreateChannel.this);
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$onViewBoundOrOnResume$6 */
    public static final class ViewOnClickListenerC73766 implements View.OnClickListener {
        public final /* synthetic */ RadioManager $radioManager;

        public ViewOnClickListenerC73766(RadioManager radioManager) {
            this.$radioManager = radioManager;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RadioManager radioManager = this.$radioManager;
            RadioButton radioButton = WidgetCreateChannel.access$getBinding$p(WidgetCreateChannel.this).f16423e;
            Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.createChannelForumRadio");
            radioManager.m8550a(radioButton);
            WidgetCreateChannel.access$configurePrivateRoles(WidgetCreateChannel.this);
        }
    }

    /* compiled from: WidgetCreateChannel.kt */
    /* renamed from: com.discord.widgets.channels.WidgetCreateChannel$onViewBoundOrOnResume$7 */
    public static final class ViewOnClickListenerC73777 implements View.OnClickListener {
        public ViewOnClickListenerC73777() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SwitchCompat switchCompat = WidgetCreateChannel.access$getBinding$p(WidgetCreateChannel.this).f16427i;
            Intrinsics3.checkNotNullExpressionValue(switchCompat, "binding.createChannelPrivateSwitch");
            Intrinsics3.checkNotNullExpressionValue(WidgetCreateChannel.access$getBinding$p(WidgetCreateChannel.this).f16427i, "binding.createChannelPrivateSwitch");
            switchCompat.setChecked(!r1.isChecked());
            WidgetCreateChannel.access$configurePrivateRoles(WidgetCreateChannel.this);
        }
    }

    public WidgetCreateChannel() {
        super(C5419R.layout.widget_create_channel);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetCreateChannel$binding$2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetCreateChannel$guildId$2(this));
        this.type = LazyJVM.lazy(new WidgetCreateChannel$type$2(this));
        this.categoryId = LazyJVM.lazy(new WidgetCreateChannel$categoryId$2(this));
        this.provideResultOnly = LazyJVM.lazy(new WidgetCreateChannel$provideResultOnly$2(this));
        this.shouldChannelDefaultPrivate = LazyJVM.lazy(new WidgetCreateChannel$shouldChannelDefaultPrivate$2(this));
        this.disablePrivateSwitch = LazyJVM.lazy(new WidgetCreateChannel$disablePrivateSwitch$2(this));
        this.disableAnnouncementChannelType = LazyJVM.lazy(new WidgetCreateChannel$disableAnnouncementChannelType$2(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetCreateChannel$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configurePrivateRoles(WidgetCreateChannel widgetCreateChannel) {
        widgetCreateChannel.configurePrivateRoles();
    }

    public static final /* synthetic */ void access$configureUI(WidgetCreateChannel widgetCreateChannel, Model model) {
        widgetCreateChannel.configureUI(model);
    }

    public static final /* synthetic */ WidgetCreateChannelBinding access$getBinding$p(WidgetCreateChannel widgetCreateChannel) {
        return widgetCreateChannel.getBinding();
    }

    public static final /* synthetic */ Long access$getCategoryId$p(WidgetCreateChannel widgetCreateChannel) {
        return widgetCreateChannel.getCategoryId();
    }

    public static final /* synthetic */ int access$getChannelType$p(WidgetCreateChannel widgetCreateChannel) {
        return widgetCreateChannel.getChannelType();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetCreateChannel widgetCreateChannel) {
        return widgetCreateChannel.getGuildId();
    }

    public static final /* synthetic */ List access$getPermissionOverwrites(WidgetCreateChannel widgetCreateChannel) {
        return widgetCreateChannel.getPermissionOverwrites();
    }

    public static final /* synthetic */ void access$onChannelCreated(WidgetCreateChannel widgetCreateChannel, Channel channel) {
        widgetCreateChannel.onChannelCreated(channel);
    }

    private final void configurePrivateRoles() {
        boolean z2 = (getChannelType() == 13 || getDisablePrivateSwitch()) ? false : true;
        SwitchCompat switchCompat = getBinding().f16427i;
        Intrinsics3.checkNotNullExpressionValue(switchCompat, "binding.createChannelPrivateSwitch");
        boolean zIsChecked = switchCompat.isChecked();
        RelativeLayout relativeLayout = getBinding().f16425g;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.createChannelPrivateContainer");
        relativeLayout.setVisibility(z2 ? 0 : 8);
        View view = getBinding().f16430l;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.createChannelRoleDivider");
        view.setVisibility(z2 ? 0 : 8);
        TextView textView = getBinding().f16431m;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.createChannelRoleHeader");
        textView.setVisibility(z2 && zIsChecked ? 0 : 8);
        RecyclerView recyclerView = getBinding().f16429k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.createChannelRoleAccessRecycler");
        recyclerView.setVisibility(z2 && zIsChecked ? 0 : 8);
    }

    private final void configureUI(Model model) {
        if (model == null || !model.getCanCreate()) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(getType() == 4 ? C5419R.string.create_category : C5419R.string.create_channel);
        AppFragment.setActionBarOptionsMenu$default(this, C5419R.menu.menu_channel_create, new C73701(), null, 4, null);
        ConstraintLayout constraintLayout = getBinding().f16420b;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.createChannelAnnouncementsContainer");
        constraintLayout.setVisibility(model.getCanCreateCommunityChannels() && !getDisableAnnouncementChannelType() ? 0 : 8);
        ConstraintLayout constraintLayout2 = getBinding().f16432n;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.createChannelStageContainer");
        constraintLayout2.setVisibility(model.getCanCreateCommunityChannels() && model.getCanManageRoles() ? 0 : 8);
        ConstraintLayout constraintLayout3 = getBinding().f16422d;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout3, "binding.createChannelForumContainer");
        constraintLayout3.setVisibility(model.getCanCreateForumChannels() ? 0 : 8);
        RolesAdapter rolesAdapter = this.rolesAdapter;
        if (rolesAdapter != null) {
            rolesAdapter.setData(model.getRoleItems());
        }
    }

    private final void finishActivity() {
        AppFragment.hideKeyboard$default(this, null, 1, null);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }

    private final WidgetCreateChannelBinding getBinding() {
        return (WidgetCreateChannelBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Long getCategoryId() {
        return (Long) this.categoryId.getValue();
    }

    private final int getChannelType() {
        if (getType() == 4) {
            return 4;
        }
        RadioButton radioButton = getBinding().f16438t;
        Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.createChannelVoiceRadio");
        if (radioButton.isChecked()) {
            return 2;
        }
        RadioButton radioButton2 = getBinding().f16421c;
        Intrinsics3.checkNotNullExpressionValue(radioButton2, "binding.createChannelAnnouncementsRadio");
        if (radioButton2.isChecked()) {
            return 5;
        }
        RadioButton radioButton3 = getBinding().f16433o;
        Intrinsics3.checkNotNullExpressionValue(radioButton3, "binding.createChannelStageRadio");
        if (radioButton3.isChecked()) {
            return 13;
        }
        RadioButton radioButton4 = getBinding().f16423e;
        Intrinsics3.checkNotNullExpressionValue(radioButton4, "binding.createChannelForumRadio");
        return radioButton4.isChecked() ? 15 : 0;
    }

    private final boolean getDisableAnnouncementChannelType() {
        return ((Boolean) this.disableAnnouncementChannelType.getValue()).booleanValue();
    }

    private final boolean getDisablePrivateSwitch() {
        return ((Boolean) this.disablePrivateSwitch.getValue()).booleanValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<RestAPIParams.ChannelPermissionOverwrites> getPermissionOverwrites() {
        Map<Long, Integer> checkedRoles;
        Set<Long> setKeySet;
        Map<Long, Integer> checkedRoles2;
        Set<Long> setKeySet2;
        if (getChannelType() != 13) {
            SwitchCompat switchCompat = getBinding().f16427i;
            Intrinsics3.checkNotNullExpressionValue(switchCompat, "binding.createChannelPrivateSwitch");
            if (!switchCompat.isChecked()) {
                if (!getDisablePrivateSwitch() || !getShouldChannelDefaultPrivate()) {
                    return null;
                }
            }
        }
        RolesAdapter rolesAdapter = this.rolesAdapter;
        if (rolesAdapter != null && (checkedRoles2 = rolesAdapter.getCheckedRoles()) != null && (setKeySet2 = checkedRoles2.keySet()) != null && setKeySet2.contains(Long.valueOf(getGuildId()))) {
            return null;
        }
        long j = (getChannelType() == 2 || getChannelType() == 13) ? Permission.CONNECT : Permission.VIEW_CHANNEL;
        ArrayList arrayList = new ArrayList();
        arrayList.add(RestAPIParams.ChannelPermissionOverwrites.INSTANCE.createForRole(getGuildId(), 0L, Long.valueOf(j)));
        RolesAdapter rolesAdapter2 = this.rolesAdapter;
        if (rolesAdapter2 != null && (checkedRoles = rolesAdapter2.getCheckedRoles()) != null && (setKeySet = checkedRoles.keySet()) != null) {
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                arrayList.add(RestAPIParams.ChannelPermissionOverwrites.INSTANCE.createForRole(((Number) it.next()).longValue(), Long.valueOf(j), 0L));
            }
        }
        return arrayList;
    }

    private final boolean getProvideResultOnly() {
        return ((Boolean) this.provideResultOnly.getValue()).booleanValue();
    }

    private final boolean getShouldChannelDefaultPrivate() {
        return ((Boolean) this.shouldChannelDefaultPrivate.getValue()).booleanValue();
    }

    private final int getType() {
        return ((Number) this.type.getValue()).intValue();
    }

    private final void onChannelCreated(Channel channel) {
        if (getProvideResultOnly()) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intent intent = new Intent();
            intent.putExtra(RESULT_EXTRA_CHANNEL_ID, channel.getId());
            intent.putExtra(RESULT_EXTRA_CHANNEL_NAME, ChannelUtils.m7679c(channel));
            intent.putExtra(RESULT_EXTRA_CHANNEL_ICON_RES_ID, GuildChannelIconUtils2.guildChannelIcon(channel));
            fragmentActivityRequireActivity.setResult(-1, intent);
            finishActivity();
            return;
        }
        if (channel.getType() == 0) {
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), channel, null, null, 6, null);
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        boolean zComputeCanEditStageModerators = StageChannelUtils.computeCanEditStageModerators(companion.getPermissions(), companion.getGuilds(), companion.getUsers().getMeSnapshot().getId(), getGuildId(), channel);
        if (channel.getType() == 13 && zComputeCanEditStageModerators) {
            WidgetCreateChannelAddMember.INSTANCE.create(requireContext(), channel.getId());
        }
        finishActivity();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16429k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.createChannelRoleAccessRecycler");
        this.rolesAdapter = (RolesAdapter) companion.configure(new RolesAdapter(recyclerView));
        getBinding().f16429k.setHasFixedSize(false);
        RecyclerView recyclerView2 = getBinding().f16429k;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.createChannelRoleAccessRecycler");
        recyclerView2.setNestedScrollingEnabled(false);
        SwitchCompat switchCompat = getBinding().f16427i;
        Intrinsics3.checkNotNullExpressionValue(switchCompat, "binding.createChannelPrivateSwitch");
        switchCompat.setChecked(getShouldChannelDefaultPrivate() || getDisablePrivateSwitch());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getGuildId(), getCategoryId()), this, null, 2, null), WidgetCreateChannel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C73711(this), 62, (Object) null);
        RadioManager radioManager = new RadioManager(Collections2.listOf((Object[]) new RadioButton[]{getBinding().f16435q, getBinding().f16438t, getBinding().f16421c, getBinding().f16433o, getBinding().f16423e}));
        getBinding().f16434p.setOnClickListener(new ViewOnClickListenerC73722(radioManager));
        getBinding().f16437s.setOnClickListener(new ViewOnClickListenerC73733(radioManager));
        getBinding().f16420b.setOnClickListener(new ViewOnClickListenerC73744(radioManager));
        getBinding().f16432n.setOnClickListener(new ViewOnClickListenerC73755(radioManager));
        getBinding().f16422d.setOnClickListener(new ViewOnClickListenerC73766(radioManager));
        int type = getType();
        if (type == 0) {
            RadioButton radioButton = getBinding().f16435q;
            Intrinsics3.checkNotNullExpressionValue(radioButton, "binding.createChannelTextRadio");
            radioManager.m8550a(radioButton);
        } else if (type == 2) {
            RadioButton radioButton2 = getBinding().f16438t;
            Intrinsics3.checkNotNullExpressionValue(radioButton2, "binding.createChannelVoiceRadio");
            radioManager.m8550a(radioButton2);
        } else if (type == 5) {
            RadioButton radioButton3 = getBinding().f16421c;
            Intrinsics3.checkNotNullExpressionValue(radioButton3, "binding.createChannelAnnouncementsRadio");
            radioManager.m8550a(radioButton3);
        } else if (type == 13) {
            RadioButton radioButton4 = getBinding().f16433o;
            Intrinsics3.checkNotNullExpressionValue(radioButton4, "binding.createChannelStageRadio");
            radioManager.m8550a(radioButton4);
        } else if (type == 15) {
            RadioButton radioButton5 = getBinding().f16423e;
            Intrinsics3.checkNotNullExpressionValue(radioButton5, "binding.createChannelForumRadio");
            radioManager.m8550a(radioButton5);
        }
        configurePrivateRoles();
        getBinding().f16425g.setOnClickListener(new ViewOnClickListenerC73777());
        LinearLayout linearLayout = getBinding().f16436r;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.createChannelTypeContainer");
        linearLayout.setVisibility(getType() != 4 ? 0 : 8);
        getBinding().f16428j.setText(getType() == 4 ? C5419R.string.private_category : C5419R.string.private_channel);
        getBinding().f16426h.setText(getType() == 4 ? C5419R.string.private_category_note : C5419R.string.private_channel_note);
        getBinding().f16431m.setText(getType() == 4 ? C5419R.string.form_label_category_permissions : C5419R.string.form_label_channel_permissions);
        TextInputLayout textInputLayout = getBinding().f16424f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.createChannelNameLayout");
        textInputLayout.setHint(getString(getType() == 4 ? C5419R.string.category_name : C5419R.string.form_label_channel_name));
    }
}
