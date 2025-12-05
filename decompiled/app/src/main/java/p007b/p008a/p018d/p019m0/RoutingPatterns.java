package p007b.p008a.p018d.p019m0;

import android.net.Uri;
import com.discord.BuildConfig;
import kotlin.text.Regex;
import p507d0.p579g0.Regex5;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: RoutingPatterns.kt */
/* renamed from: b.a.d.m0.a, reason: use source file name */
/* loaded from: classes.dex */
public final class RoutingPatterns {

    /* renamed from: A */
    public static final Regex f532A;

    /* renamed from: B */
    public static final Regex f533B;

    /* renamed from: C */
    public static final Regex f534C;

    /* renamed from: D */
    public static final Regex f535D;

    /* renamed from: E */
    public static final Regex f536E;

    /* renamed from: F */
    public static final Regex f537F;

    /* renamed from: G */
    public static final RoutingPatterns f538G;

    /* renamed from: a */
    public static final String f539a;

    /* renamed from: b */
    public static final String f540b;

    /* renamed from: c */
    public static final String f541c;

    /* renamed from: d */
    public static final String f542d;

    /* renamed from: e */
    public static final String f543e;

    /* renamed from: f */
    public static final String f544f;

    /* renamed from: g */
    public static final String f545g;

    /* renamed from: h */
    public static final String f546h;

    /* renamed from: i */
    public static final String f547i;

    /* renamed from: j */
    public static final String f548j;

    /* renamed from: k */
    public static final String f549k;

    /* renamed from: l */
    public static final Regex f550l;

    /* renamed from: m */
    public static final Regex f551m;

    /* renamed from: n */
    public static final Regex f552n;

    /* renamed from: o */
    public static final Regex f553o;

    /* renamed from: p */
    public static final Regex f554p;

    /* renamed from: q */
    public static final Regex f555q;

    /* renamed from: r */
    public static final Regex f556r;

    /* renamed from: s */
    public static final Regex f557s;

    /* renamed from: t */
    public static final Regex f558t;

    /* renamed from: u */
    public static final Regex f559u;

    /* renamed from: v */
    public static final Regex f560v;

    /* renamed from: w */
    public static final Regex f561w;

    /* renamed from: x */
    public static final Regex f562x;

    /* renamed from: y */
    public static final Regex f563y;

    /* renamed from: z */
    public static final Regex f564z;

    static {
        RoutingPatterns routingPatterns = new RoutingPatterns();
        f538G = routingPatterns;
        String strM174b = routingPatterns.m174b(BuildConfig.HOST);
        f539a = strM174b;
        String strM174b2 = routingPatterns.m174b(BuildConfig.HOST_ALTERNATE);
        f540b = strM174b2;
        String strM174b3 = routingPatterns.m174b(BuildConfig.HOST_GIFT);
        f541c = strM174b3;
        String strM174b4 = routingPatterns.m174b(BuildConfig.HOST_INVITE);
        f542d = strM174b4;
        String strM174b5 = routingPatterns.m174b(BuildConfig.HOST_GUILD_TEMPLATE);
        f543e = strM174b5;
        String strReplace$default = StringsJVM.replace$default(strM174b, ".", "\\.", false, 4, (Object) null);
        f544f = strReplace$default;
        String strReplace$default2 = StringsJVM.replace$default(strM174b2, ".", "\\.", false, 4, (Object) null);
        f545g = strReplace$default2;
        String str = "(?:" + strReplace$default + '|' + strReplace$default2 + ')';
        f546h = str;
        String strReplace$default3 = StringsJVM.replace$default(strM174b3, ".", "\\.", false, 4, (Object) null);
        f547i = strReplace$default3;
        String strReplace$default4 = StringsJVM.replace$default(strM174b4, ".", "\\.", false, 4, (Object) null);
        f548j = strReplace$default4;
        String strReplace$default5 = StringsJVM.replace$default(strM174b5, ".", "\\.", false, 4, (Object) null);
        f549k = strReplace$default5;
        Regex5 regex5 = Regex5.IGNORE_CASE;
        f550l = new Regex("^(?:ptb|canary|www)." + str + '$', regex5);
        f551m = new Regex("^/(?:(invite|gift|template)/)?([\\w-]+)/?$", regex5);
        f552n = new Regex("^/(?:invite/)?([\\w-]+)/?$", regex5);
        StringBuilder sb = new StringBuilder();
        sb.append("(?:https?://(?:(?:" + str + "/invite)|");
        sb.append("(?:" + strReplace$default4 + "))|");
        sb.append("(?:^" + strReplace$default4 + "))/([\\w-]+)/?");
        sb.append("(?:(?:\\S*[\\?&]event=)([\\w-]+))?");
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder()\n        …\"\")\n          .toString()");
        f553o = new Regex(string, regex5);
        f554p = new Regex("^/(?:template/)?([\\w-]+)/?$", regex5);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(?:https?://(?:(?:" + str + "/template)|");
        sb2.append("(?:" + strReplace$default5 + "))|");
        sb2.append("(?:" + strReplace$default5 + "))/([\\w-]+)/?");
        String string2 = sb2.toString();
        Intrinsics3.checkNotNullExpressionValue(string2, "StringBuilder()\n        …?\")\n          .toString()");
        f555q = new Regex(string2, regex5);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("(?:https?://)?(?:(?:" + str + "/gifts)|");
        sb3.append("(?:" + strReplace$default3 + "))/([\\w-]+)/?");
        String string3 = sb3.toString();
        Intrinsics3.checkNotNullExpressionValue(string3, "StringBuilder()\n        …?\")\n          .toString()");
        f556r = new Regex(string3, regex5);
        f557s = new Regex("^/connect(?:/(\\d+))?/?$", regex5);
        f558t = new Regex("^/channels/((?:@me)|(?:\\d+))(?:/(\\d+))?(?:/(\\d+))?/?$", regex5);
        f559u = new Regex("^/channels/((?:@me)|(?:\\d+))/([@a-zA-Z_-]+)/?$", regex5);
        f560v = new Regex("^/channels/@me/-1?/?$", regex5);
        f561w = new Regex("^/lurk/(\\d+)(?:/(\\d+))?/?$", regex5);
        f562x = new Regex("^/channels/@me/user/(\\d+)/?$", regex5);
        f563y = new Regex("^/users/(\\d+)/?$", regex5);
        f564z = new Regex("^/settings(/\\w+)*/?$", regex5);
        f532A = new Regex("^/feature(/\\w+)*/?$", regex5);
        f533B = new Regex("^/query(/\\w+)*/?$", regex5);
        f534C = new Regex("^/(?:oauth2|connect)/authorize/?$", regex5);
        f535D = new Regex("^/ra/([\\w-]+)$");
        f536E = new Regex("^/guild/((?:@me)|(?:\\d+))/premiumguild/?$", regex5);
        f537F = new Regex("^/events/(\\d+)/(\\d+)/?$", regex5);
    }

    /* renamed from: a */
    public final boolean m173a(String str) {
        if (str == null) {
            return false;
        }
        if (Intrinsics3.areEqual(str, f539a) || Intrinsics3.areEqual(str, f540b) || Intrinsics3.areEqual(str, f541c) || Intrinsics3.areEqual(str, f543e) || Intrinsics3.areEqual(str, f542d)) {
            return true;
        }
        return f550l.matches(str);
    }

    /* renamed from: b */
    public final String m174b(String str) {
        Uri uri = Uri.parse(str);
        Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(this)");
        String host = uri.getHost();
        return host != null ? host : "";
    }
}
