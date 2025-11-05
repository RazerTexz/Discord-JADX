package b.f.j.h;

import android.graphics.Bitmap;
import b.f.j.j.h;
import b.f.j.j.i;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.decoder.DecodeException;
import java.io.InputStream;
import java.util.Objects;

/* compiled from: DefaultImageDecoder.java */
/* loaded from: classes.dex */
public class a implements b {
    public final b a;

    /* renamed from: b, reason: collision with root package name */
    public final b f588b;
    public final b.f.j.n.d c;
    public final b d = new C0072a();

    /* compiled from: DefaultImageDecoder.java */
    /* renamed from: b.f.j.h.a$a, reason: collision with other inner class name */
    public class C0072a implements b {
        public C0072a() {
        }

        @Override // b.f.j.h.b
        public b.f.j.j.c a(b.f.j.j.e eVar, int i, i iVar, b.f.j.d.b bVar) {
            eVar.x();
            b.f.i.c cVar = eVar.l;
            if (cVar == b.f.i.b.a) {
                CloseableReference<Bitmap> closeableReferenceB = a.this.c.b(eVar, bVar.d, null, i, null);
                try {
                    b.c.a.a0.d.g1(null, closeableReferenceB);
                    eVar.x();
                    int i2 = eVar.m;
                    eVar.x();
                    b.f.j.j.d dVar = new b.f.j.j.d(closeableReferenceB, iVar, i2, eVar.n);
                    Boolean bool = Boolean.FALSE;
                    if (b.f.j.j.c.j.contains("is_rounded")) {
                        dVar.k.put("is_rounded", bool);
                    }
                    return dVar;
                } finally {
                    closeableReferenceB.close();
                }
            }
            if (cVar != b.f.i.b.c) {
                if (cVar != b.f.i.b.j) {
                    if (cVar != b.f.i.c.a) {
                        return a.this.b(eVar, bVar);
                    }
                    throw new DecodeException("unknown image format", eVar);
                }
                b bVar2 = a.this.f588b;
                if (bVar2 != null) {
                    return bVar2.a(eVar, i, iVar, bVar);
                }
                throw new DecodeException("Animated WebP support not set up!", eVar);
            }
            a aVar = a.this;
            Objects.requireNonNull(aVar);
            eVar.x();
            if (eVar.o != -1) {
                eVar.x();
                if (eVar.p != -1) {
                    Objects.requireNonNull(bVar);
                    b bVar3 = aVar.a;
                    return bVar3 != null ? bVar3.a(eVar, i, iVar, bVar) : aVar.b(eVar, bVar);
                }
            }
            throw new DecodeException("image width or height is incorrect", eVar);
        }
    }

    public a(b bVar, b bVar2, b.f.j.n.d dVar) {
        this.a = bVar;
        this.f588b = bVar2;
        this.c = dVar;
    }

    @Override // b.f.j.h.b
    public b.f.j.j.c a(b.f.j.j.e eVar, int i, i iVar, b.f.j.d.b bVar) {
        InputStream inputStreamE;
        Objects.requireNonNull(bVar);
        eVar.x();
        b.f.i.c cVar = eVar.l;
        if ((cVar == null || cVar == b.f.i.c.a) && (inputStreamE = eVar.e()) != null) {
            eVar.l = b.f.i.d.b(inputStreamE);
        }
        return this.d.a(eVar, i, iVar, bVar);
    }

    public b.f.j.j.d b(b.f.j.j.e eVar, b.f.j.d.b bVar) {
        CloseableReference<Bitmap> closeableReferenceA = this.c.a(eVar, bVar.d, null, null);
        try {
            b.c.a.a0.d.g1(null, closeableReferenceA);
            i iVar = h.a;
            eVar.x();
            int i = eVar.m;
            eVar.x();
            b.f.j.j.d dVar = new b.f.j.j.d(closeableReferenceA, iVar, i, eVar.n);
            Boolean bool = Boolean.FALSE;
            if (b.f.j.j.c.j.contains("is_rounded")) {
                dVar.k.put("is_rounded", bool);
            }
            return dVar;
        } finally {
            closeableReferenceA.close();
        }
    }
}
