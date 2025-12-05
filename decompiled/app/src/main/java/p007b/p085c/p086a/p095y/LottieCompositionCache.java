package p007b.p085c.p086a.p095y;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import p007b.p085c.p086a.LottieComposition;

/* compiled from: LottieCompositionCache.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: b.c.a.y.h, reason: use source file name */
/* loaded from: classes.dex */
public class LottieCompositionCache {

    /* renamed from: a */
    public static final LottieCompositionCache f2715a = new LottieCompositionCache();

    /* renamed from: b */
    public final LruCache<String, LottieComposition> f2716b = new LruCache<>(20);

    @VisibleForTesting
    public LottieCompositionCache() {
    }
}
