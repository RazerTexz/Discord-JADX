package b.c.a.y.l;

import android.graphics.Path;

/* compiled from: GradientFill.java */
/* loaded from: classes.dex */
public class d implements b {
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public final Path.FillType f417b;
    public final b.c.a.y.k.c c;
    public final b.c.a.y.k.d d;
    public final b.c.a.y.k.f e;
    public final b.c.a.y.k.f f;
    public final String g;
    public final boolean h;

    public d(String str, int i, Path.FillType fillType, b.c.a.y.k.c cVar, b.c.a.y.k.d dVar, b.c.a.y.k.f fVar, b.c.a.y.k.f fVar2, b.c.a.y.k.b bVar, b.c.a.y.k.b bVar2, boolean z2) {
        this.a = i;
        this.f417b = fillType;
        this.c = cVar;
        this.d = dVar;
        this.e = fVar;
        this.f = fVar2;
        this.g = str;
        this.h = z2;
    }

    @Override // b.c.a.y.l.b
    public b.c.a.w.b.c a(b.c.a.j jVar, b.c.a.y.m.b bVar) {
        return new b.c.a.w.b.h(jVar, bVar, this);
    }
}
