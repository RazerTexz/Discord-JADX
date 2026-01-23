package p007b.p195g.p196a.p205c.p219i0;

import java.util.Objects;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.PropertyMetadata;
import p007b.p195g.p196a.p205c.PropertyName;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedField;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMethod;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedParameter;
import p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;

/* JADX INFO: renamed from: b.g.a.c.i0.q, reason: use source file name */
/* JADX INFO: compiled from: SimpleBeanPropertyDefinition.java */
/* JADX INFO: loaded from: classes3.dex */
public class SimpleBeanPropertyDefinition extends BeanPropertyDefinition {

    /* JADX INFO: renamed from: k */
    public final AnnotationIntrospector f4963k;

    /* JADX INFO: renamed from: l */
    public final AnnotatedMember f4964l;

    /* JADX INFO: renamed from: m */
    public final PropertyMetadata f4965m;

    /* JADX INFO: renamed from: n */
    public final PropertyName f4966n;

    /* JADX INFO: renamed from: o */
    public final JsonInclude.b f4967o;

    public SimpleBeanPropertyDefinition(AnnotationIntrospector annotationIntrospector, AnnotatedMember annotatedMember, PropertyName propertyName, PropertyMetadata propertyMetadata, JsonInclude.b bVar) {
        this.f4963k = annotationIntrospector;
        this.f4964l = annotatedMember;
        this.f4966n = propertyName;
        this.f4965m = propertyMetadata == null ? PropertyMetadata.f5026k : propertyMetadata;
        this.f4967o = bVar;
    }

    /* JADX INFO: renamed from: w */
    public static SimpleBeanPropertyDefinition m2203w(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, PropertyName propertyName, PropertyMetadata propertyMetadata, JsonInclude.a aVar) {
        JsonInclude.a aVar2;
        return new SimpleBeanPropertyDefinition(mapperConfig.m2267e(), annotatedMember, propertyName, propertyMetadata, (aVar == null || aVar == (aVar2 = JsonInclude.a.USE_DEFAULTS)) ? BeanPropertyDefinition.f4747j : aVar != aVar2 ? new JsonInclude.b(aVar, null, null, null) : JsonInclude.b.f4436j);
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: g */
    public JsonInclude.b mo1850g() {
        return this.f4967o;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: k */
    public AnnotatedParameter mo1853k() {
        AnnotatedMember annotatedMember = this.f4964l;
        if (annotatedMember instanceof AnnotatedParameter) {
            return (AnnotatedParameter) annotatedMember;
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: l */
    public AnnotatedField mo1854l() {
        AnnotatedMember annotatedMember = this.f4964l;
        if (annotatedMember instanceof AnnotatedField) {
            return (AnnotatedField) annotatedMember;
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: m */
    public PropertyName mo1855m() {
        return this.f4966n;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: n */
    public AnnotatedMethod mo1856n() {
        AnnotatedMember annotatedMember = this.f4964l;
        if ((annotatedMember instanceof AnnotatedMethod) && ((AnnotatedMethod) annotatedMember).m1905o() == 0) {
            return (AnnotatedMethod) this.f4964l;
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: o */
    public PropertyMetadata mo1857o() {
        return this.f4965m;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: p */
    public String mo1858p() {
        return this.f4966n._simpleName;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: q */
    public AnnotatedMember mo1859q() {
        return this.f4964l;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: r */
    public Class<?> mo1860r() {
        AnnotatedMember annotatedMember = this.f4964l;
        return annotatedMember == null ? Object.class : annotatedMember.mo1820d();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: s */
    public AnnotatedMethod mo1861s() {
        AnnotatedMember annotatedMember = this.f4964l;
        if ((annotatedMember instanceof AnnotatedMethod) && ((AnnotatedMethod) annotatedMember).m1905o() == 1) {
            return (AnnotatedMethod) this.f4964l;
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: t */
    public PropertyName mo1862t() {
        AnnotationIntrospector annotationIntrospector = this.f4963k;
        if (annotationIntrospector != null && this.f4964l != null) {
            Objects.requireNonNull(annotationIntrospector);
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: u */
    public boolean mo1863u() {
        return false;
    }
}
