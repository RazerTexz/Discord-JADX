package p007b.p452o.p453a.p471v;

import android.hardware.Camera;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayInputStream;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.PictureResult;
import p007b.p452o.p453a.p455n.Camera1Engine2;
import p007b.p452o.p453a.p455n.p461t.Reference2;
import p007b.p452o.p453a.p455n.p463v.CameraState2;
import p007b.p452o.p453a.p465p.ByteBufferFrameManager;
import p007b.p452o.p453a.p473x.Size3;

/* compiled from: Full1PictureRecorder.java */
/* renamed from: b.o.a.v.a, reason: use source file name */
/* loaded from: classes3.dex */
public class Full1PictureRecorder extends FullPictureRecorder {

    /* renamed from: n */
    public final Camera f14161n;

    /* renamed from: o */
    public final Camera1Engine2 f14162o;

    /* compiled from: Full1PictureRecorder.java */
    /* renamed from: b.o.a.v.a$a */
    public class a implements Camera.ShutterCallback {
        public a() {
        }

        @Override // android.hardware.Camera.ShutterCallback
        public void onShutter() {
            FullPictureRecorder.f14171m.m7159a(1, "take(): got onShutter callback.");
            Full1PictureRecorder.this.m7420a(true);
        }
    }

    /* compiled from: Full1PictureRecorder.java */
    /* renamed from: b.o.a.v.a$b */
    public class b implements Camera.PictureCallback {
        public b() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            int i;
            FullPictureRecorder.f14171m.m7159a(1, "take(): got picture callback.");
            switch (new ExifInterface(new ByteArrayInputStream(bArr)).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1)) {
                case 3:
                case 4:
                    i = 180;
                    break;
                case 5:
                case 6:
                    i = 90;
                    break;
                case 7:
                case 8:
                    i = 270;
                    break;
                default:
                    i = 0;
                    break;
            }
            PictureResult.a aVar = Full1PictureRecorder.this.f14172j;
            aVar.f13720f = bArr;
            aVar.f13717c = i;
            FullPictureRecorder.f14171m.m7159a(1, "take(): starting preview again. ", Thread.currentThread());
            if (Full1PictureRecorder.this.f14162o.f13922n.f14028f.m7367f(CameraState2.PREVIEW)) {
                camera.setPreviewCallbackWithBuffer(Full1PictureRecorder.this.f14162o);
                Size3 size3Mo7254C = Full1PictureRecorder.this.f14162o.mo7254C(Reference2.SENSOR);
                if (size3Mo7254C == null) {
                    throw new IllegalStateException("Preview stream size should never be null here.");
                }
                ByteBufferFrameManager byteBufferFrameManagerM7220l1 = Full1PictureRecorder.this.f14162o.m7220l1();
                Camera1Engine2 camera1Engine2 = Full1PictureRecorder.this.f14162o;
                byteBufferFrameManagerM7220l1.mo7382e(camera1Engine2.f13901u, size3Mo7254C, camera1Engine2.f13877L);
                camera.startPreview();
            }
            Full1PictureRecorder.this.mo7416b();
        }
    }

    public Full1PictureRecorder(@NonNull PictureResult.a aVar, @NonNull Camera1Engine2 camera1Engine2, @NonNull Camera camera) {
        super(aVar, camera1Engine2);
        this.f14162o = camera1Engine2;
        this.f14161n = camera;
        Camera.Parameters parameters = camera.getParameters();
        parameters.setRotation(this.f14172j.f13717c);
        camera.setParameters(parameters);
    }

    @Override // p007b.p452o.p453a.p471v.PictureRecorder
    /* renamed from: b */
    public void mo7416b() {
        FullPictureRecorder.f14171m.m7159a(1, "dispatching result. Thread:", Thread.currentThread());
        super.mo7416b();
    }

    @Override // p007b.p452o.p453a.p471v.PictureRecorder
    /* renamed from: c */
    public void mo7417c() {
        CameraLogger cameraLogger = FullPictureRecorder.f14171m;
        cameraLogger.m7159a(1, "take() called.");
        this.f14161n.setPreviewCallbackWithBuffer(null);
        this.f14162o.m7220l1().mo7381d();
        try {
            this.f14161n.takePicture(new a(), null, null, new b());
            cameraLogger.m7159a(1, "take() returned.");
        } catch (Exception e) {
            this.f14174l = e;
            mo7416b();
        }
    }
}
