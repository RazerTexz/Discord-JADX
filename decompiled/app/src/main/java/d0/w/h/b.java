package d0.w.h;

import d0.l;
import d0.w.f;
import d0.w.i.a.d;
import d0.w.i.a.g;
import d0.w.i.a.i;
import d0.z.d.e0;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* compiled from: IntrinsicsJvm.kt */
/* loaded from: classes3.dex */
public class b {

    /* compiled from: IntrinsicsJvm.kt */
    public static final class a extends i {
        public final /* synthetic */ Continuation $completion;
        public final /* synthetic */ Object $receiver$inlined;
        public final /* synthetic */ Function2 $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Continuation continuation, Continuation continuation2, Function2 function2, Object obj) {
            super(continuation2);
            this.$completion = continuation;
            this.$this_createCoroutineUnintercepted$inlined = function2;
            this.$receiver$inlined = obj;
        }

        @Override // d0.w.i.a.a
        public Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                l.throwOnFailure(obj);
                return obj;
            }
            this.label = 1;
            l.throwOnFailure(obj);
            Function2 function2 = this.$this_createCoroutineUnintercepted$inlined;
            Objects.requireNonNull(function2, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            return ((Function2) e0.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(this.$receiver$inlined, this);
        }
    }

    /* compiled from: IntrinsicsJvm.kt */
    /* renamed from: d0.w.h.b$b, reason: collision with other inner class name */
    public static final class C0601b extends d {
        public final /* synthetic */ Continuation $completion;
        public final /* synthetic */ CoroutineContext $context;
        public final /* synthetic */ Object $receiver$inlined;
        public final /* synthetic */ Function2 $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0601b(Continuation continuation, CoroutineContext coroutineContext, Continuation continuation2, CoroutineContext coroutineContext2, Function2 function2, Object obj) {
            super(continuation2, coroutineContext2);
            this.$completion = continuation;
            this.$context = coroutineContext;
            this.$this_createCoroutineUnintercepted$inlined = function2;
            this.$receiver$inlined = obj;
        }

        @Override // d0.w.i.a.a
        public Object invokeSuspend(Object obj) {
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.label = 2;
                l.throwOnFailure(obj);
                return obj;
            }
            this.label = 1;
            l.throwOnFailure(obj);
            Function2 function2 = this.$this_createCoroutineUnintercepted$inlined;
            Objects.requireNonNull(function2, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            return ((Function2) e0.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(this.$receiver$inlined, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> Continuation<Unit> createCoroutineUnintercepted(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        m.checkNotNullParameter(function2, "$this$createCoroutineUnintercepted");
        m.checkNotNullParameter(continuation, "completion");
        Continuation<?> continuationProbeCoroutineCreated = g.probeCoroutineCreated(continuation);
        if (function2 instanceof d0.w.i.a.a) {
            return ((d0.w.i.a.a) function2).create(r, continuationProbeCoroutineCreated);
        }
        CoroutineContext context = continuationProbeCoroutineCreated.getContext();
        return context == f.j ? new a(continuationProbeCoroutineCreated, continuationProbeCoroutineCreated, function2, r) : new C0601b(continuationProbeCoroutineCreated, context, continuationProbeCoroutineCreated, context, function2, r);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Continuation<T> intercepted(Continuation<? super T> continuation) {
        Continuation<T> continuation2;
        m.checkNotNullParameter(continuation, "$this$intercepted");
        d dVar = !(continuation instanceof d) ? null : continuation;
        return (dVar == null || (continuation2 = (Continuation<T>) dVar.intercepted()) == null) ? continuation : continuation2;
    }
}
