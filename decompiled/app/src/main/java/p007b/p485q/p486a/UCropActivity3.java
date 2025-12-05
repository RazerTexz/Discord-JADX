package p007b.p485q.p486a;

import com.yalantis.ucrop.UCropActivity;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;

/* compiled from: UCropActivity.java */
/* renamed from: b.q.a.c, reason: use source file name */
/* loaded from: classes3.dex */
public class UCropActivity3 implements HorizontalProgressWheelView.InterfaceC11207a {

    /* renamed from: a */
    public final /* synthetic */ UCropActivity f14390a;

    public UCropActivity3(UCropActivity uCropActivity) {
        this.f14390a = uCropActivity;
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC11207a
    /* renamed from: a */
    public void mo7468a() {
        this.f14390a.f22194w.setImageToWrapCropBounds(true);
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC11207a
    /* renamed from: b */
    public void mo7469b(float f, float f2) {
        this.f14390a.f22194w.m7482k(f / 42.0f);
    }

    @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.InterfaceC11207a
    /* renamed from: c */
    public void mo7470c() {
        this.f14390a.f22194w.m7480i();
    }
}
