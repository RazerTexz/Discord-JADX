package p007b.p195g.p196a.p205c.p215g0;

import java.io.Serializable;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedClass;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;
import p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.PropertySerializerMap;
import p007b.p195g.p196a.p205c.p219i0.Annotations;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;

/* JADX INFO: renamed from: b.g.a.c.g0.s, reason: use source file name */
/* JADX INFO: compiled from: VirtualBeanPropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class VirtualBeanPropertyWriter extends BeanPropertyWriter implements Serializable {
    private static final long serialVersionUID = 1;

    public VirtualBeanPropertyWriter() {
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter
    /* JADX INFO: renamed from: h */
    public void mo1982h(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Object objMo2017j = mo2017j(obj, jsonGenerator, serializerProvider);
        if (objMo2017j == null) {
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
            Class<?> cls = objMo2017j.getClass();
            PropertySerializerMap propertySerializerMap = this.f4794n;
            JsonSerializer<Object> jsonSerializerMo2034c = propertySerializerMap.mo2034c(cls);
            jsonSerializerMo1977c = jsonSerializerMo2034c == null ? mo1977c(propertySerializerMap, cls, serializerProvider) : jsonSerializerMo2034c;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (JsonInclude.a.NON_EMPTY == obj2) {
                if (jsonSerializerMo1977c.mo2021d(serializerProvider, objMo2017j)) {
                    JsonSerializer<Object> jsonSerializer2 = this._nullSerializer;
                    if (jsonSerializer2 != null) {
                        jsonSerializer2.mo1807f(null, jsonGenerator, serializerProvider);
                        return;
                    } else {
                        jsonGenerator.mo1631A();
                        return;
                    }
                }
            } else if (obj2.equals(objMo2017j)) {
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
        if (objMo2017j == obj && m1978d(jsonGenerator, serializerProvider, jsonSerializerMo1977c)) {
            return;
        }
        TypeSerializer typeSerializer = this._typeSerializer;
        if (typeSerializer == null) {
            jsonSerializerMo1977c.mo1807f(objMo2017j, jsonGenerator, serializerProvider);
        } else {
            jsonSerializerMo1977c.mo1808g(objMo2017j, jsonGenerator, serializerProvider, typeSerializer);
        }
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter
    /* JADX INFO: renamed from: i */
    public void mo1983i(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Object objMo2017j = mo2017j(obj, jsonGenerator, serializerProvider);
        if (objMo2017j == null) {
            if (this._nullSerializer != null) {
                jsonGenerator.mo1665x(this._name);
                this._nullSerializer.mo1807f(null, jsonGenerator, serializerProvider);
                return;
            }
            return;
        }
        JsonSerializer<Object> jsonSerializerMo1977c = this._serializer;
        if (jsonSerializerMo1977c == null) {
            Class<?> cls = objMo2017j.getClass();
            PropertySerializerMap propertySerializerMap = this.f4794n;
            JsonSerializer<Object> jsonSerializerMo2034c = propertySerializerMap.mo2034c(cls);
            jsonSerializerMo1977c = jsonSerializerMo2034c == null ? mo1977c(propertySerializerMap, cls, serializerProvider) : jsonSerializerMo2034c;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (JsonInclude.a.NON_EMPTY == obj2) {
                if (jsonSerializerMo1977c.mo2021d(serializerProvider, objMo2017j)) {
                    return;
                }
            } else if (obj2.equals(objMo2017j)) {
                return;
            }
        }
        if (objMo2017j == obj && m1978d(jsonGenerator, serializerProvider, jsonSerializerMo1977c)) {
            return;
        }
        jsonGenerator.mo1665x(this._name);
        TypeSerializer typeSerializer = this._typeSerializer;
        if (typeSerializer == null) {
            jsonSerializerMo1977c.mo1807f(objMo2017j, jsonGenerator, serializerProvider);
        } else {
            jsonSerializerMo1977c.mo1808g(objMo2017j, jsonGenerator, serializerProvider, typeSerializer);
        }
    }

    /* JADX INFO: renamed from: j */
    public abstract Object mo2017j(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception;

    /* JADX INFO: renamed from: k */
    public abstract VirtualBeanPropertyWriter mo2018k(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, BeanPropertyDefinition beanPropertyDefinition, JavaType javaType);

    /* JADX WARN: Illegal instructions before constructor call */
    public VirtualBeanPropertyWriter(BeanPropertyDefinition beanPropertyDefinition, Annotations annotations, JavaType javaType, JsonSerializer<?> jsonSerializer, TypeSerializer typeSerializer, JavaType javaType2, JsonInclude.b bVar, Class<?>[] clsArr) {
        boolean z2;
        Object obj;
        JsonInclude.a aVar = JsonInclude.a.USE_DEFAULTS;
        JsonInclude.a aVar2 = JsonInclude.a.ALWAYS;
        AnnotatedMember annotatedMemberMo1859q = beanPropertyDefinition.mo1859q();
        boolean z3 = false;
        if (bVar == null) {
            z2 = false;
        } else {
            JsonInclude.a aVar3 = bVar._valueInclusion;
            if (aVar3 != aVar2 && aVar3 != aVar) {
                z3 = true;
            }
            z2 = z3;
        }
        if (bVar == null) {
            obj = Boolean.FALSE;
        } else {
            JsonInclude.a aVar4 = bVar._valueInclusion;
            obj = (aVar4 == aVar2 || aVar4 == JsonInclude.a.NON_NULL || aVar4 == aVar) ? null : JsonInclude.a.NON_EMPTY;
        }
        super(beanPropertyDefinition, annotatedMemberMo1859q, annotations, javaType, null, null, null, z2, obj, null);
    }
}
