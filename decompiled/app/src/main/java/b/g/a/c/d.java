package b.g.a.c;

import b.g.a.a.i;
import b.g.a.a.p;
import java.io.Serializable;

/* compiled from: BeanProperty.java */
/* loaded from: classes3.dex */
public interface d {
    public static final i.d c = new i.d("", i.c.ANY, "", "", i.b.a, null);

    /* compiled from: BeanProperty.java */
    public static class a implements d, Serializable {
        private static final long serialVersionUID = 1;
        public final b.g.a.c.c0.i _member;
        public final s _metadata;
        public final t _name;
        public final j _type;
        public final t _wrapperName;

        public a(t tVar, j jVar, t tVar2, b.g.a.c.c0.i iVar, s sVar) {
            this._name = tVar;
            this._type = jVar;
            this._wrapperName = tVar2;
            this._metadata = sVar;
            this._member = iVar;
        }

        @Override // b.g.a.c.d
        public i.d a(b.g.a.c.z.l<?> lVar, Class<?> cls) {
            b.g.a.c.c0.i iVar;
            i.d dVarH;
            i.d dVarI = lVar.i(cls);
            b bVarE = lVar.e();
            return (bVarE == null || (iVar = this._member) == null || (dVarH = bVarE.h(iVar)) == null) ? dVarI : dVarI.k(dVarH);
        }

        @Override // b.g.a.c.d
        public p.b b(b.g.a.c.z.l<?> lVar, Class<?> cls) {
            b.g.a.c.c0.i iVar;
            p.b bVarZ;
            p.b bVarG = lVar.g(cls, this._type._class);
            b bVarE = lVar.e();
            return (bVarE == null || (iVar = this._member) == null || (bVarZ = bVarE.z(iVar)) == null) ? bVarG : bVarG.a(bVarZ);
        }

        @Override // b.g.a.c.d
        public b.g.a.c.c0.i getMember() {
            return this._member;
        }

        @Override // b.g.a.c.d
        public j getType() {
            return this._type;
        }
    }

    static {
        p.b bVar = p.b.j;
        p.b bVar2 = p.b.j;
    }

    i.d a(b.g.a.c.z.l<?> lVar, Class<?> cls);

    p.b b(b.g.a.c.z.l<?> lVar, Class<?> cls);

    b.g.a.c.c0.i getMember();

    j getType();
}
