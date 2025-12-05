package p007b.p225i.p361c.p369m.p370d;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4353a;

/* compiled from: Onboarding.java */
/* renamed from: b.i.c.m.d.g, reason: use source file name */
/* loaded from: classes3.dex */
public class Onboarding3 implements InterfaceC4353a<Void, Object> {
    public Onboarding3(Onboarding4 onboarding4) {
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4353a
    /* renamed from: a */
    public Object mo4012a(@NonNull Task<Void> task) throws Exception {
        if (task.mo6021p()) {
            return null;
        }
        Logger3 logger3 = Logger3.f12227a;
        Exception excMo6016k = task.mo6016k();
        if (!logger3.m6370a(6)) {
            return null;
        }
        Log.e("FirebaseCrashlytics", "Error fetching settings.", excMo6016k);
        return null;
    }
}
