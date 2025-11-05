package s.a.a;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: LockFreeLinkedList.kt */
/* loaded from: classes3.dex */
public class k {
    public static final AtomicReferenceFieldUpdater j = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_next");
    public static final AtomicReferenceFieldUpdater k = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_prev");
    public static final AtomicReferenceFieldUpdater l = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_removedRef");
    public volatile Object _next = this;
    public volatile Object _prev = this;
    public volatile Object _removedRef = null;

    /* compiled from: LockFreeLinkedList.kt */
    public static abstract class a extends d<k> {

        /* renamed from: b, reason: collision with root package name */
        public k f3828b;
        public final k c;

        public a(k kVar) {
            this.c = kVar;
        }

        @Override // s.a.a.d
        public void b(k kVar, Object obj) {
            k kVar2 = kVar;
            boolean z2 = obj == null;
            k kVar3 = z2 ? this.c : this.f3828b;
            if (kVar3 != null && k.j.compareAndSet(kVar2, this, kVar3) && z2) {
                k kVar4 = this.c;
                k kVar5 = this.f3828b;
                d0.z.d.m.checkNotNull(kVar5);
                kVar4.g(kVar5);
            }
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    public static final class b extends p {
    }

    public final boolean e(k kVar, k kVar2) {
        k.lazySet(kVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
        atomicReferenceFieldUpdater.lazySet(kVar, kVar2);
        if (!atomicReferenceFieldUpdater.compareAndSet(this, kVar2, kVar)) {
            return false;
        }
        kVar.g(kVar2);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
    
        if (s.a.a.k.j.compareAndSet(r2, r1, ((s.a.a.q) r3).a) != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final k f(p pVar) {
        while (true) {
            k kVar = (k) this._prev;
            k kVar2 = kVar;
            while (true) {
                k kVar3 = null;
                while (true) {
                    Object obj = kVar2._next;
                    if (obj == this) {
                        if (kVar == kVar2 || k.compareAndSet(this, kVar, kVar2)) {
                            return kVar2;
                        }
                    } else {
                        if (m()) {
                            return null;
                        }
                        if (obj == null) {
                            return kVar2;
                        }
                        if (obj instanceof p) {
                            ((p) obj).a(kVar2);
                            break;
                        }
                        if (!(obj instanceof q)) {
                            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                            kVar3 = kVar2;
                            kVar2 = (k) obj;
                        } else {
                            if (kVar3 != null) {
                                break;
                            }
                            kVar2 = (k) kVar2._prev;
                        }
                    }
                }
                kVar2 = kVar3;
            }
        }
    }

    public final void g(k kVar) {
        k kVar2;
        do {
            kVar2 = (k) kVar._prev;
            if (i() != kVar) {
                return;
            }
        } while (!k.compareAndSet(kVar, kVar2, this));
        if (m()) {
            kVar.f(null);
        }
    }

    public final Object i() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof p)) {
                return obj;
            }
            ((p) obj).a(this);
        }
    }

    public final k j() {
        k kVar;
        Object objI = i();
        q qVar = (q) (!(objI instanceof q) ? null : objI);
        if (qVar != null && (kVar = qVar.a) != null) {
            return kVar;
        }
        Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        return (k) objI;
    }

    public final k k() {
        k kVarF = f(null);
        if (kVarF == null) {
            Object obj = this._prev;
            while (true) {
                kVarF = (k) obj;
                if (!kVarF.m()) {
                    break;
                }
                obj = kVarF._prev;
            }
        }
        return kVarF;
    }

    public final void l() {
        k kVar = this;
        while (true) {
            Object objI = kVar.i();
            if (!(objI instanceof q)) {
                kVar.f(null);
                return;
            }
            kVar = ((q) objI).a;
        }
    }

    public boolean m() {
        return i() instanceof q;
    }

    public boolean n() {
        return o() == null;
    }

    public final k o() {
        Object objI;
        k kVar;
        q qVar;
        do {
            objI = i();
            if (objI instanceof q) {
                return ((q) objI).a;
            }
            if (objI == this) {
                return (k) objI;
            }
            Objects.requireNonNull(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            kVar = (k) objI;
            qVar = (q) kVar._removedRef;
            if (qVar == null) {
                qVar = new q(kVar);
                l.lazySet(kVar, qVar);
            }
        } while (!j.compareAndSet(this, objI, qVar));
        kVar.f(null);
        return null;
    }

    public final int p(k kVar, k kVar2, a aVar) {
        k.lazySet(kVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = j;
        atomicReferenceFieldUpdater.lazySet(kVar, kVar2);
        aVar.f3828b = kVar2;
        if (atomicReferenceFieldUpdater.compareAndSet(this, kVar2, aVar)) {
            return aVar.a(this) == null ? 1 : 2;
        }
        return 0;
    }

    public String toString() {
        return getClass().getSimpleName() + MentionUtilsKt.MENTIONS_CHAR + Integer.toHexString(System.identityHashCode(this));
    }
}
