package p007b.p225i.p226a.p242c.p278y2;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.MimeTypes;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p265v2.DecoderReuseEvaluation;

/* JADX INFO: renamed from: b.i.a.c.y2.u, reason: use source file name */
/* JADX INFO: compiled from: MediaCodecInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaCodecInfo {

    /* JADX INFO: renamed from: a */
    public final String f9112a;

    /* JADX INFO: renamed from: b */
    public final String f9113b;

    /* JADX INFO: renamed from: c */
    public final String f9114c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public final MediaCodecInfo.CodecCapabilities f9115d;

    /* JADX INFO: renamed from: e */
    public final boolean f9116e;

    /* JADX INFO: renamed from: f */
    public final boolean f9117f;

    /* JADX INFO: renamed from: g */
    public final boolean f9118g;

    @VisibleForTesting
    public MediaCodecInfo(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Objects.requireNonNull(str);
        this.f9112a = str;
        this.f9113b = str2;
        this.f9114c = str3;
        this.f9115d = codecCapabilities;
        this.f9116e = z5;
        this.f9117f = z7;
        this.f9118g = MimeTypes.m3052j(str2);
    }

    @RequiresApi(21)
    /* JADX INFO: renamed from: a */
    public static Point m3862a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(Util2.m2998f(i, widthAlignment) * widthAlignment, Util2.m2998f(i2, heightAlignment) * heightAlignment);
    }

    @RequiresApi(21)
    /* JADX INFO: renamed from: b */
    public static boolean m3863b(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point pointM3862a = m3862a(videoCapabilities, i, i2);
        int i3 = pointM3862a.x;
        int i4 = pointM3862a.y;
        return (d == -1.0d || d < 1.0d) ? videoCapabilities.isSizeSupported(i3, i4) : videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007b  */
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MediaCodecInfo m3864i(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        boolean z7;
        boolean z8;
        boolean z9;
        if (z5 || codecCapabilities == null) {
            z7 = false;
        } else {
            int i = Util2.f6708a;
            if (i >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback")) {
                if (i <= 22) {
                    String str4 = Util2.f6711d;
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
            if (Util2.f6708a >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback")) {
                z8 = true;
            }
        }
        if (z6) {
            z9 = true;
        } else {
            if (codecCapabilities != null) {
                if (Util2.f6708a >= 21 && codecCapabilities.isFeatureSupported("secure-playback")) {
                }
            }
            z9 = false;
        }
        return new MediaCodecInfo(str, str2, str3, codecCapabilities, z2, z3, z4, z7, z8, z9);
    }

    /* JADX INFO: renamed from: c */
    public DecoderReuseEvaluation m3865c(Format2 format2, Format2 format22) {
        boolean z2 = false;
        int i = !Util2.m2993a(format2.f7155w, format22.f7155w) ? 8 : 0;
        if (this.f9118g) {
            if (format2.f7131E != format22.f7131E) {
                i |= 1024;
            }
            if (!this.f9116e && (format2.f7128B != format22.f7128B || format2.f7129C != format22.f7129C)) {
                i |= 512;
            }
            if (!Util2.m2993a(format2.f7135I, format22.f7135I)) {
                i |= 2048;
            }
            String str = this.f9112a;
            if (Util2.f6711d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str)) {
                z2 = true;
            }
            if (z2 && !format2.m3276c(format22)) {
                i |= 2;
            }
            if (i == 0) {
                return new DecoderReuseEvaluation(this.f9112a, format2, format22, format2.m3276c(format22) ? 3 : 2, 0);
            }
        } else {
            if (format2.f7136J != format22.f7136J) {
                i |= 4096;
            }
            if (format2.f7137K != format22.f7137K) {
                i |= 8192;
            }
            if (format2.f7138L != format22.f7138L) {
                i |= 16384;
            }
            if (i == 0 && "audio/mp4a-latm".equals(this.f9113b)) {
                Pair<Integer, Integer> pairM8864c = MediaCodecUtil.m8864c(format2);
                Pair<Integer, Integer> pairM8864c2 = MediaCodecUtil.m8864c(format22);
                if (pairM8864c != null && pairM8864c2 != null) {
                    int iIntValue = ((Integer) pairM8864c.first).intValue();
                    int iIntValue2 = ((Integer) pairM8864c2.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new DecoderReuseEvaluation(this.f9112a, format2, format22, 3, 0);
                    }
                }
            }
            if (!format2.m3276c(format22)) {
                i |= 32;
            }
            if ("audio/opus".equals(this.f9113b)) {
                i |= 2;
            }
            if (i == 0) {
                return new DecoderReuseEvaluation(this.f9112a, format2, format22, 1, 0);
            }
        }
        return new DecoderReuseEvaluation(this.f9112a, format2, format22, 0, i);
    }

    /* JADX INFO: renamed from: d */
    public MediaCodecInfo.CodecProfileLevel[] m3866d() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f9115d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m3867e(Format2 format2) throws MediaCodecUtil.DecoderQueryException {
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        String strM3045c;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        String str = format2.f7152t;
        int i2 = 16;
        if (str == null || this.f9113b == null || (strM3045c = MimeTypes.m3045c(str)) == null) {
            z2 = true;
            break;
        }
        if (this.f9113b.equals(strM3045c)) {
            Pair<Integer, Integer> pairM8864c = MediaCodecUtil.m8864c(format2);
            if (pairM8864c != null) {
                int iIntValue = ((Integer) pairM8864c.first).intValue();
                int iIntValue2 = ((Integer) pairM8864c.second).intValue();
                if (this.f9118g || iIntValue == 42) {
                    MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrM3866d = m3866d();
                    if (Util2.f6708a <= 23 && "video/x-vnd.on2.vp9".equals(this.f9113b) && codecProfileLevelArrM3866d.length == 0) {
                        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f9115d;
                        int iIntValue3 = (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) ? 0 : ((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue();
                        int i3 = iIntValue3 >= 180000000 ? 1024 : iIntValue3 >= 120000000 ? 512 : iIntValue3 >= 60000000 ? 256 : iIntValue3 >= 30000000 ? 128 : iIntValue3 >= 18000000 ? 64 : iIntValue3 >= 12000000 ? 32 : iIntValue3 >= 7200000 ? 16 : iIntValue3 >= 3600000 ? 8 : iIntValue3 >= 1800000 ? 4 : iIntValue3 >= 800000 ? 2 : 1;
                        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
                        codecProfileLevel.profile = 1;
                        codecProfileLevel.level = i3;
                        codecProfileLevelArrM3866d = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
                    }
                    for (MediaCodecInfo.CodecProfileLevel codecProfileLevel2 : codecProfileLevelArrM3866d) {
                        if (codecProfileLevel2.profile != iIntValue || codecProfileLevel2.level < iIntValue2) {
                        }
                    }
                    String str2 = format2.f7152t;
                    m3870h(outline.m861l(strM3045c.length() + outline.m841b(str2, 22), "codec.profileLevel, ", str2, ", ", strM3045c));
                }
            }
            z2 = true;
            break;
        } else {
            String str3 = format2.f7152t;
            m3870h(outline.m861l(strM3045c.length() + outline.m841b(str3, 13), "codec.mime ", str3, ", ", strM3045c));
        }
        z2 = false;
        if (!z2) {
            return false;
        }
        if (this.f9118g) {
            int i4 = format2.f7128B;
            if (i4 <= 0 || (i = format2.f7129C) <= 0) {
                return true;
            }
            if (Util2.f6708a >= 21) {
                return m3869g(i4, i, format2.f7130D);
            }
            boolean z5 = i4 * i <= MediaCodecUtil.m8870i();
            if (!z5) {
                m3870h(outline.m853h(40, "legacyFrameSize, ", format2.f7128B, "x", format2.f7129C));
            }
            return z5;
        }
        int i5 = Util2.f6708a;
        if (i5 >= 21) {
            int i6 = format2.f7137K;
            if (i6 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.f9115d;
                if (codecCapabilities2 == null) {
                    m3870h("sampleRate.caps");
                } else {
                    MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities2.getAudioCapabilities();
                    if (audioCapabilities == null) {
                        m3870h("sampleRate.aCaps");
                    } else if (audioCapabilities.isSampleRateSupported(i6)) {
                        z4 = true;
                        if (!z4) {
                            return false;
                        }
                    } else {
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("sampleRate.support, ");
                        sb.append(i6);
                        m3870h(sb.toString());
                    }
                }
                z4 = false;
                if (!z4) {
                }
            }
            int i7 = format2.f7136J;
            if (i7 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities3 = this.f9115d;
                if (codecCapabilities3 == null) {
                    m3870h("channelCount.caps");
                } else {
                    MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities3.getAudioCapabilities();
                    if (audioCapabilities2 == null) {
                        m3870h("channelCount.aCaps");
                    } else {
                        String str4 = this.f9112a;
                        String str5 = this.f9113b;
                        int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                        if (maxInputChannelCount <= 1 && ((i5 < 26 || maxInputChannelCount <= 0) && !"audio/mpeg".equals(str5) && !"audio/3gpp".equals(str5) && !"audio/amr-wb".equals(str5) && !"audio/mp4a-latm".equals(str5) && !"audio/vorbis".equals(str5) && !"audio/opus".equals(str5) && !"audio/raw".equals(str5) && !"audio/flac".equals(str5) && !"audio/g711-alaw".equals(str5) && !"audio/g711-mlaw".equals(str5) && !"audio/gsm".equals(str5))) {
                            if ("audio/ac3".equals(str5)) {
                                i2 = 6;
                            } else if (!"audio/eac3".equals(str5)) {
                                i2 = 30;
                            }
                            StringBuilder sb2 = new StringBuilder(outline.m841b(str4, 59));
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
                            m3870h(sb3.toString());
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

    /* JADX INFO: renamed from: f */
    public boolean m3868f(Format2 format2) {
        if (this.f9118g) {
            return this.f9116e;
        }
        Pair<Integer, Integer> pairM8864c = MediaCodecUtil.m8864c(format2);
        return pairM8864c != null && ((Integer) pairM8864c.first).intValue() == 42;
    }

    @RequiresApi(21)
    /* JADX INFO: renamed from: g */
    public boolean m3869g(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f9115d;
        if (codecCapabilities == null) {
            m3870h("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            m3870h("sizeAndRate.vCaps");
            return false;
        }
        if (!m3863b(videoCapabilities, i, i2, d)) {
            if (i < i2) {
                if ((("OMX.MTK.VIDEO.DECODER.HEVC".equals(this.f9112a) && "mcv5a".equals(Util2.f6709b)) ? false : true) && m3863b(videoCapabilities, i2, i, d)) {
                    StringBuilder sb = new StringBuilder(69);
                    sb.append("sizeAndRate.rotated, ");
                    sb.append(i);
                    sb.append("x");
                    sb.append(i2);
                    sb.append("x");
                    sb.append(d);
                    String string = sb.toString();
                    String str = this.f9112a;
                    String str2 = this.f9113b;
                    String str3 = Util2.f6712e;
                    StringBuilder sbM831S = outline.m831S(outline.m841b(str3, outline.m841b(str2, outline.m841b(str, outline.m841b(string, 25)))), "AssumedSupport [", string, "] [", str);
                    outline.m876s0(sbM831S, ", ", str2, "] [", str3);
                    sbM831S.append("]");
                    Log.d("MediaCodecInfo", sbM831S.toString());
                }
            }
            StringBuilder sb2 = new StringBuilder(69);
            sb2.append("sizeAndRate.support, ");
            sb2.append(i);
            sb2.append("x");
            sb2.append(i2);
            sb2.append("x");
            sb2.append(d);
            m3870h(sb2.toString());
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: h */
    public final void m3870h(String str) {
        String str2 = this.f9112a;
        String str3 = this.f9113b;
        String str4 = Util2.f6712e;
        StringBuilder sbM831S = outline.m831S(outline.m841b(str4, outline.m841b(str3, outline.m841b(str2, outline.m841b(str, 20)))), "NoSupport [", str, "] [", str2);
        outline.m876s0(sbM831S, ", ", str3, "] [", str4);
        sbM831S.append("]");
        Log.d("MediaCodecInfo", sbM831S.toString());
    }

    public String toString() {
        return this.f9112a;
    }
}
