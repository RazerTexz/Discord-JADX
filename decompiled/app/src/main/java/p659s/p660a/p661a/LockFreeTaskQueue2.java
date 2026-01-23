package p659s.p660a.p661a;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: s.a.a.m, reason: use source file name */
/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LockFreeTaskQueue2<E> {
    public volatile Object _next = null;
    public volatile long _state = 0;

    /* JADX INFO: renamed from: e */
    public final int f27694e;

    /* JADX INFO: renamed from: f */
    public AtomicReferenceArray f27695f;

    /* JADX INFO: renamed from: g */
    public final int f27696g;

    /* JADX INFO: renamed from: h */
    public final boolean f27697h;

    /* JADX INFO: renamed from: d */
    public static final a f27693d = new a(null);

    /* JADX INFO: renamed from: c */
    public static final Symbol3 f27692c = new Symbol3("REMOVE_FROZEN");

    /* JADX INFO: renamed from: a */
    public static final AtomicReferenceFieldUpdater f27690a = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue2.class, Object.class, "_next");

    /* JADX INFO: renamed from: b */
    public static final AtomicLongFieldUpdater f27691b = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueue2.class, "_state");

    /* JADX INFO: renamed from: s.a.a.m$a */
    /* JADX INFO: compiled from: LockFreeTaskQueue.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: s.a.a.m$b */
    /* JADX INFO: compiled from: LockFreeTaskQueue.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final int f27698a;

        public b(int i) {
            this.f27698a = i;
        }
    }

    public LockFreeTaskQueue2(int i, boolean z2) {
        this.f27696g = i;
        this.f27697h = z2;
        int i2 = i - 1;
        this.f27694e = i2;
        this.f27695f = new AtomicReferenceArray(i);
        if (!(i2 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i & i2) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
    
        return 1;
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m11165a(E e) {
        while (true) {
            long j = this._state;
            if ((3458764513820540928L & j) != 0) {
                return (2305843009213693952L & j) != 0 ? 2 : 1;
            }
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.f27694e;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            if (!this.f27697h && this.f27695f.get(i2 & i3) != null) {
                int i4 = this.f27696g;
                if (i4 < 1024 || ((i2 - i) & 1073741823) > (i4 >> 1)) {
                    break;
                }
            } else if (f27691b.compareAndSet(this, j, ((-1152921503533105153L) & j) | (((long) ((i2 + 1) & 1073741823)) << 30))) {
                this.f27695f.set(i2 & i3, e);
                LockFreeTaskQueue2<E> lockFreeTaskQueue2M11168d = this;
                while ((lockFreeTaskQueue2M11168d._state & 1152921504606846976L) != 0) {
                    lockFreeTaskQueue2M11168d = lockFreeTaskQueue2M11168d.m11168d();
                    Object obj = lockFreeTaskQueue2M11168d.f27695f.get(lockFreeTaskQueue2M11168d.f27694e & i2);
                    if ((obj instanceof b) && ((b) obj).f27698a == i2) {
                        lockFreeTaskQueue2M11168d.f27695f.set(lockFreeTaskQueue2M11168d.f27694e & i2, e);
                    } else {
                        lockFreeTaskQueue2M11168d = null;
                    }
                    if (lockFreeTaskQueue2M11168d == null) {
                        break;
                    }
                }
                return 0;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m11166b() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!f27691b.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m11167c() {
        long j = this._state;
        return ((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: d */
    public final LockFreeTaskQueue2<E> m11168d() {
        long j;
        while (true) {
            j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                break;
            }
            long j2 = j | 1152921504606846976L;
            if (f27691b.compareAndSet(this, j, j2)) {
                j = j2;
                break;
            }
        }
        while (true) {
            LockFreeTaskQueue2<E> lockFreeTaskQueue2 = (LockFreeTaskQueue2) this._next;
            if (lockFreeTaskQueue2 != null) {
                return lockFreeTaskQueue2;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f27690a;
            LockFreeTaskQueue2 lockFreeTaskQueue22 = new LockFreeTaskQueue2(this.f27696g * 2, this.f27697h);
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            while (true) {
                int i3 = this.f27694e;
                int i4 = i & i3;
                if (i4 != (i3 & i2)) {
                    Object bVar = this.f27695f.get(i4);
                    if (bVar == null) {
                        bVar = new b(i);
                    }
                    lockFreeTaskQueue22.f27695f.set(lockFreeTaskQueue22.f27694e & i, bVar);
                    i++;
                }
            }
            lockFreeTaskQueue22._state = (-1152921504606846977L) & j;
            atomicReferenceFieldUpdater.compareAndSet(this, null, lockFreeTaskQueue22);
        }
    }

    /* JADX INFO: renamed from: e */
    public final Object m11169e() {
        while (true) {
            long j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return f27692c;
            }
            int i = (int) ((j & 1073741823) >> 0);
            int i2 = this.f27694e;
            int i3 = ((int) ((1152921503533105152L & j) >> 30)) & i2;
            int i4 = i2 & i;
            if (i3 == i4) {
                return null;
            }
            Object obj = this.f27695f.get(i4);
            if (obj == null) {
                if (this.f27697h) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                long j2 = ((long) ((i + 1) & 1073741823)) << 0;
                if (f27691b.compareAndSet(this, j, (j & (-1073741824)) | j2)) {
                    this.f27695f.set(this.f27694e & i, null);
                    return obj;
                }
                if (this.f27697h) {
                    LockFreeTaskQueue2<E> lockFreeTaskQueue2M11168d = this;
                    while (true) {
                        long j3 = lockFreeTaskQueue2M11168d._state;
                        int i5 = (int) ((j3 & 1073741823) >> 0);
                        if ((j3 & 1152921504606846976L) != 0) {
                            lockFreeTaskQueue2M11168d = lockFreeTaskQueue2M11168d.m11168d();
                        } else {
                            if (f27691b.compareAndSet(lockFreeTaskQueue2M11168d, j3, (j3 & (-1073741824)) | j2)) {
                                lockFreeTaskQueue2M11168d.f27695f.set(lockFreeTaskQueue2M11168d.f27694e & i5, null);
                                lockFreeTaskQueue2M11168d = null;
                            } else {
                                continue;
                            }
                        }
                        if (lockFreeTaskQueue2M11168d == null) {
                            return obj;
                        }
                    }
                }
            }
        }
    }
}
