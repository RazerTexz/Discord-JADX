package p007b.p225i.p361c.p406w;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.firebase.iid.FirebaseInstanceId;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p393p.ObjectEncoder;
import p007b.p225i.p361c.p393p.ObjectEncoderContext;

/* JADX INFO: renamed from: b.i.c.w.m */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4875m {

    /* JADX INFO: renamed from: a */
    public final String f13030a;

    /* JADX INFO: renamed from: b */
    public final Intent f13031b;

    /* JADX INFO: renamed from: b.i.c.w.m$a */
    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static class a implements ObjectEncoder<C4875m> {
        /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x0163  */
        @Override // p007b.p225i.p361c.p393p.Encoder
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            int iIntValue;
            C4875m c4875m = (C4875m) obj;
            ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
            Intent intent = c4875m.f13031b;
            Object obj2 = intent.getExtras().get("google.ttl");
            int i = 0;
            if (obj2 instanceof Integer) {
                iIntValue = ((Integer) obj2).intValue();
            } else if (obj2 instanceof String) {
                try {
                    iIntValue = Integer.parseInt((String) obj2);
                } catch (NumberFormatException unused) {
                    String strValueOf = String.valueOf(obj2);
                    outline.m854h0(strValueOf.length() + 13, "Invalid TTL: ", strValueOf, "FirebaseMessaging");
                    iIntValue = 0;
                }
            } else {
                iIntValue = 0;
            }
            objectEncoderContext2.mo6707c("ttl", iIntValue);
            objectEncoderContext2.mo6708f("event", c4875m.f13030a);
            FirebaseInstanceId firebaseInstanceId = FirebaseInstanceId.getInstance(FirebaseApp2.m6327b());
            FirebaseInstanceId.m9178c(firebaseInstanceId.f21437f);
            if (firebaseInstanceId.m9192p(firebaseInstanceId.m9187j())) {
                synchronized (firebaseInstanceId) {
                    if (!firebaseInstanceId.f21442k) {
                        firebaseInstanceId.m9191o(0L);
                    }
                }
            }
            objectEncoderContext2.mo6708f("instanceId", firebaseInstanceId.m9182e());
            String stringExtra = intent.getStringExtra("google.delivered_priority");
            if (stringExtra == null) {
                if (!"1".equals(intent.getStringExtra("google.priority_reduced"))) {
                    stringExtra = intent.getStringExtra("google.priority");
                    if (!Constants.HIGH.equals(stringExtra)) {
                    }
                }
                i = 2;
            } else if (!Constants.HIGH.equals(stringExtra)) {
                i = 1;
            } else if (Constants.NORMAL.equals(stringExtra)) {
                i = 2;
            }
            objectEncoderContext2.mo6707c("priority", i);
            FirebaseApp2 firebaseApp2M6327b = FirebaseApp2.m6327b();
            firebaseApp2M6327b.m6330a();
            objectEncoderContext2.mo6708f("packageName", firebaseApp2M6327b.f12118d.getPackageName());
            objectEncoderContext2.mo6708f("sdkPlatform", "ANDROID");
            objectEncoderContext2.mo6708f("messageType", (intent.getExtras() == null || !C4880r.m6820f(intent.getExtras())) ? "DATA_MESSAGE" : "DISPLAY_NOTIFICATION");
            String stringExtra2 = intent.getStringExtra("google.message_id");
            if (stringExtra2 == null) {
                stringExtra2 = intent.getStringExtra("message_id");
            }
            if (stringExtra2 != null) {
                objectEncoderContext2.mo6708f("messageId", stringExtra2);
            }
            String strM6817a = C4879q.m6817a(intent);
            if (strM6817a != null) {
                objectEncoderContext2.mo6708f(ModelAuditLogEntry.CHANGE_KEY_TOPIC, strM6817a);
            }
            String stringExtra3 = intent.getStringExtra("collapse_key");
            if (stringExtra3 != null) {
                objectEncoderContext2.mo6708f("collapseKey", stringExtra3);
            }
            if (intent.getStringExtra("google.c.a.m_l") != null) {
                objectEncoderContext2.mo6708f("analyticsLabel", intent.getStringExtra("google.c.a.m_l"));
            }
            if (intent.getStringExtra("google.c.a.c_l") != null) {
                objectEncoderContext2.mo6708f("composerLabel", intent.getStringExtra("google.c.a.c_l"));
            }
            FirebaseApp2 firebaseApp2M6327b2 = FirebaseApp2.m6327b();
            firebaseApp2M6327b2.m6330a();
            String str = firebaseApp2M6327b2.f12120f.f12138e;
            if (str == null) {
                firebaseApp2M6327b2.m6330a();
                str = firebaseApp2M6327b2.f12120f.f12135b;
                if (str.startsWith("1:")) {
                    String[] strArrSplit = str.split(":");
                    if (strArrSplit.length < 2) {
                        str = null;
                    } else {
                        str = strArrSplit[1];
                        if (str.isEmpty()) {
                        }
                    }
                }
            }
            if (str != null) {
                objectEncoderContext2.mo6708f("projectNumber", str);
            }
        }
    }

    /* JADX INFO: renamed from: b.i.c.w.m$b */
    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final C4875m f13032a;

        public b(@NonNull C4875m c4875m) {
            this.f13032a = c4875m;
        }
    }

    /* JADX INFO: renamed from: b.i.c.w.m$c */
    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static final class c implements ObjectEncoder<b> {
        @Override // p007b.p225i.p361c.p393p.Encoder
        /* JADX INFO: renamed from: a */
        public final void mo2312a(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.mo6708f("messaging_client_event", ((b) obj).f13032a);
        }
    }

    public C4875m(@NonNull String str, @NonNull Intent intent) {
        AnimatableValueParser.m579v(str, "evenType must be non-null");
        this.f13030a = str;
        AnimatableValueParser.m595z(intent, "intent must be non-null");
        this.f13031b = intent;
    }
}
