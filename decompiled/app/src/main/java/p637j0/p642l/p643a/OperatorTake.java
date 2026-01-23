package p637j0.p642l.p643a;

import java.util.concurrent.atomic.AtomicLong;
import p637j0.p652o.C12774l;
import p658rx.Producer;
import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.b2, reason: use source file name */
/* JADX INFO: compiled from: OperatorTake.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorTake<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public int f26743j;

    /* JADX INFO: renamed from: k */
    public boolean f26744k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Subscriber f26745l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ OperatorTake2 f26746m;

    /* JADX INFO: renamed from: j0.l.a.b2$a */
    /* JADX INFO: compiled from: OperatorTake.java */
    public class a implements Producer {

        /* JADX INFO: renamed from: j */
        public final AtomicLong f26747j = new AtomicLong(0);

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Producer f26748k;

        public a(Producer producer) {
            this.f26748k = producer;
        }

        @Override // p658rx.Producer
        /* JADX INFO: renamed from: j */
        public void mo10704j(long j) {
            long j2;
            long jMin;
            if (j <= 0 || OperatorTake.this.f26744k) {
                return;
            }
            do {
                j2 = this.f26747j.get();
                jMin = Math.min(j, ((long) OperatorTake.this.f26746m.f26758j) - j2);
                if (jMin == 0) {
                    return;
                }
            } while (!this.f26747j.compareAndSet(j2, j2 + jMin));
            this.f26748k.mo10704j(jMin);
        }
    }

    public OperatorTake(OperatorTake2 operatorTake2, Subscriber subscriber) {
        this.f26746m = operatorTake2;
        this.f26745l = subscriber;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        if (this.f26744k) {
            return;
        }
        this.f26744k = true;
        this.f26745l.onCompleted();
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        if (this.f26744k) {
            C12774l.m10863b(th);
            return;
        }
        this.f26744k = true;
        try {
            this.f26745l.onError(th);
        } finally {
            unsubscribe();
        }
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        if (isUnsubscribed()) {
            return;
        }
        int i = this.f26743j;
        int i2 = i + 1;
        this.f26743j = i2;
        int i3 = this.f26746m.f26758j;
        if (i < i3) {
            boolean z2 = i2 == i3;
            this.f26745l.onNext(t);
            if (!z2 || this.f26744k) {
                return;
            }
            this.f26744k = true;
            try {
                this.f26745l.onCompleted();
            } finally {
                unsubscribe();
            }
        }
    }

    @Override // p658rx.Subscriber
    public void setProducer(Producer producer) {
        this.f26745l.setProducer(new a(producer));
    }
}
