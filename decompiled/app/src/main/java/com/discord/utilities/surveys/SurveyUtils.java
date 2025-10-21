package com.discord.utilities.surveys;

import android.app.Application;
import android.content.pm.PackageManager;
import androidx.core.app.NotificationCompat;
import com.discord.api.user.UserSurvey;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import rx.Observable;

/* compiled from: SurveyUtils.kt */
/* loaded from: classes2.dex */
public final class SurveyUtils {
    public static final SurveyUtils INSTANCE = new SurveyUtils();
    private static final long MIN_APP_INSTALL_TIME = 604800000;
    private static Application applicationContext;

    /* compiled from: SurveyUtils.kt */
    public static class Survey {
        private final String noticeKey;
        private final String surveyBody;
        private final String surveyId;
        private final String surveyTitle;
        private final String surveyURL;

        /* compiled from: SurveyUtils.kt */
        public static final class None extends Survey {
            public static final None INSTANCE = new None();

            private None() {
                super("", "", "", "", "");
            }
        }

        public Survey(String str, String str2, String str3, String str4, String str5) {
            Intrinsics3.checkNotNullParameter(str, "surveyId");
            Intrinsics3.checkNotNullParameter(str2, "surveyURL");
            Intrinsics3.checkNotNullParameter(str3, "noticeKey");
            Intrinsics3.checkNotNullParameter(str4, "surveyBody");
            Intrinsics3.checkNotNullParameter(str5, "surveyTitle");
            this.surveyId = str;
            this.surveyURL = str2;
            this.noticeKey = str3;
            this.surveyBody = str4;
            this.surveyTitle = str5;
        }

        public String getNoticeKey() {
            return this.noticeKey;
        }

        public String getSurveyBody() {
            return this.surveyBody;
        }

        public String getSurveyId() {
            return this.surveyId;
        }

        public String getSurveyTitle() {
            return this.surveyTitle;
        }

        public String getSurveyURL() {
            return this.surveyURL;
        }
    }

    /* compiled from: SurveyUtils.kt */
    /* renamed from: com.discord.utilities.surveys.SurveyUtils$getSurveyToShow$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<UserSurvey, Survey> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Survey call(UserSurvey userSurvey) {
            return call2(userSurvey);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Survey call2(UserSurvey userSurvey) {
            if (userSurvey != null) {
                return new Survey(userSurvey.getKey(), userSurvey.getUrl(), userSurvey.getKey(), userSurvey.getPrompt(), userSurvey.getCta());
            }
            return null;
        }
    }

    private SurveyUtils() {
    }

    private final boolean isInstallOldEnough() {
        try {
            Application application = applicationContext;
            if (application == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("applicationContext");
            }
            PackageManager packageManager = application.getPackageManager();
            Application application2 = applicationContext;
            if (application2 == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("applicationContext");
            }
            return ClockFactory.get().currentTimeMillis() - packageManager.getPackageInfo(application2.getPackageName(), 0).firstInstallTime >= MIN_APP_INSTALL_TIME;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final Observable<Survey> getSurveyToShow() {
        if (isInstallOldEnough()) {
            Observable observableG = StoreStream.INSTANCE.getUserSurvey().observeUserSurvey().G(AnonymousClass1.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream\n        .get…  )\n          }\n        }");
            return observableG;
        }
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(Survey.None.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(Survey.None)");
        return scalarSynchronousObservable;
    }

    public final void init(Application applicationContext2) {
        Intrinsics3.checkNotNullParameter(applicationContext2, "applicationContext");
        applicationContext = applicationContext2;
    }
}
