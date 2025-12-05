package p007b.p195g.p196a.p205c.p215g0;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.p200p.SerializedString;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.PropertyMetadata;
import p007b.p195g.p196a.p205c.PropertyName;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedField;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMethod;
import p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.PropertySerializerMap;
import p007b.p195g.p196a.p205c.p215g0.p217u.BeanSerializerBase;
import p007b.p195g.p196a.p205c.p219i0.Annotations;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p195g.p196a.p205c.p219i0.NameTransformer4;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* compiled from: BeanPropertyWriter.java */
@JacksonStdImpl
/* renamed from: b.g.a.c.g0.c, reason: use source file name */
/* loaded from: classes3.dex */
public class BeanPropertyWriter extends PropertyWriter implements Serializable {

    /* renamed from: j */
    public static final /* synthetic */ int f4790j = 0;
    private static final long serialVersionUID = 1;
    public final JavaType _cfgSerializationType;
    public final JavaType _declaredType;
    public final Class<?>[] _includeInViews;
    public final AnnotatedMember _member;
    public final SerializedString _name;
    public JavaType _nonTrivialBaseType;
    public JsonSerializer<Object> _nullSerializer;
    public JsonSerializer<Object> _serializer;
    public final boolean _suppressNulls;
    public final Object _suppressableValue;
    public TypeSerializer _typeSerializer;
    public final PropertyName _wrapperName;

    /* renamed from: k */
    public final transient Annotations f4791k;

    /* renamed from: l */
    public transient Method f4792l;

    /* renamed from: m */
    public transient Field f4793m;

    /* renamed from: n */
    public transient PropertySerializerMap f4794n;

    /* renamed from: o */
    public transient HashMap<Object, Object> f4795o;

    public BeanPropertyWriter(BeanPropertyDefinition beanPropertyDefinition, AnnotatedMember annotatedMember, Annotations annotations, JavaType javaType, JsonSerializer<?> jsonSerializer, TypeSerializer typeSerializer, JavaType javaType2, boolean z2, Object obj, Class<?>[] clsArr) {
        super(beanPropertyDefinition);
        this._member = annotatedMember;
        this.f4791k = annotations;
        this._name = new SerializedString(beanPropertyDefinition.mo1858p());
        this._wrapperName = beanPropertyDefinition.mo1862t();
        this._declaredType = javaType;
        this._serializer = jsonSerializer;
        this.f4794n = jsonSerializer == null ? PropertySerializerMap.b.f4828b : null;
        this._typeSerializer = typeSerializer;
        this._cfgSerializationType = javaType2;
        if (annotatedMember instanceof AnnotatedField) {
            this.f4792l = null;
            this.f4793m = (Field) annotatedMember.mo1888i();
        } else if (annotatedMember instanceof AnnotatedMethod) {
            this.f4792l = (Method) annotatedMember.mo1888i();
            this.f4793m = null;
        } else {
            this.f4792l = null;
            this.f4793m = null;
        }
        this._suppressNulls = z2;
        this._suppressableValue = obj;
        this._nullSerializer = null;
        this._includeInViews = clsArr;
    }

    /* renamed from: c */
    public JsonSerializer<Object> mo1977c(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) throws JsonMappingException, IllegalArgumentException {
        PropertySerializerMap.d dVar;
        JavaType javaType = this._nonTrivialBaseType;
        if (javaType != null) {
            JavaType javaTypeM2247k = serializerProvider.m2247k(javaType, cls);
            JsonSerializer<Object> jsonSerializerM2252q = serializerProvider.m2252q(javaTypeM2247k, this);
            dVar = new PropertySerializerMap.d(jsonSerializerM2252q, propertySerializerMap.mo2033b(javaTypeM2247k._class, jsonSerializerM2252q));
        } else {
            JsonSerializer<Object> jsonSerializerM2253r = serializerProvider.m2253r(cls, this);
            dVar = new PropertySerializerMap.d(jsonSerializerM2253r, propertySerializerMap.mo2033b(cls, jsonSerializerM2253r));
        }
        PropertySerializerMap propertySerializerMap2 = dVar.f4831b;
        if (propertySerializerMap != propertySerializerMap2) {
            this.f4794n = propertySerializerMap2;
        }
        return dVar.f4830a;
    }

    /* renamed from: d */
    public boolean m1978d(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, JsonSerializer jsonSerializer) throws IOException {
        if (jsonSerializer.mo2052i()) {
            return false;
        }
        if (serializerProvider.m2240D(SerializationFeature.FAIL_ON_SELF_REFERENCES)) {
            if (!(jsonSerializer instanceof BeanSerializerBase)) {
                return false;
            }
            serializerProvider.mo1942f(this._declaredType, "Direct self-reference leading to cycle");
            throw null;
        }
        if (!serializerProvider.m2240D(SerializationFeature.WRITE_SELF_REFERENCES_AS_NULL)) {
            return false;
        }
        if (this._nullSerializer == null) {
            return true;
        }
        if (!jsonGenerator.mo1650c().m1674b()) {
            jsonGenerator.mo1665x(this._name);
        }
        this._nullSerializer.mo1807f(null, jsonGenerator, serializerProvider);
        return true;
    }

