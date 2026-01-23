package p007b.p109f.p161j.p181p;

import java.util.Map;
import p007b.p109f.p161j.p176k.RequestListener;
import p007b.p109f.p161j.p176k.RequestListener2;

/* JADX INFO: renamed from: b.f.j.p.b0, reason: use source file name */
/* JADX INFO: compiled from: InternalRequestListener.java */
/* JADX INFO: loaded from: classes3.dex */
public class InternalRequestListener implements RequestListener2, ProducerListener2 {

    /* JADX INFO: renamed from: a */
    public final ProducerListener f3994a;

    /* JADX INFO: renamed from: b */
    public final ProducerListener2 f3995b;

    /* JADX INFO: renamed from: c */
    public final RequestListener f3996c;

    /* JADX INFO: renamed from: d */
    public final RequestListener2 f3997d;

    public InternalRequestListener(RequestListener requestListener, RequestListener2 requestListener2) {
        this.f3994a = requestListener;
        this.f3995b = requestListener2;
        this.f3996c = requestListener;
        this.f3997d = requestListener2;
    }

    @Override // p007b.p109f.p161j.p181p.ProducerListener2
    /* JADX INFO: renamed from: a */
    public void mo1354a(ProducerContext producerContext, String str, String str2) {
        ProducerListener producerListener = this.f3994a;
        if (producerListener != null) {
            producerListener.mo1351h(producerContext.getId(), str, str2);
        }
        ProducerListener2 producerListener2 = this.f3995b;
        if (producerListener2 != null) {
            producerListener2.mo1354a(producerContext, str, str2);
        }
    }

    @Override // p007b.p109f.p161j.p176k.RequestListener2
    /* JADX INFO: renamed from: b */
    public void mo1355b(ProducerContext producerContext) {
        RequestListener requestListener = this.f3996c;
        if (requestListener != null) {
            requestListener.mo1079a(producerContext.mo1447e(), producerContext.mo1444b(), producerContext.getId(), producerContext.mo1453k());
        }
        RequestListener2 requestListener2 = this.f3997d;
        if (requestListener2 != null) {
            requestListener2.mo1355b(producerContext);
        }
    }

    @Override // p007b.p109f.p161j.p181p.ProducerListener2
    /* JADX INFO: renamed from: c */
    public void mo1356c(ProducerContext producerContext, String str, boolean z2) {
        ProducerListener producerListener = this.f3994a;
        if (producerListener != null) {
            producerListener.mo1062e(producerContext.getId(), str, z2);
        }
        ProducerListener2 producerListener2 = this.f3995b;
        if (producerListener2 != null) {
            producerListener2.mo1356c(producerContext, str, z2);
        }
    }

    @Override // p007b.p109f.p161j.p181p.ProducerListener2
    /* JADX INFO: renamed from: d */
    public void mo1357d(ProducerContext producerContext, String str, Map map) {
        ProducerListener producerListener = this.f3994a;
        if (producerListener != null) {
            producerListener.mo1349d(producerContext.getId(), str, map);
        }
        ProducerListener2 producerListener2 = this.f3995b;
        if (producerListener2 != null) {
            producerListener2.mo1357d(producerContext, str, map);
        }
    }

    @Override // p007b.p109f.p161j.p181p.ProducerListener2
    /* JADX INFO: renamed from: e */
    public void mo1358e(ProducerContext producerContext, String str) {
        ProducerListener producerListener = this.f3994a;
        if (producerListener != null) {
            producerListener.mo1348b(producerContext.getId(), str);
        }
        ProducerListener2 producerListener2 = this.f3995b;
        if (producerListener2 != null) {
            producerListener2.mo1358e(producerContext, str);
        }
    }

    @Override // p007b.p109f.p161j.p176k.RequestListener2
    /* JADX INFO: renamed from: f */
    public void mo1359f(ProducerContext producerContext) {
        RequestListener requestListener = this.f3996c;
        if (requestListener != null) {
            requestListener.mo1080c(producerContext.mo1447e(), producerContext.getId(), producerContext.mo1453k());
        }
        RequestListener2 requestListener2 = this.f3997d;
        if (requestListener2 != null) {
            requestListener2.mo1359f(producerContext);
        }
    }

    @Override // p007b.p109f.p161j.p181p.ProducerListener2
    /* JADX INFO: renamed from: g */
    public boolean mo1360g(ProducerContext producerContext, String str) {
        ProducerListener2 producerListener2;
        ProducerListener producerListener = this.f3994a;
        boolean zMo1350f = producerListener != null ? producerListener.mo1350f(producerContext.getId()) : false;
        return (zMo1350f || (producerListener2 = this.f3995b) == null) ? zMo1350f : producerListener2.mo1360g(producerContext, str);
    }

    @Override // p007b.p109f.p161j.p176k.RequestListener2
    /* JADX INFO: renamed from: h */
    public void mo1361h(ProducerContext producerContext, Throwable th) {
        RequestListener requestListener = this.f3996c;
        if (requestListener != null) {
            requestListener.mo1081g(producerContext.mo1447e(), producerContext.getId(), th, producerContext.mo1453k());
        }
        RequestListener2 requestListener2 = this.f3997d;
        if (requestListener2 != null) {
            requestListener2.mo1361h(producerContext, th);
        }
    }

    @Override // p007b.p109f.p161j.p176k.RequestListener2
    /* JADX INFO: renamed from: i */
    public void mo1362i(ProducerContext producerContext) {
        RequestListener requestListener = this.f3996c;
        if (requestListener != null) {
            requestListener.mo1082k(producerContext.getId());
        }
        RequestListener2 requestListener2 = this.f3997d;
        if (requestListener2 != null) {
            requestListener2.mo1362i(producerContext);
        }
    }

    @Override // p007b.p109f.p161j.p181p.ProducerListener2
    /* JADX INFO: renamed from: j */
    public void mo1363j(ProducerContext producerContext, String str, Map map) {
        ProducerListener producerListener = this.f3994a;
        if (producerListener != null) {
            producerListener.mo1352i(producerContext.getId(), str, map);
        }
        ProducerListener2 producerListener2 = this.f3995b;
        if (producerListener2 != null) {
            producerListener2.mo1363j(producerContext, str, map);
        }
    }

    @Override // p007b.p109f.p161j.p181p.ProducerListener2
    /* JADX INFO: renamed from: k */
    public void mo1364k(ProducerContext producerContext, String str, Throwable th, Map map) {
        ProducerListener producerListener = this.f3994a;
        if (producerListener != null) {
            producerListener.mo1353j(producerContext.getId(), str, th, map);
        }
        ProducerListener2 producerListener2 = this.f3995b;
        if (producerListener2 != null) {
            producerListener2.mo1364k(producerContext, str, th, map);
        }
    }
}
