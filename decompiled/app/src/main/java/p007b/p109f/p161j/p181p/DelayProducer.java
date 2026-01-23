package p007b.p109f.p161j.p181p;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import p007b.p109f.p161j.p175j.CloseableImage;

/* JADX INFO: renamed from: b.f.j.p.o, reason: use source file name */
/* JADX INFO: compiled from: DelayProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class DelayProducer implements Producer2<CloseableReference<CloseableImage>> {

    /* JADX INFO: renamed from: a */
    public final Producer2<CloseableReference<CloseableImage>> f4174a;

    /* JADX INFO: renamed from: b */
    public final ScheduledExecutorService f4175b;

    /* JADX INFO: renamed from: b.f.j.p.o$a */
    /* JADX INFO: compiled from: DelayProducer.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Consumer2 f4176j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ ProducerContext f4177k;

        public a(Consumer2 consumer2, ProducerContext producerContext) {
            this.f4176j = consumer2;
            this.f4177k = producerContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            DelayProducer.this.f4174a.mo1417b(this.f4176j, this.f4177k);
        }
    }

    public DelayProducer(Producer2<CloseableReference<CloseableImage>> producer2, ScheduledExecutorService scheduledExecutorService) {
        this.f4174a = producer2;
        this.f4175b = scheduledExecutorService;
    }

    @Override // p007b.p109f.p161j.p181p.Producer2
    /* JADX INFO: renamed from: b */
    public void mo1417b(Consumer2<CloseableReference<CloseableImage>> consumer2, ProducerContext producerContext) {
        ImageRequest imageRequestMo1447e = producerContext.mo1447e();
        ScheduledExecutorService scheduledExecutorService = this.f4175b;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.schedule(new a(consumer2, producerContext), imageRequestMo1447e.f19603u, TimeUnit.MILLISECONDS);
        } else {
            this.f4174a.mo1417b(consumer2, producerContext);
        }
    }
}
