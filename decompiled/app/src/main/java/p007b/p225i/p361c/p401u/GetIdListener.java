package p007b.p225i.p361c.p401u;

import com.google.android.gms.tasks.TaskCompletionSource;
import p007b.p225i.p361c.p401u.p402o.PersistedInstallation;
import p007b.p225i.p361c.p401u.p402o.PersistedInstallationEntry;

/* compiled from: GetIdListener.java */
/* renamed from: b.i.c.u.j, reason: use source file name */
/* loaded from: classes3.dex */
public class GetIdListener implements StateListener {

    /* renamed from: a */
    public final TaskCompletionSource<String> f12945a;

    public GetIdListener(TaskCompletionSource<String> taskCompletionSource) {
        this.f12945a = taskCompletionSource;
    }

    @Override // p007b.p225i.p361c.p401u.StateListener
    /* renamed from: a */
    public boolean mo6767a(Exception exc) {
        return false;
    }

    @Override // p007b.p225i.p361c.p401u.StateListener
    /* renamed from: b */
    public boolean mo6768b(PersistedInstallationEntry persistedInstallationEntry) {
        if (!(persistedInstallationEntry.mo6779f() == PersistedInstallation.a.UNREGISTERED) && !persistedInstallationEntry.m6791j() && !persistedInstallationEntry.m6789h()) {
            return false;
        }
        this.f12945a.m9126b(persistedInstallationEntry.mo6776c());
        return true;
    }
}
