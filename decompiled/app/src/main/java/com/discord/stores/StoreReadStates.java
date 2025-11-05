package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.a.d.a0;
import b.a.d.b0;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.application.Unread;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageAck;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import com.discord.utilities.time.Clock;
import d0.t.s;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.a;
import j0.k.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function9;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* compiled from: StoreReadStates.kt */
/* loaded from: classes2.dex */
public final class StoreReadStates extends Store {
    private final Clock clock;
    private final SerializedSubject<Boolean, Boolean> markAsRead;
    private final SerializedSubject<Set<Long>, Set<Long>> unreadChannelIds;
    private final SerializedSubject<Set<Long>, Set<Long>> unreadGuildIds;
    private final Persister<Unread> unreadMessageMarker;

    /* compiled from: StoreReadStates.kt */
    /* renamed from: com.discord.stores.StoreReadStates$clearMarker$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Unread, Unread> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Unread call(Unread unread) {
            return call2(unread);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Unread call2(Unread unread) {
            return unread.createWithEmptyCount();
        }
    }

    /* compiled from: StoreReadStates.kt */
    /* renamed from: com.discord.stores.StoreReadStates$clearMarker$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Unread, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unread unread) {
            invoke2(unread);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unread unread) {
            Persister persisterAccess$getUnreadMessageMarker$p = StoreReadStates.access$getUnreadMessageMarker$p(StoreReadStates.this);
            m.checkNotNullExpressionValue(unread, "newValue");
            Persister.set$default(persisterAccess$getUnreadMessageMarker$p, unread, false, 2, null);
        }
    }

    /* compiled from: StoreReadStates.kt */
    /* renamed from: com.discord.stores.StoreReadStates$computeUnreadChannelIds$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function9<Map<Long, ? extends Long>, Map<Long, ? extends Channel>, Map<Long, ? extends Long>, Map<Long, ? extends ModelNotificationSettings>, Map<Long, ? extends StoreMessageAck.Ack>, Map<Long, ? extends Long>, Long, Map<Long, ? extends Channel>, Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>, Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>>> {
        public AnonymousClass1(StoreReadStates storeReadStates) {
            super(9, storeReadStates, StoreReadStates.class, "computeUnreadIds", "computeUnreadIds(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;JLjava/util/Map;Ljava/util/Map;)Lkotlin/Pair;", 0);
        }

        @Override // kotlin.jvm.functions.Function9
        public /* bridge */ /* synthetic */ Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>> invoke(Map<Long, ? extends Long> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends Long> map3, Map<Long, ? extends ModelNotificationSettings> map4, Map<Long, ? extends StoreMessageAck.Ack> map5, Map<Long, ? extends Long> map6, Long l, Map<Long, ? extends Channel> map7, Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread> map8) {
            return invoke((Map<Long, Long>) map, (Map<Long, Channel>) map2, (Map<Long, Long>) map3, map4, (Map<Long, StoreMessageAck.Ack>) map5, (Map<Long, Long>) map6, l.longValue(), (Map<Long, Channel>) map7, (Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>) map8);
        }

