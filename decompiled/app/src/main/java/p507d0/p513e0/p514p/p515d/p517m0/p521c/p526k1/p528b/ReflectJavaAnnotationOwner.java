package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ReflectJavaAnnotationOwner.kt */
/* renamed from: d0.e0.p.d.m0.c.k1.b.f, reason: use source file name */
/* loaded from: classes3.dex */
public interface ReflectJavaAnnotationOwner extends InterfaceC11570d {

    /* compiled from: ReflectJavaAnnotationOwner.kt */
    /* renamed from: d0.e0.p.d.m0.c.k1.b.f$a */
    public static final class a {
        public static ReflectJavaAnnotation findAnnotation(ReflectJavaAnnotationOwner reflectJavaAnnotationOwner, FqName fqName) {
            Annotation[] declaredAnnotations;
            Intrinsics3.checkNotNullParameter(reflectJavaAnnotationOwner, "this");
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            AnnotatedElement element = reflectJavaAnnotationOwner.getElement();
            if (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null) {
                return null;
            }
            return ReflectJavaAnnotationOwner2.findAnnotation(declaredAnnotations, fqName);
        }

        public static List<ReflectJavaAnnotation> getAnnotations(ReflectJavaAnnotationOwner reflectJavaAnnotationOwner) {
            Intrinsics3.checkNotNullParameter(reflectJavaAnnotationOwner, "this");
            AnnotatedElement element = reflectJavaAnnotationOwner.getElement();
            Annotation[] declaredAnnotations = element == null ? null : element.getDeclaredAnnotations();
            return declaredAnnotations == null ? Collections2.emptyList() : ReflectJavaAnnotationOwner2.getAnnotations(declaredAnnotations);
        }

        public static boolean isDeprecatedInJavaDoc(ReflectJavaAnnotationOwner reflectJavaAnnotationOwner) {
            Intrinsics3.checkNotNullParameter(reflectJavaAnnotationOwner, "this");
            return false;
        }
    }

    AnnotatedElement getElement();
}
