package b.f.j.p;

import b.f.j.p.c0;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: ResizeAndRotateProducer.java */
/* loaded from: classes3.dex */
public class c1 implements w0<b.f.j.j.e> {
    public final Executor a;

    /* renamed from: b, reason: collision with root package name */
    public final b.f.d.g.g f607b;
    public final w0<b.f.j.j.e> c;
    public final boolean d;
    public final b.f.j.s.c e;

    /* compiled from: ResizeAndRotateProducer.java */
    public class a extends p<b.f.j.j.e, b.f.j.j.e> {
        public final boolean c;
        public final b.f.j.s.c d;
        public final x0 e;
        public boolean f;
        public final c0 g;

        /* compiled from: ResizeAndRotateProducer.java */
        /* renamed from: b.f.j.p.c1$a$a, reason: collision with other inner class name */
        public class C0074a implements c0.c {
            public C0074a(c1 c1Var) {
            }

            @Override // b.f.j.p.c0.c
            public void a(b.f.j.j.e eVar, int i) throws Throwable {
                b.f.j.s.a aVarC;
                a aVar = a.this;
                b.f.j.s.c cVar = aVar.d;
                eVar.x();
                b.f.j.s.b bVarCreateImageTranscoder = cVar.createImageTranscoder(eVar.l, a.this.c);
                Objects.requireNonNull(bVarCreateImageTranscoder);
                aVar.e.o().e(aVar.e, "ResizeAndRotateProducer");
                ImageRequest imageRequestE = aVar.e.e();
                b.f.d.g.i iVarA = c1.this.f607b.a();
                try {
                    try {
                        aVarC = bVarCreateImageTranscoder.c(eVar, iVarA, imageRequestE.k, imageRequestE.j, null, 85);
                    } catch (Exception e) {
                        aVar.e.o().k(aVar.e, "ResizeAndRotateProducer", e, null);
                        if (b.f.j.p.b.e(i)) {
                            aVar.f632b.c(e);
                        }
                    }
                    if (aVarC.a == 2) {
                        throw new RuntimeException("Error while transcoding the image");
                    }
                    Map<String, String> mapN = aVar.n(eVar, imageRequestE.j, aVarC, bVarCreateImageTranscoder.a());
                    CloseableReference closeableReferenceA = CloseableReference.A(((MemoryPooledByteBufferOutputStream) iVarA).b());
                    try {
                        b.f.j.j.e eVar2 = new b.f.j.j.e(closeableReferenceA);
                        eVar2.l = b.f.i.b.a;
                        try {
                            eVar2.q();
                            aVar.e.o().j(aVar.e, "ResizeAndRotateProducer", mapN);
                            if (aVarC.a != 1) {
                                i |= 16;
                            }
                            aVar.f632b.b(eVar2, i);
                        } finally {
                            eVar2.close();
                        }
                    } finally {
                        if (closeableReferenceA != null) {
                            closeableReferenceA.close();
                        }
                    }
                } finally {
                    iVarA.close();
                }
            }
        }

        /* compiled from: ResizeAndRotateProducer.java */
        public class b extends e {
            public final /* synthetic */ l a;

            public b(c1 c1Var, l lVar) {
                this.a = lVar;
            }

            @Override // b.f.j.p.y0
            public void a() {
                a.this.g.a();
                a.this.f = true;
                this.a.d();
            }

            @Override // b.f.j.p.e, b.f.j.p.y0
            public void b() {
                if (a.this.e.p()) {
                    a.this.g.d();
                }
            }
        }

