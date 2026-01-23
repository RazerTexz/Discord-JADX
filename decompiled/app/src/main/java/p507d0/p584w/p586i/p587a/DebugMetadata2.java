package p507d0.p584w.p586i.p587a;

import com.discord.widgets.chat.input.MentionUtils;
import java.lang.reflect.Field;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.w.i.a.f, reason: use source file name */
/* JADX INFO: compiled from: DebugMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DebugMetadata2 {
    public static final StackTraceElement getStackTraceElement(ContinuationImpl continuationImpl) {
        int iIntValue;
        String strM10084c;
        Intrinsics3.checkNotNullParameter(continuationImpl, "$this$getStackTraceElementImpl");
        DebugMetadata debugMetadata = (DebugMetadata) continuationImpl.getClass().getAnnotation(DebugMetadata.class);
        Object obj = null;
        if (debugMetadata == null) {
            return null;
        }
        int iM10088v = debugMetadata.m10088v();
        if (iM10088v > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iM10088v + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = continuationImpl.getClass().getDeclaredField("label");
            Intrinsics3.checkNotNullExpressionValue(declaredField, "field");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(continuationImpl);
            if (obj2 instanceof Integer) {
                obj = obj2;
            }
            Integer num = (Integer) obj;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i = iIntValue >= 0 ? debugMetadata.m10086l()[iIntValue] : -1;
        String moduleName = DebugMetadata3.f25247c.getModuleName(continuationImpl);
        if (moduleName == null) {
            strM10084c = debugMetadata.m10084c();
        } else {
            strM10084c = moduleName + MentionUtils.SLASH_CHAR + debugMetadata.m10084c();
        }
        return new StackTraceElement(strM10084c, debugMetadata.m10087m(), debugMetadata.m10085f(), i);
    }
}
