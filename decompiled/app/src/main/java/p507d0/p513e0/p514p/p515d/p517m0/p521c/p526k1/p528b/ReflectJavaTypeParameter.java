package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaAnnotationOwner;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11592y;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p580t.Collections2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.x, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaTypeParameter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaTypeParameter extends ReflectJavaElement implements ReflectJavaAnnotationOwner, InterfaceC11592y {

    /* JADX INFO: renamed from: a */
    public final TypeVariable<?> f23066a;

    public ReflectJavaTypeParameter(TypeVariable<?> typeVariable) {
        Intrinsics3.checkNotNullParameter(typeVariable, "typeVariable");
        this.f23066a = typeVariable;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaTypeParameter) && Intrinsics3.areEqual(this.f23066a, ((ReflectJavaTypeParameter) obj).f23066a);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public ReflectJavaAnnotation findAnnotation(FqName fqName) {
        return ReflectJavaAnnotationOwner.a.findAnnotation(this, fqName);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaAnnotationOwner
    public AnnotatedElement getElement() {
        TypeVariable<?> typeVariable = this.f23066a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11587t
    public Name getName() {
        Name nameIdentifier = Name.identifier(this.f23066a.getName());
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(typeVariable.name)");
        return nameIdentifier;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11592y
    public /* bridge */ /* synthetic */ Collection getUpperBounds() {
        return getUpperBounds();
    }

    public int hashCode() {
        return this.f23066a.hashCode();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.a.isDeprecatedInJavaDoc(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        outline.m860k0(ReflectJavaTypeParameter.class, sb, ": ");
        sb.append(this.f23066a);
        return sb.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public /* bridge */ /* synthetic */ InterfaceC11564a findAnnotation(FqName fqName) {
        return findAnnotation(fqName);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.a.getAnnotations(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11592y
    public List<ReflectJavaClassifierType> getUpperBounds() {
        Type[] bounds = this.f23066a.getBounds();
        Intrinsics3.checkNotNullExpressionValue(bounds, "typeVariable.bounds");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new ReflectJavaClassifierType(type));
        }
        ReflectJavaClassifierType reflectJavaClassifierType = (ReflectJavaClassifierType) _Collections.singleOrNull((List) arrayList);
        return Intrinsics3.areEqual(reflectJavaClassifierType == null ? null : reflectJavaClassifierType.getReflectType(), Object.class) ? Collections2.emptyList() : arrayList;
    }
}
