package p659s.p660a.p663c2;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.OnUndeliveredElement;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p580t._ArraysJvm;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.p661a.Symbol3;

/* compiled from: ArrayChannel.kt */
/* renamed from: s.a.c2.d, reason: use source file name */
/* loaded from: classes3.dex */
public class ArrayChannel<E> extends AbstractChannel<E> {

    /* renamed from: m */
    public final ReentrantLock f27750m;

    /* renamed from: n */
    public Object[] f27751n;

    /* renamed from: o */
    public int f27752o;

    /* renamed from: p */
    public final int f27753p;

    /* renamed from: q */
    public final BufferOverflow f27754q;
    public volatile int size;

    public ArrayChannel(int i, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        super(function1);
        this.f27753p = i;
        this.f27754q = bufferOverflow;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(outline.m873r("ArrayChannel capacity must be at least 1, but ", i, " was specified").toString());
        }
        this.f27750m = new ReentrantLock();
        Object[] objArr = new Object[Math.min(i, 8)];
        _ArraysJvm.fill$default(objArr, AbstractChannel2.f27739a, 0, 0, 6, null);
        this.f27751n = objArr;
        this.size = 0;
    }

    @Override // p659s.p660a.p663c2.AbstractChannel3
    /* renamed from: c */
    public Object mo11214c(AbstractChannel7 abstractChannel7) {
        ReentrantLock reentrantLock = this.f27750m;
        reentrantLock.lock();
        try {
            return super.mo11214c(abstractChannel7);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // p659s.p660a.p663c2.AbstractChannel3
    /* renamed from: d */
    public String mo11215d() {
        StringBuilder sbM833U = outline.m833U("(buffer:capacity=");
        sbM833U.append(this.f27753p);
        sbM833U.append(",size=");
        return outline.m813A(sbM833U, this.size, ')');
    }

    @Override // p659s.p660a.p663c2.AbstractChannel3
    /* renamed from: h */
    public final boolean mo11219h() {
        return false;
    }

    @Override // p659s.p660a.p663c2.AbstractChannel3
    /* renamed from: i */
    public final boolean mo11220i() {
        return this.size == this.f27753p && this.f27754q == BufferOverflow.SUSPEND;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0038 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003c  */
    @Override // p659s.p660a.p663c2.AbstractChannel3
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo11222k(E e) {
        Symbol3 symbol3;
        AbstractChannel6<E> abstractChannel6Mo11201n;
        ReentrantLock reentrantLock = this.f27750m;
        reentrantLock.lock();
        try {
            int i = this.size;
            AbstractChannel4<?> abstractChannel4M11216e = m11216e();
            if (abstractChannel4M11216e != null) {
                return abstractChannel4M11216e;
            }
            if (i >= this.f27753p) {
                int iOrdinal = this.f27754q.ordinal();
                if (iOrdinal == 0) {
                    symbol3 = AbstractChannel2.f27741c;
                } else if (iOrdinal != 1) {
                    if (iOrdinal != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    symbol3 = AbstractChannel2.f27740b;
                }
                if (symbol3 == null) {
                    return symbol3;
                }
                if (i == 0) {
                    do {
                        abstractChannel6Mo11201n = mo11201n();
                        if (abstractChannel6Mo11201n != null) {
                            if (abstractChannel6Mo11201n instanceof AbstractChannel4) {
                                this.size = i;
                                Intrinsics3.checkNotNull(abstractChannel6Mo11201n);
                                return abstractChannel6Mo11201n;
                            }
                            Intrinsics3.checkNotNull(abstractChannel6Mo11201n);
                        }
                    } while (abstractChannel6Mo11201n.mo11210d(e, null) == null);
                    this.size = i;
                    reentrantLock.unlock();
                    Intrinsics3.checkNotNull(abstractChannel6Mo11201n);
                    abstractChannel6Mo11201n.mo11209c(e);
                    Intrinsics3.checkNotNull(abstractChannel6Mo11201n);
                    return abstractChannel6Mo11201n.mo11232b();
                }
                m11231w(i, e);
                return AbstractChannel2.f27740b;
            }
            this.size = i + 1;
            symbol3 = null;
            if (symbol3 == null) {
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // p659s.p660a.p663c2.AbstractChannel
    /* renamed from: r */
    public boolean mo11202r(AbstractChannel5<? super E> abstractChannel5) {
        ReentrantLock reentrantLock = this.f27750m;
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
        return this.size == 0;
    }

    @Override // p659s.p660a.p663c2.AbstractChannel
    /* renamed from: u */
    public void mo11205u(boolean z2) {
        Function1<E, Unit> function1 = this.f27747l;
        ReentrantLock reentrantLock = this.f27750m;
        reentrantLock.lock();
        try {
            int i = this.size;
            OnUndeliveredElement onUndeliveredElementM4327p = null;
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = this.f27751n[this.f27752o];
                if (function1 != null && obj != AbstractChannel2.f27739a) {
                    onUndeliveredElementM4327p = C3404f.m4327p(function1, obj, onUndeliveredElementM4327p);
                }
                Object[] objArr = this.f27751n;
                int i3 = this.f27752o;
                objArr[i3] = AbstractChannel2.f27739a;
                this.f27752o = (i3 + 1) % objArr.length;
            }
            this.size = 0;
            reentrantLock.unlock();
            super.mo11205u(z2);
            if (onUndeliveredElementM4327p != null) {
                throw onUndeliveredElementM4327p;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // p659s.p660a.p663c2.AbstractChannel
    /* renamed from: v */
    public Object mo11206v() {
        ReentrantLock reentrantLock = this.f27750m;
        reentrantLock.lock();
        try {
            int i = this.size;
            if (i == 0) {
                Object objM11216e = m11216e();
                if (objM11216e == null) {
                    objM11216e = AbstractChannel2.f27742d;
                }
                return objM11216e;
            }
            Object[] objArr = this.f27751n;
            int i2 = this.f27752o;
            Object obj = objArr[i2];
            AbstractChannel7 abstractChannel7 = null;
            objArr[i2] = null;
            this.size = i - 1;
            Object objMo11228r = AbstractChannel2.f27742d;
            boolean z2 = false;
            if (i == this.f27753p) {
                AbstractChannel7 abstractChannel72 = null;
                while (true) {
                    AbstractChannel7 abstractChannel7M11226q = m11226q();
                    if (abstractChannel7M11226q == null) {
                        abstractChannel7 = abstractChannel72;
                        break;
                    }
                    Intrinsics3.checkNotNull(abstractChannel7M11226q);
                    if (abstractChannel7M11226q.mo11230t(null) != null) {
                        Intrinsics3.checkNotNull(abstractChannel7M11226q);
                        objMo11228r = abstractChannel7M11226q.mo11228r();
                        abstractChannel7 = abstractChannel7M11226q;
                        z2 = true;
                        break;
                    }
                    Intrinsics3.checkNotNull(abstractChannel7M11226q);
                    abstractChannel7M11226q.mo11241u();
                    abstractChannel72 = abstractChannel7M11226q;
                }
            }
            if (objMo11228r != AbstractChannel2.f27742d && !(objMo11228r instanceof AbstractChannel4)) {
                this.size = i;
                Object[] objArr2 = this.f27751n;
                objArr2[(this.f27752o + i) % objArr2.length] = objMo11228r;
            }
            this.f27752o = (this.f27752o + 1) % this.f27751n.length;
            if (z2) {
                Intrinsics3.checkNotNull(abstractChannel7);
                abstractChannel7.mo11227q();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: w */
    public final void m11231w(int i, E e) {
        int i2 = this.f27753p;
        if (i >= i2) {
            Object[] objArr = this.f27751n;
            int i3 = this.f27752o;
            objArr[i3 % objArr.length] = null;
            objArr[(i + i3) % objArr.length] = e;
            this.f27752o = (i3 + 1) % objArr.length;
            return;
        }
        Object[] objArr2 = this.f27751n;
        if (i >= objArr2.length) {
            int iMin = Math.min(objArr2.length * 2, i2);
            Object[] objArr3 = new Object[iMin];
            for (int i4 = 0; i4 < i; i4++) {
                Object[] objArr4 = this.f27751n;
                objArr3[i4] = objArr4[(this.f27752o + i4) % objArr4.length];
            }
            _ArraysJvm.fill((Symbol3[]) objArr3, AbstractChannel2.f27739a, i, iMin);
            this.f27751n = objArr3;
            this.f27752o = 0;
        }
        Object[] objArr5 = this.f27751n;
        objArr5[(this.f27752o + i) % objArr5.length] = e;
    }
}
