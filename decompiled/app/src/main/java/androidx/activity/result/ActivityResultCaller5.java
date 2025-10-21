package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.Unit;

/* compiled from: ActivityResultCaller.kt */
/* renamed from: androidx.activity.result.ActivityResultCallerLauncher, reason: use source file name */
/* loaded from: classes.dex */
public final class ActivityResultCaller5<I, O> extends ActivityResultLauncher<Unit> {
    private final ActivityResultContract<I, O> callerContract;
    private final I input;
    private final ActivityResultLauncher<I> launcher;

    /* renamed from: resultContract$delegate, reason: from kotlin metadata */
    private final Lazy resultContract;

    public ActivityResultCaller5(ActivityResultLauncher<I> activityResultLauncher, ActivityResultContract<I, O> activityResultContract, I i) {
        Intrinsics3.checkNotNullParameter(activityResultLauncher, "launcher");
        Intrinsics3.checkNotNullParameter(activityResultContract, "callerContract");
        this.launcher = activityResultLauncher;
        this.callerContract = activityResultContract;
        this.input = i;
        this.resultContract = LazyJVM.lazy(new ActivityResultCaller6(this));
    }

    public final ActivityResultContract<I, O> getCallerContract() {
        return this.callerContract;
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public ActivityResultContract<Unit, ?> getContract() {
        return getResultContract();
    }

    public final I getInput() {
        return this.input;
    }

    public final ActivityResultLauncher<I> getLauncher() {
        return this.launcher;
    }

    public final ActivityResultContract<Unit, O> getResultContract() {
        return (ActivityResultContract) this.resultContract.getValue();
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public /* bridge */ /* synthetic */ void launch(Unit unit, ActivityOptionsCompat activityOptionsCompat) {
        launch2(unit, activityOptionsCompat);
    }

    @Override // androidx.activity.result.ActivityResultLauncher
    public void unregister() {
        this.launcher.unregister();
    }

    /* renamed from: launch, reason: avoid collision after fix types in other method */
    public void launch2(Unit unit, ActivityOptionsCompat options) {
        this.launcher.launch(this.input, options);
    }
}
