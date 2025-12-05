package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import p007b.p225i.p226a.p228b.p231j.AutoValue_TransportContext;
import p007b.p225i.p226a.p228b.p231j.TransportContext;
import p007b.p225i.p226a.p228b.p231j.TransportRuntime;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.JobInfoSchedulerService2;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.Uploader;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.Uploader6;
import p007b.p225i.p226a.p228b.p231j.p241w.PriorityMapping;

@RequiresApi(api = 21)
/* loaded from: classes3.dex */
public class JobInfoSchedulerService extends JobService {

    /* renamed from: j */
    public static final /* synthetic */ int f19693j = 0;

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE);
        int i = jobParameters.getExtras().getInt("priority");
        int i2 = jobParameters.getExtras().getInt("attemptNumber");
        TransportRuntime.m2360b(getApplicationContext());
        TransportContext.a aVarM2358a = TransportContext.m2358a();
        aVarM2358a.mo2352b(string);
        aVarM2358a.mo2353c(PriorityMapping.m2415b(i));
        if (string2 != null) {
            ((AutoValue_TransportContext.b) aVarM2358a).f5262b = Base64.decode(string2, 0);
        }
        Uploader6 uploader6 = TransportRuntime.m2359a().f5294e;
        uploader6.f5389e.execute(new Uploader(uploader6, aVarM2358a.mo2351a(), i2, new JobInfoSchedulerService2(this, jobParameters)));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
