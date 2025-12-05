package com.discord.utilities.persister;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.app.AppLog;
import com.discord.utilities.collections.LeastRecentlyAddedSet;
import com.discord.utilities.collections.SnowflakePartitionMap;
import com.discord.utilities.kryo.LeastRecentlyAddedSetSerializer;
import com.discord.utilities.kryo.SnowflakePartitionMapSerializer;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.time.Clock;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serializers.FieldSerializerConfig;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.AppLog2;
import p007b.p008a.p018d.AppState;
import p007b.p008a.p018d.AppState2;
import p007b.p008a.p020e.Backgrounded4;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p617h0.p620b.p627b.StdInstantiatorStrategy;
import p658rx.Observable;
import p658rx.functions.Func2;

/* compiled from: PersisterConfig.kt */
/* loaded from: classes2.dex */
public final class PersisterConfig {
    public static final PersisterConfig INSTANCE = new PersisterConfig();

    /* compiled from: PersisterConfig.kt */
    /* renamed from: com.discord.utilities.persister.PersisterConfig$init$1 */
    public static final class C68331 extends Lambda implements Function1<Kryo, Unit> {
        public static final C68331 INSTANCE = new C68331();

        public C68331() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Kryo kryo) {
            invoke2(kryo);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Kryo kryo) {
            Intrinsics3.checkNotNullParameter(kryo, "it");
            kryo.setInstantiatorStrategy(new Kryo.DefaultInstantiatorStrategy(new StdInstantiatorStrategy()));
            FieldSerializerConfig fieldSerializerConfig = kryo.getFieldSerializerConfig();
            Intrinsics3.checkNotNullExpressionValue(fieldSerializerConfig, "it.fieldSerializerConfig");
            fieldSerializerConfig.setOptimizedGenerics(true);
            kryo.register(LeastRecentlyAddedSet.class, new LeastRecentlyAddedSetSerializer());
            kryo.register(SnowflakePartitionMap.class, new SnowflakePartitionMapSerializer());
        }
    }

    /* compiled from: PersisterConfig.kt */
    /* renamed from: com.discord.utilities.persister.PersisterConfig$isNotActive$1 */
    public static final class C68341<T1, T2, R> implements Func2<Boolean, Boolean, Boolean> {
        public static final C68341 INSTANCE = new C68341();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ Boolean call(Boolean bool, Boolean bool2) {
            return call2(bool, bool2);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Boolean bool, Boolean bool2) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isBackgrounded");
            return Boolean.valueOf(bool.booleanValue() && !bool2.booleanValue());
        }
    }

    private PersisterConfig() {
    }

    private final Observable<Boolean> getPersistenceStrategy() {
        Observable<Boolean> observableM11064I = Observable.m11064I(isNotActive(), Observable.m11068d0(1L, TimeUnit.MINUTES).m11083G(PersisterConfig2.INSTANCE));
        Intrinsics3.checkNotNullExpressionValue(observableM11064I, "Observable\n        .merg…  .map { true }\n        )");
        return observableM11064I;
    }

    private final Observable<Boolean> isNotActive() {
        Observable<Boolean> observableM11093S = Backgrounded4.f600d.m185a().m11093S(1);
        AppState2 appState2 = AppState2.f530c;
        Observable observableM11112r = AppState2.f529b.m11083G(AppState.f526j).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "numGatewayConnectionCons…  .distinctUntilChanged()");
        return Observable.m11076j(observableM11093S, observableM11112r, C68341.INSTANCE).m11112r();
    }

    public final void init(Context context, Clock clock) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Persister.Companion companion = Persister.INSTANCE;
        companion.setKryoConfig(C68331.INSTANCE);
        Objects.requireNonNull(AppLog.f14950g);
        Intrinsics3.checkNotNullParameter("[Persister]", "tag");
        companion.setLogger(new AppLog2("[Persister]"));
        companion.init(context, clock, getPersistenceStrategy());
    }
}
