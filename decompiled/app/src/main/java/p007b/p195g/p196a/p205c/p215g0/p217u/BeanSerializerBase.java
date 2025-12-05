package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p197a.ObjectIdGenerator;
import p007b.p195g.p196a.p197a.ObjectIdGenerators3;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.SerializableString;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.PropertyName;
import p007b.p195g.p196a.p205c.SerializationConfig;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p210c0.Annotated;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;
import p007b.p195g.p196a.p205c.p210c0.ObjectIdInfo;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.AnyGetterWriter;
import p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter;
import p007b.p195g.p196a.p205c.p215g0.BeanSerializerBuilder;
import p007b.p195g.p196a.p205c.p215g0.ContainerSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContextualSerializer;
import p007b.p195g.p196a.p205c.p215g0.ResolvableSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.MapEntrySerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.ObjectIdWriter;
import p007b.p195g.p196a.p205c.p215g0.p216t.PropertyBasedObjectIdGenerator;
import p007b.p195g.p196a.p205c.p215g0.p216t.WritableObjectId;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p195g.p196a.p205c.p219i0.Converter;
import p007b.p195g.p196a.p205c.p219i0.EnumValues;
import p007b.p195g.p196a.p205c.p219i0.NameTransformer4;

/* compiled from: BeanSerializerBase.java */
/* renamed from: b.g.a.c.g0.u.d, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class BeanSerializerBase extends StdSerializer<Object> implements ContextualSerializer, ResolvableSerializer {

    /* renamed from: k */
    public static final BeanPropertyWriter[] f4851k;
    public final AnyGetterWriter _anyGetterWriter;
    public final JavaType _beanType;
    public final BeanPropertyWriter[] _filteredProps;
    public final ObjectIdWriter _objectIdWriter;
    public final Object _propertyFilterId;
    public final BeanPropertyWriter[] _props;
    public final JsonFormat.c _serializationShape;
    public final AnnotatedMember _typeId;

    static {
        new PropertyName("#object-ref");
        f4851k = new BeanPropertyWriter[0];
    }

    public BeanSerializerBase(JavaType javaType, BeanSerializerBuilder beanSerializerBuilder, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(javaType);
        this._beanType = javaType;
        this._props = beanPropertyWriterArr;
        this._filteredProps = beanPropertyWriterArr2;
        if (beanSerializerBuilder == null) {
            this._typeId = null;
            this._anyGetterWriter = null;
            this._propertyFilterId = null;
            this._objectIdWriter = null;
            this._serializationShape = null;
            return;
        }
        this._typeId = beanSerializerBuilder.f4803h;
        this._anyGetterWriter = beanSerializerBuilder.f4801f;
        this._propertyFilterId = beanSerializerBuilder.f4802g;
        this._objectIdWriter = beanSerializerBuilder.f4804i;
        this._serializationShape = beanSerializerBuilder.f4797b.mo1812a(null).m1601e();
    }

    /* renamed from: t */
    public static final BeanPropertyWriter[] m2051t(BeanPropertyWriter[] beanPropertyWriterArr, NameTransformer4 nameTransformer4) {
        if (beanPropertyWriterArr == null || beanPropertyWriterArr.length == 0 || nameTransformer4 == null || nameTransformer4 == NameTransformer4.f4961j) {
            return beanPropertyWriterArr;
        }
        int length = beanPropertyWriterArr.length;
        BeanPropertyWriter[] beanPropertyWriterArr2 = new BeanPropertyWriter[length];
        for (int i = 0; i < length; i++) {
            BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
            if (beanPropertyWriter != null) {
                beanPropertyWriterArr2[i] = beanPropertyWriter.mo1981g(nameTransformer4);
            }
        }
        return beanPropertyWriterArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0171  */
    @Override // p007b.p195g.p196a.p205c.p215g0.ContextualSerializer
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonSerializer<?> mo1997a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.c cVarM1601e;
        Object objMo1783g;
        Set<String> set;
        Set<String> setM1617d;
        int i;
        BeanSerializerBase beanSerializerBaseMo1987w;
        Object obj;
        ObjectIdInfo objectIdInfoMo1795s;
        AnnotationIntrospector annotationIntrospectorM2257v = serializerProvider.m2257v();
        BeanPropertyWriter[] beanPropertyWriterArr = null;
        AnnotatedMember member = (beanProperty == null || annotationIntrospectorM2257v == null) ? null : beanProperty.getMember();
        SerializationConfig serializationConfig = serializerProvider._config;
        JsonFormat.d dVarM2074l = m2074l(serializerProvider, beanProperty, this._handledType);
        char c = 0;
        if (dVarM2074l == null || !dVarM2074l.m1605i()) {
            cVarM1601e = null;
        } else {
            cVarM1601e = dVarM2074l.m1601e();
            if (cVarM1601e != JsonFormat.c.ANY && cVarM1601e != this._serializationShape) {
                if (this._beanType.m2219w()) {
                    int iOrdinal = cVarM1601e.ordinal();
                    if (iOrdinal == 5 || iOrdinal == 7 || iOrdinal == 8) {
                        serializationConfig.m2276n(this._beanType);
                        Class<?> cls = this._beanType._class;
                        return serializerProvider.m2260y(new EnumSerializer2(EnumValues.m2198a(serializerProvider._config, cls), EnumSerializer2.m2068p(cls, dVarM2074l, true, null)), beanProperty);
                    }
                } else if (cVarM1601e == JsonFormat.c.NATURAL && ((!this._beanType.mo2122z() || !Map.class.isAssignableFrom(this._handledType)) && Map.Entry.class.isAssignableFrom(this._handledType))) {
                    JavaType javaTypeMo2144i = this._beanType.mo2144i(Map.Entry.class);
                    return serializerProvider.m2260y(new MapEntrySerializer(this._beanType, javaTypeMo2144i.m2217h(0), javaTypeMo2144i.m2217h(1), false, null, beanProperty), beanProperty);
                }
            }
        }
        ObjectIdWriter objectIdWriterM2031a = this._objectIdWriter;
        if (member != null) {
            setM1617d = annotationIntrospectorM2257v.mo1800x(serializationConfig, member).m1617d();
            set = annotationIntrospectorM2257v.mo1745A(serializationConfig, member)._included;
            ObjectIdInfo objectIdInfoMo1794r = annotationIntrospectorM2257v.mo1794r(member);
            if (objectIdInfoMo1794r != null) {
                ObjectIdInfo objectIdInfoMo1795s2 = annotationIntrospectorM2257v.mo1795s(member, objectIdInfoMo1794r);
                Class<? extends ObjectIdGenerator<?>> cls2 = objectIdInfoMo1795s2.f4629c;
                JavaType javaType = serializerProvider.mo1940d().m2167i(serializerProvider.m1938b(cls2), ObjectIdGenerator.class)[0];
                if (cls2 == ObjectIdGenerators3.class) {
                    String str = objectIdInfoMo1795s2.f4628b._simpleName;
                    int length = this._props.length;
                    i = 0;
                    while (i != length) {
                        BeanPropertyWriter beanPropertyWriter = this._props[i];
                        if (str.equals(beanPropertyWriter._name._value)) {
                            objectIdWriterM2031a = ObjectIdWriter.m2031a(beanPropertyWriter._declaredType, null, new PropertyBasedObjectIdGenerator(objectIdInfoMo1795s2, beanPropertyWriter), objectIdInfoMo1795s2.f4632f);
                            objMo1783g = annotationIntrospectorM2257v.mo1783g(member);
                            if (objMo1783g != null || ((obj = this._propertyFilterId) != null && objMo1783g.equals(obj))) {
                                objMo1783g = null;
                            }
                        } else {
                            i++;
                            c = 0;
                        }
                    }
                    JavaType javaType2 = this._beanType;
                    Object[] objArr = new Object[2];
                    objArr[c] = ClassUtil.m2189u(this._handledType);
                    objArr[1] = str == null ? "[null]" : ClassUtil.m2171c(str);
                    serializerProvider.mo1942f(javaType2, String.format("Invalid Object Id definition for %s: cannot find property with name %s", objArr));
                    throw null;
                }
                objectIdWriterM2031a = ObjectIdWriter.m2031a(javaType, objectIdInfoMo1795s2.f4628b, serializerProvider.m1941e(member, objectIdInfoMo1795s2), objectIdInfoMo1795s2.f4632f);
            } else if (objectIdWriterM2031a != null && (objectIdInfoMo1795s = annotationIntrospectorM2257v.mo1795s(member, null)) != null) {
                objectIdWriterM2031a = this._objectIdWriter;
                boolean z2 = objectIdInfoMo1795s.f4632f;
                if (z2 != objectIdWriterM2031a.f4822e) {
                    objectIdWriterM2031a = new ObjectIdWriter(objectIdWriterM2031a.f4818a, objectIdWriterM2031a.f4819b, objectIdWriterM2031a.f4820c, objectIdWriterM2031a.f4821d, z2);
                }
            }
            i = 0;
            objMo1783g = annotationIntrospectorM2257v.mo1783g(member);
            if (objMo1783g != null) {
                objMo1783g = null;
            }
        } else {
            objMo1783g = null;
            set = null;
            setM1617d = null;
            i = 0;
        }
        if (i > 0) {
            BeanPropertyWriter[] beanPropertyWriterArr2 = this._props;
            BeanPropertyWriter[] beanPropertyWriterArr3 = (BeanPropertyWriter[]) Arrays.copyOf(beanPropertyWriterArr2, beanPropertyWriterArr2.length);
            BeanPropertyWriter beanPropertyWriter2 = beanPropertyWriterArr3[i];
            System.arraycopy(beanPropertyWriterArr3, 0, beanPropertyWriterArr3, 1, i);
            beanPropertyWriterArr3[0] = beanPropertyWriter2;
            BeanPropertyWriter[] beanPropertyWriterArr4 = this._filteredProps;
            if (beanPropertyWriterArr4 != null) {
                beanPropertyWriterArr = (BeanPropertyWriter[]) Arrays.copyOf(beanPropertyWriterArr4, beanPropertyWriterArr4.length);
                BeanPropertyWriter beanPropertyWriter3 = beanPropertyWriterArr[i];
                System.arraycopy(beanPropertyWriterArr, 0, beanPropertyWriterArr, 1, i);
                beanPropertyWriterArr[0] = beanPropertyWriter3;
            }
            beanSerializerBaseMo1987w = mo1989y(beanPropertyWriterArr3, beanPropertyWriterArr);
        } else {
            beanSerializerBaseMo1987w = this;
        }
        if (objectIdWriterM2031a != null) {
            ObjectIdWriter objectIdWriter = new ObjectIdWriter(objectIdWriterM2031a.f4818a, objectIdWriterM2031a.f4819b, objectIdWriterM2031a.f4820c, serializerProvider.m2255t(objectIdWriterM2031a.f4818a, beanProperty), objectIdWriterM2031a.f4822e);
            if (objectIdWriter != this._objectIdWriter) {
                beanSerializerBaseMo1987w = beanSerializerBaseMo1987w.mo1988x(objectIdWriter);
            }
        }
        if ((setM1617d != null && !setM1617d.isEmpty()) || set != null) {
            beanSerializerBaseMo1987w = beanSerializerBaseMo1987w.mo1986v(setM1617d, set);
        }
        if (objMo1783g != null) {
            beanSerializerBaseMo1987w = beanSerializerBaseMo1987w.mo1987w(objMo1783g);
        }
        if (cVarM1601e == null) {
            cVarM1601e = this._serializationShape;
        }
        return cVarM1601e == JsonFormat.c.ARRAY ? beanSerializerBaseMo1987w.mo1985s() : beanSerializerBaseMo1987w;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00b6  */
    @Override // p007b.p195g.p196a.p205c.p215g0.ResolvableSerializer
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo2007b(SerializerProvider serializerProvider) throws JsonMappingException {
        BeanPropertyWriter beanPropertyWriter;
        TypeSerializer typeSerializer;
        Annotated annotated;
        Object objMo1752H;
        JsonSerializer<Object> jsonSerializer;
        BeanPropertyWriter beanPropertyWriter2;
        BeanPropertyWriter[] beanPropertyWriterArr = this._filteredProps;
        int length = beanPropertyWriterArr == null ? 0 : beanPropertyWriterArr.length;
        int length2 = this._props.length;
        for (int i = 0; i < length2; i++) {
            BeanPropertyWriter beanPropertyWriter3 = this._props[i];
            if (!beanPropertyWriter3._suppressNulls) {
                if (!(beanPropertyWriter3._nullSerializer != null) && (jsonSerializer = serializerProvider._nullValueSerializer) != null) {
                    beanPropertyWriter3.mo1979e(jsonSerializer);
                    if (i < length && (beanPropertyWriter2 = this._filteredProps[i]) != null) {
                        beanPropertyWriter2.mo1979e(jsonSerializer);
                    }
                }
            }
            if (!(beanPropertyWriter3._serializer != null)) {
                AnnotationIntrospector annotationIntrospectorM2257v = serializerProvider.m2257v();
                if (annotationIntrospectorM2257v != null && (annotated = beanPropertyWriter3._member) != null && (objMo1752H = annotationIntrospectorM2257v.mo1752H(annotated)) != null) {
                    Converter<Object, Object> converterM1939c = serializerProvider.m1939c(beanPropertyWriter3._member, objMo1752H);
                    JavaType javaTypeM2197a = converterM1939c.m2197a(serializerProvider.mo1940d());
                    jsonSerializerM2255t = new StdDelegatingSerializer(converterM1939c, javaTypeM2197a, javaTypeM2197a.m2221y() ? null : serializerProvider.m2255t(javaTypeM2197a, beanPropertyWriter3));
                }
                if (jsonSerializerM2255t == null) {
                    JavaType javaType = beanPropertyWriter3._cfgSerializationType;
                    if (javaType == null) {
                        javaType = beanPropertyWriter3._declaredType;
                        if (!javaType.m2220x()) {
                            if (javaType.mo2104v() || javaType.mo2143g() > 0) {
                                beanPropertyWriter3._nonTrivialBaseType = javaType;
                            }
                        }
                    }
                    jsonSerializerM2255t = serializerProvider.m2255t(javaType, beanPropertyWriter3);
                    if (javaType.mo2104v() && (typeSerializer = (TypeSerializer) javaType.mo2099k()._typeHandler) != null && (jsonSerializerM2255t instanceof ContainerSerializer)) {
                        ContainerSerializer containerSerializer = (ContainerSerializer) jsonSerializerM2255t;
                        Objects.requireNonNull(containerSerializer);
                        jsonSerializerM2255t = containerSerializer.mo1995p(typeSerializer);
                    }
                    if (i < length) {
                        beanPropertyWriter3.mo1980f(jsonSerializerM2255t);
                    }
                } else if (i < length || (beanPropertyWriter = this._filteredProps[i]) == null) {
                    beanPropertyWriter3.mo1980f(jsonSerializerM2255t);
                } else {
                    beanPropertyWriter.mo1980f(jsonSerializerM2255t);
                }
            }
        }
        AnyGetterWriter anyGetterWriter = this._anyGetterWriter;
        if (anyGetterWriter != null) {
            JsonSerializer<?> jsonSerializer2 = anyGetterWriter.f4786c;
            if (jsonSerializer2 instanceof ContextualSerializer) {
                JsonSerializer<?> jsonSerializerM2260y = serializerProvider.m2260y(jsonSerializer2, anyGetterWriter.f4784a);
                anyGetterWriter.f4786c = jsonSerializerM2260y;
                if (jsonSerializerM2260y instanceof MapSerializer2) {
                    anyGetterWriter.f4787d = (MapSerializer2) jsonSerializerM2260y;
                }
            }
        }
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: g */
    public void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws UnsupportedOperationException, IOException, IllegalArgumentException {
        if (this._objectIdWriter != null) {
            jsonGenerator.mo1654e(obj);
            m2053p(obj, jsonGenerator, serializerProvider, typeSerializer);
            return;
        }
        jsonGenerator.mo1654e(obj);
        WritableTypeId writableTypeIdM2055r = m2055r(typeSerializer, obj, JsonToken2.START_OBJECT);
        typeSerializer.mo1959e(jsonGenerator, writableTypeIdM2055r);
        Object obj2 = this._propertyFilterId;
        if (obj2 == null) {
            m2056u(obj, jsonGenerator, serializerProvider);
            typeSerializer.mo1960f(jsonGenerator, writableTypeIdM2055r);
        } else {
            if (this._filteredProps != null) {
                Class<?> cls = serializerProvider._serializationView;
            }
            m2075m(serializerProvider, obj2, obj);
            throw null;
        }
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: i */
    public boolean mo2052i() {
        return this._objectIdWriter != null;
    }

    /* renamed from: p */
    public final void m2053p(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        ObjectIdWriter objectIdWriter = this._objectIdWriter;
        WritableObjectId writableObjectIdMo2005p = serializerProvider.mo2005p(obj, objectIdWriter.f4820c);
        if (writableObjectIdMo2005p.m2043a(jsonGenerator, serializerProvider, objectIdWriter)) {
            return;
        }
        if (writableObjectIdMo2005p.f4848b == null) {
            writableObjectIdMo2005p.f4848b = writableObjectIdMo2005p.f4847a.mo1610c(obj);
        }
        Object obj2 = writableObjectIdMo2005p.f4848b;
        if (objectIdWriter.f4822e) {
            objectIdWriter.f4821d.mo1807f(obj2, jsonGenerator, serializerProvider);
            return;
        }
        ObjectIdWriter objectIdWriter2 = this._objectIdWriter;
        WritableTypeId writableTypeIdM2055r = m2055r(typeSerializer, obj, JsonToken2.START_OBJECT);
        typeSerializer.mo1959e(jsonGenerator, writableTypeIdM2055r);
        writableObjectIdMo2005p.f4849c = true;
        Objects.requireNonNull(jsonGenerator);
        SerializableString serializableString = objectIdWriter2.f4819b;
        if (serializableString != null) {
            jsonGenerator.mo1665x(serializableString);
            objectIdWriter2.f4821d.mo1807f(writableObjectIdMo2005p.f4848b, jsonGenerator, serializerProvider);
        }
        Object obj3 = this._propertyFilterId;
        if (obj3 != null) {
            m2075m(serializerProvider, obj3, obj);
            throw null;
        }
        m2056u(obj, jsonGenerator, serializerProvider);
        typeSerializer.mo1960f(jsonGenerator, writableTypeIdM2055r);
    }

    /* renamed from: q */
    public final void m2054q(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, boolean z2) throws IOException {
        ObjectIdWriter objectIdWriter = this._objectIdWriter;
        WritableObjectId writableObjectIdMo2005p = serializerProvider.mo2005p(obj, objectIdWriter.f4820c);
        if (writableObjectIdMo2005p.m2043a(jsonGenerator, serializerProvider, objectIdWriter)) {
            return;
        }
        if (writableObjectIdMo2005p.f4848b == null) {
            writableObjectIdMo2005p.f4848b = writableObjectIdMo2005p.f4847a.mo1610c(obj);
        }
        Object obj2 = writableObjectIdMo2005p.f4848b;
        if (objectIdWriter.f4822e) {
            objectIdWriter.f4821d.mo1807f(obj2, jsonGenerator, serializerProvider);
            return;
        }
        if (z2) {
            jsonGenerator.mo1653d0(obj);
        }
        writableObjectIdMo2005p.f4849c = true;
        SerializableString serializableString = objectIdWriter.f4819b;
        if (serializableString != null) {
            jsonGenerator.mo1665x(serializableString);
            objectIdWriter.f4821d.mo1807f(writableObjectIdMo2005p.f4848b, jsonGenerator, serializerProvider);
        }
        Object obj3 = this._propertyFilterId;
        if (obj3 != null) {
            m2075m(serializerProvider, obj3, obj);
            throw null;
        }
        m2056u(obj, jsonGenerator, serializerProvider);
        if (z2) {
            jsonGenerator.mo1664u();
        }
    }

    /* renamed from: r */
    public final WritableTypeId m2055r(TypeSerializer typeSerializer, Object obj, JsonToken2 jsonToken2) throws UnsupportedOperationException, IllegalArgumentException {
        AnnotatedMember annotatedMember = this._typeId;
        if (annotatedMember == null) {
            return typeSerializer.m1958d(obj, jsonToken2);
        }
        Object objMo1889j = annotatedMember.mo1889j(obj);
        if (objMo1889j == null) {
            objMo1889j = "";
        }
        WritableTypeId writableTypeIdM1958d = typeSerializer.m1958d(obj, jsonToken2);
        writableTypeIdM1958d.f4586c = objMo1889j;
        return writableTypeIdM1958d;
    }

    /* renamed from: s */
    public abstract BeanSerializerBase mo1985s();

    /* renamed from: u */
    public void m2056u(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        BeanPropertyWriter[] beanPropertyWriterArr = this._filteredProps;
        if (beanPropertyWriterArr == null || serializerProvider._serializationView == null) {
            beanPropertyWriterArr = this._props;
        }
        int i = 0;
        try {
            int length = beanPropertyWriterArr.length;
            while (i < length) {
                BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
                if (beanPropertyWriter != null) {
                    beanPropertyWriter.mo1983i(obj, jsonGenerator, serializerProvider);
                }
                i++;
            }
            AnyGetterWriter anyGetterWriter = this._anyGetterWriter;
            if (anyGetterWriter != null) {
                anyGetterWriter.m1970a(obj, jsonGenerator, serializerProvider);
            }
        } catch (Exception e) {
            m2077o(serializerProvider, e, obj, i != beanPropertyWriterArr.length ? beanPropertyWriterArr[i]._name._value : "[anySetter]");
            throw null;
        } catch (StackOverflowError e2) {
            JsonMappingException jsonMappingException = new JsonMappingException(jsonGenerator, "Infinite recursion (StackOverflowError)", e2);
            jsonMappingException.m8743e(new JsonMappingException.C10677a(obj, i != beanPropertyWriterArr.length ? beanPropertyWriterArr[i]._name._value : "[anySetter]"));
            throw jsonMappingException;
        }
    }

    /* renamed from: v */
    public abstract BeanSerializerBase mo1986v(Set<String> set, Set<String> set2);

    /* renamed from: w */
    public abstract BeanSerializerBase mo1987w(Object obj);

    /* renamed from: x */
    public abstract BeanSerializerBase mo1988x(ObjectIdWriter objectIdWriter);

    /* renamed from: y */
    public abstract BeanSerializerBase mo1989y(BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2);

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2) {
        super(beanSerializerBase._handledType);
        this._beanType = beanSerializerBase._beanType;
        this._props = beanPropertyWriterArr;
        this._filteredProps = beanPropertyWriterArr2;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = beanSerializerBase._objectIdWriter;
        this._propertyFilterId = beanSerializerBase._propertyFilterId;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, ObjectIdWriter objectIdWriter, Object obj) {
        super(beanSerializerBase._handledType);
        this._beanType = beanSerializerBase._beanType;
        this._props = beanSerializerBase._props;
        this._filteredProps = beanSerializerBase._filteredProps;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = objectIdWriter;
        this._propertyFilterId = obj;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, Set<String> set, Set<String> set2) {
        super(beanSerializerBase._handledType);
        this._beanType = beanSerializerBase._beanType;
        BeanPropertyWriter[] beanPropertyWriterArr = beanSerializerBase._props;
        BeanPropertyWriter[] beanPropertyWriterArr2 = beanSerializerBase._filteredProps;
        int length = beanPropertyWriterArr.length;
        ArrayList arrayList = new ArrayList(length);
        ArrayList arrayList2 = beanPropertyWriterArr2 == null ? null : new ArrayList(length);
        for (int i = 0; i < length; i++) {
            BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
            if (!AnimatableValueParser.m502b2(beanPropertyWriter._name._value, set, set2)) {
                arrayList.add(beanPropertyWriter);
                if (beanPropertyWriterArr2 != null) {
                    arrayList2.add(beanPropertyWriterArr2[i]);
                }
            }
        }
        this._props = (BeanPropertyWriter[]) arrayList.toArray(new BeanPropertyWriter[arrayList.size()]);
        this._filteredProps = arrayList2 != null ? (BeanPropertyWriter[]) arrayList2.toArray(new BeanPropertyWriter[arrayList2.size()]) : null;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = beanSerializerBase._objectIdWriter;
        this._propertyFilterId = beanSerializerBase._propertyFilterId;
        this._serializationShape = beanSerializerBase._serializationShape;
    }
}
