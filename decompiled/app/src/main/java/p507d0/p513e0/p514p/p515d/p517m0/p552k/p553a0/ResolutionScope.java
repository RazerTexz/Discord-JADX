package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.l, reason: use source file name */
/* JADX INFO: compiled from: ResolutionScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ResolutionScope {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.l$a */
    /* JADX INFO: compiled from: ResolutionScope.kt */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection getContributedDescriptors$default(ResolutionScope resolutionScope, MemberScope2 memberScope2, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
            }
            if ((i & 1) != 0) {
                memberScope2 = MemberScope2.f24351m;
            }
            if ((i & 2) != 0) {
                function1 = MemberScope3.f24369a.getALL_NAME_FILTER();
            }
            return resolutionScope.getContributedDescriptors(memberScope2, function1);
        }
    }

    ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2);

    Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1);
}
