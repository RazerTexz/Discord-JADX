package b.f.j.p;

import android.graphics.Bitmap;
import androidx.core.os.EnvironmentCompat;
import b.f.j.p.c0;
import com.facebook.common.internal.Supplier;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.imagepipeline.decoder.DecodeException;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: DecodeProducer.java */
/* loaded from: classes3.dex */
public class n implements w0<CloseableReference<b.f.j.j.c>> {
    public final b.f.d.g.a a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f626b;
    public final b.f.j.h.b c;
    public final b.f.j.h.d d;
    public final w0<b.f.j.j.e> e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final b.f.j.e.a j;
    public final Runnable k;
    public final Supplier<Boolean> l;

    /* compiled from: DecodeProducer.java */
    public class a extends c {
        public a(n nVar, l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var, boolean z2, int i) {
            super(lVar, x0Var, z2, i);
        }

        @Override // b.f.j.p.n.c
        public int o(b.f.j.j.e eVar) {
            return eVar.n();
        }

        @Override // b.f.j.p.n.c
        public b.f.j.j.i p() {
            return new b.f.j.j.h(0, false, false);
        }

        @Override // b.f.j.p.n.c
        public synchronized boolean w(b.f.j.j.e eVar, int i) {
            if (b.f.j.p.b.f(i)) {
                return false;
            }
            return this.g.f(eVar, i);
        }
    }

    /* compiled from: DecodeProducer.java */
    public class b extends c {
        public final b.f.j.h.e i;
        public final b.f.j.h.d j;
        public int k;

        public b(n nVar, l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var, b.f.j.h.e eVar, b.f.j.h.d dVar, boolean z2, int i) {
            super(lVar, x0Var, z2, i);
            this.i = eVar;
            Objects.requireNonNull(dVar);
            this.j = dVar;
            this.k = 0;
        }

        @Override // b.f.j.p.n.c
        public int o(b.f.j.j.e eVar) {
            return this.i.f;
        }

        @Override // b.f.j.p.n.c
        public b.f.j.j.i p() {
            return this.j.a(this.i.e);
        }

        @Override // b.f.j.p.n.c
        public synchronized boolean w(b.f.j.j.e eVar, int i) {
            boolean zF = this.g.f(eVar, i);
            if ((b.f.j.p.b.f(i) || b.f.j.p.b.m(i, 8)) && !b.f.j.p.b.m(i, 4) && b.f.j.j.e.u(eVar)) {
                eVar.x();
                if (eVar.l == b.f.i.b.a) {
                    if (!this.i.b(eVar)) {
                        return false;
                    }
                    int i2 = this.i.e;
                    int i3 = this.k;
                    if (i2 <= i3) {
                        return false;
                    }
                    if (i2 < this.j.b(i3) && !this.i.g) {
                        return false;
                    }
                    this.k = i2;
                }
            }
            return zF;
        }
    }

    /* compiled from: DecodeProducer.java */
    public abstract class c extends p<b.f.j.j.e, CloseableReference<b.f.j.j.c>> {
        public final x0 c;
        public final z0 d;
        public final b.f.j.d.b e;
        public boolean f;
        public final c0 g;

        /* compiled from: DecodeProducer.java */
        public class a implements c0.c {
            public final /* synthetic */ x0 a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f627b;

            public a(n nVar, x0 x0Var, int i) {
                this.a = x0Var;
                this.f627b = i;
            }

