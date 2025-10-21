package com.discord.utilities.device;

import android.content.Context;
import androidx.annotation.AnyThread;
import co.discord.media_engine.CameraEnumeratorProvider;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreStream;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: RtcCameraConfig.kt */
/* loaded from: classes2.dex */
public final class RtcCameraConfig {
    public static final RtcCameraConfig INSTANCE = new RtcCameraConfig();
    private static final AtomicBoolean initialized = new AtomicBoolean();

    /* compiled from: RtcCameraConfig.kt */
    /* renamed from: com.discord.utilities.device.RtcCameraConfig$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Experiment, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Experiment experiment) {
            invoke2(experiment);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Experiment experiment) {
            Intrinsics3.checkNotNullParameter(experiment, "it");
            CameraEnumeratorProvider.INSTANCE.init(ApplicationProvider.INSTANCE.get(), experiment.getBucket() == 1);
        }
    }

    private RtcCameraConfig() {
    }

    private final Observable<Experiment> observeExperiment(StoreExperiments storeExperiments) {
        Observable<R> observableG = storeExperiments.observeUserExperiment("2021-02_android_webrtc_camera2", true).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableZ = observableG.Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "storeExperiments.observe…Null()\n          .take(1)");
        return ObservableExtensionsKt.computationLatest(observableZ);
    }

    @AnyThread
    public final void init() {
        if (initialized.compareAndSet(false, true)) {
            ObservableExtensionsKt.appSubscribe$default(observeExperiment(StoreStream.INSTANCE.getExperiments()), RtcCameraConfig.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
        }
    }
}
