package p007b.p195g.p196a.p205c.p215g0.p216t;

import java.io.IOException;
import java.util.Objects;
import p007b.p195g.p196a.p197a.ObjectIdGenerator;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.SerializerProvider;

/* JADX INFO: renamed from: b.g.a.c.g0.t.u, reason: use source file name */
/* JADX INFO: compiled from: WritableObjectId.java */
/* JADX INFO: loaded from: classes3.dex */
public final class WritableObjectId {

    /* JADX INFO: renamed from: a */
    public final ObjectIdGenerator<?> f4847a;

    /* JADX INFO: renamed from: b */
    public Object f4848b;

    /* JADX INFO: renamed from: c */
    public boolean f4849c = false;

    public WritableObjectId(ObjectIdGenerator<?> objectIdGenerator) {
        this.f4847a = objectIdGenerator;
    }

    /* JADX INFO: renamed from: a */
    public boolean m2043a(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, ObjectIdWriter objectIdWriter) throws IOException {
        if (this.f4848b == null) {
            return false;
        }
        if (!this.f4849c && !objectIdWriter.f4822e) {
            return false;
        }
        Objects.requireNonNull(jsonGenerator);
        objectIdWriter.f4821d.mo1807f(this.f4848b, jsonGenerator, serializerProvider);
        return true;
    }
}
