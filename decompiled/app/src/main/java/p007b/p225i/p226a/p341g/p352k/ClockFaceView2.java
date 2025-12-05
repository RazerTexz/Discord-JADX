package p007b.p225i.p226a.p341g.p352k;

import android.view.ViewTreeObserver;
import com.google.android.material.timepicker.ClockFaceView;
import com.google.android.material.timepicker.ClockHandView;

/* compiled from: ClockFaceView.java */
/* renamed from: b.i.a.g.k.b, reason: use source file name */
/* loaded from: classes3.dex */
public class ClockFaceView2 implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: j */
    public final /* synthetic */ ClockFaceView f11858j;

    public ClockFaceView2(ClockFaceView clockFaceView) {
        this.f11858j = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        if (!this.f11858j.isShown()) {
            return true;
        }
        this.f11858j.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = this.f11858j.getHeight() / 2;
        ClockFaceView clockFaceView = this.f11858j;
        int i = (height - clockFaceView.f21186m.f21206r) - clockFaceView.f21193t;
        if (i != clockFaceView.f11862k) {
            clockFaceView.f11862k = i;
            clockFaceView.m6170a();
            ClockHandView clockHandView = clockFaceView.f21186m;
            clockHandView.f21198A = clockFaceView.f11862k;
            clockHandView.invalidate();
        }
        return true;
    }
}
