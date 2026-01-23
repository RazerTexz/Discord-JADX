package p007b.p008a.p024h;

import android.content.ComponentName;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.List;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.h.d, reason: use source file name */
/* JADX INFO: compiled from: CustomTabsService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CustomTabsService2 extends CustomTabsServiceConnection {

    /* JADX INFO: renamed from: j */
    public final List<Uri> f653j;

    /* JADX WARN: Multi-variable type inference failed */
    public CustomTabsService2(List<? extends Uri> list) {
        Intrinsics3.checkNotNullParameter(list, "uris");
        this.f653j = list;
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        Intrinsics3.checkNotNullParameter(componentName, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(customTabsClient, "client");
        customTabsClient.warmup(0L);
        CustomTabsSession customTabsSessionNewSession = customTabsClient.newSession(new CustomTabsCallback());
        if (customTabsSessionNewSession != null) {
            Uri uri = (Uri) _Collections.first((List) this.f653j);
            List<Uri> listDrop = _Collections.drop(this.f653j, 1);
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listDrop, 10));
            for (Uri uri2 : listDrop) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(CustomTabsService.KEY_URL, uri2);
                arrayList.add(bundle);
            }
            customTabsSessionNewSession.mayLaunchUrl(uri, Bundle.EMPTY, arrayList);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
