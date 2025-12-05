package com.discord.stores;

import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.discord.models.message.Message;
import com.discord.models.user.User;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.subjects.PublishSubject;

/* compiled from: StoreChat.kt */
/* loaded from: classes2.dex */
public final class StoreChat extends StoreV2 {
    private final Dispatcher dispatcher;
    private EditingMessage editingMessage;
    private final PublishSubject<Event> eventSubject;
    private final List<Long> expandedBlockedMessageGroups;
    private List<Long> expandedBlockedMessageGroupsSnapshot;
    private InteractionState interactionState;
    private final ObservationDeck observationDeck;

    /* compiled from: StoreChat.kt */
    public static final /* data */ class EditingMessage {
        private final CharSequence content;
        private final Message message;

        public EditingMessage(Message message, CharSequence charSequence) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(charSequence, "content");
            this.message = message;
            this.content = charSequence;
        }

        public static /* synthetic */ EditingMessage copy$default(EditingMessage editingMessage, Message message, CharSequence charSequence, int i, Object obj) {
            if ((i & 1) != 0) {
                message = editingMessage.message;
            }
            if ((i & 2) != 0) {
                charSequence = editingMessage.content;
            }
            return editingMessage.copy(message, charSequence);
        }

        /* renamed from: component1, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        /* renamed from: component2, reason: from getter */
        public final CharSequence getContent() {
            return this.content;
        }

