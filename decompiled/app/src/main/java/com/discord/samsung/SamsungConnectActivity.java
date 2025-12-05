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
import com.discord.BuildConfig;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p048r.SamsungConnectActivity3;
import p007b.p100d.p104b.p105a.outline;
import p007b.p449n.p450a.p451a.ISACallback;
import p007b.p449n.p450a.p451a.ISAService;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SamsungConnectActivity.kt */
/* loaded from: classes.dex */
public final class SamsungConnectActivity extends AppCompatActivity {

    /* renamed from: j, reason: from kotlin metadata */
    public ISACallback samsungAccountServiceCallback;

    /* renamed from: k, reason: from kotlin metadata */
    public boolean serviceBound;

    /* renamed from: l, reason: from kotlin metadata */
    public final ServiceConnectionC5650a serviceConnection = new ServiceConnectionC5650a();

    /* compiled from: SamsungConnectActivity.kt */
    public static abstract class Result {

        /* compiled from: SamsungConnectActivity.kt */
        public static final /* data */ class Failure extends Result {

            /* renamed from: a, reason: from kotlin metadata */
            public final boolean isRetryAllowed;

            /* renamed from: b, reason: from kotlin metadata */
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
                StringBuilder sbM833U = outline.m833U("Failure(isRetryAllowed=");
                sbM833U.append(this.isRetryAllowed);
                sbM833U.append(", attemptCount=");
                return outline.m814B(sbM833U, this.attemptCount, ")");
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

            /* renamed from: b, reason: from kotlin metadata */
            public final String serverUrl;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(String str, String str2) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "authCode");
                Intrinsics3.checkNotNullParameter(str2, "serverUrl");
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
                return Intrinsics3.areEqual(this.authCode, success.authCode) && Intrinsics3.areEqual(this.serverUrl, success.serverUrl);
            }

            public int hashCode() {
                String str = this.authCode;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.serverUrl;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Success(authCode=");
                sbM833U.append(this.authCode);
                sbM833U.append(", serverUrl=");
                return outline.m822J(sbM833U, this.serverUrl, ")");
            }
        }

        public Result() {
        }

        public Result(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: SamsungConnectActivity.kt */
    /* renamed from: com.discord.samsung.SamsungConnectActivity$a */
    public static final class ServiceConnectionC5650a implements ServiceConnection {
        public ServiceConnectionC5650a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ISAService c13241a;
            SamsungConnectActivity.this.serviceBound = true;
            int i = ISAService.a.f13676a;
            if (iBinder == null) {
                c13241a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.msc.sa.aidl.ISAService");
                c13241a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ISAService)) ? new ISAService.a.C13241a(iBinder) : (ISAService) iInterfaceQueryLocalInterface;
            }
            Log.i("Discord", "Samsung Account service connection established");
            try {
                ISACallback iSACallback = SamsungConnectActivity.this.samsungAccountServiceCallback;
                if (iSACallback == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("samsungAccountServiceCallback");
                }
                String strMo7153Q = c13241a.mo7153Q("97t47j218f", "dummy", BuildConfig.APPLICATION_ID, iSACallback);
                Log.i("Discord", "Samsung Account service connection established: " + strMo7153Q);
                if (strMo7153Q == null) {
                    SamsungConnectActivity samsungConnectActivity = SamsungConnectActivity.this;
                    samsungConnectActivity.setResult(500, new Intent().putExtra("com.discord.samsung.intent.extra.ATTEMPT_COUNT", samsungConnectActivity.getIntent().getIntExtra("com.discord.samsung.intent.extra.ATTEMPT_COUNT", 0) + 1));
                    samsungConnectActivity.finish();
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putStringArray("additional", new String[]{"api_server_url", "auth_server_url"});
                boolean zMo7154h0 = c13241a.mo7154h0(1221, strMo7153Q, bundle);
                Log.i("Discord", "Samsung Account service connection established: isReqSucc? " + zMo7154h0);
                if (!zMo7154h0) {
                    throw new Exception("Call Samsung.requestAuthCode failed");
                }
            } catch (Throwable th) {
                Log.e("Discord", "Unable to connect to Samsung", th);
                SamsungConnectActivity.m8503a(SamsungConnectActivity.this, null, null);
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m8503a(SamsungConnectActivity samsungConnectActivity, String str, String str2) {
        Objects.requireNonNull(samsungConnectActivity);
        boolean z2 = true;
        if (str == null || StringsJVM.isBlank(str)) {
            samsungConnectActivity.setResult(0);
        } else {
            if (str2 != null && !StringsJVM.isBlank(str2)) {
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

    /* renamed from: b */
    public static final void m8504b(Context context, ActivityResultLauncher<Intent> activityResultLauncher, int i) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(activityResultLauncher, "launcher");
        Intent intentAddFlags = new Intent(context, (Class<?>) SamsungConnectActivity.class).putExtra("com.discord.samsung.intent.extra.ATTEMPT_COUNT", i).addFlags(65536);
        Intrinsics3.checkNotNullExpressionValue(intentAddFlags, "Intent(context, SamsungC…AG_ACTIVITY_NO_ANIMATION)");
        activityResultLauncher.launch(intentAddFlags);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.samsungAccountServiceCallback = new SamsungConnectActivity3(this);
        Intent intent = new Intent("com.msc.action.samsungaccount.REQUEST_SERVICE").setPackage("com.osp.app.signin");
        Intrinsics3.checkNotNullExpressionValue(intent, "Intent(SA_ACCOUNT_ACTION…ckage(SA_ACCOUNT_SERVICE)");
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
