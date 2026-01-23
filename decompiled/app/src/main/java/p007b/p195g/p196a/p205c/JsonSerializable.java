package p007b.p195g.p196a.p205c;

import java.io.IOException;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;

/* JADX INFO: renamed from: b.g.a.c.m, reason: use source file name */
/* JADX INFO: compiled from: JsonSerializable.java */
/* JADX INFO: loaded from: classes3.dex */
public interface JsonSerializable {

    /* JADX INFO: renamed from: b.g.a.c.m$a */
    /* JADX INFO: compiled from: JsonSerializable.java */
    public static abstract class a implements JsonSerializable {
    }

    /* JADX INFO: renamed from: c */
    void mo2140c(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException;

    /* JADX INFO: renamed from: d */
    void mo2141d(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException;
}
