package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibility2;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.EnumC11685j;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.EnumC11699x;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.a0, reason: use source file name */
/* JADX INFO: compiled from: ProtoEnumFlagsUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ProtoEnumFlagsUtils {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.a0$a */
    /* JADX INFO: compiled from: ProtoEnumFlagsUtils.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f24495a;

        /* JADX INFO: renamed from: b */
        public static final /* synthetic */ int[] f24496b;

        static {
            EnumC11685j.values();
            f24495a = new int[]{1, 2, 3, 4};
            CallableMemberDescriptor.a.values();
            EnumC11699x.values();
            f24496b = new int[]{1, 2, 4, 5, 3, 6};
        }
    }

    public static final DescriptorVisibility2 descriptorVisibility(ProtoEnumFlags protoEnumFlags, EnumC11699x enumC11699x) {
        Intrinsics3.checkNotNullParameter(protoEnumFlags, "<this>");
        switch (enumC11699x == null ? -1 : a.f24496b[enumC11699x.ordinal()]) {
            case 1:
                DescriptorVisibility2 descriptorVisibility2 = DescriptorVisibilities.f23086d;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility2, "INTERNAL");
                return descriptorVisibility2;
            case 2:
                DescriptorVisibility2 descriptorVisibility22 = DescriptorVisibilities.f23083a;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility22, "PRIVATE");
                return descriptorVisibility22;
            case 3:
                DescriptorVisibility2 descriptorVisibility23 = DescriptorVisibilities.f23084b;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility23, "PRIVATE_TO_THIS");
                return descriptorVisibility23;
            case 4:
                DescriptorVisibility2 descriptorVisibility24 = DescriptorVisibilities.f23085c;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility24, "PROTECTED");
                return descriptorVisibility24;
            case 5:
                DescriptorVisibility2 descriptorVisibility25 = DescriptorVisibilities.f23087e;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility25, "PUBLIC");
                return descriptorVisibility25;
            case 6:
                DescriptorVisibility2 descriptorVisibility26 = DescriptorVisibilities.f23088f;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility26, "LOCAL");
                return descriptorVisibility26;
            default:
                DescriptorVisibility2 descriptorVisibility27 = DescriptorVisibilities.f23083a;
                Intrinsics3.checkNotNullExpressionValue(descriptorVisibility27, "PRIVATE");
                return descriptorVisibility27;
        }
    }

    public static final CallableMemberDescriptor.a memberKind(ProtoEnumFlags protoEnumFlags, EnumC11685j enumC11685j) {
        CallableMemberDescriptor.a aVar = CallableMemberDescriptor.a.DECLARATION;
        Intrinsics3.checkNotNullParameter(protoEnumFlags, "<this>");
        int i = enumC11685j == null ? -1 : a.f24495a[enumC11685j.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? aVar : CallableMemberDescriptor.a.SYNTHESIZED : CallableMemberDescriptor.a.DELEGATION : CallableMemberDescriptor.a.FAKE_OVERRIDE : aVar;
    }
}
