package p007b.p008a.p009a.p014f.p015a;

import android.content.Context;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AppViewModel;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;

/* compiled from: AudioOutputSelectionDialogViewModel.kt */
/* renamed from: b.a.a.f.a.d, reason: use source file name */
/* loaded from: classes.dex */
public final class AudioOutputSelectionDialogViewModel2 extends AppViewModel<a> {

    /* renamed from: j */
    public final StoreAudioManagerV2 f360j;

    /* compiled from: AudioOutputSelectionDialogViewModel.kt */
    /* renamed from: b.a.a.f.a.d$a */
    public static abstract class a {

        /* compiled from: AudioOutputSelectionDialogViewModel.kt */
        /* renamed from: b.a.a.f.a.d$a$a, reason: collision with other inner class name */
        public static final class C13208a extends a {

            /* renamed from: a */
            public final DiscordAudioManager.DeviceTypes f361a;

            /* renamed from: b */
            public final boolean f362b;

            /* renamed from: c */
            public final String f363c;

            /* renamed from: d */
            public final boolean f364d;

            /* renamed from: e */
            public final boolean f365e;

            /* renamed from: f */
            public final boolean f366f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C13208a(DiscordAudioManager.DeviceTypes deviceTypes, boolean z2, String str, boolean z3, boolean z4, boolean z5) {
                super(null);
                Intrinsics3.checkNotNullParameter(deviceTypes, "selectedAudioOutput");
                this.f361a = deviceTypes;
                this.f362b = z2;
                this.f363c = str;
                this.f364d = z3;
                this.f365e = z4;
                this.f366f = z5;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C13208a)) {
                    return false;
                }
                C13208a c13208a = (C13208a) obj;
                return Intrinsics3.areEqual(this.f361a, c13208a.f361a) && this.f362b == c13208a.f362b && Intrinsics3.areEqual(this.f363c, c13208a.f363c) && this.f364d == c13208a.f364d && this.f365e == c13208a.f365e && this.f366f == c13208a.f366f;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                DiscordAudioManager.DeviceTypes deviceTypes = this.f361a;
                int iHashCode = (deviceTypes != null ? deviceTypes.hashCode() : 0) * 31;
                boolean z2 = this.f362b;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                int i2 = (iHashCode + i) * 31;
                String str = this.f363c;
                int iHashCode2 = (i2 + (str != null ? str.hashCode() : 0)) * 31;
                boolean z3 = this.f364d;
                int i3 = z3;
                if (z3 != 0) {
                    i3 = 1;
                }
                int i4 = (iHashCode2 + i3) * 31;
                boolean z4 = this.f365e;
                int i5 = z4;
                if (z4 != 0) {
                    i5 = 1;
                }
                int i6 = (i4 + i5) * 31;
                boolean z5 = this.f366f;
                return i6 + (z5 ? 1 : z5 ? 1 : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Loaded(selectedAudioOutput=");
                sbM833U.append(this.f361a);
                sbM833U.append(", showBluetoothItem=");
                sbM833U.append(this.f362b);
                sbM833U.append(", bluetoothDeviceName=");
                sbM833U.append(this.f363c);
                sbM833U.append(", showSpeakerItem=");
                sbM833U.append(this.f364d);
                sbM833U.append(", showWiredItem=");
                sbM833U.append(this.f365e);
                sbM833U.append(", showEarpieceItem=");
                return outline.m827O(sbM833U, this.f366f, ")");
            }
        }

        /* compiled from: AudioOutputSelectionDialogViewModel.kt */
        /* renamed from: b.a.a.f.a.d$a$b */
        public static final class b extends a {

            /* renamed from: a */
            public static final b f367a = new b();

            public b() {
                super(null);
            }
        }

        public a() {
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public AudioOutputSelectionDialogViewModel2() {
        this(null, null, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioOutputSelectionDialogViewModel2(StoreAudioManagerV2 storeAudioManagerV2, Observable observable, int i) {
        super(a.b.f367a);
        StoreAudioManagerV2 audioManagerV2 = (i & 1) != 0 ? StoreStream.INSTANCE.getAudioManagerV2() : null;
        Observable<StoreAudioManagerV2.State> observableObserveAudioManagerState = (i & 2) != 0 ? audioManagerV2.observeAudioManagerState() : null;
        Intrinsics3.checkNotNullParameter(audioManagerV2, "storeAudioManager");
        Intrinsics3.checkNotNullParameter(observableObserveAudioManagerState, "storeStateObservable");
        this.f360j = audioManagerV2;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableObserveAudioManagerState), this, null, 2, null), AudioOutputSelectionDialogViewModel2.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AudioOutputSelectionDialogViewModel(this), 62, (Object) null);
    }
}
