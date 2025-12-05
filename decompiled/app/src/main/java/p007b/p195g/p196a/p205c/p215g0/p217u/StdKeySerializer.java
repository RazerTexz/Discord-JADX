package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.SerializerProvider;

/* compiled from: StdKeySerializer.java */
@Deprecated
/* renamed from: b.g.a.c.g0.u.n0, reason: use source file name */
/* loaded from: classes3.dex */
public class StdKeySerializer extends StdSerializer<Object> {
    public StdKeySerializer() {
        super(Object.class);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.mo1666y(obj.toString());
    }
}
