package androidx.work;

import androidx.exifinterface.media.ExifInterface;
import androidx.work.Data;
import d0.z.d.m;
import kotlin.Pair;

/* compiled from: Data.kt */
/* loaded from: classes.dex */
public final class DataKt {
    public static final /* synthetic */ <T> boolean hasKeyWithValueOfType(Data data, String str) {
        m.checkParameterIsNotNull(data, "$this$hasKeyWithValueOfType");
        m.checkParameterIsNotNull(str, "key");
        m.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return data.hasKeyWithValueOfType(str, Object.class);
    }

    public static final Data workDataOf(Pair<String, ? extends Object>... pairArr) throws Throwable {
        m.checkParameterIsNotNull(pairArr, "pairs");
        Data.Builder builder = new Data.Builder();
        for (Pair<String, ? extends Object> pair : pairArr) {
            builder.put(pair.getFirst(), pair.getSecond());
        }
        Data dataBuild = builder.build();
        m.checkExpressionValueIsNotNull(dataBuild, "dataBuilder.build()");
        return dataBuild;
    }
}
