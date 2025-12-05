package p007b.p008a.p018d;

import android.annotation.SuppressLint;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.MentionUtils;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AppHelpDesk.kt */
/* renamed from: b.a.d.f, reason: use source file name */
/* loaded from: classes.dex */
public final class AppHelpDesk {

    /* renamed from: a */
    public static final AppHelpDesk f507a = new AppHelpDesk();

    /* renamed from: c */
    public static final String m148c() {
        StringBuilder sbM836X = outline.m836X("https://support.discord.com", "/hc/");
        String locale = StoreStream.INSTANCE.getUserSettingsSystem().getLocale();
        Objects.requireNonNull(locale, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = locale.toLowerCase();
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        sbM836X.append(lowerCase);
        sbM836X.append("/requests/new");
        return sbM836X.toString();
    }

    /* renamed from: a */
    public final String m149a(long j, String str) {
        if (str == null) {
            StringBuilder sbM836X = outline.m836X("https://support.discord.com", "/hc/");
            sbM836X.append(m150b());
            sbM836X.append("/articles/");
            sbM836X.append(j);
            return sbM836X.toString();
        }
        StringBuilder sbM836X2 = outline.m836X("https://support.discord.com", "/hc/");
        sbM836X2.append(m150b());
        sbM836X2.append("/articles/");
        sbM836X2.append(j);
        sbM836X2.append(MentionUtils.CHANNELS_CHAR);
        sbM836X2.append(str);
        return sbM836X2.toString();
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: b */
    public final String m150b() {
        String locale = StoreStream.INSTANCE.getUserSettingsSystem().getLocale();
        Objects.requireNonNull(locale, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = locale.toLowerCase();
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }
}
