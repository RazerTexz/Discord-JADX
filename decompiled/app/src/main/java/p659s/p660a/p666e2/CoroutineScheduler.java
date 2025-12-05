package p659s.p660a.p666e2;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.api.permission.Permission;
import com.discord.widgets.chat.input.MentionUtils;
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
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p510c0.Random;
import p507d0.p512d0._Ranges;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.p661a.Symbol3;

/* compiled from: CoroutineScheduler.kt */
/* renamed from: s.a.e2.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    public volatile int _isTerminated;
    public volatile long controlState;

    /* renamed from: n */
    public final Tasks f27798n;

    /* renamed from: o */
    public final Tasks f27799o;

    /* renamed from: p */
    public final AtomicReferenceArray<a> f27800p;
    public volatile long parkedWorkersStack;

    /* renamed from: q */
    public final int f27801q;

    /* renamed from: r */
    public final int f27802r;

    /* renamed from: s */
    public final long f27803s;

    /* renamed from: t */
    public final String f27804t;

    /* renamed from: m */
    public static final Symbol3 f27797m = new Symbol3("NOT_IN_STACK");

    /* renamed from: j */
    public static final AtomicLongFieldUpdater f27794j = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");

    /* renamed from: k */
    public static final AtomicLongFieldUpdater f27795k = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");

    /* renamed from: l */
    public static final AtomicIntegerFieldUpdater f27796l = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* compiled from: CoroutineScheduler.kt */
    /* renamed from: s.a.e2.a$a */
    public final class a extends Thread {

        /* renamed from: j */
        public static final AtomicIntegerFieldUpdater f27805j = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl");
        public volatile int indexInArray;

        /* renamed from: k */
        public final WorkQueue f27806k;

        /* renamed from: l */
        public int f27807l;

        /* renamed from: m */
        public long f27808m;

        /* renamed from: n */
        public long f27809n;
        public volatile Object nextParkedWorker;

        /* renamed from: o */
        public int f27810o;

        /* renamed from: p */
        public boolean f27811p;
        public volatile int workerCtl;

        public a(int i) {
            setDaemon(true);
            this.f27806k = new WorkQueue();
            this.f27807l = 4;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.f27797m;
            this.f27810o = Random.f22272k.nextInt();
            m11264d(i);
        }

        /* renamed from: a */
        public final Tasks4 m11261a(boolean z2) {
            boolean z3;
            Tasks4 tasks4M11164d;
            Tasks4 tasks4M11263c;
            Tasks4 tasks4M11263c2;
            boolean z4;
            if (this.f27807l == 1) {
                z3 = true;
            } else {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j = coroutineScheduler.controlState;
                    if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                        z4 = false;
                        break;
                    }
                    if (CoroutineScheduler.f27795k.compareAndSet(coroutineScheduler, j, j - 4398046511104L)) {
                        z4 = true;
                        break;
                    }
                }
                if (z4) {
                    this.f27807l = 1;
                    z3 = true;
                } else {
                    z3 = false;
                }
            }
            if (!z3) {
                if (!z2 || (tasks4M11164d = this.f27806k.m11275e()) == null) {
                    tasks4M11164d = CoroutineScheduler.this.f27799o.m11164d();
                }
                return tasks4M11164d != null ? tasks4M11164d : m11266f(true);
            }
            if (z2) {
                boolean z5 = m11262b(CoroutineScheduler.this.f27801q * 2) == 0;
                if (z5 && (tasks4M11263c2 = m11263c()) != null) {
                    return tasks4M11263c2;
                }
                Tasks4 tasks4M11275e = this.f27806k.m11275e();
                if (tasks4M11275e != null) {
                    return tasks4M11275e;
                }
                if (!z5 && (tasks4M11263c = m11263c()) != null) {
                    return tasks4M11263c;
                }
            } else {
                Tasks4 tasks4M11263c3 = m11263c();
                if (tasks4M11263c3 != null) {
                    return tasks4M11263c3;
                }
            }
            return m11266f(false);
        }

        /* renamed from: b */
        public final int m11262b(int i) {
            int i2 = this.f27810o;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.f27810o = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        /* renamed from: c */
        public final Tasks4 m11263c() {
            if (m11262b(2) == 0) {
                Tasks4 tasks4M11164d = CoroutineScheduler.this.f27798n.m11164d();
                return tasks4M11164d != null ? tasks4M11164d : CoroutineScheduler.this.f27799o.m11164d();
            }
            Tasks4 tasks4M11164d2 = CoroutineScheduler.this.f27799o.m11164d();
            return tasks4M11164d2 != null ? tasks4M11164d2 : CoroutineScheduler.this.f27798n.m11164d();
        }

        /* renamed from: d */
        public final void m11264d(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.f27804t);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        /* renamed from: e */
        public final boolean m11265e(int i) {
            int i2 = this.f27807l;
            boolean z2 = i2 == 1;
            if (z2) {
                CoroutineScheduler.f27795k.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (i2 != i) {
                this.f27807l = i;
            }
            return z2;
        }

        /* renamed from: f */
        public final Tasks4 m11266f(boolean z2) {
            long jM11277g;
            int i = (int) (CoroutineScheduler.this.controlState & 2097151);
            if (i < 2) {
                return null;
            }
            int iM11262b = m11262b(i);
            long jMin = RecyclerView.FOREVER_NS;
            for (int i2 = 0; i2 < i; i2++) {
                iM11262b++;
                if (iM11262b > i) {
                    iM11262b = 1;
                }
                a aVar = CoroutineScheduler.this.f27800p.get(iM11262b);
                if (aVar != null && aVar != this) {
                    if (z2) {
                        WorkQueue workQueue = this.f27806k;
                        WorkQueue workQueue2 = aVar.f27806k;
                        Objects.requireNonNull(workQueue);
                        int i3 = workQueue2.producerIndex;
                        AtomicReferenceArray<Tasks4> atomicReferenceArray = workQueue2.f27840e;
                        for (int i4 = workQueue2.consumerIndex; i4 != i3; i4++) {
                            int i5 = i4 & Opcodes.LAND;
                            if (workQueue2.blockingTasksInBuffer == 0) {
                                break;
                            }
                            Tasks4 tasks4 = atomicReferenceArray.get(i5);
                            if (tasks4 != null) {
                                if ((tasks4.f27829k.mo11269t() == 1) && atomicReferenceArray.compareAndSet(i5, tasks4, null)) {
                                    WorkQueue.f27839d.decrementAndGet(workQueue2);
                                    workQueue.m11271a(tasks4, false);
                                    jM11277g = -1;
                                    break;
                                }
                            }
                        }
                        jM11277g = workQueue.m11277g(workQueue2, true);
                    } else {
                        WorkQueue workQueue3 = this.f27806k;
                        WorkQueue workQueue4 = aVar.f27806k;
                        Objects.requireNonNull(workQueue3);
                        Tasks4 tasks4M11276f = workQueue4.m11276f();
                        if (tasks4M11276f != null) {
                            workQueue3.m11271a(tasks4M11276f, false);
                            jM11277g = -1;
                        } else {
                            jM11277g = workQueue3.m11277g(workQueue4, false);
                        }
                    }
                    if (jM11277g == -1) {
                        return this.f27806k.m11275e();
                    }
                    if (jM11277g > 0) {
                        jMin = Math.min(jMin, jM11277g);
                    }
                }
            }
            if (jMin == RecyclerView.FOREVER_NS) {
                jMin = 0;
            }
            this.f27809n = jMin;
            return null;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j;
            long j2;
            int i;
            loop0: while (true) {
                boolean z2 = false;
                while (CoroutineScheduler.this._isTerminated == 0 && this.f27807l != 5) {
                    Tasks4 tasks4M11261a = m11261a(this.f27811p);
                    if (tasks4M11261a != null) {
                        this.f27809n = 0L;
                        int iMo11269t = tasks4M11261a.f27829k.mo11269t();
                        this.f27808m = 0L;
                        if (this.f27807l == 3) {
                            this.f27807l = 2;
                        }
                        if (iMo11269t != 0 && m11265e(2)) {
                            CoroutineScheduler.this.m11258s();
                        }
                        CoroutineScheduler.this.m11257q(tasks4M11261a);
                        if (iMo11269t != 0) {
                            CoroutineScheduler.f27795k.addAndGet(CoroutineScheduler.this, -2097152L);
                            if (this.f27807l != 5) {
                                this.f27807l = 4;
                            }
                        }
                    } else {
                        this.f27811p = false;
                        if (this.f27809n == 0) {
                            Object obj = this.nextParkedWorker;
                            Symbol3 symbol3 = CoroutineScheduler.f27797m;
                            if (obj != symbol3) {
                                this.workerCtl = -1;
                                while (true) {
                                    if (!(this.nextParkedWorker != CoroutineScheduler.f27797m) || CoroutineScheduler.this._isTerminated != 0 || this.f27807l == 5) {
                                        break;
                                    }
                                    m11265e(3);
                                    Thread.interrupted();
                                    if (this.f27808m == 0) {
                                        this.f27808m = System.nanoTime() + CoroutineScheduler.this.f27803s;
                                    }
                                    LockSupport.parkNanos(CoroutineScheduler.this.f27803s);
                                    if (System.nanoTime() - this.f27808m >= 0) {
                                        this.f27808m = 0L;
                                        synchronized (CoroutineScheduler.this.f27800p) {
                                            if (CoroutineScheduler.this._isTerminated == 0) {
                                                if (((int) (CoroutineScheduler.this.controlState & 2097151)) > CoroutineScheduler.this.f27801q) {
                                                    if (f27805j.compareAndSet(this, -1, 1)) {
                                                        int i2 = this.indexInArray;
                                                        m11264d(0);
                                                        CoroutineScheduler.this.m11256n(this, i2, 0);
                                                        int andDecrement = (int) (CoroutineScheduler.f27795k.getAndDecrement(CoroutineScheduler.this) & 2097151);
                                                        if (andDecrement != i2) {
                                                            a aVar = CoroutineScheduler.this.f27800p.get(andDecrement);
                                                            Intrinsics3.checkNotNull(aVar);
                                                            a aVar2 = aVar;
                                                            CoroutineScheduler.this.f27800p.set(i2, aVar2);
                                                            aVar2.m11264d(i2);
                                                            CoroutineScheduler.this.m11256n(aVar2, andDecrement, i2);
                                                        }
                                                        CoroutineScheduler.this.f27800p.set(andDecrement, null);
                                                        this.f27807l = 5;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                                Objects.requireNonNull(coroutineScheduler);
                                if (this.nextParkedWorker == symbol3) {
                                    do {
                                        j = coroutineScheduler.parkedWorkersStack;
                                        j2 = (Permission.SPEAK + j) & (-2097152);
                                        i = this.indexInArray;
                                        this.nextParkedWorker = coroutineScheduler.f27800p.get((int) (j & 2097151));
                                    } while (!CoroutineScheduler.f27794j.compareAndSet(coroutineScheduler, j, i | j2));
                                }
                            }
                        } else if (z2) {
                            m11265e(3);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f27809n);
                            this.f27809n = 0L;
                        } else {
                            z2 = true;
                        }
                    }
                }
                break loop0;
            }
            m11265e(5);
        }
    }

    public CoroutineScheduler(int i, int i2, long j, String str) {
        this.f27801q = i;
        this.f27802r = i2;
        this.f27803s = j;
        this.f27804t = str;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(outline.m873r("Core pool size ", i, " should be at least 1").toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(outline.m875s("Max pool size ", i2, " should be greater than or equals to core pool size ", i).toString());
        }
        if (!(i2 <= 2097150)) {
            throw new IllegalArgumentException(outline.m873r("Max pool size ", i2, " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
        }
        this.f27798n = new Tasks();
        this.f27799o = new Tasks();
        this.parkedWorkersStack = 0L;
        this.f27800p = new AtomicReferenceArray<>(i2 + 1);
        this.controlState = i << 42;
        this._isTerminated = 0;
    }

    /* renamed from: e */
    public static /* synthetic */ void m11250e(CoroutineScheduler coroutineScheduler, Runnable runnable, Tasks5 tasks5, boolean z2, int i) {
        Tasks3 tasks3 = (i & 2) != 0 ? Tasks3.f27827j : null;
        if ((i & 4) != 0) {
            z2 = false;
        }
        coroutineScheduler.m11254d(runnable, tasks3, z2);
    }

    /* renamed from: a */
    public final int m11251a() {
        synchronized (this.f27800p) {
            if (this._isTerminated != 0) {
                return -1;
            }
            long j = this.controlState;
            int i = (int) (j & 2097151);
            int iCoerceAtLeast = _Ranges.coerceAtLeast(i - ((int) ((j & 4398044413952L) >> 21)), 0);
            if (iCoerceAtLeast >= this.f27801q) {
                return 0;
            }
            if (i >= this.f27802r) {
                return 0;
            }
            int i2 = ((int) (this.controlState & 2097151)) + 1;
            if (!(i2 > 0 && this.f27800p.get(i2) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            a aVar = new a(i2);
            this.f27800p.set(i2, aVar);
            if (!(i2 == ((int) (2097151 & f27795k.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            aVar.start();
            return iCoerceAtLeast + 1;
        }
    }

    /* renamed from: b */
    public final Tasks4 m11252b(Runnable runnable, Tasks5 tasks5) {
        long jMo11270a = Tasks7.f27835e.mo11270a();
        if (!(runnable instanceof Tasks4)) {
            return new Tasks6(runnable, jMo11270a, tasks5);
        }
        Tasks4 tasks4 = (Tasks4) runnable;
        tasks4.f27828j = jMo11270a;
        tasks4.f27829k = tasks5;
        return tasks4;
    }

    /* renamed from: c */
    public final a m11253c() {
        Thread threadCurrentThread = Thread.currentThread();
        if (!(threadCurrentThread instanceof a)) {
            threadCurrentThread = null;
        }
        a aVar = (a) threadCurrentThread;
        if (aVar == null || !Intrinsics3.areEqual(CoroutineScheduler.this, this)) {
            return null;
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0076  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void close() throws InterruptedException {
        int i;
        Tasks4 tasks4M11164d;
        boolean z2;
        if (f27796l.compareAndSet(this, 0, 1)) {
            a aVarM11253c = m11253c();
            synchronized (this.f27800p) {
                i = (int) (this.controlState & 2097151);
            }
            if (1 <= i) {
                int i2 = 1;
                while (true) {
                    a aVar = this.f27800p.get(i2);
                    Intrinsics3.checkNotNull(aVar);
                    a aVar2 = aVar;
                    if (aVar2 != aVarM11253c) {
                        while (aVar2.isAlive()) {
                            LockSupport.unpark(aVar2);
                            aVar2.join(10000L);
                        }
                        WorkQueue workQueue = aVar2.f27806k;
                        Tasks tasks = this.f27799o;
                        Objects.requireNonNull(workQueue);
                        Tasks4 tasks4 = (Tasks4) WorkQueue.f27836a.getAndSet(workQueue, null);
                        if (tasks4 != null) {
                            tasks.m11161a(tasks4);
                        }
                        do {
                            Tasks4 tasks4M11276f = workQueue.m11276f();
                            if (tasks4M11276f != null) {
                                tasks.m11161a(tasks4M11276f);
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
            this.f27799o.m11162b();
            this.f27798n.m11162b();
            while (true) {
                if (aVarM11253c == null) {
                    tasks4M11164d = this.f27798n.m11164d();
                } else {
                    tasks4M11164d = aVarM11253c.m11261a(true);
                    if (tasks4M11164d == null) {
                    }
                }
                if (tasks4M11164d == null) {
                    tasks4M11164d = this.f27799o.m11164d();
                }
                if (tasks4M11164d == null) {
                    break;
                } else {
                    m11257q(tasks4M11164d);
                }
            }
            if (aVarM11253c != null) {
                aVarM11253c.m11265e(5);
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    /* renamed from: d */
    public final void m11254d(Runnable runnable, Tasks5 tasks5, boolean z2) {
        Tasks4 tasks4M11271a;
        Tasks4 tasks4M11252b = m11252b(runnable, tasks5);
        a aVarM11253c = m11253c();
        if (aVarM11253c == null || aVarM11253c.f27807l == 5 || (tasks4M11252b.f27829k.mo11269t() == 0 && aVarM11253c.f27807l == 2)) {
            tasks4M11271a = tasks4M11252b;
        } else {
            aVarM11253c.f27811p = true;
            tasks4M11271a = aVarM11253c.f27806k.m11271a(tasks4M11252b, z2);
        }
        if (tasks4M11271a != null) {
            if (!(tasks4M11271a.f27829k.mo11269t() == 1 ? this.f27799o.m11161a(tasks4M11271a) : this.f27798n.m11161a(tasks4M11271a))) {
                throw new RejectedExecutionException(outline.m822J(new StringBuilder(), this.f27804t, " was terminated"));
            }
        }
        boolean z3 = z2 && aVarM11253c != null;
        if (tasks4M11252b.f27829k.mo11269t() == 0) {
            if (z3) {
                return;
            }
            m11258s();
        } else {
            long jAddAndGet = f27795k.addAndGet(this, Permission.SPEAK);
            if (z3 || m11260u() || m11259t(jAddAndGet)) {
                return;
            }
            m11260u();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        m11250e(this, runnable, null, false, 6);
    }

    /* renamed from: f */
    public final int m11255f(a aVar) {
        Object obj = aVar.nextParkedWorker;
        while (obj != f27797m) {
            if (obj == null) {
                return 0;
            }
            a aVar2 = (a) obj;
            int i = aVar2.indexInArray;
            if (i != 0) {
                return i;
            }
            obj = aVar2.nextParkedWorker;
        }
        return -1;
    }

    /* renamed from: n */
    public final void m11256n(a aVar, int i, int i2) {
        while (true) {
            long j = this.parkedWorkersStack;
            int iM11255f = (int) (2097151 & j);
            long j2 = (Permission.SPEAK + j) & (-2097152);
            if (iM11255f == i) {
                iM11255f = i2 == 0 ? m11255f(aVar) : i2;
            }
            if (iM11255f >= 0 && f27794j.compareAndSet(this, j, j2 | iM11255f)) {
                return;
            }
        }
    }

    /* renamed from: q */
    public final void m11257q(Tasks4 tasks4) {
        try {
            tasks4.run();
        } finally {
        }
    }

    /* renamed from: s */
    public final void m11258s() {
        if (m11260u() || m11259t(this.controlState)) {
            return;
        }
        m11260u();
    }

    /* renamed from: t */
    public final boolean m11259t(long j) {
        if (_Ranges.coerceAtLeast(((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)), 0) < this.f27801q) {
            int iM11251a = m11251a();
            if (iM11251a == 1 && this.f27801q > 1) {
                m11251a();
            }
            if (iM11251a > 0) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int length = this.f27800p.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < length; i6++) {
            a aVar = this.f27800p.get(i6);
            if (aVar != null) {
                int iM11274d = aVar.f27806k.m11274d();
                int iM758h = C1563b.m758h(aVar.f27807l);
                if (iM758h == 0) {
                    i++;
                    arrayList.add(String.valueOf(iM11274d) + "c");
                } else if (iM758h == 1) {
                    i2++;
                    arrayList.add(String.valueOf(iM11274d) + "b");
                } else if (iM758h == 2) {
                    i3++;
                } else if (iM758h == 3) {
                    i4++;
                    if (iM11274d > 0) {
                        arrayList.add(String.valueOf(iM11274d) + "d");
                    }
                } else if (iM758h == 4) {
                    i5++;
                }
            }
        }
        long j = this.controlState;
        return this.f27804t + MentionUtils.MENTIONS_CHAR + C3404f.m4312l0(this) + "[Pool Size {core = " + this.f27801q + ", max = " + this.f27802r + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f27798n.m11163c() + ", global blocking queue size = " + this.f27799o.m11163c() + ", Control State {created workers= " + ((int) (2097151 & j)) + ", blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", CPUs acquired = " + (this.f27801q - ((int) ((9223367638808264704L & j) >> 42))) + "}]";
    }

    /* renamed from: u */
    public final boolean m11260u() {
        while (true) {
            long j = this.parkedWorkersStack;
            a aVar = this.f27800p.get((int) (2097151 & j));
            if (aVar != null) {
                long j2 = (Permission.SPEAK + j) & (-2097152);
                int iM11255f = m11255f(aVar);
                if (iM11255f >= 0 && f27794j.compareAndSet(this, j, iM11255f | j2)) {
                    aVar.nextParkedWorker = f27797m;
                }
            } else {
                aVar = null;
            }
            if (aVar == null) {
                return false;
            }
            if (a.f27805j.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
        }
    }
}
