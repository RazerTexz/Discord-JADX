package com.discord.widgets.captcha;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment2;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetCaptchaBottomSheetBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.captcha.CaptchaService;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.share.WidgetIncomingShare;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p513e0.KClass;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetCaptchaBottomSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetCaptchaBottomSheet extends AppBottomSheet {
    private static final String ARG_REQUEST_KEY = "INTENT_EXTRA_REQUEST_CODE";
    private static final String NOTICE_NAME = "captcha notice";
    private static final String RESULT_EXTRA_CAPTCHA_RQTOKEN = "INTENT_EXTRA_CAPTCHA_RQTOKEN";
    private static final String RESULT_EXTRA_CAPTCHA_TOKEN = "INTENT_EXTRA_CAPTCHA_TOKEN";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: captchaErrorBody$delegate, reason: from kotlin metadata */
    private final Lazy captchaErrorBody;
    private boolean captchaPassed;
    private Function0<Unit> onCaptchaAttemptFailed;

    /* renamed from: requestCode$delegate, reason: from kotlin metadata */
    private final Lazy requestCode;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetCaptchaBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCaptchaBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<KClass<? extends AppFragment>> resolvableFragments = Collections2.listOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(WidgetTabsHost.class), Reflection2.getOrCreateKotlinClass(WidgetIncomingShare.class)});

    /* compiled from: WidgetCaptchaBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void enqueue$default(Companion companion, String str, Function2 function2, Function0 function0, CaptchaErrorBody captchaErrorBody, int i, Object obj) {
            if ((i & 4) != 0) {
                function0 = null;
            }
            companion.enqueue(str, function2, function0, captchaErrorBody);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, String str, CaptchaErrorBody captchaErrorBody, Function0 function0, int i, Object obj) {
            if ((i & 8) != 0) {
                function0 = null;
            }
            companion.show(fragmentManager, str, captchaErrorBody, function0);
        }

        public final void enqueue(String requestKey, Function2<? super AppFragment, ? super CaptchaHelper.CaptchaPayload, Unit> onCaptchaPayloadReceived, Function0<Unit> onCaptchaAttemptFailed, CaptchaErrorBody error) {
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics3.checkNotNullParameter(onCaptchaPayloadReceived, "onCaptchaPayloadReceived");
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(WidgetCaptchaBottomSheet.NOTICE_NAME, null, 0L, 0, false, WidgetCaptchaBottomSheet.access$getResolvableFragments$cp(), 0L, false, 0L, new WidgetCaptchaBottomSheet2(requestKey, error, onCaptchaAttemptFailed, onCaptchaPayloadReceived), 150, null));
        }

        public final void registerForResult(AppFragment fragment, String requestKey, Function2<? super AppFragment, ? super CaptchaHelper.CaptchaPayload, Unit> onCaptchaPayloadReceived) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics3.checkNotNullParameter(onCaptchaPayloadReceived, "onCaptchaPayloadReceived");
            Fragment2.setFragmentResultListener(fragment, requestKey, new WidgetCaptchaBottomSheet3(requestKey, onCaptchaPayloadReceived, fragment));
        }

        public final void show(FragmentManager fragmentManager, String requestKey, CaptchaErrorBody error, Function0<Unit> onCaptchaAttemptFailed) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            WidgetCaptchaBottomSheet widgetCaptchaBottomSheet = new WidgetCaptchaBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putSerializable("INTENT_EXTRA_CAPTCHA_ERROR_BODY", error);
            bundle.putString(WidgetCaptchaBottomSheet.ARG_REQUEST_KEY, requestKey);
            widgetCaptchaBottomSheet.setArguments(bundle);
            WidgetCaptchaBottomSheet.access$setOnCaptchaAttemptFailed$p(widgetCaptchaBottomSheet, onCaptchaAttemptFailed);
            widgetCaptchaBottomSheet.show(fragmentManager, WidgetCaptchaBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetCaptchaBottomSheet.kt */
    /* renamed from: com.discord.widgets.captcha.WidgetCaptchaBottomSheet$configureUI$1 */
    public static final class ViewOnClickListenerC73021 implements View.OnClickListener {
        public ViewOnClickListenerC73021() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetCaptchaBottomSheet.access$openCaptcha(WidgetCaptchaBottomSheet.this);
        }
    }

    /* compiled from: WidgetCaptchaBottomSheet.kt */
    /* renamed from: com.discord.widgets.captcha.WidgetCaptchaBottomSheet$openCaptcha$1 */
    public static final class C73031 extends Lambda implements Function1<String, Unit> {
        public C73031() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            CaptchaHelper.INSTANCE.setCaptchaToken(str);
            WidgetCaptchaBottomSheet.access$setCaptchaPassed$p(WidgetCaptchaBottomSheet.this, true);
            AppActivity appActivity = WidgetCaptchaBottomSheet.this.getAppActivity();
            if (appActivity != null) {
                WidgetCaptchaBottomSheet.access$finishIfCaptchaTokenReceived(WidgetCaptchaBottomSheet.this, appActivity);
            }
        }
    }

    /* compiled from: WidgetCaptchaBottomSheet.kt */
    /* renamed from: com.discord.widgets.captcha.WidgetCaptchaBottomSheet$openCaptcha$2 */
    public static final class C73042 extends Lambda implements Function1<Error, Unit> {
        public C73042() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            Throwable throwable = error.getThrowable();
            if (!(throwable instanceof CaptchaHelper.Failure)) {
                throwable = null;
            }
            CaptchaHelper.Failure failure = (CaptchaHelper.Failure) throwable;
            if (failure != null) {
                AppToast.m169g(WidgetCaptchaBottomSheet.this.getAppActivity(), failure.getErrorStringId(), 0, null, 12);
            }
        }
    }

    public WidgetCaptchaBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetCaptchaBottomSheet4.INSTANCE, null, 2, null);
        this.requestCode = LazyJVM.lazy(new WidgetCaptchaBottomSheet6(this));
        this.captchaErrorBody = LazyJVM.lazy(new WidgetCaptchaBottomSheet5(this));
    }

    public static final /* synthetic */ void access$finishIfCaptchaTokenReceived(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet, Activity activity) {
        widgetCaptchaBottomSheet.finishIfCaptchaTokenReceived(activity);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet) {
        return widgetCaptchaBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ boolean access$getCaptchaPassed$p(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet) {
        return widgetCaptchaBottomSheet.captchaPassed;
    }

    public static final /* synthetic */ Function0 access$getOnCaptchaAttemptFailed$p(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet) {
        return widgetCaptchaBottomSheet.onCaptchaAttemptFailed;
    }

    public static final /* synthetic */ List access$getResolvableFragments$cp() {
        return resolvableFragments;
    }

    public static final /* synthetic */ void access$openCaptcha(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet) {
        widgetCaptchaBottomSheet.openCaptcha();
    }

    public static final /* synthetic */ void access$setCaptchaPassed$p(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet, boolean z2) {
        widgetCaptchaBottomSheet.captchaPassed = z2;
    }

    public static final /* synthetic */ void access$setOnCaptchaAttemptFailed$p(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet, Function0 function0) {
        widgetCaptchaBottomSheet.onCaptchaAttemptFailed = function0;
    }

    private final void configureUI() {
        TextView textView = getBinding().f15802d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.captchaTitle");
        FormatUtils.m222n(textView, C5419R.string.generic_captcha_header, new Object[0], null, 4);
        TextView textView2 = getBinding().f15800b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.captchaBody");
        FormatUtils.m222n(textView2, C5419R.string.generic_captcha_description, new Object[0], null, 4);
        MaterialButton materialButton = getBinding().f15801c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.captchaButton");
        FormatUtils.m222n(materialButton, C5419R.string.confirm, new Object[0], null, 4);
        getBinding().f15801c.setOnClickListener(new ViewOnClickListenerC73021());
    }

    private final void finishIfCaptchaTokenReceived(Activity activity) {
        CaptchaHelper captchaHelper = CaptchaHelper.INSTANCE;
        String captchaToken = captchaHelper.getCaptchaToken();
        if (captchaToken != null) {
            String captchaRqtoken = captchaHelper.getCaptchaRqtoken();
            captchaHelper.setCaptchaToken(null);
            captchaHelper.setCaptchaRqtoken(null);
            String requestCode = getRequestCode();
            Bundle bundle = new Bundle();
            bundle.putString(RESULT_EXTRA_CAPTCHA_TOKEN, captchaToken);
            bundle.putString(RESULT_EXTRA_CAPTCHA_RQTOKEN, captchaRqtoken);
            Fragment2.setFragmentResult(this, requestCode, bundle);
            dismiss();
        }
    }

    private final WidgetCaptchaBottomSheetBinding getBinding() {
        return (WidgetCaptchaBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CaptchaErrorBody getCaptchaErrorBody() {
        return (CaptchaErrorBody) this.captchaErrorBody.getValue();
    }

    private final String getRequestCode() {
        return (String) this.requestCode.getValue();
    }

    private final void openCaptcha() {
        CaptchaHelper.CaptchaRequest reCaptcha;
        String captchaSitekey = getCaptchaErrorBody().getCaptchaSitekey();
        CaptchaService captchaService = getCaptchaErrorBody().getCaptchaService();
        String captchaRqdata = getCaptchaErrorBody().getCaptchaRqdata();
        String captchaRqtoken = getCaptchaErrorBody().getCaptchaRqtoken();
        CaptchaHelper captchaHelper = CaptchaHelper.INSTANCE;
        captchaHelper.setCaptchaRqtoken(captchaRqtoken);
        if (captchaSitekey == null || captchaService != CaptchaService.HCAPTCHA) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            reCaptcha = new CaptchaHelper.CaptchaRequest.ReCaptcha(fragmentActivityRequireActivity);
        } else {
            FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
            reCaptcha = new CaptchaHelper.CaptchaRequest.HCaptcha(captchaSitekey, fragmentActivityRequireActivity2, captchaRqdata);
        }
        ObservableExtensionsKt.appSubscribe$default(captchaHelper.tryShowCaptcha(reCaptcha), WidgetCaptchaBottomSheet.class, (Context) null, (Function1) null, new C73042(), (Function0) null, (Function0) null, new C73031(), 54, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_captcha_bottom_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Function0<Unit> function0;
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.captchaPassed || (function0 = this.onCaptchaAttemptFailed) == null) {
            return;
        }
        function0.invoke();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        configureUI();
    }
}
