package p007b.p225i.p361c.p369m;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p225i.p361c.p362j.p363a.InterfaceC4549a;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p371i.AnalyticsEventReceiver;

/* JADX INFO: renamed from: b.i.c.m.a, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsAnalyticsListener.java */
/* JADX INFO: loaded from: classes3.dex */
public class CrashlyticsAnalyticsListener implements InterfaceC4549a.b {

    /* JADX INFO: renamed from: a */
    public AnalyticsEventReceiver f12219a;

    /* JADX INFO: renamed from: b */
    public AnalyticsEventReceiver f12220b;

    /* JADX INFO: renamed from: a */
    public void m6361a(int i, @Nullable Bundle bundle) {
        Logger3.f12227a.m6371b("Received Analytics message: " + i + " " + bundle);
        String string = bundle.getString(ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (string != null) {
            Bundle bundle2 = bundle.getBundle("params");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            AnalyticsEventReceiver analyticsEventReceiver = "clx".equals(bundle2.getString("_o")) ? this.f12219a : this.f12220b;
            if (analyticsEventReceiver == null) {
                return;
            }
            analyticsEventReceiver.mo6387b(string, bundle2);
        }
    }
}
