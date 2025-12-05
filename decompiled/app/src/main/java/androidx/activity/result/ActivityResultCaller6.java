package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: ActivityResultCaller.kt */
/* renamed from: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2, reason: use source file name */
/* loaded from: classes.dex */
public final class ActivityResultCaller6 extends Lambda implements Function0<C00451> {
    public final /* synthetic */ ActivityResultCaller5 this$0;

    /* JADX INFO: Add missing generic type declarations: [O] */
    /* compiled from: ActivityResultCaller.kt */
    /* renamed from: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1 */
    public static final class C00451<O> extends ActivityResultContract<Unit, O> {
        public C00451() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context context, Unit unit) {
            return createIntent2(context, unit);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public O parseResult(int resultCode, Intent intent) {
            return (O) ActivityResultCaller6.this.this$0.getCallerContract().parseResult(resultCode, intent);
        }

        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context context, Unit unit) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentCreateIntent = ActivityResultCaller6.this.this$0.getCallerContract().createIntent(context, ActivityResultCaller6.this.this$0.getInput());
            Intrinsics3.checkNotNullExpressionValue(intentCreateIntent, "callerContract.createIntent(context, input)");
            return intentCreateIntent;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityResultCaller6(ActivityResultCaller5 activityResultCaller5) {
        super(0);
        this.this$0 = activityResultCaller5;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ C00451 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final C00451 invoke() {
        return new C00451();
    }
}
