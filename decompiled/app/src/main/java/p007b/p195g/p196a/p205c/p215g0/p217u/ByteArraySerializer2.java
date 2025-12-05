package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p198b.p203s.WritableTypeId;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* compiled from: ByteArraySerializer.java */
@JacksonStdImpl
/* renamed from: b.g.a.c.g0.u.f, reason: use source file name */
/* loaded from: classes3.dex */
public class ByteArraySerializer2 extends StdSerializer<byte[]> {
    private static final long serialVersionUID = 1;

    public ByteArraySerializer2() {
        super(byte[].class);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: d */
    public boolean mo2021d(SerializerProvider serializerProvider, Object obj) {
        return ((byte[]) obj).length == 0;
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        byte[] bArr = (byte[]) obj;
        jsonGenerator.mo1660n(serializerProvider._config._base._defaultBase64, bArr, 0, bArr.length);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* renamed from: g */
    public void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        byte[] bArr = (byte[]) obj;
        WritableTypeId writableTypeIdMo1959e = typeSerializer.mo1959e(jsonGenerator, typeSerializer.m1958d(bArr, JsonToken2.VALUE_EMBEDDED_OBJECT));
        jsonGenerator.mo1660n(serializerProvider._config._base._defaultBase64, bArr, 0, bArr.length);
        typeSerializer.mo1960f(jsonGenerator, writableTypeIdMo1959e);
    }
}
