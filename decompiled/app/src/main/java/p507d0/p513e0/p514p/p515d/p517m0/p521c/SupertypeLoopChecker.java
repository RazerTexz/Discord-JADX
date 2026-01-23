package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.TypeConstructor;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.x0, reason: use source file name */
/* JADX INFO: compiled from: SupertypeLoopChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface SupertypeLoopChecker {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.x0$a */
    /* JADX INFO: compiled from: SupertypeLoopChecker.kt */
    public static final class a implements SupertypeLoopChecker {

        /* JADX INFO: renamed from: a */
        public static final a f23103a = new a();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.SupertypeLoopChecker
        public Collection<KotlinType> findLoopsInSupertypesAndDisconnect(TypeConstructor typeConstructor, Collection<? extends KotlinType> collection, Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> function1, Function1<? super KotlinType, Unit> function12) {
            Intrinsics3.checkNotNullParameter(typeConstructor, "currentTypeConstructor");
            Intrinsics3.checkNotNullParameter(collection, "superTypes");
            Intrinsics3.checkNotNullParameter(function1, "neighbors");
            Intrinsics3.checkNotNullParameter(function12, "reportLoop");
            return collection;
        }
    }

    Collection<KotlinType> findLoopsInSupertypesAndDisconnect(TypeConstructor typeConstructor, Collection<? extends KotlinType> collection, Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> function1, Function1<? super KotlinType, Unit> function12);
}