            @Override // b.f.j.p.c0.c
            public void a(b.f.j.j.e eVar, int i) {
                boolean z2;
                String str;
                long j;
                b.f.j.j.c cVarT;
                int i2 = i;
                if (eVar != null) {
                    x0 x0Var = c.this.c;
                    eVar.x();
                    x0Var.d("image_format", eVar.l.f541b);
                    if (n.this.f || !b.f.j.p.b.m(i2, 16)) {
                        ImageRequest imageRequestE = this.a.e();
                        if (n.this.g || !b.f.d.l.b.e(imageRequestE.c)) {
                            eVar.q = b.c.a.a0.d.a0(imageRequestE.k, imageRequestE.j, eVar, this.f627b);
                        }
                    }
                    Objects.requireNonNull(this.a.g().getExperiments());
                    c cVar = c.this;
                    Objects.requireNonNull(cVar);
                    eVar.x();
                    if (eVar.l == b.f.i.b.a || !b.f.j.p.b.f(i)) {
                        synchronized (cVar) {
                            z2 = cVar.f;
                        }
                        if (z2 || !b.f.j.j.e.u(eVar)) {
                            return;
                        }
                        eVar.x();
                        b.f.i.c cVar2 = eVar.l;
                        String str2 = cVar2 != null ? cVar2.f541b : EnvironmentCompat.MEDIA_UNKNOWN;
                        StringBuilder sb = new StringBuilder();
                        eVar.x();
                        sb.append(eVar.o);
                        sb.append("x");
                        eVar.x();
                        sb.append(eVar.p);
                        String string = sb.toString();
                        String strValueOf = String.valueOf(eVar.q);
                        boolean zE = b.f.j.p.b.e(i);
                        boolean z3 = zE && !b.f.j.p.b.m(i2, 8);
                        boolean zM = b.f.j.p.b.m(i2, 4);
                        b.f.j.d.e eVar2 = cVar.c.e().j;
                        if (eVar2 != null) {
                            str = eVar2.a + "x" + eVar2.f566b;
                        } else {
                            str = EnvironmentCompat.MEDIA_UNKNOWN;
                        }
                        String str3 = str;
                        try {
                            c0 c0Var = cVar.g;
                            synchronized (c0Var) {
                                j = c0Var.j - c0Var.i;
                            }
                            String strValueOf2 = String.valueOf(cVar.c.e().c);
                            int iN = (z3 || zM) ? eVar.n() : cVar.o(eVar);
                            b.f.j.j.i iVarP = (z3 || zM) ? b.f.j.j.h.a : cVar.p();
                            cVar.d.e(cVar.c, "DecodeProducer");
                            try {
                                try {
                                    cVarT = cVar.t(eVar, iN, iVarP);
                                } catch (DecodeException e) {
                                    b.f.j.j.e eVarA = e.a();
                                    b.f.d.e.a.o("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", e.getMessage(), strValueOf2, eVarA.d(10), Integer.valueOf(eVarA.n()));
                                    throw e;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                cVarT = null;
                            }
                            try {
                                if (eVar.q != 1) {
                                    i2 |= 16;
                                }
                                cVar.d.j(cVar.c, "DecodeProducer", cVar.n(cVarT, j, iVarP, zE, str2, string, str3, strValueOf));
                                cVar.v(eVar, cVarT);
                                cVar.s(cVarT, i2);
                            } catch (Exception e3) {
                                e = e3;
                                cVar.d.k(cVar.c, "DecodeProducer", e, cVar.n(cVarT, j, iVarP, zE, str2, string, str3, strValueOf));
                                cVar.u(true);
                                cVar.f632b.c(e);
                            }
                        } finally {
                            eVar.close();
                        }
                    }
                }
            }
        }

        /* compiled from: DecodeProducer.java */
        public class b extends e {
            public final /* synthetic */ boolean a;

            public b(n nVar, boolean z2) {
                this.a = z2;
            }

            @Override // b.f.j.p.y0
            public void a() {
                if (this.a) {
                    c cVar = c.this;
                    cVar.u(true);
                    cVar.f632b.d();
                }
            }

            @Override // b.f.j.p.e, b.f.j.p.y0
            public void b() {
                if (c.this.c.p()) {
                    c.this.g.d();
                }
            }
        }

        public c(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var, boolean z2, int i) {
            super(lVar);
            this.c = x0Var;
            this.d = x0Var.o();
            b.f.j.d.b bVar = x0Var.e().i;
            this.e = bVar;
            this.f = false;
            this.g = new c0(n.this.f626b, new a(n.this, x0Var, i), bVar.f564b);
            x0Var.f(new b(n.this, z2));
        }

        @Override // b.f.j.p.p, b.f.j.p.b
        public void g() {
            q();
        }

