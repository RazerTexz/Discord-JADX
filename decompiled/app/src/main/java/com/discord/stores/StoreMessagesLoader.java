package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.user.User;
import com.discord.app.AppLog;
import com.discord.models.message.Message;
import com.discord.stores.StoreChat;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.C0879o;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Sets5;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;

/* compiled from: StoreMessagesLoader.kt */
/* loaded from: classes2.dex */
public final class StoreMessagesLoader extends Store {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long SCROLL_TO_LAST_UNREAD = 0;
    public static final long SCROLL_TO_LATEST = 1;
    private boolean authed;
    private boolean backgrounded;
    private final SerializedSubject<Map<Long, ChannelLoadedState>, Map<Long, ChannelLoadedState>> channelLoadedStateSubject;
    private final HashMap<Long, ChannelLoadedState> channelLoadedStates;
    private final SerializedSubject<ChannelChunk, ChannelChunk> channelMessageChunksSubject;
    private final SerializedSubject<Boolean, Boolean> channelMessagesLoadingSubject;
    private Subscription delayLoadingMessagesSubscription;
    private Set<Long> detachedChannels;
    private final Dispatcher dispatcher;
    private boolean hasConnected;
    private StoreChat.InteractionState interactionState;
    private final long loadingMessagesRetryDelayDefault;
    private long loadingMessagesRetryDelayMillis;
    private final int loadingMessagesRetryJitter;
    private int loadingMessagesRetryMax;
    private Subscription loadingMessagesSubscription;
    private final int messageRequestSize;
    private final SerializedSubject<Long, Long> scrollToSubject;
    private long selectedChannelId;
    private final StoreStream stream;

