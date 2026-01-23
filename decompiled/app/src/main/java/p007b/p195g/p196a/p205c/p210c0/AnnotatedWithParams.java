package p007b.p195g.p196a.p205c.p210c0;

import p007b.p195g.p196a.p205c.JavaType;

/* JADX INFO: renamed from: b.g.a.c.c0.n, reason: use source file name */
/* JADX INFO: compiled from: AnnotatedWithParams.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AnnotatedWithParams extends AnnotatedMember {
    private static final long serialVersionUID = 1;
    public final AnnotationMap[] _paramAnnotations;

    public AnnotatedWithParams(TypeResolutionContext typeResolutionContext, AnnotationMap annotationMap, AnnotationMap[] annotationMapArr) {
        super(typeResolutionContext, annotationMap);
        this._paramAnnotations = annotationMapArr;
    }

    /* JADX INFO: renamed from: m */
    public final AnnotatedParameter m1910m(int i) {
        JavaType javaTypeMo1891n = mo1891n(i);
        TypeResolutionContext typeResolutionContext = this.f4716j;
        AnnotationMap[] annotationMapArr = this._paramAnnotations;
        return new AnnotatedParameter(this, javaTypeMo1891n, typeResolutionContext, (annotationMapArr == null || i < 0 || i >= annotationMapArr.length) ? null : annotationMapArr[i], i);
    }

    /* JADX INFO: renamed from: n */
    public abstract JavaType mo1891n(int i);
}
