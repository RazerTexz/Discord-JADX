package com.discord.widgets.search.results;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSearchResultsBinding;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.WidgetUrlActions;
import com.discord.widgets.chat.list.ThreadSpineItemDecoration;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AppScreen2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;

/* JADX INFO: compiled from: WidgetSearchResults.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchResults extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetSearchResults.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSearchResultsBinding;", 0)};
    private WidgetChatListAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetSearchResults.kt */
    public static final /* data */ class Model implements WidgetChatListAdapter.Data {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
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

        /* JADX INFO: compiled from: WidgetSearchResults.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get() {
                Observable observableM11112r = StoreStream.INSTANCE.getSearch().getStoreSearchQuery().getState().m11099Y(WidgetSearchResults2.INSTANCE).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "StoreStream\n            …  .distinctUntilChanged()");
                return ObservableExtensionsKt.computationLatest(observableM11112r);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(List<? extends ChatListEntry> list, long j, Map<Long, String> map, long j2, Set<Long> set) {
            Intrinsics3.checkNotNullParameter(list, "list");
            Intrinsics3.checkNotNullParameter(map, "channelNames");
            Intrinsics3.checkNotNullParameter(set, "myRoleIds");
            this.list = list;
            this.userId = j;
            this.channelNames = map;
            this.oldestMessageId = j2;
            this.myRoleIds = set;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, List list, long j, Map map, long j2, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                list = model.getList();
            }
            if ((i & 2) != 0) {
                j = model.getUserId();
            }
            long j3 = j;
            if ((i & 4) != 0) {
                map = model.getChannelNames();
            }
            Map map2 = map;
            if ((i & 8) != 0) {
                j2 = model.getOldestMessageId();
            }
            long j4 = j2;
            if ((i & 16) != 0) {
                set = model.getMyRoleIds();
            }
            return model.copy(list, j3, map2, j4, set);
        }

        public final List<ChatListEntry> component1() {
            return getList();
        }

        public final long component2() {
            return getUserId();
        }

        public final Map<Long, String> component3() {
            return getChannelNames();
        }

        public final long component4() {
            return getOldestMessageId();
        }

        public final Set<Long> component5() {
            return getMyRoleIds();
        }

        public final Model copy(List<? extends ChatListEntry> list, long userId, Map<Long, String> channelNames, long oldestMessageId, Set<Long> myRoleIds) {
            Intrinsics3.checkNotNullParameter(list, "list");
            Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
            Intrinsics3.checkNotNullParameter(myRoleIds, "myRoleIds");
            return new Model(list, userId, channelNames, oldestMessageId, myRoleIds);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(getList(), model.getList()) && getUserId() == model.getUserId() && Intrinsics3.areEqual(getChannelNames(), model.getChannelNames()) && getOldestMessageId() == model.getOldestMessageId() && Intrinsics3.areEqual(getMyRoleIds(), model.getMyRoleIds());
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
            List<ChatListEntry> list = getList();
            int iM3a = (C0002b.m3a(getUserId()) + ((list != null ? list.hashCode() : 0) * 31)) * 31;
            Map<Long, String> channelNames = getChannelNames();
            int iM3a2 = (C0002b.m3a(getOldestMessageId()) + ((iM3a + (channelNames != null ? channelNames.hashCode() : 0)) * 31)) * 31;
            Set<Long> myRoleIds = getMyRoleIds();
            return iM3a2 + (myRoleIds != null ? myRoleIds.hashCode() : 0);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        /* JADX INFO: renamed from: isSpoilerClickAllowed, reason: from getter */
        public boolean getIsSpoilerClickAllowed() {
            return this.isSpoilerClickAllowed;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(list=");
            sbM833U.append(getList());
            sbM833U.append(", userId=");
            sbM833U.append(getUserId());
            sbM833U.append(", channelNames=");
            sbM833U.append(getChannelNames());
            sbM833U.append(", oldestMessageId=");
            sbM833U.append(getOldestMessageId());
            sbM833U.append(", myRoleIds=");
            sbM833U.append(getMyRoleIds());
            sbM833U.append(")");
            return sbM833U.toString();
        }

        public /* synthetic */ Model(List list, long j, Map map, long j2, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i & 2) != 0 ? 0L : j, map, j2, set);
        }
    }

    /* JADX INFO: compiled from: WidgetSearchResults.kt */
    public static final class SearchResultAdapterEventHandler implements WidgetChatListAdapter.EventHandler {
        private final ChannelSelector channelSelector;
        private final Context context;
        private final FragmentManager fragmentManager;
        private long oldestMessageId;

        public SearchResultAdapterEventHandler(Context context, FragmentManager fragmentManager, ChannelSelector channelSelector) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(channelSelector, "channelSelector");
            this.context = context;
            this.fragmentManager = fragmentManager;
            this.channelSelector = channelSelector;
        }

        private final void jumpToChat(Message message) {
            StoreStream.INSTANCE.getMessagesLoader().jumpToMessage(message.getChannelId(), message.getId());
            AppScreen2.m155c(this.context, false, null, 6);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onBotUiComponentClicked(long applicationId, Long guildId, long channelId, long messageId, Long messageFlags, int componentIndex, RestAPIParams.ComponentInteractionData componentSendData) {
            Intrinsics3.checkNotNullParameter(componentSendData, "componentSendData");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onCallMessageClicked(long voiceChannelId, WidgetChatListAdapterItemCallMessage.CallStatus callStatus) {
            Intrinsics3.checkNotNullParameter(callStatus, "callStatus");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onCommandClicked(long interactionId, Long guildId, long channelId, long messageId, long interactionUserId, long applicationId, String messageNonce) {
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onDismissClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onDismissLocalMessageClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onDismissLocalMessageClicked(this, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onInteractionStateUpdated(StoreChat.InteractionState interactionState) {
            Intrinsics3.checkNotNullParameter(interactionState, "interactionState");
            if (!interactionState.getIsAtTop() || this.oldestMessageId == RecyclerView.FOREVER_NS) {
                return;
            }
            StoreStream.INSTANCE.getSearch().loadMore(this.oldestMessageId);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onListClicked() {
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorAvatarClicked(Message message, long guildId) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorLongClicked(Message message, Long guildId) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageAuthorNameClicked(Message message, long guildId) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageBlockedGroupClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageClicked(Message message, boolean isThreadStarterMessage) {
            Intrinsics3.checkNotNullParameter(message, "message");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onMessageLongClicked(Message message, CharSequence formattedMessage, boolean isThreadStarterMessage) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(formattedMessage, "formattedMessage");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onOldestMessageId(long channelId, long oldestMessageId) {
            this.oldestMessageId = oldestMessageId;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onOpenPinsClicked(Message message) {
            Intrinsics3.checkNotNullParameter(message, "message");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onQuickAddReactionClicked(long guildId, long myUserId, long channelId, long messageId) {
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public boolean onQuickDownloadClicked(Uri uri, String fileName) {
            Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            Intrinsics3.checkNotNullParameter(fileName, "fileName");
            return false;
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReactionClicked(long guildId, long myUserId, long channelId, long messageId, MessageReaction reaction, boolean canAddReactions) {
            Intrinsics3.checkNotNullParameter(reaction, "reaction");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReactionLongClicked(long guildId, long channelId, long messageId, MessageReaction reaction) {
            Intrinsics3.checkNotNullParameter(reaction, "reaction");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onReportIssueWithAutoMod(Context context, Message message) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(message, "message");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onReportIssueWithAutoMod(this, context, message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onRoleSubscriptionPurchaseTierClick(long j, long j2, long j3, long j4, long j5) {
            WidgetChatListAdapter.EventHandler.DefaultImpls.onRoleSubscriptionPurchaseTierClick(this, j, j2, j3, j4, j5);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onSendGreetMessageClicked(long j, int i, Sticker sticker) {
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onSendGreetMessageClicked(this, j, i, sticker);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onShareButtonClick(GuildScheduledEvent guildScheduledEvent, WeakReference<Context> weakReference, WeakReference<AppFragment> weakReference2) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildEvent");
            Intrinsics3.checkNotNullParameter(weakReference, "weakContext");
            Intrinsics3.checkNotNullParameter(weakReference2, "weakFragment");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onShareButtonClick(this, guildScheduledEvent, weakReference, weakReference2);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onStickerClicked(Message message, BaseSticker sticker) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(sticker, "sticker");
            jumpToChat(message);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onSystemMessageCtaClicked(Message message, Channel channel, BaseSticker baseSticker) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            Intrinsics3.checkNotNullParameter(baseSticker, "sticker");
            WidgetChatListAdapter.EventHandler.DefaultImpls.onSystemMessageCtaClicked(this, message, channel, baseSticker);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onThreadClicked(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            ChannelSelector.selectChannel$default(this.channelSelector, channel, null, StoreChannelsSelected3.EMBED, 2, null);
            AppScreen2.m155c(this.context, false, null, 6);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onThreadLongClicked(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUrlLongClicked(String url) {
            Intrinsics3.checkNotNullParameter(url, "url");
            WidgetUrlActions.INSTANCE.launch(this.fragmentManager, url);
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserActivityAction(long authorId, long channelId, long messageId, MessageActivityType actionType, Activity activity, Application application) {
            Intrinsics3.checkNotNullParameter(actionType, "actionType");
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Intrinsics3.checkNotNullParameter(application, "application");
        }

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.EventHandler
        public void onUserMentionClicked(long userId, long channelId, long guildId) {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.results.WidgetSearchResults$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSearchResults.kt */
    public static final /* synthetic */ class C91351 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public C91351(WidgetSearchResults widgetSearchResults) {
            super(1, widgetSearchResults, WidgetSearchResults.class, "configureUI", "configureUI(Lcom/discord/widgets/search/results/WidgetSearchResults$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetSearchResults.access$configureUI((WidgetSearchResults) this.receiver, model);
        }
    }

    public WidgetSearchResults() {
        super(C5419R.layout.widget_search_results);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSearchResults3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSearchResults widgetSearchResults, Model model) {
        widgetSearchResults.configureUI(model);
    }

    private final void addThreadSpineItemDecoration(WidgetChatListAdapter adapter) {
        getBinding().f17425b.addItemDecoration(new ThreadSpineItemDecoration(requireContext(), adapter));
    }

    private final void configureUI(Model model) {
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setData(model);
        }
    }

    private final WidgetSearchResultsBinding getBinding() {
        return (WidgetSearchResultsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f17425b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.searchResultsList");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "view.context");
        FragmentManager parentFragmentManager2 = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
        WidgetChatListAdapter widgetChatListAdapter = (WidgetChatListAdapter) companion.configure(new WidgetChatListAdapter(recyclerView, this, parentFragmentManager, new SearchResultAdapterEventHandler(context, parentFragmentManager2, ChannelSelector.INSTANCE.getInstance()), null, null, 48, null));
        addThreadSpineItemDecoration(widgetChatListAdapter);
        this.adapter = widgetChatListAdapter;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), WidgetSearchResults.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C91351(this), 62, (Object) null);
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setHandlers();
        }
    }
}
