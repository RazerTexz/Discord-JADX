package p659s.p660a.p661a;

import com.discord.widgets.chat.input.MentionUtils;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: s.a.a.k, reason: use source file name */
/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes3.dex */
public class LockFreeLinkedList3 {

    /* JADX INFO: renamed from: j */
    public static final AtomicReferenceFieldUpdater f27684j = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedList3.class, Object.class, "_next");

    /* JADX INFO: renamed from: k */
    public static final AtomicReferenceFieldUpdater f27685k = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedList3.class, Object.class, "_prev");

    /* JADX INFO: renamed from: l */
    public static final AtomicReferenceFieldUpdater f27686l = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedList3.class, Object.class, "_removedRef");
    public volatile Object _next = this;
    public volatile Object _prev = this;
    public volatile Object _removedRef = null;

    /* JADX INFO: renamed from: s.a.a.k$a */
    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    public static abstract class a extends Atomic2<LockFreeLinkedList3> {

        /* JADX INFO: renamed from: b */
        public LockFreeLinkedList3 f27687b;

        /* JADX INFO: renamed from: c */
        public final LockFreeLinkedList3 f27688c;

        public a(LockFreeLinkedList3 lockFreeLinkedList3) {
            this.f27688c = lockFreeLinkedList3;
        }

        @Override // p659s.p660a.p661a.Atomic2
        /* JADX INFO: renamed from: b */
        public void mo11143b(LockFreeLinkedList3 lockFreeLinkedList3, Object obj) {
            LockFreeLinkedList3 lockFreeLinkedList32 = lockFreeLinkedList3;
            boolean z2 = obj == null;
            LockFreeLinkedList3 lockFreeLinkedList33 = z2 ? this.f27688c : this.f27687b;
            if (lockFreeLinkedList33 != null && LockFreeLinkedList3.f27684j.compareAndSet(lockFreeLinkedList32, this, lockFreeLinkedList33) && z2) {
                LockFreeLinkedList3 lockFreeLinkedList34 = this.f27688c;
                LockFreeLinkedList3 lockFreeLinkedList35 = this.f27687b;
                Intrinsics3.checkNotNull(lockFreeLinkedList35);
                lockFreeLinkedList34.m11154g(lockFreeLinkedList35);
            }
        }
    }

    /* JADX INFO: renamed from: s.a.a.k$b */
    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    public static final class b extends Atomic3 {
    }

    /* JADX INFO: renamed from: e */
    public final boolean m11152e(LockFreeLinkedList3 lockFreeLinkedList3, LockFreeLinkedList3 lockFreeLinkedList32) {
        f27685k.lazySet(lockFreeLinkedList3, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f27684j;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedList3, lockFreeLinkedList32);
        if (!atomicReferenceFieldUpdater.compareAndSet(this, lockFreeLinkedList32, lockFreeLinkedList3)) {
            return false;
        }
        lockFreeLinkedList3.m11154g(lockFreeLinkedList32);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
    
        if (p659s.p660a.p661a.LockFreeLinkedList3.f27684j.compareAndSet(r2, r1, ((p659s.p660a.p661a.LockFreeLinkedList4) r3).f27701a) != false) goto L26;
     */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final LockFreeLinkedList3 m11153f(Atomic3 atomic3) {
        while (true) {
            LockFreeLinkedList3 lockFreeLinkedList3 = (LockFreeLinkedList3) this._prev;
            LockFreeLinkedList3 lockFreeLinkedList32 = lockFreeLinkedList3;
            while (true) {
                LockFreeLinkedList3 lockFreeLinkedList33 = null;
                while (true) {
                    Object obj = lockFreeLinkedList32._next;
                    if (obj == this) {
                        if (lockFreeLinkedList3 == lockFreeLinkedList32 || f27685k.compareAndSet(this, lockFreeLinkedList3, lockFreeLinkedList32)) {
                            return lockFreeLinkedList32;
                        }
                    } else {
                        if (mo11150m()) {
                            return null;
                        }
                        if (obj == null) {
                            return lockFreeLinkedList32;
                        }
                        if (obj instanceof Atomic3) {
                            ((Atomic3) obj).mo11142a(lockFreeLinkedList32);
                            break;
                        }
                        if (!(obj instanceof LockFreeLinkedList4)) {
                            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                            lockFreeLinkedList33 = lockFreeLinkedList32;
                            lockFreeLinkedList32 = (LockFreeLinkedList3) obj;
                        } else {
                            if (lockFreeLinkedList33 != null) {
                                break;
                            }
                            lockFreeLinkedList32 = (LockFreeLinkedList3) lockFreeLinkedList32._prev;
                        }
                    }
                }
                lockFreeLinkedList32 = lockFreeLinkedList33;
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m11154g(LockFreeLinkedList3 lockFreeLinkedList3) {
        LockFreeLinkedList3 lockFreeLinkedList32;
        do {
            lockFreeLinkedList32 = (LockFreeLinkedList3) lockFreeLinkedList3._prev;
            if (m11155i() != lockFreeLinkedList3) {
                return;
            }
        } while (!f27685k.compareAndSet(lockFreeLinkedList3, lockFreeLinkedList32, this));
        if (mo11150m()) {
            lockFreeLinkedList3.m11153f(null);
        }
    }

    /* JADX INFO: renamed from: i */
    public final Object m11155i() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof Atomic3)) {
                return obj;
            }
            ((Atomic3) obj).mo11142a(this);
        }
    }

    /* JADX INFO: renamed from: j */
    public final LockFreeLinkedList3 m11156j() {
        LockFreeLinkedList3 lockFreeLinkedList3;
        Object objM11155i = m11155i();
        LockFreeLinkedList4 lockFreeLinkedList4 = (LockFreeLinkedList4) (!(objM11155i instanceof LockFreeLinkedList4) ? null : objM11155i);
        if (lockFreeLinkedList4 != null && (lockFreeLinkedList3 = lockFreeLinkedList4.f27701a) != null) {
            return lockFreeLinkedList3;
        }
        Objects.requireNonNull(objM11155i, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        return (LockFreeLinkedList3) objM11155i;
    }

    /* JADX INFO: renamed from: k */
    public final LockFreeLinkedList3 m11157k() {
        LockFreeLinkedList3 lockFreeLinkedList3M11153f = m11153f(null);
        if (lockFreeLinkedList3M11153f == null) {
            Object obj = this._prev;
            while (true) {
                lockFreeLinkedList3M11153f = (LockFreeLinkedList3) obj;
                if (!lockFreeLinkedList3M11153f.mo11150m()) {
                    break;
                }
                obj = lockFreeLinkedList3M11153f._prev;
            }
        }
        return lockFreeLinkedList3M11153f;
    }

    /* JADX INFO: renamed from: l */
    public final void m11158l() {
        LockFreeLinkedList3 lockFreeLinkedList3 = this;
        while (true) {
            Object objM11155i = lockFreeLinkedList3.m11155i();
            if (!(objM11155i instanceof LockFreeLinkedList4)) {
                lockFreeLinkedList3.m11153f(null);
                return;
            }
            lockFreeLinkedList3 = ((LockFreeLinkedList4) objM11155i).f27701a;
        }
    }

    /* JADX INFO: renamed from: m */
    public boolean mo11150m() {
        return m11155i() instanceof LockFreeLinkedList4;
    }

    /* JADX INFO: renamed from: n */
    public boolean mo11151n() {
        return m11159o() == null;
    }

    /* JADX INFO: renamed from: o */
    public final LockFreeLinkedList3 m11159o() {
        Object objM11155i;
        LockFreeLinkedList3 lockFreeLinkedList3;
        LockFreeLinkedList4 lockFreeLinkedList4;
        do {
            objM11155i = m11155i();
            if (objM11155i instanceof LockFreeLinkedList4) {
                return ((LockFreeLinkedList4) objM11155i).f27701a;
            }
            if (objM11155i == this) {
                return (LockFreeLinkedList3) objM11155i;
            }
            Objects.requireNonNull(objM11155i, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            lockFreeLinkedList3 = (LockFreeLinkedList3) objM11155i;
            lockFreeLinkedList4 = (LockFreeLinkedList4) lockFreeLinkedList3._removedRef;
            if (lockFreeLinkedList4 == null) {
                lockFreeLinkedList4 = new LockFreeLinkedList4(lockFreeLinkedList3);
                f27686l.lazySet(lockFreeLinkedList3, lockFreeLinkedList4);
            }
        } while (!f27684j.compareAndSet(this, objM11155i, lockFreeLinkedList4));
        lockFreeLinkedList3.m11153f(null);
        return null;
    }

    /* JADX INFO: renamed from: p */
    public final int m11160p(LockFreeLinkedList3 lockFreeLinkedList3, LockFreeLinkedList3 lockFreeLinkedList32, a aVar) {
        f27685k.lazySet(lockFreeLinkedList3, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f27684j;
        atomicReferenceFieldUpdater.lazySet(lockFreeLinkedList3, lockFreeLinkedList32);
        aVar.f27687b = lockFreeLinkedList32;
        if (atomicReferenceFieldUpdater.compareAndSet(this, lockFreeLinkedList32, aVar)) {
            return aVar.mo11142a(this) == null ? 1 : 2;
        }
        return 0;
    }

    public String toString() {
        return getClass().getSimpleName() + MentionUtils.MENTIONS_CHAR + Integer.toHexString(System.identityHashCode(this));
    }
}
