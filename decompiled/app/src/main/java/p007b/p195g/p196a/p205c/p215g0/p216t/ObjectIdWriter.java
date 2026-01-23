package p007b.p195g.p196a.p205c.p215g0.p216t;

import p007b.p195g.p196a.p197a.ObjectIdGenerator;
import p007b.p195g.p196a.p198b.SerializableString;
import p007b.p195g.p196a.p198b.p200p.SerializedString;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.JsonSerializer;
import p007b.p195g.p196a.p205c.PropertyName;

/* JADX INFO: renamed from: b.g.a.c.g0.t.j, reason: use source file name */
/* JADX INFO: compiled from: ObjectIdWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ObjectIdWriter {

    /* JADX INFO: renamed from: a */
    public final JavaType f4818a;

    /* JADX INFO: renamed from: b */
    public final SerializableString f4819b;

    /* JADX INFO: renamed from: c */
    public final ObjectIdGenerator<?> f4820c;

    /* JADX INFO: renamed from: d */
    public final JsonSerializer<Object> f4821d;

    /* JADX INFO: renamed from: e */
    public final boolean f4822e;

    public ObjectIdWriter(JavaType javaType, SerializableString serializableString, ObjectIdGenerator<?> objectIdGenerator, JsonSerializer<?> jsonSerializer, boolean z2) {
        this.f4818a = javaType;
        this.f4819b = serializableString;
        this.f4820c = objectIdGenerator;
        this.f4821d = jsonSerializer;
        this.f4822e = z2;
    }

    /* JADX INFO: renamed from: a */
    public static ObjectIdWriter m2031a(JavaType javaType, PropertyName propertyName, ObjectIdGenerator<?> objectIdGenerator, boolean z2) {
        String str = propertyName == null ? null : propertyName._simpleName;
        return new ObjectIdWriter(javaType, str != null ? new SerializedString(str) : null, objectIdGenerator, null, z2);
    }
}
