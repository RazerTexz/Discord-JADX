package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.ClassDescriptorFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation2;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation3;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.utils;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11687l;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11693r;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11695t;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11698w;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.BinaryVersion;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.TypeTable;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.VersionRequirement2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope2;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.context5;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.context6;
import p507d0.p580t.MutableCollections;
import p507d0.p580t.Sets5;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.i, reason: use source file name */
/* JADX INFO: compiled from: DeserializedPackageMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public class DeserializedPackageMemberScope extends DeserializedMemberScope {

    /* JADX INFO: renamed from: g */
    public final PackageFragmentDescriptor f24597g;

    /* JADX INFO: renamed from: h */
    public final FqName f24598h;

    public DeserializedPackageMemberScope(PackageFragmentDescriptor packageFragmentDescriptor, C11687l c11687l, NameResolver nameResolver, BinaryVersion binaryVersion, DeserializedContainerSource2 deserializedContainerSource2, context5 context5Var, Function0<? extends Collection<Name>> function0) {
        Intrinsics3.checkNotNullParameter(packageFragmentDescriptor, "packageDescriptor");
        Intrinsics3.checkNotNullParameter(c11687l, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(binaryVersion, "metadataVersion");
        Intrinsics3.checkNotNullParameter(context5Var, "components");
        Intrinsics3.checkNotNullParameter(function0, "classNames");
        C11695t typeTable = c11687l.getTypeTable();
        Intrinsics3.checkNotNullExpressionValue(typeTable, "proto.typeTable");
        TypeTable typeTable2 = new TypeTable(typeTable);
        VersionRequirement2.a aVar = VersionRequirement2.f24073a;
        C11698w versionRequirementTable = c11687l.getVersionRequirementTable();
        Intrinsics3.checkNotNullExpressionValue(versionRequirementTable, "proto.versionRequirementTable");
        context6 context6VarCreateContext = context5Var.createContext(packageFragmentDescriptor, nameResolver, typeTable2, aVar.create(versionRequirementTable), binaryVersion, deserializedContainerSource2);
        List<C11684i> functionList = c11687l.getFunctionList();
        Intrinsics3.checkNotNullExpressionValue(functionList, "proto.functionList");
        List<C11689n> propertyList = c11687l.getPropertyList();
        Intrinsics3.checkNotNullExpressionValue(propertyList, "proto.propertyList");
        List<C11693r> typeAliasList = c11687l.getTypeAliasList();
        Intrinsics3.checkNotNullExpressionValue(typeAliasList, "proto.typeAliasList");
        super(context6VarCreateContext, functionList, propertyList, typeAliasList, function0);
        this.f24597g = packageFragmentDescriptor;
        this.f24598h = packageFragmentDescriptor.getFqName();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope
    /* JADX INFO: renamed from: a */
    public void mo9955a(Collection<DeclarationDescriptor> collection, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(collection, "result");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope
    /* JADX INFO: renamed from: e */
    public ClassId mo9958e(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ClassId(this.f24598h, name);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope
    /* JADX INFO: renamed from: f */
    public Set<Name> mo9959f() {
        return Sets5.emptySet();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope
    /* JADX INFO: renamed from: g */
    public Set<Name> mo9960g() {
        return Sets5.emptySet();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(name, lookupLocation2);
        return super.getContributedClassifier(name, lookupLocation2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(MemberScope2 memberScope2, Function1 function1) {
        return getContributedDescriptors(memberScope2, (Function1<? super Name, Boolean>) function1);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope
    /* JADX INFO: renamed from: h */
    public Set<Name> mo9961h() {
        return Sets5.emptySet();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedMemberScope
    /* JADX INFO: renamed from: i */
    public boolean mo9965i(Name name) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (getClassNames$deserialization().contains(name)) {
            return true;
        }
        Iterable<ClassDescriptorFactory> fictitiousClassDescriptorFactories = this.f24568c.getComponents().getFictitiousClassDescriptorFactories();
        if ((fictitiousClassDescriptorFactories instanceof Collection) && ((Collection) fictitiousClassDescriptorFactories).isEmpty()) {
            z2 = false;
        } else {
            Iterator<ClassDescriptorFactory> it = fictitiousClassDescriptorFactories.iterator();
            while (it.hasNext()) {
                if (it.next().shouldCreateClass(this.f24598h, name)) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        return z2;
    }

    public void recordLookup(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        utils.record(this.f24568c.getComponents().getLookupTracker(), lookupLocation2, this.f24597g, name);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public List<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        Collection<DeclarationDescriptor> collectionM9964b = m9964b(memberScope2, function1, LookupLocation3.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<ClassDescriptorFactory> fictitiousClassDescriptorFactories = this.f24568c.getComponents().getFictitiousClassDescriptorFactories();
        ArrayList arrayList = new ArrayList();
        Iterator<ClassDescriptorFactory> it = fictitiousClassDescriptorFactories.iterator();
        while (it.hasNext()) {
            MutableCollections.addAll(arrayList, it.next().getAllContributedClassesIfPossible(this.f24598h));
        }
        return _Collections.plus((Collection) collectionM9964b, (Iterable) arrayList);
    }
}
