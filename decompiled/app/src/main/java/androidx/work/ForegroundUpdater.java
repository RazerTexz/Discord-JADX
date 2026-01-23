package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.UUID;
import p007b.p225i.p355b.p359d.p360a.ListenableFuture8;

/* JADX INFO: loaded from: classes.dex */
public interface ForegroundUpdater {
    @NonNull
    ListenableFuture8<Void> setForegroundAsync(@NonNull Context context, @NonNull UUID uuid, @NonNull ForegroundInfo foregroundInfo);
}
