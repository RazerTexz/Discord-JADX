package p007b.p008a.p009a;

import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetAccessibilityDetectionDialogViewModel.kt */
/* renamed from: b.a.a.p, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetAccessibilityDetectionDialogViewModel extends AppViewModel<a> {

    /* renamed from: j */
    public final StoreUserSettings f419j;

    /* renamed from: k */
    public final StoreNotices f420k;

    /* compiled from: WidgetAccessibilityDetectionDialogViewModel.kt */
    /* renamed from: b.a.a.p$a */
    public static abstract class a {

        /* compiled from: WidgetAccessibilityDetectionDialogViewModel.kt */
        /* renamed from: b.a.a.p$a$a, reason: collision with other inner class name */
        public static final class C13209a extends a {

            /* renamed from: a */
            public static final C13209a f421a = new C13209a();

            public C13209a() {
                super(null);
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public WidgetAccessibilityDetectionDialogViewModel() {
        this(null, null, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAccessibilityDetectionDialogViewModel(StoreUserSettings storeUserSettings, StoreNotices storeNotices, int i) {
        super(a.C13209a.f421a);
        StoreUserSettings userSettings = (i & 1) != 0 ? StoreStream.INSTANCE.getUserSettings() : null;
        StoreNotices notices = (i & 2) != 0 ? StoreStream.INSTANCE.getNotices() : null;
        Intrinsics3.checkNotNullParameter(userSettings, "storeUserSettings");
        Intrinsics3.checkNotNullParameter(notices, "storeNotices");
        this.f419j = userSettings;
        this.f420k = notices;
    }

    @Override // p007b.p008a.p018d.AppViewModel, androidx.view.ViewModel
    public void onCleared() {
        StoreNotices storeNotices = this.f420k;
        Objects.requireNonNull(WidgetAccessibilityDetectionDialog.INSTANCE);
        StoreNotices.markSeen$default(storeNotices, "ALLOW_ACCESSIBILITY_DETECTION_DIALOG", 0L, 2, null);
    }
}
