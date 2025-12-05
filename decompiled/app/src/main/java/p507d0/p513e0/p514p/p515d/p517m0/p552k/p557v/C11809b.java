package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: constantValues.kt */
/* renamed from: d0.e0.p.d.m0.k.v.b */
/* loaded from: classes3.dex */
public final class C11809b extends AbstractC11815g<List<? extends AbstractC11815g<?>>> {

    /* renamed from: b */
    public final Function1<ModuleDescriptor2, KotlinType> f24435b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C11809b(List<? extends AbstractC11815g<?>> list, Function1<? super ModuleDescriptor2, ? extends KotlinType> function1) {
        super(list);
        Intrinsics3.checkNotNullParameter(list, "value");
        Intrinsics3.checkNotNullParameter(function1, "computeType");
        this.f24435b = function1;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public KotlinType getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        KotlinType kotlinTypeInvoke = this.f24435b.invoke(moduleDescriptor2);
        if (!KotlinBuiltIns.isArray(kotlinTypeInvoke) && !KotlinBuiltIns.isPrimitiveArray(kotlinTypeInvoke)) {
            KotlinBuiltIns.isUnsignedArrayType(kotlinTypeInvoke);
        }
        return kotlinTypeInvoke;
    }
}
