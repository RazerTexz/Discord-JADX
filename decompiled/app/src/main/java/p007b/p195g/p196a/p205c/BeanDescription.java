package p007b.p195g.p196a.p205c;

import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;

/* JADX INFO: renamed from: b.g.a.c.c, reason: use source file name */
/* JADX INFO: compiled from: BeanDescription.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BeanDescription {

    /* JADX INFO: renamed from: a */
    public final JavaType f4626a;

    public BeanDescription(JavaType javaType) {
        this.f4626a = javaType;
    }

    /* JADX INFO: renamed from: a */
    public abstract JsonFormat.d mo1812a(JsonFormat.d dVar);

    /* JADX INFO: renamed from: b */
    public abstract AnnotatedMember mo1813b();

    /* JADX INFO: renamed from: c */
    public abstract JsonInclude.b mo1814c(JsonInclude.b bVar);
}
