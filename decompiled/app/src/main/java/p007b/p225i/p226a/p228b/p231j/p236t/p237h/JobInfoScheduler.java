package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import com.adjust.sdk.Constants;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.Adler32;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p228b.Priority3;
import p007b.p225i.p226a.p228b.p231j.TransportContext;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.SchedulerConfig;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.EventStore;
import p007b.p225i.p226a.p228b.p231j.p241w.PriorityMapping;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.d, reason: use source file name */
/* JADX INFO: compiled from: JobInfoScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(api = 21)
public class JobInfoScheduler implements WorkScheduler {

    /* JADX INFO: renamed from: a */
    public final Context f5361a;

    /* JADX INFO: renamed from: b */
    public final EventStore f5362b;

    /* JADX INFO: renamed from: c */
    public final SchedulerConfig f5363c;

    public JobInfoScheduler(Context context, EventStore eventStore, SchedulerConfig schedulerConfig) {
        this.f5361a = context;
        this.f5362b = eventStore;
        this.f5363c = schedulerConfig;
    }

    @Override // p007b.p225i.p226a.p228b.p231j.p236t.p237h.WorkScheduler
    /* JADX INFO: renamed from: a */
    public void mo2382a(TransportContext transportContext, int i) {
        boolean z2;
        boolean z3;
        char c;
        ComponentName componentName = new ComponentName(this.f5361a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f5361a.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(this.f5361a.getPackageName().getBytes(Charset.forName(Constants.ENCODING)));
        adler32.update(transportContext.mo2348b().getBytes(Charset.forName(Constants.ENCODING)));
        adler32.update(ByteBuffer.allocate(4).putInt(PriorityMapping.m2414a(transportContext.mo2350d())).array());
        if (transportContext.mo2349c() != null) {
            adler32.update(transportContext.mo2349c());
        }
        int value = (int) adler32.getValue();
        Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JobInfo next = it.next();
            int i2 = next.getExtras().getInt("attemptNumber");
            if (next.getId() == value) {
                z2 = i2 >= i;
            }
        }
        if (z2) {
            AnimatableValueParser.m486X("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", transportContext);
            return;
        }
        long jMo2395h0 = this.f5362b.mo2395h0(transportContext);
        SchedulerConfig schedulerConfig = this.f5363c;
        JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
        Priority3 priority3Mo2350d = transportContext.mo2350d();
        builder.setMinimumLatency(schedulerConfig.m2383b(priority3Mo2350d, jMo2395h0, i));
        Set<SchedulerConfig.b> setMo2377c = schedulerConfig.mo2375c().get(priority3Mo2350d).mo2377c();
        if (setMo2377c.contains(SchedulerConfig.b.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
            z3 = true;
        } else {
            z3 = true;
            builder.setRequiredNetworkType(1);
        }
        if (setMo2377c.contains(SchedulerConfig.b.DEVICE_CHARGING)) {
            builder.setRequiresCharging(z3);
        }
        if (setMo2377c.contains(SchedulerConfig.b.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(z3);
        }
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i);
        persistableBundle.putString("backendName", transportContext.mo2348b());
        persistableBundle.putInt("priority", PriorityMapping.m2414a(transportContext.mo2350d()));
        if (transportContext.mo2349c() != null) {
            c = 0;
            persistableBundle.putString(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE, Base64.encodeToString(transportContext.mo2349c(), 0));
        } else {
            c = 0;
        }
        builder.setExtras(persistableBundle);
        Object[] objArr = new Object[5];
        objArr[c] = transportContext;
        objArr[1] = Integer.valueOf(value);
        objArr[2] = Long.valueOf(this.f5363c.m2383b(transportContext.mo2350d(), jMo2395h0, i));
        objArr[3] = Long.valueOf(jMo2395h0);
        objArr[4] = Integer.valueOf(i);
        AnimatableValueParser.m489Y("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr);
        jobScheduler.schedule(builder.build());
    }
}
