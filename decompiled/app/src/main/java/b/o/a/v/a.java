package b.o.a.v;

import android.hardware.Camera;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import b.o.a.l;
import java.io.ByteArrayInputStream;

/* compiled from: Full1PictureRecorder.java */
/* loaded from: classes3.dex */
public class a extends c {
    public final Camera n;
    public final b.o.a.n.b o;

    /* compiled from: Full1PictureRecorder.java */
    /* renamed from: b.o.a.v.a$a, reason: collision with other inner class name */
    public class C0178a implements Camera.ShutterCallback {
        public C0178a() {
        }

        @Override // android.hardware.Camera.ShutterCallback
        public void onShutter() {
            c.m.a(1, "take(): got onShutter callback.");
            a.this.a(true);
        }
    }

    /* compiled from: Full1PictureRecorder.java */
    public class b implements Camera.PictureCallback {
        public b() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            int i;
            c.m.a(1, "take(): got picture callback.");
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
            l.a aVar = a.this.j;
            aVar.f = bArr;
            aVar.c = i;
            c.m.a(1, "take(): starting preview again. ", Thread.currentThread());
            if (a.this.o.n.f.f(b.o.a.n.v.e.PREVIEW)) {
                camera.setPreviewCallbackWithBuffer(a.this.o);
                b.o.a.x.b bVarC = a.this.o.C(b.o.a.n.t.b.SENSOR);
                if (bVarC == null) {
                    throw new IllegalStateException("Preview stream size should never be null here.");
                }
                b.o.a.p.a aVarL1 = a.this.o.l1();
                b.o.a.n.b bVar = a.this.o;
                aVarL1.e(bVar.u, bVarC, bVar.L);
                camera.startPreview();
            }
            a.this.b();
        }
    }

    public a(@NonNull l.a aVar, @NonNull b.o.a.n.b bVar, @NonNull Camera camera) {
        super(aVar, bVar);
        this.o = bVar;
        this.n = camera;
        Camera.Parameters parameters = camera.getParameters();
        parameters.setRotation(this.j.c);
        camera.setParameters(parameters);
    }

    @Override // b.o.a.v.d
    public void b() {
        c.m.a(1, "dispatching result. Thread:", Thread.currentThread());
        super.b();
    }

    @Override // b.o.a.v.d
    public void c() {
        b.o.a.b bVar = c.m;
        bVar.a(1, "take() called.");
        this.n.setPreviewCallbackWithBuffer(null);
        this.o.l1().d();
        try {
            this.n.takePicture(new C0178a(), null, null, new b());
            bVar.a(1, "take() returned.");
        } catch (Exception e) {
            this.l = e;
            b();
        }
    }
}
