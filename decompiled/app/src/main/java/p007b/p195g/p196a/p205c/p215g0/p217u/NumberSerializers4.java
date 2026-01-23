package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.math.BigDecimal;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p198b.JsonParser;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p215g0.ContextualSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.NumberSerializer;

/* JADX INFO: renamed from: b.g.a.c.g0.u.w, reason: use source file name */
/* JADX INFO: compiled from: NumberSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class NumberSerializers4<T> extends StdScalarSerializer<T> implements ContextualSerializer {
    public final boolean _isInt;
    public final JsonParser.b _numberType;
    public final String _schemaType;

    public NumberSerializers4(Class<?> cls, JsonParser.b bVar, String str) {
        super(cls, false);
        this._numberType = bVar;
        this._schemaType = str;
        this._isInt = bVar == JsonParser.b.INT || bVar == JsonParser.b.LONG || bVar == JsonParser.b.BIG_INTEGER;
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.ContextualSerializer
    /* JADX INFO: renamed from: a */
    public JsonSerializer<?> mo1997a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.d dVarM2074l = m2074l(serializerProvider, beanProperty, this._handledType);
        if (dVarM2074l == null || dVarM2074l.m1601e().ordinal() != 8) {
            return this;
        }
        if (this._handledType != BigDecimal.class) {
            return ToStringSerializer.f4866k;
        }
        NumberSerializer numberSerializer = NumberSerializer.f4868k;
        return NumberSerializer.a.f4869k;
    }
}
