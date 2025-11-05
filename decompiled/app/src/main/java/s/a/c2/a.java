package s.a.c2;

import d0.k;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import s.a.a.k;
import s.a.c2.v;

/* compiled from: AbstractChannel.kt */
/* loaded from: classes3.dex */
public abstract class a<E> extends s.a.c2.c<E> implements s.a.c2.f<E> {

    /* compiled from: AbstractChannel.kt */
    /* renamed from: s.a.c2.a$a, reason: collision with other inner class name */
    public static final class C0646a<E> implements s.a.c2.g<E> {
        public Object a = s.a.c2.b.d;

        /* renamed from: b, reason: collision with root package name */
        public final a<E> f3833b;

        public C0646a(a<E> aVar) {
            this.f3833b = aVar;
        }

        @Override // s.a.c2.g
        public Object a(Continuation<? super Boolean> continuation) {
            Object obj = this.a;
            s.a.a.t tVar = s.a.c2.b.d;
            if (obj != tVar) {
                return d0.w.i.a.b.boxBoolean(b(obj));
            }
            Object objV = this.f3833b.v();
            this.a = objV;
            if (objV != tVar) {
                return d0.w.i.a.b.boxBoolean(b(objV));
            }
            s.a.l lVarO0 = b.i.a.f.e.o.f.o0(d0.w.h.b.intercepted(continuation));
            d dVar = new d(this, lVarO0);
            while (true) {
                if (this.f3833b.r(dVar)) {
                    a<E> aVar = this.f3833b;
                    Objects.requireNonNull(aVar);
                    lVarO0.f(aVar.new e(dVar));
                    break;
                }
                Object objV2 = this.f3833b.v();
                this.a = objV2;
                if (objV2 instanceof i) {
                    i iVar = (i) objV2;
                    if (iVar.m == null) {
                        Boolean boolBoxBoolean = d0.w.i.a.b.boxBoolean(false);
                        k.a aVar2 = d0.k.j;
                        lVarO0.resumeWith(d0.k.m97constructorimpl(boolBoxBoolean));
                    } else {
                        Throwable thV = iVar.v();
                        k.a aVar3 = d0.k.j;
                        lVarO0.resumeWith(d0.k.m97constructorimpl(d0.l.createFailure(thV)));
                    }
                } else if (objV2 != s.a.c2.b.d) {
                    Boolean boolBoxBoolean2 = d0.w.i.a.b.boxBoolean(true);
                    Function1<E, Unit> function1 = this.f3833b.l;
                    lVarO0.y(boolBoxBoolean2, lVarO0.l, function1 != null ? new s.a.a.o(function1, objV2, lVarO0.o) : null);
                }
            }
            Object objU = lVarO0.u();
            if (objU == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                d0.w.i.a.g.probeCoroutineSuspended(continuation);
            }
            return objU;
        }

        public final boolean b(Object obj) throws Throwable {
            if (!(obj instanceof i)) {
                return true;
            }
            i iVar = (i) obj;
            if (iVar.m == null) {
                return false;
            }
            Throwable thV = iVar.v();
            String str = s.a.a.s.a;
            throw thV;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // s.a.c2.g
        public E next() throws Throwable {
            E e = (E) this.a;
            if (e instanceof i) {
                Throwable thV = ((i) e).v();
                String str = s.a.a.s.a;
                throw thV;
            }
            s.a.a.t tVar = s.a.c2.b.d;
            if (e == tVar) {
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            this.a = tVar;
            return e;
        }
    }

    /* compiled from: AbstractChannel.kt */
    public static class b<E> extends n<E> {
        public final CancellableContinuation<Object> m;
        public final int n;

        public b(CancellableContinuation<Object> cancellableContinuation, int i) {
            this.m = cancellableContinuation;
            this.n = i;
        }

        @Override // s.a.c2.p
        public void c(E e) {
            this.m.r(s.a.m.a);
        }

        @Override // s.a.c2.p
        public s.a.a.t d(E e, k.b bVar) {
            if (this.m.h(this.n != 2 ? e : new v(e), null, q(e)) != null) {
                return s.a.m.a;
            }
            return null;
        }

        @Override // s.a.c2.n
        public void r(i<?> iVar) {
            int i = this.n;
            if (i == 1 && iVar.m == null) {
                CancellableContinuation<Object> cancellableContinuation = this.m;
                k.a aVar = d0.k.j;
                cancellableContinuation.resumeWith(d0.k.m97constructorimpl(null));
            } else {
                if (i == 2) {
                    CancellableContinuation<Object> cancellableContinuation2 = this.m;
                    v vVar = new v(new v.a(iVar.m));
                    k.a aVar2 = d0.k.j;
                    cancellableContinuation2.resumeWith(d0.k.m97constructorimpl(vVar));
                    return;
                }
                CancellableContinuation<Object> cancellableContinuation3 = this.m;
                Throwable thV = iVar.v();
                k.a aVar3 = d0.k.j;
                cancellableContinuation3.resumeWith(d0.k.m97constructorimpl(d0.l.createFailure(thV)));
            }
        }

        @Override // s.a.a.k
        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("ReceiveElement@");
            sbU.append(b.i.a.f.e.o.f.l0(this));
            sbU.append("[receiveMode=");
            return b.d.b.a.a.A(sbU, this.n, ']');
        }
    }

