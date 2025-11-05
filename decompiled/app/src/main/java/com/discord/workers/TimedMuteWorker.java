package com.discord.workers;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreStream;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.io.NetworkUtils;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.m;
import j0.m.a;
import java.util.Objects;
import rx.Observable;

/* compiled from: TimedMuteWorker.kt */
/* loaded from: classes.dex */
public final class TimedMuteWorker extends Worker {

    /* renamed from: a, reason: from kotlin metadata */
    public Clock clock;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimedMuteWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(workerParameters, "params");
        this.clock = ClockFactory.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01ae  */
    @Override // androidx.work.Worker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ListenableWorker.Result doWork() {
        String str;
        long j;
        long j2;
        AppLog appLog = AppLog.g;
        String simpleName = TimedMuteWorker.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        StringBuilder sb = new StringBuilder();
        sb.append("Starting for [");
        Data inputData = getInputData();
        m.checkNotNullExpressionValue(inputData, "inputData");
        sb.append(inputData.getKeyValueMap());
        sb.append(']');
        Logger.i$default(appLog, simpleName, sb.toString(), null, 4, null);
        NotificationClient notificationClient = NotificationClient.INSTANCE;
        if (!notificationClient.isAuthed()) {
            String simpleName2 = TimedMuteWorker.class.getSimpleName();
            m.checkNotNullExpressionValue(simpleName2, "javaClass.simpleName");
            Logger.d$default(appLog, simpleName2, "Not authenticated. Aborting job request.", null, 4, null);
            ListenableWorker.Result resultFailure = ListenableWorker.Result.failure();
            m.checkNotNullExpressionValue(resultFailure, "Result.failure()");
            return resultFailure;
        }
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        Context applicationContext = getApplicationContext();
        m.checkNotNullExpressionValue(applicationContext, "applicationContext");
        if (!NetworkUtils.isDeviceConnected$default(networkUtils, applicationContext, null, null, 6, null)) {
            ListenableWorker.Result resultRetry = ListenableWorker.Result.retry();
            m.checkNotNullExpressionValue(resultRetry, "Result.retry()");
            return resultRetry;
        }
        long j3 = getInputData().getLong("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
        long j4 = getInputData().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
        long j5 = getInputData().getLong("com.discord.intent.extra.EXTRA_UNTIL_TIMESTAMP_MS", 0L);
        if (j3 == -1 || j4 == -1) {
            ListenableWorker.Result resultFailure2 = ListenableWorker.Result.failure();
            m.checkNotNullExpressionValue(resultFailure2, "Result.failure()");
            return resultFailure2;
        }
        if (this.clock.currentTimeMillis() > j5) {
            ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
            m.checkNotNullExpressionValue(resultSuccess, "Result.success()");
            return resultSuccess;
        }
        String uTCDateTime$default = TimeUtils.toUTCDateTime$default(Long.valueOf(j5), null, 2, null);
        try {
            Observable<ModelNotificationSettings> observableUpdateUserGuildSettings = RestAPI.INSTANCE.getApi().updateUserGuildSettings(j3, new RestAPIParams.UserGuildSettings(j4, new RestAPIParams.UserGuildSettings.ChannelOverride(Boolean.TRUE, new ModelMuteConfig(uTCDateTime$default), null, null, 12, null)));
            Objects.requireNonNull(observableUpdateUserGuildSettings);
            ModelNotificationSettings modelNotificationSettings = (ModelNotificationSettings) new a(observableUpdateUserGuildSettings).b();
            String simpleName3 = getClass().getSimpleName();
            m.checkNotNullExpressionValue(simpleName3, "javaClass.simpleName");
            str = uTCDateTime$default;
            try {
                Logger.d$default(appLog, simpleName3, "Muted: " + j3 + '-' + j4 + " until " + uTCDateTime$default, null, 4, null);
                j = j4;
                j2 = j3;
                try {
                    NotificationClient.clear$default(notificationClient, j, getApplicationContext(), false, 4, null);
                    StoreAnalytics analytics = StoreStream.INSTANCE.getAnalytics();
                    m.checkNotNullExpressionValue(modelNotificationSettings, "notifSettings");
                    analytics.onNotificationSettingsUpdated(modelNotificationSettings, Long.valueOf(j));
                    ListenableWorker.Result resultSuccess2 = ListenableWorker.Result.success();
                    m.checkNotNullExpressionValue(resultSuccess2, "Result.success()");
                    return resultSuccess2;
                } catch (Throwable th) {
                    th = th;
                    AppLog appLog2 = AppLog.g;
                    String simpleName4 = TimedMuteWorker.class.getSimpleName();
                    m.checkNotNullExpressionValue(simpleName4, "javaClass.simpleName");
                    appLog2.w(simpleName4, "Mute failure: " + j2 + '-' + j + " until " + str, th);
                    ListenableWorker.Result resultRetry2 = getRunAttemptCount() >= 3 ? ListenableWorker.Result.retry() : ListenableWorker.Result.failure();
                    m.checkNotNullExpressionValue(resultRetry2, "if (runAttemptCount < MA…y() else Result.failure()");
                    return resultRetry2;
                }
            } catch (Throwable th2) {
                th = th2;
                j = j4;
                j2 = j3;
                AppLog appLog22 = AppLog.g;
                String simpleName42 = TimedMuteWorker.class.getSimpleName();
                m.checkNotNullExpressionValue(simpleName42, "javaClass.simpleName");
                appLog22.w(simpleName42, "Mute failure: " + j2 + '-' + j + " until " + str, th);
                if (getRunAttemptCount() >= 3) {
                }
                m.checkNotNullExpressionValue(resultRetry2, "if (runAttemptCount < MA…y() else Result.failure()");
                return resultRetry2;
            }
        } catch (Throwable th3) {
            th = th3;
            str = uTCDateTime$default;
        }
    }
}
