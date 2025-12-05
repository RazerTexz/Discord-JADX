package okhttp3;

import com.discord.models.domain.ModelAuditLogEntry;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.Progressions2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p512d0._Ranges;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: MediaType.kt */
/* loaded from: classes3.dex */
public final class MediaType {

    /* renamed from: a */
    public static final Pattern f27514a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: b */
    public static final Pattern f27515b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = null;

    /* renamed from: d, reason: from kotlin metadata */
    public final String mediaType;

    /* renamed from: e, reason: from kotlin metadata */
    public final String type;

    /* renamed from: f, reason: from kotlin metadata */
    public final String subtype;

    /* renamed from: g, reason: from kotlin metadata */
    public final String[] parameterNamesAndValues;

    /* compiled from: MediaType.kt */
    /* renamed from: okhttp3.MediaType$a, reason: from kotlin metadata */
    public static final class Companion {
        /* renamed from: a */
        public static final MediaType m10967a(String str) {
            Intrinsics3.checkParameterIsNotNull(str, "$this$toMediaType");
            Matcher matcher = MediaType.f27514a.matcher(str);
            if (!matcher.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
            }
            String strGroup = matcher.group(1);
            Intrinsics3.checkExpressionValueIsNotNull(strGroup, "typeSubtype.group(1)");
            Locale locale = Locale.US;
            Intrinsics3.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (strGroup == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strGroup.toLowerCase(locale);
            Intrinsics3.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String strGroup2 = matcher.group(2);
            Intrinsics3.checkExpressionValueIsNotNull(strGroup2, "typeSubtype.group(2)");
            Intrinsics3.checkExpressionValueIsNotNull(locale, "Locale.US");
            if (strGroup2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase2 = strGroup2.toLowerCase(locale);
            Intrinsics3.checkExpressionValueIsNotNull(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList = new ArrayList();
            Matcher matcher2 = MediaType.f27515b.matcher(str);
            int iEnd = matcher.end();
            while (iEnd < str.length()) {
                matcher2.region(iEnd, str.length());
                if (!matcher2.lookingAt()) {
                    StringBuilder sbM833U = outline.m833U("Parameter is not formatted correctly: \"");
                    String strSubstring = str.substring(iEnd);
                    Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
                    sbM833U.append(strSubstring);
                    sbM833U.append("\" for: \"");
                    sbM833U.append(str);
                    sbM833U.append('\"');
                    throw new IllegalArgumentException(sbM833U.toString().toString());
                }
                String strGroup3 = matcher2.group(1);
                if (strGroup3 == null) {
                    iEnd = matcher2.end();
                } else {
                    String strGroup4 = matcher2.group(2);
                    if (strGroup4 == null) {
                        strGroup4 = matcher2.group(3);
                    } else if (StringsJVM.startsWith$default(strGroup4, "'", false, 2, null) && StringsJVM.endsWith$default(strGroup4, "'", false, 2, null) && strGroup4.length() > 2) {
                        strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                        Intrinsics3.checkExpressionValueIsNotNull(strGroup4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    arrayList.add(strGroup3);
                    arrayList.add(strGroup4);
                    iEnd = matcher2.end();
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return new MediaType(str, lowerCase, lowerCase2, (String[]) array, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        /* renamed from: b */
        public static final MediaType m10968b(String str) {
            Intrinsics3.checkParameterIsNotNull(str, "$this$toMediaTypeOrNull");
            try {
                return m10967a(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    public MediaType(String str, String str2, String str3, String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.parameterNamesAndValues = strArr;
    }

    /* renamed from: b */
    public static final MediaType m10965b(String str) {
        return Companion.m10967a(str);
    }

    /* renamed from: a */
    public final Charset m10966a(Charset defaultValue) {
        String str;
        Intrinsics3.checkParameterIsNotNull("charset", ModelAuditLogEntry.CHANGE_KEY_NAME);
        Progressions2 progressions2Step = _Ranges.step(_Arrays.getIndices(this.parameterNamesAndValues), 2);
        int first = progressions2Step.getFirst();
        int last = progressions2Step.getLast();
        int step = progressions2Step.getStep();
        if (step < 0 ? first < last : first > last) {
            str = null;
            break;
        }
        while (!StringsJVM.equals(this.parameterNamesAndValues[first], "charset", true)) {
            if (first == last) {
                str = null;
                break;
            }
            first += step;
        }
        str = this.parameterNamesAndValues[first + 1];
        if (str == null) {
            return defaultValue;
        }
        try {
            return Charset.forName(str);
        } catch (IllegalArgumentException unused) {
            return defaultValue;
        }
    }

    public boolean equals(Object other) {
        return (other instanceof MediaType) && Intrinsics3.areEqual(((MediaType) other).mediaType, this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    /* renamed from: toString, reason: from getter */
    public String getMediaType() {
        return this.mediaType;
    }
}
