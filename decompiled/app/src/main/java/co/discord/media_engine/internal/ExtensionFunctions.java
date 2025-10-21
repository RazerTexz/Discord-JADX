package co.discord.media_engine.internal;

import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import org.webrtc.Logging;

/* compiled from: ExtensionFunctions.kt */
/* renamed from: co.discord.media_engine.internal.ExtensionFunctionsKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ExtensionFunctions {
    public static final void logi(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "tag");
        Intrinsics3.checkNotNullParameter(str2, NotificationCompat.CATEGORY_MESSAGE);
        Logging.log(Logging.Severity.LS_INFO, str, str2);
    }
}
