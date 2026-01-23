package p007b.p008a.p009a.p014f.p015a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.radiobutton.MaterialRadioButton;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p000.C12788k;
import p007b.p008a.p009a.p014f.p015a.AudioOutputSelectionDialogViewModel2;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p025i.AudioOutputSelectionDialogBinding;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* JADX INFO: renamed from: b.a.a.f.a.a, reason: use source file name */
/* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AudioOutputSelectionDialog extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f352j = {outline.m846d0(AudioOutputSelectionDialog.class, "binding", "getBinding()Lcom/discord/databinding/AudioOutputSelectionDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* JADX INFO: renamed from: b.a.a.f.a.a$a */
    /* JADX INFO: compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f356j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f357k;

        public a(int i, Object obj) {
            this.f356j = i;
            this.f357k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f356j;
            if (i == 0) {
                AudioOutputSelectionDialog.m130h((AudioOutputSelectionDialog) this.f357k).f360j.selectOutputDevice(DiscordAudioManager.DeviceTypes.BLUETOOTH_HEADSET);
                AudioOutputSelectionDialog.m129g((AudioOutputSelectionDialog) this.f357k);
                return;
            }
            if (i == 1) {
                AudioOutputSelectionDialog.m130h((AudioOutputSelectionDialog) this.f357k).f360j.selectOutputDevice(DiscordAudioManager.DeviceTypes.SPEAKERPHONE);
                AudioOutputSelectionDialog.m129g((AudioOutputSelectionDialog) this.f357k);
            } else if (i == 2) {
                AudioOutputSelectionDialog.m130h((AudioOutputSelectionDialog) this.f357k).f360j.selectOutputDevice(DiscordAudioManager.DeviceTypes.WIRED_HEADSET);
                AudioOutputSelectionDialog.m129g((AudioOutputSelectionDialog) this.f357k);
            } else {
                if (i != 3) {
                    throw null;
                }
                AudioOutputSelectionDialog.m130h((AudioOutputSelectionDialog) this.f357k).f360j.selectOutputDevice(DiscordAudioManager.DeviceTypes.EARPIECE);
                AudioOutputSelectionDialog.m129g((AudioOutputSelectionDialog) this.f357k);
            }
        }
    }

    /* JADX INFO: renamed from: b.a.a.f.a.a$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.f.a.a$c */
    /* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, AudioOutputSelectionDialogBinding> {

        /* JADX INFO: renamed from: j */
        public static final c f358j = new c();

        public c() {
            super(1, AudioOutputSelectionDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/AudioOutputSelectionDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public AudioOutputSelectionDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.audio_output_selection_bluetooth_radio;
            MaterialRadioButton materialRadioButton = (MaterialRadioButton) view2.findViewById(C5419R.id.audio_output_selection_bluetooth_radio);
            if (materialRadioButton != null) {
                i = C5419R.id.audio_output_selection_dialog_header;
                TextView textView = (TextView) view2.findViewById(C5419R.id.audio_output_selection_dialog_header);
                if (textView != null) {
                    i = C5419R.id.audio_output_selection_dialog_radio_group;
                    RadioGroup radioGroup = (RadioGroup) view2.findViewById(C5419R.id.audio_output_selection_dialog_radio_group);
                    if (radioGroup != null) {
                        i = C5419R.id.audio_output_selection_earpiece_radio;
                        MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) view2.findViewById(C5419R.id.audio_output_selection_earpiece_radio);
                        if (materialRadioButton2 != null) {
                            i = C5419R.id.audio_output_selection_speaker_radio;
                            MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) view2.findViewById(C5419R.id.audio_output_selection_speaker_radio);
                            if (materialRadioButton3 != null) {
                                i = C5419R.id.audio_output_selection_wired_radio;
                                MaterialRadioButton materialRadioButton4 = (MaterialRadioButton) view2.findViewById(C5419R.id.audio_output_selection_wired_radio);
                                if (materialRadioButton4 != null) {
                                    return new AudioOutputSelectionDialogBinding((LinearLayout) view2, materialRadioButton, textView, radioGroup, materialRadioButton2, materialRadioButton3, materialRadioButton4);
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.f.a.a$d */
    /* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
    public static final class d extends Lambda implements Function1<AudioOutputSelectionDialogViewModel2.a, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(AudioOutputSelectionDialogViewModel2.a aVar) {
            int id2;
            AudioOutputSelectionDialogViewModel2.a aVar2 = aVar;
            Intrinsics3.checkNotNullParameter(aVar2, "viewState");
            AudioOutputSelectionDialog audioOutputSelectionDialog = AudioOutputSelectionDialog.this;
            Objects.requireNonNull(audioOutputSelectionDialog);
            Intrinsics3.checkNotNullParameter(aVar2, "viewState");
            if (!(aVar2 instanceof AudioOutputSelectionDialogViewModel2.a.b) && (aVar2 instanceof AudioOutputSelectionDialogViewModel2.a.C13208a)) {
                AudioOutputSelectionDialogViewModel2.a.C13208a c13208a = (AudioOutputSelectionDialogViewModel2.a.C13208a) aVar2;
                int iOrdinal = c13208a.f361a.ordinal();
                if (iOrdinal == 2) {
                    MaterialRadioButton materialRadioButton = audioOutputSelectionDialog.m131i().f689e;
                    Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.audioOutputSelectionSpeakerRadio");
                    id2 = materialRadioButton.getId();
                } else if (iOrdinal == 3) {
                    MaterialRadioButton materialRadioButton2 = audioOutputSelectionDialog.m131i().f690f;
                    Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.audioOutputSelectionWiredRadio");
                    id2 = materialRadioButton2.getId();
                } else if (iOrdinal == 4) {
                    MaterialRadioButton materialRadioButton3 = audioOutputSelectionDialog.m131i().f688d;
                    Intrinsics3.checkNotNullExpressionValue(materialRadioButton3, "binding.audioOutputSelectionEarpieceRadio");
                    id2 = materialRadioButton3.getId();
                } else if (iOrdinal == 5) {
                    MaterialRadioButton materialRadioButton4 = audioOutputSelectionDialog.m131i().f686b;
                    Intrinsics3.checkNotNullExpressionValue(materialRadioButton4, "binding.audioOutputSelectionBluetoothRadio");
                    id2 = materialRadioButton4.getId();
                }
                audioOutputSelectionDialog.m131i().f687c.check(id2);
                MaterialRadioButton materialRadioButton5 = audioOutputSelectionDialog.m131i().f686b;
                Intrinsics3.checkNotNullExpressionValue(materialRadioButton5, "binding.audioOutputSelectionBluetoothRadio");
                materialRadioButton5.setVisibility(c13208a.f362b ? 0 : 8);
                MaterialRadioButton materialRadioButton6 = audioOutputSelectionDialog.m131i().f686b;
                Intrinsics3.checkNotNullExpressionValue(materialRadioButton6, "binding.audioOutputSelectionBluetoothRadio");
                String string = c13208a.f363c;
                if (string == null) {
                    string = audioOutputSelectionDialog.getString(C5419R.string.audio_devices_bluetooth);
                }
                materialRadioButton6.setText(string);
                MaterialRadioButton materialRadioButton7 = audioOutputSelectionDialog.m131i().f689e;
                Intrinsics3.checkNotNullExpressionValue(materialRadioButton7, "binding.audioOutputSelectionSpeakerRadio");
                materialRadioButton7.setVisibility(c13208a.f364d ? 0 : 8);
                MaterialRadioButton materialRadioButton8 = audioOutputSelectionDialog.m131i().f690f;
                Intrinsics3.checkNotNullExpressionValue(materialRadioButton8, "binding.audioOutputSelectionWiredRadio");
                materialRadioButton8.setVisibility(c13208a.f365e ? 0 : 8);
                MaterialRadioButton materialRadioButton9 = audioOutputSelectionDialog.m131i().f688d;
                Intrinsics3.checkNotNullExpressionValue(materialRadioButton9, "binding.audioOutputSelectionEarpieceRadio");
                materialRadioButton9.setVisibility(c13208a.f366f ? 0 : 8);
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.f.a.a$e */
    /* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
    public static final class e extends Lambda implements Function0<AudioOutputSelectionDialogViewModel2> {

        /* JADX INFO: renamed from: j */
        public static final e f359j = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AudioOutputSelectionDialogViewModel2 invoke() {
            return new AudioOutputSelectionDialogViewModel2(null, null, 3);
        }
    }

    public AudioOutputSelectionDialog() {
        super(C5419R.layout.audio_output_selection_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.f358j, null, 2, null);
        e eVar = e.f359j;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(AudioOutputSelectionDialogViewModel2.class), new C12788k(5, appViewModelDelegates3), new AppViewModelDelegates5(eVar));
    }

    /* JADX INFO: renamed from: g */
    public static final void m129g(AudioOutputSelectionDialog audioOutputSelectionDialog) {
        Objects.requireNonNull(audioOutputSelectionDialog);
        Observable<Long> observableM11068d0 = Observable.m11068d0(300L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableM11068d0, "Observable\n        .time…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM11068d0, audioOutputSelectionDialog, null, 2, null), AudioOutputSelectionDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AudioOutputSelectionDialog2(audioOutputSelectionDialog), 62, (Object) null);
    }

    /* JADX INFO: renamed from: h */
    public static final AudioOutputSelectionDialogViewModel2 m130h(AudioOutputSelectionDialog audioOutputSelectionDialog) {
        return (AudioOutputSelectionDialogViewModel2) audioOutputSelectionDialog.viewModel.getValue();
    }

    /* JADX INFO: renamed from: i */
    public final AudioOutputSelectionDialogBinding m131i() {
        return (AudioOutputSelectionDialogBinding) this.binding.getValue((Fragment) this, f352j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        int themedColor = ColorCompat.getThemedColor(view, C5419R.attr.colorInteractiveNormal);
        MaterialRadioButton materialRadioButton = m131i().f686b;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.audioOutputSelectionBluetoothRadio");
        ColorCompat2.setDrawableColor(materialRadioButton, themedColor);
        MaterialRadioButton materialRadioButton2 = m131i().f689e;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.audioOutputSelectionSpeakerRadio");
        ColorCompat2.setDrawableColor(materialRadioButton2, themedColor);
        MaterialRadioButton materialRadioButton3 = m131i().f690f;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton3, "binding.audioOutputSelectionWiredRadio");
        ColorCompat2.setDrawableColor(materialRadioButton3, themedColor);
        MaterialRadioButton materialRadioButton4 = m131i().f688d;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton4, "binding.audioOutputSelectionEarpieceRadio");
        ColorCompat2.setDrawableColor(materialRadioButton4, themedColor);
        m131i().f686b.setOnClickListener(new a(0, this));
        m131i().f689e.setOnClickListener(new a(1, this));
        m131i().f690f.setOnClickListener(new a(2, this));
        m131i().f688d.setOnClickListener(new a(3, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(((AudioOutputSelectionDialogViewModel2) this.viewModel.getValue()).observeViewState(), this, null, 2, null), AudioOutputSelectionDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new d(), 62, (Object) null);
    }
}