        public a(l<b.f.j.j.e> lVar, x0 x0Var, boolean z2, b.f.j.s.c cVar) {
            super(lVar);
            this.f = false;
            this.e = x0Var;
            Objects.requireNonNull(x0Var.e());
            this.c = z2;
            this.d = cVar;
            this.g = new c0(c1.this.a, new C0074a(c1.this), 100);
            x0Var.f(new b(c1.this, lVar));
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x007c  */
        @Override // b.f.j.p.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void i(Object obj, int i) {
            boolean z2;
            b.f.d.l.a aVarF;
            boolean zContains;
            b.f.j.j.e eVarA = (b.f.j.j.e) obj;
            b.f.d.l.a aVar = b.f.d.l.a.UNSET;
            if (this.f) {
                return;
            }
            boolean zE = b.f.j.p.b.e(i);
            boolean z3 = true;
            if (eVarA == null) {
                if (zE) {
                    this.f632b.b(null, 1);
                    return;
                }
                return;
            }
            eVarA.x();
            b.f.i.c cVar = eVarA.l;
            ImageRequest imageRequestE = this.e.e();
            b.f.j.s.b bVarCreateImageTranscoder = this.d.createImageTranscoder(cVar, this.c);
            Objects.requireNonNull(bVarCreateImageTranscoder);
            eVarA.x();
            if (eVarA.l == b.f.i.c.a) {
                aVarF = aVar;
            } else {
                eVarA.x();
                if (bVarCreateImageTranscoder.d(eVarA.l)) {
                    b.f.j.d.f fVar = imageRequestE.k;
                    if (fVar.d) {
                        z2 = false;
                        if (!z2 && !bVarCreateImageTranscoder.b(eVarA, imageRequestE.k, imageRequestE.j)) {
                            z3 = false;
                        }
                        aVarF = b.f.d.l.a.f(z3);
                    } else {
                        if (b.f.j.s.d.b(fVar, eVarA) == 0) {
                            if (!fVar.b() || fVar.d) {
                                eVarA.n = 0;
                                zContains = false;
                            } else {
                                b.f.d.d.e<Integer> eVar = b.f.j.s.d.a;
                                eVarA.x();
                                zContains = eVar.contains(Integer.valueOf(eVarA.n));
                            }
                            if (zContains) {
                            }
                            if (!z2) {
                                z3 = false;
                            }
                            aVarF = b.f.d.l.a.f(z3);
                        }
                        z2 = true;
                        if (!z2) {
                        }
                        aVarF = b.f.d.l.a.f(z3);
                    }
                } else {
                    aVarF = b.f.d.l.a.NO;
                }
            }
            if (zE || aVarF != aVar) {
                if (aVarF == b.f.d.l.a.YES) {
                    if (this.g.f(eVarA, i)) {
                        if (zE || this.e.p()) {
                            this.g.d();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (cVar != b.f.i.b.a && cVar != b.f.i.b.k) {
                    b.f.j.d.f fVar2 = this.e.e().k;
                    if (!fVar2.c() && fVar2.b()) {
                        int iA = fVar2.a();
                        eVarA = b.f.j.j.e.a(eVarA);
                        if (eVarA != null) {
                            eVarA.m = iA;
                        }
                    }
                } else if (!this.e.e().k.d) {
                    eVarA.x();
                    if (eVarA.m != 0) {
                        eVarA.x();
                        if (eVarA.m != -1 && (eVarA = b.f.j.j.e.a(eVarA)) != null) {
                            eVarA.m = 0;
                        }
                    }
                }
                this.f632b.b(eVarA, i);
            }
        }

        public final Map<String, String> n(b.f.j.j.e eVar, b.f.j.d.e eVar2, b.f.j.s.a aVar, String str) {
            String str2;
            long j;
            if (!this.e.o().g(this.e, "ResizeAndRotateProducer")) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            eVar.x();
            sb.append(eVar.o);
            sb.append("x");
            eVar.x();
            sb.append(eVar.p);
            String string = sb.toString();
            if (eVar2 != null) {
                str2 = eVar2.a + "x" + eVar2.f566b;
            } else {
                str2 = "Unspecified";
            }
            HashMap map = new HashMap();
            eVar.x();
            map.put("Image format", String.valueOf(eVar.l));
            map.put("Original size", string);
            map.put("Requested size", str2);
            c0 c0Var = this.g;
            synchronized (c0Var) {
                j = c0Var.j - c0Var.i;
            }
            map.put("queueTime", String.valueOf(j));
            map.put("Transcoder id", str);
            map.put("Transcoding result", String.valueOf(aVar));
            return new b.f.d.d.f(map);
        }
    }

    public c1(Executor executor, b.f.d.g.g gVar, w0<b.f.j.j.e> w0Var, boolean z2, b.f.j.s.c cVar) {
        Objects.requireNonNull(executor);
        this.a = executor;
        Objects.requireNonNull(gVar);
        this.f607b = gVar;
        Objects.requireNonNull(w0Var);
        this.c = w0Var;
        Objects.requireNonNull(cVar);
        this.e = cVar;
        this.d = z2;
    }

    @Override // b.f.j.p.w0
    public void b(l<b.f.j.j.e> lVar, x0 x0Var) {
        this.c.b(new a(lVar, x0Var, this.d, this.e), x0Var);
    }
}
