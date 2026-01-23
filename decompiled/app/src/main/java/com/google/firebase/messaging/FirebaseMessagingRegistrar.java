package com.google.firebase.messaging;

import androidx.annotation.Keep;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p228b.Encoding2;
import p007b.p225i.p226a.p228b.Event2;
import p007b.p225i.p226a.p228b.Transformer;
import p007b.p225i.p226a.p228b.Transport2;
import p007b.p225i.p226a.p228b.TransportFactory;
import p007b.p225i.p226a.p228b.TransportScheduleCallback;
import p007b.p225i.p226a.p228b.p229i.CCTDestination;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p368l.Component4;
import p007b.p225i.p361c.p368l.ComponentContainer;
import p007b.p225i.p361c.p368l.ComponentRegistrar;
import p007b.p225i.p361c.p368l.Dependency2;
import p007b.p225i.p361c.p369m.p370d.p383r.DataTransportCrashlyticsReportSender;
import p007b.p225i.p361c.p396q.Subscriber2;
import p007b.p225i.p361c.p397r.HeartBeatInfo;
import p007b.p225i.p361c.p401u.InterfaceC4843g;
import p007b.p225i.p361c.p406w.C4874l;
import p007b.p225i.p361c.p407x.UserAgentPublisher;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class FirebaseMessagingRegistrar implements ComponentRegistrar {

    /* JADX INFO: renamed from: com.google.firebase.messaging.FirebaseMessagingRegistrar$b */
    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static class C11090b<T> implements Transport2<T> {
        public C11090b(C11089a c11089a) {
        }

        @Override // p007b.p225i.p226a.p228b.Transport2
        /* JADX INFO: renamed from: a */
        public void mo2289a(Event2<T> event2) {
        }

        @Override // p007b.p225i.p226a.p228b.Transport2
        /* JADX INFO: renamed from: b */
        public void mo2290b(Event2<T> event2, TransportScheduleCallback transportScheduleCallback) {
            ((DataTransportCrashlyticsReportSender) transportScheduleCallback).mo2292a(null);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.messaging.FirebaseMessagingRegistrar$c */
    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    @VisibleForTesting
    public static class C11091c implements TransportFactory {
        @Override // p007b.p225i.p226a.p228b.TransportFactory
        /* JADX INFO: renamed from: a */
        public <T> Transport2<T> mo2291a(String str, Class<T> cls, Encoding2 encoding2, Transformer<T, byte[]> transformer) {
            return new C11090b(null);
        }
    }

    @VisibleForTesting
    public static TransportFactory determineFactory(TransportFactory transportFactory) {
        if (transportFactory != null) {
            Objects.requireNonNull(CCTDestination.f5127e);
            if (CCTDestination.f5126d.contains(new Encoding2("json"))) {
                return transportFactory;
            }
        }
        return new C11091c();
    }

    public static final /* synthetic */ FirebaseMessaging lambda$getComponents$0$FirebaseMessagingRegistrar(ComponentContainer componentContainer) {
        return new FirebaseMessaging((FirebaseApp2) componentContainer.mo6346a(FirebaseApp2.class), (FirebaseInstanceId) componentContainer.mo6346a(FirebaseInstanceId.class), componentContainer.mo6355b(UserAgentPublisher.class), componentContainer.mo6355b(HeartBeatInfo.class), (InterfaceC4843g) componentContainer.mo6346a(InterfaceC4843g.class), determineFactory((TransportFactory) componentContainer.mo6346a(TransportFactory.class)), (Subscriber2) componentContainer.mo6346a(Subscriber2.class));
    }

    @Override // p007b.p225i.p361c.p368l.ComponentRegistrar
    @Keep
    public List<Component4<?>> getComponents() {
        Component4.b bVarM6348a = Component4.m6348a(FirebaseMessaging.class);
        bVarM6348a.m6351a(new Dependency2(FirebaseApp2.class, 1, 0));
        bVarM6348a.m6351a(new Dependency2(FirebaseInstanceId.class, 1, 0));
        bVarM6348a.m6351a(new Dependency2(UserAgentPublisher.class, 0, 1));
        bVarM6348a.m6351a(new Dependency2(HeartBeatInfo.class, 0, 1));
        bVarM6348a.m6351a(new Dependency2(TransportFactory.class, 0, 0));
        bVarM6348a.m6351a(new Dependency2(InterfaceC4843g.class, 1, 0));
        bVarM6348a.m6351a(new Dependency2(Subscriber2.class, 1, 0));
        bVarM6348a.m6353c(C4874l.f13029a);
        bVarM6348a.m6354d(1);
        return Arrays.asList(bVarM6348a.m6352b(), C3404f.m4228N("fire-fcm", "20.1.7_1p"));
    }
}
