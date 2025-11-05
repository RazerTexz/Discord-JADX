package b.f.g.a.a.h.i;

import b.f.g.a.a.h.h;
import com.facebook.imagepipeline.request.ImageRequest;

/* compiled from: ImagePerfRequestListener.java */
/* loaded from: classes.dex */
public class c extends b.f.j.k.a {
    public final b.f.d.k.b a;

    /* renamed from: b, reason: collision with root package name */
    public final h f492b;

    public c(b.f.d.k.b bVar, h hVar) {
        this.a = bVar;
        this.f492b = hVar;
    }

    @Override // b.f.j.k.a, b.f.j.k.e
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z2) {
        this.f492b.n = this.a.now();
        h hVar = this.f492b;
        hVar.c = imageRequest;
        hVar.d = obj;
        hVar.f486b = str;
        hVar.r = z2;
    }

    @Override // b.f.j.k.a, b.f.j.k.e
    public void c(ImageRequest imageRequest, String str, boolean z2) {
        this.f492b.o = this.a.now();
        h hVar = this.f492b;
        hVar.c = imageRequest;
        hVar.f486b = str;
        hVar.r = z2;
    }

    @Override // b.f.j.k.a, b.f.j.k.e
    public void g(ImageRequest imageRequest, String str, Throwable th, boolean z2) {
        this.f492b.o = this.a.now();
        h hVar = this.f492b;
        hVar.c = imageRequest;
        hVar.f486b = str;
        hVar.r = z2;
    }

    @Override // b.f.j.k.a, b.f.j.k.e
    public void k(String str) {
        this.f492b.o = this.a.now();
        this.f492b.f486b = str;
    }
}
