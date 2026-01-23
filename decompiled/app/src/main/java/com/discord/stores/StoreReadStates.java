package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.p501rx.ObservableWithLeadingEdgeThrottle;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.time.Clock;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function9;
import p007b.p008a.p018d.C0853a0;
import p007b.p008a.p018d.C0855b0;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.ReversedViews3;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Actions2;
import p637j0.p641k.Func1;
import p637j0.p642l.p643a.OnSubscribeDoOnEach;
import p637j0.p642l.p647e.ActionObserver;
import p658rx.Observable;
import p658rx.functions.Action0;
import p658rx.functions.Func2;
import p658rx.functions.Func3;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreReadStates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreReadStates extends Store {
    private final Clock clock;
    private final SerializedSubject<Boolean, Boolean> markAsRead;
    private final SerializedSubject<Set<Long>, Set<Long>> unreadChannelIds;
    private final SerializedSubject<Set<Long>, Set<Long>> unreadGuildIds;
    private final Persister<Unread> unreadMessageMarker;

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$clearMarker$1 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class C63401<T, R> implements Func1<Unread, Unread> {
        public static final C63401 INSTANCE = new C63401();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Unread call(Unread unread) {
            return call2(unread);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Unread call2(Unread unread) {
            return unread.createWithEmptyCount();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$clearMarker$2 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class C63412 extends Lambda implements Function1<Unread, Unit> {
        public C63412() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unread unread) {
            invoke2(unread);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unread unread) {
            Persister persisterAccess$getUnreadMessageMarker$p = StoreReadStates.access$getUnreadMessageMarker$p(StoreReadStates.this);
            Intrinsics3.checkNotNullExpressionValue(unread, "newValue");
            Persister.set$default(persisterAccess$getUnreadMessageMarker$p, unread, false, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadChannelIds$1 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final /* synthetic */ class C63421 extends FunctionReferenceImpl implements Function9<Map<Long, ? extends Long>, Map<Long, ? extends Channel>, Map<Long, ? extends Long>, Map<Long, ? extends ModelNotificationSettings>, Map<Long, ? extends StoreMessageAck.Ack>, Map<Long, ? extends Long>, Long, Map<Long, ? extends Channel>, Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>, Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>>> {
        public C63421(StoreReadStates storeReadStates) {
            super(9, storeReadStates, StoreReadStates.class, "computeUnreadIds", "computeUnreadIds(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;JLjava/util/Map;Ljava/util/Map;)Lkotlin/Pair;", 0);
        }

        @Override // kotlin.jvm.functions.Function9
        public /* bridge */ /* synthetic */ Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>> invoke(Map<Long, ? extends Long> map, Map<Long, ? extends Channel> map2, Map<Long, ? extends Long> map3, Map<Long, ? extends ModelNotificationSettings> map4, Map<Long, ? extends StoreMessageAck.Ack> map5, Map<Long, ? extends Long> map6, Long l, Map<Long, ? extends Channel> map7, Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread> map8) {
            return invoke((Map<Long, Long>) map, (Map<Long, Channel>) map2, (Map<Long, Long>) map3, map4, (Map<Long, StoreMessageAck.Ack>) map5, (Map<Long, Long>) map6, l.longValue(), (Map<Long, Channel>) map7, (Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>) map8);
        }

        public final Tuples2<Set<Long>, Set<Long>> invoke(Map<Long, Long> map, Map<Long, Channel> map2, Map<Long, Long> map3, Map<Long, ? extends ModelNotificationSettings> map4, Map<Long, StoreMessageAck.Ack> map5, Map<Long, Long> map6, long j, Map<Long, Channel> map7, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> map8) {
            Intrinsics3.checkNotNullParameter(map, "p1");
            Intrinsics3.checkNotNullParameter(map2, "p2");
            Intrinsics3.checkNotNullParameter(map3, "p3");
            Intrinsics3.checkNotNullParameter(map4, "p4");
            Intrinsics3.checkNotNullParameter(map5, "p5");
            Intrinsics3.checkNotNullParameter(map6, "p6");
            Intrinsics3.checkNotNullParameter(map7, "p8");
            Intrinsics3.checkNotNullParameter(map8, "p9");
            return StoreReadStates.access$computeUnreadIds((StoreReadStates) this.receiver, map, map2, map3, map4, map5, map6, j, map7, map8);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadChannelIds$2 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class C63432 extends Lambda implements Function1<Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>>, Unit> {
        public C63432() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends Set<? extends Long>, ? extends Set<? extends Long>> tuples2) {
            invoke2((Tuples2<? extends Set<Long>, ? extends Set<Long>>) tuples2);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<? extends Set<Long>, ? extends Set<Long>> tuples2) {
            Set<Long> setComponent1 = tuples2.component1();
            Set<Long> setComponent2 = tuples2.component2();
            StoreReadStates.access$getUnreadChannelIds$p(StoreReadStates.this).f27653k.onNext(setComponent1);
            StoreReadStates.access$getUnreadGuildIds$p(StoreReadStates.this).f27653k.onNext(setComponent2);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$1 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class C63441 extends Lambda implements Function1<Long, Observable<Unread.Marker>> {
        public static final C63441 INSTANCE = new C63441();

        /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreReadStates.kt */
        public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends StoreMessageAck.Ack>, StoreMessageAck.Ack> {
            public final /* synthetic */ long $channelId;

            public AnonymousClass1(long j) {
                this.$channelId = j;
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ StoreMessageAck.Ack call(Map<Long, ? extends StoreMessageAck.Ack> map) {
                return call2((Map<Long, StoreMessageAck.Ack>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final StoreMessageAck.Ack call2(Map<Long, StoreMessageAck.Ack> map) {
                return map.get(Long.valueOf(this.$channelId));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreReadStates.kt */
        public static final class AnonymousClass2<T, R> implements Func1<Map<Long, ? extends StoreMessageAck.Ack>, StoreMessageAck.Ack> {
            public final /* synthetic */ long $channelId;

            public AnonymousClass2(long j) {
                this.$channelId = j;
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ StoreMessageAck.Ack call(Map<Long, ? extends StoreMessageAck.Ack> map) {
                return call2((Map<Long, StoreMessageAck.Ack>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final StoreMessageAck.Ack call2(Map<Long, StoreMessageAck.Ack> map) {
                return map.get(Long.valueOf(this.$channelId));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: StoreReadStates.kt */
        public static final class AnonymousClass3<T1, T2, T3, R> implements Func3<StoreMessageAck.Ack, StoreMessageAck.Ack, Long, Unread.Marker> {
            public final /* synthetic */ long $channelId;

            public AnonymousClass3(long j) {
                this.$channelId = j;
            }

            @Override // p658rx.functions.Func3
            public /* bridge */ /* synthetic */ Unread.Marker call(StoreMessageAck.Ack ack, StoreMessageAck.Ack ack2, Long l) {
                return call2(ack, ack2, l);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Unread.Marker call2(StoreMessageAck.Ack ack, StoreMessageAck.Ack ack2, Long l) {
                return (ack2 == null || !ack2.isLockedAck()) ? ack != null ? new Unread.Marker(this.$channelId, ack.getMessageId(), l) : new Unread.Marker(this.$channelId, 0L, l) : new Unread.Marker(this.$channelId, ack2.getMessageId(), l);
            }
        }

        public C63441() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Observable<Unread.Marker> invoke(Long l) {
            return invoke(l.longValue());
        }

        public final Observable<Unread.Marker> invoke(long j) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            return Observable.m11075i(companion.getMessageAck().observeAll().m11083G(new AnonymousClass1(j)).m11100Z(1), companion.getMessageAck().observeAll().m11083G(new AnonymousClass2(j)), companion.getMessagesMostRecent().observeRecentMessageIds(j).m11100Z(1), new AnonymousClass3(j));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$2 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class C63452 extends Lambda implements Function1<Long, Boolean> {
        public static final C63452 INSTANCE = new C63452();

        public C63452() {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$3 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class C63463 extends Lambda implements Function1<Long, Observable<Unread.Marker>> {
        public static final C63463 INSTANCE = new C63463();

        public C63463() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Observable<Unread.Marker> invoke(Long l) {
            return invoke(l.longValue());
        }

        public final Observable<Unread.Marker> invoke(long j) {
            Observable<Unread.Marker> observableInvoke = C63441.INSTANCE.invoke(j);
            Intrinsics3.checkNotNullExpressionValue(observableInvoke, "getMarker(channelId)");
            return observableInvoke;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$4 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class C63474<T, R> implements Func1<Unread.Marker, Observable<? extends Unread>> {

        /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreReadStates.kt */
        public static final class AnonymousClass1<T, R> implements Func1<List<? extends Message>, Unread> {
            public final /* synthetic */ Unread.Marker $marker;

            public AnonymousClass1(Unread.Marker marker) {
                this.$marker = marker;
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Unread call(List<? extends Message> list) {
                return call2((List<Message>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Unread call2(List<Message> list) {
                Unread.Marker marker = this.$marker;
                Intrinsics3.checkNotNullExpressionValue(list, "messages");
                return new Unread(marker, list);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$4$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreReadStates.kt */
        public static final class AnonymousClass2<T, R> implements Func1<Boolean, Boolean> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Boolean bool) {
                return bool;
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Boolean call(Boolean bool) {
                return call2(bool);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$4$3, reason: invalid class name */
        /* JADX INFO: compiled from: StoreReadStates.kt */
        public static final class AnonymousClass3 implements Action0 {
            public AnonymousClass3() {
            }

            @Override // p658rx.functions.Action0
            public final void call() {
                StoreReadStates.access$clearMarker(StoreReadStates.this);
            }
        }

        public C63474() {
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Unread> call(Unread.Marker marker) {
            return call2(marker);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Unread> call2(Unread.Marker marker) {
            Intrinsics3.checkNotNullParameter(marker, "marker");
            Observable<R> observableM11102a0 = StoreStream.INSTANCE.getMessages().observeMessagesForChannel(marker.getChannelId()).m11083G(new AnonymousClass1(marker)).m11102a0(StoreReadStates.access$getMarkAsRead$p(StoreReadStates.this).m11118y(AnonymousClass2.INSTANCE));
            AnonymousClass3 anonymousClass3 = new AnonymousClass3();
            Actions2.a aVar = Actions2.f26710a;
            return Observable.m11074h0(new OnSubscribeDoOnEach(observableM11102a0, new ActionObserver(aVar, aVar, anonymousClass3)));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$computeUnreadMarker$5 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class C63485 extends Lambda implements Function1<Unread, Unit> {
        public C63485() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unread unread) {
            invoke2(unread);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unread unread) {
            Persister persisterAccess$getUnreadMessageMarker$p = StoreReadStates.access$getUnreadMessageMarker$p(StoreReadStates.this);
            Intrinsics3.checkNotNullExpressionValue(unread, "newValue");
            Persister.set$default(persisterAccess$getUnreadMessageMarker$p, unread, false, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$getIsUnread$1 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class C63491<T, R> implements Func1<Set<? extends Long>, Boolean> {
        public final /* synthetic */ long $guildId;

        public C63491(long j) {
            this.$guildId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Set<? extends Long> set) {
            return call2((Set<Long>) set);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Set<Long> set) {
            return Boolean.valueOf(set.contains(Long.valueOf(this.$guildId)));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$getUnreadMarker$1 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class C63501<T, R> implements Func1<Unread, Boolean> {
        public final /* synthetic */ long $channelId;

        public C63501(long j) {
            this.$channelId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Unread unread) {
            return call2(unread);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Unread unread) {
            Intrinsics3.checkNotNullParameter(unread, "marker");
            return Boolean.valueOf(unread.getMarker().getChannelId() == this.$channelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$observeUnreadCountForChannel$1 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class C63511<T, R> implements Func1<Map<Long, ? extends StoreMessageAck.Ack>, StoreMessageAck.Ack> {
        public final /* synthetic */ long $channelId;

        public C63511(long j) {
            this.$channelId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ StoreMessageAck.Ack call(Map<Long, ? extends StoreMessageAck.Ack> map) {
            return call2((Map<Long, StoreMessageAck.Ack>) map);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final StoreMessageAck.Ack call2(Map<Long, StoreMessageAck.Ack> map) {
            return map.get(Long.valueOf(this.$channelId));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreReadStates$observeUnreadCountForChannel$2 */
    /* JADX INFO: compiled from: StoreReadStates.kt */
    public static final class C63522<T1, T2, R> implements Func2<List<? extends Message>, StoreMessageAck.Ack, Integer> {
        public final /* synthetic */ UtcDateTime $since;

        public C63522(UtcDateTime utcDateTime) {
            this.$since = utcDateTime;
        }

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ Integer call(List<? extends Message> list, StoreMessageAck.Ack ack) {
            return call2((List<Message>) list, ack);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Integer call2(List<Message> list, StoreMessageAck.Ack ack) {
            Long lValueOf = ack != null ? Long.valueOf(ack.getMessageId()) : null;
            Intrinsics3.checkNotNullExpressionValue(list, "messages");
            int i = 0;
            if (!list.isEmpty()) {
                for (Message message : ReversedViews3.asReversed(list)) {
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
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        this.unreadChannelIds = new SerializedSubject<>(BehaviorSubject.m11130l0(new HashSet()));
        this.unreadGuildIds = new SerializedSubject<>(BehaviorSubject.m11130l0(new HashSet()));
        this.markAsRead = new SerializedSubject<>(BehaviorSubject.m11130l0(Boolean.FALSE));
        this.unreadMessageMarker = new Persister<>("UNREAD_MESSAGE_MARKER_V3", new Unread(null, 0, 3, null));
    }

    public static final /* synthetic */ void access$clearMarker(StoreReadStates storeReadStates) {
        storeReadStates.clearMarker();
    }

    public static final /* synthetic */ Tuples2 access$computeUnreadIds(StoreReadStates storeReadStates, Map map, Map map2, Map map3, Map map4, Map map5, Map map6, long j, Map map7, Map map8) {
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
        Observable observableM11100Z = this.unreadMessageMarker.getObservable().m11083G(C63401.INSTANCE).m11100Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableM11100Z, "unreadMessageMarker\n    …ount() }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableM11100Z, (Context) null, "unreadMessageMarker", (Function1) null, new C63412(), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
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
        Observable observableCombineLatest = ObservableWithLeadingEdgeThrottle.combineLatest(observableObservePermissionsForAllChannels, observableObserveGuildAndPrivateChannels, observableObserveJoinedAt, observableObserveGuildSettings, observableObserveAll, ObservableExtensionsKt.leadingEdgeThrottle(observableObserveRecentMessageIds, 3L, timeUnit), companion.getVoiceChannelSelected().observeSelectedVoiceChannelId(), ObservableExtensionsKt.leadingEdgeThrottle(companion.getThreadsActive().observeAllActiveForumThreadsById(), 3L, timeUnit), companion.getThreadsActiveJoined().observeAllActiveJoinedThreadsById(), new StoreReadStates2(new C63421(this)), 1L, timeUnit);
        Intrinsics3.checkNotNullExpressionValue(observableCombineLatest, "ObservableWithLeadingEdg…imeUnit.SECONDS\n        )");
        Observable observableM11112r = ObservableExtensionsKt.computationLatest(observableCombineLatest).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "ObservableWithLeadingEdg…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableM11112r, (Context) null, "computeUnreadChannelIds", (Function1) null, new C63432(), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    private final Tuples2<Set<Long>, Set<Long>> computeUnreadIds(Map<Long, Long> permissions, Map<Long, Channel> channels, Map<Long, Long> guildJoinedAt, Map<Long, ? extends ModelNotificationSettings> guildSettings, Map<Long, StoreMessageAck.Ack> acks, Map<Long, Long> mostRecent, long voiceChannelSelectedId, Map<Long, Channel> activeForumThreads, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> activeAndJoinedThreads) {
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
            boolean z2 = channel2 != null && ChannelUtils.m7694r(channel2, channel2 != null ? channels.get(Long.valueOf(channel2.getParentId())) : null);
            if (channel2 != null && !ChannelUtils.m7667B(channel2) && ((!ChannelUtils.m7673H(channel2) || z2 || activeJoinedThread != null) && (!ChannelUtils.m7673H(channel2) || !z2 || channel != null))) {
                if (PermissionUtils.INSTANCE.hasAccess(channel2, permissions.get(Long.valueOf(jLongValue2))) && !isChannelMuted(channel2, guildSettings, activeJoinedThread) && ((!ChannelUtils.m7675J(channel2) || channel2.getId() == voiceChannelSelectedId) && (!ChannelUtils.m7675J(channel2) || channel2.getId() != voiceChannelSelectedId || wasMessageSentAfterTimestamp(new UtcDateTime(StoreStream.INSTANCE.getVoiceChannelSelected().getTimeSelectedMs()), Long.valueOf(jLongValue3))))) {
                    StoreMessageAck.Ack ack = acks.get(Long.valueOf(jLongValue2));
                    if (ack != null || !ChannelUtils.m7673H(channel2)) {
                        if (ack != null) {
                            jLongValue = ack.getMessageId();
                        } else {
                            Long l = (Long) outline.m843c(channel2, guildJoinedAt);
                            jLongValue = ((l != null ? l.longValue() : this.clock.currentTimeMillis()) - SnowflakeUtils.DISCORD_EPOCH) << 22;
                        }
                        if (MessageUtils.isNewer(Long.valueOf(jLongValue), Long.valueOf(jLongValue3))) {
                            hashSet.add(Long.valueOf(jLongValue2));
                            Channel channel3 = channels.get(Long.valueOf(channel2.getParentId()));
                            boolean zIsChannelMuted = isChannelMuted(channel3, guildSettings, activeJoinedThread);
                            if (!zIsChannelMuted && ChannelUtils.m7673H(channel2) && channel3 != null) {
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
        return new Tuples2<>(hashSet, hashSet2);
    }

    private final void computeUnreadMarker() {
        C63441 c63441 = C63441.INSTANCE;
        Observable<Long> observableObserveId = StoreStream.INSTANCE.getChannelsSelected().observeId();
        C63452 c63452 = C63452.INSTANCE;
        Unread.Marker marker = new Unread.Marker();
        C63463 c63463 = C63463.INSTANCE;
        Intrinsics3.checkNotNullParameter(c63452, "observableCondition");
        Intrinsics3.checkNotNullParameter(c63463, "defaultObservableFunc");
        C0855b0 c0855b0 = new C0855b0(marker);
        Intrinsics3.checkNotNullParameter(c63452, "observableCondition");
        Intrinsics3.checkNotNullParameter(c0855b0, "switchedObservableFunc");
        Intrinsics3.checkNotNullParameter(c63463, "defaultObservableFunc");
        Observable observableM11099Y = observableObserveId.m11108k(new C0853a0(c63452, c0855b0, c63463)).m11099Y(new C63474());
        Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "getChannelsSelected()\n  …clearMarker() }\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableM11099Y, (Context) null, "unreadMessageMarker", (Function1) null, new C63485(), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    private final boolean isChannelMuted(Channel channel, Map<Long, ? extends ModelNotificationSettings> guildSettings, StoreThreadsActiveJoined.ActiveJoinedThread activeJoinedThread) {
        if (channel == null) {
            return false;
        }
        if (ChannelUtils.m7673H(channel) && activeJoinedThread != null) {
            return activeJoinedThread.getMuted();
        }
        long id2 = channel.getId();
        ModelNotificationSettings modelNotificationSettings = (ModelNotificationSettings) outline.m843c(channel, guildSettings);
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
        return since == null || (messageId != null && new UtcDateTime((messageId.longValue() >>> 22) + SnowflakeUtils.DISCORD_EPOCH).m8322f(since) >= 0);
    }

    public final Observable<Boolean> getIsUnread(long guildId) {
        Observable<Boolean> observableM11112r = getUnreadGuildIds().m11083G(new C63491(guildId)).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "getUnreadGuildIds()\n    …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Set<Long>> getUnreadChannelIds() {
        return this.unreadChannelIds;
    }

    public final Observable<Set<Long>> getUnreadGuildIds() {
        return this.unreadGuildIds;
    }

    public final Observable<Unread> getUnreadMarker(long channelId) {
        Observable<Unread> observableM11112r = getUnreadMarkerForSelectedChannel().m11118y(new C63501(channelId)).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "unreadMarkerForSelectedC…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Unread> getUnreadMarkerForSelectedChannel() {
        Observable<Unread> observableM11112r = ObservableExtensionsKt.computationLatest(this.unreadMessageMarker.getObservable()).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "unreadMessageMarker\n    …  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        computeUnreadChannelIds();
        computeUnreadMarker();
    }

    public final void markAsRead(Long channelId) {
        if (channelId == null) {
            return;
        }
        SerializedSubject<Boolean, Boolean> serializedSubject = this.markAsRead;
        serializedSubject.f27653k.onNext(Boolean.TRUE);
        SerializedSubject<Boolean, Boolean> serializedSubject2 = this.markAsRead;
        serializedSubject2.f27653k.onNext(Boolean.FALSE);
        StoreStream.INSTANCE.getMessageAck().ack(channelId.longValue(), false, false);
    }

    public final Observable<Integer> observeUnreadCountForChannel(long channelId, UtcDateTime since) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Integer> observableM11076j = Observable.m11076j(companion.getMessages().observeMessagesForChannel(channelId), companion.getMessageAck().observeAll().m11083G(new C63511(channelId)), new C63522(since));
        Intrinsics3.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…\n      messageCount\n    }");
        return observableM11076j;
    }
}
