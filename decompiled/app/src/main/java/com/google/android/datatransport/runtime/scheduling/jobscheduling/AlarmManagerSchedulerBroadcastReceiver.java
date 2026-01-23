package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import p007b.p225i.p226a.p228b.p231j.AutoValue_TransportContext;
import p007b.p225i.p226a.p228b.p231j.TransportContext;
import p007b.p225i.p226a.p228b.p231j.TransportRuntime;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.AlarmManagerSchedulerBroadcastReceiver2;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.Uploader;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.Uploader6;
import p007b.p225i.p226a.p228b.p231j.p241w.PriorityMapping;

/* JADX INFO: loaded from: classes3.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f19692a = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE);
        int iIntValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        TransportRuntime.m2360b(context);
        TransportContext.a aVarM2358a = TransportContext.m2358a();
        aVarM2358a.mo2352b(queryParameter);
        aVarM2358a.mo2353c(PriorityMapping.m2415b(iIntValue));
        if (queryParameter2 != null) {
            ((AutoValue_TransportContext.b) aVarM2358a).f5262b = Base64.decode(queryParameter2, 0);
        }
        Uploader6 uploader6 = TransportRuntime.m2359a().f5294e;
        uploader6.f5389e.execute(new Uploader(uploader6, aVarM2358a.mo2351a(), i, AlarmManagerSchedulerBroadcastReceiver2.f5352j));
    }
}
