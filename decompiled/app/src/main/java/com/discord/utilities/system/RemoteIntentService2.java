package com.discord.utilities.system;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import androidx.core.app.NotificationCompat;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import com.discord.utilities.system.RemoteIntentService;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: RemoteIntentService.kt */
/* renamed from: com.discord.utilities.system.RemoteIntentService$IpcCallback$handler$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class RemoteIntentService2 implements Handler.Callback {
    public final /* synthetic */ RemoteIntentService.IpcCallback this$0;

    public RemoteIntentService2(RemoteIntentService.IpcCallback ipcCallback) {
        this.this$0 = ipcCallback;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Intrinsics3.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
        Logger logger = LoggingProvider.INSTANCE.get();
        if (message.what == 1) {
            StringBuilder sbM829Q = outline.m829Q('[');
            sbM829Q.append(RemoteIntentService.IpcCallback.access$getName$p(this.this$0));
            sbM829Q.append("] in IpcCallback: app pid=");
            sbM829Q.append(Process.myPid());
            Logger.d$default(logger, "RemoteIntentService", sbM829Q.toString(), null, 4, null);
            Object obj = message.obj;
            if (obj instanceof Bundle) {
                StringBuilder sbM829Q2 = outline.m829Q('[');
                sbM829Q2.append(RemoteIntentService.IpcCallback.access$getName$p(this.this$0));
                sbM829Q2.append("] success after (");
                Logger.d$default(logger, "RemoteIntentService", outline.m814B(sbM829Q2, message.arg1, " ms)"), null, 4, null);
                RemoteIntentService.IpcCallback ipcCallback = this.this$0;
                Object obj2 = message.obj;
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type android.os.Bundle");
                ipcCallback.onSuccess((Bundle) obj2);
                return true;
            }
            if ((obj instanceof Throwable) || obj == null) {
                StringBuilder sbM829Q3 = outline.m829Q('[');
                sbM829Q3.append(RemoteIntentService.IpcCallback.access$getName$p(this.this$0));
                sbM829Q3.append("] failure after (");
                Logger.d$default(logger, "RemoteIntentService", outline.m814B(sbM829Q3, message.arg1, " ms)"), null, 4, null);
                RemoteIntentService.IpcCallback ipcCallback2 = this.this$0;
                Object obj3 = message.obj;
                if (!(obj3 instanceof Throwable)) {
                    obj3 = null;
                }
                ipcCallback2.onFailure((Throwable) obj3);
                return true;
            }
        }
        StringBuilder sbM829Q4 = outline.m829Q('[');
        sbM829Q4.append(RemoteIntentService.IpcCallback.access$getName$p(this.this$0));
        sbM829Q4.append("] unexpected message in handler: ");
        sbM829Q4.append(RemoteIntentService.Companion.access$messageToString(RemoteIntentService.INSTANCE, message));
        Logger.w$default(logger, "RemoteIntentService", sbM829Q4.toString(), null, 4, null);
        return false;
    }
}
