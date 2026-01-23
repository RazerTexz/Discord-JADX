package p007b.p195g.p196a.p205c.p221z;

import java.io.Serializable;
import java.util.Objects;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p197a.JsonSetter;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.BeanDescription;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.MapperFeature;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedClass;
import p007b.p195g.p196a.p205c.p210c0.BasicBeanDescription;
import p007b.p195g.p196a.p205c.p210c0.BasicClassIntrospector;
import p007b.p195g.p196a.p205c.p210c0.ClassIntrospector;
import p007b.p195g.p196a.p205c.p210c0.NopAnnotationIntrospector;
import p007b.p195g.p196a.p205c.p210c0.VisibilityChecker;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;

/* JADX INFO: renamed from: b.g.a.c.z.l, reason: use source file name */
/* JADX INFO: compiled from: MapperConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MapperConfig<T extends MapperConfig<T>> implements ClassIntrospector.a, Serializable {
    private static final long serialVersionUID = 2;
    public final BaseSettings _base;
    public final int _mapperFeatures;

    static {
        JsonInclude.b bVar = JsonInclude.b.f4436j;
        JsonInclude.b bVar2 = JsonInclude.b.f4436j;
        JsonFormat.d dVar = JsonFormat.d.f4421j;
    }

    public MapperConfig(BaseSettings baseSettings, int i) {
        this._base = baseSettings;
        this._mapperFeatures = i;
    }

    /* JADX INFO: renamed from: c */
    public static <F extends Enum<F> & ConfigFeature> int m2264c(Class<F> cls) {
        int iMo2091g = 0;
        for (Object obj : (Enum[]) cls.getEnumConstants()) {
            ConfigFeature configFeature = (ConfigFeature) obj;
            if (configFeature.mo2090f()) {
                iMo2091g |= configFeature.mo2091g();
            }
        }
        return iMo2091g;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m2265b() {
        return m2279q(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS);
    }

    /* JADX INFO: renamed from: d */
    public final JavaType m2266d(Class<?> cls) {
        return this._base._typeFactory.m2160b(null, cls, TypeFactory.f4926l);
    }

    /* JADX INFO: renamed from: e */
    public AnnotationIntrospector m2267e() {
        return m2279q(MapperFeature.USE_ANNOTATIONS) ? this._base._annotationIntrospector : NopAnnotationIntrospector.f4764j;
    }

    /* JADX INFO: renamed from: f */
    public abstract ConfigOverride mo2268f(Class<?> cls);

    /* JADX INFO: renamed from: g */
    public abstract JsonInclude.b mo2269g(Class<?> cls, Class<?> cls2);

    /* JADX INFO: renamed from: h */
    public abstract Boolean mo2270h();

    /* JADX INFO: renamed from: i */
    public abstract JsonFormat.d mo2271i(Class<?> cls);

    /* JADX INFO: renamed from: j */
    public abstract JsonInclude.b mo2272j(Class<?> cls);

    /* JADX INFO: renamed from: k */
    public JsonInclude.b m2273k(Class<?> cls, JsonInclude.b bVar) {
        Objects.requireNonNull(mo2268f(cls));
        return bVar;
    }

    /* JADX INFO: renamed from: l */
    public abstract JsonSetter.a mo2274l();

    /* JADX INFO: renamed from: m */
    public abstract VisibilityChecker<?> mo2275m(Class<?> cls, AnnotatedClass annotatedClass);

    /* JADX INFO: renamed from: n */
    public BeanDescription m2276n(JavaType javaType) {
        BasicClassIntrospector basicClassIntrospector = (BasicClassIntrospector) this._base._classIntrospector;
        BasicBeanDescription basicBeanDescriptionM1920a = basicClassIntrospector.m1920a(this, javaType);
        return basicBeanDescriptionM1920a == null ? BasicBeanDescription.m1918e(this, javaType, basicClassIntrospector.m1921b(this, javaType, this)) : basicBeanDescriptionM1920a;
    }

    /* JADX INFO: renamed from: o */
    public BeanDescription m2277o(Class<?> cls) {
        return m2276n(this._base._typeFactory.m2160b(null, cls, TypeFactory.f4926l));
    }

    /* JADX INFO: renamed from: p */
    public final boolean m2278p() {
        return m2279q(MapperFeature.USE_ANNOTATIONS);
    }

    /* JADX INFO: renamed from: q */
    public final boolean m2279q(MapperFeature mapperFeature) {
        return mapperFeature.m2222h(this._mapperFeatures);
    }

    public MapperConfig(MapperConfig<T> mapperConfig, int i) {
        this._base = mapperConfig._base;
        this._mapperFeatures = i;
    }
}
