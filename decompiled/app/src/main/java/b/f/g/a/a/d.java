package b.f.g.a.a;

import android.content.Context;
import android.net.Uri;
import b.f.d.d.l;
import b.f.j.c.i;
import b.f.j.c.n;
import b.f.j.e.h;
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

/* compiled from: PipelineDraweeControllerBuilder.java */
/* loaded from: classes.dex */
public class d extends AbstractDraweeControllerBuilder<d, ImageRequest, CloseableReference<b.f.j.j.c>, ImageInfo> {
    public final h o;
    public final f p;
    public b.f.g.a.a.h.e q;

    public d(Context context, f fVar, h hVar, Set<ControllerListener> set, Set<b.f.h.b.a.b> set2) {
        super(context, set, set2);
        this.o = hVar;
        this.p = fVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public DataSource<CloseableReference<b.f.j.j.c>> b(DraweeController draweeController, String str, ImageRequest imageRequest, Object obj, AbstractDraweeControllerBuilder.b bVar) {
        ImageRequest.c cVar;
        b.f.g.a.a.h.c cVar2;
        ImageRequest imageRequest2 = imageRequest;
        h hVar = this.o;
        int iOrdinal = bVar.ordinal();
        if (iOrdinal == 0) {
            cVar = ImageRequest.c.FULL_FETCH;
        } else if (iOrdinal == 1) {
            cVar = ImageRequest.c.DISK_CACHE;
        } else {
            if (iOrdinal != 2) {
                throw new RuntimeException("Cache level" + bVar + "is not supported. ");
            }
            cVar = ImageRequest.c.BITMAP_MEMORY_CACHE;
        }
        ImageRequest.c cVar3 = cVar;
        if (draweeController instanceof c) {
            c cVar4 = (c) draweeController;
            synchronized (cVar4) {
                b.f.g.a.a.h.b bVar2 = cVar4.G;
                cVar = bVar2 != null ? new b.f.g.a.a.h.c(cVar4.m, bVar2) : null;
                Set<b.f.j.k.e> set = cVar4.F;
                if (set != null) {
                    b.f.j.k.c cVar5 = new b.f.j.k.c(set);
                    if (cVar != null) {
                        cVar5.a.add(cVar);
                    }
                    cVar2 = cVar5;
                } else {
                    cVar2 = cVar;
                }
            }
        } else {
            cVar2 = cVar;
        }
        return hVar.a(imageRequest2, obj, cVar3, cVar2, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.drawee.controller.AbstractDraweeControllerBuilder
    public AbstractDraweeController d() {
        c cVar;
        CacheKey cacheKey;
        CacheKey cacheKeyA;
        b.f.j.r.b.b();
        try {
            DraweeController draweeController = this.n;
            String strValueOf = String.valueOf(AbstractDraweeControllerBuilder.c.getAndIncrement());
            if (draweeController instanceof c) {
                cVar = (c) draweeController;
            } else {
                f fVar = this.p;
                c cVar2 = new c(fVar.a, fVar.f482b, fVar.c, fVar.d, fVar.e, fVar.f);
                Supplier<Boolean> supplier = fVar.g;
                if (supplier != null) {
                    cVar2.C = supplier.get().booleanValue();
                }
                cVar = cVar2;
            }
            Supplier<DataSource<CloseableReference<b.f.j.j.c>>> supplierE = e(cVar, strValueOf);
            ImageRequest imageRequest = (ImageRequest) this.h;
            i iVar = this.o.g;
            if (iVar == null || imageRequest == null) {
                cacheKey = null;
            } else {
                if (imageRequest.f2903s != null) {
                    cacheKeyA = ((n) iVar).c(imageRequest, this.g);
                } else {
                    cacheKeyA = ((n) iVar).a(imageRequest, this.g);
                }
                cacheKey = cacheKeyA;
            }
            cVar.H(supplierE, strValueOf, cacheKey, this.g, null, null);
            cVar.I(this.q, this, l.a);
            return cVar;
        } finally {
            b.f.j.r.b.b();
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    public d f(Uri uri) {
        if (uri == null) {
            this.h = null;
            return this;
        }
        ImageRequestBuilder imageRequestBuilderB = ImageRequestBuilder.b(uri);
        imageRequestBuilderB.e = b.f.j.d.f.f567b;
        this.h = imageRequestBuilderB.a();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d g(String str) {
        Uri uri;
        if (str != null && !str.isEmpty()) {
            return f(Uri.parse(str));
        }
        REQUEST requestA = 0;
        requestA = 0;
        requestA = 0;
        if (str != null && str.length() != 0 && (uri = Uri.parse(str)) != null) {
            requestA = ImageRequestBuilder.b(uri).a();
        }
        this.h = requestA;
        return this;
    }
}
