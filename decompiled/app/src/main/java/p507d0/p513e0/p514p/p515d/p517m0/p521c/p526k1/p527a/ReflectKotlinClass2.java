package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import com.discord.widgets.chat.input.MentionUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.reflectClassUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.KotlinClassHeader;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.ReadKotlinClassHeaderAnnotationVisitor;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ReflectKotlinClass.kt */
/* renamed from: d0.e0.p.d.m0.c.k1.a.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class ReflectKotlinClass2 implements KotlinJvmBinaryClass {

    /* renamed from: a */
    public static final a f23015a = new a(null);

    /* renamed from: b */
    public final Class<?> f23016b;

    /* renamed from: c */
    public final KotlinClassHeader f23017c;

    /* compiled from: ReflectKotlinClass.kt */
    /* renamed from: d0.e0.p.d.m0.c.k1.a.f$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final ReflectKotlinClass2 create(Class<?> cls) {
            Intrinsics3.checkNotNullParameter(cls, "klass");
            ReadKotlinClassHeaderAnnotationVisitor readKotlinClassHeaderAnnotationVisitor = new ReadKotlinClassHeaderAnnotationVisitor();
            ReflectKotlinClass.f23013a.loadClassAnnotations(cls, readKotlinClassHeaderAnnotationVisitor);
            KotlinClassHeader kotlinClassHeaderCreateHeader = readKotlinClassHeaderAnnotationVisitor.createHeader();
            if (kotlinClassHeaderCreateHeader == null) {
                return null;
            }
            return new ReflectKotlinClass2(cls, kotlinClassHeaderCreateHeader, null);
        }
    }

    public ReflectKotlinClass2(Class cls, KotlinClassHeader kotlinClassHeader, DefaultConstructorMarker defaultConstructorMarker) {
        this.f23016b = cls;
        this.f23017c = kotlinClassHeader;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectKotlinClass2) && Intrinsics3.areEqual(this.f23016b, ((ReflectKotlinClass2) obj).f23016b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass
    public KotlinClassHeader getClassHeader() {
        return this.f23017c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass
    public ClassId getClassId() {
        return reflectClassUtil.getClassId(this.f23016b);
    }

    public final Class<?> getKlass() {
        return this.f23016b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass
    public String getLocation() {
        String name = this.f23016b.getName();
        Intrinsics3.checkNotNullExpressionValue(name, "klass.name");
        return Intrinsics3.stringPlus(StringsJVM.replace$default(name, '.', MentionUtils.SLASH_CHAR, false, 4, (Object) null), ".class");
    }

    public int hashCode() {
        return this.f23016b.hashCode();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass
    public void loadClassAnnotations(KotlinJvmBinaryClass.c cVar, byte[] bArr) {
        Intrinsics3.checkNotNullParameter(cVar, "visitor");
        ReflectKotlinClass.f23013a.loadClassAnnotations(this.f23016b, cVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        outline.m860k0(ReflectKotlinClass2.class, sb, ": ");
        sb.append(this.f23016b);
        return sb.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass
    public void visitMembers(KotlinJvmBinaryClass.d dVar, byte[] bArr) {
        Intrinsics3.checkNotNullParameter(dVar, "visitor");
        ReflectKotlinClass.f23013a.visitMembers(this.f23016b, dVar);
    }
}
