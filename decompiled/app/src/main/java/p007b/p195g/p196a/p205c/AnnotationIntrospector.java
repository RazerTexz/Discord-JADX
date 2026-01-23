package p007b.p195g.p196a.p205c;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import p007b.p195g.p196a.p197a.JacksonInject;
import p007b.p195g.p196a.p197a.JsonCreator;
import p007b.p195g.p196a.p197a.JsonFormat;
import p007b.p195g.p196a.p197a.JsonIgnoreProperties;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p197a.JsonIncludeProperties;
import p007b.p195g.p196a.p197a.JsonProperty;
import p007b.p195g.p196a.p197a.JsonSetter;
import p007b.p195g.p196a.p205c.p210c0.Annotated;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedClass;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedField;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMember;
import p007b.p195g.p196a.p205c.p210c0.AnnotatedMethod;
import p007b.p195g.p196a.p205c.p210c0.ObjectIdInfo;
import p007b.p195g.p196a.p205c.p210c0.VisibilityChecker;
import p007b.p195g.p196a.p205c.p212e0.NamedType;
import p007b.p195g.p196a.p205c.p212e0.TypeResolverBuilder;
import p007b.p195g.p196a.p205c.p215g0.BeanPropertyWriter;
import p007b.p195g.p196a.p205c.p219i0.NameTransformer4;
import p007b.p195g.p196a.p205c.p220y.JsonSerialize;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;

