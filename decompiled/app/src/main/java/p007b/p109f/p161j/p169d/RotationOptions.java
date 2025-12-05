package p007b.p109f.p161j.p169d;

import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: RotationOptions.java */
/* renamed from: b.f.j.d.f, reason: use source file name */
/* loaded from: classes.dex */
public class RotationOptions {

    /* renamed from: a */
    public static final RotationOptions f3721a = new RotationOptions(-1, false);

    /* renamed from: b */
    public static final RotationOptions f3722b = new RotationOptions(-1, true);

    /* renamed from: c */
    public final int f3723c;

    /* renamed from: d */
    public final boolean f3724d;

    public RotationOptions(int i, boolean z2) {
        this.f3723c = i;
        this.f3724d = z2;
    }

    /* renamed from: a */
    public int m1249a() {
        if (m1251c()) {
            throw new IllegalStateException("Rotation is set to use EXIF");
        }
        return this.f3723c;
    }

    /* renamed from: b */
    public boolean m1250b() {
        return this.f3723c != -2;
    }

    /* renamed from: c */
    public boolean m1251c() {
        return this.f3723c == -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RotationOptions)) {
            return false;
        }
        RotationOptions rotationOptions = (RotationOptions) obj;
        return this.f3723c == rotationOptions.f3723c && this.f3724d == rotationOptions.f3724d;
    }

    public int hashCode() {
        return AnimatableValueParser.m448K0(Integer.valueOf(this.f3723c), Boolean.valueOf(this.f3724d));
    }

    public String toString() {
        return String.format(null, "%d defer:%b", Integer.valueOf(this.f3723c), Boolean.valueOf(this.f3724d));
    }
}
