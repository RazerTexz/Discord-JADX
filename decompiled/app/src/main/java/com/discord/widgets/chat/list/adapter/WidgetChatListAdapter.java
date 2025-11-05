package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.message.activity.MessageActivityType;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppFragment;
import com.discord.app.AppPermissionsRequests;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.discord.widgets.botuikit.ComponentProvider;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.list.FragmentLifecycleListener;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemCallMessage;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import com.discord.widgets.chat.list.entries.NewMessagesEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModel;
import com.discord.widgets.guild_automod.WidgetReportIssueWithAutoMod;
import d0.l;
import d0.t.h0;
import d0.t.n;
import d0.t.n0;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import d0.z.d.o;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import rx.functions.Action0;

/* compiled from: WidgetChatListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapter extends MGRecyclerAdapterSimple<ChatListEntry> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int NEW_MESSAGES_MAX_SCROLLBACK_COUNT = 30;
    private static final int NEW_MESSAGES_MIN_SCROLLBACK_COUNT = 10;
    private final AppPermissionsRequests appPermissionsRequests;
    private final ComponentProvider botUiComponentProvider;
    private final Clock clock;
    private Data data;
    private final EventHandler eventHandler;
    private final AppFlexInputViewModel flexInputViewModel;
    private FragmentManager fragmentManager;
    private final HandlerOfScrolls handlerOfScrolls;
    private final HandlerOfTouches handlerOfTouches;
    private final HandlerOfUpdates handlerOfUpdates;
    private boolean isTouchedSinceLastJump;
    private Job lastUpdateJob;
    private boolean mentionMeMessageLevelHighlighting;
    private ScrollToWithHighlight scrollToWithHighlight;

    /* compiled from: WidgetChatListAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ int access$findBestNewMessagesPosition(Companion companion, int i) {
            return companion.findBestNewMessagesPosition(i);
        }

        private final int findBestNewMessagesPosition(int numKnownMessages) {
            if (-1 <= numKnownMessages && 10 > numKnownMessages) {
                return -1;
            }
            if (10 <= numKnownMessages && 30 > numKnownMessages) {
                return numKnownMessages;
            }
            return 30;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChatListAdapter.kt */
    public interface Data {
        long getChannelId();

        Map<Long, String> getChannelNames();

        Guild getGuild();

        long getGuildId();

        List<ChatListEntry> getList();

        Set<Long> getMyRoleIds();

        long getNewMessagesMarkerMessageId();

        long getOldestMessageId();

        long getUserId();

        /* renamed from: isSpoilerClickAllowed */
        boolean getIsSpoilerClickAllowed();
    }

    /* compiled from: WidgetChatListAdapter.kt */
    public static final class EmptyData implements Data {
        private final long channelId;
        private final Guild guild;
        private final long guildId;
        private final boolean isSpoilerClickAllowed;
        private final long newMessagesMarkerMessageId;
        private final long oldestMessageId;
        private final long userId;
        private final Map<Long, String> channelNames = h0.emptyMap();
        private final List<ChatListEntry> list = n.emptyList();
        private final Set<Long> myRoleIds = n0.emptySet();

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

        @Override // com.discord.widgets.chat.list.adapter.WidgetChatListAdapter.Data
        /* renamed from: isSpoilerClickAllowed, reason: from getter */
        public boolean getIsSpoilerClickAllowed() {
            return this.isSpoilerClickAllowed;
        }
    }

    /* compiled from: WidgetChatListAdapter.kt */
    public interface EventHandler {

        /* compiled from: WidgetChatListAdapter.kt */
        public static final class DefaultImpls {
            public static void onBotUiComponentClicked(EventHandler eventHandler, long j, Long l, long j2, long j3, Long l2, int i, RestAPIParams.ComponentInteractionData componentInteractionData) {
                m.checkNotNullParameter(componentInteractionData, "componentSendData");
            }

            public static void onCallMessageClicked(EventHandler eventHandler, long j, WidgetChatListAdapterItemCallMessage.CallStatus callStatus) {
                m.checkNotNullParameter(callStatus, "callStatus");
            }

            public static void onCommandClicked(EventHandler eventHandler, long j, Long l, long j2, long j3, long j4, long j5, String str) {
            }

            public static void onDismissClicked(EventHandler eventHandler, Message message) {
                m.checkNotNullParameter(message, "message");
            }

            public static void onDismissLocalMessageClicked(EventHandler eventHandler, Message message) {
                m.checkNotNullParameter(message, "message");
            }

            public static void onInteractionStateUpdated(EventHandler eventHandler, StoreChat.InteractionState interactionState) {
                m.checkNotNullParameter(interactionState, "interactionState");
            }

            public static void onListClicked(EventHandler eventHandler) {
            }

            public static void onMessageAuthorAvatarClicked(EventHandler eventHandler, Message message, long j) {
                m.checkNotNullParameter(message, "message");
            }

            public static void onMessageAuthorLongClicked(EventHandler eventHandler, Message message, Long l) {
                m.checkNotNullParameter(message, "message");
            }

            public static void onMessageAuthorNameClicked(EventHandler eventHandler, Message message, long j) {
                m.checkNotNullParameter(message, "message");
            }

            public static void onMessageBlockedGroupClicked(EventHandler eventHandler, Message message) {
                m.checkNotNullParameter(message, "message");
            }

            public static void onMessageClicked(EventHandler eventHandler, Message message, boolean z2) {
                m.checkNotNullParameter(message, "message");
            }

            public static void onMessageLongClicked(EventHandler eventHandler, Message message, CharSequence charSequence, boolean z2) {
                m.checkNotNullParameter(message, "message");
                m.checkNotNullParameter(charSequence, "formattedMessage");
            }

            public static void onOldestMessageId(EventHandler eventHandler, long j, long j2) {
            }

            public static void onOpenPinsClicked(EventHandler eventHandler, Message message) {
                m.checkNotNullParameter(message, "message");
            }

            public static void onQuickAddReactionClicked(EventHandler eventHandler, long j, long j2, long j3, long j4) {
            }

            public static boolean onQuickDownloadClicked(EventHandler eventHandler, Uri uri, String str) {
                m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
                m.checkNotNullParameter(str, "fileName");
                return false;
            }

            public static void onReactionClicked(EventHandler eventHandler, long j, long j2, long j3, long j4, MessageReaction messageReaction, boolean z2) {
                m.checkNotNullParameter(messageReaction, "reaction");
            }

            public static void onReactionLongClicked(EventHandler eventHandler, long j, long j2, long j3, MessageReaction messageReaction) {
                m.checkNotNullParameter(messageReaction, "reaction");
            }

            public static void onReportIssueWithAutoMod(EventHandler eventHandler, Context context, Message message) {
                m.checkNotNullParameter(context, "context");
                m.checkNotNullParameter(message, "message");
                WidgetReportIssueWithAutoMod.INSTANCE.launch(context, message.getChannelId(), message.getId());
            }

            public static void onRoleSubscriptionPurchaseTierClick(EventHandler eventHandler, long j, long j2, long j3, long j4, long j5) {
            }

            public static void onSendGreetMessageClicked(EventHandler eventHandler, long j, int i, Sticker sticker) {
                m.checkNotNullParameter(sticker, "sticker");
            }

            public static void onShareButtonClick(EventHandler eventHandler, GuildScheduledEvent guildScheduledEvent, WeakReference<Context> weakReference, WeakReference<AppFragment> weakReference2) {
                m.checkNotNullParameter(guildScheduledEvent, "guildEvent");
                m.checkNotNullParameter(weakReference, "weakContext");
                m.checkNotNullParameter(weakReference2, "weakFragment");
            }

            public static void onStickerClicked(EventHandler eventHandler, Message message, BaseSticker baseSticker) {
                m.checkNotNullParameter(message, "message");
                m.checkNotNullParameter(baseSticker, "sticker");
            }

            public static void onSystemMessageCtaClicked(EventHandler eventHandler, Message message, Channel channel, BaseSticker baseSticker) {
                m.checkNotNullParameter(message, "message");
                m.checkNotNullParameter(channel, "channel");
                m.checkNotNullParameter(baseSticker, "sticker");
            }

            public static void onThreadClicked(EventHandler eventHandler, Channel channel) {
                m.checkNotNullParameter(channel, "channel");
            }

            public static void onThreadLongClicked(EventHandler eventHandler, Channel channel) {
                m.checkNotNullParameter(channel, "channel");
            }

            public static void onUrlLongClicked(EventHandler eventHandler, String str) {
                m.checkNotNullParameter(str, "url");
            }

            public static void onUserActivityAction(EventHandler eventHandler, long j, long j2, long j3, MessageActivityType messageActivityType, Activity activity, Application application) {
                m.checkNotNullParameter(messageActivityType, "messageActivityType");
                m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
                m.checkNotNullParameter(application, "application");
            }

            public static void onUserMentionClicked(EventHandler eventHandler, long j, long j2, long j3) {
            }
        }

        void onBotUiComponentClicked(long applicationId, Long guildId, long channelId, long messageId, Long messageFlags, int componentIndex, RestAPIParams.ComponentInteractionData componentSendData);

        void onCallMessageClicked(long voiceChannelId, WidgetChatListAdapterItemCallMessage.CallStatus callStatus);

        void onCommandClicked(long interactionId, Long guildId, long channelId, long messageId, long interactionUserId, long applicationId, String messageNonce);

        void onDismissClicked(Message message);

        void onDismissLocalMessageClicked(Message message);

        void onInteractionStateUpdated(StoreChat.InteractionState interactionState);

        void onListClicked();

        void onMessageAuthorAvatarClicked(Message message, long guildId);

        void onMessageAuthorLongClicked(Message message, Long guildId);

        void onMessageAuthorNameClicked(Message message, long guildId);

        void onMessageBlockedGroupClicked(Message message);

        void onMessageClicked(Message message, boolean isThreadStarterMessage);

        void onMessageLongClicked(Message message, CharSequence formattedMessage, boolean isThreadStarterMessage);

        void onOldestMessageId(long channelId, long oldestMessageId);

        void onOpenPinsClicked(Message message);

        void onQuickAddReactionClicked(long guildId, long myUserId, long channelId, long messageId);

        boolean onQuickDownloadClicked(Uri uri, String fileName);

        void onReactionClicked(long guildId, long myUserId, long channelId, long messageId, MessageReaction reaction, boolean canAddReactions);

        void onReactionLongClicked(long guildId, long channelId, long messageId, MessageReaction reaction);

        void onReportIssueWithAutoMod(Context context, Message message);

        void onRoleSubscriptionPurchaseTierClick(long roleSubscriptionListingId, long guildId, long userId, long channelId, long messageId);

        void onSendGreetMessageClicked(long channelId, int channelType, Sticker sticker);

        void onShareButtonClick(GuildScheduledEvent guildEvent, WeakReference<Context> weakContext, WeakReference<AppFragment> weakFragment);

        void onStickerClicked(Message message, BaseSticker sticker);

        void onSystemMessageCtaClicked(Message message, Channel channel, BaseSticker sticker);

        void onThreadClicked(Channel channel);

        void onThreadLongClicked(Channel channel);

        void onUrlLongClicked(String url);

        void onUserActivityAction(long authorId, long channelId, long messageId, MessageActivityType messageActivityType, Activity activity, Application application);

        void onUserMentionClicked(long userId, long channelId, long guildId);
    }

    /* compiled from: WidgetChatListAdapter.kt */
    public final class HandlerOfScrolls extends RecyclerView.OnScrollListener {
        private long channelId;
        private int scrollState;

        public HandlerOfScrolls() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {
            m.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, scrollState);
            if (this.scrollState == scrollState && WidgetChatListAdapter.this.getData().getChannelId() == this.channelId) {
                return;
            }
            this.scrollState = scrollState;
            this.channelId = WidgetChatListAdapter.this.getData().getChannelId();
            WidgetChatListAdapter.access$publishInteractionState(WidgetChatListAdapter.this);
        }
    }

    /* compiled from: WidgetChatListAdapter.kt */
    public final class HandlerOfTouches implements View.OnTouchListener {
        private final GestureDetector tapGestureDetector;

        public HandlerOfTouches() {
            this.tapGestureDetector = new GestureDetector(WidgetChatListAdapter.this.getContext(), new WidgetChatListAdapter$HandlerOfTouches$tapGestureDetector$1(this));
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            boolean z2 = event != null && event.getAction() == 2;
            if (!WidgetChatListAdapter.access$isTouchedSinceLastJump$p(WidgetChatListAdapter.this) && z2) {
                WidgetChatListAdapter.access$setTouchedSinceLastJump$p(WidgetChatListAdapter.this, true);
                WidgetChatListAdapter.access$publishInteractionState(WidgetChatListAdapter.this);
            }
            return this.tapGestureDetector.onTouchEvent(event);
        }
    }

    /* compiled from: WidgetChatListAdapter.kt */
    public final class HandlerOfUpdates implements Runnable {
        private long channelId;
        private long oldestMessageId;

        public HandlerOfUpdates() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.channelId != WidgetChatListAdapter.this.getData().getChannelId()) {
                boolean z2 = this.channelId != 0;
                this.channelId = WidgetChatListAdapter.this.getData().getChannelId();
                if (z2) {
                    WidgetChatListAdapter.this.scrollToMessageId(0L, WidgetChatListAdapter$HandlerOfUpdates$run$1.INSTANCE);
                }
                WidgetChatListAdapter.access$setTouchedSinceLastJump$p(WidgetChatListAdapter.this, false);
            }
            if (this.oldestMessageId != WidgetChatListAdapter.this.getData().getOldestMessageId()) {
                this.oldestMessageId = WidgetChatListAdapter.this.getData().getOldestMessageId();
                WidgetChatListAdapter.this.getEventHandler().onOldestMessageId(this.channelId, this.oldestMessageId);
            }
            WidgetChatListAdapter.access$publishInteractionState(WidgetChatListAdapter.this);
        }
    }

    /* compiled from: WidgetChatListAdapter.kt */
    public static final class ScrollToWithHighlight implements Runnable {
        private final WidgetChatListAdapter adapter;
        private int attempts;
        private final long messageId;
        private final Function0<Unit> onCompleted;

        public ScrollToWithHighlight(WidgetChatListAdapter widgetChatListAdapter, long j, Function0<Unit> function0) {
            m.checkNotNullParameter(widgetChatListAdapter, "adapter");
            m.checkNotNullParameter(function0, "onCompleted");
            this.adapter = widgetChatListAdapter;
            this.messageId = j;
            this.onCompleted = function0;
            widgetChatListAdapter.getRecycler().post(this);
        }

        private final void animateHighlight(View view) {
            view.setBackgroundResource(R.drawable.drawable_bg_highlight);
            Drawable background = view.getBackground();
            Objects.requireNonNull(background, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
            TransitionDrawable transitionDrawable = (TransitionDrawable) background;
            transitionDrawable.startTransition(500);
            CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(view);
            if (coroutineScope != null) {
                f.H0(coroutineScope, null, null, new WidgetChatListAdapter$ScrollToWithHighlight$animateHighlight$1(transitionDrawable, null), 3, null);
            }
        }

        private final int getNewMessageEntryIndex(List<? extends ChatListEntry> list) {
            long jLongValue = this.messageId;
            boolean z2 = jLongValue == 0;
            if (jLongValue == 1) {
                return 0;
            }
            Integer num = null;
            if (jLongValue == 0) {
                Long lValueOf = Long.valueOf(this.adapter.getData().getNewMessagesMarkerMessageId());
                if (!(lValueOf.longValue() > 0)) {
                    lValueOf = null;
                }
                if (lValueOf == null) {
                    return 0;
                }
                jLongValue = lValueOf.longValue();
            }
            int iAccess$findBestNewMessagesPosition = -1;
            if (jLongValue <= 0) {
                return -1;
            }
            Iterator<? extends ChatListEntry> it = list.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ChatListEntry next = it.next();
                if ((next instanceof MessageEntry) && ((MessageEntry) next).getMessage().getId() <= jLongValue) {
                    iAccess$findBestNewMessagesPosition = i;
                    break;
                }
                i++;
            }
            if (iAccess$findBestNewMessagesPosition < 0 && z2) {
                iAccess$findBestNewMessagesPosition = Companion.access$findBestNewMessagesPosition(WidgetChatListAdapter.INSTANCE, n.getLastIndex(list));
            }
            Iterator<Integer> it2 = d0.d0.f.downTo(iAccess$findBestNewMessagesPosition, 0).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Integer next2 = it2.next();
                ChatListEntry chatListEntry = list.get(next2.intValue());
                if ((chatListEntry instanceof NewMessagesEntry) && ((NewMessagesEntry) chatListEntry).getMessageId() == jLongValue) {
                    num = next2;
                    break;
                }
            }
            Integer num2 = num;
            return num2 != null ? num2.intValue() : iAccess$findBestNewMessagesPosition;
        }

        private final void scheduleRetry() {
            int i = this.attempts;
            if (i >= 20) {
                this.onCompleted.invoke();
                return;
            }
            this.attempts = i + 1;
            CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(this.adapter.getRecycler());
            if (coroutineScope != null) {
                f.H0(coroutineScope, null, null, new WidgetChatListAdapter$ScrollToWithHighlight$scheduleRetry$1(this, null), 3, null);
            }
        }

        public final void cancel() {
            this.adapter.getRecycler().removeCallbacks(this);
        }

        public final WidgetChatListAdapter getAdapter() {
            return this.adapter;
        }

        public final long getMessageId() {
            return this.messageId;
        }

        public final Function0<Unit> getOnCompleted() {
            return this.onCompleted;
        }

        @Override // java.lang.Runnable
        public void run() {
            Data data = this.adapter.getData();
            View viewFindViewByPosition = null;
            if (!(data instanceof WidgetChatListModel)) {
                data = null;
            }
            WidgetChatListModel widgetChatListModel = (WidgetChatListModel) data;
            if (widgetChatListModel != null && widgetChatListModel.isLoadingMessages()) {
                scheduleRetry();
                return;
            }
            int newMessageEntryIndex = getNewMessageEntryIndex(this.adapter.getData().getList());
            if (newMessageEntryIndex < 0) {
                scheduleRetry();
                return;
            }
            int height = (int) (this.adapter.getRecycler().getHeight() / 2.0f);
            LinearLayoutManager layoutManager = this.adapter.getLayoutManager();
            if (layoutManager != null) {
                layoutManager.scrollToPositionWithOffset(newMessageEntryIndex, height);
                viewFindViewByPosition = layoutManager.findViewByPosition(newMessageEntryIndex);
            }
            if (viewFindViewByPosition == null) {
                scheduleRetry();
                return;
            }
            if (!(newMessageEntryIndex < this.adapter.getData().getList().size() && (this.adapter.getData().getList().get(newMessageEntryIndex) instanceof NewMessagesEntry))) {
                animateHighlight(viewFindViewByPosition);
            }
            this.onCompleted.invoke();
        }
    }

    /* compiled from: WidgetChatListAdapter.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$disposeHandlers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function2<List<? extends ChatListEntry>, List<? extends ChatListEntry>, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ChatListEntry> list, List<? extends ChatListEntry> list2) {
            invoke2(list, list2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ChatListEntry> list, List<? extends ChatListEntry> list2) {
            m.checkNotNullParameter(list, "<anonymous parameter 0>");
            m.checkNotNullParameter(list2, "<anonymous parameter 1>");
        }
    }

    /* compiled from: WidgetChatListAdapter.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$scrollToMessageId$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ Action0 $onCompleted;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Action0 action0) {
            super(0);
            this.$onCompleted = action0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChatListAdapter.access$setScrollToWithHighlight$p(WidgetChatListAdapter.this, null);
            WidgetChatListAdapter.access$publishInteractionState(WidgetChatListAdapter.this);
            this.$onCompleted.call();
        }
    }

    /* compiled from: WidgetChatListAdapter.kt */
    /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$setHandlers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function2<List<? extends ChatListEntry>, List<? extends ChatListEntry>, Unit> {

        /* compiled from: WidgetChatListAdapter.kt */
        @e(c = "com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$setHandlers$1$1", f = "WidgetChatListAdapter.kt", l = {118}, m = "invokeSuspend")
        /* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$setHandlers$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03851 extends k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public int label;

            public C03851(Continuation continuation) {
                super(2, continuation);
            }

            @Override // d0.w.i.a.a
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                m.checkNotNullParameter(continuation, "completion");
                return AnonymousClass1.this.new C03851(continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C03851) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
            }

            @Override // d0.w.i.a.a
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    l.throwOnFailure(obj);
                    this.label = 1;
                    if (f.P(250L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    l.throwOnFailure(obj);
                }
                WidgetChatListAdapter.access$getHandlerOfUpdates$p(WidgetChatListAdapter.this).run();
                return Unit.a;
            }
        }

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ChatListEntry> list, List<? extends ChatListEntry> list2) {
            invoke2(list, list2);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ChatListEntry> list, List<? extends ChatListEntry> list2) {
            m.checkNotNullParameter(list, "<anonymous parameter 0>");
            m.checkNotNullParameter(list2, "<anonymous parameter 1>");
            Job jobAccess$getLastUpdateJob$p = WidgetChatListAdapter.access$getLastUpdateJob$p(WidgetChatListAdapter.this);
            if (jobAccess$getLastUpdateJob$p != null) {
                f.t(jobAccess$getLastUpdateJob$p, null, 1, null);
            }
            WidgetChatListAdapter widgetChatListAdapter = WidgetChatListAdapter.this;
            CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(widgetChatListAdapter.getRecycler());
            WidgetChatListAdapter.access$setLastUpdateJob$p(widgetChatListAdapter, coroutineScope != null ? f.H0(coroutineScope, null, null, new C03851(null), 3, null) : null);
            WidgetChatListAdapter.this.getRecycler().setOnTouchListener(WidgetChatListAdapter.access$getHandlerOfTouches$p(WidgetChatListAdapter.this));
            WidgetChatListAdapter.this.getRecycler().removeOnScrollListener(WidgetChatListAdapter.access$getHandlerOfScrolls$p(WidgetChatListAdapter.this));
            WidgetChatListAdapter.this.getRecycler().addOnScrollListener(WidgetChatListAdapter.access$getHandlerOfScrolls$p(WidgetChatListAdapter.this));
        }
    }

    public WidgetChatListAdapter(RecyclerView recyclerView, AppPermissionsRequests appPermissionsRequests, FragmentManager fragmentManager, EventHandler eventHandler) {
        this(recyclerView, appPermissionsRequests, fragmentManager, eventHandler, null, null, 48, null);
    }

    public WidgetChatListAdapter(RecyclerView recyclerView, AppPermissionsRequests appPermissionsRequests, FragmentManager fragmentManager, EventHandler eventHandler, AppFlexInputViewModel appFlexInputViewModel) {
        this(recyclerView, appPermissionsRequests, fragmentManager, eventHandler, appFlexInputViewModel, null, 32, null);
    }

    public /* synthetic */ WidgetChatListAdapter(RecyclerView recyclerView, AppPermissionsRequests appPermissionsRequests, FragmentManager fragmentManager, EventHandler eventHandler, AppFlexInputViewModel appFlexInputViewModel, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, appPermissionsRequests, fragmentManager, eventHandler, (i & 16) != 0 ? null : appFlexInputViewModel, (i & 32) != 0 ? ClockFactory.get() : clock);
    }

    public static final /* synthetic */ HandlerOfScrolls access$getHandlerOfScrolls$p(WidgetChatListAdapter widgetChatListAdapter) {
        return widgetChatListAdapter.handlerOfScrolls;
    }

    public static final /* synthetic */ HandlerOfTouches access$getHandlerOfTouches$p(WidgetChatListAdapter widgetChatListAdapter) {
        return widgetChatListAdapter.handlerOfTouches;
    }

    public static final /* synthetic */ HandlerOfUpdates access$getHandlerOfUpdates$p(WidgetChatListAdapter widgetChatListAdapter) {
        return widgetChatListAdapter.handlerOfUpdates;
    }

    public static final /* synthetic */ Job access$getLastUpdateJob$p(WidgetChatListAdapter widgetChatListAdapter) {
        return widgetChatListAdapter.lastUpdateJob;
    }

    public static final /* synthetic */ ScrollToWithHighlight access$getScrollToWithHighlight$p(WidgetChatListAdapter widgetChatListAdapter) {
        return widgetChatListAdapter.scrollToWithHighlight;
    }

    public static final /* synthetic */ boolean access$isTouchedSinceLastJump$p(WidgetChatListAdapter widgetChatListAdapter) {
        return widgetChatListAdapter.isTouchedSinceLastJump;
    }

    public static final /* synthetic */ void access$publishInteractionState(WidgetChatListAdapter widgetChatListAdapter) {
        widgetChatListAdapter.publishInteractionState();
    }

    public static final /* synthetic */ void access$setLastUpdateJob$p(WidgetChatListAdapter widgetChatListAdapter, Job job) {
        widgetChatListAdapter.lastUpdateJob = job;
    }

    public static final /* synthetic */ void access$setScrollToWithHighlight$p(WidgetChatListAdapter widgetChatListAdapter, ScrollToWithHighlight scrollToWithHighlight) {
        widgetChatListAdapter.scrollToWithHighlight = scrollToWithHighlight;
    }

    public static final /* synthetic */ void access$setTouchedSinceLastJump$p(WidgetChatListAdapter widgetChatListAdapter, boolean z2) {
        widgetChatListAdapter.isTouchedSinceLastJump = z2;
    }

    private final void publishInteractionState() {
        Data data = this.data;
        if (!(data instanceof WidgetChatListModel)) {
            data = null;
        }
        WidgetChatListModel widgetChatListModel = (WidgetChatListModel) data;
        this.eventHandler.onInteractionStateUpdated(new StoreChat.InteractionState(this.data.getChannelId(), widgetChatListModel != null ? widgetChatListModel.getNewestKnownMessageId() : 0L, this.isTouchedSinceLastJump, getLayoutManager()));
    }

    public final void disposeHandlers() {
        setOnUpdated(AnonymousClass1.INSTANCE);
        Job job = this.lastUpdateJob;
        if (job != null) {
            f.t(job, null, 1, null);
        }
        getRecycler().setOnTouchListener(null);
        getRecycler().removeOnScrollListener(this.handlerOfScrolls);
        this.eventHandler.onInteractionStateUpdated(new StoreChat.InteractionState(this.data.getChannelId(), 0L, this.isTouchedSinceLastJump, (LinearLayoutManager) null));
    }

    public final AppPermissionsRequests getAppPermissionsRequests() {
        return this.appPermissionsRequests;
    }

    public final ComponentProvider getBotUiComponentProvider() {
        return this.botUiComponentProvider;
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final Data getData() {
        return this.data;
    }

    public final EventHandler getEventHandler() {
        return this.eventHandler;
    }

    public final AppFlexInputViewModel getFlexInputViewModel() {
        return this.flexInputViewModel;
    }

    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public final LinearLayoutManager getLayoutManager() {
        RecyclerView.LayoutManager layoutManager = getRecycler().getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            layoutManager = null;
        }
        return (LinearLayoutManager) layoutManager;
    }

    public final boolean getMentionMeMessageLevelHighlighting() {
        return this.mentionMeMessageLevelHighlighting;
    }

    public final void onBotUiComponentClicked(long applicationId, long messageId, Long messageFlags, int componentIndex, RestAPIParams.ComponentInteractionData componentSendData) {
        m.checkNotNullParameter(componentSendData, "componentSendData");
        EventHandler eventHandler = this.eventHandler;
        Guild guild = this.data.getGuild();
        eventHandler.onBotUiComponentClicked(applicationId, guild != null ? Long.valueOf(guild.getId()) : null, this.data.getChannelId(), messageId, messageFlags, componentIndex, componentSendData);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void onPause() {
        int childCount = getRecycler().getChildCount();
        for (int i = 0; i < childCount; i++) {
            Object childViewHolder = getRecycler().getChildViewHolder(getRecycler().getChildAt(i));
            if (childViewHolder instanceof FragmentLifecycleListener) {
                ((FragmentLifecycleListener) childViewHolder).onPause();
            }
        }
    }

    public final void onQuickAddReactionClicked(long messageId) {
        this.eventHandler.onQuickAddReactionClicked(this.data.getGuildId(), this.data.getUserId(), this.data.getChannelId(), messageId);
    }

    public final void onReactionClicked(long messageId, MessageReaction reaction, boolean canAddReactions) {
        m.checkNotNullParameter(reaction, "reaction");
        this.eventHandler.onReactionClicked(this.data.getGuildId(), this.data.getUserId(), this.data.getChannelId(), messageId, reaction, canAddReactions);
    }

    public final void onReactionLongClicked(long messageId, MessageReaction reaction) {
        m.checkNotNullParameter(reaction, "reaction");
        this.eventHandler.onReactionLongClicked(this.data.getGuildId(), this.data.getChannelId(), messageId, reaction);
    }

    public final void onResume() {
        int childCount = getRecycler().getChildCount();
        for (int i = 0; i < childCount; i++) {
            Object childViewHolder = getRecycler().getChildViewHolder(getRecycler().getChildAt(i));
            if (childViewHolder instanceof FragmentLifecycleListener) {
                ((FragmentLifecycleListener) childViewHolder).onResume();
            }
        }
    }

    public final void onRoleSubscriptionPurchaseSystemMessageClicked(long roleSubscriptionListingId, long messageId) {
        this.eventHandler.onRoleSubscriptionPurchaseTierClick(roleSubscriptionListingId, this.data.getGuildId(), this.data.getUserId(), this.data.getChannelId(), messageId);
    }

    public final void onShareButtonClick(GuildScheduledEvent guildEvent, WeakReference<Context> weakContext, WeakReference<AppFragment> weakFragment) {
        m.checkNotNullParameter(guildEvent, "guildEvent");
        m.checkNotNullParameter(weakContext, "weakContext");
        m.checkNotNullParameter(weakFragment, "weakFragment");
        this.eventHandler.onShareButtonClick(guildEvent, weakContext, weakFragment);
    }

    public final void onStickerClicked(Message message, BaseSticker sticker) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(sticker, "sticker");
        this.eventHandler.onStickerClicked(message, sticker);
    }

    public final void onThreadClicked(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        this.eventHandler.onThreadClicked(channel);
    }

    public final void onThreadLongClicked(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        this.eventHandler.onThreadLongClicked(channel);
    }

    public final void onUserActivityAction(long authorId, long messageId, MessageActivityType messageActivityType, Activity activity, Application application) {
        m.checkNotNullParameter(messageActivityType, "messageActivityType");
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        m.checkNotNullParameter(application, "application");
        this.eventHandler.onUserActivityAction(authorId, this.data.getChannelId(), messageId, messageActivityType, activity, application);
    }

    public final void scrollToMessageId(long messageId, Action0 onCompleted) {
        m.checkNotNullParameter(onCompleted, "onCompleted");
        ScrollToWithHighlight scrollToWithHighlight = this.scrollToWithHighlight;
        if (scrollToWithHighlight != null && scrollToWithHighlight.getMessageId() > 0 && messageId <= 0) {
            onCompleted.call();
            return;
        }
        this.isTouchedSinceLastJump = false;
        ScrollToWithHighlight scrollToWithHighlight2 = this.scrollToWithHighlight;
        if (scrollToWithHighlight2 != null) {
            scrollToWithHighlight2.cancel();
        }
        this.scrollToWithHighlight = new ScrollToWithHighlight(this, messageId, new AnonymousClass1(onCompleted));
    }

    public final void setData(Data data) {
        m.checkNotNullParameter(data, "value");
        this.data = data;
        setData(data.getList());
    }

    public final void setFragmentManager(FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "<set-?>");
        this.fragmentManager = fragmentManager;
    }

    public final void setHandlers() {
        setOnUpdated(new AnonymousClass1());
    }

    public final void setMentionMeMessageLevelHighlighting(boolean z2) {
        this.mentionMeMessageLevelHighlighting = z2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapter(RecyclerView recyclerView, AppPermissionsRequests appPermissionsRequests, FragmentManager fragmentManager, EventHandler eventHandler, AppFlexInputViewModel appFlexInputViewModel, Clock clock) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        m.checkNotNullParameter(appPermissionsRequests, "appPermissionsRequests");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(eventHandler, "eventHandler");
        m.checkNotNullParameter(clock, "clock");
        this.appPermissionsRequests = appPermissionsRequests;
        this.fragmentManager = fragmentManager;
        this.eventHandler = eventHandler;
        this.flexInputViewModel = appFlexInputViewModel;
        this.clock = clock;
        Context context = recyclerView.getContext();
        m.checkNotNullExpressionValue(context, "recycler.context");
        this.botUiComponentProvider = new ComponentProvider(context);
        this.data = new EmptyData();
        this.mentionMeMessageLevelHighlighting = true;
        this.handlerOfTouches = new HandlerOfTouches();
        this.handlerOfScrolls = new HandlerOfScrolls();
        this.handlerOfUpdates = new HandlerOfUpdates();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetChatListAdapter, ChatListEntry> onCreateViewHolder(ViewGroup parent, int viewType) {
        MGRecyclerViewHolder<WidgetChatListAdapter, ChatListEntry> widgetChatListAdapterItemGuildWelcome;
        m.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
            case 32:
                return new WidgetChatListAdapterItemMessage(R.layout.widget_chat_list_adapter_item_text, this);
            case 1:
                return new WidgetChatListAdapterItemMessage(R.layout.widget_chat_list_adapter_item_minimal, this);
            case 2:
                return new WidgetChatListItem(R.layout.widget_chat_list_adapter_item_loading, this);
            case 3:
                return new WidgetChatListAdapterItemStart(this);
            case 4:
                return new WidgetChatListAdapterItemReactions(this);
            case 5:
                return new WidgetChatListAdapterItemSystemMessage(this);
            case 6:
                return new WidgetChatListAdapterItemUploadProgress(this);
            case 7:
                return new WidgetChatListItem(R.layout.widget_chat_list_adapter_item_spacer, this);
            case 8:
                return new WidgetChatListAdapterItemNewMessages(this);
            case 9:
                return new WidgetChatListAdapterItemTimestamp(this);
            case 10:
                return new WidgetChatListAdapterItemBlocked(this);
            case 11:
                return new WidgetChatListAdapterItemSearchResultCount(this);
            case 12:
                return new MGRecyclerViewHolder<>(R.layout.widget_chat_list_adapter_item_search_indexing, this);
            case 13:
                return new MGRecyclerViewHolder<>(R.layout.widget_chat_list_adapter_item_search_empty, this);
            case 14:
                return new MGRecyclerViewHolder<>(R.layout.widget_chat_list_adapter_item_search_error, this);
            case 15:
                return new MGRecyclerViewHolder<>(R.layout.widget_chat_list_adapter_item_divider, this);
            case 16:
                return new WidgetChatListAdapterItemEmptyPins(this);
            case 17:
                return new WidgetChatListAdapterItemMessageHeader(this);
            case 18:
                return new WidgetChatListAdapterItemMentionFooter(this);
            case 19:
                return new WidgetChatListAdapterItemCallMessage(this);
            case 20:
                return new WidgetChatListAdapterItemMessage(R.layout.widget_chat_list_adapter_item_failed, this);
            case 21:
                return new WidgetChatListAdapterItemEmbed(this);
            case 22:
                return new WidgetChatListAdapterItemGameInvite(this);
            case 23:
                return new WidgetChatListAdapterItemSpotifyListenTogether(this);
            case 24:
                return new WidgetChatListAdapterItemInvite(this);
            case 25:
                widgetChatListAdapterItemGuildWelcome = new WidgetChatListAdapterItemGuildWelcome(this, null, 2, null);
                break;
            case 26:
                return new WidgetChatListAdapterItemGift(this);
            case 27:
            default:
                throw invalidViewTypeException(viewType);
            case 28:
                return new WidgetChatListAdapterItemAttachment(this);
            case 29:
                return new WidgetChatListAdapterItemPrivateChannelStart(this);
            case 30:
                return new WidgetChatListAdapterItemGuildTemplate(this);
            case 31:
                return new WidgetChatListAdapterItemSticker(this);
            case 33:
                return new WidgetChatListAdapterItemApplicationCommand(this);
            case 34:
                return new WidgetChatListAdapterItemEphemeralMessage(this);
            case 35:
                return new WidgetChatListAdapterItemThreadEmbed(this);
            case 36:
                return new WidgetChatListAdapterItemBotComponentRow(this);
            case 37:
                return new WidgetChatListAdapterItemThreadDraftForm(this, this.flexInputViewModel);
            case 38:
                return new WidgetChatListAdapterItemGuildInviteReminder(this);
            case 39:
                return new WidgetChatListAdapterItemStageInvite(this);
            case 40:
                return new MGRecyclerViewHolder<>(R.layout.widget_chat_list_adapter_item_thread_starter_divider, this);
            case 41:
                return new WidgetChatListAdapterItemStickerGreet(this);
            case 42:
                return new WidgetChatListAdapterItemStickerGreetCompact(this);
            case 43:
                widgetChatListAdapterItemGuildWelcome = new WidgetChatListAdapterItemGuildScheduledEventInvite(this, null, 2, null);
                break;
            case 44:
                return new WidgetChatListAdapterItemAutoModBlocked(this);
            case 45:
                return new WidgetChatListAdapterItemAutoModSystemMessageEmbed(this);
        }
        return widgetChatListAdapterItemGuildWelcome;
    }
}
