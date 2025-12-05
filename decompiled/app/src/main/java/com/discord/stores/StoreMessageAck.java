package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelReadState;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreMessagesLoader;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.collections.CollectionExtensions;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.threads.ThreadUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p512d0._Ranges;
import p507d0.p580t.Iterables2;
import p507d0.p580t.MapsJVM;
import p507d0.p580t.Sets5;
import p507d0.p580t._Sets;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func2;
import p658rx.functions.Func3;
import p658rx.functions.Func4;

/* compiled from: StoreMessageAck.kt */
/* loaded from: classes2.dex */
public final class StoreMessageAck extends StoreV2 {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<Long, Ack> acks;
    private final Persister<Map<Long, Ack>> acksPersister;
    private Map<Long, Ack> acksSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private final StoreStream stream;
    private Subscription threadSyncSubscription;

    /* compiled from: StoreMessageAck.kt */
    public static final /* data */ class Ack {
        private final boolean isLockedAck;
        private final long messageId;
        private final boolean viewed;

        public Ack(long j, boolean z2, boolean z3) {
            this.messageId = j;
            this.viewed = z2;
            this.isLockedAck = z3;
        }

        public static /* synthetic */ Ack copy$default(Ack ack, long j, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                j = ack.messageId;
            }
            if ((i & 2) != 0) {
                z2 = ack.viewed;
            }
            if ((i & 4) != 0) {
                z3 = ack.isLockedAck;
            }
            return ack.copy(j, z2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final long getMessageId() {
            return this.messageId;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getViewed() {
            return this.viewed;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsLockedAck() {
            return this.isLockedAck;
        }

        public final Ack copy(long messageId, boolean viewed, boolean isLockedAck) {
            return new Ack(messageId, viewed, isLockedAck);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ack)) {
                return false;
            }
            Ack ack = (Ack) other;
            return this.messageId == ack.messageId && this.viewed == ack.viewed && this.isLockedAck == ack.isLockedAck;
        }

        public final long getMessageId() {
            return this.messageId;
        }

        public final boolean getViewed() {
            return this.viewed;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iM3a = C0002b.m3a(this.messageId) * 31;
            boolean z2 = this.viewed;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iM3a + i) * 31;
            boolean z3 = this.isLockedAck;
            return i2 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isLockedAck() {
            return this.isLockedAck;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Ack(messageId=");
            sbM833U.append(this.messageId);
            sbM833U.append(", viewed=");
            sbM833U.append(this.viewed);
            sbM833U.append(", isLockedAck=");
            return outline.m827O(sbM833U, this.isLockedAck, ")");
        }

        public Ack(ModelReadState modelReadState, boolean z2, boolean z3) {
            this(modelReadState != null ? modelReadState.getLastMessageId() : 0L, z2, z3);
        }
    }

    /* compiled from: StoreMessageAck.kt */
    public static final class Companion {

        /* compiled from: StoreMessageAck.kt */
        public static abstract class ThreadAckState {

            /* compiled from: StoreMessageAck.kt */
            public static final class NotThread extends ThreadAckState {
                public static final NotThread INSTANCE = new NotThread();

                private NotThread() {
                    super(null);
                }
            }

            /* compiled from: StoreMessageAck.kt */
            public static final /* data */ class Thread extends ThreadAckState {
                private final boolean canAckThread;

                public Thread(boolean z2) {
                    super(null);
                    this.canAckThread = z2;
                }

                public static /* synthetic */ Thread copy$default(Thread thread, boolean z2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        z2 = thread.canAckThread;
                    }
                    return thread.copy(z2);
                }

                /* renamed from: component1, reason: from getter */
                public final boolean getCanAckThread() {
                    return this.canAckThread;
                }

                public final Thread copy(boolean canAckThread) {
                    return new Thread(canAckThread);
                }

                public boolean equals(Object other) {
                    if (this != other) {
                        return (other instanceof Thread) && this.canAckThread == ((Thread) other).canAckThread;
                    }
                    return true;
                }

                public final boolean getCanAckThread() {
                    return this.canAckThread;
                }

                public int hashCode() {
                    boolean z2 = this.canAckThread;
                    if (z2) {
                        return 1;
                    }
                    return z2 ? 1 : 0;
                }

                public String toString() {
                    return outline.m827O(outline.m833U("Thread(canAckThread="), this.canAckThread, ")");
                }
            }

            private ThreadAckState() {
            }

            public /* synthetic */ ThreadAckState(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Companion() {
        }

        public final boolean isNonThreadChannel(ThreadAckState threadAckState) {
            return threadAckState instanceof ThreadAckState.NotThread;
        }

        public final boolean isThreadAndAbleToAck(ThreadAckState threadAckState) {
            return (threadAckState instanceof ThreadAckState.Thread) && ((ThreadAckState.Thread) threadAckState).getCanAckThread();
        }

        public final boolean isThreadAndUnableToAck(ThreadAckState threadAckState) {
            return (threadAckState instanceof ThreadAckState.Thread) && !((ThreadAckState.Thread) threadAckState).getCanAckThread();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreMessageAck.kt */
    public static final /* data */ class PendingAck {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final PendingAck EMPTY = new PendingAck(0, new Ack(0L, false, false));
        private final Ack ack;
        private final long channelId;

        /* compiled from: StoreMessageAck.kt */
        public static final class Companion {
            private Companion() {
            }

            public final PendingAck getEMPTY() {
                return PendingAck.access$getEMPTY$cp();
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public PendingAck(long j, Ack ack) {
            Intrinsics3.checkNotNullParameter(ack, "ack");
            this.channelId = j;
            this.ack = ack;
        }

        public static final /* synthetic */ PendingAck access$getEMPTY$cp() {
            return EMPTY;
        }

        public static /* synthetic */ PendingAck copy$default(PendingAck pendingAck, long j, Ack ack, int i, Object obj) {
            if ((i & 1) != 0) {
                j = pendingAck.channelId;
            }
            if ((i & 2) != 0) {
                ack = pendingAck.ack;
            }
            return pendingAck.copy(j, ack);
        }

        /* renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component2, reason: from getter */
        public final Ack getAck() {
            return this.ack;
        }

        public final PendingAck copy(long channelId, Ack ack) {
            Intrinsics3.checkNotNullParameter(ack, "ack");
            return new PendingAck(channelId, ack);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PendingAck)) {
                return false;
            }
            PendingAck pendingAck = (PendingAck) other;
            return this.channelId == pendingAck.channelId && Intrinsics3.areEqual(this.ack, pendingAck.ack);
        }

        public final Ack getAck() {
            return this.ack;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public int hashCode() {
            int iM3a = C0002b.m3a(this.channelId) * 31;
            Ack ack = this.ack;
            return iM3a + (ack != null ? ack.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("PendingAck(channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", ack=");
            sbM833U.append(this.ack);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: StoreMessageAck.kt */
    /* renamed from: com.discord.stores.StoreMessageAck$ack$1 */
    public static final class C61971 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ boolean $clearLock;
        public final /* synthetic */ boolean $isLockedAck;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61971(long j, boolean z2, boolean z3) {
            super(0);
            this.$channelId = j;
            this.$isLockedAck = z2;
            this.$clearLock = z3;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Channel channelFindChannelByIdInternal$app_productionGoogleRelease = StoreMessageAck.access$getStream$p(StoreMessageAck.this).getChannels().findChannelByIdInternal$app_productionGoogleRelease(this.$channelId);
            if (channelFindChannelByIdInternal$app_productionGoogleRelease != null) {
                if (channelFindChannelByIdInternal$app_productionGoogleRelease.getType() != 4) {
                    StoreMessageAck.access$internalAck(StoreMessageAck.this, channelFindChannelByIdInternal$app_productionGoogleRelease, this.$isLockedAck, this.$clearLock);
                    return;
                }
                Iterator<T> it = StoreMessageAck.access$getStream$p(StoreMessageAck.this).getChannels().findChannelsByCategoryInternal$app_productionGoogleRelease(channelFindChannelByIdInternal$app_productionGoogleRelease.getGuildId(), channelFindChannelByIdInternal$app_productionGoogleRelease.getId()).iterator();
                while (it.hasNext()) {
                    StoreMessageAck.access$internalAck(StoreMessageAck.this, (Channel) it.next(), this.$isLockedAck, this.$clearLock);
                }
            }
        }
    }

    /* compiled from: StoreMessageAck.kt */
    /* renamed from: com.discord.stores.StoreMessageAck$getPendingAck$1 */
    public static final class C61981 extends Lambda implements Function2<Ack, Long, Boolean> {
        public final /* synthetic */ boolean $clearLock;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61981(boolean z2) {
            super(2);
            this.$clearLock = z2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Boolean invoke(Ack ack, Long l) {
            return Boolean.valueOf(invoke(ack, l.longValue()));
        }

        public final boolean invoke(Ack ack, long j) {
            boolean zIsNewer = MessageUtils.isNewer(ack != null ? Long.valueOf(ack.getMessageId()) : null, Long.valueOf(j));
            boolean z2 = ack == null || !ack.isLockedAck();
            if (zIsNewer) {
                return this.$clearLock || z2;
            }
            return false;
        }
    }

    /* compiled from: StoreMessageAck.kt */
    /* renamed from: com.discord.stores.StoreMessageAck$getPendingAck$2 */
    public static final class C61992<T, R> implements Func1<Long, Observable<? extends PendingAck>> {
        public final /* synthetic */ boolean $isLockedAck;
        public final /* synthetic */ C61981 $isUpdateRequired$1;

        /* compiled from: StoreMessageAck.kt */
        /* renamed from: com.discord.stores.StoreMessageAck$getPendingAck$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Ack, Long, Companion.ThreadAckState, PendingAck> {
            public final /* synthetic */ Long $channelId;

            public AnonymousClass1(Long l) {
                this.$channelId = l;
            }

            @Override // p658rx.functions.Func3
            public /* bridge */ /* synthetic */ PendingAck call(Ack ack, Long l, Companion.ThreadAckState threadAckState) {
                return call2(ack, l, threadAckState);
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
            
                if (r8.invoke(r6, r7.longValue()) != false) goto L14;
             */
            /* renamed from: call, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final PendingAck call2(Ack ack, Long l, Companion.ThreadAckState threadAckState) {
                Companion companion = StoreMessageAck.INSTANCE;
                if (companion.isNonThreadChannel(threadAckState) || companion.isThreadAndAbleToAck(threadAckState)) {
                    C61992 c61992 = C61992.this;
                    if (!c61992.$isLockedAck) {
                        C61981 c61981 = c61992.$isUpdateRequired$1;
                        Intrinsics3.checkNotNullExpressionValue(l, "mostRecentMessageId");
                    }
                    Long l2 = this.$channelId;
                    Intrinsics3.checkNotNullExpressionValue(l2, "channelId");
                    long jLongValue = l2.longValue();
                    Intrinsics3.checkNotNullExpressionValue(l, "mostRecentMessageId");
                    return new PendingAck(jLongValue, new Ack(l.longValue(), true, C61992.this.$isLockedAck));
                }
                return PendingAck.INSTANCE.getEMPTY();
            }
        }

        public C61992(boolean z2, C61981 c61981) {
            this.$isLockedAck = z2;
            this.$isUpdateRequired$1 = c61981;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends PendingAck> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends PendingAck> call2(Long l) {
            if (l.longValue() <= 0) {
                return new ScalarSynchronousObservable(PendingAck.INSTANCE.getEMPTY());
            }
            StoreMessageAck messageAck = StoreMessageAck.access$getStream$p(StoreMessageAck.this).getMessageAck();
            Intrinsics3.checkNotNullExpressionValue(l, "channelId");
            return Observable.m11075i(messageAck.observeForChannel(l.longValue()), StoreMessageAck.access$getStream$p(StoreMessageAck.this).getMessagesMostRecent().observeRecentMessageIds(l.longValue()), StoreMessageAck.access$observeThreadAckState(StoreMessageAck.this, l.longValue()), new AnonymousClass1(l));
        }
    }

    /* compiled from: StoreMessageAck.kt */
    /* renamed from: com.discord.stores.StoreMessageAck$handleConnectionOpen$3 */
    public static final class C62003 extends Lambda implements Function1<Subscription, Unit> {
        public C62003() {
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
            StoreMessageAck.access$setThreadSyncSubscription$p(StoreMessageAck.this, subscription);
        }
    }

    /* compiled from: StoreMessageAck.kt */
    /* renamed from: com.discord.stores.StoreMessageAck$handleConnectionOpen$4 */
    public static final class C62014 extends Lambda implements Function1<Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>>, Unit> {

        /* compiled from: StoreMessageAck.kt */
        /* renamed from: com.discord.stores.StoreMessageAck$handleConnectionOpen$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Set $newThreadIds;
            public final /* synthetic */ Set $oldThreadIds;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Set set, Set set2) {
                super(0);
                this.$oldThreadIds = set;
                this.$newThreadIds = set2;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessageAck.access$updateThreadAcks(StoreMessageAck.this, this.$oldThreadIds, this.$newThreadIds);
            }
        }

        public C62014() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>> tuples2) {
            invoke2((Tuples2<? extends Set<Long>, ? extends Set<Long>>) tuples2);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<? extends Set<Long>, ? extends Set<Long>> tuples2) {
            Intrinsics3.checkNotNullParameter(tuples2, "<name for destructuring parameter 0>");
            StoreMessageAck.access$getDispatcher$p(StoreMessageAck.this).schedule(new AnonymousClass1(tuples2.component1(), tuples2.component2()));
        }
    }

    /* compiled from: StoreMessageAck.kt */
    /* renamed from: com.discord.stores.StoreMessageAck$init$1 */
    public static final class C62021<T, R> implements Func1<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends Long>> {

        /* compiled from: StoreMessageAck.kt */
        /* renamed from: com.discord.stores.StoreMessageAck$init$1$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<StoreMessagesLoader.ChannelLoadedState, Boolean> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Boolean call(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
                return call2(channelLoadedState);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(StoreMessagesLoader.ChannelLoadedState channelLoadedState) {
                return Boolean.valueOf(channelLoadedState.isInitialMessagesLoaded() && !channelLoadedState.isLoadingMessages());
            }
        }

        /* compiled from: StoreMessageAck.kt */
        /* renamed from: com.discord.stores.StoreMessageAck$init$1$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements Func1<StoreChat.InteractionState, Boolean> {
            public final /* synthetic */ StoreChannelsSelected.ResolvedSelectedChannel $selectedChannel;

            public AnonymousClass2(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
                this.$selectedChannel = resolvedSelectedChannel;
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Boolean call(StoreChat.InteractionState interactionState) {
                return call2(interactionState);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(StoreChat.InteractionState interactionState) {
                return Boolean.valueOf(interactionState.getChannelId() == this.$selectedChannel.getId());
            }
        }

        /* compiled from: StoreMessageAck.kt */
        /* renamed from: com.discord.stores.StoreMessageAck$init$1$3, reason: invalid class name */
        public static final class AnonymousClass3<T1, T2, T3, T4, R> implements Func4<Set<? extends Long>, Boolean, StoreChat.InteractionState, Ack, Long> {
            public final /* synthetic */ StoreChannelsSelected.ResolvedSelectedChannel $selectedChannel;

            public AnonymousClass3(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
                this.$selectedChannel = resolvedSelectedChannel;
            }

            @Override // p658rx.functions.Func4
            public /* bridge */ /* synthetic */ Long call(Set<? extends Long> set, Boolean bool, StoreChat.InteractionState interactionState, Ack ack) {
                return call2((Set<Long>) set, bool, interactionState, ack);
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
            /* renamed from: call, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Long call2(Set<Long> set, Boolean bool, StoreChat.InteractionState interactionState, Ack ack) {
                long channelId;
                Channel maybeChannel = this.$selectedChannel.getMaybeChannel();
                boolean z2 = maybeChannel != null && ChannelUtils.m7691o(maybeChannel);
                if (interactionState.isAtBottomIgnoringTouch()) {
                    Intrinsics3.checkNotNullExpressionValue(bool, "isLoadingSettled");
                    channelId = (!bool.booleanValue() || set.contains(Long.valueOf(interactionState.getChannelId())) || z2 || (ack != null && ack.isLockedAck())) ? 0L : interactionState.getChannelId();
                }
                return Long.valueOf(channelId);
            }
        }

        public C62021() {
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Long> call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
            return call2(resolvedSelectedChannel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Long> call2(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
            return Observable.m11073h(StoreMessageAck.access$getStream$p(StoreMessageAck.this).getMessages().getAllDetached().m11110p(50L, TimeUnit.MILLISECONDS), StoreMessageAck.access$getStream$p(StoreMessageAck.this).getMessagesLoader().getMessagesLoadedState(resolvedSelectedChannel.getId()).m11083G(AnonymousClass1.INSTANCE).m11112r(), StoreMessageAck.access$getStream$p(StoreMessageAck.this).getChat().observeInteractionState().m11118y(new AnonymousClass2(resolvedSelectedChannel)), StoreMessageAck.access$getStream$p(StoreMessageAck.this).getMessageAck().observeForChannel(resolvedSelectedChannel.getId()), new AnonymousClass3(resolvedSelectedChannel));
        }
    }

    /* compiled from: StoreMessageAck.kt */
    /* renamed from: com.discord.stores.StoreMessageAck$markUnread$1 */
    public static final class C62031<T, R> implements Func1<List<? extends Message>, Boolean> {
        public static final C62031 INSTANCE = new C62031();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(List<? extends Message> list) {
            return call2((List<Message>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(List<Message> list) {
            Intrinsics3.checkNotNullExpressionValue(list, "it");
            return Boolean.valueOf(!list.isEmpty());
        }
    }

    /* compiled from: StoreMessageAck.kt */
    /* renamed from: com.discord.stores.StoreMessageAck$markUnread$2 */
    public static final class C62042<T1, T2, R> implements Func2<List<? extends Message>, Companion.ThreadAckState, Tuples2<? extends List<? extends Message>, ? extends Companion.ThreadAckState>> {
        public static final C62042 INSTANCE = new C62042();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ Tuples2<? extends List<? extends Message>, ? extends Companion.ThreadAckState> call(List<? extends Message> list, Companion.ThreadAckState threadAckState) {
            return call2((List<Message>) list, threadAckState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Tuples2<List<Message>, Companion.ThreadAckState> call2(List<Message> list, Companion.ThreadAckState threadAckState) {
            return new Tuples2<>(list, threadAckState);
        }
    }

    /* compiled from: StoreMessageAck.kt */
    /* renamed from: com.discord.stores.StoreMessageAck$markUnread$3 */
    public static final class C62053 extends Lambda implements Function1<Tuples2<? extends List<? extends Message>, ? extends Companion.ThreadAckState>, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;

        /* compiled from: StoreMessageAck.kt */
        /* renamed from: com.discord.stores.StoreMessageAck$markUnread$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $channelMessages;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$channelMessages = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Object obj;
                List list = this.$channelMessages;
                ArrayList arrayListM840a0 = outline.m840a0(list, "channelMessages");
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((Message) next).getId() < C62053.this.$messageId) {
                        arrayListM840a0.add(next);
                    }
                }
                Iterator it2 = arrayListM840a0.iterator();
                if (it2.hasNext()) {
                    Object next2 = it2.next();
                    if (it2.hasNext()) {
                        long id2 = ((Message) next2).getId();
                        do {
                            Object next3 = it2.next();
                            long id3 = ((Message) next3).getId();
                            if (id2 < id3) {
                                next2 = next3;
                                id2 = id3;
                            }
                        } while (it2.hasNext());
                    }
                    obj = next2;
                } else {
                    obj = null;
                }
                Message message = (Message) obj;
                List list2 = this.$channelMessages;
                ArrayList arrayListM840a02 = outline.m840a0(list2, "channelMessages");
                for (Object obj2 : list2) {
                    if (((Message) obj2).getId() >= C62053.this.$messageId) {
                        arrayListM840a02.add(obj2);
                    }
                }
                Ack ack = new Ack(message != null ? message.getId() : (((C62053.this.$messageId >>> 22) - 1) - SnowflakeUtils.DISCORD_EPOCH) << 22, false, true);
                C62053 c62053 = C62053.this;
                StoreMessageAck.access$updateAcks(StoreMessageAck.this, c62053.$channelId, ack);
                int iProcessMarkUnread$app_productionGoogleRelease = StoreStream.INSTANCE.getMentions().processMarkUnread$app_productionGoogleRelease(C62053.this.$channelId, arrayListM840a02);
                StoreMessageAck storeMessageAck = StoreMessageAck.this;
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new PendingAck(C62053.this.$channelId, ack));
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(PendingAck(channelId, ack))");
                StoreMessageAck.access$postPendingAck(storeMessageAck, scalarSynchronousObservable, iProcessMarkUnread$app_productionGoogleRelease);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62053(long j, long j2) {
            super(1);
            this.$messageId = j;
            this.$channelId = j2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends List<? extends Message>, ? extends Companion.ThreadAckState> tuples2) {
            invoke2((Tuples2<? extends List<Message>, ? extends Companion.ThreadAckState>) tuples2);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<? extends List<Message>, ? extends Companion.ThreadAckState> tuples2) {
            List<Message> listComponent1 = tuples2.component1();
            if (StoreMessageAck.INSTANCE.isThreadAndUnableToAck(tuples2.component2())) {
                return;
            }
            StoreMessageAck.access$getDispatcher$p(StoreMessageAck.this).schedule(new AnonymousClass1(listComponent1));
        }
    }

    /* compiled from: StoreMessageAck.kt */
    /* renamed from: com.discord.stores.StoreMessageAck$observeActiveThreadIdsWithPrevious$1 */
    public static final class C62061<T1, T2, R> implements Func2<Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>, Map<Long, ? extends Channel>, Set<? extends Long>> {
        public static final C62061 INSTANCE = new C62061();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread> map, Map<Long, ? extends Channel> map2) {
            return call2((Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>) map, (Map<Long, Channel>) map2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Set<Long> call2(Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> map, Map<Long, Channel> map2) {
            return _Sets.plus((Set) map.keySet(), (Iterable) map2.keySet());
        }
    }

    /* compiled from: StoreMessageAck.kt */
    /* renamed from: com.discord.stores.StoreMessageAck$observeActiveThreadIdsWithPrevious$2 */
    public static final class C62072<T1, T2, R> implements Func2<Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>>, Set<? extends Long>, Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>>> {
        public static final C62072 INSTANCE = new C62072();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>> call(Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>> tuples2, Set<? extends Long> set) {
            return call2((Tuples2<? extends Set<Long>, ? extends Set<Long>>) tuples2, (Set<Long>) set);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Tuples2<Set<Long>, Set<Long>> call2(Tuples2<? extends Set<Long>, ? extends Set<Long>> tuples2, Set<Long> set) {
            return new Tuples2<>(tuples2.getSecond(), set);
        }
    }

    /* compiled from: StoreMessageAck.kt */
    /* renamed from: com.discord.stores.StoreMessageAck$observeAll$1 */
    public static final class C62081 extends Lambda implements Function0<Map<Long, ? extends Ack>> {
        public C62081() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Ack> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Ack> invoke2() {
            return StoreMessageAck.this.getAll();
        }
    }

    /* compiled from: StoreMessageAck.kt */
    /* renamed from: com.discord.stores.StoreMessageAck$observeForChannel$1 */
    public static final class C62091 extends Lambda implements Function0<Ack> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62091(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Ack invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Ack invoke() {
            return StoreMessageAck.this.getForChannel(this.$channelId);
        }
    }

    /* compiled from: StoreMessageAck.kt */
    /* renamed from: com.discord.stores.StoreMessageAck$observeThreadAckState$1 */
    public static final class C62101 extends Lambda implements Function0<Companion.ThreadAckState> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62101(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Companion.ThreadAckState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Companion.ThreadAckState invoke() {
            StoreMessageAck storeMessageAck = StoreMessageAck.this;
            return StoreMessageAck.getThreadAckStateInternal$default(storeMessageAck, this.$channelId, StoreMessageAck.access$getStream$p(storeMessageAck).getThreadsActiveJoined().getActiveJoinedThreadsInternal$app_productionGoogleRelease(), StoreMessageAck.access$getStream$p(StoreMessageAck.this).getThreadsActive().getAllForumThreadsByIdInternal$app_productionGoogleRelease(), null, 8, null);
        }
    }

    /* compiled from: StoreMessageAck.kt */
    /* renamed from: com.discord.stores.StoreMessageAck$postPendingAck$1 */
    public static final class C62111 extends Lambda implements Function1<PendingAck, Unit> {
        public final /* synthetic */ int $mentionCount;

        /* compiled from: StoreMessageAck.kt */
        /* renamed from: com.discord.stores.StoreMessageAck$postPendingAck$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Ack $ack;
            public final /* synthetic */ long $channelId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(long j, Ack ack) {
                super(0);
                this.$channelId = j;
                this.$ack = ack;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMessageAck.access$updateAcks(StoreMessageAck.this, this.$channelId, this.$ack);
            }
        }

        /* compiled from: StoreMessageAck.kt */
        /* renamed from: com.discord.stores.StoreMessageAck$postPendingAck$1$2, reason: invalid class name */
        public static final class AnonymousClass2<T> implements Action1<Void> {
            public final /* synthetic */ long $channelId;

            public AnonymousClass2(long j) {
                this.$channelId = j;
            }

            @Override // p658rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Void r1) {
                call2(r1);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(Void r3) {
                StoreStream.INSTANCE.getAnalytics().ackMessage(this.$channelId);
            }
        }

        /* compiled from: StoreMessageAck.kt */
        /* renamed from: com.discord.stores.StoreMessageAck$postPendingAck$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends Lambda implements Function1<Void, Unit> {
            public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

            public AnonymousClass3() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62111(int i) {
            super(1);
            this.$mentionCount = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PendingAck pendingAck) {
            invoke2(pendingAck);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PendingAck pendingAck) {
            Intrinsics3.checkNotNullParameter(pendingAck, "pendingAck");
            long channelId = pendingAck.getChannelId();
            Ack ack = pendingAck.getAck();
            StoreMessageAck.access$getDispatcher$p(StoreMessageAck.this).schedule(new AnonymousClass1(channelId, ack));
            Observable observableM11115u = ObservableExtensionsKt.restSubscribeOn$default(StoreMessageAck.access$getRestAPI$p(StoreMessageAck.this).postChannelMessagesAck(channelId, Long.valueOf(ack.getMessageId()), new RestAPIParams.ChannelMessagesAck(Boolean.valueOf(ack.isLockedAck()), Integer.valueOf(this.$mentionCount))), false, 1, null).m11115u(new AnonymousClass2(channelId));
            Intrinsics3.checkNotNullExpressionValue(observableM11115u, "restAPI\n          .postC…).ackMessage(channelId) }");
            ObservableExtensionsKt.appSubscribe$default(observableM11115u, (Context) null, "REST: ack", (Function1) null, AnonymousClass3.INSTANCE, (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
        }
    }

    /* compiled from: StoreMessageAck.kt */
    /* renamed from: com.discord.stores.StoreMessageAck$postPendingAck$2 */
    public static final class C62122<T, R> implements Func1<PendingAck, Boolean> {
        public static final C62122 INSTANCE = new C62122();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(PendingAck pendingAck) {
            return call2(pendingAck);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(PendingAck pendingAck) {
            return Boolean.valueOf(!Intrinsics3.areEqual(pendingAck, PendingAck.INSTANCE.getEMPTY()));
        }
    }

    /* compiled from: StoreMessageAck.kt */
    /* renamed from: com.discord.stores.StoreMessageAck$postPendingAck$3 */
    public static final /* synthetic */ class C62133 extends FunctionReferenceImpl implements Function1<PendingAck, Unit> {
        public final /* synthetic */ C62111 $postChannelMessagesAck$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62133(C62111 c62111) {
            super(1, null, "postChannelMessagesAck", "invoke(Lcom/discord/stores/StoreMessageAck$PendingAck;)V", 0);
            this.$postChannelMessagesAck$1 = c62111;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PendingAck pendingAck) {
            invoke2(pendingAck);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PendingAck pendingAck) {
            Intrinsics3.checkNotNullParameter(pendingAck, "p1");
            this.$postChannelMessagesAck$1.invoke2(pendingAck);
        }
    }

    public StoreMessageAck(StoreStream storeStream, ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.stream = storeStream;
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        Persister<Map<Long, Ack>> persister = new Persister<>("MOST_RECENT_ACKS_V3", new HashMap());
        this.acksPersister = persister;
        this.acksSnapshot = persister.get();
        this.acks = new HashMap(this.acksSnapshot);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreMessageAck storeMessageAck) {
        return storeMessageAck.dispatcher;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreMessageAck storeMessageAck) {
        return storeMessageAck.restAPI;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreMessageAck storeMessageAck) {
        return storeMessageAck.stream;
    }

    public static final /* synthetic */ Subscription access$getThreadSyncSubscription$p(StoreMessageAck storeMessageAck) {
        return storeMessageAck.threadSyncSubscription;
    }

    public static final /* synthetic */ void access$internalAck(StoreMessageAck storeMessageAck, Channel channel, boolean z2, boolean z3) {
        storeMessageAck.internalAck(channel, z2, z3);
    }

    public static final /* synthetic */ Observable access$observeThreadAckState(StoreMessageAck storeMessageAck, long j) {
        return storeMessageAck.observeThreadAckState(j);
    }

    public static final /* synthetic */ void access$postPendingAck(StoreMessageAck storeMessageAck, Observable observable, int i) {
        storeMessageAck.postPendingAck(observable, i);
    }

    public static final /* synthetic */ void access$setThreadSyncSubscription$p(StoreMessageAck storeMessageAck, Subscription subscription) {
        storeMessageAck.threadSyncSubscription = subscription;
    }

    public static final /* synthetic */ void access$updateAcks(StoreMessageAck storeMessageAck, long j, Ack ack) {
        storeMessageAck.updateAcks(j, ack);
    }

    public static final /* synthetic */ void access$updateThreadAcks(StoreMessageAck storeMessageAck, Set set, Set set2) {
        storeMessageAck.updateThreadAcks(set, set2);
    }

    public static /* synthetic */ void ack$default(StoreMessageAck storeMessageAck, long j, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 4) != 0) {
            z3 = false;
        }
        storeMessageAck.ack(j, z2, z3);
    }

    private final Observable<PendingAck> getPendingAck(Observable<Long> observable, boolean z2, boolean z3) {
        Observable observableM11099Y = observable.m11099Y(new C61992(z2, new C61981(z3)));
        Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "switchMap { channelId ->…gAck.EMPTY)\n      }\n    }");
        return observableM11099Y;
    }

    @Store3
    private final Companion.ThreadAckState getThreadAckStateInternal(long channelId, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> activeAndJoinedThreads, Map<Long, Channel> activeForumThreads, StoreChannels storeChannels) {
        Channel channel = storeChannels.getChannel(channelId);
        if (channel != null) {
            return !ChannelUtils.m7673H(channel) ? Companion.ThreadAckState.NotThread.INSTANCE : (activeAndJoinedThreads.containsKey(Long.valueOf(channelId)) || activeForumThreads.containsKey(Long.valueOf(channelId))) ? new Companion.ThreadAckState.Thread(true) : new Companion.ThreadAckState.Thread(false);
        }
        return null;
    }

    public static /* synthetic */ Companion.ThreadAckState getThreadAckStateInternal$default(StoreMessageAck storeMessageAck, long j, Map map, Map map2, StoreChannels storeChannels, int i, Object obj) {
        if ((i & 8) != 0) {
            storeChannels = storeMessageAck.stream.getChannels();
        }
        return storeMessageAck.getThreadAckStateInternal(j, map, map2, storeChannels);
    }

    private final void internalAck(Channel channel, boolean isLockedAck, boolean clearLock) {
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(Long.valueOf(channel.getId()));
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(channel.id)");
        postPendingAck$default(this, ObservableExtensionsKt.takeSingleUntilTimeout$default(getPendingAck(scalarSynchronousObservable, isLockedAck, clearLock), 0L, false, 1, null), 0, 1, null);
    }

    private final Observable<Tuples2<Set<Long>, Set<Long>>> observeActiveThreadIdsWithPrevious() {
        Observable observableM11076j = Observable.m11076j(this.stream.getThreadsActiveJoined().observeAllActiveJoinedThreadsById(), this.stream.getThreadsActive().observeAllActiveForumThreadsById(), C62061.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…veForumThreads.keys\n    }");
        Observable<Tuples2<Set<Long>, Set<Long>>> observableM11091Q = ObservableExtensionsKt.leadingEdgeThrottle(observableM11076j, 1L, TimeUnit.SECONDS).m11112r().m11091Q(new Tuples2(Sets5.emptySet(), Sets5.emptySet()), C62072.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11091Q, "Observable.combineLatest…ond, threadIds)\n        }");
        return observableM11091Q;
    }

    private final Observable<Companion.ThreadAckState> observeThreadAckState(long channelId) {
        Observable<Companion.ThreadAckState> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.stream.getThreadsActiveJoined(), this.stream.getThreadsActive()}, false, null, null, new C62101(channelId), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    private final void postPendingAck(Observable<PendingAck> observable, int i) {
        C62111 c62111 = new C62111(i);
        Observable<PendingAck> observableM11118y = observable.m11118y(C62122.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11118y, "filter { it != PendingAck.EMPTY }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(observableM11118y), observable.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C62133(c62111), 62, (Object) null);
    }

    public static /* synthetic */ void postPendingAck$default(StoreMessageAck storeMessageAck, Observable observable, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        storeMessageAck.postPendingAck(observable, i);
    }

    @Store3
    private final void pruneAcks() {
        if (!this.stream.getGuilds().getUnavailableGuildsInternal$app_productionGoogleRelease().isEmpty()) {
            return;
        }
        Map<Long, Channel> channelsByIdInternal$app_productionGoogleRelease = this.stream.getChannels().getChannelsByIdInternal$app_productionGoogleRelease();
        Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> activeJoinedThreadsInternal$app_productionGoogleRelease = this.stream.getThreadsActiveJoined().getActiveJoinedThreadsInternal$app_productionGoogleRelease();
        Map<Long, Channel> allForumThreadsByIdInternal$app_productionGoogleRelease = this.stream.getThreadsActive().getAllForumThreadsByIdInternal$app_productionGoogleRelease();
        Iterator<Long> it = this.acks.keySet().iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            if (!channelsByIdInternal$app_productionGoogleRelease.containsKey(Long.valueOf(jLongValue)) && !activeJoinedThreadsInternal$app_productionGoogleRelease.containsKey(Long.valueOf(jLongValue)) && !allForumThreadsByIdInternal$app_productionGoogleRelease.containsKey(Long.valueOf(jLongValue))) {
                it.remove();
                markChanged();
            }
        }
    }

    @Store3
    private final void updateAcks(long channelId, Ack ackNewer) {
        if (INSTANCE.isThreadAndUnableToAck(getThreadAckStateInternal$default(this, channelId, this.stream.getThreadsActiveJoined().getActiveJoinedThreadsInternal$app_productionGoogleRelease(), this.stream.getThreadsActive().getAllForumThreadsByIdInternal$app_productionGoogleRelease(), null, 8, null))) {
            return;
        }
        Ack ack = this.acks.get(Long.valueOf(channelId));
        if (ack == null || MessageUtils.compareMessages(Long.valueOf(ack.getMessageId()), Long.valueOf(ackNewer.getMessageId())) != 0 || (ackNewer.isLockedAck() && !ack.isLockedAck())) {
            this.acks.put(Long.valueOf(channelId), ackNewer);
            markChanged();
        }
    }

    @Store3
    private final void updateThreadAcks(Set<Long> oldThreadIds, Set<Long> newThreadIds) {
        Channel channel;
        UtcDateTime joinTimestamp;
        if (this.stream.getGuilds().getUnavailableGuildsInternal$app_productionGoogleRelease().isEmpty()) {
            Iterator it = _Sets.minus((Set) oldThreadIds, (Iterable) newThreadIds).iterator();
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                if (this.acks.containsKey(Long.valueOf(jLongValue)) && this.acks.remove(Long.valueOf(jLongValue)) != null) {
                    markChanged();
                }
            }
        }
        Map<Long, Long> guildsJoinedAtInternal$app_productionGoogleRelease = this.stream.getGuilds().getGuildsJoinedAtInternal$app_productionGoogleRelease();
        Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> activeJoinedThreadsInternal$app_productionGoogleRelease = this.stream.getThreadsActiveJoined().getActiveJoinedThreadsInternal$app_productionGoogleRelease();
        Map<Long, Channel> allForumThreadsByIdInternal$app_productionGoogleRelease = this.stream.getThreadsActive().getAllForumThreadsByIdInternal$app_productionGoogleRelease();
        Iterator it2 = _Sets.minus((Set) newThreadIds, (Iterable) oldThreadIds).iterator();
        while (it2.hasNext()) {
            long jLongValue2 = ((Number) it2.next()).longValue();
            if (!this.acks.containsKey(Long.valueOf(jLongValue2))) {
                if (INSTANCE.isThreadAndAbleToAck(getThreadAckStateInternal$default(this, jLongValue2, activeJoinedThreadsInternal$app_productionGoogleRelease, allForumThreadsByIdInternal$app_productionGoogleRelease, null, 8, null))) {
                    StoreThreadsActiveJoined.ActiveJoinedThread activeJoinedThread = activeJoinedThreadsInternal$app_productionGoogleRelease.get(Long.valueOf(jLongValue2));
                    if (activeJoinedThread == null || (channel = activeJoinedThread.getChannel()) == null) {
                        channel = allForumThreadsByIdInternal$app_productionGoogleRelease.get(Long.valueOf(jLongValue2));
                    }
                    Channel channel2 = channel;
                    if (channel2 != null) {
                        this.acks.put(Long.valueOf(jLongValue2), new Ack((ThreadUtils.getThreadAckMessageTimestamp$default(ThreadUtils.INSTANCE, channel2, (Long) outline.m843c(channel2, guildsJoinedAtInternal$app_productionGoogleRelease), (activeJoinedThread == null || (joinTimestamp = activeJoinedThread.getJoinTimestamp()) == null) ? null : Long.valueOf(joinTimestamp.getDateTimeMillis()), null, 4, null) - SnowflakeUtils.DISCORD_EPOCH) << 22, false, false));
                        markChanged();
                    }
                }
            }
        }
    }

    public final void ack(long channelId, boolean isLockedAck, boolean clearLock) {
        this.dispatcher.schedule(new C61971(channelId, isLockedAck, clearLock));
    }

    public final Map<Long, Ack> getAll() {
        return this.acksSnapshot;
    }

    @Store3
    public final Map<Long, Ack> getAllInternal() {
        return this.acks;
    }

    public final Ack getForChannel(long channelId) {
        return getAll().get(Long.valueOf(channelId));
    }

    @Store3
    public final void handleChannelSelected() {
        for (Map.Entry<Long, Ack> entry : this.acks.entrySet()) {
            this.acks.put(Long.valueOf(entry.getKey().longValue()), Ack.copy$default(entry.getValue(), 0L, false, false, 3, null));
        }
        markChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00cc  */
    @Store3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleConnectionOpen(ModelPayload payload) {
        long dateTimeMillis;
        Object next;
        UtcDateTime joinedAt;
        Intrinsics3.checkNotNullParameter(payload, "payload");
        ModelPayload.VersionedReadStates readState = payload.getReadState();
        Intrinsics3.checkNotNullExpressionValue(readState, "payload.readState");
        if (!readState.isPartial()) {
            this.acks.clear();
        }
        Map<Long, Ack> map = this.acks;
        ModelPayload.VersionedReadStates readState2 = payload.getReadState();
        Intrinsics3.checkNotNullExpressionValue(readState2, "payload.readState");
        List<ModelReadState> entries = readState2.getEntries();
        Intrinsics3.checkNotNullExpressionValue(entries, "payload.readState.entries");
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(entries, 10)), 16));
        for (ModelReadState modelReadState : entries) {
            Tuples2 tuples2M10073to = Tuples.m10073to(Long.valueOf(modelReadState.getChannelId()), new Ack(modelReadState, false, false));
            linkedHashMap.put(tuples2M10073to.getFirst(), tuples2M10073to.getSecond());
        }
        map.putAll(linkedHashMap);
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            List<GuildMember> listM7875v = guild.m7875v();
            if (listM7875v != null) {
                Iterator<T> it = listM7875v.iterator();
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        if (((GuildMember) next).getUser().getId() == payload.getMe().getId()) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                GuildMember guildMember = (GuildMember) next;
                dateTimeMillis = (guildMember == null || (joinedAt = guildMember.getJoinedAt()) == null) ? 0L : joinedAt.getDateTimeMillis();
            }
            List<Channel> listM7860g = guild.m7860g();
            if (listM7860g != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : listM7860g) {
                    Channel channel = (Channel) obj;
                    Intrinsics3.checkNotNullParameter(channel, "$this$isTextyOrVoiceChannel");
                    if ((ChannelUtils.m7698v(channel) || ChannelUtils.m7675J(channel)) && !this.acks.containsKey(Long.valueOf(channel.getId()))) {
                        arrayList.add(obj);
                    }
                }
                ArrayList<Channel> arrayList2 = new ArrayList();
                for (Object obj2 : arrayList) {
                    if ((((Channel) obj2).getLastMessageId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH < dateTimeMillis) {
                        arrayList2.add(obj2);
                    }
                }
                for (Channel channel2 : arrayList2) {
                    this.acks.put(Long.valueOf(channel2.getId()), new Ack(channel2.getLastMessageId(), false, false));
                }
            }
        }
        pruneAcks();
        Subscription subscription = this.threadSyncSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(observeActiveThreadIdsWithPrevious()), StoreMessageAck.class, (Context) null, new C62003(), (Function1) null, (Function0) null, (Function0) null, new C62014(), 58, (Object) null);
        markChanged();
    }

    @Store3
    public final void handleGuildCreate() {
        pruneAcks();
    }

    @Store3
    public final void handleMessageAck(ModelReadState readState) {
        Intrinsics3.checkNotNullParameter(readState, "readState");
        updateAcks(readState.getChannelId(), new Ack(readState, false, false));
    }

    @Store3
    public final void handleMessageCreate(com.discord.api.message.Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        User author = message.getAuthor();
        if (author == null || author.getId() != this.stream.getUsers().getMe().getId()) {
            return;
        }
        updateAcks(message.getChannelId(), new Ack(message.getId(), false, false));
    }

    @Store3
    public final void handlePreLogout() {
        Subscription subscription = this.threadSyncSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.threadSyncSubscription = null;
    }

    @Store3
    public final void handleThreadCreateOrUpdate(Channel channel) {
        Channel channelFindChannelById;
        Intrinsics3.checkNotNullParameter(channel, "channel");
        boolean z2 = channel.getOwnerId() == this.stream.getUsers().getMe().getId();
        if (ChannelUtils.m7673H(channel) && !ChannelUtils.m7686j(channel) && z2 && (channelFindChannelById = this.stream.getChannels().findChannelById(channel.getParentId())) != null && ChannelUtils.m7693q(channelFindChannelById)) {
            updateAcks(channelFindChannelById.getId(), new Ack(channel.getId(), false, false));
        }
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        Observable<R> observableM11099Y = StoreStream.INSTANCE.getChannelsSelected().observeResolvedSelectedChannel().m11112r().m11099Y(new C62021());
        Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n        .get… 0L\n          }\n        }");
        Observable<Long> observableM11110p = ObservableExtensionsKt.computationLatest(observableM11099Y).m11110p(500L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableM11110p, "StoreStream\n        .get…0, TimeUnit.MILLISECONDS)");
        postPendingAck$default(this, getPendingAck(observableM11110p, false, false), 0, 1, null);
    }

    public final void markUnread(long channelId, long messageId) {
        Observable observableM11076j = Observable.m11076j(this.stream.getMessages().observeMessagesForChannel(channelId).m11118y(C62031.INSTANCE), observeThreadAckState(channelId), C62042.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11076j, "Observable\n        .comb…lMessages, threadState) }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout(observableM11076j, 10L, false), StoreMessageAck.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C62053(messageId, channelId), 62, (Object) null);
    }

    public final Observable<Map<Long, Ack>> observeAll() {
        Observable<Map<Long, Ack>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C62081(), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Ack> observeForChannel(long channelId) {
        Observable<Ack> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C62091(channelId), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        HashMap mapSnapshot$default = CollectionExtensions.snapshot$default(this.acks, 0, 0.0f, 3, null);
        this.acksSnapshot = mapSnapshot$default;
        Persister.set$default(this.acksPersister, mapSnapshot$default, false, 2, null);
    }
}
