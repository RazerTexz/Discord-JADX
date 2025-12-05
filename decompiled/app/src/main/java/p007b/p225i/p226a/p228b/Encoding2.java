package p007b.p225i.p226a.p228b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: Encoding.java */
/* renamed from: b.i.a.b.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class Encoding2 {

    /* renamed from: a */
    public final String f5118a;

    public Encoding2(@NonNull String str) {
        Objects.requireNonNull(str, "name is null");
        this.f5118a = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Encoding2) {
            return this.f5118a.equals(((Encoding2) obj).f5118a);
        }
        return false;
    }

    public int hashCode() {
        return this.f5118a.hashCode() ^ 1000003;
    }

    @NonNull
    public String toString() {
        return outline.m822J(outline.m833U("Encoding{name=\""), this.f5118a, "\"}");
    }
}
