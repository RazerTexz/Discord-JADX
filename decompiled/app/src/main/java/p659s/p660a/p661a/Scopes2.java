package p659s.p660a.p661a;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p584w.p585h.IntrinsicsJvm;
import p659s.p660a.AbstractCoroutine;

/* compiled from: Scopes.kt */
/* renamed from: s.a.a.r, reason: use source file name */
/* loaded from: classes3.dex */
public class Scopes2<T> extends AbstractCoroutine<T> implements CoroutineStackFrame {

    /* renamed from: m */
    public final Continuation<T> f27702m;

    /* JADX WARN: Multi-variable type inference failed */
    public Scopes2(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, true);
        this.f27702m = continuation;
    }

    @Override // p659s.p660a.C13116h1
    /* renamed from: Q */
    public final boolean mo11171Q() {
        return true;
    }

    @Override // p659s.p660a.AbstractCoroutine
    /* renamed from: e0 */
    public void mo11172e0(Object obj) {
        Continuation<T> continuation = this.f27702m;
        continuation.resumeWith(C3404f.m4259X0(obj, continuation));
    }

    @Override // p659s.p660a.C13116h1
    /* renamed from: v */
    public void mo11173v(Object obj) {
        DispatchedContinuation2.m11149b(IntrinsicsJvm.intercepted(this.f27702m), C3404f.m4259X0(obj, this.f27702m), null, 2);
    }
}
