package p007b.p452o.p453a.p455n.p456o;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: b.o.a.n.o.f, reason: use source file name */
/* JADX INFO: compiled from: CompletionCallback.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class CompletionCallback implements ActionCallback {
    @Override // p007b.p452o.p453a.p455n.p456o.ActionCallback
    /* JADX INFO: renamed from: a */
    public final void mo7334a(@NonNull Action2 action2, int i) {
        if (i == Integer.MAX_VALUE) {
            mo7247b(action2);
        }
    }

    /* JADX INFO: renamed from: b */
    public abstract void mo7247b(@NonNull Action2 action2);
}
