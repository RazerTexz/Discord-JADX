package p007b.p225i.p226a.p228b.p231j.p236t;

import java.util.logging.Logger;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p228b.TransportScheduleCallback;
import p007b.p225i.p226a.p228b.p231j.EventInternal;
import p007b.p225i.p226a.p228b.p231j.TransportContext;
import p007b.p225i.p226a.p228b.p231j.p232q.TransportBackend;

/* JADX INFO: renamed from: b.i.a.b.j.t.a, reason: use source file name */
/* JADX INFO: compiled from: DefaultScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class DefaultScheduler implements Runnable {

    /* JADX INFO: renamed from: j */
    public final DefaultScheduler3 f5329j;

    /* JADX INFO: renamed from: k */
    public final TransportContext f5330k;

    /* JADX INFO: renamed from: l */
    public final TransportScheduleCallback f5331l;

    /* JADX INFO: renamed from: m */
    public final EventInternal f5332m;

    public DefaultScheduler(DefaultScheduler3 defaultScheduler3, TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        this.f5329j = defaultScheduler3;
        this.f5330k = transportContext;
        this.f5331l = transportScheduleCallback;
        this.f5332m = eventInternal;
    }

    @Override // java.lang.Runnable
    public void run() {
        DefaultScheduler3 defaultScheduler3 = this.f5329j;
        TransportContext transportContext = this.f5330k;
        TransportScheduleCallback transportScheduleCallback = this.f5331l;
        EventInternal eventInternal = this.f5332m;
        Logger logger = DefaultScheduler3.f5336a;
        try {
            TransportBackend transportBackend = defaultScheduler3.f5339d.get(transportContext.mo2348b());
            if (transportBackend == null) {
                String str = String.format("Transport backend '%s' is not registered", transportContext.mo2348b());
                DefaultScheduler3.f5336a.warning(str);
                transportScheduleCallback.mo2292a(new IllegalArgumentException(str));
            } else {
                defaultScheduler3.f5341f.mo2406a(new DefaultScheduler2(defaultScheduler3, transportContext, transportBackend.mo2298b(eventInternal)));
                transportScheduleCallback.mo2292a(null);
            }
        } catch (Exception e) {
            Logger logger2 = DefaultScheduler3.f5336a;
            StringBuilder sbM833U = outline.m833U("Error scheduling event ");
            sbM833U.append(e.getMessage());
            logger2.warning(sbM833U.toString());
            transportScheduleCallback.mo2292a(e);
        }
    }
}
