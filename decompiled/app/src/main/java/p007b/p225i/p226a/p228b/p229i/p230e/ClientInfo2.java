package p007b.p225i.p226a.p228b.p229i.p230e;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* JADX INFO: renamed from: b.i.a.b.i.e.k, reason: use source file name */
/* JADX INFO: compiled from: ClientInfo.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class ClientInfo2 {

    /* JADX INFO: renamed from: b.i.a.b.i.e.k$a */
    /* JADX INFO: compiled from: ClientInfo.java */
    public enum a {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        private final int value;

        a(int i) {
            this.value = i;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public abstract AndroidClientInfo mo2314a();

    @Nullable
    /* JADX INFO: renamed from: b */
    public abstract a mo2315b();
}
