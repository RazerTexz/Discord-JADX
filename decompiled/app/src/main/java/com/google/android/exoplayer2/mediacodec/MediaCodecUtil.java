package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.MimeTypes;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.ColorInfo;
import p007b.p225i.p226a.p242c.p278y2.C3133e;
import p007b.p225i.p226a.p242c.p278y2.C3134f;
import p007b.p225i.p226a.p242c.p278y2.C3136h;
import p007b.p225i.p226a.p242c.p278y2.MediaCodecInfo;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

@SuppressLint({"InlinedApi"})
/* loaded from: classes3.dex */
public final class MediaCodecUtil {

    /* renamed from: a */
    public static final Pattern f19928a = Pattern.compile("^\\D?(\\d+)$");

    /* renamed from: b */
    @GuardedBy("MediaCodecUtil.class")
    public static final HashMap<C10714b, List<MediaCodecInfo>> f19929b = new HashMap<>();

    /* renamed from: c */
    public static int f19930c = -1;

    public static class DecoderQueryException extends Exception {
        public DecoderQueryException(Throwable th, C10713a c10713a) {
            super("Failed to query underlying media codecs", th);
        }
    }

    /* renamed from: com.google.android.exoplayer2.mediacodec.MediaCodecUtil$b */
    public static final class C10714b {

        /* renamed from: a */
        public final String f19931a;

        /* renamed from: b */
        public final boolean f19932b;

        /* renamed from: c */
        public final boolean f19933c;

        public C10714b(String str, boolean z2, boolean z3) {
            this.f19931a = str;
            this.f19932b = z2;
            this.f19933c = z3;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != C10714b.class) {
                return false;
            }
            C10714b c10714b = (C10714b) obj;
            return TextUtils.equals(this.f19931a, c10714b.f19931a) && this.f19932b == c10714b.f19932b && this.f19933c == c10714b.f19933c;
        }

