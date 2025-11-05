package b.c.a.y.l;

import androidx.annotation.Nullable;

/* compiled from: MergePaths.java */
/* loaded from: classes.dex */
public class g implements b {
    public final String a;

    /* renamed from: b, reason: collision with root package name */
    public final a f420b;
    public final boolean c;

    /* compiled from: MergePaths.java */
    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS
    }

    public g(String str, a aVar, boolean z2) {
        this.a = str;
        this.f420b = aVar;
        this.c = z2;
    }

    @Override // b.c.a.y.l.b
    @Nullable
    public b.c.a.w.b.c a(b.c.a.j jVar, b.c.a.y.m.b bVar) {
        if (jVar.w) {
            return new b.c.a.w.b.l(this);
        }
        b.c.a.b0.c.b("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("MergePaths{mode=");
        sbU.append(this.f420b);
        sbU.append('}');
        return sbU.toString();
    }
}
