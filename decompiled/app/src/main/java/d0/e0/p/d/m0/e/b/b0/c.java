package d0.e0.p.d.m0.e.b.b0;

import d0.e0.p.d.m0.e.b.b0.b;

/* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
/* loaded from: classes3.dex */
public class c extends b.AbstractC0535b {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b.c f3369b;

    public c(b.c cVar) {
        this.f3369b = cVar;
    }

    @Override // d0.e0.p.d.m0.e.b.b0.b.AbstractC0535b
    public void b(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
        }
        b.this.h = strArr;
    }
}
