package p007b.p109f.p132g.p133a.p134a;

import android.content.Context;
import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Set;
import p007b.p109f.p115d.p119d.Suppliers2;
import p007b.p109f.p132g.p133a.p134a.p136h.ImageOriginListener;
import p007b.p109f.p132g.p133a.p134a.p136h.ImageOriginRequestListener;
import p007b.p109f.p132g.p133a.p134a.p136h.ImagePerfDataListener;
import p007b.p109f.p148h.p158b.p159a.ControllerListener2;
import p007b.p109f.p161j.p168c.CacheKeyFactory;
import p007b.p109f.p161j.p168c.DefaultCacheKeyFactory;
import p007b.p109f.p161j.p169d.RotationOptions;
import p007b.p109f.p161j.p170e.ImagePipeline2;
import p007b.p109f.p161j.p175j.CloseableImage;
import p007b.p109f.p161j.p176k.ForwardingRequestListener;
import p007b.p109f.p161j.p176k.RequestListener;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* compiled from: PipelineDraweeControllerBuilder.java */
/* renamed from: b.f.g.a.a.d, reason: use source file name */
/* loaded from: classes.dex */
public class PipelineDraweeControllerBuilder extends AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> {

    /* renamed from: o */
    public final ImagePipeline2 f3184o;

    /* renamed from: p */
    public final PipelineDraweeControllerFactory f3185p;

    /* renamed from: q */
    public ImagePerfDataListener f3186q;

    public PipelineDraweeControllerBuilder(Context context, PipelineDraweeControllerFactory pipelineDraweeControllerFactory, ImagePipeline2 imagePipeline2, Set<ControllerListener> set, Set<ControllerListener2> set2) {
        super(context, set, set2);
        this.f3184o = imagePipeline2;
        this.f3185p = pipelineDraweeControllerFactory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: b */
    public DataSource<CloseableReference<CloseableImage>> mo1056b(DraweeController draweeController, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.EnumC10643b enumC10643b) {
        ImageRequest.EnumC10667c enumC10667c;
        ImageOriginRequestListener imageOriginRequestListener;
        ImageRequest imageRequest2 = imageRequest;
        ImagePipeline2 imagePipeline2 = this.f3184o;
        int iOrdinal = enumC10643b.ordinal();
        if (iOrdinal == 0) {
            enumC10667c = ImageRequest.EnumC10667c.FULL_FETCH;
        } else if (iOrdinal == 1) {
            enumC10667c = ImageRequest.EnumC10667c.DISK_CACHE;
        } else {
            if (iOrdinal != 2) {
                throw new RuntimeException("Cache level" + enumC10643b + "is not supported. ");
            }
            enumC10667c = ImageRequest.EnumC10667c.BITMAP_MEMORY_CACHE;
        }
        ImageRequest.EnumC10667c enumC10667c2 = enumC10667c;
        if (draweeController instanceof PipelineDraweeController) {
            PipelineDraweeController pipelineDraweeController = (PipelineDraweeController) draweeController;
            synchronized (pipelineDraweeController) {
                ImageOriginListener imageOriginListener = pipelineDraweeController.f3176G;
                imageOriginRequestListener = imageOriginListener != null ? new ImageOriginRequestListener(pipelineDraweeController.f19463m, imageOriginListener) : null;
                Set<RequestListener> set = pipelineDraweeController.f3175F;
                if (set != null) {
                    ForwardingRequestListener forwardingRequestListener = new ForwardingRequestListener(set);
                    if (imageOriginRequestListener != null) {
                        forwardingRequestListener.f3913a.add(imageOriginRequestListener);
                    }
                    imageOriginRequestListener = forwardingRequestListener;
                } else {
                    imageOriginRequestListener = imageOriginRequestListener;
                }
            }
        } else {
            imageOriginRequestListener = imageOriginRequestListener;
        }
        return imagePipeline2.m1262a(imageRequest2, obj, enumC10667c2, imageOriginRequestListener, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    /* renamed from: d */
    public AbstractDraweeController mo1057d() {
        PipelineDraweeController pipelineDraweeController;
        CacheKey cacheKey;
        CacheKey cacheKeyM1229a;
        FrescoSystrace.m1527b();
        try {
            DraweeController draweeController = this.f19490n;
            String strValueOf = String.valueOf(AbstractDraweeControllerBuilder.f19479c.getAndIncrement());
            if (draweeController instanceof PipelineDraweeController) {
                pipelineDraweeController = (PipelineDraweeController) draweeController;
            } else {
                PipelineDraweeControllerFactory pipelineDraweeControllerFactory = this.f3185p;
                PipelineDraweeController pipelineDraweeController2 = new PipelineDraweeController(pipelineDraweeControllerFactory.f3190a, pipelineDraweeControllerFactory.f3191b, pipelineDraweeControllerFactory.f3192c, pipelineDraweeControllerFactory.f3193d, pipelineDraweeControllerFactory.f3194e, pipelineDraweeControllerFactory.f3195f);
                Supplier<Boolean> supplier = pipelineDraweeControllerFactory.f3196g;
                if (supplier != null) {
                    pipelineDraweeController2.f3172C = supplier.get().booleanValue();
                }
                pipelineDraweeController = pipelineDraweeController2;
            }
            Supplier<DataSource<CloseableReference<CloseableImage>>> supplierM8669e = m8669e(pipelineDraweeController, strValueOf);
            ImageRequest imageRequest = (ImageRequest) this.f19484h;
            CacheKeyFactory cacheKeyFactory = this.f3184o.f3739g;
            if (cacheKeyFactory == null || imageRequest == null) {
                cacheKey = null;
            } else {
                if (imageRequest.f19601s != null) {
                    cacheKeyM1229a = ((DefaultCacheKeyFactory) cacheKeyFactory).m1231c(imageRequest, this.f19483g);
                } else {
                    cacheKeyM1229a = ((DefaultCacheKeyFactory) cacheKeyFactory).m1229a(imageRequest, this.f19483g);
                }
                cacheKey = cacheKeyM1229a;
            }
            pipelineDraweeController.m1040H(supplierM8669e, strValueOf, cacheKey, this.f19483g, null, null);
            pipelineDraweeController.m1041I(this.f3186q, this, Suppliers2.f3101a);
            return pipelineDraweeController;
        } finally {
            FrescoSystrace.m1527b();
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    /* renamed from: f */
    public PipelineDraweeControllerBuilder m1058f(Uri uri) {
        if (uri == null) {
            this.f19484h = null;
            return this;
        }
        ImageRequestBuilder imageRequestBuilderM8723b = ImageRequestBuilder.m8723b(uri);
        imageRequestBuilderM8723b.f19616e = RotationOptions.f3722b;
        this.f19484h = imageRequestBuilderM8723b.m8724a();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    public PipelineDraweeControllerBuilder m1059g(String str) {
        Uri uri;
        if (str != null && !str.isEmpty()) {
            return m1058f(Uri.parse(str));
        }
        REQUEST requestM8724a = 0;
        requestM8724a = 0;
        requestM8724a = 0;
        if (str != null && str.length() != 0 && (uri = Uri.parse(str)) != null) {
            requestM8724a = ImageRequestBuilder.m8723b(uri).m8724a();
        }
        this.f19484h = requestM8724a;
        return this;
    }
}
