package androidx.view;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import p507d0.p584w.p585h.Intrinsics2;
import p659s.p660a.p664d2.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Collect.kt */
/* renamed from: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1$invokeSuspend$$inlined$collect$1, reason: use source file name */
/* loaded from: classes.dex */
public final class Collect<T> implements FlowCollector<T> {
    public final /* synthetic */ CoroutineLiveData7 $this_liveData$inlined;

    public Collect(CoroutineLiveData7 coroutineLiveData7) {
        this.$this_liveData$inlined = coroutineLiveData7;
    }

    @Override // p659s.p660a.p664d2.FlowCollector
    public Object emit(Object obj, Continuation continuation) {
        Object objEmit = this.$this_liveData$inlined.emit(obj, continuation);
        return objEmit == Intrinsics2.getCOROUTINE_SUSPENDED() ? objEmit : Unit.f27425a;
    }
}
