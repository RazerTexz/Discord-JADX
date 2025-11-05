package d0.e0.p.d.m0.c.k1.a;

import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.e0.p.d.m0.e.b.p;
import d0.g0.t;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ReflectKotlinClass.kt */
/* loaded from: classes3.dex */
public final class f implements p {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final Class<?> f3284b;
    public final d0.e0.p.d.m0.e.b.b0.a c;

    /* compiled from: ReflectKotlinClass.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final f create(Class<?> cls) {
            d0.z.d.m.checkNotNullParameter(cls, "klass");
            d0.e0.p.d.m0.e.b.b0.b bVar = new d0.e0.p.d.m0.e.b.b0.b();
            c.a.loadClassAnnotations(cls, bVar);
            d0.e0.p.d.m0.e.b.b0.a aVarCreateHeader = bVar.createHeader();
            if (aVarCreateHeader == null) {
                return null;
            }
            return new f(cls, aVarCreateHeader, null);
        }
    }

    public f(Class cls, d0.e0.p.d.m0.e.b.b0.a aVar, DefaultConstructorMarker defaultConstructorMarker) {
        this.f3284b = cls;
        this.c = aVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && d0.z.d.m.areEqual(this.f3284b, ((f) obj).f3284b);
    }

    @Override // d0.e0.p.d.m0.e.b.p
    public d0.e0.p.d.m0.e.b.b0.a getClassHeader() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.e.b.p
    public d0.e0.p.d.m0.g.a getClassId() {
        return d0.e0.p.d.m0.c.k1.b.b.getClassId(this.f3284b);
    }

    public final Class<?> getKlass() {
        return this.f3284b;
    }

    @Override // d0.e0.p.d.m0.e.b.p
    public String getLocation() {
        String name = this.f3284b.getName();
        d0.z.d.m.checkNotNullExpressionValue(name, "klass.name");
        return d0.z.d.m.stringPlus(t.replace$default(name, '.', MentionUtilsKt.SLASH_CHAR, false, 4, (Object) null), ".class");
    }

    public int hashCode() {
        return this.f3284b.hashCode();
    }

    @Override // d0.e0.p.d.m0.e.b.p
    public void loadClassAnnotations(p.c cVar, byte[] bArr) {
        d0.z.d.m.checkNotNullParameter(cVar, "visitor");
        c.a.loadClassAnnotations(this.f3284b, cVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        b.d.b.a.a.k0(f.class, sb, ": ");
        sb.append(this.f3284b);
        return sb.toString();
    }

    @Override // d0.e0.p.d.m0.e.b.p
    public void visitMembers(p.d dVar, byte[] bArr) {
        d0.z.d.m.checkNotNullParameter(dVar, "visitor");
        c.a.visitMembers(this.f3284b, dVar);
    }
}
