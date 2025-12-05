package p659s.p660a;

import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result2;
import p507d0.Result3;
import p507d0.p584w.Continuation2;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.DebugProbes;
import p507d0.p592z.p594d.TypeIntrinsics;
import p659s.p660a.p661a.ThreadContext;

/* compiled from: AbstractCoroutine.kt */
/* renamed from: s.a.b, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class AbstractCoroutine<T> extends C13116h1 implements Job, Continuation<T>, CoroutineScope {

    /* renamed from: k */
    public final CoroutineContext f27714k;

    /* renamed from: l */
    public final CoroutineContext f27715l;

    public AbstractCoroutine(CoroutineContext coroutineContext, boolean z2) {
        super(z2);
        this.f27715l = coroutineContext;
        this.f27714k = coroutineContext.plus(this);
    }

    @Override // p659s.p660a.C13116h1
    /* renamed from: B */
    public String mo11182B() {
        return getClass().getSimpleName() + " was cancelled";
    }

    @Override // p659s.p660a.C13116h1
    /* renamed from: O */
    public final void mo11183O(Throwable th) {
        C3404f.m4348u0(this.f27714k, th);
    }

    @Override // p659s.p660a.C13116h1
    /* renamed from: T */
    public String mo11184T() {
        boolean z2 = CoroutineContext2.f27923a;
        return super.mo11184T();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    @Override // p659s.p660a.C13116h1
    /* renamed from: W */
    public final void mo11185W(Object obj) {
        if (!(obj instanceof CompletionState2)) {
            m11189h0(obj);
        } else {
            CompletionState2 completionState2 = (CompletionState2) obj;
            m11188g0(completionState2.f27913b, completionState2._handled);
        }
    }

    @Override // p659s.p660a.C13116h1
    /* renamed from: X */
    public final void mo11186X() {
        mo11190i0();
    }

    @Override // p659s.p660a.C13116h1, kotlinx.coroutines.Job
    /* renamed from: a */
    public boolean mo10910a() {
        return super.mo10910a();
    }

    /* renamed from: e0 */
    public void mo11172e0(Object obj) {
        mo11173v(obj);
    }

    /* renamed from: f0 */
    public final void m11187f0() {
        m11294P((Job) this.f27715l.get(Job.INSTANCE));
    }

    /* renamed from: g0 */
    public void m11188g0(Throwable th, boolean z2) {
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.f27714k;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f27714k;
    }

    /* renamed from: h0 */
    public void m11189h0(T t) {
    }

    /* renamed from: i0 */
    public void mo11190i0() {
    }

    /* renamed from: j0 */
    public final <R> void m11191j0(CoroutineStart coroutineStart, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        m11187f0();
        int iOrdinal = coroutineStart.ordinal();
        if (iOrdinal == 0) {
            C3404f.m4289f1(function2, r, this, null, 4);
            return;
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                Continuation2.startCoroutine(function2, r, this);
                return;
            }
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            Continuation continuationProbeCoroutineCreated = DebugProbes.probeCoroutineCreated(this);
            try {
                CoroutineContext coroutineContext = this.f27714k;
                Object objM11141b = ThreadContext.m11141b(coroutineContext, null);
                try {
                    if (function2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
                    }
                    Object objInvoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, continuationProbeCoroutineCreated);
                    if (objInvoke != Intrinsics2.getCOROUTINE_SUSPENDED()) {
                        Result2.a aVar = Result2.f25169j;
                        continuationProbeCoroutineCreated.resumeWith(Result2.m11474constructorimpl(objInvoke));
                    }
                } finally {
                    ThreadContext.m11140a(coroutineContext, objM11141b);
                }
            } catch (Throwable th) {
                Result2.a aVar2 = Result2.f25169j;
                continuationProbeCoroutineCreated.resumeWith(Result2.m11474constructorimpl(Result3.createFailure(th)));
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object objM11295R = m11295R(C3404f.m4353v1(obj, null));
        if (objM11295R == C13119i1.f27858b) {
            return;
        }
        mo11172e0(objM11295R);
    }
}
