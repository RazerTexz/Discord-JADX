package b.g.a.c.c0;

import b.g.a.a.i;
import b.g.a.a.p;
import java.io.Serializable;

/* compiled from: ConcreteBeanPropertyBase.java */
/* loaded from: classes3.dex */
public abstract class v implements b.g.a.c.d, Serializable {
    private static final long serialVersionUID = 1;
    public final b.g.a.c.s _metadata;

    public v(b.g.a.c.s sVar) {
        this._metadata = sVar == null ? b.g.a.c.s.l : sVar;
    }

    @Override // b.g.a.c.d
    public i.d a(b.g.a.c.z.l<?> lVar, Class<?> cls) {
        i member;
        i.d dVarI = lVar.i(cls);
        b.g.a.c.b bVarE = lVar.e();
        i.d dVarH = (bVarE == null || (member = getMember()) == null) ? null : bVarE.h(member);
        return dVarI == null ? dVarH == null ? b.g.a.c.d.c : dVarH : dVarH == null ? dVarI : dVarI.k(dVarH);
    }

    @Override // b.g.a.c.d
    public p.b b(b.g.a.c.z.l<?> lVar, Class<?> cls) {
        b.g.a.c.b bVarE = lVar.e();
        i member = getMember();
        if (member == null) {
            return lVar.j(cls);
        }
        p.b bVarG = lVar.g(cls, member.d());
        if (bVarE == null) {
            return bVarG;
        }
        p.b bVarZ = bVarE.z(member);
        return bVarG == null ? bVarZ : bVarG.a(bVarZ);
    }

    public v(v vVar) {
        this._metadata = vVar._metadata;
    }
}
