package b.g.a.c.g0.u;

import b.g.a.a.i;
import b.g.a.b.d;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: NumberSerializer.java */
@b.g.a.c.y.a
/* loaded from: classes3.dex */
public class v extends p0<Number> implements b.g.a.c.g0.i {
    public static final v k = new v(Number.class);
    public final boolean _isInt;

    /* compiled from: NumberSerializer.java */
    public static final class a extends u0 {
        public static final a k = new a();

        public a() {
            super(BigDecimal.class);
        }

        @Override // b.g.a.c.g0.u.u0, b.g.a.c.n
        public boolean d(b.g.a.c.x xVar, Object obj) {
            return false;
        }

        @Override // b.g.a.c.g0.u.u0, b.g.a.c.n
        public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
            String string;
            if (dVar.d(d.a.WRITE_BIGDECIMAL_AS_PLAIN)) {
                BigDecimal bigDecimal = (BigDecimal) obj;
                int iScale = bigDecimal.scale();
                if (!(iScale >= -9999 && iScale <= 9999)) {
                    xVar.G(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", Integer.valueOf(bigDecimal.scale()), 9999, 9999), new Object[0]);
                    throw null;
                }
                string = bigDecimal.toPlainString();
            } else {
                string = obj.toString();
            }
            dVar.j0(string);
        }

        @Override // b.g.a.c.g0.u.u0
        public String p(Object obj) {
            throw new IllegalStateException();
        }
    }

    public v(Class<? extends Number> cls) {
        super(cls, false);
        this._isInt = cls == BigInteger.class;
    }

    @Override // b.g.a.c.g0.i
    public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        i.d dVarL = l(xVar, dVar, this._handledType);
        return (dVarL == null || dVarL.e().ordinal() != 8) ? this : this._handledType == BigDecimal.class ? a.k : t0.k;
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        Number number = (Number) obj;
        if (number instanceof BigDecimal) {
            dVar.L((BigDecimal) number);
            return;
        }
        if (number instanceof BigInteger) {
            dVar.N((BigInteger) number);
            return;
        }
        if (number instanceof Long) {
            dVar.I(number.longValue());
            return;
        }
        if (number instanceof Double) {
            dVar.C(number.doubleValue());
            return;
        }
        if (number instanceof Float) {
            dVar.D(number.floatValue());
        } else if ((number instanceof Integer) || (number instanceof Byte) || (number instanceof Short)) {
            dVar.H(number.intValue());
        } else {
            dVar.J(number.toString());
        }
    }
}
