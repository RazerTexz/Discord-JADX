package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppFragment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.channels.SimpleMembersAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p073z.p074a.p075a.C1391a;
import p007b.p008a.p073z.p074a.p075a.C1392b;
import p007b.p008a.p073z.p074a.p075a.C1393c;
import p007b.p008a.p073z.p074a.p075a.C1395e;
import p007b.p008a.p073z.p074a.p075a.C1399i;
import p007b.p008a.p073z.p074a.p075a.C1404n;
import p007b.p008a.p073z.p074a.p075a.C1405o;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.Subject;

/* loaded from: classes2.dex */
public class WidgetChannelSettingsPermissionsAddMember extends AppFragment {
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final int VIEW_INDEX_MEMBER_LIST = 0;
    private static final int VIEW_INDEX_NO_RESULTS = 1;

    /* renamed from: j */
    public static final /* synthetic */ int f19372j = 0;
    private SimpleMembersAdapter membersAdapter;
    private RecyclerView membersRecycler;
    private final Subject<String, String> nameFilterPublisher;
    private TextInputLayout searchBox;
    private ViewFlipper viewFlipper;

    public static class Model {
        private final boolean canManage;
        private final Channel channel;
        private final List<SimpleMembersAdapter.MemberItem> memberItems;

        private Model(MeUser meUser, Guild guild, Channel channel, Long l, List<SimpleMembersAdapter.MemberItem> list) {
            this.channel = channel;
            this.memberItems = list;
            boolean mfaEnabled = meUser.getMfaEnabled();
            this.canManage = guild.getOwnerId() == meUser.getId() || PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, l, mfaEnabled, guild.getMfaLevel()) || PermissionUtils.canAndIsElevated(8L, l, mfaEnabled, guild.getMfaLevel());
        }

        public static /* synthetic */ boolean access$000(Model model) {
            return model.canManage;
        }

        public static /* synthetic */ Channel access$100(Model model) {
            return model.channel;
        }

        public static /* synthetic */ List access$200(Model model) {
            return model.memberItems;
        }

        public static Observable<Model> get(long j, long j2, Observable<String> observable) {
            return StoreStream.getChannels().observeChannel(j2).m11099Y(new C1395e(j, j2, observable));
        }

        private static Observable<List<SimpleMembersAdapter.MemberItem>> getMemberItems(long j, @Nullable List<PermissionOverwrite> list, String str) {
            return StoreStream.getGuilds().observeComputed(j).m11099Y(new C1399i(list, str.toLowerCase(Locale.getDefault())));
        }

        private static boolean isValid(MeUser meUser, Guild guild, Channel channel, List<SimpleMembersAdapter.MemberItem> list) {
            return (channel == null || guild == null || meUser == null || list == null) ? false : true;
        }

        public static /* synthetic */ Observable lambda$null$0(long j, Channel channel, String str) {
            return getMemberItems(j, channel.m7655v(), str);
        }

        public static /* synthetic */ Model lambda$null$1(Channel channel, MeUser meUser, Guild guild, Long l, List list) {
            if (isValid(meUser, guild, channel, list)) {
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
            List<SimpleMembersAdapter.MemberItem> list = this.memberItems;
            List<SimpleMembersAdapter.MemberItem> list2 = model.memberItems;
            return list != null ? list.equals(list2) : list2 == null;
        }

        public int hashCode() {
            int i = this.canManage ? 79 : 97;
            Channel channel = this.channel;
            int iHashCode = ((i + 59) * 59) + (channel == null ? 43 : channel.hashCode());
            List<SimpleMembersAdapter.MemberItem> list = this.memberItems;
            return (iHashCode * 59) + (list != null ? list.hashCode() : 43);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("WidgetChannelSettingsPermissionsAddMember.Model(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", memberItems=");
            sbM833U.append(this.memberItems);
            sbM833U.append(", canManage=");
            return outline.m827O(sbM833U, this.canManage, ")");
        }
    }

    public WidgetChannelSettingsPermissionsAddMember() {
        super(C5419R.layout.widget_channel_settings_permissions_add_member);
        this.nameFilterPublisher = BehaviorSubject.m11130l0("");
    }

    private void configureToolbar(Channel channel) {
        setActionBarTitle(C5419R.string.add_a_member);
        setActionBarSubtitle(ChannelUtils.m7680d(channel, requireContext(), true));
    }

    private void configureUI(Model model) {
        if (model == null || !Model.access$000(model)) {
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        } else {
            configureToolbar(Model.access$100(model));
            this.membersAdapter.setData(Model.access$200(model), new C1393c(this, model));
            ViewFlipper viewFlipper = this.viewFlipper;
            if (viewFlipper != null) {
                viewFlipper.setDisplayedChild(Model.access$200(model).isEmpty() ? 1 : 0);
            }
        }
    }

    public static void create(Context context, long j, long j2) {
        Intent intent = new Intent();
        intent.putExtra("INTENT_EXTRA_GUILD_ID", j);
        intent.putExtra(INTENT_EXTRA_CHANNEL_ID, j2);
        AppScreen2.m156d(context, WidgetChannelSettingsPermissionsAddMember.class, intent);
    }

    /* renamed from: g */
    public static /* synthetic */ void m8625g(WidgetChannelSettingsPermissionsAddMember widgetChannelSettingsPermissionsAddMember, Model model) {
        widgetChannelSettingsPermissionsAddMember.configureUI(model);
    }

    /* renamed from: h */
    public /* synthetic */ Unit m8626h(Editable editable) {
        this.nameFilterPublisher.onNext(editable.toString());
        return null;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(@NonNull View view) {
        super.onViewBound(view);
        this.membersRecycler = (RecyclerView) view.findViewById(C5419R.id.channel_settings_permissions_add_member_recycler);
        this.searchBox = (TextInputLayout) view.findViewById(C5419R.id.channel_settings_permissions_add_member_name_search);
        this.viewFlipper = (ViewFlipper) view.findViewById(C5419R.id.channel_settings_permissions_add_member_view_flipper);
        setActionBarDisplayHomeAsUpEnabled();
        this.membersAdapter = (SimpleMembersAdapter) MGRecyclerAdapter.configure(new SimpleMembersAdapter(this.membersRecycler));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        long longExtra2 = getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, -1L);
        ViewExtensions.addBindedTextWatcher(this.searchBox, this, new C1404n(this));
        this.nameFilterPublisher.onNext(ViewExtensions.getTextOrEmpty(this.searchBox));
        this.nameFilterPublisher.m11110p(750L, TimeUnit.MILLISECONDS).m11118y(C1405o.f2104j).m11108k(C0879o.m179e(new C1392b(longExtra), getClass()));
        Observable<Model> observable = Model.get(longExtra, longExtra2, this.nameFilterPublisher);
        Intrinsics3.checkNotNullParameter(this, "appComponent");
        Intrinsics3.checkNotNullExpressionValue(observable, "it");
        ObservableExtensionsKt.m8519ui(observable, this, null).m11108k(C0879o.m179e(new C1391a(this), getClass()));
    }
}
