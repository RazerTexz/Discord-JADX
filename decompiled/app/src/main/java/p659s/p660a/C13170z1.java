package p659s.p660a;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p659s.p660a.p661a.Scopes2;
import p659s.p660a.p661a.ThreadContext;

/* JADX INFO: renamed from: s.a.z1 */
/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13170z1<T> extends Scopes2<T> {
    public C13170z1(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
    }

    @Override // p659s.p660a.p661a.Scopes2, p659s.p660a.AbstractCoroutine
    /* JADX INFO: renamed from: e0 */
    public void mo11172e0(Object obj) {
        Object objM4259X0 = C3404f.m4259X0(obj, this.f27702m);
        CoroutineContext context = this.f27702m.getContext();
        Object objM11141b = ThreadContext.m11141b(context, null);
        try {
            this.f27702m.resumeWith(objM4259X0);
        } finally {
            ThreadContext.m11140a(context, objM11141b);
        }
    }
}
