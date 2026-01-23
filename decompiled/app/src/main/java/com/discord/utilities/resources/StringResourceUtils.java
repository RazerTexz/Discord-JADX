package com.discord.utilities.resources;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.PluralsRes;
import androidx.annotation.StringRes;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.string.StringUtils2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.resources.StringResourceUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: StringResourceUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StringResourceUtils {
    public static final CharSequence getI18nPluralString(Context context, @PluralsRes int i, int i2, Object... objArr) {
        Intrinsics3.checkNotNullParameter(context, "$this$getI18nPluralString");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        String quantityString = context.getResources().getQuantityString(i, i2);
        Intrinsics3.checkNotNullExpressionValue(quantityString, "resources.getQuantityString(resId, quantity)");
        return objArr.length == 0 ? FormatUtils.m220l(quantityString, new Object[0], null, 2) : FormatUtils.m220l(quantityString, Arrays.copyOf(objArr, objArr.length), null, 2);
    }

    public static final CharSequence getQuantityString(Resources resources, @PluralsRes int i, @StringRes int i2, int i3, Object... objArr) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(resources, "$this$getQuantityString");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        if (i3 == 0) {
            return FormatUtils.m217i(resources, i2, new Object[0], null, 4);
        }
        String quantityString = resources.getQuantityString(i, i3);
        Intrinsics3.checkNotNullExpressionValue(quantityString, "getQuantityString(id, quantity)");
        return objArr.length == 0 ? FormatUtils.m220l(quantityString, new Object[0], null, 2) : FormatUtils.m220l(quantityString, Arrays.copyOf(objArr, objArr.length), null, 2);
    }

    public static final CharSequence getQuantityString(Resources resources, Context context, @PluralsRes int i, int i2, Object... objArr) {
        Intrinsics3.checkNotNullParameter(resources, "$this$getQuantityString");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            if (obj instanceof Integer) {
                obj = StringUtils2.format(i2, context);
            }
            arrayList.add(obj);
        }
        Object[] array = arrayList.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        String quantityString = resources.getQuantityString(i, i2);
        Intrinsics3.checkNotNullExpressionValue(quantityString, "getQuantityString(resId, quantity)");
        if (array.length == 0) {
            return FormatUtils.m220l(quantityString, new Object[0], null, 2);
        }
        return FormatUtils.m220l(quantityString, Arrays.copyOf(array, array.length), null, 2);
    }
}
