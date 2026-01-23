package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaAnnotationArguments;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.annotationArguments;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p592z.JvmClassMapping;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.c, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaAnnotation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaAnnotation extends ReflectJavaElement implements InterfaceC11564a {

    /* JADX INFO: renamed from: a */
    public final Annotation f23038a;

    public ReflectJavaAnnotation(Annotation annotation) {
        Intrinsics3.checkNotNullParameter(annotation, "annotation");
        this.f23038a = annotation;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaAnnotation) && Intrinsics3.areEqual(this.f23038a, ((ReflectJavaAnnotation) obj).f23038a);
    }

    public final Annotation getAnnotation() {
        return this.f23038a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a
    public Collection<annotationArguments> getArguments() throws IllegalAccessException, InvocationTargetException {
        Method[] declaredMethods = JvmClassMapping.getJavaClass(JvmClassMapping.getAnnotationClass(this.f23038a)).getDeclaredMethods();
        Intrinsics3.checkNotNullExpressionValue(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            ReflectJavaAnnotationArguments.a aVar = ReflectJavaAnnotationArguments.f23039a;
            Object objInvoke = method.invoke(getAnnotation(), new Object[0]);
            Intrinsics3.checkNotNullExpressionValue(objInvoke, "method.invoke(annotation)");
            arrayList.add(aVar.create(objInvoke, Name.identifier(method.getName())));
        }
        return arrayList;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a
    public ClassId getClassId() {
        return reflectClassUtil.getClassId(JvmClassMapping.getJavaClass(JvmClassMapping.getAnnotationClass(this.f23038a)));
    }

    public int hashCode() {
        return this.f23038a.hashCode();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a
    public boolean isFreshlySupportedTypeUseAnnotation() {
        return InterfaceC11564a.a.isFreshlySupportedTypeUseAnnotation(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a
    public boolean isIdeExternalAnnotation() {
        return InterfaceC11564a.a.isIdeExternalAnnotation(this);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a
    public /* bridge */ /* synthetic */ InterfaceC11574g resolve() {
        return resolve();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        outline.m860k0(ReflectJavaAnnotation.class, sb, ": ");
        sb.append(this.f23038a);
        return sb.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a
    public ReflectJavaClass resolve() {
        return new ReflectJavaClass(JvmClassMapping.getJavaClass(JvmClassMapping.getAnnotationClass(this.f23038a)));
    }
}
