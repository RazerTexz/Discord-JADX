package p007b.p452o.p453a.p471v;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import androidx.annotation.NonNull;
import java.io.ByteArrayOutputStream;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.PictureResult;
import p007b.p452o.p453a.p455n.Camera1Engine2;
import p007b.p452o.p453a.p455n.p461t.Reference2;
import p007b.p452o.p453a.p465p.ByteBufferFrameManager;
import p007b.p452o.p453a.p467r.WorkerHandler;
import p007b.p452o.p453a.p473x.AspectRatio2;
import p007b.p452o.p453a.p473x.Size3;

/* compiled from: Snapshot1PictureRecorder.java */
/* renamed from: b.o.a.v.e, reason: use source file name */
/* loaded from: classes3.dex */
public class Snapshot1PictureRecorder extends SnapshotPictureRecorder {

    /* renamed from: n */
    public Camera1Engine2 f14175n;

    /* renamed from: o */
    public Camera f14176o;

    /* renamed from: p */
    public AspectRatio2 f14177p;

    /* renamed from: q */
    public int f14178q;

    /* compiled from: Snapshot1PictureRecorder.java */
    /* renamed from: b.o.a.v.e$a */
    public class a implements Camera.PreviewCallback {

        /* compiled from: Snapshot1PictureRecorder.java */
        /* renamed from: b.o.a.v.e$a$a, reason: collision with other inner class name */
        public class RunnableC13245a implements Runnable {

            /* renamed from: j */
            public final /* synthetic */ byte[] f14180j;

            /* renamed from: k */
            public final /* synthetic */ Size3 f14181k;

            /* renamed from: l */
            public final /* synthetic */ int f14182l;

            /* renamed from: m */
            public final /* synthetic */ Size3 f14183m;

            public RunnableC13245a(byte[] bArr, Size3 size3, int i, Size3 size32) {
                this.f14180j = bArr;
                this.f14181k = size3;
                this.f14182l = i;
                this.f14183m = size32;
            }

            @Override // java.lang.Runnable
            public void run() {
                byte[] bArr;
                byte[] bArr2 = this.f14180j;
                Size3 size3 = this.f14181k;
                int i = this.f14182l;
                if (i == 0) {
                    bArr = bArr2;
                } else {
                    if (i % 90 != 0 || i < 0 || i > 270) {
                        throw new IllegalArgumentException("0 <= rotation < 360, rotation % 90 == 0");
                    }
                    int i2 = size3.f14251j;
                    int i3 = size3.f14252k;
                    byte[] bArr3 = new byte[bArr2.length];
                    int i4 = i2 * i3;
                    boolean z2 = i % 180 != 0;
                    boolean z3 = i % 270 != 0;
                    boolean z4 = i >= 180;
                    for (int i5 = 0; i5 < i3; i5++) {
                        for (int i6 = 0; i6 < i2; i6++) {
                            int i7 = (i5 * i2) + i6;
                            int i8 = ((i5 >> 1) * i2) + i4 + (i6 & (-2));
                            int i9 = i8 + 1;
                            int i10 = z2 ? i3 : i2;
                            int i11 = z2 ? i2 : i3;
                            int i12 = z2 ? i5 : i6;
                            int i13 = z2 ? i6 : i5;
                            if (z3) {
                                i12 = (i10 - i12) - 1;
                            }
                            if (z4) {
                                i13 = (i11 - i13) - 1;
                            }
                            int i14 = (i13 * i10) + i12;
                            int i15 = ((i13 >> 1) * i10) + i4 + (i12 & (-2));
                            bArr3[i14] = (byte) (bArr2[i7] & 255);
                            bArr3[i15] = (byte) (bArr2[i8] & 255);
                            bArr3[i15 + 1] = (byte) (bArr2[i9] & 255);
                        }
                    }
                    bArr = bArr3;
                }
                int i16 = Snapshot1PictureRecorder.this.f14178q;
                Size3 size32 = this.f14183m;
                YuvImage yuvImage = new YuvImage(bArr, i16, size32.f14251j, size32.f14252k, null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Rect rectM4222L = C3404f.m4222L(this.f14183m, Snapshot1PictureRecorder.this.f14177p);
                yuvImage.compressToJpeg(rectM4222L, 90, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                PictureResult.a aVar = Snapshot1PictureRecorder.this.f14172j;
                aVar.f13720f = byteArray;
                aVar.f13718d = new Size3(rectM4222L.width(), rectM4222L.height());
                Snapshot1PictureRecorder snapshot1PictureRecorder = Snapshot1PictureRecorder.this;
                snapshot1PictureRecorder.f14172j.f13717c = 0;
                snapshot1PictureRecorder.mo7416b();
            }
        }

        public a() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(@NonNull byte[] bArr, Camera camera) {
            Snapshot1PictureRecorder.this.m7420a(false);
            Snapshot1PictureRecorder snapshot1PictureRecorder = Snapshot1PictureRecorder.this;
            PictureResult.a aVar = snapshot1PictureRecorder.f14172j;
            int i = aVar.f13717c;
            Size3 size3 = aVar.f13718d;
            Size3 size3Mo7254C = snapshot1PictureRecorder.f14175n.mo7254C(Reference2.SENSOR);
            if (size3Mo7254C == null) {
                throw new IllegalStateException("Preview stream size should never be null here.");
            }
            WorkerHandler.m7402a(new RunnableC13245a(bArr, size3Mo7254C, i, size3));
            camera.setPreviewCallbackWithBuffer(null);
            camera.setPreviewCallbackWithBuffer(Snapshot1PictureRecorder.this.f14175n);
            ByteBufferFrameManager byteBufferFrameManagerM7220l1 = Snapshot1PictureRecorder.this.f14175n.m7220l1();
            Snapshot1PictureRecorder snapshot1PictureRecorder2 = Snapshot1PictureRecorder.this;
            byteBufferFrameManagerM7220l1.mo7382e(snapshot1PictureRecorder2.f14178q, size3Mo7254C, snapshot1PictureRecorder2.f14175n.f13877L);
        }
    }

    public Snapshot1PictureRecorder(@NonNull PictureResult.a aVar, @NonNull Camera1Engine2 camera1Engine2, @NonNull Camera camera, @NonNull AspectRatio2 aspectRatio2) {
        super(aVar, camera1Engine2);
        this.f14175n = camera1Engine2;
        this.f14176o = camera;
        this.f14177p = aspectRatio2;
        this.f14178q = camera.getParameters().getPreviewFormat();
    }

    @Override // p007b.p452o.p453a.p471v.PictureRecorder
    /* renamed from: b */
    public void mo7416b() {
        this.f14175n = null;
        this.f14176o = null;
        this.f14177p = null;
        this.f14178q = 0;
        super.mo7416b();
    }

    @Override // p007b.p452o.p453a.p471v.PictureRecorder
    /* renamed from: c */
    public void mo7417c() {
        this.f14176o.setOneShotPreviewCallback(new a());
    }
}
