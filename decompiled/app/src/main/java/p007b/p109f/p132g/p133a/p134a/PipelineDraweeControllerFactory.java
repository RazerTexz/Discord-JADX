package p007b.p109f.p132g.p133a.p134a;

import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import java.util.concurrent.Executor;
import p007b.p109f.p115d.p119d.ImmutableList;
import p007b.p109f.p132g.p138b.DeferredReleaser;
import p007b.p109f.p161j.p168c.MemoryCache;
import p007b.p109f.p161j.p174i.DrawableFactory;
import p007b.p109f.p161j.p175j.CloseableImage;

/* JADX INFO: renamed from: b.f.g.a.a.f, reason: use source file name */
/* JADX INFO: compiled from: PipelineDraweeControllerFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class PipelineDraweeControllerFactory {

    /* JADX INFO: renamed from: a */
    public Resources f3190a;

    /* JADX INFO: renamed from: b */
    public DeferredReleaser f3191b;

    /* JADX INFO: renamed from: c */
    public DrawableFactory f3192c;

    /* JADX INFO: renamed from: d */
    public Executor f3193d;

    /* JADX INFO: renamed from: e */
    public MemoryCache<CacheKey, CloseableImage> f3194e;

    /* JADX INFO: renamed from: f */
    public ImmutableList<DrawableFactory> f3195f;

    /* JADX INFO: renamed from: g */
    public Supplier<Boolean> f3196g;
}
