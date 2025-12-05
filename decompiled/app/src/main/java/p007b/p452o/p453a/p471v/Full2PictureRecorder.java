package p007b.p452o.p453a.p471v;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.DngCreator;
import android.hardware.camera2.TotalCaptureResult;
import android.location.Location;
import android.media.Image;
import android.media.ImageReader;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import p007b.p100d.p104b.p105a.outline;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.PictureResult;
import p007b.p452o.p453a.p454m.PictureFormat;
import p007b.p452o.p453a.p455n.Camera2Engine;
import p007b.p452o.p453a.p455n.p456o.Action2;
import p007b.p452o.p453a.p455n.p456o.ActionHolder;
import p007b.p452o.p453a.p455n.p456o.BaseAction;
import p007b.p452o.p453a.p467r.WorkerHandler;

/* compiled from: Full2PictureRecorder.java */
@RequiresApi(21)
/* renamed from: b.o.a.v.b, reason: use source file name */
/* loaded from: classes3.dex */
public class Full2PictureRecorder extends FullPictureRecorder implements ImageReader.OnImageAvailableListener {

    /* renamed from: n */
    public final ActionHolder f14165n;

    /* renamed from: o */
    public final Action2 f14166o;

    /* renamed from: p */
    public final ImageReader f14167p;

    /* renamed from: q */
    public final CaptureRequest.Builder f14168q;

    /* renamed from: r */
    public DngCreator f14169r;

    /* compiled from: Full2PictureRecorder.java */
    /* renamed from: b.o.a.v.b$a */
    public class a extends BaseAction {
        public a() {
        }

        @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
        /* renamed from: b */
        public void mo7248b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            int i;
            Full2PictureRecorder full2PictureRecorder = Full2PictureRecorder.this;
            if (full2PictureRecorder.f14172j.f13721g == PictureFormat.DNG) {
                full2PictureRecorder.f14169r = new DngCreator(((Camera2Engine) actionHolder).f13805g0, totalCaptureResult);
                Full2PictureRecorder full2PictureRecorder2 = Full2PictureRecorder.this;
                DngCreator dngCreator = full2PictureRecorder2.f14169r;
                int i2 = full2PictureRecorder2.f14172j.f13717c;
                int i3 = (i2 + 360) % 360;
                if (i3 == 0) {
                    i = 1;
                } else if (i3 == 90) {
                    i = 6;
                } else if (i3 == 180) {
                    i = 3;
                } else {
                    if (i3 != 270) {
                        throw new IllegalArgumentException(outline.m871q("Invalid orientation: ", i2));
                    }
                    i = 8;
                }
                dngCreator.setOrientation(i);
                Full2PictureRecorder full2PictureRecorder3 = Full2PictureRecorder.this;
                Location location = full2PictureRecorder3.f14172j.f13716b;
                if (location != null) {
                    full2PictureRecorder3.f14169r.setLocation(location);
                }
            }
        }

        @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
        /* renamed from: c */
        public void mo7331c(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
            if (this.f13940d) {
                mo7249j(actionHolder);
                this.f13940d = false;
            }
            if (captureRequest.getTag() == 2) {
                FullPictureRecorder.f14171m.m7159a(1, "onCaptureStarted:", "Dispatching picture shutter.");
                Full2PictureRecorder.this.m7420a(false);
                m7341l(Integer.MAX_VALUE);
            }
        }

