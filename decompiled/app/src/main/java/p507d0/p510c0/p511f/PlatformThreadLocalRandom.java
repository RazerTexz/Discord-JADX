package p507d0.p510c0.p511f;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import p507d0.p510c0.PlatformRandom;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.c0.f.a, reason: use source file name */
/* JADX INFO: compiled from: PlatformThreadLocalRandom.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PlatformThreadLocalRandom extends PlatformRandom {
    @Override // p507d0.p510c0.PlatformRandom
    public Random getImpl() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Intrinsics3.checkNotNullExpressionValue(threadLocalRandomCurrent, "ThreadLocalRandom.current()");
        return threadLocalRandomCurrent;
    }

    @Override // p507d0.p510c0.Random
    public int nextInt(int i, int i2) {
        return ThreadLocalRandom.current().nextInt(i, i2);
    }
}
