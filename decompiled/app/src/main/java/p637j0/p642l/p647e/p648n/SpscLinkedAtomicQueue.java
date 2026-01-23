package p637j0.p642l.p647e.p648n;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: j0.l.e.n.f, reason: use source file name */
/* JADX INFO: compiled from: SpscLinkedAtomicQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SpscLinkedAtomicQueue<E> {

    /* JADX INFO: renamed from: j */
    public final AtomicReference<LinkedQueueNode<E>> f27320j;

    /* JADX INFO: renamed from: k */
    public final AtomicReference<LinkedQueueNode<E>> f27321k;

    public SpscLinkedAtomicQueue() {
        AtomicReference<LinkedQueueNode<E>> atomicReference = new AtomicReference<>();
        this.f27320j = atomicReference;
        AtomicReference<LinkedQueueNode<E>> atomicReference2 = new AtomicReference<>();
        this.f27321k = atomicReference2;
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        atomicReference.lazySet(linkedQueueNode);
        atomicReference2.lazySet(linkedQueueNode);
        linkedQueueNode.lazySet(null);
    }

    public final boolean isEmpty() {
        return this.f27321k.get() == this.f27320j.get();
    }

    public final Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    public boolean offer(E e) {
        Objects.requireNonNull(e, "null elements not allowed");
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e);
        this.f27320j.get().lazySet(linkedQueueNode);
        this.f27320j.lazySet(linkedQueueNode);
        return true;
    }

    public E peek() {
        LinkedQueueNode<E> linkedQueueNodeM10826c = this.f27321k.get().m10826c();
        if (linkedQueueNodeM10826c != null) {
            return linkedQueueNodeM10826c.m10825b();
        }
        return null;
    }

    public E poll() {
        LinkedQueueNode<E> linkedQueueNodeM10826c = this.f27321k.get().m10826c();
        if (linkedQueueNodeM10826c == null) {
            return null;
        }
        E eM10824a = linkedQueueNodeM10826c.m10824a();
        this.f27321k.lazySet(linkedQueueNodeM10826c);
        return eM10824a;
    }

    public final int size() {
        LinkedQueueNode<E> linkedQueueNodeM10826c;
        LinkedQueueNode<E> linkedQueueNode = this.f27321k.get();
        LinkedQueueNode<E> linkedQueueNode2 = this.f27320j.get();
        int i = 0;
        while (linkedQueueNode != linkedQueueNode2 && i < Integer.MAX_VALUE) {
            do {
                linkedQueueNodeM10826c = linkedQueueNode.m10826c();
            } while (linkedQueueNodeM10826c == null);
            i++;
            linkedQueueNode = linkedQueueNodeM10826c;
        }
        return i;
    }
}
