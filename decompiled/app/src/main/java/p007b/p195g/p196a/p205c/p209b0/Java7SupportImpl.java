package p007b.p195g.p196a.p205c.p209b0;

import java.beans.ConstructorProperties;
import java.beans.Transient;
import p007b.p195g.p196a.p205c.PropertyName;
import p007b.p195g.p196a.p205c.p210c0.Annotated;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedParameter;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedWithParams;

/* JADX INFO: renamed from: b.g.a.c.b0.d, reason: use source file name */
/* JADX INFO: compiled from: Java7SupportImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class Java7SupportImpl extends Java7Support {
    @Override // p007b.p195g.p196a.p205c.p209b0.Java7Support
    /* JADX INFO: renamed from: a */
    public PropertyName mo1804a(AnnotatedParameter annotatedParameter) {
        ConstructorProperties constructorPropertiesMo1818b;
        AnnotatedWithParams annotatedWithParams = annotatedParameter._owner;
        if (annotatedWithParams == null || (constructorPropertiesMo1818b = annotatedWithParams.mo1818b(ConstructorProperties.class)) == null) {
            return null;
        }
        String[] strArrValue = constructorPropertiesMo1818b.value();
        int i = annotatedParameter._index;
        if (i < strArrValue.length) {
            return PropertyName.m2227a(strArrValue[i]);
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.p209b0.Java7Support
    /* JADX INFO: renamed from: b */
    public Boolean mo1805b(Annotated annotated) {
        Transient transientMo1818b = annotated.mo1818b(Transient.class);
        if (transientMo1818b != null) {
            return Boolean.valueOf(transientMo1818b.value());
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.p209b0.Java7Support
    /* JADX INFO: renamed from: c */
    public Boolean mo1806c(Annotated annotated) {
        if (annotated.mo1818b(ConstructorProperties.class) != null) {
            return Boolean.TRUE;
        }
        return null;
    }
}
