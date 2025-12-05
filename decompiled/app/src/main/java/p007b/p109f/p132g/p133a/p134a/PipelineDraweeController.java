package p007b.p109f.p132g.p133a.p134a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.core.os.EnvironmentCompat;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.AwakeTimeSinceBootClock;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p119d.ImmutableList;
import p007b.p109f.p115d.p119d.Objects2;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p130f.p131a.DrawableWithCaches;
import p007b.p109f.p132g.p133a.p134a.p135g.DebugOverlayImageOriginColor;
import p007b.p109f.p132g.p133a.p134a.p135g.DebugOverlayImageOriginListener;
import p007b.p109f.p132g.p133a.p134a.p136h.ForwardingImageOriginListener;
import p007b.p109f.p132g.p133a.p134a.p136h.ImageOriginListener;
import p007b.p109f.p132g.p133a.p134a.p136h.ImagePerfDataListener;
import p007b.p109f.p132g.p133a.p134a.p136h.ImagePerfMonitor;
import p007b.p109f.p132g.p133a.p134a.p136h.ImagePerfState;
import p007b.p109f.p132g.p138b.DeferredReleaser;
import p007b.p109f.p132g.p140d.DebugControllerOverlayDrawable;
import p007b.p109f.p132g.p140d.p141b.ImageLoadingTimeControllerListener;
import p007b.p109f.p132g.p142e.ScaleTypeDrawable;
import p007b.p109f.p132g.p145h.SettableDraweeHierarchy;
import p007b.p109f.p161j.p168c.MemoryCache;
import p007b.p109f.p161j.p174i.DrawableFactory;
import p007b.p109f.p161j.p175j.CloseableImage;
import p007b.p109f.p161j.p175j.ImmutableQualityInfo;
import p007b.p109f.p161j.p176k.RequestListener;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* compiled from: PipelineDraweeController.java */
/* renamed from: b.f.g.a.a.c, reason: use source file name */
/* loaded from: classes.dex */
public class PipelineDraweeController extends AbstractDraweeController<CloseableReference<CloseableImage>, ImageInfo> {

    /* renamed from: A */
    public CacheKey f3170A;

    /* renamed from: B */
    public Supplier<DataSource<CloseableReference<CloseableImage>>> f3171B;

    /* renamed from: C */
    public boolean f3172C;

    /* renamed from: D */
    public ImmutableList<DrawableFactory> f3173D;

    /* renamed from: E */
    public ImagePerfMonitor f3174E;

    /* renamed from: F */
    public Set<RequestListener> f3175F;

    /* renamed from: G */
    public ImageOriginListener f3176G;

    /* renamed from: H */
    public DebugOverlayImageOriginListener f3177H;

    /* renamed from: I */
    public ImageRequest f3178I;

    /* renamed from: J */
    public ImageRequest[] f3179J;

    /* renamed from: K */
    public ImageRequest f3180K;

    /* renamed from: x */
    public final DrawableFactory f3181x;

    /* renamed from: y */
    public final ImmutableList<DrawableFactory> f3182y;

    /* renamed from: z */
    public final MemoryCache<CacheKey, CloseableImage> f3183z;

    public PipelineDraweeController(Resources resources, DeferredReleaser deferredReleaser, DrawableFactory drawableFactory, Executor executor, MemoryCache<CacheKey, CloseableImage> memoryCache, ImmutableList<DrawableFactory> immutableList) {
        super(deferredReleaser, executor, null, null);
        this.f3181x = new DefaultDrawableFactory(resources, drawableFactory);
        this.f3182y = immutableList;
        this.f3183z = memoryCache;
    }

    /* renamed from: F */
    public synchronized void m1038F(ImageOriginListener imageOriginListener) {
        ImageOriginListener imageOriginListener2 = this.f3176G;
        if (imageOriginListener2 instanceof ForwardingImageOriginListener) {
            ForwardingImageOriginListener forwardingImageOriginListener = (ForwardingImageOriginListener) imageOriginListener2;
            synchronized (forwardingImageOriginListener) {
                forwardingImageOriginListener.f3199a.add(imageOriginListener);
            }
        } else if (imageOriginListener2 != null) {
            this.f3176G = new ForwardingImageOriginListener(imageOriginListener2, imageOriginListener);
        } else {
            this.f3176G = imageOriginListener;
        }
    }

