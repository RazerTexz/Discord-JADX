package p007b.p452o.p453a.p455n.p462u;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import p007b.p452o.p453a.CameraOptions;
import p007b.p452o.p453a.p454m.Facing;
import p007b.p452o.p453a.p454m.Flash;
import p007b.p452o.p453a.p454m.Hdr;
import p007b.p452o.p453a.p454m.PictureFormat;
import p007b.p452o.p453a.p454m.WhiteBalance;
import p007b.p452o.p453a.p455n.p458q.Camera1Mapper;
import p007b.p452o.p453a.p467r.CamcorderProfiles;
import p007b.p452o.p453a.p473x.AspectRatio2;
import p007b.p452o.p453a.p473x.Size3;

/* compiled from: Camera1Options.java */
/* renamed from: b.o.a.n.u.a, reason: use source file name */
/* loaded from: classes3.dex */
public class Camera1Options extends CameraOptions {
    public Camera1Options(@NonNull Camera.Parameters parameters, int i, boolean z2) {
        CamcorderProfile camcorderProfile;
        int i2;
        int i3;
        Camera1Mapper camera1MapperM7346a = Camera1Mapper.m7346a();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i4 = 0; i4 < numberOfCameras; i4++) {
            Camera.getCameraInfo(i4, cameraInfo);
            Facing facing = (Facing) camera1MapperM7346a.m7347b(Camera1Mapper.f13959d, Integer.valueOf(cameraInfo.facing));
            if (facing != null) {
                this.f13683b.add(facing);
            }
        }
        List<String> supportedWhiteBalance = parameters.getSupportedWhiteBalance();
        if (supportedWhiteBalance != null) {
            Iterator<String> it = supportedWhiteBalance.iterator();
            while (it.hasNext()) {
                WhiteBalance whiteBalance = (WhiteBalance) camera1MapperM7346a.m7347b(Camera1Mapper.f13958c, it.next());
                if (whiteBalance != null) {
                    this.f13682a.add(whiteBalance);
                }
            }
        }
        this.f13684c.add(Flash.OFF);
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes != null) {
            Iterator<String> it2 = supportedFlashModes.iterator();
            while (it2.hasNext()) {
                Flash flash = (Flash) camera1MapperM7346a.m7347b(Camera1Mapper.f13957b, it2.next());
                if (flash != null) {
                    this.f13684c.add(flash);
                }
            }
        }
        this.f13685d.add(Hdr.OFF);
        List<String> supportedSceneModes = parameters.getSupportedSceneModes();
        if (supportedSceneModes != null) {
            Iterator<String> it3 = supportedSceneModes.iterator();
            while (it3.hasNext()) {
                Hdr hdr = (Hdr) camera1MapperM7346a.m7347b(Camera1Mapper.f13960e, it3.next());
                if (hdr != null) {
                    this.f13685d.add(hdr);
                }
            }
        }
        this.f13692k = parameters.isZoomSupported();
        this.f13696o = parameters.getSupportedFocusModes().contains("auto");
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        this.f13694m = parameters.getMinExposureCompensation() * exposureCompensationStep;
        this.f13695n = parameters.getMaxExposureCompensation() * exposureCompensationStep;
        this.f13693l = (parameters.getMinExposureCompensation() == 0 && parameters.getMaxExposureCompensation() == 0) ? false : true;
        for (Camera.Size size : parameters.getSupportedPictureSizes()) {
            int i5 = z2 ? size.height : size.width;
            int i6 = z2 ? size.width : size.height;
            this.f13686e.add(new Size3(i5, i6));
            this.f13688g.add(AspectRatio2.m7447f(i5, i6));
        }
        ArrayList arrayList = new ArrayList(CamcorderProfiles.f14101b.keySet());
        Collections.sort(arrayList, new CamcorderProfiles.a(Integer.MAX_VALUE * Integer.MAX_VALUE));
        while (true) {
            if (arrayList.size() <= 0) {
                camcorderProfile = CamcorderProfile.get(i, 0);
                break;
            }
            int iIntValue = CamcorderProfiles.f14101b.get((Size3) arrayList.remove(0)).intValue();
            if (CamcorderProfile.hasProfile(i, iIntValue)) {
                camcorderProfile = CamcorderProfile.get(i, iIntValue);
                break;
            }
        }
        int i7 = camcorderProfile.videoFrameWidth;
        int i8 = camcorderProfile.videoFrameHeight;
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        if (supportedVideoSizes != null) {
            for (Camera.Size size2 : supportedVideoSizes) {
                int i9 = size2.width;
                if (i9 <= i7 && (i3 = size2.height) <= i8) {
                    int i10 = z2 ? i3 : i9;
                    i9 = z2 ? i9 : i3;
                    this.f13687f.add(new Size3(i10, i9));
                    this.f13689h.add(AspectRatio2.m7447f(i10, i9));
                }
            }
        } else {
            for (Camera.Size size3 : parameters.getSupportedPreviewSizes()) {
                int i11 = size3.width;
                if (i11 <= i7 && (i2 = size3.height) <= i8) {
                    int i12 = z2 ? i2 : i11;
                    i11 = z2 ? i11 : i2;
                    this.f13687f.add(new Size3(i12, i11));
                    this.f13689h.add(AspectRatio2.m7447f(i12, i11));
                }
            }
        }
        this.f13697p = Float.MAX_VALUE;
        this.f13698q = -3.4028235E38f;
        for (int[] iArr : parameters.getSupportedPreviewFpsRange()) {
            float f = iArr[0] / 1000.0f;
            this.f13697p = Math.min(this.f13697p, f);
            this.f13698q = Math.max(this.f13698q, iArr[1] / 1000.0f);
        }
        this.f13690i.add(PictureFormat.JPEG);
        this.f13691j.add(17);
    }
}
