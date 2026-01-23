package p007b.p195g.p196a.p205c.p215g0;

import com.fasterxml.jackson.databind.JsonMappingException;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.BeanDescription;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.SerializationConfig;
import p007b.p195g.p196a.p205c.p210c0.Annotated;
import p007b.p195g.p196a.p205c.p220y.JsonSerialize;

/* JADX INFO: renamed from: b.g.a.c.g0.l, reason: use source file name */
/* JADX INFO: compiled from: PropertyBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class PropertyBuilder {

    /* JADX INFO: renamed from: a */
    public final SerializationConfig f4809a;

    /* JADX INFO: renamed from: b */
    public final BeanDescription f4810b;

    /* JADX INFO: renamed from: c */
    public final AnnotationIntrospector f4811c;

    /* JADX INFO: renamed from: d */
    public Object f4812d;

    /* JADX INFO: renamed from: e */
    public final JsonInclude.b f4813e;

    /* JADX INFO: renamed from: f */
    public final boolean f4814f;

    public PropertyBuilder(SerializationConfig serializationConfig, BeanDescription beanDescription) {
        this.f4809a = serializationConfig;
        this.f4810b = beanDescription;
        JsonInclude.b bVar = JsonInclude.b.f4436j;
        JsonInclude.b bVarM1618a = JsonInclude.b.f4436j;
        JsonInclude.b bVarMo1814c = beanDescription.mo1814c(bVarM1618a);
        serializationConfig.m2273k(beanDescription.f4626a._class, bVarM1618a);
        bVarM1618a = bVarMo1814c != null ? bVarMo1814c.m1618a(bVarM1618a) : bVarM1618a;
        JsonInclude.b bVar2 = serializationConfig._configOverrides._defaultInclusion;
        this.f4813e = bVar2 == null ? bVarM1618a : bVar2.m1618a(bVarM1618a);
        this.f4814f = bVarM1618a._valueInclusion == JsonInclude.a.NON_DEFAULT;
        this.f4811c = serializationConfig.m2267e();
    }

    /* JADX INFO: renamed from: a */
    public JavaType m2006a(Annotated annotated, boolean z2, JavaType javaType) throws JsonMappingException {
        JavaType javaTypeMo1780e0 = this.f4811c.mo1780e0(this.f4809a, annotated, javaType);
        if (javaTypeMo1780e0 != javaType) {
            Class<?> cls = javaTypeMo1780e0._class;
            Class<?> cls2 = javaType._class;
            if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
                StringBuilder sbM833U = outline.m833U("Illegal concrete-type annotation for method '");
                sbM833U.append(annotated.mo1819c());
                sbM833U.append("': class ");
                sbM833U.append(cls.getName());
                sbM833U.append(" not a super-type of (declared) class ");
                sbM833U.append(cls2.getName());
                throw new IllegalArgumentException(sbM833U.toString());
            }
            z2 = true;
            javaType = javaTypeMo1780e0;
        }
        JsonSerialize.b bVarMo1755K = this.f4811c.mo1755K(annotated);
        if (bVarMo1755K != null && bVarMo1755K != JsonSerialize.b.DEFAULT_TYPING) {
            z2 = bVarMo1755K == JsonSerialize.b.STATIC;
        }
        if (z2) {
            return javaType.mo2096G();
        }
        return null;
    }
}