    /* renamed from: G */
    public synchronized void m1039G(RequestListener requestListener) {
        if (this.f3175F == null) {
            this.f3175F = new HashSet();
        }
        this.f3175F.add(requestListener);
    }

    /* renamed from: H */
    public void m1040H(Supplier<DataSource<CloseableReference<CloseableImage>>> supplier, String str, CacheKey cacheKey, Object obj, ImmutableList<DrawableFactory> immutableList, ImageOriginListener imageOriginListener) {
        FrescoSystrace.m1527b();
        m8658n(str, obj);
        this.f19472v = false;
        this.f3171B = supplier;
        m1043K(null);
        this.f3170A = cacheKey;
        this.f3173D = null;
        synchronized (this) {
            this.f3176G = null;
        }
        m1043K(null);
        m1038F(null);
        FrescoSystrace.m1527b();
    }

    /* renamed from: I */
    public synchronized void m1041I(ImagePerfDataListener imagePerfDataListener, AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> abstractDraweeControllerBuilder, Supplier<Boolean> supplier) {
        ImagePerfMonitor imagePerfMonitor = this.f3174E;
        if (imagePerfMonitor != null) {
            List<ImagePerfDataListener> list = imagePerfMonitor.f3213j;
            if (list != null) {
                list.clear();
            }
            imagePerfMonitor.m1067c(false);
            imagePerfMonitor.f3206c.m1068a();
        }
        if (imagePerfDataListener != null) {
            if (this.f3174E == null) {
                this.f3174E = new ImagePerfMonitor(AwakeTimeSinceBootClock.get(), this, supplier);
            }
            ImagePerfMonitor imagePerfMonitor2 = this.f3174E;
            Objects.requireNonNull(imagePerfMonitor2);
            if (imagePerfMonitor2.f3213j == null) {
                imagePerfMonitor2.f3213j = new CopyOnWriteArrayList();
            }
            imagePerfMonitor2.f3213j.add(imagePerfDataListener);
            this.f3174E.m1067c(true);
            ImagePerfState imagePerfState = this.f3174E.f3206c;
            ImageRequest imageRequest = abstractDraweeControllerBuilder.f19484h;
            ImageRequest[] imageRequestArr = abstractDraweeControllerBuilder.f19485i;
            imagePerfState.f3221f = imageRequest;
            imagePerfState.f3222g = null;
            imagePerfState.f3223h = imageRequestArr;
        }
        this.f3178I = abstractDraweeControllerBuilder.f19484h;
        this.f3179J = abstractDraweeControllerBuilder.f19485i;
        this.f3180K = null;
    }

    /* renamed from: J */
    public final Drawable m1042J(ImmutableList<DrawableFactory> immutableList, CloseableImage closeableImage) {
        Drawable drawableMo1036b;
        if (immutableList == null) {
            return null;
        }
        for (DrawableFactory drawableFactory : immutableList) {
            if (drawableFactory.mo1035a(closeableImage) && (drawableMo1036b = drawableFactory.mo1036b(closeableImage)) != null) {
                return drawableMo1036b;
            }
        }
        return null;
    }

