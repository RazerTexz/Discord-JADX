package s.a.d2;

import d0.l;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: Builders.kt */
/* loaded from: classes3.dex */
public final class b<T> extends c<T> {
    public final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> e;

    /* compiled from: Builders.kt */
    @d0.w.i.a.e(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", l = {358}, m = "collectTo")
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
            return b.this.b(null, this);
        }
    }

    public b(Function2 function2, CoroutineContext coroutineContext, int i, s.a.c2.e eVar, int i2) {
        super(function2, (i2 & 2) != 0 ? d0.w.f.j : null, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? s.a.c2.e.SUSPEND : null);
        this.e = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // s.a.d2.g.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation) {
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
        if (i2 == 0) {
            l.throwOnFailure(obj);
            aVar.L$0 = this;
            aVar.L$1 = producerScope;
            aVar.label = 1;
            Object objInvoke = this.d.invoke(producerScope, aVar);
            if (objInvoke != d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                objInvoke = Unit.a;
            }
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            producerScope = (ProducerScope) aVar.L$1;
            l.throwOnFailure(obj);
        }
        if (producerScope.p()) {
            return Unit.a;
        }
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    }
}
