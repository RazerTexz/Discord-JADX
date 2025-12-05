package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: LazyScopeAdapter.kt */
/* renamed from: d0.e0.p.d.m0.k.a0.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class LazyScopeAdapter extends AbstractScopeAdapter {

    /* renamed from: b */
    public final storage5<MemberScope3> f24368b;

    /* compiled from: LazyScopeAdapter.kt */
    /* renamed from: d0.e0.p.d.m0.k.a0.h$a */
    public static final class a extends Lambda implements Function0<MemberScope3> {
        public final /* synthetic */ Function0<MemberScope3> $getScope;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Function0<? extends MemberScope3> function0) {
            super(0);
            this.$getScope = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ MemberScope3 invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MemberScope3 invoke() {
            MemberScope3 memberScope3Invoke = this.$getScope.invoke();
            return memberScope3Invoke instanceof AbstractScopeAdapter ? ((AbstractScopeAdapter) memberScope3Invoke).getActualScope() : memberScope3Invoke;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ LazyScopeAdapter(StorageManager storageManager, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            storageManager = LockBasedStorageManager.f24710b;
            Intrinsics3.checkNotNullExpressionValue(storageManager, "NO_LOCKS");
        }
        this(storageManager, function0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LazyScopeAdapter(Function0<? extends MemberScope3> function0) {
        this(null, function0, 1, null);
        Intrinsics3.checkNotNullParameter(function0, "getScope");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractScopeAdapter
    /* renamed from: a */
    public MemberScope3 mo9910a() {
        return this.f24368b.invoke();
    }

    public LazyScopeAdapter(StorageManager storageManager, Function0<? extends MemberScope3> function0) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(function0, "getScope");
        this.f24368b = storageManager.createLazyValue(new a(function0));
    }
}
