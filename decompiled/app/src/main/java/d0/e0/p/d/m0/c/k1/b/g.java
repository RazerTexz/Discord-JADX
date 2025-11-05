package d0.e0.p.d.m0.c.k1.b;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ReflectJavaAnnotationOwner.kt */
/* loaded from: classes3.dex */
public final class g {
    public static final c findAnnotation(Annotation[] annotationArr, d0.e0.p.d.m0.g.b bVar) {
        Annotation annotation;
        d0.z.d.m.checkNotNullParameter(annotationArr, "<this>");
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        int length = annotationArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i];
            if (d0.z.d.m.areEqual(b.getClassId(d0.z.a.getJavaClass(d0.z.a.getAnnotationClass(annotation))).asSingleFqName(), bVar)) {
                break;
            }
            i++;
        }
        if (annotation == null) {
            return null;
        }
        return new c(annotation);
    }

    public static final List<c> getAnnotations(Annotation[] annotationArr) {
        d0.z.d.m.checkNotNullParameter(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new c(annotation));
        }
        return arrayList;
    }
}
