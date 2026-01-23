package p659s.p660a.p663c2;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result2;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p585h.IntrinsicsJvm;
import p507d0.p584w.p586i.p587a.ContinuationImpl3;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p584w.p586i.p587a.DebugProbes;
import p507d0.p584w.p586i.p587a.boxing;
import p659s.p660a.CancellableContinuationImpl3;
import p659s.p660a.CancellableContinuationImpl5;
import p659s.p660a.CancellableContinuationImpl6;
import p659s.p660a.p661a.LockFreeLinkedList;
import p659s.p660a.p661a.LockFreeLinkedList2;
import p659s.p660a.p661a.LockFreeLinkedList3;
import p659s.p660a.p661a.LockFreeLinkedList4;
import p659s.p660a.p661a.OnUndeliveredElement2;
import p659s.p660a.p661a.StackTraceRecovery;
import p659s.p660a.p661a.Symbol3;
import p659s.p660a.p663c2.Channel8;

/* JADX INFO: renamed from: s.a.c2.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractChannel<E> extends AbstractChannel3<E> implements Channel4<E> {

    /* JADX INFO: renamed from: s.a.c2.a$a */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    public static final class a<E> implements Channel5<E> {

        /* JADX INFO: renamed from: a */
        public Object f27729a = AbstractChannel2.f27742d;

        /* JADX INFO: renamed from: b */
        public final AbstractChannel<E> f27730b;

        public a(AbstractChannel<E> abstractChannel) {
            this.f27730b = abstractChannel;
        }

        @Override // p659s.p660a.p663c2.Channel5
        /* JADX INFO: renamed from: a */
        public Object mo11207a(Continuation<? super Boolean> continuation) {
            Object obj = this.f27729a;
            Symbol3 symbol3 = AbstractChannel2.f27742d;
            if (obj != symbol3) {
                return boxing.boxBoolean(m11208b(obj));
            }
            Object objMo11206v = this.f27730b.mo11206v();
            this.f27729a = objMo11206v;
            if (objMo11206v != symbol3) {
                return boxing.boxBoolean(m11208b(objMo11206v));
            }
            CancellableContinuationImpl5 cancellableContinuationImpl5M4324o0 = C3404f.m4324o0(IntrinsicsJvm.intercepted(continuation));
            d dVar = new d(this, cancellableContinuationImpl5M4324o0);
            while (true) {
                if (this.f27730b.mo11202r(dVar)) {
                    AbstractChannel<E> abstractChannel = this.f27730b;
                    Objects.requireNonNull(abstractChannel);
                    cancellableContinuationImpl5M4324o0.mo10902f(abstractChannel.new e(dVar));
                    break;
                }
                Object objMo11206v2 = this.f27730b.mo11206v();
                this.f27729a = objMo11206v2;
                if (objMo11206v2 instanceof AbstractChannel4) {
                    AbstractChannel4 abstractChannel4 = (AbstractChannel4) objMo11206v2;
                    if (abstractChannel4.f27763m == null) {
                        Boolean boolBoxBoolean = boxing.boxBoolean(false);
                        Result2.a aVar = Result2.f25169j;
                        cancellableContinuationImpl5M4324o0.resumeWith(Result2.m11474constructorimpl(boolBoxBoolean));
                    } else {
                        Throwable thM11233v = abstractChannel4.m11233v();
                        Result2.a aVar2 = Result2.f25169j;
                        cancellableContinuationImpl5M4324o0.resumeWith(Result2.m11474constructorimpl(Result3.createFailure(thM11233v)));
                    }
                } else if (objMo11206v2 != AbstractChannel2.f27742d) {
                    Boolean boolBoxBoolean2 = boxing.boxBoolean(true);
                    Function1<E, Unit> function1 = this.f27730b.f27747l;
                    cancellableContinuationImpl5M4324o0.m11330y(boolBoxBoolean2, cancellableContinuationImpl5M4324o0.f27864l, function1 != null ? new OnUndeliveredElement2(function1, objMo11206v2, cancellableContinuationImpl5M4324o0.f27871o) : null);
                }
            }
            Object objM11326u = cancellableContinuationImpl5M4324o0.m11326u();
            if (objM11326u == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return objM11326u;
        }

        /* JADX INFO: renamed from: b */
        public final boolean m11208b(Object obj) throws Throwable {
            if (!(obj instanceof AbstractChannel4)) {
                return true;
            }
            AbstractChannel4 abstractChannel4 = (AbstractChannel4) obj;
            if (abstractChannel4.f27763m == null) {
                return false;
            }
            Throwable thM11233v = abstractChannel4.m11233v();
            String str = StackTraceRecovery.f27703a;
            throw thM11233v;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p659s.p660a.p663c2.Channel5
        public E next() throws Throwable {
            E e = (E) this.f27729a;
            if (e instanceof AbstractChannel4) {
                Throwable thM11233v = ((AbstractChannel4) e).m11233v();
                String str = StackTraceRecovery.f27703a;
                throw thM11233v;
            }
            Symbol3 symbol3 = AbstractChannel2.f27742d;
            if (e == symbol3) {
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            this.f27729a = symbol3;
            return e;
        }
    }

    /* JADX INFO: renamed from: s.a.c2.a$b */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    public static class b<E> extends AbstractChannel5<E> {

        /* JADX INFO: renamed from: m */
        public final CancellableContinuation<Object> f27731m;

        /* JADX INFO: renamed from: n */
        public final int f27732n;

        public b(CancellableContinuation<Object> cancellableContinuation, int i) {
            this.f27731m = cancellableContinuation;
            this.f27732n = i;
        }

        @Override // p659s.p660a.p663c2.AbstractChannel6
        /* JADX INFO: renamed from: c */
        public void mo11209c(E e) {
            this.f27731m.mo10907r(CancellableContinuationImpl6.f27874a);
        }

        @Override // p659s.p660a.p663c2.AbstractChannel6
        /* JADX INFO: renamed from: d */
        public Symbol3 mo11210d(E e, LockFreeLinkedList3.b bVar) {
            if (this.f27731m.mo10904h(this.f27732n != 2 ? e : new Channel8(e), null, mo11212q(e)) != null) {
                return CancellableContinuationImpl6.f27874a;
            }
            return null;
        }

        @Override // p659s.p660a.p663c2.AbstractChannel5
        /* JADX INFO: renamed from: r */
        public void mo11211r(AbstractChannel4<?> abstractChannel4) {
            int i = this.f27732n;
            if (i == 1 && abstractChannel4.f27763m == null) {
                CancellableContinuation<Object> cancellableContinuation = this.f27731m;
                Result2.a aVar = Result2.f25169j;
                cancellableContinuation.resumeWith(Result2.m11474constructorimpl(null));
            } else {
                if (i == 2) {
                    CancellableContinuation<Object> cancellableContinuation2 = this.f27731m;
                    Channel8 channel8 = new Channel8(new Channel8.a(abstractChannel4.f27763m));
                    Result2.a aVar2 = Result2.f25169j;
                    cancellableContinuation2.resumeWith(Result2.m11474constructorimpl(channel8));
                    return;
                }
                CancellableContinuation<Object> cancellableContinuation3 = this.f27731m;
                Throwable thM11233v = abstractChannel4.m11233v();
                Result2.a aVar3 = Result2.f25169j;
                cancellableContinuation3.resumeWith(Result2.m11474constructorimpl(Result3.createFailure(thM11233v)));
            }
        }

        @Override // p659s.p660a.p661a.LockFreeLinkedList3
        public String toString() {
            StringBuilder sbM833U = outline.m833U("ReceiveElement@");
            sbM833U.append(C3404f.m4312l0(this));
            sbM833U.append("[receiveMode=");
            return outline.m813A(sbM833U, this.f27732n, ']');
        }
    }

    /* JADX INFO: renamed from: s.a.c2.a$c */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    public static final class c<E> extends b<E> {

        /* JADX INFO: renamed from: o */
        public final Function1<E, Unit> f27733o;

        /* JADX WARN: Multi-variable type inference failed */
        public c(CancellableContinuation<Object> cancellableContinuation, int i, Function1<? super E, Unit> function1) {
            super(cancellableContinuation, i);
            this.f27733o = function1;
        }

        @Override // p659s.p660a.p663c2.AbstractChannel5
        /* JADX INFO: renamed from: q */
        public Function1<Throwable, Unit> mo11212q(E e) {
            return new OnUndeliveredElement2(this.f27733o, e, this.f27731m.getContext());
        }
    }

    /* JADX INFO: renamed from: s.a.c2.a$d */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    public static class d<E> extends AbstractChannel5<E> {

        /* JADX INFO: renamed from: m */
        public final a<E> f27734m;

        /* JADX INFO: renamed from: n */
        public final CancellableContinuation<Boolean> f27735n;

        /* JADX WARN: Multi-variable type inference failed */
        public d(a<E> aVar, CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f27734m = aVar;
            this.f27735n = cancellableContinuation;
        }

        @Override // p659s.p660a.p663c2.AbstractChannel6
        /* JADX INFO: renamed from: c */
        public void mo11209c(E e) {
            this.f27734m.f27729a = e;
            this.f27735n.mo10907r(CancellableContinuationImpl6.f27874a);
        }

        @Override // p659s.p660a.p663c2.AbstractChannel6
        /* JADX INFO: renamed from: d */
        public Symbol3 mo11210d(E e, LockFreeLinkedList3.b bVar) {
            if (this.f27735n.mo10904h(Boolean.TRUE, null, mo11212q(e)) != null) {
                return CancellableContinuationImpl6.f27874a;
            }
            return null;
        }

        @Override // p659s.p660a.p663c2.AbstractChannel5
        /* JADX INFO: renamed from: q */
        public Function1<Throwable, Unit> mo11212q(E e) {
            Function1<E, Unit> function1 = this.f27734m.f27730b.f27747l;
            if (function1 != null) {
                return new OnUndeliveredElement2(function1, e, this.f27735n.getContext());
            }
            return null;
        }

        @Override // p659s.p660a.p663c2.AbstractChannel5
        /* JADX INFO: renamed from: r */
        public void mo11211r(AbstractChannel4<?> abstractChannel4) {
            Object objMo10901c = abstractChannel4.f27763m == null ? this.f27735n.mo10901c(Boolean.FALSE, null) : this.f27735n.mo10903g(abstractChannel4.m11233v());
            if (objMo10901c != null) {
                this.f27734m.f27729a = abstractChannel4;
                this.f27735n.mo10907r(objMo10901c);
            }
        }

        @Override // p659s.p660a.p661a.LockFreeLinkedList3
        public String toString() {
            StringBuilder sbM833U = outline.m833U("ReceiveHasNext@");
            sbM833U.append(C3404f.m4312l0(this));
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: s.a.c2.a$e */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    public final class e extends CancellableContinuationImpl3 {

        /* JADX INFO: renamed from: j */
        public final AbstractChannel5<?> f27736j;

        public e(AbstractChannel5<?> abstractChannel5) {
            this.f27736j = abstractChannel5;
        }

        @Override // p659s.p660a.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo11193a(Throwable th) {
            if (this.f27736j.mo11151n()) {
                Objects.requireNonNull(AbstractChannel.this);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            if (this.f27736j.mo11151n()) {
                Objects.requireNonNull(AbstractChannel.this);
            }
            return Unit.f27425a;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("RemoveReceiveOnCancel[");
            sbM833U.append(this.f27736j);
            sbM833U.append(']');
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: s.a.c2.a$f */
    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    public static final class f extends LockFreeLinkedList3.a {

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ AbstractChannel f27738d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(LockFreeLinkedList3 lockFreeLinkedList3, LockFreeLinkedList3 lockFreeLinkedList32, AbstractChannel abstractChannel) {
            super(lockFreeLinkedList32);
            this.f27738d = abstractChannel;
        }

        @Override // p659s.p660a.p661a.Atomic2
        /* JADX INFO: renamed from: c */
        public Object mo11144c(LockFreeLinkedList3 lockFreeLinkedList3) {
            if (this.f27738d.mo11204t()) {
                return null;
            }
            return LockFreeLinkedList2.f27683a;
        }
    }

    /* JADX INFO: renamed from: s.a.c2.a$g */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    @DebugMetadata(m10084c = "kotlinx.coroutines.channels.AbstractChannel", m10085f = "AbstractChannel.kt", m10086l = {624}, m10087m = "receiveOrClosed-ZYPwvRU")
    public static final class g extends ContinuationImpl3 {
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public g(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AbstractChannel.this.mo11200m(this);
        }
    }

    public AbstractChannel(Function1<? super E, Unit> function1) {
        super(function1);
    }

    @Override // p659s.p660a.p663c2.Channel6
    /* JADX INFO: renamed from: b */
    public final void mo11199b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException(getClass().getSimpleName() + " was cancelled");
        }
        mo11205u(mo11221j(cancellationException));
    }

    @Override // p659s.p660a.p663c2.Channel6
    public final Channel5<E> iterator() {
        return new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p659s.p660a.p663c2.Channel6
    /* JADX INFO: renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mo11200m(Continuation<? super Channel8<? extends E>> continuation) {
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
        Object objM11326u = gVar.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = gVar.label;
        if (i2 == 0) {
            Result3.throwOnFailure(objM11326u);
            Object objMo11206v = mo11206v();
            if (objMo11206v != AbstractChannel2.f27742d) {
                return objMo11206v instanceof AbstractChannel4 ? new Channel8.a(((AbstractChannel4) objMo11206v).f27763m) : objMo11206v;
            }
            gVar.L$0 = this;
            gVar.L$1 = objMo11206v;
            gVar.label = 1;
            CancellableContinuationImpl5 cancellableContinuationImpl5M4324o0 = C3404f.m4324o0(IntrinsicsJvm.intercepted(gVar));
            b bVar = this.f27747l == null ? new b(cancellableContinuationImpl5M4324o0, 2) : new c(cancellableContinuationImpl5M4324o0, 2, this.f27747l);
            while (true) {
                if (mo11202r(bVar)) {
                    cancellableContinuationImpl5M4324o0.mo10902f(new e(bVar));
                    break;
                }
                Object objMo11206v2 = mo11206v();
                if (objMo11206v2 instanceof AbstractChannel4) {
                    bVar.mo11211r((AbstractChannel4) objMo11206v2);
                    break;
                }
                if (objMo11206v2 != AbstractChannel2.f27742d) {
                    cancellableContinuationImpl5M4324o0.m11330y(bVar.f27732n != 2 ? objMo11206v2 : new Channel8(objMo11206v2), cancellableContinuationImpl5M4324o0.f27864l, bVar.mo11212q(objMo11206v2));
                }
            }
            objM11326u = cancellableContinuationImpl5M4324o0.m11326u();
            if (objM11326u == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                DebugProbes.probeCoroutineSuspended(gVar);
            }
            if (objM11326u == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(objM11326u);
        }
        return ((Channel8) objM11326u).f27770a;
    }

    @Override // p659s.p660a.p663c2.AbstractChannel3
    /* JADX INFO: renamed from: n */
    public AbstractChannel6<E> mo11201n() {
        AbstractChannel6<E> abstractChannel6Mo11201n = super.mo11201n();
        if (abstractChannel6Mo11201n != null) {
            boolean z2 = abstractChannel6Mo11201n instanceof AbstractChannel4;
        }
        return abstractChannel6Mo11201n;
    }

    /* JADX INFO: renamed from: r */
    public boolean mo11202r(AbstractChannel5<? super E> abstractChannel5) {
        int iM11160p;
        LockFreeLinkedList3 lockFreeLinkedList3M11157k;
        if (!mo11203s()) {
            LockFreeLinkedList3 lockFreeLinkedList3 = this.f27746k;
            f fVar = new f(abstractChannel5, abstractChannel5, this);
            do {
                LockFreeLinkedList3 lockFreeLinkedList3M11157k2 = lockFreeLinkedList3.m11157k();
                if (!(!(lockFreeLinkedList3M11157k2 instanceof AbstractChannel7))) {
                    break;
                }
                iM11160p = lockFreeLinkedList3M11157k2.m11160p(abstractChannel5, lockFreeLinkedList3, fVar);
                if (iM11160p == 1) {
                    return true;
                }
            } while (iM11160p != 2);
        } else {
            LockFreeLinkedList3 lockFreeLinkedList32 = this.f27746k;
            do {
                lockFreeLinkedList3M11157k = lockFreeLinkedList32.m11157k();
                if (!(!(lockFreeLinkedList3M11157k instanceof AbstractChannel7))) {
                }
            } while (!lockFreeLinkedList3M11157k.m11152e(abstractChannel5, lockFreeLinkedList32));
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: s */
    public abstract boolean mo11203s();

    /* JADX INFO: renamed from: t */
    public abstract boolean mo11204t();

    /* JADX INFO: renamed from: u */
    public void mo11205u(boolean z2) {
        AbstractChannel4<?> abstractChannel4M11216e = m11216e();
        if (abstractChannel4M11216e == null) {
            throw new IllegalStateException("Cannot happen".toString());
        }
        Object objM4247T0 = null;
        while (true) {
            LockFreeLinkedList3 lockFreeLinkedList3M11157k = abstractChannel4M11216e.m11157k();
            if (lockFreeLinkedList3M11157k instanceof LockFreeLinkedList) {
                break;
            }
            if (lockFreeLinkedList3M11157k.mo11151n()) {
                objM4247T0 = C3404f.m4247T0(objM4247T0, (AbstractChannel7) lockFreeLinkedList3M11157k);
            } else {
                Object objM11155i = lockFreeLinkedList3M11157k.m11155i();
                Objects.requireNonNull(objM11155i, "null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
                ((LockFreeLinkedList4) objM11155i).f27701a.m11153f(null);
            }
        }
        if (objM4247T0 == null) {
            return;
        }
        if (!(objM4247T0 instanceof ArrayList)) {
            ((AbstractChannel7) objM4247T0).mo11229s(abstractChannel4M11216e);
            return;
        }
        ArrayList arrayList = (ArrayList) objM4247T0;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                ((AbstractChannel7) arrayList.get(size)).mo11229s(abstractChannel4M11216e);
            }
        }
    }

    /* JADX INFO: renamed from: v */
    public Object mo11206v() {
        while (true) {
            AbstractChannel7 abstractChannel7M11226q = m11226q();
            if (abstractChannel7M11226q == null) {
                return AbstractChannel2.f27742d;
            }
            if (abstractChannel7M11226q.mo11230t(null) != null) {
                abstractChannel7M11226q.mo11227q();
                return abstractChannel7M11226q.mo11228r();
            }
            abstractChannel7M11226q.mo11241u();
        }
    }
}
