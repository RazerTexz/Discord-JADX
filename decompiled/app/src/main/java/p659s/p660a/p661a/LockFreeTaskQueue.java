package p659s.p660a.p661a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: s.a.a.l, reason: use source file name */
/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public class LockFreeTaskQueue<E> {

    /* JADX INFO: renamed from: a */
    public static final AtomicReferenceFieldUpdater f27689a = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur");
    public volatile Object _cur;

    public LockFreeTaskQueue(boolean z2) {
        this._cur = new LockFreeTaskQueue2(8, z2);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m11161a(E e) {
        while (true) {
            LockFreeTaskQueue2 lockFreeTaskQueue2 = (LockFreeTaskQueue2) this._cur;
            int iM11165a = lockFreeTaskQueue2.m11165a(e);
            if (iM11165a == 0) {
                return true;
            }
            if (iM11165a == 1) {
                f27689a.compareAndSet(this, lockFreeTaskQueue2, lockFreeTaskQueue2.m11168d());
            } else if (iM11165a == 2) {
                return false;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m11162b() {
        while (true) {
            LockFreeTaskQueue2 lockFreeTaskQueue2 = (LockFreeTaskQueue2) this._cur;
            if (lockFreeTaskQueue2.m11166b()) {
                return;
            } else {
                f27689a.compareAndSet(this, lockFreeTaskQueue2, lockFreeTaskQueue2.m11168d());
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final int m11163c() {
        long j = ((LockFreeTaskQueue2) this._cur)._state;
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0)));
    }

    /* JADX INFO: renamed from: d */
    public final E m11164d() {
        while (true) {
            LockFreeTaskQueue2 lockFreeTaskQueue2 = (LockFreeTaskQueue2) this._cur;
            E e = (E) lockFreeTaskQueue2.m11169e();
            if (e != LockFreeTaskQueue2.f27692c) {
                return e;
            }
            f27689a.compareAndSet(this, lockFreeTaskQueue2, lockFreeTaskQueue2.m11168d());
        }
    }
}
