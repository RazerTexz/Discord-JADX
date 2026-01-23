package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0;

import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.ReadKotlinClassHeaderAnnotationVisitor;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b0.c, reason: use source file name */
/* JADX INFO: compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
/* JADX INFO: loaded from: classes3.dex */
public class ReadKotlinClassHeaderAnnotationVisitor2 extends ReadKotlinClassHeaderAnnotationVisitor.b {

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ReadKotlinClassHeaderAnnotationVisitor.c f23581b;

    public ReadKotlinClassHeaderAnnotationVisitor2(ReadKotlinClassHeaderAnnotationVisitor.c cVar) {
        this.f23581b = cVar;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.ReadKotlinClassHeaderAnnotationVisitor.b
    /* JADX INFO: renamed from: b */
    public void mo9541b(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
        }
        ReadKotlinClassHeaderAnnotationVisitor.this.f23574h = strArr;
    }
}
