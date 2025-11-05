package b.a.a;

import b.a.d.d0;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetAccessibilityDetectionDialogViewModel.kt */
/* loaded from: classes.dex */
public final class p extends d0<a> {
    public final StoreUserSettings j;
    public final StoreNotices k;

    /* compiled from: WidgetAccessibilityDetectionDialogViewModel.kt */
    public static abstract class a {

        /* compiled from: WidgetAccessibilityDetectionDialogViewModel.kt */
        /* renamed from: b.a.a.p$a$a, reason: collision with other inner class name */
        public static final class C0027a extends a {
            public static final C0027a a = new C0027a();

            public C0027a() {
                super(null);
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public p() {
        this(null, null, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(StoreUserSettings storeUserSettings, StoreNotices storeNotices, int i) {
        super(a.C0027a.a);
        StoreUserSettings userSettings = (i & 1) != 0 ? StoreStream.INSTANCE.getUserSettings() : null;
        StoreNotices notices = (i & 2) != 0 ? StoreStream.INSTANCE.getNotices() : null;
        d0.z.d.m.checkNotNullParameter(userSettings, "storeUserSettings");
        d0.z.d.m.checkNotNullParameter(notices, "storeNotices");
        this.j = userSettings;
        this.k = notices;
    }

    @Override // b.a.d.d0, androidx.view.ViewModel
    public void onCleared() {
        StoreNotices storeNotices = this.k;
        Objects.requireNonNull(h.INSTANCE);
        StoreNotices.markSeen$default(storeNotices, "ALLOW_ACCESSIBILITY_DETECTION_DIALOG", 0L, 2, null);
    }
}
