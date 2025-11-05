package d0.g0;

/* compiled from: StringBuilder.kt */
/* loaded from: classes3.dex */
public class q extends p {
    public static final StringBuilder append(StringBuilder sb, String... strArr) {
        d0.z.d.m.checkNotNullParameter(sb, "$this$append");
        d0.z.d.m.checkNotNullParameter(strArr, "value");
        for (String str : strArr) {
            sb.append(str);
        }
        return sb;
    }
}