        public final EditingMessage copy(Message message, CharSequence content) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(content, "content");
            return new EditingMessage(message, content);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EditingMessage)) {
                return false;
            }
            EditingMessage editingMessage = (EditingMessage) other;
            return Intrinsics3.areEqual(this.message, editingMessage.message) && Intrinsics3.areEqual(this.content, editingMessage.content);
        }

        public final CharSequence getContent() {
            return this.content;
        }

        public final Message getMessage() {
            return this.message;
        }

        public int hashCode() {
            Message message = this.message;
            int iHashCode = (message != null ? message.hashCode() : 0) * 31;
            CharSequence charSequence = this.content;
            return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("EditingMessage(message=");
            sbM833U.append(this.message);
            sbM833U.append(", content=");
            return outline.m817E(sbM833U, this.content, ")");
        }
    }

    /* compiled from: StoreChat.kt */
    public static abstract class Event {

        /* compiled from: StoreChat.kt */
        public static final /* data */ class AppendChatText extends Event {
            private final String text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AppendChatText(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                this.text = str;
            }

            public static /* synthetic */ AppendChatText copy$default(AppendChatText appendChatText, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = appendChatText.text;
                }
                return appendChatText.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final AppendChatText copy(String text) {
                Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                return new AppendChatText(text);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof AppendChatText) && Intrinsics3.areEqual(this.text, ((AppendChatText) other).text);
                }
                return true;
            }

            public final String getText() {
                return this.text;
            }

            public int hashCode() {
                String str = this.text;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.m822J(outline.m833U("AppendChatText(text="), this.text, ")");
            }
        }

        /* compiled from: StoreChat.kt */
        public static final /* data */ class ReplaceChatText extends Event {
            private final String text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReplaceChatText(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                this.text = str;
            }

            public static /* synthetic */ ReplaceChatText copy$default(ReplaceChatText replaceChatText, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = replaceChatText.text;
                }
                return replaceChatText.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final ReplaceChatText copy(String text) {
                Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                return new ReplaceChatText(text);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ReplaceChatText) && Intrinsics3.areEqual(this.text, ((ReplaceChatText) other).text);
                }
                return true;
            }

            public final String getText() {
                return this.text;
            }

            public int hashCode() {
                String str = this.text;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.m822J(outline.m833U("ReplaceChatText(text="), this.text, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreChat.kt */
    /* renamed from: com.discord.stores.StoreChat$observeEditingMessage$1 */
    public static final class C58401 extends Lambda implements Function0<EditingMessage> {
        public C58401() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ EditingMessage invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final EditingMessage invoke() {
            return StoreChat.this.getEditingMessage();
        }
    }

    /* compiled from: StoreChat.kt */
    /* renamed from: com.discord.stores.StoreChat$observeExpandedBlockedMessageIds$1 */
    public static final class C58411 extends Lambda implements Function0<List<? extends Long>> {
        public C58411() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends Long> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends Long> invoke2() {
            return StoreChat.this.getExpandedBlockedMessageGroups();
        }
    }

    /* compiled from: StoreChat.kt */
    /* renamed from: com.discord.stores.StoreChat$observeInteractionState$1 */
    public static final class C58421 extends Lambda implements Function0<InteractionState> {
        public C58421() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ InteractionState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final InteractionState invoke() {
            return StoreChat.this.getInteractionState();
        }
    }

    /* compiled from: StoreChat.kt */
    /* renamed from: com.discord.stores.StoreChat$setEditingMessage$1 */
    public static final class C58431 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ EditingMessage $editingMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58431(EditingMessage editingMessage) {
            super(0);
            this.$editingMessage = editingMessage;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreChat.access$setEditingMessage$p(StoreChat.this, this.$editingMessage);
            StoreChat.this.markChanged();
        }
    }

    /* compiled from: StoreChat.kt */
    /* renamed from: com.discord.stores.StoreChat$setInteractionState$1 */
    public static final class C58441 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ InteractionState $interactionState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58441(InteractionState interactionState) {
            super(0);
            this.$interactionState = interactionState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreChat.access$setInteractionState$p(StoreChat.this, this.$interactionState);
            StoreChat.this.markChanged();
        }
    }

    /* compiled from: StoreChat.kt */
    /* renamed from: com.discord.stores.StoreChat$toggleBlockedMessageGroup$1 */
    public static final class C58451 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58451(long j) {
            super(0);
            this.$messageId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreChat.access$getExpandedBlockedMessageGroups$p(StoreChat.this).contains(Long.valueOf(this.$messageId))) {
                StoreChat.access$getExpandedBlockedMessageGroups$p(StoreChat.this).remove(Long.valueOf(this.$messageId));
            } else {
                StoreChat.access$getExpandedBlockedMessageGroups$p(StoreChat.this).add(Long.valueOf(this.$messageId));
            }
            StoreChat.this.markChanged();
        }
    }

    public /* synthetic */ StoreChat(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ EditingMessage access$getEditingMessage$p(StoreChat storeChat) {
        return storeChat.editingMessage;
    }

    public static final /* synthetic */ List access$getExpandedBlockedMessageGroups$p(StoreChat storeChat) {
        return storeChat.expandedBlockedMessageGroups;
    }

    public static final /* synthetic */ InteractionState access$getInteractionState$p(StoreChat storeChat) {
        return storeChat.interactionState;
    }

    public static final /* synthetic */ void access$setEditingMessage$p(StoreChat storeChat, EditingMessage editingMessage) {
        storeChat.editingMessage = editingMessage;
    }

    public static final /* synthetic */ void access$setInteractionState$p(StoreChat storeChat, InteractionState interactionState) {
        storeChat.interactionState = interactionState;
    }

    public final void appendMention(User user, long guildId) {
        if (user != null) {
            if (user.getUsername().length() == 0) {
                return;
            }
            StoreGatewayConnection.requestGuildMembers$default(StoreStream.INSTANCE.getGatewaySocket(), guildId, user.getUsername(), null, null, 12, null);
            StringBuilder sbM833U = outline.m833U("@");
            sbM833U.append(user.getUsername());
            sbM833U.append(UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
            String string = sbM833U.toString();
            this.eventSubject.f27650k.onNext(new Event.AppendChatText(string + ' '));
        }
    }

    public final EditingMessage getEditingMessage() {
        return this.editingMessage;
    }

    public final List<Long> getExpandedBlockedMessageGroups() {
        return this.expandedBlockedMessageGroupsSnapshot;
    }

    public final InteractionState getInteractionState() {
        return this.interactionState;
    }

    public final Observable<EditingMessage> observeEditingMessage() {
        Observable<EditingMessage> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C58401(), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final Observable<List<Long>> observeExpandedBlockedMessageIds() {
        Observable<List<Long>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C58411(), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<InteractionState> observeInteractionState() {
        Observable observableM11083G = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C58421(), 14, null).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        Observable<InteractionState> observableM11112r = observableM11083G.m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final void replaceChatText(String text) {
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.eventSubject.f27650k.onNext(new Event.ReplaceChatText(text + ' '));
    }

    public final void setEditingMessage(EditingMessage editingMessage) {
        this.dispatcher.schedule(new C58431(editingMessage));
    }

    public final void setInteractionState(InteractionState interactionState) {
        Intrinsics3.checkNotNullParameter(interactionState, "interactionState");
        this.dispatcher.schedule(new C58441(interactionState));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.expandedBlockedMessageGroupsSnapshot = new ArrayList(this.expandedBlockedMessageGroups);
    }

    public final void toggleBlockedMessageGroup(long messageId) {
        this.dispatcher.schedule(new C58451(messageId));
    }

    public StoreChat(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.expandedBlockedMessageGroups = new ArrayList();
        this.expandedBlockedMessageGroupsSnapshot = Collections2.emptyList();
        this.eventSubject = PublishSubject.m11133k0();
    }

    /* compiled from: StoreChat.kt */
    public static final /* data */ class InteractionState {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int NEAR_EDGE_THRESHOLD = 15;
        private static final int SCROLLED = 0;
        private static final int SCROLLED_BOTTOM = 1;
        private static final int SCROLLED_NEAR_BOTTOM = 4;
        private static final int SCROLLED_TOP = 2;
        private final long channelId;
        private final boolean isAtBottom;
        private final boolean isAtTop;
        private final boolean isTouchedSinceLastJump;
        private final long lastMessageId;

        /* renamed from: scrollState$1, reason: from kotlin metadata */
        private final int scrollState;

        /* compiled from: StoreChat.kt */
        public static final class Companion {
            private Companion() {
            }

            public static final /* synthetic */ int access$getScrollState$p(Companion companion, LinearLayoutManager linearLayoutManager) {
                return companion.getScrollState(linearLayoutManager);
            }

            private final int getScrollState(LinearLayoutManager linearLayoutManager) {
                if (linearLayoutManager == null) {
                    return 0;
                }
                int itemCount = linearLayoutManager.getItemCount() - 1;
                int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                int iMax = Math.max(0, itemCount - 15);
                int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                boolean z2 = 1 <= iFindFirstVisibleItemPosition && 15 >= iFindFirstVisibleItemPosition;
                int i = iFindFirstVisibleItemPosition <= 0 ? 1 : 0;
                if (iFindLastVisibleItemPosition == itemCount || iFindLastVisibleItemPosition >= iMax) {
                    i |= 2;
                }
                return z2 ? i | 4 : i;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public InteractionState(long j, long j2, boolean z2, int i) {
            this.channelId = j;
            this.lastMessageId = j2;
            this.isTouchedSinceLastJump = z2;
            this.scrollState = i;
            this.isAtTop = z2 && isAtTopIgnoringTouch();
            this.isAtBottom = z2 && isAtBottomIgnoringTouch();
        }

        /* renamed from: component4, reason: from getter */
        private final int getScrollState() {
            return this.scrollState;
        }

        public static /* synthetic */ InteractionState copy$default(InteractionState interactionState, long j, long j2, boolean z2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = interactionState.channelId;
            }
            long j3 = j;
            if ((i2 & 2) != 0) {
                j2 = interactionState.lastMessageId;
            }
            long j4 = j2;
            if ((i2 & 4) != 0) {
                z2 = interactionState.isTouchedSinceLastJump;
            }
            boolean z3 = z2;
            if ((i2 & 8) != 0) {
                i = interactionState.scrollState;
            }
            return interactionState.copy(j3, j4, z3, i);
        }

        /* renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component2, reason: from getter */
        public final long getLastMessageId() {
            return this.lastMessageId;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsTouchedSinceLastJump() {
            return this.isTouchedSinceLastJump;
        }

        public final InteractionState copy(long channelId, long lastMessageId, boolean isTouchedSinceLastJump, int scrollState) {
            return new InteractionState(channelId, lastMessageId, isTouchedSinceLastJump, scrollState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InteractionState)) {
                return false;
            }
            InteractionState interactionState = (InteractionState) other;
            return this.channelId == interactionState.channelId && this.lastMessageId == interactionState.lastMessageId && this.isTouchedSinceLastJump == interactionState.isTouchedSinceLastJump && this.scrollState == interactionState.scrollState;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final long getLastMessageId() {
            return this.lastMessageId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iM3a = (C0002b.m3a(this.lastMessageId) + (C0002b.m3a(this.channelId) * 31)) * 31;
            boolean z2 = this.isTouchedSinceLastJump;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return ((iM3a + i) * 31) + this.scrollState;
        }

        /* renamed from: isAtBottom, reason: from getter */
        public final boolean getIsAtBottom() {
            return this.isAtBottom;
        }

        public final boolean isAtBottomIgnoringTouch() {
            return (this.scrollState & 1) != 0;
        }

        /* renamed from: isAtTop, reason: from getter */
        public final boolean getIsAtTop() {
            return this.isAtTop;
        }

        public final boolean isAtTopIgnoringTouch() {
            return (this.scrollState & 2) != 0;
        }

        public final boolean isNearBottomIgnoringTouch() {
            return (this.scrollState & 4) != 0;
        }

        public final boolean isTouchedSinceLastJump() {
            return this.isTouchedSinceLastJump;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("InteractionState(channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", lastMessageId=");
            sbM833U.append(this.lastMessageId);
            sbM833U.append(", isTouchedSinceLastJump=");
            sbM833U.append(this.isTouchedSinceLastJump);
            sbM833U.append(", scrollState=");
            return outline.m814B(sbM833U, this.scrollState, ")");
        }

        public InteractionState(long j, long j2, boolean z2, LinearLayoutManager linearLayoutManager) {
            this(j, j2, z2, Companion.access$getScrollState$p(INSTANCE, linearLayoutManager));
        }
    }
}
