package okhttp3;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;

/* compiled from: WebSocket.kt */
/* loaded from: classes3.dex */
public interface WebSocket {
    boolean a(String text);

    boolean e(int code, String reason);
}
