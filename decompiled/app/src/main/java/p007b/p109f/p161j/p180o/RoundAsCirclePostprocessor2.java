package p007b.p109f.p161j.p180o;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.nativecode.NativeRoundingFilter;
import p007b.p109f.p111b.p112a.SimpleCacheKey;
import p007b.p109f.p161j.p182q.BasePostprocessor;

/* compiled from: RoundAsCirclePostprocessor.java */
/* renamed from: b.f.j.o.a, reason: use source file name */
/* loaded from: classes3.dex */
public class RoundAsCirclePostprocessor2 extends BasePostprocessor {
    private static final boolean ENABLE_ANTI_ALIASING = true;
    private CacheKey mCacheKey;
    private final boolean mEnableAntiAliasing;

    public RoundAsCirclePostprocessor2() {
        this(true);
    }

    @Override // p007b.p109f.p161j.p182q.BasePostprocessor, p007b.p109f.p161j.p182q.Postprocessor
    public CacheKey getPostprocessorCacheKey() {
        if (this.mCacheKey == null) {
            if (this.mEnableAntiAliasing) {
                this.mCacheKey = new SimpleCacheKey("RoundAsCirclePostprocessor#AntiAliased");
            } else {
                this.mCacheKey = new SimpleCacheKey("RoundAsCirclePostprocessor");
            }
        }
        return this.mCacheKey;
    }

    @Override // p007b.p109f.p161j.p182q.BasePostprocessor
    public void process(Bitmap bitmap) {
        NativeRoundingFilter.toCircleFast(bitmap, this.mEnableAntiAliasing);
    }

    public RoundAsCirclePostprocessor2(boolean z2) {
        this.mEnableAntiAliasing = z2;
    }
}
