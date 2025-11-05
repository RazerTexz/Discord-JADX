package com.discord.workers;

import android.app.Application;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import j0.k.b;

/* compiled from: BackgroundMessageSendWorker.kt */
/* loaded from: classes.dex */
public final class BackgroundMessageSendWorker extends Worker {

    /* compiled from: BackgroundMessageSendWorker.kt */
    public static final class a<T, R> implements b<Boolean, Boolean> {
        public static final a j = new a();

        @Override // j0.k.b
        public Boolean call(Boolean bool) {
            return Boolean.valueOf(m.areEqual(bool, Boolean.TRUE));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundMessageSendWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(workerParameters, "params");
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
            m.checkNotNullExpressionValue(resultFailure, "Result.failure()");
            return resultFailure;
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.initialize(application);
        new j0.m.a(companion.getMessages().observeInitResendFinished().y(a.j).Z(1)).b();
        ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
        m.checkNotNullExpressionValue(resultSuccess, "Result.success()");
        return resultSuccess;
    }
}
