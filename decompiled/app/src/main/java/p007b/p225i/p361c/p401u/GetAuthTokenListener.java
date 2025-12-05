package p007b.p225i.p361c.p401u;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p401u.p402o.PersistedInstallationEntry;

/* compiled from: GetAuthTokenListener.java */
/* renamed from: b.i.c.u.i, reason: use source file name */
/* loaded from: classes3.dex */
public class GetAuthTokenListener implements StateListener {

    /* renamed from: a */
    public final Utils6 f12943a;

    /* renamed from: b */
    public final TaskCompletionSource<AbstractC4847k> f12944b;

    public GetAuthTokenListener(Utils6 utils6, TaskCompletionSource<AbstractC4847k> taskCompletionSource) {
        this.f12943a = utils6;
        this.f12944b = taskCompletionSource;
    }

    @Override // p007b.p225i.p361c.p401u.StateListener
    /* renamed from: a */
    public boolean mo6767a(Exception exc) {
        this.f12944b.m9125a(exc);
        return true;
    }

    @Override // p007b.p225i.p361c.p401u.StateListener
    /* renamed from: b */
    public boolean mo6768b(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.m6791j() || this.f12943a.m6773d(persistedInstallationEntry)) {
            return false;
        }
        TaskCompletionSource<AbstractC4847k> taskCompletionSource = this.f12944b;
        String strMo6774a = persistedInstallationEntry.mo6774a();
        Objects.requireNonNull(strMo6774a, "Null token");
        Long lValueOf = Long.valueOf(persistedInstallationEntry.mo6775b());
        Long lValueOf2 = Long.valueOf(persistedInstallationEntry.mo6780g());
        String strM883w = lValueOf == null ? outline.m883w("", " tokenExpirationTimestamp") : "";
        if (lValueOf2 == null) {
            strM883w = outline.m883w(strM883w, " tokenCreationTimestamp");
        }
        if (!strM883w.isEmpty()) {
            throw new IllegalStateException(outline.m883w("Missing required properties:", strM883w));
        }
        taskCompletionSource.f20845a.m6024s(new C4837a(strMo6774a, lValueOf.longValue(), lValueOf2.longValue(), null));
        return true;
    }
}
