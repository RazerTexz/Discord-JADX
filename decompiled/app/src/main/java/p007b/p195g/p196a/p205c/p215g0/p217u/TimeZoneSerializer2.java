package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.util.TimeZone;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;

/* compiled from: TimeZoneSerializer.java */
/* renamed from: b.g.a.c.g0.u.s0, reason: use source file name */
/* loaded from: classes3.dex */
public class TimeZoneSerializer2 extends StdScalarSerializer<TimeZone> {
    public TimeZoneSerializer2() {
        super(TimeZone.class);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.mo1658j0(((TimeZone) obj).getID());
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.StdScalarSerializer, p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: g */
    public void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        TimeZone timeZone = (TimeZone) obj;
        WritableTypeId writableTypeIdM1958d = typeSerializer.m1958d(timeZone, JsonToken2.VALUE_STRING);
        writableTypeIdM1958d.f4585b = TimeZone.class;
        WritableTypeId writableTypeIdMo1959e = typeSerializer.mo1959e(jsonGenerator, writableTypeIdM1958d);
        jsonGenerator.mo1658j0(timeZone.getID());
        typeSerializer.mo1960f(jsonGenerator, writableTypeIdMo1959e);
    }
}
