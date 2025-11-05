package b.f.j.p;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: EncodedMemoryCacheProducer.java */
/* loaded from: classes3.dex */
public class v implements w0<b.f.j.j.e> {
    public final b.f.j.c.w<CacheKey, PooledByteBuffer> a;

    /* renamed from: b, reason: collision with root package name */
    public final b.f.j.c.i f640b;
    public final w0<b.f.j.j.e> c;

    /* compiled from: EncodedMemoryCacheProducer.java */
    public static class a extends p<b.f.j.j.e, b.f.j.j.e> {
        public final b.f.j.c.w<CacheKey, PooledByteBuffer> c;
        public final CacheKey d;
        public final boolean e;
        public final boolean f;

        public a(l<b.f.j.j.e> lVar, b.f.j.c.w<CacheKey, PooledByteBuffer> wVar, CacheKey cacheKey, boolean z2, boolean z3) {
            super(lVar);
            this.c = wVar;
            this.d = cacheKey;
            this.e = z2;
            this.f = z3;
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0065 A[Catch: all -> 0x0074, TryCatch #1 {all -> 0x0074, blocks: (B:3:0x0002, B:6:0x000d, B:8:0x0015, B:11:0x001f, B:19:0x0036, B:22:0x0043, B:24:0x0052, B:26:0x0057, B:27:0x005a, B:29:0x005c, B:30:0x005f, B:32:0x0061, B:33:0x0064, B:34:0x0065, B:35:0x006b, B:14:0x0026, B:16:0x002a, B:18:0x002e, B:23:0x0046, B:21:0x003b), top: B:43:0x0002, inners: #0, #2, #3 }] */
        @Override // b.f.j.p.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void i(Object obj, int i) {
            b.f.j.j.e eVar = (b.f.j.j.e) obj;
            try {
                b.f.j.r.b.b();
                if (b.f(i) || eVar == null || b.l(i, 10)) {
                    this.f632b.b(eVar, i);
                } else {
                    eVar.x();
                    if (eVar.l == b.f.i.c.a) {
                        this.f632b.b(eVar, i);
                    } else {
                        CloseableReference<PooledByteBuffer> closeableReferenceC = eVar.c();
                        if (closeableReferenceC != null) {
                            CloseableReference<PooledByteBuffer> closeableReferenceA = null;
                            try {
                                if (this.f && this.e) {
                                    closeableReferenceA = this.c.a(this.d, closeableReferenceC);
                                }
                                if (closeableReferenceA != null) {
                                    try {
                                        b.f.j.j.e eVar2 = new b.f.j.j.e(closeableReferenceA);
                                        eVar2.b(eVar);
                                        try {
                                            this.f632b.a(1.0f);
                                            this.f632b.b(eVar2, i);
                                            eVar2.close();
                                        } catch (Throwable th) {
                                            eVar2.close();
                                            throw th;
                                        }
                                    } finally {
                                        closeableReferenceA.close();
                                    }
                                } else {
                                    this.f632b.b(eVar, i);
                                }
                            } finally {
                                closeableReferenceC.close();
                            }
                        }
                    }
                }
            } finally {
                b.f.j.r.b.b();
            }
        }
    }

    public v(b.f.j.c.w<CacheKey, PooledByteBuffer> wVar, b.f.j.c.i iVar, w0<b.f.j.j.e> w0Var) {
        this.a = wVar;
        this.f640b = iVar;
        this.c = w0Var;
    }

    @Override // b.f.j.p.w0
    public void b(l<b.f.j.j.e> lVar, x0 x0Var) {
        try {
            b.f.j.r.b.b();
            z0 z0VarO = x0Var.o();
            z0VarO.e(x0Var, "EncodedMemoryCacheProducer");
            CacheKey cacheKeyB = ((b.f.j.c.n) this.f640b).b(x0Var.e(), x0Var.b());
            CloseableReference<PooledByteBuffer> closeableReference = x0Var.e().b(4) ? this.a.get(cacheKeyB) : null;
            try {
                if (closeableReference != null) {
                    b.f.j.j.e eVar = new b.f.j.j.e(closeableReference);
                    try {
                        z0VarO.j(x0Var, "EncodedMemoryCacheProducer", z0VarO.g(x0Var, "EncodedMemoryCacheProducer") ? b.f.d.d.f.of("cached_value_found", "true") : null);
                        z0VarO.c(x0Var, "EncodedMemoryCacheProducer", true);
                        x0Var.n("memory_encoded");
                        lVar.a(1.0f);
                        lVar.b(eVar, 1);
                        closeableReference.close();
                        return;
                    } finally {
                        eVar.close();
                    }
                }
                if (x0Var.q().g() >= ImageRequest.c.ENCODED_MEMORY_CACHE.g()) {
                    z0VarO.j(x0Var, "EncodedMemoryCacheProducer", z0VarO.g(x0Var, "EncodedMemoryCacheProducer") ? b.f.d.d.f.of("cached_value_found", "false") : null);
                    z0VarO.c(x0Var, "EncodedMemoryCacheProducer", false);
                    x0Var.i("memory_encoded", "nil-result");
                    lVar.b(null, 1);
                    return;
                }
                a aVar = new a(lVar, this.a, cacheKeyB, x0Var.e().b(8), x0Var.g().getExperiments().e);
                z0VarO.j(x0Var, "EncodedMemoryCacheProducer", z0VarO.g(x0Var, "EncodedMemoryCacheProducer") ? b.f.d.d.f.of("cached_value_found", "false") : null);
                this.c.b(aVar, x0Var);
                Class<CloseableReference> cls = CloseableReference.j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
            } finally {
                Class<CloseableReference> cls2 = CloseableReference.j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
            }
        } finally {
            b.f.j.r.b.b();
        }
    }
}
