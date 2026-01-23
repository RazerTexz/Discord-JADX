package com.discord.stores;

import co.discord.media_engine.DeviceDescription4;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import p507d0.Result2;
import p507d0.p584w.Continuation2;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: StoreMediaEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreMediaEngine$getVideoInputDevicesNativeAsync$2$1 extends FunctionReferenceImpl implements Function1<DeviceDescription4[], Unit> {
    public StoreMediaEngine$getVideoInputDevicesNativeAsync$2$1(CancellableContinuation cancellableContinuation) {
        super(1, cancellableContinuation, Continuation2.class, "resume", "resume(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DeviceDescription4[] deviceDescription4Arr) {
        invoke2(deviceDescription4Arr);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DeviceDescription4[] deviceDescription4Arr) {
        Intrinsics3.checkNotNullParameter(deviceDescription4Arr, "p1");
        CancellableContinuation cancellableContinuation = (CancellableContinuation) this.receiver;
        Result2.a aVar = Result2.f25169j;
        cancellableContinuation.resumeWith(Result2.m11474constructorimpl(deviceDescription4Arr));
    }
}
