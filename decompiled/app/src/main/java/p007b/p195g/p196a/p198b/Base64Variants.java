package p007b.p195g.p196a.p198b;

import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.android.material.badge.BadgeDrawable;

/* JADX INFO: renamed from: b.g.a.b.b, reason: use source file name */
/* JADX INFO: compiled from: Base64Variants.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Base64Variants {

    /* JADX INFO: renamed from: a */
    public static final Base64Variant f4451a;

    /* JADX INFO: renamed from: b */
    public static final Base64Variant f4452b;

    /* JADX INFO: renamed from: c */
    public static final Base64Variant f4453c;

    /* JADX INFO: renamed from: d */
    public static final Base64Variant f4454d;

    static {
        Base64Variant base64Variant = new Base64Variant("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        f4451a = base64Variant;
        f4452b = new Base64Variant(base64Variant, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
        f4453c = new Base64Variant(base64Variant, "PEM", true, '=', 64);
        StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        sb.setCharAt(sb.indexOf(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX), '-');
        sb.setCharAt(sb.indexOf(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN), '_');
        f4454d = new Base64Variant("MODIFIED-FOR-URL", sb.toString(), false, (char) 0, Integer.MAX_VALUE);
    }
}
