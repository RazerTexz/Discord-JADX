package com.discord.workers;

import android.app.Application;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.discord.stores.StoreStream;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p650m.BlockingObservable;

/* compiled from: BackgroundMessageSendWorker.kt */
/* loaded from: classes.dex */
public final class BackgroundMessageSendWorker extends Worker {

    /* compiled from: BackgroundMessageSendWorker.kt */
    /* renamed from: com.discord.workers.BackgroundMessageSendWorker$a */
    public static final class C10617a<T, R> implements Func1<Boolean, Boolean> {

        /* renamed from: j */
        public static final C10617a f19414j = new C10617a();

        @Override // p637j0.p641k.Func1
        public Boolean call(Boolean bool) {
            return Boolean.valueOf(Intrinsics3.areEqual(bool, Boolean.TRUE));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundMessageSendWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(workerParameters, "params");
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        Context applicationContext = getApplicationContext();
        if (!(applicationContext instanceof Application)) {
            applicationContext = null;
        }
        Application application = (Application) applicationContext;
        if (application == null) {
            ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
            Intrinsics3.checkNotNullExpressionValue(resultFailure, "Result.failure()");
            return resultFailure;
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.initialize(application);
        new BlockingObservable(companion.getMessages().observeInitResendFinished().m11118y(C10617a.f19414j).m11100Z(1)).m10860b();
        ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
        Intrinsics3.checkNotNullExpressionValue(resultSuccess, "Result.success()");
        return resultSuccess;
    }
}
