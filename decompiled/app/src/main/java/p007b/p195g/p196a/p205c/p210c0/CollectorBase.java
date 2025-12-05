package p007b.p195g.p196a.p205c.p210c0;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.p210c0.AnnotationCollector;
import p007b.p195g.p196a.p205c.p219i0.ClassUtil;

/* compiled from: CollectorBase.java */
/* renamed from: b.g.a.c.c0.u, reason: use source file name */
/* loaded from: classes3.dex */
public class CollectorBase {

    /* renamed from: a */
    public static final AnnotationMap[] f4748a = new AnnotationMap[0];

    /* renamed from: b */
    public static final Annotation[] f4749b = new Annotation[0];

    /* renamed from: c */
    public final AnnotationIntrospector f4750c;

    public CollectorBase(AnnotationIntrospector annotationIntrospector) {
        this.f4750c = annotationIntrospector;
    }

    /* renamed from: a */
    public static AnnotationMap[] m1923a(int i) {
        if (i == 0) {
            return f4748a;
        }
        AnnotationMap[] annotationMapArr = new AnnotationMap[i];
        for (int i2 = 0; i2 < i; i2++) {
            annotationMapArr[i2] = new AnnotationMap();
        }
        return annotationMapArr;
    }

    /* renamed from: b */
    public final AnnotationCollector m1924b(AnnotationCollector annotationCollector, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            annotationCollector = annotationCollector.mo1911a(annotation);
            if (this.f4750c.mo1774b0(annotation)) {
                annotationCollector = m1927e(annotationCollector, annotation);
            }
        }
        return annotationCollector;
    }

    /* renamed from: c */
    public final AnnotationCollector m1925c(Annotation[] annotationArr) {
        AnnotationCollector annotationCollectorMo1911a = AnnotationCollector.a.f4727c;
        for (Annotation annotation : annotationArr) {
            annotationCollectorMo1911a = annotationCollectorMo1911a.mo1911a(annotation);
            if (this.f4750c.mo1774b0(annotation)) {
                annotationCollectorMo1911a = m1927e(annotationCollectorMo1911a, annotation);
            }
        }
        return annotationCollectorMo1911a;
    }

    /* renamed from: d */
    public final AnnotationCollector m1926d(AnnotationCollector annotationCollector, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            if (!annotationCollector.mo1914d(annotation)) {
                annotationCollector = annotationCollector.mo1911a(annotation);
                if (this.f4750c.mo1774b0(annotation)) {
                    for (Annotation annotation2 : ClassUtil.m2177i(annotation.annotationType())) {
                        if (!((annotation2 instanceof Target) || (annotation2 instanceof Retention)) && !annotationCollector.mo1914d(annotation2)) {
                            annotationCollector = annotationCollector.mo1911a(annotation2);
                            if (this.f4750c.mo1774b0(annotation2)) {
                                annotationCollector = m1927e(annotationCollector, annotation2);
                            }
                        }
                    }
                }
            }
        }
        return annotationCollector;
    }

    /* renamed from: e */
    public final AnnotationCollector m1927e(AnnotationCollector annotationCollector, Annotation annotation) {
        for (Annotation annotation2 : ClassUtil.m2177i(annotation.annotationType())) {
            if (!((annotation2 instanceof Target) || (annotation2 instanceof Retention))) {
                if (!this.f4750c.mo1774b0(annotation2)) {
                    annotationCollector = annotationCollector.mo1911a(annotation2);
                } else if (!annotationCollector.mo1914d(annotation2)) {
                    annotationCollector = m1927e(annotationCollector.mo1911a(annotation2), annotation2);
                }
            }
        }
        return annotationCollector;
    }
}
