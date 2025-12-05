package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* renamed from: b.i.a.f.i.b.e7 */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC4024e7 implements Runnable {

    /* renamed from: j */
    public final RunnableC4036f7 f10689j;

    /* renamed from: k */
    public final int f10690k;

    /* renamed from: l */
    public final Exception f10691l;

    /* renamed from: m */
    public final byte[] f10692m;

    /* renamed from: n */
    public final Map f10693n;

    public RunnableC4024e7(RunnableC4036f7 runnableC4036f7, int i, Exception exc, byte[] bArr, Map map) {
        this.f10689j = runnableC4036f7;
        this.f10690k = i;
        this.f10691l = exc;
        this.f10692m = bArr;
        this.f10693n = map;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException {
        List<ResolveInfo> listQueryIntentActivities;
        RunnableC4036f7 runnableC4036f7 = this.f10689j;
        int i = this.f10690k;
        Exception exc = this.f10691l;
        byte[] bArr = this.f10692m;
        C4202u4 c4202u4 = runnableC4036f7.f10723k.f11340a;
        boolean z2 = true;
        if (!((i == 200 || i == 204 || i == 304) && exc == null)) {
            c4202u4.mo5726g().f11144i.m5862c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), exc);
            return;
        }
        c4202u4.m5946o().f10655y.m5596a(true);
        if (bArr.length == 0) {
            c4202u4.mo5726g().f11148m.m5860a("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String strOptString = jSONObject.optString(Constants.DEEPLINK, "");
            String strOptString2 = jSONObject.optString("gclid", "");
            double dOptDouble = jSONObject.optDouble("timestamp", 0.0d);
            if (TextUtils.isEmpty(strOptString)) {
                c4202u4.mo5726g().f11148m.m5860a("Deferred Deep Link is empty.");
                return;
            }
            C4196t9 c4196t9M5949t = c4202u4.m5949t();
            if (TextUtils.isEmpty(strOptString) || (listQueryIntentActivities = c4196t9M5949t.f11202a.f11254b.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(strOptString)), 0)) == null || listQueryIntentActivities.isEmpty()) {
                z2 = false;
            }
            if (!z2) {
                c4202u4.mo5726g().f11144i.m5862c("Deferred Deep Link validation failed. gclid, deep link", strOptString2, strOptString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", strOptString2);
            bundle.putString("_cis", "ddp");
            c4202u4.f11269q.m5545H("auto", "_cmp", bundle);
            C4196t9 c4196t9M5949t2 = c4202u4.m5949t();
            if (TextUtils.isEmpty(strOptString) || !c4196t9M5949t2.m5907Y(strOptString, dOptDouble)) {
                return;
            }
            c4196t9M5949t2.f11202a.f11254b.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
        } catch (JSONException e) {
            c4202u4.mo5726g().f11141f.m5861b("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }
}
