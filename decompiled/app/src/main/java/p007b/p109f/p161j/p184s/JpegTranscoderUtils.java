package p007b.p109f.p161j.p184s;

import java.util.Collections;
import p007b.p109f.p115d.p119d.ImmutableList;
import p007b.p109f.p161j.p169d.ResizeOptions;
import p007b.p109f.p161j.p169d.RotationOptions;
import p007b.p109f.p161j.p175j.EncodedImage2;

/* JADX INFO: renamed from: b.f.j.s.d, reason: use source file name */
/* JADX INFO: compiled from: JpegTranscoderUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class JpegTranscoderUtils {

    /* JADX INFO: renamed from: a */
    public static final ImmutableList<Integer> f4268a;

    static {
        ImmutableList<Integer> immutableList = new ImmutableList<>(4);
        Collections.addAll(immutableList, 2, 7, 4, 5);
        f4268a = immutableList;
    }

    /* JADX INFO: renamed from: a */
    public static int m1532a(RotationOptions rotationOptions, EncodedImage2 encodedImage2) {
        encodedImage2.m1347x();
        int i = encodedImage2.f3895n;
        ImmutableList<Integer> immutableList = f4268a;
        int iIndexOf = immutableList.indexOf(Integer.valueOf(i));
        if (iIndexOf >= 0) {
            return immutableList.get((((rotationOptions.m1251c() ? 0 : rotationOptions.m1249a()) / 90) + iIndexOf) % immutableList.size()).intValue();
        }
        throw new IllegalArgumentException("Only accepts inverted exif orientations");
    }

    /* JADX INFO: renamed from: b */
    public static int m1533b(RotationOptions rotationOptions, EncodedImage2 encodedImage2) {
        int i = 0;
        if (!rotationOptions.m1250b()) {
            return 0;
        }
        encodedImage2.m1347x();
        int i2 = encodedImage2.f3894m;
        if (i2 == 90 || i2 == 180 || i2 == 270) {
            encodedImage2.m1347x();
            i = encodedImage2.f3894m;
        }
        return rotationOptions.m1251c() ? i : (rotationOptions.m1249a() + i) % 360;
    }

    /* JADX INFO: renamed from: c */
    public static int m1534c(RotationOptions rotationOptions, ResizeOptions resizeOptions, EncodedImage2 encodedImage2, boolean z2) {
        int i;
        int i2;
        if (!z2 || resizeOptions == null) {
            return 8;
        }
        int iM1533b = m1533b(rotationOptions, encodedImage2);
        ImmutableList<Integer> immutableList = f4268a;
        encodedImage2.m1347x();
        int iM1532a = immutableList.contains(Integer.valueOf(encodedImage2.f3895n)) ? m1532a(rotationOptions, encodedImage2) : 0;
        boolean z3 = iM1533b == 90 || iM1533b == 270 || iM1532a == 5 || iM1532a == 7;
        if (z3) {
            encodedImage2.m1347x();
            i = encodedImage2.f3897p;
        } else {
            encodedImage2.m1347x();
            i = encodedImage2.f3896o;
        }
        if (z3) {
            encodedImage2.m1347x();
            i2 = encodedImage2.f3896o;
        } else {
            encodedImage2.m1347x();
            i2 = encodedImage2.f3897p;
        }
        float f = i;
        float f2 = i2;
        float fMax = Math.max(resizeOptions.f3717a / f, resizeOptions.f3718b / f2);
        float f3 = f * fMax;
        float f4 = resizeOptions.f3719c;
        if (f3 > f4) {
            fMax = f4 / f;
        }
        if (f2 * fMax > f4) {
            fMax = f4 / f2;
        }
        int i3 = (int) ((fMax * 8.0f) + resizeOptions.f3720d);
        if (i3 > 8) {
            return 8;
        }
        if (i3 < 1) {
            return 1;
        }
        return i3;
    }
}
