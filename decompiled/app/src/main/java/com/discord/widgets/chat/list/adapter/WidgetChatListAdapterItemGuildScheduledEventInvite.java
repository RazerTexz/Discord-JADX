package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.ViewKt;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.databinding.WidgetChatListAdapterItemGuildScheduledEventInviteBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildScheduledEventInviteEntry;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventItemView;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.Job;
import rx.Observable;
import rx.Subscription;

/* compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildScheduledEventInvite extends WidgetChatListAdapterItemInviteBase {
    private final WidgetChatListAdapterItemGuildScheduledEventInviteBinding binding;
    private final StoreGuildScheduledEvents guildScheduledEventStore;
    private Job inviteJoinJob;
    private Subscription subscription;

    /* compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canConnect;
        private final boolean canShare;
        private final Channel channel;
        private final UserGuildMember creator;
        private final Guild guild;
        private final GuildScheduledEvent guildScheduledEvent;
        private final ModelInvite invite;
        private final boolean isInGuild;
        private final boolean isRsvped;
        private final Long selectedVoiceChannelId;

        /* compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
        public static final class Companion {
            private Companion() {
            }

            public static /* synthetic */ Observable observe$default(Companion companion, GuildScheduledEventInviteEntry guildScheduledEventInviteEntry, StoreGuilds storeGuilds, StoreUser storeUser, StoreChannels storeChannels, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreVoiceChannelSelected storeVoiceChannelSelected, StorePermissions storePermissions, int i, Object obj) {
                return companion.observe(guildScheduledEventInviteEntry, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents, (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 64) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions);
            }

            public final Observable<Model> observe(GuildScheduledEventInviteEntry item, StoreGuilds guildStore, StoreUser userStore, StoreChannels channelStore, StoreGuildScheduledEvents guildScheduledEventStore, StoreVoiceChannelSelected voiceChannelSelectedStore, StorePermissions permissionStore) {
                m.checkNotNullParameter(item, "item");
                m.checkNotNullParameter(guildStore, "guildStore");
                m.checkNotNullParameter(userStore, "userStore");
                m.checkNotNullParameter(channelStore, "channelStore");
                m.checkNotNullParameter(guildScheduledEventStore, "guildScheduledEventStore");
                m.checkNotNullParameter(voiceChannelSelectedStore, "voiceChannelSelectedStore");
                m.checkNotNullParameter(permissionStore, "permissionStore");
                return ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck.UpdateSource[]{guildStore, userStore, guildScheduledEventStore, voiceChannelSelectedStore, permissionStore}, false, null, null, new WidgetChatListAdapterItemGuildScheduledEventInvite$Model$Companion$observe$1(item, guildStore, userStore, guildScheduledEventStore, channelStore, voiceChannelSelectedStore, permissionStore), 14, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(ModelInvite modelInvite, boolean z2, boolean z3, GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember userGuildMember, Long l, boolean z4, boolean z5) {
            m.checkNotNullParameter(modelInvite, "invite");
            m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
            this.invite = modelInvite;
            this.isInGuild = z2;
            this.isRsvped = z3;
            this.guildScheduledEvent = guildScheduledEvent;
            this.channel = channel;
            this.guild = guild;
            this.creator = userGuildMember;
            this.selectedVoiceChannelId = l;
            this.canConnect = z4;
            this.canShare = z5;
        }

        public static /* synthetic */ Model copy$default(Model model, ModelInvite modelInvite, boolean z2, boolean z3, GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember userGuildMember, Long l, boolean z4, boolean z5, int i, Object obj) {
            return model.copy((i & 1) != 0 ? model.invite : modelInvite, (i & 2) != 0 ? model.isInGuild : z2, (i & 4) != 0 ? model.isRsvped : z3, (i & 8) != 0 ? model.guildScheduledEvent : guildScheduledEvent, (i & 16) != 0 ? model.channel : channel, (i & 32) != 0 ? model.guild : guild, (i & 64) != 0 ? model.creator : userGuildMember, (i & 128) != 0 ? model.selectedVoiceChannelId : l, (i & 256) != 0 ? model.canConnect : z4, (i & 512) != 0 ? model.canShare : z5);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelInvite getInvite() {
            return this.invite;
        }

        /* renamed from: component10, reason: from getter */
        public final boolean getCanShare() {
            return this.canShare;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsInGuild() {
            return this.isInGuild;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsRsvped() {
            return this.isRsvped;
        }

        /* renamed from: component4, reason: from getter */
        public final GuildScheduledEvent getGuildScheduledEvent() {
            return this.guildScheduledEvent;
        }

        /* renamed from: component5, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* renamed from: component6, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component7, reason: from getter */
        public final UserGuildMember getCreator() {
            return this.creator;
        }

        /* renamed from: component8, reason: from getter */
        public final Long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        /* renamed from: component9, reason: from getter */
        public final boolean getCanConnect() {
            return this.canConnect;
        }

        public final Model copy(ModelInvite invite, boolean isInGuild, boolean isRsvped, GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember creator, Long selectedVoiceChannelId, boolean canConnect, boolean canShare) {
            m.checkNotNullParameter(invite, "invite");
            m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
            return new Model(invite, isInGuild, isRsvped, guildScheduledEvent, channel, guild, creator, selectedVoiceChannelId, canConnect, canShare);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return m.areEqual(this.invite, model.invite) && this.isInGuild == model.isInGuild && this.isRsvped == model.isRsvped && m.areEqual(this.guildScheduledEvent, model.guildScheduledEvent) && m.areEqual(this.channel, model.channel) && m.areEqual(this.guild, model.guild) && m.areEqual(this.creator, model.creator) && m.areEqual(this.selectedVoiceChannelId, model.selectedVoiceChannelId) && this.canConnect == model.canConnect && this.canShare == model.canShare;
        }

        public final boolean getCanConnect() {
            return this.canConnect;
        }

        public final boolean getCanShare() {
            return this.canShare;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final UserGuildMember getCreator() {
            return this.creator;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final GuildScheduledEvent getGuildScheduledEvent() {
            return this.guildScheduledEvent;
        }

        public final ModelInvite getInvite() {
            return this.invite;
        }

        public final Long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ModelInvite modelInvite = this.invite;
            int iHashCode = (modelInvite != null ? modelInvite.hashCode() : 0) * 31;
            boolean z2 = this.isInGuild;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            boolean z3 = this.isRsvped;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
            int iHashCode2 = (i4 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iHashCode3 = (iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int iHashCode4 = (iHashCode3 + (guild != null ? guild.hashCode() : 0)) * 31;
            UserGuildMember userGuildMember = this.creator;
            int iHashCode5 = (iHashCode4 + (userGuildMember != null ? userGuildMember.hashCode() : 0)) * 31;
            Long l = this.selectedVoiceChannelId;
            int iHashCode6 = (iHashCode5 + (l != null ? l.hashCode() : 0)) * 31;
            boolean z4 = this.canConnect;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (iHashCode6 + i5) * 31;
            boolean z5 = this.canShare;
            return i6 + (z5 ? 1 : z5 ? 1 : 0);
        }

        public final boolean isInGuild() {
            return this.isInGuild;
        }

        public final boolean isRsvped() {
            return this.isRsvped;
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(invite=");
            sbU.append(this.invite);
            sbU.append(", isInGuild=");
            sbU.append(this.isInGuild);
            sbU.append(", isRsvped=");
            sbU.append(this.isRsvped);
            sbU.append(", guildScheduledEvent=");
            sbU.append(this.guildScheduledEvent);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", creator=");
            sbU.append(this.creator);
            sbU.append(", selectedVoiceChannelId=");
            sbU.append(this.selectedVoiceChannelId);
            sbU.append(", canConnect=");
            sbU.append(this.canConnect);
            sbU.append(", canShare=");
            return a.O(sbU, this.canShare, ")");
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass2(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$model.isInGuild()) {
                WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE.showForGuild(WidgetChatListAdapterItemGuildScheduledEventInvite.access$getAdapter$p(WidgetChatListAdapterItemGuildScheduledEventInvite.this).getFragmentManager(), this.$model.getGuildScheduledEvent().getId());
            } else {
                WidgetChatListAdapterItemInviteBase.joinServerOrDM$default(WidgetChatListAdapterItemGuildScheduledEventInvite.this, WidgetChatListAdapterItemGuildScheduledEventInvite.class, this.$model.getInvite(), null, null, 12, null);
            }
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass3(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemGuildScheduledEventInvite.access$getGuildScheduledEventStore$p(WidgetChatListAdapterItemGuildScheduledEventInvite.this).toggleMeRsvpForEvent(this.$model.getGuildScheduledEvent());
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass4(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Job jobAccess$getInviteJoinJob$p = WidgetChatListAdapterItemGuildScheduledEventInvite.access$getInviteJoinJob$p(WidgetChatListAdapterItemGuildScheduledEventInvite.this);
            if (jobAccess$getInviteJoinJob$p == null || !jobAccess$getInviteJoinJob$p.a()) {
                WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite = WidgetChatListAdapterItemGuildScheduledEventInvite.this;
                WidgetChatListAdapterItemGuildScheduledEventInvite.access$setInviteJoinJob$p(widgetChatListAdapterItemGuildScheduledEventInvite, WidgetChatListAdapterItemInviteBase.joinServerOrDM$default(widgetChatListAdapterItemGuildScheduledEventInvite, widgetChatListAdapterItemGuildScheduledEventInvite.getClass(), this.$model.getInvite(), null, null, 12, null));
            }
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass5(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListAdapterItemGuildScheduledEventInvite.access$getAdapter$p(WidgetChatListAdapterItemGuildScheduledEventInvite.this).onShareButtonClick(this.$model.getGuildScheduledEvent(), new WeakReference<>(WidgetChatListAdapterItemGuildScheduledEventInvite.access$getAdapter$p(WidgetChatListAdapterItemGuildScheduledEventInvite.this).getContext()), new WeakReference<>(ViewKt.findFragment(WidgetChatListAdapterItemGuildScheduledEventInvite.access$getAdapter$p(WidgetChatListAdapterItemGuildScheduledEventInvite.this).getRecycler())));
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite$onConfigure$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite) {
            super(1, widgetChatListAdapterItemGuildScheduledEventInvite, WidgetChatListAdapterItemGuildScheduledEventInvite.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemGuildScheduledEventInvite$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Resources.NotFoundException {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Resources.NotFoundException {
            m.checkNotNullParameter(model, "p1");
            WidgetChatListAdapterItemGuildScheduledEventInvite.access$configureUI((WidgetChatListAdapterItemGuildScheduledEventInvite) this.receiver, model);
        }
    }

    /* compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildScheduledEventInvite$onConfigure$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            m.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemGuildScheduledEventInvite.access$setSubscription$p(WidgetChatListAdapterItemGuildScheduledEventInvite.this, subscription);
        }
    }

    public /* synthetic */ WidgetChatListAdapterItemGuildScheduledEventInvite(WidgetChatListAdapter widgetChatListAdapter, StoreGuildScheduledEvents storeGuildScheduledEvents, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(widgetChatListAdapter, (i & 2) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite, Model model) throws Resources.NotFoundException {
        widgetChatListAdapterItemGuildScheduledEventInvite.configureUI(model);
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemGuildScheduledEventInvite.adapter;
    }

    public static final /* synthetic */ StoreGuildScheduledEvents access$getGuildScheduledEventStore$p(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite) {
        return widgetChatListAdapterItemGuildScheduledEventInvite.guildScheduledEventStore;
    }

    public static final /* synthetic */ Job access$getInviteJoinJob$p(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite) {
        return widgetChatListAdapterItemGuildScheduledEventInvite.inviteJoinJob;
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite) {
        return widgetChatListAdapterItemGuildScheduledEventInvite.subscription;
    }

    public static final /* synthetic */ void access$setInviteJoinJob$p(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite, Job job) {
        widgetChatListAdapterItemGuildScheduledEventInvite.inviteJoinJob = job;
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite, Subscription subscription) {
        widgetChatListAdapterItemGuildScheduledEventInvite.subscription = subscription;
    }

    private final void configureUI(Model model) throws Resources.NotFoundException {
        GuildScheduledEventItemView guildScheduledEventItemView = this.binding.f2322b;
        m.checkNotNullExpressionValue(guildScheduledEventItemView, "binding.guildScheduledEventInviteContainer");
        guildScheduledEventItemView.setBackground(null);
        GuildScheduledEventItemView guildScheduledEventItemView2 = this.binding.f2322b;
        GuildScheduledEvent guildScheduledEvent = model.getGuildScheduledEvent();
        Channel channel = model.getChannel();
        Guild guild = model.getGuild();
        UserGuildMember creator = model.getCreator();
        boolean zIsInGuild = model.isInGuild();
        boolean zIsRsvped = model.isRsvped();
        Long channelId = model.getGuildScheduledEvent().getChannelId();
        boolean z2 = false;
        if (channelId != null) {
            long jLongValue = channelId.longValue();
            Long selectedVoiceChannelId = model.getSelectedVoiceChannelId();
            if (selectedVoiceChannelId != null && jLongValue == selectedVoiceChannelId.longValue()) {
                z2 = true;
            }
        }
        guildScheduledEventItemView2.configureInChatList(guildScheduledEvent, channel, guild, creator, zIsInGuild, zIsRsvped, z2, model.getCanConnect(), new AnonymousClass2(model), new AnonymousClass3(model), new AnonymousClass4(model), new AnonymousClass5(model));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildScheduledEventInvite(WidgetChatListAdapter widgetChatListAdapter, StoreGuildScheduledEvents storeGuildScheduledEvents) {
        super(R.layout.widget_chat_list_adapter_item_guild_scheduled_event_invite, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        m.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventStore");
        this.guildScheduledEventStore = storeGuildScheduledEvents;
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        GuildScheduledEventItemView guildScheduledEventItemView = (GuildScheduledEventItemView) view;
        WidgetChatListAdapterItemGuildScheduledEventInviteBinding widgetChatListAdapterItemGuildScheduledEventInviteBinding = new WidgetChatListAdapterItemGuildScheduledEventInviteBinding(guildScheduledEventItemView, guildScheduledEventItemView);
        m.checkNotNullExpressionValue(widgetChatListAdapterItemGuildScheduledEventInviteBinding, "WidgetChatListAdapterIte…iteBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemGuildScheduledEventInviteBinding;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(Model.Companion.observe$default(Model.INSTANCE, (GuildScheduledEventInviteEntry) data, null, null, null, null, null, null, 126, null)), WidgetChatListAdapterItemGuildScheduledEventInvite.class, (Context) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 58, (Object) null);
    }
}
