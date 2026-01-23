package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* JADX INFO: renamed from: b.g.a.c.g0.u.r0, reason: use source file name */
/* JADX INFO: compiled from: StringSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public final class StringSerializer2 extends StdScalarSerializer<Object> {
    private static final long serialVersionUID = 1;

    public StringSerializer2() {
        super(String.class, false);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
        return ((String) obj).isEmpty();
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.mo1658j0((String) obj);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.StdScalarSerializer, p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: g */
    public final void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        jsonGenerator.mo1658j0((String) obj);
    }
}
