package com.discord.samsung;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import b.a.r.d;
import b.n.a.a.b;
import com.discord.BuildConfig;
import d0.g0.t;
import d0.z.d.m;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SamsungConnectActivity.kt */
/* loaded from: classes.dex */
public final class SamsungConnectActivity extends AppCompatActivity {

    /* renamed from: j, reason: from kotlin metadata */
    public b.n.a.a.a samsungAccountServiceCallback;

    /* renamed from: k, reason: from kotlin metadata */
    public boolean serviceBound;

    /* renamed from: l, reason: from kotlin metadata */
    public final a serviceConnection = new a();

    /* compiled from: SamsungConnectActivity.kt */
    public static abstract class Result {

        /* compiled from: SamsungConnectActivity.kt */
        public static final /* data */ class Failure extends Result {

            /* renamed from: a, reason: from kotlin metadata */
            public final boolean isRetryAllowed;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            public final int attemptCount;

            public Failure(boolean z2, int i) {
                super(null);
                this.isRetryAllowed = z2;
                this.attemptCount = i;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Failure)) {
                    return false;
                }
                Failure failure = (Failure) other;
                return this.isRetryAllowed == failure.isRetryAllowed && this.attemptCount == failure.attemptCount;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            public int hashCode() {
                boolean z2 = this.isRetryAllowed;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                return (r0 * 31) + this.attemptCount;
            }

            public String toString() {
                StringBuilder sbU = b.d.b.a.a.U("Failure(isRetryAllowed=");
                sbU.append(this.isRetryAllowed);
                sbU.append(", attemptCount=");
                return b.d.b.a.a.B(sbU, this.attemptCount, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Failure(boolean z2, int i, int i2) {
                super(null);
                i = (i2 & 2) != 0 ? 0 : i;
                this.isRetryAllowed = z2;
                this.attemptCount = i;
            }
        }

        /* compiled from: SamsungConnectActivity.kt */
        public static final /* data */ class Success extends Result {

            /* renamed from: a, reason: from kotlin metadata */
            public final String authCode;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            public final String serverUrl;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(String str, String str2) {
                super(null);
                m.checkNotNullParameter(str, "authCode");
                m.checkNotNullParameter(str2, "serverUrl");
                this.authCode = str;
                this.serverUrl = str2;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return m.areEqual(this.authCode, success.authCode) && m.areEqual(this.serverUrl, success.serverUrl);
            }

            public int hashCode() {
                String str = this.authCode;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.serverUrl;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = b.d.b.a.a.U("Success(authCode=");
                sbU.append(this.authCode);
                sbU.append(", serverUrl=");
                return b.d.b.a.a.J(sbU, this.serverUrl, ")");
            }
        }

        public Result() {
        }

        public Result(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: SamsungConnectActivity.kt */
    public static final class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b c0165a;
            SamsungConnectActivity.this.serviceBound = true;
            int i = b.a.a;
            if (iBinder == null) {
                c0165a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.msc.sa.aidl.ISAService");
                c0165a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new b.a.C0165a(iBinder) : (b) iInterfaceQueryLocalInterface;
            }
            Log.i("Discord", "Samsung Account service connection established");
            try {
                b.n.a.a.a aVar = SamsungConnectActivity.this.samsungAccountServiceCallback;
                if (aVar == null) {
                    m.throwUninitializedPropertyAccessException("samsungAccountServiceCallback");
                }
                String strQ = c0165a.Q("97t47j218f", "dummy", BuildConfig.APPLICATION_ID, aVar);
                Log.i("Discord", "Samsung Account service connection established: " + strQ);
                if (strQ == null) {
                    SamsungConnectActivity samsungConnectActivity = SamsungConnectActivity.this;
                    samsungConnectActivity.setResult(500, new Intent().putExtra("com.discord.samsung.intent.extra.ATTEMPT_COUNT", samsungConnectActivity.getIntent().getIntExtra("com.discord.samsung.intent.extra.ATTEMPT_COUNT", 0) + 1));
                    samsungConnectActivity.finish();
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putStringArray("additional", new String[]{"api_server_url", "auth_server_url"});
                boolean zH0 = c0165a.h0(1221, strQ, bundle);
                Log.i("Discord", "Samsung Account service connection established: isReqSucc? " + zH0);
                if (!zH0) {
                    throw new Exception("Call Samsung.requestAuthCode failed");
                }
            } catch (Throwable th) {
                Log.e("Discord", "Unable to connect to Samsung", th);
                SamsungConnectActivity.a(SamsungConnectActivity.this, null, null);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i("Discord", "Samsung Account service connection unbound");
            SamsungConnectActivity samsungConnectActivity = SamsungConnectActivity.this;
            samsungConnectActivity.serviceBound = false;
            samsungConnectActivity.finish();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(SamsungConnectActivity samsungConnectActivity, String str, String str2) {
        Objects.requireNonNull(samsungConnectActivity);
        boolean z2 = true;
        if (str == null || t.isBlank(str)) {
            samsungConnectActivity.setResult(0);
        } else {
            if (str2 != null && !t.isBlank(str2)) {
                z2 = false;
            }
            if (!z2) {
                Intent intent = new Intent();
                intent.putExtra("com.discord.samsung.intent.extra.AUTH_CODE", str);
                intent.putExtra("com.discord.samsung.intent.extra.SERVER_URL", str2);
                samsungConnectActivity.setResult(-1, intent);
            }
        }
        samsungConnectActivity.finish();
    }

    public static final void b(Context context, ActivityResultLauncher<Intent> activityResultLauncher, int i) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(activityResultLauncher, "launcher");
        Intent intentAddFlags = new Intent(context, (Class<?>) SamsungConnectActivity.class).putExtra("com.discord.samsung.intent.extra.ATTEMPT_COUNT", i).addFlags(65536);
        m.checkNotNullExpressionValue(intentAddFlags, "Intent(context, SamsungC…AG_ACTIVITY_NO_ANIMATION)");
        activityResultLauncher.launch(intentAddFlags);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.samsungAccountServiceCallback = new d(this);
        Intent intent = new Intent("com.msc.action.samsungaccount.REQUEST_SERVICE").setPackage("com.osp.app.signin");
        m.checkNotNullExpressionValue(intent, "Intent(SA_ACCOUNT_ACTION…ckage(SA_ACCOUNT_SERVICE)");
        Log.i("Discord", "Samsung starting SA Service");
        if (startService(intent) == null) {
            Log.e("Discord", "Samsung Account service could not be started");
        } else {
            if (bindService(intent, this.serviceConnection, 1)) {
                return;
            }
            Log.e("Discord", "Samsung Account service could not be bound");
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        if (this.serviceBound) {
            unbindService(this.serviceConnection);
            this.serviceBound = false;
        }
        super.onStop();
    }
}
