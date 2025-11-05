package j0.l.e.o;

/* compiled from: SpscArrayQueue.java */
/* loaded from: classes3.dex */
public abstract class p<E> {
    public static final Integer o = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    public p(int i) {
        super(i);
        Math.min(i / 4, o.intValue());
    }
}
