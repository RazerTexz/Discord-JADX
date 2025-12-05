package p007b.p452o.p453a.p455n.p457p;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.p455n.p456o.ActionWrapper;
import p007b.p452o.p453a.p455n.p456o.BaseAction;

/* compiled from: LockAction.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.p.d, reason: use source file name */
/* loaded from: classes3.dex */
public class LockAction extends ActionWrapper {

    /* renamed from: e */
    public final BaseAction f13954e = C3404f.m4361x1(new ExposureLock(), new FocusLock(), new WhiteBalanceLock());

    @Override // p007b.p452o.p453a.p455n.p456o.ActionWrapper
    @NonNull
    /* renamed from: m */
    public BaseAction mo7336m() {
        return this.f13954e;
    }
}
