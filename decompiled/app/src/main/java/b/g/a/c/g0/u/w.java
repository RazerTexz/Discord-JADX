package b.g.a.c.g0.u;

import b.g.a.a.i;
import b.g.a.b.f;
import b.g.a.c.g0.u.v;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.math.BigDecimal;

/* compiled from: NumberSerializers.java */
/* loaded from: classes3.dex */
public abstract class w<T> extends p0<T> implements b.g.a.c.g0.i {
    public final boolean _isInt;
    public final f.b _numberType;
    public final String _schemaType;

    public w(Class<?> cls, f.b bVar, String str) {
        super(cls, false);
        this._numberType = bVar;
        this._schemaType = str;
        this._isInt = bVar == f.b.INT || bVar == f.b.LONG || bVar == f.b.BIG_INTEGER;
    }

    @Override // b.g.a.c.g0.i
    public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        i.d dVarL = l(xVar, dVar, this._handledType);
        if (dVarL == null || dVarL.e().ordinal() != 8) {
            return this;
        }
        if (this._handledType != BigDecimal.class) {
            return t0.k;
        }
        v vVar = v.k;
        return v.a.k;
    }
}
