package com.facebook.imagepipeline.memory;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Objects;
import java.util.Set;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p109f.p115d.p119d.Throwables;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p115d.p122g.MemoryTrimmableRegistry;
import p007b.p109f.p115d.p122g.Pool2;
import p007b.p109f.p161j.p177l.Bucket2;
import p007b.p109f.p161j.p177l.PoolParams;
import p007b.p109f.p161j.p177l.PoolStatsTracker;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BasePool<V> implements Pool2<V> {

    /* JADX INFO: renamed from: a */
    public final Class<?> f19548a = getClass();

    /* JADX INFO: renamed from: b */
    public final MemoryTrimmableRegistry f19549b;

    /* JADX INFO: renamed from: c */
    public final PoolParams f19550c;

    /* JADX INFO: renamed from: d */
    @VisibleForTesting
    public final SparseArray<Bucket2<V>> f19551d;

    /* JADX INFO: renamed from: e */
    @VisibleForTesting
    public final Set<V> f19552e;

    /* JADX INFO: renamed from: f */
    public boolean f19553f;

    /* JADX INFO: renamed from: g */
    @VisibleForTesting
    public final C10661a f19554g;

    /* JADX INFO: renamed from: h */
    @VisibleForTesting
    public final C10661a f19555h;

    /* JADX INFO: renamed from: i */
    public final PoolStatsTracker f19556i;

    /* JADX INFO: renamed from: j */
    public boolean f19557j;

    public static class InvalidSizeException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        public InvalidSizeException(Object obj) {
            StringBuilder sbM833U = outline.m833U("Invalid size: ");
            sbM833U.append(obj.toString());
            super(sbM833U.toString());
        }
    }

    public static class InvalidValueException extends RuntimeException {
    }

    public static class PoolSizeViolationException extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        public PoolSizeViolationException(int i, int i2, int i3, int i4) {
            StringBuilder sbM835W = outline.m835W("Pool hard cap violation? Hard cap = ", i, " Used size = ", i2, " Free size = ");
            sbM835W.append(i3);
            sbM835W.append(" Request size = ");
            sbM835W.append(i4);
            super(sbM835W.toString());
        }
    }

    public static class SizeTooLargeException extends InvalidSizeException {
    }

    /* JADX INFO: renamed from: com.facebook.imagepipeline.memory.BasePool$a */
    @VisibleForTesting
    public static class C10661a {

        /* JADX INFO: renamed from: a */
        public int f19558a;

        /* JADX INFO: renamed from: b */
        public int f19559b;

        /* JADX INFO: renamed from: a */
        public void m8704a(int i) {
            int i2;
            int i3 = this.f19559b;
            if (i3 < i || (i2 = this.f19558a) <= 0) {
                FLog.m988p("com.facebook.imagepipeline.memory.BasePool.Counter", "Unexpected decrement of %d. Current numBytes = %d, count = %d", Integer.valueOf(i), Integer.valueOf(this.f19559b), Integer.valueOf(this.f19558a));
            } else {
                this.f19558a = i2 - 1;
                this.f19559b = i3 - i;
            }
        }

        /* JADX INFO: renamed from: b */
        public void m8705b(int i) {
            this.f19558a++;
            this.f19559b += i;
        }
    }

    public BasePool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        Objects.requireNonNull(memoryTrimmableRegistry);
        this.f19549b = memoryTrimmableRegistry;
        Objects.requireNonNull(poolParams);
        this.f19550c = poolParams;
        Objects.requireNonNull(poolStatsTracker);
        this.f19556i = poolStatsTracker;
        SparseArray<Bucket2<V>> sparseArray = new SparseArray<>();
        this.f19551d = sparseArray;
        SparseIntArray sparseIntArray = new SparseIntArray(0);
        synchronized (this) {
            sparseArray.clear();
            SparseIntArray sparseIntArray2 = poolParams.f3978c;
            if (sparseIntArray2 != null) {
                for (int i = 0; i < sparseIntArray2.size(); i++) {
                    int iKeyAt = sparseIntArray2.keyAt(i);
                    int iValueAt = sparseIntArray2.valueAt(i);
                    int i2 = sparseIntArray.get(iKeyAt, 0);
                    SparseArray<Bucket2<V>> sparseArray2 = this.f19551d;
                    int iMo1386k = mo1386k(iKeyAt);
                    Objects.requireNonNull(this.f19550c);
                    sparseArray2.put(iKeyAt, new Bucket2<>(iMo1386k, iValueAt, i2, false));
                }
                this.f19553f = false;
            } else {
                this.f19553f = true;
            }
        }
        this.f19552e = Collections.newSetFromMap(new IdentityHashMap());
        this.f19555h = new C10661a();
        this.f19554g = new C10661a();
    }

    /* JADX INFO: renamed from: e */
    public abstract V mo1382e(int i);

    @VisibleForTesting
    /* JADX INFO: renamed from: f */
    public synchronized boolean m8697f(int i) {
        if (this.f19557j) {
            return true;
        }
        PoolParams poolParams = this.f19550c;
        int i2 = poolParams.f3976a;
        int i3 = this.f19554g.f19559b;
        if (i > i2 - i3) {
            this.f19556i.mo1404f();
            return false;
        }
        int i4 = poolParams.f3977b;
        if (i > i4 - (i3 + this.f19555h.f19559b)) {
            m8703r(i4 - i);
        }
        if (i <= i2 - (this.f19554g.f19559b + this.f19555h.f19559b)) {
            return true;
        }
        this.f19556i.mo1404f();
        return false;
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: g */
    public abstract void mo1383g(V v);

    @Override // p007b.p109f.p115d.p122g.Pool2
    public V get(int i) throws Throwable {
        V vMo1387l;
        synchronized (this) {
            AnimatableValueParser.m419B(!m8700n() || this.f19555h.f19559b == 0);
        }
        int iMo1384i = mo1384i(i);
        synchronized (this) {
            Bucket2<V> bucket2M8698h = m8698h(iMo1384i);
            if (bucket2M8698h != null && (vMo1387l = mo1387l(bucket2M8698h)) != null) {
                AnimatableValueParser.m419B(this.f19552e.add(vMo1387l));
                int iMo1386k = mo1386k(mo1385j(vMo1387l));
                this.f19554g.m8705b(iMo1386k);
                this.f19555h.m8704a(iMo1386k);
                this.f19556i.mo1400b(iMo1386k);
                m8701p();
                if (FLog.m980h(2)) {
                    System.identityHashCode(vMo1387l);
                }
                return vMo1387l;
            }
            int iMo1386k2 = mo1386k(iMo1384i);
            if (!m8697f(iMo1386k2)) {
                throw new PoolSizeViolationException(this.f19550c.f3976a, this.f19554g.f19559b, this.f19555h.f19559b, iMo1386k2);
            }
            this.f19554g.m8705b(iMo1386k2);
            if (bucket2M8698h != null) {
                bucket2M8698h.f3930e++;
            }
            V vMo1382e = null;
            try {
                vMo1382e = mo1382e(iMo1384i);
            } catch (Throwable th) {
                synchronized (this) {
                    this.f19554g.m8704a(iMo1386k2);
                    Bucket2<V> bucket2M8698h2 = m8698h(iMo1384i);
                    if (bucket2M8698h2 != null) {
                        bucket2M8698h2.m1377b();
                    }
                    Throwables.m972a(th);
                }
            }
            synchronized (this) {
                AnimatableValueParser.m419B(this.f19552e.add(vMo1382e));
                synchronized (this) {
                    if (m8700n()) {
                        m8703r(this.f19550c.f3977b);
                    }
                }
                return vMo1382e;
            }
            this.f19556i.mo1399a(iMo1386k2);
            m8701p();
            if (FLog.m980h(2)) {
                System.identityHashCode(vMo1382e);
            }
            return vMo1382e;
        }
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: h */
    public synchronized Bucket2<V> m8698h(int i) {
        Bucket2<V> bucket2 = this.f19551d.get(i);
        if (bucket2 == null && this.f19553f) {
            FLog.m980h(2);
            Bucket2<V> bucket2M8702q = m8702q(i);
            this.f19551d.put(i, bucket2M8702q);
            return bucket2M8702q;
        }
        return bucket2;
    }

    /* JADX INFO: renamed from: i */
    public abstract int mo1384i(int i);

    /* JADX INFO: renamed from: j */
    public abstract int mo1385j(V v);

    /* JADX INFO: renamed from: k */
    public abstract int mo1386k(int i);

    /* JADX INFO: renamed from: l */
    public synchronized V mo1387l(Bucket2<V> bucket2) {
        V vM1378c;
        vM1378c = bucket2.m1378c();
        if (vM1378c != null) {
            bucket2.f3930e++;
        }
        return vM1378c;
    }

    /* JADX INFO: renamed from: m */
    public void m8699m() {
        this.f19549b.mo989a(this);
        this.f19556i.mo1401c(this);
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: n */
    public synchronized boolean m8700n() {
        boolean z2;
        z2 = this.f19554g.f19559b + this.f19555h.f19559b > this.f19550c.f3977b;
        if (z2) {
            this.f19556i.mo1402d();
        }
        return z2;
    }

    /* JADX INFO: renamed from: o */
    public boolean mo1388o(V v) {
        return true;
    }

    @SuppressLint({"InvalidAccessToGuardedField"})
    /* JADX INFO: renamed from: p */
    public final void m8701p() {
        if (FLog.m980h(2)) {
            C10661a c10661a = this.f19554g;
            int i = c10661a.f19558a;
            int i2 = c10661a.f19559b;
            C10661a c10661a2 = this.f19555h;
            int i3 = c10661a2.f19558a;
            int i4 = c10661a2.f19559b;
        }
    }

    /* JADX INFO: renamed from: q */
    public Bucket2<V> m8702q(int i) {
        int iMo1386k = mo1386k(i);
        Objects.requireNonNull(this.f19550c);
        return new Bucket2<>(iMo1386k, Integer.MAX_VALUE, 0, false);
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: r */
    public synchronized void m8703r(int i) {
        int i2 = this.f19554g.f19559b;
        int i3 = this.f19555h.f19559b;
        int iMin = Math.min((i2 + i3) - i, i3);
        if (iMin <= 0) {
            return;
        }
        if (FLog.m980h(2)) {
            FLog.m982j(this.f19548a, "trimToSize: TargetSize = %d; Initial Size = %d; Bytes to free = %d", Integer.valueOf(i), Integer.valueOf(this.f19554g.f19559b + this.f19555h.f19559b), Integer.valueOf(iMin));
        }
        m8701p();
        for (int i4 = 0; i4 < this.f19551d.size() && iMin > 0; i4++) {
            Bucket2<V> bucket2ValueAt = this.f19551d.valueAt(i4);
            Objects.requireNonNull(bucket2ValueAt);
            Bucket2<V> bucket2 = bucket2ValueAt;
            while (iMin > 0) {
                V vM1378c = bucket2.m1378c();
                if (vM1378c == null) {
                    break;
                }
                mo1383g(vM1378c);
                int i5 = bucket2.f3926a;
                iMin -= i5;
                this.f19555h.m8704a(i5);
            }
        }
        m8701p();
        if (FLog.m980h(2)) {
            int i6 = this.f19554g.f19559b;
            int i7 = this.f19555h.f19559b;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007f  */
    @Override // p007b.p109f.p115d.p122g.Pool2, p007b.p109f.p115d.p123h.ResourceReleaser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void release(V v) {
        Bucket2<V> bucket2;
        Objects.requireNonNull(v);
        int iMo1385j = mo1385j(v);
        int iMo1386k = mo1386k(iMo1385j);
        synchronized (this) {
            try {
                synchronized (this) {
                    bucket2 = this.f19551d.get(iMo1385j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        boolean z2 = true;
        if (!this.f19552e.remove(v)) {
            FLog.m975c(this.f19548a, "release (free, value unrecognized) (object, size) = (%x, %s)", Integer.valueOf(System.identityHashCode(v)), Integer.valueOf(iMo1385j));
            mo1383g(v);
            this.f19556i.mo1403e(iMo1386k);
        } else if (bucket2 == null) {
            if (bucket2 != null) {
                bucket2.m1377b();
            }
            if (FLog.m980h(2)) {
                System.identityHashCode(v);
            }
            mo1383g(v);
            this.f19554g.m8704a(iMo1386k);
            this.f19556i.mo1403e(iMo1386k);
        } else {
            if (bucket2.f3930e + bucket2.f3928c.size() <= bucket2.f3927b) {
                z2 = false;
            }
            if (!z2 && !m8700n() && mo1388o(v)) {
                bucket2.m1379d(v);
                this.f19555h.m8705b(iMo1386k);
                this.f19554g.m8704a(iMo1386k);
                this.f19556i.mo1405g(iMo1386k);
                if (FLog.m980h(2)) {
                    System.identityHashCode(v);
                }
            }
        }
        m8701p();
    }
}
