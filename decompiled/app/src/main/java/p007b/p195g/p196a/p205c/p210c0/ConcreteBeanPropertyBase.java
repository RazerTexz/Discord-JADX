package p007b.p195g.p196a.p205c.p210c0;

import java.io.Serializable;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.BeanProperty;
import p007b.p195g.p196a.p205c.PropertyMetadata;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;

/* JADX INFO: renamed from: b.g.a.c.c0.v, reason: use source file name */
/* JADX INFO: compiled from: ConcreteBeanPropertyBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ConcreteBeanPropertyBase implements BeanProperty, Serializable {
    private static final long serialVersionUID = 1;
    public final PropertyMetadata _metadata;

    public ConcreteBeanPropertyBase(PropertyMetadata propertyMetadata) {
        this._metadata = propertyMetadata == null ? PropertyMetadata.f5027l : propertyMetadata;
    }

    @Override // p007b.p195g.p196a.p205c.BeanProperty
    /* JADX INFO: renamed from: a */
    public JsonFormat.d mo1928a(MapperConfig<?> mapperConfig, Class<?> cls) {
        AnnotatedMember member;
        JsonFormat.d dVarMo2271i = mapperConfig.mo2271i(cls);
        AnnotationIntrospector annotationIntrospectorM2267e = mapperConfig.m2267e();
        JsonFormat.d dVarMo1784h = (annotationIntrospectorM2267e == null || (member = getMember()) == null) ? null : annotationIntrospectorM2267e.mo1784h(member);
        return dVarMo2271i == null ? dVarMo1784h == null ? BeanProperty.f4765c : dVarMo1784h : dVarMo1784h == null ? dVarMo2271i : dVarMo2271i.m1607k(dVarMo1784h);
    }

    @Override // p007b.p195g.p196a.p205c.BeanProperty
    /* JADX INFO: renamed from: b */
    public JsonInclude.b mo1929b(MapperConfig<?> mapperConfig, Class<?> cls) {
        AnnotationIntrospector annotationIntrospectorM2267e = mapperConfig.m2267e();
        AnnotatedMember member = getMember();
        if (member == null) {
            return mapperConfig.mo2272j(cls);
        }
        JsonInclude.b bVarMo2269g = mapperConfig.mo2269g(cls, member.mo1820d());
        if (annotationIntrospectorM2267e == null) {
            return bVarMo2269g;
        }
        JsonInclude.b bVarMo1802z = annotationIntrospectorM2267e.mo1802z(member);
        return bVarMo2269g == null ? bVarMo1802z : bVarMo2269g.m1618a(bVarMo1802z);
    }

    public ConcreteBeanPropertyBase(ConcreteBeanPropertyBase concreteBeanPropertyBase) {
        this._metadata = concreteBeanPropertyBase._metadata;
    }
}
