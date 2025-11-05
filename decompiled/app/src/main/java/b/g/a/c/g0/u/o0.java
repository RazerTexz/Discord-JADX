package b.g.a.c.g0.u;

import b.g.a.c.g0.t.l;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/* compiled from: StdKeySerializers.java */
/* loaded from: classes3.dex */
public abstract class o0 {
    public static final b.g.a.c.n<Object> a = new d();

    /* compiled from: StdKeySerializers.java */
    public static class a extends q0<Object> {
        public final int _typeId;

        public a(int i, Class<?> cls) {
            super(cls, false);
            this._typeId = i;
        }

        @Override // b.g.a.c.n
        public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
            String strValueOf;
            switch (this._typeId) {
                case 1:
                    Date date = (Date) obj;
                    Objects.requireNonNull(xVar);
                    if (!xVar.D(b.g.a.c.w.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
                        dVar.y(xVar.j().format(date));
                        break;
                    } else {
                        dVar.y(String.valueOf(date.getTime()));
                        break;
                    }
                case 2:
                    long timeInMillis = ((Calendar) obj).getTimeInMillis();
                    Objects.requireNonNull(xVar);
                    if (!xVar.D(b.g.a.c.w.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
                        dVar.y(xVar.j().format(new Date(timeInMillis)));
                        break;
                    } else {
                        dVar.y(String.valueOf(timeInMillis));
                        break;
                    }
                case 3:
                    dVar.y(((Class) obj).getName());
                    break;
                case 4:
                    if (xVar.D(b.g.a.c.w.WRITE_ENUMS_USING_TO_STRING)) {
                        strValueOf = obj.toString();
                    } else {
                        Enum r3 = (Enum) obj;
                        strValueOf = xVar.D(b.g.a.c.w.WRITE_ENUM_KEYS_USING_INDEX) ? String.valueOf(r3.ordinal()) : r3.name();
                    }
                    dVar.y(strValueOf);
                    break;
                case 5:
                case 6:
                    long jLongValue = ((Number) obj).longValue();
                    Objects.requireNonNull(dVar);
                    dVar.y(Long.toString(jLongValue));
                    break;
                case 7:
                    dVar.y(xVar._config._base._defaultBase64.a((byte[]) obj));
                    break;
                default:
                    dVar.y(obj.toString());
                    break;
            }
        }
    }

    /* compiled from: StdKeySerializers.java */
    public static class b extends q0<Object> {
        public transient b.g.a.c.g0.t.l k;

        public b() {
            super(String.class, false);
            this.k = l.b.f706b;
        }

        @Override // b.g.a.c.n
        public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
            Class<?> cls = obj.getClass();
            b.g.a.c.g0.t.l lVar = this.k;
            b.g.a.c.n<Object> nVarC = lVar.c(cls);
            if (nVarC == null) {
                if (cls == Object.class) {
                    nVarC = new a(8, cls);
                    this.k = lVar.b(cls, nVarC);
                } else {
                    nVarC = xVar.o(xVar._config._base._typeFactory.b(null, cls, b.g.a.c.h0.n.l), null);
                    b.g.a.c.g0.t.l lVarB = lVar.b(cls, nVarC);
                    if (lVar != lVarB) {
                        this.k = lVarB;
                    }
                }
            }
            nVarC.f(obj, dVar, xVar);
        }

        public Object readResolve() {
            this.k = l.b.f706b;
            return this;
        }
    }

    /* compiled from: StdKeySerializers.java */
    public static class c extends q0<Object> {
        public final b.g.a.c.i0.f _values;

        public c(Class<?> cls, b.g.a.c.i0.f fVar) {
            super(cls, false);
            this._values = fVar;
        }

        @Override // b.g.a.c.n
        public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
            if (xVar.D(b.g.a.c.w.WRITE_ENUMS_USING_TO_STRING)) {
                dVar.y(obj.toString());
                return;
            }
            Enum<?> r2 = (Enum) obj;
            if (xVar.D(b.g.a.c.w.WRITE_ENUM_KEYS_USING_INDEX)) {
                dVar.y(String.valueOf(r2.ordinal()));
            } else {
                dVar.x(this._values.c(r2));
            }
        }
    }

    /* compiled from: StdKeySerializers.java */
    public static class d extends q0<Object> {
        public d() {
            super(String.class, false);
        }

        @Override // b.g.a.c.n
        public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
            dVar.y((String) obj);
        }
    }
}