        @Override // b.f.j.p.p, b.f.j.p.b
        public void h(Throwable th) {
            r(th);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0034 A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:3:0x0002, B:7:0x000e, B:8:0x001e, B:10:0x0024, B:11:0x0034, B:15:0x003f, B:18:0x0047, B:20:0x004f), top: B:26:0x0002 }] */
        @Override // b.f.j.p.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void i(Object obj, int i) {
            b.f.j.j.e eVar = (b.f.j.j.e) obj;
            try {
                b.f.j.r.b.b();
                boolean zE = b.f.j.p.b.e(i);
                if (zE) {
                    if (eVar == null) {
                        ExceptionWithNoStacktrace exceptionWithNoStacktrace = new ExceptionWithNoStacktrace("Encoded image is null.");
                        u(true);
                        this.f632b.c(exceptionWithNoStacktrace);
                    } else if (!eVar.t()) {
                        ExceptionWithNoStacktrace exceptionWithNoStacktrace2 = new ExceptionWithNoStacktrace("Encoded image is not valid.");
                        u(true);
                        this.f632b.c(exceptionWithNoStacktrace2);
                    }
                } else if (w(eVar, i)) {
                    boolean zM = b.f.j.p.b.m(i, 4);
                    if (zE || zM || this.c.p()) {
                        this.g.d();
                    }
                }
            } finally {
                b.f.j.r.b.b();
            }
        }

        @Override // b.f.j.p.p, b.f.j.p.b
        public void j(float f) {
            this.f632b.a(f * 0.99f);
        }

        public final Map<String, String> n(b.f.j.j.c cVar, long j, b.f.j.j.i iVar, boolean z2, String str, String str2, String str3, String str4) {
            if (!this.d.g(this.c, "DecodeProducer")) {
                return null;
            }
            String strValueOf = String.valueOf(j);
            String strValueOf2 = String.valueOf(((b.f.j.j.h) iVar).c);
            String strValueOf3 = String.valueOf(z2);
            if (!(cVar instanceof b.f.j.j.d)) {
                HashMap map = new HashMap(7);
                map.put("queueTime", strValueOf);
                map.put("hasGoodQuality", strValueOf2);
                map.put("isFinal", strValueOf3);
                map.put("encodedImageSize", str2);
                map.put("imageFormat", str);
                map.put("requestedImageSize", str3);
                map.put("sampleSize", str4);
                return new b.f.d.d.f(map);
            }
            Bitmap bitmap = ((b.f.j.j.d) cVar).m;
            Objects.requireNonNull(bitmap);
            String str5 = bitmap.getWidth() + "x" + bitmap.getHeight();
            HashMap map2 = new HashMap(8);
            map2.put("bitmapSize", str5);
            map2.put("queueTime", strValueOf);
            map2.put("hasGoodQuality", strValueOf2);
            map2.put("isFinal", strValueOf3);
            map2.put("encodedImageSize", str2);
            map2.put("imageFormat", str);
            map2.put("requestedImageSize", str3);
            map2.put("sampleSize", str4);
            map2.put("byteCount", bitmap.getByteCount() + "");
            return new b.f.d.d.f(map2);
        }

        public abstract int o(b.f.j.j.e eVar);

        public abstract b.f.j.j.i p();

        public final void q() {
            u(true);
            this.f632b.d();
        }

        public final void r(Throwable th) {
            u(true);
            this.f632b.c(th);
        }

        public final void s(b.f.j.j.c cVar, int i) {
            CloseableReference.c cVar2 = n.this.j.a;
            Class<CloseableReference> cls = CloseableReference.j;
            CloseableReference closeableReferenceI = null;
            if (cVar != null) {
                closeableReferenceI = CloseableReference.I(cVar, CloseableReference.l, cVar2, cVar2.b() ? new Throwable() : null);
            }
            try {
                u(b.f.j.p.b.e(i));
                this.f632b.b(closeableReferenceI, i);
            } finally {
                if (closeableReferenceI != null) {
                    closeableReferenceI.close();
                }
            }
        }

        public final b.f.j.j.c t(b.f.j.j.e eVar, int i, b.f.j.j.i iVar) {
            n nVar = n.this;
            boolean z2 = nVar.k != null && nVar.l.get().booleanValue();
            try {
                return n.this.c.a(eVar, i, iVar, this.e);
            } catch (OutOfMemoryError e) {
                if (!z2) {
                    throw e;
                }
                n.this.k.run();
                System.gc();
                return n.this.c.a(eVar, i, iVar, this.e);
            }
        }

        public final void u(boolean z2) {
            synchronized (this) {
                if (z2) {
                    if (!this.f) {
                        this.f632b.a(1.0f);
                        this.f = true;
                        this.g.a();
                    }
                }
            }
        }

        public final void v(b.f.j.j.e eVar, b.f.j.j.c cVar) {
            x0 x0Var = this.c;
            eVar.x();
            x0Var.d("encoded_width", Integer.valueOf(eVar.o));
            x0 x0Var2 = this.c;
            eVar.x();
            x0Var2.d("encoded_height", Integer.valueOf(eVar.p));
            this.c.d("encoded_size", Integer.valueOf(eVar.n()));
            if (cVar instanceof b.f.j.j.b) {
                Bitmap bitmapF = ((b.f.j.j.b) cVar).f();
                this.c.d("bitmap_config", String.valueOf(bitmapF == null ? null : bitmapF.getConfig()));
            }
            if (cVar != null) {
                cVar.e(this.c.a());
            }
        }

        public abstract boolean w(b.f.j.j.e eVar, int i);
    }

    public n(b.f.d.g.a aVar, Executor executor, b.f.j.h.b bVar, b.f.j.h.d dVar, boolean z2, boolean z3, boolean z4, w0<b.f.j.j.e> w0Var, int i, b.f.j.e.a aVar2, Runnable runnable, Supplier<Boolean> supplier) {
        Objects.requireNonNull(aVar);
        this.a = aVar;
        Objects.requireNonNull(executor);
        this.f626b = executor;
        Objects.requireNonNull(bVar);
        this.c = bVar;
        Objects.requireNonNull(dVar);
        this.d = dVar;
        this.f = z2;
        this.g = z3;
        Objects.requireNonNull(w0Var);
        this.e = w0Var;
        this.h = z4;
        this.i = i;
        this.j = aVar2;
        this.k = null;
        this.l = supplier;
    }

    @Override // b.f.j.p.w0
    public void b(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var) {
        try {
            b.f.j.r.b.b();
            this.e.b(!b.f.d.l.b.e(x0Var.e().c) ? new a(this, lVar, x0Var, this.h, this.i) : new b(this, lVar, x0Var, new b.f.j.h.e(this.a), this.d, this.h, this.i), x0Var);
        } finally {
            b.f.j.r.b.b();
        }
    }
}
