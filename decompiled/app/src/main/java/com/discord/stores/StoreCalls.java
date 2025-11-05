package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.voice.state.VoiceState;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelCall;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.voice.call.WidgetCallFailed;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import j0.l.e.k;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* compiled from: StoreCalls.kt */
/* loaded from: classes2.dex */
public final class StoreCalls {
    private final HashMap<Long, ModelCall> calls;
    private final SerializedSubject<HashMap<Long, ModelCall>, HashMap<Long, ModelCall>> callsSubject;
    private boolean connectionReady;
    private long selectedChannelId;
    private long selectedGuildId;
    private final StoreStream stream;

    /* compiled from: StoreCalls.kt */
    /* renamed from: com.discord.stores.StoreCalls$call$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Boolean, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            StoreCalls.access$getStream$p(StoreCalls.this).getVoiceChannelSelected().selectVoiceChannel(this.$channelId);
            if (z2) {
                StoreCalls.ring$default(StoreCalls.this, this.$channelId, null, 2, null);
            }
        }
    }

    /* compiled from: StoreCalls.kt */
    /* renamed from: com.discord.stores.StoreCalls$call$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Long, Unit> {
        public final /* synthetic */ AppComponent $appComponent;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ AnonymousClass1 $doCall$1;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ Function0 $onError;

        /* compiled from: StoreCalls.kt */
        /* renamed from: com.discord.stores.StoreCalls$call$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements b<Integer, Observable<? extends Boolean>> {

            /* compiled from: StoreCalls.kt */
            /* renamed from: com.discord.stores.StoreCalls$call$2$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C02151<T, R> implements b<ModelCall.Ringable, Boolean> {
                public static final C02151 INSTANCE = new C02151();

                @Override // j0.k.b
                public /* bridge */ /* synthetic */ Boolean call(ModelCall.Ringable ringable) {
                    return call2(ringable);
                }

