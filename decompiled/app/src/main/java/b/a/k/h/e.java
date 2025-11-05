package b.a.k.h;

import java.util.regex.Pattern;

/* compiled from: ClickListenerRule.kt */
/* loaded from: classes.dex */
public final class e {
    public static final Pattern a = Pattern.compile("^\\[((?:\\[[^]]*]|[^]]|](?=[^\\[]*]))*)]\\(\\s*<?((?:[^\\s\\\\]|\\\\.)*?)>?(?:\\s+['\"]([\\s\\S]*?)['\"])?\\s*\\)");
}
