package p007b.p225i.p361c.p398s;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4353a;

/* JADX INFO: renamed from: b.i.c.s.m */
/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C4822m implements InterfaceC4353a {

    /* JADX INFO: renamed from: a */
    public final C4823n f12876a;

    public C4822m(C4823n c4823n) {
        this.f12876a = c4823n;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4353a
    /* JADX INFO: renamed from: a */
    public final Object mo4012a(Task task) throws IOException {
        Objects.requireNonNull(this.f12876a);
        Bundle bundle = (Bundle) task.mo6018m(IOException.class);
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string != null || (string = bundle.getString("unregistered")) != null) {
            return string;
        }
        String string2 = bundle.getString("error");
        if ("RST".equals(string2)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if (string2 != null) {
            throw new IOException(string2);
        }
        String strValueOf = String.valueOf(bundle);
        Log.w("FirebaseInstanceId", outline.m857j(strValueOf.length() + 21, "Unexpected response: ", strValueOf), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }
}
