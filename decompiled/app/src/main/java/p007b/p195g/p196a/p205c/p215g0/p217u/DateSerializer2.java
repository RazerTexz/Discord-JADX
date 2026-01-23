package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* JADX INFO: renamed from: b.g.a.c.g0.u.k, reason: use source file name */
/* JADX INFO: compiled from: DateSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class DateSerializer2 extends DateTimeSerializerBase<Date> {

    /* JADX INFO: renamed from: k */
    public static final DateSerializer2 f4856k = new DateSerializer2();

    public DateSerializer2() {
        super(Date.class, null, null);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Date date = (Date) obj;
        if (m2066p(serializerProvider)) {
            jsonGenerator.mo1635I(date == null ? 0L : date.getTime());
        } else {
            m2067q(date, jsonGenerator, serializerProvider);
        }
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.DateTimeSerializerBase
    /* JADX INFO: renamed from: r */
    public DateTimeSerializerBase<Date> mo2060r(Boolean bool, DateFormat dateFormat) {
        return new DateSerializer2(bool, dateFormat);
    }

    public DateSerializer2(Boolean bool, DateFormat dateFormat) {
        super(Date.class, bool, dateFormat);
    }
}
