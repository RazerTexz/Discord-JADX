package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonParser;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* JADX INFO: renamed from: b.g.a.c.g0.u.b0, reason: use source file name */
/* JADX INFO: compiled from: NumberSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class NumberSerializers2 extends NumberSerializers4<Object> {
    public NumberSerializers2(Class<?> cls) {
        super(cls, JsonParser.b.LONG, "number");
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.mo1635I(((Long) obj).longValue());
    }
}
