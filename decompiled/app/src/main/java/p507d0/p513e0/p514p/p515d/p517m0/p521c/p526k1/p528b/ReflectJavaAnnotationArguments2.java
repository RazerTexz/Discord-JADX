package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.annotation.Annotation;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.e, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaAnnotationArguments2 extends ReflectJavaAnnotationArguments implements annotationArguments2 {

    /* JADX INFO: renamed from: c */
    public final Annotation f23041c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectJavaAnnotationArguments2(Name name, Annotation annotation) {
        super(name);
        Intrinsics3.checkNotNullParameter(annotation, "annotation");
        this.f23041c = annotation;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments2
    public InterfaceC11564a getAnnotation() {
        return new ReflectJavaAnnotation(this.f23041c);
    }
}