        @Override // p007b.p452o.p453a.p455n.p456o.BaseAction
        /* renamed from: j */
        public void mo7249j(@NonNull ActionHolder actionHolder) {
            this.f13939c = actionHolder;
            Full2PictureRecorder full2PictureRecorder = Full2PictureRecorder.this;
            full2PictureRecorder.f14168q.addTarget(full2PictureRecorder.f14167p.getSurface());
            Full2PictureRecorder full2PictureRecorder2 = Full2PictureRecorder.this;
            PictureResult.a aVar = full2PictureRecorder2.f14172j;
            if (aVar.f13721g == PictureFormat.JPEG) {
                full2PictureRecorder2.f14168q.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(aVar.f13717c));
            }
            Full2PictureRecorder.this.f14168q.setTag(2);
            try {
                ((Camera2Engine) actionHolder).m7230e1(this, Full2PictureRecorder.this.f14168q);
            } catch (CameraAccessException e) {
                Full2PictureRecorder full2PictureRecorder3 = Full2PictureRecorder.this;
                full2PictureRecorder3.f14172j = null;
                full2PictureRecorder3.f14174l = e;
                full2PictureRecorder3.mo7416b();
                m7341l(Integer.MAX_VALUE);
            }
        }
    }

    public Full2PictureRecorder(@NonNull PictureResult.a aVar, @NonNull Camera2Engine camera2Engine, @NonNull CaptureRequest.Builder builder, @NonNull ImageReader imageReader) {
        super(aVar, camera2Engine);
        this.f14165n = camera2Engine;
        this.f14168q = builder;
        this.f14167p = imageReader;
        WorkerHandler workerHandlerM7403b = WorkerHandler.m7403b("FallbackCameraThread");
        WorkerHandler.f14129c = workerHandlerM7403b;
        imageReader.setOnImageAvailableListener(this, workerHandlerM7403b.f14132f);
        this.f14166o = new a();
    }

    @Override // p007b.p452o.p453a.p471v.PictureRecorder
    /* renamed from: c */
    public void mo7417c() {
        this.f14166o.mo7333e(this.f14165n);
    }

    /* renamed from: d */
    public final void m7418d(@NonNull Image image) {
        int i = 0;
        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
        byte[] bArr = new byte[buffer.remaining()];
        buffer.get(bArr);
        PictureResult.a aVar = this.f14172j;
        aVar.f13720f = bArr;
        aVar.f13717c = 0;
        try {
            int attributeInt = new ExifInterface(new ByteArrayInputStream(this.f14172j.f13720f)).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            PictureResult.a aVar2 = this.f14172j;
            switch (attributeInt) {
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
            }
            aVar2.f13717c = i;
        } catch (IOException unused) {
        }
    }

    /* renamed from: e */
    public final void m7419e(@NonNull Image image) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        try {
            this.f14169r.writeImage(bufferedOutputStream, image);
            bufferedOutputStream.flush();
            this.f14172j.f13720f = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            this.f14169r.close();
            try {
                bufferedOutputStream.close();
            } catch (IOException unused) {
            }
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
    @Override // android.media.ImageReader.OnImageAvailableListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onImageAvailable(ImageReader imageReader) throws Throwable {
        Image imageAcquireNextImage;
        CameraLogger cameraLogger = FullPictureRecorder.f14171m;
        cameraLogger.m7159a(1, "onImageAvailable started.");
        Image image = 0;
        try {
            try {
                imageAcquireNextImage = imageReader.acquireNextImage();
                try {
                    int iOrdinal = this.f14172j.f13721g.ordinal();
                    if (iOrdinal == 0) {
                        m7418d(imageAcquireNextImage);
                    } else {
                        if (iOrdinal != 1) {
                            throw new IllegalStateException("Unknown format: " + this.f14172j.f13721g);
                        }
                        m7419e(imageAcquireNextImage);
                    }
                    if (imageAcquireNextImage != null) {
                        imageAcquireNextImage.close();
                    }
                    cameraLogger.m7159a(1, "onImageAvailable ended.");
                    mo7416b();
                } catch (Exception e) {
                    e = e;
                    this.f14172j = null;
                    this.f14174l = e;
                    mo7416b();
                    if (imageAcquireNextImage != null) {
                        imageAcquireNextImage.close();
                    }
                }
            } catch (Throwable th) {
                th = th;
                image = imageReader;
                if (image != 0) {
                    image.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            imageAcquireNextImage = null;
        } catch (Throwable th2) {
            th = th2;
            if (image != 0) {
            }
            throw th;
        }
    }
}
