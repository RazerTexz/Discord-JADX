package p007b.p195g.p196a.p205c.p215g0;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p197a.JsonIgnoreProperties;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p197a.JsonIncludeProperties;
import p007b.p195g.p196a.p197a.JsonTypeInfo;
import p007b.p195g.p196a.p197a.ObjectIdGenerator;
import p007b.p195g.p196a.p197a.ObjectIdGenerators3;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.BeanDescription;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.MapperFeature;
import p007b.p195g.p196a.p205c.PropertyMetadata;
import p007b.p195g.p196a.p205c.PropertyName;
import p007b.p195g.p196a.p205c.SerializationConfig;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p209b0.OptionalHandlerFactory;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedClass;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedConstructor;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedField;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMethod;
import p007b.p195g.p196a.p205c.p210c0.BasicBeanDescription;
import p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition;
import p007b.p195g.p196a.p205c.p210c0.ObjectIdInfo;
import p007b.p195g.p196a.p205c.p210c0.POJOPropertiesCollector;
import p007b.p195g.p196a.p205c.p212e0.TypeResolverBuilder;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.FilteredBeanPropertyWriter;
import p007b.p195g.p196a.p205c.p215g0.p216t.FilteredBeanPropertyWriter2;
import p007b.p195g.p196a.p205c.p215g0.p216t.IndexedListSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.IndexedStringListSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.IteratorSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.MapEntrySerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.ObjectIdWriter;
import p007b.p195g.p196a.p205c.p215g0.p216t.PropertyBasedObjectIdGenerator;
import p007b.p195g.p196a.p205c.p215g0.p216t.StringArraySerializer2;
import p007b.p195g.p196a.p205c.p215g0.p216t.StringCollectionSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.UnsupportedTypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.UnwrappingBeanPropertyWriter;
import p007b.p195g.p196a.p205c.p215g0.p217u.AtomicReferenceSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase;
import p007b.p195g.p196a.p205c.p215g0.p217u.ByteBufferSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.CalendarSerializer2;
import p007b.p195g.p196a.p205c.p215g0.p217u.CollectionSerializer2;
import p007b.p195g.p196a.p205c.p215g0.p217u.DateSerializer2;
import p007b.p195g.p196a.p205c.p215g0.p217u.EnumSerializer2;
import p007b.p195g.p196a.p205c.p215g0.p217u.EnumSetSerializer2;
import p007b.p195g.p196a.p205c.p215g0.p217u.InetAddressSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.InetSocketAddressSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.IterableSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.MapSerializer2;
import p007b.p195g.p196a.p205c.p215g0.p217u.NumberSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.ObjectArraySerializer2;
import p007b.p195g.p196a.p205c.p215g0.p217u.ReferenceTypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.StdArraySerializers;
import p007b.p195g.p196a.p205c.p215g0.p217u.StdDelegatingSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.TimeZoneSerializer2;
import p007b.p195g.p196a.p205c.p215g0.p217u.ToStringSerializer;
import p007b.p195g.p196a.p205c.p218h0.ArrayType;
import p007b.p195g.p196a.p205c.p218h0.CollectionLikeType;
import p007b.p195g.p196a.p205c.p218h0.CollectionType;
import p007b.p195g.p196a.p205c.p218h0.MapLikeType;
import p007b.p195g.p196a.p205c.p218h0.MapType;
import p007b.p195g.p196a.p205c.p218h0.ReferenceType;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;
import p007b.p195g.p196a.p205c.p219i0.ArrayIterator2;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p195g.p196a.p205c.p219i0.Converter;
import p007b.p195g.p196a.p205c.p219i0.EnumValues;
import p007b.p195g.p196a.p205c.p219i0.NameTransformer4;
import p007b.p195g.p196a.p205c.p221z.SerializerFactoryConfig;

/* compiled from: BeanSerializerFactory.java */
/* renamed from: b.g.a.c.g0.f, reason: use source file name */
/* loaded from: classes3.dex */
public class BeanSerializerFactory extends BasicSerializerFactory implements Serializable {

    /* renamed from: l */
    public static final BeanSerializerFactory f4805l = new BeanSerializerFactory(null);
    private static final long serialVersionUID = 1;

