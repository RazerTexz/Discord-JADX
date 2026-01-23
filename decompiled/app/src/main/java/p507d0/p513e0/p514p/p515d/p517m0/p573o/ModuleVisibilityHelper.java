package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.DeclarationDescriptor;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.g, reason: use source file name */
/* JADX INFO: compiled from: ModuleVisibilityHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ModuleVisibilityHelper {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.o.g$a */
    /* JADX INFO: compiled from: ModuleVisibilityHelper.kt */
    public static final class a implements ModuleVisibilityHelper {

        /* JADX INFO: renamed from: a */
        public static final a f24915a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p573o.ModuleVisibilityHelper
        public boolean isInFriendModule(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
            Intrinsics3.checkNotNullParameter(declarationDescriptor, "what");
            Intrinsics3.checkNotNullParameter(declarationDescriptor2, "from");
            return true;
        }
    }

    boolean isInFriendModule(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2);
}
