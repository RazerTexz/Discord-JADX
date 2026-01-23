package p007b.p085c.p086a.p095y;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;
import p007b.p085c.p086a.LottieComposition;

/* JADX INFO: renamed from: b.c.a.y.h, reason: use source file name */
/* JADX INFO: compiled from: LottieCompositionCache.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class LottieCompositionCache {

    /* JADX INFO: renamed from: a */
    public static final LottieCompositionCache f2715a = new LottieCompositionCache();

    /* JADX INFO: renamed from: b */
    public final LruCache<String, LottieComposition> f2716b = new LruCache<>(20);

    @VisibleForTesting
    public LottieCompositionCache() {
    }
}
