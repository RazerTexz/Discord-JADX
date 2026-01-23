package p007b.p195g.p196a.p205c.p215g0;

import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.p212e0.TypeSerializer;
import p007b.p195g.p196a.p205c.p215g0.p217u.StdSerializer;

/* JADX INFO: renamed from: b.g.a.c.g0.h, reason: use source file name */
/* JADX INFO: compiled from: ContainerSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ContainerSerializer<T> extends StdSerializer<T> {
    public ContainerSerializer(Class<T> cls) {
        super(cls);
    }

    /* JADX INFO: renamed from: p */
    public abstract ContainerSerializer<?> mo1995p(TypeSerializer typeSerializer);

    /* JADX INFO: renamed from: q */
    public abstract boolean mo1996q(T t);

    public ContainerSerializer(JavaType javaType) {
        super(javaType);
    }

    public ContainerSerializer(Class<?> cls, boolean z2) {
        super(cls, z2);
    }

    public ContainerSerializer(ContainerSerializer<?> containerSerializer) {
        super(containerSerializer._handledType, false);
    }
}
