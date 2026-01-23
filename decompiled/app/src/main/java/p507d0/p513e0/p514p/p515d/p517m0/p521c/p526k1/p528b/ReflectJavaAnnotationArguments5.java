package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments5;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.o, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaAnnotationArguments5 extends ReflectJavaAnnotationArguments implements annotationArguments5 {

    /* JADX INFO: renamed from: c */
    public final Enum<?> f23058c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectJavaAnnotationArguments5(Name name, Enum<?> r3) {
        super(name);
        Intrinsics3.checkNotNullParameter(r3, "value");
        this.f23058c = r3;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments5
    public Name getEntryName() {
        return Name.identifier(this.f23058c.name());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments5
    public ClassId getEnumClassId() {
        Class<?> enclosingClass = this.f23058c.getClass();
        if (!enclosingClass.isEnum()) {
            enclosingClass = enclosingClass.getEnclosingClass();
        }
        Intrinsics3.checkNotNullExpressionValue(enclosingClass, "enumClass");
        return reflectClassUtil.getClassId(enclosingClass);
    }
}
