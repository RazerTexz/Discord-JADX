package com.discord.utilities.string;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utils.C7063R;
import com.discord.widgets.chat.input.MentionUtils;
import java.net.IDN;
import java.net.URL;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.util.Locale;
import kotlin.jvm.functions.Function1;
import kotlin.text.Regex;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: StringUtils.kt */
/* renamed from: com.discord.utilities.string.StringUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class StringUtils2 {
    private static final String STATIC_IMAGE_EXTENSION;
    private static final Regex STRIP_ACCENTS_REGEX = new Regex("[\\p{InCombiningDiacriticalMarks}]");

    static {
        STATIC_IMAGE_EXTENSION = Collections2.listOf((Object[]) new Integer[]{28, 29}).contains(Integer.valueOf(Build.VERSION.SDK_INT)) ? "png" : "webp";
    }

    public static final String encodeToBase32String(byte[] bArr) {
        int i;
        Intrinsics3.checkNotNullParameter(bArr, "$this$encodeToBase32String");
        StringBuffer stringBuffer = new StringBuffer(((bArr.length + 7) * 8) / 5);
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            int i4 = bArr[i2] >= 0 ? bArr[i2] : bArr[i2] + 256;
            if (i3 > 3) {
                i2++;
                int i5 = i4 & (255 >> i3);
                i3 = (i3 + 5) % 8;
                i = (i5 << i3) | ((i2 < bArr.length ? bArr[i2] >= 0 ? bArr[i2] : bArr[i2] + 256 : 0) >> (8 - i3));
            } else {
                int i6 = i3 + 5;
                i = (i4 >> (8 - i6)) & 31;
                i3 = i6 % 8;
                if (i3 == 0) {
                    i2++;
                }
            }
            stringBuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".charAt(i));
        }
        String string = stringBuffer.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "Base32.encodeOriginal(this)");
        return string;
    }

    public static final String filenameSanitized(CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(charSequence, "$this$filenameSanitized");
        return new Regex("[/\\\\]").replace(charSequence, "_");
    }

    public static final String format(int i, Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        String str = NumberFormat.getInstance(new LocaleManager().getPrimaryLocale(context)).format(Integer.valueOf(i));
        Intrinsics3.checkNotNullExpressionValue(str, "NumberFormat.getInstance…le(context)).format(this)");
        return str;
    }

    public static final String getSTATIC_IMAGE_EXTENSION() {
        return STATIC_IMAGE_EXTENSION;
    }

    public static final CharSequence getStringByLocale(Context context, int i, String str) {
        Intrinsics3.checkNotNullParameter(context, "$this$getStringByLocale");
        Intrinsics3.checkNotNullParameter(str, "locale");
        try {
            Resources resources = context.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            Configuration configuration = new Configuration(resources.getConfiguration());
            configuration.setLocale(new Locale(str));
            Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
            Intrinsics3.checkNotNullExpressionValue(contextCreateConfigurationContext, "createConfigurationContext(configuration)");
            Resources resources2 = contextCreateConfigurationContext.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources2, "createConfigurationConte…(configuration).resources");
            return FormatUtils.m217i(resources2, i, new Object[0], null, 4);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static final String stripAccents(String str) {
        Intrinsics3.checkNotNullParameter(str, "$this$stripAccents");
        String strNormalize = Normalizer.normalize(str, Normalizer.Form.NFKD);
        Intrinsics3.checkNotNullExpressionValue(strNormalize, "normalizedString");
        return STRIP_ACCENTS_REGEX.replace(strNormalize, "");
    }

    public static final void test(Context context, Resources resources) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(resources, "resources");
        context.getString(C7063R.a.common_google_play_services_unknown_issue, 1);
        resources.getString(C7063R.a.common_google_play_services_enable_button, 1);
    }

    public static final String toPunyCodeASCIIUrl(String str) {
        Intrinsics3.checkNotNullParameter(str, "$this$toPunyCodeASCIIUrl");
        URL url = new URL(str);
        StringBuilder sb = new StringBuilder(new URL(url.getProtocol(), IDN.toASCII(url.getHost(), 1), url.getPort(), url.getFile()).toString());
        if (url.getRef() != null) {
            sb.append(MentionUtils.CHANNELS_CHAR);
            sb.append(url.getRef());
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "safeUrlStringBuilder.toString()");
        return string;
    }

    public static final String transformOrEmpty(String str, Function1<? super String, String> function1) {
        String strInvoke;
        if (function1 != null && (strInvoke = function1.invoke(str)) != null) {
            str = strInvoke;
        }
        return str != null ? str : "";
    }
}
