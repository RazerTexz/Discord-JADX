package p007b.p109f.p161j.p168c;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import p007b.p109f.p111b.p112a.SimpleCacheKey;
import p007b.p109f.p161j.p182q.Postprocessor;

/* JADX INFO: renamed from: b.f.j.c.n, reason: use source file name */
/* JADX INFO: compiled from: DefaultCacheKeyFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class DefaultCacheKeyFactory implements CacheKeyFactory {

    /* JADX INFO: renamed from: a */
    public static DefaultCacheKeyFactory f3684a;

    /* JADX INFO: renamed from: a */
    public CacheKey m1229a(ImageRequest imageRequest, Object obj) {
        return new BitmapMemoryCacheKey(imageRequest.f19585c.toString(), imageRequest.f19592j, imageRequest.f19593k, imageRequest.f19591i, null, null, obj);
    }

    /* JADX INFO: renamed from: b */
    public CacheKey m1230b(ImageRequest imageRequest, Object obj) {
        return new SimpleCacheKey(imageRequest.f19585c.toString());
    }

    /* JADX INFO: renamed from: c */
    public CacheKey m1231c(ImageRequest imageRequest, Object obj) {
        CacheKey cacheKey;
        String name;
        Postprocessor postprocessor = imageRequest.f19601s;
        if (postprocessor != null) {
            CacheKey postprocessorCacheKey = postprocessor.getPostprocessorCacheKey();
            name = postprocessor.getClass().getName();
            cacheKey = postprocessorCacheKey;
        } else {
            cacheKey = null;
            name = null;
        }
        return new BitmapMemoryCacheKey(imageRequest.f19585c.toString(), imageRequest.f19592j, imageRequest.f19593k, imageRequest.f19591i, cacheKey, name, obj);
    }
}
