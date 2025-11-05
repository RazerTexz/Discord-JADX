package j0.l.a;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: OperatorTake.java */
/* loaded from: classes3.dex */
public class b2<T> extends Subscriber<T> {
    public int j;
    public boolean k;
    public final /* synthetic */ Subscriber l;
    public final /* synthetic */ c2 m;

    /* compiled from: OperatorTake.java */
    public class a implements Producer {
        public final AtomicLong j = new AtomicLong(0);
        public final /* synthetic */ Producer k;

        public a(Producer producer) {
            this.k = producer;
        }

        @Override // rx.Producer
        public void j(long j) {
            long j2;
            long jMin;
            if (j <= 0 || b2.this.k) {
                return;
            }
            do {
                j2 = this.j.get();
                jMin = Math.min(j, b2.this.m.j - j2);
                if (jMin == 0) {
                    return;
                }
            } while (!this.j.compareAndSet(j2, j2 + jMin));
            this.k.j(jMin);
        }
    }

    public b2(c2 c2Var, Subscriber subscriber) {
        this.m = c2Var;
        this.l = subscriber;
    }

    @Override // j0.g
    public void onCompleted() {
        if (this.k) {
            return;
        }
        this.k = true;
        this.l.onCompleted();
    }

    @Override // j0.g
    public void onError(Throwable th) {
        if (this.k) {
            j0.o.l.b(th);
            return;
        }
        this.k = true;
        try {
            this.l.onError(th);
        } finally {
            unsubscribe();
        }
    }

    @Override // j0.g
    public void onNext(T t) {
        if (isUnsubscribed()) {
            return;
        }
        int i = this.j;
        int i2 = i + 1;
        this.j = i2;
        int i3 = this.m.j;
        if (i < i3) {
            boolean z2 = i2 == i3;
            this.l.onNext(t);
            if (!z2 || this.k) {
                return;
            }
            this.k = true;
            try {
                this.l.onCompleted();
            } finally {
                unsubscribe();
            }
        }
    }

    @Override // rx.Subscriber
    public void setProducer(Producer producer) {
        this.l.setProducer(new a(producer));
    }
}
