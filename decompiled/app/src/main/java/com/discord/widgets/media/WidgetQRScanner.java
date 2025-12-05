package com.discord.widgets.media;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.webkit.URLUtil;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetQrScannerBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.auth.WidgetRemoteAuth;
import com.google.android.material.chip.Chip;
import com.google.zxing.Result;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.p019m0.RoutingPatterns;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p596e0.p597a.p598a.p599a.CameraHandlerThread;
import p596e0.p597a.p598a.p599a.CameraHandlerThread2;

/* compiled from: WidgetQRScanner.kt */
/* loaded from: classes2.dex */
public final class WidgetQRScanner extends AppFragment implements ZXingScannerView.InterfaceC12927b {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetQRScanner.class, "binding", "getBinding()Lcom/discord/databinding/WidgetQrScannerBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_SHOW_HELP_CHIP = "SHOW_HELP_CHIP";
    private static final int MAIN_BACK_CAMERA = 0;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetQRScanner.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            companion.launch(context, z2);
        }

        public final void launch(Context context, boolean showHelpChip) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent("android.intent.action.VIEW").putExtra(WidgetQRScanner.EXTRA_SHOW_HELP_CHIP, showHelpChip);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent(Intent.ACTION_VIE…_HELP_CHIP, showHelpChip)");
            AppScreen2.m156d(context, WidgetQRScanner.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetQRScanner.kt */
    /* renamed from: com.discord.widgets.media.WidgetQRScanner$onViewBoundOrOnResume$1 */
    public static final class C90681 extends Lambda implements Function0<Unit> {
        public C90681() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ZXingScannerView zXingScannerView = WidgetQRScanner.access$getBinding$p(WidgetQRScanner.this).f17396b;
            if (zXingScannerView.f25303n == null) {
                zXingScannerView.f25303n = new CameraHandlerThread2(zXingScannerView);
            }
            CameraHandlerThread2 cameraHandlerThread2 = zXingScannerView.f25303n;
            Objects.requireNonNull(cameraHandlerThread2);
            new Handler(cameraHandlerThread2.getLooper()).post(new CameraHandlerThread(cameraHandlerThread2, 0));
        }
    }

    /* compiled from: WidgetQRScanner.kt */
    /* renamed from: com.discord.widgets.media.WidgetQRScanner$onViewBoundOrOnResume$2 */
    public static final class C90692 extends Lambda implements Function0<Unit> {
        public C90692() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AppActivity appActivity = WidgetQRScanner.this.getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }
    }

    public WidgetQRScanner() {
        super(C5419R.layout.widget_qr_scanner);
        this.binding = FragmentViewBindingDelegate3.viewBinding(this, WidgetQRScanner2.INSTANCE, new WidgetQRScanner3(this));
    }

    public static final /* synthetic */ WidgetQrScannerBinding access$getBinding$p(WidgetQRScanner widgetQRScanner) {
        return widgetQRScanner.getBinding();
    }

    public static final /* synthetic */ void access$onViewBindingDestroy(WidgetQRScanner widgetQRScanner, WidgetQrScannerBinding widgetQrScannerBinding) {
        widgetQRScanner.onViewBindingDestroy(widgetQrScannerBinding);
    }

    private final WidgetQrScannerBinding getBinding() {
        return (WidgetQrScannerBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onViewBindingDestroy(WidgetQrScannerBinding binding) {
        binding.f17396b.m10094a();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // me.dm7.barcodescanner.zxing.ZXingScannerView.InterfaceC12927b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleResult(Result rawResult) {
        String str;
        MatchResult matchResultMatchEntire;
        if (rawResult == null || (str = rawResult.f21668a) == null) {
            return;
        }
        Uri uri = Uri.parse(str);
        if (URLUtil.isValidUrl(str)) {
            RoutingPatterns routingPatterns = RoutingPatterns.f538G;
            Intrinsics3.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            if (!routingPatterns.m173a(uri.getHost())) {
                IntentUtils intentUtils = IntentUtils.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
                if (intentUtils.isDiscordAppUri(uri)) {
                    String path = uri.getPath();
                    if (path != null) {
                        RoutingPatterns routingPatterns2 = RoutingPatterns.f538G;
                        Regex regex = RoutingPatterns.f535D;
                        Intrinsics3.checkNotNullExpressionValue(path, "it");
                        matchResultMatchEntire = regex.matchEntire(path);
                    } else {
                        matchResultMatchEntire = null;
                    }
                    if (matchResultMatchEntire != null) {
                        WidgetRemoteAuth.INSTANCE.launch(requireContext(), (String) _Collections.last((List) matchResultMatchEntire.getGroupValues()));
                    } else {
                        UriHandler.handle$default(UriHandler.INSTANCE, requireContext(), str, false, false, null, 28, null);
                    }
                } else {
                    AppToast.m171i(this, C5419R.string.qr_code_invalid, 0, 4);
                }
            }
        }
        requireActivity().finish();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getBinding().f17396b.m10094a();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f17396b.setFormats(ZXingScannerView.f27495D);
        getBinding().f17396b.setResultHandler(this);
        ZXingScannerView zXingScannerView = getBinding().f17396b;
        Intrinsics3.checkNotNullExpressionValue(zXingScannerView, "binding.qrScanner");
        zXingScannerView.setVisibility(0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ColorCompat.setStatusBarColor$default((Fragment) this, ColorCompat.getColor(this, C5419R.color.black), false, 4, (Object) null);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.login_with_qr);
        boolean booleanExtra = getMostRecentIntent().getBooleanExtra(EXTRA_SHOW_HELP_CHIP, false);
        Chip chip = getBinding().f17397c;
        Intrinsics3.checkNotNullExpressionValue(chip, "binding.qrScannerChip");
        chip.setVisibility(booleanExtra ? 0 : 8);
        requestCameraQRScanner(new C90681(), new C90692());
    }
}
