package com.discord.widgets.debugging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.discord.BuildConfig;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetFatalCrashBinding;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetFatalCrash.kt */
/* loaded from: classes2.dex */
public final class WidgetFatalCrash extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetFatalCrash.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFatalCrashBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CRASH_SOURCE = "INTENT_EXTRA_CRASH_SOURCE";
    private static final String INTENT_EXTRA_CRASH_TIME = "INTENT_EXTRA_CRASH_TIME";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* compiled from: WidgetFatalCrash.kt */
    public static final class Companion {
        private Companion() {
        }

        @SuppressLint({"SimpleDateFormat"})
        private final Intent createIntent(String source) {
            Bundle bundle = new Bundle();
            bundle.putString(WidgetFatalCrash.INTENT_EXTRA_CRASH_SOURCE, source);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            bundle.putString(WidgetFatalCrash.INTENT_EXTRA_CRASH_TIME, simpleDateFormat.format(new Date()) + " GMT");
            Intent intentPutExtras = new Intent().putExtras(bundle);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtras, "Intent().putExtras(extras)");
            return intentPutExtras;
        }

        public final void launch(Context context, Throwable throwable, String crashSource) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(throwable, "throwable");
            Intrinsics3.checkNotNullParameter(crashSource, "crashSource");
            AppLog appLog = AppLog.f14950g;
            String simpleName = WidgetFatalCrash.class.getSimpleName();
            Intrinsics3.checkNotNullExpressionValue(simpleName, "WidgetFatalCrash::class.java.simpleName");
            Logger.e$default(appLog, simpleName, new Throwable(crashSource, throwable), null, 4, null);
            AppScreen2.m156d(context, WidgetFatalCrash.class, createIntent(crashSource));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetFatalCrash() {
        super(C5419R.layout.widget_fatal_crash);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetFatalCrash2.INSTANCE, null, 2, null);
    }

    private final WidgetFatalCrashBinding getBinding() {
        return (WidgetFatalCrashBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context, Throwable th, String str) {
        INSTANCE.launch(context, th, str);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        LinkifiedTextView linkifiedTextView = getBinding().f16621f;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.fatalCrashTestersInvite");
        linkifiedTextView.setText(FormatUtils.m219k(this, C5419R.string.crash_testers_invite, new Object[]{"https://discord.gg/discord-testers"}, null, 4));
        Bundle extras = getMostRecentIntent().getExtras();
        TextView textView = getBinding().f16620e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.fatalCrashSource");
        Object[] objArr = new Object[1];
        objArr[0] = extras != null ? extras.getString(INTENT_EXTRA_CRASH_SOURCE, getString(C5419R.string.status_unknown)) : null;
        textView.setText(FormatUtils.m219k(this, C5419R.string.crash_source, objArr, null, 4));
        TextView textView2 = getBinding().f16622g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.fatalCrashTime");
        Object[] objArr2 = new Object[1];
        objArr2[0] = extras != null ? extras.getString(INTENT_EXTRA_CRASH_TIME) : null;
        textView2.setText(FormatUtils.m219k(this, C5419R.string.crash_timestamp, objArr2, null, 4));
        TextView textView3 = getBinding().f16617b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.fatalCrashAppVersion");
        textView3.setText(FormatUtils.m219k(this, C5419R.string.crash_app_version, new Object[]{BuildConfig.VERSION_NAME}, null, 4));
        TextView textView4 = getBinding().f16619d;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.fatalCrashOsVersion");
        textView4.setText(FormatUtils.m219k(this, C5419R.string.crash_device_version, new Object[]{String.valueOf(Build.VERSION.SDK_INT)}, null, 4));
        TextView textView5 = getBinding().f16618c;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.fatalCrashDevice");
        textView5.setText(FormatUtils.m219k(this, C5419R.string.crash_device, new Object[]{Build.MODEL + ' ' + Build.PRODUCT}, null, 4));
    }
}
