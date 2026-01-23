package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import java.util.Collection;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.q, reason: use source file name */
/* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaStaticClassScope4 extends DFS.b<ClassDescriptor, Unit> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ClassDescriptor f23415a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Set<R> f23416b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Function1<MemberScope3, Collection<R>> f23417c;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyJavaStaticClassScope4(ClassDescriptor classDescriptor, Set<R> set, Function1<? super MemberScope3, ? extends Collection<? extends R>> function1) {
        this.f23415a = classDescriptor;
        this.f23416b = set;
        this.f23417c = function1;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS.d
    public /* bridge */ /* synthetic */ boolean beforeChildren(Object obj) {
        return beforeChildren((ClassDescriptor) obj);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p576p.DFS.d
    public /* bridge */ /* synthetic */ Object result() {
        m11464result();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: result, reason: collision with other method in class */
    public void m11464result() {
    }

    public boolean beforeChildren(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "current");
        if (classDescriptor == this.f23415a) {
            return true;
        }
        MemberScope3 staticScope = classDescriptor.getStaticScope();
        Intrinsics3.checkNotNullExpressionValue(staticScope, "current.staticScope");
        if (!(staticScope instanceof LazyJavaStaticScope)) {
            return true;
        }
        this.f23416b.addAll((Collection) this.f23417c.invoke(staticScope));
        return false;
    }
}
