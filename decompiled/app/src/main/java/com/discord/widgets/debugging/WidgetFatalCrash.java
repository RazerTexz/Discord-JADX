package com.discord.widgets.debugging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetFatalCrashBinding;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetFatalCrash.kt */
/* loaded from: classes2.dex */
public final class WidgetFatalCrash extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetFatalCrash.class, "binding", "getBinding()Lcom/discord/databinding/WidgetFatalCrashBinding;", 0)};

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
            m.checkNotNullExpressionValue(intentPutExtras, "Intent().putExtras(extras)");
            return intentPutExtras;
        }

        public final void launch(Context context, Throwable throwable, String crashSource) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(throwable, "throwable");
            m.checkNotNullParameter(crashSource, "crashSource");
            AppLog appLog = AppLog.g;
            String simpleName = WidgetFatalCrash.class.getSimpleName();
            m.checkNotNullExpressionValue(simpleName, "WidgetFatalCrash::class.java.simpleName");
            Logger.e$default(appLog, simpleName, new Throwable(crashSource, throwable), null, 4, null);
            j.d(context, WidgetFatalCrash.class, createIntent(crashSource));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetFatalCrash() {
        super(R.layout.widget_fatal_crash);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetFatalCrash$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetFatalCrashBinding getBinding() {
        return (WidgetFatalCrashBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context, Throwable th, String str) {
        INSTANCE.launch(context, th, str);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        LinkifiedTextView linkifiedTextView = getBinding().f;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.fatalCrashTestersInvite");
        linkifiedTextView.setText(b.k(this, R.string.crash_testers_invite, new Object[]{"https://discord.gg/discord-testers"}, null, 4));
        Bundle extras = getMostRecentIntent().getExtras();
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.fatalCrashSource");
        Object[] objArr = new Object[1];
        objArr[0] = extras != null ? extras.getString(INTENT_EXTRA_CRASH_SOURCE, getString(R.string.status_unknown)) : null;
        textView.setText(b.k(this, R.string.crash_source, objArr, null, 4));
        TextView textView2 = getBinding().g;
        m.checkNotNullExpressionValue(textView2, "binding.fatalCrashTime");
        Object[] objArr2 = new Object[1];
        objArr2[0] = extras != null ? extras.getString(INTENT_EXTRA_CRASH_TIME) : null;
        textView2.setText(b.k(this, R.string.crash_timestamp, objArr2, null, 4));
        TextView textView3 = getBinding().f2384b;
        m.checkNotNullExpressionValue(textView3, "binding.fatalCrashAppVersion");
        textView3.setText(b.k(this, R.string.crash_app_version, new Object[]{BuildConfig.VERSION_NAME}, null, 4));
        TextView textView4 = getBinding().d;
        m.checkNotNullExpressionValue(textView4, "binding.fatalCrashOsVersion");
        textView4.setText(b.k(this, R.string.crash_device_version, new Object[]{String.valueOf(Build.VERSION.SDK_INT)}, null, 4));
        TextView textView5 = getBinding().c;
        m.checkNotNullExpressionValue(textView5, "binding.fatalCrashDevice");
        textView5.setText(b.k(this, R.string.crash_device, new Object[]{Build.MODEL + ' ' + Build.PRODUCT}, null, 4));
    }
}
