package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: PrimitiveTypeUtil.kt */
/* renamed from: d0.e0.p.d.m0.k.v.u, reason: use source file name */
/* loaded from: classes3.dex */
public final class PrimitiveTypeUtil {
    public static final Collection<KotlinType> getAllSignedLiteralTypes(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "<this>");
        return Collections2.listOf((Object[]) new KotlinType4[]{moduleDescriptor2.getBuiltIns().getIntType(), moduleDescriptor2.getBuiltIns().getLongType(), moduleDescriptor2.getBuiltIns().getByteType(), moduleDescriptor2.getBuiltIns().getShortType()});
    }
}
