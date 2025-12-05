package p507d0.p591y;

import com.discord.models.domain.ModelAuditLogEntry;
import java.io.File;
import p507d0.p579g0.Strings4;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Utils.kt */
/* renamed from: d0.y.h, reason: use source file name */
/* loaded from: classes3.dex */
public class Utils7 extends FileTreeWalk3 {
    public static final boolean deleteRecursively(File file) {
        Intrinsics3.checkNotNullParameter(file, "$this$deleteRecursively");
        while (true) {
            boolean z2 = true;
            for (File file2 : FileTreeWalk3.walkBottomUp(file)) {
                if (!file2.delete() && file2.exists()) {
                    z2 = false;
                } else {
                    if (z2) {
                        break;
                    }
                    z2 = false;
                }
            }
            return z2;
        }
    }

    public static final String getExtension(File file) {
        Intrinsics3.checkNotNullParameter(file, "$this$extension");
        String name = file.getName();
        Intrinsics3.checkNotNullExpressionValue(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return Strings4.substringAfterLast(name, '.', "");
    }
}
