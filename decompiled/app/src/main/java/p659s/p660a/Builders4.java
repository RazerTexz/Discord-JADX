package p659s.p660a;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Builders.kt */
/* renamed from: s.a.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class Builders4<T> extends AbstractCoroutine<T> {

    /* renamed from: m */
    public final Thread f27841m;

    /* renamed from: n */
    public final AbstractC13142q0 f27842n;

    public Builders4(CoroutineContext coroutineContext, Thread thread, AbstractC13142q0 abstractC13142q0) {
        super(coroutineContext, true);
        this.f27841m = thread;
        this.f27842n = abstractC13142q0;
    }

    @Override // p659s.p660a.C13116h1
    /* renamed from: v */
    public void mo11173v(Object obj) {
        if (!Intrinsics3.areEqual(Thread.currentThread(), this.f27841m)) {
            LockSupport.unpark(this.f27841m);
        }
    }
}
