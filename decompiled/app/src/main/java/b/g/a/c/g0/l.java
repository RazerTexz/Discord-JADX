package b.g.a.c.g0;

import b.g.a.a.p;
import b.g.a.c.v;
import b.g.a.c.y.e;
import com.fasterxml.jackson.databind.JsonMappingException;

/* compiled from: PropertyBuilder.java */
/* loaded from: classes3.dex */
public class l {
    public final v a;

    /* renamed from: b, reason: collision with root package name */
    public final b.g.a.c.c f702b;
    public final b.g.a.c.b c;
    public Object d;
    public final p.b e;
    public final boolean f;

    public l(v vVar, b.g.a.c.c cVar) {
        this.a = vVar;
        this.f702b = cVar;
        p.b bVar = p.b.j;
        p.b bVarA = p.b.j;
        p.b bVarC = cVar.c(bVarA);
        vVar.k(cVar.a._class, bVarA);
        bVarA = bVarC != null ? bVarC.a(bVarA) : bVarA;
        p.b bVar2 = vVar._configOverrides._defaultInclusion;
        this.e = bVar2 == null ? bVarA : bVar2.a(bVarA);
        this.f = bVarA._valueInclusion == p.a.NON_DEFAULT;
        this.c = vVar.e();
    }

    public b.g.a.c.j a(b.g.a.c.c0.b bVar, boolean z2, b.g.a.c.j jVar) throws JsonMappingException {
        b.g.a.c.j jVarE0 = this.c.e0(this.a, bVar, jVar);
        if (jVarE0 != jVar) {
            Class<?> cls = jVarE0._class;
            Class<?> cls2 = jVar._class;
            if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
                StringBuilder sbU = b.d.b.a.a.U("Illegal concrete-type annotation for method '");
                sbU.append(bVar.c());
                sbU.append("': class ");
                sbU.append(cls.getName());
                sbU.append(" not a super-type of (declared) class ");
                sbU.append(cls2.getName());
                throw new IllegalArgumentException(sbU.toString());
            }
            z2 = true;
            jVar = jVarE0;
        }
        e.b bVarK = this.c.K(bVar);
        if (bVarK != null && bVarK != e.b.DEFAULT_TYPING) {
            z2 = bVarK == e.b.STATIC;
        }
        if (z2) {
            return jVar.G();
        }
        return null;
    }
}