                /* renamed from: call, reason: avoid collision after fix types in other method */
                public final Boolean call2(ModelCall.Ringable ringable) {
                    m.checkNotNullExpressionValue(ringable, "it");
                    return Boolean.valueOf(ringable.isRingable());
                }
            }

            public AnonymousClass1() {
            }

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Integer num) {
                return call2(num);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Boolean> call2(Integer num) {
                return (num != null && num.intValue() == 1) ? new k(Boolean.TRUE) : ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().call(AnonymousClass2.this.$channelId), false, 1, null).G(C02151.INSTANCE);
            }
        }

        /* compiled from: StoreCalls.kt */
        /* renamed from: com.discord.stores.StoreCalls$call$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C02162 extends o implements Function1<Boolean, Unit> {
            public C02162() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                AnonymousClass1 anonymousClass1 = AnonymousClass2.this.$doCall$1;
                m.checkNotNullExpressionValue(bool, "isRingable");
                anonymousClass1.invoke(bool.booleanValue());
            }
        }

        /* compiled from: StoreCalls.kt */
        /* renamed from: com.discord.stores.StoreCalls$call$2$3, reason: invalid class name */
        public static final class AnonymousClass3 extends o implements Function1<Error, Unit> {
            public final /* synthetic */ long $userId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(long j) {
                super(1);
                this.$userId = j;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                m.checkNotNullParameter(error, "error");
                Function0 function0 = AnonymousClass2.this.$onError;
                if (function0 != null) {
                }
                Error.Response response = error.getResponse();
                m.checkNotNullExpressionValue(response, "error.response");
                if (response.getCode() == 50013) {
                    error.setShowErrorToasts(false);
                    WidgetCallFailed.INSTANCE.show(AnonymousClass2.this.$fragmentManager, this.$userId);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j, AppComponent appComponent, Context context, AnonymousClass1 anonymousClass1, Function0 function0, FragmentManager fragmentManager) {
            super(1);
            this.$channelId = j;
            this.$appComponent = appComponent;
            this.$context = context;
            this.$doCall$1 = anonymousClass1;
            this.$onError = function0;
            this.$fragmentManager = fragmentManager;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            Observable<R> observableA = StoreStream.INSTANCE.getUserRelationships().observe(j).A(new AnonymousClass1());
            m.checkNotNullExpressionValue(observableA, "StoreStream\n          .g…            }\n          }");
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableA, 0L, false, 3, null), this.$appComponent, null, 2, null);
            Context context = this.$context;
            ObservableExtensionsKt.appSubscribe$default(observableUi$default, StoreCalls.this.getClass(), context, (Function1) null, new AnonymousClass3(j), (Function0) null, (Function0) null, new C02162(), 52, (Object) null);
        }
    }

    /* compiled from: StoreCalls.kt */
    /* renamed from: com.discord.stores.StoreCalls$call$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Channel, Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
            return Boolean.valueOf(invoke2(channel));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Channel channel) {
            return channel != null;
        }
    }

    /* compiled from: StoreCalls.kt */
    /* renamed from: com.discord.stores.StoreCalls$call$4, reason: invalid class name */
    public static final class AnonymousClass4<T1, T2, R> implements Func2<Channel, Map<Long, ? extends VoiceState>, Pair<? extends Channel, ? extends Map<Long, ? extends VoiceState>>> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Pair<? extends Channel, ? extends Map<Long, ? extends VoiceState>> call(Channel channel, Map<Long, ? extends VoiceState> map) {
            return call2(channel, (Map<Long, VoiceState>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Pair<Channel, Map<Long, VoiceState>> call2(Channel channel, Map<Long, VoiceState> map) {
            return new Pair<>(channel, map);
        }
    }

    /* compiled from: StoreCalls.kt */
    /* renamed from: com.discord.stores.StoreCalls$call$5, reason: invalid class name */
    public static final class AnonymousClass5 extends o implements Function1<Pair<? extends Channel, ? extends Map<Long, ? extends VoiceState>>, Unit> {
        public final /* synthetic */ AnonymousClass1 $doCall$1;
        public final /* synthetic */ AnonymousClass2 $doCallIfCallable$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(AnonymousClass2 anonymousClass2, AnonymousClass1 anonymousClass1) {
            super(1);
            this.$doCallIfCallable$2 = anonymousClass2;
            this.$doCall$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Channel, ? extends Map<Long, ? extends VoiceState>> pair) {
            invoke2((Pair<Channel, ? extends Map<Long, VoiceState>>) pair);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Pair<Channel, ? extends Map<Long, VoiceState>> pair) {
            Channel channelComponent1 = pair.component1();
            Map<Long, VoiceState> mapComponent2 = pair.component2();
            User userA = channelComponent1 != null ? ChannelUtils.a(channelComponent1) : null;
            if (userA != null) {
                this.$doCallIfCallable$2.invoke(userA.getId());
            } else if (channelComponent1 != null) {
                this.$doCall$1.invoke(mapComponent2.isEmpty());
            }
        }
    }

    /* compiled from: StoreCalls.kt */
    /* renamed from: com.discord.stores.StoreCalls$findCall$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ModelCall, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ModelCall modelCall) {
            return Boolean.valueOf(invoke2(modelCall));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(ModelCall modelCall) {
            return modelCall != null;
        }
    }

    /* compiled from: StoreCalls.kt */
    /* renamed from: com.discord.stores.StoreCalls$get$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<HashMap<Long, ModelCall>, ModelCall> {
        public final /* synthetic */ long $channelId;

        public AnonymousClass1(long j) {
            this.$channelId = j;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ ModelCall call(HashMap<Long, ModelCall> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final ModelCall call2(HashMap<Long, ModelCall> map) {
            return map.get(Long.valueOf(this.$channelId));
        }
    }

    /* compiled from: StoreCalls.kt */
    /* renamed from: com.discord.stores.StoreCalls$ring$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ModelCall, Unit> {
        public final /* synthetic */ List $recipients;

        /* compiled from: StoreCalls.kt */
        /* renamed from: com.discord.stores.StoreCalls$ring$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02171 extends o implements Function1<Void, Unit> {
            public static final C02171 INSTANCE = new C02171();

            public C02171() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list) {
            super(1);
            this.$recipients = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelCall modelCall) {
            invoke2(modelCall);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelCall modelCall) {
            if (modelCall != null) {
                ObservableExtensionsKt.appSubscribe$default(RestAPI.INSTANCE.getApi().ring(modelCall.getChannelId(), modelCall.getMessageId(), this.$recipients), StoreCalls.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, C02171.INSTANCE, 62, (Object) null);
            }
        }
    }

    /* compiled from: StoreCalls.kt */
    /* renamed from: com.discord.stores.StoreCalls$stopRinging$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ModelCall, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ List $recipients;

        /* compiled from: StoreCalls.kt */
        /* renamed from: com.discord.stores.StoreCalls$stopRinging$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02181 extends o implements Function1<Void, Unit> {
            public static final C02181 INSTANCE = new C02181();

            public C02181() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, List list) {
            super(1);
            this.$channelId = j;
            this.$recipients = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelCall modelCall) {
            invoke2(modelCall);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelCall modelCall) {
            if (modelCall == null) {
                StoreCalls.access$getStream$p(StoreCalls.this).getCallsIncoming().removeIncomingCall(this.$channelId);
            } else {
                ObservableExtensionsKt.appSubscribe$default(RestAPI.INSTANCE.getApi().stopRinging(modelCall.getChannelId(), modelCall.getMessageId(), this.$recipients), StoreCalls.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, C02181.INSTANCE, 62, (Object) null);
            }
        }
    }

    public StoreCalls(StoreStream storeStream) {
        m.checkNotNullParameter(storeStream, "stream");
        this.stream = storeStream;
        this.calls = new HashMap<>();
        this.callsSubject = new SerializedSubject<>(BehaviorSubject.k0());
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreCalls storeCalls) {
        return storeCalls.stream;
    }

    public static /* synthetic */ void call$default(StoreCalls storeCalls, AppComponent appComponent, Context context, FragmentManager fragmentManager, long j, Function0 function0, int i, Object obj) {
        if ((i & 16) != 0) {
            function0 = null;
        }
        storeCalls.call(appComponent, context, fragmentManager, j, function0);
    }

    private final void callConnect() {
        if (this.connectionReady && this.selectedGuildId == 0) {
            long j = this.selectedChannelId;
            if (j <= 0 || this.calls.containsKey(Long.valueOf(j))) {
                return;
            }
            this.calls.put(Long.valueOf(this.selectedChannelId), null);
            this.stream.getGatewaySocket().callConnect(this.selectedChannelId);
        }
    }

    private final void callSubjectUpdate(boolean updated) {
        if (updated) {
            SerializedSubject<HashMap<Long, ModelCall>, HashMap<Long, ModelCall>> serializedSubject = this.callsSubject;
            serializedSubject.k.onNext(new HashMap<>(this.calls));
        }
    }

    public static /* synthetic */ void callSubjectUpdate$default(StoreCalls storeCalls, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        storeCalls.callSubjectUpdate(z2);
    }

    private final void findCall(long channelId, Function1<? super ModelCall, Unit> onFoundCall) {
        Observable<R> observableK = get(channelId).k(b.a.d.o.c(AnonymousClass1.INSTANCE, null, 3L, TimeUnit.SECONDS));
        m.checkNotNullExpressionValue(observableK, "get(channelId)\n        .…l?, 3, TimeUnit.SECONDS))");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableK, 0L, false, 3, null), StoreCalls.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, onFoundCall, 62, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void ring$default(StoreCalls storeCalls, long j, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        storeCalls.ring(j, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void stopRinging$default(StoreCalls storeCalls, long j, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = null;
        }
        storeCalls.stopRinging(j, list);
    }

    public final void call(AppComponent appComponent, Context context, FragmentManager fragmentManager, long channelId, Function0<Unit> onError) {
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(channelId);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(channelId, appComponent, context, anonymousClass1, onError, fragmentManager);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableZ = Observable.j0(companion.getChannels().observeChannel(channelId).k(b.a.d.o.c(AnonymousClass3.INSTANCE, null, 5000L, TimeUnit.MILLISECONDS)), companion.getVoiceStates().observeForPrivateChannels(channelId), AnonymousClass4.INSTANCE).Z(1);
        m.checkNotNullExpressionValue(observableZ, "Observable\n        .zip(…tates) }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableZ, StoreCalls.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass5(anonymousClass2, anonymousClass1), 62, (Object) null);
    }

    public final Observable<ModelCall> get(long channelId) {
        Observable<R> observableG = this.callsSubject.G(new AnonymousClass1(channelId));
        m.checkNotNullExpressionValue(observableG, "callsSubject\n          .…lls -> calls[channelId] }");
        Observable<ModelCall> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        m.checkNotNullExpressionValue(observableR, "callsSubject\n          .…  .distinctUntilChanged()");
        return observableR;
    }

    public final void handleCallCreateOrUpdate(ModelCall call) {
        m.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        long channelId = call.getChannelId();
        boolean z2 = true;
        if (!m.areEqual(call, this.calls.get(Long.valueOf(channelId)))) {
            this.calls.put(Long.valueOf(channelId), call);
        } else {
            z2 = false;
        }
        callSubjectUpdate(z2);
    }

    public final void handleCallDelete(ModelCall callDelete) {
        m.checkNotNullParameter(callDelete, "callDelete");
        long channelId = callDelete.getChannelId();
        if (this.calls.containsKey(Long.valueOf(channelId))) {
            this.calls.put(Long.valueOf(channelId), null);
            callSubjectUpdate$default(this, false, 1, null);
        }
    }

    public final void handleChannelSelect(long channelId) {
        this.selectedChannelId = channelId;
        callConnect();
    }

    public final void handleConnectionOpen() {
        this.calls.clear();
        callSubjectUpdate$default(this, false, 1, null);
        callConnect();
    }

    public final void handleConnectionReady(boolean connectionReady) {
        this.connectionReady = connectionReady;
        callConnect();
    }

    public final void handleGuildSelect(long guildId) {
        this.selectedGuildId = guildId;
        callConnect();
    }

    public final void ring(long channelId, List<Long> recipients) {
        findCall(channelId, new AnonymousClass1(recipients));
    }

    public final void stopRinging(long channelId, List<Long> recipients) {
        findCall(channelId, new AnonymousClass1(channelId, recipients));
    }
}
