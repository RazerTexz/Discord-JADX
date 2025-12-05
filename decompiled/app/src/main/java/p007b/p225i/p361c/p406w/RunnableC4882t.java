package p007b.p225i.p361c.p406w;

import android.content.SharedPreferences;
import java.util.Iterator;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* renamed from: b.i.c.w.t */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC4882t implements Runnable {

    /* renamed from: j */
    public final C4883u f13040j;

    public RunnableC4882t(C4883u c4883u) {
        this.f13040j = c4883u;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4883u c4883u = this.f13040j;
        synchronized (c4883u.f13044d) {
            SharedPreferences.Editor editorEdit = c4883u.f13041a.edit();
            String str = c4883u.f13042b;
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = c4883u.f13044d.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(c4883u.f13043c);
            }
            editorEdit.putString(str, sb.toString()).commit();
        }
    }
}
