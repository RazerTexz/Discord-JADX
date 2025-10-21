package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ActivityResultCaller.kt */
/* renamed from: androidx.activity.result.ActivityResultCallerKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ActivityResultCaller2 {
    public static final <I, O> ActivityResultLauncher<Unit> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i, ActivityResultRegistry activityResultRegistry, Function1<? super O, Unit> function1) {
        Intrinsics3.checkNotNullParameter(activityResultCaller, "$this$registerForActivityResult");
        Intrinsics3.checkNotNullParameter(activityResultContract, "contract");
        Intrinsics3.checkNotNullParameter(activityResultRegistry, "registry");
        Intrinsics3.checkNotNullParameter(function1, "callback");
        ActivityResultLauncher<I> activityResultLauncherRegisterForActivityResult = activityResultCaller.registerForActivityResult(activityResultContract, activityResultRegistry, new ActivityResultCaller3(function1));
        Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…egistry) { callback(it) }");
        return new ActivityResultCaller5(activityResultLauncherRegisterForActivityResult, activityResultContract, i);
    }

    public static final <I, O> ActivityResultLauncher<Unit> registerForActivityResult(ActivityResultCaller activityResultCaller, ActivityResultContract<I, O> activityResultContract, I i, Function1<? super O, Unit> function1) {
        Intrinsics3.checkNotNullParameter(activityResultCaller, "$this$registerForActivityResult");
        Intrinsics3.checkNotNullParameter(activityResultContract, "contract");
        Intrinsics3.checkNotNullParameter(function1, "callback");
        ActivityResultLauncher<I> activityResultLauncherRegisterForActivityResult = activityResultCaller.registerForActivityResult(activityResultContract, new ActivityResultCaller4(function1));
        Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…ontract) { callback(it) }");
        return new ActivityResultCaller5(activityResultLauncherRegisterForActivityResult, activityResultContract, i);
    }
}
