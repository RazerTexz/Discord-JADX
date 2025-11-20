package d0.t;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* compiled from: SlidingWindow.kt */
/* loaded from: classes3.dex */
public final class p0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SlidingWindow.kt */
    @d0.w.i.a.e(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", l = {34, 40, 49, 55, 58}, m = "invokeSuspend")
    public static final class a<T> extends d0.w.i.a.j implements Function2<d0.f0.k<? super List<? extends T>>, Continuation<? super Unit>, Object> {
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

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d0.z.d.m.checkNotNullParameter(continuation, "completion");
            a aVar = new a(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return ((a) create(obj, continuation)).invokeSuspend(Unit.a);
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
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a7 -> B:30:0x00a8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x011b -> B:59:0x011e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0149 -> B:72:0x014c). Please report as a decompilation issue!!! */
        @Override // d0.w.i.a.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            Iterator it;
            d0.f0.k kVar;
            a<T> aVar;
            int i2;
            d0.f0.k kVar2;
            a<T> aVar2;
            ArrayList arrayList;
            Iterator it2;
            l0 l0VarExpanded;
            l0 l0Var;
            d0.f0.k kVar3;
            Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                d0.l.throwOnFailure(obj);
                d0.f0.k kVar4 = (d0.f0.k) this.L$0;
                int iCoerceAtMost = d0.d0.f.coerceAtMost(this.$size, 1024);
                i = this.$step - this.$size;
                if (i < 0) {
                    l0 l0Var2 = new l0(iCoerceAtMost);
                    it = this.$iterator;
                    kVar = kVar4;
                    aVar = this;
                    l0VarExpanded = l0Var2;
                    while (it.hasNext()) {
                    }
                    if (aVar.$partialWindows) {
                    }
                    return Unit.a;
                }
                ArrayList arrayList2 = new ArrayList(iCoerceAtMost);
                i2 = 0;
                kVar2 = kVar4;
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
                    if (kVar2.yield(arrayList, aVar2) == coroutine_suspended) {
                    }
                }
                return Unit.a;
            }
            if (i3 == 1) {
                i2 = this.I$0;
                it2 = (Iterator) this.L$2;
                arrayList = (ArrayList) this.L$1;
                kVar2 = (d0.f0.k) this.L$0;
                d0.l.throwOnFailure(obj);
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
                            aVar2.L$0 = kVar2;
                            aVar2.L$1 = arrayList;
                            aVar2.L$2 = it2;
                            aVar2.I$0 = i;
                            aVar2.label = 1;
                            if (kVar2.yield(arrayList, aVar2) == coroutine_suspended) {
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
                    if (kVar2.yield(arrayList, aVar2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.a;
            }
            if (i3 != 2) {
                if (i3 == 3) {
                    it = (Iterator) this.L$2;
                    l0 l0Var3 = (l0) this.L$1;
                    kVar = (d0.f0.k) this.L$0;
                    d0.l.throwOnFailure(obj);
                    aVar = this;
                    l0 l0Var4 = l0Var3;
                    l0Var4.removeFirst(aVar.$step);
                    l0VarExpanded = l0Var4;
                    while (it.hasNext()) {
                        l0VarExpanded.add(it.next());
                        if (l0VarExpanded.isFull()) {
                            int size = l0VarExpanded.size();
                            int i4 = aVar.$size;
                            if (size >= i4) {
                                ArrayList arrayList3 = aVar.$reuseBuffer ? l0VarExpanded : new ArrayList(l0VarExpanded);
                                aVar.L$0 = kVar;
                                aVar.L$1 = l0VarExpanded;
                                aVar.L$2 = it;
                                aVar.label = 3;
                                l0Var4 = l0VarExpanded;
                                if (kVar.yield(arrayList3, aVar) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                l0Var4.removeFirst(aVar.$step);
                                l0VarExpanded = l0Var4;
                                while (it.hasNext()) {
                                }
                            } else {
                                l0VarExpanded = l0VarExpanded.expanded(i4);
                            }
                        }
                    }
                    if (aVar.$partialWindows) {
                        l0Var = l0VarExpanded;
                        kVar3 = kVar;
                        if (l0Var.size() <= aVar.$step) {
                        }
                    }
                    return Unit.a;
                }
                if (i3 == 4) {
                    l0Var = (l0) this.L$1;
                    kVar3 = (d0.f0.k) this.L$0;
                    d0.l.throwOnFailure(obj);
                    aVar = this;
                    l0Var.removeFirst(aVar.$step);
                    if (l0Var.size() <= aVar.$step) {
                        RandomAccess arrayList4 = aVar.$reuseBuffer ? l0Var : new ArrayList(l0Var);
                        aVar.L$0 = kVar3;
                        aVar.L$1 = l0Var;
                        aVar.L$2 = null;
                        aVar.label = 4;
                        if (kVar3.yield(arrayList4, aVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        l0Var.removeFirst(aVar.$step);
                        if (l0Var.size() <= aVar.$step) {
                            if (!l0Var.isEmpty()) {
                                aVar.L$0 = null;
                                aVar.L$1 = null;
                                aVar.L$2 = null;
                                aVar.label = 5;
                                if (kVar3.yield(l0Var, aVar) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.a;
                        }
                    }
                } else if (i3 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            d0.l.throwOnFailure(obj);
            return Unit.a;
        }
    }

    public static final void checkWindowSizeStep(int i, int i2) {
        String strR;
        if (i > 0 && i2 > 0) {
            return;
        }
        if (i != i2) {
            strR = "Both size " + i + " and step " + i2 + " must be greater than zero.";
        } else {
            strR = b.d.b.a.a.r("size ", i, " must be greater than zero.");
        }
        throw new IllegalArgumentException(strR.toString());
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> it, int i, int i2, boolean z2, boolean z3) {
        d0.z.d.m.checkNotNullParameter(it, "iterator");
        return !it.hasNext() ? v.j : d0.f0.l.iterator(new a(i, i2, it, z3, z2, null));
    }
}