    /* compiled from: AbstractChannel.kt */
    public static final class c<E> extends b<E> {
        public final Function1<E, Unit> o;

        /* JADX WARN: Multi-variable type inference failed */
        public c(CancellableContinuation<Object> cancellableContinuation, int i, Function1<? super E, Unit> function1) {
            super(cancellableContinuation, i);
            this.o = function1;
        }

        @Override // s.a.c2.n
        public Function1<Throwable, Unit> q(E e) {
            return new s.a.a.o(this.o, e, this.m.getContext());
        }
    }

    /* compiled from: AbstractChannel.kt */
    public static class d<E> extends n<E> {
        public final C0646a<E> m;
        public final CancellableContinuation<Boolean> n;

        /* JADX WARN: Multi-variable type inference failed */
        public d(C0646a<E> c0646a, CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.m = c0646a;
            this.n = cancellableContinuation;
        }

        @Override // s.a.c2.p
        public void c(E e) {
            this.m.a = e;
            this.n.r(s.a.m.a);
        }

        @Override // s.a.c2.p
        public s.a.a.t d(E e, k.b bVar) {
            if (this.n.h(Boolean.TRUE, null, q(e)) != null) {
                return s.a.m.a;
            }
            return null;
        }

        @Override // s.a.c2.n
        public Function1<Throwable, Unit> q(E e) {
            Function1<E, Unit> function1 = this.m.f3833b.l;
            if (function1 != null) {
                return new s.a.a.o(function1, e, this.n.getContext());
            }
            return null;
        }

        @Override // s.a.c2.n
        public void r(i<?> iVar) {
            Object objC = iVar.m == null ? this.n.c(Boolean.FALSE, null) : this.n.g(iVar.v());
            if (objC != null) {
                this.m.a = iVar;
                this.n.r(objC);
            }
        }

        @Override // s.a.a.k
        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("ReceiveHasNext@");
            sbU.append(b.i.a.f.e.o.f.l0(this));
            return sbU.toString();
        }
    }

    /* compiled from: AbstractChannel.kt */
    public final class e extends s.a.e {
        public final n<?> j;

        public e(n<?> nVar) {
            this.j = nVar;
        }

        @Override // s.a.k
        public void a(Throwable th) {
            if (this.j.n()) {
                Objects.requireNonNull(a.this);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            if (this.j.n()) {
                Objects.requireNonNull(a.this);
            }
            return Unit.a;
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("RemoveReceiveOnCancel[");
            sbU.append(this.j);
            sbU.append(']');
            return sbU.toString();
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    public static final class f extends k.a {
        public final /* synthetic */ a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(s.a.a.k kVar, s.a.a.k kVar2, a aVar) {
            super(kVar2);
            this.d = aVar;
        }

        @Override // s.a.a.d
        public Object c(s.a.a.k kVar) {
            if (this.d.t()) {
                return null;
            }
            return s.a.a.j.a;
        }
    }

    /* compiled from: AbstractChannel.kt */
    @d0.w.i.a.e(c = "kotlinx.coroutines.channels.AbstractChannel", f = "AbstractChannel.kt", l = {624}, m = "receiveOrClosed-ZYPwvRU")
    public static final class g extends d0.w.i.a.d {
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public g(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.m(this);
        }
    }

    public a(Function1<? super E, Unit> function1) {
        super(function1);
    }

    @Override // s.a.c2.o
    public final void b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException(getClass().getSimpleName() + " was cancelled");
        }
        u(j(cancellationException));
    }

