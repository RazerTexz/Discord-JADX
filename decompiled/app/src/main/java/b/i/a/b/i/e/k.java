package b.i.a.b.i.e;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* compiled from: ClientInfo.java */
@AutoValue
/* loaded from: classes3.dex */
public abstract class k {

    /* compiled from: ClientInfo.java */
    public enum a {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        private final int value;

        a(int i) {
            this.value = i;
        }
    }

    @Nullable
    public abstract b.i.a.b.i.e.a a();

    @Nullable
    public abstract a b();
}
