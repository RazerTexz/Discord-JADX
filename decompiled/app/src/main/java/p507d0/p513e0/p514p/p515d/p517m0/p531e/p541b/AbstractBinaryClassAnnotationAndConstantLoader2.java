package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.MemberSignature;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.ConstantValueFactory;
import p507d0.p579g0.Strings4;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* renamed from: d0.e0.p.d.m0.e.b.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class AbstractBinaryClassAnnotationAndConstantLoader2 implements KotlinJvmBinaryClass.d {

    /* renamed from: a */
    public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> f23543a;

    /* renamed from: b */
    public final /* synthetic */ HashMap<MemberSignature, List<A>> f23544b;

    /* renamed from: c */
    public final /* synthetic */ HashMap<MemberSignature, C> f23545c;

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.b$a */
    public final class a extends b implements KotlinJvmBinaryClass.e {

        /* renamed from: d */
        public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader2 f23546d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbstractBinaryClassAnnotationAndConstantLoader2 abstractBinaryClassAnnotationAndConstantLoader2, MemberSignature memberSignature) {
            super(abstractBinaryClassAnnotationAndConstantLoader2, memberSignature);
            Intrinsics3.checkNotNullParameter(abstractBinaryClassAnnotationAndConstantLoader2, "this$0");
            Intrinsics3.checkNotNullParameter(memberSignature, "signature");
            this.f23546d = abstractBinaryClassAnnotationAndConstantLoader2;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.e
        public KotlinJvmBinaryClass.a visitParameterAnnotation(int i, ClassId classId, SourceElement sourceElement) {
            Intrinsics3.checkNotNullParameter(classId, "classId");
            Intrinsics3.checkNotNullParameter(sourceElement, "source");
            MemberSignature memberSignatureFromMethodSignatureAndParameterIndex = MemberSignature.f23633a.fromMethodSignatureAndParameterIndex(this.f23547a, i);
            List arrayList = (List) this.f23546d.f23544b.get(memberSignatureFromMethodSignatureAndParameterIndex);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f23546d.f23544b.put(memberSignatureFromMethodSignatureAndParameterIndex, arrayList);
            }
            return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.f23546d.f23543a, classId, sourceElement, arrayList);
        }
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.b$b */
    public class b implements KotlinJvmBinaryClass.c {

        /* renamed from: a */
        public final MemberSignature f23547a;

        /* renamed from: b */
        public final ArrayList<A> f23548b;

        /* renamed from: c */
        public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader2 f23549c;

        public b(AbstractBinaryClassAnnotationAndConstantLoader2 abstractBinaryClassAnnotationAndConstantLoader2, MemberSignature memberSignature) {
            Intrinsics3.checkNotNullParameter(abstractBinaryClassAnnotationAndConstantLoader2, "this$0");
            Intrinsics3.checkNotNullParameter(memberSignature, "signature");
            this.f23549c = abstractBinaryClassAnnotationAndConstantLoader2;
            this.f23547a = memberSignature;
            this.f23548b = new ArrayList<>();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.c
        public KotlinJvmBinaryClass.a visitAnnotation(ClassId classId, SourceElement sourceElement) {
            Intrinsics3.checkNotNullParameter(classId, "classId");
            Intrinsics3.checkNotNullParameter(sourceElement, "source");
            return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.f23549c.f23543a, classId, sourceElement, this.f23548b);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.c
        public void visitEnd() {
            if (!this.f23548b.isEmpty()) {
                this.f23549c.f23544b.put(this.f23547a, this.f23548b);
            }
        }
    }

    public AbstractBinaryClassAnnotationAndConstantLoader2(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader, HashMap<MemberSignature, List<A>> map, HashMap<MemberSignature, C> map2) {
        this.f23543a = abstractBinaryClassAnnotationAndConstantLoader;
        this.f23544b = map;
        this.f23545c = map2;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.d
    public KotlinJvmBinaryClass.c visitField(Name name, String str, Object obj) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str, "desc");
        MemberSignature.a aVar = MemberSignature.f23633a;
        String strAsString = name.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "name.asString()");
        MemberSignature memberSignatureFromFieldNameAndDesc = aVar.fromFieldNameAndDesc(strAsString, str);
        if (obj != null) {
            Objects.requireNonNull((BinaryClassAnnotationAndConstantLoaderImpl) this.f23543a);
            Intrinsics3.checkNotNullParameter(str, "desc");
            Intrinsics3.checkNotNullParameter(obj, "initializer");
            if (Strings4.contains$default((CharSequence) "ZBCS", (CharSequence) str, false, 2, (Object) null)) {
                int iIntValue = ((Integer) obj).intValue();
                int iHashCode = str.hashCode();
                if (iHashCode == 66) {
                    if (str.equals("B")) {
                        obj = Byte.valueOf((byte) iIntValue);
                    }
                    throw new AssertionError(str);
                }
                if (iHashCode == 67) {
                    if (str.equals("C")) {
                        obj = Character.valueOf((char) iIntValue);
                    }
                    throw new AssertionError(str);
                }
                if (iHashCode == 83) {
                    if (str.equals(ExifInterface.LATITUDE_SOUTH)) {
                        obj = Short.valueOf((short) iIntValue);
                    }
                    throw new AssertionError(str);
                }
                if (iHashCode == 90 && str.equals("Z")) {
                    obj = Boolean.valueOf(iIntValue != 0);
                }
                throw new AssertionError(str);
            }
            AbstractC11815g<?> abstractC11815gCreateConstantValue = ConstantValueFactory.f24439a.createConstantValue(obj);
            if (abstractC11815gCreateConstantValue != null) {
                this.f23545c.put(memberSignatureFromFieldNameAndDesc, abstractC11815gCreateConstantValue);
            }
        }
        return new b(this, memberSignatureFromFieldNameAndDesc);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.KotlinJvmBinaryClass.d
    public KotlinJvmBinaryClass.e visitMethod(Name name, String str) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str, "desc");
        MemberSignature.a aVar = MemberSignature.f23633a;
        String strAsString = name.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "name.asString()");
        return new a(this, aVar.fromMethodNameAndDesc(strAsString, str));
    }
}
