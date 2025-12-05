package p007b.p008a.p018d;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.utilities.view.ToastManager;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AppToast.kt */
/* renamed from: b.a.d.m, reason: use source file name */
/* loaded from: classes.dex */
public final class AppToast {
    /* renamed from: a */
    public static final void m163a(Context context, CharSequence charSequence, int i) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        String string = context.getString(i);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(toastResId)");
        m164b(context, charSequence, string);
    }

    /* renamed from: b */
    public static final void m164b(Context context, CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        Intrinsics3.checkNotNullParameter(charSequence2, "toastText");
        Object systemService = context.getSystemService("clipboard");
        if (!(systemService instanceof ClipboardManager)) {
            systemService = null;
        }
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        ClipData clipDataNewPlainText = ClipData.newPlainText("", charSequence);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
        m170h(context, charSequence2, 0, null, 12);
    }

    /* renamed from: c */
    public static /* synthetic */ void m165c(Context context, CharSequence charSequence, int i, int i2) {
        if ((i2 & 4) != 0) {
            i = C5419R.string.copied_text;
        }
        m163a(context, charSequence, i);
    }

    /* renamed from: d */
    public static final void m166d(Context context, @StringRes int i, int i2, ToastManager toastManager) {
        m167e(context, context != null ? context.getString(i) : null, i2, toastManager);
    }

    /* renamed from: e */
    public static final void m167e(Context context, CharSequence charSequence, int i, ToastManager toastManager) {
        TextView textView;
        if (context != null) {
            Toast toast = new Toast(context);
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 2131952606);
            if (charSequence instanceof DraweeSpanStringBuilder) {
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = new SimpleDraweeSpanTextView(contextThemeWrapper);
                simpleDraweeSpanTextView.setDraweeSpanStringBuilder((DraweeSpanStringBuilder) charSequence);
                textView = simpleDraweeSpanTextView;
            } else {
                TextView textView2 = new TextView(contextThemeWrapper);
                textView2.setText(charSequence);
                textView = textView2;
            }
            toast.setView(textView);
            toast.setDuration(i);
            if (toastManager != null) {
                toastManager.show(toast);
            } else {
                toast.show();
            }
        }
    }

    /* renamed from: f */
    public static final void m168f(Fragment fragment, CharSequence charSequence, int i) {
        m170h(fragment != null ? fragment.getContext() : null, charSequence, i, null, 8);
    }

    /* renamed from: g */
    public static /* synthetic */ void m169g(Context context, int i, int i2, ToastManager toastManager, int i3) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        int i4 = i3 & 8;
        m166d(context, i, i2, null);
    }

    /* renamed from: h */
    public static /* synthetic */ void m170h(Context context, CharSequence charSequence, int i, ToastManager toastManager, int i2) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        if ((i2 & 8) != 0) {
            toastManager = null;
        }
        m167e(context, charSequence, i, toastManager);
    }

    /* renamed from: i */
    public static void m171i(Fragment fragment, int i, int i2, int i3) {
        Context context;
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        m168f(fragment, (fragment == null || (context = fragment.getContext()) == null) ? null : context.getString(i), i2);
    }

    /* renamed from: j */
    public static /* synthetic */ void m172j(Fragment fragment, CharSequence charSequence, int i, int i2) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        m168f(fragment, charSequence, i);
    }
}
