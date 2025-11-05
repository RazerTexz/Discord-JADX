package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import x.a.a.a;
import x.a.a.c;

/* loaded from: classes.dex */
public class PostMessageService extends Service {
    private c.a mBinder = new AnonymousClass1();

    /* renamed from: androidx.browser.customtabs.PostMessageService$1, reason: invalid class name */
    public class AnonymousClass1 extends c.a {
        public AnonymousClass1() {
        }

        @Override // x.a.a.c
        public void onMessageChannelReady(@NonNull a aVar, @Nullable Bundle bundle) throws RemoteException {
            aVar.onMessageChannelReady(bundle);
        }

        @Override // x.a.a.c
        public void onPostMessage(@NonNull a aVar, @NonNull String str, @Nullable Bundle bundle) throws RemoteException {
            aVar.onPostMessage(str, bundle);
        }
    }

    @Override // android.app.Service
    @NonNull
    public IBinder onBind(@Nullable Intent intent) {
        return this.mBinder;
    }
}
