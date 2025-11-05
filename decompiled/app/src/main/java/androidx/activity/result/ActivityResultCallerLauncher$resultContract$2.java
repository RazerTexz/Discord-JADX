package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: ActivityResultCaller.kt */
/* loaded from: classes.dex */
public final class ActivityResultCallerLauncher$resultContract$2 extends o implements Function0<AnonymousClass1> {
    public final /* synthetic */ ActivityResultCallerLauncher this$0;

    /* JADX INFO: Add missing generic type declarations: [O] */
    /* compiled from: ActivityResultCaller.kt */
    /* renamed from: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1, reason: invalid class name */
    public static final class AnonymousClass1<O> extends ActivityResultContract<Unit, O> {
        public AnonymousClass1() {
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public /* bridge */ /* synthetic */ Intent createIntent(Context context, Unit unit) {
            return createIntent2(context, unit);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public O parseResult(int resultCode, Intent intent) {
            return (O) ActivityResultCallerLauncher$resultContract$2.this.this$0.getCallerContract().parseResult(resultCode, intent);
        }

        /* renamed from: createIntent, reason: avoid collision after fix types in other method */
        public Intent createIntent2(Context context, Unit unit) {
            m.checkNotNullParameter(context, "context");
            Intent intentCreateIntent = ActivityResultCallerLauncher$resultContract$2.this.this$0.getCallerContract().createIntent(context, ActivityResultCallerLauncher$resultContract$2.this.this$0.getInput());
            m.checkNotNullExpressionValue(intentCreateIntent, "callerContract.createIntent(context, input)");
            return intentCreateIntent;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityResultCallerLauncher$resultContract$2(ActivityResultCallerLauncher activityResultCallerLauncher) {
        super(0);
        this.this$0 = activityResultCallerLauncher;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnonymousClass1 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnonymousClass1 invoke() {
        return new AnonymousClass1();
    }
}
