package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* compiled from: CalendarSerializer.java */
@JacksonStdImpl
/* renamed from: b.g.a.c.g0.u.h, reason: use source file name */
/* loaded from: classes3.dex */
public class CalendarSerializer2 extends DateTimeSerializerBase<Calendar> {

    /* renamed from: k */
    public static final CalendarSerializer2 f4854k = new CalendarSerializer2();

    public CalendarSerializer2() {
        super(Calendar.class, null, null);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Calendar calendar = (Calendar) obj;
        if (m2066p(serializerProvider)) {
            jsonGenerator.mo1635I(calendar == null ? 0L : calendar.getTimeInMillis());
        } else {
            m2067q(calendar.getTime(), jsonGenerator, serializerProvider);
        }
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.DateTimeSerializerBase
    /* renamed from: r */
    public DateTimeSerializerBase<Calendar> mo2060r(Boolean bool, DateFormat dateFormat) {
        return new CalendarSerializer2(bool, dateFormat);
    }

    public CalendarSerializer2(Boolean bool, DateFormat dateFormat) {
        super(Calendar.class, bool, dateFormat);
    }
}
