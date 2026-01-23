package p659s.p660a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Job;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Result2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: s.a.d, reason: use source file name */
/* JADX INFO: compiled from: Await.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Await<T> {

    /* JADX INFO: renamed from: a */
    public static final AtomicIntegerFieldUpdater f27772a = AtomicIntegerFieldUpdater.newUpdater(Await.class, "notCompletedCount");

    /* JADX INFO: renamed from: b */
    public final Deferred<T>[] f27773b;
    public volatile int notCompletedCount;

    /* JADX INFO: renamed from: s.a.d$a */
    /* JADX INFO: compiled from: Await.kt */
    public final class a extends AbstractC13113g1<Job> {
        public volatile Object _disposer;

        /* JADX INFO: renamed from: n */
        public Job2 f27774n;

        /* JADX INFO: renamed from: o */
        public final CancellableContinuation<List<? extends T>> f27775o;

        /* JADX WARN: Multi-variable type inference failed */
        public a(CancellableContinuation<? super List<? extends T>> cancellableContinuation, Job job) {
            super(job);
            this.f27775o = cancellableContinuation;
            this._disposer = null;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            mo11198q(th);
            return Unit.f27425a;
        }

        @Override // p659s.p660a.CompletionHandler2
        /* JADX INFO: renamed from: q */
        public void mo11198q(Throwable th) {
            if (th != null) {
                Object objMo10903g = this.f27775o.mo10903g(th);
                if (objMo10903g != null) {
                    this.f27775o.mo10907r(objMo10903g);
                    b bVar = (b) this._disposer;
                    if (bVar != null) {
                        bVar.m11242b();
                        return;
                    }
                    return;
                }
                return;
            }
            if (Await.f27772a.decrementAndGet(Await.this) == 0) {
                CancellableContinuation<List<? extends T>> cancellableContinuation = this.f27775o;
                Deferred<T>[] deferredArr = Await.this.f27773b;
                ArrayList arrayList = new ArrayList(deferredArr.length);
                for (Deferred<T> deferred : deferredArr) {
                    arrayList.add(deferred.mo11278d());
                }
                Result2.a aVar = Result2.f25169j;
                cancellableContinuation.resumeWith(Result2.m11474constructorimpl(arrayList));
            }
        }
    }

    /* JADX INFO: renamed from: s.a.d$b */
    /* JADX INFO: compiled from: Await.kt */
    public final class b extends CancellableContinuationImpl4 {

        /* JADX INFO: renamed from: j */
        public final Await<T>.a[] f27777j;

        public b(Await await, Await<T>.a[] aVarArr) {
            this.f27777j = aVarArr;
        }

        @Override // p659s.p660a.CompletionHandler
        /* JADX INFO: renamed from: a */
        public void mo11193a(Throwable th) {
            m11242b();
        }

        /* JADX INFO: renamed from: b */
        public final void m11242b() {
            for (Await<T>.a aVar : this.f27777j) {
                Job2 job2 = aVar.f27774n;
                if (job2 == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("handle");
                }
                job2.dispose();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            m11242b();
            return Unit.f27425a;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("DisposeHandlersOnCancel[");
            sbM833U.append(this.f27777j);
            sbM833U.append(']');
            return sbM833U.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Await(Deferred<? extends T>[] deferredArr) {
        this.f27773b = deferredArr;
        this.notCompletedCount = deferredArr.length;
    }
}
