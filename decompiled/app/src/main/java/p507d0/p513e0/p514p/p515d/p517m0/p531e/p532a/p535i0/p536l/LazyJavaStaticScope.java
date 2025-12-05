package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.TypeParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ValueParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11585r;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: LazyJavaStaticScope.kt */
/* renamed from: d0.e0.p.d.m0.e.a.i0.l.r, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class LazyJavaStaticScope extends LazyJavaScope {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaStaticScope(context4 context4Var) {
        super(context4Var, null, 2, null);
        Intrinsics3.checkNotNullParameter(context4Var, "c");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* renamed from: g */
    public void mo9475g(Name name, Collection<PropertyDescriptor> collection) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(collection, "result");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* renamed from: i */
    public ReceiverParameterDescriptor mo9477i() {
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaScope
    /* renamed from: l */
    public LazyJavaScope.a mo9480l(InterfaceC11585r interfaceC11585r, List<? extends TypeParameterDescriptor> list, KotlinType kotlinType, List<? extends ValueParameterDescriptor> list2) {
        Intrinsics3.checkNotNullParameter(interfaceC11585r, "method");
        Intrinsics3.checkNotNullParameter(list, "methodTypeParameters");
        Intrinsics3.checkNotNullParameter(kotlinType, "returnType");
        Intrinsics3.checkNotNullParameter(list2, "valueParameters");
        return new LazyJavaScope.a(kotlinType, null, list2, list, false, Collections2.emptyList());
    }
}