    /* compiled from: StoreMessagesLoader.kt */
    public static final /* data */ class ChannelChunk {
        private final long channelId;
        private final boolean isAppendingTop;
        private final boolean isInitial;
        private final boolean isJump;
        private final boolean isPresent;
        private final List<Message> messages;

        public ChannelChunk(long j, List<Message> list, boolean z2, boolean z3, boolean z4, boolean z5) {
            Intrinsics3.checkNotNullParameter(list, "messages");
            this.channelId = j;
            this.messages = list;
            this.isInitial = z2;
            this.isPresent = z3;
            this.isAppendingTop = z4;
            this.isJump = z5;
        }

        public static /* synthetic */ ChannelChunk copy$default(ChannelChunk channelChunk, long j, List list, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
            return channelChunk.copy((i & 1) != 0 ? channelChunk.channelId : j, (i & 2) != 0 ? channelChunk.messages : list, (i & 4) != 0 ? channelChunk.isInitial : z2, (i & 8) != 0 ? channelChunk.isPresent : z3, (i & 16) != 0 ? channelChunk.isAppendingTop : z4, (i & 32) != 0 ? channelChunk.isJump : z5);
        }

        /* renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        public final List<Message> component2() {
            return this.messages;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsInitial() {
            return this.isInitial;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsPresent() {
            return this.isPresent;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsAppendingTop() {
            return this.isAppendingTop;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsJump() {
            return this.isJump;
        }

        public final ChannelChunk copy(long channelId, List<Message> messages, boolean isInitial, boolean isPresent, boolean isAppendingTop, boolean isJump) {
            Intrinsics3.checkNotNullParameter(messages, "messages");
            return new ChannelChunk(channelId, messages, isInitial, isPresent, isAppendingTop, isJump);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelChunk)) {
                return false;
            }
            ChannelChunk channelChunk = (ChannelChunk) other;
            return this.channelId == channelChunk.channelId && Intrinsics3.areEqual(this.messages, channelChunk.messages) && this.isInitial == channelChunk.isInitial && this.isPresent == channelChunk.isPresent && this.isAppendingTop == channelChunk.isAppendingTop && this.isJump == channelChunk.isJump;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final List<Message> getMessages() {
            return this.messages;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iM3a = C0002b.m3a(this.channelId) * 31;
            List<Message> list = this.messages;
            int iHashCode = (iM3a + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.isInitial;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            boolean z3 = this.isPresent;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z4 = this.isAppendingTop;
            int i5 = z4;
            if (z4 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z5 = this.isJump;
            return i6 + (z5 ? 1 : z5 ? 1 : 0);
        }

        public final boolean isAppendingTop() {
            return this.isAppendingTop;
        }

        public final boolean isInitial() {
            return this.isInitial;
        }

        public final boolean isJump() {
            return this.isJump;
        }

        public final boolean isPresent() {
            return this.isPresent;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("ChannelChunk(channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", messages=");
            sbM833U.append(this.messages);
            sbM833U.append(", isInitial=");
            sbM833U.append(this.isInitial);
            sbM833U.append(", isPresent=");
            sbM833U.append(this.isPresent);
            sbM833U.append(", isAppendingTop=");
            sbM833U.append(this.isAppendingTop);
            sbM833U.append(", isJump=");
            return outline.m827O(sbM833U, this.isJump, ")");
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    public static final /* data */ class ChannelLoadedState {
        private final boolean isInitialMessagesLoaded;
        private final boolean isLoadingMessages;
        private final boolean isOldestMessagesLoaded;
        private final boolean isTouchedSinceLastJump;
        private final Long newestSentByUserMessageId;

        public ChannelLoadedState() {
            this(false, false, false, false, null, 31, null);
        }

        public ChannelLoadedState(boolean z2, boolean z3, boolean z4, boolean z5, Long l) {
            this.isInitialMessagesLoaded = z2;
            this.isOldestMessagesLoaded = z3;
            this.isLoadingMessages = z4;
            this.isTouchedSinceLastJump = z5;
            this.newestSentByUserMessageId = l;
        }

        public static /* synthetic */ ChannelLoadedState copy$default(ChannelLoadedState channelLoadedState, boolean z2, boolean z3, boolean z4, boolean z5, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = channelLoadedState.isInitialMessagesLoaded;
            }
            if ((i & 2) != 0) {
                z3 = channelLoadedState.isOldestMessagesLoaded;
            }
            boolean z6 = z3;
            if ((i & 4) != 0) {
                z4 = channelLoadedState.isLoadingMessages;
            }
            boolean z7 = z4;
            if ((i & 8) != 0) {
                z5 = channelLoadedState.isTouchedSinceLastJump;
            }
            boolean z8 = z5;
            if ((i & 16) != 0) {
                l = channelLoadedState.newestSentByUserMessageId;
            }
            return channelLoadedState.copy(z2, z6, z7, z8, l);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsInitialMessagesLoaded() {
            return this.isInitialMessagesLoaded;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsOldestMessagesLoaded() {
            return this.isOldestMessagesLoaded;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsLoadingMessages() {
            return this.isLoadingMessages;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsTouchedSinceLastJump() {
            return this.isTouchedSinceLastJump;
        }

        /* renamed from: component5, reason: from getter */
        public final Long getNewestSentByUserMessageId() {
            return this.newestSentByUserMessageId;
        }

        public final ChannelLoadedState copy(boolean isInitialMessagesLoaded, boolean isOldestMessagesLoaded, boolean isLoadingMessages, boolean isTouchedSinceLastJump, Long newestSentByUserMessageId) {
            return new ChannelLoadedState(isInitialMessagesLoaded, isOldestMessagesLoaded, isLoadingMessages, isTouchedSinceLastJump, newestSentByUserMessageId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelLoadedState)) {
                return false;
            }
            ChannelLoadedState channelLoadedState = (ChannelLoadedState) other;
            return this.isInitialMessagesLoaded == channelLoadedState.isInitialMessagesLoaded && this.isOldestMessagesLoaded == channelLoadedState.isOldestMessagesLoaded && this.isLoadingMessages == channelLoadedState.isLoadingMessages && this.isTouchedSinceLastJump == channelLoadedState.isTouchedSinceLastJump && Intrinsics3.areEqual(this.newestSentByUserMessageId, channelLoadedState.newestSentByUserMessageId);
        }

        public final Long getNewestSentByUserMessageId() {
            return this.newestSentByUserMessageId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.isInitialMessagesLoaded;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.isOldestMessagesLoaded;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            ?? r22 = this.isLoadingMessages;
            int i4 = r22;
            if (r22 != 0) {
                i4 = 1;
            }
            int i5 = (i3 + i4) * 31;
            boolean z3 = this.isTouchedSinceLastJump;
            int i6 = (i5 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            Long l = this.newestSentByUserMessageId;
            return i6 + (l != null ? l.hashCode() : 0);
        }

        public final boolean isInitialMessagesLoaded() {
            return this.isInitialMessagesLoaded;
        }

        public final boolean isLoadingMessages() {
            return this.isLoadingMessages;
        }

        public final boolean isOldestMessagesLoaded() {
            return this.isOldestMessagesLoaded;
        }

        public final boolean isTouchedSinceLastJump() {
            return this.isTouchedSinceLastJump;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("ChannelLoadedState(isInitialMessagesLoaded=");
            sbM833U.append(this.isInitialMessagesLoaded);
            sbM833U.append(", isOldestMessagesLoaded=");
            sbM833U.append(this.isOldestMessagesLoaded);
            sbM833U.append(", isLoadingMessages=");
            sbM833U.append(this.isLoadingMessages);
            sbM833U.append(", isTouchedSinceLastJump=");
            sbM833U.append(this.isTouchedSinceLastJump);
            sbM833U.append(", newestSentByUserMessageId=");
            return outline.m819G(sbM833U, this.newestSentByUserMessageId, ")");
        }

        public /* synthetic */ ChannelLoadedState(boolean z2, boolean z3, boolean z4, boolean z5, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? false : z4, (i & 8) == 0 ? z5 : false, (i & 16) != 0 ? null : l);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    public static final class Companion {
        private Companion() {
        }

        public final boolean isScrollToAction(long targetMessageId) {
            return targetMessageId == 0 || targetMessageId == 1;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    /* renamed from: com.discord.stores.StoreMessagesLoader$getMessagesLoadedState$1 */
    public static final class C62511<T, R> implements Func1<Map<Long, ? extends ChannelLoadedState>, ChannelLoadedState> {
        public final /* synthetic */ long $channelId;

        public C62511(long j) {
            this.$channelId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ ChannelLoadedState call(Map<Long, ? extends ChannelLoadedState> map) {
            return call2((Map<Long, ChannelLoadedState>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ChannelLoadedState call2(Map<Long, ChannelLoadedState> map) {
            ChannelLoadedState channelLoadedState = map.get(Long.valueOf(this.$channelId));
            return channelLoadedState != null ? channelLoadedState : new ChannelLoadedState(false, false, false, false, null, 31, null);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    /* renamed from: com.discord.stores.StoreMessagesLoader$handleChannelSelected$1 */
    public static final class C62521 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
        public static final C62521 INSTANCE = new C62521();

        public C62521() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
            return invoke2(channelLoadedState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ChannelLoadedState invoke2(ChannelLoadedState channelLoadedState) {
            Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
            return ChannelLoadedState.copy$default(channelLoadedState, false, false, false, false, null, 23, null);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    /* renamed from: com.discord.stores.StoreMessagesLoader$handleLoadMessagesError$1 */
    public static final class C62531 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
        public static final C62531 INSTANCE = new C62531();

        public C62531() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
            return invoke2(channelLoadedState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ChannelLoadedState invoke2(ChannelLoadedState channelLoadedState) {
            Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
            return ChannelLoadedState.copy$default(channelLoadedState, false, false, false, false, null, 27, null);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    /* renamed from: com.discord.stores.StoreMessagesLoader$handleLoadedMessages$1 */
    public static final class C62541 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
        public final /* synthetic */ boolean $isAllLoaded;
        public final /* synthetic */ boolean $isAppendingTop;
        public final /* synthetic */ boolean $isInitial;
        public final /* synthetic */ List $messages;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62541(boolean z2, boolean z3, boolean z4, List list) {
            super(1);
            this.$isInitial = z2;
            this.$isAppendingTop = z3;
            this.$isAllLoaded = z4;
            this.$messages = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
            return invoke2(channelLoadedState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ChannelLoadedState invoke2(ChannelLoadedState channelLoadedState) {
            Object next;
            Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
            boolean zIsInitialMessagesLoaded = this.$isInitial ? true : channelLoadedState.isInitialMessagesLoaded();
            boolean zIsOldestMessagesLoaded = (this.$isInitial || this.$isAppendingTop) ? this.$isAllLoaded : channelLoadedState.isOldestMessagesLoaded();
            Iterator it = this.$messages.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                User author = ((Message) next).getAuthor();
                if (author != null && author.getId() == StoreMessagesLoader.access$getStream$p(StoreMessagesLoader.this).getUsers().getMeSnapshot().getId()) {
                    break;
                }
            }
            Message message = (Message) next;
            return ChannelLoadedState.copy$default(channelLoadedState, zIsInitialMessagesLoaded, zIsOldestMessagesLoaded, false, false, message != null ? Long.valueOf(message.getId()) : null, 8, null);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    /* renamed from: com.discord.stores.StoreMessagesLoader$init$1 */
    public static final /* synthetic */ class C62551 extends FunctionReferenceImpl implements Function1<StoreChat.InteractionState, Unit> {
        public C62551(StoreMessagesLoader storeMessagesLoader) {
            super(1, storeMessagesLoader, StoreMessagesLoader.class, "handleChatInteraction", "handleChatInteraction(Lcom/discord/stores/StoreChat$InteractionState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreChat.InteractionState interactionState) {
            invoke2(interactionState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreChat.InteractionState interactionState) {
            Intrinsics3.checkNotNullParameter(interactionState, "p1");
            StoreMessagesLoader.access$handleChatInteraction((StoreMessagesLoader) this.receiver, interactionState);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    /* renamed from: com.discord.stores.StoreMessagesLoader$init$2 */
    public static final /* synthetic */ class C62562 extends FunctionReferenceImpl implements Function1<Set<? extends Long>, Unit> {
        public C62562(StoreMessagesLoader storeMessagesLoader) {
            super(1, storeMessagesLoader, StoreMessagesLoader.class, "handleChatDetached", "handleChatDetached(Ljava/util/Set;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Long> set) {
            invoke2((Set<Long>) set);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Set<Long> set) {
            Intrinsics3.checkNotNullParameter(set, "p1");
            StoreMessagesLoader.access$handleChatDetached((StoreMessagesLoader) this.receiver, set);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$1 */
    public static final class C62571 extends Lambda implements Function1<Message, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;

        /* compiled from: StoreMessagesLoader.kt */
        /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
                return invoke2(channelLoadedState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ChannelLoadedState invoke2(ChannelLoadedState channelLoadedState) {
                Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
                return ChannelLoadedState.copy$default(channelLoadedState, false, false, false, false, null, 29, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62571(long j, long j2) {
            super(1);
            this.$channelId = j;
            this.$messageId = j2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Message message) {
            invoke2(message);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final synchronized void invoke2(Message message) {
            if (message != null) {
                SerializedSubject serializedSubjectAccess$getScrollToSubject$p = StoreMessagesLoader.access$getScrollToSubject$p(StoreMessagesLoader.this);
                serializedSubjectAccess$getScrollToSubject$p.f27653k.onNext(Long.valueOf(message.getId()));
            } else {
                StoreMessagesLoader.access$channelLoadedStateUpdate(StoreMessagesLoader.this, this.$channelId, AnonymousClass1.INSTANCE);
                StoreMessagesLoader.tryLoadMessages$default(StoreMessagesLoader.this, 0L, true, false, false, Long.valueOf(this.$channelId), Long.valueOf(this.$messageId), 9, null);
            }
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$2 */
    public static final class C62582 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $channelId;

        /* compiled from: StoreMessagesLoader.kt */
        /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
                return invoke2(channelLoadedState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ChannelLoadedState invoke2(ChannelLoadedState channelLoadedState) {
                Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
                return ChannelLoadedState.copy$default(channelLoadedState, true, false, false, false, null, 30, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62582(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final synchronized void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            if (channel.getId() != StoreMessagesLoader.access$getSelectedChannelId$p(StoreMessagesLoader.this)) {
                StoreMessagesLoader.access$channelLoadedStateUpdate(StoreMessagesLoader.this, this.$channelId, AnonymousClass1.INSTANCE);
                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), channel, null, null, 6, null);
            }
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$3 */
    public static final class C62593 extends Lambda implements Function1<Long, Boolean> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62593(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
            return Boolean.valueOf(invoke2(l));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Long l) {
            return l != null && l.longValue() == this.$channelId;
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$4 */
    public static final class C62604<T, R> implements Func1<Long, Observable<? extends Message>> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;

        public C62604(long j, long j2) {
            this.$channelId = j;
            this.$messageId = j2;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Message> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Message> call2(Long l) {
            return StoreMessagesLoader.access$getStream$p(StoreMessagesLoader.this).getMessages().observeMessagesForChannel(this.$channelId, this.$messageId);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$5 */
    public static final class C62615 extends Lambda implements Function1<Message, Unit> {
        public final /* synthetic */ C62571 $handleTargetChannelSelected$1;

        /* compiled from: StoreMessagesLoader.kt */
        /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$5$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Message $message;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Message message) {
                super(0);
                this.$message = message;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C62615.this.$handleTargetChannelSelected$1.invoke2(this.$message);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62615(C62571 c62571) {
            super(1);
            this.$handleTargetChannelSelected$1 = c62571;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Message message) {
            invoke2(message);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Message message) {
            StoreMessagesLoader.access$getDispatcher$p(StoreMessagesLoader.this).schedule(new AnonymousClass1(message));
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$6 */
    public static final class C62626<T, R> implements Func1<Boolean, Observable<? extends Channel>> {
        public final /* synthetic */ long $channelId;

        public C62626(long j) {
            this.$channelId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Channel> call(Boolean bool) {
            return call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Channel> call2(Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isConnected");
            int i = bool.booleanValue() ? 1 : 3;
            Observable<R> observableM11083G = StoreMessagesLoader.access$getStream$p(StoreMessagesLoader.this).getChannels().observeChannel(this.$channelId).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
            return ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11083G, 1000 * i, false, 2, null);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$7 */
    public static final class C62637 extends Lambda implements Function1<Error, Unit> {
        public static final C62637 INSTANCE = new C62637();

        public C62637() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            Logger.w$default(AppLog.f14950g, "Dropped message jump action", null, 2, null);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    /* renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$8 */
    public static final /* synthetic */ class C62648 extends FunctionReferenceImpl implements Function1<Channel, Unit> {
        public final /* synthetic */ C62582 $handleTargetChannelResolved$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62648(C62582 c62582) {
            super(1, null, "handleTargetChannelResolved", "invoke(Lcom/discord/api/channel/Channel;)V", 0);
            this.$handleTargetChannelResolved$2 = c62582;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "p1");
            this.$handleTargetChannelResolved$2.invoke2(channel);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    /* renamed from: com.discord.stores.StoreMessagesLoader$requestNewestMessages$1 */
    public static final class C62651 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
        public static final C62651 INSTANCE = new C62651();

        public C62651() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
            return invoke2(channelLoadedState);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ChannelLoadedState invoke2(ChannelLoadedState channelLoadedState) {
            Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
            return ChannelLoadedState.copy$default(channelLoadedState, false, false, false, false, null, 30, null);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$1 */
    public static final class C62661 extends Lambda implements Function1<Long, Unit> {
        public C62661() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreMessagesLoader.tryLoadMessages$default(StoreMessagesLoader.this, 0L, false, false, true, null, null, 55, null);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$2 */
    public static final class C62672 extends Lambda implements Function1<Subscription, Unit> {
        public C62672() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            StoreMessagesLoader.access$setDelayLoadingMessagesSubscription$p(StoreMessagesLoader.this, subscription);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$3 */
    public static final class C62683 extends Lambda implements Function4<Long, Long, Long, Long, Unit> {

        /* compiled from: StoreMessagesLoader.kt */
        /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
                return invoke2(channelLoadedState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ChannelLoadedState invoke2(ChannelLoadedState channelLoadedState) {
                Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
                return ChannelLoadedState.copy$default(channelLoadedState, false, false, true, false, null, 27, null);
            }
        }

        /* compiled from: StoreMessagesLoader.kt */
        /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$3$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements Func1<List<? extends com.discord.api.message.Message>, List<? extends Message>> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ List<? extends Message> call(List<? extends com.discord.api.message.Message> list) {
                return call2((List<com.discord.api.message.Message>) list);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final List<Message> call2(List<com.discord.api.message.Message> list) {
                Intrinsics3.checkNotNullExpressionValue(list, "messages");
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new Message((com.discord.api.message.Message) it.next()));
                }
                return arrayList;
            }
        }

        /* compiled from: StoreMessagesLoader.kt */
        /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$3$3, reason: invalid class name */
        public static final class AnonymousClass3 extends Lambda implements Function1<List<? extends Message>, Unit> {
            public final /* synthetic */ Long $after;
            public final /* synthetic */ Long $before;
            public final /* synthetic */ long $channelId;
            public final /* synthetic */ Long $messageId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(long j, Long l, Long l2, Long l3) {
                super(1);
                this.$channelId = j;
                this.$messageId = l;
                this.$before = l2;
                this.$after = l3;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Message> list) {
                invoke2((List<Message>) list);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Message> list) {
                StoreMessagesLoader storeMessagesLoader = StoreMessagesLoader.this;
                Intrinsics3.checkNotNullExpressionValue(list, "it");
                long j = this.$channelId;
                Long l = this.$messageId;
                StoreMessagesLoader.access$handleLoadedMessages(storeMessagesLoader, list, j, l != null ? l.longValue() : 0L, this.$before, this.$after);
            }
        }

        /* compiled from: StoreMessagesLoader.kt */
        /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$3$4, reason: invalid class name */
        public static final class AnonymousClass4 extends Lambda implements Function1<Error, Unit> {
            public final /* synthetic */ long $channelId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass4(long j) {
                super(1);
                this.$channelId = j;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreMessagesLoader.access$handleLoadMessagesError(StoreMessagesLoader.this, this.$channelId);
            }
        }

        /* compiled from: StoreMessagesLoader.kt */
        /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$3$5, reason: invalid class name */
        public static final class AnonymousClass5 extends Lambda implements Function1<Subscription, Unit> {
            public AnonymousClass5() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
                invoke2(subscription);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Subscription subscription) {
                Intrinsics3.checkNotNullParameter(subscription, "it");
                StoreMessagesLoader.access$setLoadingMessagesSubscription$p(StoreMessagesLoader.this, subscription);
            }
        }

        public C62683() {
            super(4);
        }

        public static /* synthetic */ void invoke$default(C62683 c62683, long j, Long l, Long l2, Long l3, int i, Object obj) {
            c62683.invoke(j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : l3);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2, Long l3, Long l4) {
            invoke(l.longValue(), l2, l3, l4);
            return Unit.f27425a;
        }

        public final synchronized void invoke(long j, Long l, Long l2, Long l3) {
            Observable<List<com.discord.api.message.Message>> channelMessages;
            StoreMessagesLoader.access$channelLoadedStateUpdate(StoreMessagesLoader.this, j, AnonymousClass1.INSTANCE);
            if (l == null || l.longValue() != 1) {
                if (l == null || l.longValue() != 0) {
                    if (l != null) {
                        channelMessages = RestAPI.INSTANCE.getApi().getChannelMessagesAround(j, StoreMessagesLoader.access$getMessageRequestSize$p(StoreMessagesLoader.this), l.longValue());
                    }
                    SerializedSubject serializedSubjectAccess$getChannelMessagesLoadingSubject$p = StoreMessagesLoader.access$getChannelMessagesLoadingSubject$p(StoreMessagesLoader.this);
                    serializedSubjectAccess$getChannelMessagesLoadingSubject$p.f27653k.onNext(Boolean.TRUE);
                    Observable observableM11083G = ObservableExtensionsKt.restSubscribeOn(channelMessages, false).m11083G(AnonymousClass2.INSTANCE);
                    Intrinsics3.checkNotNullExpressionValue(observableM11083G, "messagesRequest\n        …messages.map(::Message) }");
                    Observable observableComputationLatest = ObservableExtensionsKt.computationLatest(observableM11083G);
                    Class<?> cls = StoreMessagesLoader.this.getClass();
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(j, l, l2, l3);
                    ObservableExtensionsKt.appSubscribe$default(observableComputationLatest, cls, (Context) null, new AnonymousClass5(), new AnonymousClass4(j), (Function0) null, (Function0) null, anonymousClass3, 50, (Object) null);
                }
            }
            channelMessages = RestAPI.INSTANCE.getApi().getChannelMessages(j, l2, l3, Integer.valueOf(StoreMessagesLoader.access$getMessageRequestSize$p(StoreMessagesLoader.this)));
            SerializedSubject serializedSubjectAccess$getChannelMessagesLoadingSubject$p2 = StoreMessagesLoader.access$getChannelMessagesLoadingSubject$p(StoreMessagesLoader.this);
            serializedSubjectAccess$getChannelMessagesLoadingSubject$p2.f27653k.onNext(Boolean.TRUE);
            Observable observableM11083G2 = ObservableExtensionsKt.restSubscribeOn(channelMessages, false).m11083G(AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11083G2, "messagesRequest\n        …messages.map(::Message) }");
            Observable observableComputationLatest2 = ObservableExtensionsKt.computationLatest(observableM11083G2);
            Class<?> cls2 = StoreMessagesLoader.this.getClass();
            AnonymousClass3 anonymousClass32 = new AnonymousClass3(j, l, l2, l3);
            ObservableExtensionsKt.appSubscribe$default(observableComputationLatest2, cls2, (Context) null, new AnonymousClass5(), new AnonymousClass4(j), (Function0) null, (Function0) null, anonymousClass32, 50, (Object) null);
        }
    }

    /* compiled from: StoreMessagesLoader.kt */
    /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$4 */
    public static final class C62694 extends Lambda implements Function4<Long, List<? extends Message>, Boolean, Boolean, Unit> {
        public final /* synthetic */ C62683 $loadMessages$3;

        /* compiled from: StoreMessagesLoader.kt */
        /* renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
                return invoke2(channelLoadedState);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final ChannelLoadedState invoke2(ChannelLoadedState channelLoadedState) {
                Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
                return ChannelLoadedState.copy$default(channelLoadedState, false, false, false, false, null, 27, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62694(C62683 c62683) {
            super(4);
            this.$loadMessages$3 = c62683;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Long l, List<? extends Message> list, Boolean bool, Boolean bool2) {
            invoke(l.longValue(), (List<Message>) list, bool.booleanValue(), bool2.booleanValue());
            return Unit.f27425a;
        }

        public final synchronized void invoke(long j, List<Message> list, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(list, "messages");
            if (list.isEmpty()) {
                StoreMessagesLoader.access$channelLoadedStateUpdate(StoreMessagesLoader.this, j, AnonymousClass1.INSTANCE);
                return;
            }
            if (z2) {
                C62683.invoke$default(this.$loadMessages$3, j, null, Long.valueOf(list.get(0).getId()), null, 10, null);
            } else if (z3) {
                C62683.invoke$default(this.$loadMessages$3, j, null, null, Long.valueOf(list.get(list.size() - 1).getId()), 6, null);
            }
        }
    }

    public StoreMessagesLoader(StoreStream storeStream, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.messageRequestSize = 50;
        this.channelMessageChunksSubject = new SerializedSubject<>(BehaviorSubject.m11129k0());
        HashMap<Long, ChannelLoadedState> map = new HashMap<>();
        this.channelLoadedStates = map;
        this.channelLoadedStateSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(new HashMap(map)));
        this.scrollToSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(null));
        this.channelMessagesLoadingSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(Boolean.FALSE));
        this.detachedChannels = Sets5.emptySet();
        this.backgrounded = true;
        this.loadingMessagesRetryDelayDefault = 1500L;
        this.loadingMessagesRetryJitter = 2000;
        this.loadingMessagesRetryDelayMillis = 1500L;
        this.loadingMessagesRetryMax = 30000;
    }

    public static final /* synthetic */ void access$channelLoadedStateUpdate(StoreMessagesLoader storeMessagesLoader, long j, Function1 function1) {
        storeMessagesLoader.channelLoadedStateUpdate(j, function1);
    }

    public static final /* synthetic */ SerializedSubject access$getChannelMessagesLoadingSubject$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.channelMessagesLoadingSubject;
    }

    public static final /* synthetic */ Subscription access$getDelayLoadingMessagesSubscription$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.delayLoadingMessagesSubscription;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.dispatcher;
    }

    public static final /* synthetic */ Subscription access$getLoadingMessagesSubscription$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.loadingMessagesSubscription;
    }

    public static final /* synthetic */ int access$getMessageRequestSize$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.messageRequestSize;
    }

    public static final /* synthetic */ SerializedSubject access$getScrollToSubject$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.scrollToSubject;
    }

    public static final /* synthetic */ long access$getSelectedChannelId$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.selectedChannelId;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreMessagesLoader storeMessagesLoader) {
        return storeMessagesLoader.stream;
    }

    public static final /* synthetic */ void access$handleChatDetached(StoreMessagesLoader storeMessagesLoader, Set set) {
        storeMessagesLoader.handleChatDetached(set);
    }

    public static final /* synthetic */ void access$handleChatInteraction(StoreMessagesLoader storeMessagesLoader, StoreChat.InteractionState interactionState) {
        storeMessagesLoader.handleChatInteraction(interactionState);
    }

    public static final /* synthetic */ void access$handleLoadMessagesError(StoreMessagesLoader storeMessagesLoader, long j) {
        storeMessagesLoader.handleLoadMessagesError(j);
    }

    public static final /* synthetic */ void access$handleLoadedMessages(StoreMessagesLoader storeMessagesLoader, List list, long j, long j2, Long l, Long l2) {
        storeMessagesLoader.handleLoadedMessages(list, j, j2, l, l2);
    }

    public static final /* synthetic */ void access$setDelayLoadingMessagesSubscription$p(StoreMessagesLoader storeMessagesLoader, Subscription subscription) {
        storeMessagesLoader.delayLoadingMessagesSubscription = subscription;
    }

    public static final /* synthetic */ void access$setLoadingMessagesSubscription$p(StoreMessagesLoader storeMessagesLoader, Subscription subscription) {
        storeMessagesLoader.loadingMessagesSubscription = subscription;
    }

    public static final /* synthetic */ void access$setSelectedChannelId$p(StoreMessagesLoader storeMessagesLoader, long j) {
        storeMessagesLoader.selectedChannelId = j;
    }

    private final synchronized void channelLoadedStateUpdate(long channelId, Function1<? super ChannelLoadedState, ChannelLoadedState> updater) {
        ChannelLoadedState channelLoadedState = this.channelLoadedStates.get(Long.valueOf(channelId));
        if (channelLoadedState == null) {
            channelLoadedState = new ChannelLoadedState(false, false, false, false, null, 31, null);
        }
        Intrinsics3.checkNotNullExpressionValue(channelLoadedState, "channelLoadedStates[chan…] ?: ChannelLoadedState()");
        this.channelLoadedStates.put(Long.valueOf(channelId), updater.invoke(channelLoadedState));
        SerializedSubject<Map<Long, ChannelLoadedState>, Map<Long, ChannelLoadedState>> serializedSubject = this.channelLoadedStateSubject;
        serializedSubject.f27653k.onNext(new HashMap(this.channelLoadedStates));
    }

    private final void channelLoadedStatesReset() {
        this.channelLoadedStates.clear();
        SerializedSubject<Map<Long, ChannelLoadedState>, Map<Long, ChannelLoadedState>> serializedSubject = this.channelLoadedStateSubject;
        serializedSubject.f27653k.onNext(new HashMap(this.channelLoadedStates));
        Subscription subscription = this.loadingMessagesSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.loadingMessagesRetryDelayMillis = this.loadingMessagesRetryDelayDefault;
        log("Disconnected, resetting all message loaded states.");
    }

    private final synchronized void handleChatDetached(Set<Long> detachedChannels) {
        this.detachedChannels = detachedChannels;
        log("Loaded detached channel state: " + detachedChannels);
        tryLoadMessages$default(this, 0L, false, true, false, null, null, 59, null);
    }

    private final synchronized void handleChatInteraction(StoreChat.InteractionState interactionState) {
        channelLoadedStateUpdate(interactionState.getChannelId(), new StoreMessagesLoader2(interactionState));
        this.interactionState = interactionState;
        tryLoadMessages$default(this, 0L, false, true, false, null, null, 59, null);
    }

    private final synchronized void handleLoadMessagesError(long channelId) {
        channelLoadedStateUpdate(channelId, C62531.INSTANCE);
        long j = this.loadingMessagesRetryDelayMillis;
        if (j < this.loadingMessagesRetryMax) {
            this.loadingMessagesRetryDelayMillis = (j * 2) + new Random().nextInt(this.loadingMessagesRetryJitter);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to load messages for channel [" + channelId + "], ");
        sb.append("retrying in " + this.loadingMessagesRetryDelayMillis + "ms");
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder()\n        …}ms\")\n        .toString()");
        log(string);
        tryLoadMessages$default(this, this.loadingMessagesRetryDelayMillis, false, false, false, null, null, 58, null);
    }

    private final synchronized void handleLoadedMessages(List<Message> messages, long channelId, long messageId, Long before, Long after) {
        Object next;
        boolean z2 = messages.size() < this.messageRequestSize;
        boolean z3 = after != null;
        boolean z4 = before != null;
        boolean z5 = !INSTANCE.isScrollToAction(messageId);
        boolean z6 = (z5 || z3 || z4) ? false : true;
        boolean z7 = z6 || (z3 && z2);
        channelLoadedStateUpdate(channelId, new C62541(z6, z4, z2, messages));
        this.channelMessagesLoadingSubject.f27653k.onNext(Boolean.FALSE);
        this.channelMessageChunksSubject.f27653k.onNext(new ChannelChunk(channelId, messages, z6, z7, z4, z5));
        boolean z8 = z6 && (messages.isEmpty() ^ true) && messageId == 1;
        if (z8) {
            this.scrollToSubject.f27653k.onNext(1L);
        } else if (z6) {
            this.scrollToSubject.f27653k.onNext(0L);
        }
        if (z5) {
            Iterator<T> it = messages.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (((Message) next).getId() == messageId) {
                        break;
                    }
                }
            }
            Message message = (Message) next;
            if (message == null) {
                StoreStream.INSTANCE.getReadStates().markAsRead(Long.valueOf(channelId));
            } else {
                this.scrollToSubject.f27653k.onNext(Long.valueOf(message.getId()));
            }
        }
        if (!z5 && !z8) {
            clearScrollTo();
        }
        log("Loaded " + messages.size() + " messages for channel [" + channelId + "], all loaded: " + z2 + '.');
        tryLoadMessages$default(this, this.loadingMessagesRetryDelayDefault, false, false, false, null, null, 58, null);
    }

    public static /* synthetic */ void handleLoadedMessages$default(StoreMessagesLoader storeMessagesLoader, List list, long j, long j2, Long l, Long l2, int i, Object obj) {
        storeMessagesLoader.handleLoadedMessages(list, j, (i & 4) != 0 ? 0L : j2, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2);
    }

    private final void log(String message) {
        AppLog.m8358i("[MessageLoader] " + message);
    }

    private final synchronized void tryLoadMessages(long delay, boolean force, boolean resetRetry, boolean resetDelay, Long targetChannelId, Long targetMessageId) {
        long jLongValue = targetChannelId != null ? targetChannelId.longValue() : this.selectedChannelId;
        Subscription subscription = this.delayLoadingMessagesSubscription;
        if (subscription != null && resetDelay) {
            if (subscription != null) {
                subscription.unsubscribe();
            }
            this.delayLoadingMessagesSubscription = null;
        }
        if (this.delayLoadingMessagesSubscription == null || force) {
            if (delay > 0) {
                Observable<Long> observableM11068d0 = Observable.m11068d0(delay, TimeUnit.MILLISECONDS);
                Intrinsics3.checkNotNullExpressionValue(observableM11068d0, "Observable\n          .ti…y, TimeUnit.MILLISECONDS)");
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(observableM11068d0), getClass(), (Context) null, new C62672(), (Function1) null, (Function0) null, (Function0) null, new C62661(), 58, (Object) null);
                return;
            }
            if (resetRetry) {
                this.loadingMessagesRetryDelayMillis = this.loadingMessagesRetryDelayDefault;
            }
            ChannelLoadedState channelLoadedState = this.channelLoadedStates.get(Long.valueOf(jLongValue));
            if (channelLoadedState == null || !channelLoadedState.isLoadingMessages() || force) {
                Subscription subscription2 = this.loadingMessagesSubscription;
                if (subscription2 != null) {
                    subscription2.unsubscribe();
                }
                if (jLongValue > 0 && !this.backgrounded && this.authed) {
                    C62683 c62683 = new C62683();
                    C62694 c62694 = new C62694(c62683);
                    if (targetMessageId != null) {
                        C62683.invoke$default(c62683, jLongValue, targetMessageId, null, null, 12, null);
                    } else if (channelLoadedState == null || !channelLoadedState.isInitialMessagesLoaded()) {
                        C62683.invoke$default(c62683, jLongValue, 0L, null, null, 12, null);
                    } else {
                        this.channelMessagesLoadingSubject.f27653k.onNext(Boolean.FALSE);
                        StoreChat.InteractionState interactionState = this.interactionState;
                        if (interactionState != null) {
                            boolean z2 = false;
                            boolean z3 = interactionState.getIsAtTop() && !channelLoadedState.isOldestMessagesLoaded();
                            if (interactionState.getIsAtBottom() && this.detachedChannels.contains(Long.valueOf(jLongValue))) {
                                z2 = true;
                            }
                            if (interactionState.getChannelId() == jLongValue && (z3 || z2)) {
                                channelLoadedStateUpdate(jLongValue, StoreMessagesLoader5.INSTANCE);
                                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationBuffered(ObservableExtensionsKt.takeSingleUntilTimeout$default(this.stream.getMessages().observeMessagesForChannel(jLongValue), 0L, false, 3, null)), interactionState.getClass(), (Context) null, (Function1) null, new StoreMessagesLoader4(this, channelLoadedState, jLongValue, c62694), (Function0) null, (Function0) null, new StoreMessagesLoader3(z3, z2, this, channelLoadedState, jLongValue, c62694), 54, (Object) null);
                            }
                        }
                    }
                }
            }
        }
    }

    public static /* synthetic */ void tryLoadMessages$default(StoreMessagesLoader storeMessagesLoader, long j, boolean z2, boolean z3, boolean z4, Long l, Long l2, int i, Object obj) {
        storeMessagesLoader.tryLoadMessages((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) == 0 ? z4 : false, (i & 16) != 0 ? null : l, (i & 32) == 0 ? l2 : null);
    }

    public final void clearScrollTo() {
        this.scrollToSubject.f27653k.onNext(null);
    }

    public final Observable<ChannelChunk> get() {
        return ObservableExtensionsKt.computationBuffered(this.channelMessageChunksSubject);
    }

    public final Observable<ChannelLoadedState> getMessagesLoadedState(long channelId) {
        Observable<R> observableM11083G = this.channelLoadedStateSubject.m11083G(new C62511(channelId));
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "channelLoadedStateSubjec…?: ChannelLoadedState() }");
        Observable<ChannelLoadedState> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11083G).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "channelLoadedStateSubjec…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Long> getScrollTo() {
        Observable<R> observableM11083G = this.scrollToSubject.m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        return ObservableExtensionsKt.computationLatest(observableM11083G);
    }

    public final synchronized void handleAuthToken(String authToken) {
        this.authed = authToken != null;
        tryLoadMessages$default(this, 0L, false, true, false, null, null, 59, null);
    }

    public final synchronized void handleBackgrounded(boolean backgrounded) {
        this.backgrounded = backgrounded;
        tryLoadMessages$default(this, 0L, false, true, false, null, null, 59, null);
    }

    @Store3
    public final synchronized void handleChannelSelected(long selectedChannelId) {
        channelLoadedStateUpdate(this.selectedChannelId, C62521.INSTANCE);
        this.selectedChannelId = selectedChannelId;
        tryLoadMessages$default(this, 0L, true, true, false, null, null, 57, null);
    }

    public final synchronized void handleConnected(boolean connected) {
        if (connected) {
            this.hasConnected = true;
        } else if (this.hasConnected) {
            channelLoadedStatesReset();
        }
        tryLoadMessages$default(this, 0L, false, true, this.hasConnected, null, null, 51, null);
    }

    @Store3
    public final synchronized void handleVoiceChannelJoined(long selectedVoiceChannelId) {
        tryLoadMessages$default(this, 0L, true, true, false, Long.valueOf(selectedVoiceChannelId), null, 41, null);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(this.stream.getChat().observeInteractionState()), StoreMessagesLoader.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C62551(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(this.stream.getMessages().getAllDetached(), StoreMessagesLoader.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C62562(this), 62, (Object) null);
    }

    public final synchronized void jumpToMessage(long channelId, long messageId) {
        if (messageId <= 0) {
            return;
        }
        C62571 c62571 = new C62571(channelId, messageId);
        C62582 c62582 = new C62582(channelId);
        Observable observableM11099Y = this.stream.getChannelsSelected().observeId().m11108k(C0879o.m177c(new C62593(channelId), -1L, 1000L, TimeUnit.MILLISECONDS)).m11099Y(new C62604(channelId, messageId));
        Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "stream\n        .channels…lId, messageId)\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11099Y, 0L, false, 3, null)), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C62615(c62571), 62, (Object) null);
        Observable observableM11082A = StoreConnectionOpen.observeConnectionOpen$default(this.stream.getConnectionOpen(), false, 1, null).m11100Z(1).m11082A(new C62626(channelId));
        Intrinsics3.checkNotNullExpressionValue(observableM11082A, "stream\n        .connecti…mes.ONE_SECOND)\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(observableM11082A), getClass(), (Context) null, (Function1) null, C62637.INSTANCE, (Function0) null, (Function0) null, new C62648(c62582), 54, (Object) null);
    }

    public final Observable<Boolean> observeChannelMessagesLoading() {
        Observable<Boolean> observableM11112r = ObservableExtensionsKt.computationBuffered(this.channelMessagesLoadingSubject).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "channelMessagesLoadingSu…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final synchronized void requestNewestMessages() {
        ChannelLoadedState channelLoadedState;
        if (!this.detachedChannels.contains(Long.valueOf(this.selectedChannelId)) && (channelLoadedState = this.channelLoadedStates.get(Long.valueOf(this.selectedChannelId))) != null && channelLoadedState.isInitialMessagesLoaded()) {
            this.scrollToSubject.f27653k.onNext(1L);
        } else {
            channelLoadedStateUpdate(this.selectedChannelId, C62651.INSTANCE);
            tryLoadMessages$default(this, 0L, true, false, false, null, 1L, 25, null);
        }
    }
}