    @Override // s.a.c2.o
    public final s.a.c2.g<E> iterator() {
        return new C0646a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // s.a.c2.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m(Continuation<? super v<? extends E>> continuation) {
        g gVar;
        if (continuation instanceof g) {
            gVar = (g) continuation;
            int i = gVar.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                gVar.label = i - Integer.MIN_VALUE;
            } else {
                gVar = new g(continuation);
            }
        }
        Object objU = gVar.result;
        Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
        int i2 = gVar.label;
        if (i2 == 0) {
            d0.l.throwOnFailure(objU);
            Object objV = v();
            if (objV != s.a.c2.b.d) {
                return objV instanceof i ? new v.a(((i) objV).m) : objV;
            }
            gVar.L$0 = this;
            gVar.L$1 = objV;
            gVar.label = 1;
            s.a.l lVarO0 = b.i.a.f.e.o.f.o0(d0.w.h.b.intercepted(gVar));
            b bVar = this.l == null ? new b(lVarO0, 2) : new c(lVarO0, 2, this.l);
            while (true) {
                if (r(bVar)) {
                    lVarO0.f(new e(bVar));
                    break;
                }
                Object objV2 = v();
                if (objV2 instanceof i) {
                    bVar.r((i) objV2);
                    break;
                }
                if (objV2 != s.a.c2.b.d) {
                    lVarO0.y(bVar.n != 2 ? objV2 : new v(objV2), lVarO0.l, bVar.q(objV2));
                }
            }
            objU = lVarO0.u();
            if (objU == d0.w.h.c.getCOROUTINE_SUSPENDED()) {
                d0.w.i.a.g.probeCoroutineSuspended(gVar);
            }
            if (objU == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d0.l.throwOnFailure(objU);
        }
        return ((v) objU).a;
    }

    @Override // s.a.c2.c
    public p<E> n() {
        p<E> pVarN = super.n();
        if (pVarN != null) {
            boolean z2 = pVarN instanceof i;
        }
        return pVarN;
    }

    public boolean r(n<? super E> nVar) {
        int iP;
        s.a.a.k kVarK;
        if (!s()) {
            s.a.a.k kVar = this.k;
            f fVar = new f(nVar, nVar, this);
            do {
                s.a.a.k kVarK2 = kVar.k();
                if (!(!(kVarK2 instanceof r))) {
                    break;
                }
                iP = kVarK2.p(nVar, kVar, fVar);
                if (iP == 1) {
                    return true;
                }
            } while (iP != 2);
        } else {
            s.a.a.k kVar2 = this.k;
            do {
                kVarK = kVar2.k();
                if (!(!(kVarK instanceof r))) {
                }
            } while (!kVarK.e(nVar, kVar2));
            return true;
        }
        return false;
    }

    public abstract boolean s();

    public abstract boolean t();

    public void u(boolean z2) {
        i<?> iVarE = e();
        if (iVarE == null) {
            throw new IllegalStateException("Cannot happen".toString());
        }
        Object objT0 = null;
        while (true) {
            s.a.a.k kVarK = iVarE.k();
            if (kVarK instanceof s.a.a.i) {
                break;
            }
            if (kVarK.n()) {
                objT0 = b.i.a.f.e.o.f.T0(objT0, (r) kVarK);
            } else {
                Object objI = kVarK.i();
                Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
                ((s.a.a.q) objI).a.f(null);
            }
        }
        if (objT0 == null) {
            return;
        }
        if (!(objT0 instanceof ArrayList)) {
            ((r) objT0).s(iVarE);
            return;
        }
        ArrayList arrayList = (ArrayList) objT0;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                ((r) arrayList.get(size)).s(iVarE);
            }
        }
    }

    public Object v() {
        while (true) {
            r rVarQ = q();
            if (rVarQ == null) {
                return s.a.c2.b.d;
            }
            if (rVarQ.t(null) != null) {
                rVarQ.q();
                return rVarQ.r();
            }
            rVarQ.u();
        }
    }
}
