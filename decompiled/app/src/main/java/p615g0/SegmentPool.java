package p615g0;

import java.util.concurrent.atomic.AtomicReference;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: g0.t, reason: use source file name */
/* JADX INFO: compiled from: SegmentPool.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SegmentPool {

    /* JADX INFO: renamed from: b */
    public static final int f26126b;

    /* JADX INFO: renamed from: c */
    public static final AtomicReference<Segment2>[] f26127c;

    /* JADX INFO: renamed from: d */
    public static final SegmentPool f26128d = new SegmentPool();

    /* JADX INFO: renamed from: a */
    public static final Segment2 f26125a = new Segment2(new byte[0], 0, 0, false, false);

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f26126b = iHighestOneBit;
        AtomicReference<Segment2>[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference<>();
        }
        f26127c = atomicReferenceArr;
    }

    /* JADX INFO: renamed from: a */
    public static final void m10498a(Segment2 segment2) {
        Intrinsics3.checkParameterIsNotNull(segment2, "segment");
        if (!(segment2.f26123f == null && segment2.f26124g == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (segment2.f26121d) {
            return;
        }
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics3.checkExpressionValueIsNotNull(threadCurrentThread, "Thread.currentThread()");
        AtomicReference<Segment2> atomicReference = f26127c[(int) (threadCurrentThread.getId() & (((long) f26126b) - 1))];
        Segment2 segment22 = atomicReference.get();
        if (segment22 == f26125a) {
            return;
        }
        int i = segment22 != null ? segment22.f26120c : 0;
        if (i >= 65536) {
            return;
        }
        segment2.f26123f = segment22;
        segment2.f26119b = 0;
        segment2.f26120c = i + 8192;
        if (atomicReference.compareAndSet(segment22, segment2)) {
            return;
        }
        segment2.f26123f = null;
    }

    /* JADX INFO: renamed from: b */
    public static final Segment2 m10499b() {
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics3.checkExpressionValueIsNotNull(threadCurrentThread, "Thread.currentThread()");
        AtomicReference<Segment2> atomicReference = f26127c[(int) (threadCurrentThread.getId() & (((long) f26126b) - 1))];
        Segment2 segment2 = f26125a;
        Segment2 andSet = atomicReference.getAndSet(segment2);
        if (andSet == segment2) {
            return new Segment2();
        }
        if (andSet == null) {
            atomicReference.set(null);
            return new Segment2();
        }
        atomicReference.set(andSet.f26123f);
        andSet.f26123f = null;
        andSet.f26120c = 0;
        return andSet;
    }
}
