package p637j0.p642l.p647e.p649o;

/* JADX INFO: renamed from: j0.l.e.o.i, reason: use source file name */
/* JADX INFO: compiled from: SpmcArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SpmcArrayQueue2<E> extends SpmcArrayQueue4<E> {

    /* JADX INFO: renamed from: p */
    public static final long f27339p = UnsafeAccess.m10857a(SpmcArrayQueue2.class, "consumerIndex");
    private volatile long consumerIndex;

    public SpmcArrayQueue2(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: k */
    public final boolean m10840k(long j, long j2) {
        return UnsafeAccess.f27357a.compareAndSwapLong(this, f27339p, j, j2);
    }

    /* JADX INFO: renamed from: l */
    public final long m10841l() {
        return this.consumerIndex;
    }
}
