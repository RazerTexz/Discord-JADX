package s.a.c2;

import d0.k;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: Produce.kt */
/* loaded from: classes3.dex */
public final class l {

    /* compiled from: Produce.kt */
    @d0.w.i.a.e(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", l = {157}, m = "awaitClose")
    public static final class a extends d0.w.i.a.d {
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
            return l.a(null, null, this);
        }
    }

    /* compiled from: Produce.kt */
    public static final class b extends d0.z.d.o implements Function1<Throwable, Unit> {
        public final /* synthetic */ CancellableContinuation $cont;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CancellableContinuation cancellableContinuation) {
            super(1);
            this.$cont = cancellableContinuation;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            CancellableContinuation cancellableContinuation = this.$cont;
            Unit unit = Unit.a;
            k.a aVar = d0.k.j;
            cancellableContinuation.resumeWith(d0.k.m97constructorimpl(unit));
            return unit;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object a(ProducerScope<?> producerScope, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        a aVar;
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
        try {
            if (i2 == 0) {
                d0.l.throwOnFailure(obj);
                if (!(((Job) aVar.getContext().get(Job.INSTANCE)) == producerScope)) {
                    throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
                }
                aVar.L$0 = producerScope;
                aVar.L$1 = function0;
                aVar.label = 1;
                s.a.l lVar = new s.a.l(d0.w.h.b.intercepted(aVar), 1);
                lVar.A();
                producerScope.l(new b(lVar));
                Object objU = lVar.u();
                if (objU == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                    d0.w.i.a.g.probeCoroutineSuspended(aVar);
                }
                if (objU == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function0 = (Function0) aVar.L$1;
                d0.l.throwOnFailure(obj);
            }
            function0.invoke();
            return Unit.a;
        } catch (Throwable th) {
            function0.invoke();
            throw th;
        }
    }
}
