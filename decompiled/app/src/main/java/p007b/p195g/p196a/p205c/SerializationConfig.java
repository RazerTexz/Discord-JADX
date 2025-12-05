package p007b.p195g.p196a.p205c;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import p007b.p195g.p196a.p198b.PrettyPrinter2;
import p007b.p195g.p196a.p198b.p204t.DefaultPrettyPrinter;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedClass;
import p007b.p195g.p196a.p205c.p210c0.BasicBeanDescription;
import p007b.p195g.p196a.p205c.p210c0.BasicClassIntrospector;
import p007b.p195g.p196a.p205c.p210c0.DefaultAccessorNamingStrategy;
import p007b.p195g.p196a.p205c.p210c0.POJOPropertiesCollector;
import p007b.p195g.p196a.p205c.p210c0.SimpleMixInResolver;
import p007b.p195g.p196a.p205c.p212e0.SubtypeResolver;
import p007b.p195g.p196a.p205c.p215g0.FilterProvider;
import p007b.p195g.p196a.p205c.p218h0.ArrayType;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p195g.p196a.p205c.p219i0.RootNameLookup;
import p007b.p195g.p196a.p205c.p221z.BaseSettings;
import p007b.p195g.p196a.p205c.p221z.ConfigOverrides;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;
import p007b.p195g.p196a.p205c.p221z.MapperConfigBase;

/* compiled from: SerializationConfig.java */
/* renamed from: b.g.a.c.v, reason: use source file name */
/* loaded from: classes3.dex */
public final class SerializationConfig extends MapperConfigBase<SerializationFeature, SerializationConfig> implements Serializable {

    /* renamed from: l */
    public static final PrettyPrinter2 f5033l = new DefaultPrettyPrinter();

    /* renamed from: m */
    public static final int f5034m = MapperConfig.m2264c(SerializationFeature.class);
    private static final long serialVersionUID = 1;
    public final PrettyPrinter2 _defaultPrettyPrinter;
    public final FilterProvider _filterProvider;
    public final int _formatWriteFeatures;
    public final int _formatWriteFeaturesToChange;
    public final int _generatorFeatures;
    public final int _generatorFeaturesToChange;
    public final int _serFeatures;

    public SerializationConfig(BaseSettings baseSettings, SubtypeResolver subtypeResolver, SimpleMixInResolver simpleMixInResolver, RootNameLookup rootNameLookup, ConfigOverrides configOverrides) {
        super(baseSettings, subtypeResolver, simpleMixInResolver, rootNameLookup, configOverrides);
        this._serFeatures = f5034m;
        this._defaultPrettyPrinter = f5033l;
        this._generatorFeatures = 0;
        this._generatorFeaturesToChange = 0;
        this._formatWriteFeatures = 0;
        this._formatWriteFeaturesToChange = 0;
    }

    @Override // p007b.p195g.p196a.p205c.p221z.MapperConfigBase
    /* renamed from: r */
    public MapperConfigBase mo1969r(int i) {
        return new SerializationConfig(this, i, this._serFeatures, this._generatorFeatures, this._generatorFeaturesToChange, this._formatWriteFeatures, this._formatWriteFeaturesToChange);
    }

    /* renamed from: u */
    public BeanDescription m2236u(JavaType javaType) {
        DefaultAccessorNamingStrategy defaultAccessorNamingStrategy;
        BasicClassIntrospector basicClassIntrospector = (BasicClassIntrospector) this._base._classIntrospector;
        BasicBeanDescription basicBeanDescriptionM1920a = basicClassIntrospector.m1920a(this, javaType);
        if (basicBeanDescriptionM1920a != null) {
            return basicBeanDescriptionM1920a;
        }
        boolean z2 = false;
        if (javaType.mo2104v() && !(javaType instanceof ArrayType)) {
            Class<?> cls = javaType._class;
            if (ClassUtil.m2186r(cls) && (Collection.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls))) {
                z2 = true;
            }
        }
        BasicBeanDescription basicBeanDescriptionM1918e = z2 ? BasicBeanDescription.m1918e(this, javaType, basicClassIntrospector.m1921b(this, javaType, this)) : null;
        if (basicBeanDescriptionM1918e != null) {
            return basicBeanDescriptionM1918e;
        }
        AnnotatedClass annotatedClassM1921b = basicClassIntrospector.m1921b(this, javaType, this);
        if (javaType.m2215A()) {
            Objects.requireNonNull((DefaultAccessorNamingStrategy.b) this._base._accessorNaming);
            defaultAccessorNamingStrategy = new DefaultAccessorNamingStrategy.c(this, annotatedClassM1921b);
        } else {
            DefaultAccessorNamingStrategy.b bVar = (DefaultAccessorNamingStrategy.b) this._base._accessorNaming;
            defaultAccessorNamingStrategy = new DefaultAccessorNamingStrategy(this, annotatedClassM1921b, bVar._setterPrefix, bVar._getterPrefix, bVar._isGetterPrefix, bVar._baseNameValidator);
        }
        return new BasicBeanDescription(new POJOPropertiesCollector(this, true, javaType, annotatedClassM1921b, defaultAccessorNamingStrategy));
    }

    /* renamed from: v */
    public final boolean m2237v(SerializationFeature serializationFeature) {
        return (serializationFeature.mo2091g() & this._serFeatures) != 0;
    }

    public SerializationConfig(SerializationConfig serializationConfig, int i, int i2, int i3, int i4, int i5, int i6) {
        super(serializationConfig, i);
        this._serFeatures = i2;
        this._defaultPrettyPrinter = serializationConfig._defaultPrettyPrinter;
        this._generatorFeatures = i3;
        this._generatorFeaturesToChange = i4;
        this._formatWriteFeatures = i5;
        this._formatWriteFeaturesToChange = i6;
    }
}
