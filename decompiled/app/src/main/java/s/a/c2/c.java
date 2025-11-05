package s.a.c2;

import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.k;
import d0.z.d.e0;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.UndeliveredElementException;
import s.a.a.k;
import s.a.r1;

/* compiled from: AbstractChannel.kt */
/* loaded from: classes3.dex */
public abstract class c<E> implements s<E> {
    public static final AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "onCloseHandler");
    public final Function1<E, Unit> l;
    public final s.a.a.i k = new s.a.a.i();
    public volatile Object onCloseHandler = null;

    /* compiled from: AbstractChannel.kt */
    public static final class a<E> extends r {
        public final E m;

        public a(E e) {
            this.m = e;
        }

        @Override // s.a.c2.r
        public void q() {
        }

        @Override // s.a.c2.r
        public Object r() {
            return this.m;
        }

        @Override // s.a.c2.r
        public void s(i<?> iVar) {
        }

        @Override // s.a.c2.r
        public s.a.a.t t(k.b bVar) {
            return s.a.m.a;
        }

        @Override // s.a.a.k
        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("SendBuffered@");
            sbU.append(b.i.a.f.e.o.f.l0(this));
            sbU.append('(');
            sbU.append(this.m);
            sbU.append(')');
            return sbU.toString();
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    public static final class b extends k.a {
        public final /* synthetic */ c d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(s.a.a.k kVar, s.a.a.k kVar2, c cVar) {
            super(kVar2);
            this.d = cVar;
        }

        @Override // s.a.a.d
        public Object c(s.a.a.k kVar) {
            if (this.d.i()) {
                return null;
            }
            return s.a.a.j.a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function1<? super E, Unit> function1) {
        this.l = function1;
    }

    public static final void a(c cVar, Continuation continuation, Object obj, i iVar) {
        UndeliveredElementException undeliveredElementExceptionQ;
        cVar.f(iVar);
        Throwable thW = iVar.w();
        Function1<E, Unit> function1 = cVar.l;
        if (function1 == null || (undeliveredElementExceptionQ = b.i.a.f.e.o.f.q(function1, obj, null, 2)) == null) {
            k.a aVar = d0.k.j;
            ((s.a.l) continuation).resumeWith(d0.k.m97constructorimpl(d0.l.createFailure(thW)));
        } else {
            d0.b.addSuppressed(undeliveredElementExceptionQ, thW);
            k.a aVar2 = d0.k.j;
            ((s.a.l) continuation).resumeWith(d0.k.m97constructorimpl(d0.l.createFailure(undeliveredElementExceptionQ)));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        return s.a.c2.b.e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object c(r rVar) {
        s.a.a.k kVarK;
        if (!h()) {
            s.a.a.k kVar = this.k;
            b bVar = new b(rVar, rVar, this);
            while (true) {
                s.a.a.k kVarK2 = kVar.k();
                if (!(kVarK2 instanceof p)) {
                    int iP = kVarK2.p(rVar, kVar, bVar);
                    boolean z2 = true;
                    if (iP != 1) {
                        if (iP == 2) {
                            z2 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    return kVarK2;
                }
            }
        } else {
            s.a.a.k kVar2 = this.k;
            do {
                kVarK = kVar2.k();
                if (kVarK instanceof p) {
                    return kVarK;
                }
            } while (!kVarK.e(rVar, kVar2));
            return null;
        }
    }

    public String d() {
        return "";
    }

    public final i<?> e() {
        s.a.a.k kVarK = this.k.k();
        if (!(kVarK instanceof i)) {
            kVarK = null;
        }
        i<?> iVar = (i) kVarK;
        if (iVar == null) {
            return null;
        }
        f(iVar);
        return iVar;
    }

    public final void f(i<?> iVar) {
        Object objT0 = null;
        while (true) {
            s.a.a.k kVarK = iVar.k();
            if (!(kVarK instanceof n)) {
                kVarK = null;
            }
            n nVar = (n) kVarK;
            if (nVar == null) {
                break;
            }
            if (nVar.n()) {
                objT0 = b.i.a.f.e.o.f.T0(objT0, nVar);
            } else {
                Object objI = nVar.i();
                Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
                ((s.a.a.q) objI).a.f(null);
            }
        }
        if (objT0 == null) {
            return;
        }
        if (!(objT0 instanceof ArrayList)) {
            ((n) objT0).r(iVar);
            return;
        }
        ArrayList arrayList = (ArrayList) objT0;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                ((n) arrayList.get(size)).r(iVar);
            }
        }
    }

    public final Throwable g(E e, i<?> iVar) {
        UndeliveredElementException undeliveredElementExceptionQ;
        f(iVar);
        Function1<E, Unit> function1 = this.l;
        if (function1 == null || (undeliveredElementExceptionQ = b.i.a.f.e.o.f.q(function1, e, null, 2)) == null) {
            return iVar.w();
        }
        d0.b.addSuppressed(undeliveredElementExceptionQ, iVar.w());
        throw undeliveredElementExceptionQ;
    }

    public abstract boolean h();

    public abstract boolean i();

    @Override // s.a.c2.s
    public boolean j(Throwable th) {
        boolean z2;
        Object obj;
        s.a.a.t tVar;
        i<?> iVar = new i<>(th);
        s.a.a.k kVar = this.k;
        while (true) {
            s.a.a.k kVarK = kVar.k();
            if (!(!(kVarK instanceof i))) {
                z2 = false;
                break;
            }
            if (kVarK.e(iVar, kVar)) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            iVar = (i) this.k.k();
        }
        f(iVar);
        if (z2 && (obj = this.onCloseHandler) != null && obj != (tVar = s.a.c2.b.f) && j.compareAndSet(this, obj, tVar)) {
            ((Function1) e0.beforeCheckcastToFunctionOfArity(obj, 1)).invoke(th);
        }
        return z2;
    }

    public Object k(E e) {
        p<E> pVarN;
        do {
            pVarN = n();
            if (pVarN == null) {
                return s.a.c2.b.c;
            }
        } while (pVarN.d(e, null) == null);
        pVarN.c(e);
        return pVarN.b();
    }

    @Override // s.a.c2.s
    public void l(Function1<? super Throwable, Unit> function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj != s.a.c2.b.f) {
                throw new IllegalStateException(b.d.b.a.a.v("Another handler was already registered: ", obj));
            }
            throw new IllegalStateException("Another handler was already registered and successfully invoked");
        }
        i<?> iVarE = e();
        if (iVarE == null || !atomicReferenceFieldUpdater.compareAndSet(this, function1, s.a.c2.b.f)) {
            return;
        }
        function1.invoke(iVarE.m);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [s.a.a.k] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public p<E> n() {
        ?? r1;
        s.a.a.k kVarO;
        s.a.a.i iVar = this.k;
        while (true) {
            Object objI = iVar.i();
            Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            r1 = (s.a.a.k) objI;
            if (r1 == iVar || !(r1 instanceof p)) {
                break;
            }
            if (((((p) r1) instanceof i) && !r1.m()) || (kVarO = r1.o()) == null) {
                break;
            }
            kVarO.l();
        }
        return (p) r1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x008e, code lost:
    
        r4 = r0.u();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0096, code lost:
    
        if (r4 != d0.w.h.c.getCOROUTINE_SUSPENDED()) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0098, code lost:
    
        d0.w.i.a.g.probeCoroutineSuspended(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009f, code lost:
    
        if (r4 != d0.w.h.c.getCOROUTINE_SUSPENDED()) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a1, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a4, code lost:
    
        return kotlin.Unit.a;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0074 A[SYNTHETIC] */
    @Override // s.a.c2.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object o(E e, Continuation<? super Unit> continuation) {
        Object objK;
        if (k(e) == s.a.c2.b.f3834b) {
            return Unit.a;
        }
        s.a.l lVarO0 = b.i.a.f.e.o.f.o0(d0.w.h.b.intercepted(continuation));
        while (true) {
            if (!(this.k.j() instanceof p) && i()) {
                r tVar = this.l == null ? new t(e, lVarO0) : new u(e, lVarO0, this.l);
                Object objC = c(tVar);
                if (objC == null) {
                    lVarO0.f(new r1(tVar));
                    break;
                }
                if (objC instanceof i) {
                    a(this, lVarO0, e, (i) objC);
                    break;
                }
                if (objC != s.a.c2.b.e && !(objC instanceof n)) {
                    throw new IllegalStateException(b.d.b.a.a.v("enqueueSend returned ", objC).toString());
                }
                objK = k(e);
                if (objK != s.a.c2.b.f3834b) {
                }
            } else {
                objK = k(e);
                if (objK != s.a.c2.b.f3834b) {
                    Unit unit = Unit.a;
                    k.a aVar = d0.k.j;
                    lVarO0.resumeWith(d0.k.m97constructorimpl(unit));
                    break;
                }
                if (objK != s.a.c2.b.c) {
                    if (!(objK instanceof i)) {
                        throw new IllegalStateException(b.d.b.a.a.v("offerInternal returned ", objK).toString());
                    }
                    a(this, lVarO0, e, (i) objK);
                }
            }
        }
    }

    @Override // s.a.c2.s
    public final boolean offer(E e) throws Throwable {
        Object objK = k(e);
        if (objK == s.a.c2.b.f3834b) {
            return true;
        }
        if (objK != s.a.c2.b.c) {
            if (!(objK instanceof i)) {
                throw new IllegalStateException(b.d.b.a.a.v("offerInternal returned ", objK).toString());
            }
            Throwable thG = g(e, (i) objK);
            String str = s.a.a.s.a;
            throw thG;
        }
        i<?> iVarE = e();
        if (iVarE == null) {
            return false;
        }
        Throwable thG2 = g(e, iVarE);
        String str2 = s.a.a.s.a;
        throw thG2;
    }

    @Override // s.a.c2.s
    public final boolean p() {
        return e() != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final r q() {
        s.a.a.k kVar;
        s.a.a.k kVarO;
        s.a.a.i iVar = this.k;
        while (true) {
            Object objI = iVar.i();
            Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            kVar = (s.a.a.k) objI;
            if (kVar == iVar || !(kVar instanceof r)) {
                break;
            }
            if (((((r) kVar) instanceof i) && !kVar.m()) || (kVarO = kVar.o()) == null) {
                break;
            }
            kVarO.l();
        }
        return (r) kVar;
    }

    public String toString() {
        String string;
        String string2;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(MentionUtilsKt.MENTIONS_CHAR);
        sb.append(b.i.a.f.e.o.f.l0(this));
        sb.append('{');
        s.a.a.k kVarJ = this.k.j();
        if (kVarJ == this.k) {
            string2 = "EmptyQueue";
        } else {
            if (kVarJ instanceof i) {
                string = kVarJ.toString();
            } else if (kVarJ instanceof n) {
                string = "ReceiveQueued";
            } else if (kVarJ instanceof r) {
                string = "SendQueued";
            } else {
                string = "UNEXPECTED:" + kVarJ;
            }
            s.a.a.k kVarK = this.k.k();
            if (kVarK != kVarJ) {
                StringBuilder sbX = b.d.b.a.a.X(string, ",queueSize=");
                Object objI = this.k.i();
                Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                int i = 0;
                for (s.a.a.k kVarJ2 = (s.a.a.k) objI; !d0.z.d.m.areEqual(kVarJ2, r2); kVarJ2 = kVarJ2.j()) {
                    i++;
                }
                sbX.append(i);
                string2 = sbX.toString();
                if (kVarK instanceof i) {
                    string2 = string2 + ",closedForSend=" + kVarK;
                }
            } else {
                string2 = string;
            }
        }
        sb.append(string2);
        sb.append('}');
        sb.append(d());
        return sb.toString();
    }
}
