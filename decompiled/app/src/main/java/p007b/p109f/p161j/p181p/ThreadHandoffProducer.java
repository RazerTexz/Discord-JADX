package p007b.p109f.p161j.p181p;

import java.util.Objects;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* JADX INFO: renamed from: b.f.j.p.f1, reason: use source file name */
/* JADX INFO: compiled from: ThreadHandoffProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class ThreadHandoffProducer<T> implements Producer2<T> {

    /* JADX INFO: renamed from: a */
    public final Producer2<T> f4051a;

    /* JADX INFO: renamed from: b */
    public final ThreadHandoffProducerQueue f4052b;

    /* JADX INFO: renamed from: b.f.j.p.f1$a */
    /* JADX INFO: compiled from: ThreadHandoffProducer.java */
    public class a extends StatefulProducerRunnable<T> {

        /* JADX INFO: renamed from: o */
        public final /* synthetic */ ProducerListener2 f4053o;

        /* JADX INFO: renamed from: p */
        public final /* synthetic */ ProducerContext f4054p;

        /* JADX INFO: renamed from: q */
        public final /* synthetic */ Consumer2 f4055q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consumer2 consumer2, ProducerListener2 producerListener2, ProducerContext producerContext, String str, ProducerListener2 producerListener22, ProducerContext producerContext2, Consumer2 consumer22) {
            super(consumer2, producerListener2, producerContext, str);
            this.f4053o = producerListener22;
            this.f4054p = producerContext2;
            this.f4055q = consumer22;
        }

        @Override // p007b.p109f.p161j.p181p.StatefulProducerRunnable
        /* JADX INFO: renamed from: b */
        public void mo1465b(T t) {
        }

        @Override // p007b.p109f.p161j.p181p.StatefulProducerRunnable
        /* JADX INFO: renamed from: d */
        public T mo1467d() throws Exception {
            return null;
        }

        @Override // p007b.p109f.p161j.p181p.StatefulProducerRunnable
        /* JADX INFO: renamed from: g */
        public void mo1470g(T t) {
            this.f4053o.mo1363j(this.f4054p, "BackgroundThreadHandoffProducer", null);
            ThreadHandoffProducer.this.f4051a.mo1417b(this.f4055q, this.f4054p);
        }
    }

    /* JADX INFO: renamed from: b.f.j.p.f1$b */
    /* JADX INFO: compiled from: ThreadHandoffProducer.java */
    public class b extends BaseProducerContextCallbacks {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ StatefulProducerRunnable f4057a;

        public b(StatefulProducerRunnable statefulProducerRunnable) {
            this.f4057a = statefulProducerRunnable;
        }

        @Override // p007b.p109f.p161j.p181p.ProducerContextCallbacks
        /* JADX INFO: renamed from: a */
        public void mo1438a() {
            this.f4057a.m1464a();
            ThreadHandoffProducerQueue threadHandoffProducerQueue = ThreadHandoffProducer.this.f4052b;
            StatefulProducerRunnable statefulProducerRunnable = this.f4057a;
            ThreadHandoffProducerQueueImpl threadHandoffProducerQueueImpl = (ThreadHandoffProducerQueueImpl) threadHandoffProducerQueue;
            synchronized (threadHandoffProducerQueueImpl) {
                threadHandoffProducerQueueImpl.f4073a.remove(statefulProducerRunnable);
            }
        }
    }

    public ThreadHandoffProducer(Producer2<T> producer2, ThreadHandoffProducerQueue threadHandoffProducerQueue) {
        Objects.requireNonNull(producer2);
        this.f4051a = producer2;
        this.f4052b = threadHandoffProducerQueue;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* JADX INFO: renamed from: b */
    public void mo1417b(Consumer2<T> consumer2, ProducerContext producerContext) {
        try {
            FrescoSystrace.m1527b();
            ProducerListener2 producerListener2Mo1457o = producerContext.mo1457o();
            Objects.requireNonNull(producerContext.mo1449g().getExperiments());
            a aVar = new a(consumer2, producerListener2Mo1457o, producerContext, "BackgroundThreadHandoffProducer", producerListener2Mo1457o, producerContext, consumer2);
            producerContext.mo1448f(new b(aVar));
            ThreadHandoffProducerQueueImpl threadHandoffProducerQueueImpl = (ThreadHandoffProducerQueueImpl) this.f4052b;
            synchronized (threadHandoffProducerQueueImpl) {
                threadHandoffProducerQueueImpl.f4074b.execute(aVar);
            }
        } finally {
            FrescoSystrace.m1527b();
        }
    }
}
