package p007b.p195g.p196a.p205c;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import p007b.p195g.p196a.p198b.Base64Variants;
import p007b.p195g.p196a.p198b.JsonFactory;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.ObjectCodec;
import p007b.p195g.p196a.p198b.PrettyPrinter2;
import p007b.p195g.p196a.p198b.SerializableString;
import p007b.p195g.p196a.p198b.p200p.IOContext;
import p007b.p195g.p196a.p198b.p201q.WriterBasedJsonGenerator;
import p007b.p195g.p196a.p198b.p204t.Instantiatable;
import p007b.p195g.p196a.p205c.p206a0.BeanDeserializerFactory;
import p007b.p195g.p196a.p205c.p206a0.DefaultDeserializationContext;
import p007b.p195g.p196a.p205c.p210c0.BasicClassIntrospector;
import p007b.p195g.p196a.p205c.p210c0.DefaultAccessorNamingStrategy;
import p007b.p195g.p196a.p205c.p210c0.JacksonAnnotationIntrospector;
import p007b.p195g.p196a.p205c.p210c0.SimpleMixInResolver;
import p007b.p195g.p196a.p205c.p212e0.SubtypeResolver;
import p007b.p195g.p196a.p205c.p212e0.p213h.LaissezFaireSubTypeValidator;
import p007b.p195g.p196a.p205c.p212e0.p213h.StdSubtypeResolver;
import p007b.p195g.p196a.p205c.p215g0.BeanSerializerFactory;
import p007b.p195g.p196a.p205c.p215g0.DefaultSerializerProvider;
import p007b.p195g.p196a.p205c.p215g0.SerializerFactory2;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p195g.p196a.p205c.p219i0.RootNameLookup;
import p007b.p195g.p196a.p205c.p219i0.StdDateFormat;
import p007b.p195g.p196a.p205c.p221z.BaseSettings;
import p007b.p195g.p196a.p205c.p221z.CoercionConfigs;
import p007b.p195g.p196a.p205c.p221z.ConfigOverrides;

/* compiled from: ObjectMapper.java */
/* renamed from: b.g.a.c.r, reason: use source file name */
/* loaded from: classes3.dex */
public class ObjectMapper extends ObjectCodec implements Serializable {

    /* renamed from: j */
    public static final AnnotationIntrospector f5023j;

    /* renamed from: k */
    public static final BaseSettings f5024k;
    private static final long serialVersionUID = 2;
    public final CoercionConfigs _coercionConfigs;
    public final ConfigOverrides _configOverrides;
    public DeserializationConfig _deserializationConfig;
    public DefaultDeserializationContext _deserializationContext;
    public InjectableValues _injectableValues;
    public final JsonFactory _jsonFactory;
    public SimpleMixInResolver _mixIns;
    public Set<Object> _registeredModuleTypes;
    public final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _rootDeserializers;
    public SerializationConfig _serializationConfig;
    public SerializerFactory2 _serializerFactory;
    public DefaultSerializerProvider _serializerProvider;
    public SubtypeResolver _subtypeResolver;
    public TypeFactory _typeFactory;

    static {
        JacksonAnnotationIntrospector jacksonAnnotationIntrospector = new JacksonAnnotationIntrospector();
        f5023j = jacksonAnnotationIntrospector;
        f5024k = new BaseSettings(null, jacksonAnnotationIntrospector, null, TypeFactory.f4925k, null, StdDateFormat.f4974p, Locale.getDefault(), null, Base64Variants.f4452b, LaissezFaireSubTypeValidator.f4772j, new DefaultAccessorNamingStrategy.b());
    }

    public ObjectMapper() {
        this(null, null, null);
    }

