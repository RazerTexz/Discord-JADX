package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* JADX INFO: renamed from: b.g.a.c.g0.u.h, reason: use source file name */
/* JADX INFO: compiled from: CalendarSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class CalendarSerializer2 extends DateTimeSerializerBase<Calendar> {

    /* JADX INFO: renamed from: k */
    public static final CalendarSerializer2 f4854k = new CalendarSerializer2();

    public CalendarSerializer2() {
        super(Calendar.class, null, null);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Calendar calendar = (Calendar) obj;
        if (m2066p(serializerProvider)) {
            jsonGenerator.mo1635I(calendar == null ? 0L : calendar.getTimeInMillis());
        } else {
            m2067q(calendar.getTime(), jsonGenerator, serializerProvider);
        }
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.DateTimeSerializerBase
    /* JADX INFO: renamed from: r */
    public DateTimeSerializerBase<Calendar> mo2060r(Boolean bool, DateFormat dateFormat) {
        return new CalendarSerializer2(bool, dateFormat);
    }

    public CalendarSerializer2(Boolean bool, DateFormat dateFormat) {
        super(Calendar.class, bool, dateFormat);
    }
}
