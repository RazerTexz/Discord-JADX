package p659s.p660a.p663c2;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.OnUndeliveredElement;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.p661a.Symbol3;

/* compiled from: ConflatedChannel.kt */
/* renamed from: s.a.c2.j, reason: use source file name */
/* loaded from: classes3.dex */
public class ConflatedChannel<E> extends AbstractChannel<E> {

    /* renamed from: m */
    public final ReentrantLock f27764m;

    /* renamed from: n */
    public Object f27765n;

    public ConflatedChannel(Function1<? super E, Unit> function1) {
        super(function1);
        this.f27764m = new ReentrantLock();
        this.f27765n = AbstractChannel2.f27739a;
    }

    @Override // p659s.p660a.p663c2.AbstractChannel3
    /* renamed from: d */
    public String mo11215d() {
        StringBuilder sbM833U = outline.m833U("(value=");
        sbM833U.append(this.f27765n);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    @Override // p659s.p660a.p663c2.AbstractChannel3
    /* renamed from: h */
    public final boolean mo11219h() {
        return false;
    }

    @Override // p659s.p660a.p663c2.AbstractChannel3
    /* renamed from: i */
    public final boolean mo11220i() {
        return false;
    }

    @Override // p659s.p660a.p663c2.AbstractChannel3
    /* renamed from: k */
    public Object mo11222k(E e) {
        AbstractChannel6<E> abstractChannel6Mo11201n;
        ReentrantLock reentrantLock = this.f27764m;
        reentrantLock.lock();
        try {
            AbstractChannel4<?> abstractChannel4M11216e = m11216e();
            if (abstractChannel4M11216e != null) {
                return abstractChannel4M11216e;
            }
            if (this.f27765n == AbstractChannel2.f27739a) {
                do {
                    abstractChannel6Mo11201n = mo11201n();
                    if (abstractChannel6Mo11201n != null) {
                        if (abstractChannel6Mo11201n instanceof AbstractChannel4) {
                            Intrinsics3.checkNotNull(abstractChannel6Mo11201n);
                            return abstractChannel6Mo11201n;
                        }
                        Intrinsics3.checkNotNull(abstractChannel6Mo11201n);
                    }
                } while (abstractChannel6Mo11201n.mo11210d(e, null) == null);
                reentrantLock.unlock();
                Intrinsics3.checkNotNull(abstractChannel6Mo11201n);
                abstractChannel6Mo11201n.mo11209c(e);
                Intrinsics3.checkNotNull(abstractChannel6Mo11201n);
                return abstractChannel6Mo11201n.mo11232b();
            }
            OnUndeliveredElement onUndeliveredElementM11235w = m11235w(e);
            if (onUndeliveredElementM11235w == null) {
                return AbstractChannel2.f27740b;
            }
            throw onUndeliveredElementM11235w;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // p659s.p660a.p663c2.AbstractChannel
    /* renamed from: r */
    public boolean mo11202r(AbstractChannel5<? super E> abstractChannel5) {
        ReentrantLock reentrantLock = this.f27764m;
        reentrantLock.lock();
        try {
            return super.mo11202r(abstractChannel5);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // p659s.p660a.p663c2.AbstractChannel
    /* renamed from: s */
    public final boolean mo11203s() {
        return false;
    }

    @Override // p659s.p660a.p663c2.AbstractChannel
    /* renamed from: t */
    public final boolean mo11204t() {
        return this.f27765n == AbstractChannel2.f27739a;
    }

    @Override // p659s.p660a.p663c2.AbstractChannel
    /* renamed from: u */
    public void mo11205u(boolean z2) {
        ReentrantLock reentrantLock = this.f27764m;
        reentrantLock.lock();
        try {
            OnUndeliveredElement onUndeliveredElementM11235w = m11235w(AbstractChannel2.f27739a);
            reentrantLock.unlock();
            super.mo11205u(z2);
            if (onUndeliveredElementM11235w != null) {
                throw onUndeliveredElementM11235w;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // p659s.p660a.p663c2.AbstractChannel
    /* renamed from: v */
    public Object mo11206v() {
        ReentrantLock reentrantLock = this.f27764m;
        reentrantLock.lock();
        try {
            Object obj = this.f27765n;
            Symbol3 symbol3 = AbstractChannel2.f27739a;
            if (obj != symbol3) {
                this.f27765n = symbol3;
                return obj;
            }
            Object objM11216e = m11216e();
            if (objM11216e == null) {
                objM11216e = AbstractChannel2.f27742d;
            }
            return objM11216e;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: w */
    public final OnUndeliveredElement m11235w(Object obj) {
        Function1<E, Unit> function1;
        Object obj2 = this.f27765n;
        OnUndeliveredElement onUndeliveredElementM4331q = null;
        if (obj2 != AbstractChannel2.f27739a && (function1 = this.f27747l) != null) {
            onUndeliveredElementM4331q = C3404f.m4331q(function1, obj2, null, 2);
        }
        this.f27765n = obj;
        return onUndeliveredElementM4331q;
    }
}
