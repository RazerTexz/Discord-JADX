package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContextualSerializer;
import p007b.p195g.p196a.p205c.p215g0.ResolvableSerializer;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;
import p007b.p195g.p196a.p205c.p219i0.Converter;

/* compiled from: StdDelegatingSerializer.java */
/* renamed from: b.g.a.c.g0.u.j0, reason: use source file name */
/* loaded from: classes3.dex */
public class StdDelegatingSerializer extends StdSerializer<Object> implements ContextualSerializer, ResolvableSerializer {
    public final Converter<Object, ?> _converter;
    public final JsonSerializer<Object> _delegateSerializer;
    public final JavaType _delegateType;

    public StdDelegatingSerializer(Converter<Object, ?> converter, JavaType javaType, JsonSerializer<?> jsonSerializer) {
        super(javaType);
        this._converter = converter;
        this._delegateType = javaType;
        this._delegateSerializer = jsonSerializer;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContextualSerializer
    /* renamed from: a */
    public JsonSerializer<?> mo1997a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<?> jsonSerializerM2261z = this._delegateSerializer;
        JavaType javaTypeM2197a = this._delegateType;
        if (jsonSerializerM2261z == null) {
            if (javaTypeM2197a == null) {
                javaTypeM2197a = this._converter.m2197a(serializerProvider.mo1940d());
            }
            if (!javaTypeM2197a.m2221y()) {
                jsonSerializerM2261z = serializerProvider.m2254s(javaTypeM2197a);
            }
        }
        if (jsonSerializerM2261z instanceof ContextualSerializer) {
            jsonSerializerM2261z = serializerProvider.m2261z(jsonSerializerM2261z, beanProperty);
        }
        if (jsonSerializerM2261z == this._delegateSerializer && javaTypeM2197a == this._delegateType) {
            return this;
        }
        Converter<Object, ?> converter = this._converter;
        ClassUtil.m2194z(StdDelegatingSerializer.class, this, "withDelegate");
        return new StdDelegatingSerializer(converter, javaTypeM2197a, jsonSerializerM2261z);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ResolvableSerializer
    /* renamed from: b */
    public void mo2007b(SerializerProvider serializerProvider) throws JsonMappingException {
        Object obj = this._delegateSerializer;
        if (obj == null || !(obj instanceof ResolvableSerializer)) {
            return;
        }
        ((ResolvableSerializer) obj).mo2007b(serializerProvider);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
        Object objConvert = this._converter.convert(obj);
        if (objConvert == null) {
            return true;
        }
        JsonSerializer<Object> jsonSerializer = this._delegateSerializer;
        return jsonSerializer == null ? obj == null : jsonSerializer.mo2021d(serializerProvider, objConvert);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Object objConvert = this._converter.convert(obj);
        if (objConvert == null) {
            serializerProvider.m2248l(jsonGenerator);
            return;
        }
        JsonSerializer<Object> jsonSerializerM2065p = this._delegateSerializer;
        if (jsonSerializerM2065p == null) {
            jsonSerializerM2065p = m2065p(objConvert, serializerProvider);
        }
        jsonSerializerM2065p.mo1807f(objConvert, jsonGenerator, serializerProvider);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: g */
    public void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        Object objConvert = this._converter.convert(obj);
        JsonSerializer<Object> jsonSerializerM2065p = this._delegateSerializer;
        if (jsonSerializerM2065p == null) {
            jsonSerializerM2065p = m2065p(obj, serializerProvider);
        }
        jsonSerializerM2065p.mo1808g(objConvert, jsonGenerator, serializerProvider, typeSerializer);
    }

    /* renamed from: p */
    public JsonSerializer<Object> m2065p(Object obj, SerializerProvider serializerProvider) throws JsonMappingException {
        Class<?> cls = obj.getClass();
        JsonSerializer<Object> jsonSerializerM2036b = serializerProvider._knownSerializers.m2036b(cls);
        if (jsonSerializerM2036b != null) {
            return jsonSerializerM2036b;
        }
        JsonSerializer<Object> jsonSerializerM2009b = serializerProvider._serializerCache.m2009b(cls);
        if (jsonSerializerM2009b != null) {
            return jsonSerializerM2009b;
        }
        JsonSerializer<Object> jsonSerializerM2008a = serializerProvider._serializerCache.m2008a(serializerProvider._config._base._typeFactory.m2160b(null, cls, TypeFactory.f4926l));
        if (jsonSerializerM2008a != null) {
            return jsonSerializerM2008a;
        }
        JsonSerializer<Object> jsonSerializerM2245i = serializerProvider.m2245i(cls);
        return jsonSerializerM2245i == null ? serializerProvider.m2259x(cls) : jsonSerializerM2245i;
    }
}