    /* renamed from: e */
    public void mo1979e(JsonSerializer<Object> jsonSerializer) {
        JsonSerializer<Object> jsonSerializer2 = this._nullSerializer;
        if (jsonSerializer2 != null && jsonSerializer2 != jsonSerializer) {
            throw new IllegalStateException(String.format("Cannot override _nullSerializer: had a %s, trying to set to %s", ClassUtil.m2173e(this._nullSerializer), ClassUtil.m2173e(jsonSerializer)));
        }
        this._nullSerializer = jsonSerializer;
    }

    /* renamed from: f */
    public void mo1980f(JsonSerializer<Object> jsonSerializer) {
        JsonSerializer<Object> jsonSerializer2 = this._serializer;
        if (jsonSerializer2 != null && jsonSerializer2 != jsonSerializer) {
            throw new IllegalStateException(String.format("Cannot override _serializer: had a %s, trying to set to %s", ClassUtil.m2173e(this._serializer), ClassUtil.m2173e(jsonSerializer)));
        }
        this._serializer = jsonSerializer;
    }

    /* renamed from: g */
    public BeanPropertyWriter mo1981g(NameTransformer4 nameTransformer4) {
        String strMo2202a = nameTransformer4.mo2202a(this._name._value);
        return strMo2202a.equals(this._name._value) ? this : new BeanPropertyWriter(this, PropertyName.m2227a(strMo2202a));
    }

    @Override // p007b.p195g.p196a.p205c.BeanProperty
    public AnnotatedMember getMember() {
        return this._member;
    }

    @Override // p007b.p195g.p196a.p205c.BeanProperty
    public JavaType getType() {
        return this._declaredType;
    }

