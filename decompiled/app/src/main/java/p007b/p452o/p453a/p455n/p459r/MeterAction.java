package p007b.p452o.p453a.p455n.p459r;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.p455n.Camera2Engine;
import p007b.p452o.p453a.p455n.CameraEngine;
import p007b.p452o.p453a.p455n.p456o.ActionHolder;
import p007b.p452o.p453a.p455n.p456o.ActionWrapper;
import p007b.p452o.p453a.p455n.p456o.BaseAction;
import p007b.p452o.p453a.p455n.p460s.Camera2MeteringTransform;
import p007b.p452o.p453a.p455n.p461t.Reference2;
import p007b.p452o.p453a.p469t.MeteringRegions;

/* compiled from: MeterAction.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.r.g, reason: use source file name */
/* loaded from: classes3.dex */
public class MeterAction extends ActionWrapper {

    /* renamed from: e */
    public static final CameraLogger f13976e = new CameraLogger(MeterAction.class.getSimpleName());

    /* renamed from: f */
    public List<BaseMeter> f13977f;

    /* renamed from: g */
    public BaseAction f13978g;

    /* renamed from: h */
    public final MeteringRegions f13979h;

    /* renamed from: i */
    public final CameraEngine f13980i;

    /* renamed from: j */
    public final boolean f13981j;

    public MeterAction(@NonNull CameraEngine cameraEngine, @Nullable MeteringRegions meteringRegions, boolean z2) {
        this.f13979h = meteringRegions;
        this.f13980i = cameraEngine;
        this.f13981j = z2;
    }

    @Override // p007b.p452o.p453a.p455n.p456o.ActionWrapper, p007b.p452o.p453a.p455n.p456o.BaseAction
    /* renamed from: j */
    public void mo7249j(@NonNull ActionHolder actionHolder) {
        CameraLogger cameraLogger = f13976e;
        cameraLogger.m7159a(2, "onStart:", "initializing.");
        m7353n(actionHolder);
        cameraLogger.m7159a(2, "onStart:", "initialized.");
        super.mo7249j(actionHolder);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.ActionWrapper
    @NonNull
    /* renamed from: m */
    public BaseAction mo7336m() {
        return this.f13978g;
    }

    /* renamed from: n */
    public final void m7353n(@NonNull ActionHolder actionHolder) {
        List arrayList = new ArrayList();
        if (this.f13979h != null) {
            Camera2Engine camera2Engine = (Camera2Engine) actionHolder;
            Camera2MeteringTransform camera2MeteringTransform = new Camera2MeteringTransform(this.f13980i.mo7281e(), this.f13980i.mo7315z().m7432l(), this.f13980i.mo7254C(Reference2.VIEW), this.f13980i.mo7315z().f14209d, camera2Engine.f13805g0, camera2Engine.f13807i0);
            arrayList = this.f13979h.m7411c(camera2MeteringTransform).m7410b(Integer.MAX_VALUE, camera2MeteringTransform);
        }
        ExposureMeter exposureMeter = new ExposureMeter(arrayList, this.f13981j);
        FocusMeter focusMeter = new FocusMeter(arrayList, this.f13981j);
        WhiteBalanceMeter whiteBalanceMeter = new WhiteBalanceMeter(arrayList, this.f13981j);
        this.f13977f = Arrays.asList(exposureMeter, focusMeter, whiteBalanceMeter);
        this.f13978g = C3404f.m4361x1(exposureMeter, focusMeter, whiteBalanceMeter);
    }
}