        public int hashCode() {
            return ((outline.m863m(this.f19931a, 31, 31) + (this.f19932b ? 1231 : 1237)) * 31) + (this.f19933c ? 1231 : 1237);
        }
    }

    /* renamed from: com.google.android.exoplayer2.mediacodec.MediaCodecUtil$c */
    public interface InterfaceC10715c {
        /* renamed from: a */
        android.media.MediaCodecInfo mo8872a(int i);

        /* renamed from: b */
        boolean mo8873b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        /* renamed from: c */
        boolean mo8874c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        /* renamed from: d */
        int mo8875d();

        /* renamed from: e */
        boolean mo8876e();
    }

    /* renamed from: com.google.android.exoplayer2.mediacodec.MediaCodecUtil$d */
    public static final class C10716d implements InterfaceC10715c {
        public C10716d(C10713a c10713a) {
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.InterfaceC10715c
        /* renamed from: a */
        public android.media.MediaCodecInfo mo8872a(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.InterfaceC10715c
        /* renamed from: b */
        public boolean mo8873b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && "video/avc".equals(str2);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.InterfaceC10715c
        /* renamed from: c */
        public boolean mo8874c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.InterfaceC10715c
        /* renamed from: d */
        public int mo8875d() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.InterfaceC10715c
        /* renamed from: e */
        public boolean mo8876e() {
            return false;
        }
    }

    @RequiresApi(21)
    /* renamed from: com.google.android.exoplayer2.mediacodec.MediaCodecUtil$e */
    public static final class C10717e implements InterfaceC10715c {

        /* renamed from: a */
        public final int f19934a;

        /* renamed from: b */
        @Nullable
        public android.media.MediaCodecInfo[] f19935b;

        public C10717e(boolean z2, boolean z3) {
            this.f19934a = (z2 || z3) ? 1 : 0;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.InterfaceC10715c
        /* renamed from: a */
        public android.media.MediaCodecInfo mo8872a(int i) {
            if (this.f19935b == null) {
                this.f19935b = new MediaCodecList(this.f19934a).getCodecInfos();
            }
            return this.f19935b[i];
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.InterfaceC10715c
        /* renamed from: b */
        public boolean mo8873b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.InterfaceC10715c
        /* renamed from: c */
        public boolean mo8874c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.InterfaceC10715c
        /* renamed from: d */
        public int mo8875d() {
            if (this.f19935b == null) {
                this.f19935b = new MediaCodecList(this.f19934a).getCodecInfos();
            }
            return this.f19935b.length;
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecUtil.InterfaceC10715c
        /* renamed from: e */
        public boolean mo8876e() {
            return true;
        }
    }

    /* renamed from: com.google.android.exoplayer2.mediacodec.MediaCodecUtil$f */
    public interface InterfaceC10718f<T> {
        /* renamed from: a */
        int mo3830a(T t);
    }

    /* renamed from: a */
    public static void m8862a(String str, List<p007b.p225i.p226a.p242c.p278y2.MediaCodecInfo> list) {
        if ("audio/raw".equals(str)) {
            if (Util2.f6708a < 26 && Util2.f6709b.equals("R9") && list.size() == 1 && list.get(0).f9112a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(p007b.p225i.p226a.p242c.p278y2.MediaCodecInfo.m3864i("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            m8871j(list, C3133e.f9051a);
        }
        int i = Util2.f6708a;
        if (i < 21 && list.size() > 1) {
            String str2 = list.get(0).f9112a;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                m8871j(list, C3134f.f9052a);
            }
        }
        if (i >= 32 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(list.get(0).f9112a)) {
            return;
        }
        list.add(list.remove(0));
    }

    @Nullable
    /* renamed from: b */
    public static String m8863b(android.media.MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0158, code lost:
    
        switch(r0) {
            case 1567: goto L142;
            case 1568: goto L138;
            case 1569: goto L134;
            case 1570: goto L130;
            default: goto L146;
        };
     */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x042f A[Catch: NumberFormatException -> 0x043f, TRY_LEAVE, TryCatch #3 {NumberFormatException -> 0x043f, blocks: (B:280:0x03c4, B:282:0x03d8, B:294:0x03f7, B:310:0x042f), top: B:637:0x03c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:448:0x061e  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x06dd  */
    /* JADX WARN: Removed duplicated region for block: B:585:0x08a6  */
    /* JADX WARN: Removed duplicated region for block: B:586:0x08a8  */
    /* JADX WARN: Removed duplicated region for block: B:596:0x08bd  */
    /* JADX WARN: Removed duplicated region for block: B:597:0x08bf  */
    /* JADX WARN: Removed duplicated region for block: B:598:0x08c2  */
    /* JADX WARN: Removed duplicated region for block: B:599:0x08c5  */
    /* JADX WARN: Removed duplicated region for block: B:600:0x08c8  */
    /* JADX WARN: Removed duplicated region for block: B:601:0x08cb  */
    /* JADX WARN: Removed duplicated region for block: B:602:0x08ce  */
    /* JADX WARN: Removed duplicated region for block: B:603:0x08d1  */
    /* JADX WARN: Removed duplicated region for block: B:604:0x08d4  */
    /* JADX WARN: Removed duplicated region for block: B:605:0x08d7  */
    /* JADX WARN: Removed duplicated region for block: B:606:0x08db  */
    /* JADX WARN: Removed duplicated region for block: B:607:0x08de  */
    /* JADX WARN: Removed duplicated region for block: B:608:0x08e1  */
    /* JADX WARN: Removed duplicated region for block: B:609:0x08e4  */
    /* JADX WARN: Removed duplicated region for block: B:610:0x08e7  */
    /* JADX WARN: Removed duplicated region for block: B:611:0x08ea  */
    /* JADX WARN: Removed duplicated region for block: B:612:0x08ed  */
    /* JADX WARN: Removed duplicated region for block: B:613:0x08f0  */
    /* JADX WARN: Removed duplicated region for block: B:614:0x08f3  */
    /* JADX WARN: Removed duplicated region for block: B:615:0x08f6  */
    /* JADX WARN: Removed duplicated region for block: B:616:0x08f9  */
    /* JADX WARN: Removed duplicated region for block: B:617:0x08fc  */
    /* JADX WARN: Removed duplicated region for block: B:618:0x08ff  */
    /* JADX WARN: Removed duplicated region for block: B:619:0x0901  */
    /* JADX WARN: Removed duplicated region for block: B:620:0x0903  */
    /* JADX WARN: Removed duplicated region for block: B:623:0x0907  */
    /* JADX WARN: Removed duplicated region for block: B:624:0x090f  */
    /* JADX WARN: Removed duplicated region for block: B:646:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x014a  */
    @Nullable
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Integer, Integer> m8864c(Format2 format2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Integer num;
        int i8;
        int i9;
        int i10;
        int i11;
        Integer num2;
        Integer num3;
        String str = format2.f7152t;
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        if ("video/dolby-vision".equals(format2.f7155w)) {
            String str2 = format2.f7152t;
            if (strArrSplit.length < 3) {
                String strValueOf = String.valueOf(str2);
                Log.w("MediaCodecUtil", strValueOf.length() != 0 ? "Ignoring malformed Dolby Vision codec string: ".concat(strValueOf) : new String("Ignoring malformed Dolby Vision codec string: "));
            } else {
                Matcher matcher = f19928a.matcher(strArrSplit[1]);
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    if (strGroup == null) {
                        num2 = null;
                        if (num2 != null) {
                            String strValueOf2 = String.valueOf(strGroup);
                            Log.w("MediaCodecUtil", strValueOf2.length() != 0 ? "Unknown Dolby Vision profile string: ".concat(strValueOf2) : new String("Unknown Dolby Vision profile string: "));
                        } else {
                            String str3 = strArrSplit[2];
                            if (str3 == null) {
                                num3 = null;
                                if (num3 == null) {
                                    return new Pair<>(num2, num3);
                                }
                                String strValueOf3 = String.valueOf(str3);
                                Log.w("MediaCodecUtil", strValueOf3.length() != 0 ? "Unknown Dolby Vision level string: ".concat(strValueOf3) : new String("Unknown Dolby Vision level string: "));
                            } else {
                                int iHashCode = str3.hashCode();
                                switch (str3) {
                                    case "01":
                                        num3 = 1;
                                        break;
                                    case "02":
                                        num3 = 2;
                                        break;
                                    case "03":
                                        num3 = 4;
                                        break;
                                    case "04":
                                        num3 = 8;
                                        break;
                                    case "05":
                                        num3 = 16;
                                        break;
                                    case "06":
                                        num3 = 32;
                                        break;
                                    case "07":
                                        num3 = 64;
                                        break;
                                    case "08":
                                        num3 = 128;
                                        break;
                                    case "09":
                                        num3 = 256;
                                        break;
                                    case "10":
                                        num3 = 512;
                                        break;
                                    case "11":
                                        num3 = 1024;
                                        break;
                                    case "12":
                                        num3 = 2048;
                                        break;
                                    case "13":
                                        num3 = 4096;
                                        break;
                                }
                                if (num3 == null) {
                                }
                            }
                        }
                    } else {
                        switch (strGroup) {
                            case "00":
                                num2 = 1;
                                break;
                            case "01":
                                num2 = 2;
                                break;
                            case "02":
                                num2 = 4;
                                break;
                            case "03":
                                num2 = 8;
                                break;
                            case "04":
                                num2 = 16;
                                break;
                            case "05":
                                num2 = 32;
                                break;
                            case "06":
                                num2 = 64;
                                break;
                            case "07":
                                num2 = 128;
                                break;
                            case "08":
                                num2 = 256;
                                break;
                            case "09":
                                num2 = 512;
                                break;
                        }
                        if (num2 != null) {
                        }
                    }
                } else {
                    String strValueOf4 = String.valueOf(str2);
                    Log.w("MediaCodecUtil", strValueOf4.length() != 0 ? "Ignoring malformed Dolby Vision codec string: ".concat(strValueOf4) : new String("Ignoring malformed Dolby Vision codec string: "));
                }
            }
            return null;
        }
        String str4 = strArrSplit[0];
        str4.hashCode();
        switch (str4) {
            case "av01":
                String str5 = format2.f7152t;
                ColorInfo colorInfo = format2.f7135I;
                if (strArrSplit.length < 4) {
                    String strValueOf5 = String.valueOf(str5);
                    Log.w("MediaCodecUtil", strValueOf5.length() != 0 ? "Ignoring malformed AV1 codec string: ".concat(strValueOf5) : new String("Ignoring malformed AV1 codec string: "));
                    return null;
                }
                try {
                    int i12 = Integer.parseInt(strArrSplit[1]);
                    int i13 = Integer.parseInt(strArrSplit[2].substring(0, 2));
                    int i14 = Integer.parseInt(strArrSplit[3]);
                    if (i12 != 0) {
                        outline.m852g0(32, "Unknown AV1 profile: ", i12, "MediaCodecUtil");
                    } else {
                        int i15 = 8;
                        if (i14 == 8) {
                            int i16 = i14 != i15 ? 1 : (colorInfo == null || !(colorInfo.f6847n != null || (i = colorInfo.f6846m) == 7 || i == 6)) ? 2 : 4096;
                            switch (i13) {
                                case 0:
                                    i2 = 1;
                                    break;
                                case 1:
                                    i2 = 2;
                                    break;
                                case 2:
                                    i2 = 4;
                                    break;
                                case 3:
                                    i2 = 8;
                                    break;
                                case 4:
                                    i2 = 16;
                                    break;
                                case 5:
                                    i2 = 32;
                                    break;
                                case 6:
                                    i2 = 64;
                                    break;
                                case 7:
                                    i2 = 128;
                                    break;
                                case 8:
                                    i2 = 256;
                                    break;
                                case 9:
                                    i2 = 512;
                                    break;
                                case 10:
                                    i2 = 1024;
                                    break;
                                case 11:
                                    i2 = 2048;
                                    break;
                                case 12:
                                    i2 = 4096;
                                    break;
                                case 13:
                                    i2 = 8192;
                                    break;
                                case 14:
                                    i2 = 16384;
                                    break;
                                case 15:
                                    i2 = 32768;
                                    break;
                                case 16:
                                    i2 = 65536;
                                    break;
                                case 17:
                                    i2 = 131072;
                                    break;
                                case 18:
                                    i2 = 262144;
                                    break;
                                case 19:
                                    i2 = 524288;
                                    break;
                                case 20:
                                    i2 = 1048576;
                                    break;
                                case 21:
                                    i2 = 2097152;
                                    break;
                                case 22:
                                    i2 = 4194304;
                                    break;
                                case 23:
                                    i2 = 8388608;
                                    break;
                                default:
                                    i2 = -1;
                                    break;
                            }
                            if (i2 == -1) {
                                return new Pair<>(Integer.valueOf(i16), Integer.valueOf(i2));
                            }
                            outline.m852g0(30, "Unknown AV1 level: ", i13, "MediaCodecUtil");
                        } else if (i14 != 10) {
                            outline.m852g0(34, "Unknown AV1 bit depth: ", i14, "MediaCodecUtil");
                        } else {
                            i15 = 8;
                            if (i14 != i15) {
                            }
                            switch (i13) {
                            }
                            if (i2 == -1) {
                            }
                        }
                    }
                } catch (NumberFormatException unused) {
                    String strValueOf6 = String.valueOf(str5);
                    Log.w("MediaCodecUtil", strValueOf6.length() != 0 ? "Ignoring malformed AV1 codec string: ".concat(strValueOf6) : new String("Ignoring malformed AV1 codec string: "));
                }
                return null;
            case "avc1":
            case "avc2":
                int i17 = 2048;
                String str6 = format2.f7152t;
                if (strArrSplit.length < 2) {
                    String strValueOf7 = String.valueOf(str6);
                    Log.w("MediaCodecUtil", strValueOf7.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(strValueOf7) : new String("Ignoring malformed AVC codec string: "));
                    return null;
                }
                try {
                    if (strArrSplit[1].length() == 6) {
                        i3 = Integer.parseInt(strArrSplit[1].substring(0, 2), 16);
                        i4 = Integer.parseInt(strArrSplit[1].substring(4), 16);
                    } else {
                        if (strArrSplit.length < 3) {
                            String strValueOf8 = String.valueOf(str6);
                            Log.w("MediaCodecUtil", strValueOf8.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(strValueOf8) : new String("Ignoring malformed AVC codec string: "));
                            return null;
                        }
                        i3 = Integer.parseInt(strArrSplit[1]);
                        i4 = Integer.parseInt(strArrSplit[2]);
                    }
                    int i18 = i3 != 66 ? i3 != 77 ? i3 != 88 ? i3 != 100 ? i3 != 110 ? i3 != 122 ? i3 != 244 ? -1 : 64 : 32 : 16 : 8 : 4 : 2 : 1;
                    if (i18 == -1) {
                        outline.m852g0(32, "Unknown AVC profile: ", i3, "MediaCodecUtil");
                        return null;
                    }
                    switch (i4) {
                        case 10:
                            i5 = -1;
                            i6 = 1;
                            break;
                        case 11:
                            i5 = -1;
                            i6 = 4;
                            break;
                        case 12:
                            i5 = -1;
                            i6 = 8;
                            break;
                        case 13:
                            i5 = -1;
                            i6 = 16;
                            break;
                        default:
                            switch (i4) {
                                case 20:
                                    i5 = -1;
                                    i6 = 32;
                                    break;
                                case 21:
                                    i5 = -1;
                                    i6 = 64;
                                    break;
                                case 22:
                                    i5 = -1;
                                    i6 = 128;
                                    break;
                                default:
                                    switch (i4) {
                                        case 30:
                                            i5 = -1;
                                            i6 = 256;
                                            break;
                                        case 31:
                                            i5 = -1;
                                            i6 = 512;
                                            break;
                                        case 32:
                                            i5 = -1;
                                            i6 = 1024;
                                            break;
                                        default:
                                            switch (i4) {
                                                case 40:
                                                    i6 = i17;
                                                    i5 = -1;
                                                    break;
                                                case 41:
                                                    i5 = -1;
                                                    i6 = 4096;
                                                    break;
                                                case 42:
                                                    i17 = 8192;
                                                    i6 = i17;
                                                    i5 = -1;
                                                    break;
                                                default:
                                                    switch (i4) {
                                                        case 50:
                                                            i17 = 16384;
                                                            i6 = i17;
                                                            i5 = -1;
                                                            break;
                                                        case 51:
                                                            i17 = 32768;
                                                            i6 = i17;
                                                            i5 = -1;
                                                            break;
                                                        case 52:
                                                            i17 = 65536;
                                                            i6 = i17;
                                                            i5 = -1;
                                                            break;
                                                        default:
                                                            i5 = -1;
                                                            i6 = -1;
                                                            break;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    if (i6 != i5) {
                        return new Pair<>(Integer.valueOf(i18), Integer.valueOf(i6));
                    }
                    outline.m852g0(30, "Unknown AVC level: ", i4, "MediaCodecUtil");
                    return null;
                } catch (NumberFormatException unused2) {
                    String strValueOf9 = String.valueOf(str6);
                    Log.w("MediaCodecUtil", strValueOf9.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(strValueOf9) : new String("Ignoring malformed AVC codec string: "));
                    return null;
                }
            case "hev1":
            case "hvc1":
                String str7 = format2.f7152t;
                if (strArrSplit.length < 4) {
                    String strValueOf10 = String.valueOf(str7);
                    Log.w("MediaCodecUtil", strValueOf10.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(strValueOf10) : new String("Ignoring malformed HEVC codec string: "));
                    return null;
                }
                Matcher matcher2 = f19928a.matcher(strArrSplit[1]);
                if (!matcher2.matches()) {
                    String strValueOf11 = String.valueOf(str7);
                    Log.w("MediaCodecUtil", strValueOf11.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(strValueOf11) : new String("Ignoring malformed HEVC codec string: "));
                    return null;
                }
                String strGroup2 = matcher2.group(1);
                if ("1".equals(strGroup2)) {
                    i7 = 1;
                } else {
                    if (!ExifInterface.GPS_MEASUREMENT_2D.equals(strGroup2)) {
                        String strValueOf12 = String.valueOf(strGroup2);
                        Log.w("MediaCodecUtil", strValueOf12.length() != 0 ? "Unknown HEVC profile string: ".concat(strValueOf12) : new String("Unknown HEVC profile string: "));
                        return null;
                    }
                    i7 = 2;
                }
                String str8 = strArrSplit[3];
                if (str8 != null) {
                    switch (str8) {
                        case "H30":
                            num = 2;
                            break;
                        case "H60":
                            num = 8;
                            break;
                        case "H63":
                            num = 32;
                            break;
                        case "H90":
                            num = 128;
                            break;
                        case "H93":
                            num = 512;
                            break;
                        case "L30":
                            num = 1;
                            break;
                        case "L60":
                            num = 4;
                            break;
                        case "L63":
                            num = 16;
                            break;
                        case "L90":
                            num = 64;
                            break;
                        case "L93":
                            num = 256;
                            break;
                        case "H120":
                            num = 2048;
                            break;
                        case "H123":
                            num = 8192;
                            break;
                        case "H150":
                            num = 32768;
                            break;
                        case "H153":
                            num = 131072;
                            break;
                        case "H156":
                            num = 524288;
                            break;
                        case "H180":
                            num = 2097152;
                            break;
                        case "H183":
                            num = 8388608;
                            break;
                        case "H186":
                            num = 33554432;
                            break;
                        case "L120":
                            num = 1024;
                            break;
                        case "L123":
                            num = 4096;
                            break;
                        case "L150":
                            num = 16384;
                            break;
                        case "L153":
                            num = 65536;
                            break;
                        case "L156":
                            num = 262144;
                            break;
                        case "L180":
                            num = 1048576;
                            break;
                        case "L183":
                            num = 4194304;
                            break;
                        case "L186":
                            num = 16777216;
                            break;
                    }
                } else {
                    num = null;
                }
                if (num != null) {
                    return new Pair<>(Integer.valueOf(i7), num);
                }
                String strValueOf13 = String.valueOf(str8);
                Log.w("MediaCodecUtil", strValueOf13.length() != 0 ? "Unknown HEVC level string: ".concat(strValueOf13) : new String("Unknown HEVC level string: "));
                return null;
            case "mp4a":
                String str9 = format2.f7152t;
                if (strArrSplit.length != 3) {
                    String strValueOf14 = String.valueOf(str9);
                    Log.w("MediaCodecUtil", strValueOf14.length() != 0 ? "Ignoring malformed MP4A codec string: ".concat(strValueOf14) : new String("Ignoring malformed MP4A codec string: "));
                    return null;
                }
                try {
                    if (!"audio/mp4a-latm".equals(MimeTypes.m3046d(Integer.parseInt(strArrSplit[1], 16)))) {
                        return null;
                    }
                    int i19 = Integer.parseInt(strArrSplit[2]);
                    if (i19 == 17) {
                        i8 = 17;
                    } else if (i19 == 20) {
                        i8 = 20;
                    } else if (i19 == 23) {
                        i8 = 23;
                    } else if (i19 == 29) {
                        i8 = 29;
                    } else if (i19 == 39) {
                        i8 = 39;
                    } else {
                        if (i19 != 42) {
                            switch (i19) {
                                case 1:
                                    i9 = -1;
                                    i8 = 1;
                                    break;
                                case 2:
                                    i9 = -1;
                                    i8 = 2;
                                    break;
                                case 3:
                                    i9 = -1;
                                    i8 = 3;
                                    break;
                                case 4:
                                    i9 = -1;
                                    i8 = 4;
                                    break;
                                case 5:
                                    i9 = -1;
                                    i8 = 5;
                                    break;
                                case 6:
                                    i9 = -1;
                                    i8 = 6;
                                    break;
                                default:
                                    i9 = -1;
                                    i8 = -1;
                                    break;
                            }
                            if (i8 == i9) {
                                return new Pair<>(Integer.valueOf(i8), 0);
                            }
                            return null;
                        }
                        i8 = 42;
                    }
                    i9 = -1;
                    if (i8 == i9) {
                    }
                } catch (NumberFormatException unused3) {
                    String strValueOf15 = String.valueOf(str9);
                    Log.w("MediaCodecUtil", strValueOf15.length() != 0 ? "Ignoring malformed MP4A codec string: ".concat(strValueOf15) : new String("Ignoring malformed MP4A codec string: "));
                    return null;
                }
                break;
            case "vp09":
                String str10 = format2.f7152t;
                if (strArrSplit.length < 3) {
                    String strValueOf16 = String.valueOf(str10);
                    Log.w("MediaCodecUtil", strValueOf16.length() != 0 ? "Ignoring malformed VP9 codec string: ".concat(strValueOf16) : new String("Ignoring malformed VP9 codec string: "));
                    return null;
                }
                try {
                    int i20 = Integer.parseInt(strArrSplit[1]);
                    int i21 = Integer.parseInt(strArrSplit[2]);
                    int i22 = i20 != 0 ? i20 != 1 ? i20 != 2 ? i20 != 3 ? -1 : 8 : 4 : 2 : 1;
                    if (i22 == -1) {
                        outline.m852g0(32, "Unknown VP9 profile: ", i20, "MediaCodecUtil");
                        return null;
                    }
                    if (i21 == 10) {
                        i10 = -1;
                        i11 = 1;
                    } else if (i21 == 11) {
                        i10 = -1;
                        i11 = 2;
                    } else if (i21 == 20) {
                        i10 = -1;
                        i11 = 4;
                    } else if (i21 == 21) {
                        i10 = -1;
                        i11 = 8;
                    } else if (i21 == 30) {
                        i10 = -1;
                        i11 = 16;
                    } else if (i21 == 31) {
                        i10 = -1;
                        i11 = 32;
                    } else if (i21 == 40) {
                        i10 = -1;
                        i11 = 64;
                    } else if (i21 == 41) {
                        i10 = -1;
                        i11 = 128;
                    } else if (i21 == 50) {
                        i10 = -1;
                        i11 = 256;
                    } else if (i21 != 51) {
                        switch (i21) {
                            case 60:
                                i10 = -1;
                                i11 = 2048;
                                break;
                            case 61:
                                i10 = -1;
                                i11 = 4096;
                                break;
                            case 62:
                                i11 = 8192;
                                i10 = -1;
                                break;
                            default:
                                i10 = -1;
                                i11 = -1;
                                break;
                        }
                    } else {
                        i10 = -1;
                        i11 = 512;
                    }
                    if (i11 != i10) {
                        return new Pair<>(Integer.valueOf(i22), Integer.valueOf(i11));
                    }
                    outline.m852g0(30, "Unknown VP9 level: ", i21, "MediaCodecUtil");
                    return null;
                } catch (NumberFormatException unused4) {
                    String strValueOf17 = String.valueOf(str10);
                    Log.w("MediaCodecUtil", strValueOf17.length() != 0 ? "Ignoring malformed VP9 codec string: ".concat(strValueOf17) : new String("Ignoring malformed VP9 codec string: "));
                    return null;
                }
            default:
                return null;
        }
    }

    @Nullable
    /* renamed from: d */
    public static p007b.p225i.p226a.p242c.p278y2.MediaCodecInfo m8865d(String str, boolean z2, boolean z3) throws DecoderQueryException {
        List<p007b.p225i.p226a.p242c.p278y2.MediaCodecInfo> listM8866e = m8866e(str, z2, z3);
        if (listM8866e.isEmpty()) {
            return null;
        }
        return listM8866e.get(0);
    }

    /* renamed from: e */
    public static synchronized List<p007b.p225i.p226a.p242c.p278y2.MediaCodecInfo> m8866e(String str, boolean z2, boolean z3) throws DecoderQueryException {
        C10714b c10714b = new C10714b(str, z2, z3);
        HashMap<C10714b, List<p007b.p225i.p226a.p242c.p278y2.MediaCodecInfo>> map = f19929b;
        List<p007b.p225i.p226a.p242c.p278y2.MediaCodecInfo> list = map.get(c10714b);
        if (list != null) {
            return list;
        }
        int i = Util2.f6708a;
        ArrayList<p007b.p225i.p226a.p242c.p278y2.MediaCodecInfo> arrayListM8867f = m8867f(c10714b, i >= 21 ? new C10717e(z2, z3) : new C10716d(null));
        if (z2 && arrayListM8867f.isEmpty() && 21 <= i && i <= 23) {
            arrayListM8867f = m8867f(c10714b, new C10716d(null));
            if (!arrayListM8867f.isEmpty()) {
                String str2 = arrayListM8867f.get(0).f9112a;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                sb.append("MediaCodecList API didn't list secure decoder for: ");
                sb.append(str);
                sb.append(". Assuming: ");
                sb.append(str2);
                Log.w("MediaCodecUtil", sb.toString());
            }
        }
        m8862a(str, arrayListM8867f);
        List<p007b.p225i.p226a.p242c.p278y2.MediaCodecInfo> listUnmodifiableList = Collections.unmodifiableList(arrayListM8867f);
        map.put(c10714b, listUnmodifiableList);
        return listUnmodifiableList;
    }

    /* renamed from: f */
    public static ArrayList<p007b.p225i.p226a.p242c.p278y2.MediaCodecInfo> m8867f(C10714b c10714b, InterfaceC10715c interfaceC10715c) throws DecoderQueryException {
        String strM8863b;
        String str;
        String str2;
        int i;
        boolean z2;
        int i2;
        boolean z3;
        boolean zIsHardwareAccelerated;
        boolean zIsVendor;
        try {
            ArrayList<p007b.p225i.p226a.p242c.p278y2.MediaCodecInfo> arrayList = new ArrayList<>();
            String str3 = c10714b.f19931a;
            int iMo8875d = interfaceC10715c.mo8875d();
            boolean zMo8876e = interfaceC10715c.mo8876e();
            int i3 = 0;
            while (i3 < iMo8875d) {
                android.media.MediaCodecInfo mediaCodecInfoMo8872a = interfaceC10715c.mo8872a(i3);
                int i4 = Util2.f6708a;
                if (!(i4 >= 29 && mediaCodecInfoMo8872a.isAlias())) {
                    String name = mediaCodecInfoMo8872a.getName();
                    if (m8868g(mediaCodecInfoMo8872a, name, zMo8876e, str3) && (strM8863b = m8863b(mediaCodecInfoMo8872a, name, str3)) != null) {
                        try {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfoMo8872a.getCapabilitiesForType(strM8863b);
                            boolean zMo8873b = interfaceC10715c.mo8873b("tunneled-playback", strM8863b, capabilitiesForType);
                            boolean zMo8874c = interfaceC10715c.mo8874c("tunneled-playback", strM8863b, capabilitiesForType);
                            boolean z4 = c10714b.f19933c;
                            if ((z4 || !zMo8874c) && (!z4 || zMo8873b)) {
                                boolean zMo8873b2 = interfaceC10715c.mo8873b("secure-playback", strM8863b, capabilitiesForType);
                                boolean zMo8874c2 = interfaceC10715c.mo8874c("secure-playback", strM8863b, capabilitiesForType);
                                boolean z5 = c10714b.f19932b;
                                if ((z5 || !zMo8874c2) && (!z5 || zMo8873b2)) {
                                    if (i4 >= 29) {
                                        zIsHardwareAccelerated = mediaCodecInfoMo8872a.isHardwareAccelerated();
                                        z3 = true;
                                    } else {
                                        z3 = true;
                                        zIsHardwareAccelerated = !m8869h(mediaCodecInfoMo8872a);
                                    }
                                    boolean zM8869h = m8869h(mediaCodecInfoMo8872a);
                                    if (i4 >= 29) {
                                        zIsVendor = mediaCodecInfoMo8872a.isVendor();
                                    } else {
                                        String strM4349u1 = C3404f.m4349u1(mediaCodecInfoMo8872a.getName());
                                        if (strM4349u1.startsWith("omx.google.") || strM4349u1.startsWith("c2.android.") || strM4349u1.startsWith("c2.google.")) {
                                            z3 = false;
                                        }
                                        zIsVendor = z3;
                                    }
                                    if (!(zMo8876e && c10714b.f19932b == zMo8873b2) && (zMo8876e || c10714b.f19932b)) {
                                        str = strM8863b;
                                        str2 = name;
                                        i = i3;
                                        z2 = zMo8876e;
                                        i2 = iMo8875d;
                                        if (!z2 && zMo8873b2) {
                                            arrayList.add(p007b.p225i.p226a.p242c.p278y2.MediaCodecInfo.m3864i(String.valueOf(str2).concat(".secure"), str3, str, capabilitiesForType, zIsHardwareAccelerated, zM8869h, zIsVendor, false, true));
                                            return arrayList;
                                        }
                                    } else {
                                        str = strM8863b;
                                        str2 = name;
                                        i = i3;
                                        z2 = zMo8876e;
                                        i2 = iMo8875d;
                                        try {
                                            arrayList.add(p007b.p225i.p226a.p242c.p278y2.MediaCodecInfo.m3864i(name, str3, strM8863b, capabilitiesForType, zIsHardwareAccelerated, zM8869h, zIsVendor, false, false));
                                        } catch (Exception e) {
                                            e = e;
                                            if (Util2.f6708a > 23 || arrayList.isEmpty()) {
                                                String str4 = str2;
                                                StringBuilder sb = new StringBuilder(String.valueOf(str4).length() + 25 + str.length());
                                                sb.append("Failed to query codec ");
                                                sb.append(str4);
                                                sb.append(" (");
                                                sb.append(str);
                                                sb.append(")");
                                                Log.e("MediaCodecUtil", sb.toString());
                                                throw e;
                                            }
                                            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 46);
                                            sb2.append("Skipping codec ");
                                            sb2.append(str2);
                                            sb2.append(" (failed to query capabilities)");
                                            Log.e("MediaCodecUtil", sb2.toString());
                                            i3 = i + 1;
                                            iMo8875d = i2;
                                            zMo8876e = z2;
                                        }
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str = strM8863b;
                            str2 = name;
                            i = i3;
                            z2 = zMo8876e;
                            i2 = iMo8875d;
                        }
                    }
                    i3 = i + 1;
                    iMo8875d = i2;
                    zMo8876e = z2;
                }
                i = i3;
                z2 = zMo8876e;
                i2 = iMo8875d;
                i3 = i + 1;
                iMo8875d = i2;
                zMo8876e = z2;
            }
            return arrayList;
        } catch (Exception e3) {
            throw new DecoderQueryException(e3, null);
        }
    }

    /* renamed from: g */
    public static boolean m8868g(android.media.MediaCodecInfo mediaCodecInfo, String str, boolean z2, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z2 && str.endsWith(".secure"))) {
            return false;
        }
        int i = Util2.f6708a;
        if (i < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = Util2.f6709b;
            if ("a70".equals(str3) || ("Xiaomi".equals(Util2.f6710c) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = Util2.f6709b;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = Util2.f6709b;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(Util2.f6710c))) {
            String str6 = Util2.f6709b;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(Util2.f6710c)) {
            String str7 = Util2.f6709b;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i <= 19 && Util2.f6709b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return ("audio/eac3-joc".equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    /* renamed from: h */
    public static boolean m8869h(android.media.MediaCodecInfo mediaCodecInfo) {
        if (Util2.f6708a >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        String strM4349u1 = C3404f.m4349u1(mediaCodecInfo.getName());
        if (strM4349u1.startsWith("arc.")) {
            return false;
        }
        return strM4349u1.startsWith("omx.google.") || strM4349u1.startsWith("omx.ffmpeg.") || (strM4349u1.startsWith("omx.sec.") && strM4349u1.contains(".sw.")) || strM4349u1.equals("omx.qcom.video.decoder.hevcswvdec") || strM4349u1.startsWith("c2.android.") || strM4349u1.startsWith("c2.google.") || !(strM4349u1.startsWith("omx.") || strM4349u1.startsWith("c2."));
    }

    /* renamed from: i */
    public static int m8870i() throws DecoderQueryException {
        int i;
        if (f19930c == -1) {
            int iMax = 0;
            p007b.p225i.p226a.p242c.p278y2.MediaCodecInfo mediaCodecInfoM8865d = m8865d("video/avc", false, false);
            if (mediaCodecInfoM8865d != null) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrM3866d = mediaCodecInfoM8865d.m3866d();
                int length = codecProfileLevelArrM3866d.length;
                int iMax2 = 0;
                while (iMax < length) {
                    int i2 = codecProfileLevelArrM3866d[iMax].level;
                    if (i2 != 1 && i2 != 2) {
                        switch (i2) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                break;
                            case 64:
                                i = 202752;
                                break;
                            case 128:
                            case 256:
                                i = 414720;
                                break;
                            case 512:
                                i = 921600;
                                break;
                            case 1024:
                                i = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                break;
                            case 8192:
                                i = 2228224;
                                break;
                            case 16384:
                                i = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                break;
                            case 131072:
                            case 262144:
                            case 524288:
                                i = 35651584;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 25344;
                    }
                    iMax2 = Math.max(i, iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, Util2.f6708a >= 21 ? 345600 : 172800);
            }
            f19930c = iMax;
        }
        return f19930c;
    }

    /* renamed from: j */
    public static <T> void m8871j(List<T> list, InterfaceC10718f<T> interfaceC10718f) {
        Collections.sort(list, new C3136h(interfaceC10718f));
    }
}
