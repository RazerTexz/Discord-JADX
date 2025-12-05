package p659s.p660a.p664d2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import p507d0.p584w.p585h.Intrinsics2;

/* compiled from: Builders.kt */
/* renamed from: s.a.d2.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class Builders3<T> extends Flow2<T> {

    /* renamed from: a */
    public final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> f27783a;

    /* JADX WARN: Multi-variable type inference failed */
    public Builders3(Function2<? super FlowCollector<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.f27783a = function2;
    }

    @Override // p659s.p660a.p664d2.Flow2
    /* renamed from: b */
    public Object mo11247b(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object objInvoke = this.f27783a.invoke(flowCollector, continuation);
        return objInvoke == Intrinsics2.getCOROUTINE_SUSPENDED() ? objInvoke : Unit.f27425a;
    }
}
