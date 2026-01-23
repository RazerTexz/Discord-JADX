package p007b.p195g.p196a.p205c.p210c0;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p197a.JsonInclude;
import p007b.p195g.p196a.p197a.JsonSetter;
import p007b.p195g.p196a.p197a.Nulls;
import p007b.p195g.p196a.p205c.AnnotationIntrospector;
import p007b.p195g.p196a.p205c.JavaType;
import p007b.p195g.p196a.p205c.PropertyMetadata;
import p007b.p195g.p196a.p205c.PropertyName;
import p007b.p195g.p196a.p205c.p218h0.TypeFactory;
import p007b.p195g.p196a.p205c.p221z.MapperConfig;

/* JADX INFO: renamed from: b.g.a.c.c0.c0, reason: use source file name */
/* JADX INFO: compiled from: POJOPropertyBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class POJOPropertyBuilder extends BeanPropertyDefinition implements Comparable<POJOPropertyBuilder> {

    /* JADX INFO: renamed from: k */
    public static final AnnotationIntrospector.a f4671k = new AnnotationIntrospector.a(1, "");

    /* JADX INFO: renamed from: l */
    public final boolean f4672l;

    /* JADX INFO: renamed from: m */
    public final MapperConfig<?> f4673m;

    /* JADX INFO: renamed from: n */
    public final AnnotationIntrospector f4674n;

    /* JADX INFO: renamed from: o */
    public final PropertyName f4675o;

    /* JADX INFO: renamed from: p */
    public final PropertyName f4676p;

    /* JADX INFO: renamed from: q */
    public d<AnnotatedField> f4677q;

    /* JADX INFO: renamed from: r */
    public d<AnnotatedParameter> f4678r;

    /* JADX INFO: renamed from: s */
    public d<AnnotatedMethod> f4679s;

    /* JADX INFO: renamed from: t */
    public d<AnnotatedMethod> f4680t;

    /* JADX INFO: renamed from: u */
    public transient PropertyMetadata f4681u;

    /* JADX INFO: renamed from: v */
    public transient AnnotationIntrospector.a f4682v;

    /* JADX INFO: renamed from: b.g.a.c.c0.c0$a */
    /* JADX INFO: compiled from: POJOPropertyBuilder.java */
    public class a implements e<Class<?>[]> {
        public a() {
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.POJOPropertyBuilder.e
        /* JADX INFO: renamed from: a */
        public Class<?>[] mo1869a(AnnotatedMember annotatedMember) {
            return POJOPropertyBuilder.this.f4674n.mo1762R(annotatedMember);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.c0$b */
    /* JADX INFO: compiled from: POJOPropertyBuilder.java */
    public class b implements e<AnnotationIntrospector.a> {
        public b() {
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.POJOPropertyBuilder.e
        /* JADX INFO: renamed from: a */
        public AnnotationIntrospector.a mo1869a(AnnotatedMember annotatedMember) {
            return POJOPropertyBuilder.this.f4674n.mo1748D(annotatedMember);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.c0$c */
    /* JADX INFO: compiled from: POJOPropertyBuilder.java */
    public class c implements e<Boolean> {
        public c() {
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.POJOPropertyBuilder.e
        /* JADX INFO: renamed from: a */
        public Boolean mo1869a(AnnotatedMember annotatedMember) {
            return POJOPropertyBuilder.this.f4674n.mo1778d0(annotatedMember);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.c0$d */
    /* JADX INFO: compiled from: POJOPropertyBuilder.java */
    public static final class d<T> {

        /* JADX INFO: renamed from: a */
        public final T f4686a;

        /* JADX INFO: renamed from: b */
        public final d<T> f4687b;

        /* JADX INFO: renamed from: c */
        public final PropertyName f4688c;

        /* JADX INFO: renamed from: d */
        public final boolean f4689d;

        /* JADX INFO: renamed from: e */
        public final boolean f4690e;

        /* JADX INFO: renamed from: f */
        public final boolean f4691f;

        public d(T t, d<T> dVar, PropertyName propertyName, boolean z2, boolean z3, boolean z4) {
            this.f4686a = t;
            this.f4687b = dVar;
            PropertyName propertyName2 = (propertyName == null || propertyName.m2230d()) ? null : propertyName;
            this.f4688c = propertyName2;
            if (z2) {
                if (propertyName2 == null) {
                    throw new IllegalArgumentException("Cannot pass true for 'explName' if name is null/empty");
                }
                if (!propertyName.m2229c()) {
                    z2 = false;
                }
            }
            this.f4689d = z2;
            this.f4690e = z3;
            this.f4691f = z4;
        }

        /* JADX INFO: renamed from: a */
        public d<T> m1870a(d<T> dVar) {
            d<T> dVar2 = this.f4687b;
            return dVar2 == null ? m1872c(dVar) : m1872c(dVar2.m1870a(dVar));
        }

        /* JADX INFO: renamed from: b */
        public d<T> m1871b() {
            d<T> dVar = this.f4687b;
            if (dVar == null) {
                return this;
            }
            d<T> dVarM1871b = dVar.m1871b();
            if (this.f4688c != null) {
                return dVarM1871b.f4688c == null ? m1872c(null) : m1872c(dVarM1871b);
            }
            if (dVarM1871b.f4688c != null) {
                return dVarM1871b;
            }
            boolean z2 = this.f4690e;
            return z2 == dVarM1871b.f4690e ? m1872c(dVarM1871b) : z2 ? m1872c(null) : dVarM1871b;
        }

        /* JADX INFO: renamed from: c */
        public d<T> m1872c(d<T> dVar) {
            return dVar == this.f4687b ? this : new d<>(this.f4686a, dVar, this.f4688c, this.f4689d, this.f4690e, this.f4691f);
        }

        /* JADX INFO: renamed from: d */
        public d<T> m1873d() {
            d<T> dVarM1873d;
            if (!this.f4691f) {
                d<T> dVar = this.f4687b;
                return (dVar == null || (dVarM1873d = dVar.m1873d()) == this.f4687b) ? this : m1872c(dVarM1873d);
            }
            d<T> dVar2 = this.f4687b;
            if (dVar2 == null) {
                return null;
            }
            return dVar2.m1873d();
        }

        /* JADX INFO: renamed from: e */
        public d<T> m1874e() {
            return this.f4687b == null ? this : new d<>(this.f4686a, null, this.f4688c, this.f4689d, this.f4690e, this.f4691f);
        }

        /* JADX INFO: renamed from: f */
        public d<T> m1875f() {
            d<T> dVar = this.f4687b;
            d<T> dVarM1875f = dVar == null ? null : dVar.m1875f();
            return this.f4690e ? m1872c(dVarM1875f) : dVarM1875f;
        }

        public String toString() {
            String str = String.format("%s[visible=%b,ignore=%b,explicitName=%b]", this.f4686a.toString(), Boolean.valueOf(this.f4690e), Boolean.valueOf(this.f4691f), Boolean.valueOf(this.f4689d));
            if (this.f4687b == null) {
                return str;
            }
            StringBuilder sbM836X = outline.m836X(str, ", ");
            sbM836X.append(this.f4687b.toString());
            return sbM836X.toString();
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.c0$e */
    /* JADX INFO: compiled from: POJOPropertyBuilder.java */
    public interface e<T> {
        /* JADX INFO: renamed from: a */
        T mo1869a(AnnotatedMember annotatedMember);
    }

    public POJOPropertyBuilder(MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector, boolean z2, PropertyName propertyName) {
        this.f4673m = mapperConfig;
        this.f4674n = annotationIntrospector;
        this.f4676p = propertyName;
        this.f4675o = propertyName;
        this.f4672l = z2;
    }

    /* JADX INFO: renamed from: N */
    public static <T> d<T> m1835N(d<T> dVar, d<T> dVar2) {
        if (dVar == null) {
            return dVar2;
        }
        if (dVar2 == null) {
            return dVar;
        }
        d<T> dVar3 = dVar.f4687b;
        return dVar3 == null ? dVar.m1872c(dVar2) : dVar.m1872c(dVar3.m1870a(dVar2));
    }

    /* JADX INFO: renamed from: A */
    public final <T extends AnnotatedMember> d<T> m1836A(d<T> dVar, AnnotationMap annotationMap) {
        AnnotatedMember annotatedMember = (AnnotatedMember) dVar.f4686a.mo1890l(annotationMap);
        d<T> dVar2 = dVar.f4687b;
        if (dVar2 != null) {
            dVar = dVar.m1872c(m1836A(dVar2, annotationMap));
        }
        return annotatedMember == dVar.f4686a ? dVar : new d<>(annotatedMember, dVar.f4687b, dVar.f4688c, dVar.f4689d, dVar.f4690e, dVar.f4691f);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v0 ??, still in use, count: 1, list:
          (r8v0 ?? I:java.lang.Object) from 0x0023: INVOKE (r11v0 ?? I:java.util.Map), (r7v0 ?? I:java.lang.Object), (r8v0 ?? I:java.lang.Object) INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:5)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    /* JADX INFO: renamed from: B */
    public final void m1837B(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v0 ??, still in use, count: 1, list:
          (r8v0 ?? I:java.lang.Object) from 0x0023: INVOKE (r11v0 ?? I:java.util.Map), (r7v0 ?? I:java.lang.Object), (r8v0 ?? I:java.lang.Object) INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:5)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:303)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */

    /* JADX INFO: renamed from: C */
    public final Set<PropertyName> m1838C(d<? extends AnnotatedMember> dVar, Set<PropertyName> set) {
        for (d dVar2 = dVar; dVar2 != null; dVar2 = dVar2.f4687b) {
            if (dVar2.f4689d && dVar2.f4688c != null) {
                if (set == null) {
                    set = new HashSet<>();
                }
                set.add(dVar2.f4688c);
            }
        }
        return set;
    }

    /* JADX INFO: renamed from: D */
    public final <T extends AnnotatedMember> AnnotationMap m1839D(d<T> dVar) {
        AnnotationMap annotationMap = dVar.f4686a.f4717k;
        d<T> dVar2 = dVar.f4687b;
        return dVar2 != null ? AnnotationMap.m1916c(annotationMap, m1839D(dVar2)) : annotationMap;
    }

    /* JADX INFO: renamed from: E */
    public int m1840E(AnnotatedMethod annotatedMethod) {
        String strMo1819c = annotatedMethod.mo1819c();
        if (!strMo1819c.startsWith("get") || strMo1819c.length() <= 3) {
            return (!strMo1819c.startsWith("is") || strMo1819c.length() <= 2) ? 3 : 2;
        }
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: F */
    public final AnnotationMap m1841F(int i, d<? extends AnnotatedMember>... dVarArr) {
        d<? extends AnnotatedMember> dVar = dVarArr[i];
        AnnotationMap annotationMapM1916c = ((AnnotatedMember) dVar.f4686a).f4717k;
        d<? extends AnnotatedMember> dVar2 = dVar.f4687b;
        if (dVar2 != null) {
            annotationMapM1916c = AnnotationMap.m1916c(annotationMapM1916c, m1839D(dVar2));
        }
        do {
            i++;
            if (i >= dVarArr.length) {
                return annotationMapM1916c;
            }
        } while (dVarArr[i] == null);
        return AnnotationMap.m1916c(annotationMapM1916c, m1841F(i, dVarArr));
    }

    /* JADX INFO: renamed from: G */
    public final <T> d<T> m1842G(d<T> dVar) {
        return dVar == null ? dVar : dVar.m1873d();
    }

    /* JADX INFO: renamed from: H */
    public final <T> d<T> m1843H(d<T> dVar) {
        return dVar == null ? dVar : dVar.m1875f();
    }

    /* JADX INFO: renamed from: I */
    public int m1844I(AnnotatedMethod annotatedMethod) {
        String strMo1819c = annotatedMethod.mo1819c();
        return (!strMo1819c.startsWith("set") || strMo1819c.length() <= 3) ? 2 : 1;
    }

    /* JADX INFO: renamed from: J */
    public final <T> d<T> m1845J(d<T> dVar) {
        return dVar == null ? dVar : dVar.m1871b();
    }

    /* JADX INFO: renamed from: K */
    public void m1846K(POJOPropertyBuilder pOJOPropertyBuilder) {
        this.f4677q = m1835N(this.f4677q, pOJOPropertyBuilder.f4677q);
        this.f4678r = m1835N(this.f4678r, pOJOPropertyBuilder.f4678r);
        this.f4679s = m1835N(this.f4679s, pOJOPropertyBuilder.f4679s);
        this.f4680t = m1835N(this.f4680t, pOJOPropertyBuilder.f4680t);
    }

    /* JADX INFO: renamed from: L */
    public Set<PropertyName> m1847L() {
        Set<PropertyName> setM1838C = m1838C(this.f4678r, m1838C(this.f4680t, m1838C(this.f4679s, m1838C(this.f4677q, null))));
        return setM1838C == null ? Collections.emptySet() : setM1838C;
    }

    /* JADX INFO: renamed from: M */
    public <T> T m1848M(e<T> eVar) {
        d<AnnotatedMethod> dVar;
        d<AnnotatedField> dVar2;
        if (this.f4674n == null) {
            return null;
        }
        if (this.f4672l) {
            d<AnnotatedMethod> dVar3 = this.f4679s;
            if (dVar3 != null) {
                tMo1869a = eVar.mo1869a(dVar3.f4686a);
            }
        } else {
            d<AnnotatedParameter> dVar4 = this.f4678r;
            tMo1869a = dVar4 != null ? eVar.mo1869a(dVar4.f4686a) : null;
            if (tMo1869a == null && (dVar = this.f4680t) != null) {
                tMo1869a = eVar.mo1869a(dVar.f4686a);
            }
        }
        return (tMo1869a != null || (dVar2 = this.f4677q) == null) ? tMo1869a : eVar.mo1869a(dVar2.f4686a);
    }

    @Override // java.lang.Comparable
    public int compareTo(POJOPropertyBuilder pOJOPropertyBuilder) {
        POJOPropertyBuilder pOJOPropertyBuilder2 = pOJOPropertyBuilder;
        if (this.f4678r != null) {
            if (pOJOPropertyBuilder2.f4678r == null) {
                return -1;
            }
        } else if (pOJOPropertyBuilder2.f4678r != null) {
            return 1;
        }
        return mo1858p().compareTo(pOJOPropertyBuilder2.mo1858p());
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: f */
    public boolean mo1849f() {
        return (this.f4678r == null && this.f4680t == null && this.f4677q == null) ? false : true;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: g */
    public JsonInclude.b mo1850g() {
        AnnotatedMember annotatedMemberM1922j = m1922j();
        AnnotationIntrospector annotationIntrospector = this.f4674n;
        JsonInclude.b bVarMo1802z = annotationIntrospector == null ? null : annotationIntrospector.mo1802z(annotatedMemberM1922j);
        if (bVarMo1802z != null) {
            return bVarMo1802z;
        }
        JsonInclude.b bVar = JsonInclude.b.f4436j;
        return JsonInclude.b.f4436j;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: h */
    public AnnotationIntrospector.a mo1851h() {
        AnnotationIntrospector.a aVar = this.f4682v;
        if (aVar != null) {
            if (aVar == f4671k) {
                return null;
            }
            return aVar;
        }
        AnnotationIntrospector.a aVar2 = (AnnotationIntrospector.a) m1848M(new b());
        this.f4682v = aVar2 == null ? f4671k : aVar2;
        return aVar2;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: i */
    public Class<?>[] mo1852i() {
        return (Class[]) m1848M(new a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: k */
    public AnnotatedParameter mo1853k() {
        d dVar = this.f4678r;
        if (dVar == null) {
            return null;
        }
        do {
            T t = dVar.f4686a;
            if (((AnnotatedParameter) t)._owner instanceof AnnotatedConstructor) {
                return (AnnotatedParameter) t;
            }
            dVar = dVar.f4687b;
        } while (dVar != null);
        return this.f4678r.f4686a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: l */
    public AnnotatedField mo1854l() {
        d<AnnotatedField> dVar = this.f4677q;
        if (dVar == null) {
            return null;
        }
        AnnotatedField annotatedField = dVar.f4686a;
        for (d dVar2 = dVar.f4687b; dVar2 != null; dVar2 = dVar2.f4687b) {
            AnnotatedField annotatedField2 = (AnnotatedField) dVar2.f4686a;
            Class<?> clsMo1887g = annotatedField.mo1887g();
            Class<?> clsMo1887g2 = annotatedField2.mo1887g();
            if (clsMo1887g != clsMo1887g2) {
                if (clsMo1887g.isAssignableFrom(clsMo1887g2)) {
                    annotatedField = annotatedField2;
                } else if (clsMo1887g2.isAssignableFrom(clsMo1887g)) {
                }
            }
            StringBuilder sbM833U = outline.m833U("Multiple fields representing property \"");
            sbM833U.append(mo1858p());
            sbM833U.append("\": ");
            sbM833U.append(annotatedField.mo1903h());
            sbM833U.append(" vs ");
            sbM833U.append(annotatedField2.mo1903h());
            throw new IllegalArgumentException(sbM833U.toString());
        }
        return annotatedField;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: m */
    public PropertyName mo1855m() {
        return this.f4675o;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AnnotatedMethod mo1856n() {
        d dVar = this.f4679s;
        if (dVar == null) {
            return null;
        }
        d dVar2 = dVar.f4687b;
        if (dVar2 == null) {
            return (AnnotatedMethod) dVar.f4686a;
        }
        while (dVar2 != null) {
            Class<?> clsMo1887g = ((AnnotatedMethod) dVar.f4686a).mo1887g();
            Class<?> clsMo1887g2 = ((AnnotatedMethod) dVar2.f4686a).mo1887g();
            if (clsMo1887g == clsMo1887g2) {
                int iM1840E = m1840E((AnnotatedMethod) dVar2.f4686a);
                int iM1840E2 = m1840E((AnnotatedMethod) dVar.f4686a);
                if (iM1840E == iM1840E2) {
                    StringBuilder sbM833U = outline.m833U("Conflicting getter definitions for property \"");
                    sbM833U.append(mo1858p());
                    sbM833U.append("\": ");
                    sbM833U.append(((AnnotatedMethod) dVar.f4686a).mo1903h());
                    sbM833U.append(" vs ");
                    sbM833U.append(((AnnotatedMethod) dVar2.f4686a).mo1903h());
                    throw new IllegalArgumentException(sbM833U.toString());
                }
                if (iM1840E < iM1840E2) {
                    dVar = dVar2;
                }
            } else if (!clsMo1887g.isAssignableFrom(clsMo1887g2)) {
                if (clsMo1887g2.isAssignableFrom(clsMo1887g)) {
                    continue;
                }
            }
            dVar2 = dVar2.f4687b;
        }
        this.f4679s = dVar.m1874e();
        return (AnnotatedMethod) dVar.f4686a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0104  */
    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PropertyMetadata mo1857o() {
        AnnotatedMethod annotatedMethod;
        Nulls nullsM1620a;
        boolean z2;
        Boolean boolMo1789m;
        if (this.f4681u == null) {
            Nulls nullsM1621b = null;
            if (this.f4672l) {
                d<AnnotatedMethod> dVar = this.f4679s;
                if (dVar != null) {
                    annotatedMethod = dVar.f4686a;
                } else {
                    d<AnnotatedField> dVar2 = this.f4677q;
                    annotatedMethod = dVar2 != null ? dVar2.f4686a : null;
                }
                if (annotatedMethod != null) {
                    this.f4681u = PropertyMetadata.f5027l;
                } else {
                    Boolean boolMo1772a0 = this.f4674n.mo1772a0(annotatedMethod);
                    String strMo1799w = this.f4674n.mo1799w(annotatedMethod);
                    Integer numMo1746B = this.f4674n.mo1746B(annotatedMethod);
                    String strMo1798v = this.f4674n.mo1798v(annotatedMethod);
                    if (boolMo1772a0 == null && numMo1746B == null && strMo1798v == null) {
                        PropertyMetadata propertyMetadata = PropertyMetadata.f5027l;
                        if (strMo1799w != null) {
                            propertyMetadata = new PropertyMetadata(propertyMetadata._required, strMo1799w, propertyMetadata._index, propertyMetadata._defaultValue, propertyMetadata.f5028m, propertyMetadata._valueNulls, propertyMetadata._contentNulls);
                        }
                        this.f4681u = propertyMetadata;
                    } else {
                        PropertyMetadata propertyMetadata2 = PropertyMetadata.f5025j;
                        this.f4681u = (strMo1799w == null && numMo1746B == null && strMo1798v == null) ? boolMo1772a0 == null ? PropertyMetadata.f5027l : boolMo1772a0.booleanValue() ? PropertyMetadata.f5025j : PropertyMetadata.f5026k : new PropertyMetadata(boolMo1772a0, strMo1799w, numMo1746B, strMo1798v, null, null, null);
                    }
                    if (!this.f4672l) {
                        PropertyMetadata propertyMetadataM2226a = this.f4681u;
                        AnnotatedMember annotatedMemberM1922j = m1922j();
                        AnnotationIntrospector annotationIntrospector = this.f4674n;
                        if (annotationIntrospector != null) {
                            if (annotatedMemberM1922j == null || (boolMo1789m = annotationIntrospector.mo1789m(annotatedMethod)) == null) {
                                z2 = true;
                            } else {
                                if (boolMo1789m.booleanValue()) {
                                    propertyMetadataM2226a = propertyMetadataM2226a.m2226a(new PropertyMetadata.a(annotatedMemberM1922j, false));
                                }
                                z2 = false;
                            }
                            JsonSetter.a aVarMo1757M = this.f4674n.mo1757M(annotatedMethod);
                            if (aVarMo1757M != null) {
                                nullsM1621b = aVarMo1757M.m1621b();
                                nullsM1620a = aVarMo1757M.m1620a();
                            } else {
                                nullsM1620a = null;
                            }
                        } else {
                            nullsM1620a = null;
                            z2 = true;
                        }
                        if (z2 || nullsM1621b == null || nullsM1620a == null) {
                            if (annotatedMethod instanceof AnnotatedMethod) {
                                AnnotatedMethod annotatedMethod2 = (AnnotatedMethod) annotatedMethod;
                                Class<?> cls = annotatedMethod2.m1905o() > 0 ? annotatedMethod2.mo1891n(0)._class : annotatedMethod.mo1821e()._class;
                                Objects.requireNonNull(this.f4673m.mo2268f(cls));
                            }
                        }
                        if (z2 || nullsM1621b == null || nullsM1620a == null) {
                            JsonSetter.a aVarMo2274l = this.f4673m.mo2274l();
                            if (nullsM1621b == null) {
                                nullsM1621b = aVarMo2274l.m1621b();
                            }
                            if (nullsM1620a == null) {
                                nullsM1620a = aVarMo2274l.m1620a();
                            }
                            if (z2) {
                                if (Boolean.TRUE.equals(this.f4673m.mo2270h()) && annotatedMemberM1922j != null) {
                                    propertyMetadataM2226a = propertyMetadataM2226a.m2226a(new PropertyMetadata.a(annotatedMemberM1922j, true));
                                }
                            }
                        }
                        Nulls nulls = nullsM1621b;
                        Nulls nulls2 = nullsM1620a;
                        if (nulls != null || nulls2 != null) {
                            propertyMetadataM2226a = new PropertyMetadata(propertyMetadataM2226a._required, propertyMetadataM2226a._description, propertyMetadataM2226a._index, propertyMetadataM2226a._defaultValue, propertyMetadataM2226a.f5028m, nulls, nulls2);
                        }
                        this.f4681u = propertyMetadataM2226a;
                    }
                }
            } else {
                d<AnnotatedParameter> dVar3 = this.f4678r;
                if (dVar3 != null) {
                    annotatedMethod = dVar3.f4686a;
                } else {
                    d<AnnotatedMethod> dVar4 = this.f4680t;
                    if (dVar4 != null) {
                        annotatedMethod = dVar4.f4686a;
                    } else {
                        d<AnnotatedField> dVar5 = this.f4677q;
                        if (dVar5 != null) {
                            annotatedMethod = dVar5.f4686a;
                        } else {
                            d<AnnotatedMethod> dVar6 = this.f4679s;
                            if (dVar6 != null) {
                                annotatedMethod = dVar6.f4686a;
                            }
                        }
                    }
                }
                if (annotatedMethod != null) {
                }
            }
        }
        return this.f4681u;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: p */
    public String mo1858p() {
        PropertyName propertyName = this.f4675o;
        if (propertyName == null) {
            return null;
        }
        return propertyName._simpleName;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: q */
    public AnnotatedMember mo1859q() {
        if (this.f4672l) {
            return m1922j();
        }
        AnnotatedMember annotatedMemberMo1853k = mo1853k();
        if (annotatedMemberMo1853k == null && (annotatedMemberMo1853k = mo1861s()) == null) {
            annotatedMemberMo1853k = mo1854l();
        }
        return annotatedMemberMo1853k == null ? m1922j() : annotatedMemberMo1853k;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d A[PHI: r0
      0x003d: PHI (r0v3 b.g.a.c.c0.b) = (r0v2 b.g.a.c.c0.b), (r0v5 b.g.a.c.c0.b) binds: [B:16:0x0030, B:18:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Class<?> mo1860r() {
        JavaType javaTypeMo1821e;
        if (this.f4672l) {
            Annotated annotatedMo1856n = mo1856n();
            javaTypeMo1821e = (annotatedMo1856n == null && (annotatedMo1856n = mo1854l()) == null) ? TypeFactory.m2158k() : annotatedMo1856n.mo1821e();
        } else {
            Annotated annotatedMo1853k = mo1853k();
            if (annotatedMo1853k != null) {
                javaTypeMo1821e = (annotatedMo1853k == null || (annotatedMo1853k = mo1856n()) != null) ? annotatedMo1853k.mo1821e() : TypeFactory.m2158k();
            } else {
                AnnotatedMethod annotatedMethodMo1861s = mo1861s();
                if (annotatedMethodMo1861s != null) {
                    javaTypeMo1821e = annotatedMethodMo1861s.mo1891n(0);
                } else {
                    annotatedMo1853k = mo1854l();
                    if (annotatedMo1853k == null) {
                    }
                }
            }
        }
        return javaTypeMo1821e._class;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AnnotatedMethod mo1861s() {
        d dVar = this.f4680t;
        if (dVar == null) {
            return null;
        }
        d dVar2 = dVar.f4687b;
        if (dVar2 == null) {
            return (AnnotatedMethod) dVar.f4686a;
        }
        while (dVar2 != null) {
            Class<?> clsMo1887g = ((AnnotatedMethod) dVar.f4686a).mo1887g();
            Class<?> clsMo1887g2 = ((AnnotatedMethod) dVar2.f4686a).mo1887g();
            if (clsMo1887g == clsMo1887g2) {
                AnnotatedMethod annotatedMethod = (AnnotatedMethod) dVar2.f4686a;
                AnnotatedMethod annotatedMethod2 = (AnnotatedMethod) dVar.f4686a;
                int iM1844I = m1844I(annotatedMethod);
                int iM1844I2 = m1844I(annotatedMethod2);
                if (iM1844I == iM1844I2) {
                    AnnotationIntrospector annotationIntrospector = this.f4674n;
                    if (annotationIntrospector != null) {
                        AnnotatedMethod annotatedMethodMo1782f0 = annotationIntrospector.mo1782f0(this.f4673m, annotatedMethod2, annotatedMethod);
                        if (annotatedMethodMo1782f0 != annotatedMethod2) {
                            if (annotatedMethodMo1782f0 != annotatedMethod) {
                            }
                            dVar = dVar2;
                        } else {
                            continue;
                        }
                    }
                    throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s vs %s", mo1858p(), ((AnnotatedMethod) dVar.f4686a).mo1903h(), ((AnnotatedMethod) dVar2.f4686a).mo1903h()));
                }
                if (iM1844I < iM1844I2) {
                    dVar = dVar2;
                }
            } else if (!clsMo1887g.isAssignableFrom(clsMo1887g2)) {
                if (clsMo1887g2.isAssignableFrom(clsMo1887g)) {
                    continue;
                }
            }
            dVar2 = dVar2.f4687b;
        }
        this.f4680t = dVar.m1874e();
        return (AnnotatedMethod) dVar.f4686a;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: t */
    public PropertyName mo1862t() {
        AnnotationIntrospector annotationIntrospector;
        if (mo1859q() == null || (annotationIntrospector = this.f4674n) == null) {
            return null;
        }
        Objects.requireNonNull(annotationIntrospector);
        return null;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("[Property '");
        sbM833U.append(this.f4675o);
        sbM833U.append("'; ctors: ");
        sbM833U.append(this.f4678r);
        sbM833U.append(", field(s): ");
        sbM833U.append(this.f4677q);
        sbM833U.append(", getter(s): ");
        sbM833U.append(this.f4679s);
        sbM833U.append(", setter(s): ");
        sbM833U.append(this.f4680t);
        sbM833U.append("]");
        return sbM833U.toString();
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: u */
    public boolean mo1863u() {
        return m1866x(this.f4677q) || m1866x(this.f4679s) || m1866x(this.f4680t) || m1865w(this.f4678r);
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.BeanPropertyDefinition
    /* JADX INFO: renamed from: v */
    public boolean mo1864v() {
        Boolean bool = (Boolean) m1848M(new c());
        return bool != null && bool.booleanValue();
    }

    /* JADX INFO: renamed from: w */
    public final <T> boolean m1865w(d<T> dVar) {
        while (dVar != null) {
            if (dVar.f4688c != null && dVar.f4689d) {
                return true;
            }
            dVar = dVar.f4687b;
        }
        return false;
    }

    /* JADX INFO: renamed from: x */
    public final <T> boolean m1866x(d<T> dVar) {
        while (dVar != null) {
            PropertyName propertyName = dVar.f4688c;
            if (propertyName != null && propertyName.m2229c()) {
                return true;
            }
            dVar = dVar.f4687b;
        }
        return false;
    }

    /* JADX INFO: renamed from: y */
    public final <T> boolean m1867y(d<T> dVar) {
        while (dVar != null) {
            if (dVar.f4691f) {
                return true;
            }
            dVar = dVar.f4687b;
        }
        return false;
    }

    /* JADX INFO: renamed from: z */
    public final <T> boolean m1868z(d<T> dVar) {
        while (dVar != null) {
            if (dVar.f4690e) {
                return true;
            }
            dVar = dVar.f4687b;
        }
        return false;
    }

    public POJOPropertyBuilder(MapperConfig<?> mapperConfig, AnnotationIntrospector annotationIntrospector, boolean z2, PropertyName propertyName, PropertyName propertyName2) {
        this.f4673m = mapperConfig;
        this.f4674n = annotationIntrospector;
        this.f4676p = propertyName;
        this.f4675o = propertyName2;
        this.f4672l = z2;
    }

    public POJOPropertyBuilder(POJOPropertyBuilder pOJOPropertyBuilder, PropertyName propertyName) {
        this.f4673m = pOJOPropertyBuilder.f4673m;
        this.f4674n = pOJOPropertyBuilder.f4674n;
        this.f4676p = pOJOPropertyBuilder.f4676p;
        this.f4675o = propertyName;
        this.f4677q = pOJOPropertyBuilder.f4677q;
        this.f4678r = pOJOPropertyBuilder.f4678r;
        this.f4679s = pOJOPropertyBuilder.f4679s;
        this.f4680t = pOJOPropertyBuilder.f4680t;
        this.f4672l = pOJOPropertyBuilder.f4672l;
    }
}
