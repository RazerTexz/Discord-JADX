package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.CallableMemberDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DescriptorVisibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.FunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Modality;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ReceiverParameterDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.SimpleFunctionDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.GivenFunctionsMemberScope;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.DescriptorUtils2;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p580t.Collections2;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.a, reason: use source file name */
/* JADX INFO: compiled from: CloneableClassScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CloneableClassScope extends GivenFunctionsMemberScope {

    /* JADX INFO: renamed from: e */
    public static final a f22610e = new a(null);

    /* JADX INFO: renamed from: f */
    public static final Name f22611f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.a$a */
    /* JADX INFO: compiled from: CloneableClassScope.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Name getCLONE_NAME() {
            return CloneableClassScope.access$getCLONE_NAME$cp();
        }
    }

    static {
        Name nameIdentifier = Name.identifier("clone");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(\"clone\")");
        f22611f = nameIdentifier;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloneableClassScope(StorageManager storageManager, ClassDescriptor classDescriptor) {
        super(storageManager, classDescriptor);
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(classDescriptor, "containingClass");
    }

    public static final /* synthetic */ Name access$getCLONE_NAME$cp() {
        return f22611f;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.GivenFunctionsMemberScope
    /* JADX INFO: renamed from: a */
    public List<FunctionDescriptor> mo9372a() {
        SimpleFunctionDescriptorImpl simpleFunctionDescriptorImplCreate = SimpleFunctionDescriptorImpl.create(this.f24363c, Annotations4.f22735f.getEMPTY(), f22610e.getCLONE_NAME(), CallableMemberDescriptor.a.DECLARATION, SourceElement.f23099a);
        simpleFunctionDescriptorImplCreate.initialize((ReceiverParameterDescriptor) null, this.f24363c.getThisAsReceiverParameter(), Collections2.emptyList(), Collections2.emptyList(), (KotlinType) DescriptorUtils2.getBuiltIns(this.f24363c).getAnyType(), Modality.OPEN, DescriptorVisibilities.f23085c);
        return CollectionsJVM.listOf(simpleFunctionDescriptorImplCreate);
    }
}
