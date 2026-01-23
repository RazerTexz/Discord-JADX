package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes5;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.k, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaAnnotationArguments4 extends ReflectJavaAnnotationArguments implements annotationArguments4 {

    /* JADX INFO: renamed from: c */
    public final Class<?> f23054c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectJavaAnnotationArguments4(Name name, Class<?> cls) {
        super(name);
        Intrinsics3.checkNotNullParameter(cls, "klass");
        this.f23054c = cls;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments4
    public javaTypes5 getReferencedType() {
        return ReflectJavaType.f23065a.create(this.f23054c);
    }
}
