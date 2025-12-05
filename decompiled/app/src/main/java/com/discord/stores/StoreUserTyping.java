package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.api.message.Message;
import com.discord.api.user.TypingUser;
import com.discord.api.user.User;
import com.discord.models.domain.ModelTypingResponse;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.Maps6;
import p507d0.p580t.Sets5;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.Subscription;

/* compiled from: StoreUserTyping.kt */
/* loaded from: classes2.dex */
public final class StoreUserTyping extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;
    private final StoreStream stream;
    private final HashMap<Long, Set<Long>> typingUsers;
    private final HashMap<Long, Map<Long, Subscription>> typingUsersRemoveCallbacks;
    private Map<Long, ? extends Set<Long>> typingUsersSnapshot;

    /* compiled from: StoreUserTyping.kt */
    /* renamed from: com.discord.stores.StoreUserTyping$handleTypingStart$1 */
    public static final class C66101 extends Lambda implements Function1<TypingUser, Unit> {

        /* compiled from: StoreUserTyping.kt */
        /* renamed from: com.discord.stores.StoreUserTyping$handleTypingStart$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ TypingUser $prevTyping;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(TypingUser typingUser) {
                super(0);
                this.$prevTyping = typingUser;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserTyping storeUserTyping = StoreUserTyping.this;
                TypingUser typingUser = this.$prevTyping;
                Intrinsics3.checkNotNullExpressionValue(typingUser, "prevTyping");
                StoreUserTyping.access$handleTypingStop(storeUserTyping, typingUser);
            }
        }

        public C66101() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypingUser typingUser) {
            invoke2(typingUser);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TypingUser typingUser) {
            StoreUserTyping.access$getDispatcher$p(StoreUserTyping.this).schedule(new AnonymousClass1(typingUser));
        }
    }

    /* compiled from: StoreUserTyping.kt */
    /* renamed from: com.discord.stores.StoreUserTyping$handleTypingStart$2 */
    public static final class C66112 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $userId;

        /* compiled from: StoreUserTyping.kt */
        /* renamed from: com.discord.stores.StoreUserTyping$handleTypingStart$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Subscription $subscription;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Subscription subscription) {
                super(0);
                this.$subscription = subscription;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map map = (Map) StoreUserTyping.access$getTypingUsersRemoveCallbacks$p(StoreUserTyping.this).get(Long.valueOf(C66112.this.$channelId));
                if (map != null) {
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C66112(long j, long j2) {
            super(1);
            this.$channelId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            StoreUserTyping.access$getDispatcher$p(StoreUserTyping.this).schedule(new AnonymousClass1(subscription));
        }
    }

    /* compiled from: StoreUserTyping.kt */
    /* renamed from: com.discord.stores.StoreUserTyping$observeTypingUsers$1 */
    public static final class C66121 extends Lambda implements Function0<Map<Long, ? extends Set<? extends Long>>> {
        public C66121() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Set<? extends Long>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Set<? extends Long>> invoke2() {
            return StoreUserTyping.access$getTypingUsers(StoreUserTyping.this);
        }
    }

    /* compiled from: StoreUserTyping.kt */
    /* renamed from: com.discord.stores.StoreUserTyping$observeTypingUsers$2 */
    public static final class C66132<T, R> implements Func1<Map<Long, ? extends Set<? extends Long>>, Set<? extends Long>> {
        public final /* synthetic */ long $channelId;

        public C66132(long j) {
            this.$channelId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends Set<? extends Long>> map) {
            return call2((Map<Long, ? extends Set<Long>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Set<Long> call2(Map<Long, ? extends Set<Long>> map) {
            Intrinsics3.checkNotNullExpressionValue(map, "typingUsersByChannel");
            Set<Long> setEmptySet = map.get(Long.valueOf(this.$channelId));
            if (setEmptySet == null) {
                setEmptySet = Sets5.emptySet();
            }
            return setEmptySet;
        }
    }

    /* compiled from: StoreUserTyping.kt */
    /* renamed from: com.discord.stores.StoreUserTyping$observeTypingUsersForChannels$1 */
    public static final class C66141 extends Lambda implements Function0<Map<Long, ? extends Set<? extends Long>>> {
        public C66141() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Set<? extends Long>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Set<? extends Long>> invoke2() {
            return StoreUserTyping.access$getTypingUsers(StoreUserTyping.this);
        }
    }

    /* compiled from: StoreUserTyping.kt */
    /* renamed from: com.discord.stores.StoreUserTyping$observeTypingUsersForChannels$2 */
    public static final class C66152<T, R> implements Func1<Map<Long, ? extends Set<? extends Long>>, Map<Long, ? extends Set<? extends Long>>> {
        public final /* synthetic */ Set $channelIds;

        public C66152(Set set) {
            this.$channelIds = set;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Map<Long, ? extends Set<? extends Long>> call(Map<Long, ? extends Set<? extends Long>> map) {
            return call2((Map<Long, ? extends Set<Long>>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, Set<Long>> call2(Map<Long, ? extends Set<Long>> map) {
            Intrinsics3.checkNotNullExpressionValue(map, "typingUsersByChannel");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, ? extends Set<Long>> entry : map.entrySet()) {
                if (this.$channelIds.contains(Long.valueOf(entry.getKey().longValue()))) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }
    }

    /* compiled from: StoreUserTyping.kt */
    /* renamed from: com.discord.stores.StoreUserTyping$setUserTyping$1 */
    public static final class C66161 extends Lambda implements Function1<ModelTypingResponse, Unit> {
        public final /* synthetic */ long $channelId;

        /* compiled from: StoreUserTyping.kt */
        /* renamed from: com.discord.stores.StoreUserTyping$setUserTyping$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ long $messageSendCooldownSecs;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(long j) {
                super(0);
                this.$messageSendCooldownSecs = j;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreStream.INSTANCE.getSlowMode().onCooldown(C66161.this.$channelId, this.$messageSendCooldownSecs, StoreSlowMode.Type.MessageSend.INSTANCE);
            }
        }

        /* compiled from: StoreUserTyping.kt */
        /* renamed from: com.discord.stores.StoreUserTyping$setUserTyping$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ long $threadCreateCooldown;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(long j) {
                super(0);
                this.$threadCreateCooldown = j;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreStream.INSTANCE.getSlowMode().onCooldown(C66161.this.$channelId, this.$threadCreateCooldown, StoreSlowMode.Type.ThreadCreate.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C66161(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelTypingResponse modelTypingResponse) {
            invoke2(modelTypingResponse);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelTypingResponse modelTypingResponse) {
            Long threadCreateCooldownMs;
            Long messageSendCooldownMs;
            long jLongValue = (modelTypingResponse == null || (messageSendCooldownMs = modelTypingResponse.getMessageSendCooldownMs()) == null) ? 0L : messageSendCooldownMs.longValue();
            if (jLongValue > 0) {
                StoreUserTyping.access$getDispatcher$p(StoreUserTyping.this).schedule(new AnonymousClass1(jLongValue));
            }
            long jLongValue2 = (modelTypingResponse == null || (threadCreateCooldownMs = modelTypingResponse.getThreadCreateCooldownMs()) == null) ? 0L : threadCreateCooldownMs.longValue();
            if (jLongValue2 > 0) {
                StoreUserTyping.access$getDispatcher$p(StoreUserTyping.this).schedule(new AnonymousClass2(jLongValue2));
            }
        }
    }

    public /* synthetic */ StoreUserTyping(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeStream, dispatcher, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck, (i & 8) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreUserTyping storeUserTyping) {
        return storeUserTyping.dispatcher;
    }

    public static final /* synthetic */ Map access$getTypingUsers(StoreUserTyping storeUserTyping) {
        return storeUserTyping.getTypingUsers();
    }

    public static final /* synthetic */ HashMap access$getTypingUsersRemoveCallbacks$p(StoreUserTyping storeUserTyping) {
        return storeUserTyping.typingUsersRemoveCallbacks;
    }

    public static final /* synthetic */ void access$handleTypingStop(StoreUserTyping storeUserTyping, TypingUser typingUser) {
        storeUserTyping.handleTypingStop(typingUser);
    }

    private final Map<Long, Set<Long>> getTypingUsers() {
        return this.typingUsersSnapshot;
    }

    @Store3
    private final void handleTypingStop(TypingUser typing) {
        Set<Long> set = this.typingUsers.get(Long.valueOf(typing.getChannelId()));
        if (set != null) {
            Intrinsics3.checkNotNullExpressionValue(set, "typingUsers[typing.channelId] ?: return");
            if (set.remove(Long.valueOf(typing.getUserId()))) {
                markChanged();
            }
        }
    }

    @Store3
    public final void handleMessageCreate(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        User author = message.getAuthor();
        if (author != null) {
            long id2 = author.getId();
            Set<Long> set = this.typingUsers.get(Long.valueOf(message.getChannelId()));
            if (set != null) {
                Intrinsics3.checkNotNullExpressionValue(set, "typingUsers[message.channelId] ?: return");
                if (set.remove(Long.valueOf(id2))) {
                    markChanged();
                }
            }
        }
    }

    @Store3
    public final void handleTypingStart(TypingUser typing) {
        Intrinsics3.checkNotNullParameter(typing, "typing");
        long id2 = this.stream.getUsers().getMe().getId();
        long userId = typing.getUserId();
        if (id2 == userId) {
            return;
        }
        long channelId = typing.getChannelId();
        HashMap<Long, Map<Long, Subscription>> map = this.typingUsersRemoveCallbacks;
        Long lValueOf = Long.valueOf(channelId);
        Map<Long, Subscription> map2 = map.get(lValueOf);
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(lValueOf, map2);
        }
        Subscription subscription = map2.get(Long.valueOf(userId));
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<T> observableM11111q = new ScalarSynchronousObservable(typing).m11111q(10L, TimeUnit.SECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableM11111q, "Observable\n        .just…lay(10, TimeUnit.SECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableM11111q, (Context) null, "typingRemove", new C66112(channelId, userId), new C66101(), (Function1) null, (Function0) null, (Function0) null, 113, (Object) null);
        HashMap<Long, Set<Long>> map3 = this.typingUsers;
        Long lValueOf2 = Long.valueOf(channelId);
        Set<Long> hashSet = map3.get(lValueOf2);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            map3.put(lValueOf2, hashSet);
        }
        if (hashSet.add(Long.valueOf(userId))) {
            markChanged();
        }
    }

    public final Observable<Set<Long>> observeTypingUsers(long channelId) {
        Observable<Set<Long>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C66121(), 14, null).m11083G(new C66132(channelId)).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, Set<Long>>> observeTypingUsersForChannels(Set<Long> channelIds) {
        Intrinsics3.checkNotNullParameter(channelIds, "channelIds");
        Observable<Map<Long, Set<Long>>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C66141(), 14, null).m11083G(new C66152(channelIds)).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final void setUserTyping(long channelId) {
        if (channelId == 0) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.setUserTyping(channelId, new RestAPIParams.EmptyBody()), false, 1, null), (Context) null, "typingEvent", (Function1) null, new C66161(channelId), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        HashMap map = new HashMap();
        for (Map.Entry<Long, Set<Long>> entry : this.typingUsers.entrySet()) {
            map.put(Long.valueOf(entry.getKey().longValue()), new HashSet(entry.getValue()));
        }
        this.typingUsersSnapshot = map;
    }

    public StoreUserTyping(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.typingUsersRemoveCallbacks = new HashMap<>();
        this.typingUsers = new HashMap<>();
        this.typingUsersSnapshot = Maps6.emptyMap();
    }
}
