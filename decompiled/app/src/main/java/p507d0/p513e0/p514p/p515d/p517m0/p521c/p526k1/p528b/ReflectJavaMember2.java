package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Visibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaAnnotationOwner;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaModifierListOwner;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11565a0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11584q;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.SpecialNames;
import p507d0.p580t._Arrays;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.r, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaMember.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ReflectJavaMember2 extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, InterfaceC11584q {
    /* JADX INFO: renamed from: a */
    public final List<InterfaceC11565a0> m9436a(Type[] typeArr, Annotation[][] annotationArr, boolean z2) throws IllegalAccessException, InvocationTargetException {
        String str;
        Intrinsics3.checkNotNullParameter(typeArr, "parameterTypes");
        Intrinsics3.checkNotNullParameter(annotationArr, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(typeArr.length);
        List<String> listLoadParameterNames = ReflectJavaMember.f23028a.loadParameterNames(getMember());
        Integer numValueOf = listLoadParameterNames == null ? null : Integer.valueOf(listLoadParameterNames.size());
        int iIntValue = numValueOf == null ? 0 : numValueOf.intValue() - typeArr.length;
        int length = typeArr.length - 1;
        if (length >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                ReflectJavaType reflectJavaTypeCreate = ReflectJavaType.f23065a.create(typeArr[i]);
                if (listLoadParameterNames == null) {
                    str = null;
                } else {
                    str = (String) _Collections.getOrNull(listLoadParameterNames, i + iIntValue);
                    if (str == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("No parameter with index ");
                        sb.append(i);
                        sb.append('+');
                        sb.append(iIntValue);
                        sb.append(" (name=");
                        sb.append(getName());
                        sb.append(" type=");
                        sb.append(reflectJavaTypeCreate);
                        sb.append(") in ");
                        throw new IllegalStateException(outline.m824L(sb, listLoadParameterNames, "@ReflectJavaMember").toString());
                    }
                }
                arrayList.add(new ReflectJavaValueParameter(reflectJavaTypeCreate, annotationArr[i], str, z2 && i == _Arrays.getLastIndex(typeArr)));
                if (i2 > length) {
                    break;
                }
                i = i2;
            }
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaMember2) && Intrinsics3.areEqual(getMember(), ((ReflectJavaMember2) obj).getMember());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public ReflectJavaAnnotation findAnnotation(FqName fqName) {
        return ReflectJavaAnnotationOwner.a.findAnnotation(this, fqName);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11584q
    public /* bridge */ /* synthetic */ InterfaceC11574g getContainingClass() {
        return getContainingClass();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaAnnotationOwner
    public AnnotatedElement getElement() {
        return (AnnotatedElement) getMember();
    }

    public abstract Member getMember();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaModifierListOwner
    public int getModifiers() {
        return getMember().getModifiers();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11587t
    public Name getName() {
        String name = getMember().getName();
        Name nameIdentifier = name == null ? null : Name.identifier(name);
        if (nameIdentifier != null) {
            return nameIdentifier;
        }
        Name name2 = SpecialNames.f24092a;
        Intrinsics3.checkNotNullExpressionValue(name2, "NO_NAME_PROVIDED");
        return name2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11586s
    public Visibility2 getVisibility() {
        return ReflectJavaModifierListOwner.a.getVisibility(this);
    }

    public int hashCode() {
        return getMember().hashCode();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11586s
    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.a.isAbstract(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.a.isDeprecatedInJavaDoc(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11586s
    public boolean isFinal() {
        return ReflectJavaModifierListOwner.a.isFinal(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11586s
    public boolean isStatic() {
        return ReflectJavaModifierListOwner.a.isStatic(this);
    }

    public String toString() {
        return getClass().getName() + ": " + getMember();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public /* bridge */ /* synthetic */ InterfaceC11564a findAnnotation(FqName fqName) {
        return findAnnotation(fqName);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.a.getAnnotations(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11584q
    public ReflectJavaClass getContainingClass() {
        Class<?> declaringClass = getMember().getDeclaringClass();
        Intrinsics3.checkNotNullExpressionValue(declaringClass, "member.declaringClass");
        return new ReflectJavaClass(declaringClass);
    }
}
