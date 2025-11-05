package s.a.e2;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.permission.Permission;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import org.objectweb.asm.Opcodes;
import s.a.a.t;

/* compiled from: CoroutineScheduler.kt */
/* loaded from: classes3.dex */
public final class a implements Executor, Closeable {
    public volatile int _isTerminated;
    public volatile long controlState;
    public final d n;
    public final d o;
    public final AtomicReferenceArray<C0649a> p;
    public volatile long parkedWorkersStack;
    public final int q;
    public final int r;

    /* renamed from: s, reason: collision with root package name */
    public final long f3838s;
    public final String t;
    public static final t m = new t("NOT_IN_STACK");
    public static final AtomicLongFieldUpdater j = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");
    public static final AtomicLongFieldUpdater k = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");
    public static final AtomicIntegerFieldUpdater l = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    /* compiled from: CoroutineScheduler.kt */
    /* renamed from: s.a.e2.a$a, reason: collision with other inner class name */
    public final class C0649a extends Thread {
        public static final AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(C0649a.class, "workerCtl");
        public volatile int indexInArray;
        public final m k;
        public int l;
        public long m;
        public long n;
        public volatile Object nextParkedWorker;
        public int o;
        public boolean p;
        public volatile int workerCtl;

        public C0649a(int i) {
            setDaemon(true);
            this.k = new m();
            this.l = 4;
            this.workerCtl = 0;
            this.nextParkedWorker = a.m;
            this.o = d0.c0.c.k.nextInt();
            d(i);
        }

        public final h a(boolean z2) {
            boolean z3;
            h hVarD;
            h hVarC;
            h hVarC2;
            boolean z4;
            if (this.l == 1) {
                z3 = true;
            } else {
                a aVar = a.this;
                while (true) {
                    long j2 = aVar.controlState;
                    if (((int) ((9223367638808264704L & j2) >> 42)) == 0) {
                        z4 = false;
                        break;
                    }
                    if (a.k.compareAndSet(aVar, j2, j2 - 4398046511104L)) {
                        z4 = true;
                        break;
                    }
                }
                if (z4) {
                    this.l = 1;
                    z3 = true;
                } else {
                    z3 = false;
                }
            }
            if (!z3) {
                if (!z2 || (hVarD = this.k.e()) == null) {
                    hVarD = a.this.o.d();
                }
                return hVarD != null ? hVarD : f(true);
            }
            if (z2) {
                boolean z5 = b(a.this.q * 2) == 0;
                if (z5 && (hVarC2 = c()) != null) {
                    return hVarC2;
                }
                h hVarE = this.k.e();
                if (hVarE != null) {
                    return hVarE;
                }
                if (!z5 && (hVarC = c()) != null) {
                    return hVarC;
                }
            } else {
                h hVarC3 = c();
                if (hVarC3 != null) {
                    return hVarC3;
                }
            }
            return f(false);
        }

