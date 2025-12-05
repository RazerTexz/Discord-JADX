package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.app.AppFragment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.channels.SimpleRolesAdapter;
import java.util.List;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.C0878n;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p073z.p074a.p075a.C1406p;
import p007b.p008a.p073z.p074a.p075a.C1407q;
import p007b.p008a.p073z.p074a.p075a.C1411u;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;

/* loaded from: classes2.dex */
public class WidgetChannelSettingsPermissionsAddRole extends AppFragment {
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private SimpleRolesAdapter rolesAdapter;
    private RecyclerView rolesRecycler;

    public static class Model {
        private final boolean canManage;
        private final Channel channel;
        private final List<SimpleRolesAdapter.RoleItem> roleItems;

        private Model(MeUser meUser, Guild guild, Channel channel, Long l, List<SimpleRolesAdapter.RoleItem> list) {
            this.channel = channel;
            this.roleItems = list;
            boolean mfaEnabled = meUser.getMfaEnabled();
            this.canManage = guild.getOwnerId() == meUser.getId() || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, l, mfaEnabled, guild.getMfaLevel()) || PermissionUtils.canAndIsElevated(8L, l, mfaEnabled, guild.getMfaLevel());
        }

        public static /* synthetic */ boolean access$000(Model model) {
            return model.canManage;
        }

        public static /* synthetic */ List access$100(Model model) {
            return model.roleItems;
        }

        public static /* synthetic */ Channel access$200(Model model) {
            return model.channel;
        }

        public static Observable<Model> get(long j) {
            return StoreStream.getChannels().observeChannel(j).m11099Y(new C1407q(j)).m11108k(C0878n.f565j);
        }

        private static boolean isValid(Guild guild, Channel channel) {
            return (channel == null || guild == null) ? false : true;
        }

        public static /* synthetic */ Model lambda$null$2(Channel channel, Guild guild, MeUser meUser, Long l, List list) {
            if (isValid(guild, channel)) {
                return new Model(meUser, guild, channel, l, list);
            }
            return null;
        }

        public boolean canEqual(Object obj) {
            return obj instanceof Model;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Model)) {
                return false;
            }
            Model model = (Model) obj;
            if (!model.canEqual(this) || this.canManage != model.canManage) {
                return false;
            }
            Channel channel = this.channel;
            Channel channel2 = model.channel;
            if (channel != null ? !channel.equals(channel2) : channel2 != null) {
                return false;
            }
            List<SimpleRolesAdapter.RoleItem> list = this.roleItems;
            List<SimpleRolesAdapter.RoleItem> list2 = model.roleItems;
            return list != null ? list.equals(list2) : list2 == null;
        }

        public int hashCode() {
            int i = this.canManage ? 79 : 97;
            Channel channel = this.channel;
            int iHashCode = ((i + 59) * 59) + (channel == null ? 43 : channel.hashCode());
            List<SimpleRolesAdapter.RoleItem> list = this.roleItems;
            return (iHashCode * 59) + (list != null ? list.hashCode() : 43);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("WidgetChannelSettingsPermissionsAddRole.Model(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", roleItems=");
            sbM833U.append(this.roleItems);
            sbM833U.append(", canManage=");
            return outline.m827O(sbM833U, this.canManage, ")");
        }
    }

    public WidgetChannelSettingsPermissionsAddRole() {
        super(C5419R.layout.widget_channel_settings_permissions_add_role);
    }

    private void configureToolbar(Channel channel) {
        setActionBarTitle(C5419R.string.add_a_role);
        setActionBarSubtitle(ChannelUtils.m7680d(channel, requireContext(), true));
    }

    private void configureUI(Model model) {
        if (model != null && Model.access$000(model) && !Model.access$100(model).isEmpty()) {
            configureToolbar(Model.access$200(model));
            this.rolesAdapter.setData(Model.access$100(model), new C1411u(this, model));
        } else if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }

    public static void create(Context context, long j) {
        Intent intent = new Intent();
        intent.putExtra(INTENT_EXTRA_CHANNEL_ID, j);
        AppScreen2.m156d(context, WidgetChannelSettingsPermissionsAddRole.class, intent);
    }

    /* renamed from: g */
    public static /* synthetic */ void m8627g(WidgetChannelSettingsPermissionsAddRole widgetChannelSettingsPermissionsAddRole, Model model) {
        widgetChannelSettingsPermissionsAddRole.configureUI(model);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(@NonNull View view) {
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled();
        this.rolesRecycler = (RecyclerView) view.findViewById(C5419R.id.channel_settings_permissions_add_role_recycler);
        this.rolesAdapter = (SimpleRolesAdapter) MGRecyclerAdapter.configure(new SimpleRolesAdapter(this.rolesRecycler));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<Model> observable = Model.get(getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, -1L));
        Intrinsics3.checkNotNullParameter(this, "appComponent");
        Intrinsics3.checkNotNullExpressionValue(observable, "it");
        ObservableExtensionsKt.m8519ui(observable, this, null).m11108k(C0879o.m179e(new C1406p(this), getClass()));
    }
}
