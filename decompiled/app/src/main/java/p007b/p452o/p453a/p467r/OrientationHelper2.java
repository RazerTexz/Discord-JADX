package p007b.p452o.p453a.p467r;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.CameraView;
import p007b.p452o.p453a.CameraView6;
import p007b.p452o.p453a.p455n.p461t.Angles;

/* compiled from: OrientationHelper.java */
/* renamed from: b.o.a.r.f, reason: use source file name */
/* loaded from: classes3.dex */
public class OrientationHelper2 {

    /* renamed from: b */
    public final Context f14118b;

    /* renamed from: c */
    public final c f14119c;

    /* renamed from: d */
    @VisibleForTesting
    public final OrientationEventListener f14120d;

    /* renamed from: h */
    public boolean f14124h;

    /* renamed from: a */
    public final Handler f14117a = new Handler(Looper.getMainLooper());

    /* renamed from: e */
    public int f14121e = -1;

    /* renamed from: g */
    public int f14123g = -1;

    /* renamed from: f */
    @VisibleForTesting
    public final DisplayManager.DisplayListener f14122f = new b();

    /* compiled from: OrientationHelper.java */
    /* renamed from: b.o.a.r.f$a */
    public class a extends OrientationEventListener {
        public a(Context context, int i) {
            super(context, i);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x002d  */
        @Override // android.view.OrientationEventListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onOrientationChanged(int i) {
            int i2;
            if (i == -1) {
                i2 = OrientationHelper2.this.f14121e;
                if (i2 == -1) {
                    i2 = 0;
                }
            } else if (i < 315 && i >= 45) {
                if (i >= 45 && i < 135) {
                    i2 = 90;
                } else if (i >= 135 && i < 225) {
                    i2 = 180;
                } else if (i >= 225 && i < 315) {
                    i2 = 270;
                }
            }
            OrientationHelper2 orientationHelper2 = OrientationHelper2.this;
            if (i2 != orientationHelper2.f14121e) {
                orientationHelper2.f14121e = i2;
                CameraView.C11195b c11195b = (CameraView.C11195b) orientationHelper2.f14119c;
                c11195b.f22141b.m7159a(1, "onDeviceOrientationChanged", Integer.valueOf(i2));
                CameraView cameraView = CameraView.this;
                int i3 = cameraView.f22137y.f14123g;
                if (cameraView.f22125m) {
                    Angles anglesMo7281e = cameraView.f22138z.mo7281e();
                    anglesMo7281e.m7360e(i2);
                    anglesMo7281e.f13999e = i2;
                    anglesMo7281e.m7359d();
                } else {
                    int i4 = (360 - i3) % 360;
                    Angles anglesMo7281e2 = cameraView.f22138z.mo7281e();
                    anglesMo7281e2.m7360e(i4);
                    anglesMo7281e2.f13999e = i4;
                    anglesMo7281e2.m7359d();
                }
                CameraView.this.f22133u.post(new CameraView6(c11195b, (i2 + i3) % 360));
            }
        }
    }

    /* compiled from: OrientationHelper.java */
    /* renamed from: b.o.a.r.f$b */
    public class b implements DisplayManager.DisplayListener {
        public b() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            OrientationHelper2 orientationHelper2 = OrientationHelper2.this;
            int i2 = orientationHelper2.f14123g;
            int iM7401a = orientationHelper2.m7401a();
            if (iM7401a != i2) {
                OrientationHelper2 orientationHelper22 = OrientationHelper2.this;
                orientationHelper22.f14123g = iM7401a;
                CameraView.C11195b c11195b = (CameraView.C11195b) orientationHelper22.f14119c;
                if (CameraView.this.m9307d()) {
                    c11195b.f22141b.m7159a(2, "onDisplayOffsetChanged", "restarting the camera.");
                    CameraView.this.close();
                    CameraView.this.open();
                }
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
        }
    }

    /* compiled from: OrientationHelper.java */
    /* renamed from: b.o.a.r.f$c */
    public interface c {
    }

    public OrientationHelper2(@NonNull Context context, @NonNull c cVar) {
        this.f14118b = context;
        this.f14119c = cVar;
        this.f14120d = new a(context.getApplicationContext(), 3);
    }

    /* renamed from: a */
    public final int m7401a() {
        int rotation = ((WindowManager) this.f14118b.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 270;
        }
        return 180;
    }
}
