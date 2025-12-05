package p637j0.p642l.p647e.p649o;

import java.util.Iterator;
import java.util.Objects;
import p637j0.p642l.p647e.p648n.LinkedQueueNode;

/* compiled from: SpscLinkedQueue.java */
/* renamed from: j0.l.e.o.s, reason: use source file name */
/* loaded from: classes3.dex */
public final class SpscLinkedQueue<E> {
    public SpscLinkedQueue() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        this.producerNode = linkedQueueNode;
        this.consumerNode = linkedQueueNode;
        linkedQueueNode.lazySet(null);
    }

    public final boolean isEmpty() {
        return m10833d() == m10834c();
    }

    public final Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    public boolean offer(E e) {
        Objects.requireNonNull(e, "null elements not allowed");
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e);
        this.producerNode.lazySet(linkedQueueNode);
        this.producerNode = linkedQueueNode;
        return true;
    }

    public E peek() {
        LinkedQueueNode<E> linkedQueueNodeM10826c = this.consumerNode.m10826c();
        if (linkedQueueNodeM10826c != null) {
            return linkedQueueNodeM10826c.m10825b();
        }
        return null;
    }

    public E poll() {
        LinkedQueueNode<E> linkedQueueNodeM10826c = this.consumerNode.m10826c();
        if (linkedQueueNodeM10826c == null) {
            return null;
        }
        E eM10824a = linkedQueueNodeM10826c.m10824a();
        this.consumerNode = linkedQueueNodeM10826c;
        return eM10824a;
    }

    public final int size() {
        LinkedQueueNode<E> linkedQueueNodeM10826c;
        LinkedQueueNode<E> linkedQueueNodeM10833d = m10833d();
        LinkedQueueNode<E> linkedQueueNodeM10834c = m10834c();
        int i = 0;
        while (linkedQueueNodeM10833d != linkedQueueNodeM10834c && i < Integer.MAX_VALUE) {
            do {
                linkedQueueNodeM10826c = linkedQueueNodeM10833d.m10826c();
            } while (linkedQueueNodeM10826c == null);
            i++;
            linkedQueueNodeM10833d = linkedQueueNodeM10826c;
        }
        return i;
    }
}
