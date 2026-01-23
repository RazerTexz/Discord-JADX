package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.io.IOException;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p215g0.p217u.StdSerializer;

/* JADX INFO: renamed from: b.g.a.c.g0.t.r, reason: use source file name */
/* JADX INFO: compiled from: UnsupportedTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class UnsupportedTypeSerializer extends StdSerializer<Object> {
    private static final long serialVersionUID = 1;
    public final String _message;
    public final JavaType _type;

    public UnsupportedTypeSerializer(JavaType javaType, String str) {
        super(Object.class);
        this._type = javaType;
        this._message = str;
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        serializerProvider.mo1942f(this._type, this._message);
        throw null;
    }
}
