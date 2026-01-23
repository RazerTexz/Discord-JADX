package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.util.Objects;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.JsonSerializable;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* JADX INFO: renamed from: b.g.a.c.g0.u.g0, reason: use source file name */
/* JADX INFO: compiled from: SerializableSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class SerializableSerializer extends StdSerializer<JsonSerializable> {

    /* JADX INFO: renamed from: k */
    public static final SerializableSerializer f4853k = new SerializableSerializer();

    public SerializableSerializer() {
        super(JsonSerializable.class);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
        JsonSerializable jsonSerializable = (JsonSerializable) obj;
        if (!(jsonSerializable instanceof JsonSerializable.a)) {
            return false;
        }
        Objects.requireNonNull((JsonSerializable.a) jsonSerializable);
        return false;
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        ((JsonSerializable) obj).mo2140c(jsonGenerator, serializerProvider);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        ((JsonSerializable) obj).mo2141d(jsonGenerator, serializerProvider, typeSerializer);
    }
}
