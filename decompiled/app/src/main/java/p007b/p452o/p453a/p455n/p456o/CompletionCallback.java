package p007b.p452o.p453a.p455n.p456o;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: CompletionCallback.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.o.f, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class CompletionCallback implements ActionCallback {
    @Override // p007b.p452o.p453a.p455n.p456o.ActionCallback
    /* renamed from: a */
    public final void mo7334a(@NonNull Action2 action2, int i) {
        if (i == Integer.MAX_VALUE) {
            mo7247b(action2);
        }
    }

    /* renamed from: b */
    public abstract void mo7247b(@NonNull Action2 action2);
}
