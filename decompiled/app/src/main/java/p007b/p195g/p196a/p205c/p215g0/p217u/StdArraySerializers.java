package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContainerSerializer;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* compiled from: StdArraySerializers.java */
/* renamed from: b.g.a.c.g0.u.i0, reason: use source file name */
/* loaded from: classes3.dex */
public class StdArraySerializers {

    /* renamed from: a */
    public static final HashMap<String, JsonSerializer<?>> f4855a;

    /* compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    /* renamed from: b.g.a.c.g0.u.i0$a */
    public static class a extends ArraySerializerBase<boolean[]> {
        static {
            TypeFactory.f4925k.m2168j(Boolean.class);
        }

        public a() {
            super(boolean[].class);
        }

        @Override // p007b.p195g.p196a.p205c.JsonSerializer
        /* renamed from: d */
        public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
            return ((boolean[]) obj).length == 0;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase, p007b.p195g.p196a.p205c.JsonSerializer
        /* renamed from: f */
        public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            boolean[] zArr = (boolean[]) obj;
            int length = zArr.length;
            if (length == 1 && m2044r(serializerProvider)) {
                m2061u(zArr, jsonGenerator);
                return;
            }
            jsonGenerator.mo1649b0(zArr, length);
            m2061u(zArr, jsonGenerator);
            jsonGenerator.mo1663t();
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
        /* renamed from: p */
        public ContainerSerializer<?> mo1995p(TypeSerializer typeSerializer) {
            return this;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
        /* renamed from: q */
        public boolean mo1996q(Object obj) {
            return ((boolean[]) obj).length == 1;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase
        /* renamed from: s */
        public JsonSerializer<?> mo2037s(BeanProperty beanProperty, Boolean bool) {
            return new a(this, beanProperty, bool);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase
        /* renamed from: t */
        public /* bridge */ /* synthetic */ void mo2038t(boolean[] zArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            m2061u(zArr, jsonGenerator);
        }

        /* renamed from: u */
        public void m2061u(boolean[] zArr, JsonGenerator jsonGenerator) throws IOException {
            for (boolean z2 : zArr) {
                jsonGenerator.mo1662s(z2);
            }
        }

        public a(a aVar, BeanProperty beanProperty, Boolean bool) {
            super(aVar, beanProperty, bool);
        }
    }

    /* compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    /* renamed from: b.g.a.c.g0.u.i0$b */
    public static class b extends StdSerializer<char[]> {
        public b() {
            super(char[].class);
        }

        @Override // p007b.p195g.p196a.p205c.JsonSerializer
        /* renamed from: d */
        public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
            return ((char[]) obj).length == 0;
        }

        @Override // p007b.p195g.p196a.p205c.JsonSerializer
        /* renamed from: f */
        public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            char[] cArr = (char[]) obj;
            if (!serializerProvider.m2240D(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                jsonGenerator.mo1659m0(cArr, 0, cArr.length);
                return;
            }
            jsonGenerator.mo1649b0(cArr, cArr.length);
            int length = cArr.length;
            for (int i = 0; i < length; i++) {
                jsonGenerator.mo1659m0(cArr, i, 1);
            }
            jsonGenerator.mo1663t();
        }

        @Override // p007b.p195g.p196a.p205c.JsonSerializer
        /* renamed from: g */
        public void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
            WritableTypeId writableTypeIdMo1959e;
            char[] cArr = (char[]) obj;
            if (serializerProvider.m2240D(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS)) {
                writableTypeIdMo1959e = typeSerializer.mo1959e(jsonGenerator, typeSerializer.m1958d(cArr, JsonToken2.START_ARRAY));
                int length = cArr.length;
                for (int i = 0; i < length; i++) {
                    jsonGenerator.mo1659m0(cArr, i, 1);
                }
            } else {
                writableTypeIdMo1959e = typeSerializer.mo1959e(jsonGenerator, typeSerializer.m1958d(cArr, JsonToken2.VALUE_STRING));
                jsonGenerator.mo1659m0(cArr, 0, cArr.length);
            }
            typeSerializer.mo1960f(jsonGenerator, writableTypeIdMo1959e);
        }
    }

    /* compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    /* renamed from: b.g.a.c.g0.u.i0$c */
    public static class c extends ArraySerializerBase<double[]> {
        static {
            TypeFactory.f4925k.m2168j(Double.TYPE);
        }

        public c() {
            super(double[].class);
        }

