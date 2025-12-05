package p637j0.p642l.p647e.p648n;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: LinkedQueueNode.java */
/* renamed from: j0.l.e.n.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
    private static final long serialVersionUID = 2404266111789071508L;
    private E value;

    public LinkedQueueNode() {
    }

    /* renamed from: a */
    public E m10824a() {
        E e = this.value;
        this.value = null;
        return e;
    }

    /* renamed from: b */
    public E m10825b() {
        return this.value;
    }

    /* renamed from: c */
    public LinkedQueueNode<E> m10826c() {
        return get();
    }

    public LinkedQueueNode(E e) {
        this.value = e;
    }
}
