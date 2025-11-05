package com.discord.widgets.servers.settings.invites;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.User;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsInstantInvitesBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.servers.WidgetServerSettingsInstantInvitesActions;
import d0.g;
import d0.g0.t;
import d0.t.o;
import d0.t.u;
import d0.z.d.k;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsInstantInvites.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvites extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsInstantInvites.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsInstantInvitesBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final int VIEW_INDEX_INVITES_LIST = 1;
    private static final int VIEW_INDEX_INVITES_LOADING = 0;
    private static final int VIEW_INDEX_NO_INVITES = 2;
    private Adapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final LoggingConfig loggingConfig;
    private final StoreInstantInvites storeInstantInvites;

    /* compiled from: WidgetServerSettingsInstantInvites.kt */
    public static final class Adapter extends MGRecyclerAdapterSimple<Model.InviteItem> {
        private Function1<? super ModelInvite, Unit> onInviteExpiredListener;
        private Function1<? super ModelInvite, Unit> onInviteSelectedListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            m.checkNotNullParameter(recyclerView, "recycler");
            this.onInviteSelectedListener = WidgetServerSettingsInstantInvites$Adapter$onInviteSelectedListener$1.INSTANCE;
            this.onInviteExpiredListener = WidgetServerSettingsInstantInvites$Adapter$onInviteExpiredListener$1.INSTANCE;
        }

        public final void configure(List<Model.InviteItem> data, Function1<? super ModelInvite, Unit> onInviteSelectedListener, Function1<? super ModelInvite, Unit> onInviteExpiredListener) {
            m.checkNotNullParameter(data, "data");
            m.checkNotNullParameter(onInviteSelectedListener, "onInviteSelectedListener");
            m.checkNotNullParameter(onInviteExpiredListener, "onInviteExpiredListener");
            this.onInviteSelectedListener = onInviteSelectedListener;
            this.onInviteExpiredListener = onInviteExpiredListener;
            setData(data);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        public final void onInviteExpired(ModelInvite invite) {
            m.checkNotNullParameter(invite, "invite");
            this.onInviteExpiredListener.invoke(invite);
        }

        public final void onInviteSelected(ModelInvite invite) {
            m.checkNotNullParameter(invite, "invite");
            this.onInviteSelectedListener.invoke(invite);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<?, Model.InviteItem> onCreateViewHolder(ViewGroup parent, int viewType) {
            m.checkNotNullParameter(parent, "parent");
            if (viewType == 0) {
                return new WidgetServerSettingsInstantInvitesListItem(this);
            }
            throw invalidViewTypeException(viewType);
        }
    }

    /* compiled from: WidgetServerSettingsInstantInvites.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            m.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("INSTANT_INVITES", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            j.d(context, WidgetServerSettingsInstantInvites.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsInstantInvites.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Guild guild;
        private final List<InviteItem> inviteItems;

        /* compiled from: WidgetServerSettingsInstantInvites.kt */
        public static final class Companion {
            private Companion() {
            }

            public static /* synthetic */ Observable get$default(Companion companion, long j, StoreGuilds storeGuilds, StoreInstantInvites storeInstantInvites, int i, Object obj) {
                if ((i & 2) != 0) {
                    storeGuilds = StoreStream.INSTANCE.getGuilds();
                }
                if ((i & 4) != 0) {
                    storeInstantInvites = StoreStream.INSTANCE.getInstantInvites();
                }
                return companion.get(j, storeGuilds, storeInstantInvites);
            }

            public final Observable<Model> get(long guildId, StoreGuilds storeGuilds, StoreInstantInvites storeInstantInvites) {
                m.checkNotNullParameter(storeGuilds, "storeGuilds");
                m.checkNotNullParameter(storeInstantInvites, "storeInstantInvites");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck.UpdateSource[]{storeGuilds, storeInstantInvites}, false, null, null, new WidgetServerSettingsInstantInvites$Model$Companion$get$1(storeGuilds, guildId, storeInstantInvites), 14, null)).r();
                m.checkNotNullExpressionValue(observableR, "ObservationDeckProvider.…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: WidgetServerSettingsInstantInvites.kt */
        public static final /* data */ class InviteItem implements MGRecyclerDataPayload, Comparable<InviteItem> {

            /* renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            public static final int TYPE_INVITE = 0;
            private final long guildId;
            private final GuildMember guildMember;
            private final ModelInvite invite;
            private final String key;
            private final int type;

            /* compiled from: WidgetServerSettingsInstantInvites.kt */
            public static final class Companion {
                private Companion() {
                }

                public final List<InviteItem> createList(Map<String, ? extends ModelInvite> invites, long guildId, Map<Long, GuildMember> guildMembers) {
                    m.checkNotNullParameter(invites, "invites");
                    m.checkNotNullParameter(guildMembers, "guildMembers");
                    Collection<? extends ModelInvite> collectionValues = invites.values();
                    ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(collectionValues, 10));
                    for (ModelInvite modelInvite : collectionValues) {
                        User inviter = modelInvite.getInviter();
                        arrayList.add(new InviteItem(modelInvite, guildId, inviter != null ? guildMembers.get(Long.valueOf(inviter.getId())) : null));
                    }
                    return u.sorted(arrayList);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public InviteItem(ModelInvite modelInvite, long j, GuildMember guildMember) {
                m.checkNotNullParameter(modelInvite, "invite");
                this.invite = modelInvite;
                this.guildId = j;
                this.guildMember = guildMember;
                String str = modelInvite.code;
                m.checkNotNullExpressionValue(str, "invite.code");
                this.key = str;
            }

            public static /* synthetic */ InviteItem copy$default(InviteItem inviteItem, ModelInvite modelInvite, long j, GuildMember guildMember, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelInvite = inviteItem.invite;
                }
                if ((i & 2) != 0) {
                    j = inviteItem.guildId;
                }
                if ((i & 4) != 0) {
                    guildMember = inviteItem.guildMember;
                }
                return inviteItem.copy(modelInvite, j, guildMember);
            }

            @Override // java.lang.Comparable
            public /* bridge */ /* synthetic */ int compareTo(InviteItem inviteItem) {
                return compareTo2(inviteItem);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelInvite getInvite() {
                return this.invite;
            }

            /* renamed from: component2, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* renamed from: component3, reason: from getter */
            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            public final InviteItem copy(ModelInvite invite, long guildId, GuildMember guildMember) {
                m.checkNotNullParameter(invite, "invite");
                return new InviteItem(invite, guildId, guildMember);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof InviteItem)) {
                    return false;
                }
                InviteItem inviteItem = (InviteItem) other;
                return m.areEqual(this.invite, inviteItem.invite) && this.guildId == inviteItem.guildId && m.areEqual(this.guildMember, inviteItem.guildMember);
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            public final ModelInvite getInvite() {
                return this.invite;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                ModelInvite modelInvite = this.invite;
                int iA = (b.a(this.guildId) + ((modelInvite != null ? modelInvite.hashCode() : 0) * 31)) * 31;
                GuildMember guildMember = this.guildMember;
                return iA + (guildMember != null ? guildMember.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = a.U("InviteItem(invite=");
                sbU.append(this.invite);
                sbU.append(", guildId=");
                sbU.append(this.guildId);
                sbU.append(", guildMember=");
                sbU.append(this.guildMember);
                sbU.append(")");
                return sbU.toString();
            }

            /* renamed from: compareTo, reason: avoid collision after fix types in other method */
            public int compareTo2(InviteItem other) {
                String username;
                String username2;
                m.checkNotNullParameter(other, "other");
                Channel channel = this.invite.getChannel();
                String strC = channel != null ? ChannelUtils.c(channel) : null;
                Channel channel2 = other.invite.getChannel();
                String strC2 = channel2 != null ? ChannelUtils.c(channel2) : null;
                int iCompareTo = (strC == null || strC2 == null) ? 0 : t.compareTo(strC, strC2, true);
                User inviter = this.invite.getInviter();
                User inviter2 = other.invite.getInviter();
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                UserUtils userUtils = UserUtils.INSTANCE;
                if (inviter == null || (username = inviter.getUsername()) == null) {
                    username = "";
                }
                if (inviter2 == null || (username2 = inviter2.getUsername()) == null) {
                    username2 = "";
                }
                return userUtils.compareUserNames(username, username2, null, null, inviter != null ? inviter.getId() : 0L, inviter2 != null ? inviter2.getId() : 0L);
            }
        }

        public Model(Guild guild, List<InviteItem> list) {
            m.checkNotNullParameter(guild, "guild");
            this.guild = guild;
            this.inviteItems = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, Guild guild, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                list = model.inviteItems;
            }
            return model.copy(guild, list);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final List<InviteItem> component2() {
            return this.inviteItems;
        }

        public final Model copy(Guild guild, List<InviteItem> inviteItems) {
            m.checkNotNullParameter(guild, "guild");
            return new Model(guild, inviteItems);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return m.areEqual(this.guild, model.guild) && m.areEqual(this.inviteItems, model.inviteItems);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final List<InviteItem> getInviteItems() {
            return this.inviteItems;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            List<InviteItem> list = this.inviteItems;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(", inviteItems=");
            return a.L(sbU, this.inviteItems, ")");
        }
    }

    /* compiled from: WidgetServerSettingsInstantInvites.kt */
    /* renamed from: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.z.d.o implements Function1<ModelInvite, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            m.checkNotNullParameter(modelInvite, "invite");
            WidgetServerSettingsInstantInvitesActions.Companion companion = WidgetServerSettingsInstantInvitesActions.INSTANCE;
            FragmentManager parentFragmentManager = WidgetServerSettingsInstantInvites.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            String str = modelInvite.code;
            m.checkNotNullExpressionValue(str, "invite.code");
            companion.create(parentFragmentManager, str);
        }
    }

    /* compiled from: WidgetServerSettingsInstantInvites.kt */
    /* renamed from: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends d0.z.d.o implements Function1<ModelInvite, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            m.checkNotNullParameter(modelInvite, "invite");
            StoreStream.INSTANCE.getInstantInvites().onInviteRemoved(modelInvite);
        }
    }

    /* compiled from: WidgetServerSettingsInstantInvites.kt */
    /* renamed from: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsInstantInvites widgetServerSettingsInstantInvites) {
            super(1, widgetServerSettingsInstantInvites, WidgetServerSettingsInstantInvites.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Exception {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Exception {
            WidgetServerSettingsInstantInvites.access$configureUI((WidgetServerSettingsInstantInvites) this.receiver, model);
        }
    }

    public WidgetServerSettingsInstantInvites() {
        super(R.layout.widget_server_settings_instant_invites);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsInstantInvites$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetServerSettingsInstantInvites$guildId$2(this));
        this.storeInstantInvites = StoreStream.INSTANCE.getInstantInvites();
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsInstantInvites$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsInstantInvites widgetServerSettingsInstantInvites, Model model) throws Exception {
        widgetServerSettingsInstantInvites.configureUI(model);
    }

    private final void configureUI(Model data) throws Exception {
        if (data == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        if (data.getInviteItems() == null) {
            AppViewFlipper appViewFlipper = getBinding().c;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsInstantInvitesViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (data.getInviteItems().isEmpty()) {
            AppViewFlipper appViewFlipper2 = getBinding().c;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.serverSettingsInstantInvitesViewFlipper");
            appViewFlipper2.setDisplayedChild(2);
        } else {
            AppViewFlipper appViewFlipper3 = getBinding().c;
            m.checkNotNullExpressionValue(appViewFlipper3, "binding.serverSettingsInstantInvitesViewFlipper");
            appViewFlipper3.setDisplayedChild(1);
            Adapter adapter = this.adapter;
            if (adapter != null) {
                adapter.configure(data.getInviteItems(), new AnonymousClass1(), AnonymousClass2.INSTANCE);
            }
        }
        setActionBarTitle(R.string.instant_invites);
        setActionBarSubtitle(data.getGuild().getName());
    }

    private final WidgetServerSettingsInstantInvitesBinding getBinding() {
        return (WidgetServerSettingsInstantInvitesBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2575b;
        m.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsInstantInvitesRecycler");
        this.adapter = (Adapter) companion.configure(new Adapter(recyclerView));
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.storeInstantInvites.clearInvites(getGuildId());
        this.storeInstantInvites.fetchGuildInvites(getGuildId());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.Companion.get$default(Model.INSTANCE, getGuildId(), null, null, 6, null), this, null, 2, null), WidgetServerSettingsInstantInvites.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
