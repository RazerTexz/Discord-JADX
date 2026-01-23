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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.voice.call.WidgetCallFailed;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0879o;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func2;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreCalls.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCalls {
    private final HashMap<Long, ModelCall> calls;
    private final SerializedSubject<HashMap<Long, ModelCall>, HashMap<Long, ModelCall>> callsSubject;
    private boolean connectionReady;
    private long selectedChannelId;
    private long selectedGuildId;
    private final StoreStream stream;

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$1 */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class C57961 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57961(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            StoreCalls.access$getStream$p(StoreCalls.this).getVoiceChannelSelected().selectVoiceChannel(this.$channelId);
            if (z2) {
                StoreCalls.ring$default(StoreCalls.this, this.$channelId, null, 2, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$2 */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class C57972 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ AppComponent $appComponent;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ C57961 $doCall$1;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ Function0 $onError;

        /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreCalls.kt */
        public static final class AnonymousClass1<T, R> implements Func1<Integer, Observable<? extends Boolean>> {

            /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreCalls.kt */
            public static final class C132501<T, R> implements Func1<ModelCall.Ringable, Boolean> {
                public static final C132501 INSTANCE = new C132501();

                @Override // p637j0.p641k.Func1
                public /* bridge */ /* synthetic */ Boolean call(ModelCall.Ringable ringable) {
                    return call2(ringable);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Boolean call2(ModelCall.Ringable ringable) {
                    Intrinsics3.checkNotNullExpressionValue(ringable, "it");
                    return Boolean.valueOf(ringable.isRingable());
                }
            }

            public AnonymousClass1() {
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Integer num) {
                return call2(num);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Boolean> call2(Integer num) {
                return (num != null && num.intValue() == 1) ? new ScalarSynchronousObservable(Boolean.TRUE) : ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().call(C57972.this.$channelId), false, 1, null).m11083G(C132501.INSTANCE);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreCalls.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                C57961 c57961 = C57972.this.$doCall$1;
                Intrinsics3.checkNotNullExpressionValue(bool, "isRingable");
                c57961.invoke(bool.booleanValue());
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: StoreCalls.kt */
        public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
            public final /* synthetic */ long $userId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(long j) {
                super(1);
                this.$userId = j;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                Function0 function0 = C57972.this.$onError;
                if (function0 != null) {
                }
                Error.Response response = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                if (response.getCode() == 50013) {
                    error.setShowErrorToasts(false);
                    WidgetCallFailed.INSTANCE.show(C57972.this.$fragmentManager, this.$userId);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C57972(long j, AppComponent appComponent, Context context, C57961 c57961, Function0 function0, FragmentManager fragmentManager) {
            super(1);
            this.$channelId = j;
            this.$appComponent = appComponent;
            this.$context = context;
            this.$doCall$1 = c57961;
            this.$onError = function0;
            this.$fragmentManager = fragmentManager;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            Observable<R> observableM11082A = StoreStream.INSTANCE.getUserRelationships().observe(j).m11082A(new AnonymousClass1());
            Intrinsics3.checkNotNullExpressionValue(observableM11082A, "StoreStream\n          .g…            }\n          }");
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11082A, 0L, false, 3, null), this.$appComponent, null, 2, null);
            Context context = this.$context;
            ObservableExtensionsKt.appSubscribe$default(observableUi$default, StoreCalls.this.getClass(), context, (Function1) null, new AnonymousClass3(j), (Function0) null, (Function0) null, new AnonymousClass2(), 52, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$3 */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class C57983 extends Lambda implements Function1<Channel, Boolean> {
        public static final C57983 INSTANCE = new C57983();

        public C57983() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
            return Boolean.valueOf(invoke2(channel));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Channel channel) {
            return channel != null;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$4 */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class C57994<T1, T2, R> implements Func2<Channel, Map<Long, ? extends VoiceState>, Tuples2<? extends Channel, ? extends Map<Long, ? extends VoiceState>>> {
        public static final C57994 INSTANCE = new C57994();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ Tuples2<? extends Channel, ? extends Map<Long, ? extends VoiceState>> call(Channel channel, Map<Long, ? extends VoiceState> map) {
            return call2(channel, (Map<Long, VoiceState>) map);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Tuples2<Channel, Map<Long, VoiceState>> call2(Channel channel, Map<Long, VoiceState> map) {
            return new Tuples2<>(channel, map);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$call$5 */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class C58005 extends Lambda implements Function1<Tuples2<? extends Channel, ? extends Map<Long, ? extends VoiceState>>, Unit> {
        public final /* synthetic */ C57961 $doCall$1;
        public final /* synthetic */ C57972 $doCallIfCallable$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58005(C57972 c57972, C57961 c57961) {
            super(1);
            this.$doCallIfCallable$2 = c57972;
            this.$doCall$1 = c57961;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends Channel, ? extends Map<Long, ? extends VoiceState>> tuples2) {
            invoke2((Tuples2<Channel, ? extends Map<Long, VoiceState>>) tuples2);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<Channel, ? extends Map<Long, VoiceState>> tuples2) {
            Channel channelComponent1 = tuples2.component1();
            Map<Long, VoiceState> mapComponent2 = tuples2.component2();
            User userM7677a = channelComponent1 != null ? ChannelUtils.m7677a(channelComponent1) : null;
            if (userM7677a != null) {
                this.$doCallIfCallable$2.invoke(userM7677a.getId());
            } else if (channelComponent1 != null) {
                this.$doCall$1.invoke(mapComponent2.isEmpty());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$findCall$1 */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class C58011 extends Lambda implements Function1<ModelCall, Boolean> {
        public static final C58011 INSTANCE = new C58011();

        public C58011() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(ModelCall modelCall) {
            return Boolean.valueOf(invoke2(modelCall));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(ModelCall modelCall) {
            return modelCall != null;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$get$1 */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class C58021<T, R> implements Func1<HashMap<Long, ModelCall>, ModelCall> {
        public final /* synthetic */ long $channelId;

        public C58021(long j) {
            this.$channelId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ ModelCall call(HashMap<Long, ModelCall> map) {
            return call2(map);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final ModelCall call2(HashMap<Long, ModelCall> map) {
            return map.get(Long.valueOf(this.$channelId));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$ring$1 */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class C58031 extends Lambda implements Function1<ModelCall, Unit> {
        public final /* synthetic */ List $recipients;

        /* JADX INFO: renamed from: com.discord.stores.StoreCalls$ring$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreCalls.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58031(List list) {
            super(1);
            this.$recipients = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelCall modelCall) {
            invoke2(modelCall);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelCall modelCall) {
            if (modelCall != null) {
                ObservableExtensionsKt.appSubscribe$default(RestAPI.INSTANCE.getApi().ring(modelCall.getChannelId(), modelCall.getMessageId(), this.$recipients), StoreCalls.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCalls$stopRinging$1 */
    /* JADX INFO: compiled from: StoreCalls.kt */
    public static final class C58041 extends Lambda implements Function1<ModelCall, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ List $recipients;

        /* JADX INFO: renamed from: com.discord.stores.StoreCalls$stopRinging$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreCalls.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58041(long j, List list) {
            super(1);
            this.$channelId = j;
            this.$recipients = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelCall modelCall) {
            invoke2(modelCall);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelCall modelCall) {
            if (modelCall == null) {
                StoreCalls.access$getStream$p(StoreCalls.this).getCallsIncoming().removeIncomingCall(this.$channelId);
            } else {
                ObservableExtensionsKt.appSubscribe$default(RestAPI.INSTANCE.getApi().stopRinging(modelCall.getChannelId(), modelCall.getMessageId(), this.$recipients), StoreCalls.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
            }
        }
    }

    public StoreCalls(StoreStream storeStream) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        this.stream = storeStream;
        this.calls = new HashMap<>();
        this.callsSubject = new SerializedSubject<>(BehaviorSubject.m11129k0());
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreCalls storeCalls) {
        return storeCalls.stream;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
            serializedSubject.f27653k.onNext(new HashMap<>(this.calls));
        }
    }

    public static /* synthetic */ void callSubjectUpdate$default(StoreCalls storeCalls, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        storeCalls.callSubjectUpdate(z2);
    }

    private final void findCall(long channelId, Function1<? super ModelCall, Unit> onFoundCall) {
        Observable<R> observableM11108k = get(channelId).m11108k(C0879o.m177c(C58011.INSTANCE, null, 3L, TimeUnit.SECONDS));
        Intrinsics3.checkNotNullExpressionValue(observableM11108k, "get(channelId)\n        .…l?, 3, TimeUnit.SECONDS))");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11108k, 0L, false, 3, null), StoreCalls.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, onFoundCall, 62, (Object) null);
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
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        C57961 c57961 = new C57961(channelId);
        C57972 c57972 = new C57972(channelId, appComponent, context, c57961, onError, fragmentManager);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableM11100Z = Observable.m11077j0(companion.getChannels().observeChannel(channelId).m11108k(C0879o.m177c(C57983.INSTANCE, null, 5000L, TimeUnit.MILLISECONDS)), companion.getVoiceStates().observeForPrivateChannels(channelId), C57994.INSTANCE).m11100Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableM11100Z, "Observable\n        .zip(…tates) }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableM11100Z, StoreCalls.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C58005(c57972, c57961), 62, (Object) null);
    }

    public final Observable<ModelCall> get(long channelId) {
        Observable<R> observableM11083G = this.callsSubject.m11083G(new C58021(channelId));
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "callsSubject\n          .…lls -> calls[channelId] }");
        Observable<ModelCall> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11083G).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "callsSubject\n          .…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final void handleCallCreateOrUpdate(ModelCall call) {
        Intrinsics3.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        long channelId = call.getChannelId();
        boolean z2 = true;
        if (!Intrinsics3.areEqual(call, this.calls.get(Long.valueOf(channelId)))) {
            this.calls.put(Long.valueOf(channelId), call);
        } else {
            z2 = false;
        }
        callSubjectUpdate(z2);
    }

    public final void handleCallDelete(ModelCall callDelete) {
        Intrinsics3.checkNotNullParameter(callDelete, "callDelete");
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
        findCall(channelId, new C58031(recipients));
    }

    public final void stopRinging(long channelId, List<Long> recipients) {
        findCall(channelId, new C58041(channelId, recipients));
    }
}