        public final int b(int i) {
            int i2 = this.o;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.o = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        public final h c() {
            if (b(2) == 0) {
                h hVarD = a.this.n.d();
                return hVarD != null ? hVarD : a.this.o.d();
            }
            h hVarD2 = a.this.o.d();
            return hVarD2 != null ? hVarD2 : a.this.n.d();
        }

        public final void d(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.t);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final boolean e(int i) {
            int i2 = this.l;
            boolean z2 = i2 == 1;
            if (z2) {
                a.k.addAndGet(a.this, 4398046511104L);
            }
            if (i2 != i) {
                this.l = i;
            }
            return z2;
        }

        public final h f(boolean z2) {
            long jG;
            int i = (int) (a.this.controlState & 2097151);
            if (i < 2) {
                return null;
            }
            int iB = b(i);
            long jMin = RecyclerView.FOREVER_NS;
            for (int i2 = 0; i2 < i; i2++) {
                iB++;
                if (iB > i) {
                    iB = 1;
                }
                C0649a c0649a = a.this.p.get(iB);
                if (c0649a != null && c0649a != this) {
                    if (z2) {
                        m mVar = this.k;
                        m mVar2 = c0649a.k;
                        Objects.requireNonNull(mVar);
                        int i3 = mVar2.producerIndex;
                        AtomicReferenceArray<h> atomicReferenceArray = mVar2.e;
                        for (int i4 = mVar2.consumerIndex; i4 != i3; i4++) {
                            int i5 = i4 & Opcodes.LAND;
                            if (mVar2.blockingTasksInBuffer == 0) {
                                break;
                            }
                            h hVar = atomicReferenceArray.get(i5);
                            if (hVar != null) {
                                if ((hVar.k.t() == 1) && atomicReferenceArray.compareAndSet(i5, hVar, null)) {
                                    m.d.decrementAndGet(mVar2);
                                    mVar.a(hVar, false);
                                    jG = -1;
                                    break;
                                }
                            }
                        }
                        jG = mVar.g(mVar2, true);
                    } else {
                        m mVar3 = this.k;
                        m mVar4 = c0649a.k;
                        Objects.requireNonNull(mVar3);
                        h hVarF = mVar4.f();
                        if (hVarF != null) {
                            mVar3.a(hVarF, false);
                            jG = -1;
                        } else {
                            jG = mVar3.g(mVar4, false);
                        }
                    }
                    if (jG == -1) {
                        return this.k.e();
                    }
                    if (jG > 0) {
                        jMin = Math.min(jMin, jG);
                    }
                }
            }
            if (jMin == RecyclerView.FOREVER_NS) {
                jMin = 0;
            }
            this.n = jMin;
            return null;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j2;
            long j3;
            int i;
            loop0: while (true) {
                boolean z2 = false;
                while (a.this._isTerminated == 0 && this.l != 5) {
                    h hVarA = a(this.p);
                    if (hVarA != null) {
                        this.n = 0L;
                        int iT = hVarA.k.t();
                        this.m = 0L;
                        if (this.l == 3) {
                            this.l = 2;
                        }
                        if (iT != 0 && e(2)) {
                            a.this.s();
                        }
                        a.this.q(hVarA);
                        if (iT != 0) {
                            a.k.addAndGet(a.this, -2097152L);
                            if (this.l != 5) {
                                this.l = 4;
                            }
                        }
                    } else {
                        this.p = false;
                        if (this.n == 0) {
                            Object obj = this.nextParkedWorker;
                            t tVar = a.m;
                            if (obj != tVar) {
                                this.workerCtl = -1;
                                while (true) {
                                    if (!(this.nextParkedWorker != a.m) || a.this._isTerminated != 0 || this.l == 5) {
                                        break;
                                    }
                                    e(3);
                                    Thread.interrupted();
                                    if (this.m == 0) {
                                        this.m = System.nanoTime() + a.this.f3838s;
                                    }
                                    LockSupport.parkNanos(a.this.f3838s);
                                    if (System.nanoTime() - this.m >= 0) {
                                        this.m = 0L;
                                        synchronized (a.this.p) {
                                            if (a.this._isTerminated == 0) {
                                                if (((int) (a.this.controlState & 2097151)) > a.this.q) {
                                                    if (j.compareAndSet(this, -1, 1)) {
                                                        int i2 = this.indexInArray;
                                                        d(0);
                                                        a.this.n(this, i2, 0);
                                                        int andDecrement = (int) (a.k.getAndDecrement(a.this) & 2097151);
                                                        if (andDecrement != i2) {
                                                            C0649a c0649a = a.this.p.get(andDecrement);
                                                            d0.z.d.m.checkNotNull(c0649a);
                                                            C0649a c0649a2 = c0649a;
                                                            a.this.p.set(i2, c0649a2);
                                                            c0649a2.d(i2);
                                                            a.this.n(c0649a2, andDecrement, i2);
                                                        }
                                                        a.this.p.set(andDecrement, null);
                                                        this.l = 5;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                a aVar = a.this;
                                Objects.requireNonNull(aVar);
                                if (this.nextParkedWorker == tVar) {
                                    do {
                                        j2 = aVar.parkedWorkersStack;
                                        j3 = (Permission.SPEAK + j2) & (-2097152);
                                        i = this.indexInArray;
                                        this.nextParkedWorker = aVar.p.get((int) (j2 & 2097151));
                                    } while (!a.j.compareAndSet(aVar, j2, i | j3));
                                }
                            }
                        } else if (z2) {
                            e(3);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.n);
                            this.n = 0L;
                        } else {
                            z2 = true;
                        }
                    }
                }
                break loop0;
            }
            e(5);
        }
    }

    public a(int i, int i2, long j2, String str) {
        this.q = i;
        this.r = i2;
        this.f3838s = j2;
        this.t = str;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(b.d.b.a.a.r("Core pool size ", i, " should be at least 1").toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(b.d.b.a.a.s("Max pool size ", i2, " should be greater than or equals to core pool size ", i).toString());
        }
        if (!(i2 <= 2097150)) {
            throw new IllegalArgumentException(b.d.b.a.a.r("Max pool size ", i2, " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j2 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.n = new d();
        this.o = new d();
        this.parkedWorkersStack = 0L;
        this.p = new AtomicReferenceArray<>(i2 + 1);
        this.controlState = i << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ void e(a aVar, Runnable runnable, i iVar, boolean z2, int i) {
        g gVar = (i & 2) != 0 ? g.j : null;
        if ((i & 4) != 0) {
            z2 = false;
        }
        aVar.d(runnable, gVar, z2);
    }

    public final int a() {
        synchronized (this.p) {
            if (this._isTerminated != 0) {
                return -1;
            }
            long j2 = this.controlState;
            int i = (int) (j2 & 2097151);
            int iCoerceAtLeast = d0.d0.f.coerceAtLeast(i - ((int) ((j2 & 4398044413952L) >> 21)), 0);
            if (iCoerceAtLeast >= this.q) {
                return 0;
            }
            if (i >= this.r) {
                return 0;
            }
            int i2 = ((int) (this.controlState & 2097151)) + 1;
            if (!(i2 > 0 && this.p.get(i2) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            C0649a c0649a = new C0649a(i2);
            this.p.set(i2, c0649a);
            if (!(i2 == ((int) (2097151 & k.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            c0649a.start();
            return iCoerceAtLeast + 1;
        }
    }

    public final h b(Runnable runnable, i iVar) {
        long jA = k.e.a();
        if (!(runnable instanceof h)) {
            return new j(runnable, jA, iVar);
        }
        h hVar = (h) runnable;
        hVar.j = jA;
        hVar.k = iVar;
        return hVar;
    }

    public final C0649a c() {
        Thread threadCurrentThread = Thread.currentThread();
        if (!(threadCurrentThread instanceof C0649a)) {
            threadCurrentThread = null;
        }
        C0649a c0649a = (C0649a) threadCurrentThread;
        if (c0649a == null || !d0.z.d.m.areEqual(a.this, this)) {
            return null;
        }
        return c0649a;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0076  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws InterruptedException {
        int i;
        h hVarD;
        boolean z2;
        if (l.compareAndSet(this, 0, 1)) {
            C0649a c0649aC = c();
            synchronized (this.p) {
                i = (int) (this.controlState & 2097151);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    C0649a c0649a = this.p.get(i2);
                    d0.z.d.m.checkNotNull(c0649a);
                    C0649a c0649a2 = c0649a;
                    if (c0649a2 != c0649aC) {
                        while (c0649a2.isAlive()) {
                            LockSupport.unpark(c0649a2);
                            c0649a2.join(10000L);
                        }
                        m mVar = c0649a2.k;
                        d dVar = this.o;
                        Objects.requireNonNull(mVar);
                        h hVar = (h) m.a.getAndSet(mVar, null);
                        if (hVar != null) {
                            dVar.a(hVar);
                        }
                        do {
                            h hVarF = mVar.f();
                            if (hVarF != null) {
                                dVar.a(hVarF);
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        } while (z2);
                    }
                    if (i2 == i) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            this.o.b();
            this.n.b();
            while (true) {
                if (c0649aC == null) {
                    hVarD = this.n.d();
                } else {
                    hVarD = c0649aC.a(true);
                    if (hVarD == null) {
                    }
                }
                if (hVarD == null) {
                    hVarD = this.o.d();
                }
                if (hVarD == null) {
                    break;
                } else {
                    q(hVarD);
                }
            }
            if (c0649aC != null) {
                c0649aC.e(5);
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    public final void d(Runnable runnable, i iVar, boolean z2) {
        h hVarA;
        h hVarB = b(runnable, iVar);
        C0649a c0649aC = c();
        if (c0649aC == null || c0649aC.l == 5 || (hVarB.k.t() == 0 && c0649aC.l == 2)) {
            hVarA = hVarB;
        } else {
            c0649aC.p = true;
            hVarA = c0649aC.k.a(hVarB, z2);
        }
        if (hVarA != null) {
            if (!(hVarA.k.t() == 1 ? this.o.a(hVarA) : this.n.a(hVarA))) {
                throw new RejectedExecutionException(b.d.b.a.a.J(new StringBuilder(), this.t, " was terminated"));
            }
        }
        boolean z3 = z2 && c0649aC != null;
        if (hVarB.k.t() == 0) {
            if (z3) {
                return;
            }
            s();
        } else {
            long jAddAndGet = k.addAndGet(this, Permission.SPEAK);
            if (z3 || u() || t(jAddAndGet)) {
                return;
            }
            u();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        e(this, runnable, null, false, 6);
    }

    public final int f(C0649a c0649a) {
        Object obj = c0649a.nextParkedWorker;
        while (obj != m) {
            if (obj == null) {
                return 0;
            }
            C0649a c0649a2 = (C0649a) obj;
            int i = c0649a2.indexInArray;
            if (i != 0) {
                return i;
            }
            obj = c0649a2.nextParkedWorker;
        }
        return -1;
    }

    public final void n(C0649a c0649a, int i, int i2) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int iF = (int) (2097151 & j2);
            long j3 = (Permission.SPEAK + j2) & (-2097152);
            if (iF == i) {
                iF = i2 == 0 ? f(c0649a) : i2;
            }
            if (iF >= 0 && j.compareAndSet(this, j2, j3 | iF)) {
                return;
            }
        }
    }

    public final void q(h hVar) {
        try {
            hVar.run();
        } finally {
        }
    }

    public final void s() {
        if (u() || t(this.controlState)) {
            return;
        }
        u();
    }

    public final boolean t(long j2) {
        if (d0.d0.f.coerceAtLeast(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0) < this.q) {
            int iA = a();
            if (iA == 1 && this.q > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int length = this.p.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < length; i6++) {
            C0649a c0649a = this.p.get(i6);
            if (c0649a != null) {
                int iD = c0649a.k.d();
                int iH = b.c.a.y.b.h(c0649a.l);
                if (iH == 0) {
                    i++;
                    arrayList.add(String.valueOf(iD) + "c");
                } else if (iH == 1) {
                    i2++;
                    arrayList.add(String.valueOf(iD) + "b");
                } else if (iH == 2) {
                    i3++;
                } else if (iH == 3) {
                    i4++;
                    if (iD > 0) {
                        arrayList.add(String.valueOf(iD) + "d");
                    }
                } else if (iH == 4) {
                    i5++;
                }
            }
        }
        long j2 = this.controlState;
        return this.t + MentionUtilsKt.MENTIONS_CHAR + b.i.a.f.e.o.f.l0(this) + "[Pool Size {core = " + this.q + ", max = " + this.r + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.n.c() + ", global blocking queue size = " + this.o.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.q - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }

    public final boolean u() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            C0649a c0649a = this.p.get((int) (2097151 & j2));
            if (c0649a != null) {
                long j3 = (Permission.SPEAK + j2) & (-2097152);
                int iF = f(c0649a);
                if (iF >= 0 && j.compareAndSet(this, j2, iF | j3)) {
                    c0649a.nextParkedWorker = m;
                }
            } else {
                c0649a = null;
            }
            if (c0649a == null) {
                return false;
            }
            if (C0649a.j.compareAndSet(c0649a, -1, 0)) {
                LockSupport.unpark(c0649a);
                return true;
            }
        }
    }
}
