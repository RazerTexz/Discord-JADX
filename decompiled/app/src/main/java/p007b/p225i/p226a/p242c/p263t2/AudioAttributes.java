package p007b.p225i.p226a.p242c.p263t2;

import android.media.AudioAttributes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import p007b.p225i.p226a.p242c.Bundleable;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.t2.o, reason: use source file name */
/* JADX INFO: compiled from: AudioAttributes.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AudioAttributes implements Bundleable {

    /* JADX INFO: renamed from: j */
    public static final AudioAttributes f7779j = new AudioAttributes(0, 0, 1, 1, null);

    /* JADX INFO: renamed from: k */
    public final int f7780k;

    /* JADX INFO: renamed from: l */
    public final int f7781l;

    /* JADX INFO: renamed from: m */
    public final int f7782m;

    /* JADX INFO: renamed from: n */
    public final int f7783n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public android.media.AudioAttributes f7784o;

    public AudioAttributes(int i, int i2, int i3, int i4, a aVar) {
        this.f7780k = i;
        this.f7781l = i2;
        this.f7782m = i3;
        this.f7783n = i4;
    }

    @RequiresApi(21)
    /* JADX INFO: renamed from: a */
    public android.media.AudioAttributes m3494a() {
        if (this.f7784o == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(this.f7780k).setFlags(this.f7781l).setUsage(this.f7782m);
            if (Util2.f6708a >= 29) {
                usage.setAllowedCapturePolicy(this.f7783n);
            }
            this.f7784o = usage.build();
        }
        return this.f7784o;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AudioAttributes.class != obj.getClass()) {
            return false;
        }
        AudioAttributes audioAttributes = (AudioAttributes) obj;
        return this.f7780k == audioAttributes.f7780k && this.f7781l == audioAttributes.f7781l && this.f7782m == audioAttributes.f7782m && this.f7783n == audioAttributes.f7783n;
    }

    public int hashCode() {
        return ((((((527 + this.f7780k) * 31) + this.f7781l) * 31) + this.f7782m) * 31) + this.f7783n;
    }
}
