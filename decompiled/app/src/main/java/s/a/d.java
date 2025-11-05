package s.a;

import d0.k;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Job;

/* compiled from: Await.kt */
/* loaded from: classes3.dex */
public final class d<T> {
    public static final AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(d.class, "notCompletedCount");

    /* renamed from: b, reason: collision with root package name */
    public final f0<T>[] f3836b;
    public volatile int notCompletedCount;

    /* compiled from: Await.kt */
    public final class a extends g1<Job> {
        public volatile Object _disposer;
        public m0 n;
        public final CancellableContinuation<List<? extends T>> o;

        /* JADX WARN: Multi-variable type inference failed */
        public a(CancellableContinuation<? super List<? extends T>> cancellableContinuation, Job job) {
            super(job);
            this.o = cancellableContinuation;
            this._disposer = null;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            q(th);
            return Unit.a;
        }

        @Override // s.a.y
        public void q(Throwable th) {
            if (th != null) {
                Object objG = this.o.g(th);
                if (objG != null) {
                    this.o.r(objG);
                    b bVar = (b) this._disposer;
                    if (bVar != null) {
                        bVar.b();
                        return;
                    }
                    return;
                }
                return;
            }
            if (d.a.decrementAndGet(d.this) == 0) {
                CancellableContinuation<List<? extends T>> cancellableContinuation = this.o;
                f0<T>[] f0VarArr = d.this.f3836b;
                ArrayList arrayList = new ArrayList(f0VarArr.length);
                for (f0<T> f0Var : f0VarArr) {
                    arrayList.add(f0Var.d());
                }
                k.a aVar = d0.k.j;
                cancellableContinuation.resumeWith(d0.k.m97constructorimpl(arrayList));
            }
        }
    }

    /* compiled from: Await.kt */
    public final class b extends j {
        public final d<T>.a[] j;

        public b(d dVar, d<T>.a[] aVarArr) {
            this.j = aVarArr;
        }

        @Override // s.a.k
        public void a(Throwable th) {
            b();
        }

        public final void b() {
            for (d<T>.a aVar : this.j) {
                m0 m0Var = aVar.n;
                if (m0Var == null) {
                    d0.z.d.m.throwUninitializedPropertyAccessException("handle");
                }
                m0Var.dispose();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            b();
            return Unit.a;
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("DisposeHandlersOnCancel[");
            sbU.append(this.j);
            sbU.append(']');
            return sbU.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(f0<? extends T>[] f0VarArr) {
        this.f3836b = f0VarArr;
        this.notCompletedCount = f0VarArr.length;
    }
}
