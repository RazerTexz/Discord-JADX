package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JvmAnnotationNames;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.KotlinClassHeader;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmBytecodeBinaryVersion;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmMetadataVersion;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.ClassLiteralValue;

/* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
/* renamed from: d0.e0.p.d.m0.e.b.b0.b, reason: use source file name */
/* loaded from: classes3.dex */
public class ReadKotlinClassHeaderAnnotationVisitor implements KotlinJvmBinaryClass.c {

    /* renamed from: a */
    public static final boolean f23567a = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));

    /* renamed from: b */
    public static final Map<ClassId, KotlinClassHeader.a> f23568b;

    /* renamed from: c */
    public int[] f23569c = null;

    /* renamed from: d */
    public JvmBytecodeBinaryVersion f23570d = null;

    /* renamed from: e */
    public String f23571e = null;

    /* renamed from: f */
    public int f23572f = 0;

    /* renamed from: g */
    public String f23573g = null;

    /* renamed from: h */
    public String[] f23574h = null;

    /* renamed from: i */
    public String[] f23575i = null;

    /* renamed from: j */
    public String[] f23576j = null;

    /* renamed from: k */
    public KotlinClassHeader.a f23577k = null;

    /* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
    /* renamed from: d0.e0.p.d.m0.e.b.b0.b$b */
    public static abstract class b implements KotlinJvmBinaryClass.b {

        /* renamed from: a */
        public final List<String> f23578a = new ArrayList();

        /* renamed from: a */
        public static /* synthetic */ void m9540a(int i) {
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

        /* renamed from: b */
        public abstract void mo9541b(String[] strArr);

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.b
        public void visit(Object obj) {
            if (obj instanceof String) {
                this.f23578a.add((String) obj);
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.b
        public void visitClassLiteral(ClassLiteralValue classLiteralValue) {
            if (classLiteralValue != null) {
                return;
            }
            m9540a(2);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.b
        public void visitEnd() {
            mo9541b((String[]) this.f23578a.toArray(new String[0]));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.b
        public void visitEnum(ClassId classId, Name name) {
            if (classId == null) {
                m9540a(0);
                throw null;
            }
            if (name != null) {
                return;
            }
            m9540a(1);
            throw null;
        }
    }

    /* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
    /* renamed from: d0.e0.p.d.m0.e.b.b0.b$c */
    public class c implements KotlinJvmBinaryClass.a {
        public c(a aVar) {
        }

        /* renamed from: a */
        public static /* synthetic */ void m9542a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
        public void visit(Name name, Object obj) {
            if (name == null) {
                return;
            }
            String strAsString = name.asString();
            if ("k".equals(strAsString)) {
                if (obj instanceof Integer) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.f23577k = KotlinClassHeader.a.getById(((Integer) obj).intValue());
                    return;
                }
                return;
            }
            if ("mv".equals(strAsString)) {
                if (obj instanceof int[]) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.f23569c = (int[]) obj;
                    return;
                }
                return;
            }
            if ("bv".equals(strAsString)) {
                if (obj instanceof int[]) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.f23570d = new JvmBytecodeBinaryVersion((int[]) obj);
                    return;
                }
                return;
            }
            if ("xs".equals(strAsString)) {
                if (obj instanceof String) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.f23571e = (String) obj;
                    return;
                }
                return;
            }
            if ("xi".equals(strAsString)) {
                if (obj instanceof Integer) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.f23572f = ((Integer) obj).intValue();
                    return;
                }
                return;
            }
            if ("pn".equals(strAsString) && (obj instanceof String)) {
                ReadKotlinClassHeaderAnnotationVisitor.this.f23573g = (String) obj;
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
        public KotlinJvmBinaryClass.a visitAnnotation(Name name, ClassId classId) {
            if (name == null) {
                m9542a(6);
                throw null;
            }
            if (classId != null) {
                return null;
            }
            m9542a(7);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
        public KotlinJvmBinaryClass.b visitArray(Name name) {
            if (name == null) {
                m9542a(2);
                throw null;
            }
            String strAsString = name.asString();
            if ("d1".equals(strAsString)) {
                return new ReadKotlinClassHeaderAnnotationVisitor2(this);
            }
            if ("d2".equals(strAsString)) {
                return new ReadKotlinClassHeaderAnnotationVisitor3(this);
            }
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
        public void visitClassLiteral(Name name, ClassLiteralValue classLiteralValue) {
            if (name == null) {
                m9542a(0);
                throw null;
            }
            if (classLiteralValue != null) {
                return;
            }
            m9542a(1);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
        public void visitEnd() {
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
        public void visitEnum(Name name, ClassId classId, Name name2) {
            if (name == null) {
                m9542a(3);
                throw null;
            }
            if (classId == null) {
                m9542a(4);
                throw null;
            }
            if (name2 != null) {
                return;
            }
            m9542a(5);
            throw null;
        }
    }

    /* compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
    /* renamed from: d0.e0.p.d.m0.e.b.b0.b$d */
    public class d implements KotlinJvmBinaryClass.a {
        public d(a aVar) {
        }

        /* renamed from: a */
        public static /* synthetic */ void m9543a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
        public void visit(Name name, Object obj) {
            if (name == null) {
                return;
            }
            String strAsString = name.asString();
            if (!"version".equals(strAsString)) {
                if ("multifileClassName".equals(strAsString)) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.f23571e = obj instanceof String ? (String) obj : null;
                    return;
                }
                return;
            }
            if (obj instanceof int[]) {
                ReadKotlinClassHeaderAnnotationVisitor readKotlinClassHeaderAnnotationVisitor = ReadKotlinClassHeaderAnnotationVisitor.this;
                int[] iArr = (int[]) obj;
                readKotlinClassHeaderAnnotationVisitor.f23569c = iArr;
                if (readKotlinClassHeaderAnnotationVisitor.f23570d == null) {
                    readKotlinClassHeaderAnnotationVisitor.f23570d = new JvmBytecodeBinaryVersion(iArr);
                }
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
        public KotlinJvmBinaryClass.a visitAnnotation(Name name, ClassId classId) {
            if (name == null) {
                m9543a(6);
                throw null;
            }
            if (classId != null) {
                return null;
            }
            m9543a(7);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
        public KotlinJvmBinaryClass.b visitArray(Name name) {
            if (name == null) {
                m9543a(2);
                throw null;
            }
            String strAsString = name.asString();
            if ("data".equals(strAsString) || "filePartClassNames".equals(strAsString)) {
                return new ReadKotlinClassHeaderAnnotationVisitor4(this);
            }
            if ("strings".equals(strAsString)) {
                return new ReadKotlinClassHeaderAnnotationVisitor5(this);
            }
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
        public void visitClassLiteral(Name name, ClassLiteralValue classLiteralValue) {
            if (name == null) {
                m9543a(0);
                throw null;
            }
            if (classLiteralValue != null) {
                return;
            }
            m9543a(1);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
        public void visitEnd() {
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.a
        public void visitEnum(Name name, ClassId classId, Name name2) {
            if (name == null) {
                m9543a(3);
                throw null;
            }
            if (classId == null) {
                m9543a(4);
                throw null;
            }
            if (name2 != null) {
                return;
            }
            m9543a(5);
            throw null;
        }
    }

    static {
        HashMap map = new HashMap();
        f23568b = map;
        map.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader.a.CLASS);
        map.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader.a.FILE_FACADE);
        map.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader.a.MULTIFILE_CLASS);
        map.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader.a.MULTIFILE_CLASS_PART);
        map.put(ClassId.topLevel(new FqName("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader.a.SYNTHETIC_CLASS);
    }

    /* renamed from: a */
    public static /* synthetic */ void m9539a(int i) {
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

    public KotlinClassHeader createHeader() {
        if (this.f23577k == null || this.f23569c == null) {
            return null;
        }
        boolean z2 = true;
        JvmMetadataVersion jvmMetadataVersion = new JvmMetadataVersion(this.f23569c, (this.f23572f & 8) != 0);
        if (jvmMetadataVersion.isCompatible()) {
            KotlinClassHeader.a aVar = this.f23577k;
            if (aVar != KotlinClassHeader.a.CLASS && aVar != KotlinClassHeader.a.FILE_FACADE && aVar != KotlinClassHeader.a.MULTIFILE_CLASS_PART) {
                z2 = false;
            }
            if (z2 && this.f23574h == null) {
                return null;
            }
        } else {
            this.f23576j = this.f23574h;
            this.f23574h = null;
        }
        KotlinClassHeader.a aVar2 = this.f23577k;
        JvmBytecodeBinaryVersion jvmBytecodeBinaryVersion = this.f23570d;
        if (jvmBytecodeBinaryVersion == null) {
            jvmBytecodeBinaryVersion = JvmBytecodeBinaryVersion.f23703f;
        }
        return new KotlinClassHeader(aVar2, jvmMetadataVersion, jvmBytecodeBinaryVersion, this.f23574h, this.f23576j, this.f23575i, this.f23571e, this.f23572f, this.f23573g);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.c
    public KotlinJvmBinaryClass.a visitAnnotation(ClassId classId, SourceElement sourceElement) {
        KotlinClassHeader.a aVar;
        if (classId == null) {
            m9539a(0);
            throw null;
        }
        if (sourceElement == null) {
            m9539a(1);
            throw null;
        }
        if (classId.asSingleFqName().equals(JvmAnnotationNames.f23147a)) {
            return new c(null);
        }
        if (f23567a || this.f23577k != null || (aVar = f23568b.get(classId)) == null) {
            return null;
        }
        this.f23577k = aVar;
        return new d(null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.c
    public void visitEnd() {
    }
}
