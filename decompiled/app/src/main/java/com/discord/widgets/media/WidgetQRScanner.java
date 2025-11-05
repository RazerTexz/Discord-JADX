package com.discord.widgets.media;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.view.View;
import android.webkit.URLUtil;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetQrScannerBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.auth.WidgetRemoteAuth;
import com.google.android.material.chip.Chip;
import com.google.zxing.Result;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import e0.a.a.a.b;
import e0.a.a.a.c;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/* compiled from: WidgetQRScanner.kt */
/* loaded from: classes2.dex */
public final class WidgetQRScanner extends AppFragment implements ZXingScannerView.b {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetQRScanner.class, "binding", "getBinding()Lcom/discord/databinding/WidgetQrScannerBinding;", 0)};

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
            m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent("android.intent.action.VIEW").putExtra(WidgetQRScanner.EXTRA_SHOW_HELP_CHIP, showHelpChip);
            m.checkNotNullExpressionValue(intentPutExtra, "Intent(Intent.ACTION_VIE…_HELP_CHIP, showHelpChip)");
            j.d(context, WidgetQRScanner.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetQRScanner.kt */
    /* renamed from: com.discord.widgets.media.WidgetQRScanner$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ZXingScannerView zXingScannerView = WidgetQRScanner.access$getBinding$p(WidgetQRScanner.this).f2515b;
            if (zXingScannerView.n == null) {
                zXingScannerView.n = new c(zXingScannerView);
            }
            c cVar = zXingScannerView.n;
            Objects.requireNonNull(cVar);
            new Handler(cVar.getLooper()).post(new b(cVar, 0));
        }
    }

    /* compiled from: WidgetQRScanner.kt */
    /* renamed from: com.discord.widgets.media.WidgetQRScanner$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
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
        super(R.layout.widget_qr_scanner);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetQRScanner$binding$2.INSTANCE, new WidgetQRScanner$binding$3(this));
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
        binding.f2515b.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // me.dm7.barcodescanner.zxing.ZXingScannerView.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleResult(Result rawResult) {
        String str;
        MatchResult matchResultMatchEntire;
        if (rawResult == null || (str = rawResult.a) == null) {
            return;
        }
        Uri uri = Uri.parse(str);
        if (URLUtil.isValidUrl(str)) {
            b.a.d.m0.a aVar = b.a.d.m0.a.G;
            m.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
            if (!aVar.a(uri.getHost())) {
                IntentUtils intentUtils = IntentUtils.INSTANCE;
                m.checkNotNullExpressionValue(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
                if (intentUtils.isDiscordAppUri(uri)) {
                    String path = uri.getPath();
                    if (path != null) {
                        b.a.d.m0.a aVar2 = b.a.d.m0.a.G;
                        Regex regex = b.a.d.m0.a.D;
                        m.checkNotNullExpressionValue(path, "it");
                        matchResultMatchEntire = regex.matchEntire(path);
                    } else {
                        matchResultMatchEntire = null;
                    }
                    if (matchResultMatchEntire != null) {
                        WidgetRemoteAuth.INSTANCE.launch(requireContext(), (String) u.last((List) matchResultMatchEntire.getGroupValues()));
                    } else {
                        UriHandler.handle$default(UriHandler.INSTANCE, requireContext(), str, false, false, null, 28, null);
                    }
                } else {
                    b.a.d.m.i(this, R.string.qr_code_invalid, 0, 4);
                }
            }
        }
        requireActivity().finish();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        getBinding().f2515b.a();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f2515b.setFormats(ZXingScannerView.D);
        getBinding().f2515b.setResultHandler(this);
        ZXingScannerView zXingScannerView = getBinding().f2515b;
        m.checkNotNullExpressionValue(zXingScannerView, "binding.qrScanner");
        zXingScannerView.setVisibility(0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ColorCompat.setStatusBarColor$default((Fragment) this, ColorCompat.getColor(this, R.color.black), false, 4, (Object) null);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.login_with_qr);
        boolean booleanExtra = getMostRecentIntent().getBooleanExtra(EXTRA_SHOW_HELP_CHIP, false);
        Chip chip = getBinding().c;
        m.checkNotNullExpressionValue(chip, "binding.qrScannerChip");
        chip.setVisibility(booleanExtra ? 0 : 8);
        requestCameraQRScanner(new AnonymousClass1(), new AnonymousClass2());
    }
}
