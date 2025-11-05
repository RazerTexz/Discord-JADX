package com.discord.widgets.chat.pins;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelPinnedMessagesBinding;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.WidgetUrlActions;
import com.discord.widgets.chat.list.ThreadSpineItemDecoration;
import com.discord.widgets.chat.list.actions.WidgetChatListActions;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.m;
import d0.z.d.o;
import j0.l.e.k;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetChannelPinnedMessages.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelPinnedMessages extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelPinnedMessages.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelPinnedMessagesBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private WidgetChatListAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetChannelPinnedMessages.kt */
    public static final class ChannelPinnedMessagesAdapterEventHandler implements WidgetChatListAdapter.EventHandler {
        private final ChannelSelector channelSelector;
        private final Context context;
        private final FragmentManager fragmentManager;

        public ChannelPinnedMessagesAdapterEventHandler(Context context, FragmentManager fragmentManager, ChannelSelector channelSelector) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            m.checkNotNullParameter(channelSelector, "channelSelector");
            this.context = context;
            this.fragmentManager = fragmentManager;
            this.channelSelector = channelSelector;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onBotUiComponentClicked(long j, Long l, long j2, long j3, Long l2, int i, RestAPIParams.ComponentInteractionData componentInteractionData) {
            m.checkNotNullParameter(componentInteractionData, "componentSendData");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onBotUiComponentClicked(this, j, l, j2, j3, l2, i, componentInteractionData);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onCallMessageClicked(long j, WidgetChatListAdapterItemCallMessage.CallStatus callStatus) {
            m.checkNotNullParameter(callStatus, "callStatus");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onCallMessageClicked(this, j, callStatus);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onCommandClicked(long j, Long l, long j2, long j3, long j4, long j5, String str) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onCommandClicked(this, j, l, j2, j3, j4, j5, str);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onDismissClicked(Message message) {
            m.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onDismissClicked(this, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onDismissLocalMessageClicked(Message message) {
            m.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onDismissLocalMessageClicked(this, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onInteractionStateUpdated(StoreChat.InteractionState interactionState) {
            m.checkNotNullParameter(interactionState, "interactionState");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onInteractionStateUpdated(this, interactionState);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onListClicked() {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onListClicked(this);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorAvatarClicked(Message message, long j) {
            m.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onMessageAuthorAvatarClicked(this, message, j);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorLongClicked(Message message, Long l) {
            m.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onMessageAuthorLongClicked(this, message, l);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorNameClicked(Message message, long j) {
            m.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onMessageAuthorNameClicked(this, message, j);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageBlockedGroupClicked(Message message) {
            m.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onMessageBlockedGroupClicked(this, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageClicked(Message message, boolean isThreadStarterMessage) {
            m.checkNotNullParameter(message, "message");
            StoreStream.INSTANCE.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
            j.c(this.context, false, null, 6);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageLongClicked(Message message, CharSequence formattedMessage, boolean isThreadStarterMessage) {
            m.checkNotNullParameter(message, "message");
            m.checkNotNullParameter(formattedMessage, "formattedMessage");
            WidgetChatListActions.INSTANCE.showForPin(this.fragmentManager, message.getChannelId(), message.getId(), formattedMessage);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onOldestMessageId(long j, long j2) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onOldestMessageId(this, j, j2);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onOpenPinsClicked(Message message) {
            m.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onOpenPinsClicked(this, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onQuickAddReactionClicked(long j, long j2, long j3, long j4) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onQuickAddReactionClicked(this, j, j2, j3, j4);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public boolean onQuickDownloadClicked(Uri uri, String str) {
            m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            m.checkNotNullParameter(str, "fileName");
            return WidgetChatListAdapter.EventHandler.DefaultImpls.onQuickDownloadClicked(this, uri, str);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReactionClicked(long j, long j2, long j3, long j4, MessageReaction messageReaction, boolean z2) {
            m.checkNotNullParameter(messageReaction, "reaction");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onReactionClicked(this, j, j2, j3, j4, messageReaction, z2);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReactionLongClicked(long j, long j2, long j3, MessageReaction messageReaction) {
            m.checkNotNullParameter(messageReaction, "reaction");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onReactionLongClicked(this, j, j2, j3, messageReaction);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReportIssueWithAutoMod(Context context, Message message) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onReportIssueWithAutoMod(this, context, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onRoleSubscriptionPurchaseTierClick(long j, long j2, long j3, long j4, long j5) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onRoleSubscriptionPurchaseTierClick(this, j, j2, j3, j4, j5);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onSendGreetMessageClicked(long j, int i, Sticker sticker) {
            m.checkNotNullParameter(sticker, "sticker");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onSendGreetMessageClicked(this, j, i, sticker);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onShareButtonClick(GuildScheduledEvent guildScheduledEvent, WeakReference<Context> weakReference, WeakReference<AppFragment> weakReference2) {
            m.checkNotNullParameter(guildScheduledEvent, "guildEvent");
            m.checkNotNullParameter(weakReference, "weakContext");
            m.checkNotNullParameter(weakReference2, "weakFragment");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onShareButtonClick(this, guildScheduledEvent, weakReference, weakReference2);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onStickerClicked(Message message, BaseSticker sticker) {
            m.checkNotNullParameter(message, "message");
            m.checkNotNullParameter(sticker, "sticker");
            StoreStream.INSTANCE.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onSystemMessageCtaClicked(Message message, Channel channel, BaseSticker baseSticker) {
            m.checkNotNullParameter(message, "message");
            m.checkNotNullParameter(channel, "channel");
            m.checkNotNullParameter(baseSticker, "sticker");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onSystemMessageCtaClicked(this, message, channel, baseSticker);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onThreadClicked(Channel channel) {
            m.checkNotNullParameter(channel, "channel");
            ChannelSelector.selectChannel$default(this.channelSelector, channel, null, SelectedChannelAnalyticsLocation.EMBED, 2, null);
            j.c(this.context, false, null, 6);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onThreadLongClicked(Channel channel) {
            m.checkNotNullParameter(channel, "channel");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onThreadLongClicked(this, channel);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUrlLongClicked(String url) {
            m.checkNotNullParameter(url, "url");
            WidgetUrlActions.INSTANCE.launch(this.fragmentManager, url);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserActivityAction(long j, long j2, long j3, MessageActivityType messageActivityType, Activity activity, Application application) {
            m.checkNotNullParameter(messageActivityType, "messageActivityType");
            m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            m.checkNotNullParameter(application, "application");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onUserActivityAction(this, j, j2, j3, messageActivityType, activity, application);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserMentionClicked(long j, long j2, long j3) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onUserMentionClicked(this, j, j2, j3);
        }
    }

    /* compiled from: WidgetChannelPinnedMessages.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, long channelId) {
            m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra(WidgetChannelPinnedMessages.INTENT_EXTRA_CHANNEL_ID, channelId);
            j.d(context, WidgetChannelPinnedMessages.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelPinnedMessages.kt */
    public static final /* data */ class Model implements WidgetChatListAdapter.Data {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Channel channel;
        private final long channelId;
        private final Map<Long, String> channelNames;
        private final Guild guild;
        private final long guildId;
        private final boolean isSpoilerClickAllowed;
        private final List<ChatListEntry> list;
        private final Set<Long> myRoleIds;
        private final long newMessagesMarkerMessageId;
        private final long oldestMessageId;
        private final long userId;

        /* compiled from: WidgetChannelPinnedMessages.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(Context context, long channelId) {
                m.checkNotNullParameter(context, "context");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Channel channelFindChannelById = companion.getChannels().findChannelById(channelId);
                if (channelFindChannelById != null) {
                    Observable observableY = companion.getPinnedMessages().observeForChannel(channelId).Y(new WidgetChannelPinnedMessages$Model$Companion$get$1(channelFindChannelById, context));
                    m.checkNotNullExpressionValue(observableY, "getPinnedMessages().obse…              }\n        }");
                    return observableY;
                }
                k kVar = new k(null);
                m.checkNotNullExpressionValue(kVar, "Observable.just(null)");
                return kVar;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(Channel channel, Guild guild, long j, Map<Long, String> map, List<? extends ChatListEntry> list, Set<Long> set, long j2, long j3, long j4, long j5, boolean z2) {
            m.checkNotNullParameter(channel, "channel");
            m.checkNotNullParameter(map, "channelNames");
            m.checkNotNullParameter(list, "list");
            m.checkNotNullParameter(set, "myRoleIds");
            this.channel = channel;
            this.guild = guild;
            this.userId = j;
            this.channelNames = map;
            this.list = list;
            this.myRoleIds = set;
            this.channelId = j2;
            this.guildId = j3;
            this.oldestMessageId = j4;
            this.newMessagesMarkerMessageId = j5;
            this.isSpoilerClickAllowed = z2;
        }

        public static /* synthetic */ Model copy$default(Model model, Channel channel, Guild guild, long j, Map map, List list, Set set, long j2, long j3, long j4, long j5, boolean z2, int i, Object obj) {
            return model.copy((i & 1) != 0 ? model.channel : channel, (i & 2) != 0 ? model.getGuild() : guild, (i & 4) != 0 ? model.getUserId() : j, (i & 8) != 0 ? model.getChannelNames() : map, (i & 16) != 0 ? model.getList() : list, (i & 32) != 0 ? model.getMyRoleIds() : set, (i & 64) != 0 ? model.getChannelId() : j2, (i & 128) != 0 ? model.getGuildId() : j3, (i & 256) != 0 ? model.getOldestMessageId() : j4, (i & 512) != 0 ? model.getNewMessagesMarkerMessageId() : j5, (i & 1024) != 0 ? model.getIsSpoilerClickAllowed() : z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final long component10() {
            return getNewMessagesMarkerMessageId();
        }

        public final boolean component11() {
            return getIsSpoilerClickAllowed();
        }

        public final Guild component2() {
            return getGuild();
        }

        public final long component3() {
            return getUserId();
        }

        public final Map<Long, String> component4() {
            return getChannelNames();
        }

        public final List<ChatListEntry> component5() {
            return getList();
        }

        public final Set<Long> component6() {
            return getMyRoleIds();
        }

        public final long component7() {
            return getChannelId();
        }

        public final long component8() {
            return getGuildId();
        }

        public final long component9() {
            return getOldestMessageId();
        }

        public final Model copy(Channel channel, Guild guild, long userId, Map<Long, String> channelNames, List<? extends ChatListEntry> list, Set<Long> myRoleIds, long channelId, long guildId, long oldestMessageId, long newMessagesMarkerMessageId, boolean isSpoilerClickAllowed) {
            m.checkNotNullParameter(channel, "channel");
            m.checkNotNullParameter(channelNames, "channelNames");
            m.checkNotNullParameter(list, "list");
            m.checkNotNullParameter(myRoleIds, "myRoleIds");
            return new Model(channel, guild, userId, channelNames, list, myRoleIds, channelId, guildId, oldestMessageId, newMessagesMarkerMessageId, isSpoilerClickAllowed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return m.areEqual(this.channel, model.channel) && m.areEqual(getGuild(), model.getGuild()) && getUserId() == model.getUserId() && m.areEqual(getChannelNames(), model.getChannelNames()) && m.areEqual(getList(), model.getList()) && m.areEqual(getMyRoleIds(), model.getMyRoleIds()) && getChannelId() == model.getChannelId() && getGuildId() == model.getGuildId() && getOldestMessageId() == model.getOldestMessageId() && getNewMessagesMarkerMessageId() == model.getNewMessagesMarkerMessageId() && getIsSpoilerClickAllowed() == model.getIsSpoilerClickAllowed();
        }

        public final Channel getChannel() {
            return this.channel;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getChannelId() {
            return this.channelId;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public Map<Long, String> getChannelNames() {
            return this.channelNames;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public Guild getGuild() {
            return this.guild;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getGuildId() {
            return this.guildId;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public List<ChatListEntry> getList() {
            return this.list;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public Set<Long> getMyRoleIds() {
            return this.myRoleIds;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getNewMessagesMarkerMessageId() {
            return this.newMessagesMarkerMessageId;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getOldestMessageId() {
            return this.oldestMessageId;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        public long getUserId() {
            return this.userId;
        }

        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Guild guild = getGuild();
            int iA = (b.a(getUserId()) + ((iHashCode + (guild != null ? guild.hashCode() : 0)) * 31)) * 31;
            Map<Long, String> channelNames = getChannelNames();
            int iHashCode2 = (iA + (channelNames != null ? channelNames.hashCode() : 0)) * 31;
            List<ChatListEntry> list = getList();
            int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            Set<Long> myRoleIds = getMyRoleIds();
            int iA2 = (b.a(getNewMessagesMarkerMessageId()) + ((b.a(getOldestMessageId()) + ((b.a(getGuildId()) + ((b.a(getChannelId()) + ((iHashCode3 + (myRoleIds != null ? myRoleIds.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31;
            boolean isSpoilerClickAllowed = getIsSpoilerClickAllowed();
            int i = isSpoilerClickAllowed;
            if (isSpoilerClickAllowed) {
                i = 1;
            }
            return iA2 + i;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        /* renamed from: isSpoilerClickAllowed, reason: from getter */
        public boolean getIsSpoilerClickAllowed() {
            return this.isSpoilerClickAllowed;
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(getGuild());
            sbU.append(", userId=");
            sbU.append(getUserId());
            sbU.append(", channelNames=");
            sbU.append(getChannelNames());
            sbU.append(", list=");
            sbU.append(getList());
            sbU.append(", myRoleIds=");
            sbU.append(getMyRoleIds());
            sbU.append(", channelId=");
            sbU.append(getChannelId());
            sbU.append(", guildId=");
            sbU.append(getGuildId());
            sbU.append(", oldestMessageId=");
            sbU.append(getOldestMessageId());
            sbU.append(", newMessagesMarkerMessageId=");
            sbU.append(getNewMessagesMarkerMessageId());
            sbU.append(", isSpoilerClickAllowed=");
            sbU.append(getIsSpoilerClickAllowed());
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ Model(Channel channel, Guild guild, long j, Map map, List list, Set set, long j2, long j3, long j4, long j5, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(channel, guild, j, map, list, set, (i & 64) != 0 ? channel.getId() : j2, (i & 128) != 0 ? channel.getGuildId() : j3, (i & 256) != 0 ? 0L : j4, (i & 512) != 0 ? 0L : j5, (i & 1024) != 0 ? false : z2);
        }
    }

    /* compiled from: WidgetChannelPinnedMessages.kt */
    /* renamed from: com.discord.widgets.chat.pins.WidgetChannelPinnedMessages$onViewBoundOrOnResume$1, reason: invalid class name */
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
            WidgetChannelPinnedMessages.access$configureUI(WidgetChannelPinnedMessages.this, model);
        }
    }

    public WidgetChannelPinnedMessages() {
        super(R.layout.widget_channel_pinned_messages);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelPinnedMessages$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelPinnedMessages widgetChannelPinnedMessages, Model model) {
        widgetChannelPinnedMessages.configureUI(model);
    }

    private final void addThreadSpineItemDecoration(WidgetChatListAdapter adapter) {
        getBinding().f2265b.addItemDecoration(new ThreadSpineItemDecoration(requireContext(), adapter));
    }

    private final void configureUI(Model model) {
        if (model == null) {
            requireActivity().finish();
            return;
        }
        setActionBarSubtitle(ChannelUtils.e(model.getChannel(), requireContext(), false, 2));
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setData(model);
        }
    }

    private final WidgetChannelPinnedMessagesBinding getBinding() {
        return (WidgetChannelPinnedMessagesBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.dispose();
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.disposeHandlers();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.pinned_messages);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2265b;
        m.checkNotNullExpressionValue(recyclerView, "binding.channelPinnedMessagesRecycler");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        FragmentManager parentFragmentManager2 = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
        WidgetChatListAdapter widgetChatListAdapter = (WidgetChatListAdapter) companion.configure(new WidgetChatListAdapter(recyclerView, this, parentFragmentManager, new ChannelPinnedMessagesAdapterEventHandler(contextRequireContext, parentFragmentManager2, ChannelSelector.INSTANCE.getInstance()), null, null, 48, null));
        addThreadSpineItemDecoration(widgetChatListAdapter);
        this.adapter = widgetChatListAdapter;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<Model> observableR = Model.INSTANCE.get(requireContext(), getMostRecentIntent().getLongExtra(INTENT_EXTRA_CHANNEL_ID, 0L)).r();
        m.checkNotNullExpressionValue(observableR, "Model\n        .get(requi…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetChannelPinnedMessages.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setHandlers();
        }
    }
}
