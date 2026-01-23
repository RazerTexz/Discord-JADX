package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.discord.app.AppFragment;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.error.Error;
import com.discord.widgets.captcha.WidgetCaptcha;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppScreen2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: WidgetAuthCaptcha.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthCaptcha extends WidgetCaptcha {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_CAPTCHA_ERROR_BODY = "EXTRA_CAPTCHA_ERROR_BODY";
    private static final String RESULT_EXTRA_RQTOKEN = "RESULT_EXTRA_RQTOKEN";
    private static final String RESULT_EXTRA_TOKEN = "RESULT_EXTRA_TOKEN";

    /* JADX INFO: compiled from: WidgetAuthCaptcha.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, CaptchaErrorBody captchaErrorBody) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intent intent = new Intent();
            intent.putExtra(WidgetAuthCaptcha.EXTRA_CAPTCHA_ERROR_BODY, captchaErrorBody);
            AppScreen2.f524g.m160f(context, launcher, WidgetAuthCaptcha.class, intent);
        }

        public final void processErrorsForCaptcha(Context context, ActivityResultLauncher<Intent> launcher, List<String> unhandledErrors, Error error) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intrinsics3.checkNotNullParameter(unhandledErrors, "unhandledErrors");
            Intrinsics3.checkNotNullParameter(error, "error");
            if (unhandledErrors.remove(CaptchaHelper.CAPTCHA_KEY)) {
                launch(context, launcher, CaptchaErrorBody.INSTANCE.createFromError(error));
                error.setShowErrorToasts(false);
            }
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function1<? super CaptchaHelper.CaptchaPayload, Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetAuthCaptcha2(callback));
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.discord.widgets.captcha.WidgetCaptcha
    public void trackTransition(String action, List<String> details) {
        Intrinsics3.checkNotNullParameter(action, "action");
        RegistrationFlowRepo.INSTANCE.getINSTANCE().trackTransition("Captcha", action, details);
    }
}
