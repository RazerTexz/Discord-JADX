package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PropertyDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p580t.Sets5;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.i, reason: use source file name */
/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface MemberScope3 extends ResolutionScope {

    /* JADX INFO: renamed from: a */
    public static final a f24369a = a.f24370a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.i$a */
    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ a f24370a = new a();

        /* JADX INFO: renamed from: b */
        public static final Function1<Name, Boolean> f24371b = C13328a.f24372j;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MemberScope.kt */
        public static final class C13328a extends Lambda implements Function1<Name, Boolean> {

            /* JADX INFO: renamed from: j */
            public static final C13328a f24372j = new C13328a();

            public C13328a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Name name) {
                return Boolean.valueOf(invoke2(name));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(Name name) {
                Intrinsics3.checkNotNullParameter(name, "it");
                return true;
            }
        }

        public final Function1<Name, Boolean> getALL_NAME_FILTER() {
            return f24371b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.i$b */
    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class b extends MemberScopeImpl {

        /* JADX INFO: renamed from: b */
        public static final b f24373b = new b();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
        public Set<Name> getClassifierNames() {
            return Sets5.emptySet();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
        public Set<Name> getFunctionNames() {
            return Sets5.emptySet();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScopeImpl, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3
        public Set<Name> getVariableNames() {
            return Sets5.emptySet();
        }
    }

    Set<Name> getClassifierNames();

    Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2);

    Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2);

    Set<Name> getFunctionNames();

    Set<Name> getVariableNames();
}
