package com.discord.stores;

import co.discord.media_engine.VideoInputDeviceDescription;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: StoreMediaEngine.kt */
@e(c = "com.discord.stores.StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1", f = "StoreMediaEngine.kt", l = {266}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 extends k implements Function2<CoroutineScope, Continuation<? super VideoInputDeviceDescription[]>, Object> {
    public int label;
    public final /* synthetic */ StoreMediaEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1(StoreMediaEngine storeMediaEngine, Continuation continuation) {
        super(2, continuation);
        this.this$0 = storeMediaEngine;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        return new StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super VideoInputDeviceDescription[]> continuation) {
        return ((StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0028 -> B:13:0x002c). Please report as a decompilation issue!!! */
    @Override // d0.w.i.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1;
        Object videoInputDevicesNativeAsync;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            l.throwOnFailure(obj);
            storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 = this;
            StoreMediaEngine storeMediaEngine = storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1.this$0;
            storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1.label = 1;
            videoInputDevicesNativeAsync = storeMediaEngine.getVideoInputDevicesNativeAsync(storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1);
            if (videoInputDevicesNativeAsync != coroutine_suspended) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            l.throwOnFailure(obj);
            Object obj2 = coroutine_suspended;
            StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$12 = this;
            VideoInputDeviceDescription[] videoInputDeviceDescriptionArr = (VideoInputDeviceDescription[]) obj;
            if (!(videoInputDeviceDescriptionArr.length != 0)) {
                if (StoreMediaEngine.access$getHasTimedOutAwaitingDevice$p(storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$12.this$0)) {
                    return null;
                }
                storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 = storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$12;
                coroutine_suspended = obj2;
                StoreMediaEngine storeMediaEngine2 = storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1.this$0;
                storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1.label = 1;
                videoInputDevicesNativeAsync = storeMediaEngine2.getVideoInputDevicesNativeAsync(storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1);
                if (videoInputDevicesNativeAsync != coroutine_suspended) {
                    return coroutine_suspended;
                }
                Object obj3 = coroutine_suspended;
                storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$12 = storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1;
                obj = videoInputDevicesNativeAsync;
                obj2 = obj3;
                VideoInputDeviceDescription[] videoInputDeviceDescriptionArr2 = (VideoInputDeviceDescription[]) obj;
                if (!(videoInputDeviceDescriptionArr2.length != 0)) {
                    return videoInputDeviceDescriptionArr2;
                }
            }
        }
    }
}
