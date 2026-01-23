package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p592z.JvmClassMapping;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.g, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaAnnotationOwner.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaAnnotationOwner2 {
    public static final ReflectJavaAnnotation findAnnotation(Annotation[] annotationArr, FqName fqName) {
        Annotation annotation;
        Intrinsics3.checkNotNullParameter(annotationArr, "<this>");
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        int length = annotationArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i];
            if (Intrinsics3.areEqual(reflectClassUtil.getClassId(JvmClassMapping.getJavaClass(JvmClassMapping.getAnnotationClass(annotation))).asSingleFqName(), fqName)) {
                break;
            }
            i++;
        }
        if (annotation == null) {
            return null;
        }
        return new ReflectJavaAnnotation(annotation);
    }

    public static final List<ReflectJavaAnnotation> getAnnotations(Annotation[] annotationArr) {
        Intrinsics3.checkNotNullParameter(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new ReflectJavaAnnotation(annotation));
        }
        return arrayList;
    }
}
