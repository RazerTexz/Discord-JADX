package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p215g0.ContextualSerializer;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* JADX INFO: renamed from: b.g.a.c.g0.u.v, reason: use source file name */
/* JADX INFO: compiled from: NumberSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class NumberSerializer extends StdScalarSerializer<Number> implements ContextualSerializer {

    /* JADX INFO: renamed from: k */
    public static final NumberSerializer f4868k = new NumberSerializer(Number.class);
    public final boolean _isInt;

    /* JADX INFO: renamed from: b.g.a.c.g0.u.v$a */
    /* JADX INFO: compiled from: NumberSerializer.java */
    public static final class a extends ToStringSerializerBase {

        /* JADX INFO: renamed from: k */
        public static final a f4869k = new a();

        public a() {
            super(BigDecimal.class);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ToStringSerializerBase, p007b.p195g.p196a.p205c.JsonSerializer
        /* JADX INFO: renamed from: d */
        public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
            return false;
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ToStringSerializerBase, p007b.p195g.p196a.p205c.JsonSerializer
        /* JADX INFO: renamed from: f */
        public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            String string;
            if (jsonGenerator.mo1652d(JsonGenerator.a.WRITE_BIGDECIMAL_AS_PLAIN)) {
                BigDecimal bigDecimal = (BigDecimal) obj;
                int iScale = bigDecimal.scale();
                if (!(iScale >= -9999 && iScale <= 9999)) {
                    serializerProvider.m2243G(String.format("Attempt to write plain `java.math.BigDecimal` (see JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN) with illegal scale (%d): needs to be between [-%d, %d]", Integer.valueOf(bigDecimal.scale()), 9999, 9999), new Object[0]);
                    throw null;
                }
                string = bigDecimal.toPlainString();
            } else {
                string = obj.toString();
            }
            jsonGenerator.mo1658j0(string);
        }

        @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ToStringSerializerBase
        /* JADX INFO: renamed from: p */
        public String mo2087p(Object obj) {
            throw new IllegalStateException();
        }
    }

    public NumberSerializer(Class<? extends Number> cls) {
        super(cls, false);
        this._isInt = cls == BigInteger.class;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContextualSerializer
    /* JADX INFO: renamed from: a */
    public JsonSerializer<?> mo1997a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.d dVarM2074l = m2074l(serializerProvider, beanProperty, this._handledType);
        return (dVarM2074l == null || dVarM2074l.m1601e().ordinal() != 8) ? this : this._handledType == BigDecimal.class ? a.f4869k : ToStringSerializer.f4866k;
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Number number = (Number) obj;
        if (number instanceof BigDecimal) {
            jsonGenerator.mo1637L((BigDecimal) number);
            return;
        }
        if (number instanceof BigInteger) {
            jsonGenerator.mo1638N((BigInteger) number);
            return;
        }
        if (number instanceof Long) {
            jsonGenerator.mo1635I(number.longValue());
            return;
        }
        if (number instanceof Double) {
            jsonGenerator.mo1632C(number.doubleValue());
            return;
        }
        if (number instanceof Float) {
            jsonGenerator.mo1633D(number.floatValue());
        } else if ((number instanceof Integer) || (number instanceof Byte) || (number instanceof Short)) {
            jsonGenerator.mo1634H(number.intValue());
        } else {
            jsonGenerator.mo1636J(number.toString());
        }
    }
}
