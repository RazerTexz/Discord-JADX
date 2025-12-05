package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: descriptorBasedTypeSignatureMapping.kt */
/* renamed from: d0.e0.p.d.m0.e.b.x, reason: use source file name */
/* loaded from: classes3.dex */
public interface descriptorBasedTypeSignatureMapping2<T> {

    /* compiled from: descriptorBasedTypeSignatureMapping.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.x$a */
    public static final class a {
        public static <T> String getPredefinedFullInternalNameForClass(descriptorBasedTypeSignatureMapping2<? extends T> descriptorbasedtypesignaturemapping2, ClassDescriptor classDescriptor) {
            Intrinsics3.checkNotNullParameter(descriptorbasedtypesignaturemapping2, "this");
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            return null;
        }

        public static <T> KotlinType preprocessType(descriptorBasedTypeSignatureMapping2<? extends T> descriptorbasedtypesignaturemapping2, KotlinType kotlinType) {
            Intrinsics3.checkNotNullParameter(descriptorbasedtypesignaturemapping2, "this");
            Intrinsics3.checkNotNullParameter(kotlinType, "kotlinType");
            return null;
        }

        public static <T> boolean releaseCoroutines(descriptorBasedTypeSignatureMapping2<? extends T> descriptorbasedtypesignaturemapping2) {
            Intrinsics3.checkNotNullParameter(descriptorbasedtypesignaturemapping2, "this");
            return true;
        }
    }

    KotlinType commonSupertype(Collection<KotlinType> collection);

    String getPredefinedFullInternalNameForClass(ClassDescriptor classDescriptor);

    String getPredefinedInternalNameForClass(ClassDescriptor classDescriptor);

    T getPredefinedTypeForClass(ClassDescriptor classDescriptor);

    KotlinType preprocessType(KotlinType kotlinType);

    void processErrorType(KotlinType kotlinType, ClassDescriptor classDescriptor);

    boolean releaseCoroutines();
}
