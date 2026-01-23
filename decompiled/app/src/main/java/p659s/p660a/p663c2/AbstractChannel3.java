package p659s.p660a.p663c2;

import com.discord.widgets.chat.input.MentionUtils;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.OnUndeliveredElement;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Exceptions;
import p507d0.Result2;
import p507d0.Result3;
import p507d0.p584w.p585h.IntrinsicsJvm;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.TypeIntrinsics;
import p659s.p660a.CancellableContinuation3;
import p659s.p660a.CancellableContinuationImpl5;
import p659s.p660a.CancellableContinuationImpl6;
import p659s.p660a.p661a.LockFreeLinkedList;
import p659s.p660a.p661a.LockFreeLinkedList2;
import p659s.p660a.p661a.LockFreeLinkedList3;
import p659s.p660a.p661a.LockFreeLinkedList4;
import p659s.p660a.p661a.StackTraceRecovery;
import p659s.p660a.p661a.Symbol3;

/* JADX INFO: renamed from: s.a.c2.c, reason: use source file name */
/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractChannel3<E> implements Channel7<E> {

    /* JADX INFO: renamed from: j */
    public static final AtomicReferenceFieldUpdater f27745j = AtomicReferenceFieldUpdater.newUpdater(AbstractChannel3.class, Object.class, "onCloseHandler");

    /* JADX INFO: renamed from: l */
    public final Function1<E, Unit> f27747l;

    /* JADX INFO: renamed from: k */
    public final LockFreeLinkedList f27746k = new LockFreeLinkedList();
    public volatile Object onCloseHandler = null;

    /* JADX INFO: renamed from: s.a.c2.c$a */
    /* JADX INFO: compiled from: AbstractChannel.kt */
    public static final class a<E> extends AbstractChannel7 {

        /* JADX INFO: renamed from: m */
        public final E f27748m;

        public a(E e) {
            this.f27748m = e;
        }

        @Override // p659s.p660a.p663c2.AbstractChannel7
        /* JADX INFO: renamed from: q */
        public void mo11227q() {
        }

        @Override // p659s.p660a.p663c2.AbstractChannel7
        /* JADX INFO: renamed from: r */
        public Object mo11228r() {
            return this.f27748m;
        }

        @Override // p659s.p660a.p663c2.AbstractChannel7
        /* JADX INFO: renamed from: s */
        public void mo11229s(AbstractChannel4<?> abstractChannel4) {
        }

        @Override // p659s.p660a.p663c2.AbstractChannel7
        /* JADX INFO: renamed from: t */
        public Symbol3 mo11230t(LockFreeLinkedList3.b bVar) {
            return CancellableContinuationImpl6.f27874a;
        }

        @Override // p659s.p660a.p661a.LockFreeLinkedList3
        public String toString() {
            StringBuilder sbM833U = outline.m833U("SendBuffered@");
            sbM833U.append(C3404f.m4312l0(this));
            sbM833U.append('(');
            sbM833U.append(this.f27748m);
            sbM833U.append(')');
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: s.a.c2.c$b */
    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    public static final class b extends LockFreeLinkedList3.a {

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ AbstractChannel3 f27749d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LockFreeLinkedList3 lockFreeLinkedList3, LockFreeLinkedList3 lockFreeLinkedList32, AbstractChannel3 abstractChannel3) {
            super(lockFreeLinkedList32);
            this.f27749d = abstractChannel3;
        }

        @Override // p659s.p660a.p661a.Atomic2
        /* JADX INFO: renamed from: c */
        public Object mo11144c(LockFreeLinkedList3 lockFreeLinkedList3) {
            if (this.f27749d.mo11220i()) {
                return null;
            }
            return LockFreeLinkedList2.f27683a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractChannel3(Function1<? super E, Unit> function1) {
        this.f27747l = function1;
    }

    /* JADX INFO: renamed from: a */
    public static final void m11213a(AbstractChannel3 abstractChannel3, Continuation continuation, Object obj, AbstractChannel4 abstractChannel4) {
        OnUndeliveredElement onUndeliveredElementM4331q;
        abstractChannel3.m11217f(abstractChannel4);
        Throwable thM11234w = abstractChannel4.m11234w();
        Function1<E, Unit> function1 = abstractChannel3.f27747l;
        if (function1 == null || (onUndeliveredElementM4331q = C3404f.m4331q(function1, obj, null, 2)) == null) {
            Result2.a aVar = Result2.f25169j;
            ((CancellableContinuationImpl5) continuation).resumeWith(Result2.m11474constructorimpl(Result3.createFailure(thM11234w)));
        } else {
            Exceptions.addSuppressed(onUndeliveredElementM4331q, thM11234w);
            Result2.a aVar2 = Result2.f25169j;
            ((CancellableContinuationImpl5) continuation).resumeWith(Result2.m11474constructorimpl(Result3.createFailure(onUndeliveredElementM4331q)));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        return p659s.p660a.p663c2.AbstractChannel2.f27743e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        return null;
     */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo11214c(AbstractChannel7 abstractChannel7) {
        LockFreeLinkedList3 lockFreeLinkedList3M11157k;
        if (!mo11219h()) {
            LockFreeLinkedList3 lockFreeLinkedList3 = this.f27746k;
            b bVar = new b(abstractChannel7, abstractChannel7, this);
            while (true) {
                LockFreeLinkedList3 lockFreeLinkedList3M11157k2 = lockFreeLinkedList3.m11157k();
                if (!(lockFreeLinkedList3M11157k2 instanceof AbstractChannel6)) {
                    int iM11160p = lockFreeLinkedList3M11157k2.m11160p(abstractChannel7, lockFreeLinkedList3, bVar);
                    boolean z2 = true;
                    if (iM11160p != 1) {
                        if (iM11160p == 2) {
                            z2 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    return lockFreeLinkedList3M11157k2;
                }
            }
        } else {
            LockFreeLinkedList3 lockFreeLinkedList32 = this.f27746k;
            do {
                lockFreeLinkedList3M11157k = lockFreeLinkedList32.m11157k();
                if (lockFreeLinkedList3M11157k instanceof AbstractChannel6) {
                    return lockFreeLinkedList3M11157k;
                }
            } while (!lockFreeLinkedList3M11157k.m11152e(abstractChannel7, lockFreeLinkedList32));
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    public String mo11215d() {
        return "";
    }

    /* JADX INFO: renamed from: e */
    public final AbstractChannel4<?> m11216e() {
        LockFreeLinkedList3 lockFreeLinkedList3M11157k = this.f27746k.m11157k();
        if (!(lockFreeLinkedList3M11157k instanceof AbstractChannel4)) {
            lockFreeLinkedList3M11157k = null;
        }
        AbstractChannel4<?> abstractChannel4 = (AbstractChannel4) lockFreeLinkedList3M11157k;
        if (abstractChannel4 == null) {
            return null;
        }
        m11217f(abstractChannel4);
        return abstractChannel4;
    }

    /* JADX INFO: renamed from: f */
    public final void m11217f(AbstractChannel4<?> abstractChannel4) {
        Object objM4247T0 = null;
        while (true) {
            LockFreeLinkedList3 lockFreeLinkedList3M11157k = abstractChannel4.m11157k();
            if (!(lockFreeLinkedList3M11157k instanceof AbstractChannel5)) {
                lockFreeLinkedList3M11157k = null;
            }
            AbstractChannel5 abstractChannel5 = (AbstractChannel5) lockFreeLinkedList3M11157k;
            if (abstractChannel5 == null) {
                break;
            }
            if (abstractChannel5.mo11151n()) {
                objM4247T0 = C3404f.m4247T0(objM4247T0, abstractChannel5);
            } else {
                Object objM11155i = abstractChannel5.m11155i();
                Objects.requireNonNull(objM11155i, "null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
                ((LockFreeLinkedList4) objM11155i).f27701a.m11153f(null);
            }
        }
        if (objM4247T0 == null) {
            return;
        }
        if (!(objM4247T0 instanceof ArrayList)) {
            ((AbstractChannel5) objM4247T0).mo11211r(abstractChannel4);
            return;
        }
        ArrayList arrayList = (ArrayList) objM4247T0;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                ((AbstractChannel5) arrayList.get(size)).mo11211r(abstractChannel4);
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public final Throwable m11218g(E e, AbstractChannel4<?> abstractChannel4) {
        OnUndeliveredElement onUndeliveredElementM4331q;
        m11217f(abstractChannel4);
        Function1<E, Unit> function1 = this.f27747l;
        if (function1 == null || (onUndeliveredElementM4331q = C3404f.m4331q(function1, e, null, 2)) == null) {
            return abstractChannel4.m11234w();
        }
        Exceptions.addSuppressed(onUndeliveredElementM4331q, abstractChannel4.m11234w());
        throw onUndeliveredElementM4331q;
    }

    /* JADX INFO: renamed from: h */
    public abstract boolean mo11219h();

    /* JADX INFO: renamed from: i */
    public abstract boolean mo11220i();

    @Override // p659s.p660a.p663c2.Channel7
    /* JADX INFO: renamed from: j */
    public boolean mo11221j(Throwable th) {
        boolean z2;
        Object obj;
        Symbol3 symbol3;
        AbstractChannel4<?> abstractChannel4 = new AbstractChannel4<>(th);
        LockFreeLinkedList3 lockFreeLinkedList3 = this.f27746k;
        while (true) {
            LockFreeLinkedList3 lockFreeLinkedList3M11157k = lockFreeLinkedList3.m11157k();
            if (!(!(lockFreeLinkedList3M11157k instanceof AbstractChannel4))) {
                z2 = false;
                break;
            }
            if (lockFreeLinkedList3M11157k.m11152e(abstractChannel4, lockFreeLinkedList3)) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            abstractChannel4 = (AbstractChannel4) this.f27746k.m11157k();
        }
        m11217f(abstractChannel4);
        if (z2 && (obj = this.onCloseHandler) != null && obj != (symbol3 = AbstractChannel2.f27744f) && f27745j.compareAndSet(this, obj, symbol3)) {
            ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1)).invoke(th);
        }
        return z2;
    }

    /* JADX INFO: renamed from: k */
    public Object mo11222k(E e) {
        AbstractChannel6<E> abstractChannel6Mo11201n;
        do {
            abstractChannel6Mo11201n = mo11201n();
            if (abstractChannel6Mo11201n == null) {
                return AbstractChannel2.f27741c;
            }
        } while (abstractChannel6Mo11201n.mo11210d(e, null) == null);
        abstractChannel6Mo11201n.mo11209c(e);
        return abstractChannel6Mo11201n.mo11232b();
    }

    @Override // p659s.p660a.p663c2.Channel7
    /* JADX INFO: renamed from: l */
    public void mo11223l(Function1<? super Throwable, Unit> function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f27745j;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj != AbstractChannel2.f27744f) {
                throw new IllegalStateException(outline.m881v("Another handler was already registered: ", obj));
            }
            throw new IllegalStateException("Another handler was already registered and successfully invoked");
        }
        AbstractChannel4<?> abstractChannel4M11216e = m11216e();
        if (abstractChannel4M11216e == null || !atomicReferenceFieldUpdater.compareAndSet(this, function1, AbstractChannel2.f27744f)) {
            return;
        }
        function1.invoke(abstractChannel4M11216e.f27763m);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [s.a.a.k] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX INFO: renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AbstractChannel6<E> mo11201n() {
        ?? r1;
        LockFreeLinkedList3 lockFreeLinkedList3M11159o;
        LockFreeLinkedList lockFreeLinkedList = this.f27746k;
        while (true) {
            Object objM11155i = lockFreeLinkedList.m11155i();
            Objects.requireNonNull(objM11155i, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            r1 = (LockFreeLinkedList3) objM11155i;
            if (r1 == lockFreeLinkedList || !(r1 instanceof AbstractChannel6)) {
                break;
            }
            if (((((AbstractChannel6) r1) instanceof AbstractChannel4) && !r1.mo11150m()) || (lockFreeLinkedList3M11159o = r1.m11159o()) == null) {
                break;
            }
            lockFreeLinkedList3M11159o.m11158l();
        }
        return (AbstractChannel6) r1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x008e, code lost:
    
        r4 = r0.m11326u();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0096, code lost:
    
        if (r4 != p507d0.p584w.p585h.Intrinsics2.getCOROUTINE_SUSPENDED()) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0098, code lost:
    
        p507d0.p584w.p586i.p587a.DebugProbes.probeCoroutineSuspended(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009f, code lost:
    
        if (r4 != p507d0.p584w.p585h.Intrinsics2.getCOROUTINE_SUSPENDED()) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a1, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a4, code lost:
    
        return kotlin.Unit.f27425a;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0074 A[SYNTHETIC] */
    @Override // p659s.p660a.p663c2.Channel7
    /* JADX INFO: renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mo11224o(E e, Continuation<? super Unit> continuation) {
        Object objMo11222k;
        if (mo11222k(e) == AbstractChannel2.f27740b) {
            return Unit.f27425a;
        }
        CancellableContinuationImpl5 cancellableContinuationImpl5M4324o0 = C3404f.m4324o0(IntrinsicsJvm.intercepted(continuation));
        while (true) {
            if (!(this.f27746k.m11156j() instanceof AbstractChannel6) && mo11220i()) {
                AbstractChannel7 abstractChannel8 = this.f27747l == null ? new AbstractChannel8(e, cancellableContinuationImpl5M4324o0) : new AbstractChannel9(e, cancellableContinuationImpl5M4324o0, this.f27747l);
                Object objMo11214c = mo11214c(abstractChannel8);
                if (objMo11214c == null) {
                    cancellableContinuationImpl5M4324o0.mo10902f(new CancellableContinuation3(abstractChannel8));
                    break;
                }
                if (objMo11214c instanceof AbstractChannel4) {
                    m11213a(this, cancellableContinuationImpl5M4324o0, e, (AbstractChannel4) objMo11214c);
                    break;
                }
                if (objMo11214c != AbstractChannel2.f27743e && !(objMo11214c instanceof AbstractChannel5)) {
                    throw new IllegalStateException(outline.m881v("enqueueSend returned ", objMo11214c).toString());
                }
                objMo11222k = mo11222k(e);
                if (objMo11222k != AbstractChannel2.f27740b) {
                }
            } else {
                objMo11222k = mo11222k(e);
                if (objMo11222k != AbstractChannel2.f27740b) {
                    Unit unit = Unit.f27425a;
                    Result2.a aVar = Result2.f25169j;
                    cancellableContinuationImpl5M4324o0.resumeWith(Result2.m11474constructorimpl(unit));
                    break;
                }
                if (objMo11222k != AbstractChannel2.f27741c) {
                    if (!(objMo11222k instanceof AbstractChannel4)) {
                        throw new IllegalStateException(outline.m881v("offerInternal returned ", objMo11222k).toString());
                    }
                    m11213a(this, cancellableContinuationImpl5M4324o0, e, (AbstractChannel4) objMo11222k);
                }
            }
        }
    }

    @Override // p659s.p660a.p663c2.Channel7
    public final boolean offer(E e) throws Throwable {
        Object objMo11222k = mo11222k(e);
        if (objMo11222k == AbstractChannel2.f27740b) {
            return true;
        }
        if (objMo11222k != AbstractChannel2.f27741c) {
            if (!(objMo11222k instanceof AbstractChannel4)) {
                throw new IllegalStateException(outline.m881v("offerInternal returned ", objMo11222k).toString());
            }
            Throwable thM11218g = m11218g(e, (AbstractChannel4) objMo11222k);
            String str = StackTraceRecovery.f27703a;
            throw thM11218g;
        }
        AbstractChannel4<?> abstractChannel4M11216e = m11216e();
        if (abstractChannel4M11216e == null) {
            return false;
        }
        Throwable thM11218g2 = m11218g(e, abstractChannel4M11216e);
        String str2 = StackTraceRecovery.f27703a;
        throw thM11218g2;
    }

    @Override // p659s.p660a.p663c2.Channel7
    /* JADX INFO: renamed from: p */
    public final boolean mo11225p() {
        return m11216e() != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        r1 = null;
     */
    /* JADX INFO: renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AbstractChannel7 m11226q() {
        LockFreeLinkedList3 lockFreeLinkedList3;
        LockFreeLinkedList3 lockFreeLinkedList3M11159o;
        LockFreeLinkedList lockFreeLinkedList = this.f27746k;
        while (true) {
            Object objM11155i = lockFreeLinkedList.m11155i();
            Objects.requireNonNull(objM11155i, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            lockFreeLinkedList3 = (LockFreeLinkedList3) objM11155i;
            if (lockFreeLinkedList3 == lockFreeLinkedList || !(lockFreeLinkedList3 instanceof AbstractChannel7)) {
                break;
            }
            if (((((AbstractChannel7) lockFreeLinkedList3) instanceof AbstractChannel4) && !lockFreeLinkedList3.mo11150m()) || (lockFreeLinkedList3M11159o = lockFreeLinkedList3.m11159o()) == null) {
                break;
            }
            lockFreeLinkedList3M11159o.m11158l();
        }
        return (AbstractChannel7) lockFreeLinkedList3;
    }

    public String toString() {
        String string;
        String string2;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(MentionUtils.MENTIONS_CHAR);
        sb.append(C3404f.m4312l0(this));
        sb.append('{');
        LockFreeLinkedList3 lockFreeLinkedList3M11156j = this.f27746k.m11156j();
        if (lockFreeLinkedList3M11156j == this.f27746k) {
            string2 = "EmptyQueue";
        } else {
            if (lockFreeLinkedList3M11156j instanceof AbstractChannel4) {
                string = lockFreeLinkedList3M11156j.toString();
            } else if (lockFreeLinkedList3M11156j instanceof AbstractChannel5) {
                string = "ReceiveQueued";
            } else if (lockFreeLinkedList3M11156j instanceof AbstractChannel7) {
                string = "SendQueued";
            } else {
                string = "UNEXPECTED:" + lockFreeLinkedList3M11156j;
            }
            LockFreeLinkedList3 lockFreeLinkedList3M11157k = this.f27746k.m11157k();
            if (lockFreeLinkedList3M11157k != lockFreeLinkedList3M11156j) {
                StringBuilder sbM836X = outline.m836X(string, ",queueSize=");
                Object objM11155i = this.f27746k.m11155i();
                Objects.requireNonNull(objM11155i, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                int i = 0;
                for (LockFreeLinkedList3 lockFreeLinkedList3M11156j2 = (LockFreeLinkedList3) objM11155i; !Intrinsics3.areEqual(lockFreeLinkedList3M11156j2, r2); lockFreeLinkedList3M11156j2 = lockFreeLinkedList3M11156j2.m11156j()) {
                    i++;
                }
                sbM836X.append(i);
                string2 = sbM836X.toString();
                if (lockFreeLinkedList3M11157k instanceof AbstractChannel4) {
                    string2 = string2 + ",closedForSend=" + lockFreeLinkedList3M11157k;
                }
            } else {
                string2 = string;
            }
        }
        sb.append(string2);
        sb.append('}');
        sb.append(mo11215d());
        return sb.toString();
    }
}
