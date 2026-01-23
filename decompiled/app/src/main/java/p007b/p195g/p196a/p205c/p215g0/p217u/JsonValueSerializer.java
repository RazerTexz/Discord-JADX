package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import java.io.IOException;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p197a.JsonTypeInfo;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.MapperFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContextualSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.PropertySerializerMap;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* JADX INFO: renamed from: b.g.a.c.g0.u.s, reason: use source file name */
/* JADX INFO: compiled from: JsonValueSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class JsonValueSerializer extends StdSerializer<Object> implements ContextualSerializer {
    public final AnnotatedMember _accessor;
    public final boolean _forceTypeInformation;
    public final BeanProperty _property;
    public final JsonSerializer<Object> _valueSerializer;
    public final JavaType _valueType;
    public final TypeSerializer _valueTypeSerializer;

    /* JADX INFO: renamed from: k */
    public transient PropertySerializerMap f4861k;

    /* JADX INFO: renamed from: b.g.a.c.g0.u.s$a */
    /* JADX INFO: compiled from: JsonValueSerializer.java */
    public static class a extends TypeSerializer {

        /* JADX INFO: renamed from: a */
        public final TypeSerializer f4862a;

        /* JADX INFO: renamed from: b */
        public final Object f4863b;

        public a(TypeSerializer typeSerializer, Object obj) {
            this.f4862a = typeSerializer;
            this.f4863b = obj;
        }

        @Override // p007b.p195g.p196a.p205c.p212e0.TypeSerializer
        /* JADX INFO: renamed from: a */
        public TypeSerializer mo1955a(BeanProperty beanProperty) {
            throw new UnsupportedOperationException();
        }

        @Override // p007b.p195g.p196a.p205c.p212e0.TypeSerializer
        /* JADX INFO: renamed from: b */
        public String mo1956b() {
            return this.f4862a.mo1956b();
        }

        @Override // p007b.p195g.p196a.p205c.p212e0.TypeSerializer
        /* JADX INFO: renamed from: c */
        public JsonTypeInfo.a mo1957c() {
            return this.f4862a.mo1957c();
        }

        @Override // p007b.p195g.p196a.p205c.p212e0.TypeSerializer
        /* JADX INFO: renamed from: e */
        public WritableTypeId mo1959e(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) throws IOException {
            writableTypeId.f4584a = this.f4863b;
            return this.f4862a.mo1959e(jsonGenerator, writableTypeId);
        }

        @Override // p007b.p195g.p196a.p205c.p212e0.TypeSerializer
        /* JADX INFO: renamed from: f */
        public WritableTypeId mo1960f(JsonGenerator jsonGenerator, WritableTypeId writableTypeId) throws IOException {
            return this.f4862a.mo1960f(jsonGenerator, writableTypeId);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public JsonValueSerializer(JsonValueSerializer jsonValueSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, boolean z2) {
        Class cls = jsonValueSerializer._handledType;
        super(cls == null ? Object.class : cls);
        this._accessor = jsonValueSerializer._accessor;
        this._valueType = jsonValueSerializer._valueType;
        this._valueTypeSerializer = typeSerializer;
        this._valueSerializer = jsonSerializer;
        this._property = beanProperty;
        this._forceTypeInformation = z2;
        this.f4861k = PropertySerializerMap.b.f4828b;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContextualSerializer
    /* JADX INFO: renamed from: a */
    public JsonSerializer<?> mo1997a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        TypeSerializer typeSerializerMo1955a = this._valueTypeSerializer;
        if (typeSerializerMo1955a != null) {
            typeSerializerMo1955a = typeSerializerMo1955a.mo1955a(beanProperty);
        }
        JsonSerializer<?> jsonSerializer = this._valueSerializer;
        if (jsonSerializer != null) {
            return m2081q(beanProperty, typeSerializerMo1955a, serializerProvider.m2260y(jsonSerializer, beanProperty), this._forceTypeInformation);
        }
        if (!serializerProvider.m2239C(MapperFeature.USE_STATIC_TYPING) && !this._valueType.m2220x()) {
            return beanProperty != this._property ? m2081q(beanProperty, typeSerializerMo1955a, jsonSerializer, this._forceTypeInformation) : this;
        }
        JsonSerializer<Object> jsonSerializerM2252q = serializerProvider.m2252q(this._valueType, beanProperty);
        Class<?> cls = this._valueType._class;
        boolean zM2187s = false;
        if (!cls.isPrimitive() ? cls == String.class || cls == Integer.class || cls == Boolean.class || cls == Double.class : cls == Integer.TYPE || cls == Boolean.TYPE || cls == Double.TYPE) {
            zM2187s = ClassUtil.m2187s(jsonSerializerM2252q);
        }
        return m2081q(beanProperty, typeSerializerMo1955a, jsonSerializerM2252q, zM2187s);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
        Object objMo1889j = this._accessor.mo1889j(obj);
        if (objMo1889j == null) {
            return true;
        }
        JsonSerializer<Object> jsonSerializerM2080p = this._valueSerializer;
        if (jsonSerializerM2080p == null) {
            try {
                jsonSerializerM2080p = m2080p(serializerProvider, objMo1889j.getClass());
            } catch (JsonMappingException e) {
                throw new RuntimeJsonMappingException(e);
            }
        }
        return jsonSerializerM2080p.mo2021d(serializerProvider, objMo1889j);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        try {
            Object objMo1889j = this._accessor.mo1889j(obj);
            if (objMo1889j == null) {
                serializerProvider.m2248l(jsonGenerator);
                return;
            }
            JsonSerializer<Object> jsonSerializerM2080p = this._valueSerializer;
            if (jsonSerializerM2080p == null) {
                jsonSerializerM2080p = m2080p(serializerProvider, objMo1889j.getClass());
            }
            TypeSerializer typeSerializer = this._valueTypeSerializer;
            if (typeSerializer != null) {
                jsonSerializerM2080p.mo1808g(objMo1889j, jsonGenerator, serializerProvider, typeSerializer);
            } else {
                jsonSerializerM2080p.mo1807f(objMo1889j, jsonGenerator, serializerProvider);
            }
        } catch (Exception e) {
            m2077o(serializerProvider, e, obj, this._accessor.mo1819c() + "()");
            throw null;
        }
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        try {
            Object objMo1889j = this._accessor.mo1889j(obj);
            if (objMo1889j == null) {
                serializerProvider.m2248l(jsonGenerator);
                return;
            }
            JsonSerializer<Object> jsonSerializerM2080p = this._valueSerializer;
            if (jsonSerializerM2080p == null) {
                jsonSerializerM2080p = m2080p(serializerProvider, objMo1889j.getClass());
            } else if (this._forceTypeInformation) {
                WritableTypeId writableTypeIdMo1959e = typeSerializer.mo1959e(jsonGenerator, typeSerializer.m1958d(obj, JsonToken2.VALUE_STRING));
                jsonSerializerM2080p.mo1807f(objMo1889j, jsonGenerator, serializerProvider);
                typeSerializer.mo1960f(jsonGenerator, writableTypeIdMo1959e);
                return;
            }
            jsonSerializerM2080p.mo1808g(objMo1889j, jsonGenerator, serializerProvider, new a(typeSerializer, obj));
        } catch (Exception e) {
            m2077o(serializerProvider, e, obj, this._accessor.mo1819c() + "()");
            throw null;
        }
    }

    /* JADX INFO: renamed from: p */
    public JsonSerializer<Object> m2080p(SerializerProvider serializerProvider, Class<?> cls) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerMo2034c = this.f4861k.mo2034c(cls);
        if (jsonSerializerMo2034c != null) {
            return jsonSerializerMo2034c;
        }
        if (!this._valueType.mo2102r()) {
            JsonSerializer<Object> jsonSerializerM2253r = serializerProvider.m2253r(cls, this._property);
            this.f4861k = this.f4861k.mo2033b(cls, jsonSerializerM2253r);
            return jsonSerializerM2253r;
        }
        JavaType javaTypeM2247k = serializerProvider.m2247k(this._valueType, cls);
        JsonSerializer<Object> jsonSerializerM2252q = serializerProvider.m2252q(javaTypeM2247k, this._property);
        PropertySerializerMap propertySerializerMap = this.f4861k;
        Objects.requireNonNull(propertySerializerMap);
        this.f4861k = propertySerializerMap.mo2033b(javaTypeM2247k._class, jsonSerializerM2252q);
        return jsonSerializerM2252q;
    }

    /* JADX INFO: renamed from: q */
    public JsonValueSerializer m2081q(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, boolean z2) {
        return (this._property == beanProperty && this._valueTypeSerializer == typeSerializer && this._valueSerializer == jsonSerializer && z2 == this._forceTypeInformation) ? this : new JsonValueSerializer(this, beanProperty, typeSerializer, jsonSerializer, z2);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("(@JsonValue serializer for method ");
        sbM833U.append(this._accessor.mo1887g());
        sbM833U.append("#");
        sbM833U.append(this._accessor.mo1819c());
        sbM833U.append(")");
        return sbM833U.toString();
    }

    public JsonValueSerializer(AnnotatedMember annotatedMember, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer) {
        super(annotatedMember.mo1821e());
        this._accessor = annotatedMember;
        this._valueType = annotatedMember.mo1821e();
        this._valueTypeSerializer = typeSerializer;
        this._valueSerializer = jsonSerializer;
        this._property = null;
        this._forceTypeInformation = true;
        this.f4861k = PropertySerializerMap.b.f4828b;
    }
}
