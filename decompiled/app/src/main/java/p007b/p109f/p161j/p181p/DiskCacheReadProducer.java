package p007b.p109f.p161j.p181p;

import java.util.concurrent.CancellationException;
import p007b.p109f.p161j.p175j.EncodedImage2;
import p686z.Continuation3;
import p686z.Task6;

/* compiled from: DiskCacheReadProducer.java */
/* renamed from: b.f.j.p.q, reason: use source file name */
/* loaded from: classes3.dex */
public class DiskCacheReadProducer implements Continuation3<EncodedImage2, Void> {

    /* renamed from: a */
    public final /* synthetic */ ProducerListener2 f4185a;

    /* renamed from: b */
    public final /* synthetic */ ProducerContext f4186b;

    /* renamed from: c */
    public final /* synthetic */ Consumer2 f4187c;

    /* renamed from: d */
    public final /* synthetic */ DiskCacheReadProducer3 f4188d;

    public DiskCacheReadProducer(DiskCacheReadProducer3 diskCacheReadProducer3, ProducerListener2 producerListener2, ProducerContext producerContext, Consumer2 consumer2) {
        this.f4188d = diskCacheReadProducer3;
        this.f4185a = producerListener2;
        this.f4186b = producerContext;
        this.f4187c = consumer2;
    }

    @Override // p686z.Continuation3
    /* renamed from: a */
    public Void mo1510a(Task6<EncodedImage2> task6) throws Exception {
        boolean z2;
        EncodedImage2 encodedImage2;
        synchronized (task6.f27983g) {
            z2 = task6.f27985i;
        }
        if (z2 || (task6.m11370e() && (task6.m11369d() instanceof CancellationException))) {
            this.f4185a.mo1357d(this.f4186b, "DiskCacheProducer", null);
            this.f4187c.mo1426d();
        } else if (task6.m11370e()) {
            this.f4185a.mo1364k(this.f4186b, "DiskCacheProducer", task6.m11369d(), null);
            this.f4188d.f4205d.mo1417b(this.f4187c, this.f4186b);
        } else {
            synchronized (task6.f27983g) {
                encodedImage2 = task6.f27986j;
            }
            EncodedImage2 encodedImage22 = encodedImage2;
            if (encodedImage22 != null) {
                ProducerListener2 producerListener2 = this.f4185a;
                ProducerContext producerContext = this.f4186b;
                producerListener2.mo1363j(producerContext, "DiskCacheProducer", DiskCacheReadProducer3.m1516c(producerListener2, producerContext, true, encodedImage22.m1344n()));
                this.f4185a.mo1356c(this.f4186b, "DiskCacheProducer", true);
                this.f4186b.mo1456n("disk");
                this.f4187c.mo1423a(1.0f);
                this.f4187c.mo1424b(encodedImage22, 1);
                encodedImage22.close();
            } else {
                ProducerListener2 producerListener22 = this.f4185a;
                ProducerContext producerContext2 = this.f4186b;
                producerListener22.mo1363j(producerContext2, "DiskCacheProducer", DiskCacheReadProducer3.m1516c(producerListener22, producerContext2, false, 0));
                this.f4188d.f4205d.mo1417b(this.f4187c, this.f4186b);
            }
        }
        return null;
    }
}