/* JADX INFO: renamed from: b.g.a.c.b, reason: use source file name */
/* JADX INFO: compiled from: AnnotationIntrospector.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AnnotationIntrospector implements Serializable {

    /* JADX INFO: renamed from: b.g.a.c.b$a */
    /* JADX INFO: compiled from: AnnotationIntrospector.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        public final int f4619a;

        public a(int i, String str) {
            this.f4619a = i;
        }
    }

    /* JADX INFO: renamed from: A */
    public JsonIncludeProperties.a mo1745A(MapperConfig<?> mapperConfig, Annotated annotated) {
        return JsonIncludeProperties.a.f4437j;
    }

    /* JADX INFO: renamed from: B */
    public Integer mo1746B(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: C */
    public TypeResolverBuilder<?> mo1747C(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return null;
    }

    /* JADX INFO: renamed from: D */
    public a mo1748D(AnnotatedMember annotatedMember) {
        return null;
    }

    /* JADX INFO: renamed from: E */
    public PropertyName mo1749E(MapperConfig<?> mapperConfig, AnnotatedField annotatedField, PropertyName propertyName) {
        return null;
    }

    /* JADX INFO: renamed from: F */
    public PropertyName mo1750F(AnnotatedClass annotatedClass) {
        return null;
    }

    /* JADX INFO: renamed from: G */
    public Object mo1751G(AnnotatedMember annotatedMember) {
        return null;
    }

    /* JADX INFO: renamed from: H */
    public Object mo1752H(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: I */
    public String[] mo1753I(AnnotatedClass annotatedClass) {
        return null;
    }

    /* JADX INFO: renamed from: J */
    public Boolean mo1754J(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: K */
    public JsonSerialize.b mo1755K(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: L */
    public Object mo1756L(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: M */
    public JsonSetter.a mo1757M(Annotated annotated) {
        return JsonSetter.a.f4443j;
    }

    /* JADX INFO: renamed from: N */
    public List<NamedType> mo1758N(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: O */
    public String mo1759O(AnnotatedClass annotatedClass) {
        return null;
    }

    /* JADX INFO: renamed from: P */
    public TypeResolverBuilder<?> mo1760P(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, JavaType javaType) {
        return null;
    }

    /* JADX INFO: renamed from: Q */
    public NameTransformer4 mo1761Q(AnnotatedMember annotatedMember) {
        return null;
    }

    /* JADX INFO: renamed from: R */
    public Class<?>[] mo1762R(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: S */
    public Boolean mo1763S(Annotated annotated) {
        if ((annotated instanceof AnnotatedMethod) && mo1764T((AnnotatedMethod) annotated)) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Deprecated
    /* JADX INFO: renamed from: T */
    public boolean mo1764T(AnnotatedMethod annotatedMethod) {
        return false;
    }

    /* JADX INFO: renamed from: U */
    public Boolean mo1765U(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: V */
    public Boolean mo1766V(MapperConfig<?> mapperConfig, Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: W */
    public Boolean mo1767W(Annotated annotated) {
        if ((annotated instanceof AnnotatedMethod) && mo1768X((AnnotatedMethod) annotated)) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Deprecated
    /* JADX INFO: renamed from: X */
    public boolean mo1768X(AnnotatedMethod annotatedMethod) {
        return false;
    }

    @Deprecated
    /* JADX INFO: renamed from: Y */
    public boolean mo1769Y(Annotated annotated) {
        return false;
    }

    /* JADX INFO: renamed from: Z */
    public boolean mo1770Z(AnnotatedMember annotatedMember) {
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void mo1771a(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, List<BeanPropertyWriter> list) {
    }

    /* JADX INFO: renamed from: a0 */
    public Boolean mo1772a0(AnnotatedMember annotatedMember) {
        return null;
    }

    /* JADX INFO: renamed from: b */
    public VisibilityChecker<?> mo1773b(AnnotatedClass annotatedClass, VisibilityChecker<?> visibilityChecker) {
        return visibilityChecker;
    }

    /* JADX INFO: renamed from: b0 */
    public boolean mo1774b0(Annotation annotation) {
        return false;
    }

    /* JADX INFO: renamed from: c */
    public Object mo1775c(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: c0 */
    public Boolean mo1776c0(AnnotatedClass annotatedClass) {
        return null;
    }

    /* JADX INFO: renamed from: d */
    public JsonCreator.a mo1777d(MapperConfig<?> mapperConfig, Annotated annotated) {
        if (!mo1769Y(annotated)) {
            return null;
        }
        JsonCreator.a aVarMo1779e = mo1779e(annotated);
        return aVarMo1779e == null ? JsonCreator.a.DEFAULT : aVarMo1779e;
    }

    /* JADX INFO: renamed from: d0 */
    public Boolean mo1778d0(AnnotatedMember annotatedMember) {
        return null;
    }

    @Deprecated
    /* JADX INFO: renamed from: e */
    public JsonCreator.a mo1779e(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: e0 */
    public JavaType mo1780e0(MapperConfig<?> mapperConfig, Annotated annotated, JavaType javaType) throws JsonMappingException {
        return javaType;
    }

    /* JADX INFO: renamed from: f */
    public String[] mo1781f(Class<?> cls, Enum<?>[] enumArr, String[] strArr) {
        return strArr;
    }

    /* JADX INFO: renamed from: f0 */
    public AnnotatedMethod mo1782f0(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, AnnotatedMethod annotatedMethod2) {
        return null;
    }

    /* JADX INFO: renamed from: g */
    public Object mo1783g(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: h */
    public JsonFormat.d mo1784h(Annotated annotated) {
        return JsonFormat.d.f4421j;
    }

    /* JADX INFO: renamed from: i */
    public String mo1785i(AnnotatedMember annotatedMember) {
        return null;
    }

    /* JADX INFO: renamed from: j */
    public JacksonInject.a mo1786j(AnnotatedMember annotatedMember) {
        Object objMo1787k = mo1787k(annotatedMember);
        if (objMo1787k != null) {
            return JacksonInject.a.m1593a(objMo1787k, null);
        }
        return null;
    }

    @Deprecated
    /* JADX INFO: renamed from: k */
    public Object mo1787k(AnnotatedMember annotatedMember) {
        return null;
    }

    /* JADX INFO: renamed from: l */
    public Object mo1788l(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: m */
    public Boolean mo1789m(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: n */
    public PropertyName mo1790n(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: o */
    public PropertyName mo1791o(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: p */
    public Object mo1792p(AnnotatedClass annotatedClass) {
        return null;
    }

    /* JADX INFO: renamed from: q */
    public Object mo1793q(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: r */
    public ObjectIdInfo mo1794r(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: s */
    public ObjectIdInfo mo1795s(Annotated annotated, ObjectIdInfo objectIdInfo) {
        return objectIdInfo;
    }

    /* JADX INFO: renamed from: t */
    public JsonProperty.a mo1796t(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: u */
    public TypeResolverBuilder<?> mo1797u(MapperConfig<?> mapperConfig, AnnotatedMember annotatedMember, JavaType javaType) {
        return null;
    }

    /* JADX INFO: renamed from: v */
    public String mo1798v(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: w */
    public String mo1799w(Annotated annotated) {
        return null;
    }

    /* JADX INFO: renamed from: x */
    public JsonIgnoreProperties.a mo1800x(MapperConfig<?> mapperConfig, Annotated annotated) {
        return mo1801y(annotated);
    }

    @Deprecated
    /* JADX INFO: renamed from: y */
    public JsonIgnoreProperties.a mo1801y(Annotated annotated) {
        return JsonIgnoreProperties.a.f4427j;
    }

    /* JADX INFO: renamed from: z */
    public JsonInclude.b mo1802z(Annotated annotated) {
        JsonInclude.b bVar = JsonInclude.b.f4436j;
        return JsonInclude.b.f4436j;
    }
}
