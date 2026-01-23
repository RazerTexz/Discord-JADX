package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.MapperFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContextualSerializer;
import p007b.p195g.p196a.p205c.p215g0.p216t.PropertySerializerMap;
import p007b.p195g.p196a.p205c.p218h0.ReferenceType;
import p007b.p195g.p196a.p205c.p219i0.NameTransformer4;
import p007b.p195g.p196a.p205c.p220y.JsonSerialize;

/* JADX INFO: renamed from: b.g.a.c.g0.u.f0, reason: use source file name */
/* JADX INFO: compiled from: ReferenceTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ReferenceTypeSerializer<T> extends StdSerializer<T> implements ContextualSerializer {
    private static final long serialVersionUID = 1;
    public final BeanProperty _property;
    public final JavaType _referredType;
    public final boolean _suppressNulls;
    public final Object _suppressableValue;
    public final NameTransformer4 _unwrapper;
    public final JsonSerializer<Object> _valueSerializer;
    public final TypeSerializer _valueTypeSerializer;

    /* JADX INFO: renamed from: k */
    public transient PropertySerializerMap f4852k;

    public ReferenceTypeSerializer(ReferenceType referenceType, TypeSerializer typeSerializer, JsonSerializer jsonSerializer) {
        super(referenceType);
        this._referredType = referenceType._referencedType;
        this._property = null;
        this._valueTypeSerializer = typeSerializer;
        this._valueSerializer = jsonSerializer;
        this._unwrapper = null;
        this._suppressableValue = null;
        this._suppressNulls = false;
        this.f4852k = PropertySerializerMap.b.f4828b;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    @Override // p007b.p195g.p196a.p205c.p215g0.ContextualSerializer
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonSerializer<?> mo1997a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<?> jsonSerializerMo2000H;
        JsonInclude.b bVarMo1929b;
        JsonInclude.a aVar;
        boolean zM2239C;
        Object objMo1775c;
        Object objM572t0 = JsonInclude.a.NON_EMPTY;
        TypeSerializer typeSerializerMo1955a = this._valueTypeSerializer;
        if (typeSerializerMo1955a != null) {
            typeSerializerMo1955a = typeSerializerMo1955a.mo1955a(beanProperty);
        }
        if (beanProperty != null) {
            AnnotatedMember member = beanProperty.getMember();
            jsonSerializerMo2000H = (member == null || (objMo1775c = serializerProvider.m2257v().mo1775c(member)) == null) ? null : serializerProvider.mo2000H(member, objMo1775c);
        }
        boolean zMo1999B = false;
        if (jsonSerializerMo2000H == null) {
            jsonSerializerMo2000H = this._valueSerializer;
            if (jsonSerializerMo2000H == null) {
                JavaType javaType = this._referredType;
                if (!javaType.m2221y()) {
                    if (javaType.m2220x() || javaType._asStatic) {
                        zM2239C = true;
                        if (zM2239C) {
                        }
                    } else {
                        AnnotationIntrospector annotationIntrospectorM2257v = serializerProvider.m2257v();
                        if (annotationIntrospectorM2257v != null && beanProperty != null && beanProperty.getMember() != null) {
                            JsonSerialize.b bVarMo1755K = annotationIntrospectorM2257v.mo1755K(beanProperty.getMember());
                            if (bVarMo1755K != JsonSerialize.b.STATIC) {
                                if (bVarMo1755K == JsonSerialize.b.DYNAMIC) {
                                    zM2239C = false;
                                }
                                if (zM2239C) {
                                    jsonSerializerMo2000H = serializerProvider.m2252q(this._referredType, beanProperty);
                                }
                            }
                            zM2239C = true;
                            if (zM2239C) {
                            }
                        }
                        zM2239C = serializerProvider.m2239C(MapperFeature.USE_STATIC_TYPING);
                        if (zM2239C) {
                        }
                    }
                }
            } else {
                jsonSerializerMo2000H = serializerProvider.m2260y(jsonSerializerMo2000H, beanProperty);
            }
        }
        ReferenceTypeSerializer<T> referenceTypeSerializerMo2050u = (this._property == beanProperty && this._valueTypeSerializer == typeSerializerMo1955a && this._valueSerializer == jsonSerializerMo2000H) ? this : mo2050u(beanProperty, typeSerializerMo1955a, jsonSerializerMo2000H, this._unwrapper);
        if (beanProperty == null || (bVarMo1929b = beanProperty.mo1929b(serializerProvider._config, this._handledType)) == null || (aVar = bVarMo1929b._contentInclusion) == JsonInclude.a.USE_DEFAULTS) {
            return referenceTypeSerializerMo2050u;
        }
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 1) {
            objM572t0 = null;
            zMo1999B = true;
        } else {
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    if (iOrdinal == 4) {
                        objM572t0 = AnimatableValueParser.m572t0(this._referredType);
                        if (objM572t0 != null && objM572t0.getClass().isArray()) {
                            objM572t0 = AnimatableValueParser.m560q0(objM572t0);
                        }
                    } else if (iOrdinal != 5) {
                        objM572t0 = null;
                    } else {
                        objM572t0 = serializerProvider.mo1998A(null, bVarMo1929b._contentFilter);
                        if (objM572t0 != null) {
                            zMo1999B = serializerProvider.mo1999B(objM572t0);
                        }
                    }
                }
            } else if (!this._referredType.mo1728b()) {
            }
            zMo1999B = true;
        }
        return (this._suppressableValue == objM572t0 && this._suppressNulls == zMo1999B) ? referenceTypeSerializerMo2050u : referenceTypeSerializerMo2050u.mo2049t(objM572t0, zMo1999B);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, T t) {
        if (!mo2048s(t)) {
            return true;
        }
        Object objMo2046q = mo2046q(t);
        if (objMo2046q == null) {
            return this._suppressNulls;
        }
        if (this._suppressableValue == null) {
            return false;
        }
        JsonSerializer<Object> jsonSerializerM2059p = this._valueSerializer;
        if (jsonSerializerM2059p == null) {
            try {
                jsonSerializerM2059p = m2059p(serializerProvider, objMo2046q.getClass());
            } catch (JsonMappingException e) {
                throw new RuntimeJsonMappingException(e);
            }
        }
        Object obj = this._suppressableValue;
        return obj == JsonInclude.a.NON_EMPTY ? jsonSerializerM2059p.mo2021d(serializerProvider, objMo2046q) : obj.equals(objMo2046q);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: e */
    public boolean mo2058e() {
        return this._unwrapper != null;
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Object objMo2047r = mo2047r(t);
        if (objMo2047r == null) {
            if (this._unwrapper == null) {
                serializerProvider.m2248l(jsonGenerator);
                return;
            }
            return;
        }
        JsonSerializer<Object> jsonSerializerM2059p = this._valueSerializer;
        if (jsonSerializerM2059p == null) {
            jsonSerializerM2059p = m2059p(serializerProvider, objMo2047r.getClass());
        }
        TypeSerializer typeSerializer = this._valueTypeSerializer;
        if (typeSerializer != null) {
            jsonSerializerM2059p.mo1808g(objMo2047r, jsonGenerator, serializerProvider, typeSerializer);
        } else {
            jsonSerializerM2059p.mo1807f(objMo2047r, jsonGenerator, serializerProvider);
        }
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: g */
    public void mo1808g(T t, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        Object objMo2047r = mo2047r(t);
        if (objMo2047r == null) {
            if (this._unwrapper == null) {
                serializerProvider.m2248l(jsonGenerator);
            }
        } else {
            JsonSerializer<Object> jsonSerializerM2059p = this._valueSerializer;
            if (jsonSerializerM2059p == null) {
                jsonSerializerM2059p = m2059p(serializerProvider, objMo2047r.getClass());
            }
            jsonSerializerM2059p.mo1808g(objMo2047r, jsonGenerator, serializerProvider, typeSerializer);
        }
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: h */
    public JsonSerializer<T> mo1984h(NameTransformer4 nameTransformer4) {
        JsonSerializer<?> jsonSerializerMo1984h = this._valueSerializer;
        if (jsonSerializerMo1984h != null && (jsonSerializerMo1984h = jsonSerializerMo1984h.mo1984h(nameTransformer4)) == this._valueSerializer) {
            return this;
        }
        NameTransformer4 nameTransformer42 = this._unwrapper;
        if (nameTransformer42 != null) {
            nameTransformer4 = new NameTransformer4.a(nameTransformer4, nameTransformer42);
        }
        return (this._valueSerializer == jsonSerializerMo1984h && nameTransformer42 == nameTransformer4) ? this : mo2050u(this._property, this._valueTypeSerializer, jsonSerializerMo1984h, nameTransformer4);
    }

    /* JADX INFO: renamed from: p */
    public final JsonSerializer<Object> m2059p(SerializerProvider serializerProvider, Class<?> cls) throws JsonMappingException {
        JsonSerializer<Object> jsonSerializerMo2034c = this.f4852k.mo2034c(cls);
        if (jsonSerializerMo2034c != null) {
            return jsonSerializerMo2034c;
        }
        JsonSerializer<Object> jsonSerializerM2252q = this._referredType.mo2102r() ? serializerProvider.m2252q(serializerProvider.m2247k(this._referredType, cls), this._property) : serializerProvider.m2253r(cls, this._property);
        NameTransformer4 nameTransformer4 = this._unwrapper;
        if (nameTransformer4 != null) {
            jsonSerializerM2252q = jsonSerializerM2252q.mo1984h(nameTransformer4);
        }
        JsonSerializer<Object> jsonSerializer = jsonSerializerM2252q;
        this.f4852k = this.f4852k.mo2033b(cls, jsonSerializer);
        return jsonSerializer;
    }

    /* JADX INFO: renamed from: q */
    public abstract Object mo2046q(T t);

    /* JADX INFO: renamed from: r */
    public abstract Object mo2047r(T t);

    /* JADX INFO: renamed from: s */
    public abstract boolean mo2048s(T t);

    /* JADX INFO: renamed from: t */
    public abstract ReferenceTypeSerializer<T> mo2049t(Object obj, boolean z2);

    /* JADX INFO: renamed from: u */
    public abstract ReferenceTypeSerializer<T> mo2050u(BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, NameTransformer4 nameTransformer4);

    public ReferenceTypeSerializer(ReferenceTypeSerializer<?> referenceTypeSerializer, BeanProperty beanProperty, TypeSerializer typeSerializer, JsonSerializer<?> jsonSerializer, NameTransformer4 nameTransformer4, Object obj, boolean z2) {
        super(referenceTypeSerializer);
        this._referredType = referenceTypeSerializer._referredType;
        this.f4852k = PropertySerializerMap.b.f4828b;
        this._property = beanProperty;
        this._valueTypeSerializer = typeSerializer;
        this._valueSerializer = jsonSerializer;
        this._unwrapper = nameTransformer4;
        this._suppressableValue = obj;
        this._suppressNulls = z2;
    }
}
