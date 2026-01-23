package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.util.Objects;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonToken2;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p219i0.TokenBuffer;
import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* JADX INFO: renamed from: b.g.a.c.g0.u.v0, reason: use source file name */
/* JADX INFO: compiled from: TokenBufferSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class TokenBufferSerializer extends StdSerializer<TokenBuffer> {
    public TokenBufferSerializer() {
        super(TokenBuffer.class);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Objects.requireNonNull((TokenBuffer) obj);
        Objects.requireNonNull(null);
        throw null;
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: g */
    public void mo1808g(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        TokenBuffer tokenBuffer = (TokenBuffer) obj;
        typeSerializer.mo1959e(jsonGenerator, typeSerializer.m1958d(tokenBuffer, JsonToken2.VALUE_EMBEDDED_OBJECT));
        Objects.requireNonNull(tokenBuffer);
        Objects.requireNonNull(null);
        throw null;
    }
}
