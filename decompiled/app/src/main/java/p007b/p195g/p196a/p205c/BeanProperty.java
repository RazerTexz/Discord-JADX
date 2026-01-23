package p007b.p195g.p196a.p205c;

import java.io.Serializable;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;

/* JADX INFO: renamed from: b.g.a.c.d, reason: use source file name */
/* JADX INFO: compiled from: BeanProperty.java */
/* JADX INFO: loaded from: classes3.dex */
public interface BeanProperty {

    /* JADX INFO: renamed from: c */
    public static final JsonFormat.d f4765c = new JsonFormat.d("", JsonFormat.c.ANY, "", "", JsonFormat.b.f4406a, null);

    /* JADX INFO: renamed from: b.g.a.c.d$a */
    /* JADX INFO: compiled from: BeanProperty.java */
    public static class a implements BeanProperty, Serializable {
        private static final long serialVersionUID = 1;
        public final AnnotatedMember _member;
        public final PropertyMetadata _metadata;
        public final PropertyName _name;
        public final JavaType _type;
        public final PropertyName _wrapperName;

        public a(PropertyName propertyName, JavaType javaType, PropertyName propertyName2, AnnotatedMember annotatedMember, PropertyMetadata propertyMetadata) {
            this._name = propertyName;
            this._type = javaType;
            this._wrapperName = propertyName2;
            this._metadata = propertyMetadata;
            this._member = annotatedMember;
        }

        @Override // p007b.p195g.p196a.p205c.BeanProperty
        /* JADX INFO: renamed from: a */
        public JsonFormat.d mo1928a(MapperConfig<?> mapperConfig, Class<?> cls) {
            AnnotatedMember annotatedMember;
            JsonFormat.d dVarMo1784h;
            JsonFormat.d dVarMo2271i = mapperConfig.mo2271i(cls);
            AnnotationIntrospector annotationIntrospectorM2267e = mapperConfig.m2267e();
            return (annotationIntrospectorM2267e == null || (annotatedMember = this._member) == null || (dVarMo1784h = annotationIntrospectorM2267e.mo1784h(annotatedMember)) == null) ? dVarMo2271i : dVarMo2271i.m1607k(dVarMo1784h);
        }

        @Override // p007b.p195g.p196a.p205c.BeanProperty
        /* JADX INFO: renamed from: b */
        public JsonInclude.b mo1929b(MapperConfig<?> mapperConfig, Class<?> cls) {
            AnnotatedMember annotatedMember;
            JsonInclude.b bVarMo1802z;
            JsonInclude.b bVarMo2269g = mapperConfig.mo2269g(cls, this._type._class);
            AnnotationIntrospector annotationIntrospectorM2267e = mapperConfig.m2267e();
            return (annotationIntrospectorM2267e == null || (annotatedMember = this._member) == null || (bVarMo1802z = annotationIntrospectorM2267e.mo1802z(annotatedMember)) == null) ? bVarMo2269g : bVarMo2269g.m1618a(bVarMo1802z);
        }

        @Override // p007b.p195g.p196a.p205c.BeanProperty
        public AnnotatedMember getMember() {
            return this._member;
        }

        @Override // p007b.p195g.p196a.p205c.BeanProperty
        public JavaType getType() {
            return this._type;
        }
    }

    static {
        JsonInclude.b bVar = JsonInclude.b.f4436j;
        JsonInclude.b bVar2 = JsonInclude.b.f4436j;
    }

    /* JADX INFO: renamed from: a */
    JsonFormat.d mo1928a(MapperConfig<?> mapperConfig, Class<?> cls);

    /* JADX INFO: renamed from: b */
    JsonInclude.b mo1929b(MapperConfig<?> mapperConfig, Class<?> cls);

    AnnotatedMember getMember();

    JavaType getType();
}
