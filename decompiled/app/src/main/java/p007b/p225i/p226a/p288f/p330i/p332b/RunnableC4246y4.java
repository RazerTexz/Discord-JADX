package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzn;
import java.util.Iterator;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;
import p007b.p225i.p226a.p288f.p313h.p325l.C3579a1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3607c1;

/* JADX INFO: renamed from: b.i.a.f.i.b.y4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC4246y4 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final BinderC4257z4 f11367j;

    /* JADX INFO: renamed from: k */
    public final zzn f11368k;

    /* JADX INFO: renamed from: l */
    public final Bundle f11369l;

    public RunnableC4246y4(BinderC4257z4 binderC4257z4, zzn zznVar, Bundle bundle) {
        this.f11367j = binderC4257z4;
        this.f11368k = zznVar;
        this.f11369l = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzap zzapVar;
        BinderC4257z4 binderC4257z4 = this.f11367j;
        zzn zznVar = this.f11368k;
        Bundle bundle = this.f11369l;
        C4040g c4040gM5710K = binderC4257z4.f11390a.m5710K();
        String str = zznVar.f20683j;
        c4040gM5710K.mo5848b();
        c4040gM5710K.m5684n();
        C4202u4 c4202u4 = c4040gM5710K.f11202a;
        AnimatableValueParser.m583w(str);
        AnimatableValueParser.m583w("dep");
        TextUtils.isEmpty("");
        if (bundle == null || bundle.isEmpty()) {
            zzapVar = new zzap(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    c4202u4.mo5726g().f11141f.m5860a("Param name can't be null");
                    it.remove();
                } else {
                    Object objM5892D = c4202u4.m5949t().m5892D(next, bundle2.get(next));
                    if (objM5892D == null) {
                        c4202u4.mo5726g().f11144i.m5861b("Param value can't be null", c4202u4.m5950u().m5768x(next));
                        it.remove();
                    } else {
                        c4202u4.m5949t().m5895I(bundle2, next, objM5892D);
                    }
                }
            }
            zzapVar = new zzap(bundle2);
        }
        C4163q9 c4163q9M5683m = c4040gM5710K.m5683m();
        C3579a1.a aVarM4526M = C3579a1.m4526M();
        if (aVarM4526M.f10348l) {
            aVarM4526M.m5318n();
            aVarM4526M.f10348l = false;
        }
        C3579a1.m4525E((C3579a1) aVarM4526M.f10347k, 0L);
        for (String str2 : zzapVar.f20665j.keySet()) {
            C3607c1.a aVarM4578Q = C3607c1.m4578Q();
            aVarM4578Q.m4600s(str2);
            c4163q9M5683m.m5834F(aVarM4578Q, zzapVar.m9113w0(str2));
            aVarM4526M.m4547s(aVarM4578Q);
        }
        byte[] bArrM5052d = ((C3579a1) ((AbstractC3851u4) aVarM4526M.m5320p())).m5052d();
        c4040gM5710K.mo5726g().f11149n.m5862c("Saving default event parameters, appId, data size", c4040gM5710K.m5865d().m5766u(str), Integer.valueOf(bArrM5052d.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", bArrM5052d);
        try {
            if (c4040gM5710K.m5640t().insertWithOnConflict("default_event_params", null, contentValues, 5) == -1) {
                c4040gM5710K.mo5726g().f11141f.m5861b("Failed to insert default event parameters (got -1). appId", C4157q3.m5788s(str));
            }
        } catch (SQLiteException e) {
            c4040gM5710K.mo5726g().f11141f.m5862c("Error storing default event parameters. appId", C4157q3.m5788s(str), e);
        }
    }
}
