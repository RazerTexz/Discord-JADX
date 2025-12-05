package p007b.p085c.p086a;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: LottieResult.java */
/* renamed from: b.c.a.p, reason: use source file name */
/* loaded from: classes.dex */
public final class LottieResult<V> {

    /* renamed from: a */
    @Nullable
    public final V f2449a;

    /* renamed from: b */
    @Nullable
    public final Throwable f2450b;

    public LottieResult(V v) {
        this.f2449a = v;
        this.f2450b = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LottieResult)) {
            return false;
        }
        LottieResult lottieResult = (LottieResult) obj;
        V v = this.f2449a;
        if (v != null && v.equals(lottieResult.f2449a)) {
            return true;
        }
        Throwable th = this.f2450b;
        if (th == null || lottieResult.f2450b == null) {
            return false;
        }
        return th.toString().equals(this.f2450b.toString());
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2449a, this.f2450b});
    }

    public LottieResult(Throwable th) {
        this.f2450b = th;
        this.f2449a = null;
    }
}
