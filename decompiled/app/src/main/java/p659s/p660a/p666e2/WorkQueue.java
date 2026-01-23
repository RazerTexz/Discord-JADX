package p659s.p660a.p666e2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: s.a.e2.m, reason: use source file name */
/* JADX INFO: compiled from: WorkQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class WorkQueue {

    /* JADX INFO: renamed from: a */
    public static final AtomicReferenceFieldUpdater f27836a = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");

    /* JADX INFO: renamed from: b */
    public static final AtomicIntegerFieldUpdater f27837b = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");

    /* JADX INFO: renamed from: c */
    public static final AtomicIntegerFieldUpdater f27838c = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");

    /* JADX INFO: renamed from: d */
    public static final AtomicIntegerFieldUpdater f27839d = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");

    /* JADX INFO: renamed from: e */
    public final AtomicReferenceArray<Tasks4> f27840e = new AtomicReferenceArray<>(128);
    public volatile Object lastScheduledTask = null;
    public volatile int producerIndex = 0;
    public volatile int consumerIndex = 0;
    public volatile int blockingTasksInBuffer = 0;

    /* JADX INFO: renamed from: a */
    public final Tasks4 m11271a(Tasks4 tasks4, boolean z2) {
        if (z2) {
            return m11272b(tasks4);
        }
        Tasks4 tasks42 = (Tasks4) f27836a.getAndSet(this, tasks4);
        if (tasks42 != null) {
            return m11272b(tasks42);
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public final Tasks4 m11272b(Tasks4 tasks4) {
        if (tasks4.f27829k.mo11269t() == 1) {
            f27839d.incrementAndGet(this);
        }
        if (m11273c() == 127) {
            return tasks4;
        }
        int i = this.producerIndex & Opcodes.LAND;
        while (this.f27840e.get(i) != null) {
            Thread.yield();
        }
        this.f27840e.lazySet(i, tasks4);
        f27837b.incrementAndGet(this);
        return null;
    }

    /* JADX INFO: renamed from: c */
    public final int m11273c() {
        return this.producerIndex - this.consumerIndex;
    }

    /* JADX INFO: renamed from: d */
    public final int m11274d() {
        return this.lastScheduledTask != null ? m11273c() + 1 : m11273c();
    }

    /* JADX INFO: renamed from: e */
    public final Tasks4 m11275e() {
        Tasks4 tasks4 = (Tasks4) f27836a.getAndSet(this, null);
        return tasks4 != null ? tasks4 : m11276f();
    }

    /* JADX INFO: renamed from: f */
    public final Tasks4 m11276f() {
        Tasks4 andSet;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & Opcodes.LAND;
            if (f27838c.compareAndSet(this, i, i + 1) && (andSet = this.f27840e.getAndSet(i2, null)) != null) {
                if (andSet.f27829k.mo11269t() == 1) {
                    f27839d.decrementAndGet(this);
                }
                return andSet;
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public final long m11277g(WorkQueue workQueue, boolean z2) {
        Tasks4 tasks4;
        do {
            tasks4 = (Tasks4) workQueue.lastScheduledTask;
            if (tasks4 == null) {
                return -2L;
            }
            if (z2) {
                if (!(tasks4.f27829k.mo11269t() == 1)) {
                    return -2L;
                }
            }
            long jMo11270a = Tasks7.f27835e.mo11270a() - tasks4.f27828j;
            long j = Tasks7.f27831a;
            if (jMo11270a < j) {
                return j - jMo11270a;
            }
        } while (!f27836a.compareAndSet(workQueue, tasks4, null));
        m11271a(tasks4, false);
        return -1L;
    }
}