        @Override // p007b.p195g.p196a.p205c.JsonSerializer
        /* renamed from: d */
        public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
            return ((double[]) obj).length == 0;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase, p007b.p195g.p196a.p205c.JsonSerializer
        /* renamed from: f */
        public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            double[] dArr = (double[]) obj;
            int i = 0;
            if (dArr.length == 1 && m2044r(serializerProvider)) {
                int length = dArr.length;
                while (i < length) {
                    jsonGenerator.mo1632C(dArr[i]);
                    i++;
                }
                return;
            }
            int length2 = dArr.length;
            Objects.requireNonNull(jsonGenerator);
            jsonGenerator.m1647a(dArr.length, 0, length2);
            jsonGenerator.mo1649b0(dArr, length2);
            int i2 = length2 + 0;
            while (i < i2) {
                jsonGenerator.mo1632C(dArr[i]);
                i++;
            }
            jsonGenerator.mo1663t();
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
        /* renamed from: p */
        public ContainerSerializer<?> mo1995p(TypeSerializer typeSerializer) {
            return this;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
        /* renamed from: q */
        public boolean mo1996q(Object obj) {
            return ((double[]) obj).length == 1;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase
        /* renamed from: s */
        public JsonSerializer<?> mo2037s(BeanProperty beanProperty, Boolean bool) {
            return new c(this, beanProperty, bool);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase
        /* renamed from: t */
        public void mo2038t(double[] dArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            for (double d : dArr) {
                jsonGenerator.mo1632C(d);
            }
        }

        public c(c cVar, BeanProperty beanProperty, Boolean bool) {
            super(cVar, beanProperty, bool);
        }
    }

    /* compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    /* renamed from: b.g.a.c.g0.u.i0$d */
    public static class d extends h<float[]> {
        static {
            TypeFactory.f4925k.m2168j(Float.TYPE);
        }

        public d() {
            super(float[].class);
        }

        @Override // p007b.p195g.p196a.p205c.JsonSerializer
        /* renamed from: d */
        public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
            return ((float[]) obj).length == 0;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase, p007b.p195g.p196a.p205c.JsonSerializer
        /* renamed from: f */
        public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            float[] fArr = (float[]) obj;
            int length = fArr.length;
            if (length == 1 && m2044r(serializerProvider)) {
                m2062u(fArr, jsonGenerator);
                return;
            }
            jsonGenerator.mo1649b0(fArr, length);
            m2062u(fArr, jsonGenerator);
            jsonGenerator.mo1663t();
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
        /* renamed from: q */
        public boolean mo1996q(Object obj) {
            return ((float[]) obj).length == 1;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase
        /* renamed from: s */
        public JsonSerializer<?> mo2037s(BeanProperty beanProperty, Boolean bool) {
            return new d(this, beanProperty, bool);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase
        /* renamed from: t */
        public /* bridge */ /* synthetic */ void mo2038t(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            m2062u((float[]) obj, jsonGenerator);
        }

        /* renamed from: u */
        public void m2062u(float[] fArr, JsonGenerator jsonGenerator) throws IOException {
            for (float f : fArr) {
                jsonGenerator.mo1633D(f);
            }
        }

        public d(d dVar, BeanProperty beanProperty, Boolean bool) {
            super(dVar, beanProperty, bool);
        }
    }

    /* compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    /* renamed from: b.g.a.c.g0.u.i0$e */
    public static class e extends ArraySerializerBase<int[]> {
        static {
            TypeFactory.f4925k.m2168j(Integer.TYPE);
        }

        public e() {
            super(int[].class);
        }

        @Override // p007b.p195g.p196a.p205c.JsonSerializer
        /* renamed from: d */
        public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
            return ((int[]) obj).length == 0;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase, p007b.p195g.p196a.p205c.JsonSerializer
        /* renamed from: f */
        public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            int[] iArr = (int[]) obj;
            int i = 0;
            if (iArr.length == 1 && m2044r(serializerProvider)) {
                int length = iArr.length;
                while (i < length) {
                    jsonGenerator.mo1634H(iArr[i]);
                    i++;
                }
                return;
            }
            int length2 = iArr.length;
            Objects.requireNonNull(jsonGenerator);
            jsonGenerator.m1647a(iArr.length, 0, length2);
            jsonGenerator.mo1649b0(iArr, length2);
            int i2 = length2 + 0;
            while (i < i2) {
                jsonGenerator.mo1634H(iArr[i]);
                i++;
            }
            jsonGenerator.mo1663t();
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
        /* renamed from: p */
        public ContainerSerializer<?> mo1995p(TypeSerializer typeSerializer) {
            return this;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
        /* renamed from: q */
        public boolean mo1996q(Object obj) {
            return ((int[]) obj).length == 1;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase
        /* renamed from: s */
        public JsonSerializer<?> mo2037s(BeanProperty beanProperty, Boolean bool) {
            return new e(this, beanProperty, bool);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase
        /* renamed from: t */
        public void mo2038t(int[] iArr, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            for (int i : iArr) {
                jsonGenerator.mo1634H(i);
            }
        }

        public e(e eVar, BeanProperty beanProperty, Boolean bool) {
            super(eVar, beanProperty, bool);
        }
    }

    /* compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    /* renamed from: b.g.a.c.g0.u.i0$f */
    public static class f extends h<long[]> {
        static {
            TypeFactory.f4925k.m2168j(Long.TYPE);
        }

        public f() {
            super(long[].class);
        }

        @Override // p007b.p195g.p196a.p205c.JsonSerializer
        /* renamed from: d */
        public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
            return ((long[]) obj).length == 0;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase, p007b.p195g.p196a.p205c.JsonSerializer
        /* renamed from: f */
        public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            long[] jArr = (long[]) obj;
            int i = 0;
            if (jArr.length == 1 && m2044r(serializerProvider)) {
                int length = jArr.length;
                while (i < length) {
                    jsonGenerator.mo1635I(jArr[i]);
                    i++;
                }
                return;
            }
            int length2 = jArr.length;
            Objects.requireNonNull(jsonGenerator);
            jsonGenerator.m1647a(jArr.length, 0, length2);
            jsonGenerator.mo1649b0(jArr, length2);
            int i2 = length2 + 0;
            while (i < i2) {
                jsonGenerator.mo1635I(jArr[i]);
                i++;
            }
            jsonGenerator.mo1663t();
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
        /* renamed from: q */
        public boolean mo1996q(Object obj) {
            return ((long[]) obj).length == 1;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase
        /* renamed from: s */
        public JsonSerializer<?> mo2037s(BeanProperty beanProperty, Boolean bool) {
            return new f(this, beanProperty, bool);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase
        /* renamed from: t */
        public void mo2038t(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            for (long j : (long[]) obj) {
                jsonGenerator.mo1635I(j);
            }
        }

        public f(f fVar, BeanProperty beanProperty, Boolean bool) {
            super(fVar, beanProperty, bool);
        }
    }

    /* compiled from: StdArraySerializers.java */
    @JacksonStdImpl
    /* renamed from: b.g.a.c.g0.u.i0$g */
    public static class g extends h<short[]> {
        static {
            TypeFactory.f4925k.m2168j(Short.TYPE);
        }

        public g() {
            super(short[].class);
        }

        @Override // p007b.p195g.p196a.p205c.JsonSerializer
        /* renamed from: d */
        public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
            return ((short[]) obj).length == 0;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase, p007b.p195g.p196a.p205c.JsonSerializer
        /* renamed from: f */
        public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            short[] sArr = (short[]) obj;
            int length = sArr.length;
            if (length == 1 && m2044r(serializerProvider)) {
                m2063u(sArr, jsonGenerator);
                return;
            }
            jsonGenerator.mo1649b0(sArr, length);
            m2063u(sArr, jsonGenerator);
            jsonGenerator.mo1663t();
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
        /* renamed from: q */
        public boolean mo1996q(Object obj) {
            return ((short[]) obj).length == 1;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase
        /* renamed from: s */
        public JsonSerializer<?> mo2037s(BeanProperty beanProperty, Boolean bool) {
            return new g(this, beanProperty, bool);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ArraySerializerBase
        /* renamed from: t */
        public /* bridge */ /* synthetic */ void mo2038t(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            m2063u((short[]) obj, jsonGenerator);
        }

        /* renamed from: u */
        public void m2063u(short[] sArr, JsonGenerator jsonGenerator) throws IOException {
            for (short s2 : sArr) {
                jsonGenerator.mo1634H(s2);
            }
        }

        public g(g gVar, BeanProperty beanProperty, Boolean bool) {
            super(gVar, beanProperty, bool);
        }
    }

    /* compiled from: StdArraySerializers.java */
    /* renamed from: b.g.a.c.g0.u.i0$h */
    public static abstract class h<T> extends ArraySerializerBase<T> {
        public h(Class<T> cls) {
            super(cls);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.ContainerSerializer
        /* renamed from: p */
        public final ContainerSerializer<?> mo1995p(TypeSerializer typeSerializer) {
            return this;
        }

        public h(h<T> hVar, BeanProperty beanProperty, Boolean bool) {
            super(hVar, beanProperty, bool);
        }
    }

    static {
        HashMap<String, JsonSerializer<?>> map = new HashMap<>();
        f4855a = map;
        map.put(boolean[].class.getName(), new a());
        map.put(byte[].class.getName(), new ByteArraySerializer2());
        map.put(char[].class.getName(), new b());
        map.put(short[].class.getName(), new g());
        map.put(int[].class.getName(), new e());
        map.put(long[].class.getName(), new f());
        map.put(float[].class.getName(), new d());
        map.put(double[].class.getName(), new c());
    }
}
