package p659s.p660a;

import java.util.Objects;
import kotlinx.coroutines.Job;

/* compiled from: JobSupport.kt */
/* renamed from: s.a.g1 */
/* loaded from: classes3.dex */
public abstract class AbstractC13113g1<J extends Job> extends CompletionHandler2 implements Job2, InterfaceC13169z0 {

    /* renamed from: m */
    public final J f27845m;

    public AbstractC13113g1(J j) {
        this.f27845m = j;
    }

    @Override // p659s.p660a.InterfaceC13169z0
    /* renamed from: a */
    public boolean mo11281a() {
        return true;
    }

    @Override // p659s.p660a.Job2
    public void dispose() {
        Object objM11292M;
        J j = this.f27845m;
        Objects.requireNonNull(j, "null cannot be cast to non-null type kotlinx.coroutines.JobSupport");
        C13116h1 c13116h1 = (C13116h1) j;
        do {
            objM11292M = c13116h1.m11292M();
            if (!(objM11292M instanceof AbstractC13113g1)) {
                if (!(objM11292M instanceof InterfaceC13169z0) || ((InterfaceC13169z0) objM11292M).getList() == null) {
                    return;
                }
                mo11151n();
                return;
            }
            if (objM11292M != this) {
                return;
            }
        } while (!C13116h1.f27846j.compareAndSet(c13116h1, objM11292M, C13119i1.f27863g));
    }

    @Override // p659s.p660a.InterfaceC13169z0
    public C13131m1 getList() {
        return null;
    }
}
