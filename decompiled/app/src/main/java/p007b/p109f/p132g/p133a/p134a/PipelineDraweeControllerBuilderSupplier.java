package p007b.p109f.p132g.p133a.p134a;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p117b.UiThreadImmediateExecutorService;
import p007b.p109f.p132g.p138b.DeferredReleaser;
import p007b.p109f.p132g.p138b.DeferredReleaserConcurrentImpl;
import p007b.p109f.p161j.p162a.p164b.AnimatedFactory;
import p007b.p109f.p161j.p168c.MemoryCache;
import p007b.p109f.p161j.p170e.ImagePipeline2;
import p007b.p109f.p161j.p170e.ImagePipelineFactory;
import p007b.p109f.p161j.p174i.DrawableFactory;
import p007b.p109f.p161j.p175j.CloseableImage;

/* compiled from: PipelineDraweeControllerBuilderSupplier.java */
/* renamed from: b.f.g.a.a.e, reason: use source file name */
/* loaded from: classes.dex */
public class PipelineDraweeControllerBuilderSupplier implements Supplier<PipelineDraweeControllerBuilder> {

    /* renamed from: a */
    public final Context f3187a;

    /* renamed from: b */
    public final ImagePipeline2 f3188b;

    /* renamed from: c */
    public final PipelineDraweeControllerFactory f3189c;

    public PipelineDraweeControllerBuilderSupplier(Context context) {
        DeferredReleaser deferredReleaser;
        ImagePipelineFactory imagePipelineFactory = ImagePipelineFactory.f3788a;
        AnimatableValueParser.m591y(imagePipelineFactory, "ImagePipelineFactory was not initialized!");
        this.f3187a = context;
        if (imagePipelineFactory.f3799l == null) {
            imagePipelineFactory.f3799l = imagePipelineFactory.m1295a();
        }
        ImagePipeline2 imagePipeline2 = imagePipelineFactory.f3799l;
        this.f3188b = imagePipeline2;
        PipelineDraweeControllerFactory pipelineDraweeControllerFactory = new PipelineDraweeControllerFactory();
        this.f3189c = pipelineDraweeControllerFactory;
        Resources resources = context.getResources();
        synchronized (DeferredReleaser.class) {
            if (DeferredReleaser.f3253a == null) {
                DeferredReleaser.f3253a = new DeferredReleaserConcurrentImpl();
            }
            deferredReleaser = DeferredReleaser.f3253a;
        }
        AnimatedFactory animatedFactoryM1296b = imagePipelineFactory.m1296b();
        DrawableFactory drawableFactoryMo1189a = animatedFactoryM1296b == null ? null : animatedFactoryM1296b.mo1189a(context);
        if (UiThreadImmediateExecutorService.f3090k == null) {
            UiThreadImmediateExecutorService.f3090k = new UiThreadImmediateExecutorService();
        }
        UiThreadImmediateExecutorService uiThreadImmediateExecutorService = UiThreadImmediateExecutorService.f3090k;
        MemoryCache<CacheKey, CloseableImage> memoryCache = imagePipeline2.f3737e;
        pipelineDraweeControllerFactory.f3190a = resources;
        pipelineDraweeControllerFactory.f3191b = deferredReleaser;
        pipelineDraweeControllerFactory.f3192c = drawableFactoryMo1189a;
        pipelineDraweeControllerFactory.f3193d = uiThreadImmediateExecutorService;
        pipelineDraweeControllerFactory.f3194e = memoryCache;
        pipelineDraweeControllerFactory.f3195f = null;
        pipelineDraweeControllerFactory.f3196g = null;
    }

    /* renamed from: a */
    public PipelineDraweeControllerBuilder m1060a() {
        PipelineDraweeControllerBuilder pipelineDraweeControllerBuilder = new PipelineDraweeControllerBuilder(this.f3187a, this.f3189c, this.f3188b, null, null);
        pipelineDraweeControllerBuilder.f3186q = null;
        return pipelineDraweeControllerBuilder;
    }

    @Override // com.facebook.common.internal.Supplier
    public /* bridge */ /* synthetic */ PipelineDraweeControllerBuilder get() {
        return m1060a();
    }
}
