package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializationFeature;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p215g0.ContextualSerializer;
import p007b.p195g.p196a.p205c.p219i0.EnumValues;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* compiled from: EnumSerializer.java */
@JacksonStdImpl
/* renamed from: b.g.a.c.g0.u.m, reason: use source file name */
/* loaded from: classes3.dex */
public class EnumSerializer2 extends StdScalarSerializer<Enum<?>> implements ContextualSerializer {

    /* renamed from: k */
    public static final /* synthetic */ int f4857k = 0;
    private static final long serialVersionUID = 1;
    public final Boolean _serializeAsIndex;
    public final EnumValues _values;

    public EnumSerializer2(EnumValues enumValues, Boolean bool) {
        super(enumValues.m2199b(), false);
        this._values = enumValues;
        this._serializeAsIndex = bool;
    }

    /* renamed from: p */
    public static Boolean m2068p(Class<?> cls, JsonFormat.d dVar, boolean z2, Boolean bool) {
        JsonFormat.c cVarM1601e = dVar == null ? null : dVar.m1601e();
        if (cVarM1601e == null || cVarM1601e == JsonFormat.c.ANY || cVarM1601e == JsonFormat.c.SCALAR) {
            return bool;
        }
        if (cVarM1601e == JsonFormat.c.STRING || cVarM1601e == JsonFormat.c.NATURAL) {
            return Boolean.FALSE;
        }
        if (cVarM1601e.m1596f() || cVarM1601e == JsonFormat.c.ARRAY) {
            return Boolean.TRUE;
        }
        Object[] objArr = new Object[3];
        objArr[0] = cVarM1601e;
        objArr[1] = cls.getName();
        objArr[2] = z2 ? "class" : "property";
        throw new IllegalArgumentException(String.format("Unsupported serialization shape (%s) for Enum %s, not supported as %s annotation", objArr));
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContextualSerializer
    /* renamed from: a */
    public JsonSerializer<?> mo1997a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.d dVarM2074l = m2074l(serializerProvider, beanProperty, this._handledType);
        if (dVarM2074l != null) {
            Boolean boolM2068p = m2068p(this._handledType, dVarM2074l, false, this._serializeAsIndex);
            if (!Objects.equals(boolM2068p, this._serializeAsIndex)) {
                return new EnumSerializer2(this._values, boolM2068p);
            }
        }
        return this;
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Enum<?> r2 = (Enum) obj;
        Boolean bool = this._serializeAsIndex;
        if (bool != null ? bool.booleanValue() : serializerProvider.m2240D(SerializationFeature.WRITE_ENUMS_USING_INDEX)) {
            jsonGenerator.mo1634H(r2.ordinal());
        } else if (serializerProvider.m2240D(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)) {
            jsonGenerator.mo1658j0(r2.toString());
        } else {
            jsonGenerator.mo1657g0(this._values.m2200c(r2));
        }
    }
}
