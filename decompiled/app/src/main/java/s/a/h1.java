package s.a;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.TimeoutCancellationException;
import s.a.a.k;

/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public class h1 implements Job, r, q1 {
    public static final AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(h1.class, Object.class, "_state");
    public volatile Object _parentHandle;
    public volatile Object _state;

    /* compiled from: JobSupport.kt */
    public static final class a extends g1<Job> {
        public final h1 n;
        public final b o;
        public final q p;
        public final Object q;

        public a(h1 h1Var, b bVar, q qVar, Object obj) {
            super(qVar.n);
            this.n = h1Var;
            this.o = bVar;
            this.p = qVar;
            this.q = obj;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            q(th);
            return Unit.a;
        }

        @Override // s.a.y
        public void q(Throwable th) {
            h1 h1Var = this.n;
            b bVar = this.o;
            q qVar = this.p;
            Object obj = this.q;
            q qVarU = h1Var.U(qVar);
            if (qVarU == null || !h1Var.d0(bVar, qVarU, obj)) {
                h1Var.v(h1Var.H(bVar, obj));
            }
        }

        @Override // s.a.a.k
        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("ChildCompletion[");
            sbU.append(this.p);
            sbU.append(", ");
            sbU.append(this.q);
            sbU.append(']');
            return sbU.toString();
        }
    }

    /* compiled from: JobSupport.kt */
    public static final class b implements z0 {
        public volatile Object _exceptionsHolder = null;
        public volatile int _isCompleting;
        public volatile Object _rootCause;
        public final m1 j;

        public b(m1 m1Var, boolean z2, Throwable th) {
            this.j = m1Var;
            this._isCompleting = z2 ? 1 : 0;
            this._rootCause = th;
        }

        @Override // s.a.z0
        public boolean a() {
            return ((Throwable) this._rootCause) == null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b(Throwable th) {
            Throwable th2 = (Throwable) this._rootCause;
            if (th2 == null) {
                this._rootCause = th;
                return;
            }
            if (th == th2) {
                return;
            }
            Object obj = this._exceptionsHolder;
            if (obj == null) {
                this._exceptionsHolder = th;
                return;
            }
            if (!(obj instanceof Throwable)) {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(b.d.b.a.a.v("State is ", obj).toString());
                }
                ((ArrayList) obj).add(th);
            } else {
                if (th == obj) {
                    return;
                }
                ArrayList<Throwable> arrayListC = c();
                arrayListC.add(obj);
                arrayListC.add(th);
                this._exceptionsHolder = arrayListC;
            }
        }

        public final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        public final boolean d() {
            return ((Throwable) this._rootCause) != null;
        }

        public final boolean e() {
            return this._exceptionsHolder == i1.e;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final List<Throwable> f(Throwable th) {
            ArrayList<Throwable> arrayListC;
            Object obj = this._exceptionsHolder;
            if (obj == null) {
                arrayListC = c();
            } else if (obj instanceof Throwable) {
                ArrayList<Throwable> arrayListC2 = c();
                arrayListC2.add(obj);
                arrayListC = arrayListC2;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(b.d.b.a.a.v("State is ", obj).toString());
                }
                arrayListC = (ArrayList) obj;
            }
            Throwable th2 = (Throwable) this._rootCause;
            if (th2 != null) {
                arrayListC.add(0, th2);
            }
            if (th != null && (!d0.z.d.m.areEqual(th, th2))) {
                arrayListC.add(th);
            }
            this._exceptionsHolder = i1.e;
            return arrayListC;
        }

        @Override // s.a.z0
        public m1 getList() {
            return this.j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("Finishing[cancelling=");
            sbU.append(d());
            sbU.append(", completing=");
            sbU.append((boolean) this._isCompleting);
            sbU.append(", rootCause=");
            sbU.append((Throwable) this._rootCause);
            sbU.append(", exceptions=");
            sbU.append(this._exceptionsHolder);
            sbU.append(", list=");
            sbU.append(this.j);
            sbU.append(']');
            return sbU.toString();
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    public static final class c extends k.a {
        public final /* synthetic */ h1 d;
        public final /* synthetic */ Object e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(s.a.a.k kVar, s.a.a.k kVar2, h1 h1Var, Object obj) {
            super(kVar2);
            this.d = h1Var;
            this.e = obj;
        }

        @Override // s.a.a.d
        public Object c(s.a.a.k kVar) {
            if (this.d.M() == this.e) {
                return null;
            }
            return s.a.a.j.a;
        }
    }

    /* compiled from: JobSupport.kt */
    @d0.w.i.a.e(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", l = {949, 951}, m = "invokeSuspend")
    public static final class d extends d0.w.i.a.j implements Function2<d0.f0.k<? super r>, Continuation<? super Unit>, Object> {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public Object L$5;
        public int label;
        private d0.f0.k p$;

        public d(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = h1.this.new d(continuation);
            dVar.p$ = (d0.f0.k) obj;
            return dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(d0.f0.k<? super r> kVar, Continuation<? super Unit> continuation) {
            d dVar = h1.this.new d(continuation);
            dVar.p$ = kVar;
            return dVar.invokeSuspend(Unit.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0081 -> B:27:0x009d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x009a -> B:27:0x009d). Please report as a decompilation issue!!! */
        @Override // d0.w.i.a.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            s.a.a.i list;
            d0.f0.k kVar;
            Object obj2;
            s.a.a.k kVarJ;
            d dVar;
            s.a.a.i iVar;
            Object coroutine_suspended = d0.w.h.c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                d0.l.throwOnFailure(obj);
                d0.f0.k kVar2 = this.p$;
                Object objM = h1.this.M();
                if (objM instanceof q) {
                    r rVar = ((q) objM).n;
                    this.L$0 = kVar2;
                    this.L$1 = objM;
                    this.label = 1;
                    if (kVar2.yield(rVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if ((objM instanceof z0) && (list = ((z0) objM).getList()) != null) {
                    Object objI = list.i();
                    Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                    kVar = kVar2;
                    obj2 = objM;
                    kVarJ = (s.a.a.k) objI;
                    dVar = this;
                    iVar = list;
                    if (!d0.z.d.m.areEqual(kVarJ, list)) {
                    }
                }
            } else if (i == 1) {
                d0.l.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kVarJ = (s.a.a.k) this.L$4;
                list = (s.a.a.i) this.L$3;
                iVar = (m1) this.L$2;
                obj2 = this.L$1;
                kVar = (d0.f0.k) this.L$0;
                d0.l.throwOnFailure(obj);
                dVar = this;
                kVarJ = kVarJ.j();
                if (!d0.z.d.m.areEqual(kVarJ, list)) {
                    if (kVarJ instanceof q) {
                        q qVar = (q) kVarJ;
                        r rVar2 = qVar.n;
                        dVar.L$0 = kVar;
                        dVar.L$1 = obj2;
                        dVar.L$2 = iVar;
                        dVar.L$3 = list;
                        dVar.L$4 = kVarJ;
                        dVar.L$5 = qVar;
                        dVar.label = 2;
                        if (kVar.yield(rVar2, dVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    kVarJ = kVarJ.j();
                    if (!d0.z.d.m.areEqual(kVarJ, list)) {
                    }
                }
            }
            return Unit.a;
        }
    }

    public h1(boolean z2) {
        this._state = z2 ? i1.g : i1.f;
        this._parentHandle = null;
    }

    public static /* synthetic */ CancellationException b0(h1 h1Var, Throwable th, String str, int i, Object obj) {
        int i2 = i & 1;
        return h1Var.a0(th, null);
    }

    @Override // s.a.q1
    public CancellationException A() {
        Throwable th;
        Object objM = M();
        if (objM instanceof b) {
            th = (Throwable) ((b) objM)._rootCause;
        } else if (objM instanceof w) {
            th = ((w) objM).f3846b;
        } else {
            if (objM instanceof z0) {
                throw new IllegalStateException(b.d.b.a.a.v("Cannot be cancelling child in this state: ", objM).toString());
            }
            th = null;
        }
        CancellationException cancellationException = (CancellationException) (th instanceof CancellationException ? th : null);
        if (cancellationException != null) {
            return cancellationException;
        }
        StringBuilder sbU = b.d.b.a.a.U("Parent job is ");
        sbU.append(Z(objM));
        return new JobCancellationException(sbU.toString(), th, this);
    }

    public String B() {
        return "Job was cancelled";
    }

    @Override // kotlinx.coroutines.Job
    public final p D(r rVar) {
        m0 m0VarW0 = b.i.a.f.e.o.f.w0(this, true, false, new q(this, rVar), 2, null);
        Objects.requireNonNull(m0VarW0, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (p) m0VarW0;
    }

    public boolean E(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return w(th) && J();
    }

    public final void F(z0 z0Var, Object obj) throws Throwable {
        p pVar = (p) this._parentHandle;
        if (pVar != null) {
            pVar.dispose();
            this._parentHandle = o1.j;
        }
        CompletionHandlerException completionHandlerException = null;
        if (!(obj instanceof w)) {
            obj = null;
        }
        w wVar = (w) obj;
        Throwable th = wVar != null ? wVar.f3846b : null;
        if (z0Var instanceof g1) {
            try {
                ((g1) z0Var).q(th);
                return;
            } catch (Throwable th2) {
                O(new CompletionHandlerException("Exception in completion handler " + z0Var + " for " + this, th2));
                return;
            }
        }
        m1 list = z0Var.getList();
        if (list != null) {
            Object objI = list.i();
            Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            for (s.a.a.k kVarJ = (s.a.a.k) objI; !d0.z.d.m.areEqual(kVarJ, list); kVarJ = kVarJ.j()) {
                if (kVarJ instanceof g1) {
                    g1 g1Var = (g1) kVarJ;
                    try {
                        g1Var.q(th);
                    } catch (Throwable th3) {
                        if (completionHandlerException != null) {
                            d0.b.addSuppressed(completionHandlerException, th3);
                        } else {
                            completionHandlerException = new CompletionHandlerException("Exception in completion handler " + g1Var + " for " + this, th3);
                        }
                    }
                }
            }
            if (completionHandlerException != null) {
                O(completionHandlerException);
            }
        }
    }

    public final Throwable G(Object obj) {
        if (obj != null ? obj instanceof Throwable : true) {
            return obj != null ? (Throwable) obj : new JobCancellationException(B(), null, this);
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((q1) obj).A();
    }

    public final Object H(b bVar, Object obj) throws Throwable {
        Throwable thI;
        w wVar = (w) (!(obj instanceof w) ? null : obj);
        Throwable th = wVar != null ? wVar.f3846b : null;
        synchronized (bVar) {
            bVar.d();
            List<Throwable> listF = bVar.f(th);
            thI = I(bVar, listF);
            if (thI != null && listF.size() > 1) {
                Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(listF.size()));
                for (Throwable th2 : listF) {
                    if (th2 != thI && th2 != thI && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                        d0.b.addSuppressed(thI, th2);
                    }
                }
            }
        }
        if (thI != null && thI != th) {
            obj = new w(thI, false, 2);
        }
        if (thI != null) {
            if (z(thI) || N(thI)) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                w.a.compareAndSet((w) obj, 0, 1);
            }
        }
        W(obj);
        j.compareAndSet(this, bVar, obj instanceof z0 ? new a1((z0) obj) : obj);
        F(bVar, obj);
        return obj;
    }

    public final Throwable I(b bVar, List<? extends Throwable> list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (bVar.d()) {
                return new JobCancellationException(B(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    public boolean J() {
        return true;
    }

    public boolean K() {
        return false;
    }

    public final m1 L(z0 z0Var) {
        m1 list = z0Var.getList();
        if (list != null) {
            return list;
        }
        if (z0Var instanceof p0) {
            return new m1();
        }
        if (z0Var instanceof g1) {
            Y((g1) z0Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + z0Var).toString());
    }

    public final Object M() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof s.a.a.p)) {
                return obj;
            }
            ((s.a.a.p) obj).a(this);
        }
    }

    public boolean N(Throwable th) {
        return false;
    }

    public void O(Throwable th) throws Throwable {
        throw th;
    }

    public final void P(Job job) {
        if (job == null) {
            this._parentHandle = o1.j;
            return;
        }
        job.start();
        p pVarD = job.D(this);
        this._parentHandle = pVarD;
        if (!(M() instanceof z0)) {
            pVarD.dispose();
            this._parentHandle = o1.j;
        }
    }

    public boolean Q() {
        return this instanceof f;
    }

    public final Object R(Object obj) throws Throwable {
        Object objC0;
        do {
            objC0 = c0(M(), obj);
            if (objC0 == i1.a) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                if (!(obj instanceof w)) {
                    obj = null;
                }
                w wVar = (w) obj;
                throw new IllegalStateException(str, wVar != null ? wVar.f3846b : null);
            }
        } while (objC0 == i1.c);
        return objC0;
    }

    public final g1<?> S(Function1<? super Throwable, Unit> function1, boolean z2) {
        if (z2) {
            e1 e1Var = (e1) (function1 instanceof e1 ? function1 : null);
            return e1Var != null ? e1Var : new c1(this, function1);
        }
        g1<?> g1Var = (g1) (function1 instanceof g1 ? function1 : null);
        return g1Var != null ? g1Var : new d1(this, function1);
    }

    public String T() {
        return getClass().getSimpleName();
    }

    public final q U(s.a.a.k kVar) {
        while (kVar.m()) {
            kVar = kVar.k();
        }
        while (true) {
            kVar = kVar.j();
            if (!kVar.m()) {
                if (kVar instanceof q) {
                    return (q) kVar;
                }
                if (kVar instanceof m1) {
                    return null;
                }
            }
        }
    }

    public final void V(m1 m1Var, Throwable th) throws Throwable {
        CompletionHandlerException completionHandlerException = null;
        Object objI = m1Var.i();
        Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        for (s.a.a.k kVarJ = (s.a.a.k) objI; !d0.z.d.m.areEqual(kVarJ, m1Var); kVarJ = kVarJ.j()) {
            if (kVarJ instanceof e1) {
                g1 g1Var = (g1) kVarJ;
                try {
                    g1Var.q(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        d0.b.addSuppressed(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + g1Var + " for " + this, th2);
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            O(completionHandlerException);
        }
        z(th);
    }

    public void W(Object obj) {
    }

    public void X() {
    }

    public final void Y(g1<?> g1Var) {
        m1 m1Var = new m1();
        s.a.a.k.k.lazySet(m1Var, g1Var);
        s.a.a.k.j.lazySet(m1Var, g1Var);
        while (true) {
            if (g1Var.i() != g1Var) {
                break;
            } else if (s.a.a.k.j.compareAndSet(g1Var, g1Var, m1Var)) {
                m1Var.g(g1Var);
                break;
            }
        }
        j.compareAndSet(this, g1Var, g1Var.j());
    }

    public final String Z(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof z0 ? ((z0) obj).a() ? "Active" : "New" : obj instanceof w ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        return bVar.d() ? "Cancelling" : bVar._isCompleting != 0 ? "Completing" : "Active";
    }

    @Override // kotlinx.coroutines.Job
    public boolean a() {
        Object objM = M();
        return (objM instanceof z0) && ((z0) objM).a();
    }

    public final CancellationException a0(Throwable th, String str) {
        CancellationException jobCancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (jobCancellationException == null) {
            if (str == null) {
                str = B();
            }
            jobCancellationException = new JobCancellationException(str, th, this);
        }
        return jobCancellationException;
    }

    @Override // kotlinx.coroutines.Job
    public void b(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(B(), null, this);
        }
        x(cancellationException);
    }

    public final Object c0(Object obj, Object obj2) throws Throwable {
        if (!(obj instanceof z0)) {
            return i1.a;
        }
        boolean z2 = true;
        if (((obj instanceof p0) || (obj instanceof g1)) && !(obj instanceof q) && !(obj2 instanceof w)) {
            z0 z0Var = (z0) obj;
            if (j.compareAndSet(this, z0Var, obj2 instanceof z0 ? new a1((z0) obj2) : obj2)) {
                W(obj2);
                F(z0Var, obj2);
            } else {
                z2 = false;
            }
            return z2 ? obj2 : i1.c;
        }
        z0 z0Var2 = (z0) obj;
        m1 m1VarL = L(z0Var2);
        if (m1VarL == null) {
            return i1.c;
        }
        q qVarU = null;
        b bVar = (b) (!(z0Var2 instanceof b) ? null : z0Var2);
        if (bVar == null) {
            bVar = new b(m1VarL, false, null);
        }
        synchronized (bVar) {
            if (bVar._isCompleting != 0) {
                return i1.a;
            }
            bVar._isCompleting = 1;
            if (bVar != z0Var2 && !j.compareAndSet(this, z0Var2, bVar)) {
                return i1.c;
            }
            boolean zD = bVar.d();
            w wVar = (w) (!(obj2 instanceof w) ? null : obj2);
            if (wVar != null) {
                bVar.b(wVar.f3846b);
            }
            Throwable th = (Throwable) bVar._rootCause;
            if (!(true ^ zD)) {
                th = null;
            }
            if (th != null) {
                V(m1VarL, th);
            }
            q qVar = (q) (!(z0Var2 instanceof q) ? null : z0Var2);
            if (qVar != null) {
                qVarU = qVar;
            } else {
                m1 list = z0Var2.getList();
                if (list != null) {
                    qVarU = U(list);
                }
            }
            return (qVarU == null || !d0(bVar, qVarU, obj2)) ? H(bVar, obj2) : i1.f3841b;
        }
    }

    public final boolean d0(b bVar, q qVar, Object obj) {
        while (b.i.a.f.e.o.f.w0(qVar.n, false, false, new a(this, bVar, qVar, obj), 1, null) == o1.j) {
            qVar = U(qVar);
            if (qVar == null) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public final Sequence<Job> e() {
        return d0.f0.l.sequence(new d(null));
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) CoroutineContext.Element.a.fold(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) CoroutineContext.Element.a.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return Job.INSTANCE;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return CoroutineContext.Element.a.minusKey(this, key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v3, types: [s.a.y0] */
    @Override // kotlinx.coroutines.Job
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final m0 n(boolean z2, boolean z3, Function1<? super Throwable, Unit> function1) {
        Throwable th;
        g1<?> g1VarS = null;
        while (true) {
            Object objM = M();
            if (objM instanceof p0) {
                p0 p0Var = (p0) objM;
                if (p0Var.j) {
                    if (g1VarS == null) {
                        g1VarS = S(function1, z2);
                    }
                    if (j.compareAndSet(this, objM, g1VarS)) {
                        return g1VarS;
                    }
                } else {
                    m1 m1Var = new m1();
                    if (!p0Var.j) {
                        m1Var = new y0(m1Var);
                    }
                    j.compareAndSet(this, p0Var, m1Var);
                }
            } else {
                if (!(objM instanceof z0)) {
                    if (z3) {
                        if (!(objM instanceof w)) {
                            objM = null;
                        }
                        w wVar = (w) objM;
                        function1.invoke(wVar != null ? wVar.f3846b : null);
                    }
                    return o1.j;
                }
                m1 list = ((z0) objM).getList();
                if (list == null) {
                    Objects.requireNonNull(objM, "null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                    Y((g1) objM);
                } else {
                    m0 m0Var = o1.j;
                    if (z2 && (objM instanceof b)) {
                        synchronized (objM) {
                            th = (Throwable) ((b) objM)._rootCause;
                            if (th == null || ((function1 instanceof q) && ((b) objM)._isCompleting == 0)) {
                                if (g1VarS == null) {
                                    g1VarS = S(function1, z2);
                                }
                                if (t(objM, list, g1VarS)) {
                                    if (th == null) {
                                        return g1VarS;
                                    }
                                    m0Var = g1VarS;
                                }
                            }
                        }
                        if (th == null) {
                        }
                    } else {
                        th = null;
                        if (th == null) {
                            if (z3) {
                                function1.invoke(th);
                            }
                            return m0Var;
                        }
                        if (g1VarS == null) {
                            g1VarS = S(function1, z2);
                        }
                        if (t(objM, list, g1VarS)) {
                            return g1VarS;
                        }
                    }
                }
            }
        }
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.a.plus(this, coroutineContext);
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException q() {
        Object objM = M();
        if (objM instanceof b) {
            Throwable th = (Throwable) ((b) objM)._rootCause;
            if (th != null) {
                return a0(th, getClass().getSimpleName() + " is cancelling");
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (objM instanceof z0) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (objM instanceof w) {
            return b0(this, ((w) objM).f3846b, null, 1, null);
        }
        return new JobCancellationException(getClass().getSimpleName() + " has completed normally", null, this);
    }

    @Override // s.a.r
    public final void s(q1 q1Var) throws Throwable {
        w(q1Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    @Override // kotlinx.coroutines.Job
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean start() {
        char c2;
        do {
            Object objM = M();
            c2 = 65535;
            if (objM instanceof p0) {
                if (((p0) objM).j) {
                    c2 = 0;
                } else if (j.compareAndSet(this, objM, i1.g)) {
                    X();
                    c2 = 1;
                }
            } else if (objM instanceof y0) {
                if (j.compareAndSet(this, objM, ((y0) objM).j)) {
                    X();
                    c2 = 1;
                }
            }
            if (c2 == 0) {
                return false;
            }
        } while (c2 != 1);
        return true;
    }

    public final boolean t(Object obj, m1 m1Var, g1<?> g1Var) {
        int iP;
        c cVar = new c(g1Var, g1Var, this, obj);
        do {
            iP = m1Var.k().p(g1Var, m1Var, cVar);
            if (iP == 1) {
                return true;
            }
        } while (iP != 2);
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(T() + '{' + Z(M()) + '}');
        sb.append(MentionUtilsKt.MENTIONS_CHAR);
        sb.append(b.i.a.f.e.o.f.l0(this));
        return sb.toString();
    }

    @Override // kotlinx.coroutines.Job
    public final m0 u(Function1<? super Throwable, Unit> function1) {
        return n(false, true, function1);
    }

    public void v(Object obj) {
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean w(Object obj) throws Throwable {
        s.a.a.t tVar;
        boolean z2;
        Object objC0 = i1.a;
        if (K()) {
            do {
                Object objM = M();
                if (!(objM instanceof z0) || ((objM instanceof b) && ((b) objM)._isCompleting != 0)) {
                    objC0 = i1.a;
                    break;
                }
                objC0 = c0(objM, new w(G(obj), false, 2));
            } while (objC0 == i1.c);
            if (objC0 == i1.f3841b) {
                return true;
            }
        }
        if (objC0 == i1.a) {
            Throwable thG = null;
            while (true) {
                Object objM2 = M();
                if (!(objM2 instanceof b)) {
                    if (!(objM2 instanceof z0)) {
                        tVar = i1.d;
                        break;
                    }
                    if (thG == null) {
                        thG = G(obj);
                    }
                    z0 z0Var = (z0) objM2;
                    if (z0Var.a()) {
                        m1 m1VarL = L(z0Var);
                        if (m1VarL != null) {
                            if (j.compareAndSet(this, z0Var, new b(m1VarL, false, thG))) {
                                V(m1VarL, thG);
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                tVar = i1.a;
                                break;
                            }
                        }
                    } else {
                        Object objC02 = c0(objM2, new w(thG, false, 2));
                        if (objC02 == i1.a) {
                            throw new IllegalStateException(b.d.b.a.a.v("Cannot happen in ", objM2).toString());
                        }
                        if (objC02 != i1.c) {
                            objC0 = objC02;
                            break;
                        }
                    }
                } else {
                    synchronized (objM2) {
                        if (((b) objM2).e()) {
                            tVar = i1.d;
                        } else {
                            boolean zD = ((b) objM2).d();
                            if (obj != null || !zD) {
                                if (thG == null) {
                                    thG = G(obj);
                                }
                                ((b) objM2).b(thG);
                            }
                            Throwable th = zD ^ true ? (Throwable) ((b) objM2)._rootCause : null;
                            if (th != null) {
                                V(((b) objM2).j, th);
                            }
                            tVar = i1.a;
                        }
                    }
                }
            }
            objC0 = tVar;
        }
        if (objC0 != i1.a && objC0 != i1.f3841b) {
            if (objC0 == i1.d) {
                return false;
            }
            v(objC0);
        }
        return true;
    }

    public void x(Throwable th) throws Throwable {
        w(th);
    }

    public final boolean z(Throwable th) {
        if (Q()) {
            return true;
        }
        boolean z2 = th instanceof CancellationException;
        p pVar = (p) this._parentHandle;
        return (pVar == null || pVar == o1.j) ? z2 : pVar.h(th) || z2;
    }
}
