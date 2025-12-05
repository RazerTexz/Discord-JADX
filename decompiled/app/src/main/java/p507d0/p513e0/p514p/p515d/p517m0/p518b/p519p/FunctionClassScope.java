package p507d0.p513e0.p514p.p515d.p517m0.p518b.p519p;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.GivenFunctionsMemberScope;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: FunctionClassScope.kt */
/* renamed from: d0.e0.p.d.m0.b.p.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class FunctionClassScope extends GivenFunctionsMemberScope {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionClassScope(StorageManager storageManager, FunctionClassDescriptor functionClassDescriptor) {
        super(storageManager, functionClassDescriptor);
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(functionClassDescriptor, "containingClass");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.GivenFunctionsMemberScope
    /* renamed from: a */
    public List<FunctionDescriptor> mo9372a() {
        int iOrdinal = ((FunctionClassDescriptor) this.f24363c).getFunctionKind().ordinal();
        return iOrdinal != 0 ? iOrdinal != 1 ? Collections2.emptyList() : CollectionsJVM.listOf(FunctionInvokeDescriptor.f22609M.create((FunctionClassDescriptor) this.f24363c, true)) : CollectionsJVM.listOf(FunctionInvokeDescriptor.f22609M.create((FunctionClassDescriptor) this.f24363c, false));
    }
}
