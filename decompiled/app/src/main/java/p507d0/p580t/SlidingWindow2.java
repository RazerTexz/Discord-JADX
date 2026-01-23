package p507d0.p580t;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Result3;
import p507d0.p512d0._Ranges;
import p507d0.p578f0.SequenceBuilder2;
import p507d0.p578f0.SequenceBuilder3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl5;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.t.p0, reason: use source file name */
/* JADX INFO: compiled from: SlidingWindow.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SlidingWindow2 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: d0.t.p0$a */
    /* JADX INFO: compiled from: SlidingWindow.kt */
    @DebugMetadata(m10084c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", m10085f = "SlidingWindow.kt", m10086l = {34, 40, 49, 55, 58}, m10087m = "invokeSuspend")
    public static final class a<T> extends ContinuationImpl5 implements Function2<SequenceBuilder2<? super List<? extends T>>, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Iterator $iterator;
        public final /* synthetic */ boolean $partialWindows;
        public final /* synthetic */ boolean $reuseBuffer;
        public final /* synthetic */ int $size;
        public final /* synthetic */ int $step;
        public int I$0;
        private /* synthetic */ Object L$0;
        public Object L$1;
        public Object L$2;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, int i2, Iterator it, boolean z2, boolean z3, Continuation continuation) {
            super(2, continuation);
            this.$size = i;
            this.$step = i2;
            this.$iterator = it;
            this.$reuseBuffer = z2;
            this.$partialWindows = z3;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            a aVar = new a(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((a) create(obj, continuation)).invokeSuspend(Unit.f27425a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00da A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00ea  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0132  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0152  */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v20, types: [d0.t.a, java.lang.Object, java.util.Collection] */
        /* JADX WARN: Type inference failed for: r1v21, types: [d0.t.l0] */
        /* JADX WARN: Type inference failed for: r1v27 */
        /* JADX WARN: Type inference failed for: r1v28 */
        /* JADX WARN: Type inference failed for: r1v29 */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v12 */
        /* JADX WARN: Type inference failed for: r4v13 */
        /* JADX WARN: Type inference failed for: r4v4 */
        /* JADX WARN: Type inference failed for: r4v5, types: [d0.f0.k, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r5v10, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v12 */
        /* JADX WARN: Type inference failed for: r5v16 */
        /* JADX WARN: Type inference failed for: r5v17 */
        /* JADX WARN: Type inference failed for: r5v18 */
        /* JADX WARN: Type inference failed for: r5v19 */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v20 */
        /* JADX WARN: Type inference failed for: r5v3, types: [d0.t.a, d0.t.l0, java.lang.Object, java.util.Collection] */
        /* JADX WARN: Type inference failed for: r5v4 */
        /* JADX WARN: Type inference failed for: r5v5, types: [d0.t.l0] */
        /* JADX WARN: Type inference failed for: r5v6, types: [d0.t.l0] */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v14 */
        /* JADX WARN: Type inference failed for: r8v15 */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v8, types: [d0.f0.k, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v9 */
        /* JADX WARN: Type inference failed for: r9v10, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v12 */
        /* JADX WARN: Type inference failed for: r9v14 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a7 -> B:30:0x00a8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x011b -> B:59:0x011e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0149 -> B:72:0x014c). Please report as a decompilation issue!!! */
        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            Iterator it;
            ?? r8;
            a<T> aVar;
            int i2;
            SequenceBuilder2 sequenceBuilder2;
            a<T> aVar2;
            ArrayList arrayList;
            Iterator it2;
            ?? Expanded;
            ?? r1;
            ?? r4;
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                Result3.throwOnFailure(obj);
                SequenceBuilder2 sequenceBuilder22 = (SequenceBuilder2) this.L$0;
                int iCoerceAtMost = _Ranges.coerceAtMost(this.$size, 1024);
                i = this.$step - this.$size;
                if (i < 0) {
                    SlidingWindow slidingWindow = new SlidingWindow(iCoerceAtMost);
                    it = this.$iterator;
                    r8 = sequenceBuilder22;
                    aVar = this;
                    Expanded = slidingWindow;
                    while (it.hasNext()) {
                    }
                    if (aVar.$partialWindows) {
                    }
                    return Unit.f27425a;
                }
                ArrayList arrayList2 = new ArrayList(iCoerceAtMost);
                i2 = 0;
                sequenceBuilder2 = sequenceBuilder22;
                aVar2 = this;
                arrayList = arrayList2;
                it2 = this.$iterator;
                while (it2.hasNext()) {
                }
                if (!arrayList.isEmpty()) {
                    aVar2.L$0 = null;
                    aVar2.L$1 = null;
                    aVar2.L$2 = null;
                    aVar2.label = 2;
                    if (sequenceBuilder2.yield(arrayList, aVar2) == coroutine_suspended) {
                    }
                }
                return Unit.f27425a;
            }
            if (i3 == 1) {
                i2 = this.I$0;
                it2 = (Iterator) this.L$2;
                arrayList = (ArrayList) this.L$1;
                sequenceBuilder2 = (SequenceBuilder2) this.L$0;
                Result3.throwOnFailure(obj);
                aVar2 = this;
                if (aVar2.$reuseBuffer) {
                    arrayList = new ArrayList(aVar2.$size);
                } else {
                    arrayList.clear();
                }
                i = i2;
                while (it2.hasNext()) {
                    Object next = it2.next();
                    if (i2 > 0) {
                        i2--;
                    } else {
                        arrayList.add(next);
                        if (arrayList.size() == aVar2.$size) {
                            aVar2.L$0 = sequenceBuilder2;
                            aVar2.L$1 = arrayList;
                            aVar2.L$2 = it2;
                            aVar2.I$0 = i;
                            aVar2.label = 1;
                            if (sequenceBuilder2.yield(arrayList, aVar2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            i2 = i;
                            if (aVar2.$reuseBuffer) {
                            }
                            i = i2;
                            while (it2.hasNext()) {
                            }
                        }
                    }
                }
                if ((!arrayList.isEmpty()) && (aVar2.$partialWindows || arrayList.size() == aVar2.$size)) {
                    aVar2.L$0 = null;
                    aVar2.L$1 = null;
                    aVar2.L$2 = null;
                    aVar2.label = 2;
                    if (sequenceBuilder2.yield(arrayList, aVar2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.f27425a;
            }
            if (i3 != 2) {
                if (i3 == 3) {
                    it = (Iterator) this.L$2;
                    SlidingWindow slidingWindow2 = (SlidingWindow) this.L$1;
                    SequenceBuilder2 sequenceBuilder23 = (SequenceBuilder2) this.L$0;
                    Result3.throwOnFailure(obj);
                    aVar = this;
                    ?? r5 = slidingWindow2;
                    ?? r82 = sequenceBuilder23;
                    r5.removeFirst(aVar.$step);
                    Expanded = r5;
                    r8 = r82;
                    while (it.hasNext()) {
                        Expanded.add(it.next());
                        if (Expanded.isFull()) {
                            int size = Expanded.size();
                            int i4 = aVar.$size;
                            if (size >= i4) {
                                ?? arrayList3 = aVar.$reuseBuffer ? Expanded : new ArrayList((Collection) Expanded);
                                aVar.L$0 = r8;
                                aVar.L$1 = Expanded;
                                aVar.L$2 = it;
                                aVar.label = 3;
                                Object objYield = r8.yield(arrayList3, aVar);
                                r5 = Expanded;
                                r82 = r8;
                                if (objYield == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                r5.removeFirst(aVar.$step);
                                Expanded = r5;
                                r8 = r82;
                                while (it.hasNext()) {
                                }
                            } else {
                                Expanded = Expanded.expanded(i4);
                            }
                        }
                    }
                    if (aVar.$partialWindows) {
                        r1 = Expanded;
                        r4 = r8;
                        if (r1.size() <= aVar.$step) {
                        }
                    }
                    return Unit.f27425a;
                }
                if (i3 == 4) {
                    SlidingWindow slidingWindow3 = (SlidingWindow) this.L$1;
                    SequenceBuilder2 sequenceBuilder24 = (SequenceBuilder2) this.L$0;
                    Result3.throwOnFailure(obj);
                    aVar = this;
                    ?? r12 = slidingWindow3;
                    ?? r42 = sequenceBuilder24;
                    r12.removeFirst(aVar.$step);
                    r1 = r12;
                    r4 = r42;
                    if (r1.size() <= aVar.$step) {
                        ?? arrayList4 = aVar.$reuseBuffer ? r1 : new ArrayList((Collection) r1);
                        aVar.L$0 = r4;
                        aVar.L$1 = r1;
                        aVar.L$2 = null;
                        aVar.label = 4;
                        Object objYield2 = r4.yield(arrayList4, aVar);
                        r12 = r1;
                        r42 = r4;
                        if (objYield2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        r12.removeFirst(aVar.$step);
                        r1 = r12;
                        r4 = r42;
                        if (r1.size() <= aVar.$step) {
                            if (!r1.isEmpty()) {
                                aVar.L$0 = null;
                                aVar.L$1 = null;
                                aVar.L$2 = null;
                                aVar.label = 5;
                                if (r4.yield(r1, aVar) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.f27425a;
                        }
                    }
                } else if (i3 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            Result3.throwOnFailure(obj);
            return Unit.f27425a;
        }
    }

    public static final void checkWindowSizeStep(int i, int i2) {
        String strM873r;
        if (i > 0 && i2 > 0) {
            return;
        }
        if (i != i2) {
            strM873r = "Both size " + i + " and step " + i2 + " must be greater than zero.";
        } else {
            strM873r = outline.m873r("size ", i, " must be greater than zero.");
        }
        throw new IllegalArgumentException(strM873r.toString());
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> it, int i, int i2, boolean z2, boolean z3) {
        Intrinsics3.checkNotNullParameter(it, "iterator");
        return !it.hasNext() ? Collections3.f25220j : SequenceBuilder3.iterator(new a(i, i2, it, z3, z2, null));
    }
}
