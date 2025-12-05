package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: JavaClassFinder.kt */
/* renamed from: d0.e0.p.d.m0.e.a.s, reason: use source file name */
/* loaded from: classes3.dex */
public interface JavaClassFinder {
    InterfaceC11574g findClass(a aVar);

    InterfaceC11588u findPackage(FqName fqName);

    Set<String> knownClassNamesInPackage(FqName fqName);

    /* compiled from: JavaClassFinder.kt */
    /* renamed from: d0.e0.p.d.m0.e.a.s$a */
    public static final class a {

        /* renamed from: a */
        public final ClassId f23518a;

        /* renamed from: b */
        public final byte[] f23519b;

        /* renamed from: c */
        public final InterfaceC11574g f23520c;

        public a(ClassId classId, byte[] bArr, InterfaceC11574g interfaceC11574g) {
            Intrinsics3.checkNotNullParameter(classId, "classId");
            this.f23518a = classId;
            this.f23519b = bArr;
            this.f23520c = interfaceC11574g;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics3.areEqual(this.f23518a, aVar.f23518a) && Intrinsics3.areEqual(this.f23519b, aVar.f23519b) && Intrinsics3.areEqual(this.f23520c, aVar.f23520c);
        }

        public final ClassId getClassId() {
            return this.f23518a;
        }

        public int hashCode() {
            int iHashCode = this.f23518a.hashCode() * 31;
            byte[] bArr = this.f23519b;
            int iHashCode2 = (iHashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            InterfaceC11574g interfaceC11574g = this.f23520c;
            return iHashCode2 + (interfaceC11574g != null ? interfaceC11574g.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Request(classId=");
            sbM833U.append(this.f23518a);
            sbM833U.append(", previouslyFoundClassFileContent=");
            sbM833U.append(Arrays.toString(this.f23519b));
            sbM833U.append(", outerClass=");
            sbM833U.append(this.f23520c);
            sbM833U.append(')');
            return sbM833U.toString();
        }

        public /* synthetic */ a(ClassId classId, byte[] bArr, InterfaceC11574g interfaceC11574g, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(classId, (i & 2) != 0 ? null : bArr, (i & 4) != 0 ? null : interfaceC11574g);
        }
    }
}
