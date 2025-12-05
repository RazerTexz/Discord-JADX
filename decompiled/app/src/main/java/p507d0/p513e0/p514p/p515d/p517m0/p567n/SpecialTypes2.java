package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.KotlinTypeRefiner;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: SpecialTypes.kt */
/* renamed from: d0.e0.p.d.m0.n.f0, reason: use source file name */
/* loaded from: classes3.dex */
public final class SpecialTypes2 extends KotlinType5 {

    /* renamed from: k */
    public final StorageManager f24769k;

    /* renamed from: l */
    public final Function0<KotlinType> f24770l;

    /* renamed from: m */
    public final storage5<KotlinType> f24771m;

    /* compiled from: SpecialTypes.kt */
    /* renamed from: d0.e0.p.d.m0.n.f0$a */
    public static final class a extends Lambda implements Function0<KotlinType> {
        public final /* synthetic */ KotlinTypeRefiner $kotlinTypeRefiner;
        public final /* synthetic */ SpecialTypes2 this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(KotlinTypeRefiner kotlinTypeRefiner, SpecialTypes2 specialTypes2) {
            super(0);
            this.$kotlinTypeRefiner = kotlinTypeRefiner;
            this.this$0 = specialTypes2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ KotlinType invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KotlinType invoke() {
            return this.$kotlinTypeRefiner.refineType((KotlinType) SpecialTypes2.access$getComputation$p(this.this$0).invoke());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SpecialTypes2(StorageManager storageManager, Function0<? extends KotlinType> function0) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(function0, "computation");
        this.f24769k = storageManager;
        this.f24770l = function0;
        this.f24771m = storageManager.createLazyValue(function0);
    }

    public static final /* synthetic */ Function0 access$getComputation$p(SpecialTypes2 specialTypes2) {
        return specialTypes2.f24770l;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType5
    /* renamed from: a */
    public KotlinType mo10011a() {
        return this.f24771m.invoke();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType5
    public boolean isComputed() {
        return ((LockBasedStorageManager.h) this.f24771m).isComputed();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public /* bridge */ /* synthetic */ KotlinType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        return refine(kotlinTypeRefiner);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType
    public SpecialTypes2 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new SpecialTypes2(this.f24769k, new a(kotlinTypeRefiner, this));
    }
}
