package p637j0.p642l.p647e.p649o;

/* compiled from: SpmcArrayQueue.java */
/* renamed from: j0.l.e.o.l, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class SpmcArrayQueue5<E> extends SpmcArrayQueue3<E> {

    /* renamed from: o */
    public static final long f27340o = UnsafeAccess.m10857a(SpmcArrayQueue5.class, "producerIndex");
    private volatile long producerIndex;

    public SpmcArrayQueue5(int i) {
        super(i);
    }

    /* renamed from: i */
    public final long m10842i() {
        return this.producerIndex;
    }

    /* renamed from: j */
    public final void m10843j(long j) {
        UnsafeAccess.f27357a.putOrderedLong(this, f27340o, j);
    }
}