    /* renamed from: h */
    public void mo1982h(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Method method = this.f4792l;
        Object objInvoke = method == null ? this.f4793m.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
            JsonSerializer<Object> jsonSerializer = this._nullSerializer;
            if (jsonSerializer != null) {
                jsonSerializer.mo1807f(null, jsonGenerator, serializerProvider);
                return;
            } else {
                jsonGenerator.mo1631A();
                return;
            }
        }
        JsonSerializer<Object> jsonSerializerMo1977c = this._serializer;
        if (jsonSerializerMo1977c == null) {
            Class<?> cls = objInvoke.getClass();
            PropertySerializerMap propertySerializerMap = this.f4794n;
            JsonSerializer<Object> jsonSerializerMo2034c = propertySerializerMap.mo2034c(cls);
            jsonSerializerMo1977c = jsonSerializerMo2034c == null ? mo1977c(propertySerializerMap, cls, serializerProvider) : jsonSerializerMo2034c;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (JsonInclude.a.NON_EMPTY == obj2) {
                if (jsonSerializerMo1977c.mo2021d(serializerProvider, objInvoke)) {
                    JsonSerializer<Object> jsonSerializer2 = this._nullSerializer;
                    if (jsonSerializer2 != null) {
                        jsonSerializer2.mo1807f(null, jsonGenerator, serializerProvider);
                        return;
                    } else {
                        jsonGenerator.mo1631A();
                        return;
                    }
                }
            } else if (obj2.equals(objInvoke)) {
                JsonSerializer<Object> jsonSerializer3 = this._nullSerializer;
                if (jsonSerializer3 != null) {
                    jsonSerializer3.mo1807f(null, jsonGenerator, serializerProvider);
                    return;
                } else {
                    jsonGenerator.mo1631A();
                    return;
                }
            }
        }
        if (objInvoke == obj && m1978d(jsonGenerator, serializerProvider, jsonSerializerMo1977c)) {
            return;
        }
        TypeSerializer typeSerializer = this._typeSerializer;
        if (typeSerializer == null) {
            jsonSerializerMo1977c.mo1807f(objInvoke, jsonGenerator, serializerProvider);
        } else {
            jsonSerializerMo1977c.mo1808g(objInvoke, jsonGenerator, serializerProvider, typeSerializer);
        }
    }

    /* renamed from: i */
    public void mo1983i(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Method method = this.f4792l;
        Object objInvoke = method == null ? this.f4793m.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
            if (this._nullSerializer != null) {
                jsonGenerator.mo1665x(this._name);
                this._nullSerializer.mo1807f(null, jsonGenerator, serializerProvider);
                return;
            }
            return;
        }
        JsonSerializer<Object> jsonSerializerMo1977c = this._serializer;
        if (jsonSerializerMo1977c == null) {
            Class<?> cls = objInvoke.getClass();
            PropertySerializerMap propertySerializerMap = this.f4794n;
            JsonSerializer<Object> jsonSerializerMo2034c = propertySerializerMap.mo2034c(cls);
            jsonSerializerMo1977c = jsonSerializerMo2034c == null ? mo1977c(propertySerializerMap, cls, serializerProvider) : jsonSerializerMo2034c;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (JsonInclude.a.NON_EMPTY == obj2) {
                if (jsonSerializerMo1977c.mo2021d(serializerProvider, objInvoke)) {
                    return;
                }
            } else if (obj2.equals(objInvoke)) {
                return;
            }
        }
        if (objInvoke == obj && m1978d(jsonGenerator, serializerProvider, jsonSerializerMo1977c)) {
            return;
        }
        jsonGenerator.mo1665x(this._name);
        TypeSerializer typeSerializer = this._typeSerializer;
        if (typeSerializer == null) {
            jsonSerializerMo1977c.mo1807f(objInvoke, jsonGenerator, serializerProvider);
        } else {
            jsonSerializerMo1977c.mo1808g(objInvoke, jsonGenerator, serializerProvider, typeSerializer);
        }
    }

    public Object readResolve() {
        AnnotatedMember annotatedMember = this._member;
        if (annotatedMember instanceof AnnotatedField) {
            this.f4792l = null;
            this.f4793m = (Field) annotatedMember.mo1888i();
        } else if (annotatedMember instanceof AnnotatedMethod) {
            this.f4792l = (Method) annotatedMember.mo1888i();
            this.f4793m = null;
        }
        if (this._serializer == null) {
            this.f4794n = PropertySerializerMap.b.f4828b;
        }
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("property '");
        sb.append(this._name._value);
        sb.append("' (");
        if (this.f4792l != null) {
            sb.append("via method ");
            sb.append(this.f4792l.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this.f4792l.getName());
        } else if (this.f4793m != null) {
            sb.append("field \"");
            sb.append(this.f4793m.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this.f4793m.getName());
        } else {
            sb.append("virtual");
        }
        if (this._serializer == null) {
            sb.append(", no static serializer");
        } else {
            StringBuilder sbM833U = outline.m833U(", static serializer of type ");
            sbM833U.append(this._serializer.getClass().getName());
            sb.append(sbM833U.toString());
        }
        sb.append(')');
        return sb.toString();
    }

    public BeanPropertyWriter() {
        super(PropertyMetadata.f5027l);
        this._member = null;
        this.f4791k = null;
        this._name = null;
        this._wrapperName = null;
        this._includeInViews = null;
        this._declaredType = null;
        this._serializer = null;
        this.f4794n = null;
        this._typeSerializer = null;
        this._cfgSerializationType = null;
        this.f4792l = null;
        this.f4793m = null;
        this._suppressNulls = false;
        this._suppressableValue = null;
        this._nullSerializer = null;
    }

    public BeanPropertyWriter(BeanPropertyWriter beanPropertyWriter, PropertyName propertyName) {
        super(beanPropertyWriter);
        this._name = new SerializedString(propertyName._simpleName);
        this._wrapperName = beanPropertyWriter._wrapperName;
        this.f4791k = beanPropertyWriter.f4791k;
        this._declaredType = beanPropertyWriter._declaredType;
        this._member = beanPropertyWriter._member;
        this.f4792l = beanPropertyWriter.f4792l;
        this.f4793m = beanPropertyWriter.f4793m;
        this._serializer = beanPropertyWriter._serializer;
        this._nullSerializer = beanPropertyWriter._nullSerializer;
        if (beanPropertyWriter.f4795o != null) {
            this.f4795o = new HashMap<>(beanPropertyWriter.f4795o);
        }
        this._cfgSerializationType = beanPropertyWriter._cfgSerializationType;
        this.f4794n = beanPropertyWriter.f4794n;
        this._suppressNulls = beanPropertyWriter._suppressNulls;
        this._suppressableValue = beanPropertyWriter._suppressableValue;
        this._includeInViews = beanPropertyWriter._includeInViews;
        this._typeSerializer = beanPropertyWriter._typeSerializer;
        this._nonTrivialBaseType = beanPropertyWriter._nonTrivialBaseType;
    }

    public BeanPropertyWriter(BeanPropertyWriter beanPropertyWriter, SerializedString serializedString) {
        super(beanPropertyWriter);
        this._name = serializedString;
        this._wrapperName = beanPropertyWriter._wrapperName;
        this._member = beanPropertyWriter._member;
        this.f4791k = beanPropertyWriter.f4791k;
        this._declaredType = beanPropertyWriter._declaredType;
        this.f4792l = beanPropertyWriter.f4792l;
        this.f4793m = beanPropertyWriter.f4793m;
        this._serializer = beanPropertyWriter._serializer;
        this._nullSerializer = beanPropertyWriter._nullSerializer;
        if (beanPropertyWriter.f4795o != null) {
            this.f4795o = new HashMap<>(beanPropertyWriter.f4795o);
        }
        this._cfgSerializationType = beanPropertyWriter._cfgSerializationType;
        this.f4794n = beanPropertyWriter.f4794n;
        this._suppressNulls = beanPropertyWriter._suppressNulls;
        this._suppressableValue = beanPropertyWriter._suppressableValue;
        this._includeInViews = beanPropertyWriter._includeInViews;
        this._typeSerializer = beanPropertyWriter._typeSerializer;
        this._nonTrivialBaseType = beanPropertyWriter._nonTrivialBaseType;
    }
}
