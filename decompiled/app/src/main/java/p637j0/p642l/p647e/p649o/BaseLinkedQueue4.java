package p637j0.p642l.p647e.p649o;

import p637j0.p642l.p647e.p648n.LinkedQueueNode;

/* JADX INFO: renamed from: j0.l.e.o.d, reason: use source file name */
/* JADX INFO: compiled from: BaseLinkedQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseLinkedQueue4<E> extends BaseLinkedQueue2<E> {

    /* JADX INFO: renamed from: j */
    public static final long f27333j = UnsafeAccess.m10857a(BaseLinkedQueue4.class, "producerNode");
    public LinkedQueueNode<E> producerNode;

    /* JADX INFO: renamed from: c */
    public final LinkedQueueNode<E> m10834c() {
        return (LinkedQueueNode) UnsafeAccess.f27357a.getObjectVolatile(this, f27333j);
    }
}
