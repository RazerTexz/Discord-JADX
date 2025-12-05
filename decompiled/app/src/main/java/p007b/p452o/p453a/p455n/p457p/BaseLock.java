package p007b.p452o.p453a.p455n.p457p;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import p007b.p452o.p453a.p455n.p456o.ActionHolder;
import p007b.p452o.p453a.p455n.p456o.BaseAction;

/* compiled from: BaseLock.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.p.a, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class BaseLock extends BaseAction {
    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction
    /* renamed from: j */
    public final void mo7249j(@NonNull ActionHolder actionHolder) {
        this.f13939c = actionHolder;
        boolean zMo7344n = mo7344n(actionHolder);
        if (!mo7343m(actionHolder) || zMo7344n) {
            m7341l(Integer.MAX_VALUE);
        } else {
            mo7345o(actionHolder);
        }
    }

    /* renamed from: m */
    public abstract boolean mo7343m(@NonNull ActionHolder actionHolder);

    /* renamed from: n */
    public abstract boolean mo7344n(@NonNull ActionHolder actionHolder);

    /* renamed from: o */
    public abstract void mo7345o(@NonNull ActionHolder actionHolder);
}
