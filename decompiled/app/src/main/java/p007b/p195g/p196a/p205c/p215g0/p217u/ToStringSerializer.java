package p007b.p195g.p196a.p205c.p215g0.p217u;

import p007b.p195g.p196a.p205c.p220y.JacksonStdImpl;

/* JADX INFO: renamed from: b.g.a.c.g0.u.t0, reason: use source file name */
/* JADX INFO: compiled from: ToStringSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@JacksonStdImpl
public class ToStringSerializer extends ToStringSerializerBase {

    /* JADX INFO: renamed from: k */
    public static final ToStringSerializer f4866k = new ToStringSerializer();

    public ToStringSerializer() {
        super(Object.class);
    }

    @Override // p007b.p195g.p196a.p205c.p215g0.p217u.ToStringSerializerBase
    /* JADX INFO: renamed from: p */
    public final String mo2087p(Object obj) {
        return obj.toString();
    }

    public ToStringSerializer(Class<?> cls) {
        super(cls);
    }
}
