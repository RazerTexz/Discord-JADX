package p637j0.p642l.p647e.p649o;

/* JADX INFO: renamed from: j0.l.e.o.p, reason: use source file name */
/* JADX INFO: compiled from: SpscArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SpscArrayQueue3<E> {

    /* JADX INFO: renamed from: o */
    public static final Integer f27343o = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    public SpscArrayQueue3(int i) {
        super(i);
        Math.min(i / 4, f27343o.intValue());
    }
}
