package p007b.p195g.p196a.p205c.p215g0.p216t;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.Serializable;
import java.lang.reflect.Method;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.p200p.SerializedString;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter;
import p007b.p195g.p196a.p205c.p219i0.NameTransformer4;

/* compiled from: UnwrappingBeanPropertyWriter.java */
/* renamed from: b.g.a.c.g0.t.s, reason: use source file name */
/* loaded from: classes3.dex */
public class UnwrappingBeanPropertyWriter extends BeanPropertyWriter implements Serializable {
    private static final long serialVersionUID = 1;
    public final NameTransformer4 _nameTransformer;

    public UnwrappingBeanPropertyWriter(UnwrappingBeanPropertyWriter unwrappingBeanPropertyWriter, NameTransformer4 nameTransformer4, SerializedString serializedString) {
        super(unwrappingBeanPropertyWriter, serializedString);
        this._nameTransformer = nameTransformer4;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter
    /* renamed from: c */
    public JsonSerializer<Object> mo1977c(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) throws JsonMappingException {
        JavaType javaType = this._nonTrivialBaseType;
        JsonSerializer<Object> jsonSerializerM2255t = javaType != null ? serializerProvider.m2255t(serializerProvider.m2247k(javaType, cls), this) : serializerProvider.m2256u(cls, this);
        NameTransformer4 aVar = this._nameTransformer;
        if (jsonSerializerM2255t.mo2058e() && (jsonSerializerM2255t instanceof UnwrappingBeanSerializer)) {
            aVar = new NameTransformer4.a(aVar, ((UnwrappingBeanSerializer) jsonSerializerM2255t)._nameTransformer);
        }
        JsonSerializer<Object> jsonSerializerMo1984h = jsonSerializerM2255t.mo1984h(aVar);
        this.f4794n = this.f4794n.mo2033b(cls, jsonSerializerMo1984h);
        return jsonSerializerMo1984h;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter
    /* renamed from: f */
    public void mo1980f(JsonSerializer<Object> jsonSerializer) {
        if (jsonSerializer != null) {
            NameTransformer4 aVar = this._nameTransformer;
            if (jsonSerializer.mo2058e() && (jsonSerializer instanceof UnwrappingBeanSerializer)) {
                aVar = new NameTransformer4.a(aVar, ((UnwrappingBeanSerializer) jsonSerializer)._nameTransformer);
            }
            jsonSerializer = jsonSerializer.mo1984h(aVar);
        }
        super.mo1980f(jsonSerializer);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter
    /* renamed from: g */
    public BeanPropertyWriter mo1981g(NameTransformer4 nameTransformer4) {
        return new UnwrappingBeanPropertyWriter(this, new NameTransformer4.a(nameTransformer4, this._nameTransformer), new SerializedString(nameTransformer4.mo2202a(this._name._value)));
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter
    /* renamed from: i */
    public void mo1983i(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Method method = this.f4792l;
        Object objInvoke = method == null ? this.f4793m.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
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
        if (!jsonSerializerMo1977c.mo2058e()) {
            jsonGenerator.mo1665x(this._name);
        }
        TypeSerializer typeSerializer = this._typeSerializer;
        if (typeSerializer == null) {
            jsonSerializerMo1977c.mo1807f(objInvoke, jsonGenerator, serializerProvider);
        } else {
            jsonSerializerMo1977c.mo1808g(objInvoke, jsonGenerator, serializerProvider, typeSerializer);
        }
    }

    public UnwrappingBeanPropertyWriter(BeanPropertyWriter beanPropertyWriter, NameTransformer4 nameTransformer4) {
        super(beanPropertyWriter, beanPropertyWriter._name);
        this._nameTransformer = nameTransformer4;
    }
}
