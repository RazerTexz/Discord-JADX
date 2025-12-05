package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassKind;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.DescriptorFactory;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.StorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage5;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage7;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.SmartList;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.PropertyReference1Impl;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: StaticScopeForKotlinEnum.kt */
/* renamed from: d0.e0.p.d.m0.k.a0.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class StaticScopeForKotlinEnum extends MemberScopeImpl {

    /* renamed from: b */
    public static final /* synthetic */ KProperty<Object>[] f24374b = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(StaticScopeForKotlinEnum.class), "functions", "getFunctions()Ljava/util/List;"))};

    /* renamed from: c */
    public final ClassDescriptor f24375c;

    /* renamed from: d */
    public final storage5 f24376d;

    /* compiled from: StaticScopeForKotlinEnum.kt */
    /* renamed from: d0.e0.p.d.m0.k.a0.m$a */
    public static final class a extends Lambda implements Function0<List<? extends SimpleFunctionDescriptor>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends SimpleFunctionDescriptor> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends SimpleFunctionDescriptor> invoke2() {
            return Collections2.listOf((Object[]) new SimpleFunctionDescriptor[]{DescriptorFactory.createEnumValueOfMethod(StaticScopeForKotlinEnum.access$getContainingClass$p(StaticScopeForKotlinEnum.this)), DescriptorFactory.createEnumValuesMethod(StaticScopeForKotlinEnum.access$getContainingClass$p(StaticScopeForKotlinEnum.this))});
        }
    }

    public StaticScopeForKotlinEnum(StorageManager storageManager, ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(classDescriptor, "containingClass");
        this.f24375c = classDescriptor;
        classDescriptor.getKind();
        ClassKind classKind = ClassKind.ENUM_CLASS;
        this.f24376d = storageManager.createLazyValue(new a());
    }

    public static final /* synthetic */ ClassDescriptor access$getContainingClass$p(StaticScopeForKotlinEnum staticScopeForKotlinEnum) {
        return staticScopeForKotlinEnum.f24375c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public /* bridge */ /* synthetic */ ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        return (ClassifierDescriptor) m11469getContributedClassifier(name, lookupLocation2);
    }

    /* renamed from: getContributedClassifier, reason: collision with other method in class */
    public Void m11469getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(MemberScope2 memberScope2, Function1 function1) {
        return getContributedDescriptors(memberScope2, (Function1<? super Name, Boolean>) function1);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public /* bridge */ /* synthetic */ Collection getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        return getContributedFunctions(name, lookupLocation2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.ResolutionScope
    public List<SimpleFunctionDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        return (List) storage7.getValue(this.f24376d, this, (KProperty<?>) f24374b[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
    public SmartList<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        List list = (List) storage7.getValue(this.f24376d, this, (KProperty<?>) f24374b[0]);
        SmartList<SimpleFunctionDescriptor> smartList = new SmartList<>();
        for (Object obj : list) {
            if (Intrinsics3.areEqual(((SimpleFunctionDescriptor) obj).getName(), name)) {
                smartList.add(obj);
            }
        }
        return smartList;
    }
}
