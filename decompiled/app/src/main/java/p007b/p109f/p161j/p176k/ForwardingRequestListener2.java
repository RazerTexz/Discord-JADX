package p007b.p109f.p161j.p176k;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p161j.p181p.ProducerContext;

/* JADX INFO: renamed from: b.f.j.k.b, reason: use source file name */
/* JADX INFO: compiled from: ForwardingRequestListener2.java */
/* JADX INFO: loaded from: classes.dex */
public class ForwardingRequestListener2 implements RequestListener2 {

    /* JADX INFO: renamed from: a */
    public final List<RequestListener2> f3912a;

    public ForwardingRequestListener2(Set<RequestListener2> set) {
        this.f3912a = new ArrayList(set.size());
        for (RequestListener2 requestListener2 : set) {
            if (requestListener2 != null) {
                this.f3912a.add(requestListener2);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.ProducerListener2
    /* JADX INFO: renamed from: a */
    public void mo1354a(ProducerContext producerContext, String str, String str2) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1354a(producerContext, str, str2);
            } catch (Exception e) {
                FLog.m978f("ForwardingRequestListener2", "InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p176k.RequestListener2
    /* JADX INFO: renamed from: b */
    public void mo1355b(ProducerContext producerContext) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1355b(producerContext);
            } catch (Exception e) {
                FLog.m978f("ForwardingRequestListener2", "InternalListener exception in onRequestStart", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.ProducerListener2
    /* JADX INFO: renamed from: c */
    public void mo1356c(ProducerContext producerContext, String str, boolean z2) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1356c(producerContext, str, z2);
            } catch (Exception e) {
                FLog.m978f("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.ProducerListener2
    /* JADX INFO: renamed from: d */
    public void mo1357d(ProducerContext producerContext, String str, Map<String, String> map) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1357d(producerContext, str, map);
            } catch (Exception e) {
                FLog.m978f("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.ProducerListener2
    /* JADX INFO: renamed from: e */
    public void mo1358e(ProducerContext producerContext, String str) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1358e(producerContext, str);
            } catch (Exception e) {
                FLog.m978f("ForwardingRequestListener2", "InternalListener exception in onProducerStart", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p176k.RequestListener2
    /* JADX INFO: renamed from: f */
    public void mo1359f(ProducerContext producerContext) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1359f(producerContext);
            } catch (Exception e) {
                FLog.m978f("ForwardingRequestListener2", "InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.ProducerListener2
    /* JADX INFO: renamed from: g */
    public boolean mo1360g(ProducerContext producerContext, String str) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            if (this.f3912a.get(i).mo1360g(producerContext, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // p007b.p109f.p161j.p176k.RequestListener2
    /* JADX INFO: renamed from: h */
    public void mo1361h(ProducerContext producerContext, Throwable th) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1361h(producerContext, th);
            } catch (Exception e) {
                FLog.m978f("ForwardingRequestListener2", "InternalListener exception in onRequestFailure", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p176k.RequestListener2
    /* JADX INFO: renamed from: i */
    public void mo1362i(ProducerContext producerContext) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1362i(producerContext);
            } catch (Exception e) {
                FLog.m978f("ForwardingRequestListener2", "InternalListener exception in onRequestCancellation", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.ProducerListener2
    /* JADX INFO: renamed from: j */
    public void mo1363j(ProducerContext producerContext, String str, Map<String, String> map) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1363j(producerContext, str, map);
            } catch (Exception e) {
                FLog.m978f("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.ProducerListener2
    /* JADX INFO: renamed from: k */
    public void mo1364k(ProducerContext producerContext, String str, Throwable th, Map<String, String> map) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1364k(producerContext, str, th, map);
            } catch (Exception e) {
                FLog.m978f("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }
}
