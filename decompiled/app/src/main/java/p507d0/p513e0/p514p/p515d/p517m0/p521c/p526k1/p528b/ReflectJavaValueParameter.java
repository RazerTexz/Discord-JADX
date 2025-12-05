package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11565a0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.javaTypes5;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ReflectJavaValueParameter.kt */
/* renamed from: d0.e0.p.d.m0.c.k1.b.y, reason: use source file name */
/* loaded from: classes3.dex */
public final class ReflectJavaValueParameter extends ReflectJavaElement implements InterfaceC11565a0 {

    /* renamed from: a */
    public final ReflectJavaType f23067a;

    /* renamed from: b */
    public final Annotation[] f23068b;

    /* renamed from: c */
    public final String f23069c;

    /* renamed from: d */
    public final boolean f23070d;

    public ReflectJavaValueParameter(ReflectJavaType reflectJavaType, Annotation[] annotationArr, String str, boolean z2) {
        Intrinsics3.checkNotNullParameter(reflectJavaType, "type");
        Intrinsics3.checkNotNullParameter(annotationArr, "reflectAnnotations");
        this.f23067a = reflectJavaType;
        this.f23068b = annotationArr;
        this.f23069c = str;
        this.f23070d = z2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public /* bridge */ /* synthetic */ InterfaceC11564a findAnnotation(FqName fqName) {
        return findAnnotation(fqName);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11565a0
    public Name getName() {
        String str = this.f23069c;
        if (str == null) {
            return null;
        }
        return Name.guessByFirstCharacter(str);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11565a0
    public /* bridge */ /* synthetic */ javaTypes5 getType() {
        return getType();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11565a0
    public boolean isVararg() {
        return this.f23070d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ReflectJavaValueParameter.class.getName());
        sb.append(": ");
        sb.append(isVararg() ? "vararg " : "");
        sb.append(getName());
        sb.append(": ");
        sb.append(getType());
        return sb.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public ReflectJavaAnnotation findAnnotation(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        return ReflectJavaAnnotationOwner2.findAnnotation(this.f23068b, fqName);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner2.getAnnotations(this.f23068b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11565a0
    public ReflectJavaType getType() {
        return this.f23067a;
    }
}
