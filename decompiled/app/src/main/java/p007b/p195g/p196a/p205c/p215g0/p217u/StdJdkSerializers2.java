package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.SerializerProvider;

/* JADX INFO: renamed from: b.g.a.c.g0.u.l0, reason: use source file name */
/* JADX INFO: compiled from: StdJdkSerializers.java */
/* JADX INFO: loaded from: classes3.dex */
public class StdJdkSerializers2 extends StdScalarSerializer<AtomicInteger> {
    public StdJdkSerializers2() {
        super(AtomicInteger.class, false);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.mo1634H(((AtomicInteger) obj).get());
    }
}
