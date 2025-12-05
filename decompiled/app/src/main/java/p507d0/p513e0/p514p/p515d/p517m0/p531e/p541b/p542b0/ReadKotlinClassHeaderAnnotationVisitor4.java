package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0;

import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.ReadKotlinClassHeaderAnnotationVisitor;

/* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
/* renamed from: d0.e0.p.d.m0.e.b.b0.e, reason: use source file name */
/* loaded from: classes3.dex */
public class ReadKotlinClassHeaderAnnotationVisitor4 extends ReadKotlinClassHeaderAnnotationVisitor.b {

    /* renamed from: b */
    public final /* synthetic */ ReadKotlinClassHeaderAnnotationVisitor.d f23583b;

    public ReadKotlinClassHeaderAnnotationVisitor4(ReadKotlinClassHeaderAnnotationVisitor.d dVar) {
        this.f23583b = dVar;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.ReadKotlinClassHeaderAnnotationVisitor.b
    /* renamed from: b */
    public void mo9541b(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"));
        }
        ReadKotlinClassHeaderAnnotationVisitor.this.f23574h = strArr;
    }
}
