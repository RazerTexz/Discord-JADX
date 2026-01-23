package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.KotlinClassHeader;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.ClassLiteralValue;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.p, reason: use source file name */
/* JADX INFO: compiled from: KotlinJvmBinaryClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface KotlinJvmBinaryClass {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.p$a */
    /* JADX INFO: compiled from: KotlinJvmBinaryClass.kt */
    public interface a {
        void visit(Name name, Object obj);

        a visitAnnotation(Name name, ClassId classId);

        b visitArray(Name name);

        void visitClassLiteral(Name name, ClassLiteralValue classLiteralValue);

        void visitEnd();

        void visitEnum(Name name, ClassId classId, Name name2);
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.p$b */
    /* JADX INFO: compiled from: KotlinJvmBinaryClass.kt */
    public interface b {
        void visit(Object obj);

        void visitClassLiteral(ClassLiteralValue classLiteralValue);

        void visitEnd();

        void visitEnum(ClassId classId, Name name);
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.p$c */
    /* JADX INFO: compiled from: KotlinJvmBinaryClass.kt */
    public interface c {
        a visitAnnotation(ClassId classId, SourceElement sourceElement);

        void visitEnd();
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.p$d */
    /* JADX INFO: compiled from: KotlinJvmBinaryClass.kt */
    public interface d {
        c visitField(Name name, String str, Object obj);

        e visitMethod(Name name, String str);
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.p$e */
    /* JADX INFO: compiled from: KotlinJvmBinaryClass.kt */
    public interface e extends c {
        a visitParameterAnnotation(int i, ClassId classId, SourceElement sourceElement);
    }

    KotlinClassHeader getClassHeader();

    ClassId getClassId();

    String getLocation();

    void loadClassAnnotations(c cVar, byte[] bArr);

    void visitMembers(d dVar, byte[] bArr);
}
