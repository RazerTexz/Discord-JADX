package p507d0.p578f0;

import java.util.Iterator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.sequences.Sequence;
import p507d0.p584w.p585h.Intrinsics2;

/* compiled from: SequenceBuilder.kt */
/* renamed from: d0.f0.k, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class SequenceBuilder2<T> {
    public abstract Object yield(T t, Continuation<? super Unit> continuation);

    public abstract Object yieldAll(Iterator<? extends T> it, Continuation<? super Unit> continuation);

    public final Object yieldAll(Sequence<? extends T> sequence, Continuation<? super Unit> continuation) {
        Object objYieldAll = yieldAll(sequence.iterator(), continuation);
        return objYieldAll == Intrinsics2.getCOROUTINE_SUSPENDED() ? objYieldAll : Unit.f27425a;
    }
}
