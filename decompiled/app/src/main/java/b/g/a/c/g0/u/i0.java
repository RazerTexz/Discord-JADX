package b.g.a.c.g0.u;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

/* compiled from: StdArraySerializers.java */
/* loaded from: classes3.dex */
public class i0 {
    public static final HashMap<String, b.g.a.c.n<?>> a;

    /* compiled from: StdArraySerializers.java */
    @b.g.a.c.y.a
    public static class a extends b.g.a.c.g0.u.a<boolean[]> {
        static {
            b.g.a.c.h0.n.k.j(Boolean.class);
        }

        public a() {
            super(boolean[].class);
        }

        @Override // b.g.a.c.n
        public boolean d(b.g.a.c.x xVar, Object obj) {
            return ((boolean[]) obj).length == 0;
        }

        @Override // b.g.a.c.g0.u.a, b.g.a.c.n
        public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
            boolean[] zArr = (boolean[]) obj;
            int length = zArr.length;
            if (length == 1 && r(xVar)) {
                u(zArr, dVar);
                return;
            }
            dVar.b0(zArr, length);
            u(zArr, dVar);
            dVar.t();
        }

        @Override // b.g.a.c.g0.h
        public b.g.a.c.g0.h<?> p(b.g.a.c.e0.g gVar) {
            return this;
        }

        @Override // b.g.a.c.g0.h
        public boolean q(Object obj) {
            return ((boolean[]) obj).length == 1;
        }

        @Override // b.g.a.c.g0.u.a
        public b.g.a.c.n<?> s(b.g.a.c.d dVar, Boolean bool) {
            return new a(this, dVar, bool);
        }

        @Override // b.g.a.c.g0.u.a
        public /* bridge */ /* synthetic */ void t(boolean[] zArr, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
            u(zArr, dVar);
        }

        public void u(boolean[] zArr, b.g.a.b.d dVar) throws IOException {
            for (boolean z2 : zArr) {
                dVar.s(z2);
            }
        }

