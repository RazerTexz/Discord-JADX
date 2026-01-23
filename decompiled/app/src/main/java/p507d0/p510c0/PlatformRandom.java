package p507d0.p510c0;

import java.util.Random;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.c0.a, reason: use source file name */
/* JADX INFO: compiled from: PlatformRandom.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PlatformRandom extends Random {
    public abstract Random getImpl();

    @Override // p507d0.p510c0.Random
    public int nextBits(int i) {
        return Random2.takeUpperBits(getImpl().nextInt(), i);
    }

    @Override // p507d0.p510c0.Random
    public byte[] nextBytes(byte[] bArr) {
        Intrinsics3.checkNotNullParameter(bArr, "array");
        getImpl().nextBytes(bArr);
        return bArr;
    }

    @Override // p507d0.p510c0.Random
    public int nextInt() {
        return getImpl().nextInt();
    }

    @Override // p507d0.p510c0.Random
    public long nextLong() {
        return getImpl().nextLong();
    }

    @Override // p507d0.p510c0.Random
    public int nextInt(int i) {
        return getImpl().nextInt(i);
    }
}
