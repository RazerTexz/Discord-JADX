package p659s.p660a.p664d2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Produce;
import p507d0.Result3;
import p507d0.p584w.CoroutineContextImpl4;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl3;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p659s.p660a.p663c2.BufferOverflow;

/* JADX INFO: renamed from: s.a.d2.b, reason: use source file name */
/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Builders<T> extends Builders2<T> {

    /* JADX INFO: renamed from: e */
    public final Function2<Produce<? super T>, Continuation<? super Unit>, Object> f27781e;

    /* JADX INFO: renamed from: s.a.d2.b$a */
    /* JADX INFO: compiled from: Builders.kt */
    @DebugMetadata(m10084c = "kotlinx.coroutines.flow.CallbackFlowBuilder", m10085f = "Builders.kt", m10086l = {358}, m10087m = "collectTo")
    public static final class a extends ContinuationImpl3 {
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public a(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Builders.this.mo11248b(null, this);
        }
    }

    public Builders(Function2 function2, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2) {
        super(function2, (i2 & 2) != 0 ? CoroutineContextImpl4.f25237j : null, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? BufferOverflow.SUSPEND : null);
        this.f27781e = function2;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p659s.p660a.p664d2.p665g.ChannelFlow
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo11248b(Produce<? super T> produce, Continuation<? super Unit> continuation) {
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
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = aVar.label;
        if (i2 == 0) {
            Result3.throwOnFailure(obj);
            aVar.L$0 = this;
            aVar.L$1 = produce;
            aVar.label = 1;
            Object objInvoke = this.f27782d.invoke(produce, aVar);
            if (objInvoke != Intrinsics2.getCOROUTINE_SUSPENDED()) {
                objInvoke = Unit.f27425a;
            }
            if (objInvoke == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            produce = (Produce) aVar.L$1;
            Result3.throwOnFailure(obj);
        }
        if (produce.mo11225p()) {
            return Unit.f27425a;
        }
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    }
}
