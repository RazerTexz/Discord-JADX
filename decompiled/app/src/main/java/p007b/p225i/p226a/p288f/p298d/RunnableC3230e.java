package p007b.p225i.p226a.p288f.p298d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* renamed from: b.i.a.f.d.e */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC3230e implements Runnable {

    /* renamed from: j */
    public final AbstractC3226a f9253j;

    /* renamed from: k */
    public final Intent f9254k;

    /* renamed from: l */
    public final Context f9255l;

    /* renamed from: m */
    public final boolean f9256m;

    /* renamed from: n */
    public final BroadcastReceiver.PendingResult f9257n;

    public RunnableC3230e(AbstractC3226a abstractC3226a, Intent intent, Context context, boolean z2, BroadcastReceiver.PendingResult pendingResult) {
        this.f9253j = abstractC3226a;
        this.f9254k = intent;
        this.f9255l = context;
        this.f9256m = z2;
        this.f9257n = pendingResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC3226a abstractC3226a = this.f9253j;
        Intent intent = this.f9254k;
        Context context = this.f9255l;
        boolean z2 = this.f9256m;
        BroadcastReceiver.PendingResult pendingResult = this.f9257n;
        Objects.requireNonNull(abstractC3226a);
        try {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            int iM3997a = intent2 != null ? abstractC3226a.m3997a(context, intent2) : abstractC3226a.m3998b(context, intent);
            if (z2) {
                pendingResult.setResultCode(iM3997a);
            }
        } finally {
            pendingResult.finish();
        }
    }
}
