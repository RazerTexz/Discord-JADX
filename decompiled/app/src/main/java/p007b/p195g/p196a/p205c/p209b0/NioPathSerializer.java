package p007b.p195g.p196a.p205c.p209b0;

import java.io.IOException;
import java.nio.file.Path;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.StdScalarSerializer;

/* JADX INFO: renamed from: b.g.a.c.b0.e, reason: use source file name */
/* JADX INFO: compiled from: NioPathSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class NioPathSerializer extends StdScalarSerializer<Path> {
    private static final long serialVersionUID = 1;

    public NioPathSerializer() {
        super(Path.class);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.mo1658j0(((Path) obj).toUri().toString());
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.StdScalarSerializer, p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        Path path = (Path) obj;
        WritableTypeId writableTypeIdM1958d = typeSerializer.m1958d(path, JsonToken2.VALUE_STRING);
        writableTypeIdM1958d.f4585b = Path.class;
        WritableTypeId writableTypeIdMo1959e = typeSerializer.mo1959e(jsonGenerator, writableTypeIdM1958d);
        jsonGenerator.mo1658j0(path.toUri().toString());
        typeSerializer.mo1960f(jsonGenerator, writableTypeIdMo1959e);
    }
}
