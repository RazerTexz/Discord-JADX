package p007b.p195g.p196a.p205c.p212e0.p213h;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.MapperFeature;
import p007b.p195g.p196a.p205c.p210c0.BasicBeanDescription;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;

/* JADX INFO: renamed from: b.g.a.c.e0.h.l, reason: use source file name */
/* JADX INFO: compiled from: TypeNameIdResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class TypeNameIdResolver extends TypeIdResolverBase {

    /* JADX INFO: renamed from: c */
    public final MapperConfig<?> f4776c;

    /* JADX INFO: renamed from: d */
    public final ConcurrentHashMap<String, String> f4777d;

    /* JADX INFO: renamed from: e */
    public final Map<String, JavaType> f4778e;

    public TypeNameIdResolver(MapperConfig<?> mapperConfig, JavaType javaType, ConcurrentHashMap<String, String> concurrentHashMap, HashMap<String, JavaType> map) {
        super(javaType, mapperConfig._base._typeFactory);
        this.f4776c = mapperConfig;
        this.f4777d = concurrentHashMap;
        this.f4778e = map;
        mapperConfig.m2279q(MapperFeature.ACCEPT_CASE_INSENSITIVE_VALUES);
    }

    /* JADX INFO: renamed from: d */
    public static String m1967d(Class<?> cls) {
        String name = cls.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf < 0 ? name : name.substring(iLastIndexOf + 1);
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.TypeIdResolver
    /* JADX INFO: renamed from: a */
    public String mo1946a(Object obj) {
        return m1968e(obj.getClass());
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.TypeIdResolver
    /* JADX INFO: renamed from: c */
    public String mo1948c(Object obj, Class<?> cls) {
        return obj == null ? m1968e(cls) : m1968e(obj.getClass());
    }

    /* JADX INFO: renamed from: e */
    public String m1968e(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        String name = cls.getName();
        String strM1967d = this.f4777d.get(name);
        if (strM1967d == null) {
            Class<?> cls2 = this.f4774a.m2160b(null, cls, TypeFactory.f4926l)._class;
            if (this.f4776c.m2278p()) {
                strM1967d = this.f4776c.m2267e().mo1759O(((BasicBeanDescription) this.f4776c.m2277o(cls2)).f4736f);
            }
            if (strM1967d == null) {
                strM1967d = m1967d(cls2);
            }
            this.f4777d.put(name, strM1967d);
        }
        return strM1967d;
    }

    public String toString() {
        return String.format("[%s; id-to-type=%s]", TypeNameIdResolver.class.getName(), this.f4778e);
    }
}
