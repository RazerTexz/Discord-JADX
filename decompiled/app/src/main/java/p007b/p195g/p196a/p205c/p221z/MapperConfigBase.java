package p007b.p195g.p196a.p205c.p221z;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import p007b.p195g.p196a.p197a.JsonAutoDetect;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p197a.JsonIgnoreProperties;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p197a.JsonSetter;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.MapperFeature;
import p007b.p195g.p196a.p205c.PropertyName;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedClass;
import p007b.p195g.p196a.p205c.p210c0.SimpleMixInResolver;
import p007b.p195g.p196a.p205c.p210c0.VisibilityChecker;
import p007b.p195g.p196a.p205c.p212e0.SubtypeResolver;
import p007b.p195g.p196a.p205c.p219i0.RootNameLookup;
import p007b.p195g.p196a.p205c.p221z.ConfigFeature;
import p007b.p195g.p196a.p205c.p221z.ConfigOverride;
import p007b.p195g.p196a.p205c.p221z.ContextAttributes;
import p007b.p195g.p196a.p205c.p221z.MapperConfigBase;

/* compiled from: MapperConfigBase.java */
/* renamed from: b.g.a.c.z.m, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class MapperConfigBase<CFG extends ConfigFeature, T extends MapperConfigBase<CFG, T>> extends MapperConfig<T> implements Serializable {

    /* renamed from: j */
    public static final int f5095j = MapperConfig.m2264c(MapperFeature.class);

    /* renamed from: k */
    public static final int f5096k = (((MapperFeature.AUTO_DETECT_FIELDS.mo2091g() | MapperFeature.AUTO_DETECT_GETTERS.mo2091g()) | MapperFeature.AUTO_DETECT_IS_GETTERS.mo2091g()) | MapperFeature.AUTO_DETECT_SETTERS.mo2091g()) | MapperFeature.AUTO_DETECT_CREATORS.mo2091g();
    public final ContextAttributes _attributes;
    public final ConfigOverrides _configOverrides;
    public final SimpleMixInResolver _mixIns;
    public final PropertyName _rootName;
    public final RootNameLookup _rootNames;
    public final SubtypeResolver _subtypeResolver;
    public final Class<?> _view;

    public MapperConfigBase(BaseSettings baseSettings, SubtypeResolver subtypeResolver, SimpleMixInResolver simpleMixInResolver, RootNameLookup rootNameLookup, ConfigOverrides configOverrides) {
        super(baseSettings, f5095j);
        this._mixIns = simpleMixInResolver;
        this._subtypeResolver = subtypeResolver;
        this._rootNames = rootNameLookup;
        this._rootName = null;
        this._view = null;
        this._attributes = ContextAttributes.a.f5087j;
        this._configOverrides = configOverrides;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.ClassIntrospector.a
    /* renamed from: a */
    public final Class<?> mo1885a(Class<?> cls) {
        return this._mixIns.mo1885a(cls);
    }

    @Override // p007b.p195g.p196a.p205c.p221z.MapperConfig
    /* renamed from: f */
    public final ConfigOverride mo2268f(Class<?> cls) {
        ConfigOverride configOverrideM2263a = this._configOverrides.m2263a(cls);
        return configOverrideM2263a == null ? ConfigOverride.a.f5081a : configOverrideM2263a;
    }

    @Override // p007b.p195g.p196a.p205c.p221z.MapperConfig
    /* renamed from: g */
    public final JsonInclude.b mo2269g(Class<?> cls, Class<?> cls2) {
        this._configOverrides.m2263a(cls2);
        JsonInclude.b bVarMo2272j = mo2272j(cls);
        if (bVarMo2272j == null) {
            return null;
        }
        return bVarMo2272j.m1618a(null);
    }

    @Override // p007b.p195g.p196a.p205c.p221z.MapperConfig
    /* renamed from: h */
    public Boolean mo2270h() {
        return this._configOverrides._defaultMergeable;
    }

    @Override // p007b.p195g.p196a.p205c.p221z.MapperConfig
    /* renamed from: i */
    public final JsonFormat.d mo2271i(Class<?> cls) {
        ConfigOverrides configOverrides = this._configOverrides;
        Map<Class<?>, ?> map = configOverrides._overrides;
        if (map != null) {
        }
        Boolean bool = configOverrides._defaultLeniency;
        if (bool == null) {
            return JsonFormat.d.f4421j;
        }
        return new JsonFormat.d("", null, null, null, null, JsonFormat.b.f4406a, Boolean.valueOf(bool.booleanValue()));
    }

    @Override // p007b.p195g.p196a.p205c.p221z.MapperConfig
    /* renamed from: j */
    public final JsonInclude.b mo2272j(Class<?> cls) {
        this._configOverrides.m2263a(cls);
        JsonInclude.b bVar = this._configOverrides._defaultInclusion;
        if (bVar == null) {
            return null;
        }
        return bVar.m1618a(null);
    }

    @Override // p007b.p195g.p196a.p205c.p221z.MapperConfig
    /* renamed from: l */
    public final JsonSetter.a mo2274l() {
        return this._configOverrides._defaultSetterInfo;
    }

    @Override // p007b.p195g.p196a.p205c.p221z.MapperConfig
    /* renamed from: m */
    public final VisibilityChecker<?> mo2275m(Class<?> cls, AnnotatedClass annotatedClass) {
        JsonAutoDetect.a aVar = JsonAutoDetect.a.NONE;
        VisibilityChecker<?> visibilityChecker = this._configOverrides._visibilityChecker;
        int i = this._mapperFeatures;
        int i2 = f5096k;
        VisibilityChecker<?> aVar2 = visibilityChecker;
        if ((i & i2) != i2) {
            VisibilityChecker<?> aVar3 = visibilityChecker;
            if (!m2279q(MapperFeature.AUTO_DETECT_FIELDS)) {
                VisibilityChecker.a aVar4 = (VisibilityChecker.a) visibilityChecker;
                JsonAutoDetect.a aVar5 = aVar4._fieldMinLevel;
                aVar3 = aVar4;
                if (aVar5 != aVar) {
                    aVar3 = new VisibilityChecker.a(aVar4._getterMinLevel, aVar4._isGetterMinLevel, aVar4._setterMinLevel, aVar4._creatorMinLevel, aVar);
                }
            }
            VisibilityChecker<?> aVar6 = aVar3;
            if (!m2279q(MapperFeature.AUTO_DETECT_GETTERS)) {
                VisibilityChecker.a aVar7 = (VisibilityChecker.a) aVar3;
                JsonAutoDetect.a aVar8 = aVar7._getterMinLevel;
                aVar6 = aVar7;
                if (aVar8 != aVar) {
                    aVar6 = new VisibilityChecker.a(aVar, aVar7._isGetterMinLevel, aVar7._setterMinLevel, aVar7._creatorMinLevel, aVar7._fieldMinLevel);
                }
            }
            VisibilityChecker<?> aVar9 = aVar6;
            if (!m2279q(MapperFeature.AUTO_DETECT_IS_GETTERS)) {
                VisibilityChecker.a aVar10 = (VisibilityChecker.a) aVar6;
                JsonAutoDetect.a aVar11 = aVar10._isGetterMinLevel;
                aVar9 = aVar10;
                if (aVar11 != aVar) {
                    aVar9 = new VisibilityChecker.a(aVar10._getterMinLevel, aVar, aVar10._setterMinLevel, aVar10._creatorMinLevel, aVar10._fieldMinLevel);
                }
            }
            VisibilityChecker<?> aVar12 = aVar9;
            if (!m2279q(MapperFeature.AUTO_DETECT_SETTERS)) {
                VisibilityChecker.a aVar13 = (VisibilityChecker.a) aVar9;
                JsonAutoDetect.a aVar14 = aVar13._setterMinLevel;
                aVar12 = aVar13;
                if (aVar14 != aVar) {
                    aVar12 = new VisibilityChecker.a(aVar13._getterMinLevel, aVar13._isGetterMinLevel, aVar, aVar13._creatorMinLevel, aVar13._fieldMinLevel);
                }
            }
            aVar2 = aVar12;
            if (!m2279q(MapperFeature.AUTO_DETECT_CREATORS)) {
                VisibilityChecker.a aVar15 = (VisibilityChecker.a) aVar12;
                JsonAutoDetect.a aVar16 = aVar15._creatorMinLevel;
                aVar2 = aVar15;
                if (aVar16 != aVar) {
                    aVar2 = new VisibilityChecker.a(aVar15._getterMinLevel, aVar15._isGetterMinLevel, aVar15._setterMinLevel, aVar, aVar15._fieldMinLevel);
                }
            }
        }
        AnnotationIntrospector annotationIntrospectorM2267e = m2267e();
        VisibilityChecker<?> visibilityCheckerMo1773b = aVar2;
        if (annotationIntrospectorM2267e != null) {
            visibilityCheckerMo1773b = annotationIntrospectorM2267e.mo1773b(annotatedClass, aVar2);
        }
        if (this._configOverrides.m2263a(cls) == null) {
            return visibilityCheckerMo1773b;
        }
        VisibilityChecker.a aVar17 = (VisibilityChecker.a) visibilityCheckerMo1773b;
        Objects.requireNonNull(aVar17);
        return aVar17;
    }

    /* renamed from: r */
    public abstract T mo1969r(int i);

    /* renamed from: s */
    public final JsonIgnoreProperties.a m2280s(Class<?> cls, AnnotatedClass annotatedClass) {
        AnnotationIntrospector annotationIntrospectorM2267e = m2267e();
        JsonIgnoreProperties.a aVarMo1800x = annotationIntrospectorM2267e == null ? null : annotationIntrospectorM2267e.mo1800x(this, annotatedClass);
        this._configOverrides.m2263a(cls);
        JsonIgnoreProperties.a aVar = JsonIgnoreProperties.a.f4427j;
        if (aVarMo1800x == null) {
            return null;
        }
        return aVarMo1800x;
    }

    /* renamed from: t */
    public final T m2281t(MapperFeature... mapperFeatureArr) {
        int i = this._mapperFeatures;
        for (MapperFeature mapperFeature : mapperFeatureArr) {
            i &= ~mapperFeature.mo2091g();
        }
        return i == this._mapperFeatures ? this : (T) mo1969r(i);
    }

    public MapperConfigBase(MapperConfigBase<CFG, T> mapperConfigBase, int i) {
        super(mapperConfigBase, i);
        this._mixIns = mapperConfigBase._mixIns;
        this._subtypeResolver = mapperConfigBase._subtypeResolver;
        this._rootNames = mapperConfigBase._rootNames;
        this._rootName = mapperConfigBase._rootName;
        this._view = mapperConfigBase._view;
        this._attributes = mapperConfigBase._attributes;
        this._configOverrides = mapperConfigBase._configOverrides;
    }
}
