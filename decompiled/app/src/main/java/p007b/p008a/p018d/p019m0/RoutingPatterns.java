package p007b.p008a.p018d.p019m0;

import android.net.Uri;
import com.discord.BuildConfig;
import kotlin.text.Regex;
import p507d0.p579g0.Regex5;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.d.m0.a, reason: use source file name */
/* JADX INFO: compiled from: RoutingPatterns.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RoutingPatterns {

    /* JADX INFO: renamed from: A */
    public static final Regex f532A;

    /* JADX INFO: renamed from: B */
    public static final Regex f533B;

    /* JADX INFO: renamed from: C */
    public static final Regex f534C;

    /* JADX INFO: renamed from: D */
    public static final Regex f535D;

    /* JADX INFO: renamed from: E */
    public static final Regex f536E;

    /* JADX INFO: renamed from: F */
    public static final Regex f537F;

    /* JADX INFO: renamed from: G */
    public static final RoutingPatterns f538G;

    /* JADX INFO: renamed from: a */
    public static final String f539a;

    /* JADX INFO: renamed from: b */
    public static final String f540b;

    /* JADX INFO: renamed from: c */
    public static final String f541c;

    /* JADX INFO: renamed from: d */
    public static final String f542d;

    /* JADX INFO: renamed from: e */
    public static final String f543e;

    /* JADX INFO: renamed from: f */
    public static final String f544f;

    /* JADX INFO: renamed from: g */
    public static final String f545g;

    /* JADX INFO: renamed from: h */
    public static final String f546h;

    /* JADX INFO: renamed from: i */
    public static final String f547i;

    /* JADX INFO: renamed from: j */
    public static final String f548j;

    /* JADX INFO: renamed from: k */
    public static final String f549k;

    /* JADX INFO: renamed from: l */
    public static final Regex f550l;

    /* JADX INFO: renamed from: m */
    public static final Regex f551m;

    /* JADX INFO: renamed from: n */
    public static final Regex f552n;

    /* JADX INFO: renamed from: o */
    public static final Regex f553o;

    /* JADX INFO: renamed from: p */
    public static final Regex f554p;

    /* JADX INFO: renamed from: q */
    public static final Regex f555q;

    /* JADX INFO: renamed from: r */
    public static final Regex f556r;

    /* JADX INFO: renamed from: s */
    public static final Regex f557s;

    /* JADX INFO: renamed from: t */
    public static final Regex f558t;

    /* JADX INFO: renamed from: u */
    public static final Regex f559u;

    /* JADX INFO: renamed from: v */
    public static final Regex f560v;

    /* JADX INFO: renamed from: w */
    public static final Regex f561w;

    /* JADX INFO: renamed from: x */
    public static final Regex f562x;

    /* JADX INFO: renamed from: y */
    public static final Regex f563y;

    /* JADX INFO: renamed from: z */
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

    /* JADX INFO: renamed from: a */
    public final boolean m173a(String str) {
        if (str == null) {
            return false;
        }
        if (Intrinsics3.areEqual(str, f539a) || Intrinsics3.areEqual(str, f540b) || Intrinsics3.areEqual(str, f541c) || Intrinsics3.areEqual(str, f543e) || Intrinsics3.areEqual(str, f542d)) {
            return true;
        }
        return f550l.matches(str);
    }

    /* JADX INFO: renamed from: b */
    public final String m174b(String str) {
        Uri uri = Uri.parse(str);
        Intrinsics3.checkNotNullExpressionValue(uri, "Uri.parse(this)");
        String host = uri.getHost();
        return host != null ? host : "";
    }
}