    /* renamed from: a */
    public final void m2223a(String str, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("argument \"%s\" is null", str));
        }
    }

    /* renamed from: b */
    public final void m2224b(JsonGenerator jsonGenerator, Object obj) throws IOException {
        SerializationConfig serializationConfig = this._serializationConfig;
        if (serializationConfig.m2237v(SerializationFeature.CLOSE_CLOSEABLE) && (obj instanceof Closeable)) {
            Closeable closeable = (Closeable) obj;
            try {
                this._serializerProvider.mo2003K(serializationConfig, this._serializerFactory).m2004L(jsonGenerator, obj);
            } catch (Exception e) {
                e = e;
            }
            try {
                closeable.close();
                jsonGenerator.close();
                return;
            } catch (Exception e2) {
                e = e2;
                closeable = null;
                ClassUtil.m2174f(jsonGenerator, closeable, e);
                throw null;
            }
        }
        try {
            this._serializerProvider.mo2003K(serializationConfig, this._serializerFactory).m2004L(jsonGenerator, obj);
            jsonGenerator.close();
        } catch (Exception e3) {
            Annotation[] annotationArr = ClassUtil.f4944a;
            jsonGenerator.mo1648b(JsonGenerator.a.AUTO_CLOSE_JSON_CONTENT);
            try {
                jsonGenerator.close();
            } catch (Exception e4) {
                e3.addSuppressed(e4);
            }
            if (e3 instanceof IOException) {
                throw ((IOException) e3);
            }
            ClassUtil.m2192x(e3);
            throw new RuntimeException(e3);
        }
    }

    /* renamed from: c */
    public JsonGenerator m2225c(Writer writer) throws IOException {
        m2223a("w", writer);
        JsonFactory jsonFactory = this._jsonFactory;
        IOContext iOContext = new IOContext(jsonFactory.m1626a(), writer, false);
        if (jsonFactory._outputDecorator != null) {
            throw null;
        }
        WriterBasedJsonGenerator writerBasedJsonGenerator = new WriterBasedJsonGenerator(iOContext, jsonFactory._generatorFeatures, jsonFactory._objectCodec, writer, jsonFactory._quoteChar);
        int i = jsonFactory._maximumNonEscapedChar;
        if (i > 0) {
            writerBasedJsonGenerator.m1705y0(i);
        }
        if (jsonFactory._characterEscapes != null) {
            throw null;
        }
        SerializableString serializableString = jsonFactory._rootValueSeparator;
        if (serializableString != JsonFactory.f4458m) {
            writerBasedJsonGenerator.f4568v = serializableString;
        }
        SerializationConfig serializationConfig = this._serializationConfig;
        Objects.requireNonNull(serializationConfig);
        if (SerializationFeature.INDENT_OUTPUT.m2238h(serializationConfig._serFeatures) && writerBasedJsonGenerator.f4466l == null) {
            PrettyPrinter2 prettyPrinter2 = serializationConfig._defaultPrettyPrinter;
            if (prettyPrinter2 instanceof Instantiatable) {
                prettyPrinter2 = (PrettyPrinter2) ((Instantiatable) prettyPrinter2).mo1732e();
            }
            if (prettyPrinter2 != null) {
                writerBasedJsonGenerator.f4466l = prettyPrinter2;
            }
        }
        boolean zM2238h = SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN.m2238h(serializationConfig._serFeatures);
        int i2 = serializationConfig._generatorFeaturesToChange;
        if (i2 != 0 || zM2238h) {
            int i3 = serializationConfig._generatorFeatures;
            if (zM2238h) {
                int iM1669h = JsonGenerator.a.WRITE_BIGDECIMAL_AS_PLAIN.m1669h();
                i3 |= iM1669h;
                i2 |= iM1669h;
            }
            writerBasedJsonGenerator.m1694w0(i3, i2);
        }
        return writerBasedJsonGenerator;
    }

    public ObjectMapper(JsonFactory jsonFactory, DefaultSerializerProvider defaultSerializerProvider, DefaultDeserializationContext defaultDeserializationContext) {
        this._rootDeserializers = new ConcurrentHashMap<>(64, 0.6f, 2);
        if (jsonFactory == null) {
            this._jsonFactory = new MappingJsonFactory(this);
        } else {
            this._jsonFactory = jsonFactory;
            if (jsonFactory.mo1627b() == null) {
                jsonFactory._objectCodec = this;
            }
        }
        this._subtypeResolver = new StdSubtypeResolver();
        RootNameLookup rootNameLookup = new RootNameLookup();
        this._typeFactory = TypeFactory.f4925k;
        SimpleMixInResolver simpleMixInResolver = new SimpleMixInResolver(null);
        this._mixIns = simpleMixInResolver;
        BaseSettings baseSettings = f5024k;
        BasicClassIntrospector basicClassIntrospector = new BasicClassIntrospector();
        BaseSettings baseSettings2 = baseSettings._classIntrospector == basicClassIntrospector ? baseSettings : new BaseSettings(basicClassIntrospector, baseSettings._annotationIntrospector, baseSettings._propertyNamingStrategy, baseSettings._typeFactory, baseSettings._typeResolverBuilder, baseSettings._dateFormat, baseSettings._locale, baseSettings._timeZone, baseSettings._defaultBase64, baseSettings._typeValidator, baseSettings._accessorNaming);
        ConfigOverrides configOverrides = new ConfigOverrides();
        this._configOverrides = configOverrides;
        CoercionConfigs coercionConfigs = new CoercionConfigs();
        this._coercionConfigs = coercionConfigs;
        BaseSettings baseSettings3 = baseSettings2;
        this._serializationConfig = new SerializationConfig(baseSettings3, this._subtypeResolver, simpleMixInResolver, rootNameLookup, configOverrides);
        this._deserializationConfig = new DeserializationConfig(baseSettings3, this._subtypeResolver, simpleMixInResolver, rootNameLookup, configOverrides, coercionConfigs);
        Objects.requireNonNull(this._jsonFactory);
        SerializationConfig serializationConfig = this._serializationConfig;
        MapperFeature mapperFeature = MapperFeature.SORT_PROPERTIES_ALPHABETICALLY;
        if (serializationConfig.m2279q(mapperFeature)) {
            this._serializationConfig = this._serializationConfig.m2281t(mapperFeature);
            this._deserializationConfig = this._deserializationConfig.m2281t(mapperFeature);
        }
        this._serializerProvider = new DefaultSerializerProvider.a();
        this._deserializationContext = new DefaultDeserializationContext.a(BeanDeserializerFactory.f4618j);
        this._serializerFactory = BeanSerializerFactory.f4805l;
    }
}
