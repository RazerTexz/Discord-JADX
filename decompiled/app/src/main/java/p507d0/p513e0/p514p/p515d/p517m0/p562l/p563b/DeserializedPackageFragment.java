package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ModuleDescriptor2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.PackageFragmentDescriptorImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.n, reason: use source file name */
/* JADX INFO: compiled from: DeserializedPackageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DeserializedPackageFragment extends PackageFragmentDescriptorImpl {

    /* JADX INFO: renamed from: o */
    public final StorageManager f24669o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragment(FqName fqName, StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2) {
        super(moduleDescriptor2, fqName);
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        this.f24669o = storageManager;
    }

    public abstract ClassDataFinder getClassDataFinder();

    public boolean hasTopLevelClass(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        MemberScope3 memberScope = getMemberScope();
        return (memberScope instanceof DeserializedMemberScope) && ((DeserializedMemberScope) memberScope).getClassNames$deserialization().contains(name);
    }
}
