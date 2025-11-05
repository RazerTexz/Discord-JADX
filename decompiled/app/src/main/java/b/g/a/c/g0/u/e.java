package b.g.a.c.g0.u;

import b.g.a.a.i;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

/* compiled from: BooleanSerializer.java */
@b.g.a.c.y.a
/* loaded from: classes3.dex */
public final class e extends p0<Object> implements b.g.a.c.g0.i {
    private static final long serialVersionUID = 1;
    public final boolean _forPrimitive;

    /* compiled from: BooleanSerializer.java */
    public static final class a extends p0<Object> implements b.g.a.c.g0.i {
        private static final long serialVersionUID = 1;
        public final boolean _forPrimitive;

        public a(boolean z2) {
            super(z2 ? Boolean.TYPE : Boolean.class, false);
            this._forPrimitive = z2;
        }

        @Override // b.g.a.c.g0.i
        public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
            i.d dVarL = l(xVar, dVar, Boolean.class);
            return (dVarL == null || dVarL.e().f()) ? this : new e(this._forPrimitive);
        }

        @Override // b.g.a.c.n
        public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
            dVar.H(!Boolean.FALSE.equals(obj) ? 1 : 0);
        }

        @Override // b.g.a.c.g0.u.p0, b.g.a.c.n
        public final void g(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
            dVar.s(Boolean.TRUE.equals(obj));
        }
    }

    public e(boolean z2) {
        super(z2 ? Boolean.TYPE : Boolean.class, false);
        this._forPrimitive = z2;
    }

    @Override // b.g.a.c.g0.i
    public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        i.d dVarL = l(xVar, dVar, Boolean.class);
        return (dVarL == null || !dVarL.e().f()) ? this : new a(this._forPrimitive);
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        dVar.s(Boolean.TRUE.equals(obj));
    }

    @Override // b.g.a.c.g0.u.p0, b.g.a.c.n
    public final void g(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        dVar.s(Boolean.TRUE.equals(obj));
    }
}
