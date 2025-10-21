package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.message.Message;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StorePinnedMessages.kt */
/* loaded from: classes2.dex */
public final class StorePinnedMessages extends StoreV2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final Map<Long, List<Message>> pinnedMessages;
    private Map<Long, ? extends List<Message>> pinnedMessagesSnapshot;
    private final Set<Long> updatedChannelIds;

    /* compiled from: StorePinnedMessages.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Message access$getMessage(Companion companion, List list, long j) {
            return companion.getMessage(list, j);
        }

        public static final /* synthetic */ int access$getMessageIndex(Companion companion, List list, long j) {
            return companion.getMessageIndex(list, j);
        }

        private final Message getMessage(List<Message> channelMessages, long messageId) {
            Object obj = null;
            if (channelMessages == null) {
                return null;
            }
            Iterator<T> it = channelMessages.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((Message) next).getId() == messageId) {
                    obj = next;
                    break;
                }
            }
            return (Message) obj;
        }

        private final int getMessageIndex(List<Message> channelPinnedMessages, long messageId) {
            Iterator<Message> it = channelPinnedMessages.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next().getId() == messageId) {
                    return i;
                }
                i++;
            }
            return -1;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StorePinnedMessages.kt */
    /* renamed from: com.discord.stores.StorePinnedMessages$loadPinnedMessages$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<List<? extends com.discord.api.message.Message>, List<? extends Message>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
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

    /* compiled from: StorePinnedMessages.kt */
    /* renamed from: com.discord.stores.StorePinnedMessages$loadPinnedMessages$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends Message>, Unit> {
        public final /* synthetic */ long $channelId;

        /* compiled from: StorePinnedMessages.kt */
        /* renamed from: com.discord.stores.StorePinnedMessages$loadPinnedMessages$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$it = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                StorePinnedMessages storePinnedMessages = StorePinnedMessages.this;
                long j = anonymousClass2.$channelId;
                List list = this.$it;
                Intrinsics3.checkNotNullExpressionValue(list, "it");
                StorePinnedMessages.access$handlePinnedMessagesLoaded(storePinnedMessages, j, list);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Message> list) {
            invoke2((List<Message>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Message> list) {
            StorePinnedMessages.this.getDispatcher().schedule(new AnonymousClass1(list));
        }
    }

    /* compiled from: StorePinnedMessages.kt */
    /* renamed from: com.discord.stores.StorePinnedMessages$observeForChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends Message>> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends Message> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends Message> invoke2() {
            List<? extends Message> list = (List) StorePinnedMessages.access$getPinnedMessages$p(StorePinnedMessages.this).get(Long.valueOf(this.$channelId));
            return list != null ? list : Collections2.emptyList();
        }
    }

    /* compiled from: StorePinnedMessages.kt */
    /* renamed from: com.discord.stores.StorePinnedMessages$observePinnedMessage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Message> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$channelId = j;
            this.$messageId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Message invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Message invoke() {
            List listEmptyList = (List) StorePinnedMessages.access$getPinnedMessages$p(StorePinnedMessages.this).get(Long.valueOf(this.$channelId));
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            return Companion.access$getMessage(StorePinnedMessages.INSTANCE, listEmptyList, this.$messageId);
        }
    }

    public StorePinnedMessages(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.pinnedMessages = new HashMap();
        this.pinnedMessagesSnapshot = new HashMap();
        this.updatedChannelIds = new HashSet();
    }

    public static final /* synthetic */ Map access$getPinnedMessages$p(StorePinnedMessages storePinnedMessages) {
        return storePinnedMessages.pinnedMessages;
    }

    public static final /* synthetic */ void access$handlePinnedMessagesLoaded(StorePinnedMessages storePinnedMessages, long j, List list) {
        storePinnedMessages.handlePinnedMessagesLoaded(j, list);
    }

    @Store3
    private final void handlePinnedMessagesLoaded(long channelId, List<Message> messages) {
        this.pinnedMessages.put(Long.valueOf(channelId), _Collections.toMutableList((Collection) messages));
        this.updatedChannelIds.add(Long.valueOf(channelId));
        markChanged();
    }

    private final void loadPinnedMessages(long channelId) {
        if (this.pinnedMessagesSnapshot.containsKey(Long.valueOf(channelId))) {
            return;
        }
        Observable observableG = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getChannelPins(channelId), false, 1, null).G(AnonymousClass1.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "api\n        .getChannelP…messages.map(::Message) }");
        ObservableExtensionsKt.appSubscribe$default(observableG, StorePinnedMessages.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(channelId), 62, (Object) null);
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    @Store3
    public final void handleMessageDeleteBulk(long channelId, Collection<Long> messageIds) {
        Intrinsics3.checkNotNullParameter(messageIds, "messageIds");
        List<Message> list = this.pinnedMessages.get(Long.valueOf(channelId));
        if (list != null) {
            Iterator<Message> it = list.iterator();
            while (it.hasNext()) {
                if (messageIds.contains(Long.valueOf(it.next().getId()))) {
                    it.remove();
                    this.updatedChannelIds.add(Long.valueOf(channelId));
                }
            }
            if (!this.updatedChannelIds.isEmpty()) {
                markChanged();
            }
        }
    }

    @Store3
    public final void handleMessageUpdate(com.discord.api.message.Message updatedMessage) {
        UtcDateTime timestamp;
        Intrinsics3.checkNotNullParameter(updatedMessage, "updatedMessage");
        long channelId = updatedMessage.getChannelId();
        long id2 = updatedMessage.getId();
        boolean zAreEqual = Intrinsics3.areEqual(updatedMessage.getPinned(), Boolean.TRUE);
        List<Message> list = this.pinnedMessages.get(Long.valueOf(channelId));
        if (list != null) {
            int iAccess$getMessageIndex = Companion.access$getMessageIndex(INSTANCE, list, id2);
            if (iAccess$getMessageIndex != -1) {
                if (zAreEqual) {
                    list.set(iAccess$getMessageIndex, list.get(iAccess$getMessageIndex).merge(updatedMessage));
                } else {
                    list.remove(iAccess$getMessageIndex);
                }
                this.updatedChannelIds.add(Long.valueOf(channelId));
                markChanged();
                return;
            }
            if (zAreEqual) {
                UtcDateTime timestamp2 = updatedMessage.getTimestamp();
                long dateTimeMillis = 0;
                long dateTimeMillis2 = timestamp2 != null ? timestamp2.getDateTimeMillis() : 0L;
                int i = 0;
                if (list.size() > 0 && (timestamp = list.get(0).getTimestamp()) != null) {
                    dateTimeMillis = timestamp.getDateTimeMillis();
                }
                while (i < list.size() && dateTimeMillis2 < dateTimeMillis) {
                    i++;
                }
                list.add(i, new Message(updatedMessage));
                this.updatedChannelIds.add(Long.valueOf(channelId));
                markChanged();
            }
        }
    }

    public final Observable<List<Message>> observeForChannel(long channelId) {
        loadPinnedMessages(channelId);
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId), 14, null);
    }

    public final Observable<Message> observePinnedMessage(long channelId, long messageId) {
        Observable<Message> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(channelId, messageId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        HashMap map = new HashMap(this.pinnedMessages);
        Iterator<Long> it = this.updatedChannelIds.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            Long lValueOf = Long.valueOf(jLongValue);
            List listEmptyList = (List) map.get(Long.valueOf(jLongValue));
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            map.put(lValueOf, new ArrayList(listEmptyList));
        }
        this.pinnedMessagesSnapshot = map;
        this.updatedChannelIds.clear();
    }
}
