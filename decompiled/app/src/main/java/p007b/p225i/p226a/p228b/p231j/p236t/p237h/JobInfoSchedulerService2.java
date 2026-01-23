package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.e, reason: use source file name */
/* JADX INFO: compiled from: JobInfoSchedulerService.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class JobInfoSchedulerService2 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final JobInfoSchedulerService f5364j;

    /* JADX INFO: renamed from: k */
    public final JobParameters f5365k;

    public JobInfoSchedulerService2(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f5364j = jobInfoSchedulerService;
        this.f5365k = jobParameters;
    }

    @Override // java.lang.Runnable
    public void run() {
        JobInfoSchedulerService jobInfoSchedulerService = this.f5364j;
        JobParameters jobParameters = this.f5365k;
        int i = JobInfoSchedulerService.f19693j;
        jobInfoSchedulerService.jobFinished(jobParameters, false);
    }
}
