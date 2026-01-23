package p007b.p225i.p226a.p242c.p255c3;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.c3.n, reason: use source file name */
/* JADX INFO: compiled from: TrackSelectionArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TrackSelectionArray {

    /* JADX INFO: renamed from: a */
    public final TrackSelection[] f6268a;

    /* JADX INFO: renamed from: b */
    public int f6269b;

    public TrackSelectionArray(TrackSelection... trackSelectionArr) {
        this.f6268a = trackSelectionArr;
        int length = trackSelectionArr.length;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackSelectionArray.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f6268a, ((TrackSelectionArray) obj).f6268a);
    }

    public int hashCode() {
        if (this.f6269b == 0) {
            this.f6269b = 527 + Arrays.hashCode(this.f6268a);
        }
        return this.f6269b;
    }
}
