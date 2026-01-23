package p007b.p195g.p196a.p205c.p215g0.p217u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.net.InetAddress;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.ContextualSerializer;

/* JADX INFO: renamed from: b.g.a.c.g0.u.p, reason: use source file name */
/* JADX INFO: compiled from: InetAddressSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class InetAddressSerializer extends StdScalarSerializer<InetAddress> implements ContextualSerializer {
    public final boolean _asNumeric;

    public InetAddressSerializer() {
        super(InetAddress.class);
        this._asNumeric = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    @Override // p007b.p195g.p196a.p205c.p215g0.ContextualSerializer
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonSerializer<?> mo1997a(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        boolean z2;
        JsonFormat.d dVarM2074l = m2074l(serializerProvider, beanProperty, this._handledType);
        if (dVarM2074l != null) {
            JsonFormat.c cVarM1601e = dVarM2074l.m1601e();
            z2 = cVarM1601e.m1596f() || cVarM1601e == JsonFormat.c.ARRAY;
        }
        return z2 != this._asNumeric ? new InetAddressSerializer(z2) : this;
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public /* bridge */ /* synthetic */ void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        m2070p((InetAddress) obj, jsonGenerator);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.StdScalarSerializer, p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        InetAddress inetAddress = (InetAddress) obj;
        WritableTypeId writableTypeIdM1958d = typeSerializer.m1958d(inetAddress, JsonToken2.VALUE_STRING);
        writableTypeIdM1958d.f4585b = InetAddress.class;
        WritableTypeId writableTypeIdMo1959e = typeSerializer.mo1959e(jsonGenerator, writableTypeIdM1958d);
        m2070p(inetAddress, jsonGenerator);
        typeSerializer.mo1960f(jsonGenerator, writableTypeIdMo1959e);
    }

    /* JADX INFO: renamed from: p */
    public void m2070p(InetAddress inetAddress, JsonGenerator jsonGenerator) throws IOException {
        String strTrim;
        if (this._asNumeric) {
            strTrim = inetAddress.getHostAddress();
        } else {
            strTrim = inetAddress.toString().trim();
            int iIndexOf = strTrim.indexOf(47);
            if (iIndexOf >= 0) {
                strTrim = iIndexOf == 0 ? strTrim.substring(1) : strTrim.substring(0, iIndexOf);
            }
        }
        jsonGenerator.mo1658j0(strTrim);
    }

    public InetAddressSerializer(boolean z2) {
        super(InetAddress.class);
        this._asNumeric = z2;
    }
}
