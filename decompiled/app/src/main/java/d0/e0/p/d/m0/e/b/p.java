package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.c.u0;

/* compiled from: KotlinJvmBinaryClass.kt */
/* loaded from: classes3.dex */
public interface p {

    /* compiled from: KotlinJvmBinaryClass.kt */
    public interface a {
        void visit(d0.e0.p.d.m0.g.e eVar, Object obj);

        a visitAnnotation(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.g.a aVar);

        b visitArray(d0.e0.p.d.m0.g.e eVar);

        void visitClassLiteral(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.k.v.f fVar);

        void visitEnd();

        void visitEnum(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.g.a aVar, d0.e0.p.d.m0.g.e eVar2);
    }

    /* compiled from: KotlinJvmBinaryClass.kt */
    public interface b {
        void visit(Object obj);

        void visitClassLiteral(d0.e0.p.d.m0.k.v.f fVar);

        void visitEnd();

        void visitEnum(d0.e0.p.d.m0.g.a aVar, d0.e0.p.d.m0.g.e eVar);
    }

    /* compiled from: KotlinJvmBinaryClass.kt */
    public interface c {
        a visitAnnotation(d0.e0.p.d.m0.g.a aVar, u0 u0Var);

        void visitEnd();
    }

    /* compiled from: KotlinJvmBinaryClass.kt */
    public interface d {
        c visitField(d0.e0.p.d.m0.g.e eVar, String str, Object obj);

        e visitMethod(d0.e0.p.d.m0.g.e eVar, String str);
    }

    /* compiled from: KotlinJvmBinaryClass.kt */
    public interface e extends c {
        a visitParameterAnnotation(int i, d0.e0.p.d.m0.g.a aVar, u0 u0Var);
    }

    d0.e0.p.d.m0.e.b.b0.a getClassHeader();

    d0.e0.p.d.m0.g.a getClassId();

    String getLocation();

    void loadClassAnnotations(c cVar, byte[] bArr);

    void visitMembers(d dVar, byte[] bArr);
}
