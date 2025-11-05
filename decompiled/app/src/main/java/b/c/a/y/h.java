package b.c.a.y;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;

/* compiled from: LottieCompositionCache.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class h {
    public static final h a = new h();

    /* renamed from: b, reason: collision with root package name */
    public final LruCache<String, b.c.a.d> f409b = new LruCache<>(20);

    @VisibleForTesting
    public h() {
    }
}
