package b.o.a.v;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import androidx.annotation.NonNull;
import b.o.a.l;
import java.io.ByteArrayOutputStream;

/* compiled from: Snapshot1PictureRecorder.java */
/* loaded from: classes3.dex */
public class e extends i {
    public b.o.a.n.b n;
    public Camera o;
    public b.o.a.x.a p;
    public int q;

    /* compiled from: Snapshot1PictureRecorder.java */
    public class a implements Camera.PreviewCallback {

        /* compiled from: Snapshot1PictureRecorder.java */
        /* renamed from: b.o.a.v.e$a$a, reason: collision with other inner class name */
        public class RunnableC0179a implements Runnable {
            public final /* synthetic */ byte[] j;
            public final /* synthetic */ b.o.a.x.b k;
            public final /* synthetic */ int l;
            public final /* synthetic */ b.o.a.x.b m;

            public RunnableC0179a(byte[] bArr, b.o.a.x.b bVar, int i, b.o.a.x.b bVar2) {
                this.j = bArr;
                this.k = bVar;
                this.l = i;
                this.m = bVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                byte[] bArr;
                byte[] bArr2 = this.j;
                b.o.a.x.b bVar = this.k;
                int i = this.l;
                if (i == 0) {
                    bArr = bArr2;
                } else {
                    if (i % 90 != 0 || i < 0 || i > 270) {
                        throw new IllegalArgumentException("0 <= rotation < 360, rotation % 90 == 0");
                    }
                    int i2 = bVar.j;
                    int i3 = bVar.k;
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
                int i16 = e.this.q;
                b.o.a.x.b bVar2 = this.m;
                YuvImage yuvImage = new YuvImage(bArr, i16, bVar2.j, bVar2.k, null);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Rect rectL = b.i.a.f.e.o.f.L(this.m, e.this.p);
                yuvImage.compressToJpeg(rectL, 90, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                l.a aVar = e.this.j;
                aVar.f = byteArray;
                aVar.d = new b.o.a.x.b(rectL.width(), rectL.height());
                e eVar = e.this;
                eVar.j.c = 0;
                eVar.b();
            }
        }

        public a() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(@NonNull byte[] bArr, Camera camera) {
            e.this.a(false);
            e eVar = e.this;
            l.a aVar = eVar.j;
            int i = aVar.c;
            b.o.a.x.b bVar = aVar.d;
            b.o.a.x.b bVarC = eVar.n.C(b.o.a.n.t.b.SENSOR);
            if (bVarC == null) {
                throw new IllegalStateException("Preview stream size should never be null here.");
            }
            b.o.a.r.g.a(new RunnableC0179a(bArr, bVarC, i, bVar));
            camera.setPreviewCallbackWithBuffer(null);
            camera.setPreviewCallbackWithBuffer(e.this.n);
            b.o.a.p.a aVarL1 = e.this.n.l1();
            e eVar2 = e.this;
            aVarL1.e(eVar2.q, bVarC, eVar2.n.L);
        }
    }

    public e(@NonNull l.a aVar, @NonNull b.o.a.n.b bVar, @NonNull Camera camera, @NonNull b.o.a.x.a aVar2) {
        super(aVar, bVar);
        this.n = bVar;
        this.o = camera;
        this.p = aVar2;
        this.q = camera.getParameters().getPreviewFormat();
    }

    @Override // b.o.a.v.d
    public void b() {
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = 0;
        super.b();
    }

    @Override // b.o.a.v.d
    public void c() {
        this.o.setOneShotPreviewCallback(new a());
    }
}
