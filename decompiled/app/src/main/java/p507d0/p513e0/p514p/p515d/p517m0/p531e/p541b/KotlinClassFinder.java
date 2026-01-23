package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.KotlinMetadataFinder;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.n, reason: use source file name */
/* JADX INFO: compiled from: KotlinClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface KotlinClassFinder extends KotlinMetadataFinder {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.n$a */
    /* JADX INFO: compiled from: KotlinClassFinder.kt */
    public static abstract class a {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.n$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: KotlinClassFinder.kt */
        public static final class C13316a extends a {
            public final byte[] getContent() {
                return null;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.n$a$b */
        /* JADX INFO: compiled from: KotlinClassFinder.kt */
        public static final class b extends a {

            /* JADX INFO: renamed from: a */
            public final KotlinJvmBinaryClass f23630a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(KotlinJvmBinaryClass kotlinJvmBinaryClass, byte[] bArr) {
                super(null);
                Intrinsics3.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinJvmBinaryClass");
                this.f23630a = kotlinJvmBinaryClass;
            }

            public final KotlinJvmBinaryClass getKotlinJvmBinaryClass() {
                return this.f23630a;
            }

            public /* synthetic */ b(KotlinJvmBinaryClass kotlinJvmBinaryClass, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(kotlinJvmBinaryClass, (i & 2) != 0 ? null : bArr);
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final KotlinJvmBinaryClass toKotlinJvmBinaryClass() {
            b bVar = this instanceof b ? (b) this : null;
            if (bVar == null) {
                return null;
            }
            return bVar.getKotlinJvmBinaryClass();
        }
    }

    a findKotlinClassOrContent(InterfaceC11574g interfaceC11574g);

    a findKotlinClassOrContent(ClassId classId);
}