        public final Pair<Set<Long>, Set<Long>> invoke(Map<Long, Long> map, Map<Long, Channel> map2, Map<Long, Long> map3, Map<Long, ? extends ModelNotificationSettings> map4, Map<Long, StoreMessageAck.Ack> map5, Map<Long, Long> map6, long j, Map<Long, Channel> map7, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> map8) {
            m.checkNotNullParameter(map, "p1");
            m.checkNotNullParameter(map2, "p2");
            m.checkNotNullParameter(map3, "p3");
            m.checkNotNullParameter(map4, "p4");
            m.checkNotNullParameter(map5, "p5");
            m.checkNotNullParameter(map6, "p6");
            m.checkNotNullParameter(map7, "p8");
            m.checkNotNullParameter(map8, "p9");
            return StoreReadStates.access$computeUnreadIds((StoreReadStates) this.receiver, map, map2, map3, map4, map5, map6, j, map7, map8);
        }
    }

    /* compiled from: StoreReadStates.kt */
    /* renamed from: com.discord.stores.StoreReadStates$computeUnreadChannelIds$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>>, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Set<? extends Long>, ? extends Set<? extends Long>> pair) {
            invoke2((Pair<? extends Set<Long>, ? extends Set<Long>>) pair);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Pair<? extends Set<Long>, ? extends Set<Long>> pair) {
            Set<Long> setComponent1 = pair.component1();
            Set<Long> setComponent2 = pair.component2();
            StoreReadStates.access$getUnreadChannelIds$p(StoreReadStates.this).k.onNext(setComponent1);
            StoreReadStates.access$getUnreadGuildIds$p(StoreReadStates.this).k.onNext(setComponent2);
        }
    }

    /* compiled from: StoreReadStates.kt */
    /* renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Long, Observable<Unread.Marker>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* compiled from: StoreReadStates.kt */
        /* renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02851<T, R> implements b<Map<Long, ? extends StoreMessageAck.Ack>, StoreMessageAck.Ack> {
            public final /* synthetic */ long $channelId;

            public C02851(long j) {
                this.$channelId = j;
            }

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ StoreMessageAck.Ack call(Map<Long, ? extends StoreMessageAck.Ack> map) {
                return call2((Map<Long, StoreMessageAck.Ack>) map);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final StoreMessageAck.Ack call2(Map<Long, StoreMessageAck.Ack> map) {
                return map.get(Long.valueOf(this.$channelId));
            }
        }

        /* compiled from: StoreReadStates.kt */
        /* renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$1$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements b<Map<Long, ? extends StoreMessageAck.Ack>, StoreMessageAck.Ack> {
            public final /* synthetic */ long $channelId;

            public AnonymousClass2(long j) {
                this.$channelId = j;
            }

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ StoreMessageAck.Ack call(Map<Long, ? extends StoreMessageAck.Ack> map) {
                return call2((Map<Long, StoreMessageAck.Ack>) map);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final StoreMessageAck.Ack call2(Map<Long, StoreMessageAck.Ack> map) {
                return map.get(Long.valueOf(this.$channelId));
            }
        }

        /* compiled from: StoreReadStates.kt */
        /* renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$1$3, reason: invalid class name */
        public static final class AnonymousClass3<T1, T2, T3, R> implements Func3<StoreMessageAck.Ack, StoreMessageAck.Ack, Long, Unread.Marker> {
            public final /* synthetic */ long $channelId;

            public AnonymousClass3(long j) {
                this.$channelId = j;
            }

            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ Unread.Marker call(StoreMessageAck.Ack ack, StoreMessageAck.Ack ack2, Long l) {
                return call2(ack, ack2, l);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Unread.Marker call2(StoreMessageAck.Ack ack, StoreMessageAck.Ack ack2, Long l) {
                return (ack2 == null || !ack2.isLockedAck()) ? ack != null ? new Unread.Marker(this.$channelId, ack.getMessageId(), l) : new Unread.Marker(this.$channelId, 0L, l) : new Unread.Marker(this.$channelId, ack2.getMessageId(), l);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Observable<Unread.Marker> invoke(Long l) {
            return invoke(l.longValue());
        }

        public final Observable<Unread.Marker> invoke(long j) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            return Observable.i(companion.getMessageAck().observeAll().G(new C02851(j)).Z(1), companion.getMessageAck().observeAll().G(new AnonymousClass2(j)), companion.getMessagesMostRecent().observeRecentMessageIds(j).Z(1), new AnonymousClass3(j));
        }
    }

    /* compiled from: StoreReadStates.kt */
    /* renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Long, Boolean> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
            return Boolean.valueOf(invoke(l.longValue()));
        }

        public final boolean invoke(long j) {
            return j <= 0;
        }
    }

    /* compiled from: StoreReadStates.kt */
    /* renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Long, Observable<Unread.Marker>> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Observable<Unread.Marker> invoke(Long l) {
            return invoke(l.longValue());
        }

        public final Observable<Unread.Marker> invoke(long j) {
            Observable<Unread.Marker> observableInvoke = AnonymousClass1.INSTANCE.invoke(j);
            m.checkNotNullExpressionValue(observableInvoke, "getMarker(channelId)");
            return observableInvoke;
        }
    }

    /* compiled from: StoreReadStates.kt */
    /* renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$4, reason: invalid class name */
    public static final class AnonymousClass4<T, R> implements b<Unread.Marker, Observable<? extends Unread>> {

        /* compiled from: StoreReadStates.kt */
        /* renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$4$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements b<List<? extends Message>, Unread> {
            public final /* synthetic */ Unread.Marker $marker;

            public AnonymousClass1(Unread.Marker marker) {
                this.$marker = marker;
            }

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ Unread call(List<? extends Message> list) {
                return call2((List<Message>) list);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Unread call2(List<Message> list) {
                Unread.Marker marker = this.$marker;
                m.checkNotNullExpressionValue(list, "messages");
                return new Unread(marker, list);
            }
        }

        /* compiled from: StoreReadStates.kt */
        /* renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$4$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements b<Boolean, Boolean> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Boolean bool) {
                return bool;
            }

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ Boolean call(Boolean bool) {
                return call2(bool);
            }
        }

        /* compiled from: StoreReadStates.kt */
        /* renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$4$3, reason: invalid class name */
        public static final class AnonymousClass3 implements Action0 {
            public AnonymousClass3() {
            }

            @Override // rx.functions.Action0
            public final void call() {
                StoreReadStates.access$clearMarker(StoreReadStates.this);
            }
        }

        public AnonymousClass4() {
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends Unread> call(Unread.Marker marker) {
            return call2(marker);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Unread> call2(Unread.Marker marker) {
            m.checkNotNullParameter(marker, "marker");
            Observable<R> observableA0 = StoreStream.INSTANCE.getMessages().observeMessagesForChannel(marker.getChannelId()).G(new AnonymousClass1(marker)).a0(StoreReadStates.access$getMarkAsRead$p(StoreReadStates.this).y(AnonymousClass2.INSTANCE));
            AnonymousClass3 anonymousClass3 = new AnonymousClass3();
            a.C0620a c0620a = a.a;
            return Observable.h0(new j0.l.a.k(observableA0, new j0.l.e.a(c0620a, c0620a, anonymousClass3)));
        }
    }

    /* compiled from: StoreReadStates.kt */
    /* renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$5, reason: invalid class name */
    public static final class AnonymousClass5 extends o implements Function1<Unread, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unread unread) {
            invoke2(unread);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unread unread) {
            Persister persisterAccess$getUnreadMessageMarker$p = StoreReadStates.access$getUnreadMessageMarker$p(StoreReadStates.this);
            m.checkNotNullExpressionValue(unread, "newValue");
            Persister.set$default(persisterAccess$getUnreadMessageMarker$p, unread, false, 2, null);
        }
    }

    /* compiled from: StoreReadStates.kt */
    /* renamed from: com.discord.stores.StoreReadStates$getIsUnread$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Set<? extends Long>, Boolean> {
        public final /* synthetic */ long $guildId;

        public AnonymousClass1(long j) {
            this.$guildId = j;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Boolean call(Set<? extends Long> set) {
            return call2((Set<Long>) set);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Set<Long> set) {
            return Boolean.valueOf(set.contains(Long.valueOf(this.$guildId)));
        }
    }

    /* compiled from: StoreReadStates.kt */
    /* renamed from: com.discord.stores.StoreReadStates$getUnreadMarker$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Unread, Boolean> {
        public final /* synthetic */ long $channelId;

        public AnonymousClass1(long j) {
            this.$channelId = j;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Boolean call(Unread unread) {
            return call2(unread);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Unread unread) {
            m.checkNotNullParameter(unread, "marker");
            return Boolean.valueOf(unread.getMarker().getChannelId() == this.$channelId);
        }
    }

    /* compiled from: StoreReadStates.kt */
    /* renamed from: com.discord.stores.StoreReadStates$observeUnreadCountForChannel$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Map<Long, ? extends StoreMessageAck.Ack>, StoreMessageAck.Ack> {
        public final /* synthetic */ long $channelId;

        public AnonymousClass1(long j) {
            this.$channelId = j;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ StoreMessageAck.Ack call(Map<Long, ? extends StoreMessageAck.Ack> map) {
            return call2((Map<Long, StoreMessageAck.Ack>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final StoreMessageAck.Ack call2(Map<Long, StoreMessageAck.Ack> map) {
            return map.get(Long.valueOf(this.$channelId));
        }
    }

    /* compiled from: StoreReadStates.kt */
    /* renamed from: com.discord.stores.StoreReadStates$observeUnreadCountForChannel$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<List<? extends Message>, StoreMessageAck.Ack, Integer> {
        public final /* synthetic */ UtcDateTime $since;

        public AnonymousClass2(UtcDateTime utcDateTime) {
            this.$since = utcDateTime;
        }

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Integer call(List<? extends Message> list, StoreMessageAck.Ack ack) {
            return call2((List<Message>) list, ack);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Integer call2(List<Message> list, StoreMessageAck.Ack ack) {
            Long lValueOf = ack != null ? Long.valueOf(ack.getMessageId()) : null;
            m.checkNotNullExpressionValue(list, "messages");
            int i = 0;
            if (!list.isEmpty()) {
                for (Message message : s.asReversed(list)) {
                    if (lValueOf != null && message.getId() == ack.getMessageId()) {
                        break;
                    }
                    if (StoreReadStates.access$wasMessageSentAfterTimestamp(StoreReadStates.this, this.$since, Long.valueOf(message.getId()))) {
                        i++;
                    }
                }
            }
            return Integer.valueOf(i);
        }
    }

    public StoreReadStates(Clock clock) {
        m.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        this.unreadChannelIds = new SerializedSubject<>(BehaviorSubject.l0(new HashSet()));
        this.unreadGuildIds = new SerializedSubject<>(BehaviorSubject.l0(new HashSet()));
        this.markAsRead = new SerializedSubject<>(BehaviorSubject.l0(Boolean.FALSE));
        this.unreadMessageMarker = new Persister<>("UNREAD_MESSAGE_MARKER_V3", new Unread(null, 0, 3, null));
    }

    public static final /* synthetic */ void access$clearMarker(StoreReadStates storeReadStates) {
        storeReadStates.clearMarker();
    }

    public static final /* synthetic */ Pair access$computeUnreadIds(StoreReadStates storeReadStates, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, long j, Map map7, Map map8) {
        return storeReadStates.computeUnreadIds(map, map2, map3, map4, map5, map6, j, map7, map8);
    }

    public static final /* synthetic */ SerializedSubject access$getMarkAsRead$p(StoreReadStates storeReadStates) {
        return storeReadStates.markAsRead;
    }

    public static final /* synthetic */ SerializedSubject access$getUnreadChannelIds$p(StoreReadStates storeReadStates) {
        return storeReadStates.unreadChannelIds;
    }

    public static final /* synthetic */ SerializedSubject access$getUnreadGuildIds$p(StoreReadStates storeReadStates) {
        return storeReadStates.unreadGuildIds;
    }

    public static final /* synthetic */ Persister access$getUnreadMessageMarker$p(StoreReadStates storeReadStates) {
        return storeReadStates.unreadMessageMarker;
    }

    public static final /* synthetic */ boolean access$wasMessageSentAfterTimestamp(StoreReadStates storeReadStates, UtcDateTime utcDateTime, Long l) {
        return storeReadStates.wasMessageSentAfterTimestamp(utcDateTime, l);
    }

    private final void clearMarker() {
        Observable observableZ = this.unreadMessageMarker.getObservable().G(AnonymousClass1.INSTANCE).Z(1);
        m.checkNotNullExpressionValue(observableZ, "unreadMessageMarker\n    …ount() }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableZ, (Context) null, "unreadMessageMarker", (Function1) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    private final void computeUnreadChannelIds() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Map<Long, Long>> observableObservePermissionsForAllChannels = companion.getPermissions().observePermissionsForAllChannels();
        Observable<Map<Long, Channel>> observableObserveGuildAndPrivateChannels = companion.getChannels().observeGuildAndPrivateChannels();
        Observable<Map<Long, Long>> observableObserveJoinedAt = companion.getGuilds().observeJoinedAt();
        Observable<Map<Long, ModelNotificationSettings>> observableObserveGuildSettings = companion.getUserGuildSettings().observeGuildSettings();
        Observable<Map<Long, StoreMessageAck.Ack>> observableObserveAll = companion.getMessageAck().observeAll();
        Observable<Map<Long, Long>> observableObserveRecentMessageIds = companion.getMessagesMostRecent().observeRecentMessageIds();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Observable observableCombineLatest = ObservableWithLeadingEdgeThrottle.combineLatest(observableObservePermissionsForAllChannels, observableObserveGuildAndPrivateChannels, observableObserveJoinedAt, observableObserveGuildSettings, observableObserveAll, ObservableExtensionsKt.leadingEdgeThrottle(observableObserveRecentMessageIds, 3L, timeUnit), companion.getVoiceChannelSelected().observeSelectedVoiceChannelId(), ObservableExtensionsKt.leadingEdgeThrottle(companion.getThreadsActive().observeAllActiveForumThreadsById(), 3L, timeUnit), companion.getThreadsActiveJoined().observeAllActiveJoinedThreadsById(), new StoreReadStates$sam$rx_functions_Func9$0(new AnonymousClass1(this)), 1L, timeUnit);
        m.checkNotNullExpressionValue(observableCombineLatest, "ObservableWithLeadingEdg…imeUnit.SECONDS\n        )");
        Observable observableR = ObservableExtensionsKt.computationLatest(observableCombineLatest).r();
        m.checkNotNullExpressionValue(observableR, "ObservableWithLeadingEdg…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, (Context) null, "computeUnreadChannelIds", (Function1) null, new AnonymousClass2(), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    private final Pair<Set<Long>, Set<Long>> computeUnreadIds(Map<Long, Long> permissions, Map<Long, Channel> channels, Map<Long, Long> guildJoinedAt, Map<Long, ? extends ModelNotificationSettings> guildSettings, Map<Long, StoreMessageAck.Ack> acks, Map<Long, Long> mostRecent, long voiceChannelSelectedId, Map<Long, Channel> activeForumThreads, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> activeAndJoinedThreads) {
        long jLongValue;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Iterator<Map.Entry<Long, Long>> it = mostRecent.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, Long> next = it.next();
            long jLongValue2 = next.getKey().longValue();
            long jLongValue3 = next.getValue().longValue();
            StoreThreadsActiveJoined.ActiveJoinedThread activeJoinedThread = activeAndJoinedThreads.get(Long.valueOf(jLongValue2));
            Channel channel = activeForumThreads.get(Long.valueOf(jLongValue2));
            Channel channel2 = channels.get(Long.valueOf(jLongValue2));
            if (channel2 == null) {
                channel2 = activeJoinedThread != null ? activeJoinedThread.getChannel() : null;
            }
            if (channel2 == null) {
                channel2 = channel;
            }
            Iterator<Map.Entry<Long, Long>> it2 = it;
            boolean z2 = channel2 != null && ChannelUtils.r(channel2, channel2 != null ? channels.get(Long.valueOf(channel2.getParentId())) : null);
            if (channel2 != null && !ChannelUtils.B(channel2) && ((!ChannelUtils.H(channel2) || z2 || activeJoinedThread != null) && (!ChannelUtils.H(channel2) || !z2 || channel != null))) {
                if (PermissionUtils.INSTANCE.hasAccess(channel2, permissions.get(Long.valueOf(jLongValue2))) && !isChannelMuted(channel2, guildSettings, activeJoinedThread) && ((!ChannelUtils.J(channel2) || channel2.getId() == voiceChannelSelectedId) && (!ChannelUtils.J(channel2) || channel2.getId() != voiceChannelSelectedId || wasMessageSentAfterTimestamp(new UtcDateTime(StoreStream.INSTANCE.getVoiceChannelSelected().getTimeSelectedMs()), Long.valueOf(jLongValue3))))) {
                    StoreMessageAck.Ack ack = acks.get(Long.valueOf(jLongValue2));
                    if (ack != null || !ChannelUtils.H(channel2)) {
                        if (ack != null) {
                            jLongValue = ack.getMessageId();
                        } else {
                            Long l = (Long) b.d.b.a.a.c(channel2, guildJoinedAt);
                            jLongValue = ((l != null ? l.longValue() : this.clock.currentTimeMillis()) - SnowflakeUtils.DISCORD_EPOCH) << 22;
                        }
                        if (MessageUtils.isNewer(Long.valueOf(jLongValue), Long.valueOf(jLongValue3))) {
                            hashSet.add(Long.valueOf(jLongValue2));
                            Channel channel3 = channels.get(Long.valueOf(channel2.getParentId()));
                            boolean zIsChannelMuted = isChannelMuted(channel3, guildSettings, activeJoinedThread);
                            if (!zIsChannelMuted && ChannelUtils.H(channel2) && channel3 != null) {
                                zIsChannelMuted = isChannelMuted(channels.get(Long.valueOf(channel3.getParentId())), guildSettings, activeJoinedThread);
                            }
                            if (!zIsChannelMuted) {
                                hashSet2.add(Long.valueOf(channel2.getGuildId()));
                            }
                        }
                    }
                }
                it = it2;
            }
            it = it2;
        }
        return new Pair<>(hashSet, hashSet2);
    }

    private final void computeUnreadMarker() {
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Observable<Long> observableObserveId = StoreStream.INSTANCE.getChannelsSelected().observeId();
        AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
        Unread.Marker marker = new Unread.Marker();
        AnonymousClass3 anonymousClass3 = AnonymousClass3.INSTANCE;
        m.checkNotNullParameter(anonymousClass2, "observableCondition");
        m.checkNotNullParameter(anonymousClass3, "defaultObservableFunc");
        b0 b0Var = new b0(marker);
        m.checkNotNullParameter(anonymousClass2, "observableCondition");
        m.checkNotNullParameter(b0Var, "switchedObservableFunc");
        m.checkNotNullParameter(anonymousClass3, "defaultObservableFunc");
        Observable observableY = observableObserveId.k(new a0(anonymousClass2, b0Var, anonymousClass3)).Y(new AnonymousClass4());
        m.checkNotNullExpressionValue(observableY, "getChannelsSelected()\n  …clearMarker() }\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableY, (Context) null, "unreadMessageMarker", (Function1) null, new AnonymousClass5(), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    private final boolean isChannelMuted(Channel channel, Map<Long, ? extends ModelNotificationSettings> guildSettings, StoreThreadsActiveJoined.ActiveJoinedThread activeJoinedThread) {
        if (channel == null) {
            return false;
        }
        if (ChannelUtils.H(channel) && activeJoinedThread != null) {
            return activeJoinedThread.getMuted();
        }
        long id2 = channel.getId();
        ModelNotificationSettings modelNotificationSettings = (ModelNotificationSettings) b.d.b.a.a.c(channel, guildSettings);
        ModelNotificationSettings.ChannelOverride channelOverride = modelNotificationSettings != null ? modelNotificationSettings.getChannelOverride(id2) : null;
        return channelOverride != null && channelOverride.isMuted();
    }

    public static /* synthetic */ Observable observeUnreadCountForChannel$default(StoreReadStates storeReadStates, long j, UtcDateTime utcDateTime, int i, Object obj) {
        if ((i & 2) != 0) {
            utcDateTime = null;
        }
        return storeReadStates.observeUnreadCountForChannel(j, utcDateTime);
    }

    private final boolean wasMessageSentAfterTimestamp(UtcDateTime since, Long messageId) {
        return since == null || (messageId != null && new UtcDateTime((messageId.longValue() >>> 22) + SnowflakeUtils.DISCORD_EPOCH).f(since) >= 0);
    }

    public final Observable<Boolean> getIsUnread(long guildId) {
        Observable<Boolean> observableR = getUnreadGuildIds().G(new AnonymousClass1(guildId)).r();
        m.checkNotNullExpressionValue(observableR, "getUnreadGuildIds()\n    …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Set<Long>> getUnreadChannelIds() {
        return this.unreadChannelIds;
    }

    public final Observable<Set<Long>> getUnreadGuildIds() {
        return this.unreadGuildIds;
    }

    public final Observable<Unread> getUnreadMarker(long channelId) {
        Observable<Unread> observableR = getUnreadMarkerForSelectedChannel().y(new AnonymousClass1(channelId)).r();
        m.checkNotNullExpressionValue(observableR, "unreadMarkerForSelectedC…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Unread> getUnreadMarkerForSelectedChannel() {
        Observable<Unread> observableR = ObservableExtensionsKt.computationLatest(this.unreadMessageMarker.getObservable()).r();
        m.checkNotNullExpressionValue(observableR, "unreadMessageMarker\n    …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        computeUnreadChannelIds();
        computeUnreadMarker();
    }

    public final void markAsRead(Long channelId) {
        if (channelId == null) {
            return;
        }
        SerializedSubject<Boolean, Boolean> serializedSubject = this.markAsRead;
        serializedSubject.k.onNext(Boolean.TRUE);
        SerializedSubject<Boolean, Boolean> serializedSubject2 = this.markAsRead;
        serializedSubject2.k.onNext(Boolean.FALSE);
        StoreStream.INSTANCE.getMessageAck().ack(channelId.longValue(), false, false);
    }

    public final Observable<Integer> observeUnreadCountForChannel(long channelId, UtcDateTime since) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Integer> observableJ = Observable.j(companion.getMessages().observeMessagesForChannel(channelId), companion.getMessageAck().observeAll().G(new AnonymousClass1(channelId)), new AnonymousClass2(since));
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…\n      messageCount\n    }");
        return observableJ;
    }
}
