package p659s.p660a.p663c2;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.OnUndeliveredElement;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* compiled from: AbstractChannel.kt */
/* renamed from: s.a.c2.u, reason: use source file name */
/* loaded from: classes3.dex */
public final class AbstractChannel9<E> extends AbstractChannel8<E> {

    /* renamed from: o */
    public final Function1<E, Unit> f27769o;

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractChannel9(E e, CancellableContinuation<? super Unit> cancellableContinuation, Function1<? super E, Unit> function1) {
        super(e, cancellableContinuation);
        this.f27769o = function1;
    }

    @Override // p659s.p660a.p661a.LockFreeLinkedList3
    /* renamed from: n */
    public boolean mo11151n() {
        if (!super.mo11151n()) {
            return false;
        }
        mo11241u();
        return true;
    }

    @Override // p659s.p660a.p663c2.AbstractChannel7
    /* renamed from: u */
    public void mo11241u() {
        Function1<E, Unit> function1 = this.f27769o;
        E e = this.f27767m;
        CoroutineContext context = this.f27768n.getContext();
        OnUndeliveredElement onUndeliveredElementM4327p = C3404f.m4327p(function1, e, null);
        if (onUndeliveredElementM4327p != null) {
            C3404f.m4348u0(context, onUndeliveredElementM4327p);
        }
    }
}
