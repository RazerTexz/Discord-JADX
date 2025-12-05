package p659s.p660a;

import kotlin.coroutines.CoroutineContext;

/* compiled from: Builders.common.kt */
/* renamed from: s.a.g0 */
/* loaded from: classes3.dex */
public class C13112g0<T> extends AbstractCoroutine<T> implements Deferred<T> {
    public C13112g0(CoroutineContext coroutineContext, boolean z2) {
        super(coroutineContext, z2);
    }

    @Override // p659s.p660a.Deferred
    /* renamed from: d */
    public T mo11278d() throws Throwable {
        Object objM11292M = m11292M();
        if (!(!(objM11292M instanceof InterfaceC13169z0))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        }
        if (objM11292M instanceof CompletionState2) {
            throw ((CompletionState2) objM11292M).f27913b;
        }
        return (T) C13119i1.m11314a(objM11292M);
    }
}
