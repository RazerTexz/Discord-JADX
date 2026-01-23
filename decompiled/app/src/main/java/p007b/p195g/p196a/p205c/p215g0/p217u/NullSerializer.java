package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* JADX INFO: renamed from: b.g.a.c.g0.u.u, reason: use source file name */
/* JADX INFO: compiled from: NullSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class NullSerializer extends StdSerializer<Object> {

    /* JADX INFO: renamed from: k */
    public static final NullSerializer f4867k = new NullSerializer();

    public NullSerializer() {
        super(Object.class);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.mo1631A();
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        jsonGenerator.mo1631A();
    }
}
