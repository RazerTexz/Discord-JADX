package d0.e0.p.d.m0.e.b.b0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.e.a.a0;
import d0.e0.p.d.m0.e.b.b0.a;
import d0.e0.p.d.m0.e.b.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
/* loaded from: classes3.dex */
public class b implements p.c {
    public static final boolean a = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));

    /* renamed from: b, reason: collision with root package name */
    public static final Map<d0.e0.p.d.m0.g.a, a.EnumC0533a> f3368b;
    public int[] c = null;
    public d0.e0.p.d.m0.f.a0.b.c d = null;
    public String e = null;
    public int f = 0;
    public String g = null;
    public String[] h = null;
    public String[] i = null;
    public String[] j = null;
    public a.EnumC0533a k = null;

    /* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
    /* renamed from: d0.e0.p.d.m0.e.b.b0.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0535b implements p.b {
        public final List<String> a = new ArrayList();

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "enumEntryName";
            } else if (i != 2) {
                objArr[0] = "enumClassId";
            } else {
                objArr[0] = "classLiteralValue";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (i != 2) {
                objArr[2] = "visitEnum";
            } else {
                objArr[2] = "visitClassLiteral";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public abstract void b(String[] strArr);

        @Override // d0.e0.p.d.m0.e.b.p.b
        public void visit(Object obj) {
            if (obj instanceof String) {
                this.a.add((String) obj);
            }
        }

        @Override // d0.e0.p.d.m0.e.b.p.b
        public void visitClassLiteral(d0.e0.p.d.m0.k.v.f fVar) {
            if (fVar != null) {
                return;
            }
            a(2);
            throw null;
        }

        @Override // d0.e0.p.d.m0.e.b.p.b
        public void visitEnd() {
            b((String[]) this.a.toArray(new String[0]));
        }

        @Override // d0.e0.p.d.m0.e.b.p.b
        public void visitEnum(d0.e0.p.d.m0.g.a aVar, d0.e0.p.d.m0.g.e eVar) {
            if (aVar == null) {
                a(0);
                throw null;
            }
            if (eVar != null) {
                return;
            }
            a(1);
            throw null;
        }
    }

    /* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
    public class c implements p.a {
        public c(a aVar) {
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i == 7) {
                objArr[0] = "classId";
            } else if (i == 4) {
                objArr[0] = "enumClassId";
            } else if (i != 5) {
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            switch (i) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.e.b.p.a
        public void visit(d0.e0.p.d.m0.g.e eVar, Object obj) {
            if (eVar == null) {
                return;
            }
            String strAsString = eVar.asString();
            if ("k".equals(strAsString)) {
                if (obj instanceof Integer) {
                    b.this.k = a.EnumC0533a.getById(((Integer) obj).intValue());
                    return;
                }
                return;
            }
            if ("mv".equals(strAsString)) {
                if (obj instanceof int[]) {
                    b.this.c = (int[]) obj;
                    return;
                }
                return;
            }
            if ("bv".equals(strAsString)) {
                if (obj instanceof int[]) {
                    b.this.d = new d0.e0.p.d.m0.f.a0.b.c((int[]) obj);
                    return;
                }
                return;
            }
            if ("xs".equals(strAsString)) {
                if (obj instanceof String) {
                    b.this.e = (String) obj;
                    return;
                }
                return;
            }
            if ("xi".equals(strAsString)) {
                if (obj instanceof Integer) {
                    b.this.f = ((Integer) obj).intValue();
                    return;
                }
                return;
            }
            if ("pn".equals(strAsString) && (obj instanceof String)) {
                b.this.g = (String) obj;
            }
        }

        @Override // d0.e0.p.d.m0.e.b.p.a
        public p.a visitAnnotation(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.g.a aVar) {
            if (eVar == null) {
                a(6);
                throw null;
            }
            if (aVar != null) {
                return null;
            }
            a(7);
            throw null;
        }

        @Override // d0.e0.p.d.m0.e.b.p.a
        public p.b visitArray(d0.e0.p.d.m0.g.e eVar) {
            if (eVar == null) {
                a(2);
                throw null;
            }
            String strAsString = eVar.asString();
            if ("d1".equals(strAsString)) {
                return new d0.e0.p.d.m0.e.b.b0.c(this);
            }
            if ("d2".equals(strAsString)) {
                return new d0.e0.p.d.m0.e.b.b0.d(this);
            }
            return null;
        }

        @Override // d0.e0.p.d.m0.e.b.p.a
        public void visitClassLiteral(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.k.v.f fVar) {
            if (eVar == null) {
                a(0);
                throw null;
            }
            if (fVar != null) {
                return;
            }
            a(1);
            throw null;
        }

        @Override // d0.e0.p.d.m0.e.b.p.a
        public void visitEnd() {
        }

        @Override // d0.e0.p.d.m0.e.b.p.a
        public void visitEnum(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.g.a aVar, d0.e0.p.d.m0.g.e eVar2) {
            if (eVar == null) {
                a(3);
                throw null;
            }
            if (aVar == null) {
                a(4);
                throw null;
            }
            if (eVar2 != null) {
                return;
            }
            a(5);
            throw null;
        }
    }

    /* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
    public class d implements p.a {
        public d(a aVar) {
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i == 7) {
                objArr[0] = "classId";
            } else if (i == 4) {
                objArr[0] = "enumClassId";
            } else if (i != 5) {
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            switch (i) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.e.b.p.a
        public void visit(d0.e0.p.d.m0.g.e eVar, Object obj) {
            if (eVar == null) {
                return;
            }
            String strAsString = eVar.asString();
            if (!"version".equals(strAsString)) {
                if ("multifileClassName".equals(strAsString)) {
                    b.this.e = obj instanceof String ? (String) obj : null;
                    return;
                }
                return;
            }
            if (obj instanceof int[]) {
                b bVar = b.this;
                int[] iArr = (int[]) obj;
                bVar.c = iArr;
                if (bVar.d == null) {
                    bVar.d = new d0.e0.p.d.m0.f.a0.b.c(iArr);
                }
            }
        }

        @Override // d0.e0.p.d.m0.e.b.p.a
        public p.a visitAnnotation(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.g.a aVar) {
            if (eVar == null) {
                a(6);
                throw null;
            }
            if (aVar != null) {
                return null;
            }
            a(7);
            throw null;
        }

        @Override // d0.e0.p.d.m0.e.b.p.a
        public p.b visitArray(d0.e0.p.d.m0.g.e eVar) {
            if (eVar == null) {
                a(2);
                throw null;
            }
            String strAsString = eVar.asString();
            if ("data".equals(strAsString) || "filePartClassNames".equals(strAsString)) {
                return new e(this);
            }
            if ("strings".equals(strAsString)) {
                return new f(this);
            }
            return null;
        }

        @Override // d0.e0.p.d.m0.e.b.p.a
        public void visitClassLiteral(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.k.v.f fVar) {
            if (eVar == null) {
                a(0);
                throw null;
            }
            if (fVar != null) {
                return;
            }
            a(1);
            throw null;
        }

        @Override // d0.e0.p.d.m0.e.b.p.a
        public void visitEnd() {
        }

        @Override // d0.e0.p.d.m0.e.b.p.a
        public void visitEnum(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.g.a aVar, d0.e0.p.d.m0.g.e eVar2) {
            if (eVar == null) {
                a(3);
                throw null;
            }
            if (aVar == null) {
                a(4);
                throw null;
            }
            if (eVar2 != null) {
                return;
            }
            a(5);
            throw null;
        }
    }

    static {
        HashMap map = new HashMap();
        f3368b = map;
        map.put(d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b("kotlin.jvm.internal.KotlinClass")), a.EnumC0533a.CLASS);
        map.put(d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b("kotlin.jvm.internal.KotlinFileFacade")), a.EnumC0533a.FILE_FACADE);
        map.put(d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b("kotlin.jvm.internal.KotlinMultifileClass")), a.EnumC0533a.MULTIFILE_CLASS);
        map.put(d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b("kotlin.jvm.internal.KotlinMultifileClassPart")), a.EnumC0533a.MULTIFILE_CLASS_PART);
        map.put(d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b("kotlin.jvm.internal.KotlinSyntheticClass")), a.EnumC0533a.SYNTHETIC_CLASS);
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i != 1) {
            objArr[0] = "classId";
        } else {
            objArr[0] = "source";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        objArr[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public d0.e0.p.d.m0.e.b.b0.a createHeader() {
        if (this.k == null || this.c == null) {
            return null;
        }
        boolean z2 = true;
        d0.e0.p.d.m0.f.a0.b.f fVar = new d0.e0.p.d.m0.f.a0.b.f(this.c, (this.f & 8) != 0);
        if (fVar.isCompatible()) {
            a.EnumC0533a enumC0533a = this.k;
            if (enumC0533a != a.EnumC0533a.CLASS && enumC0533a != a.EnumC0533a.FILE_FACADE && enumC0533a != a.EnumC0533a.MULTIFILE_CLASS_PART) {
                z2 = false;
            }
            if (z2 && this.h == null) {
                return null;
            }
        } else {
            this.j = this.h;
            this.h = null;
        }
        a.EnumC0533a enumC0533a2 = this.k;
        d0.e0.p.d.m0.f.a0.b.c cVar = this.d;
        if (cVar == null) {
            cVar = d0.e0.p.d.m0.f.a0.b.c.f;
        }
        return new d0.e0.p.d.m0.e.b.b0.a(enumC0533a2, fVar, cVar, this.h, this.j, this.i, this.e, this.f, this.g);
    }

    @Override // d0.e0.p.d.m0.e.b.p.c
    public p.a visitAnnotation(d0.e0.p.d.m0.g.a aVar, u0 u0Var) {
        a.EnumC0533a enumC0533a;
        if (aVar == null) {
            a(0);
            throw null;
        }
        if (u0Var == null) {
            a(1);
            throw null;
        }
        if (aVar.asSingleFqName().equals(a0.a)) {
            return new c(null);
        }
        if (a || this.k != null || (enumC0533a = f3368b.get(aVar)) == null) {
            return null;
        }
        this.k = enumC0533a;
        return new d(null);
    }

    @Override // d0.e0.p.d.m0.e.b.p.c
    public void visitEnd() {
    }
}
