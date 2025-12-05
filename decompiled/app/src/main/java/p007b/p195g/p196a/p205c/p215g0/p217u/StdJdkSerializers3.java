package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.SerializerProvider;

/* compiled from: StdJdkSerializers.java */
/* renamed from: b.g.a.c.g0.u.m0, reason: use source file name */
/* loaded from: classes3.dex */
public class StdJdkSerializers3 extends StdScalarSerializer<AtomicLong> {
    public StdJdkSerializers3() {
        super(AtomicLong.class, false);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.mo1635I(((AtomicLong) obj).get());
    }
}
