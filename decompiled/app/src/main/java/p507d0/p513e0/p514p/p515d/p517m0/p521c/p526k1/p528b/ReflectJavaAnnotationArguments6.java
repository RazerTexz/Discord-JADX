package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments6;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.q, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaAnnotationArguments6 extends ReflectJavaAnnotationArguments implements annotationArguments6 {

    /* JADX INFO: renamed from: c */
    public final Object f23060c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectJavaAnnotationArguments6(Name name, Object obj) {
        super(name);
        Intrinsics3.checkNotNullParameter(obj, "value");
        this.f23060c = obj;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments6
    public Object getValue() {
        return this.f23060c;
    }
}
