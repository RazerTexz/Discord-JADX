package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.io.IOException;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p215g0.p217u.StdSerializer;

/* compiled from: FailingSerializer.java */
/* renamed from: b.g.a.c.g0.t.c, reason: use source file name */
/* loaded from: classes3.dex */
public class FailingSerializer extends StdSerializer<Object> {
    public final String _msg;

    public FailingSerializer(String str) {
        super(Object.class);
        this._msg = str;
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        serializerProvider.m2243G(this._msg, new Object[0]);
        throw null;
    }
}
