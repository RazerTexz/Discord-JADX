package p007b.p452o.p453a.p455n.p462u;

import android.graphics.ImageFormat;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.HashSet;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p452o.p453a.CameraOptions;
import p007b.p452o.p453a.p454m.Facing;
import p007b.p452o.p453a.p454m.Flash;
import p007b.p452o.p453a.p454m.Hdr;
import p007b.p452o.p453a.p454m.PictureFormat;
import p007b.p452o.p453a.p454m.WhiteBalance;
import p007b.p452o.p453a.p455n.p458q.Camera2Mapper;
import p007b.p452o.p453a.p467r.CamcorderProfiles;
import p007b.p452o.p453a.p473x.AspectRatio2;
import p007b.p452o.p453a.p473x.Size3;

/* compiled from: Camera2Options.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.u.b, reason: use source file name */
/* loaded from: classes3.dex */
public class Camera2Options extends CameraOptions {
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Camera2Options(@NonNull CameraManager cameraManager, @NonNull String str, boolean z2, int i) throws CameraAccessException {
        Flash flash = Flash.OFF;
        if (Camera2Mapper.f13961a == null) {
            Camera2Mapper.f13961a = new Camera2Mapper();
        }
        Camera2Mapper camera2Mapper = Camera2Mapper.f13961a;
        CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
        for (String str2 : cameraManager.getCameraIdList()) {
            Integer num = (Integer) cameraManager.getCameraCharacteristics(str2).get(CameraCharacteristics.LENS_FACING);
            if (num != null) {
                Facing facing = (Facing) camera2Mapper.m7348a(Camera2Mapper.f13962b, Integer.valueOf(num.intValue()));
                if (facing != null) {
                    this.f13683b.add(facing);
                }
            }
        }
        for (int i2 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES)) {
            WhiteBalance whiteBalance = (WhiteBalance) camera2Mapper.m7348a(Camera2Mapper.f13963c, Integer.valueOf(i2));
            if (whiteBalance != null) {
                this.f13682a.add(whiteBalance);
            }
        }
        this.f13684c.add(flash);
        Boolean bool = (Boolean) cameraCharacteristics.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        boolean z3 = true;
        if (bool != null && bool.booleanValue()) {
            for (int i3 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES)) {
                Objects.requireNonNull(camera2Mapper);
                HashSet hashSet = new HashSet();
                if (i3 == 0 || i3 == 1) {
                    hashSet.add(flash);
                    hashSet.add(Flash.TORCH);
                } else if (i3 == 2) {
                    hashSet.add(Flash.AUTO);
                } else if (i3 == 3) {
                    hashSet.add(Flash.ON);
                } else if (i3 != 4) {
                }
                this.f13684c.addAll(hashSet);
            }
        }
        this.f13685d.add(Hdr.OFF);
        for (int i4 : (int[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_SCENE_MODES)) {
            Hdr hdr = (Hdr) camera2Mapper.m7348a(Camera2Mapper.f13964d, Integer.valueOf(i4));
            if (hdr != null) {
                this.f13685d.add(hdr);
            }
        }
        Float f = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f != null) {
            this.f13692k = f.floatValue() > 1.0f;
        }
        Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        Integer num3 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        Integer num4 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
        this.f13696o = (num2 != null && num2.intValue() > 0) || (num3 != null && num3.intValue() > 0) || (num4 != null && num4.intValue() > 0);
        Range range = (Range) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_RANGE);
        Rational rational = (Rational) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        if (range != null && rational != null && rational.floatValue() != 0.0f) {
            this.f13694m = ((Integer) range.getLower()).intValue() / rational.floatValue();
            this.f13695n = ((Integer) range.getUpper()).intValue() / rational.floatValue();
        }
        this.f13693l = (this.f13694m == 0.0f || this.f13695n == 0.0f) ? false : true;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
        }
        int[] outputFormats = streamConfigurationMap.getOutputFormats();
        int length = outputFormats.length;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                z3 = false;
                break;
            } else if (outputFormats[i5] == i) {
                break;
            } else {
                i5++;
            }
        }
        if (!z3) {
            throw new IllegalStateException(outline.m871q("Picture format not supported: ", i));
        }
        for (Size size : streamConfigurationMap.getOutputSizes(i)) {
            int height = z2 ? size.getHeight() : size.getWidth();
            int width = z2 ? size.getWidth() : size.getHeight();
            this.f13686e.add(new Size3(height, width));
            this.f13688g.add(AspectRatio2.m7447f(height, width));
        }
        CamcorderProfile camcorderProfileM7398b = CamcorderProfiles.m7398b(str, new Size3(Integer.MAX_VALUE, Integer.MAX_VALUE));
        int i6 = camcorderProfileM7398b.videoFrameWidth;
        int i7 = camcorderProfileM7398b.videoFrameHeight;
        for (Size size2 : streamConfigurationMap.getOutputSizes(MediaRecorder.class)) {
            if (size2.getWidth() <= i6 && size2.getHeight() <= i7) {
                int height2 = z2 ? size2.getHeight() : size2.getWidth();
                int width2 = z2 ? size2.getWidth() : size2.getHeight();
                this.f13687f.add(new Size3(height2, width2));
                this.f13689h.add(AspectRatio2.m7447f(height2, width2));
            }
        }
        Range[] rangeArr = (Range[]) cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        if (rangeArr != null) {
            this.f13697p = Float.MAX_VALUE;
            this.f13698q = -3.4028235E38f;
            for (Range range2 : rangeArr) {
                this.f13697p = Math.min(this.f13697p, ((Integer) range2.getLower()).intValue());
                this.f13698q = Math.max(this.f13698q, ((Integer) range2.getUpper()).intValue());
            }
        } else {
            this.f13697p = 0.0f;
            this.f13698q = 0.0f;
        }
        this.f13690i.add(PictureFormat.JPEG);
        int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            for (int i8 : iArr) {
                if (i8 == 3) {
                    this.f13690i.add(PictureFormat.DNG);
                }
            }
        }
        this.f13691j.add(35);
        for (int i9 : streamConfigurationMap.getOutputFormats()) {
            if (ImageFormat.getBitsPerPixel(i9) > 0) {
                this.f13691j.add(Integer.valueOf(i9));
            }
        }
    }
}
