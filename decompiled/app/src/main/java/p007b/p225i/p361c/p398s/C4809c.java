package p007b.p225i.p361c.p398s;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4353a;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* renamed from: b.i.c.s.c */
/* loaded from: classes3.dex */
public final /* synthetic */ class C4809c implements InterfaceC4353a {

    /* renamed from: a */
    public final Context f12848a;

    /* renamed from: b */
    public final Intent f12849b;

    public C4809c(Context context, Intent intent) {
        this.f12848a = context;
        this.f12849b = intent;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4353a
    /* renamed from: a */
    public final Object mo4012a(Task task) {
        Context context = this.f12848a;
        Intent intent = this.f12849b;
        if (!C3404f.m4190A0() || ((Integer) task.mo6017l()).intValue() != 402) {
            return task;
        }
        Task<Integer> taskM6724a = C4815f.m6724a(context, intent);
        Executor executor = C4817h.f12866a;
        return taskM6724a.mo6014i(ExecutorC4816g.f12865j, C4813e.f12860a);
    }
}
