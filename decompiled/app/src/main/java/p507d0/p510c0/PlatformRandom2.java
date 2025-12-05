package p507d0.p510c0;

import java.util.Random;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: PlatformRandom.kt */
/* renamed from: d0.c0.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class PlatformRandom2 extends PlatformRandom {

    /* renamed from: l */
    public final a f22270l = new a();

    /* compiled from: PlatformRandom.kt */
    /* renamed from: d0.c0.b$a */
    public static final class a extends ThreadLocal<Random> {
        @Override // java.lang.ThreadLocal
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // p507d0.p510c0.PlatformRandom
    public Random getImpl() {
        Random random = this.f22270l.get();
        Intrinsics3.checkNotNullExpressionValue(random, "implStorage.get()");
        return random;
    }
}
