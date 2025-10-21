package com.discord.utilities.resources;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.PluralsRes;
import androidx.annotation.StringRes;
import b.a.k.FormatUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.string.StringUtils2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: StringResourceUtils.kt */
/* renamed from: com.discord.utilities.resources.StringResourceUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class StringResourceUtils {
    public static final CharSequence getI18nPluralString(Context context, @PluralsRes int i, int i2, Object... objArr) {
        Intrinsics3.checkNotNullParameter(context, "$this$getI18nPluralString");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        String quantityString = context.getResources().getQuantityString(i, i2);
        Intrinsics3.checkNotNullExpressionValue(quantityString, "resources.getQuantityString(resId, quantity)");
        return objArr.length == 0 ? FormatUtils.l(quantityString, new Object[0], null, 2) : FormatUtils.l(quantityString, Arrays.copyOf(objArr, objArr.length), null, 2);
    }

    public static final CharSequence getQuantityString(Resources resources, @PluralsRes int i, @StringRes int i2, int i3, Object... objArr) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(resources, "$this$getQuantityString");
        Intrinsics3.checkNotNullParameter(objArr, "formatArgs");
        if (i3 == 0) {
            return FormatUtils.i(resources, i2, new Object[0], null, 4);
        }
        String quantityString = resources.getQuantityString(i, i3);
        Intrinsics3.checkNotNullExpressionValue(quantityString, "getQuantityString(id, quantity)");
        return objArr.length == 0 ? FormatUtils.l(quantityString, new Object[0], null, 2) : FormatUtils.l(quantityString, Arrays.copyOf(objArr, objArr.length), null, 2);
    }

    public static final CharSequence getQuantityString(Resources resources, Context context, @PluralsRes int i, int i2, Object... objArr) throws Resources.NotFoundException {
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
            return FormatUtils.l(quantityString, new Object[0], null, 2);
        }
        return FormatUtils.l(quantityString, Arrays.copyOf(array, array.length), null, 2);
    }
}
