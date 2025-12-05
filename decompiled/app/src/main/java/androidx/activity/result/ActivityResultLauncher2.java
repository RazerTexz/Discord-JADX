package androidx.activity.result;

import androidx.core.app.ActivityOptionsCompat;
import kotlin.Unit;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ActivityResultLauncher.kt */
/* renamed from: androidx.activity.result.ActivityResultLauncherKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ActivityResultLauncher2 {
    public static final void launch(ActivityResultLauncher<Void> activityResultLauncher, ActivityOptionsCompat activityOptionsCompat) {
        Intrinsics3.checkNotNullParameter(activityResultLauncher, "$this$launch");
        activityResultLauncher.launch(null, activityOptionsCompat);
    }

    public static /* synthetic */ void launch$default(ActivityResultLauncher activityResultLauncher, ActivityOptionsCompat activityOptionsCompat, int i, Object obj) {
        if ((i & 1) != 0) {
            activityOptionsCompat = null;
        }
        launch(activityResultLauncher, activityOptionsCompat);
    }

    public static final void launchUnit(ActivityResultLauncher<Unit> activityResultLauncher, ActivityOptionsCompat activityOptionsCompat) {
        Intrinsics3.checkNotNullParameter(activityResultLauncher, "$this$launch");
        activityResultLauncher.launch(null, activityOptionsCompat);
    }

    public static /* synthetic */ void launchUnit$default(ActivityResultLauncher activityResultLauncher, ActivityOptionsCompat activityOptionsCompat, int i, Object obj) {
        if ((i & 1) != 0) {
            activityOptionsCompat = null;
        }
        launchUnit(activityResultLauncher, activityOptionsCompat);
    }
}
