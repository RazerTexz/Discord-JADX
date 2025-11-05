package b.i.a.c.t2;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.b.b.n;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: AudioCapabilities.java */
/* loaded from: classes3.dex */
public final class p {
    public static final p a = new p(new int[]{2}, 8);

    /* renamed from: b, reason: collision with root package name */
    public static final p f1125b = new p(new int[]{2, 5, 6}, 8);
    public static final int[] c = {5, 6, 18, 17, 14, 7, 8};
    public final int[] d;
    public final int e;

    /* compiled from: AudioCapabilities.java */
    @RequiresApi(29)
    public static final class a {
        @DoNotInline
        public static int[] a() {
            b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
            b.i.a.f.e.o.f.A(4, "initialCapacity");
            Object[] objArrCopyOf = new Object[4];
            int i = 0;
            boolean z2 = false;
            for (int i2 : p.c) {
                if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(i2).setSampleRate(48000).build(), new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build())) {
                    Integer numValueOf = Integer.valueOf(i2);
                    Objects.requireNonNull(numValueOf);
                    int i3 = i + 1;
                    if (objArrCopyOf.length < i3) {
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, n.b.a(objArrCopyOf.length, i3));
                    } else {
                        if (z2) {
                            objArrCopyOf = (Object[]) objArrCopyOf.clone();
                        }
                        objArrCopyOf[i] = numValueOf;
                        i++;
                    }
                    z2 = false;
                    objArrCopyOf[i] = numValueOf;
                    i++;
                }
            }
            Objects.requireNonNull(2);
            int i4 = i + 1;
            if (objArrCopyOf.length < i4) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, n.b.a(objArrCopyOf.length, i4));
            } else if (z2) {
                objArrCopyOf = (Object[]) objArrCopyOf.clone();
            }
            objArrCopyOf[i] = 2;
            return b.i.a.f.e.o.f.q1(b.i.b.b.p.l(objArrCopyOf, i + 1));
        }
    }

    public p(@Nullable int[] iArr, int i) {
        if (iArr != null) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
            this.d = iArrCopyOf;
            Arrays.sort(iArrCopyOf);
        } else {
            this.d = new int[0];
        }
        this.e = i;
    }

    public boolean a(int i) {
        return Arrays.binarySearch(this.d, i) >= 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return Arrays.equals(this.d, pVar.d) && this.e == pVar.e;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.d) * 31) + this.e;
    }

    public String toString() {
        int i = this.e;
        String string = Arrays.toString(this.d);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }
}
