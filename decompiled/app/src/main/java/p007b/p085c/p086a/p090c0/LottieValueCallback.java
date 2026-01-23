package p007b.p085c.p086a.p090c0;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: renamed from: b.c.a.c0.c, reason: use source file name */
/* JADX INFO: compiled from: LottieValueCallback.java */
/* JADX INFO: loaded from: classes.dex */
public class LottieValueCallback<T> {

    /* JADX INFO: renamed from: a */
    public final LottieFrameInfo<T> f2332a = new LottieFrameInfo<>();

    /* JADX INFO: renamed from: b */
    @Nullable
    public T f2333b;

    public LottieValueCallback(@Nullable T t) {
        this.f2333b = null;
        this.f2333b = t;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* JADX INFO: renamed from: a */
    public final T m668a(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        LottieFrameInfo<T> lottieFrameInfo = this.f2332a;
        lottieFrameInfo.f2330a = t;
        lottieFrameInfo.f2331b = t2;
        return this.f2333b;
    }
}
