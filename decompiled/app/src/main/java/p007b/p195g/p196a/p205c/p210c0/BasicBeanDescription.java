package p007b.p195g.p196a.p205c.p210c0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.BeanDescription;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;

/* compiled from: BasicBeanDescription.java */
/* renamed from: b.g.a.c.c0.q, reason: use source file name */
/* loaded from: classes3.dex */
public class BasicBeanDescription extends BeanDescription {

    /* renamed from: b */
    public static final Class<?>[] f4732b = new Class[0];

    /* renamed from: c */
    public final POJOPropertiesCollector f4733c;

    /* renamed from: d */
    public final MapperConfig<?> f4734d;

    /* renamed from: e */
    public final AnnotationIntrospector f4735e;

    /* renamed from: f */
    public final AnnotatedClass f4736f;

    /* renamed from: g */
    public Class<?>[] f4737g;

    /* renamed from: h */
    public boolean f4738h;

    /* renamed from: i */
    public List<BeanPropertyDefinition> f4739i;

    /* renamed from: j */
    public ObjectIdInfo f4740j;

    public BasicBeanDescription(MapperConfig<?> mapperConfig, JavaType javaType, AnnotatedClass annotatedClass, List<BeanPropertyDefinition> list) {
        super(javaType);
        this.f4733c = null;
        this.f4734d = mapperConfig;
        if (mapperConfig == null) {
            this.f4735e = null;
        } else {
            this.f4735e = mapperConfig.m2267e();
        }
        this.f4736f = annotatedClass;
        this.f4739i = list;
    }

    /* renamed from: e */
    public static BasicBeanDescription m1918e(MapperConfig<?> mapperConfig, JavaType javaType, AnnotatedClass annotatedClass) {
        return new BasicBeanDescription(mapperConfig, javaType, annotatedClass, Collections.emptyList());
    }

    @Override // p007b.p195g.p196a.p205c.BeanDescription
    /* renamed from: a */
    public JsonFormat.d mo1812a(JsonFormat.d dVar) {
        JsonFormat.d dVarMo1784h;
        AnnotationIntrospector annotationIntrospector = this.f4735e;
        if (annotationIntrospector == null || (dVarMo1784h = annotationIntrospector.mo1784h(this.f4736f)) == null) {
            dVarMo1784h = null;
        }
        JsonFormat.d dVarMo2271i = this.f4734d.mo2271i(this.f4736f.f4655l);
        return dVarMo2271i != null ? dVarMo1784h == null ? dVarMo2271i : dVarMo1784h.m1607k(dVarMo2271i) : dVarMo1784h;
    }

    @Override // p007b.p195g.p196a.p205c.BeanDescription
    /* renamed from: b */
    public AnnotatedMember mo1813b() {
        POJOPropertiesCollector pOJOPropertiesCollector = this.f4733c;
        if (pOJOPropertiesCollector == null) {
            return null;
        }
        if (!pOJOPropertiesCollector.f4641i) {
            pOJOPropertiesCollector.m1829h();
        }
        LinkedList<AnnotatedMember> linkedList = pOJOPropertiesCollector.f4650r;
        if (linkedList == null) {
            return null;
        }
        if (linkedList.size() <= 1) {
            return pOJOPropertiesCollector.f4650r.get(0);
        }
        pOJOPropertiesCollector.m1830i("Multiple 'as-value' properties defined (%s vs %s)", pOJOPropertiesCollector.f4650r.get(0), pOJOPropertiesCollector.f4650r.get(1));
        throw null;
    }

    @Override // p007b.p195g.p196a.p205c.BeanDescription
    /* renamed from: c */
    public JsonInclude.b mo1814c(JsonInclude.b bVar) {
        JsonInclude.b bVarMo1802z;
        AnnotationIntrospector annotationIntrospector = this.f4735e;
        return (annotationIntrospector == null || (bVarMo1802z = annotationIntrospector.mo1802z(this.f4736f)) == null) ? bVar : bVar == null ? bVarMo1802z : bVar.m1618a(bVarMo1802z);
    }

    /* renamed from: d */
    public List<BeanPropertyDefinition> m1919d() {
        if (this.f4739i == null) {
            POJOPropertiesCollector pOJOPropertiesCollector = this.f4733c;
            if (!pOJOPropertiesCollector.f4641i) {
                pOJOPropertiesCollector.m1829h();
            }
            this.f4739i = new ArrayList(pOJOPropertiesCollector.f4642j.values());
        }
        return this.f4739i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BasicBeanDescription(POJOPropertiesCollector pOJOPropertiesCollector) {
        JavaType javaType = pOJOPropertiesCollector.f4636d;
        AnnotatedClass annotatedClass = pOJOPropertiesCollector.f4637e;
        super(javaType);
        this.f4733c = pOJOPropertiesCollector;
        MapperConfig<?> mapperConfig = pOJOPropertiesCollector.f4633a;
        this.f4734d = mapperConfig;
        if (mapperConfig == null) {
            this.f4735e = null;
        } else {
            this.f4735e = mapperConfig.m2267e();
        }
        this.f4736f = annotatedClass;
        ObjectIdInfo objectIdInfoMo1794r = pOJOPropertiesCollector.f4639g.mo1794r(pOJOPropertiesCollector.f4637e);
        this.f4740j = objectIdInfoMo1794r != null ? pOJOPropertiesCollector.f4639g.mo1795s(pOJOPropertiesCollector.f4637e, objectIdInfoMo1794r) : objectIdInfoMo1794r;
    }
}
