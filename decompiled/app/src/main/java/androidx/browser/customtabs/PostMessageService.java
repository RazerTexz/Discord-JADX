package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p668x.p669a.p670a.ICustomTabsCallback;
import p668x.p669a.p670a.IPostMessageService;

/* JADX INFO: loaded from: classes.dex */
public class PostMessageService extends Service {
    private IPostMessageService.a mBinder = new BinderC01561();

    /* JADX INFO: renamed from: androidx.browser.customtabs.PostMessageService$1 */
    public class BinderC01561 extends IPostMessageService.a {
        public BinderC01561() {
        }

        @Override // p668x.p669a.p670a.IPostMessageService
        public void onMessageChannelReady(@NonNull ICustomTabsCallback iCustomTabsCallback, @Nullable Bundle bundle) throws RemoteException {
            iCustomTabsCallback.onMessageChannelReady(bundle);
        }

        @Override // p668x.p669a.p670a.IPostMessageService
        public void onPostMessage(@NonNull ICustomTabsCallback iCustomTabsCallback, @NonNull String str, @Nullable Bundle bundle) throws RemoteException {
            iCustomTabsCallback.onPostMessage(str, bundle);
        }
    }

    @Override // android.app.Service
    @NonNull
    public IBinder onBind(@Nullable Intent intent) {
        return this.mBinder;
    }
}
