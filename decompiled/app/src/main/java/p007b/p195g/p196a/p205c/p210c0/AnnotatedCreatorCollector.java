package p007b.p195g.p196a.p205c.p210c0;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.p210c0.AnnotationCollector;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* JADX INFO: renamed from: b.g.a.c.c0.f, reason: use source file name */
/* JADX INFO: compiled from: AnnotatedCreatorCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotatedCreatorCollector extends CollectorBase {

    /* JADX INFO: renamed from: d */
    public final TypeResolutionContext f4705d;

    /* JADX INFO: renamed from: e */
    public final boolean f4706e;

    /* JADX INFO: renamed from: f */
    public AnnotatedConstructor f4707f;

    public AnnotatedCreatorCollector(AnnotationIntrospector annotationIntrospector, TypeResolutionContext typeResolutionContext, boolean z2) {
        super(annotationIntrospector);
        this.f4705d = typeResolutionContext;
        this.f4706e = z2;
    }

    /* JADX INFO: renamed from: f */
    public static boolean m1892f(Method method) {
        return Modifier.isStatic(method.getModifiers()) && !method.isSynthetic();
    }

    /* JADX INFO: renamed from: g */
    public final AnnotationMap m1893g(ClassUtil.a aVar, ClassUtil.a aVar2) {
        if (!this.f4706e) {
            return new AnnotationMap();
        }
        Annotation[] declaredAnnotations = aVar.f4948b;
        if (declaredAnnotations == null) {
            declaredAnnotations = aVar.f4947a.getDeclaredAnnotations();
            aVar.f4948b = declaredAnnotations;
        }
        AnnotationCollector annotationCollectorM1925c = m1925c(declaredAnnotations);
        if (aVar2 != null) {
            Annotation[] declaredAnnotations2 = aVar2.f4948b;
            if (declaredAnnotations2 == null) {
                declaredAnnotations2 = aVar2.f4947a.getDeclaredAnnotations();
                aVar2.f4948b = declaredAnnotations2;
            }
            annotationCollectorM1925c = m1924b(annotationCollectorM1925c, declaredAnnotations2);
        }
        return annotationCollectorM1925c.mo1912b();
    }

    /* JADX INFO: renamed from: h */
    public final AnnotationMap m1894h(AnnotatedElement annotatedElement, AnnotatedElement annotatedElement2) {
        AnnotationCollector annotationCollectorM1925c = m1925c(annotatedElement.getDeclaredAnnotations());
        if (annotatedElement2 != null) {
            annotationCollectorM1925c = m1924b(annotationCollectorM1925c, annotatedElement2.getDeclaredAnnotations());
        }
        return annotationCollectorM1925c.mo1912b();
    }

    /* JADX INFO: renamed from: i */
    public final AnnotationMap[] m1895i(Annotation[][] annotationArr, Annotation[][] annotationArr2) {
        if (!this.f4706e) {
            return CollectorBase.f4748a;
        }
        int length = annotationArr.length;
        AnnotationMap[] annotationMapArr = new AnnotationMap[length];
        for (int i = 0; i < length; i++) {
            AnnotationCollector annotationCollectorM1924b = m1924b(AnnotationCollector.a.f4727c, annotationArr[i]);
            if (annotationArr2 != null) {
                annotationCollectorM1924b = m1924b(annotationCollectorM1924b, annotationArr2[i]);
            }
            annotationMapArr[i] = annotationCollectorM1924b.mo1912b();
        }
        return annotationMapArr;
    }

    /* JADX INFO: renamed from: j */
    public AnnotatedMethod m1896j(Method method, TypeResolutionContext typeResolutionContext, Method method2) {
        int length = method.getParameterTypes().length;
        if (this.f4750c == null) {
            return new AnnotatedMethod(typeResolutionContext, method, new AnnotationMap(), CollectorBase.m1923a(length));
        }
        if (length == 0) {
            return new AnnotatedMethod(typeResolutionContext, method, m1894h(method, method2), CollectorBase.f4748a);
        }
        return new AnnotatedMethod(typeResolutionContext, method, m1894h(method, method2), m1895i(method.getParameterAnnotations(), method2 == null ? null : method2.getParameterAnnotations()));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /* JADX INFO: renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AnnotatedConstructor m1897k(ClassUtil.a aVar, ClassUtil.a aVar2) {
        Annotation[][] annotationArr;
        AnnotationMap[] annotationMapArrM1895i;
        int iM2195a = aVar.m2195a();
        if (this.f4750c == null) {
            return new AnnotatedConstructor(this.f4705d, aVar.f4947a, new AnnotationMap(), CollectorBase.m1923a(iM2195a));
        }
        if (iM2195a == 0) {
            return new AnnotatedConstructor(this.f4705d, aVar.f4947a, m1893g(aVar, aVar2), CollectorBase.f4748a);
        }
        Annotation[][] parameterAnnotations = aVar.f4949c;
        if (parameterAnnotations == null) {
            parameterAnnotations = aVar.f4947a.getParameterAnnotations();
            aVar.f4949c = parameterAnnotations;
        }
        Annotation[][] annotationArr2 = null;
        annotationMapArrM1895i = null;
        AnnotationMap[] annotationMapArrM1895i2 = null;
        if (iM2195a != parameterAnnotations.length) {
            Class<?> declaringClass = aVar.f4947a.getDeclaringClass();
            if (ClassUtil.m2185q(declaringClass) && iM2195a == parameterAnnotations.length + 2) {
                annotationArr = new Annotation[parameterAnnotations.length + 2][];
                System.arraycopy(parameterAnnotations, 0, annotationArr, 2, parameterAnnotations.length);
                annotationMapArrM1895i = m1895i(annotationArr, null);
            } else {
                if (declaringClass.isMemberClass() && iM2195a == parameterAnnotations.length + 1) {
                    annotationArr = new Annotation[parameterAnnotations.length + 1][];
                    System.arraycopy(parameterAnnotations, 0, annotationArr, 1, parameterAnnotations.length);
                    annotationArr[0] = CollectorBase.f4749b;
                    annotationMapArrM1895i = m1895i(annotationArr, null);
                }
                if (annotationMapArrM1895i2 == null) {
                    throw new IllegalStateException(String.format("Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations", aVar.f4947a.getDeclaringClass().getName(), Integer.valueOf(iM2195a), Integer.valueOf(parameterAnnotations.length)));
                }
            }
            annotationMapArrM1895i2 = annotationMapArrM1895i;
            parameterAnnotations = annotationArr;
            if (annotationMapArrM1895i2 == null) {
            }
        } else {
            if (aVar2 != null) {
                Annotation[][] parameterAnnotations2 = aVar2.f4949c;
                if (parameterAnnotations2 == null) {
                    parameterAnnotations2 = aVar2.f4947a.getParameterAnnotations();
                    aVar2.f4949c = parameterAnnotations2;
                }
                annotationArr2 = parameterAnnotations2;
            }
            annotationMapArrM1895i2 = m1895i(parameterAnnotations, annotationArr2);
        }
        return new AnnotatedConstructor(this.f4705d, aVar.f4947a, m1893g(aVar, aVar2), annotationMapArrM1895i2);
    }
}