    public BeanSerializerFactory(SerializerFactoryConfig serializerFactoryConfig) {
        super(null);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.SerializerFactory2
    /* renamed from: b */
    public JsonSerializer<Object> mo1991b(SerializerProvider serializerProvider, JavaType javaType) throws JsonMappingException {
        JavaType javaTypeMo1780e0;
        Object objMo1752H;
        SerializationConfig serializationConfig = serializerProvider._config;
        BeanDescription beanDescriptionM2236u = serializationConfig.m2236u(javaType);
        JsonSerializer<?> jsonSerializerM1975f = m1975f(serializerProvider, ((BasicBeanDescription) beanDescriptionM2236u).f4736f);
        if (jsonSerializerM1975f != null) {
            return jsonSerializerM1975f;
        }
        AnnotationIntrospector annotationIntrospectorM2267e = serializationConfig.m2267e();
        boolean z2 = false;
        Converter converter = null;
        if (annotationIntrospectorM2267e == null) {
            javaTypeMo1780e0 = javaType;
        } else {
            try {
                javaTypeMo1780e0 = annotationIntrospectorM2267e.mo1780e0(serializationConfig, ((BasicBeanDescription) beanDescriptionM2236u).f4736f, javaType);
            } catch (JsonMappingException e) {
                serializerProvider.m2242F(beanDescriptionM2236u, e.getMessage(), new Object[0]);
                throw null;
            }
        }
        if (javaTypeMo1780e0 != javaType) {
            if (!javaTypeMo1780e0.m2218t(javaType._class)) {
                beanDescriptionM2236u = serializationConfig.m2236u(javaTypeMo1780e0);
            }
            z2 = true;
        }
        BasicBeanDescription basicBeanDescription = (BasicBeanDescription) beanDescriptionM2236u;
        AnnotationIntrospector annotationIntrospector = basicBeanDescription.f4735e;
        if (annotationIntrospector != null && (objMo1752H = annotationIntrospector.mo1752H(basicBeanDescription.f4736f)) != null) {
            if (objMo1752H instanceof Converter) {
                converter = (Converter) objMo1752H;
            } else {
                if (!(objMo1752H instanceof Class)) {
                    StringBuilder sbM833U = outline.m833U("AnnotationIntrospector returned Converter definition of type ");
                    sbM833U.append(objMo1752H.getClass().getName());
                    sbM833U.append("; expected type Converter or Class<Converter> instead");
                    throw new IllegalStateException(sbM833U.toString());
                }
                Class cls = (Class) objMo1752H;
                if (cls != Converter.a.class && !ClassUtil.m2184p(cls)) {
                    if (!Converter.class.isAssignableFrom(cls)) {
                        throw new IllegalStateException(outline.m867o(cls, outline.m833U("AnnotationIntrospector returned Class "), "; expected Class<Converter>"));
                    }
                    Objects.requireNonNull(basicBeanDescription.f4734d._base);
                    converter = (Converter) ClassUtil.m2175g(cls, basicBeanDescription.f4734d.m2265b());
                }
            }
        }
        if (converter == null) {
            return m1993i(serializerProvider, javaTypeMo1780e0, beanDescriptionM2236u, z2);
        }
        JavaType javaTypeM2197a = converter.m2197a(serializerProvider.mo1940d());
        if (!javaTypeM2197a.m2218t(javaTypeMo1780e0._class)) {
            beanDescriptionM2236u = serializationConfig.m2236u(javaTypeM2197a);
            jsonSerializerM1975f = m1975f(serializerProvider, ((BasicBeanDescription) beanDescriptionM2236u).f4736f);
        }
        if (jsonSerializerM1975f == null && !javaTypeM2197a.m2221y()) {
            jsonSerializerM1975f = m1993i(serializerProvider, javaTypeM2197a, beanDescriptionM2236u, true);
        }
        return new StdDelegatingSerializer(converter, javaTypeM2197a, jsonSerializerM1975f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x020f  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BeanPropertyWriter m1992h(SerializerProvider serializerProvider, BeanPropertyDefinition beanPropertyDefinition, PropertyBuilder propertyBuilder, boolean z2, AnnotatedMember annotatedMember) throws JsonMappingException {
        TypeSerializer typeSerializerMo1972c;
        boolean z3;
        boolean z4;
        boolean zMo1999B;
        Object obj;
        Class<?>[] clsArrMo1852i;
        Object objMo1793q;
        Object objM572t0;
        PropertyName propertyNameMo1855m = beanPropertyDefinition.mo1855m();
        JavaType javaTypeMo1821e = annotatedMember.mo1821e();
        BeanProperty.a aVar = new BeanProperty.a(propertyNameMo1855m, javaTypeMo1821e, beanPropertyDefinition.mo1862t(), annotatedMember, beanPropertyDefinition.mo1857o());
        JsonSerializer<Object> jsonSerializerM1975f = m1975f(serializerProvider, annotatedMember);
        if (jsonSerializerM1975f instanceof ResolvableSerializer) {
            ((ResolvableSerializer) jsonSerializerM1975f).mo2007b(serializerProvider);
        }
        JsonSerializer<?> jsonSerializerM2260y = serializerProvider.m2260y(jsonSerializerM1975f, aVar);
        if (javaTypeMo1821e.mo2104v() || javaTypeMo1821e.mo1728b()) {
            SerializationConfig serializationConfig = serializerProvider._config;
            JavaType javaTypeMo2099k = javaTypeMo1821e.mo2099k();
            TypeResolverBuilder<?> typeResolverBuilderMo1797u = serializationConfig.m2267e().mo1797u(serializationConfig, annotatedMember, javaTypeMo1821e);
            typeSerializerMo1972c = typeResolverBuilderMo1797u == null ? mo1972c(serializationConfig, javaTypeMo2099k) : typeResolverBuilderMo1797u.mo1953e(serializationConfig, javaTypeMo2099k, serializationConfig._subtypeResolver.mo1945a(serializationConfig, annotatedMember, javaTypeMo2099k));
        } else {
            typeSerializerMo1972c = null;
        }
        SerializationConfig serializationConfig2 = serializerProvider._config;
        TypeResolverBuilder<?> typeResolverBuilderMo1747C = serializationConfig2.m2267e().mo1747C(serializationConfig2, annotatedMember, javaTypeMo1821e);
        TypeSerializer typeSerializerMo1972c2 = typeResolverBuilderMo1747C == null ? mo1972c(serializationConfig2, javaTypeMo1821e) : typeResolverBuilderMo1747C.mo1953e(serializationConfig2, javaTypeMo1821e, serializationConfig2._subtypeResolver.mo1945a(serializationConfig2, annotatedMember, javaTypeMo1821e));
        Object obj2 = JsonInclude.a.NON_EMPTY;
        try {
            JavaType javaTypeM2006a = propertyBuilder.m2006a(annotatedMember, z2, javaTypeMo1821e);
            if (typeSerializerMo1972c != null) {
                if (javaTypeM2006a == null) {
                    javaTypeM2006a = javaTypeMo1821e;
                }
                if (javaTypeM2006a.mo2099k() == null) {
                    serializerProvider.m2241E(propertyBuilder.f4810b, beanPropertyDefinition, "serialization type " + javaTypeM2006a + " has no content", new Object[0]);
                    throw null;
                }
                JavaType javaTypeMo2095E = javaTypeM2006a.mo2095E(typeSerializerMo1972c);
                javaTypeMo2095E.mo2099k();
                javaTypeM2006a = javaTypeMo2095E;
            }
            JavaType javaType = javaTypeM2006a == null ? javaTypeMo1821e : javaTypeM2006a;
            AnnotatedMember annotatedMemberM1922j = beanPropertyDefinition.m1922j();
            if (annotatedMemberM1922j == null) {
                serializerProvider.m2241E(propertyBuilder.f4810b, beanPropertyDefinition, "could not determine property type", new Object[0]);
                throw null;
            }
            Class<?> clsMo1820d = annotatedMemberM1922j.mo1820d();
            SerializationConfig serializationConfig3 = propertyBuilder.f4809a;
            Class<?> cls = javaType._class;
            JsonInclude.b bVar = propertyBuilder.f4813e;
            serializationConfig3.mo2268f(cls);
            serializationConfig3.mo2268f(clsMo1820d);
            JsonInclude.b[] bVarArr = {bVar, null, null};
            JsonInclude.b bVar2 = JsonInclude.b.f4436j;
            int i = 0;
            JsonInclude.b bVar3 = null;
            for (int i2 = 3; i < i2; i2 = 3) {
                JsonInclude.b bVarM1618a = bVarArr[i];
                if (bVarM1618a != null) {
                    if (bVar3 != null) {
                        bVarM1618a = bVar3.m1618a(bVarM1618a);
                    }
                    bVar3 = bVarM1618a;
                }
                i++;
            }
            JsonInclude.b bVarM1618a2 = bVar3.m1618a(beanPropertyDefinition.mo1850g());
            JsonInclude.a aVar2 = bVarM1618a2._valueInclusion;
            if (aVar2 == JsonInclude.a.USE_DEFAULTS) {
                aVar2 = JsonInclude.a.ALWAYS;
            }
            int iOrdinal = aVar2.ordinal();
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal != 3) {
                        if (iOrdinal == 4) {
                            if (propertyBuilder.f4814f) {
                                Object objNewInstance = propertyBuilder.f4812d;
                                if (objNewInstance == null) {
                                    BeanDescription beanDescription = propertyBuilder.f4810b;
                                    boolean zM2265b = propertyBuilder.f4809a.m2265b();
                                    BasicBeanDescription basicBeanDescription = (BasicBeanDescription) beanDescription;
                                    AnnotatedConstructor annotatedConstructor = basicBeanDescription.f4736f.m1832f().f4668a;
                                    if (annotatedConstructor == null) {
                                        objNewInstance = null;
                                    } else {
                                        if (zM2265b) {
                                            annotatedConstructor.m1902f(basicBeanDescription.f4734d.m2279q(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                                        }
                                        try {
                                            objNewInstance = annotatedConstructor._constructor.newInstance(new Object[0]);
                                        } catch (Exception e) {
                                            e = e;
                                            while (e.getCause() != null) {
                                                e = e.getCause();
                                            }
                                            ClassUtil.m2191w(e);
                                            ClassUtil.m2192x(e);
                                            StringBuilder sbM833U = outline.m833U("Failed to instantiate bean of type ");
                                            sbM833U.append(basicBeanDescription.f4736f.f4655l.getName());
                                            sbM833U.append(": (");
                                            sbM833U.append(e.getClass().getName());
                                            sbM833U.append(") ");
                                            sbM833U.append(ClassUtil.m2176h(e));
                                            throw new IllegalArgumentException(sbM833U.toString(), e);
                                        }
                                    }
                                    if (objNewInstance == null) {
                                        objNewInstance = Boolean.FALSE;
                                    }
                                    propertyBuilder.f4812d = objNewInstance;
                                }
                                Object obj3 = objNewInstance == Boolean.FALSE ? null : propertyBuilder.f4812d;
                                if (obj3 != null) {
                                    if (serializerProvider.m2239C(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                                        annotatedMember.m1902f(propertyBuilder.f4809a.m2279q(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                                    }
                                    try {
                                        objM572t0 = annotatedMember.mo1889j(obj3);
                                        z3 = false;
                                    } catch (Exception e2) {
                                        e = e2;
                                        String strMo1858p = beanPropertyDefinition.mo1858p();
                                        while (e.getCause() != null) {
                                            e = e.getCause();
                                        }
                                        ClassUtil.m2191w(e);
                                        ClassUtil.m2192x(e);
                                        StringBuilder sbM837Y = outline.m837Y("Failed to get property '", strMo1858p, "' of default ");
                                        sbM837Y.append(obj3.getClass().getName());
                                        sbM837Y.append(" instance");
                                        throw new IllegalArgumentException(sbM837Y.toString());
                                    }
                                }
                                if (objM572t0 != null) {
                                }
                            } else {
                                objM572t0 = AnimatableValueParser.m572t0(javaType);
                                z3 = true;
                                if (objM572t0 != null) {
                                    if (objM572t0.getClass().isArray()) {
                                        objM572t0 = AnimatableValueParser.m560q0(objM572t0);
                                    }
                                    obj2 = objM572t0;
                                    zMo1999B = z3;
                                    obj = obj2;
                                }
                            }
                            clsArrMo1852i = beanPropertyDefinition.mo1852i();
                            if (clsArrMo1852i == null) {
                            }
                            BeanPropertyWriter beanPropertyWriter = new BeanPropertyWriter(beanPropertyDefinition, annotatedMember, ((BasicBeanDescription) propertyBuilder.f4810b).f4736f.f4663t, javaTypeMo1821e, jsonSerializerM2260y, typeSerializerMo1972c2, javaTypeM2006a, zMo1999B, obj, clsArrMo1852i);
                            objMo1793q = propertyBuilder.f4811c.mo1793q(annotatedMember);
                            if (objMo1793q != null) {
                            }
                            NameTransformer4 nameTransformer4Mo1761Q = propertyBuilder.f4811c.mo1761Q(annotatedMember);
                            if (nameTransformer4Mo1761Q == null) {
                            }
                        } else if (iOrdinal != 5) {
                            z3 = false;
                        } else {
                            objM572t0 = serializerProvider.mo1998A(beanPropertyDefinition, bVarM1618a2._valueFilter);
                            if (objM572t0 != null) {
                                obj = objM572t0;
                                zMo1999B = serializerProvider.mo1999B(objM572t0);
                                clsArrMo1852i = beanPropertyDefinition.mo1852i();
                                if (clsArrMo1852i == null) {
                                    BasicBeanDescription basicBeanDescription2 = (BasicBeanDescription) propertyBuilder.f4810b;
                                    if (!basicBeanDescription2.f4738h) {
                                        basicBeanDescription2.f4738h = true;
                                        AnnotationIntrospector annotationIntrospector = basicBeanDescription2.f4735e;
                                        Class<?>[] clsArrMo1762R = annotationIntrospector == null ? null : annotationIntrospector.mo1762R(basicBeanDescription2.f4736f);
                                        if (clsArrMo1762R == null && !basicBeanDescription2.f4734d.m2279q(MapperFeature.DEFAULT_VIEW_INCLUSION)) {
                                            clsArrMo1762R = BasicBeanDescription.f4732b;
                                        }
                                        basicBeanDescription2.f4737g = clsArrMo1762R;
                                    }
                                    clsArrMo1852i = basicBeanDescription2.f4737g;
                                }
                                BeanPropertyWriter beanPropertyWriter2 = new BeanPropertyWriter(beanPropertyDefinition, annotatedMember, ((BasicBeanDescription) propertyBuilder.f4810b).f4736f.f4663t, javaTypeMo1821e, jsonSerializerM2260y, typeSerializerMo1972c2, javaTypeM2006a, zMo1999B, obj, clsArrMo1852i);
                                objMo1793q = propertyBuilder.f4811c.mo1793q(annotatedMember);
                                if (objMo1793q != null) {
                                    beanPropertyWriter2.mo1979e(serializerProvider.mo2000H(annotatedMember, objMo1793q));
                                }
                                NameTransformer4 nameTransformer4Mo1761Q2 = propertyBuilder.f4811c.mo1761Q(annotatedMember);
                                return nameTransformer4Mo1761Q2 == null ? new UnwrappingBeanPropertyWriter(beanPropertyWriter2, nameTransformer4Mo1761Q2) : beanPropertyWriter2;
                            }
                        }
                        obj2 = objM572t0;
                    } else {
                        int i3 = BeanPropertyWriter.f4790j;
                    }
                } else if (javaType.mo1728b()) {
                    int i4 = BeanPropertyWriter.f4790j;
                } else {
                    z4 = true;
                    zMo1999B = z4;
                    obj = null;
                    clsArrMo1852i = beanPropertyDefinition.mo1852i();
                    if (clsArrMo1852i == null) {
                    }
                    BeanPropertyWriter beanPropertyWriter22 = new BeanPropertyWriter(beanPropertyDefinition, annotatedMember, ((BasicBeanDescription) propertyBuilder.f4810b).f4736f.f4663t, javaTypeMo1821e, jsonSerializerM2260y, typeSerializerMo1972c2, javaTypeM2006a, zMo1999B, obj, clsArrMo1852i);
                    objMo1793q = propertyBuilder.f4811c.mo1793q(annotatedMember);
                    if (objMo1793q != null) {
                    }
                    NameTransformer4 nameTransformer4Mo1761Q22 = propertyBuilder.f4811c.mo1761Q(annotatedMember);
                    if (nameTransformer4Mo1761Q22 == null) {
                    }
                }
                obj = obj2;
                zMo1999B = true;
                clsArrMo1852i = beanPropertyDefinition.mo1852i();
                if (clsArrMo1852i == null) {
                }
                BeanPropertyWriter beanPropertyWriter222 = new BeanPropertyWriter(beanPropertyDefinition, annotatedMember, ((BasicBeanDescription) propertyBuilder.f4810b).f4736f.f4663t, javaTypeMo1821e, jsonSerializerM2260y, typeSerializerMo1972c2, javaTypeM2006a, zMo1999B, obj, clsArrMo1852i);
                objMo1793q = propertyBuilder.f4811c.mo1793q(annotatedMember);
                if (objMo1793q != null) {
                }
                NameTransformer4 nameTransformer4Mo1761Q222 = propertyBuilder.f4811c.mo1761Q(annotatedMember);
                if (nameTransformer4Mo1761Q222 == null) {
                }
            } else {
                z3 = true;
            }
            SerializationFeature serializationFeature = SerializationFeature.WRITE_EMPTY_JSON_ARRAYS;
            if (!javaType.mo2104v() || propertyBuilder.f4809a.m2237v(serializationFeature)) {
                z4 = z3;
                zMo1999B = z4;
                obj = null;
                clsArrMo1852i = beanPropertyDefinition.mo1852i();
                if (clsArrMo1852i == null) {
                }
                BeanPropertyWriter beanPropertyWriter2222 = new BeanPropertyWriter(beanPropertyDefinition, annotatedMember, ((BasicBeanDescription) propertyBuilder.f4810b).f4736f.f4663t, javaTypeMo1821e, jsonSerializerM2260y, typeSerializerMo1972c2, javaTypeM2006a, zMo1999B, obj, clsArrMo1852i);
                objMo1793q = propertyBuilder.f4811c.mo1793q(annotatedMember);
                if (objMo1793q != null) {
                }
                NameTransformer4 nameTransformer4Mo1761Q2222 = propertyBuilder.f4811c.mo1761Q(annotatedMember);
                if (nameTransformer4Mo1761Q2222 == null) {
                }
            } else {
                int i5 = BeanPropertyWriter.f4790j;
                zMo1999B = z3;
                obj = obj2;
                clsArrMo1852i = beanPropertyDefinition.mo1852i();
                if (clsArrMo1852i == null) {
                }
                BeanPropertyWriter beanPropertyWriter22222 = new BeanPropertyWriter(beanPropertyDefinition, annotatedMember, ((BasicBeanDescription) propertyBuilder.f4810b).f4736f.f4663t, javaTypeMo1821e, jsonSerializerM2260y, typeSerializerMo1972c2, javaTypeM2006a, zMo1999B, obj, clsArrMo1852i);
                objMo1793q = propertyBuilder.f4811c.mo1793q(annotatedMember);
                if (objMo1793q != null) {
                }
                NameTransformer4 nameTransformer4Mo1761Q22222 = propertyBuilder.f4811c.mo1761Q(annotatedMember);
                if (nameTransformer4Mo1761Q22222 == null) {
                }
            }
        } catch (JsonMappingException e3) {
            serializerProvider.m2241E(propertyBuilder.f4810b, beanPropertyDefinition, ClassUtil.m2176h(e3), new Object[0]);
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x04bf A[PHI: r4
      0x04bf: PHI (r4v14 int) = (r4v13 int), (r4v16 int) binds: [B:260:0x04ba, B:247:0x048b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:349:0x0658  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x065e  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0663  */
    /* JADX WARN: Removed duplicated region for block: B:408:0x0729  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x078f  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x0792  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x0795  */
    /* JADX WARN: Removed duplicated region for block: B:479:0x0891  */
    /* JADX WARN: Removed duplicated region for block: B:604:0x0b18  */
    /* JADX WARN: Removed duplicated region for block: B:606:0x0b1b  */
    /* JADX WARN: Removed duplicated region for block: B:612:0x0b6e  */
    /* JADX WARN: Removed duplicated region for block: B:629:0x0ba5  */
    /* JADX WARN: Removed duplicated region for block: B:631:0x0bad  */
    /* JADX WARN: Removed duplicated region for block: B:676:0x0c71  */
    /* JADX WARN: Removed duplicated region for block: B:680:0x0c9d  */
    /* JADX WARN: Type inference failed for: r26v0, types: [b.g.a.c.g0.b, b.g.a.c.g0.f] */
    /* JADX WARN: Type inference failed for: r5v33, types: [b.g.a.c.g0.t.i] */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v8, types: [b.g.a.c.n] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonSerializer<?> m1993i(SerializerProvider serializerProvider, JavaType javaType, BeanDescription beanDescription, boolean z2) throws JsonMappingException {
        JsonInclude.a aVar;
        JsonInclude.a aVar2;
        JsonFormat.c cVar;
        Class<Enum> cls;
        BeanDescription beanDescription2;
        int i;
        JsonSerializer<?> jsonSerializerM1974e;
        JsonSerializer<?> jsonSerializerM2010a;
        int i2;
        Object objM572t0;
        boolean zMo1999B;
        int i3;
        char c;
        int iOrdinal;
        Object objM572t02;
        boolean zMo1999B2;
        String str;
        String str2;
        String str3;
        UnsupportedTypeSerializer unsupportedTypeSerializer;
        boolean z3;
        ArrayList arrayList;
        boolean z4;
        ArrayList arrayList2;
        boolean zEquals;
        ObjectIdWriter objectIdWriterM2031a;
        AnnotatedMember first;
        boolean zM2279q;
        int size;
        int i4;
        List<BeanPropertyWriter> list;
        JsonSerializer<?> jsonSerializerM2259x;
        EnumSerializer2 enumSerializer2;
        Class<? extends JsonSerializer<?>> cls2;
        boolean z5;
        boolean z6;
        TypeSerializer typeSerializer;
        JsonSerializer<Object> jsonSerializer;
        JsonSerializer<?> collectionSerializer2;
        JsonFormat.c cVar2;
        SerializationConfig serializationConfig;
        JsonSerializer<Object> jsonSerializer2;
        BasicBeanDescription basicBeanDescription;
        boolean z7;
        TypeSerializer typeSerializer2;
        Object objM572t03;
        boolean zMo1999B3;
        BeanDescription beanDescription3 = beanDescription;
        boolean z8 = z2;
        Class<Enum> cls3 = Enum.class;
        JsonFormat.c cVar3 = JsonFormat.c.OBJECT;
        JsonInclude.a aVar3 = JsonInclude.a.ALWAYS;
        JsonInclude.a aVar4 = JsonInclude.a.USE_DEFAULTS;
        SerializationConfig serializationConfig2 = serializerProvider._config;
        if (javaType.mo2104v()) {
            boolean zM1976g = !z8 ? m1976g(serializationConfig2, beanDescription3, null) : z8;
            SerializationConfig serializationConfig3 = serializerProvider._config;
            boolean z9 = (zM1976g || !javaType._asStatic || (javaType.mo2104v() && javaType.mo2099k().m2221y())) ? zM1976g : true;
            TypeSerializer typeSerializerMo1972c = mo1972c(serializationConfig3, javaType.mo2099k());
            boolean z10 = typeSerializerMo1972c != null ? false : z9;
            BasicBeanDescription basicBeanDescription2 = (BasicBeanDescription) beanDescription3;
            AnnotatedClass annotatedClass = basicBeanDescription2.f4736f;
            Object objMo1775c = serializerProvider.m2257v().mo1775c(annotatedClass);
            JsonSerializer<Object> jsonSerializerMo2000H = objMo1775c != null ? serializerProvider.mo2000H(annotatedClass, objMo1775c) : null;
            if (javaType.mo2122z()) {
                MapLikeType mapLikeType = (MapLikeType) javaType;
                AnnotatedClass annotatedClass2 = basicBeanDescription2.f4736f;
                Object objMo1788l = serializerProvider.m2257v().mo1788l(annotatedClass2);
                JsonSerializer<Object> jsonSerializerMo2000H2 = objMo1788l != null ? serializerProvider.mo2000H(annotatedClass2, objMo1788l) : null;
                if (mapLikeType instanceof MapType) {
                    MapType mapType = (MapType) mapLikeType;
                    if (beanDescription3.mo1812a(null).m1601e() == cVar3) {
                        jsonSerializerM1974e = null;
                        cVar2 = cVar3;
                    } else {
                        SerializationConfig serializationConfig4 = serializerProvider._config;
                        ArrayIterator2 arrayIterator2 = (ArrayIterator2) m1994j();
                        JsonSerializer<?> jsonSerializerM1974e2 = null;
                        while (true) {
                            if (!arrayIterator2.hasNext()) {
                                cVar2 = cVar3;
                                serializationConfig = serializationConfig4;
                                jsonSerializer2 = jsonSerializerMo2000H;
                                basicBeanDescription = basicBeanDescription2;
                                z7 = z10;
                                typeSerializer2 = typeSerializerMo1972c;
                                break;
                            }
                            serializationConfig = serializationConfig4;
                            jsonSerializer2 = jsonSerializerMo2000H;
                            cVar2 = cVar3;
                            basicBeanDescription = basicBeanDescription2;
                            z7 = z10;
                            typeSerializer2 = typeSerializerMo1972c;
                            jsonSerializerM1974e2 = ((Serializers) arrayIterator2.next()).m2012c(serializationConfig4, mapType, beanDescription, jsonSerializerMo2000H2, typeSerializerMo1972c, jsonSerializer2);
                            if (jsonSerializerM1974e2 != null) {
                                break;
                            }
                            serializationConfig4 = serializationConfig;
                            basicBeanDescription2 = basicBeanDescription;
                            z10 = z7;
                            typeSerializerMo1972c = typeSerializer2;
                            jsonSerializerMo2000H = jsonSerializer2;
                            cVar3 = cVar2;
                        }
                        if (jsonSerializerM1974e2 == null && (jsonSerializerM1974e2 = m1974e(serializerProvider, mapType, beanDescription3)) == null) {
                            Object objMo1783g = serializationConfig.m2267e().mo1783g(basicBeanDescription.f4736f);
                            SerializationConfig serializationConfig5 = serializationConfig;
                            JsonIgnoreProperties.a aVarM2280s = serializationConfig5.m2280s(Map.class, basicBeanDescription.f4736f);
                            Set<String> setM1617d = aVarM2280s == null ? null : aVarM2280s.m1617d();
                            AnnotatedClass annotatedClass3 = basicBeanDescription.f4736f;
                            AnnotationIntrospector annotationIntrospectorM2267e = serializationConfig5.m2267e();
                            JsonIncludeProperties.a aVarMo1745A = annotationIntrospectorM2267e == null ? null : annotationIntrospectorM2267e.mo1745A(serializationConfig5, annotatedClass3);
                            MapSerializer2 mapSerializer2M2082s = MapSerializer2.m2082s(setM1617d, aVarMo1745A == null ? null : aVarMo1745A._included, mapType, z7, typeSerializer2, jsonSerializerMo2000H2, jsonSerializer2, objMo1783g);
                            JavaType javaType2 = mapSerializer2M2082s._valueType;
                            JsonInclude.b bVarM1973d = m1973d(serializerProvider, beanDescription3, javaType2, Map.class);
                            JsonInclude.a aVar5 = bVarM1973d == null ? aVar4 : bVarM1973d._contentInclusion;
                            if (aVar5 == aVar4 || aVar5 == aVar3) {
                                jsonSerializerM1974e = mapSerializer2M2082s;
                                if (!serializerProvider.m2240D(SerializationFeature.WRITE_NULL_MAP_VALUES)) {
                                    jsonSerializerM1974e = mapSerializer2M2082s.m2086v(null, true);
                                }
                            } else {
                                int iOrdinal2 = aVar5.ordinal();
                                if (iOrdinal2 != 2) {
                                    if (iOrdinal2 == 3) {
                                        objM572t03 = MapSerializer2.f4865l;
                                    } else if (iOrdinal2 == 4) {
                                        objM572t03 = AnimatableValueParser.m572t0(javaType2);
                                        if (objM572t03 != null && objM572t03.getClass().isArray()) {
                                            objM572t03 = AnimatableValueParser.m560q0(objM572t03);
                                        }
                                    } else if (iOrdinal2 != 5) {
                                        zMo1999B3 = true;
                                        objM572t03 = null;
                                    } else {
                                        objM572t03 = serializerProvider.mo1998A(null, bVarM1973d._contentFilter);
                                        if (objM572t03 != null) {
                                            zMo1999B3 = serializerProvider.mo1999B(objM572t03);
                                        }
                                    }
                                    zMo1999B3 = true;
                                } else {
                                    if (javaType2.mo1728b()) {
                                        objM572t03 = MapSerializer2.f4865l;
                                        zMo1999B3 = true;
                                    }
                                    zMo1999B3 = true;
                                    objM572t03 = null;
                                }
                                jsonSerializerM1974e = mapSerializer2M2082s.m2086v(objM572t03, zMo1999B3);
                            }
                        } else {
                            jsonSerializerM1974e = jsonSerializerM1974e2;
                        }
                        if (this._factoryConfig.m2282a()) {
                            ArrayIterator2 arrayIterator22 = (ArrayIterator2) this._factoryConfig.m2283b();
                            while (arrayIterator22.hasNext()) {
                                Objects.requireNonNull((BeanSerializerModifier) arrayIterator22.next());
                            }
                        }
                    }
                } else {
                    cVar2 = cVar3;
                    JsonSerializer<?> jsonSerializerM2015f = null;
                    ArrayIterator2 arrayIterator23 = (ArrayIterator2) m1994j();
                    while (arrayIterator23.hasNext()) {
                        MapLikeType mapLikeType2 = mapLikeType;
                        jsonSerializerM2015f = ((Serializers) arrayIterator23.next()).m2015f(serializationConfig3, mapLikeType, beanDescription, jsonSerializerMo2000H2, typeSerializerMo1972c, jsonSerializerMo2000H);
                        if (jsonSerializerM2015f != null) {
                            break;
                        }
                        mapLikeType = mapLikeType2;
                    }
                    jsonSerializerM1974e = jsonSerializerM2015f == null ? m1974e(serializerProvider, javaType, beanDescription) : jsonSerializerM2015f;
                    if (jsonSerializerM1974e != null && this._factoryConfig.m2282a()) {
                        ArrayIterator2 arrayIterator24 = (ArrayIterator2) this._factoryConfig.m2283b();
                        while (arrayIterator24.hasNext()) {
                            Objects.requireNonNull((BeanSerializerModifier) arrayIterator24.next());
                        }
                    }
                }
                aVar = aVar4;
                aVar2 = aVar3;
                cls = cls3;
                beanDescription2 = beanDescription3;
                cVar = cVar2;
            } else {
                JsonFormat.c cVar4 = cVar3;
                boolean z11 = z10;
                JsonSerializer<?> jsonSerializerM1974e3 = null;
                if (javaType.mo2111u()) {
                    CollectionLikeType collectionLikeType = (CollectionLikeType) javaType;
                    if (collectionLikeType instanceof CollectionType) {
                        CollectionType collectionType = (CollectionType) collectionLikeType;
                        SerializationConfig serializationConfig6 = serializerProvider._config;
                        ArrayIterator2 arrayIterator25 = (ArrayIterator2) m1994j();
                        while (true) {
                            if (!arrayIterator25.hasNext()) {
                                aVar = aVar4;
                                aVar2 = aVar3;
                                cls = cls3;
                                beanDescription2 = beanDescription3;
                                cVar = cVar4;
                                break;
                            }
                            Serializers serializers = (Serializers) arrayIterator25.next();
                            aVar = aVar4;
                            SerializationConfig serializationConfig7 = serializationConfig6;
                            aVar2 = aVar3;
                            cVar = cVar4;
                            SerializationConfig serializationConfig8 = serializationConfig6;
                            cls = cls3;
                            ArrayIterator2 arrayIterator26 = arrayIterator25;
                            beanDescription2 = beanDescription3;
                            jsonSerializerM1974e3 = serializers.m2016g(serializationConfig7, collectionType, beanDescription, typeSerializerMo1972c, jsonSerializerMo2000H);
                            if (jsonSerializerM1974e3 != null) {
                                break;
                            }
                            cls3 = cls;
                            beanDescription3 = beanDescription2;
                            aVar4 = aVar;
                            aVar3 = aVar2;
                            cVar4 = cVar;
                            serializationConfig6 = serializationConfig8;
                            arrayIterator25 = arrayIterator26;
                        }
                        if (jsonSerializerM1974e3 == null && (jsonSerializerM1974e3 = m1974e(serializerProvider, collectionType, beanDescription2)) == null) {
                            if (beanDescription2.mo1812a(null).m1601e() != cVar) {
                                Class<?> cls4 = collectionType._class;
                                if (EnumSet.class.isAssignableFrom(cls4)) {
                                    JavaType javaType3 = collectionType._elementType;
                                    if (!(ClassUtil.m2185q(javaType3._class) && javaType3._class != cls)) {
                                        javaType3 = null;
                                    }
                                    collectionSerializer2 = new EnumSetSerializer2(javaType3);
                                } else {
                                    Class<?> cls5 = collectionType._elementType._class;
                                    if (!RandomAccess.class.isAssignableFrom(cls4)) {
                                        z6 = z11;
                                        typeSerializer = typeSerializerMo1972c;
                                        jsonSerializer = jsonSerializerMo2000H;
                                        if (cls5 == String.class && ClassUtil.m2187s(jsonSerializer)) {
                                            jsonSerializerM1974e3 = StringCollectionSerializer.f4844k;
                                        }
                                    } else if (cls5 == String.class) {
                                        if (ClassUtil.m2187s(jsonSerializerMo2000H)) {
                                            jsonSerializerM1974e3 = IndexedStringListSerializer.f4817k;
                                        }
                                        z6 = z11;
                                        typeSerializer = typeSerializerMo1972c;
                                        jsonSerializer = jsonSerializerMo2000H;
                                    } else {
                                        z6 = z11;
                                        typeSerializer = typeSerializerMo1972c;
                                        jsonSerializer = jsonSerializerMo2000H;
                                        jsonSerializerM1974e3 = new IndexedListSerializer(collectionType._elementType, z6, typeSerializer, jsonSerializer);
                                    }
                                    if (jsonSerializerM1974e3 == null) {
                                        collectionSerializer2 = new CollectionSerializer2(collectionType._elementType, z6, typeSerializer, jsonSerializer);
                                    }
                                    jsonSerializerM1974e = jsonSerializerM1974e3;
                                    if (this._factoryConfig.m2282a()) {
                                    }
                                }
                                jsonSerializerM1974e = collectionSerializer2;
                                if (this._factoryConfig.m2282a()) {
                                }
                            }
                            jsonSerializerM1974e = null;
                        } else {
                            jsonSerializerM1974e = jsonSerializerM1974e3;
                            if (this._factoryConfig.m2282a()) {
                                ArrayIterator2 arrayIterator27 = (ArrayIterator2) this._factoryConfig.m2283b();
                                while (arrayIterator27.hasNext()) {
                                    Objects.requireNonNull((BeanSerializerModifier) arrayIterator27.next());
                                }
                            }
                        }
                    } else {
                        aVar = aVar4;
                        aVar2 = aVar3;
                        cls = cls3;
                        beanDescription2 = beanDescription3;
                        TypeSerializer typeSerializer3 = typeSerializerMo1972c;
                        JsonSerializer<Object> jsonSerializer3 = jsonSerializerMo2000H;
                        cVar = cVar4;
                        ArrayIterator2 arrayIterator28 = (ArrayIterator2) m1994j();
                        JsonSerializer<?> jsonSerializerM2013d = null;
                        while (arrayIterator28.hasNext()) {
                            SerializationConfig serializationConfig9 = serializationConfig3;
                            JsonSerializer<Object> jsonSerializer4 = jsonSerializer3;
                            TypeSerializer typeSerializer4 = typeSerializer3;
                            jsonSerializerM2013d = ((Serializers) arrayIterator28.next()).m2013d(serializationConfig9, collectionLikeType, beanDescription, typeSerializer3, jsonSerializer4);
                            if (jsonSerializerM2013d != null) {
                                break;
                            }
                            serializationConfig3 = serializationConfig9;
                            typeSerializer3 = typeSerializer4;
                            jsonSerializer3 = jsonSerializer4;
                        }
                        jsonSerializerM1974e = jsonSerializerM2013d == null ? m1974e(serializerProvider, javaType, beanDescription) : jsonSerializerM2013d;
                        if (jsonSerializerM1974e != null && this._factoryConfig.m2282a()) {
                            ArrayIterator2 arrayIterator29 = (ArrayIterator2) this._factoryConfig.m2283b();
                            while (arrayIterator29.hasNext()) {
                                Objects.requireNonNull((BeanSerializerModifier) arrayIterator29.next());
                            }
                        }
                    }
                } else {
                    aVar = aVar4;
                    aVar2 = aVar3;
                    cls = cls3;
                    beanDescription2 = beanDescription3;
                    boolean z12 = z11;
                    cVar = cVar4;
                    if (javaType instanceof ArrayType) {
                        ArrayType arrayType = (ArrayType) javaType;
                        SerializationConfig serializationConfig10 = serializerProvider._config;
                        ArrayIterator2 arrayIterator210 = (ArrayIterator2) m1994j();
                        jsonSerializerM1974e = null;
                        while (true) {
                            if (!arrayIterator210.hasNext()) {
                                z5 = z12;
                                break;
                            }
                            SerializationConfig serializationConfig11 = serializationConfig10;
                            SerializationConfig serializationConfig12 = serializationConfig10;
                            z5 = z12;
                            jsonSerializerM1974e = ((Serializers) arrayIterator210.next()).m2014e(serializationConfig11, arrayType, beanDescription, typeSerializerMo1972c, jsonSerializerMo2000H);
                            if (jsonSerializerM1974e != null) {
                                break;
                            }
                            z12 = z5;
                            serializationConfig10 = serializationConfig12;
                            jsonSerializerM1974e = jsonSerializerM1974e;
                        }
                        if (jsonSerializerM1974e == null) {
                            Class<?> cls6 = arrayType._class;
                            if (jsonSerializerMo2000H != null) {
                                jsonSerializerM1974e = jsonSerializerM1974e;
                                if (ClassUtil.m2187s(jsonSerializerMo2000H)) {
                                    jsonSerializerM1974e = String[].class == cls6 ? StringArraySerializer2.f4843k : StdArraySerializers.f4855a.get(cls6.getName());
                                }
                                if (jsonSerializerM1974e == null) {
                                    jsonSerializerM1974e = new ObjectArraySerializer2(arrayType._componentType, z5, typeSerializerMo1972c, jsonSerializerMo2000H);
                                }
                            }
                        }
                        if (this._factoryConfig.m2282a()) {
                            ArrayIterator2 arrayIterator211 = (ArrayIterator2) this._factoryConfig.m2283b();
                            while (arrayIterator211.hasNext()) {
                                Objects.requireNonNull((BeanSerializerModifier) arrayIterator211.next());
                            }
                        }
                    } else {
                        jsonSerializerM1974e = null;
                    }
                }
            }
            if (jsonSerializerM1974e != null) {
                return jsonSerializerM1974e;
            }
            i = 3;
            z8 = zM1976g;
        } else {
            aVar = aVar4;
            aVar2 = aVar3;
            cVar = cVar3;
            cls = cls3;
            beanDescription2 = beanDescription3;
            if (javaType.mo1728b()) {
                ReferenceType referenceType = (ReferenceType) javaType;
                JavaType javaType4 = referenceType._referencedType;
                TypeSerializer typeSerializerMo1972c2 = (TypeSerializer) javaType4._typeHandler;
                SerializationConfig serializationConfig13 = serializerProvider._config;
                if (typeSerializerMo1972c2 == null) {
                    typeSerializerMo1972c2 = mo1972c(serializationConfig13, javaType4);
                }
                TypeSerializer typeSerializer5 = typeSerializerMo1972c2;
                JsonSerializer<Object> jsonSerializer5 = (JsonSerializer) javaType4._valueHandler;
                ArrayIterator2 arrayIterator212 = (ArrayIterator2) m1994j();
                while (true) {
                    if (arrayIterator212.hasNext()) {
                        JsonSerializer<Object> jsonSerializer6 = jsonSerializer5;
                        TypeSerializer typeSerializer6 = typeSerializer5;
                        SerializationConfig serializationConfig14 = serializationConfig13;
                        jsonSerializerM2010a = ((Serializers) arrayIterator212.next()).m2010a(serializationConfig13, referenceType, beanDescription, typeSerializer5, jsonSerializer6);
                        if (jsonSerializerM2010a != null) {
                            break;
                        }
                        jsonSerializer5 = jsonSerializer6;
                        typeSerializer5 = typeSerializer6;
                        serializationConfig13 = serializationConfig14;
                    } else {
                        JsonSerializer<Object> jsonSerializer7 = jsonSerializer5;
                        TypeSerializer typeSerializer7 = typeSerializer5;
                        if (referenceType.m2216B(AtomicReference.class)) {
                            JavaType javaType5 = referenceType._referencedType;
                            JsonInclude.b bVarM1973d2 = m1973d(serializerProvider, beanDescription2, javaType5, AtomicReference.class);
                            JsonInclude.a aVar6 = bVarM1973d2 == null ? aVar : bVarM1973d2._contentInclusion;
                            if (aVar6 == aVar || aVar6 == aVar2) {
                                i2 = 3;
                                objM572t0 = null;
                                zMo1999B = false;
                            } else {
                                int iOrdinal3 = aVar6.ordinal();
                                if (iOrdinal3 != 2) {
                                    i2 = 3;
                                    if (iOrdinal3 == 3) {
                                        objM572t0 = MapSerializer2.f4865l;
                                    } else if (iOrdinal3 == 4) {
                                        objM572t0 = AnimatableValueParser.m572t0(javaType5);
                                        if (objM572t0 != null && objM572t0.getClass().isArray()) {
                                            objM572t0 = AnimatableValueParser.m560q0(objM572t0);
                                        }
                                    } else if (iOrdinal3 != 5) {
                                        objM572t0 = null;
                                    } else {
                                        objM572t0 = serializerProvider.mo1998A(null, bVarM1973d2._contentFilter);
                                        if (objM572t0 != null) {
                                            zMo1999B = serializerProvider.mo1999B(objM572t0);
                                        }
                                    }
                                    zMo1999B = true;
                                } else {
                                    i2 = 3;
                                    if (javaType5.mo1728b()) {
                                        objM572t0 = MapSerializer2.f4865l;
                                    }
                                    zMo1999B = true;
                                }
                            }
                            ReferenceTypeSerializer<AtomicReference<?>> referenceTypeSerializerMo2049t = new AtomicReferenceSerializer(referenceType, z8, typeSerializer7, jsonSerializer7).mo2049t(objM572t0, zMo1999B);
                            i = i2;
                            jsonSerializerM1974e = referenceTypeSerializerMo2049t;
                        } else {
                            jsonSerializerM2010a = null;
                        }
                    }
                }
                i = 3;
                jsonSerializerM1974e = jsonSerializerM2010a;
            } else {
                i = 3;
                ArrayIterator2 arrayIterator213 = (ArrayIterator2) m1994j();
                JsonSerializer<?> jsonSerializerM2011b = null;
                while (arrayIterator213.hasNext() && (jsonSerializerM2011b = ((Serializers) arrayIterator213.next()).m2011b(serializationConfig2, javaType, beanDescription2)) == null) {
                }
                jsonSerializerM1974e = jsonSerializerM2011b;
            }
            if (jsonSerializerM1974e == null) {
                jsonSerializerM1974e = m1974e(serializerProvider, javaType, beanDescription);
            }
        }
        if (jsonSerializerM1974e == null) {
            String name = javaType._class.getName();
            JsonSerializer<?> jsonSerializer8 = BasicSerializerFactory.f4788j.get(name);
            if (jsonSerializer8 != null || (cls2 = BasicSerializerFactory.f4789k.get(name)) == null) {
                jsonSerializerM1974e = jsonSerializer8;
                i3 = 0;
            } else {
                i3 = 0;
                jsonSerializerM1974e = (JsonSerializer) ClassUtil.m2175g(cls2, false);
            }
            if (jsonSerializerM1974e == null) {
                if (javaType.m2219w()) {
                    SerializationConfig serializationConfig15 = serializerProvider._config;
                    JsonFormat.d dVarMo1812a = beanDescription2.mo1812a(null);
                    if (dVarMo1812a.m1601e() == cVar) {
                        Iterator<BeanPropertyDefinition> it = ((BasicBeanDescription) beanDescription2).m1919d().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (it.next().mo1858p().equals("declaringClass")) {
                                it.remove();
                                break;
                            }
                        }
                        enumSerializer2 = null;
                    } else {
                        Class<?> cls7 = javaType._class;
                        int i5 = EnumSerializer2.f4857k;
                        EnumSerializer2 enumSerializer22 = new EnumSerializer2(EnumValues.m2198a(serializationConfig15, cls7), EnumSerializer2.m2068p(cls7, dVarMo1812a, true, null));
                        if (this._factoryConfig.m2282a()) {
                            ArrayIterator2 arrayIterator214 = (ArrayIterator2) this._factoryConfig.m2283b();
                            while (arrayIterator214.hasNext()) {
                                Objects.requireNonNull((BeanSerializerModifier) arrayIterator214.next());
                            }
                        }
                        enumSerializer2 = enumSerializer22;
                    }
                    c = 1;
                    jsonSerializerM1974e = enumSerializer2;
                } else {
                    c = 1;
                    Class<?> cls8 = javaType._class;
                    ?? M1809a = OptionalHandlerFactory.f4625l.m1809a(serializerProvider._config, javaType, beanDescription2);
                    if (M1809a != 0) {
                        jsonSerializerM1974e = M1809a;
                    } else if (Calendar.class.isAssignableFrom(cls8)) {
                        jsonSerializerM1974e = CalendarSerializer2.f4854k;
                    } else if (Date.class.isAssignableFrom(cls8)) {
                        jsonSerializerM1974e = DateSerializer2.f4856k;
                    } else if (Map.Entry.class.isAssignableFrom(cls8)) {
                        JavaType javaTypeMo2144i = javaType.mo2144i(Map.Entry.class);
                        JavaType javaTypeM2217h = javaTypeMo2144i.m2217h(i3);
                        JavaType javaTypeM2217h2 = javaTypeMo2144i.m2217h(1);
                        JsonFormat.d dVarMo2271i = serializerProvider._config.mo2271i(Map.Entry.class);
                        JsonFormat.d dVarMo1812a2 = beanDescription2.mo1812a(null);
                        if (dVarMo1812a2 != null) {
                            dVarMo2271i = dVarMo1812a2.m1607k(dVarMo2271i);
                        }
                        if (dVarMo2271i.m1601e() == cVar) {
                            M1809a = 0;
                        } else {
                            M1809a = new MapEntrySerializer(javaTypeM2217h2, javaTypeM2217h, javaTypeM2217h2, z8, mo1972c(serializerProvider._config, javaTypeM2217h2), null);
                            JavaType javaType6 = M1809a._valueType;
                            JsonInclude.b bVarM1973d3 = m1973d(serializerProvider, beanDescription2, javaType6, Map.Entry.class);
                            JsonInclude.a aVar7 = bVarM1973d3 == null ? aVar : bVarM1973d3._contentInclusion;
                            if (aVar7 != aVar && aVar7 != aVar2) {
                                int iOrdinal4 = aVar7.ordinal();
                                if (iOrdinal4 != 2) {
                                    if (iOrdinal4 == i) {
                                        objM572t02 = MapSerializer2.f4865l;
                                    } else if (iOrdinal4 == 4) {
                                        objM572t02 = AnimatableValueParser.m572t0(javaType6);
                                        if (objM572t02 != null && objM572t02.getClass().isArray()) {
                                            objM572t02 = AnimatableValueParser.m560q0(objM572t02);
                                        }
                                    } else if (iOrdinal4 != 5) {
                                        objM572t02 = null;
                                    } else {
                                        objM572t02 = serializerProvider.mo1998A(null, bVarM1973d3._contentFilter);
                                        if (objM572t02 != null) {
                                            zMo1999B2 = serializerProvider.mo1999B(objM572t02);
                                        }
                                        if (M1809a._suppressableValue != objM572t02 || M1809a._suppressNulls != zMo1999B2) {
                                            M1809a = new MapEntrySerializer(M1809a, M1809a._keySerializer, M1809a._valueSerializer, objM572t02, zMo1999B2);
                                        }
                                    }
                                    zMo1999B2 = true;
                                    if (M1809a._suppressableValue != objM572t02) {
                                        M1809a = new MapEntrySerializer(M1809a, M1809a._keySerializer, M1809a._valueSerializer, objM572t02, zMo1999B2);
                                    }
                                } else {
                                    if (javaType6.mo1728b()) {
                                        objM572t02 = MapSerializer2.f4865l;
                                    }
                                    zMo1999B2 = true;
                                    if (M1809a._suppressableValue != objM572t02) {
                                    }
                                }
                            }
                        }
                        jsonSerializerM1974e = M1809a;
                    } else {
                        jsonSerializerM1974e = ByteBuffer.class.isAssignableFrom(cls8) ? new ByteBufferSerializer() : InetAddress.class.isAssignableFrom(cls8) ? new InetAddressSerializer() : InetSocketAddress.class.isAssignableFrom(cls8) ? new InetSocketAddressSerializer() : TimeZone.class.isAssignableFrom(cls8) ? new TimeZoneSerializer2() : Charset.class.isAssignableFrom(cls8) ? ToStringSerializer.f4866k : (!Number.class.isAssignableFrom(cls8) || (iOrdinal = beanDescription2.mo1812a(null).m1601e().ordinal()) == i || iOrdinal == 4) ? null : iOrdinal != 8 ? NumberSerializer.f4868k : ToStringSerializer.f4866k;
                    }
                }
                if (jsonSerializerM1974e == null) {
                    Class<?> cls9 = javaType._class;
                    Annotation[] annotationArr = ClassUtil.f4944a;
                    if ((cls9.isAnnotation() ? "annotation" : cls9.isArray() ? "array" : cls.isAssignableFrom(cls9) ? "enum" : cls9.isPrimitive() ? "primitive" : null) == null) {
                        String name2 = cls9.getName();
                        boolean z13 = !(name2.startsWith("net.sf.cglib.proxy.") || name2.startsWith("org.hibernate.proxy."));
                        if (!z13 && !ClassUtil.m2185q(javaType._class)) {
                            jsonSerializerM2259x = null;
                        } else if (beanDescription2.f4626a._class == Object.class) {
                            jsonSerializerM2259x = serializerProvider.m2259x(Object.class);
                        } else {
                            Class<?> cls10 = javaType._class;
                            if (cls10.getName().startsWith("java.time.")) {
                                str2 = "Java 8 date/time";
                                str3 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310";
                            } else if (cls10.getName().startsWith("org.joda.time.")) {
                                str2 = "Joda date/time";
                                str3 = "com.fasterxml.jackson.datatype:jackson-datatype-joda";
                            } else {
                                str = null;
                                unsupportedTypeSerializer = (str == null && serializerProvider._config.mo1885a(javaType._class) == null) ? new UnsupportedTypeSerializer(javaType, str) : null;
                                if (unsupportedTypeSerializer == null) {
                                    jsonSerializerM1974e = unsupportedTypeSerializer;
                                } else {
                                    SerializationConfig serializationConfig16 = serializerProvider._config;
                                    BeanSerializerBuilder beanSerializerBuilder = new BeanSerializerBuilder(beanDescription2);
                                    beanSerializerBuilder.f4798c = serializationConfig16;
                                    BasicBeanDescription basicBeanDescription3 = (BasicBeanDescription) beanDescription2;
                                    List<BeanPropertyDefinition> listM1919d = basicBeanDescription3.m1919d();
                                    SerializationConfig serializationConfig17 = serializerProvider._config;
                                    AnnotationIntrospector annotationIntrospectorM2267e2 = serializationConfig17.m2267e();
                                    HashMap map = new HashMap();
                                    Iterator<BeanPropertyDefinition> it2 = listM1919d.iterator();
                                    while (it2.hasNext()) {
                                        BeanPropertyDefinition next = it2.next();
                                        if (next.m1922j() == null) {
                                            it2.remove();
                                        } else {
                                            Class<?> clsMo1860r = next.mo1860r();
                                            Boolean boolMo1776c0 = (Boolean) map.get(clsMo1860r);
                                            if (boolMo1776c0 == null) {
                                                serializationConfig17.mo2268f(clsMo1860r);
                                                boolMo1776c0 = annotationIntrospectorM2267e2.mo1776c0(((BasicBeanDescription) serializationConfig17.m2277o(clsMo1860r)).f4736f);
                                                if (boolMo1776c0 == null) {
                                                    boolMo1776c0 = Boolean.FALSE;
                                                }
                                                map.put(clsMo1860r, boolMo1776c0);
                                            }
                                            if (boolMo1776c0.booleanValue()) {
                                                it2.remove();
                                            }
                                        }
                                    }
                                    if (serializationConfig17.m2279q(MapperFeature.REQUIRE_SETTERS_FOR_GETTERS)) {
                                        Iterator<BeanPropertyDefinition> it3 = listM1919d.iterator();
                                        while (it3.hasNext()) {
                                            BeanPropertyDefinition next2 = it3.next();
                                            if (!next2.mo1849f() && !next2.mo1863u()) {
                                                it3.remove();
                                            }
                                        }
                                    }
                                    if (listM1919d.isEmpty()) {
                                        arrayList = null;
                                        z3 = z8;
                                    } else {
                                        boolean zM1976g2 = m1976g(serializationConfig17, beanDescription2, null);
                                        PropertyBuilder propertyBuilder = new PropertyBuilder(serializationConfig17, beanDescription2);
                                        ArrayList arrayList3 = new ArrayList(listM1919d.size());
                                        for (BeanPropertyDefinition beanPropertyDefinition : listM1919d) {
                                            AnnotatedMember annotatedMemberM1922j = beanPropertyDefinition.m1922j();
                                            if (!beanPropertyDefinition.mo1864v()) {
                                                AnnotationIntrospector.a aVarMo1851h = beanPropertyDefinition.mo1851h();
                                                if (aVarMo1851h == null) {
                                                    if (annotatedMemberM1922j instanceof AnnotatedMethod) {
                                                        z4 = z8;
                                                        arrayList2 = arrayList3;
                                                        arrayList2.add(m1992h(serializerProvider, beanPropertyDefinition, propertyBuilder, zM1976g2, (AnnotatedMethod) annotatedMemberM1922j));
                                                    } else {
                                                        z4 = z8;
                                                        arrayList2 = arrayList3;
                                                        arrayList2.add(m1992h(serializerProvider, beanPropertyDefinition, propertyBuilder, zM1976g2, (AnnotatedField) annotatedMemberM1922j));
                                                    }
                                                    arrayList3 = arrayList2;
                                                    z8 = z4;
                                                } else {
                                                    if (aVarMo1851h.f4619a == 2) {
                                                        z4 = z8;
                                                        arrayList2 = arrayList3;
                                                    }
                                                    arrayList3 = arrayList2;
                                                    z8 = z4;
                                                }
                                            } else if (annotatedMemberM1922j == null) {
                                                continue;
                                            } else {
                                                if (beanSerializerBuilder.f4803h != null) {
                                                    StringBuilder sbM833U = outline.m833U("Multiple type ids specified with ");
                                                    sbM833U.append(beanSerializerBuilder.f4803h);
                                                    sbM833U.append(" and ");
                                                    sbM833U.append(annotatedMemberM1922j);
                                                    throw new IllegalArgumentException(sbM833U.toString());
                                                }
                                                beanSerializerBuilder.f4803h = annotatedMemberM1922j;
                                            }
                                        }
                                        z3 = z8;
                                        arrayList = arrayList3;
                                    }
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    } else {
                                        int size2 = arrayList.size();
                                        for (int i6 = 0; i6 < size2; i6++) {
                                            BeanPropertyWriter beanPropertyWriter = (BeanPropertyWriter) arrayList.get(i6);
                                            TypeSerializer typeSerializer8 = beanPropertyWriter._typeSerializer;
                                            if (typeSerializer8 != null && typeSerializer8.mo1957c() == JsonTypeInfo.a.EXTERNAL_PROPERTY) {
                                                PropertyName propertyNameM2227a = PropertyName.m2227a(typeSerializer8.mo1956b());
                                                Iterator it4 = arrayList.iterator();
                                                while (true) {
                                                    if (!it4.hasNext()) {
                                                        break;
                                                    }
                                                    BeanPropertyWriter beanPropertyWriter2 = (BeanPropertyWriter) it4.next();
                                                    if (beanPropertyWriter2 != beanPropertyWriter) {
                                                        PropertyName propertyName = beanPropertyWriter2._wrapperName;
                                                        if (propertyName != null) {
                                                            zEquals = propertyName.equals(propertyNameM2227a);
                                                        } else {
                                                            if (propertyNameM2227a._simpleName.equals(beanPropertyWriter2._name._value)) {
                                                                if (!(propertyNameM2227a._namespace != null)) {
                                                                    zEquals = true;
                                                                }
                                                            }
                                                            zEquals = false;
                                                        }
                                                        if (zEquals) {
                                                            beanPropertyWriter._typeSerializer = null;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    serializerProvider.m2257v().mo1771a(serializationConfig16, basicBeanDescription3.f4736f, arrayList);
                                    if (this._factoryConfig.m2282a()) {
                                        ArrayIterator2 arrayIterator215 = (ArrayIterator2) this._factoryConfig.m2283b();
                                        while (arrayIterator215.hasNext()) {
                                            Objects.requireNonNull((BeanSerializerModifier) arrayIterator215.next());
                                        }
                                    }
                                    JsonIgnoreProperties.a aVarM2280s2 = serializationConfig16.m2280s(beanDescription2.f4626a._class, basicBeanDescription3.f4736f);
                                    Set<String> setM1617d2 = aVarM2280s2 != null ? aVarM2280s2.m1617d() : null;
                                    Class<?> cls11 = beanDescription2.f4626a._class;
                                    AnnotatedClass annotatedClass4 = basicBeanDescription3.f4736f;
                                    AnnotationIntrospector annotationIntrospectorM2267e3 = serializationConfig16.m2267e();
                                    JsonIncludeProperties.a aVarMo1745A2 = annotationIntrospectorM2267e3 == null ? null : annotationIntrospectorM2267e3.mo1745A(serializationConfig16, annotatedClass4);
                                    Set<String> set = aVarMo1745A2 != null ? aVarMo1745A2._included : null;
                                    if (set != null || (setM1617d2 != null && !setM1617d2.isEmpty())) {
                                        Iterator it5 = arrayList.iterator();
                                        while (it5.hasNext()) {
                                            if (AnimatableValueParser.m502b2(((BeanPropertyWriter) it5.next())._name._value, setM1617d2, set)) {
                                                it5.remove();
                                            }
                                        }
                                    }
                                    if (this._factoryConfig.m2282a()) {
                                        ArrayIterator2 arrayIterator216 = (ArrayIterator2) this._factoryConfig.m2283b();
                                        while (arrayIterator216.hasNext()) {
                                            Objects.requireNonNull((BeanSerializerModifier) arrayIterator216.next());
                                        }
                                    }
                                    ObjectIdInfo objectIdInfo = basicBeanDescription3.f4740j;
                                    if (objectIdInfo == null) {
                                        objectIdWriterM2031a = null;
                                    } else {
                                        Class<? extends ObjectIdGenerator<?>> cls12 = objectIdInfo.f4629c;
                                        if (cls12 == ObjectIdGenerators3.class) {
                                            String str4 = objectIdInfo.f4628b._simpleName;
                                            int size3 = arrayList.size();
                                            for (int i7 = 0; i7 != size3; i7++) {
                                                BeanPropertyWriter beanPropertyWriter3 = (BeanPropertyWriter) arrayList.get(i7);
                                                if (str4.equals(beanPropertyWriter3._name._value)) {
                                                    if (i7 > 0) {
                                                        arrayList.remove(i7);
                                                        arrayList.add(0, beanPropertyWriter3);
                                                    }
                                                    objectIdWriterM2031a = ObjectIdWriter.m2031a(beanPropertyWriter3._declaredType, null, new PropertyBasedObjectIdGenerator(objectIdInfo, beanPropertyWriter3), objectIdInfo.f4632f);
                                                }
                                            }
                                            Object[] objArr = new Object[2];
                                            objArr[0] = ClassUtil.m2182n(beanDescription2.f4626a);
                                            objArr[1] = str4 == null ? "[null]" : ClassUtil.m2171c(str4);
                                            throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", objArr));
                                        }
                                        objectIdWriterM2031a = ObjectIdWriter.m2031a(serializerProvider.mo1940d().m2167i(serializerProvider.m1938b(cls12), ObjectIdGenerator.class)[0], objectIdInfo.f4628b, serializerProvider.m1941e(basicBeanDescription3.f4736f, objectIdInfo), objectIdInfo.f4632f);
                                    }
                                    beanSerializerBuilder.f4804i = objectIdWriterM2031a;
                                    beanSerializerBuilder.f4799d = arrayList;
                                    beanSerializerBuilder.f4802g = serializationConfig16.m2267e().mo1783g(basicBeanDescription3.f4736f);
                                    POJOPropertiesCollector pOJOPropertiesCollector = basicBeanDescription3.f4733c;
                                    if (pOJOPropertiesCollector == null) {
                                        first = null;
                                        if (first != null) {
                                            JavaType javaTypeMo1821e = first.mo1821e();
                                            JavaType javaTypeMo2099k = javaTypeMo1821e.mo2099k();
                                            TypeSerializer typeSerializerMo1972c3 = mo1972c(serializationConfig16, javaTypeMo2099k);
                                            JsonSerializer jsonSerializerM1975f = m1975f(serializerProvider, first);
                                            if (jsonSerializerM1975f == null) {
                                                jsonSerializerM1975f = MapSerializer2.m2082s(null, null, javaTypeMo1821e, serializationConfig16.m2279q(MapperFeature.USE_STATIC_TYPING), typeSerializerMo1972c3, null, null, null);
                                            }
                                            beanSerializerBuilder.f4801f = new AnyGetterWriter(new BeanProperty.a(PropertyName.m2227a(first.mo1819c()), javaTypeMo2099k, null, first, PropertyMetadata.f5026k), first, jsonSerializerM1975f);
                                        }
                                        List<BeanPropertyWriter> list2 = beanSerializerBuilder.f4799d;
                                        zM2279q = serializationConfig16.m2279q(MapperFeature.DEFAULT_VIEW_INCLUSION);
                                        size = list2.size();
                                        BeanPropertyWriter[] beanPropertyWriterArr = new BeanPropertyWriter[size];
                                        i4 = 0;
                                        int i8 = 0;
                                        while (i4 < size) {
                                            BeanPropertyWriter beanPropertyWriter4 = list2.get(i4);
                                            Class<?>[] clsArr = beanPropertyWriter4._includeInViews;
                                            if (clsArr == null || clsArr.length == 0) {
                                                list = list2;
                                                if (zM2279q) {
                                                    beanPropertyWriterArr[i4] = beanPropertyWriter4;
                                                }
                                            } else {
                                                i8++;
                                                list = list2;
                                                beanPropertyWriterArr[i4] = clsArr.length == 1 ? new FilteredBeanPropertyWriter2(beanPropertyWriter4, clsArr[0]) : new FilteredBeanPropertyWriter(beanPropertyWriter4, clsArr);
                                            }
                                            i4++;
                                            list2 = list;
                                        }
                                        if (zM2279q || i8 != 0) {
                                            if (size == beanSerializerBuilder.f4799d.size()) {
                                                throw new IllegalArgumentException(String.format("Trying to set %d filtered properties; must match length of non-filtered `properties` (%d)", Integer.valueOf(size), Integer.valueOf(beanSerializerBuilder.f4799d.size())));
                                            }
                                            beanSerializerBuilder.f4800e = beanPropertyWriterArr;
                                        }
                                        if (this._factoryConfig.m2282a()) {
                                            ArrayIterator2 arrayIterator217 = (ArrayIterator2) this._factoryConfig.m2283b();
                                            while (arrayIterator217.hasNext()) {
                                                Objects.requireNonNull((BeanSerializerModifier) arrayIterator217.next());
                                            }
                                        }
                                        try {
                                            jsonSerializerM1974e = beanSerializerBuilder.m1990a();
                                            if (jsonSerializerM1974e == null) {
                                                if (javaType.m2215A()) {
                                                    jsonSerializerM1974e = new BeanSerializer2(beanSerializerBuilder.f4797b.f4626a, beanSerializerBuilder, BeanSerializerBase.f4851k, null);
                                                } else {
                                                    Class<?> cls13 = javaType._class;
                                                    if (Iterator.class.isAssignableFrom(cls13)) {
                                                        JavaType[] javaTypeArrM2167i = serializationConfig16._base._typeFactory.m2167i(javaType, Iterator.class);
                                                        JavaType javaTypeM2158k = (javaTypeArrM2167i == null || javaTypeArrM2167i.length != 1) ? TypeFactory.m2158k() : javaTypeArrM2167i[0];
                                                        jsonSerializerM1974e = new IteratorSerializer(javaTypeM2158k, z3, mo1972c(serializationConfig16, javaTypeM2158k));
                                                    } else {
                                                        boolean z14 = z3;
                                                        if (Iterable.class.isAssignableFrom(cls13)) {
                                                            JavaType[] javaTypeArrM2167i2 = serializationConfig16._base._typeFactory.m2167i(javaType, Iterable.class);
                                                            JavaType javaTypeM2158k2 = (javaTypeArrM2167i2 == null || javaTypeArrM2167i2.length != 1) ? TypeFactory.m2158k() : javaTypeArrM2167i2[0];
                                                            jsonSerializerM1974e = new IterableSerializer(javaTypeM2158k2, z14, mo1972c(serializationConfig16, javaTypeM2158k2));
                                                        } else {
                                                            jsonSerializerM1974e = CharSequence.class.isAssignableFrom(cls13) ? ToStringSerializer.f4866k : null;
                                                        }
                                                    }
                                                    if (jsonSerializerM1974e == null) {
                                                        if (basicBeanDescription3.f4736f.f4663t.size() > 0) {
                                                            jsonSerializerM1974e = new BeanSerializer2(beanSerializerBuilder.f4797b.f4626a, beanSerializerBuilder, BeanSerializerBase.f4851k, null);
                                                        }
                                                    }
                                                }
                                            }
                                        } catch (RuntimeException e) {
                                            serializerProvider.m2242F(beanDescription2, "Failed to construct BeanSerializer for %s: (%s) %s", beanDescription2.f4626a, e.getClass().getName(), e.getMessage());
                                            throw null;
                                        }
                                    } else {
                                        if (!pOJOPropertiesCollector.f4641i) {
                                            pOJOPropertiesCollector.m1829h();
                                        }
                                        LinkedList<AnnotatedMember> linkedList = pOJOPropertiesCollector.f4645m;
                                        if (linkedList == null) {
                                            first = null;
                                        } else {
                                            if (linkedList.size() > 1) {
                                                pOJOPropertiesCollector.m1830i("Multiple 'any-getter' methods defined (%s vs %s)", pOJOPropertiesCollector.f4645m.get(0), pOJOPropertiesCollector.f4645m.get(1));
                                                throw null;
                                            }
                                            first = pOJOPropertiesCollector.f4645m.getFirst();
                                        }
                                        if (first == null) {
                                            POJOPropertiesCollector pOJOPropertiesCollector2 = basicBeanDescription3.f4733c;
                                            if (!pOJOPropertiesCollector2.f4641i) {
                                                pOJOPropertiesCollector2.m1829h();
                                            }
                                            LinkedList<AnnotatedMember> linkedList2 = pOJOPropertiesCollector2.f4646n;
                                            if (linkedList2 == null) {
                                                first = null;
                                            } else {
                                                if (linkedList2.size() > 1) {
                                                    pOJOPropertiesCollector2.m1830i("Multiple 'any-getter' fields defined (%s vs %s)", pOJOPropertiesCollector2.f4646n.get(0), pOJOPropertiesCollector2.f4646n.get(1));
                                                    throw null;
                                                }
                                                first = pOJOPropertiesCollector2.f4646n.getFirst();
                                            }
                                            if (first != null) {
                                                if (!Map.class.isAssignableFrom(first.mo1820d())) {
                                                    throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on field '%s': type is not instance of java.util.Map", first.mo1819c()));
                                                }
                                            }
                                        } else if (!Map.class.isAssignableFrom(first.mo1820d())) {
                                            throw new IllegalArgumentException(String.format("Invalid 'any-getter' annotation on method %s(): return type is not instance of java.util.Map", first.mo1819c()));
                                        }
                                        if (first != null) {
                                        }
                                        List<BeanPropertyWriter> list22 = beanSerializerBuilder.f4799d;
                                        zM2279q = serializationConfig16.m2279q(MapperFeature.DEFAULT_VIEW_INCLUSION);
                                        size = list22.size();
                                        BeanPropertyWriter[] beanPropertyWriterArr2 = new BeanPropertyWriter[size];
                                        i4 = 0;
                                        int i82 = 0;
                                        while (i4 < size) {
                                        }
                                        if (zM2279q) {
                                            if (size == beanSerializerBuilder.f4799d.size()) {
                                            }
                                        }
                                    }
                                }
                                if (jsonSerializerM1974e == null) {
                                    jsonSerializerM1974e = serializerProvider.m2259x(beanDescription2.f4626a._class);
                                }
                            }
                            Object[] objArr2 = new Object[i];
                            objArr2[i3] = str2;
                            objArr2[c] = ClassUtil.m2182n(javaType);
                            objArr2[2] = str3;
                            str = String.format("%s type %s not supported by default: add Module \"%s\" to enable handling", objArr2);
                            if (str == null) {
                                if (unsupportedTypeSerializer == null) {
                                }
                                if (jsonSerializerM1974e == null) {
                                }
                            }
                        }
                        jsonSerializerM1974e = jsonSerializerM2259x;
                        if (jsonSerializerM1974e == null) {
                        }
                    }
                }
            }
        }
        if (jsonSerializerM1974e != null && this._factoryConfig.m2282a()) {
            ArrayIterator2 arrayIterator218 = (ArrayIterator2) this._factoryConfig.m2283b();
            while (arrayIterator218.hasNext()) {
                Objects.requireNonNull((BeanSerializerModifier) arrayIterator218.next());
            }
        }
        return jsonSerializerM1974e;
    }

    /* renamed from: j */
    public Iterable<Serializers> m1994j() {
        return new ArrayIterator2(this._factoryConfig._additionalSerializers);
    }
}
