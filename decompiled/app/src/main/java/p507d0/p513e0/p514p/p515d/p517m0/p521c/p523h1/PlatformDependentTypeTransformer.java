package p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1;

import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: PlatformDependentTypeTransformer.kt */
/* renamed from: d0.e0.p.d.m0.c.h1.e, reason: use source file name */
/* loaded from: classes3.dex */
public interface PlatformDependentTypeTransformer {

    /* compiled from: PlatformDependentTypeTransformer.kt */
    /* renamed from: d0.e0.p.d.m0.c.h1.e$a */
    public static final class a implements PlatformDependentTypeTransformer {

        /* renamed from: a */
        public static final a f22800a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.PlatformDependentTypeTransformer
        public KotlinType4 transformPlatformType(ClassId classId, KotlinType4 kotlinType4) {
            Intrinsics3.checkNotNullParameter(classId, "classId");
            Intrinsics3.checkNotNullParameter(kotlinType4, "computedType");
            return kotlinType4;
        }
    }

    KotlinType4 transformPlatformType(ClassId classId, KotlinType4 kotlinType4);
}
