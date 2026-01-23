package p659s.p660a.p664d2.p665g;

import java.util.Objects;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.Job;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Result2;
import p507d0.p579g0.Indent;
import p507d0.p584w.CoroutineContextImpl4;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl3;
import p507d0.p584w.p586i.p587a.DebugProbes;
import p507d0.p592z.p594d.Lambda;
import p659s.p660a.p664d2.FlowCollector;

/* JADX INFO: renamed from: s.a.d2.g.e, reason: use source file name */
/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SafeCollector3<T> extends ContinuationImpl3 implements FlowCollector<T>, CoroutineStackFrame {
    public final CoroutineContext collectContext;
    public final int collectContextSize;
    public final FlowCollector<T> collector;
    private Continuation<? super Unit> completion;
    private CoroutineContext lastEmissionContext;

    /* JADX INFO: renamed from: s.a.d2.g.e$a */
    /* JADX INFO: compiled from: SafeCollector.kt */
    public static final class a extends Lambda implements Function2<Integer, CoroutineContext.Element, Integer> {

        /* JADX INFO: renamed from: j */
        public static final a f27791j = new a();

        public a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Integer invoke(Integer num, CoroutineContext.Element element) {
            return Integer.valueOf(num.intValue() + 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector3(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        super(SafeCollector2.f27790j, CoroutineContextImpl4.f25237j);
        this.collector = flowCollector;
        this.collectContext = coroutineContext;
        this.collectContextSize = ((Number) coroutineContext.fold(0, a.f27791j)).intValue();
    }

    /* JADX INFO: renamed from: b */
    public final Object m11249b(Continuation<? super Unit> continuation, T t) {
        CoroutineContext context = continuation.getContext();
        Job job = (Job) context.get(Job.INSTANCE);
        if (job != null && !job.mo10910a()) {
            throw job.mo10914q();
        }
        CoroutineContext coroutineContext = this.lastEmissionContext;
        if (coroutineContext != context) {
            if (coroutineContext instanceof SafeCollector) {
                StringBuilder sbM833U = outline.m833U("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception ");
                sbM833U.append(((SafeCollector) coroutineContext).f27789k);
                sbM833U.append(", but then emission attempt of value '");
                sbM833U.append(t);
                sbM833U.append("' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
                throw new IllegalStateException(Indent.trimIndent(sbM833U.toString()).toString());
            }
            if (((Number) context.fold(0, new C13091g(this))).intValue() != this.collectContextSize) {
                StringBuilder sbM836X = outline.m836X("Flow invariant is violated:\n", "\t\tFlow was collected in ");
                sbM836X.append(this.collectContext);
                sbM836X.append(",\n");
                sbM836X.append("\t\tbut emission happened in ");
                sbM836X.append(context);
                throw new IllegalStateException(outline.m822J(sbM836X, ".\n", "\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
            }
            this.lastEmissionContext = context;
        }
        this.completion = continuation;
        Function3<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> function3 = SafeCollector4.f27792a;
        FlowCollector<T> flowCollector = this.collector;
        Objects.requireNonNull(flowCollector, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        return function3.invoke(flowCollector, t, this);
    }

    @Override // p659s.p660a.p664d2.FlowCollector
    public Object emit(T t, Continuation<? super Unit> continuation) {
        try {
            Object objM11249b = m11249b(continuation, t);
            if (objM11249b == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return objM11249b == Intrinsics2.getCOROUTINE_SUSPENDED() ? objM11249b : Unit.f27425a;
        } catch (Throwable th) {
            this.lastEmissionContext = new SafeCollector(th);
            throw th;
        }
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public CoroutineStackFrame getCallerFrame() {
        Continuation<? super Unit> continuation = this.completion;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl3, kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        CoroutineContext context;
        Continuation<? super Unit> continuation = this.completion;
        return (continuation == null || (context = continuation.getContext()) == null) ? CoroutineContextImpl4.f25237j : context;
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
    public Object invokeSuspend(Object obj) {
        Throwable thM11476exceptionOrNullimpl = Result2.m11476exceptionOrNullimpl(obj);
        if (thM11476exceptionOrNullimpl != null) {
            this.lastEmissionContext = new SafeCollector(thM11476exceptionOrNullimpl);
        }
        Continuation<? super Unit> continuation = this.completion;
        if (continuation != null) {
            continuation.resumeWith(obj);
        }
        return Intrinsics2.getCOROUTINE_SUSPENDED();
    }

    @Override // p507d0.p584w.p586i.p587a.ContinuationImpl3, p507d0.p584w.p586i.p587a.ContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
