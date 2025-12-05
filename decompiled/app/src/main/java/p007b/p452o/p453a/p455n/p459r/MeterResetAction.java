package p007b.p452o.p453a.p455n.p459r;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.p455n.p456o.ActionWrapper;
import p007b.p452o.p453a.p455n.p456o.BaseAction;

/* compiled from: MeterResetAction.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.r.h, reason: use source file name */
/* loaded from: classes3.dex */
public class MeterResetAction extends ActionWrapper {

    /* renamed from: e */
    public final BaseAction f13982e = C3404f.m4361x1(new ExposureReset(), new FocusReset(), new WhiteBalanceReset());

    @Override // p007b.p452o.p453a.p455n.p456o.ActionWrapper
    @NonNull
    /* renamed from: m */
    public BaseAction mo7336m() {
        return this.f13982e;
    }
}
