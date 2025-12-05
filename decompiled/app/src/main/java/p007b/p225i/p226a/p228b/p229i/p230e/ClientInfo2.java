package p007b.p225i.p226a.p228b.p229i.p230e;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* compiled from: ClientInfo.java */
@AutoValue
/* renamed from: b.i.a.b.i.e.k, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ClientInfo2 {

    /* compiled from: ClientInfo.java */
    /* renamed from: b.i.a.b.i.e.k$a */
    public enum a {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        private final int value;

        a(int i) {
            this.value = i;
        }
    }

    @Nullable
    /* renamed from: a */
    public abstract AndroidClientInfo mo2314a();

    @Nullable
    /* renamed from: b */
    public abstract a mo2315b();
}