        public a(a aVar, b.g.a.c.d dVar, Boolean bool) {
            super(aVar, dVar, bool);
        }
    }

    /* compiled from: StdArraySerializers.java */
    @b.g.a.c.y.a
    public static class b extends q0<char[]> {
        public b() {
            super(char[].class);
        }

        @Override // b.g.a.c.n
        public boolean d(b.g.a.c.x xVar, Object obj) {
            return ((char[]) obj).length == 0;
        }

        @Override // b.g.a.c.n
        public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
            char[] cArr = (char[]) obj;
            if (!xVar.D(b.g.a.c.w.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                dVar.m0(cArr, 0, cArr.length);
                return;
            }
            dVar.b0(cArr, cArr.length);
            int length = cArr.length;
            for (int i = 0; i < length; i++) {
                dVar.m0(cArr, i, 1);
            }
            dVar.t();
        }

        @Override // b.g.a.c.n
        public void g(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
            b.g.a.b.s.b bVarE;
            char[] cArr = (char[]) obj;
            if (xVar.D(b.g.a.c.w.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                bVarE = gVar.e(dVar, gVar.d(cArr, b.g.a.b.h.START_ARRAY));
                int length = cArr.length;
                for (int i = 0; i < length; i++) {
                    dVar.m0(cArr, i, 1);
                }
            } else {
                bVarE = gVar.e(dVar, gVar.d(cArr, b.g.a.b.h.VALUE_STRING));
                dVar.m0(cArr, 0, cArr.length);
            }
            gVar.f(dVar, bVarE);
        }
    }

    /* compiled from: StdArraySerializers.java */
    @b.g.a.c.y.a
    public static class c extends b.g.a.c.g0.u.a<double[]> {
        static {
            b.g.a.c.h0.n.k.j(Double.TYPE);
        }

        public c() {
            super(double[].class);
        }

        @Override // b.g.a.c.n
        public boolean d(b.g.a.c.x xVar, Object obj) {
            return ((double[]) obj).length == 0;
        }

        @Override // b.g.a.c.g0.u.a, b.g.a.c.n
        public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
            double[] dArr = (double[]) obj;
            int i = 0;
            if (dArr.length == 1 && r(xVar)) {
                int length = dArr.length;
                while (i < length) {
                    dVar.C(dArr[i]);
                    i++;
                }
                return;
            }
            int length2 = dArr.length;
            Objects.requireNonNull(dVar);
            dVar.a(dArr.length, 0, length2);
            dVar.b0(dArr, length2);
            int i2 = length2 + 0;
            while (i < i2) {
                dVar.C(dArr[i]);
                i++;
            }
            dVar.t();
        }

        @Override // b.g.a.c.g0.h
        public b.g.a.c.g0.h<?> p(b.g.a.c.e0.g gVar) {
            return this;
        }

        @Override // b.g.a.c.g0.h
        public boolean q(Object obj) {
            return ((double[]) obj).length == 1;
        }

        @Override // b.g.a.c.g0.u.a
        public b.g.a.c.n<?> s(b.g.a.c.d dVar, Boolean bool) {
            return new c(this, dVar, bool);
        }

        @Override // b.g.a.c.g0.u.a
        public void t(double[] dArr, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
            for (double d : dArr) {
                dVar.C(d);
            }
        }

        public c(c cVar, b.g.a.c.d dVar, Boolean bool) {
            super(cVar, dVar, bool);
        }
    }

    /* compiled from: StdArraySerializers.java */
    @b.g.a.c.y.a
    public static class d extends h<float[]> {
        static {
            b.g.a.c.h0.n.k.j(Float.TYPE);
        }

        public d() {
            super(float[].class);
        }

        @Override // b.g.a.c.n
        public boolean d(b.g.a.c.x xVar, Object obj) {
            return ((float[]) obj).length == 0;
        }

        @Override // b.g.a.c.g0.u.a, b.g.a.c.n
        public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
            float[] fArr = (float[]) obj;
            int length = fArr.length;
            if (length == 1 && r(xVar)) {
                u(fArr, dVar);
                return;
            }
            dVar.b0(fArr, length);
            u(fArr, dVar);
            dVar.t();
        }

        @Override // b.g.a.c.g0.h
        public boolean q(Object obj) {
            return ((float[]) obj).length == 1;
        }

        @Override // b.g.a.c.g0.u.a
        public b.g.a.c.n<?> s(b.g.a.c.d dVar, Boolean bool) {
            return new d(this, dVar, bool);
        }

        @Override // b.g.a.c.g0.u.a
        public /* bridge */ /* synthetic */ void t(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
            u((float[]) obj, dVar);
        }

        public void u(float[] fArr, b.g.a.b.d dVar) throws IOException {
            for (float f : fArr) {
                dVar.D(f);
            }
        }

        public d(d dVar, b.g.a.c.d dVar2, Boolean bool) {
            super(dVar, dVar2, bool);
        }
    }

    /* compiled from: StdArraySerializers.java */
    @b.g.a.c.y.a
    public static class e extends b.g.a.c.g0.u.a<int[]> {
        static {
            b.g.a.c.h0.n.k.j(Integer.TYPE);
        }

        public e() {
            super(int[].class);
        }

        @Override // b.g.a.c.n
        public boolean d(b.g.a.c.x xVar, Object obj) {
            return ((int[]) obj).length == 0;
        }

        @Override // b.g.a.c.g0.u.a, b.g.a.c.n
        public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
            int[] iArr = (int[]) obj;
            int i = 0;
            if (iArr.length == 1 && r(xVar)) {
                int length = iArr.length;
                while (i < length) {
                    dVar.H(iArr[i]);
                    i++;
                }
                return;
            }
            int length2 = iArr.length;
            Objects.requireNonNull(dVar);
            dVar.a(iArr.length, 0, length2);
            dVar.b0(iArr, length2);
            int i2 = length2 + 0;
            while (i < i2) {
                dVar.H(iArr[i]);
                i++;
            }
            dVar.t();
        }

        @Override // b.g.a.c.g0.h
        public b.g.a.c.g0.h<?> p(b.g.a.c.e0.g gVar) {
            return this;
        }

        @Override // b.g.a.c.g0.h
        public boolean q(Object obj) {
            return ((int[]) obj).length == 1;
        }

        @Override // b.g.a.c.g0.u.a
        public b.g.a.c.n<?> s(b.g.a.c.d dVar, Boolean bool) {
            return new e(this, dVar, bool);
        }

        @Override // b.g.a.c.g0.u.a
        public void t(int[] iArr, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
            for (int i : iArr) {
                dVar.H(i);
            }
        }

        public e(e eVar, b.g.a.c.d dVar, Boolean bool) {
            super(eVar, dVar, bool);
        }
    }

    /* compiled from: StdArraySerializers.java */
    @b.g.a.c.y.a
    public static class f extends h<long[]> {
        static {
            b.g.a.c.h0.n.k.j(Long.TYPE);
        }

        public f() {
            super(long[].class);
        }

        @Override // b.g.a.c.n
        public boolean d(b.g.a.c.x xVar, Object obj) {
            return ((long[]) obj).length == 0;
        }

        @Override // b.g.a.c.g0.u.a, b.g.a.c.n
        public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
            long[] jArr = (long[]) obj;
            int i = 0;
            if (jArr.length == 1 && r(xVar)) {
                int length = jArr.length;
                while (i < length) {
                    dVar.I(jArr[i]);
                    i++;
                }
                return;
            }
            int length2 = jArr.length;
            Objects.requireNonNull(dVar);
            dVar.a(jArr.length, 0, length2);
            dVar.b0(jArr, length2);
            int i2 = length2 + 0;
            while (i < i2) {
                dVar.I(jArr[i]);
                i++;
            }
            dVar.t();
        }

        @Override // b.g.a.c.g0.h
        public boolean q(Object obj) {
            return ((long[]) obj).length == 1;
        }

        @Override // b.g.a.c.g0.u.a
        public b.g.a.c.n<?> s(b.g.a.c.d dVar, Boolean bool) {
            return new f(this, dVar, bool);
        }

        @Override // b.g.a.c.g0.u.a
        public void t(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
            for (long j : (long[]) obj) {
                dVar.I(j);
            }
        }

        public f(f fVar, b.g.a.c.d dVar, Boolean bool) {
            super(fVar, dVar, bool);
        }
    }

    /* compiled from: StdArraySerializers.java */
    @b.g.a.c.y.a
    public static class g extends h<short[]> {
        static {
            b.g.a.c.h0.n.k.j(Short.TYPE);
        }

        public g() {
            super(short[].class);
        }

        @Override // b.g.a.c.n
        public boolean d(b.g.a.c.x xVar, Object obj) {
            return ((short[]) obj).length == 0;
        }

        @Override // b.g.a.c.g0.u.a, b.g.a.c.n
        public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
            short[] sArr = (short[]) obj;
            int length = sArr.length;
            if (length == 1 && r(xVar)) {
                u(sArr, dVar);
                return;
            }
            dVar.b0(sArr, length);
            u(sArr, dVar);
            dVar.t();
        }

        @Override // b.g.a.c.g0.h
        public boolean q(Object obj) {
            return ((short[]) obj).length == 1;
        }

        @Override // b.g.a.c.g0.u.a
        public b.g.a.c.n<?> s(b.g.a.c.d dVar, Boolean bool) {
            return new g(this, dVar, bool);
        }

        @Override // b.g.a.c.g0.u.a
        public /* bridge */ /* synthetic */ void t(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
            u((short[]) obj, dVar);
        }

        public void u(short[] sArr, b.g.a.b.d dVar) throws IOException {
            for (short s2 : sArr) {
                dVar.H(s2);
            }
        }

        public g(g gVar, b.g.a.c.d dVar, Boolean bool) {
            super(gVar, dVar, bool);
        }
    }

    /* compiled from: StdArraySerializers.java */
    public static abstract class h<T> extends b.g.a.c.g0.u.a<T> {
        public h(Class<T> cls) {
            super(cls);
        }

        @Override // b.g.a.c.g0.h
        public final b.g.a.c.g0.h<?> p(b.g.a.c.e0.g gVar) {
            return this;
        }

        public h(h<T> hVar, b.g.a.c.d dVar, Boolean bool) {
            super(hVar, dVar, bool);
        }
    }

    static {
        HashMap<String, b.g.a.c.n<?>> map = new HashMap<>();
        a = map;
        map.put(boolean[].class.getName(), new a());
        map.put(byte[].class.getName(), new b.g.a.c.g0.u.f());
        map.put(char[].class.getName(), new b());
        map.put(short[].class.getName(), new g());
        map.put(int[].class.getName(), new e());
        map.put(long[].class.getName(), new f());
        map.put(float[].class.getName(), new d());
        map.put(double[].class.getName(), new c());
    }
}