    /* renamed from: K */
    public final void m1043K(CloseableImage closeableImage) {
        String str;
        ScaleTypeDrawable scaleTypeDrawableM556p0;
        if (this.f3172C) {
            if (this.f19462l == null) {
                DebugControllerOverlayDrawable debugControllerOverlayDrawable = new DebugControllerOverlayDrawable();
                ImageLoadingTimeControllerListener imageLoadingTimeControllerListener = new ImageLoadingTimeControllerListener(debugControllerOverlayDrawable);
                this.f3177H = new DebugOverlayImageOriginListener();
                m8656f(imageLoadingTimeControllerListener);
                this.f19462l = debugControllerOverlayDrawable;
                SettableDraweeHierarchy settableDraweeHierarchy = this.f19461k;
                if (settableDraweeHierarchy != null) {
                    settableDraweeHierarchy.mo1131a(debugControllerOverlayDrawable);
                }
            }
            if (this.f3176G == null) {
                m1038F(this.f3177H);
            }
            Drawable drawable = this.f19462l;
            if (drawable instanceof DebugControllerOverlayDrawable) {
                DebugControllerOverlayDrawable debugControllerOverlayDrawable2 = (DebugControllerOverlayDrawable) drawable;
                String str2 = this.f19463m;
                if (str2 == null) {
                    str2 = "none";
                }
                debugControllerOverlayDrawable2.f3303j = str2;
                debugControllerOverlayDrawable2.invalidateSelf();
                SettableDraweeHierarchy settableDraweeHierarchy2 = this.f19461k;
                ScalingUtils$ScaleType scalingUtils$ScaleType = null;
                if (settableDraweeHierarchy2 != null && (scaleTypeDrawableM556p0 = AnimatableValueParser.m556p0(settableDraweeHierarchy2.mo8670e())) != null) {
                    scalingUtils$ScaleType = scaleTypeDrawableM556p0.f3435n;
                }
                debugControllerOverlayDrawable2.f3307n = scalingUtils$ScaleType;
                int i = this.f3177H.f3198a;
                switch (i) {
                    case 2:
                        str = "network";
                        break;
                    case 3:
                        str = "disk";
                        break;
                    case 4:
                        str = "memory_encoded";
                        break;
                    case 5:
                        str = "memory_bitmap";
                        break;
                    case 6:
                        str = "memory_bitmap_shortcut";
                        break;
                    case 7:
                        str = "local";
                        break;
                    default:
                        str = EnvironmentCompat.MEDIA_UNKNOWN;
                        break;
                }
                int i2 = DebugOverlayImageOriginColor.f3197a.get(i, -1);
                debugControllerOverlayDrawable2.f3301C = str;
                debugControllerOverlayDrawable2.f3302D = i2;
                debugControllerOverlayDrawable2.invalidateSelf();
                if (closeableImage == null) {
                    debugControllerOverlayDrawable2.m1089c();
                    return;
                }
                int width = closeableImage.getWidth();
                int height = closeableImage.getHeight();
                debugControllerOverlayDrawable2.f3304k = width;
                debugControllerOverlayDrawable2.f3305l = height;
                debugControllerOverlayDrawable2.invalidateSelf();
                debugControllerOverlayDrawable2.f3306m = closeableImage.mo1330c();
            }
        }
    }

