package p007b.p109f.p161j.p181p;

import android.util.Pair;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: b.f.j.p.i1, reason: use source file name */
/* JADX INFO: compiled from: ThrottlingProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class ThrottlingProducer<T> implements Producer2<T> {

    /* JADX INFO: renamed from: a */
    public final Producer2<T> f4082a;

    /* JADX INFO: renamed from: b */
    public int f4083b;

    /* JADX INFO: renamed from: c */
    public final ConcurrentLinkedQueue<Pair<Consumer2<T>, ProducerContext>> f4084c;

    /* JADX INFO: renamed from: d */
    public final Executor f4085d;

    /* JADX INFO: renamed from: b.f.j.p.i1$b */
    /* JADX INFO: compiled from: ThrottlingProducer.java */
    public class b extends DelegatingConsumer<T, T> {

        /* JADX INFO: renamed from: b.f.j.p.i1$b$a */
        /* JADX INFO: compiled from: ThrottlingProducer.java */
        public class a implements Runnable {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ Pair f4087j;

            public a(Pair pair) {
                this.f4087j = pair;
            }

            @Override // java.lang.Runnable
            public void run() {
                ThrottlingProducer throttlingProducer = ThrottlingProducer.this;
                Pair pair = this.f4087j;
                Consumer2 consumer2 = (Consumer2) pair.first;
                ProducerContext producerContext = (ProducerContext) pair.second;
                Objects.requireNonNull(throttlingProducer);
                producerContext.mo1457o().mo1363j(producerContext, "ThrottlingProducer", null);
                throttlingProducer.f4082a.mo1417b(new b(consumer2, null), producerContext);
            }
        }

        public b(Consumer2 consumer2, a aVar) {
            super(consumer2);
        }

        @Override // p007b.p109f.p161j.p181p.DelegatingConsumer, p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: g */
        public void mo1318g() {
            this.f4179b.mo1426d();
            m1479n();
        }

        @Override // p007b.p109f.p161j.p181p.DelegatingConsumer, p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: h */
        public void mo1319h(Throwable th) {
            this.f4179b.mo1425c(th);
            m1479n();
        }

        @Override // p007b.p109f.p161j.p181p.BaseConsumer
        /* JADX INFO: renamed from: i */
        public void mo1320i(T t, int i) {
            this.f4179b.mo1424b(t, i);
            if (BaseConsumer.m1419e(i)) {
                m1479n();
            }
        }

        /* JADX INFO: renamed from: n */
        public final void m1479n() {
            Pair<Consumer2<T>, ProducerContext> pairPoll;
            synchronized (ThrottlingProducer.this) {
                pairPoll = ThrottlingProducer.this.f4084c.poll();
                if (pairPoll == null) {
                    ThrottlingProducer throttlingProducer = ThrottlingProducer.this;
                    throttlingProducer.f4083b--;
                }
            }
            if (pairPoll != null) {
                ThrottlingProducer.this.f4085d.execute(new a(pairPoll));
            }
        }
    }

    public ThrottlingProducer(int i, Executor executor, Producer2<T> producer2) {
        Objects.requireNonNull(executor);
        this.f4085d = executor;
        Objects.requireNonNull(producer2);
        this.f4082a = producer2;
        this.f4084c = new ConcurrentLinkedQueue<>();
        this.f4083b = 0;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* JADX INFO: renamed from: b */
    public void mo1417b(Consumer2<T> consumer2, ProducerContext producerContext) {
        boolean z2;
        producerContext.mo1457o().mo1358e(producerContext, "ThrottlingProducer");
        synchronized (this) {
            int i = this.f4083b;
            z2 = true;
            if (i >= 5) {
                this.f4084c.add(Pair.create(consumer2, producerContext));
            } else {
                this.f4083b = i + 1;
                z2 = false;
            }
        }
        if (z2) {
            return;
        }
        producerContext.mo1457o().mo1363j(producerContext, "ThrottlingProducer", null);
        this.f4082a.mo1417b(new b(consumer2, null), producerContext);
    }
}
