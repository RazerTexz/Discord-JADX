package p617h0.p618a.p619a;

import org.objectweb.asm.Opcodes;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: h0.a.a.l, reason: use source file name */
/* JADX INFO: compiled from: FieldWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FieldWriter2 extends FieldVisitor2 {

    /* JADX INFO: renamed from: b */
    public final SymbolTable2 f26217b;

    /* JADX INFO: renamed from: c */
    public final int f26218c;

    /* JADX INFO: renamed from: d */
    public final int f26219d;

    /* JADX INFO: renamed from: e */
    public final int f26220e;

    /* JADX INFO: renamed from: f */
    public int f26221f;

    /* JADX INFO: renamed from: g */
    public int f26222g;

    /* JADX INFO: renamed from: h */
    public AnnotationWriter2 f26223h;

    /* JADX INFO: renamed from: i */
    public AnnotationWriter2 f26224i;

    /* JADX INFO: renamed from: j */
    public AnnotationWriter2 f26225j;

    /* JADX INFO: renamed from: k */
    public AnnotationWriter2 f26226k;

    /* JADX INFO: renamed from: l */
    public Attribute2 f26227l;

    public FieldWriter2(SymbolTable2 symbolTable2, int i, String str, String str2, String str3, Object obj) {
        super(Opcodes.ASM7);
        this.f26217b = symbolTable2;
        this.f26218c = i;
        this.f26219d = symbolTable2.m10637l(str);
        this.f26220e = symbolTable2.m10637l(str2);
        if (str3 != null) {
            this.f26221f = symbolTable2.m10637l(str3);
        }
        if (obj != null) {
            this.f26222g = symbolTable2.m10627b(obj).f26340a;
        }
    }

    /* JADX INFO: renamed from: a */
    public AnnotationWriter2 m10570a(String str, boolean z2) {
        ByteVector2 byteVector2 = new ByteVector2();
        byteVector2.m10538j(this.f26217b.m10637l(str));
        byteVector2.m10538j(0);
        if (z2) {
            AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(this.f26217b, true, byteVector2, this.f26223h);
            this.f26223h = annotationWriter2;
            return annotationWriter2;
        }
        AnnotationWriter2 annotationWriter22 = new AnnotationWriter2(this.f26217b, true, byteVector2, this.f26224i);
        this.f26224i = annotationWriter22;
        return annotationWriter22;
    }

    /* JADX INFO: renamed from: b */
    public AnnotationWriter2 m10571b(int i, TypePath2 typePath2, String str, boolean z2) {
        ByteVector2 byteVector2 = new ByteVector2();
        C3404f.m4256W0(i, byteVector2);
        TypePath2.m10655a(typePath2, byteVector2);
        byteVector2.m10538j(this.f26217b.m10637l(str));
        byteVector2.m10538j(0);
        if (z2) {
            AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(this.f26217b, true, byteVector2, this.f26225j);
            this.f26225j = annotationWriter2;
            return annotationWriter2;
        }
        AnnotationWriter2 annotationWriter22 = new AnnotationWriter2(this.f26217b, true, byteVector2, this.f26226k);
        this.f26226k = annotationWriter22;
        return annotationWriter22;
    }
}
