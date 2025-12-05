package p637j0.p642l.p647e.p649o;

import java.util.Iterator;
import p637j0.p642l.p647e.UtilityFunctions;

/* compiled from: ConcurrentCircularArrayQueue.java */
/* renamed from: j0.l.e.o.e, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ConcurrentCircularArrayQueue<E> extends ConcurrentCircularArrayQueue2<E> {

    /* renamed from: j */
    public static final int f27334j;

    /* renamed from: k */
    public static final long f27335k;

    /* renamed from: l */
    public static final int f27336l;

    /* renamed from: m */
    public final long f27337m;

    /* renamed from: n */
    public final E[] f27338n;

    static {
        int iIntValue = Integer.getInteger("sparse.shift", 0).intValue();
        f27334j = iIntValue;
        int iArrayIndexScale = UnsafeAccess.f27357a.arrayIndexScale(Object[].class);
        if (4 == iArrayIndexScale) {
            f27336l = iIntValue + 2;
        } else {
            if (8 != iArrayIndexScale) {
                throw new IllegalStateException("Unknown pointer size");
            }
            f27336l = iIntValue + 3;
        }
        f27335k = r2.arrayBaseOffset(Object[].class) + (32 << (f27336l - iIntValue));
    }

    public ConcurrentCircularArrayQueue(int i) {
        int iM10823b = UtilityFunctions.m10823b(i);
        this.f27337m = iM10823b - 1;
        this.f27338n = (E[]) new Object[(iM10823b << f27334j) + 64];
    }

    /* renamed from: c */
    public final long m10835c(long j) {
        return f27335k + ((j & this.f27337m) << f27336l);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* renamed from: d */
    public final E m10836d(E[] eArr, long j) {
        return (E) UnsafeAccess.f27357a.getObject(eArr, j);
    }

    /* renamed from: e */
    public final E m10837e(E[] eArr, long j) {
        return (E) UnsafeAccess.f27357a.getObjectVolatile(eArr, j);
    }

    /* renamed from: g */
    public final void m10838g(E[] eArr, long j, E e) {
        UnsafeAccess.f27357a.putOrderedObject(eArr, j, e);
    }

    /* renamed from: h */
    public final void m10839h(E[] eArr, long j, E e) {
        UnsafeAccess.f27357a.putObject(eArr, j, e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
