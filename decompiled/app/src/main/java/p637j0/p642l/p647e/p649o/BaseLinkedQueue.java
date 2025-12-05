package p637j0.p642l.p647e.p649o;

import p637j0.p642l.p647e.p648n.LinkedQueueNode;

/* compiled from: BaseLinkedQueue.java */
/* renamed from: j0.l.e.o.a, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class BaseLinkedQueue<E> extends BaseLinkedQueue3<E> {

    /* renamed from: k */
    public static final long f27332k = UnsafeAccess.m10857a(BaseLinkedQueue.class, "consumerNode");
    public LinkedQueueNode<E> consumerNode;

    /* renamed from: d */
    public final LinkedQueueNode<E> m10833d() {
        return (LinkedQueueNode) UnsafeAccess.f27357a.getObjectVolatile(this, f27332k);
    }
}
