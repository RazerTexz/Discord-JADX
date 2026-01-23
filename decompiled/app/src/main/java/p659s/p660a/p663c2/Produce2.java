package p659s.p660a.p663c2;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Produce;
import p507d0.Result2;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p585h.IntrinsicsJvm;
import p507d0.p584w.p586i.p587a.ContinuationImpl3;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p584w.p586i.p587a.DebugProbes;
import p507d0.p592z.p594d.Lambda;
import p659s.p660a.CancellableContinuationImpl5;

/* JADX INFO: renamed from: s.a.c2.l, reason: use source file name */
/* JADX INFO: compiled from: Produce.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Produce2 {

    /* JADX INFO: renamed from: s.a.c2.l$a */
    /* JADX INFO: compiled from: Produce.kt */
    @DebugMetadata(m10084c = "kotlinx.coroutines.channels.ProduceKt", m10085f = "Produce.kt", m10086l = {157}, m10087m = "awaitClose")
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
            return Produce2.m11236a(null, null, this);
        }
    }

    /* JADX INFO: renamed from: s.a.c2.l$b */
    /* JADX INFO: compiled from: Produce.kt */
    public static final class b extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ CancellableContinuation $cont;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CancellableContinuation cancellableContinuation) {
            super(1);
            this.$cont = cancellableContinuation;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            CancellableContinuation cancellableContinuation = this.$cont;
            Unit unit = Unit.f27425a;
            Result2.a aVar = Result2.f25169j;
            cancellableContinuation.resumeWith(Result2.m11474constructorimpl(unit));
            return unit;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m11236a(Produce<?> produce, Function0<Unit> function0, Continuation<? super Unit> continuation) {
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
        try {
            if (i2 == 0) {
                Result3.throwOnFailure(obj);
                if (!(((Job) aVar.getContext().get(Job.INSTANCE)) == produce)) {
                    throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
                }
                aVar.L$0 = produce;
                aVar.L$1 = function0;
                aVar.label = 1;
                CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(aVar), 1);
                cancellableContinuationImpl5.m11318A();
                produce.mo11223l(new b(cancellableContinuationImpl5));
                Object objM11326u = cancellableContinuationImpl5.m11326u();
                if (objM11326u == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                    DebugProbes.probeCoroutineSuspended(aVar);
                }
                if (objM11326u == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function0 = (Function0) aVar.L$1;
                Result3.throwOnFailure(obj);
            }
            function0.invoke();
            return Unit.f27425a;
        } catch (Throwable th) {
            function0.invoke();
            throw th;
        }
    }
}
