package j0.l.e.o;

/* compiled from: BaseLinkedQueue.java */
/* loaded from: classes3.dex */
public abstract class d<E> extends b<E> {
    public static final long j = y.a(d.class, "producerNode");
    public j0.l.e.n.b<E> producerNode;

    public final j0.l.e.n.b<E> c() {
        return (j0.l.e.n.b) y.a.getObjectVolatile(this, j);
    }
}
