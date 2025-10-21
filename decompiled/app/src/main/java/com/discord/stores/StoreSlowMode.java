package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.utilities.time.Clock;
import d0.z.d.Intrinsics3;
import j0.l.a.OnSubscribeRefCount3;
import j0.l.e.ScalarSynchronousObservable;
import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: StoreSlowMode.kt */
/* loaded from: classes2.dex */
public final class StoreSlowMode extends Store {

    @Deprecated
    private static final long COOLDOWN_BUFFER_MS = 1000;
    private static final Companion Companion = new Companion(null);
    private final HashMap<Long, Observable<Integer>> channelMessageSendCooldownObservables;
    private final HashMap<Long, Observable<Integer>> channelThreadCreateCooldownObservables;
    private final Clock clock;
    private final HashMap<Long, Long> messageSendNextSendTimes;
    private final BehaviorSubject<HashMap<Long, Long>> messageSendNextSendTimesSubject;
    private final StoreStream stream;
    private final HashMap<Long, Long> threadCreateNextSendTimes;
    private final BehaviorSubject<HashMap<Long, Long>> threadCreateNextSendTimesSubject;

    /* compiled from: StoreSlowMode.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreSlowMode.kt */
    public static abstract class Type {

        /* compiled from: StoreSlowMode.kt */
        public static final class MessageSend extends Type {
            public static final MessageSend INSTANCE = new MessageSend();

            private MessageSend() {
                super(null);
            }
        }

        /* compiled from: StoreSlowMode.kt */
        public static final class ThreadCreate extends Type {
            public static final ThreadCreate INSTANCE = new ThreadCreate();

            private ThreadCreate() {
                super(null);
            }
        }

        private Type() {
        }

        public /* synthetic */ Type(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public StoreSlowMode(Clock clock, StoreStream storeStream) {
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        this.clock = clock;
        this.stream = storeStream;
        HashMap<Long, Long> map = new HashMap<>();
        this.messageSendNextSendTimes = map;
        this.messageSendNextSendTimesSubject = BehaviorSubject.l0(new HashMap(map));
        HashMap<Long, Long> map2 = new HashMap<>();
        this.threadCreateNextSendTimes = map2;
        this.threadCreateNextSendTimesSubject = BehaviorSubject.l0(new HashMap(map2));
        this.channelMessageSendCooldownObservables = new HashMap<>();
        this.channelThreadCreateCooldownObservables = new HashMap<>();
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreSlowMode storeSlowMode) {
        return storeSlowMode.clock;
    }

    public static final /* synthetic */ BehaviorSubject access$getMessageSendNextSendTimesSubject$p(StoreSlowMode storeSlowMode) {
        return storeSlowMode.messageSendNextSendTimesSubject;
    }

    public static final /* synthetic */ BehaviorSubject access$getThreadCreateNextSendTimesSubject$p(StoreSlowMode storeSlowMode) {
        return storeSlowMode.threadCreateNextSendTimesSubject;
    }

    public static final /* synthetic */ Observable access$removeChannelCooldownObservable(StoreSlowMode storeSlowMode, long j, Type type) {
        return storeSlowMode.removeChannelCooldownObservable(j, type);
    }

    private final synchronized Observable<Integer> getChannelCooldownObservable(long channelId, Type type) {
        Type.MessageSend messageSend = Type.MessageSend.INSTANCE;
        Observable<Integer> observable = Intrinsics3.areEqual(type, messageSend) ? this.channelMessageSendCooldownObservables.get(Long.valueOf(channelId)) : this.channelThreadCreateCooldownObservables.get(Long.valueOf(channelId));
        if (observable != null) {
            return observable;
        }
        Observable<Integer> observableH0 = Observable.h0(new OnSubscribeRefCount3(this.stream.getPermissions().observePermissionsForChannel(channelId).G(new StoreSlowMode2(type)).r().Y(new StoreSlowMode3(this, type, channelId)).G(StoreSlowMode4.INSTANCE).w(new StoreSlowMode5(this, channelId, type)).N(1)));
        if (Intrinsics3.areEqual(type, messageSend)) {
            HashMap<Long, Observable<Integer>> map = this.channelMessageSendCooldownObservables;
            Long lValueOf = Long.valueOf(channelId);
            Intrinsics3.checkNotNullExpressionValue(observableH0, "newObservable");
            map.put(lValueOf, observableH0);
        } else {
            HashMap<Long, Observable<Integer>> map2 = this.channelThreadCreateCooldownObservables;
            Long lValueOf2 = Long.valueOf(channelId);
            Intrinsics3.checkNotNullExpressionValue(observableH0, "newObservable");
            map2.put(lValueOf2, observableH0);
        }
        return observableH0;
    }

    @Store3
    private final void onCooldownInternal(long channelId, long cooldownMs, Type type) {
        if (Intrinsics3.areEqual(type, Type.MessageSend.INSTANCE)) {
            this.messageSendNextSendTimes.put(Long.valueOf(channelId), Long.valueOf(this.clock.currentTimeMillis() + cooldownMs));
            this.messageSendNextSendTimesSubject.onNext(new HashMap<>(this.messageSendNextSendTimes));
        } else {
            this.threadCreateNextSendTimes.put(Long.valueOf(channelId), Long.valueOf(this.clock.currentTimeMillis() + cooldownMs));
            this.threadCreateNextSendTimesSubject.onNext(new HashMap<>(this.threadCreateNextSendTimes));
        }
    }

    private final synchronized Observable<Integer> removeChannelCooldownObservable(long channelId, Type type) {
        return Intrinsics3.areEqual(type, Type.MessageSend.INSTANCE) ? this.channelMessageSendCooldownObservables.remove(Long.valueOf(channelId)) : this.channelThreadCreateCooldownObservables.remove(Long.valueOf(channelId));
    }

    public final Observable<Integer> observeCooldownSecs(Long channelId, Type type) {
        Intrinsics3.checkNotNullParameter(type, "type");
        if (channelId != null) {
            return getChannelCooldownObservable(channelId.longValue(), type);
        }
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(0);
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(0)");
        return scalarSynchronousObservable;
    }

    @Store3
    public final void onCooldown(long channelId, long cooldownMs, Type type) {
        Intrinsics3.checkNotNullParameter(type, "type");
        onCooldownInternal(channelId, cooldownMs + 1000, type);
    }

    @Store3
    public final void onMessageSent(long channelId) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(channelId);
        int rateLimitPerUser = channelFindChannelByIdInternal$app_productionGoogleRelease != null ? channelFindChannelByIdInternal$app_productionGoogleRelease.getRateLimitPerUser() : 0;
        if (rateLimitPerUser > 0) {
            onCooldownInternal(channelId, rateLimitPerUser * 1000, Type.MessageSend.INSTANCE);
        }
    }

    @Store3
    public final void onThreadCreated(long parentChannelId) {
        Channel channelFindChannelByIdInternal$app_productionGoogleRelease = this.stream.getChannels().findChannelByIdInternal$app_productionGoogleRelease(parentChannelId);
        int rateLimitPerUser = channelFindChannelByIdInternal$app_productionGoogleRelease != null ? channelFindChannelByIdInternal$app_productionGoogleRelease.getRateLimitPerUser() : 0;
        if (rateLimitPerUser > 0) {
            onCooldownInternal(parentChannelId, rateLimitPerUser * 1000, Type.ThreadCreate.INSTANCE);
        }
    }
}