    /* renamed from: L */
    public synchronized void m1044L(RequestListener requestListener) {
        Set<RequestListener> set = this.f3175F;
        if (set == null) {
            return;
        }
        set.remove(requestListener);
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController, com.facebook.drawee.interfaces.DraweeController
    /* renamed from: e */
    public void mo1045e(DraweeHierarchy draweeHierarchy) {
        super.mo1045e(draweeHierarchy);
        m1043K(null);
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* renamed from: g */
    public Drawable mo1046g(CloseableReference<CloseableImage> closeableReference) {
        CloseableReference<CloseableImage> closeableReference2 = closeableReference;
        try {
            FrescoSystrace.m1527b();
            AnimatableValueParser.m419B(CloseableReference.m8640y(closeableReference2));
            CloseableImage closeableImageM8642u = closeableReference2.m8642u();
            m1043K(closeableImageM8642u);
            Drawable drawableM1042J = m1042J(this.f3173D, closeableImageM8642u);
            if (drawableM1042J == null && (drawableM1042J = m1042J(this.f3182y, closeableImageM8642u)) == null && (drawableM1042J = this.f3181x.mo1036b(closeableImageM8642u)) == null) {
                throw new UnsupportedOperationException("Unrecognized image class: " + closeableImageM8642u);
            }
            return drawableM1042J;
        } finally {
            FrescoSystrace.m1527b();
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* renamed from: h */
    public CloseableReference<CloseableImage> mo1047h() {
        CacheKey cacheKey;
        FrescoSystrace.m1527b();
        try {
            MemoryCache<CacheKey, CloseableImage> memoryCache = this.f3183z;
            if (memoryCache != null && (cacheKey = this.f3170A) != null) {
                CloseableReference<CloseableImage> closeableReference = memoryCache.get(cacheKey);
                if (closeableReference == null || ((ImmutableQualityInfo) closeableReference.m8642u().mo1334b()).f3911d) {
                    return closeableReference;
                }
                closeableReference.close();
            }
            return null;
        } finally {
            FrescoSystrace.m1527b();
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* renamed from: j */
    public DataSource<CloseableReference<CloseableImage>> mo1048j() {
        FrescoSystrace.m1527b();
        if (FLog.m980h(2)) {
            System.identityHashCode(this);
        }
        DataSource<CloseableReference<CloseableImage>> dataSource = this.f3171B.get();
        FrescoSystrace.m1527b();
        return dataSource;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* renamed from: k */
    public int mo1049k(CloseableReference<CloseableImage> closeableReference) {
        CloseableReference<CloseableImage> closeableReference2 = closeableReference;
        if (closeableReference2 == null || !closeableReference2.m8643x()) {
            return 0;
        }
        return System.identityHashCode(closeableReference2.f19443o.m8646c());
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* renamed from: l */
    public ImageInfo mo1050l(CloseableReference<CloseableImage> closeableReference) {
        CloseableReference<CloseableImage> closeableReference2 = closeableReference;
        AnimatableValueParser.m419B(CloseableReference.m8640y(closeableReference2));
        return closeableReference2.m8642u();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0021, code lost:
    
        if (r0 != null) goto L6;
     */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Uri mo1051m() {
        Uri uri;
        ImageRequest imageRequest = this.f3178I;
        ImageRequest imageRequest2 = this.f3180K;
        ImageRequest[] imageRequestArr = this.f3179J;
        if (imageRequest == null || (uri = imageRequest.f19585c) == null) {
            if (imageRequestArr != null && imageRequestArr.length > 0 && imageRequestArr[0] != null) {
                ImageRequest imageRequest3 = imageRequestArr[0];
                uri = imageRequest3 != null ? imageRequest3.f19585c : null;
            }
            if (imageRequest2 != null) {
                return imageRequest2.f19585c;
            }
            return null;
        }
        return uri;
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* renamed from: t */
    public Map mo1052t(ImageInfo imageInfo) {
        ImageInfo imageInfo2 = imageInfo;
        if (imageInfo2 == null) {
            return null;
        }
        return imageInfo2.mo1333a();
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    public String toString() {
        Objects2 objects2M526h2 = AnimatableValueParser.m526h2(this);
        objects2M526h2.m971c("super", super.toString());
        objects2M526h2.m971c("dataSourceSupplier", this.f3171B);
        return objects2M526h2.toString();
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* renamed from: v */
    public void mo1053v(String str, CloseableReference<CloseableImage> closeableReference) {
        synchronized (this) {
            ImageOriginListener imageOriginListener = this.f3176G;
            if (imageOriginListener != null) {
                imageOriginListener.mo1061a(str, 6, true, "PipelineDraweeController");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* renamed from: x */
    public void mo1054x(Drawable drawable) {
        if (drawable instanceof DrawableWithCaches) {
            ((DrawableWithCaches) drawable).mo1034a();
        }
    }

    @Override // com.facebook.drawee.controller.AbstractDraweeController
    /* renamed from: z */
    public void mo1055z(CloseableReference<CloseableImage> closeableReference) {
        CloseableReference<CloseableImage> closeableReference2 = closeableReference;
        Class<CloseableReference> cls = CloseableReference.f19438j;
        if (closeableReference2 != null) {
            closeableReference2.close();
        }
    }
}
