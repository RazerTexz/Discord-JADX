package p007b.p225i.p361c.p406w;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.messaging.FirebaseMessagingService;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p362j.p363a.InterfaceC4549a;
import p007b.p225i.p361c.p393p.DataEncoder;
import p007b.p225i.p361c.p393p.p395h.JsonDataEncoderBuilder4;
import p007b.p225i.p361c.p393p.p395h.JsonDataEncoderBuilder5;
import p007b.p225i.p361c.p406w.C4875m;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* renamed from: b.i.c.w.q */
/* loaded from: classes3.dex */
public class C4879q {

    /* renamed from: a */
    public static final DataEncoder f13038a;

    static {
        JsonDataEncoderBuilder5 jsonDataEncoderBuilder5 = new JsonDataEncoderBuilder5();
        jsonDataEncoderBuilder5.f12822b.put(C4875m.b.class, new C4875m.c());
        jsonDataEncoderBuilder5.f12823c.remove(C4875m.b.class);
        jsonDataEncoderBuilder5.f12822b.put(C4875m.class, new C4875m.a());
        jsonDataEncoderBuilder5.f12823c.remove(C4875m.class);
        f13038a = new JsonDataEncoderBuilder4(jsonDataEncoderBuilder5);
    }

    @Nullable
    /* renamed from: a */
    public static String m6817a(Intent intent) {
        String stringExtra = intent.getStringExtra("from");
        if (stringExtra == null || !stringExtra.startsWith("/topics/")) {
            return null;
        }
        return stringExtra;
    }

    @VisibleForTesting
    /* renamed from: b */
    public static void m6818b(String str, Intent intent) {
        Bundle bundle = new Bundle();
        String stringExtra = intent.getStringExtra("google.c.a.c_id");
        if (stringExtra != null) {
            bundle.putString("_nmid", stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("google.c.a.c_l");
        if (stringExtra2 != null) {
            bundle.putString("_nmn", stringExtra2);
        }
        String stringExtra3 = intent.getStringExtra("google.c.a.m_l");
        if (!TextUtils.isEmpty(stringExtra3)) {
            bundle.putString("label", stringExtra3);
        }
        String stringExtra4 = intent.getStringExtra("google.c.a.m_c");
        if (!TextUtils.isEmpty(stringExtra4)) {
            bundle.putString("message_channel", stringExtra4);
        }
        String strM6817a = m6817a(intent);
        if (strM6817a != null) {
            bundle.putString("_nt", strM6817a);
        }
        String stringExtra5 = intent.getStringExtra("google.c.a.ts");
        if (stringExtra5 != null) {
            try {
                bundle.putInt("_nmt", Integer.parseInt(stringExtra5));
            } catch (NumberFormatException e) {
                Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e);
            }
        }
        String stringExtra6 = intent.hasExtra("google.c.a.udt") ? intent.getStringExtra("google.c.a.udt") : null;
        if (stringExtra6 != null) {
            try {
                bundle.putInt("_ndt", Integer.parseInt(stringExtra6));
            } catch (NumberFormatException e2) {
                Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e2);
            }
        }
        String str2 = (intent.getExtras() == null || !C4880r.m6820f(intent.getExtras())) ? "data" : "display";
        if ("_nr".equals(str) || "_nf".equals(str)) {
            bundle.putString("_nmc", str2);
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String strValueOf = String.valueOf(bundle);
            Log.d("FirebaseMessaging", outline.m861l(strValueOf.length() + str.length() + 37, "Logging to scion event=", str, " scionPayload=", strValueOf));
        }
        FirebaseApp2 firebaseApp2M6327b = FirebaseApp2.m6327b();
        firebaseApp2M6327b.m6330a();
        InterfaceC4549a interfaceC4549a = (InterfaceC4549a) firebaseApp2M6327b.f12121g.mo6346a(InterfaceC4549a.class);
        if (interfaceC4549a != null) {
            interfaceC4549a.mo6338a("fcm", str, bundle);
        } else {
            Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
        }
    }

    /* renamed from: c */
    public static boolean m6819c(Intent intent) {
        if (intent == null || FirebaseMessagingService.ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(intent.getAction())) {
            return false;
        }
        return "1".equals(intent.getStringExtra("google.c.a.e"));
    }
}
