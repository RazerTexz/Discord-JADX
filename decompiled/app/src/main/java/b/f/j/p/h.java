package b.f.j.p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: BitmapMemoryCacheProducer.java */
/* loaded from: classes3.dex */
public class h implements w0<CloseableReference<b.f.j.j.c>> {
    public final b.f.j.c.w<CacheKey, b.f.j.j.c> a;

    /* renamed from: b, reason: collision with root package name */
    public final b.f.j.c.i f613b;
    public final w0<CloseableReference<b.f.j.j.c>> c;

    /* compiled from: BitmapMemoryCacheProducer.java */
    public class a extends p<CloseableReference<b.f.j.j.c>, CloseableReference<b.f.j.j.c>> {
        public final /* synthetic */ CacheKey c;
        public final /* synthetic */ boolean d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, CacheKey cacheKey, boolean z2) {
            super(lVar);
            this.c = cacheKey;
            this.d = z2;
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x0078 A[Catch: all -> 0x00a9, TRY_LEAVE, TryCatch #0 {all -> 0x00a9, blocks: (B:3:0x0002, B:6:0x000e, B:8:0x0018, B:10:0x0024, B:14:0x0030, B:21:0x0062, B:24:0x006b, B:26:0x0070, B:27:0x0073, B:28:0x0074, B:30:0x0078, B:38:0x0095, B:41:0x009d, B:42:0x00a0, B:43:0x00a1, B:32:0x0084, B:33:0x008b, B:36:0x0090, B:16:0x003c, B:18:0x0057, B:23:0x0066), top: B:49:0x0002, inners: #1, #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0095 A[Catch: all -> 0x00a9, TRY_ENTER, TryCatch #0 {all -> 0x00a9, blocks: (B:3:0x0002, B:6:0x000e, B:8:0x0018, B:10:0x0024, B:14:0x0030, B:21:0x0062, B:24:0x006b, B:26:0x0070, B:27:0x0073, B:28:0x0074, B:30:0x0078, B:38:0x0095, B:41:0x009d, B:42:0x00a0, B:43:0x00a1, B:32:0x0084, B:33:0x008b, B:36:0x0090, B:16:0x003c, B:18:0x0057, B:23:0x0066), top: B:49:0x0002, inners: #1, #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // b.f.j.p.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void i(Object obj, int i) {
            CloseableReference<b.f.j.j.c> closeableReferenceA;
            CloseableReference<b.f.j.j.c> closeableReference;
            CloseableReference<b.f.j.j.c> closeableReference2 = (CloseableReference) obj;
            try {
                b.f.j.r.b.b();
                boolean zE = b.e(i);
                if (closeableReference2 == null) {
                    if (zE) {
                        this.f632b.b(null, i);
                    }
                } else if (closeableReference2.u().d() || b.m(i, 8)) {
                    this.f632b.b(closeableReference2, i);
                } else if (zE || (closeableReference = h.this.a.get(this.c)) == null) {
                    closeableReferenceA = this.d ? h.this.a.a(this.c, closeableReference2) : null;
                    if (zE) {
                        try {
                            this.f632b.a(1.0f);
                        } catch (Throwable th) {
                            if (closeableReferenceA != null) {
                                closeableReferenceA.close();
                            }
                            throw th;
                        }
                    }
                    l<O> lVar = this.f632b;
                    if (closeableReferenceA != null) {
                        closeableReference2 = closeableReferenceA;
                    }
                    lVar.b(closeableReference2, i);
                    if (closeableReferenceA != null) {
                        closeableReferenceA.close();
                    }
                } else {
                    try {
                        b.f.j.j.i iVarB = closeableReference2.u().b();
                        b.f.j.j.i iVarB2 = closeableReference.u().b();
                        if (((b.f.j.j.h) iVarB2).d || ((b.f.j.j.h) iVarB2).f591b >= ((b.f.j.j.h) iVarB).f591b) {
                            this.f632b.b(closeableReference, i);
                            closeableReference.close();
                        } else {
                            if (this.d) {
                            }
                            if (zE) {
                            }
                            l<O> lVar2 = this.f632b;
                            if (closeableReferenceA != null) {
                            }
                            lVar2.b(closeableReference2, i);
                            if (closeableReferenceA != null) {
                            }
                        }
                    } finally {
                        closeableReference.close();
                    }
                }
            } finally {
                b.f.j.r.b.b();
            }
        }
    }

    public h(b.f.j.c.w<CacheKey, b.f.j.j.c> wVar, b.f.j.c.i iVar, w0<CloseableReference<b.f.j.j.c>> w0Var) {
        this.a = wVar;
        this.f613b = iVar;
        this.c = w0Var;
    }

    @Override // b.f.j.p.w0
    public void b(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var) {
        try {
            b.f.j.r.b.b();
            z0 z0VarO = x0Var.o();
            z0VarO.e(x0Var, d());
            CacheKey cacheKeyA = ((b.f.j.c.n) this.f613b).a(x0Var.e(), x0Var.b());
            CloseableReference<b.f.j.j.c> closeableReference = x0Var.e().b(1) ? this.a.get(cacheKeyA) : null;
            if (closeableReference != null) {
                x0Var.j(closeableReference.u().a());
                boolean z2 = ((b.f.j.j.h) closeableReference.u().b()).d;
                if (z2) {
                    z0VarO.j(x0Var, d(), z0VarO.g(x0Var, d()) ? b.f.d.d.f.of("cached_value_found", "true") : null);
                    z0VarO.c(x0Var, d(), true);
                    x0Var.i("memory_bitmap", c());
                    lVar.a(1.0f);
                }
                lVar.b(closeableReference, z2 ? 1 : 0);
                closeableReference.close();
                if (z2) {
                    return;
                }
            }
            if (x0Var.q().g() >= ImageRequest.c.BITMAP_MEMORY_CACHE.g()) {
                z0VarO.j(x0Var, d(), z0VarO.g(x0Var, d()) ? b.f.d.d.f.of("cached_value_found", "false") : null);
                z0VarO.c(x0Var, d(), false);
                x0Var.i("memory_bitmap", c());
                lVar.b(null, 1);
                return;
            }
            l<CloseableReference<b.f.j.j.c>> lVarE = e(lVar, cacheKeyA, x0Var.e().b(2));
            z0VarO.j(x0Var, d(), z0VarO.g(x0Var, d()) ? b.f.d.d.f.of("cached_value_found", "false") : null);
            b.f.j.r.b.b();
            this.c.b(lVarE, x0Var);
            b.f.j.r.b.b();
        } finally {
            b.f.j.r.b.b();
        }
    }

    public String c() {
        return "pipe_bg";
    }

    public String d() {
        return "BitmapMemoryCacheProducer";
    }

    public l<CloseableReference<b.f.j.j.c>> e(l<CloseableReference<b.f.j.j.c>> lVar, CacheKey cacheKey, boolean z2) {
        return new a(lVar, cacheKey, z2);
    }
}
