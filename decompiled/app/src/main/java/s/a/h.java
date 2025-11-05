package s.a;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;

/* compiled from: Builders.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class h {

    /* compiled from: Timeout.kt */
    @d0.w.i.a.e(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", l = {101}, m = "withTimeoutOrNull")
    public static final class a extends d0.w.i.a.d {
        public long J$0;
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public a(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return h.b(0L, null, this);
        }
    }

    public static final <U, T extends U> Object a(x1<U, ? super T> x1Var, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws Throwable {
        Object wVar;
        Object objR;
        x1Var.n(false, true, new o0(x1Var, b.i.a.f.e.o.f.i0(x1Var.m.getContext()).x(x1Var.n, x1Var, x1Var.k)));
        x1Var.f0();
        try {
        } catch (Throwable th) {
            wVar = new w(th, false, 2);
        }
        if (function2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
        wVar = ((Function2) d0.z.d.e0.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(x1Var, x1Var);
        if (wVar != d0.w.h.c.getCOROUTINE_SUSPENDED() && (objR = x1Var.R(wVar)) != i1.f3841b) {
            if (!(objR instanceof w)) {
                return i1.a(objR);
            }
            Throwable th2 = ((w) objR).f3846b;
            if (((th2 instanceof TimeoutCancellationException) && ((TimeoutCancellationException) th2).coroutine == x1Var) ? false : true) {
                throw th2;
            }
            if (wVar instanceof w) {
                throw ((w) wVar).f3846b;
            }
            return wVar;
        }
        return d0.w.h.c.getCOROUTINE_SUSPENDED();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, s.a.x1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object b(long j, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        a aVar;
        TimeoutCancellationException e;
        Ref$ObjectRef ref$ObjectRef;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.label = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        }
        Object obj = aVar.result;
        Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
        int i2 = aVar.label;
        if (i2 == 0) {
            d0.l.throwOnFailure(obj);
            if (j <= 0) {
                return null;
            }
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            try {
                aVar.J$0 = j;
                aVar.L$0 = function2;
                aVar.L$1 = ref$ObjectRef2;
                aVar.label = 1;
                ?? r2 = (T) new x1(j, aVar);
                ref$ObjectRef2.element = r2;
                Object objA = a(r2, function2);
                if (objA == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                    d0.w.i.a.g.probeCoroutineSuspended(aVar);
                }
                return objA == coroutine_suspended ? coroutine_suspended : objA;
            } catch (TimeoutCancellationException e2) {
                e = e2;
                ref$ObjectRef = ref$ObjectRef2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ref$ObjectRef = (Ref$ObjectRef) aVar.L$1;
            try {
                d0.l.throwOnFailure(obj);
                return obj;
            } catch (TimeoutCancellationException e3) {
                e = e3;
            }
        }
        if (e.coroutine == ((x1) ref$ObjectRef.element)) {
            return null;
        }
        throw e;
    }
}
