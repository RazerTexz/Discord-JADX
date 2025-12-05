package p007b.p225i.p361c.p398s;

import android.content.SharedPreferences;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4362f;
import p007b.p225i.p361c.p398s.C4832w;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* renamed from: b.i.c.s.l */
/* loaded from: classes3.dex */
public final /* synthetic */ class C4821l implements InterfaceC4362f {

    /* renamed from: a */
    public final FirebaseInstanceId f12872a;

    /* renamed from: b */
    public final String f12873b;

    /* renamed from: c */
    public final String f12874c;

    /* renamed from: d */
    public final String f12875d;

    public C4821l(FirebaseInstanceId firebaseInstanceId, String str, String str2, String str3) {
        this.f12872a = firebaseInstanceId;
        this.f12873b = str;
        this.f12874c = str2;
        this.f12875d = str3;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4362f
    /* renamed from: a */
    public final Task mo4013a(Object obj) {
        FirebaseInstanceId firebaseInstanceId = this.f12872a;
        String str = this.f12873b;
        String str2 = this.f12874c;
        String str3 = this.f12875d;
        String str4 = (String) obj;
        C4832w c4832w = FirebaseInstanceId.f21433b;
        String strM9185h = firebaseInstanceId.m9185h();
        String strM6731a = firebaseInstanceId.f21438g.m6731a();
        synchronized (c4832w) {
            String strM6742a = C4832w.a.m6742a(str4, strM6731a, System.currentTimeMillis());
            if (strM6742a != null) {
                SharedPreferences.Editor editorEdit = c4832w.f12901a.edit();
                editorEdit.putString(c4832w.m6739b(strM9185h, str, str2), strM6742a);
                editorEdit.commit();
            }
        }
        return C3404f.m4264Z(new C4825p(str3, str4));
    }
}
