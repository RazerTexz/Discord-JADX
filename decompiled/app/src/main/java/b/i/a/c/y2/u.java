package b.i.a.c.y2;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import b.i.a.c.f3.e0;
import b.i.a.c.j1;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.Objects;

/* compiled from: MediaCodecInfo.java */
/* loaded from: classes3.dex */
public final class u {
    public final String a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1315b;
    public final String c;

    @Nullable
    public final MediaCodecInfo.CodecCapabilities d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    @VisibleForTesting
    public u(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Objects.requireNonNull(str);
        this.a = str;
        this.f1315b = str2;
        this.c = str3;
        this.d = codecCapabilities;
        this.e = z5;
        this.f = z7;
        this.g = b.i.a.c.f3.t.j(str2);
    }

    @RequiresApi(21)
    public static Point a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(e0.f(i, widthAlignment) * widthAlignment, e0.f(i2, heightAlignment) * heightAlignment);
    }

    @RequiresApi(21)
    public static boolean b(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point pointA = a(videoCapabilities, i, i2);
        int i3 = pointA.x;
        int i4 = pointA.y;
        return (d == -1.0d || d < 1.0d) ? videoCapabilities.isSizeSupported(i3, i4) : videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static u i(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        boolean z7;
        boolean z8;
        boolean z9;
        if (z5 || codecCapabilities == null) {
            z7 = false;
        } else {
            int i = e0.a;
            if (i >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback")) {
                if (i <= 22) {
                    String str4 = e0.d;
                    boolean z10 = ("ODROID-XU3".equals(str4) || "Nexus 10".equals(str4)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str));
                    if (!z10) {
                        z7 = true;
                    }
                }
            }
        }
        if (codecCapabilities == null) {
            z8 = false;
        } else {
            if (e0.a >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback")) {
                z8 = true;
            }
        }
        if (z6) {
            z9 = true;
        } else {
            if (codecCapabilities != null) {
                if (e0.a >= 21 && codecCapabilities.isFeatureSupported("secure-playback")) {
                }
            }
            z9 = false;
        }
        return new u(str, str2, str3, codecCapabilities, z2, z3, z4, z7, z8, z9);
    }

    public b.i.a.c.v2.g c(j1 j1Var, j1 j1Var2) {
        boolean z2 = false;
        int i = !e0.a(j1Var.w, j1Var2.w) ? 8 : 0;
        if (this.g) {
            if (j1Var.E != j1Var2.E) {
                i |= 1024;
            }
            if (!this.e && (j1Var.B != j1Var2.B || j1Var.C != j1Var2.C)) {
                i |= 512;
            }
            if (!e0.a(j1Var.I, j1Var2.I)) {
                i |= 2048;
            }
            String str = this.a;
            if (e0.d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str)) {
                z2 = true;
            }
            if (z2 && !j1Var.c(j1Var2)) {
                i |= 2;
            }
            if (i == 0) {
                return new b.i.a.c.v2.g(this.a, j1Var, j1Var2, j1Var.c(j1Var2) ? 3 : 2, 0);
            }
        } else {
            if (j1Var.J != j1Var2.J) {
                i |= 4096;
            }
            if (j1Var.K != j1Var2.K) {
                i |= 8192;
            }
            if (j1Var.L != j1Var2.L) {
                i |= 16384;
            }
            if (i == 0 && "audio/mp4a-latm".equals(this.f1315b)) {
                Pair<Integer, Integer> pairC = MediaCodecUtil.c(j1Var);
                Pair<Integer, Integer> pairC2 = MediaCodecUtil.c(j1Var2);
                if (pairC != null && pairC2 != null) {
                    int iIntValue = ((Integer) pairC.first).intValue();
                    int iIntValue2 = ((Integer) pairC2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new b.i.a.c.v2.g(this.a, j1Var, j1Var2, 3, 0);
                    }
                }
            }
            if (!j1Var.c(j1Var2)) {
                i |= 32;
            }
            if ("audio/opus".equals(this.f1315b)) {
                i |= 2;
            }
            if (i == 0) {
                return new b.i.a.c.v2.g(this.a, j1Var, j1Var2, 1, 0);
            }
        }
        return new b.i.a.c.v2.g(this.a, j1Var, j1Var2, 0, i);
    }

    public MediaCodecInfo.CodecProfileLevel[] d() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(j1 j1Var) throws MediaCodecUtil.DecoderQueryException {
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        String strC;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        String str = j1Var.t;
        int i2 = 16;
        if (str == null || this.f1315b == null || (strC = b.i.a.c.f3.t.c(str)) == null) {
            z2 = true;
            break;
        }
        if (this.f1315b.equals(strC)) {
            Pair<Integer, Integer> pairC = MediaCodecUtil.c(j1Var);
            if (pairC != null) {
                int iIntValue = ((Integer) pairC.first).intValue();
                int iIntValue2 = ((Integer) pairC.second).intValue();
                if (this.g || iIntValue == 42) {
                    MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrD = d();
                    if (e0.a <= 23 && "video/x-vnd.on2.vp9".equals(this.f1315b) && codecProfileLevelArrD.length == 0) {
                        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
                        int iIntValue3 = (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) ? 0 : ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
                        int i3 = iIntValue3 >= 180000000 ? 1024 : iIntValue3 >= 120000000 ? 512 : iIntValue3 >= 60000000 ? 256 : iIntValue3 >= 30000000 ? 128 : iIntValue3 >= 18000000 ? 64 : iIntValue3 >= 12000000 ? 32 : iIntValue3 >= 7200000 ? 16 : iIntValue3 >= 3600000 ? 8 : iIntValue3 >= 1800000 ? 4 : iIntValue3 >= 800000 ? 2 : 1;
                        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
                        codecProfileLevel.profile = 1;
                        codecProfileLevel.level = i3;
                        codecProfileLevelArrD = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
                    }
                    for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : codecProfileLevelArrD) {
                        if (codecProfileLevel2.profile != iIntValue || codecProfileLevel2.level < iIntValue2) {
                        }
                    }
                    String str2 = j1Var.t;
                    h(b.d.b.a.a.l(strC.length() + b.d.b.a.a.b(str2, 22), "codec.profileLevel, ", str2, ", ", strC));
                }
            }
            z2 = true;
            break;
        } else {
            String str3 = j1Var.t;
            h(b.d.b.a.a.l(strC.length() + b.d.b.a.a.b(str3, 13), "codec.mime ", str3, ", ", strC));
        }
        z2 = false;
        if (!z2) {
            return false;
        }
        if (this.g) {
            int i4 = j1Var.B;
            if (i4 <= 0 || (i = j1Var.C) <= 0) {
                return true;
            }
            if (e0.a >= 21) {
                return g(i4, i, j1Var.D);
            }
            boolean z5 = i4 * i <= MediaCodecUtil.i();
            if (!z5) {
                h(b.d.b.a.a.h(40, "legacyFrameSize, ", j1Var.B, "x", j1Var.C));
            }
            return z5;
        }
        int i5 = e0.a;
        if (i5 >= 21) {
            int i6 = j1Var.K;
            if (i6 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.d;
                if (codecCapabilities2 == null) {
                    h("sampleRate.caps");
                } else {
                    MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities2.getAudioCapabilities();
                    if (audioCapabilities == null) {
                        h("sampleRate.aCaps");
                    } else if (audioCapabilities.isSampleRateSupported(i6)) {
                        z4 = true;
                        if (!z4) {
                            return false;
                        }
                    } else {
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("sampleRate.support, ");
                        sb.append(i6);
                        h(sb.toString());
                    }
                }
                z4 = false;
                if (!z4) {
                }
            }
            int i7 = j1Var.J;
            if (i7 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities3 = this.d;
                if (codecCapabilities3 == null) {
                    h("channelCount.caps");
                } else {
                    MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities3.getAudioCapabilities();
                    if (audioCapabilities2 == null) {
                        h("channelCount.aCaps");
                    } else {
                        String str4 = this.a;
                        String str5 = this.f1315b;
                        int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                        if (maxInputChannelCount <= 1 && ((i5 < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str5) && !"audio/3gpp".equals(str5) && !"audio/amr-wb".equals(str5) && !"audio/mp4a-latm".equals(str5) && !"audio/vorbis".equals(str5) && !"audio/opus".equals(str5) && !"audio/raw".equals(str5) && !"audio/flac".equals(str5) && !"audio/g711-alaw".equals(str5) && !"audio/g711-mlaw".equals(str5) && !"audio/gsm".equals(str5))) {
                            if ("audio/ac3".equals(str5)) {
                                i2 = 6;
                            } else if (!"audio/eac3".equals(str5)) {
                                i2 = 30;
                            }
                            StringBuilder sb2 = new StringBuilder(b.d.b.a.a.b(str4, 59));
                            sb2.append("AssumedMaxChannelAdjustment: ");
                            sb2.append(str4);
                            sb2.append(", [");
                            sb2.append(maxInputChannelCount);
                            sb2.append(" to ");
                            sb2.append(i2);
                            sb2.append("]");
                            Log.w("MediaCodecInfo", sb2.toString());
                            maxInputChannelCount = i2;
                        }
                        if (maxInputChannelCount < i7) {
                            StringBuilder sb3 = new StringBuilder(33);
                            sb3.append("channelCount.support, ");
                            sb3.append(i7);
                            h(sb3.toString());
                        } else {
                            z3 = true;
                            if (z3) {
                                return false;
                            }
                        }
                    }
                }
                z3 = false;
                if (z3) {
                }
            }
        }
        return true;
    }

    public boolean f(j1 j1Var) {
        if (this.g) {
            return this.e;
        }
        Pair<Integer, Integer> pairC = MediaCodecUtil.c(j1Var);
        return pairC != null && ((Integer) pairC.first).intValue() == 42;
    }

    @RequiresApi(21)
    public boolean g(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null) {
            h("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            h("sizeAndRate.vCaps");
            return false;
        }
        if (!b(videoCapabilities, i, i2, d)) {
            if (i < i2) {
                if ((("OMX.MTK.VIDEO.DECODER.HEVC".equals(this.a) && "mcv5a".equals(e0.f968b)) ? false : true) && b(videoCapabilities, i2, i, d)) {
                    StringBuilder sb = new StringBuilder(69);
                    sb.append("sizeAndRate.rotated, ");
                    sb.append(i);
                    sb.append("x");
                    sb.append(i2);
                    sb.append("x");
                    sb.append(d);
                    String string = sb.toString();
                    String str = this.a;
                    String str2 = this.f1315b;
                    String str3 = e0.e;
                    StringBuilder sbS = b.d.b.a.a.S(b.d.b.a.a.b(str3, b.d.b.a.a.b(str2, b.d.b.a.a.b(str, b.d.b.a.a.b(string, 25)))), "AssumedSupport [", string, "] [", str);
                    b.d.b.a.a.s0(sbS, ", ", str2, "] [", str3);
                    sbS.append("]");
                    Log.d("MediaCodecInfo", sbS.toString());
                }
            }
            StringBuilder sb2 = new StringBuilder(69);
            sb2.append("sizeAndRate.support, ");
            sb2.append(i);
            sb2.append("x");
            sb2.append(i2);
            sb2.append("x");
            sb2.append(d);
            h(sb2.toString());
            return false;
        }
        return true;
    }

    public final void h(String str) {
        String str2 = this.a;
        String str3 = this.f1315b;
        String str4 = e0.e;
        StringBuilder sbS = b.d.b.a.a.S(b.d.b.a.a.b(str4, b.d.b.a.a.b(str3, b.d.b.a.a.b(str2, b.d.b.a.a.b(str, 20)))), "NoSupport [", str, "] [", str2);
        b.d.b.a.a.s0(sbS, ", ", str3, "] [", str4);
        sbS.append("]");
        Log.d("MediaCodecInfo", sbS.toString());
    }

    public String toString() {
        return this.a;
    }
}
