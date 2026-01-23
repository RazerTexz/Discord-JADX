package p007b.p225i.p361c.p398s;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.adjust.sdk.Constants;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import p007b.p225i.p226a.p288f.p298d.C3227b;
import p007b.p225i.p226a.p288f.p298d.C3231f;
import p007b.p225i.p226a.p288f.p298d.C3243r;
import p007b.p225i.p226a.p288f.p298d.C3244s;
import p007b.p225i.p226a.p288f.p298d.C3245t;
import p007b.p225i.p226a.p288f.p298d.C3247v;
import p007b.p225i.p226a.p288f.p298d.ExecutorC3251z;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p397r.HeartBeatInfo;
import p007b.p225i.p361c.p400t.Provider2;
import p007b.p225i.p361c.p401u.AbstractC4847k;
import p007b.p225i.p361c.p401u.InterfaceC4843g;
import p007b.p225i.p361c.p407x.UserAgentPublisher;

/* JADX INFO: renamed from: b.i.c.s.n */
/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C4823n {

    /* JADX INFO: renamed from: a */
    public final FirebaseApp2 f12877a;

    /* JADX INFO: renamed from: b */
    public final C4826q f12878b;

    /* JADX INFO: renamed from: c */
    public final C3227b f12879c;

    /* JADX INFO: renamed from: d */
    public final Provider2<UserAgentPublisher> f12880d;

    /* JADX INFO: renamed from: e */
    public final Provider2<HeartBeatInfo> f12881e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC4843g f12882f;

    public C4823n(FirebaseApp2 firebaseApp2, C4826q c4826q, Provider2<UserAgentPublisher> provider2, Provider2<HeartBeatInfo> provider22, InterfaceC4843g interfaceC4843g) {
        firebaseApp2.m6330a();
        C3227b c3227b = new C3227b(firebaseApp2.f12118d);
        this.f12877a = firebaseApp2;
        this.f12878b = c4826q;
        this.f12879c = c3227b;
        this.f12880d = provider2;
        this.f12881e = provider22;
        this.f12882f = interfaceC4843g;
    }

    /* JADX INFO: renamed from: a */
    public final Task<String> m6727a(Task<Bundle> task) {
        Executor executor = C4817h.f12866a;
        return task.mo6014i(ExecutorC4816g.f12865j, new C4822m(this));
    }

    /* JADX INFO: renamed from: b */
    public final Task<Bundle> m6728b(String str, String str2, String str3, Bundle bundle) {
        int i;
        String str4;
        String strEncodeToString;
        int i2;
        int i3;
        PackageInfo packageInfoM4011b;
        HeartBeatInfo.a aVarMo6716a;
        PackageInfo packageInfoM6732c;
        bundle.putString("scope", str3);
        bundle.putString(NotificationCompat.MessagingStyle.Message.KEY_SENDER, str2);
        bundle.putString("subtype", str2);
        bundle.putString("appid", str);
        FirebaseApp2 firebaseApp2 = this.f12877a;
        firebaseApp2.m6330a();
        bundle.putString("gmp_app_id", firebaseApp2.f12120f.f12135b);
        C4826q c4826q = this.f12878b;
        synchronized (c4826q) {
            if (c4826q.f12888d == 0 && (packageInfoM6732c = c4826q.m6732c("com.google.android.gms")) != null) {
                c4826q.f12888d = packageInfoM6732c.versionCode;
            }
            i = c4826q.f12888d;
        }
        bundle.putString("gmsv", Integer.toString(i));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f12878b.m6731a());
        C4826q c4826q2 = this.f12878b;
        synchronized (c4826q2) {
            if (c4826q2.f12887c == null) {
                c4826q2.m6734e();
            }
            str4 = c4826q2.f12887c;
        }
        bundle.putString("app_ver_name", str4);
        FirebaseApp2 firebaseApp22 = this.f12877a;
        firebaseApp22.m6330a();
        try {
            strEncodeToString = Base64.encodeToString(MessageDigest.getInstance(Constants.SHA1).digest(firebaseApp22.f12119e.getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            strEncodeToString = "[HASH-ERROR]";
        }
        bundle.putString("firebase-app-name-hash", strEncodeToString);
        try {
            String strMo6750a = ((AbstractC4847k) C3404f.m4303j(this.f12882f.mo6756a(false))).mo6750a();
            if (TextUtils.isEmpty(strMo6750a)) {
                Log.w("FirebaseInstanceId", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", strMo6750a);
            }
        } catch (InterruptedException | ExecutionException e) {
            Log.e("FirebaseInstanceId", "Failed to get FIS auth token", e);
        }
        bundle.putString("cliv", "fiid-".concat("21.0.0"));
        HeartBeatInfo heartBeatInfo = this.f12881e.get();
        UserAgentPublisher userAgentPublisher = this.f12880d.get();
        if (heartBeatInfo != null && userAgentPublisher != null && (aVarMo6716a = heartBeatInfo.mo6716a("fire-iid")) != HeartBeatInfo.a.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(aVarMo6716a.m6717f()));
            bundle.putString("Firebase-Client", userAgentPublisher.getUserAgent());
        }
        C3227b c3227b = this.f12879c;
        C3243r c3243r = c3227b.f9248f;
        synchronized (c3243r) {
            if (c3243r.f9284b == 0 && (packageInfoM4011b = c3243r.m4011b("com.google.android.gms")) != null) {
                c3243r.f9284b = packageInfoM4011b.versionCode;
            }
            i2 = c3243r.f9284b;
        }
        if (i2 < 12000000) {
            return !(c3227b.f9248f.m4010a() != 0) ? C3404f.m4261Y(new IOException("MISSING_INSTANCEID_SERVICE")) : c3227b.m4000b(bundle).mo6015j(ExecutorC3251z.f9295j, new C3247v(c3227b, bundle));
        }
        C3231f c3231fM4001a = C3231f.m4001a(c3227b.f9247e);
        synchronized (c3231fM4001a) {
            i3 = c3231fM4001a.f9262e;
            c3231fM4001a.f9262e = i3 + 1;
        }
        return c3231fM4001a.m4002b(new C3244s(i3, bundle)).mo6014i(ExecutorC3251z.f9295j, C3245t.f9286a);
    }
}
